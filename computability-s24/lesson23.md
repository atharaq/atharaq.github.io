# Lesson 22: NP-completeness
{:.no_toc}

1. Table of Contents
{:toc}

# Presentations

# PS4 questions?

# Equivalent definition of NP

Given a language $L$, a **verifier** for $L$ is a TM $M$ such that for each $w$, $w \in L$ if and only if there is a string $c$ such that $M$ accepts the pair $\langle w, c \rangle$. $c$ is called the *certificate* (or "witness") for $w$.

We measure the time complexity of a verifier in terms of the length of $w$ (not $c$!).

**Theorem**: $L \in NP$ if and only if it has a polynomial-time verifier.

We would have to prove two directions: If $L$ has a polynomial time NTM $N$, then it has a has a polynomial time verifier $V$, and vice versa.

**Exercise**: Suppose $N$ is a polynomial-time NTM for a language $L$. Since $N$ is a polynomial time NTM, that means that every branch of $N$ ... (fill in the blank here). Morever, since $w \in L$, that means that when $N$ runs on input $w$, there is at least one branch $b$ such that ... (fill in the blank here).

So a verifier for $L$ would work as follows. Use the computational branch $b$ as your "certificate".

"On input $\langle w, b \rangle$:  
1. Simulate $N$ on $w$ using $b$ to determine which nondeterministic choices to make.
2. If $N$ accepts, accept.
3. If $N$ rejects, reject."

**Exercise**: Why does this $V$ run in polynomial time? (This should relate to your answers in a previous exercise).

Now we show the reverse direction.

**Exercise**: Suppose $V$ is a polynomial-time verifier for $L$, and so its running time $t(n)$ is $O(n^k)$ for some $k$ (assume that it is exactly $t(n) = n^k$). Explain why, for each $w \in L$, the certificate $c$ which works (so that $V$ accepts $\langle w, c \rangle$) must have length at most $n^k$.

Based on this exercise then, if we have a verifier $V$ for $L$ that runs in time $O(n^k)$, an NTM for $L$ might work as follows:

"On input $w$:  
1. Non-deterministically guess a string $c$ of length at most $n^k$.
2. Check if $V$ accepts $\langle w, c \rangle$. If so, accept, otherwise reject."

**Exercise**: Why does this non-deterministic algorithm work? Why does it run in $O(n^k)$ steps?

# Millenium Prize Problem

As mentioned a few times, the classic Millenium Prize Problem asks whether $P = NP$. The class $P$ is considered the class of problems that are "easy to solve". Similarly, NP is the class of problems that are "easy to verify" (or "easy to check"). The question, then, is if being easy to check a solution implies that it's easy to come up with a solution.

In other words, the following problem is currently open:

**Problem**: Suppose $\mathcal{L}$ can be decided by a nondeterministic TM $N$ running in polynomial time (NP). Is there an equivalent *deterministic* TM which runs in polynomial time?

**Exercise**: Why doesn't the proof that if a language is decided by an NTM then there is an equivalent deterministic TM that decides it work for this? (What is the running time of the TM we construct in this case?)

## Example

A classic example of this duality between something being easy to verify, but possibly hard to check is the factoring problem used in RSA encryption. (This is not a "yes/no" problem, so it's stated differently, but it's similar in spirit): given a number $N$, factor $N$ into primes.

* Any *solution* is easy to check: the "c" would just be the prime factors of $N$.
* Given $N$, there is currently no known algorithm which outputs the prime factors of $N$ is time polynomial in the length of $N$ (which is $O(\log(N))$).

This is the math behind public-key encryption (RSA):

* Given $p, q$ as "private" keys, you can easily compute $pq$.
* Given $p \times q$ (public), there is no known algorithm which efficiently computes $p$ and $q$.

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

# Problem Set 5

Due **Thursday, May 2**:

1. Knowing that $SUBSET$-$SUM$ is NP-complete, show that $NONEMPTY$-$SUBSET$-$SUM$ is NP-complete, where $NONEMPTY$-$SUBSET$-$SUM$ is the following language: $$ \{ \langle x_1, \ldots, x_n, t \rangle : \exists \text{ a non-empty subset } S \subseteq \{ 1, \ldots n \} \text{ such that } \sum\limits_{i \in S} x_i = t \}.$$ You must show two things: first that this language is in NP, and second, that this langauge is NP-hard (ie, if we have a polynomial time algorithm which decides this language, then there is a polynomial time algorithm which decides any other language in NP). (Hint: show that if this problem is in $P$, then so is $SUBSET$-$SUM$; that is, show a reduction from SUBSET-SUM to NONEMPTY-SUBSET-SUM)
2. Suppose $SUBSET$-$SUM \in P$ and let $M$ be a polynomial-time algorithm which decides it. Find a polynomial-time algorithm which, given $\langle x_1, \ldots, x_n, t \rangle$, outputs a subset $S \subseteq \{ 1, \ldots, n \}$ such that $\sum\limits_{i \in S} x_i = t$, or outputs "no solution" if no such subset exists. (That is: if we can decide if there is a subset of $\{ x_1, \ldots, x_n \}$ whose sum equals $t$ in polynomial time, show that we can actually find that subset whose sum equals $t$ in polynomial time also.)
3. Answer both parts:
   * Describe what it means for a language to be computable (decidable), computably enumerable (c.e.) but not computable, and co-c.e. but not computable.
   * For each of the following languages, determine which, if any, of the above categories the language belongs to:
      * $\overline{H_{\text{TM}}}$, where $H_\text{TM} = \{ \langle M, w \rangle : M $ halts on input $ w \}$
      * $CLIQUE$
      * $A_\text{TM}$ (the acceptance problem)