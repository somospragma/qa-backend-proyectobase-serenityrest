package co.com.pragma.stepdefinitions;

import co.com.pragma.model.UsuarioPostModel;
import co.com.pragma.model.bodyrequests.generators.UsuarioPostBodyRequestGenerator;
import co.com.pragma.model.bodyrequests.models.UsuarioPostBodyRequest;
import co.com.pragma.questions.ResponseDoPostValidation;
import co.com.pragma.questions.ResponseDoPutValidation;
import co.com.pragma.task.DoPutApi;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

public class ConsumoApiMetodoPutStepDefinition {
    @Managed
    private Actor actor;

    private UsuarioPostBodyRequest bodyRequest;

    @Managed
    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage(){
        String theRestApiBaseUrl = EnvironmentSpecificConfiguration.from(this.environmentVariables).getProperty("restapi.baseurl.url");
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("User").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Dado("que se genera la informacion necesaria para el consumo del servicio put")
    public void queSeGeneraLaInformacionNecesariaParaElConsumoDelServicioPut(UsuarioPostModel data) {
        UsuarioPostBodyRequestGenerator bodyRequestGenerator = new UsuarioPostBodyRequestGenerator(data);
        bodyRequest = bodyRequestGenerator.generate();
    }
    @Cuando("se realiza el consumo del servicio")
    public void seRealizaElConsumoDelServicio(UsuarioPostModel data) {
        actor.attemptsTo(DoPutApi.doPut(bodyRequest, data.getUser()));
    }
    @Entonces("Debe responder de manera correcta")
    public void debeResponderDeManeraCorrecta(UsuarioPostModel data) {
        actor.attemptsTo(ResponseDoPutValidation.validate(data));
    }

}
