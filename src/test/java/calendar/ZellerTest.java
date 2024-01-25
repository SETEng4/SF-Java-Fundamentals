package calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.List;

@RunWith(Parameterized.class)
public class ZellerTest {
  private int day;
  private Month month;
  private int year;
  private DayOfWeek expected;

  @Parameterized.Parameters
  public static List<Object[]> getParams() {
    Object[][] testValues = {
        {1, 1, 2000, 6},
        {1, 1, 1900, 1},
        {1, 3, 1900, 4},
        {8, 3, 1900, 4},
        {1, 2, 1900, 4},
    };
    return List.of(testValues);
  }

  public ZellerTest(int d, int m, int y, int e) {
    System.out.printf("constructing ZellerTest with %d, %d, %d, %d\n", d, m, y, e);
    day = d;
    month = Month.of(m);
    year = y;
    expected = DayOfWeek.of(e);
  }

  @Test
  public void testZeller() {
//    Month month = Month.of(1);
    java.time.DayOfWeek dow = Zeller.dayOfWeek(day, month, year);
//    java.time.DayOfWeek expected = DayOfWeek.of(5);
    Assert.assertEquals("Expected " + expected, expected, dow);
  }
}
