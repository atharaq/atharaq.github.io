# Lesson 9 Starter Code

SetADT.java:

```java
public interface SetADT<T> {
  boolean contains(T item);
  void insert(T item);
  void remove(T item);
  int size();
}
```

ArrayListSet.java:

```java
public class ArrayListSet<T> implements SetADT<T> {

  // TODO: Implement this interface using an ArrayList
  // 1. Keep a private ArrayList variable.
  // 2. When we insert, first check if the item is not in the list already.
  // 3. If it is, just return. If not, add it to the end.

  // O(n)
  public boolean contains(T item) {
    return false;
  }

  // O(n)
  public void insert(T item) {
    
  }

  // O(n)
  public void remove(T item) {
    
  }

  // O(1)
  public int size() {
    return -1;
  }
  
}
```

Main.java:

```java
public class Main {
  public static void main(String[] args) {
    SetADT<Integer> set = new ArrayListSet<>();
    set.insert(3);
    set.insert(1);
    set.insert(3);
    set.insert(5);
    set.insert(7);

    System.out.println("Set contains 3? " + set.contains(3));
    set.remove(3);
    System.out.println("Set contains 3? " + set.contains(3));
  }
}
```