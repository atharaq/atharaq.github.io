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

# Verifiers

## Theorem

* If a problem is in NP, then it can be verified in polynomial time.

## Theorem

* $NP \subseteq EXP$

# Coming up

* Readings: 2.1 - 2.3
* Reductions and NP-completeness
* EXP and NEXP

## Reminders

* Problem Set 1 due next Thursday **9/22**.
* Presentations will start **9/26**.
