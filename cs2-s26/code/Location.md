# Location

Location.java:

```java
import java.util.Collections;
import java.util.List;

public class Location implements Comparable<Location> {

    private int street;
    private int avenue;

    public Location(int s, int a) {
        street = s;
        avenue = a;
    }

    public String toString() {
        return street + " St and " + avenue + " Ave";
    }

    // south < north, and east < west.
    // return negative if this street < other.street
    // return negative if this street == other.street AND this ave < other.ave
    // return 0 if this street == other.street AND this ave == other.ave
    // return positive otherwise
    @Override
    public int compareTo(Location other) {
        return 0;
    }

    public static void main(String[] args) {
      List<Location> locations = new ArrayList<>();
      locations.add(new Location(15, 5)); // 15th st & 5th ave
      locations.add(new Location(25, 3)); // 25th st & 3rd ave
      locations.add(new Location(10, 7)); // 10th st & 7th ave
      locations.add(new Location(15, 2)); // 15th st & 2nd ave

      Collections.sort(locations);
      System.out.println(locations);
  }
}
```