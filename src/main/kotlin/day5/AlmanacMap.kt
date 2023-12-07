package com.github.rileymichael.aoc2023.day5

import com.github.rileymichael.aoc2023.shared.longs

data class AlmanacRangePair(
    val src: LongRange,
    val dst: LongRange,
) {
    fun reverse() = AlmanacRangePair(dst, src)
}

data class AlmanacMap(
    val src: String,
    val dst: String,
    val ranges: List<AlmanacRangePair>,
) {
    fun get(source: Long): Long = ranges.firstOrNull { source in it.src }?.let {
        val offset = source - it.src.first
        it.dst.first + offset
    } ?: source

    fun reverse() = AlmanacMap(
        dst, src, ranges.map(AlmanacRangePair::reverse).reversed()
    )

    companion object {
        fun parse(value: List<String>): AlmanacMap {
            val (mapping, _) = value.first().split(" ")
            val (src, dst) = mapping.split("-to-")
            val pairs = value.drop(1).map { entry ->
                val (dstStart, srcStart, length) = entry.longs().toList()
                AlmanacRangePair(
                    srcStart until  srcStart + length,
                    dstStart until dstStart + length,
                )
            }
            return AlmanacMap(src, dst, pairs)
        }
    }
}
