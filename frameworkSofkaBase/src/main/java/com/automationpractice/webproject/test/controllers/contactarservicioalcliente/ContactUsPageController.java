package com.automationpractice.webproject.test.controllers.contactarservicioalcliente;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.common.LandingPage;

import static com.automationpractice.webproject.test.helpers.Seconds.TWO_SECONDS;

public class ContactUsPageController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaContactUsPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());

            webAction.click(landingPage.getContactUs(),TWO_SECONDS.getValue(),true);

        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar abrir la tienda online", e);
        }
    }
}
