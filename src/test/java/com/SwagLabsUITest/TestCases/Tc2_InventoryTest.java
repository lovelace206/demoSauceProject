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

//    @Test(priority = 3)
//   public void verifyAddToCart() {
//      pi.clickOnAddToCart();
//      String buttonTextAfterClick = pi.getAddToCartButtonText();
//       Assert.assertEquals(buttonTextAfterClick, "Add to cart");
//       System.out.println("Product added to cart successfully");
//  
//   
//}

    

    @Test(priority = 4)
    public void verifyAllProductNames() {
        List<String> productNames = pi.getAllProductNames();

        Assert.assertTrue(productNames.size() > 0, "Product list is empty");

        System.out.println("Products available:");
        for (String name : productNames) {
            System.out.println(name);
        }
    }
//    @Test(priority = 5, dependsOnMethods = "verifyAllProductNames")
//    public void verifyAddToCartButtonTextChanges() {
//
//        pi.clickOnAddToCart();
//
//        String buttonText = pi.getAddToCartButtonText();
//
//        Assert.assertEquals(
//                buttonText,
//                "Remove",
//                "Button text did not change to Remove"
//        );
//
//        System.out.println("Add to Cart button text changed to Remove");
//    }

        
    
@Test(priority = 6)
public void verifyBikeLightProductIsDisplayed() {

    Assert.assertTrue(
            pi.isBikeLightProductDisplayed(),
            "Bike Light product is not visible on inventory page"
    );

    System.out.println("Bike Light product is displayed");
}

@Test(priority = 7)
public void verifyAllProductsAreDisplayed() {

    Assert.assertTrue(
            pi.areAllProductsDisplayed(),
            "One or more products are not displayed properly"
    );

    System.out.println("All products are displayed correctly");
}
@Test(priority = 8)
public void verifyFirstProductNameIsNotEmpty() {

    String firstProductName = pi.getFirstProductName();

    Assert.assertFalse(
            firstProductName.trim().isEmpty(),
            "First product name is empty"
    );

    System.out.println("First product name: " + firstProductName);
}
@Test(priority = 9)
public void verifyProductCountMatchesProductNameList() {

    int countFromMethod = pi.getProductCount();
    int countFromNamesList = pi.getProductNamesCount();

    Assert.assertEquals(
            countFromMethod,
            countFromNamesList,
            "Product count mismatch between methods"
    );

    System.out.println("Product count matches product name list size");
}

}


