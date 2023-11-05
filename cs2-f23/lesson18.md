# CS2 Lesson 18: Algorithms / Pseudocode
{:.no_toc}

1. Table of Contents
{:toc}

# Lesson Video

Instead of breaking it up for this video, I have one (long) video that covers the whole lesson.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/orXaI_ptAXI?si=mQAREVl9lLahuqjc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</div>

Timestamps:

* [0:00 - 19:00: Algorithms](#algorithms)
* [19:01 - 31:40: Analysis of algorithms](#analysis-of-algorithms): [Link to video at this timestamp](https://youtu.be/orXaI_ptAXI?si=ePxGw_CRAi49_cHr&t=1142)
* [31:40 - end: String concatenation / ArrayList add](#string-concatenation): [Link to video at this timestamp](https://youtu.be/orXaI_ptAXI?si=u9VqU_pSAawh4FZ0&t=1900)

# Algorithms

An **algorithm** is a precise list of instructions for solving a general problem. Algorithms can be described in many ways. For example, the algorithm which finds the maximum number in a list of numbers:

* English: "Set the max equal to the first number. For each of the rest of the numbers in the list, compare it to the previous max. If the number is greater than the max, update the max to that number."
* Java/Python/C++ code that implements that algorithm.
* Pseudocode: somewhere in-between natural language and a high level programming language.

Describing an algorithm using pseudocode allows us to ignore language-specific features (ie, the syntax and particular methods of the {\lstinline|ArrayList|} type). We instead focus on the steps of the algorithm.

## Sequential Search Algorithm

**Problem**: Given a list $l$ and an object we are looking for $o$, find it in the list. Return $i$ if $l_i == o$, and return $-1$ if $o$ is not in the list.

Try to do the following:

1. On paper, describe an algorithm in English to solve this problem.
2. On paper, describe this same algorithm in pseudocode.

<details>
<summary>Click for one answer:</summary>
<pre>
procedure find(list l, object o):
	for i = 0 to l.size()
		if l[i] = o
			return i
	return -1
</pre>
</details>

## Syntax

There is no generally accepted syntax for pseudocode. It's not a real langauge and doesn't have a compiler, so the point is to describe the algorithm precisely. You can use some general constructs that are available in most languages:

1. Variables and assignments
2. Comparisons and if-else statements
3. For and while loops
4. Functions / subroutines
5. Arrays and other data structures (like lists)

Don't worry so much about syntax rules like semicolons, brackets ({ and }). These are specific to the Java language.

# Analysis of Algorithms

**Question**: What's the difference between an **algorithm** and its **implementation** in code?

When we **analyze** algorithms, we do so without worrying about hardware or language specific details. We worry about two things: **running time** and **storage space**. For now we will just focus on running time: the number of steps it takes for an algorithm to run on any input of a specified size. Ideally, we try to describe this using a mathematical function: 

**Definition**: The **running time** of an algorithm is the function $t(n)$ which, for each $n$, gives the *maximum* number of steps required for the algorithm to run on any input of size $n$.

Recall the "find" algorithm:

```
procedure find(list l, object o):
	for i = 0 to l.size()
		if l[i] == o
			return i
	return -1
```

Suppose list $l$ has $n$ elements. About how many steps do you think the algorithm described earlier would take (in terms of $n$)? In other words, find the running time function for this algorithm.

Think about:

* If $o$ is randomly placed on the list (after about how many steps would you expect to find it?)
* The worst case scenario for $o$.
* If $o$ is not on the list.

## Comparing Functions

Roughly speaking it takes about $n / 2$ steps to find $o$ on a list of $n$ elements. We often don't care exactly what the running time function $t(n)$ is; instead, we care about what the running time is **proportional** to.

  Size of list      Worst Case      Average Case
--------------    ------------    --------------
50                50                25
100               100               50
200               200              100

# String concatenation

Determine what the following algorithm does:

```
procedure create(int n)
	String s = ""
	for i = 1 to n
		s += "1"
	return s
```
Recall: how does the += operator on **immutable** Strings? Fill in the following table for the number of steps for the `create` method:

   $n$     Number of steps
------    ----------------
  1           &nbsp;
  2           &nbsp;
  3           &nbsp;
  4           &nbsp;

## Big Oh Notation

The $n$-fold concatenation ends up taking $1 + 2 + \ldots + n$ steps to create a string of $n$ 1's. (**Tip**: use a **StringBuilder** instead of a String to do things like this). Exercise: find a formula for $1 + 2 + 3 + \ldots + n$.

**Hint**: If $n = 99$: write the numbers $1 + 2 + 3 + \ldots + 99$ on one line, then on the next line write it backwards $99 + 98 + 97 + \ldots + 1$. Then add vertically: each column should add to $100$! How many columns are there? (exactly $n$ of them, in this case $99$). So the total of both rows is $99 \times 100$: if we just want one row, it's $\frac{1}{2} \times 99 \times 100$.

Can you generalize this?

<details>
<summary>Check your answer.</summary>
<p>
$1 + 2 + \ldots + n = n(n+1) / 2 = (n^2 + n) / 2$. For large $n$, this is roughly proportional to $n^2$: the $n$ term is dominated by the $n^2$ term, and $1 / 2 n^2$ is of course proportional to $n^2$. The mathematics behind this is captured by "Big-Oh" notation: we say that this n-fold String concatenation algorithm is $O(n^2)$.
</p>
</details>

We say that this algorithm runs in $O(n^2)$ steps: that is, the running time is a function whose **most dominant term** is the $n^2$ term! (There is a precise, mathematical definition of "Big Oh". We won't get into it here.)

# ArrayList add

As we know: the `ArrayList` class is a dynamic list implementation based on an array. Arrays, in Java, have fixed sizes, so when we add too many things to an array, we need to create a new, larger array, copy the old elements over, and then add the new element at the correct position.

**Exercise**: write pseudocode for the following two versions of the "add" algorithm.

1. When you create a new array, make it be exactly $1$ element larger.
2. When you create a new array, make it be twice the size as the original array.

## Analysis

* Analyze the two "add" algorithms. If we start with an ArrayList of size $10$, how many steps are taken in each algorithm when we add $10$ new elements? What if we add $100$ new elements?
* How many steps does it take to add in $N$ new elements in each of the algorithms? (In terms of "Big Oh")
* Based on the above, on average, how many steps does it take to add in 1 new element in each of the algorithms (in terms of "Big Oh")?
