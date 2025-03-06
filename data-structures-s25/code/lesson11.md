# Lesson 11 Code snippets

## Knight Path

Position.java:

```java
import java.util.ArrayList;
import java.util.List;

// Position class represents a position on the chessboard
// (1, 1) is the bottom left corner
// (8, 8) is the top right corner
public class Position {
  private final int row;
  private final int col;

  private static final int[][] DELTAS = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 },
      { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

  Position(int r, int c) {
    row = r;
    col = c;
  }

  private static boolean validPosition(int r, int c) {
    return (1 <= r && r <= 8 && 1 <= c && c <= 8);
  }

  public List<Position> nextPositions() {
    List<Position> nexts = new ArrayList<>();
    int r, c;
    for (int[] delta : DELTAS) {
      r = row + delta[0];
      c = col + delta[1];
      if (validPosition(r, c)) {
        nexts.add(new Position(r, c));
      }
    }

    return nexts;
  }

  @Override
  public int hashCode() {
    return 31 * row + col;
  }

  // Look for the book Effective Java by Josh Bloch

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (!(obj instanceof Position)) {
      return false;
    }

    Position other = (Position) obj;
    return row == other.row && col == other.col;
  }

  @Override
  public String toString() {
    return "(" + row + ", " + col + ")";
  }
}
```

Main.java:

```java
import java.util.*;

public class Main {
  public static List<Position> shortestPath(Position start, Position end) {
    Queue<Position> posQueue = new LinkedList<>(); // queue for the BFS
    Set<Position> visited = new HashSet<>(); // keep track of visited nodes
    Map<Position, Position> prevsMap = new HashMap<>(); // parent map
    Position current = start;
    // BFS:

    // put the parent of parents[start] = null
    // current = start
    // while (current != end) {
    //    get all the nextPositions from current
    //    for each one, 
    //      if they are not yet visited, 
    //        mark them as visited
    //        add them to the queue
    //        add them to the parents map
    //   update current by getting the next position off the queue
    // }

    LinkedList<Position> list = new LinkedList<>();
    // now backtrack from the end back to the start using the parents map
    // return a LinkedList so it's easier to add them in the correct order.
    

    return list;
  }

  public static void main(String[] args) {
    Random r = new Random();
    Position start = new Position(r.nextInt(8) + 1, r.nextInt(8) + 1);
    Position end = new Position(r.nextInt(8) + 1, r.nextInt(8) + 1);
    System.out.println("Path from " + start + " to " + end);
    System.out.println(shortestPath(start, end));
  }

}
```


## GPS / City

Location.java:

```java
import java.util.ArrayList;
import java.util.List;

// You can use this class to implement a BFS for the
// City Path problem as well. Try it!
// In main, also implement a shortestPath method
// when given two Location objects.
record Location(int street, int ave) {   

    public List<Location> nextLocations() {
        ArrayList<Location> list = new ArrayList<>();
        if (street % 2 == 0) {
            // westbound
            for (int i = ave + 1; i <= 10; i++) {
                list.add(new Location(street, i));
            }
        }  else {
            for (int i = ave - 1; i >= 1; i--) {
                list.add(new Location(street, i));
            }
        }

        if (ave % 2 == 0) {
            // southbound
            for (int i = street - 1; i >= 1; i--) {
                list.add(new Location(i, ave));
            }
        } else {
            for (int i = street + 1; i <= 100; i++) {
                list.add(new Location(i, ave));
            }
        }
        return list;
    }
  
}
```

