package day01

import java.io.File

fun main() {
    fun part1(input: String): Int {
        val data = input.split("\n\n").map { elf ->
            elf.lines().map { it.toInt() }
        }
        return data.maxOf { it.sum() }
    }

    fun part2(input: String): Int {
        val data = input.split("\n\n").map { elf ->
            elf.lines().map { it.toInt() }
        }
        return data
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()

    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/day01/Day01_test.txt").readText()
    check(part1(testInput) == 24000)

    val input = File("src/day01/Day01.txt").readText()
    println(part1(input))
    println(part2(input))

}
