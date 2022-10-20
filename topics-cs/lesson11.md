# Topics in Advanced Computing Lesson 11: PSPACE
{:.no_toc}

1. Table of Contents
{:toc}

# Problem Set Questions?

# Space Complexity Classes

We can similarly define *nondeterministic space complexity*: a nondeterministic machine $N$ has space complexity $f(n)$ if, on input $x$ of length $n$, no matter which nondeterministic choices $N$ makes during its computation on $x$, $N$ uses no more than $f(n)$ cells on its tape during the computation on $x$. The class $NSPACE(f(n))$ is the set of those problems $X$ which can be solved by a nondeterministic TM $N$ which has space complexity $O(f(n))$.

**Definition**: We define the following space complexity classes:

* $PSPACE = \cup_{k > 0} SPACE(n^k)$
* $NPSPACE = \cup_{k > 0} NSPACE(n^k)$
* $L = SPACE(\log n)$ (the class of problems solvable with logarithmic space)
* $NL = NSPACE(\log n)$

Space complexity and time complexity are closely related. For example, clearly $P \subseteq PSPACE$ and $NP \subseteq NPSPACE$. (Why?) Less obviously, $NP \subseteq PSPACE$ and $PSPACE \subseteq EXP$.

**Theorem**: $NP \subseteq PSPACE$.

**Proof**: Suppose $X \in NP$ and $V$ is a verifier for $X$ which has running time $p(n)$. We construct a TM $M$ which solves $X$ that has polynomial space complexity:

"On input $x$ of length $n$:  
1. For each $c$ of length at most $p(n)$, run $V(x, c)$.
   * If $V(x, c) = 1$, halt and output 1.
   * Otherwise, replace $c$ with the next possible certificate.
2. If we have looked at all possible certificates, output 0."

## PSPACE vs EXP

For a problem in $PSPACE$, we don't necessarily care about how *long* it takes to solve that problem. So perhaps it's not surprising that if you can solve a problem quickly, or even if you can verify a problem quickly, you can solve it without using too much space. It's perhaps less obvious that if we can solve a problem using polynomial space, then we can solve it in *exponential time*. How would we go about this? First, we need to define a **configuration** of a machine. In short, a configuration of a TM is a snapshot of what the machine is doing at a particular moment in time. If you paused computation of a machine, you'd need to know:

* What state is the machine in?
* What is written on the tape?
* Where is the read/write head of the machine pointing to?

Based on this, along with the description of the machine, you can think figure out what happens next.

**Definition**: Let $M$ be a Turing Machine. A **configuration** of a Turing Machine is a triple $(q, i, w)$ where $q$ is the state the machien is in at some point, $i$ is a natural number representing where the machine is pointing to, and $w$ is the word written on the tape at that point in time.

Then running a machine on some input corresponds to a valid sequence of configurations.

**Lemma**: Suppose $M$ is a Turing Machine that has space complexity $O(f(n))$. Then on any input $x$ of length $n$, $M$ can be in at most $O(f(n) \times 2^{f(n)})$ configurations during its computation on $x$.

We prove this just for $f(n) = n$, but the idea is the same for any function $f(n)$. Recall that a configuration is a triple $(q, i, w)$. So this boils down to product of the following three numbers:

1. How many states are in $M$? (Some constant $c$, which does not depend on the input $x$).
2. How many different locations could $M$ point to during its computation on $x$? (Since $M$ only uses at most $n$ cells of its tape, it cannot possibly point to more than these first $n$ cells.)
3. How many different words could be on the tape?

This last one is a bit trickier: each word is a sequence of length at most $n$ of $0$s and $1$s. So then we need to ask: how many words of length 0 are there, how many of length 1, how many of length 2, ..., how many of length $n$, and then add them all up?

* There is exactly one word of length 0: the empty string "".
* There are two words of length 1: "0" and "1".
* 4 words of length 2: two choices for the first bit, two for the second.
* ...
* $2^n$ words of length $n$: two choices for each bit.

Add these up: $1 + 2 + 4 + \ldots + 2^n = 2^{n + 1} - 1$.

So in total, there are $c \times n \times (2^{n + 1} - 1)$ possible configurations that $M$ could be in, which is $O(n \times 2^n)$.

**Theorem**: $PSPACE \subseteq EXP$.

**Proof**: Let $X \in PSPACE$ and $M$ be a TM that solves $X$ in space complexity $f(n)$ for some polynomial $f(n)$. On input $x$ of length $n$, $M$ can be in at most $O(f(n) \times 2^{f(n)})$ configurations, and so $M$ has running time at most $O(f(n) 2^{f(n)})$. Since $f(n) = O(2^{f(n)})$, this is $O(2^{f(n)^2})$ and so $X \in EXP$.

# Games and PSPACE Completeness

A two-player game with perfect information is a game in which two players alternate taking moves, with each player knowing all the moves that came before. Let's describe a logic game, called the **formula game**.

We know what a Boolean formula $\phi(x_1, \ldots, x_n)$ is. Now let's add in **quantifiers**. The quantifier $\forall$ is read "for all", and $\exists$ is read "there exists". For example, the formula $\forall x_1 \exists x_2 (x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$ means: "For every value of $x_1$, there is some value of $x_2$ such that either $x_1$ or $x_2$ is TRUE **and** either $x_1$ or $x_2$ is FALSE." This is now a **statement**: it has a truth value! Is it true or false?

* Suppose $x_1$ is TRUE. Then $(x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$ can be made true if $x_2$ is FALSE.
* Suppose $x_1$ is FALSE. Then $(x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$ can be made true if $x_2$ is TRUE.

So $\forall x_1 \exists x_2 (x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$ is TRUE!

**Definition**: A **quantified boolean formula** (QBF) is a Boolean formula $\phi(x_1, \ldots, x_n)$ with a block of quantifiers for each of the $x_i$'s at the beginning.

For example, $\forall x_1 (x_1 \vee x_2)$ is not a QBF, but $\forall x_1 \forall x_2 (x_1 \vee x_2)$ is.

Now let's describe the **formula game**. The two players are "Abelard" and "Eloise", denoted $\forall$ and $\exists$, respectively. Given a QBF $\phi$, we take turns: at stage $i$, player $\forall$ goes if $x_i$ is quantified by a $\forall$, and $\exists$ goes if $x_i$ is quantified by $\exists$. (Makes sense, right?) Each player plays either TRUE or FALSE (or 0 or 1 if you prefer).

If there are $n$ variables in $\phi$, then the game lasts for $n$ rounds. At the end of the game, $\forall$ wins if the formula ends up evaluating to FALSE, and $\exists$ wins if the formula evaluates to TRUE.

We say that a player has a **winning strategy** in a game if there is a function that, for each possible state of the game, picks out a valid move in such a way that if a player follows this strategy, they will always win.

**Example**: Let $\phi$ be the formula $\forall x \exists y (x \wedge \lnot y) \vee (\lnot x \wedge y)$.

1. Suppose $\forall$ plays $x = 0$. What would you play for $y$?
2. Suppose $\forall$ plays $x = 1$. What would you play for $y$?
3. Does either player have a winning strategy for the formula game for $\phi$?

**Claim**: A quantified Boolean Formula $\phi$ is true if and only if $\exists$ has a winning strategy in the formula game for $\phi$.

We show this for statements which have two variables, but the general proof is similar. If $\phi$ has two variables $x$ and $y$, then $\phi$ could look like one of the following:

* $\forall x \exists y \psi(x, y)$
* $\exists x \forall y \psi(x, y)$
* $\exists x \exists y \psi(x, y)$
* $\forall x \forall y \psi(x, y)$

Where $\psi(x, y)$ is a propositional formula with variables $x$ and $y$.

Let's just look at the first case. $\phi = \forall x \exists y \psi(x, y)$. If $\exists$ has a winning strategy, then if $\forall$ plays TRUE, $\exists$ can play some $y$ according to her strategy so that $\psi(x, y)$ is true. If $\forall$ plays FALSE, then $\exists$ still can play some $y$ so that $\psi(x, y)$ is true.

Conversely, if the statement is true, then for each $x$, there is some $y$ so that $\psi(x, y)$ is true. That means, the winning strategy for $\exists$ is the following: if $x = 0$, pick $y$ so that $\psi(0, y)$ is true, and if $x = 1$, pick $y$ so that $\psi(1, y)$ is true. $\forall$ would have no winning strategy here: no matter what $\forall$ plays, $\exists$ can counter with something to make $\phi$ true. That's the nature of what $\forall x \exists y \psi(x, y) = TRUE$ means!

**Theorem**: The "Formula Game" is PSPACE-complete.

What does this mean? First, by the "Formula Game", we mean: "Given a QBF $\phi$, does $\exists$ have a winning strategy?" Or: "On input $\phi$, determine if $\exists$ has a winning strategy." This problem is PSPACE-complete.

**Definition**: $X$ is PSPACE-complete if $X \in PSPACE$ and whenever $A \in PSPACE$, $A \leq_P X$.

We will only show that this game is in PSPACE. The proof that it is PSPACE-hard is involved, in a similar manner to the proof of the Cook-Levin Theorem.

So why is the formula game in PSPACE? One can determine if a QBF is true using polynomial space. We describe an algorithm $M$ as follows:

"On input $\phi$:

1. If $\phi$ contains no quantifiers, then it only has constants (no variables), so we can just evaluate it. Return TRUE or FALSE based on the value of $\phi$.
2. If $\phi = \exists x \psi$, then recursively run $M(\psi[0])$ and $M(\psi[1])$. That is, run $M$ on input $\psi$ where we replace $x$ by 0 everywhere, and then again when we replace $x$ by 1 everywhere. If either return TRUE, then return TRUE. Otherwise return FALSE.
3. If $\phi = \forall x \psi$, then recursively run $M(\psi[0])$ and $M(\psi[1])$. If both return TRUE, then return TRUE. Otherwise return FALSE."

Another way to think of this: turn $\exists x \psi$ into $\psi(0) \vee \psi(1)$, and turn $\forall x \psi$ into $\psi(0) \wedge \psi(1)$. Recursively check each of these subformulas, erasing the extra memory used when we are done using it. If $\phi$ has $m$ variables, then we only need to store, at most, $m$ additional bits to figure out what assignment we are using. So this problem is solvable in polynomial space in terms of the length of $\phi$!
