package com.mercadinho.mercadinho_uniesp.controller;

import com.mercadinho.mercadinho_uniesp.model.Produto;
import com.mercadinho.mercadinho_uniesp.model.Venda;
import com.mercadinho.mercadinho_uniesp.service.VendaService;
import com.mercadinho.mercadinho_uniesp.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final VendaService vendaService;
    private final ProdutoService produtoService;


    @GetMapping("/vendas-por-produto/{produtoId}")
    public ResponseEntity<List<Venda>> obterVendasPorProduto(@PathVariable Long produtoId) {
        // Verifica se o produto existe (opcional, mas boa prática)
        Optional<Produto> produto = produtoService.buscarPorId(produtoId);
        if (produto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 se o produto não existe
        }

        // Busca as vendas relacionadas a este produto
        List<Venda> vendasDoProduto = vendaService.buscarVendasPorProdutoId(produtoId);

        if (vendasDoProduto.isEmpty()) {
            // Se não houver vendas, retorna 404 (ou 200 com lista vazia, dependendo da regra de negócio)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(vendasDoProduto, HttpStatus.OK);
    }
}