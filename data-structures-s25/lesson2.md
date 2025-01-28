# Data Structures Lesson 2: Lists / Iterators
{:.no_toc}

1. Table of Contents
{:toc}

# Recording

<iframe width="560" height="315" src="https://www.youtube.com/embed/qVgvMUIvqs4?si=k4vIdNLX1MOUaKyY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

This is a recording from when I taught this course in Spring 2021. Here are some links to timestamps:

* [Lists, up to the SimpleList exercise, and running times (0:00 - 24:07)](https://youtu.be/qVgvMUIvqs4?feature=shared)
* [Iterators, inner classes (24:08 - 37:33)](https://youtu.be/qVgvMUIvqs4?feature=shared&t=1447)
* [Brief mention of LinkedLists / Homework (37:34 - end)](https://youtu.be/qVgvMUIvqs4?feature=shared&t=2254)

# Lists

* **List**: ordered sequence of data: $x_0, x_1, \ldots, x_{n-1}$
* Size of list: $n$
* First element: $x_0$, last element: $x_{n-1}$
* $x_{i+1}$ is the *successor* of $x_i$, $x_i$ is the *predecessor* of $x_{i+1}$
* Index / position of $x_i$ is $i$

## List Operations?

What operations should a list have?

* add to the list (at the end)
* get the element at position $i$
* remove a value from the list
* insert an element at position $i$
* return the size of the list

## Simple List

Skeleton code of simple array-backed list structure in [this GitHub Classroom assignment](https://classroom.github.com/a/6r8JNV4a). Finish implementing it, and then determine the running times of the following operations (based on your implementation):

* add
* get
* remove
* insert


# Iterators

Recall: for-each loops: 

```java
List<String> myList;
for (String word : myList) {
  // ...
}
```

It turns out that this is really:

```java
List<String> myList;
Iterator<String> iter = myList.iterator();
while (iter.hasNext()) {
  String word = iter.next();
  // ...
}
```

The `iterator()` method is defined in the `Iterable<T>` interface. It must return something of ypte `Iterator<T>`, which is itself an interface.

## Iterator interface

`Iterator<T>` interface has:

* `T next()` returns the next value in the list
* `boolean hasNext()` returns true if we can call "next"
* `remove()` removes the last element returned by this iterator

What happens if the list is modified while iterating through it?

```java
List<String> l = new ArrayList<>();
l.add("a");
for (String w : l) {
  l.add("hi");
}
```

## Problem

```java
public class SLIterator<T> implements Iterator<T> {
   private SimpleList<T> list;
   private int pos = 0;
   public SLIterator(SimpleList<t> l) {
     list = l;
   }

  public boolean hasNext() {
    return pos < list.size();
  }
  public T next() {
    return list.array[pos++];
  }
}
```

What's the problem? What happens when you try to do this?

## Inner Classes

* Iterator needs to access **private** variables of main class
* Solution: make Iterator an **inner class**
  * Technically many kinds of inner classes
  * Usually static inner classes
  * But this time: non-static (only time in my life)
  * Effective Java item 24: Favor static member classes over non-static
  * Inner classes can access private members (because they're inside the scope)


## Exercise

Quick exercise: make SimpleList implement `Iterable<T>`

Update your main method to add in the following code:

```java
for (String word : list) {
    System.out.println(word);
}
```
Does it work?

# LinkedList

![Singly Linked List diagram, Wikimedia Commons](https://upload.wikimedia.org/wikipedia/commons/6/6d/Singly-linked-list.svg "Singly Linked List diagram, Wikimedia Commons")

* Another implementation of List ADT
* Node class has a data field and a pointer to the next node
* **Doubly linked list**: each Node has a pointer to the previous node as well

## LinkedList code

Code was in the same GH Classroom assignment. Running times:

  * add
  * insert
  * remove
  * get

# Homework

Due **Monday, 2/10**. Submit via **BrightSpace** (single PDF).

**Problem 1**: Implement an Iterator for this LinkedList structure.

**Problem 2**

The following method removes the first half of the list passed as a parameter:

```java
public static void removeFirstHalf(List<?> lst) {
  int theSize = list.size() / 2;
  for (int i = 0; i < theSize; i++) {
    lst.remove(0);
  }
}
```

* Why is theSize saved prior to entering the for loop?
* What is the running time of removeFirstHalf is lst is an ArrayList?
* What is the running time of removeFirstHalf if lst is a LinkedList?
* Does using an iterator make removeFirstHalf faster for either type of list?
