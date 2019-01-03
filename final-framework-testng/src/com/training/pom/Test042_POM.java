/* Locating all the WebElements for RETC042 - Admin logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Click on Posts  link, Click on Add New link, Enter Valid credentials in Enter title here textbox - New Launches_Dec28_4,
 * Enter valid credentials in body textbox - New Launch in Home, Click on Publish button, Click on All Posts,
 * Click on Post created (New Launches_Dec28_4) */

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
	@FindBy(xpath = "//a[@class='wp-first-item current']")
	private WebElement allPosts;
	//post created
	@FindBy(xpath = "//*[text()='New Launches_Dec28_4']")
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
		this.posts.click();	
	}
	public void clickAddNew() {
		//click on 'Add New' button next to Posts
		this.addNew.click();
	}
	public void enterTitle(String title) {
		//Enter Valid credentials in Enter title here textbox - New Launches3456
		this.title.sendKeys(title);
	}
	public void enterBodyText(String bodyText) {
		//Enter valid credentials in body textbox - New Launch in Home3456
		text.click();
		this.bodyText.sendKeys(bodyText);	
	}
	public void clickPublish() throws InterruptedException {
		//Click on Publish button
		publish.click();
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
