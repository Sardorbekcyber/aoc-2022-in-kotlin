package day04

import java.io.File

fun main() {

    fun part1(input: String) : Long {
        val data = input.split("\n").sumOf { line ->
            val parts = line.split(",")
            val firstPart = parts[0].split("-")
            val secondPart = parts[1].split("-")
            val firstStart = firstPart.first().toInt()
            val firstEnd = firstPart.last().toInt()
            val secondStart = secondPart.first().toInt()
            val secondEnd = secondPart.last().toInt()
            when {
                firstStart <= secondStart && firstEnd >= secondEnd -> 1L
                firstStart >= secondStart && firstEnd <= secondEnd -> 1L
                else -> 0L
            }
        }
        return data
    }

    fun part2(input: String) : Long {
        val data = input.split("\n").sumOf { line ->
            val parts = line.split(",")
            val firstPart = parts[0].split("-")
            val secondPart = parts[1].split("-")
            val firstStart = firstPart.first().toInt()
            val firstEnd = firstPart.last().toInt()
            val secondStart = secondPart.first().toInt()
            val secondEnd = secondPart.last().toInt()
            when {
                secondEnd < firstStart -> 0L
                firstEnd < secondStart -> 0L
                else -> 1L
            }
        }
        return data
    }

    val testInput = File("src/day04/Day04_test.txt").readText()
    println(part1(testInput))
    println(part2(testInput))
    check(part1(testInput) == 2L)
    check(part2(testInput) == 4L)

    val input = File("src/day04/Day04.txt").readText()
    println(part1(input))
    println(part2(input))

}