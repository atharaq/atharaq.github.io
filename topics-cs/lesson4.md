# Topics in Advanced Computing Lesson 4: Nnondeterminism and NP
{:.no_toc}

1. Table of Contents
{:toc}

# Warm-up

In small groups, devise an algorithm that solves the following problem: given an $n$-bit natural number $x$, determine if $x$ is a perfect square. That is, determine if there is a natural number $y$ such that $y \times y = x$.

Are you able to devise an algorithm that runs in polynomial time in terms of $n$? That is, can you devise an algorithm that is $O(n^2), O(n^3), O(n^4)$, or something like that?

# Non-determinism

The machines we have been looking at are all **deterministic**. That means, at each state, when we read a particular symbol(s) from the tape(s), we know exactly which rule the machine will apply. The machine has a specified next behavior based on what its state and memory look like at that moment in time. One can imagine this as a program:

```
Line 1: if the input bit is a 1, write a 0, move left on the tape, and go to line 3. If it's a 0, write a 1, move left on the tape, and go to line 2.
Line 2: ...
Line 3: ...
```

What if we allow **non-determinism**? Non-determinism means that we allow more than one single choice for a given rule. That is, at a given state $q$, if the machine reads bit $b$ from the tape, we allow the machine to choose one of finitely many rules that we specify for that given state / bit combination.

**Definition**: We say a nondeterministic machine $N$ solves a problem $X$ in $T$-time if, for every input $x$, if $N$ initialized with $x$ on its input tape, then no matter which nondeterministic choices $N$ makes at each step, $N$ must halt within $T(n)$ steps. Moreover, if $x \in X$, then there must be *some* sequence of nondeterministic choices $N$ can make so that $N$ would halt with $1$ on its output tape; and if $x \not \in X$, then *every* possible choice $N$ can make eventually ends up with $N$ halting with $0$ on the output tape.

**Example**: Consider the following nondeterministic algorithm for checking if a number is composite:

"On input $x$ of length $n$:  
1. On a scratch pad, nondeterministically write down $n$ bits. Call the resulting number in binary $y$.
2. First check if $x = y$ or if $x = 1$. If so, write a 0 on the output tape and halt. Otherwise, continue to step 3. (This is to avoid thinking that 2 is composite since $2$ is a multiple of $2$)
3. Check if $x$ is a multiple of $y$. (This requires some work, but Turing Machines can do this.)
4. If $x$ is a multiple of $y$, write a $1$ on the output tape and halt.
5. Otherwise, write a $0$ on the output tape and halt."

Suppose our input is 6. In binary, 6 is written as 110. The first "step" is to write down 3 bits at random, then. If we happen to write down 101, which is 5, then we would end up saying that 6 is not a multiple of 5, so we halt and output 0. But if we wrote down 011, which is 3, we would have seen that 6 is a multiple of 3, and we would halt and output 1. In other words, there is a sequence of nondeterministic choices one can make in order to end up outputting 1, since $6$ is composite.

Alternatively, if our input were 5, written as 101, no matter what nondeterministic choices we made, we would not find a number that is a factor of 5. That is because 5 is not a composite number (it's prime). So no matter what, we end up halting and outputting 0.

There are two paradigms for thinking about nondeterminism:

* Parallelism: the machine executes all nondeterministic choices in parallel. That is, if the machine says to either write a 0, move left, and go to state $q_2$, or to write a 1, move right, and go to state $q_3$, then we imagine that the machine forks two new computational threads that execute simultaneously (each with their own tape memory).
* Computation tree: At each step, the machine has several possible "next steps". This ends up looking like a tree structure: <img alt="Deterministic vs nondeterministic computation" src="https://upload.wikimedia.org/wikipedia/commons/1/16/Difference_between_deterministic_and_Nondeterministic.svg" />

What does the computation tree look like for our nondeterministic algorithm above?

## Exercise

Show that the following problem is in the class NP:

Given $n$-bit natural numbers $a$, $b$ and $c$ as inputs, determine if there are natural numbers $x$ and $y$ such that $ax^2 + by = c$.

**Hint**: can you give a "nondeterministic" algorithm for this? What would the nondeterministic running time of that algorithm be?

## NP

**Defintiion**: Let $T : \mathbb{N} \to \mathbb{N}$ be a function. Then $NTIME(T(n))$ is the collection of all problems that are solvable by a non-deterministic Turing machine in $O(T(n))$-time.

**Definition**: The class $NP$ is defined as $$NP = \bigcup\limits_{k} DTIME(n^k).$$ This is the class of all problems that are solvable in **nondeterministic polynomial time**.

# Verifiers

As we've seen, nondeterminism is tricky to think about. We describe an alternate definition of the class $NP$ using **verifiers**.

**Definition**: Let $X$ be a problem and $V$ a Turing Machine which accepts two inputs. $V$ is called a **verifier** for $X$ if for each $x \in \\{ 0, 1 \\}^*$, both of the following are true:
* $x \in X$ if and only if there is (at least one) $c \in \\{0, 1 \\}^*$ such that when initialized with inputs $(x, c)$, $V$ halts and outputs 1, and,
* if $x \not \in X$, then for every $c \in \\{ 0, 1 \\}^*$, when $V$ is initialized with inputs $(x, c)$, $V$ halts and outputs 0.

The idea is that $c$ is a *certificate*. The verifier $V$ doesn't have to actually solve the problem posed by input $x$, but it should just verify that $c$ witnesses a solution to $x$. If this is a little vague, then consider the following example for the "composites" problem before.

## Example

Consider the following verifier $V$ for checking if a number is composite:

"On input $(x, c)$, where $x$ has length $n$:
1. First check if $c = x$ or if $c = 1$. If so, write a 0 on the output tape and halt. Otherwise, continue to step 3.
3. Check if $x$ is a multiple of $c$.
4. If $x$ is a multiple of $c$, write a $1$ on the output tape and halt.
5. Otherwise, write a $0$ on the output tape and halt."

For example, if $x = 100$, we can let $c = 10$, so $V$ will halt and output 1. But if $x = 7$, no matter which $c$ we pick, $V$ will halt and output 0 because $7$ is prime. Notice that this is basically the same as the "nondeterministic" algorithm above, except without the first $n$ guesses.

## Theorem

**Theorem 1**: A problem $X$ is in $NP$ if and only if it has a verifier which runs in polynomial time.

This is an "if and only if" statement, and so it has two directions: If $X$ has a polynomial time NTM $N$, then it has a has a polynomial time verifier $V$, and vice versa.

Suppose $N$ is a polynomial-time NTM for a problem $X$. Since $N$ is a polynomial time NTM, that means that no matter which nondeterministic choices $N$ makes, its running time is still polynomial. Morever, if $x \in X$, that means that when $N$ runs on input $x$, there is at least one sequence $\vec{v}$ of nondeterministic choices such that $N$ halts in polynomial time on $x$ and outputs 1.

So a verifier for $X$ would work as follows. Use the sequence $\vec{v}$ as your "certificate".

"On input $(x, \vec{v})$:  
1. Simulate $N$ on $x$ using $\vec{v}$ to determine which nondeterministic choices to make.
2. Output whatever $N$ outputs.

**Exercise**: Why does this $V$ run in polynomial time?

Now we show the reverse direction. First we do a warm-up:

**Theorem**: Suppose $V$ is a polynomial-time verifier for $X$, and so its running time is $O(n^k)$ for some $k$. Then for each $x \in X$, the certificate $c$ which works (so that $V$ outputs 1 on input $(x, c)$) must have length at most $n^k$.

Based on this, if we have a verifier $V$ for $X$ that runs in time $O(n^k)$, an NTM for $X$ might work as follows:

"On input $x$:  
1. Non-deterministically guess a string $c$ of length at most $n^k$.
2. Run $V$ on input $(x, c)$, and output whatever it outputs.

**Exercise**: Why does this non-deterministic algorithm work? Why does it run in $O(n^k)$ steps?

# Coming up

* $NP \subseteq EXP$
* Readings: 2.1 - 2.3
* Reductions and NP-completeness
* EXP and NEXP

## Reminders

* Problem Set 1 due next Thursday **9/22**.
* Presentations will start **9/26**.
