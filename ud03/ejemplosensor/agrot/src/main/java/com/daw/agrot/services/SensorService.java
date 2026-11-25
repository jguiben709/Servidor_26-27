package com.daw.agrot.services;

import com.daw.agrot.entities.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SensorService {
    List<Sensor> getAllSensors();
    Page<Sensor> getAllSensorsByNameAndTipo(String name, String tipo, Pageable pageable);
    Sensor getSensorById(Long id);
    List<Sensor> getAllSensorsTemperatura();
    void saveSensor(Sensor sensor);
    void deleteSensorById(Long id);
}
