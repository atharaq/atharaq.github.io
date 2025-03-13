# Heap

Heap.java:

```java
import java.util.Arrays;

public class Heap {
  private int[] array;
  private int tail; // next place to insert into

  public Heap(int n) {
    array = new int[n];
    tail = 0;
  }

  public void insert(int number) {
    // implement this here
  }

  public int removeMin() {
    int number = array[tail - 1];
    int minimum = array[0];
    tail--;

    int index = 0;
    int child = 2 * index + 1; // left child

    boolean finished = false;
    while (!finished) {
      // pick the smaller child
      // make sure that you're still in bounds first!

      // if the child is smaller than number, slide up
      // update child
      // exit conditions?
      // either the child is at the tail, or we found the right position
    }

    // update the array at "index"


    // return the minimum value
    return minimum;
  }

  public void printArray() {
    System.out.println(Arrays.toString(array));
  }

  public static void main(String[] args) {
    Heap h = new Heap(10);
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
        int num = r.nextInt(50);
        System.out.println("Inserting " + num);
        h.insert(num);
    }
    
    h.printArray(); // just for testing.
    
    // Uncomment below when you implement removeMin
    // for (int i = 0; i < 10; i++) {
    //     System.out.println("Removing: " + h.removeMin());
    // }
  }
}
```