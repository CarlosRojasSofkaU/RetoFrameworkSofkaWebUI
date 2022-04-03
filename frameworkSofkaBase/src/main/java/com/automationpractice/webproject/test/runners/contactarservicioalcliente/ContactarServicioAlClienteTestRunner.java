package com.automationpractice.webproject.test.runners.contactarservicioalcliente;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/servicioalcliente/contactarServicioAlCliente.feature"},
        glue = {"com.automationpractice.webproject.test.stepdefinition.contactarservicioalcliente"},
        tags = "",
        publish = true
)
public class ContactarServicioAlClienteTestRunner {
}
