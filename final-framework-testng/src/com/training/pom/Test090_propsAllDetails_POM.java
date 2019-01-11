/* Test case RETC090 - To verify whether application allows admin to add multiple property with all details*/
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

public class Test090_propsAllDetails_POM {

	private WebDriver driver;

	public Test090_propsAllDetails_POM(WebDriver driver) {
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
	@FindBy(xpath = "//*[text()=' Mana Apartments10'][1]")
	private WebElement featureChkbox;
	
	//Checkbox besides Regions section
	//@FindBy(xpath = "//*[text()=' Apartments'][1]")
	//private WebElement regionChkbox;
	
	//Click on Publish button
	@FindBy(xpath = "//INPUT[@id='publish']")
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
	public void enterTitle(String title) {
		//Enter valid credentials in Enter Title Here textbox - new launch
		this.title.sendKeys(title);
	}
	public void enterBodyText(String text) {
		//Enter valid credentials in body textbox - new launch
		this.text.click();
		this.bodyText.sendKeys(text);	
	}
	public void enterPrice(String price) {
		//Enter valid credentials in Price Here textbox - 50000.00
		//double p = 70000.00;
		this.price.sendKeys(price);
	}
	public void enterPricePerSqft(String ppsqft) {
		//Enter valid credentials in Price per sq. meter/sq. ft textbox
		//double p = 300.00;
		this.pricePerSqft.sendKeys(ppsqft);
	}
	public void clickMainDetails() {
		//Click on Main Details tab
		this.mainDetails.click();
	}
	public void enterStatus(String status) {
		//Enter valid credentials in Status textbox - New
		this.status.sendKeys(status);
	}
	public void enterLocation(String location) {
		//Enter valid credentials in Location textbox - Electronic city
		this.location.sendKeys(location);
	}
	public void enterPossessionDetails(String possession) {
		//Enter valid credentials in Possession textbox - immediate
		this.possession.sendKeys(possession);
	}
	public void clickLocationTab() {
		//Click on Location tab
		this.locationTab.click();
	}
	public void enterAddress(String address) {
		//Enter valid credentials in Address textbox - yeshwanthapur
		this.address.sendKeys(address);
	}
	public void enterGMapsAddress(String gmaps) {
		//Enter valid credentials in Google Maps Address textbox - yeshwanthapur
		this.gmaps.sendKeys(gmaps);
	}
	public void enterLatitude(String lat) {
		//Enter valid credentials in Latitude textbox - 120
		this.latitude.sendKeys(lat);
	}
	public void enterLongitude(String lo) {
		//Enter valid credentials in Longitude textbox - 56
		this.longitude.sendKeys(lo);
	}
	public void clickDetailsTab() {
		//Click on Details tab
		this.details.click();
	}
	public void enterStorageRoom(String st) {
		//Enter valid credentials in Storage Room textbox - 2
		this.storage.sendKeys(st);
	}
	public void clickCheckbox() {
		//Click on Central Bangalore Checkbox
		this.checkbox.click();
	}
	public void clickFeaturesCheckbox() {
		//Click on checkbox beside  Feature of Features section
		this.featureChkbox.click();
	}
	/*public void clickRegionsCheckbox() {
		//Click on checkbox beside Region of Regions section
		this.regionChkbox.click();
	}*/
	public void WaitPublish() {
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(publish));
	}
	public void clickPublish() {
		// click on Publish button
		//this.publish.sendKeys(Keys.ARROW_UP);
		this.publish.click();
	}
	
	public String confirmationMessage() {
		// get the text of the confirmation message after clicking on Publish button
		String expected = confirmationMessage.getText();
		return expected;	
	}
}
