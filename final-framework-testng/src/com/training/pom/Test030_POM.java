package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Test030_POM {
	private WebDriver driver;

	public Test030_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;
	//Regions link
	@FindBy(xpath = "//a[contains(text(),'Regions')]")
	private WebElement regions;
	//search textbox
	@FindBy(xpath = "//input[@id='tag-search-input']")
	private WebElement searchtextbox;
	//search regions button
	@FindBy(id = "search-submit")
	private WebElement searchRegions;
	//checkbox of tag to be deleted
	@FindBy(name = "delete_tags[]")
	private WebElement checkbox;
	//bulkActions listbox
	@FindBy(xpath = "//select[@id='bulk-action-selector-top']")
	private WebElement bulkActions;
	//Apply button
	@FindBy(xpath = "//input[@id='doaction']")
	private WebElement apply;
	//message after deleting selected region
	@FindBy(xpath = "//p[contains(text(),'Items deleted.')]")
	private WebElement regionRemoved;

	public void clickProperties() {
		// click Properties
		clickProps.click();
	}

	public void clickRegions() {
		//click Regions
		regions.click();
	}

	public void enterText() {
		//enter text in searchbox
		searchtextbox.sendKeys("New Launches");
	}

	public void searchRegions() {
		//click on search button
		searchRegions.click();
	}

	public void checkCheckbox() {
		//click on checkbox of region to be deleted
		checkbox.click();
	}

	public void deleteRegion() {
		//select delete option from bulkActions listbox
		Select bulk = new Select(bulkActions);
		bulk.selectByIndex(1);
	}
	public void clickApply() {
		//click on Apply button
		apply.click();
	}
	public String existingRegions() {
		//check for the message displayed after deleting region
		String expected = regionRemoved.getText();
		return expected;
	}

}
