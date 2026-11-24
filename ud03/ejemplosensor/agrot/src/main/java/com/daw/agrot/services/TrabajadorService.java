package com.daw.agrot.services;

import com.daw.agrot.entities.Parcela;
import com.daw.agrot.entities.Trabajador;

import java.util.List;

public interface TrabajadorService {

    List<Trabajador> getAllTrabajadores();
    Trabajador getTrabajadorById(Long id);
    void saveTrabajador(Trabajador trabajador);
    void deleteTrabajadorById(Long id);
}
