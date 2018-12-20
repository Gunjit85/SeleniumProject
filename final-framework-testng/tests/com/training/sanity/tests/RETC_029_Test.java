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
import com.training.pom.Test029_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_029_Test {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM loginPOM;
	private Test029_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test029_POM(driver);
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
    public void addNewRegionTest() throws InterruptedException{
		testPOM.clickProperties();
		Thread.sleep(3000);
		System.out.println("Properties clicked");
		testPOM.clickRegions();
		Thread.sleep(3000);
		System.out.println("Regions clicked");
		testPOM.enterName();
		Thread.sleep(2000);
		System.out.println("Name entered");
		testPOM.enterSlug();
		Thread.sleep(2000);
		System.out.println("Slug entered");
		testPOM.clickParentRegion();
		Thread.sleep(2000);
		System.out.println("Parent resion listbox clicked");
		testPOM.enterDescription();
		Thread.sleep(2000);
		System.out.println("Description entered");
		testPOM.addRegion();
		Thread.sleep(2000);
		System.out.println("submit clicked");
		driver.navigate().refresh();
		testPOM.enterText();
		Thread.sleep(2000);
		System.out.println("search text entered");
		testPOM.searchRegions();
		Thread.sleep(2000);
		System.out.println("search regions button clicked");
		
		String actOutput = testPOM.existingRegions();
		
		String expOutput = "New Launches";
		assertEquals(actOutput, expOutput);
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}


