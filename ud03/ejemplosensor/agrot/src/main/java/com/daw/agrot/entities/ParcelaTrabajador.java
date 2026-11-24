package com.daw.agrot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "parcela_trabajador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParcelaTrabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_parcela", nullable = false)
    private Parcela parcela;

    @ManyToOne
    @JoinColumn(name = "id_trabajador", nullable = false)
    private Trabajador trabajador;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

}
