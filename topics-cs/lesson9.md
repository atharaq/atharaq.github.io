# Topics in Advanced Computing Lesson 9: co-NP, EXP, NEXP
{:.no_toc}

1. Table of Contents
{:toc}

# Problem Set questions?

# co-NP

Suppose $X$ is a problem, described set-theoretically. By $\bar{X}$ we mean the *complement* of $X$, meaning the set of those inputs $x$ such that $x \not \in X$.

**Exercise**: Show that if $A \in P$, then $\bar{A} \in P$.

**Definition**: The class **co-NP** consists of the problems $X$ such that $\bar{X} \in NP$.

In particular, this does not mean that $X \not \in NP$. For example, if $X \in P$, then $\bar{X} \in P$, and since $P \subseteq NP$, that means both $X$ and $\bar{X}$ are in NP.

One way to show that a problem $X$ is in co-NP is to show that there is a verifier for the complement. In other words, show that there is a polynomial time machine $M$, such that for all $x$, if $x \in X$, then for every certificate $c$, $M(x, c) = 1$, and if $x \not \in X$, then there is a certificate $c$ such that $M(x, c) = 0$.

**Example**: A *tautology* in Boolean logic is a formula which evaluates to *true* under all possible assignments. For example, the formula $(p_1 \vee \lnot p_1) \wedge (p_2 \vee \lnot p_2)$ is a tautology.

The TAUTOLOGY problem asks: given a formula $\phi$ with $n$ variables and $m$ clauses, is $\phi$ true under every possible assignment?

**Exercise**: Show that $TAUTOLOGY \in co$-$NP$. (Hint: suppose $\phi$ is a formula and a certificate is a possible assignment for $\phi$. What should we do?)

**Theorem**: TAUTOLOGY is co-NP-complete. That is, for every problem $A$, if $A \in co$-$NP$, then $A \leq_P TAUTOLOGY$.

The proof is just that $\bar{A} \leq_P SAT$. That is, there is a polynomial time computable function $f$ such that on input $x$, $f(x)$ outputs a formula $\phi$ such that $\phi$ is satisfiable if and only if $x \not \in A$. In particular, $\phi$ evaluates to false under **all** assignments if and only if $x \in A$. That means that $\lnot \phi$ is a tautology if and only if $x \in A$!

**Theorem**: Suppose $P = NP$. Then $NP = co$-$NP$.

(Can you prove this? What about the converse? If $NP = co$-$NP$, does this mean $P = NP$?)

It turns out that this is still an open question: does $NP = co$-NP?

## Integer Factoring

The **integer factoring** problem asks: given inputs $x$ and $y$ (positive integers), determine if $x$ has a factor in the interval $(1, y)$.

**Claim**: The integer factoring problem is in both NP and co-NP.

* To see it's in NP: given input $x$, let the certificate $c$ be a factor in the correct interval. Then show that $c$ is a factor of $x$ by dividing (polynomial time?).
* To see it's in co-NP? What does this even mean?
   * Given inputs $x$ and $y$, we need to certify that $x$ has *no* factors in the interval $(1, y)$.
   * Let the certificate $c$ be an increasing list of non-negative prime factors of $x$.
   * Certify that these multiply together to get $x$, that they are all greater than $y$, and that they are all prime.
   * The last part requires the fact that $PRIMES \in P$ (Agrawal-Kayal-Saxena 2002, aka the "AKS Primality Test").

# EXP vs NEXP

Recall: $EXP$ is the complexity class consisting of those problems which are solvable in $DTIME(O(2^{p(n)}))$ for some polynomial $p(n)$. It also has a nondeterministic analogue: $NEXP$.

One can show that if $P = NP$, then $EXP = NEXP$.

## EXP-completeness?

We have seen that there are problems which are $NP$-complete. That is: problems $X \in NP$ such that for all problems $A \in NP$, $A \leq_P X$.

**Questions**:

1. What would it mean for a problem to be $EXP$-complete?
2. What would it mean for a problem to be $NEXP$-complete?
3. If $X \in NEXP$ is $NEXP$-complete and $X \in EXP$, does that mean $EXP = NEXP$?

Here is an example of an $EXP$-complete problem: given a description of a deterministic Turing Machine $M$, an input $x$ to $M$ and an integer $k$, determine if $M(x)$ halts within $k$ steps.
