package com.senasoft.participacionciudadana.service.sondeoadmin.mapper;

import com.senasoft.participacionciudadana.entity.adminsondeo.OpcionesAdmin;
import com.senasoft.participacionciudadana.service.sondeoadmin.request.OpcionAdminRequest;
import com.senasoft.participacionciudadana.service.sondeoadmin.response.OpcionAdminResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface OpcionMapper {

    OpcionesAdmin aEntidad(OpcionAdminRequest opcionAdminRequest);
    OpcionAdminResponse aRespuesta(OpcionesAdmin opcionesAdmin);
}
