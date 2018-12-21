/* Test case RETC030 - User logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Click on Properties link, then click on Regions link, user searches "New Launches" in searchbox, click on search regions button, 
 * Click on the checkbox of the property to be deleted, clicks on BulkActions listbox and selects Delete, click on Apply button,
 * "Region deleted." Message should get displayed and selected region should be removed from the region list */

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
		//User logins as Admin
		loginPOM.clickLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		}
	
	@Test(priority=2)
    public void deleteSelectedRegionTest() throws InterruptedException{
		//User clicks the Properties link
		testPOM.clickProperties();
		Thread.sleep(3000);
		System.out.println("Properties clicked");
		//User clicks on Regions link
		testPOM.clickRegions();
		Thread.sleep(3000);
		System.out.println("Regions clicked");
		//User enters text in the search box
		testPOM.enterText();
		Thread.sleep(2000);
		System.out.println("User enters text in the search box");
		//User clicks on search regions button
		testPOM.searchRegions();
		Thread.sleep(2000);
		System.out.println("User clicked on search regions searchbox");
		//User selects the checkbox of the region to be deleted
		testPOM.checkCheckbox();
		Thread.sleep(2000);
		System.out.println("checkbox selected");
		//User selects Delete option in BulkActions listbox
		testPOM.deleteRegion();
		Thread.sleep(2000);
		System.out.println("Region selected");
		//User clicks on th eApply button
		testPOM.clickApply();
		Thread.sleep(2000);
		System.out.println("Selected Region is deleted");
		//User takes actual result from existingRegions method
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


