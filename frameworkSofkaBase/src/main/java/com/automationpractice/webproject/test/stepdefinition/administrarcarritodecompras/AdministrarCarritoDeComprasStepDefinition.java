package com.automationpractice.webproject.test.stepdefinition.administrarcarritodecompras;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.webproject.test.controllers.administrarcarrito.EliminarProductosDelCarritoController;
import com.automationpractice.webproject.test.controllers.administrarcarrito.VerificarCarroVacioController;
import com.automationpractice.webproject.test.controllers.administrarcarrito.VerificarCompraProductosController;
import com.automationpractice.webproject.test.controllers.comprarproductos.ComprarProductosDeMujeresController;
import com.automationpractice.webproject.test.controllers.comprarproductos.WomenCategoryPageController;
import com.automationpractice.webproject.test.controllers.crearnuevacuenta.CreateAnAccountWebController;
import com.automationpractice.webproject.test.controllers.crearnuevacuenta.LoginPageController;
import com.automationpractice.webproject.test.controllers.openwebpage.StartBrowserWebController;
import com.automationpractice.webproject.test.data.objects.TestInfo;
import com.automationpractice.webproject.test.model.costumer.Customer;
import com.automationpractice.webproject.test.model.product.OrderedProduct;
import com.automationpractice.webproject.test.stepdefinition.common.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;

public class AdministrarCarritoDeComprasStepDefinition extends Setup {

    private WebAction webAction;
    private Customer customer;
    private List <OrderedProduct> orderedProductList;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente esta en la pagina de inicio")
    public void queElClienteEstaEnLaPaginaDeInicio() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }

    @Dado("que el cliente se haya registrado o logueado en la plataforma")
    public void queElClienteSeHayaRegistradoOLogueadoEnLaPlataforma() {
        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
        customer = createAnAccountWebController.getCustomer();
    }

    @Cuando("el cliente quiere comprar un producto y realiza todas las funciones de verificacion")
    public void elClienteQuiereComprarUnProductoYRealizaTodasLasFuncionesDeVerificacion() {
        orderedProductList = new ArrayList<OrderedProduct>();
        WomenCategoryPageController womenCategoryPageController = new WomenCategoryPageController();
        womenCategoryPageController.setWebAction(webAction);
        womenCategoryPageController.irHaciaWomenCategoryPage();

        ComprarProductosDeMujeresController comprarProductosDeMujeresController = new ComprarProductosDeMujeresController();
        comprarProductosDeMujeresController.setWebAction(webAction);
        comprarProductosDeMujeresController.comprarProductosDeMujeresEIrACheckout();
        orderedProductList = comprarProductosDeMujeresController.getOrderedProductsList();

        VerificarCompraProductosController verificarCompraProductosController = new VerificarCompraProductosController();
        verificarCompraProductosController.setWebAction(webAction);
        Double shippingFee = verificarCompraProductosController.verificarCompraDeProductos();

        customer.setTotalOrderPrice(Precision.round((
                (orderedProductList.get(0).getProductCost()*orderedProductList.get(0).getProductQuantity())
                +(orderedProductList.get(1).getProductCost()*orderedProductList.get(1).getProductQuantity())
                +(shippingFee)
        ),2));
    }

    @Entonces("como resultado el usuario observara un mensaje de solicitud de compra exitosa y un precio de orden.")
    public void comoResultadoElUsuarioObservaraUnMensajeDeSolicitudDeCompraExitosaYUnPrecioDeOrden() {
        VerificarCompraProductosController verificarCompraProductosController = new VerificarCompraProductosController();
        verificarCompraProductosController.setWebAction(webAction);
        String successOrderMessage = verificarCompraProductosController.obtenerMensajeDeOrdenExitosa();

        Assert
                .Hard
                .thatString(successOrderMessage)
                .isEqualTo("Your order on My Store is complete.");

        Double successOrderPrice = verificarCompraProductosController.obtenerPrecioDeOrdenExitosa();

        Assert
                .Hard
                .thatDouble(successOrderPrice)
                .isEqualTo(customer.getTotalOrderPrice());
    }

    @Cuando("el cliente quiere eliminar sus productos del carrito de compras")
    public void elClienteQuiereEliminarSusProductosDelCarritoDeCompras() {
        orderedProductList = new ArrayList<OrderedProduct>();
        WomenCategoryPageController womenCategoryPageController = new WomenCategoryPageController();
        womenCategoryPageController.setWebAction(webAction);
        womenCategoryPageController.irHaciaWomenCategoryPage();

        ComprarProductosDeMujeresController comprarProductosDeMujeresController = new ComprarProductosDeMujeresController();
        comprarProductosDeMujeresController.setWebAction(webAction);
        comprarProductosDeMujeresController.comprarProductosDeMujeresEIrACheckout();
        orderedProductList = comprarProductosDeMujeresController.getOrderedProductsList();

        EliminarProductosDelCarritoController eliminarProductosDelCarritoController = new EliminarProductosDelCarritoController();
        eliminarProductosDelCarritoController.setWebAction(webAction);
        eliminarProductosDelCarritoController.eliminarProductosDelCarrito(orderedProductList.get(0), orderedProductList.get(1));
    }

    @Entonces("como resultado el usuario observara que el carrito de compras esta vacio.")
    public void comoResultadoElUsuarioObservaraQueElCarritoDeComprasEstaVacio() {
        VerificarCarroVacioController verificarCarroVacioController = new VerificarCarroVacioController();
        verificarCarroVacioController.setWebAction(webAction);
        String mensajeCarroVacioExitoso = verificarCarroVacioController.obtenerMensajeDeCarroVacio();

        Assert
                .Hard
                .thatString(mensajeCarroVacioExitoso)
                .isEqualTo("(empty)");
    }

    @After
    public void cerrarDriver() throws InterruptedException {

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
