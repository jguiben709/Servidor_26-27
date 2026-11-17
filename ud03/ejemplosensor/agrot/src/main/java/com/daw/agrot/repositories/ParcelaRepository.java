package com.daw.agrot.repositories;

import com.daw.agrot.entities.Parcela;
import com.daw.agrot.entities.Sensor;
import com.daw.agrot.entities.TipoCultivo;
import com.daw.agrot.entities.TipoSensor;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
    public List<Parcela> findAllByTipoEquals(@NotBlank(message = "El tipo de cultivo no puede estar vacío") TipoCultivo tipo);
    public List<Parcela> findAllByNameContainingIgnoreCase(String name);
    public List<Parcela> findAllByNameContainingIgnoreCaseAndTipoEquals(String name,
                                         TipoCultivo tipo);

}
