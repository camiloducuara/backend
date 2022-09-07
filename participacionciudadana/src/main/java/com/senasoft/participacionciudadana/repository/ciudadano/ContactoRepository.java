package com.senasoft.participacionciudadana.repository.ciudadano;

import com.senasoft.participacionciudadana.entity.ciudadano.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
