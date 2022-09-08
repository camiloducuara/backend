package com.senasoft.participacionciudadana.service.sondeouser.mapper;

import com.senasoft.participacionciudadana.entity.adminsondeo.SondeoAdmin;
import com.senasoft.participacionciudadana.entity.ciudadanosondeo.RespuestaCiudadano;
import com.senasoft.participacionciudadana.entity.ciudadanosondeo.SondeoCiudadano;
import com.senasoft.participacionciudadana.repository.adminsondeo.PreguntaAdminRepository;
import com.senasoft.participacionciudadana.repository.adminsondeo.SondeoAdminRepository;
import com.senasoft.participacionciudadana.repository.ciudadanosondeo.RespuestaCiudadanoRepository;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import com.senasoft.participacionciudadana.service.sondeouser.request.SondeoCiudadanoRequest;
import com.senasoft.participacionciudadana.service.sondeouser.response.RespuestaCiudadanoResponse;
import com.senasoft.participacionciudadana.service.sondeouser.response.SondeoCiudadanoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class SondeoCiudadanoMapper {

    @Autowired
    protected RespuestaCiudadanoRepository respuestaCiudadanoRepository;

    @Autowired
    protected PreguntaAdminRepository preguntaAdminRepository;

    @Autowired
    protected SondeoAdminRepository sondeoAdminRepository;

    protected Function<SondeoCiudadanoRequest, List<RespuestaCiudadano>> mapearRespuestasAEntidad =
            sondeoCiudadanoRequest -> {

                List<RespuestaCiudadano> respuestaCiudadanos = sondeoCiudadanoRequest
                        .getRespuestaCiudadanoRequest().stream().map(respuestaCiudadanoRequest -> {

                            RespuestaCiudadano respuestaCiudadano = new RespuestaCiudadano();

                            respuestaCiudadano.setPreguntaAdmin(preguntaAdminRepository
                                    .findById(respuestaCiudadanoRequest.getIdPreguntaAdmin())
                                    .orElseThrow((() -> new NotFoundException("Pregunta no encontrada"))));

                            respuestaCiudadano.setRespuesta(respuestaCiudadanoRequest.getRespuesta());

                            return respuestaCiudadano;


                        }).collect(Collectors.toList());

                respuestaCiudadanoRepository.saveAll(respuestaCiudadanos);

                return respuestaCiudadanos;

            };

    protected Function<SondeoCiudadano, List<RespuestaCiudadanoResponse>> mapearEntidadARespuestas =
            sondeoCiudadano -> {

                List<RespuestaCiudadanoResponse> respuestaCiudadanoResponses = sondeoCiudadano
                        .getRespuestaCiudadanos().stream().map(respuestaCiudadano -> {

                                    RespuestaCiudadanoResponse response = new RespuestaCiudadanoResponse();
                                    response.setRespuesta(respuestaCiudadano.getRespuesta());
                                    response.setContent(respuestaCiudadano.getPreguntaAdmin().getContenido());

                                    return response;

                                }

                        ).collect(Collectors.toList());

                return respuestaCiudadanoResponses;

            };

    protected Function<SondeoCiudadanoRequest, SondeoAdmin> mapearTituloSondeoASondeoAdmin
            = sondeoCiudadanoRequest -> sondeoAdminRepository.findByTitulo(sondeoCiudadanoRequest.getTitulo())
                .orElseThrow(() -> new NotFoundException("Sondeo no encontrado"));

    protected Function<SondeoCiudadano, String> mapearSondeoAdminATituloSondeo
            = sondeoCiudadano -> sondeoCiudadano.getSondeoAdmin().getTitulo();


    @Mapping(target="sondeoAdmin",
            expression = "java(mapearTituloSondeoASondeoAdmin.apply(sondeoCiudadanoRequest))")
    @Mapping(target="respuestaCiudadanos",
            expression = "java(mapearRespuestasAEntidad.apply(sondeoCiudadanoRequest))")
    public abstract SondeoCiudadano aEntidad(SondeoCiudadanoRequest sondeoCiudadanoRequest);

    @Mapping(target="tituloSondeo",
            expression = "java(mapearSondeoAdminATituloSondeo.apply(sondeoCiudadano))")
    @Mapping(target="respuestaCiudadanoResponses",
            expression = "java(mapearEntidadARespuestas.apply(sondeoCiudadano))")
    public abstract SondeoCiudadanoResponse aRespuesta(SondeoCiudadano sondeoCiudadano);


}
