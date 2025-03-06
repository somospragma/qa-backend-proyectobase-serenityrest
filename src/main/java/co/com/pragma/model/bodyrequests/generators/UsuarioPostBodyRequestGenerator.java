package co.com.pragma.model.bodyrequests.generators;

import co.com.pragma.model.UsuarioPostModel;
import co.com.pragma.model.bodyrequests.models.UsuarioPostBodyRequest;

public class UsuarioPostBodyRequestGenerator {
    private final UsuarioPostModel data;

    private UsuarioPostBodyRequest bodyRequest;

    public UsuarioPostBodyRequestGenerator(UsuarioPostModel data){
        this.data = data;
        this.bodyRequest = UsuarioPostBodyRequest.builder().build();
    }
    private void setName(){
        if(data.getName().equals("null")){
            bodyRequest.setName(null);
        }else if(data.getName().equals("empty")){
            bodyRequest.setName("");
        }else{
            bodyRequest.setName(data.getName());
        }
    }

    private void setJob(){
        if(data.getJob().equals("null")){
            bodyRequest.setJob(null);
        }else if(data.getJob().equals("empty")){
            bodyRequest.setJob("");
        }else{
            bodyRequest.setJob(data.getJob());
        }
    }

    public UsuarioPostBodyRequest generate(){
        if(data != null){
            setName();
            setJob();
        }
        return this.bodyRequest;
    }
}
