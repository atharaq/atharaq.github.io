# CS2 Lesson 12: Mutable and Immutable classes
{:.no_toc}

1. Table of Contents
{:toc}

# GaussianInteger

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/23eMuY1LQ8w" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

Continue working on the GaussianInteger class from last time. Try to implement the `multiply` method. This should be usable as follows:

```java
GaussianInteger g1 = new GaussianInteger(0, 1);
GaussianInteger g2 = new GaussianInteger(1, 2);
g1.multiply(g2):
System.out.println(g2);
```

The above should output -2 + 1i, since (0 + 1i)(1 + 2i) = -2 + 1i.

Use this [starter code for the exercises we did in class on Thursday](code/lesson11.html). The code for multiply can be tricky. Try to do this yourself first, and then follow along the video above if you need the assistance.

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
GaussianInteger one = new GaussianInteger(1, 0);
GaussianInteger i = new GaussianInteger(0, 1);

System.out.println(one); // should be 1 + 0i
System.out.println(i); // should be 0 + 1i
System.out.println(one.add(i)); // should be 1 + 1i
System.out.println(one); // should still be 1 + 0i
System.out.println(i.multiply(i)); // should be -1 + 0i
System.out.println(i); // should be 0 + 1i
```

Try making these changes on your own, and then follow along the video below as I talk through modifying the GaussianInteger class to be immutable.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/aSBka7fap_w" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

## Mutability vs Immutability

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/XhEKSv9oQlc" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

In the video above, I talk through some of the reasons why one might prefer to make objects mutable or immutable. For example, the benefits of mutable objects include:

* Flexibility. Immutable objects are rigid: you can't have any `void` methods which modify the object, so there are very specific coding patterns you have to follow.
* Ease of design. It's often easier to write the code for mutable objects.

The benefits of immutable objects include:

* Safety. One can share immutable objects (like the String above) without worrying that its contents are going to change. (Even better: if the object is shared across multiple parallel *threads* of execution, we don't have to worry about changes in other threads).
* Easier to reason about. Once an immutable object is created, one does not need to keep "updating" it when we try to read code / make memory diagrams. (Note: this is probably why the `multiply` method I wrote in class last week was wrong, while it's not so hard to write it in the immutable version).
* There are several other benefits that require material we will not cover, but for the sake of providing some other reasons here, I'll include a few: better error handling, easier to parallelize (use in multiple threads simultaneously), and works better with `Set` and `Map` types.

To be fully honest, though, the benefits of immutable objects almost always outweigh the drawbacks. Thread-safety, which we won't cover, is extremely important as you write code that might need to be parallelized (so it can run on multiple CPUs / cores at once). Some objects *must* be mutable: an ArrayList, for example, is by definition mutable. But often if we are given a choice, we should try to design our code to be immutable if possible.

# Debugging

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/pua88-TEBlg" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

In the above video, I walk through the steps of using the debugger in IntelliJ. The debugger is a very powerful tool that can help you figure out what's going wrong with your code when it's not working.

[This tutorial from JetBrains](https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html) gives a nice walkthrough of using the debugger as well. I strongly encourage you to take advantage of this tool, particularly if you get stuck on some things while working on your projects. On VSCode, we have a similar tool, but it looks a little different. [Check here for information about using the VSCode debugger.](https://code.visualstudio.com/docs/java/java-debugging)

# Errors

There are a lot of things that can go wrong when we are coding. These can include:

* **Compiler errors**: syntax errors, type mismatches, etc. These are caught by the compiler.
* **Run-time errors**: usually Exceptions, but also things like `OutOfMemoryError`.
* "Bugs" or **logic errors**: when the program doesn't do what you wanted it to do. Focus today: these types.

The examples we'll look at are taken from Bloch and Gafter, *Java Puzzlers: Traps, Pitfalls and Corner Cases* (2005). [Exercises for today are here.](code/LogicErrors.html)

# Example: Increment

```java
int j = 0;
for (int i = 0; i < 100; i++) {
  j = j++;
}
System.out.println(j);

```

* Before running, what do you think will happen?
* Run the program. What happens?

**Exercise**:

* Figure out what happened.
* Put print statements in the for loop to see what the value of $j$ is

## Debugger

Since I already introduce the debugger tool, we might as well use it here to help us figure out what's going on.

* Click on the "side" of line 6 to add a **breakpoint**.
* Use the debugger.
* The program will run until it hits the breakpoint, and then stop and let us continue execution one line at a time.
* The debugger shows us a **memory diagram**, the values of all the variables at a particular moment. What happens to $j$ as $i$ increases?

## InTheLoop

Look at the InTheLoop program:

```java
public static final int END = Integer.MAX_VALUE;
public static final int START = END - 5;

public static void main(String[] args) {
    int count = 0;
    for (int i = START; i <= END; i++)
        count++;
    System.out.println(count);
}
```

* Before running, what do you think will happen?
* Run the program. What happens?
* Use the debugger to figure out what happened.

## Exit Ticket

On BrightSpace, before class on Thursday, explain what you think is going on in these two examples. What did you expect to happen, what actually happened, and do you have a guess at what the underlying issue is?

We will go over these on Thursday.