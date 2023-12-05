package com.github.rileymichael.day2

data class Game(
    val id: Int,
    val sets: List<GameSet>
)

fun Game.possible(set: GameSet) = sets.all(set::contains)

fun Game.minSet() = sets.reduce(GameSet::max)

fun String.toGame(id: Int): Game {
    val sets = split(";").map(String::toGameSet)
    return Game(id, sets)
}