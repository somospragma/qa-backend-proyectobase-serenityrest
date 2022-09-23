package co.com.pragma.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class DoPost implements Task {

    private String resource;
    private String body;

    public DoPost usandoElEndpoint(String resource){
        this.resource = resource;
        return this;
    }

    public DoPost yElBody(String body){
        this.body = body;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource).with(
                        requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                .header("Content-type","application/json")
                                .log().all()
                                .body(body)
                )
        );
    }

    public static DoPost doPost(){
        return new DoPost();
    }
}
