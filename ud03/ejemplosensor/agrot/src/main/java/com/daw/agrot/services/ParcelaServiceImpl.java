package com.daw.agrot.services;

import com.daw.agrot.entities.Parcela;
import com.daw.agrot.entities.TipoCultivo;
import com.daw.agrot.exceptions.RecursoNoEncontradoException;
import com.daw.agrot.repositories.ParcelaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelaServiceImpl implements ParcelaService {

    private static final Logger logger = LoggerFactory.getLogger(ParcelaServiceImpl.class);

    public final ParcelaRepository parcelaRepository;

    public ParcelaServiceImpl(ParcelaRepository parcelaRepository) {
        this.parcelaRepository = parcelaRepository;
    }


    @Override
    public List<Parcela> getAllParcels() {
        return parcelaRepository.findAll();
    }

    @Override
    public List<Parcela> getAllParcelsByNameAndTipo(String name, String tipo) {
        if (tipo.equals("TODOS")) {
            return parcelaRepository.findAllByNameContainingIgnoreCase(name);
        } else {
            return parcelaRepository.findAllByNameContainingIgnoreCaseAndTipoEquals(name, TipoCultivo.valueOf(tipo));
        }
    }

    @Override
    public Parcela getParcelById(Long id) {
        return parcelaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Parcela con id " +
                                id + " no encontrada"));
    }

    @Override
    public void saveParcel(Parcela parcela) {
        parcelaRepository.save(parcela);
    }

    @Override
    public void deleteParcelById(Long id) {
        parcelaRepository.deleteById(id);
    }

    @Override
    public double superficieTotal() {
        return parcelaRepository.findAll().stream()
                .mapToDouble(Parcela::getSuperficie)
                .sum();
    }
}
