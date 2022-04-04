package com.automationpractice.webproject.test.page.carritodecompras;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {


    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/span[5]")
    WebElement emptyCartMessageIcon;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a")
    WebElement firstCartProductName;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a")
    WebElement deleteFirstCartProduct;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/p/a")
    WebElement secondCartProductName;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[7]/div/a")
    WebElement deleteSecondCartProduct;

    @CacheLookup
    @FindBy(id = "total_shipping")
    WebElement shippingFee;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proceedToCheckout;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement proceedToCheckoutAddress;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"form\"]/div/p[2]/label")
    WebElement termsOfServiceAgreement;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement proceedToCheckoutShipping;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payByBankWire;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement confirmMyOrder;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
    WebElement orderConfirmationMessage;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/span/strong")
    WebElement orderConfirmationPrice;

    public WebElement getEmptyCartMessageIcon() {
        return emptyCartMessageIcon;
    }

    public WebElement getFirstCartProductName() {
        return firstCartProductName;
    }

    public WebElement getDeleteFirstCartProduct() {
        return deleteFirstCartProduct;
    }

    public WebElement getSecondCartProductName() {
        return secondCartProductName;
    }

    public WebElement getDeleteSecondCartProduct() {
        return deleteSecondCartProduct;
    }

    public WebElement getShippingFee() {
        return shippingFee;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public WebElement getProceedToCheckoutAddress() {
        return proceedToCheckoutAddress;
    }

    public WebElement getTermsOfServiceAgreement() {
        return termsOfServiceAgreement;
    }

    public WebElement getProceedToCheckoutShipping() {
        return proceedToCheckoutShipping;
    }

    public WebElement getPayByBankWire() {
        return payByBankWire;
    }

    public WebElement getConfirmMyOrder() {
        return confirmMyOrder;
    }

    public WebElement getOrderConfirmationMessage() {
        return orderConfirmationMessage;
    }

    public WebElement getOrderConfirmationPrice() {
        return orderConfirmationPrice;
    }

    public ShoppingCartPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
