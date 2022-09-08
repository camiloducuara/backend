package com.senasoft.participacionciudadana.service.login.response;

import lombok.Data;

@Data
public class JwtResponse {
    private String type = "Bearer";
    private String token;
    private String rol;

    public JwtResponse(String token, String rol) {
        this.token = token;
        this.rol = rol;
    }
}
