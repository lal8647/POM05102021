package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver;
	
	//1. By locators:OR
	
	private By emailId= By.id("username");
	private By password=By.id("password");
	private By loginButton= By.id("");
	private By signUpLink=By.linkText("Sign up");
	
	//2. Constructor of the page class:
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Page actions: Feature/Behavior of the page in the form methods
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isSignUpLinkExist() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public void doLogin(String un, String pwd) {
		
		System.out.println("login with : " + un + "and" +pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
