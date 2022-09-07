package com.senasoft.participacionciudadana.service.ciudadano.request;

import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import lombok.Data;

@Data
public class CuentaRequest {

    private String username;
    private String password;
    private String role;

    private ContactoRequest contactoRequest;

}
