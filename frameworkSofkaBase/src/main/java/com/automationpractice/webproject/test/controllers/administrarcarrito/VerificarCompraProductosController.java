package com.automationpractice.webproject.test.controllers.administrarcarrito;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.page.carritodecompras.ShoppingCartPage;

import static com.automationpractice.webproject.test.helpers.Dictionary.EMPTY_STRING;
import static com.automationpractice.webproject.test.helpers.Seconds.TEN_SECONDS;
import static com.automationpractice.webproject.test.helpers.Seconds.TWO_SECONDS;

public class VerificarCompraProductosController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public Double verificarCompraDeProductos(){
        Double shippingFee = 0.0;
        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            shippingFee = Double.valueOf(
                    webAction.getText(
                            shoppingCartPage.getShippingFee(), TWO_SECONDS.getValue(), true
                    ).replace("$",EMPTY_STRING)
            );
            webAction.click(shoppingCartPage.getProceedToCheckout(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutAddress(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getTermsOfServiceAgreement(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutShipping(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getPayByBankWire(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getConfirmMyOrder(), TEN_SECONDS.getValue(), true);

        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar comprar productos.", e);
        }
        return shippingFee;
    }

    public String obtenerMensajeDeOrdenExitosa(){
        String mensaje = EMPTY_STRING;
        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            mensaje = webAction.getText(shoppingCartPage.getOrderConfirmationMessage(),TEN_SECONDS.getValue(),true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la orden de productos.", e);
        }
        return mensaje;
    }

    public Double obtenerPrecioDeOrdenExitosa(){
        Double precio = 0.0;
        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            precio = Double.valueOf(
                    webAction.getText(
                            shoppingCartPage.getOrderConfirmationPrice(),TEN_SECONDS.getValue(),true)
                            .replace("$",EMPTY_STRING)
            );

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la orden de productos.", e);
        }
        return precio;
    }
}
