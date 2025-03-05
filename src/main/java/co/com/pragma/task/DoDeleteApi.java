package co.com.pragma.task;

import co.com.pragma.util.BaseHeaders;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoDeleteApi implements Task {
    private String user;

    @Managed
    private EnvironmentVariables environmentVariables;

    public DoDeleteApi(String user){
        this.user = user;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String endpoint = this.environmentVariables.optionalProperty("endpoints.reqres.getusers").orElse("/");
        endpoint = endpoint + "/" + user;
        RestQueryFunction restConfiguration = requestSpecification -> {
            requestSpecification.headers(new BaseHeaders(this.environmentVariables).getBaseHeader());
            /*
            Use to certificates
            requestSpecification.keyStore("path/certificate.p12", "password");
            requestSpecification.trustStore("path/certificate.jks", "password");
            requestSpecification.relaxedHTTPSValidation("TLSv1.2");
             */
            return  requestSpecification;
        };

        actor.attemptsTo(
                Delete.from(endpoint).with(restConfiguration)
        );
    }

    public static DoDeleteApi doDelete( String user){
        return instrumented(DoDeleteApi.class, user);
    }
}
