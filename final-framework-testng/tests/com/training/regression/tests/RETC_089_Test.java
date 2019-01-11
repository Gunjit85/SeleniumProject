/* Test case RETC089 - To verify whether application allows admin to create multiple  property details based on the Region created. */
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
import com.training.dataproviders.DataProvidersTC089;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdminPOM;
import com.training.pom.LoginPOM;
import com.training.pom.Test027_POM;
import com.training.pom.Test087_multipleProps_POM;
import com.training.pom.Test089_mprops_regionsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_089_Test {
	private WebDriver driver;
	private String adminUrl;
	private AdminPOM loginPOM;
	private Test089_mprops_regionsPOM testPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException, InterruptedException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminPOM(driver); 
		testPOM = new Test089_mprops_regionsPOM(driver);
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
	@Test(priority=2, dataProvider = "excel-inputs", dataProviderClass = DataProvidersTC089.class)
	public void multiplePropsRegionsTest(String userName, String slug, String pRegion, String description, String title, String textbox, String region) throws InterruptedException, AWTException {
		String wait = properties.getProperty("implicitWait");
		testPOM.clickProperties(); // click Properties link
		testPOM.clickRegions();//click regions link
		testPOM.enterName(userName);// enter name in textbox
		testPOM.enterSlug(slug);//enter slug
		testPOM.selectParentRegion(pRegion);//select the parent region
		System.out.println("Parent region is clicked");
		testPOM.enterDescription(description);//enter description in the textbox
		testPOM.addRegion();//click on Add New Region button
		testPOM.addNewLink();//Under properties click on Add New link
		testPOM.addPropTitle(title);//add property title
		testPOM.addText(textbox);//add text in texbox
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

		testPOM.selectCreatedRegion(region);//click on checkbox next to the added feature
		System.out.println("checkbox clicked");
		testPOM.WaitPublish();//explicit wait for publish button to be clickable
		Thread.sleep(5000);
		testPOM.clickPublish();//click publish button
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