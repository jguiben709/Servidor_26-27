package com.daw.demoinyeccion.services;

import com.daw.demoinyeccion.repositories.CafeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CafeServiceImpl implements CafeService {
    Logger logger = LoggerFactory.getLogger(CafeServiceImpl.class);

    @Value("${cafe.idioma}")
    private String idioma;

    private final CafeRepository cafeRepository;
    //Constructor injection
    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Override
    public String getAllCafes() {
        logger.debug(idioma + " - Getting all cafes");
        return cafeRepository.getAllCafes();
    }

    @Override
    public String getCafeById(Long id) {
        logger.debug(idioma + " - Getting cafe by id: {}", id);

        if (id == null || id <= 0) {
            logger.info("Cafe id is null or id is negative");
            return "ID de café no válido";
        }
        return cafeRepository.getCafeById(id);

    }
}
