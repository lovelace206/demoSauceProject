package com.SwagLabsUITest.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SwagLabsUITest.Base.BaseClass;

public class Tc1_LoginTest extends BaseClass {

    @Test(priority = 1)
    public void verifyUrl() {
        Assert.assertTrue(lp.getAppurl().contains("saucedemo.com"));
    }

    @Test(priority = 2)
    public void VerifyTitle() {
        Assert.assertEquals(lp.getAppTitle(), "Swag Labs");
    }

    @Test(priority = 3, dataProvider = "loginData")
    public void VerifyLogin(String username, String password, String expectedResult) {
       lp.setUserName(username)
                   .setPassword(password)
                   .ClickonLoginBtton();

        if (expectedResult.equals("valid")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        } else {
            Assert.assertFalse(driver.getCurrentUrl().contains("inventory.html"));
        }
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
        	    {"anand", "secret_sauce", "invalid"},
                {"standard_user", "wrong", "invalid"},
                {"", "", "invalid"},
                {"standard_user", "secret_sauce", "valid"}
                
        };
    }
}
