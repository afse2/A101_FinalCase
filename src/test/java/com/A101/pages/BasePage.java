package com.A101.pages;

import com.A101.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

public BasePage(){PageFactory.initElements(Driver.getDriver(),this);}
}
