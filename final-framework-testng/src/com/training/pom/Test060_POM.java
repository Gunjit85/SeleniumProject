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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test060_POM {

	private WebDriver driver;

	public Test060_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement properties;
	//Add New button
	@FindBy(xpath="//a[@class='page-title-action']")
	private WebElement addNew;
	//Title here textbox
	@FindBy(xpath = "//input[@id='title']")
	private WebElement title;
	//Text link
	@FindBy(xpath = "//button[@id='content-html']")
	private WebElement text;
	//Body textbox 
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement bodyText;
	//price
	@FindBy(xpath = "//textarea[@id='_price']")
	private WebElement price;
	//Price per sq. meter/sq. ft textbox
	@FindBy(xpath="//input[@id='_price_per']")
	private WebElement pricePerSqft;
	//Main Details tab
	@FindBy(linkText = "Main Details")
	private WebElement mainDetails;
	//Status textbox
	@FindBy(xpath = "//input[@id='_status']")
	private WebElement status;
	//Location textbox
	@FindBy(xpath = "//input[@id='_location']")
	private WebElement location;
	//Possession textbox
	@FindBy(xpath = "//input[@id='_possession']")
	private WebElement possession;
	//Location tab
	@FindBy(linkText = "Location")
	private WebElement locationTab;
	//Address textbox
	@FindBy(xpath = "//input[@id='_friendly_address']")
	private WebElement address;
	//Google Maps Address textbox
	@FindBy(xpath = "//input[@id='_address']")
	private WebElement gmaps;
	//Latitude textbox
	@FindBy(xpath = "//input[@id='_geolocation_lat']")
	private WebElement latitude;
	//Longitude textbox
	@FindBy(xpath = "//input[@id='_geolocation_long']")
	private WebElement longitude;
	//Details tab
	@FindBy(linkText = "Details")
	private WebElement details;
	//Storage room textbox
	@FindBy(xpath = "//input[@id='_storage_room']")
	private WebElement storage;	
	//Central Bangalore checkbox
	@FindBy(xpath = "//input[@id='in-region-24']")
	private WebElement checkbox;	
	//Checkbox besides features section
	@FindBy(xpath = "//*[text()=' interior'][1]")
	private WebElement featureChkbox;
	//Checkbox besides Regions section
	@FindBy(xpath = "//*[text()=' Apartments'][1]")
	private WebElement regionChkbox;
	//Click on Publish button
	@FindBy(xpath = "//input[@id='publish']")
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
	public void enterTitle() {
		//Enter valid credentials in Enter Title Here textbox - new launch
		title.sendKeys("new launch123");
	}
	public void enterBodyText() {
		//Enter valid credentials in body textbox - new launch
		text.click();
		bodyText.sendKeys("new launch123");	
	}
	public void enterPrice() {
		//Enter valid credentials in Price Here textbox - 50000.00
		double p = 70000.00;
		price.sendKeys(String.valueOf(p));
	}
	public void enterPricePerSqft() {
		//Enter valid credentials in Price per sq. meter/sq. ft textbox
		double p = 300.00;
		pricePerSqft.sendKeys(String.valueOf(p));
	}
	public void clickMainDetails() {
		//Click on Main Details tab
		mainDetails.click();
	}
	public void enterStatus() {
		//Enter valid credentials in Status textbox - New
		status.sendKeys("New");
	}
	public void enterLocation() {
		//Enter valid credentials in Location textbox - Electronic city
		location.sendKeys("Electronic city");
	}
	public void enterPossessionDetails() {
		//Enter valid credentials in Possession textbox - immediate
		possession.sendKeys("immediate");
	}
	public void clickLocationTab() {
		//Click on Location tab
		locationTab.click();
	}
	public void enterAddress() {
		//Enter valid credentials in Address textbox - yeshwanthapur
		address.sendKeys("yeshwanthapur");
	}
	public void enterGMapsAddress() {
		//Enter valid credentials in Google Maps Address textbox - yeshwanthapur
		gmaps.sendKeys("yeshwanthapur");
	}
	public void enterLatitude() {
		//Enter valid credentials in Latitude textbox - 120
		int lat = 120;
		latitude.sendKeys(String.valueOf(lat));
	}
	public void enterLongitude() {
		//Enter valid credentials in Longitude textbox - 56
		int lo = 56;
		longitude.sendKeys(String.valueOf(lo));
	}
	public void clickDetailsTab() {
		//Click on Details tab
		details.click();
	}
	public void enterStorageRoom() {
		//Enter valid credentials in Storage Room textbox - 2
		int st = 2;
		storage.sendKeys(String.valueOf(st));
	}
	public void clickCheckbox() {
		//Click on Central Bangalore Checkbox
		checkbox.click();
	}
	public void clickFeaturesCheckbox() throws AWTException {
		//Click on checkbox beside  Feature of Features section
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);

		featureChkbox.click();
	}
	public void clickRegionsCheckbox() {
		//Click on checkbox beside Region of Regions section
		regionChkbox.click();
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
