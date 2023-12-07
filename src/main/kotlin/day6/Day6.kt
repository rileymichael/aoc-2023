package com.github.rileymichael.aoc2023.day6

import com.github.rileymichael.aoc2023.Puzzle
import com.github.rileymichael.aoc2023.shared.ints

data class RaceDocument(
    val races: List<Race>
)

data class Race(
    val time: Int,
    val record: Int,
)

object Day6: Puzzle<RaceDocument>(6) {
    override fun parse(input: Sequence<String>): RaceDocument {
        val (times, distances) = input.map { line -> line.ints() }.toList()
        val races = times.zip(distances).map { Race(it.first, it.second) }
        return RaceDocument(races.toList())
    }

    override fun part1(input: RaceDocument): Any {
        return input.races.map { race ->
            (1 until race.time).count { speed ->
                ((race.time - speed) * speed) > race.record
            }
        }.reduce(Int::times)
    }

    override fun part2(input: RaceDocument): Any {
        TODO("Not yet implemented")
    }
}