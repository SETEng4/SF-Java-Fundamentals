package map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsingMap {
  public static void main(String[] args) {
    // Map in Java == Dictionary in Python :)
    Map<String, List<String>> foods = new HashMap<>();
    foods.put("Fred", List.of("Fish", "Burgers", "Fries"));
    foods.put("Jim", List.of("Steak", "Bacon", "Fries"));
    foods.put("Sheila", List.of("Fish", "Salad", "Fries"));

    System.out.println("Fred likes " + foods.get("Fred"));
    for (String person : foods.keySet()) {
      System.out.println("Food liked by: " + person + " are:");
      List<String> foodsLiked = foods.get(person);
      for (String food : foodsLiked) {
        System.out.println(" -- " + food);
      }
    }
  }
}
