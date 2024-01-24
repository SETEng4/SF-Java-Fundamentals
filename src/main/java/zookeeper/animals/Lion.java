package zookeeper.animals;

public class Lion extends Animal {
  private static final String FAVE_FOOD = "meat";
  public Lion(int weight) {
    super(weight, "roar!");
  }

  @Override
  public String getFavoriteFood() {
    return FAVE_FOOD;
  }

  @Override
  public void feed(String food) {
    if (food.equals(FAVE_FOOD)) {
      System.out.println("Satisfied noises, goes to sleep");
    } else {
      System.out.println(getNoise() + " attack keeper!");
    }
  }
}
