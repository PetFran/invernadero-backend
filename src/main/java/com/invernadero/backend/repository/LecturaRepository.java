package com.invernadero.backend.repository;

import com.invernadero.backend.model.Lectura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LecturaRepository extends JpaRepository<Lectura, Long> {
    //ultima lectura registrada (por fecha)
    Optional<Lectura> findTopByOrderByFechaHoraDesc();
}
