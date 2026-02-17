package com.SwagLabsUITest.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P2_InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== Constructor =====
    public P2_InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ===== Product count =====
    @FindBy(className = "inventory_item_name")
    private List<WebElement> products;

    public int getProductCount() {
        return products.size();
    }

    // ===== Single product name =====
    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Bike Light']")
    private WebElement bikeLightProductName;

    public String bikeLightProductName() {
        return bikeLightProductName.getText();
    }

    // ===== Add to cart button =====
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartBtn;

    public void clickOnAddToCart() {

        // wait until clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

        addToCartBtn.click();

        // wait until text changes to "Remove"
        //wait.until(ExpectedConditions.textToBePresentInElement(addToCartBtn, "Remove"));

       // return addToCartBtn.getText(); // returns "Remove"
        wait.until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.id("remove-sauce-labs-bike-light")
            ));
    }

    // ===== All product names =====
    @FindBy(xpath = "//div[@class='inventory_list']//div//a//div")
    private List<WebElement> listOfProductsName;

    public List<String> getAllProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement product : listOfProductsName) {
            names.add(product.getText());
        }
        return names;
    }
}
