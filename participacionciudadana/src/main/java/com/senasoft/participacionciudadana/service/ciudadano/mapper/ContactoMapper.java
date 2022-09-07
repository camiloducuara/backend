package com.senasoft.participacionciudadana.service.ciudadano.mapper;

import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import com.senasoft.participacionciudadana.entity.ciudadano.Ubicacion;
import com.senasoft.participacionciudadana.repository.ciudadano.UbicacionRepository;
import com.senasoft.participacionciudadana.service.ciudadano.request.ContactoRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.ContactoResponse;
import com.senasoft.participacionciudadana.service.ciudadano.response.UbicacionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public abstract class ContactoMapper {

    @Autowired
    protected UbicacionMapper ubicacionMapper;

    @Autowired
    protected UbicacionRepository ubicacionRepository;

    protected Function<ContactoRequest, Ubicacion> mapearUbicacionRequestAEntidad =
            contactoRequest -> {

                Ubicacion ubicacion = ubicacionMapper.aEntidad(contactoRequest.getUbicacionRequest());

                ubicacionRepository.save(ubicacion);

                return ubicacion;

            };

    protected Function<Contacto, UbicacionResponse> mapearUbicacionARespuesta =
            contacto -> ubicacionMapper.aUbicacionResponse(contacto.getUbicacion());


    @Mapping(target="ubicacion",
            expression = "java(mapearUbicacionRequestAEntidad.apply(contactoRequest))")
    public abstract Contacto toEntity(ContactoRequest contactoRequest);


    @Mapping(target="ubicacionResponse",
            expression = "java(mapearUbicacionARespuesta.apply(contacto))")
    public abstract ContactoResponse toResponse(Contacto contacto);


}
