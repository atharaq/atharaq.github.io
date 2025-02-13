# Solution to Group Exercise

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
    int totalMins = oldMinute + minutesToAdd;
    int hoursToAdd = totalMins / 60;
    return (oldHour + hoursToAdd) % 24;
  }
  
  public static int minuteAfter(int oldHour, int oldMinute, int minutesToAdd) {
    return (oldMinute + minutesToAdd) % 60;
  }

  public static int getNumber(Scanner scanner, String prompt, int lowerBound, 
                              int upperBound, String error) {
    
    int input = -1;
    boolean finished = false;
    while (!finished) {
      System.out.println(prompt);
      if (scanner.hasNextInt()) {
        input = scanner.nextInt();
        if (input < lowerBound || input > upperBound) {
          System.out.println(error);
        } else {
          finished = true;
        }
      } else {
        scanner.next();
        System.out.println(error);
      }
    }
    return input;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hour = getNumber(sc, "Enter the hour (0 - 23)", 0, 23, "That's not a valid hour");
    int min = getNumber(sc, "Enter a minute (0 - 59)", 0, 59, "That's not a valid minute");
    int minsToAdd = getNumber(sc, "Enter the number of mins to add (1 - 1000)", 1, 1000, "That's not a valid number from 1 - 1000");
    System.out.println("The current time is " + displayTime(hour, min));
    int newHour = hourAfter(hour, min, minsToAdd);
    int newMin = minuteAfter(hour, min, minsToAdd);
    System.out.println("After " + minsToAdd + " minutes, it will be " + displayTime(newHour, newMin));
  }
}
```
