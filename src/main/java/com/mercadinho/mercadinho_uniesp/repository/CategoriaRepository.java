package com.mercadinho.mercadinho_uniesp.repository;

import com.mercadinho.mercadinho_uniesp.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNome(String nome);

}