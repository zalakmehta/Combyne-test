package com.farmlead.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketPlacePage2 {
	
	WebDriver  newwebDriver;
	
	public MarketPlacePage2(WebDriver driver)
	
	{
		this.newwebDriver = driver;
		PageFactory.initElements(newwebDriver, this);
	}
	String[] listedItemsComody= {"Barley - Feed","Barley - Malt","Beans - Fababeans","Canola","Corn - White","Corn - Yellow","Flax - Brown Flax","Flax - Golden","Mustard - Brown Mustard","Mustard - Oriental Mustard","Mustard - Yellow Mustard","Oats - Feed","Oats - Milling","Peas - Green","Peas - Maple","Peas - Yellow","Rye - Fall Rye","Soybeans","Triticale - Fall Triticale","Wheat - CPS Red Spring","Wheat - CPS White Spring Wheat","Wheat - Dark Northern Spring (DNS)","Wheat - Durum","Wheat - General Purpose (GP)","Wheat - Hard Red Spring (HRS)","Wheat - Hard Red Winter (HRW)","Wheat - Hard White Spring (HWS)","Wheat - Northern Spring Wheat (CNHR)","Wheat - Soft Red Winter (SRW)","Wheat - Soft White Spring (SWS)","Wheat - Soft White Winter (SWW)","Wheat - Special Purpose (SP)","Wheat - Spring Wheat","Wheat - Winter Wheat\n"
			+ ""};
	
	@FindBy(xpath="//*[text()='Grain & Oilseeds']")
	WebElement grainoilseeds;
	
	@FindBy(xpath="//*[@id='private-dashboard']/div[2]/descendant::div[contains(@class,'ListingCard_grain')]")
	List<WebElement> listingItems;
	
	
	
}
