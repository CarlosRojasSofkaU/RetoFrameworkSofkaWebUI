package com.automationpractice.webproject.test.stepdefinition.contactarservicioalcliente;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import com.automationpractice.webproject.test.controllers.contactarservicioalcliente.ContactUsPageController;
import com.automationpractice.webproject.test.controllers.contactarservicioalcliente.SubmitAContactUsMessageController;
import com.automationpractice.webproject.test.controllers.openwebpage.StartBrowserWebController;
import com.automationpractice.webproject.test.data.objects.TestInfo;
import com.automationpractice.webproject.test.stepdefinition.common.Setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static com.automationpractice.webproject.test.helpers.Dictionary.EMPTY_STRING;

public class ContactarServicioAlClienteStepDefinition extends Setup {

    private WebAction webAction;

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

    @Cuando("el cliente ingresa a contactanos y se registra todos los datos obligatorios para contactarse")
    public void elClienteIngresaAContactanosYSeRegistraTodosLosDatosObligatoriosParaContactarse() {
        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.irHaciaContactUsPage();

        SubmitAContactUsMessageController submitAContactUsMessageController = new SubmitAContactUsMessageController();
        submitAContactUsMessageController.setWebAction(webAction);
        submitAContactUsMessageController.enviarUnMensaje(EMPTY_STRING);
    }

    @Entonces("como resultado el usuario observara un mensaje de contacto exitoso en la pagina web.")
    public void comoResultadoElUsuarioObservaraUnMensajeDeContactoExitosoEnLaPaginaWeb() {
        SubmitAContactUsMessageController submitAContactUsMessageController = new SubmitAContactUsMessageController();
        submitAContactUsMessageController.setWebAction(webAction);
        String operationMessage = submitAContactUsMessageController.evaluarResultadoContacto(true);

        Assert
                .Hard
                .thatString(operationMessage)
                .isEqualTo("Your message has been successfully sent to our team.");
    }

    @Cuando("el cliente ingresa a contactanos y se registra todos los datos obligatorios para contactarse menos el mensaje")
    public void elClienteIngresaAContactanosYSeRegistraTodosLosDatosObligatoriosParaContactarseMenosElMensaje() {
        ContactUsPageController contactUsPageController = new ContactUsPageController();
        contactUsPageController.setWebAction(webAction);
        contactUsPageController.irHaciaContactUsPage();

        SubmitAContactUsMessageController submitAContactUsMessageController = new SubmitAContactUsMessageController();
        submitAContactUsMessageController.setWebAction(webAction);
        submitAContactUsMessageController.enviarUnMensaje("sin mensaje");
    }

    @Entonces("como resultado el usuario observara un mensaje de contacto fallido por falta del mensaje en la pagina web.")
    public void comoResultadoElUsuarioObservaraUnMensajeDeContactoFallidoPorFaltaDelMensajeEnLaPaginaWeb() {
        SubmitAContactUsMessageController submitAContactUsMessageController = new SubmitAContactUsMessageController();
        submitAContactUsMessageController.setWebAction(webAction);
        String operationMessage = submitAContactUsMessageController.evaluarResultadoContacto(false);

        Assert
                .Hard
                .thatString(operationMessage)
                .isEqualTo("The message cannot be blank.");
    }

    @After
    public void cerrarDriver() throws InterruptedException {

        //Thread.sleep(5000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
