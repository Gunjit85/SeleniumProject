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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_042_Test {
	private WebDriver driver;
	private String baseUrl;
	private AdminPOM loginPOM;
	private Test042_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test042_POM(driver);
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
		String wait = properties.getProperty("implicitWait");
		//Admin clicks on Posts link
		testPOM.clickPosts();
		System.out.println("Posts Clicked");
		//Admin clicks on 'Add New' link
		testPOM.clickAddNew();
		System.out.println("Add New link is clicked and Add New Post page is displayed");
		//Admin enters text in 'Title here' textbox
		testPOM.enterTitle();	
		System.out.println("Title is added");
		//Admin enters text in 'Body' textbox
		testPOM.enterBodyText();
		System.out.println("Text is added to 'Body' textbox");
		//Admin clicks on 'Publish' button
		testPOM.clickPublish();
		//Thread.sleep(8000);
		System.out.println("Publish button is clicked. Post published. View post message is displayed");
		//Admin clicks on 'All Posts' link
		testPOM.clickAllPosts();
		System.out.println("All Posts link is clicked. Post added by the admin is displayed");
		//Admin clicks on the post created link
		testPOM.clickOnPostCreated();
		System.out.println("Created post is clicked and details of post are displayed");
								
		//get the actual output message from the text displayed in the title of added post recently
		String actualOutput = testPOM.confirmationMessage();
		Thread.sleep(3000);
		
		String expected = "New Launches";	
		//assert expected and actual
		assertEquals(actualOutput, expected);	
		}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}

