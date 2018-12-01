package main

import (
	"bufio"
	"fmt"
	"os"
	"testing"
)

func TestPart1Sample1(t *testing.T) {

	var input []string = []string{"+1", "+1", "+1"}

	var result = processFrequency(input)

	checkExpected(3, result, t)

}

func TestPart1Sample2(t *testing.T) {

	var input []string = []string{"+1", "+1", "-2"}

	var result = processFrequency(input)

	checkExpected(0, result, t)

}

func TestPart1Sample3(t *testing.T) {

	var input []string = []string{"-1", "-2", "-3"}

	var result = processFrequency(input)

	checkExpected(-6, result, t)
}

func TestPart2Sample1(t *testing.T) {

	var input []string = []string{"+1", "-1"}

	var result, _ = processFrequencyDouble(input)

	checkExpected(0, result, t)
}

func TestPart2Sample2(t *testing.T) {

	var input []string = []string{"+3", "+3", "+4", "-2", "-4"}

	var result, _ = processFrequencyDouble(input)

	checkExpected(10, result, t)
}

func TestPart2Sample3(t *testing.T) {

	var input []string = []string{"-6", "+3", "+8", "+5", "-6"}

	var result, _ = processFrequencyDouble(input)

	checkExpected(5, result, t)
}

func TestPart2Sample4(t *testing.T) {

	var input []string = []string{"+7", "+7", "-2", "-7", "-4"}

	var result, _ = processFrequencyDouble(input)

	checkExpected(14, result, t)
}

func TestInput(t *testing.T) {

	var input, _ = readLines("input.txt")

	var resultPart1 = processFrequency(input)
	var resultPart2, _ = processFrequencyDouble(input)

	fmt.Printf("Final frequency is %d\n", resultPart1)
	fmt.Printf("First frequence in double is %d\n", resultPart2)

}

func checkExpected(expected int, current int, t *testing.T) {
	if current != expected {
		t.Errorf("Final frequency is wrong, got: %d, expected: %d.", current, expected)
	}
}

// readLines reads a whole file into memory
// and returns a slice of its lines.
func readLines(path string) ([]string, error) {
	file, err := os.Open(path)

	if err != nil {
		return nil, err
	}
	defer file.Close()

	var lines []string

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		lines = append(lines, scanner.Text())
	}
	return lines, scanner.Err()
}
