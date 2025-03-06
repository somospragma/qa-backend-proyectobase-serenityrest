package co.com.pragma.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/consumo_api_metodo_PUT.feature"},
        glue = {"co.com.pragma.stepdefinitions"},
        tags = "@TAG-FEATURE",
        publish = true,
        plugin = {"pretty"}
)
public class ConsumoApiMetodoPutRunnerTag {
}
