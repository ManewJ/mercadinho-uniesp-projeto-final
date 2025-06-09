package com.mercadinho.mercadinho_uniesp.service;

import com.mercadinho.mercadinho_uniesp.model.ItemVenda;
import com.mercadinho.mercadinho_uniesp.model.Produto;
import com.mercadinho.mercadinho_uniesp.model.Venda;
import com.mercadinho.mercadinho_uniesp.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VendaService {


    private final VendaRepository vendaRepository;


    private final ProdutoService produtoService; // Adicionando o ProdutoService

    @Transactional
    public Venda criar(Venda venda) {
        venda.setData(LocalDateTime.now());
        BigDecimal valorTotal = BigDecimal.ZERO;

        if (venda.getItens() != null) {
            for (ItemVenda item : venda.getItens()) {
                item.setVenda(venda);
                Optional<Produto> produtoOptional = produtoService.buscarPorId(item.getProduto().getId());
                if (produtoOptional.isPresent()) {
                    Produto produto = produtoOptional.get();
                    item.setProduto(produto); // Garante que o produto anexado ao item esteja atualizado
                    item.setPrecoUnitario(produto.getPreco());
                    BigDecimal precoItem = produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));
                    valorTotal = valorTotal.add(precoItem);
                } else {
                    // Tratar o caso em que o produto não foi encontrado
                    throw new RuntimeException("Produto com ID " + item.getProduto().getId() + " não encontrado.");
                }
            }
            venda.setValorTotal(valorTotal);
        }

        return vendaRepository.save(venda);
    }

    public Optional<Venda> buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

    public List<Venda> buscarVendasPorProdutoId(Long produtoId) {
        return vendaRepository.findByItens_Produto_Id(produtoId);
    }

    @Transactional
    public boolean deletar(Long id) {
        if (vendaRepository.existsById(id)) {
            vendaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}