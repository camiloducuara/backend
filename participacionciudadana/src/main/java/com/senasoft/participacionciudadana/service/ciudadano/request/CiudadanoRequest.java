package com.senasoft.participacionciudadana.service.ciudadano.request;

import com.senasoft.participacionciudadana.entity.ciudadano.Identificacion;
import lombok.Data;

@Data
public class CiudadanoRequest {

    private String ultimoGradoAlcanzado;
    private boolean cuentaConDispositivos;
    private String dispositivos;
    private boolean cuentaConConectividad;
    private String regimenAfiliacion;

    private IdentificacionRequest identificacionRequest;

}
