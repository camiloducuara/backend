package com.senasoft.participacionciudadana.service.ciudadano.response;

import lombok.Data;

@Data
public class UbicacionResponse {

    private String municipio;
    private String direccion;
    private String barrio;
    private String estratoResidencia;
}
