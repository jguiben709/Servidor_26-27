package com.daw.demoinyeccion.services;

import com.daw.demoinyeccion.repositories.CafeRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CafeServiceImpl implements CafeService {
    private final CafeRepository cafeRepository;

    //Constructor injection
    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Override
    public String getAllCafes() {
        return cafeRepository.getAllCafes();
    }

    @Override
    public String getCafeById(Long id) {
        if (id == null || id <= 0) {
            return "ID de café no válido";
        }
        return cafeRepository.getCafeById(id);

    }
}
