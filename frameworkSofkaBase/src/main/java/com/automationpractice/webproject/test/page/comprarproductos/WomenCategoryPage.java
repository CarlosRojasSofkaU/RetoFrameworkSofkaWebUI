package com.automationpractice.webproject.test.page.comprarproductos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenCategoryPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement firstWomenItemImg;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")
    WebElement addToCartFirstWomenItem;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart_product_title\"]")
    WebElement orderedProductName;

    @CacheLookup
    @FindBy(id = "layer_cart_product_quantity")
    WebElement orderedProductQuantity;

    @CacheLookup
    @FindBy(id = "layer_cart_product_price")
    WebElement orderedProductPrice;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    WebElement continueShopping;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    WebElement secondWomenItemImg;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")
    WebElement addToCartSecondWomenItem;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckout;

    public WebElement getFirstWomenItemImg() {
        return firstWomenItemImg;
    }

    public WebElement getAddToCartFirstWomenItem() {
        return addToCartFirstWomenItem;
    }

    public WebElement getOrderedProductName() {
        return orderedProductName;
    }

    public WebElement getOrderedProductQuantity() {
        return orderedProductQuantity;
    }

    public WebElement getOrderedProductPrice() {
        return orderedProductPrice;
    }

    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getSecondWomenItemImg() {
        return secondWomenItemImg;
    }

    public WebElement getAddToCartSecondWomenItem() {
        return addToCartSecondWomenItem;
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }

    public WomenCategoryPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
}
