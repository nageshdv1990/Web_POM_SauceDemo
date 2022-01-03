package com.qa.saucelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Errors;

public class YourCart_InformationPage {

    private final WebDriver driver;

    By text_pageHeader = By.xpath("//div[@class='header_secondary_container']/span");
    By button_continue = By.id("continue");
    By edit_firstName = By.id("first-name");
    By edit_lastName = By.id("last-name");
    By edit_postalCode = By.id("postal-code");

    public YourCart_InformationPage(WebDriver driver){
        this.driver = driver;
    }

    public void validatePageHeaderTitle(){
        String pageHeader = driver.findElement(text_pageHeader).getText();
        System.out.println("Page Header Tiltle -->"+pageHeader);
        Assert.assertEquals(pageHeader, Constants.YOURCART_HEADER_TITLE, Errors.TITLE_ERROR_MESSAGE);
    }

    public void putFirstName(String firstName){
        driver.findElement(edit_firstName).sendKeys(firstName);
    }

    public void putLastName(String lastName){
        driver.findElement(edit_lastName).sendKeys(lastName);
    }

    public void putPostalCode(String postCode){
        driver.findElement(edit_postalCode).sendKeys(postCode);
    }

    public void putInformation(String firstName, String lastName, String postalCode){
        putFirstName(firstName);
        putLastName(lastName);
        putPostalCode(postalCode);
    }

    public YourCart_CheckoutOverviewPage clickContinue(){
        driver.findElement(button_continue).click();
        return new YourCart_CheckoutOverviewPage(driver);
    }
}
