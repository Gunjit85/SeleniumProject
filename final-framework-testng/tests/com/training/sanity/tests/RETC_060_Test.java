/* Test case RETC060 - Customer logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Click on Properties tab, Click on Add New link, Enter valid credentials in Enter Title Here textbox, Enter valid credentials in textbox,
 * Enter valid credentials in Price Here textbox, Enter valid credentials in Price per sq. meter/sq. ft textbox, Click on Main Details tab,
 * Enter valid credentials in Status textbox, Enter valid credentials in Location textbox, Enter valid credentials in Possession textbox,
 * Click on Location tab, Enter valid credentials in Address textbox, Enter valid credentials in Google Maps Address textbox,
 * Enter valid credentials in Latitude textbox, Enter valid credentials in Longitude textbox, Click on Details tab, 
 * Enter valid credentials in Storage Room textbox, Click on Central Bangalore Checkbox, Click on checkbox beside  Feature of Features section,
 * Click on checkbox beside  Region of Regions section, Click on Publish button, Post published. View post message should get displayed*/

package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

	@Test(priority = 1)
	public void adminLoginTest() throws InterruptedException {
		// User logins as an Admin
		loginPOM.clickLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
	}

	@Test(priority = 2)
	public void addNewPropWithAllDetailsTest() throws InterruptedException, AWTException {
		String wait = properties.getProperty("implicitWait");
		// Click on Properties link
		testPOM.clickProperties();
		System.out.println("Properties Clicked");
		// Click on 'Add New' button
		testPOM.clickAddNew();
		System.out.println("Add New button is clicked and Add Property page is displayed");
		// Enter text in Title here textbox
		testPOM.enterTitle("new launch456");
		System.out.println("Title entered");
		// Enter text in body textbox
		testPOM.enterBodyText();
		System.out.println("Text is added to body textbox");
		// Enter Price in 'Price here' textbox
		double p = 80000.00;
		testPOM.enterPrice(p);
		System.out.println("Price is entered");
		// Enter Price per sq metre/ft
		double p1 = 350.00;
		testPOM.enterPricePerSqft(p1);
		System.out.println("Price/sqft is added");
		// Click on Main Details tab
		testPOM.clickMainDetails();
		System.out.println("Main details tab is clicked");
		// Enter text in status textbox
		testPOM.enterStatus("New");
		System.out.println("Status is added");
		// Enter location
		testPOM.enterLocation("Electronic city");
		System.out.println("Location is added");
		// Enter Possession
		testPOM.enterPossessionDetails("immediate");
		System.out.println("Possession details are added");
		// Click on Location tab
		testPOM.clickLocationTab();
		System.out.println("Location tab is clicked");
		// Enter text in Address textbox
		testPOM.enterAddress("yeshwanthapur");
		System.out.println("Address added");
		// Enter text in google maps address textbox
		testPOM.enterGMapsAddress("yeshwanthapur");
		System.out.println("Google maps address is added");
		// Enter Latitude
		int lat = 120;
		testPOM.enterLatitude(lat);
		System.out.println("Latitude added");
		// Enter Longitude
		int lo = 56;
		testPOM.enterLongitude(lo);
		System.out.println("Longitude added");
		// Click on Details tab
		testPOM.clickDetailsTab();
		System.out.println("Details tab is clicked");
		// Enter text in Storage room textbox
		int st = 2;
		testPOM.enterStorageRoom(st);
		System.out.println("Storage room entered");
		// Click on Central Bangalore Checkbox
		testPOM.clickCheckbox();
		System.out.println("central bangalore checkbox is clicked");
		// Click on checkbox beside Feature of Features section
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		testPOM.clickFeaturesCheckbox();
		Thread.sleep(2000);
		System.out.println("checkbox beside  Feature is clicked");
		// Click on checkbox beside Region of Regions section
		testPOM.clickRegionsCheckbox();
		Thread.sleep(2000);
		System.out.println("checkbox beside  Region is clicked");
		// Click on Publish button
		testPOM.clickPublish();
		Thread.sleep(2000);
		System.out.println("Publish button is clicked");

		// get the actual output message from the text displayed after
		// publishing property
		String actualOutput = testPOM.confirmationMessage();

		String expected = "Post published. View post";
		// assert expected and actual
		assertEquals(actualOutput, expected);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
