# Lesson 23: Decision / Search
{:.no_toc}

1. Table of Contents
{:toc}

# Presentations

# PS5 questions?

# Final Projects

* Topics!

# Polynomial Reducibility

**Definition**: Let $A$ and $B$ be languages. We say $A \leq_p B$, or "$A$ is polynomial-time m-reducible to $B$", or more simply, "$A$ is polynomially reducible to $B$", if there is a polynomial time computable function $f: \Sigma^\* \to \Sigma^\*$ such that for all $w$, $w \in A$ if and only if $f(w) \in B$. $f$ is called the **polynomial-time reduction** of $A$ to $B$.

**Theorem**: Suppose $B \in P$ and $A \leq_p B$. Then $A \in P$.

**Exercise**: Explain why. What's the algorithm for deciding $A$ in polynomial time?

**Definition**: $L$ is **NP-complete** if $L \in NP$ and for all $A \in NP$, $A \leq_p L$.

These are, roughly, the "hardest" problems in NP. So the idea to solve P = NP would be to either:

* Find an NP-complete $L \in NP$ and design a polynomial-time algorithm for it, or,
* Find an NP-complete $L \in NP$ and show that there is **no** polynomial time algorithm for it.

Which begs the question: are there *any* NP-complete languages? The answer is yes! Many!

## SAT

A propositional variable is, basically, a boolean variable (true or false). Given a formula in propositional logic (so just with some propositional variables $p_1, p_2, \ldots$, conjunctions, disjunctions, and negations), a **satisfying assignment** is an assignment of true or false to each variable such that the entire formula is made to be true.

For example, the formula $(p_1 \vee \bar{p_2}) \wedge (\bar{p_3} \vee \bar{p_1})$ is satisfied by:

* $p_1 = T$
* $p_2 = T$ or $F$ (doesn't matter)
* $p_3 = F$

The $\bar{p}$ means "not $p$", or "$p$ is false" above.

The problem $SAT$ is the question: given a formula $\phi(p_1, \ldots, p_k)$ (so $\phi$ has $k$ propositional variables) determine if $\phi$ has a satisfying assignment.

**Claim**: $SAT \in NP$.

The idea is that, given the formula $\phi(p_1, \ldots, p_k)$, let the certificate $c$ be the satisfying assignment (if it has one). That is, $c$ would be a sequence of T/F of length $k$. How would you verify that it is, in fact, a satisfying assignment?

**Exercise**: Let $\phi(p_1, p_2, p_3, p_4) = (p_1 \vee \bar{p_2}) \wedge (\bar{p_1} \vee \bar{p_3} \vee p_4) \wedge (p_2 \vee p_3 \vee \bar{p_4})$. Determine if the assigment $p_1 = T$, $p_2 = T$, $p_3 = F$, $p_4 = T$ is a satisfying assignment.

More generally, one might verify if an assignment is a satisfying one by turning the propositional formula into some kind of binary tree, plugging in the true / false at the leaves and then checking. The running time of this would be the running time of reading through the entire tree, which would polynomial in the size of the formula.

This was the first problem that was shown to be NP-complete! This was shown, independently, by Stephen Cook (1971) and Leonid Levin (1973), so this is called the [Cook-Levin Theorem](https://en.wikipedia.org/wiki/Cook%E2%80%93Levin_theorem). The Wikipedia page does a nice job explaining how they show this: how do you show that *any* problem $A \in NP$ can be reduced to SAT?

* First suppose that there is an NTM $N$ that decides $A$.
* Given an input $w$, you build a formula $\phi$, so that $N$ accepts $w$ if and only if $\phi$ has a satisfying assignment.
* You need to do this in such a way that it takes a polynomial number of steps to build $\phi$.

The idea was quite brilliant: the formula $\phi$ has to encode information about the NTM $N$ itself so that $\phi$ is satisfiable if and only if $N$ accepts $w$. (You can see the details on Wikipedia, but it's not particularly easy to parse.)

# Other NP-complete problems

## 3-SAT

A formuala is **3-cnf** (3-conjunctive normal form) if it is a conjunction fo clauses of the form $(a \vee b \vee c)$, where $a, b, c$ are either variables or their negations.

Ex: $(p_1 \vee \overline{p_2} \vee p_3) \wedge (\overline{p_1} \vee p_2 \vee p_4) \wedge (p_1 \vee \overline{p_2} \vee \overline{p_4})$.

The 3-SAT problem asks: given a formula $\phi(x_1, \ldots, x_k)$ in 3-cnf, determine if it is satisfiable.

**Theorem**: $SAT \leq_p 3$-$SAT$!

Idea: take a formula $\phi$ and turn it into an equivalent formula $\psi$ in 3-cnf.

(We should also show that 3-$SAT \in NP$. Ideas?)

The theorem (along with showing that it's in NP) shows that 3-SAT is NP-complete.

## SUBSET-SUM

Given $S = \\{ x_1, \ldots, x_k \\}$ and $t$, determine if there is $X \subseteq S$ such that $\sum_{x \in X} x = t$.

1. SUBSET-SUM $\in NP$. (Ideas?)
2. $3$-SAT $\leq_p SUBSET$-$SUM$.

## HAM

Let $G = (V, E)$. We saw last time: a **Hamiltonian path** is a path through G touching each vertex exactly once. A **Hamiltonian cycle** is a path through G starting and ending at the same vertex, touching each **vertex** exactly once.

$HAM = \\{ \langle G \rangle : G$ has a Hamiltonian cycle $ \\}$.

HAM is NP-complete!

## CLIQUE

$CLIQUE = \\{ \langle G, k \rangle : G$ is a graph that has a $k$-clique $\\}$.

A $k$-clique is a set $C \subseteq V$ of vertices such that $\|C\| = k$ and all vertices in $C$ have edges between them.

* Show that $CLIQUE$ has a poly-time verifier.
* Exercise: $3$-$CLIQUE \in P$.
* CLIQUE is NP-complete (there is a poly-time reduction from 3-SAT)!

# Decision vs Search problems

* Decision problem: given $\langle G, k \rangle$, determine if $G$ has a $k$-clique.
* Search problem: given $\langle G, k \rangle$, *find* a subset $C \subseteq V$ such that $C$ is a $k$-clique.
* Example: If the decision problem for CLIQUE is in P, show that there is a polynomial time algorithm that solves the search problem as well.
