# Data Structures Lesson 3: LinkedLists
{:.no_toc}

1. Table of Contents
{:toc}

# OPTIONAL: Java Crash Course Videos

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/3cptnJBqYx8" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

This video is optional, but maybe those of you who are having trouble getting reacquainted with Java should watch it.

I cover a lot of things in this video, hoping that by going through an example of a simple class or two, I can illustrate some of the subtle issues that can creep up from time to time. Things that I covered here include:

* Classes: representing "state" (or "data") and "behavior".
* Object oriented programming: modeling your code around the "things" in your program, rather than the "actions" your program needs to do.
* Interfaces, classes, run-time types vs compile-time types

I don't cover inheritance, which may be an important notion, but I do not expect that we will be using it in this class.

# LinkedLists

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/cwQ3A2mS6PY" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

A LinkedList is another implementation of the List abstract data type. In this implementation, instead of storing all of the data in contiguous memory cells (as in arrays), we store each data element in its own "Node", which also keeps track of where the "next" element in the list is.

From the code, you can see that there are not too many steps to add a new element to the end of a list, or to the beginning of the list. Please take a look at the code, and try to analyze the running times for each of the operations (add, addFirst, get, removeElementAtPosition, insert).

Now that said, some of these "efficient" operations are somewhat theoretical. Here is some [light reading](https://dzone.com/articles/performance-of-array-vs-linked-list-on-modern-comp) on that fact.

# Stacks and Queues

Next we will examine two important ADTs: stacks and queues.

Stack:

<img class="noreverse" alt="Stack of plates" src="stack.jpg" title="Stack of plates" />

Queue:

<img class="noreverse" alt="Queue of people" src="queue.jpg" title="Queue of people" />

Both of these ADTs specify two operations: insertion and removal. Most implementations also specify a "peek" in addition to a "remove", as well as a "size" and/or "isEmpty" operation.

The operations on a **stack** are called **push** and **pop**. **push** adds an item "on top" of the stack, and **pop** removes the top item of the stack. Stacks use the **LIFO**, or "Last In, First Out," paradigm: the last object added to the stack is the first one to be taken out.

The operations on a **queue** are called **enqueue**. **enqueue** adds an element to the "end" of the queue, while **dequeue** removes an element from the beginning of the queue. That is, queues use the **FIFO** paradigm: the first object added to the queue will be the first one removed.

Some questions to think about:

* How might you implement each of these ADTs with an array / ArrayList?
* How might you implement each of these ADTs with a LinkedList?

See if you can come up with implementations in which all the operations listed above are $O(1)$.

## Deques

There is a related ADT called a **deque**, or a **doubly-ended queue**. This would support all of the operations: push / pop and enqueue / dequeue. In Java, [Deque](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Deque.html) is an interface (as is Queue), with implementations ArrayDeque and LinkedList. The actual methods are listed on the API linked earlier.

# Challenge Questions

Some problems to think about. Try to find the best algorithms to solve these problems. I don't expect you to do all of these, or even to implement any of them, but do your best to come up with an algorithm that would solve it (at least on paper). Then we can discuss some of our solutions on Monday.

## Reverse a Singly Linked List

Given a singly LinkedList, how might you implement a **reverse** method? Moreover, how might you do this **in-place**: that is, without using a secondary list or additional storage?

## Middle element of a Linked List

Given a singly LinkedList, how might you find the middle element **in one loop**? (ie in N steps, not in 2N steps).

## Collate Iterators

Suppose we have an array of Iterators. Implement an Iterator which "collates" these. That is, suppose we have iterators for the following lists:

* [0, 1, 2]
* [3, 4 ]
* [5, 6, 7, 8, 9]

Then the result of

```java
Iterator<Integer> iter = new CollatedIterator(iterArray);
while (iter.hasNext()) {
  int i = iter.next();
  System.out.println(i);
}
```

would be 0, 3, 5, 1, 4, 6, 2, 7, 8, 9 (on separate lines, without commas).

## Bracket Matching

The following strings of brackets are perfectly matched:

* {}([])
* [(()())]

The following are not:

* {(})
* (][)

Devise an algorithm which, given a string of brackets, determines if the brackets are perfectly matched.

## Base Counting

Devise an algorithm which, given an input $n$, outputs all numbers from 1 to $n$ in binary. Example: if $n = 5$, then we write 1, 10, 11, 100, 101, 110. (The format of the output doesn’t matter, they can all be on separate lines.)
