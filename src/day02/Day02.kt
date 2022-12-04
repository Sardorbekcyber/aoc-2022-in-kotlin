package day02

import java.io.File

fun main() {

    fun part1(input: String) : Long {
        val lostSet = setOf("A Z", "B X", "C Y")
        val winSet = setOf("A Y", "B Z", "C X")
        val drawSet = setOf("A X", "B Y", "C Z")

        val scoreMap = mapOf('X' to 1, 'Y' to 2, 'Z' to 3)

        val data = input.split("\n").sumOf {
            val gameScore = when(it){
                in lostSet -> 0L
                in drawSet -> 3L
                in winSet -> 6L
                else -> throw IllegalArgumentException()
            }
            gameScore + scoreMap.getOrDefault(it.last(), 0)
        }
        return data
    }

    fun part2(input: String) : Long {
        val winSet = setOf("A B", "B C", "C A")
        val lostSet = setOf("A C", "B A", "C B")
        val drawSet = setOf("A A", "B B", "C C")

        val scoreMap = mapOf('A' to 1, 'B' to 2, 'C' to 3)

        val data = input.split("\n").sumOf { game ->
            val (gameScore, myScore) = when(game.last()){
                'X' -> 0L to scoreMap.getOrDefault(lostSet.first { it.first() == game.first() }.last(), 0)
                'Y' -> 3L to scoreMap.getOrDefault(drawSet.first { it.first() == game.first() }.last(), 0)
                'Z' -> 6L to scoreMap.getOrDefault(winSet.first { it.first() == game.first() }.last(), 0)
                else -> throw IllegalArgumentException()
            }
            gameScore + myScore
        }
        return data
    }

    val testInput = File("src/day02/Day02_test.txt").readText()
    println(part2(testInput))
    check(part2(testInput) == 12L)

    val input = File("src/day02/Day02.txt").readText()
    println(part1(input))
    println(part2(input))

}