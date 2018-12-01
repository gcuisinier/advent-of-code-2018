package main

import (
	"fmt"
	"strconv"
)

func processFrequency(lines []string) int {
	var frequency = 0
	for i := range lines {
		currentItem, _ := strconv.Atoi(lines[i])
		frequency += currentItem
	}
	return frequency
}

func processFrequencyDouble(lines []string) (int, error) {
	var frequency = 0
	var cache = make(map[int]bool)
	cache[frequency] = true

	for true {
		for i := range lines {
			currentItem, _ := strconv.Atoi(lines[i])
			frequency += currentItem
			if cache[frequency] {
				return frequency, nil
			}
			cache[frequency] = true
		}
	}

	return 0, fmt.Errorf("Uxpected error")
}
