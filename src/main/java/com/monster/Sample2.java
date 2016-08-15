package com.monster;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by hovaheb on 8/15/2016. watch https://www.youtube.com/watch?v=Ee5t_EGjv0A
 */
public class Sample2 {
    public static void main(String[] args) {
        //find the double of the first even number greater than 3
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9);
        int result = 0;
        for (int e : values) {
            if (e > 3 && e % 2 == 0) { /* We are focusing on the mechanics of the looping*/
                result = e * 2;
                break;
            }
        }
        System.out.println(result);

        /* Functional Way : DECORATIVE STYLE OF PROGRAMMING*/

        //stream() is a fancy iterator in java 8
        /*System.out.println(values.stream().
                filter(e -> e > 3).
                filter(e -> e % 2 == 0).
                map(e -> e * 2).
                findFirst().
                get());*/

        /*System.out.println(values.stream().
                filter(e -> e > 3).
                filter(e -> e % 2 == 0).
                map(e -> e * 2).
                findFirst());*/// Returns Optional ; what if we dont have any even number or we dont have even numbers greater than 3?

        /*System.out.println(values.stream().
                filter(Sample2::isGreaterThan3). // Method references available in java 8 :: PASSING A FUNCTION TO ANOTHER FUNCTION :: HIGHER ORDER FUNCTION :: IT MAY EVALUATE IS NOW OR LATER OR MAY NOT EVALUATE AT ALL :: LAZY EVALUATION
                filter(e -> e % 2 == 0).
                map(e -> e * 2).
                findFirst());*/
        Predicate<Integer> isGT3 = number -> number > 3;
       /* System.out.println(values.stream().
                filter(isGT3 ). // Method references available in java 8
                filter(Sample2::isEven).
                map(Sample2::doubleIt).
                findFirst());*/



        final Stream<Integer> logic = values.stream().
                filter(Sample2::isGreaterThan3). // Method references available in java 8
                filter(Sample2::isEven).
                map(Sample2::doubleIt);
        System.out.println(logic.findFirst());

        // Benefits of lazy evaluation :
            //in traditional way we had to perform more operation. If we have 110 numbers on our list on we loop over them, we have to double all of them and so on ..
            // using laziness, we first filter numbers greater than 3 (means 7  numbers) , then find even numbers and then perform double operation on them.


        Function<Integer , Predicate<Integer>> isGreaterThan = pivot ->
                number -> number > pivot;

        System.out.println("====================");
        // LESS DUPLICATION :: usig a predicate for greater than
        final Stream<Integer> temp = values.stream().
                filter(isGreaterThan.apply(3)). //apply call : apply call is a function of function :: an eager evaluation which returns a predicate
                filter(Sample2::isEven).
                map(Sample2::doubleIt);
        System.out.println(logic.findFirst());
    }

    private static int doubleIt(int number) {
        System.out.println("doubleIt " + number);
        return number * 2;
    }

    public static boolean isGreaterThan3(int number) {
        System.out.println("isGreaterThan3 " + number);
        return number > 3;
    }
    public static boolean isEven(int number) {
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }
}
