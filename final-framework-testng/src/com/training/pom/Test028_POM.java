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
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;
	//Features link
	@FindBy(xpath = "//a[contains(text(),'Features')]")
	private WebElement features;
	//checkbox of tag to be deleted
	@FindBy(name="delete_tags[]")
	private WebElement checkbox;
	//bulk actions listbox
	@FindBy(xpath="//select[@id='bulk-action-selector-top']")
	private WebElement bulkActions;
	//apply button
	@FindBy(xpath="//input[@id='doaction']")
	private WebElement apply;
	//text after deleting the feature
	@FindBy(xpath="//p[contains(text(),'Items deleted.')]")
	private WebElement featureRemoved;
	
	public void clickProperties() {
		//Click on Properties link
		clickProps.click();
	}
	public void clickFeatures() {
		//Click on features link
		features.click();
	}
	public void checkCheckbox(){
		//click on checkbox of tag to be deleted
		checkbox.click();
	}
	public void deleteFeature(){
		//click on bulk actions listbox
		Select bulk = new Select(bulkActions);
		//select the Delete option
		bulk.selectByIndex(1);
	}
	public void clickApply(){
		//click on apply button
		apply.click();
	}
	public String existingFeature() {
		//get the text of the message displayed after deleting the feature
		String expected = featureRemoved.getText();
		return expected;
	}

}
