# Lesson 17 Starter Code

## RecursionExample.java

```java
public class RecursionExample {
  public static int add(int x, int y) {
    System.out.println("Calling add(" + x + ", " + y + ")");
    if (y == 0) {
      return x;
    }
    if (y > 0) {
      int answer = add(x + 1, y - 1);
      System.out.println("Returned to add(" + x + ", " + y + ")");
      return answer;
    }
    if (y < 0) {
      return add(x - 1, y + 1);
    }
    // this shouldn't happen
    return -1;
  }

  public static int recursiveFactorial(int n) {
    // Exercise: implement this!

    return -1;
  }

  public static int fib(int n) {
    // Exercise: implement this!

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(add(7, 2));
    // System.out.println(recursiveFactorial(20));

    // Uncomment below when you've implemented fib(n)
    // It should return 13
    // System.out.println(fib(7));
  }
}
```

## PartTwo.java

```java
import java.util.ArrayList;

public class PartTwo {
  public static int sumDigits(int num) {
    if (num < 0) {
        return sumDigits(-num);
    }
    if (num < 10) {
        return num;
    }
	  // implement the rest...

    return 0;
  }

  public static void printBeforeRecursion(ArrayList<String> list, int i) {
    if (i == list.size()) {
        return;
    }
    System.out.println(list.get(i));
    printBeforeRecursion(list, i+1);
}

  public static void printAfterRecursion(ArrayList<String> list, int i) {
    if (i == list.size()) {
        return;
    }
    printAfterRecursion(list, i+1);
    System.out.println(list.get(i));
  }

  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    System.out.println("Printing " + list + " before recursion:");
    printBeforeRecursion(list, 0);

    System.out.println();

    System.out.println("Printing " + list + " after recursion:");
    printAfterRecursion(list, 0);

    // uncomment the below when you implement the sumDigits exercise
    // System.out.println(sumDigits(319));
  }
  
}
```