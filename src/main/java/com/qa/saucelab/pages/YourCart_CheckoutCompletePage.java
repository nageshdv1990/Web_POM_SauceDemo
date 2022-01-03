package com.qa.saucelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Errors;

public class YourCart_CheckoutCompletePage {

    private final WebDriver driver;

    public YourCart_CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
    }

    private final By text_pageHeader = By.xpath("//span[@class='title']");
    private final By text_completionMessage = By.xpath("//h2[@class='complete-header']");
    private final By button_backHome = By.id("back-to-products");

    public void validatePageHeaderTitle(){
        String pageHeader = driver.findElement(text_pageHeader).getText();
        System.out.println("Page Header Tiltle -->"+pageHeader);
        Assert.assertEquals(pageHeader, Constants.YOURCART_CHECKOUTCOMPLETEPAGE_HEADER_TITLE, Errors.TITLE_ERROR_MESSAGE);
    }

    public void validateCompletionMessage(){
        String completionMessage = driver.findElement(text_completionMessage).getText();
        System.out.println("Completion message -->"+completionMessage);
        Assert.assertEquals(completionMessage,Constants.YOURCART_CHECKOUTCOMPLETIONMESSAGE,Errors.TITLE_ERROR_MESSAGE);
    }

    public ProductPage clickBackHome(){
        driver.findElement(button_backHome).click();
        return new ProductPage(driver);
    }



}
