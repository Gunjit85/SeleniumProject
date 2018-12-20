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

	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;

	@FindBy(xpath = "//a[contains(text(),'Regions')]")
	private WebElement regions;
	
	@FindBy(id="tag-name")
	private WebElement name;
	
	@FindBy(id = "tag-slug")
	private WebElement slug;
	
	@FindBy(xpath="//select[@id='parent']")
	private WebElement parentRegion;
	
	@FindBy(id = "tag-description")
	private WebElement description;

	@FindBy(id = "submit")
	private WebElement submit;
	
	@FindBy(xpath="//input[@id='tag-search-input']")
	private WebElement searchtextbox;
	
	@FindBy(id="search-submit")
	private WebElement searchRegions;
	
	@FindBy(xpath = "//a[@class='row-title']")
	private WebElement regionDisplayed;

	public void clickProperties() {
		//Actions action = new Actions(driver);
		//action.moveToElement(clickProps).build().perform();
		clickProps.click();
	}
	public void clickRegions() {
		regions.click();
	}
	public void enterName() {
		name.sendKeys("New Launches");
	}

	public void enterSlug() {
		slug.sendKeys("launch");
	}
	public void clickParentRegion(){
		Select region = new Select(parentRegion);
		region.selectByIndex(0);
		}
	public void enterDescription() {
		description.sendKeys("New Launches of vilas, apartments, flats");
	}
	public void addRegion() {
		submit.click();
	}
	public void enterText(){
		searchtextbox.sendKeys("New launches");
	}
	public void searchRegions(){
		searchRegions.click();
	}
	public String existingRegions() {
		String expected = regionDisplayed.getText();
		return expected;
	}
}
