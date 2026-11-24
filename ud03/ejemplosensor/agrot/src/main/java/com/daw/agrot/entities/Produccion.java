package com.daw.agrot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "producciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El producto no puede estar vacío")
    private String producto;

    @NotNull(message = "La calidad no puede estar vacía")
    @Enumerated(EnumType.STRING)
    private Calidad calidad;

    //Puedo sembrar varios cultivos en una parcela, pero cada producción pertenece a una parcela concreta
    @ManyToOne
    @JoinColumn(name = "parcela_id")
    private Parcela parcela;

}
