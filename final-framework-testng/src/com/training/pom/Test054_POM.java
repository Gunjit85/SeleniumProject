/* Locating all the WebElements for RETC054 - User opens Retail application http://realestate.hommelle.com/
 * Click on Blog Tab, Click on Read More link of post added by admin - New Launches_Dec28_3, Enter valid details in Comment textbox - real estate TC num 054,
 * Add the name and email in the respective text boxes, Click on Post Comment button */

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test054_POM {

	private WebDriver driver;

	public Test054_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Blog tab
	@FindBy(xpath = "//A[@title=''][text()='Blog'][text()='Blog']/self::A")
	private WebElement blog;
	
	//Read More link of 'New Launches_Dec28_3'
	@FindBy(xpath="//A[@href='http://realestate.hommelle.com/new-launches_dec28_5/']/self::A")
	private WebElement readMore;
	
	//Comment textbox
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement comment;
	
	//name textbox
	@FindBy(xpath="//input[@id='author']")
	private WebElement name;
	
	//email textbox
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	//Post comment button
	@FindBy(xpath = "//input[@id='submit']")
	private WebElement postComment;
	
	//added comment 
	@FindBy(xpath = "//p[contains(text(),'real estate TC num 054_1')]")
	private WebElement addedComment;
	/*
	//down arrow
    @FindBy(css="div.user-name")
	private WebElement downArrow;
*/
	public void clickBlog() {
		//click on Blog tab
		this.blog.click();	
	}
	public void clickReadMore() {
		//click on 'Read More' link of the post added by admin - 'New Launches_Dec28_3'
		this.readMore.click();
	}
	public void addComment(String comment) throws AWTException {
		//Enter valid details in Comment textbox - real estate TC num 054
		
		this.comment.sendKeys(comment);
	}
	public void addNameEmail() {
		//Enter valid details in name and email
		this.name.sendKeys("sunil");
		this.email.sendKeys("sunil@gmail.com");
	}
	public void clickPostComment() {
		//Click on Post Comment button
		this.postComment.click();
	}
	public String confirmationMessage() {
		// get the text of the added comment
		String expected = addedComment.getText();
		return expected;	
	}
}