package com.senasoft.participacionciudadana.repository.ciudadano;

import com.senasoft.participacionciudadana.entity.ciudadano.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Optional<Cuenta> findByUsername(String username);
}
