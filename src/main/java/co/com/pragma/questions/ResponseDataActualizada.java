package co.com.pragma.questions;

import co.com.pragma.model.DataActualizadaModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseDataActualizada implements Question<String> {

    public static Question<String> was(){
        return new ResponseDataActualizada();
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(DataActualizadaModel.class).getFirstname();
    }
}
