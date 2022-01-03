package com.qa.saucelab.tests;

import com.qa.saucelab.pages.YourCartPage;
import com.qa.saucelab.pages.YourCart_CheckoutCompletePage;
import com.qa.saucelab.pages.YourCart_CheckoutOverviewPage;
import com.qa.saucelab.pages.YourCart_InformationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;
import utils.Errors;

public class Tests extends BaseTest{



    @Test(priority = 1)
    public void addToCartAndCheckout() throws InterruptedException {
        loginPage.putUserName("standard_user");
        loginPage.putPassword("secret_sauce");
        productPage = loginPage.clickLogin();
        productPage.clickAddToCart(productToBeAddedToCart);
        productPage.validatePageHeaderTitle();
        YourCartPage yourCartPage = productPage.clickOnShoppingCart();
        yourCartPage.validatePageHeaderTitle();
        yourCartPage.validateItemInCart(productToBeAddedToCart);
        YourCart_InformationPage yourCart_informationPage = yourCartPage.clickOnCheckout();
        yourCart_informationPage.putInformation(firstName, lastName, postalCode);
        YourCart_CheckoutOverviewPage yourCart_checkoutOverviewPage = yourCart_informationPage.clickContinue();
        yourCart_checkoutOverviewPage.validatePageHeaderTitle();
        yourCart_checkoutOverviewPage.validateItemInCheckout(productToBeAddedToCart);
        YourCart_CheckoutCompletePage yourCart_checkoutCompletePage = yourCart_checkoutOverviewPage.clickFinish();
        yourCart_checkoutCompletePage.validatePageHeaderTitle();
        yourCart_checkoutCompletePage.validateCompletionMessage();
        productPage = yourCart_checkoutCompletePage.clickBackHome();
        productPage.validatePageHeaderTitle();
    }


    @Test(priority = 2)
    public void addItemAndRemoveItemFromCart(){
        loginPage.putUserName("standard_user");
        loginPage.putPassword("secret_sauce");
        productPage = loginPage.clickLogin();
        productPage.clickAddToCart(productToBeAddedToCart);
        productPage.validatePageHeaderTitle();
        YourCartPage yourCartPage = productPage.clickOnShoppingCart();
        yourCartPage.validatePageHeaderTitle();
        yourCartPage.validateItemInCart(productToBeAddedToCart);
        yourCartPage.clickOnRemoveFromCartAndValidate();
    }


    @Test(priority = 3)
    public void validateErrorMessage_negativeTest(){
        String title = loginPage.getTitle();
        System.out.println(title);
        loginPage.clickLogin();
        loginPage.checkIfUsernameErrorMessageValid();
    }




}
