package com.github.rileymichael

import com.github.rileymichael.day1.Day1

fun main() {
    // todo: reflection to get rid of this.. arg to run spcific day..
    val days = listOf(
        Day1,
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