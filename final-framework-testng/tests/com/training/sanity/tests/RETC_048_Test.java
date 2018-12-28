/* Test case RETC036 - Customer logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-sunil; password - sunil@123
 * Click on Villas tab, click on search button, Enter details of apartment in search box - Nullam hendrerit apartment,
 * Click on Nullam hendrerit apartment link, Click on Drop Us a Line Link, Enter valid details in Your Name textbox(selenium), 
 * Enter valid details in Your Email Address textbox(selenium@gmail.com) , Enter valid details in subject textbox(apartment), 
 * Enter valid details in message textbox(looking for apartment), Click on Send button, 
 * Thanks you for your message. It has been sent message should get displayed*/

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
    public void addedPostDisplayedTest() throws InterruptedException{
		//String wait = properties.getProperty("implicitWait");
		//Admin clicks on Properties link
		testPOM.clickProperties();
		Thread.sleep(3000);
		System.out.println("Properties Clicked");
		//Admin clicks on 'Add New' button
		testPOM.clickAddNew();
		Thread.sleep(4000);
		System.out.println("Add New button is clicked and Add Property page is displayed");
		//Admin clicks on Add New Region link in Regions section
		testPOM.clickAddNewRegion();
		Thread.sleep(4000);
		System.out.println("Add New Region is clicked");
		//Admin enters text in textbox under Add New Region button
		testPOM.enterText();
		Thread.sleep(4000);
		System.out.println("Text is added to textbox");
		//Admin selects Parent Region as West Bangalore
		testPOM.selectParentRegion();
		Thread.sleep(2000);
		System.out.println("West Bangalore is selected");
		//Admin clicks on 'Add new region' button
		testPOM.clickAddNewRegionButton();
		Thread.sleep(2000);
		System.out.println("Region is added");
		//Admin refreshes the browser
		testPOM.Refresh();
		Thread.sleep(2000);
		//driver.switchTo().defaultContent();
		//driver.manage().window().maximize();
		
		System.out.println("Browser is refreshed");
		//Admin enters text in Title textbox
		testPOM.enterTitle();
		Thread.sleep(2000);
		System.out.println("Title is added");
		//Admin enters text in Body textbox
		testPOM.enterBodyText();
		Thread.sleep(2000);
		System.out.println("Body text is added");
		//Admin clicks on checkbox beside the created region
		testPOM.clickCheckbox();
		Thread.sleep(2000);
		System.out.println("Checkbox beside created region is clicked");
		//Admin clicks on publish button
		testPOM.clickPublish();
		Thread.sleep(2000);
		System.out.println("Publish is clicked");
								
		//get the actual output message from the text displayed in the title of added post recently
		String actualOutput = testPOM.confirmationMessage();
		Thread.sleep(3000);
		
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

