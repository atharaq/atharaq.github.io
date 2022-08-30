# Topics in Advanced Computing Lesson 1: Running Times and Big Oh
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

For set-builder notation, we describe a set by giving a property that all of its elements have. For example, $P = \{ n : n > 1$ and if $xy = n$, then either $x = n$ or $y = n \}$ is the set of all **prime numbers**.

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



# Readings
