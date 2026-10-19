package com.daw.agrot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String model;

    @Enumerated(EnumType.STRING)
    private TipoSensor tipo_sensor;

    private String unidad_medida;
    private String estado;
    private Double latitud;
    private Double longitud;



}
