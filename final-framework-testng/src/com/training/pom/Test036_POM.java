/* Locating all the WebElements for RETC036 - Customer logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-sunil; password - sunil@123
 * Click on Villas tab, click on search button, Enter details of apartment in search box - Nullam hendrerit apartment,
 * Click on Nullam hendrerit apartment link, Click on Drop Us a Line Link, Enter valid details in Your Name textbox(selenium), 
 * Enter valid details in Your Email Address textbox(selenium@gmail.com) , Enter valid details in subject textbox(apartment), 
 * Enter valid details in message textbox(looking for apartment), Click on Send button, 
 * Thanks you for your message. It has been sent message should get displayed*/

package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Test036_POM {

	private WebDriver driver;

	public Test036_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Villas link
	@FindBy(xpath = "//a[contains(text(),'Villas')]")
	private WebElement villas;
	//search box
	@FindBy(xpath="//div[@id='ajaxsearchlite2']//input[@placeholder='Search here for Properties..']")
	private WebElement searchBox;
	//click on entered text link
	@FindBy(xpath="//span[@class='overlap']")
	private WebElement property;
	//Drop Us A line 
	@FindBy(xpath = "//a[@class='button fullwidth margin-top-20']")
	private WebElement dropUsALine;
	//Name textbox on contact form
	@FindBy(name = "name")
	private WebElement name;
	//Email Address
	@FindBy(name="email")
	private WebElement emailAddress;
	//Subject textbox
	@FindBy(name="subject")
	private WebElement subject;
	//Message textbox
	@FindBy(xpath="//textarea[@placeholder='Message']")
	private WebElement message;
	//Submit button
	@FindBy(xpath="//input[@value='Send']")
	private WebElement submit;	
	//confirmation message
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ok']")
	private WebElement confirmationMessage;	
		
	public void clickVillas() {
		//click on Villas link
		this.villas.click();	
	}
	public void enterSearchText() throws InterruptedException {
		//click on Search box(right-most) and enter Nullam hendrerit apartment
		this.searchBox.click();
		Thread.sleep(2000);
		this.searchBox.sendKeys("Nullam hendrerit apartment");
	}
	public void clickProperty() {
		//click on the property "Nullam hendrerit apartment" link
		this.property.click();
	}
	public void clickDropUsALine() throws InterruptedException {
		//switch back to first tab and click on Drop Us A line button
		ArrayList<String>  wins=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wins.get(0));
		Thread.sleep(4000);
		
		this.dropUsALine.click();
	}
	public void enterName(String name) {
		//enter name in the name textbox of contact form
		this.name.sendKeys(name);	
	}
	public void enterEmailAddress(String emailAddress) {
		//Enter email address in textbox
		this.emailAddress.sendKeys(emailAddress);	
	}
	public void enterSubject(String subject) {
		//Enter Subject
		this.subject.sendKeys(subject);	
	}
	public void enterMessage(String message) {
		//Enter Message
		this.message.sendKeys(message);	
	}
	public void clickSubmit() {
		//Click on submit button
		this.submit.click();	
	}
	public String confirmationMessage() throws AWTException {
		// get the text of the message displayed after clicking the submit button
		
		String expected = confirmationMessage.getText();	
		return expected;	
	}
}
