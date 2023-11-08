# Data Structures Lesson 20: Quicksort analysis
{:.no_toc}

1. Table of Contents
{:toc}

# Final Projects

Possible topics to think about:

* Other kinds of trees: Red-Black trees, B-trees, 2-3-4 trees, splay trees: Describe the data structure. Prove the running times. Explain what they are used for (don't need to do *all* of these, maybe just one, or maybe more?)
* Huffman Coding (compression). Describe the compression algorithm and give a thorough explanation of the data structures used in it (the "trie" data structure). Implement the algorithm and run it on a large file ($>2$MB). How much does it actually compress that file?
* Union-find algorithm / Disjoint Set data structure. Explain the problem and the data structure. Explain how this data structure can be used to help solve the "Synonymous Search Queries" question in the case where the synonym relation is transitive. (Describe other problems for which this data structure would be usefulf or)
* Heuristic algorithms for NP complete problems. Take your favorite NP-complete problem (not graph coloring), and describe an algorithm which attempts to solve it. Describe its running time and the scenarios for which this algorithm will work well.
* Data structures used in Operating System design
* Find the Longest Common Substring of a set of words. Explain the algorithms and their running times. There is an algorithm which uses "suffix trees": describe how to implement this data structure and how it helps solve the problem.
* "Median of medians" pivot selection strategy. Explain the algorithm, show some examples, and implement it. Prove that this strategy results in a worst case $O(n)$ quickselect algorithm (and worst case $O(n \log(n))$ quicksort).

... or any other problem you've seen that was interesting and that you'd like to explore in more depth.

# Interview question

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/SF-9EqclsEY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Take a look at the [interview question](lesson19.html#/interview) posed at the end of Monday's class.

# Comparison Based Sorting

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/prXaTE3gYD8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

We have seen several sorting algorithms that run in $O(N \log(N))$ time. It turns out: this is the best we can do; at least, for comparison-based sorts. The idea is to think about combinatorics: a list of size $N$ has $N!$ different possible orderings. Each comparison would cut in half the number of orderings we'd need to consider. For example, if we have three (distinct) elements $a$, $b$, and $c$, there are 6 possible orderings: there are 3 orderings of these elements where $a < b$, and 3 where $b < a$. So one comparison (between $a$ and $b$) would cut the number of orderings in half.

How many comparisons would we need until we find the one, correct ordering? In other words: how many times can we cut $N!$ in half until we get to 1? The answer is $\log_2(N!)$. I claim that $\log(N!) = \Omega(N \log(N))$, where $\Omega$ is the "lower bound" equivalent to "Big Oh".

To see this, notice that $\log(N!) = \log(N) + \log(N-1) + \ldots + \log(2)$. Then:

$$
\begin{align}
\log(N!) &= \log(N) + \log(N-1) + \ldots + \log(2) \\
&\geq \log(N) + \log(N-1) + \ldots + \log(\frac{N}{2}) \\
&\geq \log(\frac{N}{2}) + \log(\frac{N}{2}) + \ldots + \log(\frac{N}{2}) \\
&= \frac{N}{2} \log(\frac{N}{2})
\end{align}
$$

That means that every comparison based sorting algorithm must use at least $\Omega(N \log(N))$ comparisons.

# Quicksort algorithm

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/7vxg2DYvp6U" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

The quicksort algorithm works as follows:

* Pick an element of the list, call it $pivot$.
* Partition the list into three parts: everything smaller than the $pivot$ (call this part $L$), the $pivot$ itself, and then everything larger than the pivot (call this part $R$).
* Recursively quicksort $L$
* Recursively quicksort $R$.

Here is some [pseudocode for the quicksort algorithm from Monday's slides](https://atharaq.github.io/data-structures/lesson18.html#/quicksort).

A lot of the work goes into the *partition* method. Try to write pseudocode for that on your own (I write some in the video above).

## Analysis

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/GR-j_qnKM_g" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Quicksort is **not stable**. To see this, consider a list with the elements [10, 1, 2, 6, 8, 2, 2]. Label the 2s so we can distinguish them: [10, 1, 2a, 6, 8, 2b, 2c]. Depending on how we treat the 2s, our partition method would either skip them (most likely it should), or it would swap $2b$ with $10$ (violating stability right away). If it skips them, then the partition method would swap 10 and 1, and then swap 10 and 2c, leaving us wiht [1, 2c, 2a, 6, 8, 2b, 10].

Quicksort has space complexity $O(1)$, as we only require a constant amount of extra space, regardless of the size of the list.

In the worst case, if we are very unlucky with our pivots, we may end up partitioning the list into one set of size $N - 1$ and another of size $0$. For example, if the list is sorted already, and we pick the last element of the list every single time:

* First we partition a list into $N - 1$ elements, and the pivot, and call quicksort on the list of size $N - 1$.
* Then we partition the $N - 1$ elements into $N - 2$ elements, and the pivot, and call quicksort on the list of size $N - 2$.
* Then...

This ends up basically being a selection sort, which runs in $O(N^2)$ time.

## Average case analysis

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/lD0O1r2WZkY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Notice that the *partition* part of the algorithm is linear: we partition by looking at each element of the list and comparing it to the $pivot$. For the sake of simplicity, we will assume that it runs in exactly $N$ steps.

Suppose that, when we partition, the we split the list into a list of size $i$ and a list of size $N - i - 1$. Then the running time for the quicksort algorithm is given by the equation $T(N) = T(i) + T(N - i - 1) + N$.

To analyze the average case, we assume that each $i$ is equally likely. That is, the left list is equally likely to have sizes $0$, $1, \ldots,$ or $N - 1$. So there are $N$ possibilities, and therefore they each have probability $\frac{1}{N}$. Then the average value of these $T(i)$ is $\frac{1}{N} \sum_{i=0}^{N-1} T(i)$. That means the average value of $T(N)$ is given by the recurrence:

$$T(N) = \frac{2}{N} \sum_{i=0}^{N-1} T(i) + N$$

We solve this recurrence by trying to get it into a form where formulas for $T(N)$ and $T(N-1)$ will cancel out. To do this, we first multiply both sides by $N$ to remove the denominator:

$$NT(N) = 2 \sum_{i=0}^{N-1} T(i) + N^2$$

Now plug in $N - 1$:

$$(N-1)T(N-1) = 2 \sum_{i=0}^{N-2} T(i) + (N-1)^2$$

Now subtract these two:

$$NT(N) - (N-1)T(N-1) = 2T(N-1) + 2N - 1$$

Simplifying:

$$NT(N) - (N+1)T(N-1) = 2N - 1$$

At this point, we drop the constant for the purposes of Big Oh analysis. Then divide by $N(N+1)$:

$$\frac{T(N)}{N+1} - \frac{T(N-1)}{N} = \frac{2}{N+1}$$

Now, as before, plug in $N - 1$ to this recurrence:

$$\frac{T(N-1)}{N} - \frac{T(N-2)}{N-1} = \frac{2}{N}$$

Notice that if we add these two, $\frac{T(N-1)}{N}$ will cancel out. This means this recurrence can be [telescoped](https://en.wikipedia.org/wiki/Telescoping_series): we continue as before, plugging in $N -2$, $N-3$, etc, until we get to expressions with just $T(1)$, and add all of them. All of the terms will cancel on the left side except the first and last, and so we will get:

$$\frac{T(N)}{N+1} - \frac{T(1)}{2} = \sum_{i=3}^{N+1} \frac{2}{i}$$

The right hand side is $O(\log(N))$ (roughly because $\int_3^{x+1} \frac{2}{t} dt = O(\log(x))$), and so $T(N) = O(N\log(N))$.

# Pivot Selection

So far, we have described the quicksort algorithm using the last element as a pivot. But there are other possible **pivot selection schemes**.

* Pick the first element as a pivot. Worst case: the list is already sorted!
* Pick the last element as a pivot. Worst case: still, if the list is sorted (or in reverse order).
* Pick a random pivot. Worst case: you're just really unlucky. Perhaps this is good enough?

This question of how to select the pivot in the quicksort algorithm is well studied (in particular by Robert Sedgewick in his 1975 Ph.D thesis).


We will study some other possible improvements.

## Median of 3

Make the pivot be the median of three elements. Two simple implementations:

1. Find the median of the first, last and middle elements.
2. Find the median of three random elements.

The worst case here is still $O(n^2)$! But it's somewhat less likely to happen, and on average the random version improves on the number of comparisons that the "random pivot" strategy would make.

## Dual pivots

The version currently implemented in the Java standard library `Arrays.sort`, created by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch, uses two pivots. Idea:

1. Pick pivots $p_1$ and $p_2$ with $p_1 < p_2$.
2. Partition the list into three parts: the part less than $p_1$, the part in between $p_1$ and $p_2$, and the part greater than $p_2$. At this point, $p_1$ and $p_2$ should be in the correct positions.
3. Quicksort the three parts.

## Caveat

Technically, the one in the JDK is much more complicated, but this is the spirit of the algorithm. Some improvements it makes:

* For small arrays: it uses insertion sort instead.
* If the array is "close" to being sorted, mergesort is used.
* If it's an array of non-primitive types: it uses something called "Timsort". 

# Quickselect

Recall the selection problem: given an unsorted list and an integer $k$, find the $k$-th largest element. We can use a variant of quicksort, called **quickselect**, to solve this problem:

1. Pick a pivot (for now, let's pick a pivot randomly).
2. Partition the list and determine the $pivotIndex$, the position of the pivot.
3. If $k ==  pivotIndex$, return the pivot.
   * Otherwise? recursion!
4. If $k < pivotIndex$, run quickselect on the list from $start$ to $pivotIndex - 1$.
5. If $k > pivotIndex$, run quickselect on the list from $pivotIndex + 1$ to $end$, searching for $k - pivotIndex - 1$.

**Example**:

Find the 3rd largest element of the following list: [3, 1, 4, 5, 9, 2, 6]

* Pick pivot = 3 (randomly)
* Partition: [2, 1, 3, 5, 9, 6, 4]
* Index = 2, quickselect([5, 9, 6, 4], 0)
* Pick pivot = 4 (randomly)
* Paritition: [4, 9, 6, 5]
* Index = 0: returns 4!

## Running time

Worst case: $O(n^2)$. Proof?

Best case: each partition takes $m$ comparisons (really $O(m)$, but we will simplify), where $m$ is the size of the part of the array that we are looking at. If the pivot is the median every single time, then the number of comparisons needed is:

$$n + n / 2 + n / 4 + \ldots = 2n$$

which is $O(n)$.

## Average case analysis

Average case? This is the scenario where every pivot is equally likely.

Let $T(n, k)$ be the expected time to find the $k$-th smallest in an array of size $n$, and $T(n)$ be the largest value over all $k$.

* It takes $n - 1$ comparisons to partition the array.
* The array is split into pieces: $0$ and $n - 1$, $1$ and $n - 2$, etc. We assume here that we always pick the larger piece.

$$T(n) \leq n - 1 + average(T(n / 2), \ldots, T(n - 1))$$

Now we use a trick: prove that $T(n) \leq 4n$ by induction.

* True for $T(0), T(1), T(2)$ by inspection.
* Assume that, for all $i < n, T(i) \leq 4i$.
* Using the equation above, we get:

$$
\begin{align}
T(n) &\leq n - 1 + average(4(n / 2), \ldots, 4(n - 1)) \\
&= n - 1 + 4(3n / 4) < 4n
\end{align}
$$

So $T(n) = O(n)$.