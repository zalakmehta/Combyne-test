package com.farmlead.testcases;

import org.testng.annotations.Test;

import com.farmlead.Base.TestBase;
import com.farmlead.pages.LoginPage;
import com.farmlead.pages.ProfilePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginLogoutTest {
	private WebDriver dr;
	private ProfilePage profile;
	private LoginPage loginpage;

  @Parameters({"user","pass"})
  @Test
  public void VerifyLogin(String user, String pass) 
  {
	  loginpage.login(user, pass);
	  Assert.assertTrue(profile.isAvtarDisplayed());
	  profile.logout();
  
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException 
  {
	  dr=TestBase.initializeDriver();
	  loginpage=new LoginPage(dr);
	  profile=new ProfilePage(dr);
	  
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() 
  {
	  dr.quit();
  }

}
