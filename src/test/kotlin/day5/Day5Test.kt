package com.github.rileymichael.aoc2023.day5

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day5Test : StringSpec({
    val input = """
seeds: 79 14 55 13

seed-to-soil map:
50 98 2
52 50 48

soil-to-fertilizer map:
0 15 37
37 52 2
39 0 15

fertilizer-to-water map:
49 53 8
0 11 42
42 0 7
57 7 4

water-to-light map:
88 18 7
18 25 70

light-to-temperature map:
45 77 23
81 45 19
68 64 13

temperature-to-humidity map:
0 69 1
1 0 69

humidity-to-location map:
60 56 37
56 93 4
    """.trimIndent()

    "part 1 example" {
        Day5.solve(Day5::part1, input) shouldBe 35
    }

    "part 1 solution" {
        Day5.solve(Day5::part1) shouldBe 424490994
    }

    "part 2 example" {
        Day5.solve(Day5::part2, input) shouldBe 46
    }

    "part 2 solution" {
        Day5.solve(Day5::part2) shouldBe 15290096
    }
})