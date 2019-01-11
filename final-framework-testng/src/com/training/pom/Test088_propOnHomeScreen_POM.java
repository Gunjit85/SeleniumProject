/* Test case RETC088 - To verify whether application allows admin to create property details based on the Feature created & 
 * added property get displayed on home screen for user. */
package com.training.pom;

import java.util.List;

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

public class Test088_propOnHomeScreen_POM {
	private WebDriver driver;

	public Test088_propOnHomeScreen_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;
	// Features link
	@FindBy(xpath = "//a[contains(text(),'Features')]")
	private WebElement clickfeatures;
	// Name texbox
	@FindBy(id = "tag-name")
	private WebElement name;
	// Slug textbox
	@FindBy(id = "tag-slug")
	private WebElement slug;
	// Description textbox
	@FindBy(id = "tag-description")
	private WebElement description;
	// add new feature button
	@FindBy(id = "submit")
	private WebElement submit;
	// add new link under properties section
	@FindBy(xpath = "//a[@href='post-new.php?post_type=property']")
	private WebElement addNew;
	// enter title
	@FindBy(xpath = "//input[@id='title']")
	private WebElement propTitle;
	// click text area
	@FindBy(xpath = "//button[@id='content-html']")
	private WebElement text;
	// text area
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement textarea;
	// Checkbox besides feature added
	@FindBy(xpath = "//*[text()=' New Launches_Jan11_1'][1]")
	private WebElement clickCheckbox;
	// publish button
	@FindBy(xpath = "//INPUT[@id='publish']")
	private WebElement publish;
	// mouse hover over admin name
	@FindBy(xpath = "//SPAN[@class='display-name'][text()='admin'][text()='admin']/self::SPAN")
	private WebElement admin;
	// Logout button
	@FindBy(xpath = "//A[@class='ab-item'][text()='Log Out']/self::A")
	private WebElement logout;
	// Real Estate Icon
	@FindBy(xpath = "//a[@title='Real Estate']")
	private WebElement realEstateIcon;
	// Search textbox
	@FindBy(xpath = "//input[@placeholder='Search here for Properties..']")
	private WebElement search;
	// Search results
	@FindBy(xpath = "//div[@class='resdrg']/div[1]")
	private WebElement searchResults;
	
	public void clickProperties() {
		// click Properties link
		this.clickProps.click();
	}

	public void clickFeatures() {
		// click Features link
		this.clickfeatures.click();
	}

	public void enterName(String name) {
		// enter text in Name textbox
		this.name.sendKeys(name);
	}

	public void enterSlug(String slug) {
		// enter text in slug textbox
		this.slug.sendKeys(slug);
	}

	public void enterDescription(String description) {
		// enter description in description textbox
		this.description.sendKeys(description);
	}

	public void addFeature() {
		// click on Add new Feature button
		this.submit.click();
	}

	public void addNewLink() {
		// click on Add new link under properties
		this.addNew.click();
	}

	public void addPropTitle(String title) {
		// Enter valid credentials in Enter Title Here textbox
		this.propTitle.sendKeys(title);
	}

	public void addText(String text) {
		// Enter valid credentials in textbox
		this.text.click();
		this.textarea.sendKeys(text);
	}

	// Select the created Feature
	public void selectCreatedFeature() {
		this.clickCheckbox.click();
	}

	public void WaitPublish() {
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(publish));
	}

	public void clickPublish() {
		// click on Publish button
		//this.publish.sendKeys(Keys.ARROW_UP);
		this.publish.click();
	}
	
	public void WaitPostPublish() {
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(admin));
	}
	public void clickLogout() throws InterruptedException {
		// Hover over the admin name and click on Logout button
		
		Actions action = new Actions(driver);
		action.moveToElement(admin).build().perform();
		Thread.sleep(5000);
		this.logout.click();
	}
	public void clickRealEstateIcon() {
		// click on RealEstate Icon 
		
		this.realEstateIcon.click();
	}
	public void searchAddedProp(String text) {
		// click on RealEstate Icon 
		this.search.sendKeys(text);
	}
	
	public String confirmationMessage() {
		// get the text of the confirmation message after clicking on Publish
		// button
		String actualMsg = searchResults.getText();
		String expected = (actualMsg.substring(0, 12));
		return expected;
	}

}