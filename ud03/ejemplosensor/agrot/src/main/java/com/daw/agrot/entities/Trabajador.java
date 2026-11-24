package com.daw.agrot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity(name = "trabajadores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(unique = true)
    private String email;

    private String telefono;
    private Double edad;
    private Double salario;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
    private List<ParcelaTrabajador> parcelasTrabajador;

}
