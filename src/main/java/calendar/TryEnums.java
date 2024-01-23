package calendar;

enum DayOfWeek {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class TryEnums {

  // can call with the wrong semantic values, because the compiler can
  // only check the type, not the "meaning" an enum Month is not
  // assignable from an int, and would prevent that!
  public static void showDate(int day, int month, int year) {
    String[] names = {
        "January", "February",
    };
    System.out.println(day + "/" + names[month-1] + "/" + year);
  }

  public static boolean isFreeDay(int dayOfWeek) { // 1 = Monday -> 7 = Sunday
    if (dayOfWeek < 1 || dayOfWeek > 7) {
      throw new IllegalArgumentException("That's not a day number: " +dayOfWeek);
    }
    if (dayOfWeek < 6) return false;
    else return true;
  }

  public static boolean isFreeDay(DayOfWeek dayOfWeek) {
    if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) return true;
    else return false;
  }

  public static void main(String[] args) {
    System.out.println("Can I relax on day 6? " + isFreeDay(6));
//    System.out.println("Can I relax on day 16? " + isFreeDay(16));
    System.out.println("Can I relax on " + DayOfWeek.SUNDAY + "? " + isFreeDay(DayOfWeek.SUNDAY));
    showDate(12, 31, 2024);
  }
}
