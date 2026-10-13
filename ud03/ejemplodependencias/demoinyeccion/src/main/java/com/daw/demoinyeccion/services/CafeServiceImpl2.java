package com.daw.demoinyeccion.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class CafeServiceImpl2 implements CafeService {

    @Override
    public String getAllCafes() {
        return "Café 1 - Café 2 - Café 3";
    }

    @Override
    public String getCafeById(Long id) {
        return "CAFÉ: " + id;
    }
}
