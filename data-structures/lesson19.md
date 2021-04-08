# Data Structures Lesson 19: Quicksort
{:.no_toc}

1. Table of Contents
{:toc}

# Heapsort stability

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/SpGZBcOxKPc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Last time, we analyzed the heapsort algorithm and mistakenly came to the conclusion that it is stable. In fact, heapsort is not stable. A simple example would be a list of 3 elements that are all the same number: [1, 1, 1]. To check if it's stable, we label each 1 with its initial order, so let's write these as [1a, 1b, 1c]. The algorithm works by turning this into a max-heap first: this is already in max-heap form, so there's nothing to do. Then $1a$ is swapped with $1c$, and the list is "re-heaped": [1c, 1b, 1a]. Then $1c$ is swapped with $1b$, and the final ordering is [1b, 1c, 1a].

If this is not satisfying, take a look at the example I go through in the video above.

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

<div class="youtube-contaienr">
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

# Interview question

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/SF-9EqclsEY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Take a look at the [interview question](https://atharaq.github.io/data-structures/lesson18.html#/interview) posed at the end of Monday's class. We will discuss this again in class next Monday.
