# Lesson 6 Group Work Solution

```java
import java.util.Scanner;

public class Main {
  public static String displayTime(int hour, int minute) {
    String time = hour + ":";
    if (minute < 10) {
      time += "0";
    }
    return time + minute;
  }

  public static int hourAfter(int oldHour, int oldMinute, int minutesToAdd) {
    int hoursToAdd = (oldMinute + minutesToAdd) / 60;
    return (oldHour + hoursToAdd) % 24;
  }
  
  public static int minuteAfter(int oldHour, int oldMinute, int minutesToAdd) {
    return (oldMinute + minutesToAdd) % 60;
  }

  public static int getNumber(Scanner scanner, String prompt, int lowerBound, 
                              int upperBound, String error) {
    System.out.println(prompt);
    boolean done = false;
    int input = 0;
                              
    while (!done) {
      if (!scanner.hasNextInt()) {
        scanner.next();
        System.out.println(error);
      } else {
        input = scanner.nextInt();
        if (input < lowerBound || input > upperBound) {
          System.out.println(error);
        } else {
          done = true;
        }

      }
    }
    return input;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hour = getNumber(sc, "Input the hour", 0, 23, "Invalid hour");
    int min = getNumber(sc, "Input the min", 0, 59, "Invalid minute");
    int minutesToAdd = getNumber(sc, "Input a number of minutes to add", 1, 1000, "Invalid number");
    System.out.println("The time is " + displayTime(hour, min));
    int newHour = hourAfter(hour, min, minutesToAdd);
    int newMin = minuteAfter(hour, min, minutesToAdd);
    System.out.println("In " + minutesToAdd + " minutes, it will be " + displayTime(newHour, newMin));
  }
}
import java.util.Scanner;

public class Main {
  public static String displayTime(int hour, int minute) {
    String time = hour + ":";
    if (minute < 10) {
      time += "0";
    }
    return time + minute;
  }

  public static int hourAfter(int oldHour, int oldMinute, int minutesToAdd) {
    int hoursToAdd = (oldMinute + minutesToAdd) / 60;
    return (oldHour + hoursToAdd) % 24;
  }
  
  public static int minuteAfter(int oldHour, int oldMinute, int minutesToAdd) {
    return (oldMinute + minutesToAdd) % 60;
  }

  public static int getNumber(Scanner scanner, String prompt, int lowerBound, 
                              int upperBound, String error) {
    System.out.println(prompt);
    boolean done = false;
    int input = 0;
                              
    while (!done) {
      if (!scanner.hasNextInt()) {
        scanner.next();
        System.out.println(error);
      } else {
        input = scanner.nextInt();
        if (input < lowerBound || input > upperBound) {
          System.out.println(error);
        } else {
          done = true;
        }

      }
    }
    return input;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hour = getNumber(sc, "Input the hour", 0, 23, "Invalid hour");
    int min = getNumber(sc, "Input the min", 0, 59, "Invalid minute");
    int minutesToAdd = getNumber(sc, "Input a number of minutes to add", 1, 1000, "Invalid number");
    System.out.println("The time is " + displayTime(hour, min));
    int newHour = hourAfter(hour, min, minutesToAdd);
    int newMin = minuteAfter(hour, min, minutesToAdd);
    System.out.println("In " + minutesToAdd + " minutes, it will be " + displayTime(newHour, newMin));
  }
}

```
