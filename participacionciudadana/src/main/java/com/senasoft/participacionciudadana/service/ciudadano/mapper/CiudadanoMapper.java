package com.senasoft.participacionciudadana.service.ciudadano.mapper;

import com.senasoft.participacionciudadana.entity.ciudadano.Ciudadano;
import com.senasoft.participacionciudadana.entity.ciudadano.Identificacion;
import com.senasoft.participacionciudadana.repository.ciudadano.IdentificacionRepository;
import com.senasoft.participacionciudadana.service.ciudadano.request.CiudadanoRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.CiudadanoResponse;
import com.senasoft.participacionciudadana.service.ciudadano.response.IdentificacionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public abstract class CiudadanoMapper {

    @Autowired
    protected IdentificacionMapper identificacionMapper;

    @Autowired
    protected IdentificacionRepository identificacionRepository;

    protected Function<CiudadanoRequest, Identificacion> mapearIdentificacionRequestAEntidad =
            ciudadanoRequest -> {

                Identificacion identificacion = identificacionMapper.toEntity(ciudadanoRequest.getIdentificacionRequest());
                identificacionRepository.save(identificacion);

                return identificacion;

            };

    protected Function<Ciudadano, IdentificacionResponse> mapearIdentificacionARespuesta =
            ciudadano -> identificacionMapper.toResponse(ciudadano.getIdentificacion());

    @Mapping(target = "identificacion",
            expression = "java(mapearIdentificacionRequestAEntidad.apply(ciudadanoRequest))")
    public abstract Ciudadano aEntidad(CiudadanoRequest ciudadanoRequest);

    @Mapping(target="identificacionResponse",
            expression = "java(mapearIdentificacionARespuesta.apply(ciudadano))")
    public abstract CiudadanoResponse aRespuesta(Ciudadano ciudadano);

}
