package co.com.pragma.task;

import co.com.pragma.model.bodyrequests.models.UsuarioPostBodyRequest;
import co.com.pragma.util.BaseHeaders;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoPutApi implements Task {

    private UsuarioPostBodyRequest bodyRequest;

    private String user;

    @Managed
    private EnvironmentVariables environmentVariables;

    public DoPutApi(UsuarioPostBodyRequest bodyRequest, String user){
        this.bodyRequest = bodyRequest;
        this.user = user;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String endpoint = this.environmentVariables.optionalProperty("endpoints.reqres.getusers").orElse("/");
        endpoint = endpoint + "/" + user;
        RestQueryFunction restConfiguration = requestSpecification -> {
            requestSpecification.headers(new BaseHeaders(this.environmentVariables).getBaseHeader());
            requestSpecification.body(bodyRequest);
            /*
            Use to certificates
            requestSpecification.keyStore("path/certificate.p12", "password");
            requestSpecification.trustStore("path/certificate.jks", "password");
            requestSpecification.relaxedHTTPSValidation("TLSv1.2");
             */
            return  requestSpecification;
        };

        actor.attemptsTo(
                Put.to(endpoint).with(restConfiguration)
        );
    }

    public static DoPutApi doPut(UsuarioPostBodyRequest bodyRequest, String user){
        return instrumented(DoPutApi.class, bodyRequest, user);
    }
}
