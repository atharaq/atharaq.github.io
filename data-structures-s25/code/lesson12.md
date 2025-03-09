# Synonymous Search Queries

```java
import java.util.*;

public class Main {
  public static boolean synonymous(List<Pair> synonyms, String firstQuery, String secondQuery) {

    return false;
  }

  public static void main(String[] args) {
    List<Pair> synonyms = new ArrayList<>();
    synonyms.add(new Pair("happy", "joyful"));
    synonyms.add(new Pair("sad", "upset"));
    synonyms.add(new Pair("hello", "hi"));
    synonyms.add(new Pair("kid", "child"));

    System.out.println(synonymous(synonyms, "hi happy kid", "hello joyful kid")); // true
    System.out.println(synonymous(synonyms, "my child is joyful", "my child is upset")); // false
  }

  private static record Pair(String first, String second) {}
}
```