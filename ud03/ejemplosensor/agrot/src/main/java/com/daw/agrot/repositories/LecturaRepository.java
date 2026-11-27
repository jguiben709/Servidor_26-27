package com.daw.agrot.repositories;

import com.daw.agrot.entities.Lectura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface LecturaRepository extends JpaRepository<Lectura, Long> {

    Page<Lectura> findAllBySensorIdAndFechaHoraBetween(Long sensorId,
                                                       LocalDateTime fechaHoraAfter,
                                                       LocalDateTime fechaHoraBefore,
                                                       Pageable pageable);


}
