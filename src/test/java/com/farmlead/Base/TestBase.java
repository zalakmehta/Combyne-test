package com.farmlead.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.OS;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class TestBase {
	//public static Logger log = Logger.getLogger(TestBase.class.getName());
	public static Logger log = Logger.getLogger(TestBase.class);
	public static WebDriver driver;
	public static Properties prop;
	public static String browserName;
	
	public static WebDriver initializeDriver() throws IOException {
		//extent = ExtentManager.getReportObject();
		//extentTest = new ThreadLocal<ExtentTest>();
		FileInputStream fis = new FileInputStream("./src/test/resources/resources/Config.properties");
		prop = new Properties();
		log.info(browserName);
		log.info("/src/test/resources/resources/Config.properties");
		prop.load(fis);
		browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("ignore-certificate-errors");
          
			if(OS.isFamilyMac())
			{
				
				System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			}else
			{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			}
			driver = new ChromeDriver(opt);
			// driver.get("https://web03.lanternqa.jana.local/");

		} else if (browserName.equalsIgnoreCase("firefox")) {

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			firefoxOptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(firefoxOptions);

		} else if (browserName.equalsIgnoreCase("safari")) {

			SafariOptions safariOptions = new SafariOptions();
			//System.setProperty("webdriver.safari.driver", "./drivers/geckodriver.exe");
			//safariOptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(safariOptions);

		} else if (browserName.equals("IE")) {
			// execute in IE driver
		} else {
			Throwable th = new Throwable();
			th.initCause(null);
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;

	}

	public static WebDriver initializeDriver(String browserName) throws IOException {
		FileInputStream fis = new FileInputStream("./resources/Config.properties");
		prop = new Properties();
		prop.load(fis);
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("ignore-certificate-errors");
			//opt.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver(opt);
			// driver.get("https://web03.lanternqa.jana.local/");

		} else if (browserName.equalsIgnoreCase("firefox")) {

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			firefoxOptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(firefoxOptions);

		} else if (browserName.equalsIgnoreCase("safari")) {

			SafariOptions safariOptions = new SafariOptions();
			//System.setProperty("webdriver.safari.driver", "./drivers/geckodriver.exe");
			//safariOptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(safariOptions);

		}else if (browserName.equals("IE")) {
			// execute in IE driver
		} else {
			Throwable th = new Throwable();
			th.initCause(null);
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;

	}


}
