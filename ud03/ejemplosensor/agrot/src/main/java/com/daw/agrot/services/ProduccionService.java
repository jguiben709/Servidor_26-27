package com.daw.agrot.services;

import com.daw.agrot.entities.Produccion;

import java.util.List;

public interface ProduccionService {
    List<Produccion> getAllProducciones();
    Produccion getProduccionById(Long id);
    void saveProduccion(Produccion produccion);
    void deleteProduccionById(Long id);
}
