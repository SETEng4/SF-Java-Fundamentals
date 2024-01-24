package zookeeper.zoomanagement;

import zookeeper.animals.Animal;
import zookeeper.animals.Cat;
import zookeeper.animals.Lion;

public class RunTheZoo {
  public static void feedTheAnimals(Animal[] zoo) {
    for (Animal a : zoo) {
      System.out.println("Feeding: " + a.getClass() + " -- " + a);
      // feed this...
      String food = a.getFavoriteFood();
      if (Math.random() > 0.7) {
        // not paying attention!!!
        food = "Oatmeal";
      }
//      if (a instanceof Cat) {
//        Cat c = (Cat)a;
      if (a instanceof Cat c) { // "pattern matching"
        // this is BUSINESS LOGIC "USE OF" a Cat, not intrinsic behavior of a cat
        c.pet();
      }
      a.feed(food);
    }
  }

  public static void main(String[] args) {
    Animal [] theZoo = {
//        new Animal(0, "??"),
        new Cat(5),
        new Cat(7, "Smoked Salmon"),
        new Lion(950),
        new Cat(3, "cat food"),
    };
    feedTheAnimals(theZoo);
  }
}
