/* Test case RETC036 - Customer logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-sunil; password - sunil@123
 * Click on Villas tab, click on search button, Enter details of apartment in search box - Nullam hendrerit apartment,
 * Click on Nullam hendrerit apartment link, Click on Drop Us a Line Link, Enter valid details in Your Name textbox(selenium), 
 * Enter valid details in Your Email Address textbox(selenium@gmail.com) , Enter valid details in subject textbox(apartment), 
 * Enter valid details in message textbox(looking for apartment), Click on Send button, 
 * Thanks you for your message. It has been sent message should get displayed*/

package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
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
import com.training.pom.CustomerPOM;
import com.training.pom.LoginPOM;
import com.training.pom.Test026_POM;
import com.training.pom.Test036_POM;
import com.training.pom.Test042_POM;
import com.training.pom.Test048_POM;
import com.training.pom.Test060_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_060_Test {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM loginPOM;
	private Test060_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test060_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void adminLoginTest() throws InterruptedException {
		//User logins as an Admin
		loginPOM.clickLogin(); 
		loginPOM.sendUserName("admin"); 
		loginPOM.sendPassword("admin@123"); 
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		}
	
	@Test(priority=2)
    public void addNewPropWithAllDetailsTest() throws InterruptedException, AWTException{
		String wait = properties.getProperty("implicitWait");
		//Click on Properties link
		testPOM.clickProperties();
		//Thread.sleep(3000);
		System.out.println("Properties Clicked");
		//Click on 'Add New' button
		testPOM.clickAddNew();
		//Thread.sleep(4000);
		System.out.println("Add New button is clicked and Add Property page is displayed");
		//Enter text in Title here textbox
		testPOM.enterTitle();
		//Thread.sleep(4000);
		System.out.println("Title entered");
		//Enter text in body textbox
		testPOM.enterBodyText();
		//Thread.sleep(4000);
		System.out.println("Text is added to body textbox");
		//Enter Price in 'Price here' textbox
		testPOM.enterPrice();
		//Thread.sleep(2000);
		System.out.println("Price is entered");
		//Enter Price per sq metre/ft
		testPOM.enterPricePerSqft();
		//Thread.sleep(2000);
		System.out.println("Price/sqft is added");
		//Click on Main Details tab
		testPOM.clickMainDetails();
		//Thread.sleep(2000);
		//driver.switchTo().defaultContent();
		//driver.manage().window().maximize();
		
		System.out.println("Main details tab is clicked");
		//Enter text in status textbox
		testPOM.enterStatus();
		//Thread.sleep(2000);
		System.out.println("Status is added");
		//Enter location
		testPOM.enterLocation();
		//Thread.sleep(2000);
		System.out.println("Location is added");
		//Enter Possession
		testPOM.enterPossessionDetails();
		//Thread.sleep(2000);
		System.out.println("Possession details are added");
		//Click on Location tab
		testPOM.clickLocationTab();
		//Thread.sleep(2000);
		System.out.println("Location tab is clicked");
		//Enter text in Address textbox
		testPOM.enterAddress();
		//Thread.sleep(2000);
		System.out.println("Address added");
		//Enter text in google maps address textbox
		testPOM.enterGMapsAddress();
		//Thread.sleep(2000);
		System.out.println("Google maps address is added");
		//Enter Latitude
		testPOM.enterLatitude();
		//Thread.sleep(2000);
		System.out.println("Latitude added");
		//Enter Longitude
		testPOM.enterLongitude();
		//Thread.sleep(2000);
		System.out.println("Longitude added");
		//Click on Details tab
		testPOM.clickDetailsTab();
		//Thread.sleep(2000);
		System.out.println("Details tab is clicked");
		//Enter text in Storage room textbox
		testPOM.enterStorageRoom();
		//Thread.sleep(2000);
		System.out.println("Storage room entered");
		//Click on Central Bangalore Checkbox
		testPOM.clickCheckbox();
		//Thread.sleep(2000);
		System.out.println("central bangalore checkbox is clicked");
		// Click on checkbox beside  Feature of Features section
		testPOM.clickFeaturesCheckbox();
		Thread.sleep(2000);
		System.out.println("checkbox beside  Feature is clicked");
		//Click on checkbox beside  Region of Regions section
		testPOM.clickRegionsCheckbox();
		Thread.sleep(2000);
		System.out.println("checkbox beside  Region is clicked");
		//Click on Publish button
		testPOM.clickPublish();
		Thread.sleep(2000);
		System.out.println("Publish button is clicked");
										
		//get the actual output message from the text displayed after publishing property
		String actualOutput = testPOM.confirmationMessage();
		//Thread.sleep(3000);
		
		String expected = "Post published. View post";	
		//assert expected and actual
		assertEquals(actualOutput, expected);	
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}


