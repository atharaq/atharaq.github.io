# CS2 Lesson 21: Sorting Algorithms
{:.no_toc}

1. Table of Contents
{:toc}

# Sorting

How would you sort a group of people by height? One intuitive idea might be to put them all in a line, and go down the line, comparing two people standing next to each other. Make sure those two are in order, and then move on one step. Any time you see someone out of order, you swap them. So for exmaple, if we have four people, whose heights (in inches) are 67, 63, 74, 61, then:

* First, we swap 67 and 63, so the order looks like 63, 67, 74, 61.
* Then we compare 67 and 74, that looks fine, so we keep going.
* Then we swap 74 and 61, so the order looks like 63, 67, 61, 74.
* We've gotten to the end of the list! But it's not in order yet.

So what do we do? Backtrack to the beginning. Actually what we know now is that the tallest person is at the back already. So now we backtrack to the beginning, and do this again. We keep doing this until, eventually, everyone is in order.

This is the idea behind the "Bubble Sort" algorithm. Take a look at this [interactive sorting demo.](https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/visualize/) Click on "run" and step through one at a time to see how the larger elements "bubble up" to the top at each iteration. Those are depicted in green when they are put into the right place.

**Exercise**: Write pseudocode for the algorithm used here. You'll need *nested* for loops: a for loop inside of another for loop! At the end of the outside for loop, the green elements should be in place.

## Selection Sort

Here we describe another sorting algorithm. This algorithm uses the fact that it's easy to find the smallest element in a list. Suppose our list contains the numbers $a_0, a_1, \ldots, a_{n-1}$.

* For each $i$, look for the smallest element in the list between $i$ and $n - 1$.
* If we find something smaller than $a_i$, swap $a_i$ with the smallest element between $i$ and the end.
* Repeat this until we have looked through all $i$ from $0$ to $n - 1$.

**Exercise**: Write pseudocode for this algorithm.

# Running Times

Analyze the pseudocode for your algorithms to figure out their running times. For Bubble sort:

* The first iteration of the "outer" loop takes about $n - 1$ steps.
* The second iteration takes about $n - 2$ steps.
* The third iteration takes $n - 3$ steps.
* etc.

So the total number of steps for the Bubble Sort algorithm would be $(n - 1) + (n - 2) + (n - 3) + \ldots + 2 + 1$. We've seen this sum before: it's $\frac{n(n-1)}{2}$.

For the selection sort:

* The first iteration would also take $n - 1$ steps (to find the smallest element in the array).
* The second iteration would also take $n - 2$ steps (to find the second smallest element).
* etc.

So this would have about the same running time! In terms of Big Oh, both of these are $O(n^2)$ algorithms.

# Divide and conquer

It seems like sorting algorithms are generally $O(n^2)$. Is that as good as we can do?

It turns out that there are several options that improve on this running time. Most involve **divide-and-conquer** algorithms. This means that we split the list into smaller parts, and (recursively) sort these smaller lists. There are several ways to do this, we will describe one: the **merge sort** algorithm.

## Merge sort

The algorithm for merge sort works as follows:

Given a list:

1. Split the list in half.
2. (*Recursively*) merge sort each half.
3. Merge the two halves to produce one, sorted list.

**Exercise**: write pseudocode for merging two sorted lists into one, larger sorted list. Analyze its running time.

For example, your pseudocode should merge the lists [1, 3, 4] and [2, 5, 6, 7] into the list [1, 2, 3, 4, 5, 6, 7].

# Presentations and demos

We were supposed to do in-class demos for project 3 and one more set of presentations on VoiceThread. Instead, we will do both on VoiceThread. I apologies for the last minute changes in this class.

# Coming Up

* Mergesort algorithm
* Running time of mergesort
* Intro to data structures
* Project 4 (announced April 24, due May 8)
* Exam 3 rescheduled to **April 27**.
* Final Exam: May 4.
