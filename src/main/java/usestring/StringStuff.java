package usestring;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringStuff {
  public static void main(String[] args) throws Exception {
    String name = "Fred";
//    int idx = 0;
//    while (idx < name.length()) {
//      System.out.println("Char at " + idx + " is " + name.charAt(idx) );
//      idx++;
//    }

    for (int idx = 0; idx < name.length(); idx++) {
      System.out.println("Char at " + idx + " is " + name.charAt(idx) );
    }

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String yourName;
    do {
      System.out.print("Enter your name ");
      yourName = input.readLine();
      if (yourName.length() == 0) {
        System.out.println("No, can't have no characters in your name, try again!");
      }
    } while (yourName.length() == 0);
    System.out.println("your name is " + yourName + "? How cool is that?!");
  }
}
