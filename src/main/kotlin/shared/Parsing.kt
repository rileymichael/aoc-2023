package com.github.rileymichael.aoc2023.shared

private val digits = "\\d+".toRegex()
fun String.digitMatches() = digits.findAll(this)
fun String.ints() = digitMatches().map { it.value.toInt() }
fun String.longs() = digitMatches().map { it.value.toLong() }
