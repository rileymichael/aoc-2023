package com.github.rileymichael.aoc2023.day3

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day3Test : StringSpec({
    val input = """
467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...$.*....
.664.598..
    """.trimIndent()

    "part 1 example" {
        Day3.solve(Day3::part1, input) shouldBe 4361
    }

    "part 1 solution" {
        Day3.solve(Day3::part1) shouldBe 543867
    }

    "part 2 example" {
        Day3.solve(Day3::part2, input) shouldBe 467835
    }

    "part 2 solution" {
        Day3.solve(Day3::part2) shouldBe 79613331
    }
})