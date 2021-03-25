# Data Structures Lesson 15: (Shortest) Path Algorithms
{:.no_toc}

1. Table of Contents
{:toc}

# PageRank

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/yt3Djohnxfs" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Last time, we discussed the PageRank algorithm. Imagine a simplified Internet with just 4 webpages.

* Page 1 has links to pages 2, 3, and 4
* Page 2 has a link to page 4
* Page 3 has links to pages 1 and 4
* Page 4 has links to pages 1 and 3

Suppose that a user clicks links randomly, with equal likelihood. We can represent this situation with the following matrix $A$:

$$
\begin{pmatrix}
0 & 0 & .5 & .5 \\
1/3 & 0 & 0 & 0 \\
1/3 & 0 & 0 & .5 \\
1/3 & 1 & .5 & 0
\end{pmatrix}
$$

The idea is the $(i, j)$ entry in the matrix tells you the probability that, if you are on page $i$, you end up on page $j$. Let $(p_1, p_2, p_3, p_4)$ be the probabilities that a user is on pages 1, 2, 3, and 4, respectively. So for example, if a user was equally likely to be on any one of these four websites, we would represent this as $(.25, .25, .25, .25)$. Then, using standard matrix multiplication, if $\bar{v}$ is this vector of probabilities, then $A\bar{v}$ gives the probability that they end up on each page after clicking one link. (I won't go through the details of this.)

The idea of PageRank, then, is to consider the limit. If one starts out on a random page and clicks links $n$ times, as $n \rightarrow \infty$, what is the likelihood that they end up on any one of these pages? That is, what is $A^n \bar{v}$?

This appears to be a challenging question: except for the fact that we can use well-known techniques from linear algebra. If you know about diagonalizing matrices, you can diagonalize this matrix and find its eigenvalues and eigenvectors. You end up with an eigenvalue $\lambda = 1$ (and other eigenvalues of smaller size), with a corresponding eigenvector of $(.3, .1, .2\bar{6}, .\bar{3})$. The values of this eigenvector correspond to the relative probabilities of landing on each page in the limit: page 4 has the highest "rank", then page 1, page 3, and last comes page 2.

# Shortest Path

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/Wf9K54AUVh0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**Problem**: Given a graph $G = (V, E)$, and a starting vertex $s$, find the shortest path from $s$ to every node in the graph.

This is the single-source shortest path problem. The solution, if the graph is unweighted, is just **breadth-first search**. Here is some pseudocode:

```
Queue<Vertex> q;
setAllDistancesToInfinity()
s.dist = 0
q.enqueue(s)
while (!q.isEmpty()) {
  Vertex v = q.dequeue()
  v.visited = true
  for (Vertex w : v.getAdjacentVertices()) {
    if (!w.visited) {
      if (v.dist + 1 < w.dist) {
        w.dist = v.dist + 1
        w.parent = v
        q.enqueue(w)
      }
    }
  }
}
```

There are some small modifications here we need to make, because a vertex w might be reached in several ways. Still, though, this should look roughly familiar to you.

What do we do if the graph is weighted, though?

## Dijkstra's Algorithm

(picture)

In case the graph is weighted, we use **Dijkstra's algorithm**. [Edsger Dijkstra](https://en.wikipedia.org/wiki/Edsger_W._Dijkstra) is a renowned computer scientist who is perhaps most famous for his article "Go To Statement Considered Harmful". This launched a series of responses, which one might assume is 1980s Computer Scientist's version of memes: "'GOTO Considered Harmful' Considered Harmful", and "'"GOTO Considered Harmful" Considered Harmful' Considered Harmful?". (Dijsktra chimed in later with "On a Somewhat Disappointing Correspondence.")

More to the point: Dijkstra's algorithm uses a similar algorithm to breadth-first-search, except it's "shortest" first. That means we use a **priority queue** instead of a regular queue! Pseudocode:

```
markAllNodesAsUnvisited()
initializeDistances()
pq.insert(s)
while (!pq.isEmpty()) {
  Vertex v = pq.deleteMin()
  v.visited = true
  for (Vetex w : v.getAdjacentVertices()) {
    if (!w.visited) {
      if (v.dist + weight(v, w) < w.dist) {
        w.dist = v.dist + weight(v, w)
        w.parent = v
        pq.insert(w)
      }
    }
  }
}
```

Notice that we may end up inserting a vertex multiple times in this algorithm. But at the end, the distances and parents will be correct.

Also note that this is, of course, pseudocode. Instead of `v.visited = true`, we might have something like `visited.add(v)`, where `visited` is some kind of `Set` object. Similarly, we might have a `parent` map and a `distance` map. But hopefully this gives you the right idea.

## decrease-key?

This is not covered in my video above, but I wanted to describe one way to solve the issue of not "re-inserting" a vertex into the priority queue multiple times.

Instead of the pseudocode above:

```
if (v.dist + weight(v, w) < w.dist) {
  w.dist = v.dist + weight(v, w)
  w.parent = v
  pq.insert(w)
}
```

We might check if $w$ is in the priority queue in the first place, and if it is, just change its priority.

So this gives us a new problem (about heaps / priority queues) to solve: given a vertex $w$ and a priority queue $pq$, if we can modify the priority of $w$, how do we fix its position in the queue?

Before answering this, a more fundamental questin: how do we even find the vertex in the priority queue? Our previous implementation of heaps would require a simple linear search, since there's no way of going from a vertex to its position in the heap. How can we improve this?

# Edit Distance

Given a word $w$, an **edit** is a one-character modification, where we replace one letter, add a single letter (anywhere in the word), or remove a single letter. For example, some valid edits of the word "hire" are "hive", "hires" and "ire".

**Problem**: Given a dictionary (as a list of words), and two words, compute the **edit distance** between those two words. That is, the number of edits needed to go from word 1 to word 2, such that *all intermediate words are words in the dictionary*.

Brainstorm the algorithm for this problem. Can you see this problem as a graph theory / shortest path problem?

# Probability Exercise

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/geWuKT6LQCo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Suppose we have a directed graph with $N$ nodes. Between any two nodes $i$ and $j$, if $i \neq j$, there is some fixed probability $p$ that there is an edge between $i$ and $j$. What is the probability that there is a path from $0$ to $N - 1$?

* If $N = 2$, then the probability is just $p$.
* If $N = 3$, the probability is $p + (1-p)p^2$. (the probability that there is an edge from $0$ to $2$, plus the probability that there is no edge from $0$ to 2, but there is an edge from $0$ to 1, and an edge from $1$ to $2$)
* If $N = 4$, the formula gets very complicated, very quickly.

Instead of computing this mathematically, let's try to write a simulation.

Download the RandomGraph class on Moodle and implement the `hasAPath` method. Play around with different values of $p$ and $size$, and check if your implementation works correctly by calling printGraph (and checking by hand if there is a path). Then implement the simulate method and play around with $size$ and $prob$:

* If $p = 0.5$, for what values of $size$ will the probability of a path be at least $90\%$?
* If $p = 0.25$, same question.
* If $p = 0.001$, for what values of $size$ will the probability of a path be at least $50\%$?
