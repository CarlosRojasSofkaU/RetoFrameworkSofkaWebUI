package com.automationpractice.webproject.test.controllers.contactarservicioalcliente;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.model.costumer.Customer;
import com.automationpractice.webproject.test.page.contactanos.ContactUsPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.*;
import static com.automationpractice.webproject.test.helpers.Helper.generateCustomer;
import static com.automationpractice.webproject.test.helpers.Seconds.TEN_SECONDS;
import static com.automationpractice.webproject.test.helpers.Seconds.TWO_SECONDS;

public class SubmitAContactUsMessageController {

    private WebAction webAction;
    private Customer customer;
    private Boolean messageFailure = false;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void enviarUnMensaje(String operationError){
        try {
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);

            switch (operationError){
                case "sin mensaje":
                    messageFailure = true;
                    break;
                default:
                    break;
            }

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.selectByText(
                    contactUsPage.getIdContact(),
                    customer.getSubjectHeading(),
                    TEN_SECONDS.getValue(),
                    true
            );
            webAction.sendText(
                    contactUsPage.getEmailAddress(),
                    customer.getEmail(),
                    true
            );
            webAction.sendText(
                    contactUsPage.getIdOrder(),
                    customer.getContactUsOrderReference(),
                    true
            );
            if (!messageFailure){
                webAction.sendText(
                        contactUsPage.getMessage(),
                        customer.getContactUsMessage(),
                        true
                );
            }
            webAction.click(contactUsPage.getSubmitMessage(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar enviar un mensaje.", e);
        }
    }

    public String evaluarResultadoContacto (Boolean successfulOperation){
        String operationMessage = EMPTY_STRING;
        ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
        try {
            if (successfulOperation){
                operationMessage = webAction.getText(
                        contactUsPage.getContactUsSuccessMessage(),
                        TWO_SECONDS.getValue(),
                        true
                );
            }
            else {
                operationMessage = webAction.getText(
                        contactUsPage.getPopUpErrorNoMessage(),
                        TWO_SECONDS.getValue(),
                        true
                );
            }
        } catch (WebActionsException e){
            Report.reportFailure(
                    "Ocurrio un error al intentar validar el contacto con el servicio al cliente.", e
            );
        }
        return operationMessage;
    }
}
