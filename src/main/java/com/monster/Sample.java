package com.monster;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by hovaheb on 8/15/2016.
 */
public class Sample {
    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
    }

    private static boolean isPrime(int number) {
        //classical way : imperative style of programming : saying how
        // mutability

        /*for (int i = 2; i < number ; i++) {
            if(number % 2 == 0 ) return false;
        }
        return number > 1 ;*/

        //functional way; focusing on problem rather than looping! : Declarative : not how but what to do
        //immutability
         return number > 1 && IntStream.range(2,number).noneMatch(index -> number % index == 0);
        /* 2
              Predicate<Integer> isDivisable = divisor -> number % divisor == 0;
              return number > 1 && IntStream.range(2,number).noneMatch(index -> isDivisable(index) );
         */


    }

}
