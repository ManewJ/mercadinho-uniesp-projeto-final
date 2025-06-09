package com.mercadinho.mercadinho_uniesp.feign;

import com.mercadinho.mercadinho_uniesp.model.PokemonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "pokeClient", url = "https://pokeapi.co/api/v2")


public interface PokeClient {
    @GetMapping("/pokemon/{name}")
    PokemonDTO buscarPokemon(@PathVariable("name") String name);
}
