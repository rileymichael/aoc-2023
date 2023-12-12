package com.github.rileymichael.aoc2023.day6

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day6Test : StringSpec({
    val input = """
Time:      7  15   30
Distance:  9  40  200
    """.trimIndent()

    "part 1 example" {
        Day6.solve(Day6::part1, input) shouldBe 288
    }

    "part 1 solution" {
        Day6.solve(Day6::part1) shouldBe 114400
    }

    "part 2 example" {
        Day6.solve(Day6::part2, input) shouldBe 71503
    }

    "part 2 solution" {
        Day6.solve(Day6::part2) shouldBe 21039729
    }
})