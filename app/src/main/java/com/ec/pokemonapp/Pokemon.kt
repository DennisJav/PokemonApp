package com.ec.pokemonapp

data class Pokemon(
    val id: Long,
    val name: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val Speed: Int,
    val type: PokemonType
) {
    enum class PokemonType {
        GRASS, FIRE, WATER, FIGHTER, ELECTRIC
    }
}