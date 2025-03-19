# Polymorphism Examples

All of this should go in the same folder:

Rectangle.java:

```java
public class Rectangle {
  private int width;
  private int height;

  public Rectangle(int w, int h) {
    System.out.println("Constructing a rectangle with width " + w + " and height " + h);
    width = w;
    height = h;
  }

  public int getArea() {
    // fix this!
    return 0;
  }

  public String toString() {
    return "Rectangle with width " + width + " and height " + height;
  }
}
```

Square.java:

```java
public class Square extends Rectangle {
  private int sideLength;

  public Square(int side) {
    super(side, side); // call the constructor for Rectangle
    System.out.println("Constructing a square with side length " + side);
    sideLength = side;

  }

  public int getSideLength() {
    return sideLength;
  }

  public String toString() {
    // change this to say "Square with side length x"
    return super.toString();
  }
}
```

Main.java:

```java
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Rectangle r = new Rectangle(5, 5);
    Square s = new Square(2);

    List<Rectangle> rectangles = new ArrayList<>();
    rectangles.add(r);
    rectangles.add(s);
    // printAllAreas(rectangles);
    printAllShapes(rectangles);

    r = s;
    // System.out.println("Square has side length " + r.getSideLength());
    System.out.println("Square has side length " + s.getSideLength());
  }

  private static void printAllAreas(List<Rectangle> rectangles) {
    for (Rectangle rectangle : rectangles) {
      System.out.println("Area of " + rectangle + ": " + rectangle.getArea());
    }
  }

  private static void printAllShapes(List<Rectangle> rectangles) {
    for (Rectangle rectangle : rectangles) {
      System.out.println(rectangle);
    }
  }
}
```