package co.com.pragma.stepdefinitions;

import co.com.pragma.model.UsuarioPostModel;
import co.com.pragma.questions.ResponseDoDeleteValidation;
import co.com.pragma.task.DoDeleteApi;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

public class ConsumoApiMetodoDeletetStepDefinition {
    @Managed
    private Actor actor;

    @Managed
    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage(){
        String theRestApiBaseUrl = EnvironmentSpecificConfiguration.from(this.environmentVariables).getProperty("restapi.baseurl.url");
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("User").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Cuando("se realiza el consumo del servicios delete con dato")
    public void seRealizaElConsumoDelServiciosDeleteConDato(UsuarioPostModel data) {
        actor.attemptsTo(DoDeleteApi.doDelete(data.getUser()));
    }
    @Entonces("Debe responder de manera correcta eliminando el usuario")
    public void debeResponderDeManeraCorrectaEliminandoElUsuario(UsuarioPostModel data) {
        actor.attemptsTo(ResponseDoDeleteValidation.validate(data));
    }
}
