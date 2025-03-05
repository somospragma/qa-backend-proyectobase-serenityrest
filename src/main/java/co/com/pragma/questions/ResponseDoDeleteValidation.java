package co.com.pragma.questions;

import co.com.pragma.model.UsuarioPostModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


public class ResponseDoDeleteValidation implements Task {
    private UsuarioPostModel data;

    public ResponseDoDeleteValidation(UsuarioPostModel data){
        this.data = data;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        //Step 1: Response validation
        actor.should(seeThatResponse(String.format("he status response is %s", data.getStatusResponse()),
                response -> response.statusCode(Integer.parseInt(data.getStatusResponse()))));
    }

    public static ResponseDoDeleteValidation validate(UsuarioPostModel data){
        return instrumented(ResponseDoDeleteValidation.class, data);
    }
}
