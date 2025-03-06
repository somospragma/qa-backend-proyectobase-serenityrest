package co.com.pragma.model.bodyrequests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioPostBodyRequest {
    private String name;
    private String job;
}
