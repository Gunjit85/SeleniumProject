/* Test case RETC086 - To Verify whether application allows admin to Add New Region in the application & 
 * added details should get displayed in database */

package com.training.regression.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.DataProvidersDB_TC086;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.LoginPOM;
import com.training.pom.Test027_POM;
import com.training.pom.Test028_POM;
import com.training.pom.Test029_POM;
import com.training.pom.Test086_DB_NewRegion_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_086_DB_Test {
	private WebDriver driver;
	private String adminUrl;
	private AdminPOM loginPOM;
	private Test086_DB_NewRegion_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver);
		testPOM = new Test086_DB_NewRegion_POM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(adminUrl);
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void adminLoginTest() throws InterruptedException {
		// User logins as an admin
		loginPOM.clickLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Thread.sleep(1000);
		screenShot.captureScreenShot("First");
	}

	@Test(priority = 2, dataProvider = "db-inputs", dataProviderClass = DataProvidersDB_TC086.class)
	public void addNewRegionDBTest(String regionName, String slugName, String desc) throws InterruptedException {
		String wait = properties.getProperty("implicitWait");
		// User click on Properties link
		testPOM.clickProperties();
		// User click on Regions link
		testPOM.clickRegions();
		// User enters text in Name textbox
		testPOM.enterName("New Launches123");

		// To Verify the RegionName entered in application is same as in DB
		String ExpRegionName = testPOM.getRegionName();
		String ActRegionName = regionName;
		Assert.assertEquals(ActRegionName, ExpRegionName);
		System.out.println("The RegionName is " + ActRegionName + " " + ExpRegionName);

		// User enters text in Slug textbox
		testPOM.enterSlug("launch");

		// To Verify the SlugName entered in application is same as in DB
		String ExpSlugName = testPOM.getSlugName();
		String ActSlugName = slugName;
		Assert.assertEquals(ActSlugName, ExpSlugName);
		System.out.println("The Slug is " + ActSlugName + " " + ExpSlugName);

		// User click on Parent Region dropdown and select 'None'
		testPOM.clickParentRegion();
		// User enters text in Description textbox
		testPOM.enterDescription("New Launches of vilas, apartments, flats");

		// To Verify the Description entered in application is same as in DB
		String ExpDescription = testPOM.getDescription();
		String ActDescription = desc;
		Assert.assertEquals(ActDescription, ExpDescription);
		System.out.println("The Slug is " + ActDescription + " " + ExpDescription);

		// User clicks on Add New Region button
		testPOM.addRegion();
		// User refreshes the browser
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
