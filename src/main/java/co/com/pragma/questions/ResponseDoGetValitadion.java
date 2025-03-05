package co.com.pragma.questions;

import co.com.pragma.model.UsuariosGetModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class ResponseDoGetValitadion implements Task {
    private UsuariosGetModel data;

    public ResponseDoGetValitadion (UsuariosGetModel data){
        this.data = data;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        //Step 1: Response validation
        actor.should(seeThatResponse(String.format("he status response is %s", data.getStatusResponse()),
                response -> response.statusCode(Integer.parseInt(data.getStatusResponse()))));

        //Step 2: Validation response with Schema
        // Step 3: BodyResponse Validation
        //HappyPath Validation...
        if(data.getStatusResponse().equals("200")) {
            actor.should(seeThatResponse("The json response body has the correct format",
                    response -> response.body(matchesJsonSchemaInClasspath("schemas/get_response_hp_schema.json"))),
                    seeThatResponse("The json response body has the correct information",
                            response -> response
                                    .body("page", equalTo(Integer.parseInt(data.getPage())))
                                    .body("per_page", equalTo(Integer.parseInt(data.getPer_page())))
                                    .body("total", equalTo(Integer.parseInt(data.getTotal())))
                                    .body("total_pages", equalTo(Integer.parseInt(data.getTotal_pages())))
                                    .body("support.url", equalTo(data.getUrl()))
                                    .body("support.text", equalTo(data.getText()))
                    ));
        }else{
            //implementation Full Error validation
        }
        //Step 4: Implementation valitation from DB
    }

    public static ResponseDoGetValitadion validate(UsuariosGetModel data){
        return instrumented(ResponseDoGetValitadion.class, data);
    }
}
