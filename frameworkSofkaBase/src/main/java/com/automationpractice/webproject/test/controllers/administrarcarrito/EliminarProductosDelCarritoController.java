package com.automationpractice.webproject.test.controllers.administrarcarrito;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.model.product.OrderedProduct;
import com.automationpractice.webproject.test.page.carritodecompras.ShoppingCartPage;

import static com.automationpractice.webproject.test.helpers.Seconds.TWENTY_SECONDS;

public class EliminarProductosDelCarritoController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void eliminarProductosDelCarrito(OrderedProduct orderedProduct1, OrderedProduct orderedProduct2){
        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            if (webAction.getText(
                    shoppingCartPage.getSecondCartProductName(), TWENTY_SECONDS.getValue(), true
            ).contains(orderedProduct2.getProductName())){
                webAction.click(shoppingCartPage.getDeleteSecondCartProduct(), TWENTY_SECONDS.getValue(), true);
            }

            if (webAction.getText(
                    shoppingCartPage.getFirstCartProductName(), TWENTY_SECONDS.getValue(), true
            ).contains(orderedProduct1.getProductName())){
                webAction.click(shoppingCartPage.getDeleteFirstCartProduct(), TWENTY_SECONDS.getValue(), true);
            }

        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar borrar productos del carrito.", e);
        }
    }
}
