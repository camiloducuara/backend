package com.senasoft.participacionciudadana.service.sondeouser;

import com.senasoft.participacionciudadana.entity.ciudadano.Ciudadano;
import com.senasoft.participacionciudadana.entity.ciudadano.Identificacion;
import com.senasoft.participacionciudadana.entity.ciudadanosondeo.RespuestaCiudadano;
import com.senasoft.participacionciudadana.entity.ciudadanosondeo.SondeoCiudadano;
import com.senasoft.participacionciudadana.repository.ciudadano.IdentificacionRepository;
import com.senasoft.participacionciudadana.repository.ciudadanosondeo.SondeoCiudadanoRepository;
import com.senasoft.participacionciudadana.service.exception.BadRequestException;
import com.senasoft.participacionciudadana.service.sondeouser.mapper.SondeoCiudadanoMapper;
import com.senasoft.participacionciudadana.service.sondeouser.request.SondeoCiudadanoRequest;
import com.senasoft.participacionciudadana.service.sondeouser.response.SondeoCiudadanoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SondeoUserServiceImpl implements SondeoUserService{

    private SondeoCiudadanoRepository sondeoCiudadanoRepository;
    private SondeoCiudadanoMapper sondeoCiudadanoMapper;

    private IdentificacionRepository identificacionRepository;

    public SondeoUserServiceImpl(SondeoCiudadanoRepository sondeoCiudadanoRepository,
                                 SondeoCiudadanoMapper sondeoCiudadanoMapper,
                                 IdentificacionRepository identificacionRepository) {

        this.sondeoCiudadanoRepository = sondeoCiudadanoRepository;
        this.sondeoCiudadanoMapper = sondeoCiudadanoMapper;
        this.identificacionRepository = identificacionRepository;
    }

    @Override
    public void responderSondeo(SondeoCiudadanoRequest sondeoCiudadanoRequest) {
        SondeoCiudadano sondeoCiudadano = sondeoCiudadanoMapper.aEntidad(sondeoCiudadanoRequest);

        List<RespuestaCiudadano> respuestaCiudadanos = sondeoCiudadano.getRespuestaCiudadanos()
                .stream().peek(respuestaCiudadano ->
                        respuestaCiudadano.setSondeo(sondeoCiudadano)).collect(Collectors.toList());

        sondeoCiudadano.setRespuestaCiudadanos(respuestaCiudadanos);

        List<Identificacion> identificaciones = identificacionRepository.findAll();

        Identificacion identificacion = identificaciones.stream().filter(identificacionOfList ->
                sondeoCiudadanoRequest.getUsername().equals(identificacionOfList.getCuenta().getUsername())
        ).collect(Collectors.toList()).get(0);

        if (sondeoCiudadano.getSondeoAdmin().getEtniaDirigida().equals(identificacion.getEtnia())){
            sondeoCiudadanoRepository.save(sondeoCiudadano);
        }if (sondeoCiudadano.getSondeoAdmin().getEtniaDirigida().equals("NA")){
            sondeoCiudadanoRepository.save(sondeoCiudadano);
        }else {
            throw new BadRequestException("Este sondeo no va dirigido a tu etnia");
        }

    }

    @Override
    public List<SondeoCiudadanoResponse> obtenerSondeosPorNombreDeUsuario(String username) {

        List<SondeoCiudadano> sondeoCiudadanos = sondeoCiudadanoRepository.findAll().stream()
                .filter(sondeoCiudadano -> username.equals(sondeoCiudadano.getUsername()))
                .collect(Collectors.toList());

        return sondeoCiudadanos.stream().map(sondeoCiudadanoMapper::aRespuesta).collect(Collectors.toList());
    }

    @Override
    public List<SondeoCiudadanoResponse> ObtenerTodosLosSondeos() {
        return sondeoCiudadanoRepository.findAll()
                .stream().map(sondeoCiudadanoMapper::aRespuesta).collect(Collectors.toList());
    }

    @Override
    public List<SondeoCiudadanoResponse> obtenerSondeosPorEtnia(String etnia) {

        List<SondeoCiudadano> sondeoCiudadanos = sondeoCiudadanoRepository.findAll().stream()
                .filter(sondeoCiudadano -> etnia.equals(sondeoCiudadano.getSondeoAdmin().getEtniaDirigida()))
                .collect(Collectors.toList());

        return sondeoCiudadanos.stream().map(sondeoCiudadanoMapper::aRespuesta).collect(Collectors.toList());
    }
}
