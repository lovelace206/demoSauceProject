package com.SwagLabsUITest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P3_CartPage {
	private WebDriver driver;
public P3_CartPage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	
}

//Locators
@FindBy(id="")
WebElement cart;
//Method
}
