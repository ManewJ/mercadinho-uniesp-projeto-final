package com.mercadinho.mercadinho_uniesp.model;

import java.util.List;


public class PokemonDTO {
    private String name;
    private int height;
    private int weight;
    public static class AbilityWrapper {
        private Ability ability;
        public Ability getAbility() { return ability; }
        public void setAbility(Ability ability) { this.ability =
                ability; }
    }
    public static class Ability {
        private String name;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
    private List<AbilityWrapper> abilities;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    public List<AbilityWrapper> getAbilities() { return abilities; }
    public void setAbilities(List<AbilityWrapper> abilities) {
        this.abilities = abilities; }
}


