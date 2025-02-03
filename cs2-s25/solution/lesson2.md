# Lesson 2 Exercise Solution

```java
public class Main {
    public static void main(String[] args) {
        int hour = 12;
        int minute = 30;

        System.out.println("The current time is " + hour + ":" + minute);

        int minsToAdd = 95;

        minute += minsToAdd;
        int hoursToAdd = minute / 60;

        hour += hoursToAdd;
        minute = minute % 60;

        String output = "In " + minsToAdd + " minutes, it will be " + hour + ":";
        if (minute < 10) {
            output += "0";
        }
        output += minute;
        System.out.println(output);
    }
}
```