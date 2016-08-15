package com.monster;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hovaheb on 8/15/2016.
 */
public class Sample3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(
                numbers.stream()
                        .mapToInt(Sample3::doubleIt) // map is transformation
                        .sum()
        );

        // for pure function we have REFERENTIAL TRANSPARENCY :: compiler can replace the letter with the results of the function

        System.out.println("FASTER THIS TIME!");
        System.out.println(
                numbers.parallelStream() // <<< when I do sequentially it is slow; using parallel stream makes it much faster! << NO NEED MULTITHREADING EXPLICITLY
                        .mapToInt(Sample3::doubleIt) // map is transformation
                        .sum()
        );

    }

    //some slow operation!! in a pure function
    private static int doubleIt(int number) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        // it is a pure function : a function with no side effects and it gives an output :: for a specific input , the output is always same
        return number * 2;
    }
}
