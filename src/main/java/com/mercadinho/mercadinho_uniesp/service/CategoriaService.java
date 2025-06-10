package com.mercadinho.mercadinho_uniesp.service;

import com.mercadinho.mercadinho_uniesp.model.Categoria;
import com.mercadinho.mercadinho_uniesp.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;


    public Categoria cadastrarCategoria(String nome)  {
        if (categoriaRepository.existsByNome(nome)) {
            throw new IllegalArgumentException("Já existe uma categoria com o nome: '" + nome + "'.");
        }
        Categoria novaCategoria = Categoria.builder()
                .nome(nome)
                .build();
        return categoriaRepository.save(novaCategoria);
    }

    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public boolean deletarCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
