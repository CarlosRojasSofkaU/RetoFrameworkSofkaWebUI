package com.automationpractice.webproject.test.runners.administrarcarritodecompras;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/carritodecompras/administrarCarritoDeCompras.feature"},
        glue = {"com.automationpractice.webproject.test.stepdefinition.administrarcarritodecompras"},
        tags = "",
        publish = true
)
public class AdministrarCarritoDeComprasTestRunner {
}
