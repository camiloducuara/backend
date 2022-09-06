package com.senasoft.participacionciudadana.service.sondeoadmin.mapper;

import com.senasoft.participacionciudadana.entity.admin.PreguntaAdmin;
import com.senasoft.participacionciudadana.entity.admin.SondeoAdmin;
import com.senasoft.participacionciudadana.repository.PreguntaAdminRepository;
import com.senasoft.participacionciudadana.repository.SondeoAdminRepository;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import com.senasoft.participacionciudadana.service.sondeoadmin.request.SondeoAdminRequest;
import com.senasoft.participacionciudadana.service.sondeoadmin.response.PreguntaAdminResponse;
import com.senasoft.participacionciudadana.service.sondeoadmin.response.SondeoAdminResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class SondeoAdminMapper {

    @Autowired
    protected PreguntaAdminRepository preguntaAdminRepository;

    @Autowired
    protected SondeoAdminRepository sondeoAdminRepository;

    protected Function<SondeoAdminRequest, List<PreguntaAdmin>> mapearAEntidadesPreguntas
            = sondeoAdminRequest -> {

        List<PreguntaAdmin> preguntaAdmins = sondeoAdminRequest.getPreguntaAdminRequests().stream().map(
                preguntaAdminRequest -> {
                    PreguntaAdmin preguntaAdmin = new PreguntaAdmin();
                    preguntaAdmin.setContenido(preguntaAdminRequest.getContenido());
                    preguntaAdmin.setType(preguntaAdminRequest.getType());
                    return preguntaAdmin;
                }
                )
                .collect(Collectors.toList());

        preguntaAdminRepository.saveAll(preguntaAdmins);

        return preguntaAdmins;
    };

    protected Function<SondeoAdmin, List<PreguntaAdminResponse>> mapearARespuestaPreguntas =
            sondeoAdmin -> {

                return sondeoAdmin.getPreguntaAdmins().stream().map(
                        preguntaAdmin -> {
                            PreguntaAdminResponse preguntaAdminResponse = new PreguntaAdminResponse();
                            preguntaAdminResponse.setContenido(preguntaAdmin.getContenido());
                            preguntaAdminResponse.setType(preguntaAdmin.getType());

                            return preguntaAdminResponse;
                        }
                        )
                        .collect(Collectors.toList());

            } ;

    @Mapping(target="preguntaAdmins",
            expression = "java(mapearAEntidadesPreguntas.apply(sondeoAdminRequest))")
    public abstract SondeoAdmin aEntidad(SondeoAdminRequest sondeoAdminRequest);


    @Mapping(target="preguntaAdminResponses",
            expression = "java(mapearARespuestaPreguntas.apply(sondeoAdmin))")
    public abstract SondeoAdminResponse aRespuesta(SondeoAdmin sondeoAdmin);
}
