package com.senasoft.participacionciudadana.service.ciudadano.mapper;

import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import com.senasoft.participacionciudadana.entity.ciudadano.Cuenta;
import com.senasoft.participacionciudadana.repository.ciudadano.ContactoRepository;
import com.senasoft.participacionciudadana.service.ciudadano.request.CuentaRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.ContactoResponse;
import com.senasoft.participacionciudadana.service.ciudadano.response.CuentaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public abstract class CuentaMapper {

    @Autowired
    protected ContactoMapper contactoMapper;

    @Autowired
    protected ContactoRepository contactoRepository;


    //Importante encriptar la contraseña con PasswordEncoder

    Function<CuentaRequest, Contacto> mapearContactoRequestAEntidad = cuentaRequest -> {

        Contacto contacto = contactoMapper.toEntity(cuentaRequest.getContactoRequest());
        contactoRepository.save(contacto);

        return contacto;

    };

    Function<Cuenta, ContactoResponse> mapearContactoARespuesta =
            cuenta -> contactoMapper.toResponse(cuenta.getContacto());

    @Mapping(target="contacto",
            expression = "java(mapearContactoRequestAEntidad.apply(cuentaRequest))")
    public abstract Cuenta toEntity(CuentaRequest cuentaRequest);

    @Mapping(target="contactoResponse",
            expression = "java(mapearContactoARespuesta.apply(cuenta))")
    public abstract CuentaResponse toResponse(Cuenta cuenta);

}
