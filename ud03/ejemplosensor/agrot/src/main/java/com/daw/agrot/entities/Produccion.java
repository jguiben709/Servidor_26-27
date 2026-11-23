package com.daw.agrot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Long id;

    private String producto;

    private Calidad calidad;

    //Puedo sembrar varios cultivos en una parcela, pero cada producción pertenece a una parcela concreta
    @ManyToOne
    @JoinColumn(name = "parcela_id")
    private Parcela parcela;

}
