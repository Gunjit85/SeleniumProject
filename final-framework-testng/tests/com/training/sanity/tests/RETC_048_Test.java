/* Test case RETC048 - Admin logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Click on Properties tab, Click on Add New button, Click on Add new Region link in Regions section, Enter valid details in Textbox - Electronic City,
 * Select valid details in Parent Region list box - West Bangalore, Click on Add New Region button, Click on Refresh button from keyboard,
 * Enter valid credentials in Enter Title Here textbox - prestige, Enter valid credentials in textbox - home town, Click on checkbox beside created region,
 * Click on Publish button, Post published. View post message should get displayed*/

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_048_Test {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM loginPOM;
	private Test048_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test048_POM(driver);
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
    public void addedPostDisplayedTest() throws InterruptedException, AWTException{
		String wait = properties.getProperty("implicitWait");
		//Admin clicks on Properties link
		testPOM.clickProperties();
		System.out.println("Properties Clicked");
		//Admin clicks on 'Add New' button
		testPOM.clickAddNew();
		System.out.println("Add New button is clicked and Add Property page is displayed");
		//Admin clicks on Add New Region link in Regions section
		testPOM.clickAddNewRegion();
		System.out.println("Add New Region is clicked");
		//Admin enters text in textbox under Add New Region button
		testPOM.enterText("Electronic City77");
		System.out.println("Text is added to textbox");
		//Admin selects Parent Region as West Bangalore
		testPOM.selectParentRegion();
		System.out.println("West Bangalore is selected");
		//Admin clicks on 'Add new region' button
		testPOM.clickAddNewRegionButton();
		System.out.println("New Region is added");
		//Admin refreshes the browser
		testPOM.Refresh();
		System.out.println("Browser is refreshed");
		//Admin enters text in Title textbox
		testPOM.enterTitle("prestige77");
		System.out.println("Title is added");
		//Admin enters text in Body textbox
		testPOM.enterBodyText();
		System.out.println("Body text is added");
		//Admin clicks on checkbox beside the created region
		testPOM.clickCheckbox();
		System.out.println("Checkbox beside created region is clicked");
		//Admin clicks on publish button
		testPOM.clickPublish();
		System.out.println("Publish is clicked");
								
		//get the actual output message from the text displayed in the title of added post recently
		String actualOutput = testPOM.confirmationMessage();
		
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


