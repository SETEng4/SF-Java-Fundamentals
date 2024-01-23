package usingswitch;

import java.util.Random;

public class Examples {
  public static void main(String[] args) {
//    String[] names = new String[3]; // three null pointers to String
//    String[] names = new String[]{"Fred", "Jim", "Sheila"};
    String[] names = {"Fred", "Jim", "Sheila"}; // shorthand for initialization
//    int index = (int)(Math.random() * names.length);
    int index = new Random().nextInt(0, names.length);

    switch (index) { // switch expression must be int or smaller integer type, String, an enum type
//      case 0:
//        System.out.println("Zero! that means it's Fred");
//        break;
//      case 0:
//      case 1:
      case 0, 1:
        System.out.println("One is Jim " + index);
        break;
      case 2:
        System.out.println("Two, that's Sheila");
        break;
      default:
        System.out.println("Bad value, how did that happen?!");
        break;
    }
    System.out.println("or with arrow switch");
    switch (index) {
//      case 0 ->
//        System.out.println("Zero! that means it's Fred");
      case 0, 1 -> {
        System.out.println("One is Jim " + index);
        if (Math.random() > 0.5) break;
        System.out.println("second thing from a value of zero or one");
      }
      case 2 ->
        System.out.println("Two, that's Sheila");
      default ->
        System.out.println("Bad value, how did that happen?!");
    }
    System.out.println("Expression switch");
    System.out.println(switch (index) {
      case 0, 1 -> {
        String value = "One is Jim " + index;
        yield value;
      }
      case 2 ->
          "Two, that's Sheila";
      default ->
          "Bad value, how did that happen?!";
    });
  }
}
