package com.qa.saucelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Errors;

public class YourCart_CheckoutOverviewPage {

    private final WebDriver driver;

    By text_pageHeader = By.xpath("//span[@class='title']");
    By text_productCheckedOut = By.xpath("//div[@class='inventory_item_name']");
    By button_finish = By.id("finish");

    public YourCart_CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }

    public void validatePageHeaderTitle(){
        String pageHeader = driver.findElement(text_pageHeader).getText();
        System.out.println("Page Header Tiltle -->"+pageHeader);
        Assert.assertEquals(pageHeader, Constants.YOURCARTINFORMATIONPAGE_HEADER_TITLE, Errors.TITLE_ERROR_MESSAGE);
    }

    public void validateItemInCheckout(String productAddedToCart){
        String productCheckedOut = driver.findElement(text_productCheckedOut).getText();
        System.out.println("Product Checkout -->"+productCheckedOut);
        Assert.assertEquals(productCheckedOut, productAddedToCart, Errors.CART_ERROR_MESSAGE);
    }

    public YourCart_CheckoutCompletePage clickFinish(){
        driver.findElement(button_finish).click();
        return new YourCart_CheckoutCompletePage(driver);
    }




}
