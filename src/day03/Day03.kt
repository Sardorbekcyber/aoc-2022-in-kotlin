package day03

import java.io.File

fun main() {
    val letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    fun part1(input: String) : Int {
        val data = input.split("\n")
        var sum = 0
        for (line in data) {
            val secondHalf = line.substring(line.length/2)
            for (char in line){
                if (secondHalf.contains(char, false)){
                    sum += letters.indexOf(char) + 1
                    break
                }
            }
        }
        return sum
    }

    fun part2(input: String) : Int {
        val data = input.split("\n").chunked(3)
        var sum = 0
        for (group in data){
            val firstSet = mutableSetOf<Char>()
            val secondSet = mutableSetOf<Char>()
            val thirdSet = mutableSetOf<Char>()
            var setNum = 1
            val groupAll = group.joinToString(",")
            for (char in groupAll){
                if (char == ','){
                    setNum++
                    continue
                }
                when (setNum) {
                    1 -> firstSet.add(char)
                    2 -> secondSet.add(char)
                    else -> thirdSet.add(char)
                }
            }
            for (char in firstSet){
                if (secondSet.contains(char) && thirdSet.contains(char)){
                    sum += letters.indexOf(char) + 1
                    break
                }
            }
        }
        return sum
    }

    val testInput = File("src/day03/Day03_test.txt").readText()
    println(part1(testInput))
    println(part2(testInput))
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = File("src/day03/Day03.txt").readText()
    println(part1(input))
    println(part2(input))

}