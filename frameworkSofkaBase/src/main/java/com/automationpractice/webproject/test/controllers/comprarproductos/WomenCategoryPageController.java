package com.automationpractice.webproject.test.controllers.comprarproductos;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.micuenta.MyAccountPage;

import static com.automationpractice.webproject.test.helpers.Seconds.TWO_SECONDS;

public class WomenCategoryPageController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaWomenCategoryPage(){
        try {
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());

            webAction.click(myAccountPage.getWomenCategory(), TWO_SECONDS.getValue(), true);

        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar abrir la tienda online", e);
        }
    }
}
