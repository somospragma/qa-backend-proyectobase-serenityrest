package co.com.pragma.questions;

import co.com.pragma.model.UsuarioPostModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class ResponseDoPostValidation implements Task {
    private UsuarioPostModel data;

    public ResponseDoPostValidation(UsuarioPostModel data){
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
        if(data.getStatusResponse().equals("201")) {
            actor.should(seeThatResponse("The json response body has the correct format",
                    response -> response.body(matchesJsonSchemaInClasspath("schemas/post_response_hp_schema.json"))),
                    seeThatResponse("The json response body has the correct information",
                            response -> response
                                    .body("name", equalTo(data.getName()))
                                    .body("job", equalTo(data.getJob()))
                                    .body("id", notNullValue())
                                    .body("createdAt", notNullValue())
                    ));
        }else{
            //implementation Full Error validation
        }
        //Step 4: Implementation valitation from DB
    }

    public static ResponseDoPostValidation validate(UsuarioPostModel data){
        return instrumented(ResponseDoPostValidation.class, data);
    }
}
