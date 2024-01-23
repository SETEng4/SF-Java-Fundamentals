package calendar;


import java.time.DayOfWeek;
import java.time.Month;

public class Zeller {
  public static DayOfWeek dayOfWeek(int dayOfMonth, Month month, int year) {
    int m = month.getValue();
    if (m < 2) {
      year--;
      m += 12;
    }
    int dow = ( dayOfMonth + (13 * (m + 1) / 5)
        + year + (year / 4) - (year / 100) + (year / 400)) % 7;
    dow = ((dow + 5) % 7) + 1;
    return DayOfWeek.of(dow);
  }
}