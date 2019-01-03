/* Locating all the WebElements for RETC048 - Admin logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Click on Properties tab, Click on Add New button, Click on Add new Region link in Regions section, Enter valid details in Textbox - Electronic City,
 * Select valid details in Parent Region list box - West Bangalore, Click on Add New Region button, Click on Refresh button from keyboard,
 * Enter valid credentials in Enter Title Here textbox - prestige, Enter valid credentials in textbox - home town, Click on checkbox beside created region,
 * Click on Publish button, Post published. View post message should get displayed*/

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

public class Test048_POM {

	private WebDriver driver;

	public Test048_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement properties;
	//Add New button
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNew;
	//Add New Region link under Regions
	@FindBy(xpath="//a[@id='region-add-toggle']")
	private WebElement addNewRegion;
	//Text box after clicking add new region button
	@FindBy(xpath = "//input[@id='newregion']")
	private WebElement textbox;
	//Parent region listbox 
	@FindBy(xpath = "//SELECT[@id='newregion_parent']/self::SELECT")
	private WebElement parentRegion;
	//Add New Region button
	@FindBy(xpath = "//input[@id='region-add-submit']")
	private WebElement addNewRbutton;
	//Title here textbox
	@FindBy(xpath = "//input[@id='title']")
	private WebElement title;
	//Text link
	@FindBy(xpath = "//button[@id='content-html']")
	private WebElement text;
	//Body textbox 
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement bodyText;
	//checkbox next to new region created
	@FindBy(xpath = "(//*[text()=' Electronic City77'])[1]")
	private WebElement checkbox;
	//Publish button
	@FindBy(xpath="//INPUT[@id='publish']")
	private WebElement publish;
	//confirmation message
	@FindBy(xpath="//div[@id='message']//p")
	private WebElement confirmationMessage;	
		
	public void clickProperties() {
		//click on Properties link
		this.properties.click();	
	}
	public void clickAddNew() {
		//click on 'Add New' button next to Properties
		this.addNew.click();
	}
	public void clickAddNewRegion() {
		//Click on Add new Region link in Regions section
		this.addNewRegion.click();
	}
	public void enterText(String textbox) {
		//Enter valid details in Textbox - Electronic City
		this.textbox.sendKeys(textbox);
	}
	public void selectParentRegion() {
		// Select valid details in Parent Region list box - West Bangalore
		Select pregion = new Select(parentRegion);
		pregion.selectByValue("27");	
	}
	public void clickAddNewRegionButton() {
		//Click on Add New Region button
		this.addNewRbutton.click();
	}
	public void Refresh() throws InterruptedException {
		//Refresh the browser
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
	public void enterTitle(String title) {
		//Enter valid credentials in Enter Title Here textbox - prestige
		this.title.sendKeys(title);
	}
	public void enterBodyText() {
		//Enter valid credentials in body textbox - home town
		this.text.click();
		bodyText.sendKeys("home town");	
	}
	public void clickCheckbox() {
		//Click on checkbox beside created region
		this.checkbox.click();
	}
	public void clickPublish() throws AWTException, InterruptedException {
		//Click on Publish button
		this.publish.sendKeys(Keys.ARROW_UP);
		this.publish.click();
	}
	
	public String confirmationMessage() {
		// get the text of the confirmation message after clicking on Publish button
		String expected = confirmationMessage.getText();
		return expected;	
	}
}
