package com.qa.saucelab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Constants;
import utils.Errors;

public class LoginPage {
    private WebDriver driver = null;
    /*
    * Private By Locators
    * */
    private  By edit_userName = By.id("user-name");
    private  By edit_password = By.id("password");
    private  By button_login = By.id("login-button");
    private By text_errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void putUserName(String userName){
        driver.findElement(edit_userName).sendKeys(userName);
    }

    public void putPassword(String password){
        driver.findElement(edit_password).sendKeys(password);
    }

    public ProductPage clickLogin(){
        driver.findElement(button_login).click();
        return new ProductPage(driver);
    }

    public void checkIfUsernameErrorMessageValid(){
        driver.findElement(text_errorMessage).isDisplayed();
        String userNameErrorMessage = driver.findElement(text_errorMessage).getText();
        System.out.println("Username Error Message -->"+userNameErrorMessage);
        Assert.assertEquals(userNameErrorMessage, Constants.LOGIN_USERNAME_ERRORMESSAGE, Errors.USERNAME_ERROR_MESSAGE);
    }

}
