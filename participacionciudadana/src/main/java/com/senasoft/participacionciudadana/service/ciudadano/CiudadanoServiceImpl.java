package com.senasoft.participacionciudadana.service.ciudadano;

import com.senasoft.participacionciudadana.entity.ciudadano.Ciudadano;
import com.senasoft.participacionciudadana.repository.ciudadano.CiudadanoRepository;
import com.senasoft.participacionciudadana.service.ciudadano.mapper.CiudadanoMapper;
import com.senasoft.participacionciudadana.service.ciudadano.request.CiudadanoRequest;
import com.senasoft.participacionciudadana.service.ciudadano.response.CiudadanoResponse;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CiudadanoServiceImpl implements CiudadanoService{

    private CiudadanoRepository ciudadanoRepository;
    private CiudadanoMapper ciudadanoMapper;

    public CiudadanoServiceImpl(CiudadanoRepository ciudadanoRepository, CiudadanoMapper ciudadanoMapper) {
        this.ciudadanoRepository = ciudadanoRepository;
        this.ciudadanoMapper = ciudadanoMapper;
    }

    @Override
    public void crear(CiudadanoRequest ciudadanoRequest) {
        ciudadanoRepository.save(ciudadanoMapper.aEntidad(ciudadanoRequest));
    }

    @Override
    public List<CiudadanoResponse> obtenerTodos() {
        return ciudadanoRepository.findAll().stream().map(ciudadanoMapper::aRespuesta)
                .collect(Collectors.toList());
    }

    @Override
    public CiudadanoResponse obtenerPorNumeroDeDocumento(String numeroDeDocumento) {

        List<Ciudadano> ciudadanos = ciudadanoRepository.findAll();

        List<Ciudadano> ciudadanosPorNumeroDeDocumento = ciudadanos.stream().filter(
                ciudadano -> numeroDeDocumento.equals(ciudadano.getIdentificacion().getNumeroDocumento())
        ).collect(Collectors.toList());

        if (ciudadanosPorNumeroDeDocumento.isEmpty()){
            throw new NotFoundException("Ciudadano no encontrado");
        }

        return ciudadanosPorNumeroDeDocumento.stream()
                .map(ciudadanoMapper::aRespuesta).collect(Collectors.toList()).get(0);
    }

    @Override
    public CiudadanoResponse obtenerPorEtnia(String etnia) {

        List<Ciudadano> ciudadanos = ciudadanoRepository.findAll();

        List<Ciudadano> ciudadanosPorNumeroDeDocumento = ciudadanos.stream().filter(
                ciudadano -> etnia.equals(ciudadano.getIdentificacion().getEtnia())
        ).collect(Collectors.toList());

        if (ciudadanosPorNumeroDeDocumento.isEmpty()){
            throw new NotFoundException("Ciudadano no encontrado");
        }

        return ciudadanosPorNumeroDeDocumento.stream()
                .map(ciudadanoMapper::aRespuesta).collect(Collectors.toList()).get(0);
    }
}
