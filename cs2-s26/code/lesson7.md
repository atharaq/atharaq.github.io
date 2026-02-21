# Lesson 7 Starter Code

Copy / paste this into IntelliJ or a VSCode project:

```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int[] numbers = new int[5];
    Scanner sc = new Scanner(System.in);
    int index = 0;
    System.out.println("Input in the first number: ");
    while (sc.hasNextInt()) {
      int number = sc.nextInt();
      if (index >= numbers.length) {
        numbers = resizeArray(numbers);
      }
      numbers[index] = number;
      index++;
      System.out.println("Input in the next number: ");
    }
    System.out.println("Your list: " + Arrays.toString(numbers));
  }

  public static int[] resizeArray(int[] originalArray) {
    // create a new array whose size is 2 * originalArray.length

    // for loop that copies over the old elements of originalArray to the new one

    // return the new array
    return null;
  }
}
```