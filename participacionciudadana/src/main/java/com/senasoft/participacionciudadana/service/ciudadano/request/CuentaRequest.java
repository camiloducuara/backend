package com.senasoft.participacionciudadana.service.ciudadano.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import lombok.Data;

@Data
public class CuentaRequest {

    private String username;
    private String password;

    @JsonIgnore
    private String role = "user";

    private ContactoRequest contactoRequest;

}
