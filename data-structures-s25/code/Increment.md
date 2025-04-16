# Increment.java

```java
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Increment implements Runnable {

  private static final int NUM_THREADS = 1000;
  private static final int NUM_INCREMENTS = 1000;

  private static int counter = 0;

  public void run() {
    for (int i = 0; i < NUM_INCREMENTS; i++) {
      ++counter;
    }
  }

  public static void main(String[] args) throws Exception {
    ArrayList<Thread> list = new ArrayList<>();

    for (int i = 0; i < NUM_THREADS; i++) {
      Thread t = new Thread(new Increment());
      list.add(t);
      t.start(); // calls the run method on Increment
    }

    for (Thread t : list) {
      t.join(); // ends this thread
    }

    System.out.println("Counter should be: " + (NUM_THREADS * NUM_INCREMENTS));
    System.out.println("Counter: " + counter);
  }
}
```