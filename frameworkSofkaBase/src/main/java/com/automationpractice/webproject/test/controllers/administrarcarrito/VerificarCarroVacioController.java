package com.automationpractice.webproject.test.controllers.administrarcarrito;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.carritodecompras.ShoppingCartPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.EMPTY_STRING;
import static com.automationpractice.webproject.test.helpers.Seconds.TWENTY_SECONDS;

public class VerificarCarroVacioController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerMensajeDeCarroVacio(){
        String mensajeDeCarroVacio = EMPTY_STRING;
        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            mensajeDeCarroVacio = webAction.getText(shoppingCartPage.getEmptyCartMessageIcon(), TWENTY_SECONDS.getValue(), true);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar validar el vaciado del carro.", e);
        }
        return mensajeDeCarroVacio;
    }
}
