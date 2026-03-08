# Logic Errors

## Increment

```java
public class Increment {

  public static void main(String[] args) {
    int j = 0;
    for (int i = 0; i < 100; i++) {
      j = j++;
    }
    System.out.println(j);
  }
}
```

## InTheLoop

```java
public class InTheLoop {
  public static final int END = Integer.MAX_VALUE;
  public static final int START = END - 5;

  public static void main(String[] args) {
    int count = 0;
    for (int i = START; i <= END; i++)
      count++;
    System.out.println(count);
  }
}
```

## AnimalFarm

```java
public class AnimalFarm {

  public static void main(String[] args) {
    final String pig = "length: 10";
    final String dog = "length: " + pig.length();
    System.out.println(pig);
    System.out.println(dog);
    System.out.println("Animals are equal: " + pig == dog);
  }
}
```