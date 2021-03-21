package com.farmlead.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver newDriver;

	public LoginPage(WebDriver driver)
	{
		this.newDriver = driver;
		PageFactory.initElements(newDriver, this);
		
	}
	
	@FindBy(xpath="//*[@class='menu'][text()='Log In']")
	WebElement login;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	public void login(String user, String pass)
	{
		login.click();
		waitForElement(email);
		email.clear();
		email.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		loginButton.click();
	}
	
	void waitForElement(WebElement e)
	{
		WebDriverWait wait=new WebDriverWait(newDriver, 20);
		wait.until(ExpectedConditions.visibilityOf(e));
				
	}
	

}
