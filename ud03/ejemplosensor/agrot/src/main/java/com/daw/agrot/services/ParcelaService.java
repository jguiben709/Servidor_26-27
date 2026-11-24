package com.daw.agrot.services;

import com.daw.agrot.entities.Parcela;
import com.daw.agrot.entities.Sensor;

import java.util.List;

public interface ParcelaService {

    List<Parcela> getAllParcels();
    List<Parcela> getAllParcelsByNameAndTipo(String name, String tipo);
    Parcela getParcelById(Long id);
    void saveParcel(Parcela parcela);
    void deleteParcelById(Long id);
    double superficieTotal();
    void asignarTrabajadorToParcela(Long id, Long trabajadorId, String fechaInicio);
}
