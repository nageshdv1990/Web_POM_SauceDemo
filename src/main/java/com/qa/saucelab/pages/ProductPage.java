package com.qa.saucelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Errors;

public class ProductPage {

    private final WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    private final By text_products = By.xpath("//div[@class=\"header_secondary_container\"]/span");
    private final By text_itemName = By.xpath("//div[@class=\"inventory_item_name\"]");
    private final By link_shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private final By text_pageHeader = By.xpath("//span[@class='title']");

    public void clickAddToCart(String productName){
        String productNameId = "add-to-cart-" + productName.toLowerCase().replace(' ', '-');
        System.out.println(productName+"----->"+productNameId);
        driver.findElement(By.id(productNameId)).click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public YourCartPage clickOnShoppingCart(){
        driver.findElement(link_shoppingCart).click();
        return new YourCartPage(driver);
    }

    public void validatePageHeaderTitle(){
        String pageHeader = driver.findElement(text_pageHeader).getText();
        System.out.println("Page Header Tiltle -->"+pageHeader);
        Assert.assertEquals(pageHeader, Constants.PRODUCTSPAGE_HEADER_TITLE, Errors.TITLE_ERROR_MESSAGE);
    }
}
