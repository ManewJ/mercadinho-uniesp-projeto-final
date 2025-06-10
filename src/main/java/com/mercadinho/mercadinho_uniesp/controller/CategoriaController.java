package com.mercadinho.mercadinho_uniesp.controller;

import com.mercadinho.mercadinho_uniesp.model.Categoria;
import com.mercadinho.mercadinho_uniesp.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody String nome) {
        try {
            Categoria novaCategoria = categoriaService.cadastrarCategoria(nome);
            return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao cadastrar categoria: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.err.println("Erro interno ao cadastrar categoria: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.buscarCategoriaPorId(id);
        return categoria.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        boolean deletado = categoriaService.deletarCategoria(id);
        if (deletado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}