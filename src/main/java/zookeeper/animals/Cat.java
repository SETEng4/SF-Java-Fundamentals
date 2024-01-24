package zookeeper.animals;

public class Cat extends Animal {
  private String faveFood = "tuna"; // instance field initialization

  public Cat(int weight) {
    super(weight, "meow");
    // instance field initilialization
    // ... more stuff
  }

  public Cat(int weight, String faveFood) {
    this(weight);
    this.faveFood = faveFood;
  }

  public String getFaveFood() {
    return faveFood;
  }

  public void setFaveFood(String faveFood) {
    // validate!!!
    this.faveFood = faveFood;
  }

  public void pet() {
    System.out.println("Stroking the cat, cat purrs!");
  }

  @Override
  public String getFavoriteFood() {
    return faveFood;
  }

  @Override
  public void feed(String food) {
    if (food.equals(faveFood)) {
      if (Math.random() > 0.5) {
        System.out.println("Satisfied noises, goes to sleep");
      } else {
        System.out.println("Leave, looking bored");
      }
    } else {
      System.out.println(getNoise() + " stalk away twitching tail!");
    }
  }
}
