package com.github.rileymichael.day2

data class GameSet(
    val red: Int,
    val green: Int,
    val blue: Int,
) {
    fun contains(other: GameSet) = red >= other.red && green >= other.green && blue >= other.blue

    fun max(other: GameSet) = GameSet(
        red = maxOf(red, other.red),
        green = maxOf(green, other.green),
        blue = maxOf(blue, other.blue),
    )

    val power: Int = red * green * blue
}

private val pattern = "(\\d+) (blue|red|green)".toRegex()
fun String.toGameSet(): GameSet {
    val colors = pattern.findAll(this).associate { match ->
        val (count, color) = match.destructured
        color to count.toInt()
    }
    return GameSet(
        red = colors["red"] ?: 0,
        green = colors["green"] ?: 0,
        blue = colors["blue"] ?: 0,
    )
}
