package com.github.rileymichael.aoc2023.shared

inline fun <T, R> Iterable<T>.mapToSet(transform: (T) -> R): Set<R> {
    return mapTo(HashSet(), transform)
}

fun <T> Sequence<T>.chunkedBy(predicate: (T) -> Boolean): Sequence<List<T>> = sequence {
    val chunk = mutableListOf<T>()
    this@chunkedBy.forEach { curr ->
        val split = predicate(curr)
        if (split) {
            yield(chunk.toList())
            chunk.clear()
        } else {
            chunk.add(curr)
        }
    }
    if (chunk.isNotEmpty()) {
        yield(chunk)
    }
}