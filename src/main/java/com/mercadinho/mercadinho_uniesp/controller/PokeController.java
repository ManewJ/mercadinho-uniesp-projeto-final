package com.mercadinho.mercadinho_uniesp.controller;

import com.mercadinho.mercadinho_uniesp.model.PokemonDTO;
import com.mercadinho.mercadinho_uniesp.service.PokeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pokemon")

public class PokeController {

    private final PokeService pokeService;

    public PokeController(PokeService pokeService) {
        this.pokeService = pokeService;
    }


    @GetMapping("/{name}")
    public PokemonDTO buscar(@PathVariable String name) {
        return pokeService.buscarPokemon(name);
    }
}

