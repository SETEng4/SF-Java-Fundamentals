package moreconditions;

import java.sql.SQLOutput;

public class ConditionalOp {
  public static void main(String[] args) {
    double d = Math.random();

    String message;
    if (d > 0.5) {
      message = "Big";
    } else {
      message = "small";
    }
    System.out.println(message);

    System.out.println("--------------------");
    System.out.println((d > 0.5) ? "Big" : "small");

  }
}
