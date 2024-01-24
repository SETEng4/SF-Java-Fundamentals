package many;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example {
  public static void breakAList(ArrayList old) {
    old.set(0, LocalDate.now());
  }

  public static void useData(List<String> als) {
    System.out.println("Items are: " + als + " and size is " + als.size());
  }

  public static void main(String[] args) {
//    ArrayList<LocalDate> bad = new ArrayList();
    ArrayList<LocalDate> bad = new ArrayList();
    bad.add(LocalDate.now());

//    ArrayList<String> names = new ArrayList<String>(bad);
//    ArrayList<String> names = new ArrayList<>(); // Diamond operator: "infer" the type here from context
    LinkedList<String> names = new LinkedList<>();
//    List<String> names = new LinkedList<>();
    System.out.println(names.size());
    names.add("Fred");
    names.add("Jim");
    System.out.println(names.size());
    names.add("Sheila");
    System.out.println(names.size());

//    names.add(0, LocalDate.now()); // this is rejected when E has type String!

//    Object s = names.get(0);
//    String st = (String)s;
//    System.out.println("item at postion zero is " + st);
//    breakAList(names); // Legacy code can break the logic!!!

    String s = names.get(0); // if E has type String no cast needed!

    System.out.println("item at postion zero is " + s);
    System.out.println(names);
    System.out.println("Element at position zero is " + names.get(0));
    names.set(0, "Frederick");
    System.out.println("Element at position zero is " + names.get(0));

    System.out.println("--------------------------------");
    useData(names);
  }
}
