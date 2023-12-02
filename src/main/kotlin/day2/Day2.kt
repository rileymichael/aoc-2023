package com.github.rileymichael.day2

import com.github.rileymichael.Puzzle

data class Game(
    val id: Int,
    val sets: List<GameSet>
)

data class GameSet(
    val red: Int,
    val green: Int,
    val blue: Int,
) {
    fun contains(other: GameSet) = red >= other.red && green >= other.green && blue >= other.blue

    fun max(other: GameSet) = GameSet(
        red = maxOf(red, other.red),
        green = maxOf(green, other.green),
        blue = maxOf(blue, other.blue),
    )
}

fun Game.possible(set: GameSet) = sets.all(set::contains)

fun Game.minSet() = sets.reduce(GameSet::max)

fun GameSet.power() = red * green * blue

object Day2 : Puzzle<Sequence<Game>>(2) {
    private val pattern = "(\\d+) (blue|red|green)".toRegex()

    override fun parse(input: Sequence<String>): Sequence<Game> = input.mapIndexed { index, line ->
        val sets = line.split(";").map {
            val colors = pattern.findAll(it).associate { match ->
                val (count, color) = match.destructured
                color to count.toInt()
            }
            GameSet(
                red = colors["red"] ?: 0,
                green = colors["green"] ?: 0,
                blue = colors["blue"] ?: 0,
            )
        }
        Game(index + 1, sets)
    }

    override fun part1(input: Sequence<Game>): Any {
        val bag = GameSet(red = 12, green = 13, blue = 14)
        return input.filter { game -> game.possible(bag) }.sumOf(Game::id)
    }

    override fun part2(input: Sequence<Game>) = input.sumOf { game -> game.minSet().power() }
}