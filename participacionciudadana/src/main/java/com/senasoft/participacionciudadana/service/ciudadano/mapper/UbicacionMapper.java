package com.senasoft.participacionciudadana.service.ciudadano.mapper;

import com.senasoft.participacionciudadana.entity.ciudadano.Ubicacion;
import com.senasoft.participacionciudadana.service.ciudadano.request.UbicacionRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.UbicacionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UbicacionMapper {

    Ubicacion aEntidad(UbicacionRequest ubicacionRequest);
    UbicacionResponse aUbicacionResponse(Ubicacion ubicacion);

}
