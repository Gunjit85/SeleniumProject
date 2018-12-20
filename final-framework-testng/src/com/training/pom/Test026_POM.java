package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Test026_POM {

	private WebDriver driver;

	public Test026_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;

	@FindBy(xpath = "//a[@class='wp-first-item current']")
	private WebElement clickAllProps;

	//@FindBy(xpath = "//input[@id='cb-select-703']")
	@FindBy(name="post[]")
	private WebElement checkbox;

	@FindBy(xpath = "//SELECT[@id='bulk-action-selector-top']/self::SELECT")
	private WebElement bulkActions;

	@FindBy(id = "doaction")
	private WebElement apply;

	@FindBy(xpath = "//div[@id='message']//p")
	private WebElement message;

	public void clickProperties() {
		//Actions action = new Actions(driver);
		//action.moveToElement(clickProps).build().perform();
		clickProps.click();
	}

	public void allProperties() {
		clickAllProps.click();
	}

	public void clickcheckbox() {
		checkbox.click();
	}

	public void clickBulkActions() {
		Select bulk = new Select(bulkActions);
		bulk.selectByIndex(2);
	}

	public void clickApply() {
		apply.click();
	}

	public String message() {
		String expected = message.getText();
		return expected;
	}
}
