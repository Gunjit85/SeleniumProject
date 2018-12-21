/* Locating all the WebElements for RETC026 - User logins to the Retail application http://realestate.hommelle.com/
 * Credentials - username-admin; password - admin@123
 * Clicks on Properties link, then clicks on AllProperties link, select the first property displayed checkbox, move to BulkActions listbox
 * Select Move to trash option, click on Apply button next to the listbox. Once it is done, 1 post moved to the Trash. Undo  message 
 * should get displayed along with property details should be removed from the properties details */
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
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;
	//All properties link
	@FindBy(xpath = "//a[@class='wp-first-item current']")
	private WebElement clickAllProps;
	//checkbox for the first property in the list
	@FindBy(name="post[]")
	private WebElement checkbox;
	//bulkActions listbox
	@FindBy(xpath = "//SELECT[@id='bulk-action-selector-top']/self::SELECT")
	private WebElement bulkActions;
	//Apply button next to the listbox
	@FindBy(id = "doaction")
	private WebElement apply;
	//message displayed after deleting the property selected
	@FindBy(xpath = "//div[@id='message']//p")
	private WebElement message;

	public void clickProperties() {
		//click on Properties link
		clickProps.click();	
	}

	public void allProperties() {
		//click on All Properties link
		clickAllProps.click(); 
	}

	public void clickcheckbox() {
		//click on checkbox of the first property listed
		checkbox.click();
	}

	public void clickBulkActions() {
		//click on bulk actions listbox and select Move to trash
		Select bulk = new Select(bulkActions);
		bulk.selectByIndex(2);	
	}

	public void clickApply() {
		//click on apply button next to bulk actions listbox
		apply.click();	
	}

	public String message() {
		// get the text on the page after deleting the property
		String expected = message.getText();	
		return expected;	
	}
}
