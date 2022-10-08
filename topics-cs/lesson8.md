# Topics in Advanced Computing Lesson 8: co-NP, EXP, NEXP
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up: CLIQUE

Given a graph $G$ and a number $k$, a $k$-clique is a subset of vertices of size $k$ which are all connected to one another. For example the following graph has a 3-clique:

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/6n-graf-clique.svg/2560px-6n-graf-clique.svg.png" alt="Graph with vertices 1-6, with edges (1, 2), (2, 3), (3, 4), (4, 5), (4, 6), and (1, 5)" />

The problem $CLIQUE$ is, given a graph $G$ and a number $k$, determine if $G$ contains a $k$-clique.

**Theorem**: $CLIQUE \in NP$.

**Exercise**: Prove this theorem.

1. What is the "certificate"?
2. What's the verifier algorithm?
3. What's the running time of your algorithm?

# SAT vs IPROG

Recall that we have already seen that $SAT \leq_P IPROG$. This means that if the integer programming problem has a polynomial time solution, then $SAT$ does as well. Therefore, if $IPROG \in P$, then $P = NP$, and so $IPROG$ is also NP-complete!

# CLIQUE is NP-Complete

The problem **3-SAT** is similar to SAT but all the clauses for the input formula are required to have at most 3 literals in them. 3-SAT is known to be NP-complete as there is a simple algorithm which reduces SAT to 3-SAT. We will not go over this now.

**Theorem**: $3-SAT \leq_P CLIQUE$.

**Proof**:

Suppose $\phi(p_1, \ldots, p_n)$ is a formula with $n$ variables and $m$ clauses. We build a graph $G$ with $m$ groups of triples (three vertices); the triples correspond to the clauses of $\phi$. For example, if we have a clause $p_1 \vee p_1 \vee \lnot p_2$, we put three nodes labeled $p_1$, $p_1$ and $\lnot p_2$ in our graph.

We put edges between all vertices except if they are in the same triple (if they correspond to two literals from the same clause), or if they are contradictory (if one corresponds to $p$ and one to $\lnot p$, for some variable $p$).

For example, if we start with the formula
$$
\begin{align}
(p_1 \vee p_2 \vee \lnot p_3) \wedge (\lnot p_1 \vee \lnot p_2 \vee \lnot p_3) \\
\wedge (p_1 \vee p_1 \vee \lnot p_2),
\end{align}
$$ we get a graph with 9 vertices (3 triples). A satisfying assignment for $\phi$ would correspond to a 3-clique in this graph.

<img class="noreverse" src="images/reduction.jpeg" alt="Example of a formula and the corresponding graph" />

**Claim**: $\phi$ is satisfiable if and only if $G$ has an $m$-clique.

# co-NP

# NEXP

# Problem Set 2

**Due Thursday, October 20**.

1. Show that $\leq_P$ is *transitive*: that is, suppose $A \leq_P B$ and $B \leq_P C$ (that is, that $A$ is polynomial-time reducible to $B$, and $B$ is polynomial-time reducible to $C$). Show that $A \leq_P C$.
2. Suppose $A$ is NP-complete and $A \leq_P B$. Explain why this means that $B$ is NP-complete. (Hint: Use question 1.)
3. Assume that $P \neq NP$ for this problem. Suppose $A$ is NP-complete. If $B \leq_P A$, is $B$ necessarily NP-complete?
4. Show that $SAT \in NP$ by giving a verifier algorithm for SAT. Make sure to explain the following:
   * What is the certificate?
   * What is your verifier algorithm?
   * Why does your verifier run in polynomial time (in terms of the length of your input)?
