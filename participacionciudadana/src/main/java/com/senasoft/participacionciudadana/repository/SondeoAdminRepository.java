package com.senasoft.participacionciudadana.repository;

import com.senasoft.participacionciudadana.entity.adminsondeo.SondeoAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SondeoAdminRepository extends JpaRepository<SondeoAdmin, Long> {
    Optional<SondeoAdmin> findByTitulo(String titulo);
}
