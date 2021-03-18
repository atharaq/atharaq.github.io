# CS2 Lesson 12: Mutable and Immutable classes
{:.no_toc}

1. Table of Contents
{:toc}

# GaussianInteger

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/23eMuY1LQ8w" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Continue working on the GaussianInteger class from last time. Try to implement the `multiply` method. This should be usable as follows:

```java
GaussianInteger g1 = new GaussianInteger(0, 1);
GaussianInteger g2 = new GaussianInteger(1, 2);
g1.multiply(g2):
System.out.println(g2);
```

The above should output -2 + 1i, since (0 + 1i)(1 + 2i) = -2 + 1i.

Note: you can still access the [CodingRooms "live classroom" from Monday](https://app.codingrooms.com/c-join/c/2MXawEuHvpJG) if you wish to continue your code on there. This code can be tricky. Try to do this yourself first, and then follow along the video above if you need the assistance.

# Immutability

The GaussianInteger class we designed above is **mutable**. That means that GaussianInteger objects can be changed after they are created. This might sounds like a good thing, but it can cause unpredictable behavior:

```java
GaussianInteger g = new GaussianInteger(2, 3); // 2 + 3i
SomeLibrary.method(g);
System.out.pritnln(g);
```

What is output above? We hope that "2 + 3i" will be output, but we can't be sure: we would need to look closely at what that SomeLibrary method does. But, for example:

```java
String name = "athar";
SomeLibrary.method(name);
System.out.println(name);
```

I can be absolutely sure that, in the above code, "athar" will be output. That's because Strings are **immutable**, so no matter what SomeLibrary does, it cannot possibly change the value of the String `name`.

How could we re-design the `GaussianInteger` class to be immutable? First, make all the instance variables **final**:

```java
private final int real;
private final int imaginary;
```

Then you will see some compiler errors: those point out where the class actually changes the value of one of those variables.

How do we implement `add` and `multiply` in an immutable way? We can't change this object, so instead return a new GaussianInteger object:

```java
public GaussianInteger add(GaussianInteger other)
```

Then in your main method, you would call the add and multiply methods as follows:

```java
GaussianInteger g1 = new GaussianInteger(1, 2);
GaussianInteger g2 = new GaussianInteger(2, -1);
GaussianInteger sum = g1.add(g2);
System.out.println(g1);
System.out.println(g2);
System.out.println(sum);
```

Try making these changes on your own, and then follow along the video below as I talk through modifying the GaussianInteger class to be immutable.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/aSBka7fap_w" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## Mutability vs Immutability

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/XhEKSv9oQlc" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

In the video above, I talk through some of the reasons why one might prefer to make objects mutable or immutable. For example, the benefits of mutable objects include:

* Flexibility. Immutable objects are rigid: you can't have any `void` methods which modify the object, so there are very specific coding patterns you have to follow.
* Ease of design. It's often easier to write the code for mutable objects.

The benefits of immutable objects include:

* Safety. One can share immutable objects (like the String above) without worrying that its contents are going to change. (Even better: if the object is shared across multiple parallel *threads* of execution, we don't have to worry about changes in other threads).
* Easier to reason about. Once an immutable object is created, one does not need to keep "updating" it when we try to read code / make memory diagrams.
* There are several other benefits that require material we will not cover, but for the sake of providing some other reasons here, I'll include a few: better error handling, easier to parallelize (use in multiple threads simultaneously), and works better with `Set` and `Map` types.

To be fully honest, though, the benefits of immutable objects almost always outweigh the drawbacks. Thread-safety, which we won't cover, is extremely important as you write code that might need to be parallelized (so it can run on multiple CPUs / cores at once). Some objects *must* be mutable: an ArrayList, for example, is by definition mutable. But often if we are given a choice, we should try to design our code to be immutable if possible.

# Debugging

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/pua88-TEBlg" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

In the above video, I walk through the steps of using the debugger in IntelliJ. The debugger is a very powerful tool that can help you figure out what's going wrong with your code when it's not working.

[This tutorial from JetBrains](https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html) gives a nice walkthrough of using the debugger as well. I strongly encourage you to take advantage of this tool, particularly if you get stuck on some things while working on your projects.

# SequentialDie Exercise

On **CodingRooms**: implement a `SequentialDie` class. A `Sequential Die` is like a normal die (you can "roll" it and it will return a number from 1 to 6), except without randomness. That is: if I create a new `SequentialDie` object, and call `roll()` on it, I should first get the number 1. If I call `roll()` again, I should then get the number 2. Calling it again and again will continue to increase the value I get back, until I get to 6, at which point it cycles back to 1.

To make this more precise:

* determine all the instance variables you would like to keep track of:

  ```java
  public class SequentialDie {
     // put all your instance variables here:
  ```

* implement a constructor (without parameters) for SequentialDie

  ```java
  public SequentialDie() {

  }
  ```

* implement the roll method:

  ```java
  public int roll() {

  }
  ```

This class should work fine with the following main method:

```java
public static void main(String[] args) {
   SequentialDie die = new SequentialDie();
   for (int i = 0; i < 8; i++) {
      System.out.println(die.roll());
   }
}
```

This should output:

1  
2  
3  
4  
5  
6  
1  
2  
