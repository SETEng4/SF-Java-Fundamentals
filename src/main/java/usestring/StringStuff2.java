package usestring;

import java.util.Arrays;

public class StringStuff2 {
  public static void main(String[] args) {
    String name = "Albert";
    char [] chars = name.toCharArray();
    System.out.println("Chars for Albert are: " + Arrays.toString(chars));

//    for (int idx = 0; idx < chars.length; idx++) {
//      System.out.println("> " + chars[idx]);
//    }

    for (char c : chars) {
      System.out.println(">> " + c);
    }

    System.out.println("Name is " + name);
//    name.toUpperCase();
    name = name.toUpperCase();
    System.out.println("Name is " + name);

//    String upcName = name.toUpperCase();
//    System.out.println("Uppercase name is " + upcName);
//    System.out.println("Name is " + name);

    String n1 = "Frank";
    String n2 = "FRANK";
    String n3 = n1.toUpperCase();
    System.out.println("n1 is " + n1);
    System.out.println("n2 is " + n2);
    System.out.println("n3 is " + n3);

    System.out.println("n2 == n3? " + (n2 == n3));
    System.out.println("n2 == n3? " + n2.equals(n3));

    StringBuilder sb1 = new StringBuilder("Hello");
    StringBuilder sb2 = new StringBuilder("Hello");
    System.out.println("sb1 == sb2? " + (sb1 == sb2));
    System.out.println("sb1.equals(sb2)? " + sb1.equals(sb2));
    System.out.println("sb1.equals(sb2) (as String)? " + sb1.toString().equals(sb2.toString()));

    String const1 = "Constant";
    String const2 = "Constant";
    System.out.println("const1 == const2? " + (const1 == const2));

    System.out.println("n2 == n3? " + (n2 == n3));
    n3 = n3.intern();
    System.out.println("n2 == n3? " + (n2 == n3));
  }
}
