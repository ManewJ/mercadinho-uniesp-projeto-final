package com.mercadinho.mercadinho_uniesp.repository;

import com.mercadinho.mercadinho_uniesp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByNome(String nome);

    Optional<Cliente> findByEmail(String email);

    boolean existsByTelefone(String telefone);








}