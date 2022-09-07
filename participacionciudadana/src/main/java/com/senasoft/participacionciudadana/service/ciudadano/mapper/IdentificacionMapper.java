package com.senasoft.participacionciudadana.service.ciudadano.mapper;

import com.senasoft.participacionciudadana.entity.ciudadano.Cuenta;
import com.senasoft.participacionciudadana.entity.ciudadano.Identificacion;
import com.senasoft.participacionciudadana.repository.ciudadano.CuentaRepository;
import com.senasoft.participacionciudadana.repository.ciudadano.IdentificacionRepository;
import com.senasoft.participacionciudadana.service.ciudadano.request.IdentificacionRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.CuentaResponse;
import com.senasoft.participacionciudadana.service.ciudadano.response.IdentificacionResponse;
import com.senasoft.participacionciudadana.service.exception.BadRequestException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

@Mapper(componentModel = "spring")
public abstract class IdentificacionMapper {

    @Autowired
    protected CuentaMapper cuentaMapper;

    @Autowired
    protected CuentaRepository cuentaRepository;

    protected Function<IdentificacionRequest, Cuenta> mapearCuentaRequestAEntidad =
            identificacionRequest -> {

                if (cuentaRepository.findByUsername(identificacionRequest
                        .getCuentaRequest().getUsername()).isPresent()){

                    throw new BadRequestException("El nombre de usuario ya existe");
                }

                Cuenta cuenta = cuentaMapper.toEntity(identificacionRequest.getCuentaRequest());

                cuentaRepository.save(cuenta);

                return cuenta;

            };

    protected Function<Identificacion, CuentaResponse> mapearCuentaARespuesta =
            identificacion -> cuentaMapper.toResponse(identificacion.getCuenta());


    @Mapping(target="cuenta",
            expression = "java(mapearCuentaRequestAEntidad.apply(identificacionRequest))")
    public abstract Identificacion toEntity(IdentificacionRequest identificacionRequest);

    @Mapping(target="cuentaResponse",
            expression = "java(mapearCuentaARespuesta.apply(identificacion))")
    public abstract IdentificacionResponse toResponse(Identificacion identificacion);
}
