/* Test case RETC088 - To verify whether application allows admin to create property details based on the Feature created & 
 * added property get displayed on home screen for user. */
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.DataProvidersTC087;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.LoginPOM;
import com.training.pom.Test027_POM;
import com.training.pom.Test087_multipleProps_POM;
import com.training.pom.Test088_propOnHomeScreen_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_088_Test {
	private WebDriver driver;
	private String adminUrl;
	private AdminPOM loginPOM;
	private Test088_propOnHomeScreen_POM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test088_propOnHomeScreen_POM(driver);
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
	@Test(priority=2)
	public void multiplePropertiesTest() throws InterruptedException, AWTException {
		String wait = properties.getProperty("implicitWait");
		testPOM.clickProperties(); // click Properties link
		testPOM.clickFeatures();//click features link
		testPOM.enterName("New Launches_Jan11_1");// enter name in textbox
		testPOM.enterSlug("launch");//enter slug
		testPOM.enterDescription("New Launches of villas, apartments, flats");//enter description in the textbox
		testPOM.addFeature();//click on Add New feature button
		testPOM.addNewLink();//Under properties click on Add New link
		testPOM.addPropTitle("prestige3333");//add property title
		testPOM.addText("hometown");//add text in texbox
		//Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		//robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		testPOM.selectCreatedFeature();//click on checkbox next to the added feature
		testPOM.WaitPublish();//explicit wait for publish button to be clickable
		Thread.sleep(3000);
		testPOM.clickPublish();//click publish button
		//testPOM.WaitPostPublish();
		Thread.sleep(3000);
		testPOM.clickLogout();
		testPOM.clickRealEstateIcon();
		testPOM.searchAddedProp("prestige3333");
		
		String actualOutput = testPOM.confirmationMessage();
		
		String expected = "prestige3333";
		// assert expected and actual
		assertEquals(actualOutput, expected);
		}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}