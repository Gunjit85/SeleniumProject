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
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;
	//Features link
	@FindBy(xpath = "//a[contains(text(),'Features')]")
	private WebElement features;
	//Name texbox
	@FindBy(id = "tag-name")
	private WebElement name;
	//Slug textbox
	@FindBy(id = "tag-slug")
	private WebElement slug;
	//Description textbox
	@FindBy(id = "tag-description")
	private WebElement description;
	//add new feature button
	@FindBy(id = "submit")
	private WebElement submit;
	//search box to enter text
	@FindBy(id="tag-search-input")
	private WebElement srchbox;
	//search features button
	@FindBy(id="search-submit")
	private WebElement srchFeatures;
	//first row element in the search results
	@FindBy(xpath = "//a[@class='row-title']")
	private WebElement featureDisplayed;
	
	public void clickProperties() {
		//click Properties link
		clickProps.click();	
	}
	public void clickFeatures() {
		//click Features link
		features.click();	
	}
	public void enterName() {
		//enter text in Name textbox
		name.sendKeys("New Launches");	
	}
	public void enterSlug() {
		//enter text in slug textbox
		slug.sendKeys("launch");	
	}
	public void enterDescription() {
		//enter description in description textbox
		description.sendKeys("New Launches of vilas, apartments, flats");	
	}
	public void addFeature() {
		//click on Add new Feature button
		submit.click();	
	}
	public void enterText(){
		//enter text in search textbox to search the new feature added
		srchbox.sendKeys("New launches");	
	}
	public void searchFeatures(){
		//click on search features button
		srchFeatures.click();	
	}
	public String existingFeature() {
		//get the text of the element displayed
		String expected = featureDisplayed.getText();	
		return expected;								
	}
}
