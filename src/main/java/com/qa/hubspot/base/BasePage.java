package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * 
 * @author Lal
 */
public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	/**
	 * This method is used to initialize the browser on the basis of given browser
	 * @param browser
	 * @return
	 */
	
	public WebDriver init_driver(String browser){
	
		System.out.println("browser value is : " +browser);
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("safari")) {
			driver= new SafariDriver();
		}
		else {
			System.out.println("Please pass the current browser value :"  +browser);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	/**
	 * This method is used to load the properties from config file
	 * @return it return Properties prop reference
	 */
	
	public Properties init_prop() {
		
		prop=new Properties();
		
		try {
			FileInputStream ip= new FileInputStream("/src/main/java/com/qa/hubspot/config/config.properties");
		     prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
	
	
}
