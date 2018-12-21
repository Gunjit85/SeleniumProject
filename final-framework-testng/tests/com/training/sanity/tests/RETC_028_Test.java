/* Test case RETC028 - User logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Click on Properties link, then click on Features link, Click on the checkbox of the tag to be deleted,
 * go to BulkActions listbox and select Delete, click on Apply button, 
 * "Items deleted." Message should get displayed and selected feature should be removed from the features list */

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_028_Test {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM loginPOM;
	private Test028_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test028_POM(driver);
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
    public void deleteExistingFeatureTest() throws InterruptedException{
		//User clicks on Properties link
		testPOM.clickProperties();
		Thread.sleep(3000);
		System.out.println("Properties clicked");
		//User clicks on Features link
		testPOM.clickFeatures();
		Thread.sleep(3000);
		System.out.println("Features clicked");
		//User clicks on the checkbox of the tag to be deleted
		testPOM.checkCheckbox();
		Thread.sleep(2000);
		System.out.println("User checked the checkbox");
		//User clicks on the bulk actions listbox and select 'Delete' option
		testPOM.deleteFeature();
		Thread.sleep(2000);
		System.out.println("Delete selected in bulk actions listbox");
		//User clicks on Apply button
		testPOM.clickApply();
		Thread.sleep(2000);
		System.out.println("Apply button selected");
		//User takes the actual result from the exitingFeature() method
		String actOutput = testPOM.existingFeature();
		
		String expOutput = "Items deleted.";
		assertEquals(actOutput, expOutput);
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}


