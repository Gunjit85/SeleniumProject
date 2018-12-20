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
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test026_POM(driver);
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
    public void moveToTrashTest() throws InterruptedException{
		testPOM.clickProperties();
		Thread.sleep(3000);
		System.out.println("Properties Clicked");
		testPOM.allProperties();
		Thread.sleep(4000);
		System.out.println("Allproperties clicked");
		testPOM.clickcheckbox();
		Thread.sleep(2000);
		System.out.println("chkbox clicked");
		testPOM.clickBulkActions();
		Thread.sleep(2000);
		System.out.println("bulk list clicked");
		testPOM.clickApply();
		Thread.sleep(2000);
		String actualOutput = testPOM.message();
		Thread.sleep(2000);
		System.out.println("text printed");
		String expected = "1 post moved to the Trash. Undo";
		assertEquals(actualOutput, expected);
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}


