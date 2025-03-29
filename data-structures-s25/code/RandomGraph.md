# Random Graph

RandomGraph.java:

```java
import java.util.*;

public class RandomGraph {
    private int size;
    private boolean[][] adjacencyMatrix;

    public RandomGraph(int size, double probability) {
        this.size = size;
        adjacencyMatrix = new boolean[size][size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    adjacencyMatrix[i][i] = false;
                    continue;
                }

                if (r.nextDouble() < probability) {
                    adjacencyMatrix[i][j] = true;
                } else {
                    adjacencyMatrix[i][j] = false;
                }
            }
        }
    }

    public boolean hasAPath(int start, int end) {
        // TODO: Implement BFS algorithm.
        return false;
    }

    public void printGraph() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < size; j++) {
                if (adjacencyMatrix[i][j]) {
                    System.out.print("(" + i  + ", " + j + ") ");
                }
            }
            System.out.println();
        }
    }
}
```

Main class:

```java
public class Main {
  public static void simulate(int numTries) {
      // TODO:
      // 1. create numTries RandomGraphs with some fixed size and probability
      // 2. for each one, check if there is a path from 0 to size - 1
      // 3. if there is, increment numSuccesses
      // 4. at the end, print ou the number of successes out of the number of tries

      int numSuccesses = 0;

      int size = 4;
      double prob = 0.5; // fix p = 0.5 for now.



      System.out.println(numSuccesses + " / " + numTries);
  }

  public static void main(String[] args) {
      RandomGraph r1 = new RandomGraph(10, .1);
      r1.printGraph();
      System.out.println(r1.hasAPath(0, 3));

      simulate(1000);
  }
}
```