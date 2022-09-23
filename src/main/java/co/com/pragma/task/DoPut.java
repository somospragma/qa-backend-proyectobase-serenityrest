package co.com.pragma.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class DoPut implements Task {

    private String recurso;
    private String token;
    private String body;

    public DoPut usandoElRecurso(String recurso){
        this.recurso = recurso;
        return this;
    }

    public DoPut conLaCookie(String cookie){
        this.token = cookie;
        return this;
    }

    public DoPut yConElBody(String Body){
        this.body = Body;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(recurso).with(
                        requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                .header("Content-type","application/json")
                                .header("Accept", "application/json")
                                //.header("Cookie", "token="+token)
                                .cookie("token", token)
                                .log().all()
                                .body(body)
                )
        );
    }

    public static DoPut doPut(){
        return new DoPut();
    }
}
