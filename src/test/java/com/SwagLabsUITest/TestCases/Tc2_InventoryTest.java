package com.SwagLabsUITest.TestCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SwagLabsUITest.Base.BaseClass;

public class Tc2_InventoryTest extends BaseClass {

    @Test(priority = 1)
    public void verifyProductCount() {
        int actcount = pi.getProductCount();
        Assert.assertEquals(actcount, 6, "Product count mismatch");
        System.out.println("Total Product count matched: " + actcount);
    }

    @Test(priority = 2)
    public void verifyBikeLightProductName() {
        String actualName = pi.bikeLightProductName();
        Assert.assertEquals(actualName, "Sauce Labs Bike Light");
        System.out.println("Bike Light product name verified");
    }

    //@Test(priority = 3)
   // public void verifyAddToCart() {
      //  String buttonTextAfterClick = pi.clickOnAddToCart();
       //// Assert.assertEquals(buttonTextAfterClick, "Add to cart");
       // System.out.println("Product added to cart successfully");
  
   // public void verifyAddToCart() {

        // Action
      //  pi.clickOnAddToCart();

        // Assertion: Remove button should be visible
        //boolean isRemoveBtnVisible = driver
//            .findElement(org.openqa.selenium.By.id("remove-sauce-labs-bike-light"))
//            .isDisplayed();
//
//        Assert.assertTrue(isRemoveBtnVisible, "Remove button not visible after add to cart");
//
//        System.out.println("Product added to cart successfully");
//    }

    

    @Test(priority = 4)
    public void verifyAllProductNames() {
        List<String> productNames = pi.getAllProductNames();

        Assert.assertTrue(productNames.size() > 0, "Product list is empty");

        System.out.println("Products available:");
        for (String name : productNames) {
            System.out.println(name);
        }
    }
}
