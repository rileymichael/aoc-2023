package com.github.rileymichael.aoc2023.day3

import com.github.rileymichael.aoc2023.Puzzle
import com.github.rileymichael.aoc2023.shared.Grid
import com.github.rileymichael.aoc2023.shared.Vector2

object Day3 : Puzzle<Schematic>(3) {
    override fun parse(input: Sequence<String>): Schematic {
        return Schematic(input.toList())
    }

    override fun part1(input: Schematic): Any {
        val parts = mutableListOf<Int>()
        (0 until input.height).forEach { y ->
            digits.findAll(input.row(y)).forEach { match ->
                val number = match.value.toInt()
                if (input.adjacentToSymbol(
                        Vector2(match.range.first, y),
                        Vector2(match.range.last, y)
                    ).isNotEmpty()
                ) {
                    parts.add(number)
                }
            }
        }
        return parts.sum()
    }

    override fun part2(input: Schematic): Any {
        val gears = mutableMapOf<Vector2, MutableList<Int>>()
        (0 until input.height).forEach { y ->
            digits.findAll(input.row(y)).forEach { match ->
                val number = match.value.toInt()
                input.adjacentToSymbol(Vector2(match.range.first, y), Vector2(match.range.last, y)).filter {
                    it.second == '*'
                }.forEach { (pos, _) ->
                    gears.getOrPut(pos) { mutableListOf() } += number
                }
            }
        }
        return gears.values.filter { it.size == 2 }.sumOf { it.reduce(Int::times) }
    }
}

private val digits = Regex("\\d+")
private typealias Schematic = Grid

private fun Schematic.adjacentToSymbol(start: Vector2, end: Vector2): List<Pair<Vector2, Char>> {
    val symbols = mutableListOf<Pair<Vector2, Char>>()
    val yRange = (start.y - 1)..(end.y + 1).coerceIn(0 until height)
    val xRange = (start.x - 1)..(end.x + 1).coerceIn(0 until width)
    yRange.forEach { y ->
        xRange.forEach { x ->
            val pos = Vector2(x, y)
            val value = this[pos]
            if (value?.isDigit() == false && value != '.') {
                symbols += pos to value
            }
        }
    }
    return symbols.toList()
}