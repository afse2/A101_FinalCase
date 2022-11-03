package com.A101.pages;

import com.A101.utilities.BrowserUtils;
import com.A101.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FinalCasePage extends BasePage {

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;

    @FindBy(id = "myAccount")
    public WebElement profileDropBox;

    @FindBy(id = "login")
    public WebElement loginButtonOnDropBox;

    @FindBy(name = "username")
    public WebElement emailBox;

    @FindBy(id = "btnLogin")
    public WebElement loginButtonUnderMail;

    @FindBy(id = "btnEmailSelect")
    public WebElement loginButtonUnderPassword;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//a[@title=\"Hesabım\"]//span")
    public List<WebElement> profileName;

    @FindBy(xpath = "//input[@placeholder=\"Ürün, kategori veya marka ara\"]")
    public WebElement searchBox;

    @FindBy(className = "SearchBoxOld-cHxjyU99nxdIaAbGyX7F")
    public WebElement searchButton;

    @FindBy(xpath = "//li[@class=\"productListContent-zAP0Y5msy8OHn5z7T_K_\"]")
    public List<WebElement> items;

    @FindBy(xpath = "(//span[@class=\"campaignText\"])[2]")
    public WebElement sellers;

    @FindBy(xpath = "(//span[@class=\"number\"])[2]")
    public WebElement sellersCount;

    @FindBy(xpath = "(//span[@class=\"merchantLink_2Ii8s\"])//a")
    public List<WebElement> sellersNames;

    @FindBy(xpath = "//span[@id=\"basket-item-count\"]")
    public WebElement itemCount;

    @FindBy(xpath = "//div[@class=\"product_name_3Lh3t\"]//a")
    public List<WebElement> itemNames;

    @FindBy(xpath = "//h1[@itemprop=\"name\"]")
    public WebElement productName;

    @FindBy(xpath = "//button[@class=\"add-to-basket button\"]")
    public List<WebElement> addToBasketButtons;

    @FindBy(xpath = "//a[@class=\"checkoutui-Modal-iHhyy79iR28NvF33vKJb\"]")
    public WebElement xButton;

    @FindBy(id = "shoppingCart")
    public WebElement shoppingCartButton;

    @FindBy(xpath = "//span[@title=\"Giriş Yap\"]")
    public WebElement signIn;

    public WebElement selectItem(int numberOfItem) {
        int itemIndex = numberOfItem - 1;

        int itemOnPage = items.size() - 1;

        int scroolCount = itemIndex/itemOnPage;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);


        if(itemIndex>itemOnPage){

            for (int k = 1; k <=scroolCount ; k++) {
                BrowserUtils.scrollToElement(Driver.getDriver().findElement(By.id("i" + (itemOnPage*k))));

                wait.until(ExpectedConditions.elementToBeClickable(Driver.getDriver().findElement(By.id("i" + (itemOnPage*k)))));
            }

            BrowserUtils.scrollToElement(Driver.getDriver().findElement(By.id("i" + itemIndex)));

        }

        return Driver.getDriver().findElement(By.id("i" + itemIndex));
    }
}
