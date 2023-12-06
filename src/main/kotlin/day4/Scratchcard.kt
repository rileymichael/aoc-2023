package com.github.rileymichael.aoc2023.day4

import com.github.rileymichael.aoc2023.shared.mapToSet

data class Scratchcard(
    val number: Int,
    val winning: Set<Int>,
    val have: Set<Int>,
) {
    val matches = have intersect winning
    val points = matches.fold(0) { acc, _ -> if (acc == 0) 1 else acc * 2 }

    companion object {
        private val cardRegex = Regex("(\\d+): (.*)")
        fun parse(value: String): Scratchcard {
            val (_, number, nums) = cardRegex.findAll(value).first().groupValues
            val (winningNumbers, numbers) = nums.split("|")
            return Scratchcard(
                number.toInt(),
                winningNumbers.split(" ").filter(String::isNotBlank).mapToSet { it.trim().toInt() },
                numbers.split(" ").filter(String::isNotBlank).mapToSet { it.trim().toInt() },
            )
        }
    }
}