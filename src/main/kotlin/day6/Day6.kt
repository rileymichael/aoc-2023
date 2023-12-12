package com.github.rileymichael.aoc2023.day6

import com.github.rileymichael.aoc2023.Puzzle
import com.github.rileymichael.aoc2023.shared.ints
import com.github.rileymichael.aoc2023.shared.longs

data class RaceDocument(
    val races: List<Race>
)

object Day6: Puzzle<RaceDocument>(6) {
    override fun parse(input: Sequence<String>): RaceDocument {
        val (times, distances) = input.map { line -> line.longs() }.toList()
        val races = times.zip(distances).map { Race(it.first, it.second) }
        return RaceDocument(races.toList())
    }

    override fun part1(input: RaceDocument): Any {
        return input.races.map(Race::wins).reduce { acc, i -> i * acc }
    }

    override fun part2(input: RaceDocument): Any {
        val single = Race(
            time = input.races.map { it.time }.joinToString(separator = "").toLong(),
            record = input.races.map { it.record }.joinToString(separator = "").toLong(),
        )
        return single.wins()
    }
}