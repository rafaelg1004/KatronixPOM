package com.ktronix.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "@agregasion",
        glue ="com.ktronix.stepsDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class AgregarProductoRunners {
}
