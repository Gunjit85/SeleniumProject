/* Locating all the WebElements for RETC054 - User opens Retail application in a new tab and login as admin http://realestate.hommelle.com/admin
 * Credentials - username-admin; password - admin@123
 * click on Dashboard tab, mouse over the comment added by user recently - real estate TC num 054, Click on Reply icon,
 * enter valid details in comments textbox - thanks, Click on Reply button, Refresh the page, 
 * comments added by the admin on user should get displayed as From admin on Comment name */

package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test054_POM2 {

	private WebDriver driver;

	public Test054_POM2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Dashboard tab
	@FindBy(xpath = "//div[contains(text(),'Dashboard')]")
	private WebElement dashboard;
	
	//comment
	@FindBy(xpath = "//*[contains(text(),'real estate TC num 054_1')]")
	private WebElement comment;
	
	//Reply link
	@FindBy(linkText = "Reply")
	private WebElement reply;
	
	//Add reply
	@FindBy(xpath="//textarea[@id='replycontent']")
	private WebElement addReply;
	
	//Reply button
	@FindBy(xpath = "//span[@id='replybtn']")
	private WebElement replyButton;
	
	//confirmation message after clicking reply button
	@FindBy(xpath = "//p[contains(text(),'thanks')]")
	private WebElement confirmationMessage;
			
	public void clickDashboard() {
		//click on Dashboard tab
		dashboard.click();	
	}
	public void clickReply() {
		//mouse over the comment added by user recently and click on Reply 
		Actions actions = new Actions(driver);
		actions.moveToElement(comment).click().perform();
		reply.click();
	}
	public void addReply(){
		//enter valid details in comments textbox
		addReply.sendKeys("thanks");
	}
	public void clickReplyButton() {
		//Click on Reply button
		replyButton.click();
	}
	public String confirmationMessage() {
		// get the text of the added reply to comment
		driver.navigate().refresh();
		String expected = confirmationMessage.getText();
		return expected;	
	}
}
