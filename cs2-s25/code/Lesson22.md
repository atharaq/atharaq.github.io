# Lesson 22: Node / LinkedList

Node.java:

```java
public class Node {
  public final int data;
  public Node next;

  public Node(int d, Node n) {
    this.data = d;
    this.next = n;
  }
}
```

LinkedList.java:

```java
public class LinkedList {
  private Node head = null;

  public void addFirst(int item) {
    // TODO: implement this method.

  }

  public int size() {
    // TODO: implement this method.
    return -1;
  }

  public int getFirst() {
    // TODO: implement this method.
  }

  // TODO: after doing the above, make sure to go back and implement addLast and getLast

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);

    // This should output: First element of the list: 3
    System.out.println("First element of the list: " + list.getFirst());
    // After you have implemented "addLast" and "getLast", uncomment the next 3 lines
    // System.out.println("Last element of the list: " + list.getLast());
    // list.addLast(4);
    // System.out.println("Last element of the list: " + list.getLast());

  }
}
```