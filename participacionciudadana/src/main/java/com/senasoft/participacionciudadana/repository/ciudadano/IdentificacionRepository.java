package com.senasoft.participacionciudadana.repository.ciudadano;

import com.senasoft.participacionciudadana.entity.ciudadano.Identificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdentificacionRepository extends JpaRepository<Identificacion, Long> {
    Optional<Identificacion> findByNumeroDocumento(String numeroDocumento);
}
