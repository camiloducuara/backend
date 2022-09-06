package com.senasoft.participacionciudadana.service.sondeoadmin.response;

import lombok.Data;

import java.util.List;

@Data
public class SondeoAdminResponse {
    private Long id;
    private String titulo;
    private String contenido;
    private String imagen;

    List<PreguntaAdminResponse> preguntaAdminResponses;
}
