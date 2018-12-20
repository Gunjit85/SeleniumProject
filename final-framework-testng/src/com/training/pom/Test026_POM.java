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
	
	@FindBy(xpath="//DIV[@class='wp-menu-image dashicons-before dashicons-admin-multisite']/self::DIV")
	private WebElement clickProps;
	
	@FindBy(xpath="//A[@href='edit.php?post_type=property'][text()='All Properties']/self::A")
	private WebElement clickAllProps;
	
	@FindBy(xpath="//input[@id='cb-select-703']")
	private WebElement checkbox;
	
	@FindBy(xpath="//select[@id='bulk-action-selector-top']")
	private WebElement bulkActions;
	
	    public void mouseHoverProperties(){
		Actions action = new Actions(driver);
		action.moveToElement(clickProps).build().perform();
		}
	    
	    public void allProperties(){
	    	clickAllProps.click();
	    }
	    
	    public void clickcheckbox(){
	    	checkbox.click();
	    }
	    
	    public void uncheck(){
	    	checkbox.click();
	    }
	    public void clickBulkActions(){
	    	Select bulk = new Select(bulkActions);
	    	bulk.selectByVisibleText("Approve Properties");
	    }
}



