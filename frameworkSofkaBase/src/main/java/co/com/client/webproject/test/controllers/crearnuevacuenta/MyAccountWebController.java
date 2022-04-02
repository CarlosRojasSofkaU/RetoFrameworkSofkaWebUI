package co.com.client.webproject.test.controllers.crearnuevacuenta;

import co.com.client.webproject.test.page.micuenta.MyAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Seconds.TWO_SECONDS;

public class MyAccountWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerNombreDeNuevoUsuario(){
        String usuario = "";
        try{
            MyAccountPage myAccountPage = new MyAccountPage(webAction.getDriver());

            usuario = webAction.getText(myAccountPage.getCustomerName(), TWO_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrio un error al intentar validar la creación de un cuenta.", e);
        }

        return usuario;
    }
}
