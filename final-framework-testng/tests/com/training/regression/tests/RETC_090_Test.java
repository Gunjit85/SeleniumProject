/* Test case RETC090 - To verify whether application allows admin to add multiple property with all details*/

package com.training.regression.tests;

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

import com.training.dataproviders.DataProvidersTC089;
import com.training.dataproviders.DataProvidersTC090;
import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.CustomerPOM;
import com.training.pom.LoginPOM;
import com.training.pom.Test026_POM;
import com.training.pom.Test036_POM;
import com.training.pom.Test042_POM;
import com.training.pom.Test048_POM;
import com.training.pom.Test060_POM;
import com.training.pom.Test090_propsAllDetails_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_090_Test {
	private WebDriver driver;
	private String adminUrl;
	private AdminPOM loginPOM;
	private Test090_propsAllDetails_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver);
		testPOM = new Test090_propsAllDetails_POM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		Thread.sleep(2000);
	}

	@Test(priority=1)
	public void adminLoginTest() {
		loginPOM.clickLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		//screenShot.captureScreenShot(userName);
	}
	
	@Test(priority=2, dataProvider = "excel-inputs", dataProviderClass = DataProvidersTC090.class)
	public void addMultiplePropWithAllDetailsTest(String title, String textbox, String price, String ppsqft, String status, String location, String possession, String address, String gmaps, String lat, String lo, String storage) throws InterruptedException, AWTException {
		String wait = properties.getProperty("implicitWait");
		// Click on Properties link
		testPOM.clickProperties();
		// Click on 'Add New' button
		testPOM.clickAddNew();
		// Enter text in Title here textbox
		testPOM.enterTitle(title);
		// Enter text in body textbox
		testPOM.enterBodyText(textbox);
		// Enter Price in 'Price here' textbox
		testPOM.enterPrice(price);
		// Enter Price per sq metre/ft
		testPOM.enterPricePerSqft(ppsqft);
		// Click on Main Details tab
		testPOM.clickMainDetails();
		// Enter text in status textbox
		testPOM.enterStatus(status);
		// Enter location
		testPOM.enterLocation(location);
		// Enter Possession
		testPOM.enterPossessionDetails(possession);
		// Click on Location tab
		testPOM.clickLocationTab();
		// Enter text in Address textbox
		testPOM.enterAddress(address);
		// Enter text in google maps address textbox
		testPOM.enterGMapsAddress(gmaps);
		// Enter Latitude
		testPOM.enterLatitude(lat);
		// Enter Longitude
		testPOM.enterLongitude(lo);
		// Click on Details tab
		testPOM.clickDetailsTab();
		// Enter text in Storage room textbox
		testPOM.enterStorageRoom(storage);
		
		Thread.sleep(3000);
		// Click on Central Bangalore under Regions Checkbox
		testPOM.clickCheckbox();
		System.out.println("central bangalore checkbox is clicked");
		
		// Click on checkbox beside Feature of Features section
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);
		testPOM.clickFeaturesCheckbox();
		System.out.println("checkbox beside  Feature is clicked");
		
		// Click on checkbox beside Region of Regions section
		//Thread.sleep(2000);
		//testPOM.clickRegionsCheckbox();
		//System.out.println("checkbox beside  Region is clicked");
		
		testPOM.WaitPublish();//explicit wait for publish button to be clickable
		Thread.sleep(5000);
		testPOM.clickPublish();//click publish button
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
