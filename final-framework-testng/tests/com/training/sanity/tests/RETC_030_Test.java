package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.LoginPOM;
import com.training.pom.Test027_POM;
import com.training.pom.Test028_POM;
import com.training.pom.Test030_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_030_Test {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM loginPOM;
	private Test030_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test030_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void adminLoginTest() throws InterruptedException {
		loginPOM.clickLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		}
	
	@Test(priority=2)
    public void deleteSelectedRegionTest() throws InterruptedException{
		testPOM.clickProperties();
		Thread.sleep(3000);
		System.out.println("Properties clicked");
		testPOM.clickRegions();
		Thread.sleep(3000);
		System.out.println("Regions clicked");
		testPOM.enterText();
		Thread.sleep(2000);
		System.out.println("User enters text in the search box");
		testPOM.searchRegions();
		Thread.sleep(2000);
		System.out.println("User clicked on search regions searchbox");
		testPOM.checkCheckbox();
		Thread.sleep(2000);
		System.out.println("checkbox selected");
		testPOM.deleteRegion();
		Thread.sleep(2000);
		System.out.println("Region selected");
		testPOM.clickApply();
		Thread.sleep(2000);
		System.out.println("Selected Region is deleted");
		
		String actOutput = testPOM.existingRegions();
		
		String expOutput = "Items deleted.";
		assertEquals(actOutput, expOutput);
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}


