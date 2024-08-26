# Lesson 22: NP and NP-completeness
{:.no_toc}

1. Table of Contents
{:toc}

**Reading**: Sipser 7.3 - 7.5, or MS 6.3-6.5.

# PS4 questions?

Due Monday!

# NP

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

**Exercise**: Why does this non-deterministic algorithm work? What's the non-deterministic running time of this?

**Exercise**: Find a similar non-deterministic algorithm for SUBSET-SUM (check [Lesson 20](lesson20.html) for the definition).

## Equivalent definition of NP

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

**Exercise**: Suppose $V$ is a polynomial-time verifier for $L$, and so its running time is $O(n^k)$ for some $k$. Explain why, for each $w \in L$, the certificate $c$ which works (so that $V$ accepts $\langle w, c \rangle$) must have length at most $n^k$ for some $k$.

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

More generally, one might verify if an assignment is a satisfying one by turning the propositional formula into some kind of binary tree, plugging in the true / false at the leaves and then checking. The running time of this would be the running time of reading through the entire tree, which would polynomial in the size of the formula. (If we have time next week, I'll try to show an example of this.)

This was the first problem that was shown to be NP-complete! This was shown, independently, by Stephen Cook (1971) and Leonid Levin (1973), so this is called the [Cook-Levin Theorem](https://en.wikipedia.org/wiki/Cook%E2%80%93Levin_theorem). The Wikipedia page does a nice job explaining how they show this: how do you show that *any* problem $A \in NP$ can be reduced to SAT?

* First suppose that there is an NTM $N$ that decides $A$.
* Given an input $w$, you build a formula $\phi$, so that $N$ accepts $w$ if and only if $\phi$ has a satisfying assignment.
* You need to do this in such a way that it takes a polynomial number of steps to build $\phi$.

The idea was quite brilliant: the formula $\phi$ has to encode information about the NTM $N$ itself so that $\phi$ is satisfiable if and only if $N$ accepts $w$. (You can see the details on Wikipedia, but it's not particularly easy to parse.)

Are there any other NP-complete problems? Yes! We'll discuss them next week! (Some of you may be interested in researching one or two yourselves for your group project. Feel free!)
