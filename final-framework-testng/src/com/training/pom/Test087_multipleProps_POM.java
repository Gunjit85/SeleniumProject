/* Test case RETC087 - To verify whether application allows admin to create multiple property details based on the Feature created. */
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

public class Test087_multipleProps_POM {
	private WebDriver driver;

	public Test087_multipleProps_POM(WebDriver driver) {
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
	// div containing all parent features
	@FindBy(xpath = "//div[@class='form-field term-parent-wrap']")
	private WebElement parentFeatures;
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
	// div containing all features
	@FindBy(xpath = "//div[@id='property_feature-all']")
	private WebElement allFeatures;
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

	public void selectParentFeature(String pFeature) {
		// Select valid details in Parent Feature list box

		List<WebElement> allFeatures = this.parentFeatures.findElements(By.tagName("option"));
		for (WebElement feature : allFeatures) {
			String featureText = feature.getText().trim();
			// System.out.println("Region is: " + regText);
			if (featureText.equalsIgnoreCase(pFeature)) {
				feature.click();
				break;
			}
		}
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
	public void selectCreatedFeature(String selectedFeature) {
		List<WebElement> features = this.allFeatures
				.findElements(By.xpath("//div[@id='property_feature-all']//label[@class='selectit']"));
		for (WebElement feature : features) {
			String myFeature = feature.getText().trim();
			// System.out.println(myFeature);
			if (myFeature.equals(selectedFeature)) {
				System.out.println("Feature is" + myFeature);
				feature.click();
				break;
			}
		}

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

	public String confirmationMessage() {
		// get the text of the confirmation message after clicking on Publish
		// button
		String expected = confirmationMessage.getText();
		return expected;
	}

}