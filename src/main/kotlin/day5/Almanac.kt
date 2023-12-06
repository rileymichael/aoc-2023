package com.github.rileymichael.aoc2023.day5

import com.github.rileymichael.aoc2023.shared.chunkedBy
import com.github.rileymichael.aoc2023.shared.longs

data class Almanac(
    val seeds: List<Long>,
    val maps: List<AlmanacMap>,
) {
    companion object {
        fun parse(value: Sequence<String>): Almanac {
            val chunked = value.chunkedBy(String::isBlank).toList()
            val seeds = chunked.first().flatMap(String::longs)
            val maps = chunked.drop(1).map(AlmanacMap::parse)
            return Almanac(
                seeds,
                maps,
            )
        }
    }
}
