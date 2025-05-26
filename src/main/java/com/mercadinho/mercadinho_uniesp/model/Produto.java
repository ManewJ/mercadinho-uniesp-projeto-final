package com.mercadinho.mercadinho_uniesp.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_gen")
    @SequenceGenerator(name = "produto_gen", sequenceName = "tb_produto_id_seq", allocationSize = 1)
    private Long id;

    private String nome;
    private String categoria;
    private BigDecimal preco;
    private Integer estoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itensVenda; // Nome da lista
}