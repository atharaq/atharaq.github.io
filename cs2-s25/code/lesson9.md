# Lesson 9 Time Class

Put the following in a file called `Time.java`:

```java
import java.util.Scanner;

public class Time {
  // static constants
  public static final int MIN_HOUR = 1;
  public static final int MAX_HOUR = 12;
  public static final int MIN_MINUTE = 0;
  public static final int MAX_MINUTE = 59;
  public static final String AM = "AM";
  public static final String PM = "PM";

  // instance variables
  private int hour;
  private int minute;
  private String amPm;

  // constructor
  public Time(int currentHour, int currentMin, String currentAmPm) {
    if (currentHour < MIN_HOUR || currentHour > MAX_HOUR) {
      throw new IllegalArgumentException("Illegal hour: " + currentHour + ". Hour must be between " + MIN_HOUR + " and " + MAX_HOUR + ".");
    }
    hour = currentHour;

    if (currentMin < MIN_MINUTE || currentMin > MAX_MINUTE) {
      throw new IllegalArgumentException("Illegal minute: " + currentMin + ". Minute must be between " + MIN_MINUTE + " and " + MAX_MINUTE + ".");
    }
    minute = currentMin;

    if (!currentAmPm.equals(AM) && !currentAmPm.equals(PM)) {
      throw new IllegalArgumentException("Illegal AM/PM: " + currentAmPm + ". AM/PM must be either " + AM + " or " + PM + ".");
    }
    amPm = currentAmPm;
  }

  public Time timeAfter(int numMins) {
    int newMinute = minute + numMins;
    int newHour = hour + newMinute / 60;
    newMinute = newMinute % 60;

    String newAmPm = amPm;
    if (newHour >= 12) {
      // This would not work in more generality
      // Think about how you might change this if numMins were unbounded?
      if (amPm.equals(AM)) {
        newAmPm = PM;
      } else {
        newAmPm = AM;
      }
      if (newHour > 12) {
        newHour = newHour % 12;
      }
    }

    return new Time(newHour, newMinute, newAmPm);
  }

  // getters

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public String getAmPm() {
    return amPm;
  }

  // toString method
  public String toString() {
    if (minute < 10) {
      return hour + ":0" + minute + " " + amPm;
    }
    return hour + ":" + minute + " " + amPm;
  }
}
```

Put this in a file called `Main.java`:

```java
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // create a new Scanner object
    // get inputs from the user for:
    // hour, minute (use getInput)
    // am/PM String (use getAmOrPmInput)

    // Create a new Time object and output the current time.

    // Get input from user for the number of mins to add
    // Up to 1-1000. (use getInput)

    // Then use the appropriate method in the Time class to find the time after that

    // Then output the time after that many minutes.
  }

  public static int getInput(Scanner sc, String prompt, int low, int high) {
    System.out.println(prompt);
    int input = 0;
    boolean valid = false;
    while (!valid) {
      if (sc.hasNextInt()) {
        input = sc.nextInt();
        if (input >= low && input <= high) {
          valid = true;
        } else {
          System.out.println("Invalid Range: " + input + " is not between " + low + " and " + high + ".");
        }
      } else {
        String word = sc.next();
        System.out.println("Invalid Input: " + word + " is not an integer.");
      }
    }
    return input;
  }

  public static String getAmOrPmInput(Scanner sc) {
    String input = null;
    while (!Time.AM.equals(input) && !Time.PM.equals(input)) {
      System.out.println("Input in AM or PM.");
      input = sc.next();
      input = input.toUpperCase();
    }

    return input;
  }
}
```