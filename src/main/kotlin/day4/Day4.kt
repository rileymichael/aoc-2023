package com.github.rileymichael.aoc2023.day4

import com.github.rileymichael.aoc2023.Puzzle

object Day4: Puzzle<Sequence<Scratchcard>>(4) {
    override fun parse(input: Sequence<String>): Sequence<Scratchcard> = input.map(Scratchcard::parse)

    override fun part1(input: Sequence<Scratchcard>) = input.sumOf(Scratchcard::points)

    override fun part2(input: Sequence<Scratchcard>): Any {
        val cards = input.toList()
        val counts = IntArray(cards.size) { 1 }
        cards.forEach { card ->
            repeat(card.matches.size) { i ->
                counts[card.number + i] += counts[card.number - 1]
            }
        }
        return counts.sum()
    }
}