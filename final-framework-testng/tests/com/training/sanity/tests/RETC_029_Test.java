/* Test case RETC029 - User logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Click on Properties link, then click on Regions link, add text "New Launches" in Name textbox, add text "launch" in slug textbox,
 * click on Parent region dropdown and select "None", Add text to Description textbox, click on Add new region button. 
 * Once it is done, Added Region in existing region module should get displayed */

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
		//User logins as an admin
		loginPOM.clickLogin();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		}
	
	@Test(priority=2)
    public void addNewRegionTest() throws InterruptedException{
		//User click on Properties link
		testPOM.clickProperties();
		Thread.sleep(3000);
		System.out.println("Properties clicked");
		//User click on Regions link
		testPOM.clickRegions();
		Thread.sleep(3000);
		System.out.println("Regions clicked");
		//User enters text in Name textbox
		testPOM.enterName();
		Thread.sleep(2000);
		System.out.println("Name entered");
		//User enters text in Slug textbox
		testPOM.enterSlug();
		Thread.sleep(2000);
		System.out.println("Slug entered");
		//User click on Parent Region dropdown and select 'None'
		testPOM.clickParentRegion();
		Thread.sleep(2000);
		System.out.println("Parent resion listbox clicked");
		//User enters text in Description textbox
		testPOM.enterDescription();
		Thread.sleep(2000);
		System.out.println("Description entered");
		//User clicks on Add New Region button
		testPOM.addRegion();
		Thread.sleep(2000);
		System.out.println("submit clicked");
		//User refreshes the browser
		driver.navigate().refresh();
		//User enters text in search textbox(same Name of region added newly)
		testPOM.enterText();
		Thread.sleep(2000);
		System.out.println("search text entered");
		//User clicks on search regions button
		testPOM.searchRegions();
		Thread.sleep(2000);
		System.out.println("search regions button clicked");
		//User takes the actual result from existingRegions method
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


