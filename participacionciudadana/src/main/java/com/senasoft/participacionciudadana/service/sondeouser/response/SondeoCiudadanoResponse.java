package com.senasoft.participacionciudadana.service.sondeouser.response;

import lombok.Data;

import java.util.List;

@Data
public class SondeoCiudadanoResponse {

    private String username;

    private String tituloSondeo;

    private List<RespuestaCiudadanoResponse> respuestaCiudadanoResponses;



}
