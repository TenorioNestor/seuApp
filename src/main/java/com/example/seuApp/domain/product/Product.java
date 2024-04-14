package com.example.seuApp.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name="PRODUTO")
@Entity(name="PRODUTO")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "ID_PRODUTO")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produto_seq" )
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1) // Ajustado para 1
    private Integer ID_PRODUTO;

    private String NOME;

    private String DESCRICAO;

    private Integer PRICE;

    private Boolean DISPONIVEL;

    private Boolean DESTAQUE;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Category category;

    public Product(RequestProduct requestProduct){
        this.NOME = requestProduct.NOME();
        this.category = requestProduct.category();
        this.DESCRICAO = requestProduct.DESCRICAO();
        this.PRICE = requestProduct.PRICE();
        this.DISPONIVEL = requestProduct.DISPONIVEL();
        this.DESTAQUE = requestProduct.DESTAQUE();
    }
    public Product(){}
}
