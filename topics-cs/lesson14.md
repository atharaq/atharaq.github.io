# Topics in Advanced Computing Lesson 14: Oracles and the Polynomial Hierarchy
{:.no_toc}

1. Table of Contents
{:toc}

# Oracles

We already have one way of when a problem is "easier than" another: namely $\leq_P$, polynomial-time reductions. There is another concept from computability theory that captures a similar notion: oracles.

An **oracle** for a problem $X$ is a function which, on input $x$, returns 1 if $x \in X$ and 0 otherwise. We ignore the computational complexity of an oracle: just treat it like a black box, or pretend that it takes only one step to make that function call. An **oracle machine** is a Turing Machine which is augmented by an oracle. That is, at any given step, it could ask if the string on its tape is in the problem for which it has an oracle.

**Example**: If we have an oracle for $SAT$, then we can solve $TAUT$ in polynomial-time. To see this, suppose $\phi$ is a formula. Then $\phi$ is a tautology if and only if $\lnot \phi$ is not satisfiable. So first check if $\lnot \phi \in SAT$: if it is, output FALSE, if not, output TRUE!

**Definition**: The class $P^{NP}$ is the class of all those problems which are solvable in polynomial-time with an oracle for some NP-complete problem (for example, for SAT). More generally, if $A$ is any class, then:

* $P^A$ is the class of those problems solvable in polynomial time with an oracle for some $A$-complete problem,
* $NP^A$ is the class of those problems solvable in non-deterministic polynomial time with an oracle for some $A$-complete problem, and
* co-$NP^A$ is the class of those problems whose complements are in $NP^A$.

The example shows that $P^{NP}$ contains the class co-NP, since TAUT is co-NP-complete. It's also clear that $P^{NP}$ contains both $P$ and $NP$. It's an open question whether this class is simply equal to just P or to NP: the conjecture is that it is different. But moreover, we can use oracles to build a kind of hierarchy of complexity classes in exactly this way.

**Definition** (Polynomial Time Hierarchy) Set $\Sigma^P_0 = \Pi^P_0 = \Delta^P_0 = P$. This is the base class of the hierarchy. Then, for each $i \geq 0$:

* $\Sigma^P_{i+1} = NP^{\Sigma^P_i}$,
* $\Pi^P_{i+1}$ = co-$NP^{\Sigma^P_i}$, and,
* $\Delta^P_{i+1} = P^{\Sigma^P_i}$.

Notice that $\Sigma^P_1 = NP$ and $\Pi^P_1 =$ co-NP. We have the following inclusions:

<img src="https://upload.wikimedia.org/wikipedia/commons/9/9e/Polynomial_time_hierarchy.svg" alt="Image depicting the inclusions in the polynomial time hierarchy." />

In particular, we have $\Sigma^P_i \subseteq \Delta^P_{i+1} \subseteq \Sigma^P_{i+1}$, and $\Pi^P_i \subseteq \Delta^P_{i+1} \subseteq \Pi^P_{i+1}$ for each $i$.

**Open question**: Is there a level $k$ such that $\Sigma^P_k = \Sigma^P_{k+1}$? In particular, is there a level $k$ so that the entire polynomial hierarchy is contained in $\Sigma^P_k$?

(The conjecture is that there is no such level, that there are always "harder" problems each level up.)

## Example Problem

Recall the "Independent Set" problem: given a graph $G$ and a number $k$, is there a subset $S$ of the vertices of $G$ of size at least $k$ such that no two vertices in $S$ share an edge? This problem is NP-complete, as we discussed earlier in the semester.

If we change the question very subtly, we can ask what the largest independent set in a graph is. This appears to be a very natural computational problem. Suppose, for example, that your graph $G$ is a graph of people and there are edges between people if they know each other / are connected on social media. One might ask: "If I throw a party for 30 people, how many people won't know anyone there besides me?" In other words: compute the largest nubmer $k$ such that there is an independent set of size $k$ in this graph.

This problem has complexity $\Delta^P_2$! Let's put this more precisely: given, as input, a graph $G$ and a number $k$, determine if the largest independent set of vertices in $G$ has size exactly $k$.

**Claim**: The EXACT-IND-SET problem can be solved in polynomial time using an oracle for IND-SET. How?

"On input $\langle G, k \rangle$:... (what should we do?)"

Therefore EXACT-IND-SET $\in \Delta^P_2$, since it's in $P^{NP}$ (because IND-SET is NP-complete).

# Logical Definition

There are several other ways to think about these complexity classes. Instead of using oracles, we can talk about certificates.

In the following definition, by $\\{0, 1 \\}^{q(n)}$ we mean a binary sequence of length $q(n)$.

**Definition**: A problem $X$ is in $\Sigma^P_2$ if there is a polynomial time machine $M$ and a polynomial function $q$ such that for each $x$ of length $n$, $x \in X$ if and only if $$\exists u_1 \in \{0, 1 \}^{q(n)} \forall u_2 \in \{ 0, 1 \}^{q(n)} M(x, u_1, u_2) = 1.$$

Similarly, a problem $X$ is in $\Pi^P_2$ if there is a polynomial time $M$ and a polynomial function $q$ such that for each $x$ of length $n$, $x \in X$ if and only if $$\forall u_1 \in \{0, 1 \}^{q(n)} \exists u_2 \in \{ 0, 1 \}^{q(n)} M(x, u_1, u_2) = 1.$$

**Question**: What do you think a natural definition of $\Sigma^P_3$ would be?

**Claim**: This defines the same class of problems as the oracle definition! In particular, $NP^{NP} = \Sigma^P_2$ according to both definitions.

Before we do this, let's notice that the analogue at level $\Sigma^P_1 = NP$ works.

**Proof**: Let $X \in NP$ and $V$ a verifier for $X$ running in polynomial time $q(n)$. Then for each $x$ of length $n$, we have $x \in X$ if and only if there is $y$ of length at most $q(n)$ such that $V(x, y) = 1$. In other words: $\exists y \in \\{ 0, 1 \\}^{q(n)} V(x, y) = 1$. But this is exactly the corresponding definition of $\Sigma^P_1$!

Similarly, suppose there is a machine $M$ and a polynomial $q(n)$ such that the problem $X$ is defined by $x \in X$ if and only if $\exists y \in \\{0, 1 \\}^{q(n)} M(x, y) = 1$. Then $M$ is a verifier for $X$ running in polynomial time!

**Theorem**: $NP^{NP} = \Sigma^P_2$.

**Proof**: Suppose $X \in \Sigma^P_2$ according to this quantifier definition. Let $M$ be the polynomial time machine and $q$ the function mentioned in the definition. So then: for each $x$, if $x \in X$, then there is $u_1$ such that for all $u_2$ (of the appropriate length), $M(x, u_1, u_2) = 1$.

Let $Y$ be the problem whose inputs are ordered pairs $(x, y)$, such that $(x, y) \in Y$ if and only if for every $u_2$, $M(x, y, u_2) = 1$. Then $Y \in \mathrm{co-NP}$. In particular, $\bar{Y} \in \mathrm{NP}$. Let $A$ be any NP-complete problem. Notice that if we have an oracle for $A$, then we can solve $\bar{Y}$, and therefore we can solve $Y$. (Think about this!)

Then I claim we can build a polynomial time *verifier* for $X$ using an oracle for $A$ (really just an oracle for $Y$ is needed):

"On input $x$ with certificate $c$:

1. Ask $A$ if $(x, c) \in Y$.
  * If so, output 1.
  * If not, output 0."

# Upcoming

* Paper due Thursday (3-5 pages)
* PS 3 will be given out Thursday, due next week (11/17).
* Guest speaker 11/21.
* Presentation 3 will be after Thanksgiving
* PS 4 and Final Paper due last week of classes / finals week.
