package com.mercadinho.mercadinho_uniesp.repository;

import com.mercadinho.mercadinho_uniesp.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByItens_Produto_Id(Long produtoId);
}