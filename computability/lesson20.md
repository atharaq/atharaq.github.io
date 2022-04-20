# Lesson 20: Introduction to Complexity
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

The SUBSET-SUM problem is defined as follows: given a set $S \subseteq \mathbb{Z}$ (integers, positive and negative), and $n \in \mathbb{Z}$, determine if there is a subset $X \subseteq S$ such that the sum of all the elements of $X$ is equal to $n$.

For example, given $S = \\{1, 4, 9, 16, 25 \\}$, and $n = 13$, the answer is yes, since $4 + 9 = 13$. Similarly:

* If $n = 29$, $4 + 9 + 16 = 29$.
* If $n = 0$? The empty set is a subset of $S$, so yes!
* If $n = 2$? No!

1. Given $S = \\{1, 2, 4 \\}$, find all $n$ such that there is $X \subseteq S$ whose sum is $n$.
2. Devise an algorithm that determines if, given $S$ and $n$, there is $X \subseteq S$ whose sum is $n$.

"On input $(S, n)$,..."

What's the running time of your algorithm?

# Complexity

Reading: Sipser 7.1, 7.2; MS 6.1, 6.2

The goal of complexity theory is to attempt to classify problems by how hard they are to solve. In other words, all of these problems are decidable, but some are "harder" than others in terms of how efficiently an algorithm can solve them.

## Graph Isomorphisms

A **graph** is given by a set of vertices $V$ and a set of edges $E \subseteq V \times V$ (the edges are ordered pairs). Graphs can be *directed* or *undirected*; if a graph is *undirected*, then if there is an edge from $v$ to $w$, we also have an edge from $w$ to $v$ (ie, the edge relation is symmetric). Two graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$ are called **isomorphic** if there is a bijection $f : V_1 \to V_2$ such athat for all vertices $v, w \in V_1$, there is an edge $(v, w) \in E_1$ if and only if there is an edge $(f(v), f(w)) \in E_2$.

<img class="noreverse" src="graph.jpeg" />

Claim: the function $f$ which maps:

* $1 \mapsto a$
* $2 \mapsto b$
* $3 \mapsto c$
* $4 \mapsto d$

is an isomorphism.

**Claim**: The graph isomorphism problem is decidable!

On input $G_1 = (V_1, E_1), G_2 = (V_2, E_2)$:

1. Check if $\|V_1\| = \|V_2\|$. If not, reject.
2. Repeat for each function $f : V_1 \to V_2$:
   * Check if $f$ is a bijection.
   * Check if $f$ satisfies $\forall v_i \forall v_j (v_i, v_j) \in E_1 \leftrightarrow (f(v_i), f(v_j)) \in E_2$. (There are only finitely many pairs if the graph is finite, so this is okay.)
   * If it does, halt and **accept**.
3. If we get through all the steps of 2 without accepting, **reject**.

This is a "brute force" algorithm. But it does decide the isomorphism problem.

**Question**: How many *steps* does this take? Suppose $\|V_1\| = \|V_2\| = n$. How many functions are there from $V_1$ to $V_2$?

* If $n = 2$: $\\{0, 1 \\} \to \\{0, 1 \\}$?
  * 2 choices for $f(0)$.
  * 2 choices for $f(1)$.
  * $2 \times 2 = 4$.
* $n = 3$: $\\{0, 1, 2 \\} \to \\{0, 1, 2 \\}$?
  * 3 choices for $f(0)$
  * 3 choices for $f(1)$
  * 3 choices for $f(2)$
  * $3 \times 3 \times 3 = 27$
* In general?
  * $n$ choices for $f(0)$
  * $n$ choices for $f(1)$
  * $\vdots$
  * $n$ choices for $f(n - 1)$
  * $n \times n \times \ldots n = n^n$

So that second step repeats $n^n$ times! There is an obvious improvement: instead of looking at all functions, just look at all the bijections. How many of those are there?

* If $n = 2$:
  * 2 choices for $f(0)$
  * 1 choices for $f(1)$ (since it's one-to-one)
  * $2 \times 1 = 2$
* $n = 3$:
  * 3 choices for $f(0)$
  * 2 choices for $f(1)$
  * 1 choices for $f(2)$
  * $3 \times 2 \times 1 = 6$
* $n = 4$:
  * 4 choices for $f(0)$
  * 3 choices for $f(1)$
  * 2 choices for $f(2)$
  * 1 choices for $f(3)$
  * $4 \times 3 \times 2 \times 1 = 4!$

In general, the number of bijections between two sets of size $n$ is $n!$

So to analyze the number of steps:

"For each bijection ($n!)$:
  * For each pair $(v_1, v_2)$ (how many? about $n^2$)
  * Check if $(v_1, v_2) \in E_1$ if and only if $(f(v_1), f(v_2)) \in E_2$"

That is, this takes about $n^2 \cdot n!$ steps.

## Time complexity

Let $M$ be a deterministic, 1-tape TM. (We will talk about other models soon.) The **running time** of $M$ is the function $f: \mathbb{N} \to \mathbb{N}$ such that $f(n)$ is the maximum nubmer of steps $M$ takes to accept or reject any input of length $n$.

Here, by "steps", we mean the number of configurations $M$ enters in its computation on the input. This of course only makes sense for deciders: if $M$ loops forever on some input of size $n$, then $f(n)$ would not be defined.

This gives us a notion of the running time of a machine, but we really want to talk about *problems*, rather than machines. We really want to define the running time of a language $\mathcal{L}$ to be the "smallest" running time of any TM $M$ which decides $\mathcal{L}$. Of course, this begs the question of how do we compare functions? When is one function "smaller" than another? We use "Big Oh" notation.

## Comparing Functions

**Definition**: Let $f, g : \mathbb{N} \to \mathbb{R}^{\geq 0}$. We say $f(n) = O(g(n))$ if there are $c, N \in \mathbb{N}$ such that for all $n \geq N$, $f(n) \leq c g(n)$. We say $f$ is "Big Oh" of $g$.

The idea is that $\frac{f}{g}$ is eventually boudned by a constant.

In practice, coefficients don't matter, and only the highest order term mattesr. So some examples:

* $5n^4 - 300n^2 = O(n^4)$
* $37 \log_{10}(n) = O(\log_{10}(n)) = O(\log_2(n)) = O(\ln(n))$, We just call all of these $O(\log n)$.

This is a strange notation as it's not symmetric. So technically $n^2 = O(n^3)$, but $n^3 \neq O(n^2)$. There is also a notion called "little oh"; I won't get into that here.

According to Big Oh:

* $O(\sqrt{n}) < O(n) < O(n^2) < O(n^3) < \ldots$
* Moreover, these are all less than $O(2^n) < O(n!) < O(n^n)$.
* Where does $O(\log n)$ sit? $O(\log n) < O(n^\varepsilon)$ for every $\varepsilon > 0$.
* $O(n \log n)$ sits between $O(n)$ and $O(n^2)$.

So there are lots of functions "in between" any two functions in this "Big Oh" ordering.

## Back to time complexity

**Definition**: Let $t : \mathbb{N} \to \mathbb{N}$ e any function. Then $TIME(t(n))$ is the collection of all languages which are decidable by a TM whose running time is $O(t(n))$.

**Definition**: The complexity class $P$ is defined as $P = \bigcup \limits_{k \in \mathbb{N}} TIME(n^k)$. This is the collection of all *polynomial-time* decidable problems.

## Example

Consider the problem $UNIQUE = \\{ L : L$ is a list of numbers without any duplicates $\\}$.

**Claim**: $UNIQUE \in P$. Why? What's the algorithm?

(Naively, there's an $O(n^2)$ algorithm. Using a hashtable / Set data structure, there's an $O(n)$ algorithm).

# Complexity Relationships between models

**Theorem**: Suppose a multitape TM $M$ has running time $t(n)$. Then there is an equivalent single tape TM whose running time is $O((t(n))^2)$.

The idea is really to just examine the proof that every multitape TM has an equivalent single-tape TM.

Suppose $M$ has $k$ tapes. Each tape has, at most, $O(t(n))$ cells that are actually used during the computation (otherwise, we wouldn't be able to even reach those). Convert this to a single tape TM $S$. The tape contents would then have length $k \times O(t(n))$, which is still $O(t(n))$ (constants don't matter).

(picture)

Recall that the algorithm for $S$ works by scanning the entire tape twice and updating the contents appropriately. So each step of $M$ corresponds to $2 \times O(t(n)) = O(t(n))$ steps for $S$.  That is:

* 1 step for $M$ is $O(t(n))$ steps for $S$
* $\vdots$
* $O(t(n))$ steps for $M$ is $O(t(n)) \times O(t(n)) = O((t(n))^2)$ steps for $S$

(We have to add one more $O(n)$ step at the beginning to get the input in the right form.) So running $S$ takes $O(n) + O((t(n))^2) = O((t(n))^2)$ steps.

**Corollary**: If a problem can be decided by a $k$-tape TM in polynomial time, then it is in $P$.

## Non-determinism

Next time we will talk about **non-deterministic** running times.

**Definition**: Let $N$ be an NTM. Its **running time** $f: \mathbb{N} \to \mathbb{N}$ is the function such that, for any input of size $n$, **every** branch of its computation tree halts in at most $f(n)$ steps.

**Definition**:

1. $NTIME(t(n))$ is the class of languages which can be decided by an NTM whose running time is $O(t(n))$.
2. $NP = \bigcup\limits_{k \in \mathbb{N}} NTIME(n^k)$

The Millenium Prize problem that we've mentioned a few times is the classic question of whether $P = NP$. We've seen that adding multiple tapes does not change the complexity class $P$; does adding non-determinism change this class?

**Example**: The graph isomorphism problem is in $NP$!

"On input $G_1 = (V_1, E_1), G_2 = (V_2, E_2)$:
1. Non-deterministically guess a function $f: V_1 \to V_2$.
2. For each $v_1, v_2 \in V_1$:
   * Check if $(v_1, v_2) \in E_1$ if and only if $(f(v_1), f(v_2)) \in E_2$.
   * If not, **reject**. If it is, continue on to the next pair.
3. If we never rejected on this branch after checking all pairs, **accept**."

**Exercise**:

1. Why does this non-deterministic algorithm work?
2. What's the non-deterministic running time of this?

# Problem Set 4

On Moodle now, due **next Thursday**.
