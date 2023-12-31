package com.github.rileymichael.aoc2023.day1

import com.github.rileymichael.aoc2023.Puzzle

object Day1 : Puzzle<Sequence<String>>(1) {
    override fun parse(input: Sequence<String>): Sequence<String> = input

    override fun part1(input: Sequence<String>) = input.sumOf { line ->
        val ints = line.filter { char -> char.isDigit() }
        "${ints.first()}${ints.last()}".toInt()
    }

    override fun part2(input: Sequence<String>) = input.sumOf { line ->
        val l = replacements.fold(line) { acc, (match, replacement) ->
            acc.replace(match, replacement)
        }
        val ints = l.filter { char -> char.isDigit() }
        "${ints.first()}${ints.last()}".toInt()
    }
}

private val replacements = listOf(
    "one" to "o1e",
    "two" to "t2o",
    "three" to "t3e",
    "four" to "f4r",
    "five" to "f5e",
    "six" to "s6x",
    "seven" to "s7n",
    "eight" to "e8t",
    "nine" to "n9e",
)


