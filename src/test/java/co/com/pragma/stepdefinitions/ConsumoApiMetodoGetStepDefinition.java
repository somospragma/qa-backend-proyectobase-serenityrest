package co.com.pragma.stepdefinitions;

import co.com.pragma.model.UsuariosGetModel;
import co.com.pragma.questions.ResponseDoGetValitadion;
import co.com.pragma.task.DoGetApi;
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

public class ConsumoApiMetodoGetStepDefinition {
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

    @Dado("que se genera la informacion necesaria para el consumo del servicio")
    public void queSeGeneraLaInformacionNecesariaParaElConsumoDelServicio() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Cuando("se realiza el consumo del servicios con los parametros")
    public void seRealizaElConsumoDelServiciosConLosParametros(UsuariosGetModel data) {
        actor.attemptsTo(DoGetApi.doGet(data.getPage()));
    }
    @Entonces("Debe responder de manera correcta con datos")
    public void debeResponderDeManeraCorrectaConDatos(UsuariosGetModel data) {
        actor.attemptsTo(ResponseDoGetValitadion.validate(data));
    }

}
