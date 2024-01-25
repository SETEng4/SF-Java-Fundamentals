package calendar;

import java.time.DayOfWeek;
import java.time.Month;

/**
 * This class contains useful calculations related to dates, particularly
 * Zeller's Congruence
 * @author simon
 */
public class Zeller {
  /**
   *
   * @param dayOfMonth this represents the day of the month, from 1 to 31
   * @param month
   * @param year
   * @return this returns a DayOfWeek object representing Monday through Sunday
   */
  /*public*/ static DayOfWeek dayOfWeek(int dayOfMonth, Month month, int year) {
    int m = month.getValue();
    if (m <= 2) { // was < 2 that was the bug!!!
      year--;
      m += 12;
    }
    int dow = ( dayOfMonth + (13 * (m + 1) / 5)
        + year + (year / 4) - (year / 100) + (year / 400)) % 7;
    dow = ((dow + 5) % 7) + 1;
    return DayOfWeek.of(dow);
  }
}

class TestZeller {
  public static void main(String[] args) {
    int[][] testValues = {
        {1, 1, 2000, 6},
        {1, 1, 1900, 1},
        {1, 3, 1900, 4},
        {8, 3, 1900, 4},
        {1, 2, 1900, 4},
    };
    for (int[] values : testValues) {
      Month month = Month.of(values[1]);
      DayOfWeek dow = Zeller.dayOfWeek(values[0], month, values[2]);
      DayOfWeek expected = DayOfWeek.of(values[3]);
      System.out.printf("day: %d, month: %s, year: %d, returned: %s, expected: %s, %s\n",
          values[0], month, values[2], dow, expected, (dow == expected) ? "OK" : "***FAIL!!!***");
    }
  }
}
