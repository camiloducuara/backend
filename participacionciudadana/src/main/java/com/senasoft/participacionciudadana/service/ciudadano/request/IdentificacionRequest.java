package com.senasoft.participacionciudadana.service.ciudadano.request;

import lombok.Data;

@Data
public class IdentificacionRequest {

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombreCompleto;
    private String apellidos;
    private String sexo;
    private String fechaNacimiento;
    private String etnia;
    private String discapacidad;

    private CuentaRequest cuentaRequest;

}
