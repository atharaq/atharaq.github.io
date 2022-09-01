# Topics in Advanced Computing Lesson 1: Big Oh
{:.no_toc}

1. Table of Contents
{:toc}

# Questions from last time

* What do you consider to be an *efficient* running time for an algorithm?
* Are there some running times that are clearly “inefficient”?
* If you write a program that only performs “efficient” computations, and calls other functions that are “efficient”, is your program still efficient?
* Questions from the reading?

# Problems

By a **problem**, in this course, we will often mean a "yes / no" problem. Such types of problems are really referred to as "decision problems". So instead of things like the multiplication problem from last time, we will ask questions like: given integers $a, b,$ and $c$, decide if $a \times b = c$. Such an algorithm should either output "YES" or "NO" (or "TRUE" / "FALSE", or 0 / 1, etc).

We usually use set-theoretic notation to describe problems. That is, for a given problem, we consider the set of all those instantiations of the problem that have "YES" answers. So instead of asking: "Given numbers $a$, $b$, and $c$, ..." we write: $MULT = \\{ (a, b, c) : a \times b = c \\}$.

## Aside: Set Theory

A **set** is a collection of objects. We often either describe sets using curly brackets, and inside, either listing out their elements or using set-builder notation. For example: $X = \\{ 2, 4, 6 \\}$ is the set consisting of just those three numbers. We write $2 \in X$ to mean "$2$ is an element of the set $X$", or more simply "$2$ is in $X$". We write $1 \not \in X$ to mean "$1$ is not an element of the set $X$", or "$1$ is not in $X$".

For set-builder notation, we describe a set by giving a property that all of its elements have. For example, $P = \\{ n : n > 1$ and if $xy = n$, then either $x = n$ or $y = n \\}$ is the set of all **prime numbers**.

Consider the problem $UNIQUE = \\{ L : L$ is a list of 32-bit integers without any duplicates $\\}$. That is: given a list of numbers $L$, we determine if all the numbers in $L$ are unique.

**Exercise**: In small groups, find an algorithm that solves this problem. Use anything you know of: Java / Python, pseudocode, whatever you like. Determine the running time of your algorithm (does not need to be exact).

## Some Graph Theory

A **graph** is given by a set of vertices $V$ and a set of edges $E \subseteq V \times V$ (the edges are ordered pairs). We usually write this as $G = (V, E)$; the graph $G$ is given by the pair $(V, E)$, the set of vertices and the set of edges. Graphs can be *directed* or *undirected*; if a graph is *undirected*, then if there is an edge from $v$ to $w$, we also have an edge from $w$ to $v$ (ie, the edge relation is symmetric). For now, we will assume graphs are undirected unless otherwise stated.

A **cycle graph** on $n$ vertices is a simple, $n$-vertex cycle. That is, it has vertices $v_0, v_1, \ldots, v_{n-1}$, and edges between $v_0$ and $v_1$, $v_1$ and $v_2$, $\ldots$, $v_{n-2}$ and $v_{n-1}$, and $v_{n-1}$ and $v_0$.

Example: $C_6$:

![Cycle graph on 6 vertices](https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Undirected_6_cycle.svg/178px-Undirected_6_cycle.svg.png)

Similarly, we might talk about when a graph *contains* a cycle: if there are $n$ vertices $v_0, \ldots, v_{n-1}$ and edges going from $v_0$ to $v_1$, $v_1$, to $v_2$, $\ldots$, $v_{n-2}$ to $v_{n-1}$ and $v_{n-1}$ to $v_0$. In this case, maybe there are other vertices and edges, but if we only worry about whether a graph contains a cycle, we can ignore the others.

![Graph with vertices A-L, with cycles A-F and G-L](https://upload.wikimedia.org/wikipedia/commons/d/df/Graph_with_Chordless_and_Chorded_Cycles.svg)

The graph above has many cycles. In particular, A-B-C-D-E-F-A is a cycle.

**Exercise**: Given a graph $G$ with vertices $V$ and edges $E$, determine if $G$ has a cycle (of any length).

1. How do we represent $G$?
2. Can you come up with an algorithm that checkes if $G$ has a cycle?
3. What is the running time of your algorithm?

# Big Oh

**Definition**: Let $f : \mathbb{N} \to \mathbb{R}$ and $g : \mathbb{N} \to \mathbb{R}$. We say $f \in O(g)$, or, abusing notation, $f(x) = O(g(x))$, if there is $N \in \mathbb{N}$ and a positive real number $k$ such that for all $n \geq N$, $$\|f(n)\| \leq k \cdot \|g(n)\|.$$

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

# Readings and reminders

* No class on Labor Day (Monday 9/5)
* Next Thursday's class (9/8) will be asynchronous. In lieu of class, there will be some "classwork" activities you will need to do. Please keep an eye out for those.
* Please read sections 1.2-1.5 (pages 14-30) of the textbook. There is a lot in here that is quite technical, but most of it are formalisms that need to be stated. Try to just get a big picture understanding of what's going on here, and I will explain more in the coming weeks.
* Remember to pick a topic by **next Friday**, September 9!
