package co.com.pragma.task;

import co.com.pragma.util.BaseHeaders;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DoGetApi implements Task {
    private final String page;

    @Managed
    private EnvironmentVariables environmentVariables;

    public DoGetApi(String page){
        this.page = page;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String endpoint = this.environmentVariables.optionalProperty("endpoints.reqres.getusers").orElse("/");

        RestQueryFunction restConfiguration = requestSpecification -> {
            requestSpecification.headers(new BaseHeaders(this.environmentVariables).getBaseHeader());
            requestSpecification.queryParam("page", page);
            /*
            Use to certificates
            requestSpecification.keyStore("path/certificate.p12", "password");
            requestSpecification.trustStore("path/certificate.jks", "password");
            requestSpecification.relaxedHTTPSValidation("TLSv1.2");
             */
            return  requestSpecification;
        };

        actor.attemptsTo(
                Get.resource(endpoint).with(restConfiguration)
        );
    }

    public static DoGetApi doGet(String page){
        return instrumented(DoGetApi.class, page);
    }
}
