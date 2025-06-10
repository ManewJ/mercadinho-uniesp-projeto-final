package com.mercadinho.mercadinho_uniesp.service;

import com.mercadinho.mercadinho_uniesp.model.Cliente;
import com.mercadinho.mercadinho_uniesp.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {


    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente criar(Cliente cliente) {
        cliente.setId(null); // Garante que o ID seja nulo para forçar a criação
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public boolean deletar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}