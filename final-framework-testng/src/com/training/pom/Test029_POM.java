package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Test029_POM {
	private WebDriver driver;

	public Test029_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;
	//Regions link
	@FindBy(xpath = "//a[contains(text(),'Regions')]")
	private WebElement regions;
	//Name textbox
	@FindBy(id="tag-name")
	private WebElement name;
	//Slug textbox
	@FindBy(id = "tag-slug")
	private WebElement slug;
	//Parent region
	@FindBy(xpath="//select[@id='parent']")
	private WebElement parentRegion;
	//description textbox
	@FindBy(id = "tag-description")
	private WebElement description;
	//Add New Region button
	@FindBy(id = "submit")
	private WebElement submit;
	//search textbox
	@FindBy(xpath="//input[@id='tag-search-input']")
	private WebElement searchtextbox;
	//search regions button
	@FindBy(id="search-submit")
	private WebElement searchRegions;
	//first element in the search results
	@FindBy(xpath = "//a[@class='row-title']")
	private WebElement regionDisplayed;

	public void clickProperties() {
		//User click on Properties
		clickProps.click();
	}
	public void clickRegions() {
		//Click on Regions
		regions.click();
	}
	public void enterName() {
		//enter text in name textbox
		name.sendKeys("New Launches");
	}

	public void enterSlug() {
		//enter text in slug textbox
		slug.sendKeys("launch");
	}
	public void clickParentRegion(){
		//click on ParentRegion dropdown and select none
		Select region = new Select(parentRegion);
		region.selectByIndex(0);
		}
	public void enterDescription() {
		//enter text in description textbox
		description.sendKeys("New Launches of vilas, apartments, flats");
	}
	public void addRegion() {
		//click on Add new Region button
		submit.click();
	}
	public void enterText(){
		//enter text in search textbox
		searchtextbox.sendKeys("New launches");
	}
	public void searchRegions(){
		//click on search regions button
		searchRegions.click();
	}
	public String existingRegions() {
		//check for the Newly added region
		String expected = regionDisplayed.getText();
		return expected;
	}
}
