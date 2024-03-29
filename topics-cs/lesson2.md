# Topics in Advanced Computing Lesson 2: Big Oh
{:.no_toc}

1. Table of Contents
{:toc}

# Graph Theory Problem

**Exercise**: Given a graph $G$ with vertices $V$ and edges $E$, determine if $G$ has a cycle (of any length).

1. How do we represent $G$?
2. Can you come up with an algorithm that checkes if $G$ has a cycle?
3. What is the running time of your algorithm?

## Representations of graphs

As mentioned last time, a **graph** consists of a set of vertices and edges. So we need to represent these two sets. The vertices are usually referred to as integers $0$ through $N - 1$, where $N$ is the number of vertices in the graph. For the edges, there are several options for representing them, but the two main ways are:

* **Adjacency lists**: For each vertex in the graph, keep track of a list of the vertices that it shares an edge with. That is, we have to keep track of $N$ lists (each list could be an array, ArrayList, LinkedList, or some other list structure available in your favorite programming language).
* **Adjacency matrix**: Keep track of an $N \times N$ matrix of $0$s and $1$s (a boolean matrix). If there is an edge between vertex $i$ and vertex $j$, put **true** (or $1$) in $matrix[i][j]$. Otherwise put **false** in that position.

**Example**:

Consider the following graph:

<img class="noreverse" src="images/star_graph.png" alt="Graph with vertices v1, v2, v3, v4. v1 is connected to v2, v3 is connected to v2, and v4 is connected to v2. There are no other edges." />

**Adjacency list**:

* $v_1$: $v_2$
* $v_2$: $v_1, v_3, v_4$
* $v_3$: $v_2$
* $v_4$: $v_3$

**Adjacency matrix**:

$$
\begin{array}{c|c|c|c|c}
& v_1 & v_2 & v_3 & v_4 \\
\hline
v_1 & 0 & 1 & 0 & 0 \\
v_2 & 1 & 0 & 1 & 1 \\
v_3 & 0 & 1 & 0 & 0 \\
v_4 & 0 & 1 & 0 & 0
\end{array}
$$

## Solution

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/DuefiU9X6MQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

At the very end of class, we started thinking about this problem. One way to look for a cycle is to just start going through the graph and see if we end up hitting a cycle. When we try to specify our algorithm, the main issue we run into right away is determining how to pick the next vertex to check. One can use either a **breadth-first** or a **depth-first** strategy to pick vertices in this case.

* **Breadth-first**: after visiting a vertex, visit all of its neighbors first.
* **Depth-first**: after visiting a vertex, go down *one path* as far as you can first.

There are times when you would prefer one over the other. In this case, there are valid solutions using both of these strategies, but we will describe the **depth-first** solution. The idea is to keep track of which nodes we have visited.

* Start at some node, and mark it as visited.
* Pick a neighbor. If we've seen it before, then we've hit a cycle, so return true!
* If we haven't seen it before, recursively "visit" it and continue.

```
function check-for-cycle() {
  // initialize visited array
  for (int i = 0; i < N; i++) {
    if (!visited[i]) {
      if (depth-first(i, visited, -1)) {
        return true
      }
    }
  }
  return false
}

function depth-first(int vertex, boolean[] visited, int parent) {
  // mark vertex as visited
  visited[vertex] = true

  // for each of its neighbors:
  for (int next : adjacencyList[vertex]) {
    if (!visited[next]) {
      // if you have not visited next yet,
      // run DFS on it.
      // if it finds a cycle, return true
      if (depth-first(next, visited, vertex)) {
        return true
      }
    } else if (next != parent) {
      // if we visited it already
      // and it's not our parent node
      // then we found a cycle!
      return true
    }
  }
  // if we never find a cycle:
  return false
}
```

**Exercise**: Determine the running time here, supposing that the graph has $N$ vertices. (It may have up to $O(N^2)$ edges.)

# Big Oh Activity

Before reading the rest of these notes, please go through this [interactive activity on Desmos](https://student.desmos.com/join/xtnw5e). Please use your **real name** for **attendance purposes**, though I can/will make all responses anonymous.

# Big Oh

The following video is from my Fall 2020 Discrete Mathematics course in which I gave a lesson on Big Oh notation. In this video, I use notation from logic that was developed in that course. So if you see $\forall n \in \mathbb{N}$, that means "For all natural nubmers $n$...", and if you see "$\exists N \in \mathbb{N}$", that means "There is a natural number $N$..."

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/hm3zxd8s254" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

* Complete the Desmos activity for classwork / attendance purposes for today. I will check this before our next class.
* Pick a topic / email it to me by **Friday, September 9**.
* Read sections 1.2 - 1.5 from the textbook (mentioned last time).
