package com.senasoft.participacionciudadana.service.ciudadano.response;

import com.senasoft.participacionciudadana.service.ciudadano.request.IdentificacionRequest;
import lombok.Data;

@Data
public class CiudadanoResponse {

    private String ultimoGradoAlcanzado;
    private boolean cuentaConDispositivos;
    private String dispositivos;
    private boolean cuentaConConectividad;
    private String regimenAfiliacion;

    private IdentificacionResponse identificacionResponse;

}
