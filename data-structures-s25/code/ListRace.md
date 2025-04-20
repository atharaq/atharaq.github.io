# List Race Condition

```java
import java.util.*;
import java.util.concurrent.*;

public class ListRaceCondition implements Runnable {

  private Queue<Integer> list;
  private int num;

  public ListRaceCondition(Queue<Integer> list, int num) {
    this.list = list;
    this.num = num;
  }

  public void run() {
    list.add(num);
  }
  
  public static void main(String[] args) throws Exception {
    Queue<Integer> ints = new LinkedList<>();

    ExecutorService singleThreaded = Executors.newSingleThreadExecutor();
    ExecutorService multiThreaded = Executors.newCachedThreadPool();

    // ExecutorService e = singleThreaded;
    ExecutorService e = multiThreaded;

    for (int i = 0; i < 50; i++) {
      e.execute(new ListRaceCondition(ints, i));
    }

    e.shutdown();
    e.awaitTermination(1000, TimeUnit.MILLISECONDS);

    int counter = 0;
    for (int num : ints) {
      System.out.println(counter + ": " + num);
      counter++;
    }
  }
}
```