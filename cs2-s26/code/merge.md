# Merge Sort Code

Starter Code for merge sort:

```java
import java.util.*;

public class MergeSort {
  public static final int SIZE = 8;

  public static void merge(int[] array, int[] tmpArray, int start, int mid, int end) {
    // assume the array is sorted from "start" to "mid - 1",
    // and from "mid" to "end - 1"

    // merge them into the tmpArray

    // then copy back over.
  }

  public static void mergesort(int[] array, int[] tmpArray, int start, int end) {
    // first check for the base case
    // (is the distance from start to end <= 1?)

    // then find the midpoint
    // mergesort from the start to the midpoint
    // mergesort from the midpoint to the end
    // then merge
  }

  public static void testMerge() {
    System.out.println("Testing the merge method");
    int[] array = {1, 2, 3, 4, 0, 5, 6, 7};
    merge(array, new int[array.length], 0, array.length / 2, array.length);
    System.out.println("After merging: " + Arrays.toString(array));
  }

  public static void testSort() {
    System.out.println("Testing the mergesort method");
    int[] array = new int[SIZE];
    Random r = new Random();
    for (int i = 0; i < SIZE; i++) {
      array[i] = r.nextInt(50);
    }

    System.out.println("Initial: " + Arrays.toString(array));
    int[] tmpArray = new int[SIZE];

    mergesort(array, tmpArray, 0, array.length);
    System.out.println("Sorted : " + Arrays.toString(array));
  }

  public static void main(String[] args) {
    testMerge();
    // testSort();
  }
}
```