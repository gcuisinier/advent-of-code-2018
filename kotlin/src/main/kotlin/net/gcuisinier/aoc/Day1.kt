package net.gcuisinier.aoc

import java.io.File

class Day1 {


    companion object {
        
        @JvmStatic
        fun process1(numbers: List<Int>): Int {
            return numbers.sum()
        }

        @JvmStatic
        fun process2(numbers: List<Int>): Int {
            val cache = hashSetOf(0)
            var sum = 0

            while (true) {
                numbers.forEach({
                    sum = sum + it
                    if (cache.contains(sum))
                        return sum
                    else
                        cache.add(sum)

                })
            }
        }
    }


}