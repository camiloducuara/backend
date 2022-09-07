package com.senasoft.participacionciudadana.service.sondeoadmin;

import com.senasoft.participacionciudadana.entity.adminsondeo.PreguntaAdmin;
import com.senasoft.participacionciudadana.entity.adminsondeo.SondeoAdmin;
import com.senasoft.participacionciudadana.repository.adminsondeo.SondeoAdminRepository;
import com.senasoft.participacionciudadana.service.exception.BadRequestException;
import com.senasoft.participacionciudadana.service.exception.NotFoundException;
import com.senasoft.participacionciudadana.service.sondeoadmin.mapper.SondeoAdminMapper;
import com.senasoft.participacionciudadana.service.sondeoadmin.request.SondeoAdminRequest;
import com.senasoft.participacionciudadana.service.sondeoadmin.response.SondeoAdminResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SondeoAdminServiceImpl implements SondeoAdminService {

    private SondeoAdminRepository sondeoAdminRepository;
    private SondeoAdminMapper sondeoAdminMapper;

    public SondeoAdminServiceImpl(SondeoAdminRepository sondeoAdminRepository, SondeoAdminMapper sondeoAdminMapper) {
        this.sondeoAdminRepository = sondeoAdminRepository;
        this.sondeoAdminMapper = sondeoAdminMapper;
    }

    @Override
    public void create(SondeoAdminRequest sondeoAdminRequest) {

        if (sondeoAdminRepository.findByTitulo(sondeoAdminRequest.getTitulo()).isPresent()){
            throw new BadRequestException("Ya existe un sondeo con el mismo titulo");
        }

        SondeoAdmin sondeoAdmin = sondeoAdminMapper.aEntidad(sondeoAdminRequest);

        List<PreguntaAdmin> preguntaAdmins = sondeoAdmin.getPreguntaAdmins().stream().map(
                preguntaAdmin -> {
                    preguntaAdmin.setSondeoAdmin(sondeoAdmin);
                    return preguntaAdmin;
                }
        ).collect(Collectors.toList());

        sondeoAdmin.setPreguntaAdmins(preguntaAdmins);

        sondeoAdminRepository.save(sondeoAdmin);
    }

    @Override
    public List<SondeoAdminResponse> getAll() {
        return sondeoAdminRepository.findAll().stream().map(sondeoAdminMapper::aRespuesta)
                .collect(Collectors.toList());
    }

    @Override
    public SondeoAdminResponse getById(Long id) {
        return sondeoAdminMapper.aRespuesta(sondeoAdminRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Sondeo no encontrado")));
        }
        }
