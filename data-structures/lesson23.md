# Data Structures Lesson 23: Concurrent Data Structures
{:.no_toc}

1. Table of Contents
{:toc}

# Compound Operations

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/HWq0u07-K8M" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

In the video above, I explore the [issue with the Vector class](https://atharaq.github.io/data-structures/lesson22.html#/vectors) that I skipped last time. In particular:

```java
// ensures that there is exactly one "item" object in the vector v
public void addIfNotFound(Vector<T> v, T item) {
    if (!v.contains(item)) {
        v.add(item);
    }
}
```

Notice that this code is not thread-safe. Why not?

I also look again at the NullPointerException we saw in the LinkedList class. The moral of the story is that the usual Java collections classes are not thread-safe: but there are several other options we can explore (and will explore) in the following videos.

# Synchronized Collections

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/Slc_FcAytac" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Java 1.1 had "synchronized collections" like `Vector`, `Hashtable`, and `Stack`. You probably should never use these.

Newer versions of Java introduced the  `Collections.synchronizedList` (and similarly `synchronizedMap`, `synchronizedCollection`, `synchronizedSet`, etc) methods.

There are two main issues with these: compound operations and iteration. We mentioned compound operations earlier:

```java
list = Collections.synchronizedList(originalList);
if (!list.contains(0)) {
	list.add(0);
}
```

**Moral:** if you use a synchronized collection, you may need to synchronize yourself as well!

## Iteration

Java Collections iterators are *fail-fast*. They will throw a `ConcurrentModificationException` if they detect that another thread is changing the underlying collection while you are iterating through it. These are not fool proof!

* If you need to, make sure to synchronize around the entire loop.
* Watch out for "hidden iterators": calls to `containsAll`, `toString`, and other methods may trigger an iteration through the entire collection.
* Locking during iteration can be bad! (Starvation, deadlocks, contention)

Instead of locking during the iteration, you can *clone* the collection first. Obvious downsides, but this is definitely thread-safe. Must lock during cloning, but no locking needed while iterating the clone! (Why?)

# CopyOnWriteArrayList

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/Mj93EAvPmqw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

The idea of this class is that each modification (add, remove, etc) would trigger creation of a new copy of the underlying array. This means that if one thread is changing the list, while another thread is "reading" from the list, there is no possible contention: the second thread will see the copy of the list as it existed at the time it started using it, while the other thread will make a new, fresh copy that it can work with.

Sometimes this is a good idea. For example: think of an event notification systems. When asynchronous "events" come in, perhaps we must notify a large, somewhat static, list of event handlers.

## Scenarios

Scenario 1:

```java
CopyOnWriteArrayList<Integer> l; // initialized somewhere
// Thread 1:
for (int i = 0; i < 1000; i++) {
	l.add(i);
}
// Thread 2:
for (int num : l) {
	System.out.println(num);
}
```

What will be printed out?

Scenario 2:

```java
// Thread 1 is the same as above
// Thread 2:
Iterator<Integer> it = l.iterator();
while (it.hasNext()) {
	int num = it.next();
	it.remove();
}
```

What happens here?

Scenario 3:

```java
CopyOnWriteArrayList<Integer> l;
// l is initialized somewhere and shared
if (!l.contains(0)) {
	l.add(0);
}
```

Are compound operations any better?

# HashMap Race Condition

Please read ["A Beautiful Race Condition"](https://mailinator.blogspot.com/2009/06/beautiful-race-condition.html), a fun blog post from 2009 about a particularly nasty race condition caused by using a `HashMap` in an unsafe concurrent way.

# ConcurrentHashMap

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/ElyR1OJxWPQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Some quick bullet points here:

* Recall that HashMaps use "separate chaining": basically a large table of LinkedLists
* ConcurrentHashMap uses "lock striping": instead of one lock for the entire table, separate the table into "buckets", each of which has its own lock.
* Reads (`get` / iterators over the keySet or entrySet) do not contend with each other, or with writes (`put`).
* Limited number of "writes" can be done concurrently.
* No need to lock on iteration: gives a "view" of the elements of the table as they existed at the time you iterate. Does not necessarily update that "view" if there are modifications to the underlying table concurrently.
* Atomic compound operations: `putIfAbsent`, `computeIfAbsent`, etc.
* Resizing creates a separate table, locks on each "bucket" of the original table as it transfers

One thing I didn't mention in the video above is that the `size` and `isEmpty` methods might not work the way you want them to in a concurrent context. From *Java Concurrency In Practice*:

> As with all improvements, there are still a few tradeoffs. The semantics of methods that operate on the entire Map, such as size and isEmpty, have been slightly weakened to reflect the concurrent nature of the collection. Since the result of size could be out of date by the time it is computed, it is really only an estimate, so size is allowed to return an approximation instead of an exact count. While at first this may seem disturbing, in reality methods like size and isEmpty are far less useful in concurrent environments because these quantities are moving targets. So the requirements for these operations were weakened to enable performance optimizations for the most important operations, primarily get, put, containsKey, and remove.
