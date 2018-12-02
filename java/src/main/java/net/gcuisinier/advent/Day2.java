package net.gcuisinier.advent;

import com.sun.tools.javac.comp.Check;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day2 {

    static class Checksum {

        int withLetterAppearTwo = 0;
        int withLetterAppearThree = 0;


        public int checksum() {
            return withLetterAppearThree * withLetterAppearTwo;
        }

        public void addLine(String line) {
            Map<String, Long> collect = Arrays.stream(line.split(""))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            if (collect.values().stream().anyMatch(c -> c == 2))
                withLetterAppearTwo++;

            if (collect.values().stream().anyMatch(c -> c == 3))
                withLetterAppearThree++;
        }

    }


    static class Tuple {

        public Tuple(String box1, String box2) {
            this.box1 = box1;
            this.box2 = box2;
        }

        String box1;
        String box2;
    }


    public static Optional<Tuple> findCorrectBoxes(List<String> lines) {

        for (String line1 : lines) {
            for (String line2 : lines) {
                int numberOfDif = 0;
                for (int i = 0; i < line1.length(); i++) {
                    if (line1.charAt(i) != line2.charAt(i))
                        numberOfDif++;
                }
                if (numberOfDif == 1) {
                    return Optional.of(new Tuple(line1, line2));


                }
            }
        }

        return Optional.empty();


    }

    public static String findCommonLetter(String box1, String box2) {


        return IntStream.range(0, box1.length())
                .filter(i -> box1.charAt(i) == box2.charAt(i))
                .mapToObj(box1::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());




    }

}
