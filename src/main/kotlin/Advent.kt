package com.github.rileymichael.aoc2023

import com.github.rileymichael.aoc2023.day1.Day1
import com.github.rileymichael.aoc2023.day2.Day2
import com.github.rileymichael.aoc2023.day3.Day3
import com.github.rileymichael.aoc2023.day4.Day4
import com.github.rileymichael.aoc2023.day5.Day5

fun main() {
    // todo: reflection to get rid of this.. arg to run spcific day..
    val days = listOf(
        Day1,
        Day2,
        Day3,
        Day4,
        Day5
    )
    days.lastOrNull()?.run { solve() }
}

private fun <T> Puzzle<T>.solve() {
    println("----Day $day----")
    listOf(::part1, ::part2).forEachIndexed { index, solution ->
        val (parse, answer) = solveTimed(solution)
        println(
            """
- Part ${index + 1} -
parsed in: ${parse.duration}
solved in: ${answer.duration}
solution: 
${answer.value}
            """.trimIndent()
        )
    }
}