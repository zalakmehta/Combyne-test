package com.farmlead.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	
	WebDriver newDriver;

	public ProfilePage(WebDriver driver)
	{
		this.newDriver = driver;
		PageFactory.initElements(newDriver, this);
		
	}
	
	@FindBy(xpath="//*[@alt='user avatar']")
	WebElement avtar;
	
	@FindBy(xpath="//div[text()='Log Out']")
	WebElement logout;
	
	@FindBy(xpath="//button[@type='button']/div[text()='Log Out']")
	WebElement logoutButton;
	
	public Boolean isAvtarDisplayed()
	{
		boolean b=false;
		try {
			b=avtar.isDisplayed();
		}catch(Exception e)
		{
		}
		return b;
	}
	
	public void logout()
	{
		avtar.click();
		logout.click();
		logoutButton.click();
	}
}

