package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.LoginPOM;
import com.training.pom.Test026_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_026_Test {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM loginPOM;
	private Test026_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test026_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		testPOM.mouseHoverProperties();
		Thread.sleep(3000);
		testPOM.allProperties();
		Thread.sleep(4000);
		testPOM.clickcheckbox();
		Thread.sleep(2000);
		testPOM.uncheck();
		Thread.sleep(2000);
		
	}
	
	
}

