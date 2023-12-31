package com.github.rileymichael.aoc2023.day5

import com.github.rileymichael.aoc2023.Puzzle

object Day5: Puzzle<Almanac>(5) {
    override fun parse(input: Sequence<String>) = Almanac.parse(input)

    override fun part1(input: Almanac): Any {
        return input.seeds.minOf { seed ->
            input.maps.fold(seed) { acc, map ->
                map.get(acc)
            }
        }
    }

    override fun part2(input: Almanac): Any {
        val seedRanges = input.seeds.chunked(2).map { (start, length) ->
            start until start + length
        }
        val reversed = input.reverse()
        return generateSequence(0L, Long::inc).first { loc ->
            val seed = reversed.fold(loc) { acc, map ->
                map.get(acc)
            }
            seedRanges.any { seed in it }
        }
    }
}