package com.daw.agrot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "parcelas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "La ubicación no puede estar vacía")
    @Column(nullable = false)
    private String ubicacion;

    @NotNull(message = "La superficie no puede estar vacía")
    @Positive(message = "La superficie debe ser mayor que 0")
    private Double superficie;

    @NotNull(message = "El tipo de cultivo no puede estar vacío")
    private TipoCultivo tipo;




}
