package com.daw.agrot.services;

import com.daw.agrot.entities.Parcela;
import com.daw.agrot.entities.ParcelaTrabajador;
import com.daw.agrot.entities.TipoCultivo;
import com.daw.agrot.entities.Trabajador;
import com.daw.agrot.exceptions.RecursoNoEncontradoException;
import com.daw.agrot.repositories.ParcelaRepository;
import com.daw.agrot.repositories.ParcelaTrabajadorRepository;
import com.daw.agrot.repositories.TrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelaServiceImpl implements ParcelaService {

    private static final Logger logger = LoggerFactory.getLogger(ParcelaServiceImpl.class);

    private final ParcelaRepository parcelaRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final ParcelaTrabajadorRepository parcelaTrabajadorRepository;

    public ParcelaServiceImpl(ParcelaRepository parcelaRepository, TrabajadorRepository trabajadorRepository, ParcelaTrabajadorRepository parcelaTrabajadorRepository) {
        this.parcelaRepository = parcelaRepository;
        this.trabajadorRepository = trabajadorRepository;
        this.parcelaTrabajadorRepository = parcelaTrabajadorRepository;
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

    @Override
    public void asignarTrabajadorToParcela(Long id, Long trabajadorId, String fechaInicio) {
        Parcela parcela = getParcelById(id);
        Trabajador trabajador = trabajadorRepository.findById(trabajadorId).get();

        ParcelaTrabajador pt = new ParcelaTrabajador();
        pt.setParcela(parcela);
        pt.setTrabajador(trabajador);
        pt.setFechaInicio(java.time.LocalDate.parse(fechaInicio));

        parcelaTrabajadorRepository.save(pt);

    }
}
