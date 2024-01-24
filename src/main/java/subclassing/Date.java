package subclassing;

import java.time.Month;

// no extends??? implicitly extends ...Object
public class Date /*extends java.lang.Object*/ {
  private int day;
  private Month month;
  private int year;

  public void setDay(int day) {
    if (isPlausibleDate(day, month, year)) {
      this.day = day;
    } else {
      throw new IllegalArgumentException("Bad day for this month!");
    }
  }

  public int getDay() {
    return day;
  }

  // called a constructor, really "initializer", Date is built by "new" and
  // passed in there (implicitly) for filling in the fields.
  public Date(int day, Month month, int year) {
    if (!isPlausibleDate(day, month, year)) {
      throw new IllegalArgumentException("Bad date proposal");
    }
    this.day = day;
    this.month = month;
    this.year = year;
  }

  // is this a leap year
  public static boolean isLeapYear(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  public static final String[] DAY_NAMES = {
      "Saturday",
      "Sunday",
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
  };

  public static String getDayName(int day) {
    if (day >= 0 && day <= 6) {
      return DAY_NAMES[day];
    }  else throw new IllegalArgumentException("Bad day " + day);
  }

  // how many days are there in this month
  public static int daysInMonth(Month m, int year) {
    int days = -1;
    switch (m) {
      case SEPTEMBER:
      case APRIL:
      case JUNE:
      case NOVEMBER:
        days = 30;
        break;
      case JANUARY:
      case MARCH:
      case MAY:
      case JULY:
      case AUGUST:
      case OCTOBER:
      case DECEMBER:
        days = 31;
        break;
      case FEBRUARY:
        days = isLeapYear(year) ? 29 : 28;
        break;
    }
    assert (days > 0);
    return days;
  }

  // do these numbers form a plausible date?
  public static boolean isPlausibleDate(int day, Month month, int year) {
    return day > 0 && day < daysInMonth(month, year);
  }

  // what is the name of this month (enum? int?)
  public static String monthName(Month m) {
    return m.name();
  }

  public int getDayOfWeek() { // Date this is *implicit* here.
    int m = month.getValue(); // 1 -> 12
    int y = this.year;
    if (m <= 2) {
      m += 12;
      // SIMON SCREWED UP HERE BADLY
      // -- we MUST NOT mutate this object just for a temporary calculation
//      year -= 1;
      y -= 1;
    }
    return (day + (13 * (m + 1) / 5) + y + (y / 4) - (y / 100) + (y / 400)) % 7;
  }

  public String toString() {
    // getDayName -> Date.getDayName (it's static)
    // getDayOfWeek -> this.getDayOfWeek (it's instance!)
    return "Date: " + getDayName(getDayOfWeek()) +
        " day is " + day + " month is " + month + " year is " + year;
  }
}

// no access control "word" usually means "accessible anywhere within this package"
class Holiday extends Date {
  private String name;
  // "default" constructor -- get this if you provide ZERO constructors in the source
  // same accessibility as this class
  // take no arguments
  // do nothing except:...
  Holiday(int day, Month month, int year, String name) {
    // first task of ANY constructor is to initialize the "base" class
    super(day, month, year);
    this.name = name;
  }

  public void celbrate() {
    System.out.println("lots of noise and laughter, we're having a " + name +
        " party because it's " + this);
  }

  @Override
  public String toString() {
    return "I'm a holiday called " + name + " on: " + super.toString();
  }

}

class UseDates {

  public static void doStuffOnDate(Date d) {
    System.out.println("Doing stuff on " + d);
//    if (d instanceof Holiday) { // Java since 1.0
//      Holiday h = (Holiday)d;
    if (d instanceof Holiday h) { // Java 14??? work with 17+
      h.celbrate();
    }
  }

  public static void main(String[] args) {
//    Date badDate = new Date(); // no "zero arg" constructor in Date any more!
    Date myBirth = new Date(15, Month.APRIL, 1978);
    System.out.println("myBirth looks like: " + myBirth.toString());

    Holiday newYearsDay = new Holiday(1, Month.JANUARY, 2025, "New Year's Day");

    String holidayText = newYearsDay.toString();
    System.out.println(holidayText);

    System.out.println("---------------------");
    doStuffOnDate(newYearsDay);

    Date d1 = new Date(3, Month.AUGUST, 2024);
    doStuffOnDate(d1);
    System.out.println("---------------------");

    newYearsDay.celbrate();
  }
}
