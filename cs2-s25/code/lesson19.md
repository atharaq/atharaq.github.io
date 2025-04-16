# Lesson 19: Guessing Game and Search

## GuessingGame.java:

```java
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
  private static final int LOW = 0;
  private static final int HIGH = 1022;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = new Random().nextInt(HIGH - LOW + 1) + LOW;

    int numGuesses = 0;

    System.out.println("Guess a number from " + LOW + " to " + HIGH + " (inclusive)");
    int guess = sc.nextInt();
    numGuesses++;

    while (guess != number) {
      if (guess < number) {
        System.out.println("Too low");
      } else {
        System.out.println("Too high");
      }

      System.out.println("Guess again.");
      guess = sc.nextInt();
      numGuesses++;
    }

    System.out.println("Correct! It only took you " + numGuesses + " guesses!");

  }
}

```

## Finder.java:

```java
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Finder {

  private ArrayList<Integer> list;

  public Finder(ArrayList<Integer> l) {
    list = l;
  }

  // returns "i" if list.get(i) = number.
  // returns -1 if number is not in the list.

  public int find(int number) {
    // change this to use the binary search algorithm!
    // Also print out the number of steps it takes to find a number in the list!
    int numSteps = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == number) {
        System.out.println("Found " + number + " in " + numSteps + " steps");
        return i;
      }
      numSteps++;
    }
    return -1;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = testList();

    // try it out with the "randomSortedList" instead after you have finished
    // implementing the binary search.
    // ArrayList<Integer> list = randomSortedList();

    Finder f = new Finder(list);

    int number = 6221;

    System.out.println("Looking for " + number + " in list");
    int i = f.find(number);
    if (i == -1) {
      System.out.println("Not found!");
    } else {
      System.out.println(number + " found at position " + i);
    }
  }

  // returns a sorted list of primes numbers less than 10000
  public static ArrayList<Integer> testList() {
    return TEST_LIST;
  }

  // returns a random, sorted list
  public static ArrayList<Integer> randomSortedList() {
    ArrayList<Integer> list = new ArrayList<>();

    TreeSet<Integer> tree = new TreeSet<>();
    Random r = new Random();
    for (int i = 0; i < 10000; i++) {
      tree.add(r.nextInt(20000));
    }

    list.addAll(tree);
    return list;
  }

  // static test list which stores prime numbers in sorted order
  private static final ArrayList<Integer> TEST_LIST;

  static {
    TEST_LIST = new ArrayList<Integer>();
    TEST_LIST.add(2);
    for (int i = 3; i < 10000; i += 2) { // skip over even numbers since they are not prime
      boolean isPrime = true;
      for (int prime : TEST_LIST) { // check current prime numbers to see if it evenly divides into number
        if (i % prime == 0) { // when number is not prime
          isPrime = false;
          break; // optimization: stop checking when number is already not prime
        }
      }
      if (isPrime) {
        TEST_LIST.add(i);
      }
    }
  }

}
```