package com.github.rileymichael.day1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day1Test : StringSpec({
    val part1Input = """
1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
    """.trimIndent()

    val part2Input = """
two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen
    """.trimIndent()

    "part 1 example" {
        Day1.solve(Day1::part1, part1Input) shouldBe 142
    }

    "part 1 solution" {
        Day1.solve(Day1::part1) shouldBe 53334
    }

    "part 2 example" {
        Day1.solve(Day1::part2, part2Input) shouldBe 281
    }

    "part 2 solution" {
        Day1.solve(Day1::part2) shouldBe 52834
    }
})