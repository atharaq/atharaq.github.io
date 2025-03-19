# CS2 Lesson 14: Polymorphism
{:.no_toc}

1. Table of Contents
{:toc}

# Interfaces

An **interface** is an **abstract type**. That is, it just describes behaviors, but it is not actually implemented. You cannot instantiate an interface. This is useful when we are defining methods:

```java
public void sort(List<Integer> list) {
    // don't care how the list is implemented
    // just that I have a list of integers
}

public static void main(String[] args) {
    List<Integer> list1 = new LinkedList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();
    sort(list1);
    sort(list2);
}
```

In the above code snippet: `ArrayList` and `LinkedList` are two different *implementations* of the *same* `List` interface. Both of them implement `add`, `get`, and `size`. But they do so in different ways:

* `ArrayList`: keeps an array, resizes that array when needed.
* `LinkedList`: keeps each item in a "node", node has a "link" to the next node.
    * `add`: create a new node, link from the last node.

We will cover Linked Lists later on this semester.

## Implementation Details

The differences between an `ArrayList` and `LinkedList` are *internal*. Externally: we can call `list.get(10);` or `list.add("hello");` on either one. Those differences are called "implementation details."

When we write a method, if we don't care *how* list is implemented, we can just ask for a `List` as a parameter.

## `Comparable`

The `Collections` class has a static method `sort`, which will sort a list for us. It can sort lists of any type -- as long as the type implements the `Comparable` interface. The `Comparable` interface specifies just one method: `compareTo`.

In order to implement the interface in your class:

```java
public class MyClass implements Comparable<MyClass> {

    // instance variables, constructors, and other methods

    public int compareTo(MyClass other) {
        // return a positive number if this > other
        // return 0 if this == other
       // return a negative number if this < other
    }
}
```

## Exercise

[Starter code](code/Location.html) Implement the "compareTo" method in the `Location` class. Implement it so that:

* A Location on a lower street (south) is "less" than a Location with a higher row
* If two Locations are on the same street, a Location on a lower avenue (to the east) is "less" than a Location with a higher avenue

Run the main method after you have implemented compareTo. It should output:

[10 St and 7 Ave, 15 St and 2 Ave, 15 St and 5 Ave, 25 St and 3 Ave]

**Exit Ticket 1**: How is the `Collections.sort` method able to sort a list of Locations, when it had no idea what a Location was in the first place? Location is a class that *we* wrote!

# Polymorphism

**Polymorphism**: The ability for an object to take multiple forms. For example: if we have a method that can calculate the area of a Rectangle, it should work on Squares too!

```java
Rectangle r = new Square(5);
System.out.println(findArea(r));
//... other code

public int findArea(Rectangle r) {
    // ...
}
```

Notice in the code above: we can *declare* a variable of type Rectangle, but *instantiate* it with a different type: Square! This is strange, but it's allowed if the `Square` class extends from the `Rectangle` class. We will see more of this below.

## Introducing Polymorphism

There are two primary ways of introducing polymorphism in Java:

* Implementing interfaces
* Extending classes (inheritance).

## Dynamic Binding

When an object is instantiated, it has a "compile-time" (declared) type and a "run-time type" (the type of the actual object that is instantiated).

```java
int width = 5; int height = 5;
Rectangle r = new Rectangle(width, height);
Square s = new Square(width);
Rectangle r2 = new Square(width);
```

What are the declared and run-time types of $r$, $s$, and $r2$?

## Exercise

```java
LinkedList<String> linkedList = new LinkedList<>();
ArrayList<String> arrayList = new ArrayList<>();
List<String> abstractList;
```

Which of the following assignments are legal?

1. `abstractList = linkedList;`
2. `abstractList = arrayList;`
3. `arrayList = abstractList;`
4. `arrayList = linkedList;`
5. `linkedList = arrayList;`
6. `linkedList = abstractList;`

Try these out in your own IDE. Some of these are allowed, and some are compiler errors.

## Think about

```java
List<String> list = new ArrayList<>();
list.add(5);
```

* What does the compile-time type tell you about the "add" method?
* What does the run-time type tell you about the "add" method?

<details>
<summary>Click for the answers.</summary>
<p>The compile-time type tells you that you're even allowed to call the method. In this case, the compile-time type being List&lt;Integer&gt; tells you that list.add(5) compiles.</p>
<p>The run-time type tells you which code is actually invoked. In this case, it says that the add method in the ArrayList class is the one that is actually going to be called.</p>
</details>

# Polymorphism

Above we discussed the differences between compile-time and run-time types and we implemented an interface. This is the concept of **dynamic binding**:

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

[Example code](code/Polymorphism.html)

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

## Exercise

1. In the `Rectangle` class, implement the `getArea` method, and then uncomment the `printAllAreas(rectangles);` line inside `Main`.
2. Run the `Main`. How does this correctly compute the areas even for the Square object?
3. Uncomment the `System.out.println` statement inside `main` (line 17). What error do you get? Why?
4. Comment that println statement again, and then uncomment the `printAllShapes(rectangles);` line inside `Main`. 
   * Run it once and take a look at the output. 
   * Then implement the `toString` method inside the `Square` class so that when a Square with side length $x$ is output, it should print out "Square with side length $x$". 
   * Run the `Main` again and see if the output changes. (It should!) Why does it change?

**Exit Ticket 2**: Explain why you got an error (in question 3) and why the output changed when we implemented the toString in Square. Try to use vocabulary that we learned in this lesson, including compile-time and run-time types.

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

# Exit Tickets

On BrightSpace, submit your answers to exit tickets 1 and 2 above.