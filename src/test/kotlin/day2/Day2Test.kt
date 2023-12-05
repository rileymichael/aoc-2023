package com.github.rileymichael.aoc2023.day2

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day2Test : StringSpec({
    val input = """
        Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
        Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
        Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
        Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
        Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
    """.trimIndent()

    "part 1 example" {
        Day2.solve(Day2::part1, input) shouldBe 8
    }

    "part 1 solution" {
        Day2.solve(Day2::part1) shouldBe 2317
    }

    "part 2 example" {
        Day2.solve(Day2::part2, input) shouldBe 2286
    }

    "part 2 solution" {
        Day2.solve(Day2::part2) shouldBe 74804
    }
})