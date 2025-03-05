package co.com.pragma.task;

import co.com.pragma.model.bodyrequests.models.UsuarioPostBodyRequest;
import co.com.pragma.util.BaseHeaders;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoPostApi implements Task {

    private UsuarioPostBodyRequest bodyRequest;

    @Managed
    private EnvironmentVariables environmentVariables;

    public DoPostApi(UsuarioPostBodyRequest bodyRequest){
        this.bodyRequest = bodyRequest;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String endpoint = this.environmentVariables.optionalProperty("endpoints.reqres.getusers").orElse("/");

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
                Post.to(endpoint).with(restConfiguration)
        );
    }

    public static DoPostApi doPost(UsuarioPostBodyRequest bodyRequest){
        return instrumented(DoPostApi.class, bodyRequest);
    }
}
