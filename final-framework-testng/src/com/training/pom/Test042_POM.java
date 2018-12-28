/* Locating all the WebElements for RETC036 - Customer logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-sunil; password - sunil@123
 * Click on Villas tab, click on search button, Enter details of apartment in search box - Nullam hendrerit apartment,
 * Click on Nullam hendrerit apartment link, Click on Drop Us a Line Link, Enter valid details in Your Name textbox(selenium), 
 * Enter valid details in Your Email Address textbox(selenium@gmail.com) , Enter valid details in subject textbox(apartment), 
 * Enter valid details in message textbox(looking for apartment), Click on Send button, 
 * Thanks you for your message. It has been sent message should get displayed*/

package com.training.pom;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Test042_POM {

	private WebDriver driver;

	public Test042_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Posts link
	@FindBy(xpath = "//div[contains(text(),'Posts')]")
	private WebElement posts;
	//Add New button
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNew;
	//Enter title here textbox
	@FindBy(xpath="//input[@id='title']")
	private WebElement title;
	//Text link
	@FindBy(xpath = "//button[@id='content-html']")
	private WebElement text;
	//Body textbox 
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement bodyText;
	//Publish button
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publish;
	//All Posts
	@FindBy(linkText = "All Posts")
	private WebElement allPosts;
	//post created
	@FindBy(xpath = "//A[@class='row-title'][text()='New Launches'][text()='New Launches']/self::A")
	private WebElement postCreated;
	//Message textbox
	@FindBy(xpath="//textarea[@placeholder='Message']")
	private WebElement message;
	//Submit button
	@FindBy(xpath="//input[@value='Send']")
	private WebElement submit;	
	//confirmation message
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ok']")
	private WebElement confirmationMessage;	
		
	public void clickPosts() {
		//click on Posts link
		posts.click();	
	}
	public void clickAddNew() {
		//click on 'Add New' button next to Posts
		addNew.click();
	}
	public void enterTitle() {
		//Enter Valid credentials in Enter title here textbox - New Launches
		title.sendKeys("New Launches");
	}
	public void enterBodyText() {
		//Enter valid credentials in body textbox - New Launch in Home
		text.click();
		bodyText.sendKeys("New Launch in Home");	
	}
	public void clickPublish() throws InterruptedException {
		//Click on Publish button
		publish.click();
		//Thread.sleep(7000);
	}
	public void clickAllPosts() {
		//Click on All Posts
		allPosts.click();	
	}
	public void clickOnPostCreated() {
		//Click on Post created (New Launches)
		postCreated.click();	
	}
	public String confirmationMessage() {
		// get the text of the title after clicking on the post created - New Launches
		String expected = title.getAttribute("value");	
		return expected;	
	}
}
