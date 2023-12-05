package com.github.rileymichael.aoc2023.shared

data class Grid(
    private val rows: List<String>,
) {
    val height = rows.size
    val width = rows.first().length

    fun row(y: Int) = rows[y]

    operator fun get(vector: Vector2): Char? {
        if (vector.x < 0 || vector.x >= width || vector.y < 0 || vector.y >= height) {
            return null
        }
        return rows[vector.y][vector.x]
    }
}
