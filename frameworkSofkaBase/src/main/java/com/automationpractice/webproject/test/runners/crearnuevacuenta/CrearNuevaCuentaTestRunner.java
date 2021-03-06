package com.automationpractice.webproject.test.runners.crearnuevacuenta;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/registro/crearNuevaCuenta.feature"},
        glue = {"com.automationpractice.webproject.test.stepdefinition.crearnuevacuenta"},
        tags = "",
        publish = true
)
public class CrearNuevaCuentaTestRunner {
}
