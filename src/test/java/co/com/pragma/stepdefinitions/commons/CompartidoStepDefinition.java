package co.com.pragma.stepdefinitions.commons;

import co.com.pragma.model.UsuarioPostModel;
import co.com.pragma.model.UsuariosGetModel;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CompartidoStepDefinition {

    @DataTableType
    public UsuariosGetModel convertUsuarioDataModel(Map<String, String> table){
        return new ObjectMapper().convertValue(table, UsuariosGetModel.class);
    }
    @DataTableType
    public UsuarioPostModel convertUsuarioPostDataModel(Map<String, String> table){
        return new ObjectMapper().convertValue(table, UsuarioPostModel.class);
    }
}
