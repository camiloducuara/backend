package com.senasoft.participacionciudadana.service.login.response;

import lombok.Data;

@Data
public class JwtResponse {
    private String type = "Bearer";
    private String token;
}
