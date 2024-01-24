package zookeeper.animals;

public abstract class Animal {
  private int weight;
  private String noise;

  // not permitted to have an *explicit* this in a constructor (who knows why!)
  // However, it's there!!!
  // when entering the constructor, this has all its fields "zero"
  public Animal(/*Animal this, */int weight, String noise) {
    if (! Animal.isValid(weight, noise)) {
      throw new IllegalArgumentException("Bad Animal values");
    }
    this.weight = weight;
    this.noise = noise;
  }

  public int getWeight(Animal this) {
//    return this.weight;
    return weight;
  }

  public void setWeight(int weight) {
    if (! Animal.isValid(weight, noise)) {
      throw new IllegalArgumentException("Bad Animal values");
    }
    this.weight = weight;
  }

  public String getNoise() {
    return noise;
  }

  public void setNoise(String noise) {
    if (! Animal.isValid(weight, noise)) {
      throw new IllegalArgumentException("Bad Animal values");
    }
    this.noise = noise;
  }

  public static boolean isValid(int weight, String noise) {
    return (weight >= 0 && noise != null && noise.length() > 0);
  }

  public abstract String getFavoriteFood();
//  public String getFavoriteFood() {
//    throw new UnsupportedOperationException("Animal isn't real, can't ask about food!");
//  }
//
  public abstract void feed(String food);
//  public void feed(String food) {
//    throw new UnsupportedOperationException("Animal isn't real, can't ask about food!");
//  }
}
