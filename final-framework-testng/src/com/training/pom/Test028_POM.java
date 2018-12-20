package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Test028_POM {
	private WebDriver driver;

	public Test028_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;

	@FindBy(xpath = "//a[contains(text(),'Features')]")
	private WebElement features;
	
	@FindBy(name="delete_tags[]")
	private WebElement checkbox;
	
	@FindBy(xpath="//select[@id='bulk-action-selector-top']")
	private WebElement bulkActions;
	
	@FindBy(xpath="//input[@id='doaction']")
	private WebElement apply;
	
	@FindBy(xpath="//p[contains(text(),'Items deleted.')]")
	private WebElement featureRemoved;
	
	public void clickProperties() {
		//Actions action = new Actions(driver);
		//action.moveToElement(clickProps).build().perform();
		clickProps.click();
	}
	public void clickFeatures() {
		features.click();
	}
	public void checkCheckbox(){
		checkbox.click();
	}
	public void deleteFeature(){
		Select bulk = new Select(bulkActions);
		bulk.selectByIndex(1);
	}
	public void clickApply(){
		apply.click();
	}
	public String existingFeature() {
		String expected = featureRemoved.getText();
		return expected;
	}

}
