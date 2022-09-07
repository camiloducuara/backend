package com.senasoft.participacionciudadana.service.ciudadano.response;

import lombok.Data;

@Data
public class CuentaResponse {
    private Long id;

    private String username;
    private String password;
    private String role;

    private ContactoResponse contactoResponse;
}
