package com.example.seuApp.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "COMENTARIO")
@Entity(name = "COMENTARIO")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "ID_COMENTARIO")

public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comentario_seq" )
    @SequenceGenerator(name = "comentario_seq", sequenceName = "comentario_seq", allocationSize = 1) // Ajustado para 1
    private Integer ID_COMENTARIO;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Product product;

    private Integer CLASSIFICACAO;

    private String COMENTARIOS;

    private String EMAIL;

    public Comments(RequestComments requestComments){
        this.product = requestComments.product();
        this.CLASSIFICACAO = requestComments.CLASSIFICACAO();
        this.COMENTARIOS = requestComments.COMENTARIOS();
        this.EMAIL = requestComments.EMAIL();
    }
    public Comments(){}

}
