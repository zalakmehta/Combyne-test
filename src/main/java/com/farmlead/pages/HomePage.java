package com.farmlead.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver newDriver;
	
	public HomePage(WebDriver driver)
	
	{
		this.newDriver = driver;
		PageFactory.initElements(newDriver, this);
		
	}
	
	@FindBy(xpath="//*[@viewBox='0 0 43 47']")
	WebElement CombyneviewBox;

	@FindBy(xpath="//div[text()='You currently don’t have Target Offers available']")
	WebElement TargetOffersavailabletext;
	
	@FindBy(xpath="//div[text()='Invite Contacts']")
	WebElement InviteContacts;
	
	@FindBy(xpath="//button[@type='button']/div[text()='Invite Contacts']")
	WebElement InviteContactsButton;
	
	@FindBy(xpath="//div[text()='Learn more']")
	WebElement Learnmore;
	
	@FindBy(xpath="//a[text()='Learn more']")
	WebElement Learnmorelink;
	
	@FindBy(xpath="//div[text()='I’m looking for Grain and Oilseeds']")
	WebElement GrainandOilseeds1;
	
	@FindBy(xpath="//div[contains(text(),'listings available')]")
	List<WebElement> listing;
	
	@FindBy(xpath="//div[text()='I’m looking for Forage & Straw']")
	WebElement ForageandStraw;

	@FindBy(xpath="//div[contains(text(),'listings available']")
	List<WebElement> listings1;

	@FindBy(xpath="//*[@id='Path_3660']")
	WebElement pathbutton;
	
	@FindBy(xpath="//div[text()='Browse Marketplace']")
	WebElement buttonBrowseMarketPlace;
	
	public Boolean isCombyneviewBoxDisplayed()
	{
		boolean a=false;
		try {
			   a= CombyneviewBox.isDisplayed();
		    }
		catch(Exception e)
		{
			
		}
		return a;
	}
	
	public void clickOnBrowseMarketPlaceButton()
	{
		buttonBrowseMarketPlace.click();
	}
	
	public String getListingCount(int i)
	{
		String str=null;
		if(i<2 && i>=0)
		{
			str=listing.get(i).getText().trim();
		}
		
		return str;
		
	}
	
	
}

