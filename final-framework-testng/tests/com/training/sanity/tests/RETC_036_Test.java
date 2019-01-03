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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_036_Test {
	private WebDriver driver;
	private String baseUrl;
	private CustomerPOM loginPOM;
	private Test036_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new CustomerPOM(driver); 
		testPOM = new Test036_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void adminLoginTest() throws InterruptedException {
		//User logins as a Customer
		loginPOM.clickLogin(); 
		loginPOM.sendUserName("sunil"); 
		loginPOM.sendPassword("sunil@123"); 
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		}
	
	@Test(priority=2)
    public void enquireVillasTest() throws InterruptedException, AWTException{
		String wait = properties.getProperty("implicitWait");
		//Customer clicks on Villas tab
		testPOM.clickVillas();
		System.out.println("Villas Clicked");
		//Customer clicks on searchbox and enters text
		testPOM.enterSearchText();	
		System.out.println("Searchbox clicked and search text is entered");
		//Customer clicks on the search result link and a new tab opens
		testPOM.clickProperty();	
		Thread.sleep(5000);
		System.out.println("Property link is clicked and a new tab opens");
		//Customer switch back to the first tab and click on Drop Us A Line button
		testPOM.clickDropUsALine();	
		System.out.println("Customer is in first tab and Drop Us A Line link is clicked");
		//Customer enters name in Name textbox
		testPOM.enterName("selenium");
		System.out.println("Name is entered");
		//Customer enters email in Email Address textbox
		testPOM.enterEmailAddress("selenium@gmail.com");
		System.out.println("Email Id is entered");
		//Customer enters Subject in Subject textbox
		testPOM.enterSubject("apartment");
		System.out.println("Subject is entered");
		//Customer enters message text in Message textbox
		testPOM.enterMessage("looking for apartment");
		System.out.println("Message text is entered");
		//Customer clicks on submit button
		testPOM.clickSubmit();
		System.out.println("Submit button is clicked");
								
		//get the actual output message from the text displayed on the browser after submitting
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		String actualOutput = testPOM.confirmationMessage();
		
		String expected = "Thank you for your message. It has been sent.";	
		//assert expected and actual
		assertEquals(actualOutput, expected);	
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}


