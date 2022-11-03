package com.A101.step_definitions;

import com.A101.pages.FinalCasePage;
import com.A101.utilities.BrowserUtils;
import com.A101.utilities.ConfigurationReader;
import com.A101.utilities.Driver;
import com.A101.utilities.Log;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FinalCase {


    FinalCasePage page = new FinalCasePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
    Log log = new Log();

    @Given("user navigate home page")
    public void user_navigate_home_page() {
        log.startTestCase("A101 Final Case");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        log.info("Base page navigated");
        page.acceptCookies.click();
        log.info("Cookies accepted");

    }
    @When("user enter mail and password in login page and display they profile name {string} on homepage")
    public void user_login_page(String profileName) {
        BrowserUtils.hover(page.profileDropBox);
        page.loginButtonOnDropBox.click();
        log.info("Login button clicked");
        page.emailBox.sendKeys(ConfigurationReader.getProperty("email"));
        log.info("Email entered");
        page.loginButtonUnderMail.click();
        page.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        log.info("Password entered");
        page.loginButtonUnderPassword.click();
        wait.until(ExpectedConditions.visibilityOf(page.profileName.get(0)));
        Assert.assertTrue(page.profileName.get(0).isDisplayed());
        Assert.assertTrue(page.profileName.get(1).getText().contains(profileName));
        log.info("Profile name confirmed");

    }
    @When("user enter {string} the name of the item they wish to buy in the search box")
    public void user_enter_the_name_of_the_item_they_wish_to_buy_in_the_search_box(String itemName) {

        page.searchBox.sendKeys(itemName);
        log.info("Item name entered");
        page.searchButton.click();

    }

    String itemName;
    @When("user select {int} th item on the page")
    public void user_select_one_item_on_the_page(int itemNumber) {

        page.selectItem(itemNumber).click();
        log.info("Item selected");
        BrowserUtils.switchToWindow(page.selectItem(itemNumber).getText());
        itemName = page.productName.getText();

    }

    @When("user add two item from {int} seller and {int} seller to cart")
    public void user_add_two_item_from_different_seller_to_cart(int firstSeller, int secondSeller) {

       //If item has not more than 1 sellers, test fail
        if(Integer.parseInt(page.sellersCount.getText())<=1){
            log.warn("There are no more than 1 seller for this item. Pls select another one." + page.sellersCount);
        }
        Assert.assertTrue(Integer.parseInt(page.sellersCount.getText())>1);
        BrowserUtils.scrollToElement(page.sellers);
        page.sellers.click();
        log.info("Sellers displayed");

        //if selected sellers number more than item's sellers, test fail
        if(page.addToBasketButtons.size()>=firstSeller && page.addToBasketButtons.size()>=secondSeller){
            page.addToBasketButtons.get(firstSeller-1).click();

            page.xButton.click();
            page.addToBasketButtons.get(secondSeller-1).click();
        }else{
            log.error("There are not as many sellers as the number of sellers entered.");
            Assert.assertTrue(page.addToBasketButtons.size()>=firstSeller && page.addToBasketButtons.size()>=secondSeller);
        }


    }

    @Then("user display correct item on the Sepetim page")
    public void user_display_correct_item_on_the_sepetim_page() {
        page.shoppingCartButton.click();
        log.info("Cart page displayed");

        Assert.assertTrue(page.itemNames.get(0).getText().contains(itemName));
        Assert.assertTrue(page.itemNames.get(1).getText().contains(itemName));
        Assert.assertTrue(Integer.parseInt(page.itemCount.getText())>1);
        Assert.assertNotEquals(page.sellersNames.get(0).getText(),page.sellersNames.get(1).getText());
        log.info("Confirmed that two item from two diffrent sellers have been added to the cart");
    }

    @When("user does not login to the page")
    public void userDoesNotLoginToThePage() {

        Assert.assertEquals("Giriş Yap",page.signIn.getText());
        log.info("Confirmed that no sign in");


    }
}
