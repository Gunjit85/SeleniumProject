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
	@FindBy(xpath = "(//*[text()=' Electronic City'])[1]")
	private WebElement checkbox;
	//Publish button
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publish;
	//confirmation message
	@FindBy(xpath="//div[@id='message']//p")
	private WebElement confirmationMessage;	
		
	public void clickProperties() {
		//click on Properties link
		properties.click();	
	}
	public void clickAddNew() {
		//click on 'Add New' button next to Properties
		addNew.click();
	}
	public void clickAddNewRegion() {
		//Click on Add new Region link in Regions section
		addNewRegion.click();
	}
	public void enterText() {
		//Enter valid details in Textbox - Electronic City
		textbox.sendKeys("Electronic City");
	}
	public void selectParentRegion() {
		// Select valid details in Parent Region list box - West Bangalore
		Select pregion = new Select(parentRegion);
		pregion.selectByValue("27");	
	}
	public void clickAddNewRegionButton() {
		//Click on Add New Region button
		addNewRbutton.click();
	}
	public void Refresh() throws InterruptedException {
		//Refresh the browser
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
	public void enterTitle() {
		//Enter valid credentials in Enter Title Here textbox - prestige
		//Actions actions = new Actions(driver);
		//actions.moveToElement(title);
		//WebDriverWait w=new WebDriverWait(driver,100);
		//w.until(ExpectedConditions. invisibilityOfElementLocated(title));

		title.sendKeys("prestige");
	}
	public void enterBodyText() {
		//Enter valid credentials in body textbox - home town
		text.click();
		bodyText.sendKeys("home town");	
	}
	public void clickCheckbox() {
		//Click on checkbox beside created region
		checkbox.click();
	}
	public void clickPublish() {
		//Click on Publish button
		publish.click();
	}
	
	public String confirmationMessage() {
		// get the text of the confirmation message after clicking on Publish button
		String expected = confirmationMessage.getText();
		return expected;	
	}
}
