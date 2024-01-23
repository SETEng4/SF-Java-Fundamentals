package parameterpassing;

public class Example {
  // Java function arguments are PASS BY VALUE
  public static void add(int a) {
    a = a + 100;
    System.out.println("a is " + a);
  }

  public static void add(StringBuilder sbX) {
    sbX.append(" World!");
    System.out.println("sbX is " + sbX);
  }

  public static void main(String[] args) {
    int x = 10;
    add(x);
    System.out.println("x is " + x);

    StringBuilder sb = new StringBuilder("Hello");
    add(sb);
    System.out.println("sb is " + sb);
  }
}
