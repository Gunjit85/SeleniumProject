package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPOM {
private WebDriver driver; 
	
	public CustomerPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	// LOGIN/REGISTER button
	@FindBy(xpath="//a[@class='sign-in']")
	private WebElement login;
	// username
	@FindBy(id="user_login")
	private WebElement userName; 
	// password
	@FindBy(name="pwd")
	private WebElement password;
	//SignIn button
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	public void clickLogin(){
		this.login.click();	//click on login/register button
	}
	
	    public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);	//enter username
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 	//enter password
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 	//click on login button
	}
	
	}



