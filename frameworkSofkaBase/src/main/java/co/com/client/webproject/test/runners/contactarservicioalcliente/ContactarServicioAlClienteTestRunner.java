package co.com.client.webproject.test.runners.contactarservicioalcliente;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/servicioalcliente/contactarServicioAlCliente.feature"},
        glue = {"co.com.client.webproject.test.stepdefinition.contactarservicioalcliente"},
        tags = "",
        publish = true
)
public class ContactarServicioAlClienteTestRunner {
}
