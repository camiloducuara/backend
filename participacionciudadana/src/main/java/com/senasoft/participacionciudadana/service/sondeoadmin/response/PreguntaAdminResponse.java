package com.senasoft.participacionciudadana.service.sondeoadmin.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreguntaAdminResponse {
    private String contenido;
    private String type;

    List<OpcionAdminResponse> opcionAdminResponses;
}
