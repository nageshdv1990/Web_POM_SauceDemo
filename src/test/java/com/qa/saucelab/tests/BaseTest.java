package com.qa.saucelab.tests;

import com.qa.saucelab.factory.DriverFactory;
import com.qa.saucelab.pages.LoginPage;
import com.qa.saucelab.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public DriverFactory df = null;
    public WebDriver driver = null;

    public LoginPage loginPage = null;
    public ProductPage productPage = null;

    public String productToBeAddedToCart = "Sauce Labs Onesie";
    public String firstName = "testerfn";
    public String lastName = "testerln";
    public String postalCode = "95035";

    @BeforeTest
    public void setup(){
        df =new DriverFactory();
        driver = df.initDriver("Edge");
        loginPage = new LoginPage(driver);
        System.out.println(loginPage.getTitle());
       // productPage.clickAddToCart("Sauce Labs Onesie");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
