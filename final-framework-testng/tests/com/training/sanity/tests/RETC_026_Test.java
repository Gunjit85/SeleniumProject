/* Test case RETC026 - User logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Click on Properties link, then click on AllProperties link, Click on the checkbox beside the Property details, 
 * Click on Bulk Actions list box, Select valid credentials(Move to trash) in Bulk Actions list box
 * Click on Apply button next to the listbox. Once it is done, "1 post moved to the Trash. Undo"  message 
 * should get displayed along with property details should be removed from the properties details */

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
		//User logins as an admin
		loginPOM.clickLogin(); 
		loginPOM.sendUserName("admin"); 
		loginPOM.sendPassword("admin@123"); 
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		}
	
	@Test(priority=2)
    public void moveToTrashTest() throws InterruptedException{
		//method to click on Properties
		testPOM.clickProperties();	
		Thread.sleep(3000);
		System.out.println("Properties Clicked");
		//method to click on AllProperties
		testPOM.allProperties();	
		Thread.sleep(4000);
		System.out.println("Allproperties clicked");
		//method to click checkbox of the first property listed
		testPOM.clickcheckbox();	
		Thread.sleep(2000);
		System.out.println("chkbox clicked");
		//method to click Bulk actions and Move to trash option
		testPOM.clickBulkActions();	
		Thread.sleep(2000);
		System.out.println("bulk list clicked");
		//method to click Apply button
		testPOM.clickApply();	
		Thread.sleep(2000);
		//get the actual output message from the method message()
		String actualOutput = testPOM.message();	
		Thread.sleep(2000);
		System.out.println("text printed");
		String expected = "1 post moved to the Trash. Undo";	
		//assert expected and actual
		assertEquals(actualOutput, expected);	
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}


