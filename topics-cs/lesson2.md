# Topics in Advanced Computing Lesson 2: Big Oh
{:.no_toc}

1. Table of Contents
{:toc}

# Graph Theory Problem

(video?)

**Exercise**: Given a graph $G$ with vertices $V$ and edges $E$, determine if $G$ has a cycle (of any length).

1. How do we represent $G$?
2. Can you come up with an algorithm that checkes if $G$ has a cycle?
3. What is the running time of your algorithm?

# Big Oh Activity

(Desmos activity)

# Big Oh

(video? some notation?)

**Definition**: Let $f : \mathbb{N} \to \mathbb{R}$ and $g : \mathbb{N} \to \mathbb{R}$. We say $f \in O(g)$, or, abusing notation, $f(x) = O(g(x))$, if there is $N \in \mathbb{N}$ and a positive real number $k$ such that for all $n \geq N$, $\|f(n)\| \leq k \cdot \|g(n)\|.$

The idea here is that $f$ is asymptotically bounded by a constant multiple of $g$. In other words, $\frac{f}{g}$ is eventually bounded above. In the below graph, we have $f(n) = 12n^2 + 2n + 3$, and $g(n) = n^2$. The dashed line graph is $15 \cdot g(n)$. Near $n = 0$, the graphs are all pretty small, but as $n$ gets larger, eventually the dashed dominates. That shows that $f(n) = O(n^2)$.

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/d8iqylvkkq?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

## Example

Suppose $f(n) = n^3$ and $g(n) = 2^n$. Show that $n^3 = O(2^n)$.

We can first plug in a few values and check.

* $f(0) = 0, g(0) = 1$
* $f(1) = 1, g(1) = 2$
* $f(2) = 8, g(2) = 4$
* $f(3) = 27, g(3) = 8$
* $f(4) = 64, g(4) = 16$,

So for the last few values we checked, $f(n) > g(n)$. But eventually, we get to $f(10) = 1000$ and $g(10) = 1024$.

In fact, we can prove the following: for every $n \geq 10$, $n^3 \leq 2^n$. How would we show this? It's not obvious at all. What we really want to show is: $\lim\limits_{n \rightarrow \infty} \frac{n^3}{2^n} = 0$. How? Use l'Hopital's rule!

$$
\begin{align}
\lim_{n \rightarrow \infty} \frac{n^3}{2^n} &= \lim_{n \rightarrow \infty} \frac{3n^2}{\ln(2) 2^n} \\
&= \lim_{n \rightarrow \infty} \frac{6n}{\ln(2)\ln(2) 2^n} \\
&= \lim_{n \rightarrow \infty} \frac{6}{\ln(2)\ln(2)\ln(2) 2^n}\\
&= 0
\end{align}
$$

**Question**: Is $2^n = O(n^3)$?

## Exercises

* Show that $\log_2(n) = O(n)$.
* Show that $n \neq O(\log_2(n))$.
* Show that $\log_b(n) = \ln(n)$ for any $b > 1$.

## Big Theta

We say $f = \Theta(g)$ if $f = O(g)$ and $g = O(f)$. The idea here is that $f$ and $g$ would be asymptotically proportional to one another; in other words, eventually $\frac{f}{g}$ and $\frac{g}{f}$ are both bounded, so neither function really "dominates" the other.

Look again at the example of $f(n) = 12n^2 + 2n + 3$ and $g(n) = n^2$. We saw that $f(n) = O(g(n))$ since, for $k = 15$, we have that eventually $f(n) \leq 15n^2$ for all large enough $n$. But also, you should notice that $g(n) \leq f(n)$ for all $n$. This is clear immediately from the expressions for $f$ and $g$. So that means $f(n) = \Theta(n^2)$: not only have we found a function that "bounds" $f(n)$, but we also have found one that is asymptotically proportional to $f(n)$!

In general, we often will use "simple" functions like $n$, $\log(n)$, $n^2$, $n^3$, etc when we classify functions. We wish to use these to describe running times: instead of saying that $T(n) = 2n^2 - n$, we would simply say $T(n) = O(n^2)$. This is in line with wanting to take a *broad* look at complexity, for the purposes of just saying "Do we have an efficient algorithm to solve this problem? Can we improve that efficiency significantly?"

# Reminders

...
