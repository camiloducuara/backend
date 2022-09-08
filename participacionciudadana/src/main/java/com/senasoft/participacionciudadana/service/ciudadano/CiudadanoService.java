package com.senasoft.participacionciudadana.service.ciudadano;

import com.senasoft.participacionciudadana.service.ciudadano.request.CiudadanoRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.CiudadanoResponse;

import java.util.List;

public interface CiudadanoService {
    void crear(CiudadanoRequest ciudadanoRequest);
    List<CiudadanoResponse> obtenerTodos();
    CiudadanoResponse obtenerPorNumeroDeDocumento(String numeroDeDocumento);
    List<CiudadanoResponse> obtenerPorEtnia(String etnia);
}
