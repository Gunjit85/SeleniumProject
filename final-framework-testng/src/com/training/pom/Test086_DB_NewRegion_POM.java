/* Test case RETC086 - To Verify whether application allows admin to Add New Region in the application & 
 * added details should get displayed in database */

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Test086_DB_NewRegion_POM {
	private WebDriver driver;

	public Test086_DB_NewRegion_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Properties link
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement clickProps;
	
	public void clickProperties() {
		//User click on Properties
		this.clickProps.click();
	}
	
	//Regions link
	@FindBy(xpath = "//a[contains(text(),'Regions')]")
	private WebElement regions;
	
	public void clickRegions() {
		//Click on Regions
		this.regions.click();
	}
	
	//Name textbox
	@FindBy(id="tag-name")
	private WebElement name;
	
	public void enterName(String name) {
		//enter text in name textbox
		this.name.sendKeys(name);
	}
	
	public String getRegionName() {
		String expected = name.getAttribute("value");
		return expected;
	}

	//Slug textbox
	@FindBy(id = "tag-slug")
	private WebElement slug;
	
	public void enterSlug(String slug) {
		//enter text in slug textbox
		this.slug.sendKeys(slug);
	}
	public String getSlugName() {
		String expected = slug.getAttribute("value");
		return expected;
	}
	
	//Parent region
	@FindBy(xpath="//select[@id='parent']")
	private WebElement parentRegion;
	
	public void clickParentRegion(){
		//click on ParentRegion dropdown and select none
		Select region = new Select(parentRegion);
		region.selectByIndex(0);
		}
	
	//description textbox
	@FindBy(id = "tag-description")
	private WebElement description;
	
	public void enterDescription(String desc) {
		//enter text in description textbox
		this.description.sendKeys(desc);
	}
	public String getDescription() {
		String expected = description.getAttribute("value");
		return expected;
	}
	
	//Add New Region button
	@FindBy(id = "submit")
	private WebElement submit;
	
	public void addRegion() {
		//click on Add new Region button
		this.submit.click();
	}
	
}
