package com.farmlead.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPlacePage {
	
	WebDriver newWebDriver;
	
	public MarketPlacePage(WebDriver driver)
	
	{
		this.newWebDriver = driver;
		PageFactory.initElements(newWebDriver, this);
		
	}
	
	String[] listedItemsComody= {"Alfalfa","Alfalfa/Grass","Alfalfa/Mixed Grass","Alfalfa/Timothy","Barley"};
	String[] listedItemsft= {"Grass Hay","Greenfeed","Haylage","Legume Hay","Mixed Hay","Silage", "Straw"};
	
	
	
	@FindBy(xpath="//*[text()='Forage & Straw']")
	private WebElement foragestraw;
	
	@FindBy(xpath="//*[text()='All']")
	private WebElement all;
	
	//@FindBy(xpath="//div[contains(@class,'ListingCard_grain')]")
	@FindBy(xpath="//*[@id='private-dashboard']/div[2]/descendant::div[contains(@class,'ListingCard_grain')]")
	private List<WebElement> listingItems;
	
	public void clickOnforagestraw() throws InterruptedException
	{
		//foragestraw.click();
		//JavascriptExecutor j=(JavascriptExecutor) newwebDriver
		//((JavascriptExecutor) newwebDriver).executeScript("arguments[0].click();",foragestraw);
		new Actions(newWebDriver).click(all).perform();
		Thread.sleep(3000);
		new Actions(newWebDriver).click(foragestraw).perform();
	}
	
	public boolean isListMatchingComodity()
	{
		boolean b=false;
		boolean[] listOfValue=new boolean[listingItems.size()-1];
		int count=0;
		try {
			
			for(WebElement e:listingItems)
			{
				String s=e.getText().split(",")[1].trim();
				System.out.println("Read:"+s);
				for(String str:listedItemsComody)
				{
					
					if(str.contains(s))
					{
						b=true;
						System.out.println("True:"+str+":"+s);
						break;
					}
					else 
					{
						b=false;
						System.out.println("False:"+str+":"+s);
					}
					//listOfValue[count]=b;
				}
				listOfValue[count]=b;
				count++;
				
			}
			
		}catch(Exception e)
		{
			
		}
		for(boolean c:listOfValue)
		{
			System.out.println(c);
			if(c==false)
			{
				b=false;
			}
		}
		return b;
	}
	public boolean isListMatchingForage()
	{
		boolean b=false;
		boolean[] listOfValue=new boolean[listingItems.size()-1];
		int count=0;
		try {
			
			for(WebElement e:listingItems)
			{
				String s=e.getText().split(",")[0].trim();
				System.out.println("Read:"+s);
				for(String str:listedItemsft)
				{
					
					if(str.contains(s))
					{
						b=true;
						System.out.println("True:"+str+":"+s);
						break;
					}
					else 
					{
						b=false;
						System.out.println("False:"+str+":"+s);
					}
					
				}
				listOfValue[count]=b;
				count++;
				
			}
			
		}catch(Exception e)
		{
			
		}
		for(boolean c:listOfValue)
		{
			System.out.println(c);
			if(c==false)
			{
				b=false;
			}
		}
		return b;
	}

}
