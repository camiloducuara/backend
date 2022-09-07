package com.senasoft.participacionciudadana.service.sondeoadmin.mapper;

import com.senasoft.participacionciudadana.entity.adminsondeo.OpcionesAdmin;
import com.senasoft.participacionciudadana.entity.adminsondeo.PreguntaAdmin;
import com.senasoft.participacionciudadana.entity.adminsondeo.SondeoAdmin;
import com.senasoft.participacionciudadana.repository.adminsondeo.OpcionAdminRepository;
import com.senasoft.participacionciudadana.repository.adminsondeo.PreguntaAdminRepository;
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
    protected OpcionMapper opcionMapper;

    @Autowired
    protected OpcionAdminRepository opcionAdminRepository;

    protected Function<SondeoAdminRequest, List<PreguntaAdmin>> mapearAEntidadesPreguntas
            = sondeoAdminRequest -> {

        List<PreguntaAdmin> preguntaAdmins = sondeoAdminRequest.getPreguntaAdminRequests().stream().map(
                preguntaAdminRequest -> {
                    PreguntaAdmin preguntaAdmin = new PreguntaAdmin();
                    preguntaAdmin.setContenido(preguntaAdminRequest.getContenido());
                    preguntaAdmin.setType(preguntaAdminRequest.getType());

                    List<OpcionesAdmin> opcionesAdmins = preguntaAdminRequest.getOpcionAdminRequests().stream()
                            .map(opcionMapper::aEntidad).collect(Collectors.toList());

                    opcionAdminRepository.saveAll(opcionesAdmins);

                    preguntaAdmin.setOpcionesAdmins(opcionesAdmins);

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

                            preguntaAdminResponse.setOpcionAdminResponses(preguntaAdmin.getOpcionesAdmins()
                                    .stream().map(opcionMapper::aRespuesta).collect(Collectors.toList()));

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
