package com.daw.agrot.services;

import com.daw.agrot.entities.Trabajador;
import com.daw.agrot.exceptions.RecursoNoEncontradoException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.daw.agrot.repositories.TrabajadorRepository;

import java.util.List;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    private final TrabajadorRepository trabajadorRepository;

    public TrabajadorServiceImpl(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    @Override
    public List<Trabajador> getAllTrabajadores() {
        return trabajadorRepository.findAll();
    }

    @Override
    public Trabajador getTrabajadorById(Long id) {
        return trabajadorRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(
                "Trabajador con id " + id + " no encontrado"));
    }

    @Override
    public void saveTrabajador(Trabajador trabajador) {
        trabajadorRepository.save(trabajador);
    }

    @Override
    public void deleteTrabajadorById(Long id) {
        trabajadorRepository.deleteById(id);
    }
}
