# Lesson 25: Turing Jumps, Arithmetical Hierarchy, Incompleteness and Truth
{:.no_toc}

1. Table of Contents
{:toc}

# Upcoming

* Problem Set 5 will be posted tomorrow and will be due Monday, May 16 (during finals week)
* Final Projects:
  * Presentation: Thursday, 5/12. (about 15 minutes)
  * Paper: Thursday, 5/19. (about 5-10 pages)

# P vs NP, Philosophically

> If P=NP, then the world would be a profoundly different place than we usually assume it to be. There would be no special value in “creative leaps,” no fundamental gap between solving a problem and recognizing the solution once it’s found. Everyone who could appreciate a symphony would be Mozart; everyone who could follow a step-by-step argument would be Gauss; everyone who could recognize a good investment strategy would be Warren Buffett.

[Scott Aaronson, "Reasons to Believe"](https://scottaaronson.blog/?p=122)

Aaronson also wrote an interesting article about philosophy and complexity theory: [Why Philosophers Should Care About Computational Complexity](https://www.scottaaronson.com/papers/philos.pdf).

Readings: skim 6.1 and read 6.2 (Sipser)

# Oracles

Recall that an "oracle-TM" is a TM which has access to querying an oracle. One can think of it as a program which takes in two inputs: a number ($n$), and a set $X$. The program, then, can do the normal operations on $n$, but it can also ask (finitely many) questions of the form "Is $x \in X$?"

This is a very general set-up. That is, given the "source code" for an oracle TM, we could "plug in" different sets as oracles, and end up solving different problems. For example, consider the following code for an oracle TM:

"On input $\langle e, n \rangle$, with oracle $X$:

1. Find the code $e^\prime$ of a function $f_{e^\prime}$, which, on any input, ignores it and compute $f_e(n)$.
2. Check if $e^\prime \in X$.
   * If not, output 0 (reject).
   * If so, compute $f_e(n)$ and output whatever it outputs."

* If we plug in to this oracle with $X$ being the empty set, this will reject every input.
* If we plug in to this oracle with $X$ being the halting set $H = \\{ e : f_e(e) = 1 \\}$, then this computes an analogue of the "acceptance problem", translated to this number-theoretic setup.

That is, this computes a total oracle-computable function $\Phi^X$ such that if $X = H$, $\Phi^X(e, n) = f_e(n)$ if $f_e(n)$ halts, and $\Phi^X(e, n) = 0$ otherwise. This function is *not* a total computable function, but it *is* a total $H$-computable function.

## Enumeration of Partial Oracle-Computable Functions

Recall that there is a computable enumeration $f_0, f_1, f_2, \ldots$ of all partial computable functions. What does this mean?

* For each $e$, one can determine what the $e$-th partial computable function is. (The idea: if $e = 0$, figure out what the smallest valid IO TM over the alphabet $\\{0, 1 \\}$ is. Then if $e = 1$, figure out the second smallest, etc.)
* For each IO TM $F$, one can find an $e$ (maybe many $e$'s, but you can find at least one) such that $f_e$ and $F$ compute the same function (halt on the same inputs, and for those inputs that they both halt on, output the same number). The idea is to think of $e$ as the "source code" for $F$.

How did we obtain such a computable enumeration? By, more or less, describing a universal TM. That is, describing a TM $M$ such that, on input $\langle M^\prime, w \rangle$, $M$ simulates $M^\prime$ on $w$. Translating this to the language of functions on natural numbers, this describes a function $f$ which, on input $(e, n)$, "decodes" $e$ (figures out what the $e$-th TM is), and runs that on input $n$.

Similarly, we can describe a universal oracle TM $M$ in the exact same way: on input $\langle M^\prime, w \rangle$, just "decode $M^\prime$" and run it on input $w$. But of course, if $M^\prime$s code queries an oracle, then the only way $M$ can simulate that is by asking the same oracle.

In other words, there is a partial oracle computable function $F$, which, for any oracle set $X$ and any input $(e, n)$, runs the $e$-th partial $X$-computable function ("decodes" this) on input $n$. So again, we obtain an $X$-computable enumeration of all partial $X$-computable functions $\Phi^X_0, \Phi^X_1, \ldots$.

(Moreover, there is a strong universality to this algorithm: the same "oracle" algorithm works for any oracle, just depending on what set you plug in as the oracle.)

This allows us to define, for any set $X$, the **halting problem relativized to $X$**:

**Definition**: Let $X \subseteq \mathbb{N}$ be any set. Then $X^\prime$, the **Turing jump of $X$**, is the set $\\{ e : \Phi^X_e(e)$ halts $\\}$.

**Theorem**: For any set $X$, $X <_T X^\prime$.

**Proof**: There are two things to show here. First, that $X \leq_T X^\prime$. Then, that $X^\prime$ is not $X$-computable. We will skip the first (it actually takes a bit more work than you might expect.)

The second part, though, is essentially the same proof that the halting problem is not computable. The exact same proof relativizes. That is, assume that $X^\prime$ is $X$-computable. Then we would also be able to $X$-compute the set $\\{ e : \Phi^X_e(e)$ halts and equals $0 \\}$. But if this is $X$-computable, then its characteristic function $\chi$ is equal to $\Phi^X_e$ for some $e$. Then one checks that $\chi(e) = 1$ iff $\Phi^X_e(e) = 0$, and vice versa.

## Turing Jumps

A Turing jump, then, is a "strictly harder" problem than the original problem.

* The sets that can be decided from no oracle, ie the $\emptyset$-computable sets, are just the computable sets.
* The halting problem, then, is the jump of the empty set$: $\emptyset^\prime$ (usually referred to as "0-jump")
* The sets that can be computed from $\emptyset^\prime$ are the c.e. and co-c.e. sets.
* Then there is $\emptyset^{\prime\prime}$, $\emptyset^{\prime\prime\prime}$, etc.

The theorem above says that each of these is strictly harder than the one that came before it! That means, there is no set $X \subseteq \mathbb{N}$ that computes everything! That is, there is no $X$ such that for every $A \subseteq \mathbb{N}$, $A \leq_T X$.

This is actually a profound statement because this is saying that there is no "universal set". I aim to show that there is a natural example of what one might hope would be a universal set: the set of all codes of true statements about numbers!

# Logic
