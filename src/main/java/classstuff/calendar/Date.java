package classstuff.calendar;

import java.time.Month;

public class Date {
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

//  class SupportingStuff {
//    private int x;
  // code in here, if it has a Date, it can access day, month, year
//  }
  // constructor:
  // name matches EXACTLY the class name
  // there is NO RETURN TYPE
  public Date(/* implicit Date this MUST NOT declare this expliticly!? */
      int day, Month month, int year) {
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
    }  else
//    if (day == 0) return "Saturday";
//    if (day == 1) return "Sunday";
//    if (day == 2) return "Monday";
//    if (day == 3) return "Tuesday";
//    if (day == 4) return "Wednesday";
//    if (day == 5) return "Thursday";
//    if (day == 6) return "Friday";
    throw new IllegalArgumentException("Bad day " + day);
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

  // VERIFY BEFORE creating the date, therefore this method isn't useful
//  public static boolean isPlausibleDate(Date d) {
//    return isPlausibleDate(d.day, d.month, d.year);
//  }

  // do these numbers form a plausible date?
  public static boolean isPlausibleDate(int day, Month month, int year) {
    return day > 0 && day < daysInMonth(month, year);
  }

  // what is the name of this month (enum? int?)
  public static String monthName(Month m) {
    return m.name();
  }

//  public static int getDayOfWeek(Date d) {
// "instance" method, no "static", first argument is of the enclosing type, and is called "this"
//  public /*static*/ int getDayOfWeek(Date this) { // this is identical to the following
//  public /*static*/ int getDayOfWeek() { // Date this is *implicit* here.
//    return getDayOfWeek(d.day, d.month, d.year);
//    return getDayOfWeek(this.day, this.month, this.year);
//    int day = 1000;
    // UNQUALIFIED IDENTIFIER: month
    // - look for local variable (not found, but day would be found)
    // - if not found, look for instance field of the same name, if found apply "this" prefix
    //   -- if "this" doesn't exist, fail
    // - if no instance field, look for a static field, and use the Classname prefix
    //   -- e.g. getDayOfWeek here is actually Date.getDayOfWeek
//    return Date.getDayOfWeek(this.day, month, year);
//    return getDayOfWeek(this.day, month, year); // equivalent to above with Date. prefix
//  }

  public int getDayOfWeek() { // Date this is *implicit* here.
    return getDayOfWeek(this.day, month, year); // equivalent to above with Date. prefix
  }

  // what day of the week is this day, month, and year
  // returns "Zeller" day of week i.e. 0 = Saturday
  public static int getDayOfWeek(int day, Month month, int year) {
    int m = month.getValue(); // 1 -> 12
    if (m <= 2) {
      m += 12;
      year -= 1;
    }
    return (day + (13 * (m + 1) / 5) + year + (year / 4) - (year / 100) + (year / 400)) % 7;
  }

  // get a nice textual representation:
  public static String getAsText(int day, Month month, int year) {
    return "Date: " + getDayName(getDayOfWeek(day, month, year)) + " day is " + day + " month is " + month + " year is " + year;
  }

  public String getAsText(Date this) {
    return /*Date.*/getAsText(this.day, this.month, this.year);
  }
}

class UseDates {
  public static void main(String[] args) {
//    int myBirthDay = 15;
//    Month myBirthMonth = Month.APRIL;
//    int myBirthYear = 1978;

//    Date myBirth = new Date(); // --> day "zero", month "zero" (null pointer), year zero
//    myBirth.day = -100;
//    myBirth.month = Month.APRIL;
//    myBirth.year = 1978;

    // new ALLOCATES and zeroes the memory for a Date
    // then it finds a "constructor", which should be called "initializer"
    // with argument list that matches
//    Date myBirth = new Date(-15, Month.APRIL, 1978);
    Date myBirth = new Date(15, Month.APRIL, 1978);
//    myBirth.day = -100;
//    myBirth.setDay(-100);
    myBirth.setDay(10);
//
//    System.out.println("day of myBirth is " + myBirth.day);
    System.out.println("day of myBirth is " + myBirth.getDay());
//    System.out.println("myBirth looks like: " + Date.getAsText(myBirth));
    System.out.println("myBirth looks like: " + myBirth.getAsText());
//    System.out.println("myBirth was on a " + Date.getDayOfWeek(myBirth));
    System.out.println("myBirth was on a " + myBirth.getDayOfWeek());
  }
}
