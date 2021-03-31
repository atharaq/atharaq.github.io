# CS2 Lesson 16: Polymorphism (Part II)
{:.no_toc}

1. Table of Contents
{:toc}


First: let's finish up the slides from Monday. Take a look at the following slides, and the accompanying videos:

# Inheritance

[Inheritance](https://atharaq.github.io/cs2/lesson15.html#/inheritance) (scroll "down" for the rest of the slides in this section)

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/_9Fwj22c4Ak" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Object class

[Object class](https://atharaq.github.io/cs2/lesson15.html#/object-class) (scroll "down" for the rest of the slides in this section)

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/eoicMIKWmqg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Implementing vs extending

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

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/Barbara_Liskov_MIT_computer_scientist_2010.jpg/428px-Barbara_Liskov_MIT_computer_scientist_2010.jpg" alt="Barbara Liskov" />

In other words: when designing subclasses, **make sure** that your subclass really can be used any time an object of the superclass is needed. If that's not always the case, then you probably don't want to **extend** the superclass!

## Composition

**Composition** is referred to as a "has-a" relationship. For example, suppose we are implementing a Pizza Delivery app. Maybe we have a class for a `Vehicle`, and a class for a `Deliverer`. A `Deliverer` is **not** a `Vehicle`, but a `Deliverer` does **have a** `Vehicle`. Usually this is implemented by making the `Vehicle` be an instance variable of the `Deliverer` class.

Think about this in terms of your second project. A `Library` is **not** a list. You should not use a `Library` whenever an `ArrayList` is needed. But a `Library` certainly might **use** a list. A Library probably does need to keep track of a list of books. And so it makes sense to have the library have an `ArrayList<Book>` as an instance variable.

# Case Study: Averager

Download the Averager class on Moodle. Answer the following questions first, before writing any code.

* What does the Averager class do?
* Is the Averager class designed in an "object-oriented" way?
* How many jobs is the `average` method responsible for?

## Single Responsibility Principle

Another software development design principle that we should know of:

> There should never be more than one reason for a class to change.
> &mdash; <cite>Robert Martin, aka "Uncle Bob"</cite>

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Robert_Cecil_Martin.png/472px-Robert_Cecil_Martin.png" alt="Robert Martin, aka 'Uncle Bob'" />

(Robert Martin is the author of *Agile Software Development: Principles, Patterns, and Practices* (2001))

## Exercise

Since the Averager class seems to do many things, let's break it up into smaller components.

* Make an Input class which has a method that returns a `List<Integer>`
* Make an Averager class (which requires a `List<Integer>` as a constructor parameter), and returns the average in a method
* Have a Main component which instantiates an Input object, an Averager object, and outputs the average.

After you have done this on your own, or if you get stuck, take a look at the video below where I go through the steps of breaking this up into components.

## More abstraction?

At this point, your code should be fairly clean. Your main method should be short, and each line of code should be pretty simple, so it seems like our code is nicely object-oriented. I'd like to try to probe a little deeper and see if there is anything that we can make even more abstract. At this point, I'd like to focus on Input.

Think about the following:

* In real-world systems, what are some of the ways in which "input" to a program is found?
* What is the purpose of the `Input` class? Specifically, what is it needed for?

Often, our components should depend upon abstractions, rather than concrete implementations. How do we think about the Input component more abstractly?

The Input component **provides a list of integers**. This is an abstract goal: we can think of it as an "Integer List Provider". There are other ways that one can provide a list of integers: hard-code it (for testing), read from a file, read from a database, etc.

So can we introduce some more abstraction and refactor our code to use that abstraction?

1. Create an IntegerListProvider interface.
2. Refactor the Input class to implement that interface.
3. Make an Output component which depends on an IntegerListProvider interface.
4. Change the main method to use these different components.
5. Try to test out the different components independently. Can you see how to test out the Averager, without needing any input? Can you see how to test out the Output component without needing any input?

# Composition vs Inheritance

> Unlike method invocation, inheritance violates encapsulation [Snyder86]. In other words, a subclass depends on the implementation details of its superclass for its proper function. The superclass's implementation may change from release to release, and if it does, the subclass may break, even though its code has not been touched. . .  Inheritance is appropriate only in circumstances where the subclass really is a subtype of the superclass. In other words, a class B should extend a class A only if an "is-a"relationship exists between the two classes. . . it is often the case that B should contain a private instance of A and expose a different API: A is not an essential part of B, merely a detail of its implementation.
> &mdash; <cite>Joshua Bloch, Effective Java (2018)</cite>

*Effective Java* is a really important book for all professional Java developers to refer to. It describes the ways in which we *should* use Java language features in a way that makes our code clean, easy to understand, and exploits the built-in features of the language and the standard library.

This particular item states that we should "Favor composition over inheritance". That is: often times, if we think that one class should extend from another, what we really want is for one class to use the other class's methods. This can be done by using composition (keeping a private instance variable) instead of inheritance.
