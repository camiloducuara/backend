package com.senasoft.participacionciudadana.service.sondeoadmin.request;

import lombok.*;

import java.util.List;

@Data
public class SondeoAdminRequest {
    private String titulo;
    private String contenido;
    private String imagen;

    private List<PreguntaAdminRequest> preguntaAdminRequests;
}
