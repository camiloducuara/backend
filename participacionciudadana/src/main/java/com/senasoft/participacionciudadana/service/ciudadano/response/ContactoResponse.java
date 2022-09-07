package com.senasoft.participacionciudadana.service.ciudadano.response;

import com.senasoft.participacionciudadana.entity.ciudadano.Ubicacion;
import lombok.Data;

@Data
public class ContactoResponse {
    private String celular;
    private String fijo;
    private String correoElectronico;

    private UbicacionResponse ubicacionResponse;
}
