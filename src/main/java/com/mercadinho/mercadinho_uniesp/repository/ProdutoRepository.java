package com.mercadinho.mercadinho_uniesp.repository;

import com.mercadinho.mercadinho_uniesp.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByEstoqueLessThan(int quantidade);

}
