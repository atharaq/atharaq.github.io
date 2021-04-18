# Data Structures Lesson 21: Algorithm Design
{:.no_toc}

1. Table of Contents
{:toc}

# Quickselect Analysis

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/uD35pi2k1-4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Follow along the slides from last time:

* [Running time (worst / best case)](https://atharaq.github.io/data-structures/lesson20.html#/running-time)
* [Average case (1 / 2)](https://atharaq.github.io/data-structures/lesson20.html#/average-case-analysis)
* [Average case (2 / 2)](https://atharaq.github.io/data-structures/lesson20.html#/magic)

# Greedy Algorithms

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/B5TO9U1rjI0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

A **greedy algorithm** is an algorithm which attempts to find a solution to a problem by making choices that are **locally optimal**. The hope is that you actually find the **globally optimal** solution. Often times, the greedy solution is not always globally optimal (in fact, it can sometimes produce the worst possible output).

<img src="https://i.stack.imgur.com/yHQuy.jpg" alt="Greedy algorithm fails for the TSP" />

For example, in this graph (Basu, *Design Methods and Analysis of Algorithms*), the greedy algorithm for the Traveling Salesman Problem starting at vertex $A$ would first look at the lowest cost edge from $A$ (which would be to $B$. This would produce the cycle ABCDA, which has total cost 9. But the optimal TSP cycle is ACBDA, which has total cost 8.

## Change-Making Problem

**(General) Problem**: given a set of coin denominations $\\{ c_1 > c_2 > \ldots > c_n \\}$, and a value $x$, find the least number of coins needed to add up to $x$.

**Claim**: if the set of coin denominations is the standard $\\{ 1, 5, 10, 25 \\}$, then the greedy algorithm produces an optimal collection of coins. (Proof is not hard, but is not very interesting. Just look at all the cases for everything below $24$.) **Exercise**: show what the greedy algorithm outputs with this set of denominations and $x = 37$. 

## Greedy Failure

The greedy algorithm fails for more general sets of coin denominations! Can you find a counterexample where the set of denominations is $\\{ 1, 15, 20 \\}$?

# Online vs Offline Algoirthms

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/F-goaz-reqo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Most of the algorithms we have seen have been **offline**. An offline algorithm is one which requires that the entire input be given all at once. In contrast, an **online algorithm** can only process its input one at a time. 

Compare the insertion and selection sort algorithms. Can one of them be considered an "online" algorithm?

In general, an online algorithm might not necessarily produce an optimal result.

## Secretary Problem

Given a list of candidates for a job opening, you wish to hire the best one. We can think of this problem in two ways:

* Offline version: interview each one, and then after you have interviewed all of them, call the one who impressed you the most on the interview. (The best candidate.)
* Online version: the candidates all expect a decision right away. Once you hire someone, you can no longer interview the rest of the candidates. Once you reject someone, you can no longer get back to them.

(Somtimes referred to as the "Marriage" problem: instead of hiring, you want to pick one person to propose to. You can only propose to one person, and you must make a decision on one relationship before moving on to the next.) Try to think of a potential hiring strategy for the "online" version. Suppose that there are 10 candidates and you can unambiguously rank them (if you were able to see them all). What strategy will optimize the probability that you hire the best candidate?

# Concurrency

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/vZ1C6-toJtE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>


Next week we will study **concurrency** issues. The idea of concurrency is simply that we can have multiple threads of execution doing work at the same exact time. You are, of course, familiar with the concept of multiple *processes* doing work at the same time in your computer: that's why you're able to have multiple tabs open at the same time in your browser window and why you're able to have multiple programs open at the same time on your laptop. Threads operate very similarly: they are kind of a "lightweight process".

When a thread is created, the JVM does several things:

* allocates memory for the "stack frame" for that thread (local memory)
* creates a "program counter" that keeps track of the instruction (line of code) that that thread is currently "sitting on"
* asks the operating system to create an actual OS thread

When multiple threads are running, often times the OS will use **time-slicing**: instead of letting one thread run for awhile, and then the next thread, the OS will have each thread run for short "slices" of the computer's clock, pause it and save the state of that thread, and then have the next thread run. The OS can do this kind of **context-switching** in very unpredictable ways, and it can lead to issues that we need to be aware of.

The `Increment` program creates several threads, each of which increments a counter a fixed number of times. This counter is shared across all the threads, and therefore, by the end of the program, the counter should be incremented `NUM_THREADS * NUM_INCREMENTS` number of times. Run this program and see what happens. Most likely, it does not match up exactly. This is called a **race condition**: the behavior of the code depends on the order in which different threads run. The race condition is localized to one very particular line of code:

```java
++counter;
```

This line of code seems innocuous: if one thread pauses before this line of code, or right after, surely nothing bad can happen, right? The issue is that this one line is not really just one instruction. This is really several instructions:

```
temp = counter;
temp2 = temp + 1;
counter = temp2;
```

It's possible that, one thread could be paused right after `temp = counter;`, while the other threads run through all these instructions immediately. So what might happen? Suppose `counter` is 50. In that case, temp is set to 50. Then it is paused while counter is still 50, and the next thread kicks in. Suppose that thread just runs straight through, incrementing `counter` to 51. Then let's assume thread 1 comes back, and sets `temp2` to 51, and then resets `counter` to 51. Therefore, we have had *two* increments for `counter`, but we were only able to increase it from 50 to 51.
