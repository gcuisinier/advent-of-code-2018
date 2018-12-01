package net.gcuisinier.aoc

import org.junit.Assert.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File

class Day1Test {


    @Test
    @DisplayName("part1 sample1")
    fun testPart1Sample1() {

        val numbers = listOf(1, 1, 1)
        var result = Day1.process1(numbers);
        assertEquals(3, result)
    }

    @Test
    @DisplayName("part1 sample2")
    fun testPart1Sample2() {

        val numbers = listOf(1, 1, -2)
        var result = Day1.process1(numbers);
        assertEquals(0, result)
    }

    @Test
    @DisplayName("part1 sample3")
    fun testPart1Sample3() {

        val numbers = listOf(-1, -2, -3)
        var result = Day1.process1(numbers);
        assertEquals(-6, result)
    }

    @Test
    @DisplayName("part2 sample1")
    fun testPart2Sample1() {

        val numbers = listOf(1, -1)
        var result = Day1.process2(numbers);
        assertEquals(0, result)
    }

    @Test
    @DisplayName("part2 sample2")
    fun testPart2Sample2() {

        val numbers = listOf(+3, +3, +4, -2, -4)
        var result = Day1.process2(numbers);
        assertEquals(10, result)
    }

    @Test
    @DisplayName("part2 sample3")
    fun testPart2Sample3() {

        val numbers = listOf(-6, +3, +8, +5, -6)
        var result = Day1.process2(numbers);
        assertEquals(5, result)
    }

    @Test
    @DisplayName("part2 sample4")
    fun testPart2Sample4() {

        val numbers = listOf(    +7, +7, -2, -7, -4)
        var result = Day1.process2(numbers);
        assertEquals(14, result)
    }


    @Test
    @DisplayName("input")
    fun testInput() {
        var result = Day1.process1(loadInput());
        var result2 = Day1.process2(loadInput());
        println("Final frequency : " + result);
        println("Duplicate frequency : " + result2);

    }

    private fun loadInput(): List<Int> {
        return File("src/main/resources/day1.txt").readLines()
                .map(Integer::parseInt)
    }

}