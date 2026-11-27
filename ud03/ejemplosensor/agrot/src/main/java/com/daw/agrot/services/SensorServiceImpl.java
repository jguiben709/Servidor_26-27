package com.daw.agrot.services;

import com.daw.agrot.entities.Lectura;
import com.daw.agrot.exceptions.RecursoNoEncontradoException;
import com.daw.agrot.entities.Sensor;
import com.daw.agrot.entities.TipoSensor;
import com.daw.agrot.repositories.LecturaRepository;
import com.daw.agrot.repositories.SensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private static final Logger logger = LoggerFactory.getLogger(SensorServiceImpl.class);

    public final SensorRepository sensorRepository;
    public final LecturaRepository lecturaRepository;

    public SensorServiceImpl(SensorRepository sensorRepository, LecturaRepository lecturaRepository) {
        this.sensorRepository = sensorRepository;
        this.lecturaRepository = lecturaRepository;
    }


    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    public Page<Sensor> getAllSensorsByNameAndTipo(String name, String tipo, Pageable pageable) {
        if (tipo.equals("TODOS")) {
            return sensorRepository.findAllByNameContainingIgnoreCase(name, pageable);
        } else {
            return sensorRepository.findAllByNameContainingIgnoreCaseAndTipoEquals(name, TipoSensor.valueOf(tipo), pageable);
        }
    }

    @Override
    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Sensor con id " +
                                id + " no encontrado"));
    }

    @Override
    public List<Sensor> getAllSensorsTemperatura() {
        logger.debug("Obteniendo todos los sensores de temperatura");
        return sensorRepository.findAllByTipoEquals(TipoSensor.TEMPERATURA);
    }

    @Override
    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public void deleteSensorById(Long id) {
        sensorRepository.deleteById(id);
    }

    //LECTURAS ----------------------------
    public Page<Lectura> findAllLecturasBySensorIdBetweenFechaHora(Long sensorId, LocalDateTime start,
                                                                   LocalDateTime end, Pageable pageable) {
        if (start != null && end != null) {
            return lecturaRepository.findAllBySensorIdAndFechaHoraBetween(sensorId, start, end, pageable);
        } else {
            return lecturaRepository.findAllBySensorId(sensorId, pageable);
        }

    }



}
