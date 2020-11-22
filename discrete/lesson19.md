# Discrete Mathematics Lesson 19: Graph Theory
{:.no_toc}

1. Table of Contents
{:toc}

# Seven Bridges of Königsberg

![Seven Bridges of Königsberg](https://upload.wikimedia.org/wikipedia/commons/5/5d/Konigsberg_bridges.png)

Königsberg, Prussia (now known as Kaliningrad, Russia) is the setting for one of the most important problems in the development of modern mathematics. The city was laid out as pictured above, with seven bridges connecting several landmasses around the Pregel River. A tale is told about how the citizens of this city used to walk around the bridges and wonder how one might plan a walk around the city crossing each bridge **exactly once**.

In 1736, Leonhard Euler proved that this would be impossible! In his proof, he recognized some simplifying assumptions that led to the modern development of graph theory and topology. In particular, he recognized that the relative shapes of each region is not really important, but what is only important are the connections between each region (the number of bridges connecting different regions). Mathematicians now recognize this as a graph-theoretic problem: given a set of vertices and some edges between those points, is there a path one can take that crosses each edge exactly once?

![Abstract Graph Representation of the Bridges Problem](https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Königsberg_graph.svg/300px-Königsberg_graph.svg.png)

# Definitions

Mathematically, we formalize the notion of graphs (vertices and edges between them) using set theory. A **graph** is an ordered pair $(V, E)$, where $V$ is a set, denoting the **vertices** of the graph, and $E$ is a set of **edges**, consisting of pairs of vertices. There are a few ways to refer to edges:

* "Unordered pairs", or sets of size 2
* Ordered pairs $(a, b)$.

I usually will use ordered pairs as it generalizes to several situations, but you may see either notation in different textbooks. Either way, for each $e \in E$, we associate one or two vertices, known as its **endpoints**. Two endpoints of an edge are **adjacent**: that is, two vertices $v$ and $u$ are called adjacent if there is an edge connecting $v$ and $u$.

A vertex is most often depicted as a point in space ($\mathbb{R}^2$ or $\mathbb{R}^3$), and an edge is depicted as a curve joining the endpoints.

A graph is called **simple** if it has no self-loops and there is at most one edge between any two pair of vertices. (Note: the "Königsberg" graph is not simple).

**insert image of a simple graph**

Graphs can be either **directed** or **undirected**.

* In a directed graph, each edge has a direction. This is usually formalized as each edge being an ordered pair $(a, b)$, where $a$ is the start vertex and $b$ is the terminal vertex.
* In an undirected graph, edges are bidirectional. That is, two vertices are either connected by an edge or they are not. As mentioned, this can be formalized using "unordered pairs" or ordered pairs. If we used ordered pairs to represent an undirected graph, we must insist that the edge relation is **symmetric**: that is, if $(a, b) \in E$, then $(b, a) \in E$.

**insert images of directed and undirected graphs**

Graphs can be **weighted** and/or **labeled**. We can label vertices and/or edges, and we can weight vertices and/or edges. Often this is done for path-finding algorithms, where the vertices are labeled by locations, and edges are weighted by the time (or distance) it would take to travel between those locations.

**insert image of graph with cities and distances**

Given a graph $G = (V, E)$, the **degree** of a vertex $v$ is the number of edges connected to $v$.

* If an undirected $G$ contains self-loops, we count that as two edges connected to $v$.
* If $G$ is a directed graph, we can define the **in-degree** and **out-degree** of $v$:
  * The **in-degree** of $v$ is the number of edges that point **toward** $v$.
  * The **out-degree** of $v$ is the number of edges that start at $v$.

The **degree-sequence** of a graph $G$ is a sequence of all degrees in non-decreasing order. For example:

**insert image of graph**

The degree sequence of this graph is $(1, 1, 2)$.

## Exercises

At least one of the following problems is impossible! Can you figure out which one?

1. Find an undirected graph whose degree sequence is $(1, 1, 2, 2)$.
2. Find an undirected graph whose degree sequence is $(1, 1, 1, 2)$.
3. Find an undirected graph whose degree sequence is  $(2, 2, 2, 2)$.
4. Find a simple undirected graph whose degree sequence is $(0, 1, 2, 3)$.

<details>
    <summary>Check your answers</summary>
    <p>The second one is impossible! Take the vertex of degree 2. It is connected to two other vertices, each has degree one. Then there is no room for a third vertex of degree one to be placed anywhere: it must be connected to <emph>some</emph> other vertex, but all the other vertices have been exhausted!</p>
    <p>The fourth one is also impossible. If our vertices have no self-loops, and one vertex has degree 3, it must be connected to three others. That would mean none of the vertices can have degree 0.</p>
    <p>Graph 1: <img class="noreverse" src="" alt="Graph depicting a straight path: a to b to c to d" /></p>
    <p>Graph 3: <img class="noreverse" src="" alt="Graph depicting a 4-element cycle: a to b to c to d back to a" /></p>
</details>

# Some Quick Theorems

One of the benefits of formalizing graphs as vertices and edges is that the combinatorics of graph theory is sometimes quite simple. For example, in the previous exercise, we saw that it was not possible for a graph to have exactly three vertices of degree one and one vertex of degree 2. We can actually see a more general property using a counting argument.

Take any graph $G = (V, E)$. What can we say about the degrees of all the vertices? If we count vertices, it's hard to say, but instead we can count edges. For each edge $e$, we see that it counts toward the degree of two vertices: each of its endpoints (or, if it's a self-loop, by definition it counts twice toward the degree of one vertex). That means each edge is counted *twice* when we add up all the degrees. Which gives us the following result:

**Theorem**: The sum of the degrees of a graph is equal to twice the number of edges.

This is a fairly innocent theorem, but it has some important consequences. First of all, that means that the sum of the degrees is even.

**Corollary**: For any graph $G = (V, E)$, there is an even number of vertices of odd degree.

**Proof**: Since the sum of the degree is even, we can really think of this as a question of adding numbers mod 2. If we add an odd number of odd numbers, we get an odd number. Adding any even number after that would keep it as an odd number. Therefore, there must be an even number of odd numbers in that sum.

## Eulerian Paths and Cycles

Before we tackle the Bridges of Königsberg problem, let's make a few more definitions:

**Definition**: Let $G = (V, E)$ be an undirected graph.

1. A **walk** in $G$ is a sequence of vertices $v_1, v_2, \ldots, v_n$ such that, for each $i < n$, the vertices $v_i$ and $v_{i+1}$ are adjacent (connected by an edge).

2. A **trail** is a walk in which no edge is repeated.

3. An **Eulerian path** is a walk in which every edge is used exactly once.

4. An **Eulerian circuit** or an **Eulerian tour** is an Eulerian path that starts and ends at the same vertex.

We now have enough information to explain Euler's proof that there is no solution to the Seven Bridges of Königsberg problem. Given a graph $G = (V, E)$, we ask: does this graph contain an Eulerian path? Does this graph contain an Eulerian circuit?

It turns out that these are questions that can be answered entirely by looking at the degree sequence of the graph. How would we use up all the edges at a particular vertex? Suppose that a vertex has degree 3. If we start at that vertex and take one of the edges, we have two more edges left to visit from that vertex. That means we have to return, which will will use one more edge, and leave it again, which will use the other edge. What if we didn't start at that vertex? If we take an edge in, we take one out, and then we still have one edge left to use. That means that we would need to *end* at that vertex!

We can generalize this. If a vertex has odd degree, we would need to either start or end at that vertex. This is because, besides the beginning or end of the walk, every time we enter a vertex through one edge, we would leave through another. That means visiting a vertex in the "middle" of the walk would use up an even number of its edges. If a vertex has odd degree, then, it has to use one edge to leave at the beginning of the walk, or it has to use one edge to return at the end of the walk.

**Theorem**: A graph $G = (V, E)$ has an Eulerian path if and only if it has exactly two vertices of odd degree.

In particular, any Eulerian path would start at one of the vertices that has odd degree, and end at the other.

What about Eulerian circuits? If we are starting and ending at the same vertex, then **every** vertex must have even degree. Do you see why? If every vertex has even degree, then there is an Eulerian circuit starting and ending at any vertex.

**Exercise**: Determine if this graph has an Eulerian path and/or an Eulerian circuit. If so, find one.

**insert image**

<details>
    <summary>Check your answer</summary>
    <p>Notice that the degree seqeunce of this graph is $(2, 2, 3, 3, 4)$. So this should have an Eulerian path!</p>
    <p>One Eulerian path is: A - B - C - D - E - C - A - E.</p>
</details>

## Non-theorem: Hamiltonian Cycles

# Special Graphs

## Complete Graphs

## Cycle Graphs

## Bipartite Graphs

## Subgraphs

# Exercises
