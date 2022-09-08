package com.senasoft.participacionciudadana.service.sondeouser;

import com.senasoft.participacionciudadana.entity.ciudadanosondeo.SondeoCiudadano;
import com.senasoft.participacionciudadana.service.sondeouser.request.SondeoCiudadanoRequest;
import com.senasoft.participacionciudadana.service.sondeouser.response.SondeoCiudadanoResponse;

import java.util.List;

public interface SondeoUserService {

    void responderSondeo(SondeoCiudadanoRequest sondeoCiudadanoRequest);
    List<SondeoCiudadanoResponse> obtenerSondeosPorNombreDeUsuario(String username);
    List<SondeoCiudadanoResponse> ObtenerTodosLosSondeos();
    List<SondeoCiudadanoResponse> obtenerSondeosPorEtnia(String etnia);


}
