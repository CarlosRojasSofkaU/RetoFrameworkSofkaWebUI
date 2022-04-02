package co.com.client.webproject.test.stepdefinition.contactarservicioalcliente;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class ContactarServicioAlClienteStepDefinition {
    @Dado("que el cliente esta en la pagina de inicio e ingresa a la seccion de contactanos")
    public void queElClienteEstaEnLaPaginaDeInicioEIngresaALaSeccionDeContactanos() {
    }
    @Cuando("el cliente registra todos los datos obligatorios para contactarse")
    public void elClienteRegistraTodosLosDatosObligatoriosParaContactarse() {
    }
    @Entonces("como resultado el usuario observara un mensaje de contacto exitoso en la pagina web.")
    public void comoResultadoElUsuarioObservaraUnMensajeDeContactoExitosoEnLaPaginaWeb() {
    }
    @Cuando("el cliente registra todos los datos obligatorios para contactarse menos el mensaje")
    public void elClienteRegistraTodosLosDatosObligatoriosParaContactarseMenosElMensaje() {
    }
    @Entonces("como resultado el usuario observara un mensaje de contacto fallido por falta del mensaje en la pagina web.")
    public void comoResultadoElUsuarioObservaraUnMensajeDeContactoFallidoPorFaltaDelMensajeEnLaPaginaWeb() {
    }
}
