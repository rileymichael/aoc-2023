package com.github.rileymichael.aoc2023.day2

import com.github.rileymichael.aoc2023.Puzzle

object Day2 : Puzzle<Sequence<Game>>(2) {
    override fun parse(input: Sequence<String>): Sequence<Game> = input.mapIndexed { index, line ->
        line.toGame(index + 1)
    }

    override fun part1(input: Sequence<Game>): Any {
        val bag = GameSet(red = 12, green = 13, blue = 14)
        return input.filter { game -> game.possible(bag) }.sumOf(Game::id)
    }

    override fun part2(input: Sequence<Game>) = input.sumOf { game -> game.minSet().power }
}