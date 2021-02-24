# CS2 Lesson 7: Review
{:.no_toc}

1. Table of Contents
{:toc}

Some questions to think about:

# Determine the output

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
  public static boolean something(ArrayList<String> list) {
   for (int i = 0; i < list.size(); i++) {
      String nameOne = list.get(i);
      for (int j = i + 1; j < list.size(); j++) {
         String nameTwo = list.get(j);
         if (nameOne.equals(nameTwo)) {
            return true;
         }
      }
   }
   return false;
  }
  ```

# Understand the method

Describe, as clearly and succinctly as you can, what each of the following methods do. Use memory diagrams with some sample input and see if you can describe, in a succinct sentence, what the method is doing (at a "Big Picture" level).

1.

  ```java  
  public static int t(int[] list) {
    int t = 0;
    for (int number : list) {
      t += number;
    }
    return t;
  }
  ```

2.

  ```java
  public boolean p(int n) {
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

3.

  ```java
  public static int l(int x) {
    int i = 0;
    while (x / 2 > 0) {
      i++;
      x /= 2;
    }
  }
  ```

# Write a method

 1. Write a method "subList", which takes in an array and two integers as parameters, and returns an array with just the elements from "start" up until (including) "end - 1". For example, if we call the method on the array ["alice", "bob", "claire", "david", "edward", "florence"] with start = 1 and end = 3, this should return an array ["bob", "claire"]:

    ```java
    public String[] subList(String[] list, int start, int end) {

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
