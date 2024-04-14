package com.example.seuApp.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name="CATEGORIA")
@Entity(name = "CATEGORIA")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "ID_CATEGORIA")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categoria_seq" )
    @SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_seq", allocationSize = 1) // Ajustado para 1

    private Integer ID_CATEGORIA;

    private String NOME;

    private Boolean DISPONIVEL;

    public Category(RequestCategory requestCategory){
        this.NOME = requestCategory.NOME();
        this.DISPONIVEL = requestCategory.DISPONIVEL();

    }
    public Category() {}
}
