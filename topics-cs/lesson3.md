# Topics in Advanced Computing Lesson 3: Computability (abridged)
{:.no_toc}

1. Table of Contents
{:toc}

# Big Oh / Desmos activity recap

# Topics

* Decide on a topic today!
* Talks will start in two weeks.
* 9/26, 9/29, 10/3, and 10/6 (if necessary)

# Computability, informally

Recall that by a "problem" we mean a "yes / no" question. Usually we represent it set-theoretically: we define some set $X$, and our "problem" then is translated into set theory as: "given some input $x$, is $x \in X$?" We really want to ask questions like: for a given problem $X$, what is the optimal running time of an algorithm which solves this problem? In order to ask and answer questions like these, we will make some simplifying assumptions:

* Our **inputs** are really just sequences of bits (0s and 1s). The justification for this is that *everything* in a computer is eventually represented as some sequence of bits.
* Our **problems** are really sets of sequences of bits.
* A **solution** to a problem $X$ is a function $f$ such that for each input $x$ (remember that $x$ is some sequence of bits), $f(x) = 1$ if $x \in X$ and $f(x) = 0$ if $x \not \in X$.

So then what do we mean by an "algorithm"? Informally, let's think about our "multiplication" algorithm we looked at in [Lesson 0](lesson0.html#better-algorithm). In order to multiply two numbers, we needed to line up the inputs $x$ and $y$, look at one bit each of $x$ and $y$, and based on that, write down a bit in our "scratch work" place and continue. After each "operation" we also had to adjust what bits we were looking at, and where, exactly, we would write things down on our "scratch pad". Later on in the algorithm, we will line up our bits of our "scratch" pad and add them.

So that means, in an algorithm, we have some finite set of rules (instructions / lines of code / operations) we are allowed to use, and then we can:

* Read one bit of input,
* Read one bit of our scratch work,
* Apply one of "rules",
* Based on the result of that rule, write something down somewhere,
* Adjust where we are looking at (either from the input, or the scratch work), and/or
* Decide we are done. (Perhaps output "YES" or "NO", or "1"/"0").

This gives us an informal, fuzzy idea of what "computation" really means.

# Turing Machines

The **Turing Machine** turns out to encapsulate exactly this idea. In fact it will turn out that really most reasonable, deterministic models of computation will be equivalent.

So again: what is computation? Here is what Alan Turing wrote in [his seminal 1936 paper](https://www.cs.virginia.edu/~robins/Turing_Paper_1936.pdf) where he birthed the subject of computability theory:

> Computing is normally done by writing certain symbols on paper. We may suppose this paper is divided into squares like a child's arithmetic book. . . The differences from our point of view between the single and compound symbols is that the compound symbols, if they are too lengthy, cannot be observed at one glance. This is in accordance with experience. We cannot tell at a glance whether 9999999999999999 and 999999999999999 are the same.
> The behaviour of the computer at any moment is determined by the symbols which he is observing, and his " state of mind " at that moment.
We may suppose that there is a bound B to the number of symbols or squares which the computer can observe at one moment. If he wishes to
observe more, he must use successive observations. We will also suppose that the number of states of mind which need be taken into account is finite. . .

> Let us imagine the operations performed by the computer to be split up into "simple operations" which are so elementary that it is not easy to imagine them further divided. Every such operation consists of some change of the physical system consisting of the computer and his tape. We know the state of the system if we know the sequence of symbols on the tape, which of these are observed by the computer (possibly with a special order), and the state of mind of the computer. We may suppose that in a simple operation not more than one symbol is altered. Any other changes can be split up into simple changes of this kind. . .

> The most general single operation must therefore be taken to be one of the following:

> (a) A possible change . . . of symbol together with a possible change of state of mind.

> (b) A possible change . . . of observed squares, together with a possible change of state of mind.

The textbook goes through the formal description of the computational model, but for us we really need to just worry about the three main parts:

* The **tapes**. This serves as the "memory" for the model. A "tape" consists of infinitely many "cells", each of which has either a symbol (usually 0 or 1) or a blank on it. Some texts insist that TMs only have a single tape, others allow for multiple. We will explain why it does not affect our notions of complexity classes later. The computer starts with the input on the first tape, and can use the other tapes as "scratch pads" to work with. One tape can be designated as an *output tape*. The machine keeps track of what position it is looking at on each tape. For example: <img class="noreverse" src="https://atharaq.github.io/computability/two-tapes.jpeg" alt="Drawing of a TM with two tapes and arrows pointing to where the TM is looking at on each tape."/>
* The **states**. One can think of this as analogous to the "line number" of your instructions. It's not a perfect analogy, but it's a decent approximation. There is a specific state that we start in, designated $q_{start}$. There is also a specific state $q_{halt}$; if the machine reaches this state, it immediately stops and outputs whatever is on its output tape.
* The **rules**. At each moment, the machine has to decide, using a rule, what to do when it is at a particular state, and reads a particular symbol from each tape. It is allowed to write symbols (usually just 0s or 1s) to each of the tapes, decide which state to go to next, and adjust the "read / write" position on each tape (where the machine is looking at).

This formalization is not particularly helpful for actually thinking about algorithms, but it does allow us to have a foundational definition on which to base all of our reasoning in this class on. So I wouldn't worry too much about the formalization: the main idea for today is really that the choice of formalizations doesn't really affect the complexity classes.

## Computing a function

**Definition**: By $\\{ 0, 1 \\}^*$ we mean the set of all finite strings (sequences) of 0s and 1s.

**Definition**: Let $f : \\{ 0, 1 \\}^* \to \\{0, 1 \\}^*$ and $T : \mathbb{N} \to \mathbb{N}$ be functions, and $M$ a Turing machine. We say $M$ computes $f$ in $T$-time if, for each $n \in \mathbb{N}$, and any input $x$ of length at most $n$, if $M$ is initialized with $x$ on its input tape, then after at most $T(n)$ steps, $M$ halts and contains $f(x)$ on its output tape.

Similarly, given a *problem* $X$ and $T : \mathbb{N} \to \mathbb{N}$, we say $M$ *solves* $X$ in $T$-time if, for each $n \in \mathbb{N}$ and any input $x$ of length at most $n$, if $M$ is initialized with $x$ on its input tape, then after at most $T(n)$ steps, $M$ halts and outputs $1$ if $x \in X$, or outputs $0$ if $x \not \in X$.

This is our definition of running time. So when we say that a problem $X$ is solvable in "quadratic time", we will mean that there is a TM which, for all $n \in \mathbb{N}$ and any input $x$ of length $n$, determines if $x \in X$ in time $O(n^2)$. This is a strong restriction, since the elementary operations here are so small. For example, suppose the problem is: check if $x$ is the binary representation of an even number. In binary, an even number is a number whose last bit is a 0. A TM would need to scan the entire input one by one, and finally at the end see if that last bit was a 1. Therefore, if the input had size $n$, this would take $n$ steps (maybe $n + 1$, but still $O(n)$).

**Important note**: It is possible that a Turing Machine might not output anything for a given input. Think about a program which reads an input and enters into a loop where it does the following:

1. Scan to the end of the input tape.
2. Write down a 1 on the work tape and move the read/write head over by one cell.
3. Scan back to the beginning of the input tape.
4. Go back to step 1.

This machine would run forever! In complexity theory, we only focus on those Turing Machines which always halt, eventually, on every input.

## Variants

We say two Turing Machines $M_1$ and $M_2$ are *equivalent* if they compute the same function. That is, for any input $x$, the output of running $M_1$ on $x$ and of running $M_2$ on $x$ is the same. By a **single-tape Turing Machine**, we mean a machine which uses a single tape as its input, output, and work tapes. So the machine is initialized with the input on the tape, and, if it wants, it can overwrite that input, or scan past it and use the rest of the tape as a scratch pad. If the machine halts, we say that its output is whatever is on the tape at that moment.

**Theorem**: Suppose $M$ is a Turing Machine with $k$ tapes and runs in $O(T(n))$ time. Then there is an equivalent single-tape Turing Machine $S$ which runs in $O((T(n))^2)$ time.

I will skip the proof here, but the idea is to use the one tape to "simulate" all $k$ tapes of the machine.

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

# Complexity classes

**Defintiion**: Let $T : \mathbb{N} \to \mathbb{N}$ be a function. Then $DTIME(T(n))$ is the collection of all problems that are solvable by a Turing machine in $O(T(n))$-time.

**Definition**: The class $P$ is defined as $$P = \bigcup\limits_{k} DTIME(n^k).$$ This is the class of all problems that are solvable in **polynomial time**. In particular, this will be our definition of what it means for a problem to be solvable *efficiently*.

# Problem Set 1

Before doing this assignment, read this short article on [Writing Mathematics Well](https://math.hmc.edu/su/wp-content/uploads/sites/10/2020/08/Guidelines-for-Good-Mathematical-Writing.pdf) by Francis Su.

Your responses must be written in complete sentences (proofs are *arguments* written in English!). If you know LaTeX, please use it: the .tex file is available on Moodle. Otherwise, write down your responses on paper and scan and upload them to Moodle. This problem set is due on **Thursday, September 22**.

1. Re-write the following argument (in complete sentences!!!) that if $f(x) = x^2 + 2$ and $g(x) = \sin(x)$, then the graphs of $f$ and $g$ never intersect:
$$
\begin{align*}
f^\prime(x) = 2x \\
2x = 0 \rightarrow x = 0 \\
f(0) = 2 \rightarrow \text{the minimum value of } f(x) \text{ is 2.} \\
g(x) \leq 1 \rightarrow g(x) < f(x) \text{ all the time. }
\end{align*}
$$
1. Show that if $f(n) = O(g(n))$ and $g(n) = O(h(n))$, then $f(n) = O(h(n))$. That is: Big Oh is *transitive*.
2. Show that if $f(n) = \Theta(g(n))$, then $g(n) = \Theta(f(n))$. That is: Big Theta is *symmetric*.
3. Classify the following functions according to Big Oh relationships. Give a short justification for each:
   * $f_1(n) = \sqrt{n}$
   * $f_2(n) = 2^n - 700$
   * $f_3(n) = 3n^2 - 2n$
   * $f_4(n) = n!$ (the factorial function)
