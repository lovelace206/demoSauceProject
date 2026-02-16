package com.SwagLabsUITest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P1_LoginPage {

    private WebDriver driver;

    public P1_LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public String getAppurl() {
        return driver.getCurrentUrl();
    }

    public String getAppTitle() {
        return driver.getTitle();
    }

    public P1_LoginPage setUserName(String un) {
    	username.clear();
        username.sendKeys(un);
        return this;
    }

    public P1_LoginPage setPassword(String pwd) {
    	password.clear();
        password.sendKeys(pwd);
        return this;
    }

    public P2_InventoryPage ClickonLoginBtton() {
        loginBtn.click();
        return new P2_InventoryPage(driver);
    }
}
