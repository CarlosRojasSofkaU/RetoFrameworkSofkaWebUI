package com.automationpractice.webproject.test.controllers.crearnuevacuenta;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.micuenta.MyAccountPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.EMPTY_STRING;
import static com.automationpractice.webproject.test.helpers.Seconds.TWO_SECONDS;

public class MyAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerNombreDeNuevoUsuario(){
        String usuario = EMPTY_STRING;
        try{
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());

            usuario = webAction.getText(myAccountPage.getCustomerName(), TWO_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }

        return usuario;
    }
}
