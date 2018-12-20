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

	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;

	@FindBy(xpath = "//a[contains(text(),'Regions')]")
	private WebElement regions;

	@FindBy(xpath = "//input[@id='tag-search-input']")
	private WebElement searchtextbox;

	@FindBy(id = "search-submit")
	private WebElement searchRegions;

	@FindBy(name = "delete_tags[]")
	private WebElement checkbox;

	@FindBy(xpath = "//select[@id='bulk-action-selector-top']")
	private WebElement bulkActions;

	@FindBy(xpath = "//input[@id='doaction']")
	private WebElement apply;

	@FindBy(xpath = "//p[contains(text(),'Items deleted.')]")
	private WebElement regionRemoved;

	public void clickProperties() {
		// Actions action = new Actions(driver);
		// action.moveToElement(clickProps).build().perform();
		clickProps.click();
	}

	public void clickRegions() {
		regions.click();
	}

	public void enterText() {
		searchtextbox.sendKeys("New Launches");
	}

	public void searchRegions() {
		searchRegions.click();
	}

	public void checkCheckbox() {
		checkbox.click();
	}

	public void deleteRegion() {
		Select bulk = new Select(bulkActions);
		bulk.selectByIndex(1);
	}
	public void clickApply() {
		apply.click();
	}
	public String existingRegions() {
		String expected = regionRemoved.getText();
		return expected;
	}

}
