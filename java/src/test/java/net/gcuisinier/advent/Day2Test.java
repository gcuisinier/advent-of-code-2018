package net.gcuisinier.advent;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class Day2Test {

    @Test

    public void testOne() {

        Day2.Checksum checksum = new Day2.Checksum();

        checksum.addLine("abcdef");

        assertEquals(0, checksum.withLetterAppearThree);
        assertEquals(0, checksum.withLetterAppearTwo);
    }

    @Test
    public void testTwo() {

        Day2.Checksum checksum = new Day2.Checksum();

        checksum.addLine("bababc");


        assertEquals(1, checksum.withLetterAppearThree);
        assertEquals(1, checksum.withLetterAppearTwo);
    }

    @Test
    public void testThree() {

        Day2.Checksum checksum = new Day2.Checksum();

        checksum.addLine("abbcde");

        assertEquals(0, checksum.withLetterAppearThree);
        assertEquals(1, checksum.withLetterAppearTwo);
    }

    @Test
    public void test4() {

        Day2.Checksum checksum = new Day2.Checksum();

        checksum.addLine("abcccd");

        assertEquals(1, checksum.withLetterAppearThree);
        assertEquals(0, checksum.withLetterAppearTwo);
    }

    @Test
    public void testCheckSumSample(){
        Day2.Checksum checksum = new Day2.Checksum();

        checksum.addLine("abcdef");
        checksum.addLine("bababc");
        checksum.addLine("abbcde");
        checksum.addLine("abcccd");
        checksum.addLine("aabcdd");
        checksum.addLine("abcdee");
        checksum.addLine("ababab");

        assertEquals(4, checksum.withLetterAppearTwo);
        assertEquals(3, checksum.withLetterAppearThree);
        assertEquals(12, checksum.checksum());




    }


    @Test
    public void testMyInput() throws IOException {
        Day2.Checksum checksum = new Day2.Checksum();

        IOUtils.readLines(getClass().getResourceAsStream("/day2.txt"), "UTF-8")
                .stream().forEach(checksum::addLine);


        System.out.println("Part 1 final checksum : " + checksum.checksum());


        List<String> lines = IOUtils.readLines(getClass().getResourceAsStream("/day2.txt"), "UTF-8");
        Optional<Day2.Tuple> result = Day2.findCorrectBoxes(lines);



        String commonLetters = Day2.findCommonLetter(result.get().box1,result.get().box2);
        System.out.println("Part2 Common lettters : " + commonLetters);



    }

    @Test
    public void testPart2(){

        List<String> listOfBoxes = new ArrayList();

        listOfBoxes.add("abcde");
        listOfBoxes.add("fghij");
        listOfBoxes.add("klmno");
        listOfBoxes.add("pqrst");
        listOfBoxes.add("fguij");
        listOfBoxes.add("axcye");
        listOfBoxes.add("wvxyz");


        Optional<Day2.Tuple> result = Day2.findCorrectBoxes(listOfBoxes);

        assertTrue(result.isPresent());
        assertEquals("fghij",result.get().box1);
        assertEquals( "fguij",result.get().box2);

        String commonLetters = Day2.findCommonLetter(result.get().box1,result.get().box2);
        System.out.println("Common : " + commonLetters);



    }


}