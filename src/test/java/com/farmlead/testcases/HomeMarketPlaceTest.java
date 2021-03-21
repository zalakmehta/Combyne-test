package com.farmlead.testcases;

import org.testng.annotations.Test;

import com.farmlead.Base.TestBase;
import com.farmlead.pages.HomePage;
import com.farmlead.pages.LoginPage;
import com.farmlead.pages.MarketPlacePage;
import com.farmlead.pages.ProfilePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class HomeMarketPlaceTest {
	public static Logger log = Logger.getLogger(HomeMarketPlaceTest.class);
	private WebDriver dr;
	private HomePage homepage;
	private LoginPage loginpage;
	private MarketPlacePage marketplace;
  @Parameters({"user","pass"})	
  @Test
  public void C191_BrowseMarketplaceForageAndStrawComodity(String user, String pass) throws InterruptedException {
	  log.info("C191_BrowseMarketplaceForageAndStrawComodity");
	  loginpage.login(user, pass);
	  log.info(user);
	  homepage.clickOnBrowseMarketPlaceButton();
	  //String s=homepage.getListingCount(0);
	  marketplace.clickOnforagestraw();
	  Thread.sleep(4000);
	  Assert.assertTrue(marketplace.isListMatchingComodity());
	 // Assert.assertTrue(marketplace.isListMatchingForage());
	  
  }
  
  @Parameters({"user","pass"})	
  @Test
  public void C191_BrowseMarketplaceForageAndStrawForage(String user, String pass) throws InterruptedException {
	  loginpage.login(user, pass);
	  homepage.clickOnBrowseMarketPlaceButton();
	  //String s=homepage.getListingCount(0);
	  marketplace.clickOnforagestraw();
	  Thread.sleep(4000);
	  //Assert.assertTrue(marketplace.isListMatchingComodity());
	  Assert.assertTrue(marketplace.isListMatchingForage());
	  
  }
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException {
	  dr=TestBase.initializeDriver();
	  loginpage=new LoginPage(dr);
	  homepage=new HomePage(dr);
	  marketplace=new MarketPlacePage(dr);
  }
  
  

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  dr.quit();
  }

}
