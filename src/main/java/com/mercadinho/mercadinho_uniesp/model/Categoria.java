package com.mercadinho.mercadinho_uniesp.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; // Importa a anotação NoArgsConstructor do Lombok
import lombok.AllArgsConstructor; // Importa a anotação AllArgsConstructor do Lombok (útil com Builder)

@Entity
@Data
@Builder
@NoArgsConstructor // Adiciona um construtor sem argumentos
@AllArgsConstructor // Adiciona um construtor com todos os argumentos (geralmente usado com @Builder)
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;
}