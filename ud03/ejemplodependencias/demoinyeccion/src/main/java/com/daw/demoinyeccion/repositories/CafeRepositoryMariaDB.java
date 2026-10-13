package com.daw.demoinyeccion.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CafeRepositoryMariaDB implements CafeRepository {
    List<String> cafes = List.of("1. Colombia", "2. Brasil", "3. Perú", "4. Guatemala");

    @Override
    public String getAllCafes() {
        return cafes.toString();
    }

    @Override
    public String getCafeById(long id) {
        Optional<String> salida = cafes.stream()
                .filter(cafe -> cafe.startsWith(String.valueOf(id) + "."))
                .findFirst();
        return salida.orElse("No encontrado");
    }
}
