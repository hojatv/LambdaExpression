package com.monster;

/**
 * Created by hovaheb on 8/15/2016.
 * Lambda expression is just a way to pass a block of code to method. That's all it is!
 */

/**
 * Factional interface is an interface with only a method inside
 */
interface Executable {
    int execute(int a , int b );
}
interface StringExecutable {
    int execute(int a );
}

class Runner {

    public void run(Executable e) {
        System.out.println("Executing code block ...");
        int value = e.execute(12,13);
        System.out.println("Returend Value : " + value);
    }
    public void run(StringExecutable e) {
        System.out.println("Executing code block ...");
        int value = e.execute(12);
        System.out.println("Returend Value : " + value);
    }
}
// 1     () -> System.out.println("Hello There!")
/* 2
         () -> {
            System.out.println("This is code passed in a lambda expression");
            System.out.println("Hello There!");
        }
 */
/* 3
         () -> {
            System.out.println("This is code passed in a lambda expression");
            System.out.println("Hello There!");
            return 8;
        }
 */
/* 4
         () -> { return 8; }
 */
// 5     () -> 8
/* 6
        (int a ) -> {
            System.out.println("This is code passed in a lambda expression");
            System.out.println("Hello There!");
            return 8 + a ;
        }
 */
/* 7 Type Inference
        (a ) -> {
            System.out.println("This is code passed in a lambda expression");
            System.out.println("Hello There!");
            return 8 + a ;
        }
 */
public class App {
    public static void main(String[] args) {
        Runner runner = new Runner();
        int c = 100;
        //c = 10;

        //anonymous class in java 7
        runner.run(new Executable() {
            public int execute(int a, int b ) {
                System.out.println("Hello There!");
                return 7 + a + b  + c;
            }
        });
        System.out.println("================================================");
        //Lambda expression in java 8
        runner.run((Executable) (int a , int b) -> {
            System.out.println("This is code passed in a lambda expression");
            System.out.println("Hello There!");
            return 8 + a + b + c ;
        });

        Executable ex = (a,b) -> {
            System.out.println("Hello There!");
            return 8 + a + b + c ;
        };
        System.out.println("================================================");
        System.out.println("Lambda expression is an object!");
        runner.run(ex);

        Object codeBlock = (Executable)(a,b) -> {
            System.out.println("Hello There!");
            return 8 + a + b + c ;
        };

    }

}
