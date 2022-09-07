package com.senasoft.participacionciudadana.service.ciudadano.request;

import com.senasoft.participacionciudadana.entity.ciudadano.Ubicacion;
import lombok.Data;

@Data
public class ContactoRequest {

    private String celular;
    private String fijo;
    private String correoElectronico;

    private UbicacionRequest ubicacionRequest;
}
