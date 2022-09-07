package com.senasoft.participacionciudadana.service.ciudadano.request;

import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import lombok.Data;

@Data
public class UbicacionRequest {

    private String municipio;
    private String direccion;
    private String barrio;
    private String estratoResidencia;

}
