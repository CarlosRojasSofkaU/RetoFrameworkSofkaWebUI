package com.automationpractice.webproject.test.page.micuenta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @CacheLookup
    @FindBy(className = "account")
    WebElement customerName;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    WebElement womenCategory;

    public WebElement getCustomerName() {
        return customerName;
    }

    public WebElement getWomenCategory() {
        return womenCategory;
    }

    public MyAccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
