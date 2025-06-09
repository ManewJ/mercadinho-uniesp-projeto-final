package com.mercadinho.mercadinho_uniesp.service;

import com.mercadinho.mercadinho_uniesp.feign.PokeClient;
import com.mercadinho.mercadinho_uniesp.model.PokemonDTO;
import org.springframework.stereotype.Service;


@Service
public class PokeService {
    private final PokeClient pokeClient;
    public PokeService(PokeClient pokeClient) {
        this.pokeClient = pokeClient;
    }
    public PokemonDTO buscarPokemon(String name) {
        return pokeClient.buscarPokemon(name);
    }
}
