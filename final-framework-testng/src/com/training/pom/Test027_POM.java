package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test027_POM {
	private WebDriver driver;

	public Test027_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;

	@FindBy(xpath = "//a[contains(text(),'Features')]")
	private WebElement features;

	@FindBy(id = "tag-name")
	private WebElement name;

	@FindBy(id = "tag-slug")
	private WebElement slug;

	@FindBy(id = "tag-description")
	private WebElement description;

	@FindBy(id = "submit")
	private WebElement submit;
	
	@FindBy(id="tag-search-input")
	private WebElement srchbox;
	
	@FindBy(id="search-submit")
	private WebElement srchFeatures;

	@FindBy(xpath = "//a[@class='row-title']")
	private WebElement featureDisplayed;

	public void clickProperties() {
		Actions action = new Actions(driver);
		action.moveToElement(clickProps).build().perform();
		clickProps.click();
	}
	public void clickFeatures() {
		features.click();
	}
	public void enterName() {
		name.sendKeys("New Launches");
	}
	public void enterSlug() {
		slug.sendKeys("launch");
	}
	public void enterDescription() {
		description.sendKeys("New Launches of vilas, apartments, flats");
	}
	public void addFeature() {
		submit.click();
	}
	public void enterText(){
		srchbox.sendKeys("New launches");
	}
	public void searchFeatures(){
		srchFeatures.click();
	}
	public String existingFeature() {
		String expected = featureDisplayed.getText();
		return expected;
	}
}
