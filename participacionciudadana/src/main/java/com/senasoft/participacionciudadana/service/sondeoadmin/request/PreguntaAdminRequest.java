package com.senasoft.participacionciudadana.service.sondeoadmin.request;

import lombok.Data;

import java.util.List;

@Data
public class PreguntaAdminRequest {
    private String contenido;
    private String type;

    private List<OpcionAdminRequest> opcionAdminRequests;
}
