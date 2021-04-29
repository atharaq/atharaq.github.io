# CS2 Lesson 23: Mergesort
{:.no_toc}

1. Table of Contents
{:toc}

Today we will be looking at the mergesort algorithm. The idea of the algorithm is as follows:

1. Split a list in half.
2. Recursively mergesort each half.
3. Merge the two halves to produce one, sorted list.

# Merge pseudocode

How do we merge two "sorted" halves to produce one sorted list? Try to write the pseudocode for that.

```java
int[] merge(int[] left, int[] right)
```

The idea is as follows:

* Create a new list of the appropriate size.
* Keep track of "index" variables that tell you where you are looking at in the left, right, and new lists.
* Compare an element from the left array with an element from the right.
  * Take the smaller one and copy that over to the new list.
  * Advance the appropriate "index" variables.
* Whichever list has anything left over, copy those elements over to the new list.

See if you can write the pseudocode for this. If you get stuck, start watching the video below where I go through the idea of the algorithm and the pseudocode for it.


<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/ZkgLjwoME6o" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Mergesort pseudocode

Recall: the merge sort algorithm works as follows:

* Split the list in half.
* Recursively merge sort each list.
* Merge the two halves.

Write pseudocode for the merge sort algorithm and write pseudocode for it. (No need to re-write the "merge" method.)

## Analysis

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/-Z6s6411Nu8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

To analyze the running time, suppose $T(n)$ is the number of steps the merge sort algorithm takes on a list of size $n$. Then notice:

$$T(n) = 2T(n/2) + O(n)$$

For simplicity, we will just assume $T(n) = 2T(n/2) + n$. Notice: if $n = 8$ (which is $2^3$):

$$
\begin{align}
T(2^3) &= 2T(2^2) + 2^3 \\
&= 2(2T(2^1)+2^2)+2^3 \\
&= 2^2T(2^1)+2*2^3 \\
&= 2^2(2T(1)+2^1)+2*2^3 \\
&= 2^3T(1)+3*2^3
\end{align}
$$

In other words, we split 8 in half 3 times, and each time we split it in half, we end up counting 8 more steps.

In general, for any $N$, we can split $N$ in half $\log_2(N)$ times, and each time we would count $N$ more steps, so the running time would be $O(n \log(n))$.

# Implementations

At this point, we have seen pseudocode for the merge algorithm and the mergesort algorithm. Now let's implement them.

First, implement the merge algorithm:

```java
int[] merge(int[] left, int[] right)
```

Test it out with a main method that creates two sorted lists and calls "merge" to merge them:

```java
int[] left = { 1, 2, 5, 6 };
int[] right = { 3, 4, 7, 8};
int[] merged = merge(left, right);
System.out.println(Arrays.toString(merged);
```

We can print out an array easily using the `Arrays.toString` method.

If you get stuck on this part, take a look at the following video where I go through the steps of implementing this.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/tecljsCL0CQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## Mergesort implementation

Now implement the mergesort algorithm:

```java
void mergesort(int[] list)
```

Test it out with a main method that creates an (unsorted) array and attempts to sort it. Again, if you get stuck, feel free to consult the following video:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/BmUFrtA7fco" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Next time

Next week, we will study data structures. A **data structure** is a way of organizing data in memory. We have seen two important kinds of data structures already: arrays and ArrayList.

A **linked list** is another kind of list structure.

<img src="singly_linked_list.png" alt="Singly linked list diagram, Wikimedia Commons" class="noreverse" />

The data is organized into **nodes**. Each node has a data item and a link to the next node. (The last node links to `null`.)

We will see how to implement these kinds of data structures, as well as how using different data structures (arrays vs linked lists) could affect the kind of algorithm we might use to solve a problem.
