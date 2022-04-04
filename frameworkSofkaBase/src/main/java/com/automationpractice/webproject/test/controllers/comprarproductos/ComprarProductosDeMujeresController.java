package com.automationpractice.webproject.test.controllers.comprarproductos;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import com.automationpractice.webproject.test.model.product.OrderedProduct;
import com.automationpractice.webproject.test.page.comprarproductos.WomenCategoryPage;

import java.util.ArrayList;
import java.util.List;

import static com.automationpractice.webproject.test.helpers.Dictionary.EMPTY_STRING;
import static com.automationpractice.webproject.test.helpers.Seconds.FIVE_SECONDS;
import static com.automationpractice.webproject.test.helpers.Seconds.TEN_SECONDS;

public class ComprarProductosDeMujeresController {

    private WebAction webAction;
    private List <OrderedProduct> orderedProductsList = new ArrayList<OrderedProduct>();

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public List<OrderedProduct> getOrderedProductsList() {
        return orderedProductsList;
    }

    public void comprarProductosDeMujeresEIrACheckout(){
        try {
            OrderedProduct orderedProduct1 = new OrderedProduct();
            OrderedProduct orderedProduct2 = new OrderedProduct();
            WomenCategoryPage womenCategoryPage = new WomenCategoryPage(webAction.getDriver());

            webAction.moveTo(womenCategoryPage.getFirstWomenItemImg(), FIVE_SECONDS.getValue(), true);
            webAction.click(womenCategoryPage.getAddToCartFirstWomenItem(), TEN_SECONDS.getValue(), true);
            orderedProduct1.setProductName(
                    webAction.getText(
                            womenCategoryPage.getOrderedProductName(), TEN_SECONDS.getValue(), false
                    )
            );
            orderedProduct1.setProductCost(
                    Double.valueOf(webAction.getText(
                            womenCategoryPage.getOrderedProductPrice(), TEN_SECONDS.getValue(), false
                    ).replace("$",EMPTY_STRING))
            );
            orderedProduct1.setProductQuantity(
                    Integer.valueOf(webAction.getText(
                            womenCategoryPage.getOrderedProductQuantity(), TEN_SECONDS.getValue(), false
                    ))
            );
            orderedProductsList.add(orderedProduct1);
            webAction.click(womenCategoryPage.getContinueShopping(), FIVE_SECONDS.getValue(), true);
            webAction.moveTo(womenCategoryPage.getSecondWomenItemImg(), FIVE_SECONDS.getValue(), true);
            webAction.click(womenCategoryPage.getAddToCartSecondWomenItem(), TEN_SECONDS.getValue(), true);
            orderedProduct2.setProductName(
                    webAction.getText(
                            womenCategoryPage.getOrderedProductName(), TEN_SECONDS.getValue(), false
                    )
            );
            orderedProduct2.setProductCost(
                    Double.valueOf(webAction.getText(
                            womenCategoryPage.getOrderedProductPrice(), TEN_SECONDS.getValue(), false
                    ).replace("$",EMPTY_STRING))
            );
            orderedProduct2.setProductQuantity(
                    Integer.valueOf(webAction.getText(
                            womenCategoryPage.getOrderedProductQuantity(), TEN_SECONDS.getValue(), false
                    ))
            );
            orderedProductsList.add(orderedProduct2);
            webAction.click(womenCategoryPage.getProceedToCheckout(),FIVE_SECONDS.getValue(),true);

        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar comprar productos.", e);
        }
    }
}
