package com.automationpractice.webproject.test.page.contactanos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement idContact;

    @CacheLookup
    @FindBy(id = "email")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement idOrder;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/fieldset/div[1]/div[1]/p[5]/div/span[2]")
    WebElement chooseFile;

    @CacheLookup
    @FindBy(id = "message")
    WebElement message;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement submitMessage;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/ol/li")
    WebElement popUpErrorNoMessage;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p")
    WebElement contactUsSuccessMessage;

    public WebElement getIdContact() {
        return idContact;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getIdOrder() {
        return idOrder;
    }

    public WebElement getChooseFile() {
        return chooseFile;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSubmitMessage() {
        return submitMessage;
    }

    public WebElement getPopUpErrorNoMessage() {
        return popUpErrorNoMessage;
    }

    public WebElement getContactUsSuccessMessage() {
        return contactUsSuccessMessage;
    }

    public ContactUsPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }
}
