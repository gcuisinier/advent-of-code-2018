package net.gcuisinier.advent;

import com.sun.tools.corba.se.idl.InterfaceGen;

import javax.xml.ws.Holder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Day1 {


    public static int processPart1(String input) {


        int frequency = Pattern.compile("\n").splitAsStream(input)
                .map(line -> {
                    int value = Integer.parseInt(line.substring(1));
                    if (line.charAt(0) == '+') {
                        return value;
                    } else {
                        return -value;
                    }
                }).mapToInt(l -> l)
                .sum();


        return frequency;
    }


    public static int processPart2(String input) {

        Map<Integer, Boolean> cache = new HashMap<>();
        Holder<Integer> frequency = new Holder<>(0);
        Holder<Integer> duplicate = new Holder<>();


        cache.put(0, true);

        while(duplicate.value == null) {
            Pattern.compile("\n").splitAsStream(input)
                    .forEach(line -> {
                        if (duplicate.value == null) {
                            int value = Integer.parseInt(line.substring(1));
                            if (line.charAt(0) == '+') {
                                frequency.value = frequency.value + value;
                            } else {
                                frequency.value = frequency.value - value;
                            }
                            Boolean alreadyCached = cache.putIfAbsent(frequency.value, true);
                            if (alreadyCached != null) {
                                duplicate.value = frequency.value;
                            }
                        }
                    });
        }

    return duplicate.value;

    }

}
