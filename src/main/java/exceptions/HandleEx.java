package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class HandleEx {
  public static void main(String[] args) /*throws IOException*/ {
    // Java has two kinds of exceptions (really 3)
    // Stuff that represents a bug --> crash (or shutdown cleanly)
    // -- represented by "RuntimeExceptions" and are NOT checked
    // Environmental stuff didn't cooperate --> retry
    // -- represented by checked exceptions, any subclass of java.lang.Exception
    //    EXCEPT RuntimeException and its subtypes :)
    // Third type is Error -- environment, but catastrophid -> unchecked

    Scanner sc = new Scanner(System.in);

    String filename;
//    String filename = "text1.txt";
    boolean success = false;
    while (!success) {
      System.out.print("Enter filename: ");
      filename = sc.nextLine();
      try {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        if (Math.random() > 0.5) {
          int x = 99;
          int y = 0;
          System.out.println("going for division!!!");
          int z = x / y;
        }
        String line;
        if (Math.random() > 0.5) {
          throw new SQLException("DB busted!");
        }
        while ((line = br.readLine()) != null) {
          System.out.println("> " + line);
        }
//        br.close(); // attempts to close br and fr... BUT, if we throw exception we never get here!
        success = true;
      } catch (FileNotFoundException e) {
        System.out.println("I can't find that file, please try again!");
      } catch (SQLException | IOException e) { // since Java 7, catch this OR that...
        System.out.println("Problem: " + e.getClass() + " message " + e.getMessage());
//      } catch (SQLException e) { // If a checked exception is never thrown, it is an error to catch it
//        System.out.println("Problem: " + e.getClass() + " message " + e.getMessage());
      } finally {
        System.out.println("This executes regardless!");
        // close the files...
//        br.close(); // OUT OF SCOPE!!!
      }
    }

    System.out.println("All done...");
  }
}
