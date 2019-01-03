/* Test case RETC054 - User opens Retail application http://realestate.hommelle.com/
 * Click on Blog Tab, Click on Read More link of post added by admin - New Launch_Dec28_3, Enter valid details in Comment textbox - real estate TC num 054,
 * Add the name and email in the respective text boxes, Click on Post Comment button, Open admin site in new window,
 * Credentials - username-admin; password - admin@123
 * click on Dashboard tab, mouse over the comment added by user recently - real estate TC num 054, Click on Reply icon,
 * enter valid details in comments textbox - thanks, Click on Reply button, Refresh the page, 
 * comments added by the admin on user should get displayed as From admin on Comment name*/

package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.hpsf.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.training.pom.Test054_POM;
import com.training.pom.Test054_POM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_054_Test {
	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private CustomerPOM userLoginPOM;
	private AdminPOM adminLoginPOM;
	private Test054_POM userPOM;
	private Test054_POM2 adminPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		userLoginPOM = new CustomerPOM(driver); 
		userPOM = new Test054_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(3000);
	}
/*	
	@Test(priority=1)
	public void userLoginTest() throws InterruptedException {
		//User logins as a User
		userLoginPOM.clickLogin(); 
		userLoginPOM.sendUserName("sunil"); 
		userLoginPOM.sendPassword("sunil@123"); 
		userLoginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		screenShot.captureScreenShot("First");
		}
	*/
	@Test(priority=2)
    public void userAddedCommentTest() throws InterruptedException, AWTException{
		String wait = properties.getProperty("implicitWait");
		//User clicks on Blog link
		userPOM.clickBlog();
		System.out.println("Blog link is Clicked");
		//User clicks on Read more link
		userPOM.clickReadMore();
		System.out.println("Read more link of the post added by admin is clicked");
		//User adds comment to the post
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		userPOM.addComment("real estate TC num 054_1");
		System.out.println("Comment is added");
		//User adds name and email
		userPOM.addNameEmail();
		System.out.println("Name and email is added");
		//Click on post comment button
		userPOM.clickPostComment();
		Thread.sleep(4000);
		System.out.println("Post comment button is clicked");
								
		//get the actual output message from the text displayed in the recently added comment
		String actualOutput = userPOM.confirmationMessage();
		
		String expected = "real estate TC num 054_1";	
		//assert expected and actual
		assertEquals(actualOutput, expected);	
		}

	@Test(priority=3)
	public void AdminLoginTest() throws InterruptedException {
		String wait1 = properties.getProperty("implicitWait");
		adminLoginPOM = new AdminPOM(driver); 
		adminPOM = new Test054_POM2(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", adminUrl);
		System.out.println("New window opens for Admin Login");
		//User login as Admin
		ArrayList<String>  wins=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wins.get(1));
		
		adminLoginPOM.clickLogin(); 
		adminLoginPOM.sendUserName("admin"); 
		adminLoginPOM.sendPassword("admin@123"); 
		adminLoginPOM.clickLoginBtn(); 
	}
	
	@Test(priority=4)
    public void adminRepliesToCommentTest() throws InterruptedException, AWTException{
		String wait = properties.getProperty("implicitWait");
		//Admin clicks on Dashboard link
		adminPOM.clickDashboard();
		System.out.println("Dashboard is Clicked");
		//Admin hovers over the added comment and click on Reply icon
		adminPOM.clickReply();
		System.out.println("Reply icon is clicked");
		//Admin adds reply in the texbox
		adminPOM.addReply("thanks");
		System.out.println("Reply text is added");
		//Admin clicks on Reply button
		adminPOM.clickReplyButton();
		System.out.println("Reply button is clicked");
		
		//get the actual output message from the text displayed in the recently added reply
		String actualOutput = adminPOM.confirmationMessage();
		
		String expected = "thanks";	
		//assert expected and actual
		assertEquals(actualOutput, expected);	
		}

		
		
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}


