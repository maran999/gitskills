package com.greenkart.step;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Home {
	public WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		// TODO Auto-generated method stub
	    driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}
	@Test (dependsOnMethods = "launchBrowser")
	public void selectVegiee() {
		// TODO Auto-generated method stub
		 String[]  veg ={"Carrot","Corn","Pomegranate","Almonds"};
		 List<String> vegList = Arrays.asList(veg);
		 
		List<WebElement> vegiee = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int totVeg = vegiee.size();
		for(int i=0; i<totVeg; i++) {
			String vegName = vegiee.get(i).getText();
			
			String[] name = vegName.split("-");
			String formatedName = name[0].trim();
			System.out.println(formatedName);
			if (vegList.contains(formatedName)) {
				//****Doubt***//
				//driver.findElements(By.xpath("//button[text()='ADD TO CART'] ")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
			
			
		}
		
		
	}
	@Test(dependsOnMethods = "selectVegiee")
	public void confirmItems() {
		// TODO Auto-generated method stub
		WebElement kart = driver.findElement(By.xpath("//a[@class='cart-icon']"));
		kart.click();
		WebElement proceedToCheckout = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
        proceedToCheckout.click();
	}
}
