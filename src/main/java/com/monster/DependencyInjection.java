package com.monster;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by hovaheb on 8/15/2016.
 */
interface Selector {
    public boolean pick(int value);

}

// This is called ceremony. what we have to do before we get to know what to do
/*class EvenSelector implements Selector{

    @Override
    public boolean pick(int value) {
        return value % 2 == 0;
    }
}*/
public class DependencyInjection {
    public static int totalValues(List<Integer> numbers, Selector selector) {
        int result = 0;
        for (int e : numbers) {
            if (selector.pick(e)) result += e;
        }
        return result;
    }

    public static int moreDecoratedTotalValues(List<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream().
                filter(selector).
                reduce(0, Math::addExact);

    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 20);
        // if we want the totla of only selected values. what are selected values ? We dont know, we may decide later so we create an interface Selector
        System.out.println(totalValues(values, e -> true));
        System.out.println(totalValues(values, e -> e % 2 == 0));

        //mixing object composition - function composition
        System.out.println(moreDecoratedTotalValues(values, e -> e % 2 == 0));

    }
}
