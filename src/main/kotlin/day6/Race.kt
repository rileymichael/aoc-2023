package com.github.rileymichael.aoc2023.day6

data class Race(
    val time: Long,
    val record: Long,
) {
    fun wins() = (1 until time).count { speed ->
        ((time - speed) * speed) > record
    }
}