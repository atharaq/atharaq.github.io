# Data Structures Lesson 1: Short Intro to Java Generics
{:.no_toc}

1. Table of Contents
{:toc}

# Selection Exercise

At this point, I hope you have already signed up for CodingRooms. If you haven't yet, please make sure to do so now!

Take a look at the "Selection Exercise" code on CodingRooms. This code provides a data structure which attempts to solve the **selection problem**. The selection problem can be stated as follows: given a set of (orderable) data, find the i-th smallest element of the set. That is, if $i = 0$, it should find the smallest element of the set, if $i = 1$, the second smallest, etc.

We solve this problem by creating a *data structure* which can handle the operations of adding and selecting. The **SelectionList** class is our data structure: we can **add** to it, **select** from it, and call **printList** to view the entire list. Take a look at the code and see if you can make sense of it. This code may look familiar to those of you who took CS2 with me recently, but if you haven't seen anything like this before, I hope it's not too much of a challenge to understand. Feel free to reach out to me (Discord, email, or in office hours on Friday) if you need help understanding it!

**Exercise**: Suppose we have an instance of the SelectionList class with $n$ elements in it already. What is the running time of each of the methods? That is: how many steps does the code take to run **add**, **select** and **printList**?

Note: do **not** submit this exercise. We can discuss the running times of these operations on Monday if you have questions. But we will be using this exercise later on in this lesson, so please save it for that!

# Generic Types

Later on in this lesson, we will look at how to generalize the selection problem. What if we wanted a list of Strings, or a list of doubles, or a list of timestamps? The code for any of these would roughly be the same, so we hope that there is a way to not have to re-write the code over and over again. There is: **generics**!

For example, the below code is a "generic" list type:

```java
public class MyList<T> {
  // instance vars go here...

  public void add(T newElement) {
    // add newElement to the list
  }

  public T get(int index) {
    // get the element at that position in the list.
  }
}
```

T here is referred to as the **type parameter** or the **generic**. **MyList** is called a "parameterized type" or a "generic type". We can use this class by providing the type when we declare a MyList variable. Example:

```java
MyList<Integer> intList = new MyList<>();
MyList<String> stringList = new MyList<>();
```

Now when we add to the intList or the stringList, the compiler can ensure type safety:

```java
// This does not compile
intList.add("this is not a number");
```

Notice that we use the **Integer** class to create a list of integers, instead of the **int** type. This is because, in Java, the type parameter needs to be instantiated by an actual class. So we use the "wrapper classes" like Integer, Double, etc to "wrap" the primitive type into an object. When we add to this list, however, we don't need to worry about this:

```java
// this compiles
intList.add(3);
// this also works, but is unnecessary
intList.add(new Integer(3));
```

The "3" is **autoboxed** into an "Integer" object. Similarly, when we "get" from the MyList class, we don't need to worry about converting it from an Integer to an int:

```java
// gets the element at position 2 from the list
int num = intList.get(2);
```

## CodingRooms Exercise

There is a simple exercise on CodingRooms to try out:

**Exercise**: Implement a simple generic class which supports two operations: read and write. A skeleton is included in the CodingRooms exercise. Fill in the code for it, and make sure to throw an IllegalStateException if the user of the class calls read() when nothing has been written yet.

Play around with this code in the main method provided. What happens if you do the following?

```java
ReadWriteCell<String> r = new ReadWriteCell<>();
r.write(32);
```

# Static Methods

On your own (whether in a CodingRooms workspace or in IntelliJ on your own computer), try to solve the following problem:

**Exercise**: write a static method which searches a generic array for a value. It should return true if the value is in the array, false otherwise. Where do you declare the type parameter?

Give up?

<details>
  <summary>
    Spoilers
  </summary>

<div class="language-java highlighter-rouge"><div class="highlight"><pre class="highlight"><code><span class="kd">public</span> <span class="kd">static</span> <span class="o">&lt;</span><span class="no">T</span><span class="o">&gt;</span> <span class="kt">boolean</span> <span class="nf">contains</span><span class="o">(</span><span class="no">T</span><span class="o">[]</span> <span class="n">array</span><span class="o">,</span> <span class="no">T</span> <span class="n">value</span><span class="o">)</span>
</code></pre></div>    </div>
</details>

The T needs to be declared somewhere. The Java specification demands that the type parameters be declared *before* the return type of the method. This is referred to as a **generic method**.

# Wildcards

Generics are not **covariant**. For example, suppose **Apple** is a class which extends from **Fruit**. We might hope that **Collection\<Apple>** can be used whenever **Collection\<Fruit>** is asked for, but unfortunately this is not how generics are implemented in Java.

```java
// cannot call printFruit() and pass a Collection<Apple>!
public void printFruit(Collection<Fruit> c) {
  for (Fruit f : c) {
    System.out.println(f);
  }
}
```

Instead, we can use **wildcards**:

```java
public void printFruit(Collection<? extends Fruit> c) {
  for (Fruit f : c) {
    System.out.println(f);
  }
}
```

"?" here is a wildcard. In this case, it can represent **any** type that extends from Fruit. Here **extends** refers to both classes extending from other classes, and classes implementing interfaces.

## Selection Exercise Update

**Exercise**: Go back to CodingRooms and update the SelectionList to work for a generic type.

How do we compare generic objects, without knowing that they are integers? Use the [Comparable](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/Comparable.html) type! Recall: that if a class implements Comparable, then it must implement the **compareTo** method, with the contract that:

* x.compareTo(y) < 0 means, roughly, that "x < y"
* x.compareTo(y) == 0 means, roughly, that "x == y"
* x.compareTo(y) > 0 means, roughly, that "x > y"

As a first attempt, try changing the declaration of SelectionList to:

```java
public class SelectionList<T extends Comparable<T>> {
  ...
}
```

Once you have made the appropriate change, uncomment lines 17-21 from the main method and make sure it works.

```java
SelectionList<Shape> shapeList = new SelectionList<>();
shapeList.add(new Rectangle(2, 3));
shapeList.add(new Triangle(1, 4));
shapeList.add(new Rectangle(1, 1));
shapeList.printList();
```

Here we create a list of "Shape" objects. Shape is an interface defined later in the code, while Rectangle and Triangle are classes which implement that interface. Shapes can be compared with each other using their areas.

However, it turns out that this is not the appropriate fix. To see this, look at lines 23-26:

```java
SelectionList<Rectangle> rectList = new SelectionList<>();
rectList.add(new Rectangle(2, 3));
rectList.add(new Rectangle(1, 1));
rectList.printList();
```

If you uncomment these lines, the program will no longer compile. Why is that? **Rectangle** implements **Comparable\<Shape>**. But the type parameter in SelectionList is expecting a class, T, which implements (or extends) **Comparable\<T>**. That is: Shape extends Comparable\<Shape>, so this is fine, but Rectangle does not extend Comparable\<Rectangle>. So we need to allow for things to be compared to types which are possibly "superclasses":

```java

public class SelectionList<T extends Comparable<? super T>> {
  ...
}
```

This uses both wildcards and bounds to help specify, *exactly*, what we are allowed to provide the SelectionList class.

Once you have finished making the changes to SelectionList, you can submit and see if it passes the tests. If it doesn't, you probably need to fix the syntax of your SelectionList declaration, or when you change the comparison to use the compareTo method.

# Type Erasure

Try this out:

```java
String[] list = new String[5];
Object[] o = list;
o[0] = new Integer(30);
```

Does this compile? Does this run?

<details>
<summary>Spoiler</summary>
<p>It does compile, but it throws a ClassCastException when you run it.</p>
</details>

Generics were introduced as a way to fix this problem: now run-time errors become compile-time errors. That is: the Java language designers wanted to limit the ability for errors to be missed by the compiler, but then crash your program. Instead, just don't let the program even compile.

In Java, though, the fix was a bit of a half-measure. When you compile a class like **MyList\<T>**, it creates just a single **raw type**, rather than one for each possible type parameter T. That is: it just becomes **MyList** (the compiler replaces the parameter T by its “bound”, Object in this case). This process is referred to as **type erasure**.

After the class is compiled to bytecode, the "JVM"-version of the class is the raw type (with no generics). This means:

* Primitive types cannot be used as type parameters, since **int** does not inherit from **Object**, for example.
* Casts can cause problems:
```java
ReadWriteCell<String> rws = new ReadWriteCell<>();
rws.write("Hello");
ReadWriteCell<Integer> rwi = (ReadWriteCell<Integer>) rws; // this works!
int x = rwi.read(); // this is bad
```
* You cannot instantiate a generic type! That is, you cannot do something like
```java
T x = new T();
```
* You cannot create an array of generic objects
* You cannot create an array of parameterized types. Otherwise:
```java
ReadWriteCell<String>[] arr1 = new ReadWriteCell<>[5];
ReadWriteCell<Double> c = new ReadWriteCell<>();
c.write(0.01);
Object[] badGuy = arr1;
badGuy[0] = c;
String s = arr1[0].read();
```

As we can see, type erasure causes several problems in Java. Unfortunately this is the reality of Java generics. Other languages (C++ and C#) have different paradigms, and there are reasons for this (I can discuss a little bit on Monday if students are interested), but overall we just need to be careful about how we use generics.

As an aside: generics are a bit of a prerequisite for the kinds of activities we want to do in Data Structures. For the most part, we don't necessarily need to worry about some of these nuanced issues, but it is worth knowing about as you progress in your Java careers. These kinds of strange issues tend to prop up at unsuspecting times.

# Resources

This has been an extremely quick crash course on Java generics. There are several good resources, at different levels of detail:

* [Java Generics Tutorial](https://devqa.io/java-generics-tutorial/)
* [Basics of Java Generics](https://www.baeldung.com/java-generics)
* [Generics Tutorial from Oracle](https://docs.oracle.com/javase/tutorial/extra/generics/index.html): This one is a bit more in-depth, and covers some of the nuanced issues we have seen here.

# Preview: Abstract Data Types

We will start the main content of our course next week, when we talk about **abstract data types**. An abstract data type is, as the name suggests, an abstraction of a data type. That is, we just describe the operations that the data type supports. In Java, we often use interfaces to describe these operations.

The first examples we will see are Lists, Stacks, and Queues.

```java
public interface List<T> {
   void insert(T object, int position);
   void remove(int position);
   void printList();
   T get(int i);
   // maybe others
}
```

Here we are describing an abstract data type which supports the operations of inserting into the structure, removing an object at a particular position in the structure, and getting the object at some position.

Whenever we describe an abstract data type, we will be interested in the best running times we can obtain for each of the supported operations. We might find that we have tradeoffs to make: if we don't care about insertions or removals, maybe "get"s can be made very efficient. We will discuss some of these implementation issues next time.
