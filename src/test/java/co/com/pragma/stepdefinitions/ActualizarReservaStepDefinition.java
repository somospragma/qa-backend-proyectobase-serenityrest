package co.com.pragma.stepdefinitions;

import co.com.pragma.model.TokenModel;
import co.com.pragma.questions.ResponseCode;
import co.com.pragma.questions.ResponseDataActualizada;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.pragma.task.DoPost.doPost;
import static co.com.pragma.task.DoPut.doPut;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class ActualizarReservaStepDefinition {

    private final Actor david = Actor.named("david");
    private static final String URL_BASE = "https://restful-booker.herokuapp.com";
    private static final String RESOURCE_AUTH = "/auth";
    private static final String RESOURCE_BOOKINGUPDATE = "/booking/2";

    private static final String BODY_AUTH = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    private static final String BODY_UPDATE = "{\n" +
            "    \"firstname\": \"David\",\n" +
            "    \"lastname\": \"Bonett\",\n" +
            "    \"totalprice\": 67,\n" +
            "    \"depositpaid\": true,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2022-05-10\",\n" +
            "        \"checkout\": \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";


    @Dado("El recepcionista cuenta con la informacion actualizar y autenticado")
    public void elRecepcionistaCuentaConLaInformacionActualizarYAutenticado() {
        david.can(CallAnApi.at(URL_BASE));
        david.wasAbleTo(
            doPost().usandoElEndpoint(RESOURCE_AUTH).yElBody(BODY_AUTH)
        );

    }
    @Cuando("El recepcionista realiza la actualizacion de la reserva")
    public void elRecepcionistaRealizaLaActualizacionDeLaReserva() {
        TokenModel respuesta = SerenityRest.lastResponse().as(TokenModel.class);
        david.attemptsTo(
                doPut().usandoElRecurso(RESOURCE_BOOKINGUPDATE)
                        .conLaCookie(respuesta.getToken())
                        .yConElBody(BODY_UPDATE)
        );

    }
    @Entonces("Recibe un codigo de confirmacion y la informacion actualizada")
    public void recibeUnCodigoDeConfirmacionYLaInformacionActualizada() {
        david.should(
                seeThat(
                        "el codigo de respuesta fue",
                        ResponseCode.was(), equalTo(200)
                ),
                seeThat(
                        "La reserva esta a nombre de",
                        ResponseDataActualizada.was(), equalTo("David")
                )
        );
    }

}
