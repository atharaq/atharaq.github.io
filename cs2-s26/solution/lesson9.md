# Lesson 9 Solution

Solution for the Time exercise. Use the [starter code](../code/lesson9.html) for the Time class and the rest of the Main class.

In `Main.java`:

```java
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hour = getInput(sc, "Input the hour (1-12)", Time.MIN_HOUR, Time.MAX_HOUR);
    int min = getInput(sc, "Input the minute (0-59)", Time.MIN_MINUTE, Time.MAX_MINUTE);
    String amPm = getAmOrPmInput(sc);
    
    Time currentTime = new Time(hour, min, amPm);
    System.out.println("The current time is " + currentTime);
    int minsToAdd = getInput(sc, "Input the number of minutes to add (1-500)", 1, 500);
    
    Time newTime = currentTime.timeAfter(minsToAdd);
    System.out.println("In " + minsToAdd + " minutes, it will be " + newTime);
  }
```