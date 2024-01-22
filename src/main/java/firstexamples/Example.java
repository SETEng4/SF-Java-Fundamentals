package firstexamples;

//import java.lang.System;

import java.io.FileReader;
import java.util.Scanner;

import static java.lang.System.out;

public class Example {

  public static int add(int a, int b) {
    int result = a + b;
    out.println("I added " + a + " and " + b + " to get " + result) ;
    return result;
  }

  public static void main(String[] args) throws Exception {
//    java.lang.System.out.println("Hello Java World!");
    System.out.println("Hello Java World!");
    out.println("Hello Java World!");
    out.println("Hello Java World Again!");

    // Core built in data types--Java is STRONGLY, STATICALLY typed
    // boolean -- true/false java does NOT do "truthy/falsy"
    // int, long, double
    // String (java.lang.String) -- immutable

    // declare variable: type name-of-variable;
    // declare initialized
    int x = 5;
    // more recent (not really recommended by me!)
    var y = 3; // STILL AN int -- must be initialized, type is taken from the initializing value

    String message = "I'm a message"; // String literals double quotes!!!

    boolean doILikeJava = true; // true/false (everything in Java is case sensitive)

    // operations on numeric stuff
    // + - * / % (% is remainder, not mod!)
    // type of the result of numeric computation depends on the type of the operands
    // conditionals < <= > >= == !=
    // logical && - and, short circuiting
    //         || - or, short circuiting
    // bitwise ( & | ~ ^ )
    // shift >> << >>>

    // iteration while.. do---while, C-style for, foreach style for ("enhanced" for)

    while (y > 0) { // parens are required, expression MUST BE boolean!
      System.out.println("y is " + y);
      y = y - 1; // other options from C/C++/JavaScript :)
    }

    double d = Math.random();
    if (d > 0.5) { // require parens, expression MUST BE boolean
      out.println("oops");
      out.println("it's bigger " + d);
    } else if (d > 0.25) {
      out.println("it's smaller, but not tiny " + d);
    } else {
      out.println("tiny!!!");
    }

    out.println("one plus two is " + Example.add(1, 2));
    out.println("3, 4 is " + add(3, 4));

//    Scanner input = new Scanner(System.in);
    Scanner input = new Scanner(new FileReader("text.txt"));
    while (input.hasNextLine()) {
      String line = input.nextLine();
      out.println("I read: " + line);
    }
  }
}
