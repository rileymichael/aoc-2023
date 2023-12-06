package com.github.rileymichael.aoc2023.shared

inline fun <T, R> Iterable<T>.mapToSet(transform: (T) -> R): Set<R> {
    return mapTo(HashSet(), transform)
}