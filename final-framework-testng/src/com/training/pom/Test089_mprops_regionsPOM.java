/* Test case RETC089 - To verify whether application allows admin to create multiple  property details based on the Region created. */
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

public class Test089_mprops_regionsPOM {

	private WebDriver driver;

	public Test089_mprops_regionsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;
	//Regions link
	@FindBy(xpath="//a[contains(text(),'Regions')]")
	private WebElement clickRegions;
	//Name textbox
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement name;
	//Slug
	@FindBy(xpath = "//input[@id='tag-slug']")
	private WebElement slug;
	// div containing all parent regions
	@FindBy(xpath = "//div[@class='form-field term-parent-wrap']")
	private WebElement parentRegions;
	//Description textbox 
	@FindBy(xpath = "//textarea[@id='tag-description']")
	private WebElement description;
	//Add New Region button
	@FindBy(xpath = "//input[@id='submit']")
	private WebElement addNewRbutton;
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
	// div containing all features
	@FindBy(xpath = "//div[@id='region-all']")
	private WebElement allRegions;
	// publish button
	@FindBy(xpath = "//INPUT[@id='publish']")
	private WebElement publish;
	// confirmation message
	@FindBy(xpath = "//div[@id='message']//p")
	private WebElement confirmationMessage;
	
	public void clickProperties() {
		// click Properties link
		this.clickProps.click();
	}

	public void clickRegions() {
		// click Regions link
		this.clickRegions.click();
	}

	public void enterName(String name) {
		// enter text in Name textbox
		this.name.sendKeys(name);
	}

	public void enterSlug(String slug) {
		// enter text in slug textbox
		this.slug.sendKeys(slug);
	}

	public void selectParentRegion(String pRegion) {
		// Select valid details in Parent Region list box

		List<WebElement> allRegions = this.parentRegions.findElements(By.tagName("option"));
		for (WebElement region : allRegions) {
			String regionText = region.getText().trim();
			// System.out.println("Region is: " + regText);
			if (regionText.equalsIgnoreCase(pRegion)) {
				region.click();
				break;
			}
		}
	}

	public void enterDescription(String description) {
		// enter description in description textbox
		this.description.sendKeys(description);
	}

	public void addRegion() {
		// click on Add new Region button
		this.addNewRbutton.click();
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

	// Select the created Region
	public void selectCreatedRegion(String selectedRegion) {
		List<WebElement> regions = this.allRegions
				.findElements(By.xpath("//div[@id='region-all']//label[@class='selectit']"));
		for (WebElement region : regions) {
			String myRegion = region.getText().trim();
			// System.out.println(myFeature);
			if (myRegion.equals(selectedRegion)) {
				//System.out.println("Feature is" + myFeature);
				region.click();
				break;
			}
		}

	}

	public void WaitPublish() {
		this.publish.sendKeys(Keys.ARROW_UP);
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(publish));
	}

	public void clickPublish() {
		// click on Publish button
		
		this.publish.click();
	}

	public String confirmationMessage() {
		// get the text of the confirmation message after clicking on Publish
		// button
		String expected = confirmationMessage.getText();
		return expected;
	}

}