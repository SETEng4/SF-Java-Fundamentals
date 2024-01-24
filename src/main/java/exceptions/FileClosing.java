package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class FileClosing {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String filename;
    boolean success = false;
    while (!success) {
      System.out.print("Enter filename: ");
      filename = sc.nextLine();
      // fr, br, are called "resources"
      // to be valid here, their types must implement AutoCloseable
      try (FileReader fr = new FileReader(filename);
           BufferedReader br = new BufferedReader(fr);) {

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
      }
      // compiler generated finally block(s)
      // and attempts to close EVERY resource metioned in the try ()
      // even if some of them throw exeptions while being closed.
      // also, any unhandled exception(s) reach the caller
      // the first to arise might reach the caller
      // any extras will be attached to that exception as "suppresed exceptions"
    }

    System.out.println("All done...");

  }
}