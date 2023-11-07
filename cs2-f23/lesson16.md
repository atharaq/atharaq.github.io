# CS2 Lesson 16: Polymorphism (Part II)
{:.no_toc}

1. Table of Contents
{:toc}


# Polymorphism

Last time we discussed the differences between compile-time and run-time types and we implemented an interface. We saw the concept of **dynamic binding**:

* When a method is invoked, the "run-time" type's method is invoked, not the "compile-time" type.
* However: we can only invoke those methods which are declared on the "compile-time" type!

In other-words: 

* What methods can you see? *compile-time*.
* What code do you run? *run-time*.

# Inheritance

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/_9Fwj22c4Ak" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**Inheritance**: the ability to define a new class that has the same instance variables and methods of another class. A **subclass** is a class that **extends** another class. That is, it has everything that the "parent" class has, but possibly more. Tto make one class inherit from another, we use the `extends` keyword.

To do so, we use the **extends** keyword:

```java
public class Square extends Rectangle {
```

`Square extends Rectangle` means every `Square` is a `Rectangle`. It **does not** mean that every Rectangle is a Square!

Again, we need to make a note of the difference between compile-time and run-time types: an object can be *declared* as a Rectangle, but at runtime the actual object constructed could be a Square.

Every Square object can invoke methods written inside the Rectangle class -- but not vice versa! If the *compile-time* type of an object is Rectangle, then you can only invoke methods declared in the Rectangle class. Again, the actual method that is invoked is based upon the *run-time* class! That is: the code that is run might be in `Square`.

## Example

[On Replit](https://replit.com/team/cs2-fall-2023/Lesson-16-Polymorphism-exercises)

```java
public class Square extends Rectangle {
    private int sideLength;

    public Square(int side) {
        super(side, side);
        System.out.println("Constructing a square with side length " + side);
        sideLength = side;
    }
}
```

The constructor for `Square` **must** invoke the constructor for its **superclass** (Rectangle). It does this by calling `super`. Notice that when we run `Main`, the print statement inside Rectangle happens twice:

 	* Once for the Rectangle object we create
	* Once for the Square object!

## Exercise (Don't submit)

1. In the `Rectangle` class, implement the `getArea` method, and then uncomment the `printAllAreas(rectangles);` line inside `Main`.
2. Run the `Main`. How does this correctly compute the areas even for the Square object?
3. Uncomment the `System.out.println` statement inside `main` (line 17). What error do you get? Why?
4. Comment that println statement again, and then uncomment the `printAllShapes(rectangles);` line inside `Main`. 
   * Run it once and take a look at the output. 
   * Then implement the `toString` method inside the `Square` class. 
   * When a Square with side length $x$ is output, it should print out "Square with side length $x$". 
   * Run the `Main` again and see if the output changes. (It should!) Why does it change?

# `Object` class

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/eoicMIKWmqg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Every class inherits from the `Object` class. This provides default implementations of a few commonly used methods:

* toString: used when we call `System.out.println`
* equals: default implementation checks if two objects refer to the same location in memory
* getClass: returns the run-time class of an Object. (cannot be overridden)

Recall that the **toString** method is used in the `println`. Under the hood: `println` is defined on all Objects. That is, there is a version of the `println` method which takes in an `Object` as a parameter. Since any class you define eventually inherits from `Object`, that means you can pass in any object of any class to the `println` method. `println` then calls a method (which calls another, which, eventually) which calls the toString method on the Object. If we **override** the toString method and write our own version, it will use ours! That's how we are able to get the println method to work properly!

## Class Hierarchies

Every class, except Object, has exactly one direct **superclass**. In our example:

	* The superclass of Square is Rectangle.
	* The superclass of Rectangle is Object.

Notice that in Rectangle's constructor, we don't have to explicitly invoke `super`. This is because the `Object` class has a default (no-argument) constructor, which is automatically invoked (unless otherwise specified).

# Implementing vs extending

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/TzJvn7EdR8M" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Now that we know about interfaces and inheritance, let's recap some of the differences between them.

Interfaces:

* A class can implement multiple interfaces.
* (Prior to Java 8) interfaces do not provide implementations, just declarations.
* Interfaces do not provide any instance variables.
* Interfaces describe a **contract**: they guarantee that implementing classes will have certain methods.

Inheritance:

* A class can extend exactly one other class.
* Classes "inherit" all members (variables, methods) from their parent class -- but can only see the **public** or **protected** members!
* Inheritance is used when one type is a more specialized version of a another type.

**Inheritance** is also known as an "is-a" relationship. That is, if `Employee` and `Person` are two different classes, and `Employee` inherits from `Person`, we say that every `Employee` **is a** `Person`. (Similar to how we said every `Square` **is a** `Rectangle`.)

## Liskov's Substitution Principle

In general, when should we use inheritance? There is a principle in software development introduced by [Barbara Liskov](https://en.wikipedia.org/wiki/Barbara_Liskov), a computer scientist at MIT, known as **Liskov's Substitution Principle**:

If $S$ is a subtype of $T$, then any object of type $T$ in a program can be replaced with an object of type $S$ without breaking the program.

<img class="noreverse" src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Barbara_Liskov_MIT_computer_scientist_2010.jpg/428px-Barbara_Liskov_MIT_computer_scientist_2010.jpg" alt="Barbara Liskov" />

In other words: when designing subclasses, **make sure** that your subclass really can be used any time an object of the superclass is needed. If that's not always the case, then you probably don't want to **extend** the superclass!

## Composition

**Composition** is referred to as a "has-a" relationship. For example, suppose we are implementing a Pizza Delivery app. Maybe we have a class for a `Vehicle`, and a class for a `Deliverer`. A `Deliverer` is **not** a `Vehicle`, but a `Deliverer` does **have a** `Vehicle`. Usually this is implemented by making the `Vehicle` be an instance variable of the `Deliverer` class.

Think about this in terms of your second project. A `Library` is **not** a list. You should not use a `Library` whenever an `ArrayList` is needed. But a `Library` certainly might **use** a list. A Library probably does need to keep track of a list of books. And so it makes sense to have the library have an `ArrayList<Book>` as an instance variable.

# Case Study: Averager

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/d4TjtggzZqM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Take a look at the Averager class on [replit](https://replit.com/team/cs2-fall-2023/Lesson-16-Averager-case-study). Answer the following questions first, before writing any code.

* What does the Averager class do?
* Is the Averager class designed in an "object-oriented" way?
* How many jobs is the `average` method responsible for?

## Single Responsibility Principle

Another software development design principle that we should know of:

> There should never be more than one reason for a class to change.
> &mdash; <cite>Robert Martin, aka "Uncle Bob"</cite>

<img class="noreverse" src="https://upload.wikimedia.org/wikipedia/commons/2/27/Robert_C._Martin_surrounded_by_computers.jpg" alt="Robert Martin, aka 'Uncle Bob'" />

(Robert Martin is the author of *Agile Software Development: Principles, Patterns, and Practices* (2001))

## Exercise (don't submit)

Since the Averager class seems to do many things, let's break it up into smaller components.

* Make an Input class which has a method that returns a `List<Integer>`
* Make an Averager class (which requires a `List<Integer>` as a constructor parameter), and returns the average in a method
* Have a Main component which instantiates an Input object, an Averager object, and outputs the average.

After you have done this on your own, or if you get stuck, take a look at the video below where I go through the steps of breaking this up into components.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/JgxaG_fh0BM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## More abstraction?

At this point, your code should be fairly clean. Your main method should be short, and each line of code should be pretty simple, so it seems like our code is nicely object-oriented. I'd like to try to probe a little deeper and see if there is anything that we can make even more abstract.

Think about the following:

* In real-world systems, what are some of the ways in which "input" to a program is found?
* What is the purpose of the `Input` class? Specifically, what is it needed for?

Often, our components should depend upon abstractions, rather than concrete implementations. How do we think about the Input component more abstractly? Let's discus this next time.

# Composition vs Inheritance

> Unlike method invocation, inheritance violates encapsulation [Snyder86]. In other words, a subclass depends on the implementation details of its superclass for its proper function. The superclass's implementation may change from release to release, and if it does, the subclass may break, even though its code has not been touched. . .  Inheritance is appropriate only in circumstances where the subclass really is a subtype of the superclass. In other words, a class B should extend a class A only if an "is-a"relationship exists between the two classes. . . it is often the case that B should contain a private instance of A and expose a different API: A is not an essential part of B, merely a detail of its implementation.
> &mdash; <cite>Joshua Bloch, Effective Java (2018)</cite>

*Effective Java* is a really important book for all professional Java developers to refer to. It describes the ways in which we *should* use Java language features in a way that makes our code clean, easy to understand, and exploits the built-in features of the language and the standard library.

This particular item states that we should "Favor composition over inheritance". That is: often times, if we think that one class should extend from another, what we really want is for one class to use the other class's methods. This can be done by using composition (keeping a private instance variable) instead of inheritance.
