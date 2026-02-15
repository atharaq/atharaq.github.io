# CS2 Exam 1 Review
{:.no_toc}

1. Table of Contents
{:toc}

# Project 1 Notes

By now:

* You should have code to handle input (4 times).
* You should have code to figure out, on a given street/avenue, if you can go east/west/north/south.
* You should have code to figure out whether you want to go east/west/north/south (based on your current street/avenue and your destination street/avenue).

What would make sense to do next? Simple idea that works:

* As long as you haven't reached your destination, figure out a direction that makes sense to move in and move.
* What kind of loop is that?
* What's the loop condition?
* How do you figure out a direction? (Hard: but think about easy ideas first, try a few things at a time.)

Remember: **coding is learning**. You're not learning to code if you aren't coding, and so even if you feel like you need time to study, you are preparing for the exam by doing a little work on the project. You also should do some exercises as well.

**Note**: I added the "explanation.md" file for everyone. You might not have seen it right away depending on when you accepted the assignment. So you may need to sync your project for that file to show up.

# Quiz 1 Discussion

Biggest issues:

1. Methods: how do we *write* them? How do we *use* them?
2. Loops: how do *nested loops* work?

## Methods

* Why do we have methods?
* Write once, re-use!

## Example

```java
int[] list = { 1, 3, 0, -2, 5 };
System.out.println(minimum(list));
int[] list2 = { 4, 3, 2, 5, 6, 7, 1, 8, 9 };
System.out.println(minimum(list2));
```

What should the code for `minimum` look like?

## Errors

```java
public static int minimum(int[] list) {
    int[] list = { 1, 3, 0, -2, 5 };
    int min = list[0];
    for (int i = 1; i < list.length; i++) {
        if (list[i] < min) {
            min = list[i];
            System.out.println(min);
        }
    }
    System.out.println(min);
}
```

How many errors do you see in this method? Discuss.

## Upshot: methods

* Do not initialize the parameters. (Why?)
* Keep the **return type** in mind.
* Make sure it works for as *general* a problem as possible.

## (Nested) loops

```java
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        System.out.print("(" + i + ", " + j + ") ");
    }
    System.out.println();
}
```

What is output?

## Upshot: loops

* (Minor): `print` vs `println`
* (Major): inside loop has to finish before outside loop increments.

# Exam 1 Review questions

Some questions to think about:

# Determine the output (25-35%)

 1. Determine what the following method outputs if the list is ["charles", "candy", "cool", "abaca"]. Draw out the memory diagram. (Hint: look up the behavior of the String's compareTo method):

    ```java
    public static void m(String[] list) {
        int first = 0;
        String name = list[first];
        for (int i = 1; i < list.length; i++) {
            if (name.compareTo(list[i]) > 0) {
                first = i;
                name = list[i];
            }
        }
        System.out.println(first + ": " + name);
    }
    ```

 2. What does the following method return if the input list is ["Athar", "Bob", "Carl", "David"]? What if the list is ["Bob", "Carl", "Bob", "David"]? Draw the memory diagrams for each of these.

    ```java
    public static boolean something(String[] list) {
        for (int i = 0; i < list.length; i++) {
            String nameOne = list[i];
            for (int j = i + 1; j < list.length; j++) {
                String nameTwo = list[j];
                if (nameOne.equals(nameTwo)) {
                    return true;
                }
            }
        }
        return false;
    }
    ```

3. What is output by the following code if `print(3)` is invoked? What if `print(10)` is invoked?

```java
public static void printSpace(int n) {
  if (n >= 100) {
    System.out.print(" " + n);
  } else if (n >= 10) {
    System.out.print("  " + n);
  } else {
    System.out.print("   " + n);
  }
}

public static void print(int n) {
  System.out.print("   x");
  for (int i = 1; i <= n; i++) {
    printSpace(i);
  }
  System.out.println();
  for (int i = 1; i <= n; i++) {
    printSpace(i);
    for (int j = 1; j <= n; j++) {
      printSpace(i * j);
    }
    System.out.println();
  }
}
```

# Understand the method (10-20%)

Describe, as clearly and succinctly as you can, what each of the following methods do. Use memory diagrams with some sample input and see if you can describe, in a succinct sentence, what the method is doing (at a "Big Picture" level).

 1. Example one:

    ```java  
    public static int t(int[] list) {
        int t = 0;
        for (int number : list) {
            t += number;
        }
        return t;
    }
    ```

 2. Example two:

    ```java
    public static boolean p(int n) {
        int i = 0;
        while (i * i < n) {
            i++;
        }
        if (i * i == n) {
            return true;
        }
        return false;
    }
    ```

 3. Example three:

    ```java
    public static int l(int x) {
        int i = 0;
        while (x / 2 > 0) {
            i++;
            x /= 2;
        }
        return i;
    }
    ```

# Write a method (20%)

 1. Write a method "subList", which takes in an array and two integers as parameters, and returns an array with just the elements from "start" up until (including) "end - 1". For example, if we call the method on the array ["alice", "bob", "claire", "david", "edward", "florence"] with start = 1 and end = 3, this should return an array ["bob", "claire"]:

    ```java
    public static String[] subList(String[] list, int start, int end) {

    }
    ```

 2. Write the "isPerfectSquare" method from the homework exercises. The method should take in a parameter $n$ and return **true** if $n$ is a perfect square, and **false** if not. You should **not** use Math.sqrt in this method!

    ```java
    public static boolean isPerfectSquare(int n) {

    }
    ```

 3. Write a method "fibonacci" which returns the "n"-th fibonacci number. This is defined so that fibonacci(0) returns 0, fibonacci(1) returns 1, and the $n$-th fibonacci number is the sum of the $(n-1)$-st and $(n-2)$-nd fibonacci numbers.

    ```java
    public static int fibonacci(int n) {

    }
    ```

# Put it together (35%)

Given a problem (broken into components), implement each "component" in its own method, and write a main method that uses all the components.

One example was the "time" exercises we did in lesson 6. Here is another example:

Write a program which asks users to input in two positive fractions and outputs the sum of the fractions. For example, if the user inputted in 1/2 and 1/3, the program would output 5/6. To handle the input, you will need to ask the user to input in four integers, representing the numerators and denominators of two fractions. You should not worry about reducing the fraction: given fractions $a/b$ and $c/d$, the sum is $(ad + bc) / (bd)$.

You should implement this in a **modular** way. That is, you will need to implement the following methods:

* `getNumber`: output a `prompt` and taken the input in from the user. If the input is not an integer, or it is not positive ($\leq 0$), then output `error` and exit the program. Otherwise, return the input.
* `numerator`: takes in four parameters: the numerators and denominators of each of the two fractions you are adding, and returns the numerator of the sum of the fractions. That is, given fractions $a/b$ and $c/d$, this method should return $ad + bc$.
* `denominator`: takes in four parameters: the numerators and denominators of each of the two fractions you are adding, and returns the denominator of the sum of the fractions. That is, given fractions $a/b$ and $c/d$, this method returns $bd$.
* `displayNumber`: takes in two parameters: a numerator $a$ and a denominator $b$, and returns a String $a / b$.

```java
public static int getNumber(Scanner scan, String prompt, String error) {



}

public static int numerator(int numerX, int denomX, int numerY, int denomY) {



}

public static int denominator(int numerX, int denomX, int numerY, int denomY) {



}

public static String displayNumber(int numer, int denom) {



}

```

Next you will be asked to **put everything together** in the main method. That is, your main method should create a new Scanner, use `getNumber` to get four inputs from the user (the numerator of $x$, the denominator of $x$, the numerator of $y$, the denominator of $y$), output each of the two fractions on their own, compute the sum of the two fractions, and then output that on its own line. For example, if the user inputs in:

* numerator of $x$: 1
* denominator of $x$: 10
* numerator of $y$: 2
* denominator of $y$: 5

The program should display:

```
x = 1 / 10
y = 2 / 5
x + y = 25 / 50
```

(Note: you do not need to reduce fractions here. But if you'd like, see if you can implement two other methods, `reduceNumer` and `reduceDenom` which take in the numerator and denominator of a fraction and return the numerator and denominator, respectively, of the equivalent reduced fraction.)
