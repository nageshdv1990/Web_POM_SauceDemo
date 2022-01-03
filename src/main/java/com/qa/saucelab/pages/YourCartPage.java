package com.qa.saucelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Errors;

public class YourCartPage {
    private final WebDriver driver;
    
    private By text_pageHeader = By.xpath("//span[@class='title']");
    private By text_itemInCart = By.xpath("//div[@class='inventory_item_name']");
    private By button_checkOut = By.id("checkout");
    private By button_remove = By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");
    private By list_cartItems = By.xpath("//div[@class='cart_item']");

    public YourCartPage(WebDriver driver){
        this.driver = driver;
    }
    public void validatePageHeaderTitle(){
        String pageHeader = driver.findElement(text_pageHeader).getText();
        System.out.println("Page Header Tiltle -->"+pageHeader);
        Assert.assertEquals(pageHeader, Constants.YOURCART_HEADER_TITLE, Errors.TITLE_ERROR_MESSAGE);
    }

    public void validateItemInCart(String productAddedToCart){
        String itemInCart = driver.findElement(text_itemInCart).getText();
        System.out.println(itemInCart);
        Assert.assertEquals(itemInCart,productAddedToCart,Errors.CART_ERROR_MESSAGE);
    }

    public YourCart_InformationPage clickOnCheckout(){
        driver.findElement(button_checkOut).click();
        return new YourCart_InformationPage(driver);
    }

    public void clickOnRemoveFromCartAndValidate(){
        int numberOfItemsInCartBefore = driver.findElements(list_cartItems).size();
        driver.findElement(button_remove).click();
        int numberOfItemsInCartAfter = driver.findElements(list_cartItems).size();
        System.out.println("Before -->"+numberOfItemsInCartBefore);
        System.out.println("After --> "+numberOfItemsInCartAfter);
        Assert.assertEquals(numberOfItemsInCartAfter,numberOfItemsInCartBefore-1,Errors.REMOVE_ITEM_FAILED);
    }


}
