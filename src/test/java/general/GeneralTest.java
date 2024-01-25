package general;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;

public class GeneralTest {
  static {
    System.out.println("Preparing class GeneralTest");
  }
  {
    System.out.println("instantiating GeneralTest");
  }
  private static boolean getTrue() {
    return true;
  }

  @Test
  public void piShouldBeThreePointOneFour() {
    double pi = 3.14;
    double expected = Math.PI;
    Assert.assertEquals("Pi should be 3.14", expected, pi, 0.01);
  }

  @Test
  public void trueShouldBeTrue() {
    System.out.println("testing if true is true");
    boolean expected = true;
    boolean calculated = getTrue();
    Assert.assertEquals("true should be true!", expected, calculated);
  }

  @Test
  public void falseShouldBeTrue() {
    System.out.println("testing if false is true");
    boolean expected = false;
    boolean calculated = getTrue();
    Assert.assertEquals("false should be true!?!?!?", expected, calculated);
//    throw new RuntimeException("Bwahahaha, that's a silly idea!");
  }

  @Test(expected = java.io.FileNotFoundException.class)
  public void openNonExistentFileShouldThrowException() throws Throwable {
    FileReader fr = new FileReader("DoesNotExist");
  }
}
