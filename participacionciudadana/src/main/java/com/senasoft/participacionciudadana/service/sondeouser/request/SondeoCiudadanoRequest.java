package com.senasoft.participacionciudadana.service.sondeouser.request;

import lombok.Data;

import java.util.List;

@Data
public class SondeoCiudadanoRequest {

    private String titulo;
    private String username;

    private List<RespuestaCiudadanoRequest> respuestaCiudadanoRequest;


}
