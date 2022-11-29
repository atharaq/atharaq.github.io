# Topics in Advanced Computing Lesson 18: Interactive Proofs
{:.no_toc}

1. Table of Contents
{:toc}

# Interactive Proofs

One can think of the notion of a mathematical proof as analogous to the role of a verifier in the **NP** definition. That is: a *proof* of some theorem is a finite string that one can *verify*. We can generalize this idea: suppose we have two players, a *prover* and a *verifier*. The verifier is able to ask the prover finitely many questions (usually there is some fixed bound $k$), the prover responds each time, and then, finally at the end, the verifier outputs TRUE or FALSE.

We usually insist on the following:

* The prover has **unlimited** computational power, but might not be telling the truth.
* The verifier has some bounded computational power (perhaps we insist that the verifier runs in polynomial time, or probabilistic polynomial time), but is always honest.

In what sense is this a proof system? Essentially, we say that a language $X$ has a "proof system" if there is a verifier We need two properties:

* **Completeness**: if $x \in L$, then any honest "prover" can convince the verifier that $x \in L$, and
* **Soundness**: if $x \not \in L$, then no "prover" (honest or not) can convince the verifier that $x \in L$.

The words "convince" here often refers to some sort of probability, so it suggests having some sort of probabilistic verifier.

## Example

Recall the problem of checking if two graphs are isomorphic. We have seen before that this problem is in **NP**: the certificate would just be the isomorphism. The complement is in **coNP**; we don't exactly have a quick way of determining if two graphs are *not* isomorphic. But if we allow interaction, we do!

Here is the protocol. Suppose we are given two graphs $G_1$ and $G_2$. Both $V$ and $P$ can see them. I'll refer to $V$ as the verifier, and $P$ as the prover.

* $V$ picks between $G_1$ and $G_2$ randomly (call the graph it picks $G$).
* $V$ then randomly renames the vertices of $G$ to get a new graph $H$ (which is isomorphic to $G$). $V$ sends $H$ to $P$.
* $P$ determines if $H$ came from $G_1$ or from $G_2$. It responds with 1 or 2 accordingly.
* $V$ then verifies that $P$'s response matches with the graph it originally chose.

Notice that if $G_1 \not \cong G_2$, then there is a prover which knows this, and so such a prover would be able to tell, immediately, which of $G_1$ or $G_2$ is used to create $H$ each time. In other words, if $G_1 \not \cong G_2$, then the probability of the verifier saying that they are not isomorphic, in this protocol, is exactly 1. But if they are isomorphic, then the best any prover can do is just guess: any $H$ which $V$ could send could theoretically come from either $G_1$ or from $G_2$, so the probability that $V$ would say that they are not isomoprhic is at most $\frac{1}{2}$. If we repeat this protocol enough times, we can reduce this probability to $\frac{1}{4}$ (or even $\frac{1}{2^k}$ if we wish).

In other words, an honest prover can convince us that two graphs that are not isomorphic are, in fact, not isomorphic, and no prover can consistently convince us that two isomorphic graphs are not isomorphic.

## Model

Let's go back to the definition of the interactive proof system. We will define a **verifier** and a **prover**. A **verifier** is a function $V$ which takes in:

1. an **input string** $x$,
2. a **random input** $r$, and
3. the **message history** $\langle a_1, a_2, \ldots, a_i \rangle$.

Then $V(x, r, a_1, \ldots, a_i)$ will either output the next message, $a_{i+1}$, or it will output "YES" (1) or "NO" (0). The randomized input is to simulate a "probabilistic" algorithm (instead of allowing the machine to make its own probabilistic choices).

The **prover** is a function $P$ with unlimited computational ability. It's defined to be a function with two inputs:

1. the **input string** $x$,
2. the **message history** $\langle a_1, a_2, \ldots, a_i \rangle$.

Then $P(x, a_1, \ldots, a_i)$ outputs the next message $a_{i+1}$. Then for an input string $x$ and random input $r$, we write $(V \leftrightarrow P)(x, r) = 1$ if there is a sequence of messages $a_1, \ldots, a_k$ such that for even numbers $i$, $V(x, r, a_1, \ldots, a_i) = a_{i+1}$, for odd numbers $i$, $P(x, a_1, \dots, a_i) = a_{i+1})$, and at stage $k$, we have $V(x, r, a_1, \ldots, a_k) = 1$ (YES). We similarly define $(V \leftrightarrow P)(x, r) = 0$.

Suppose $x$ has length $n$. We assume that there is a polynomial $p(n)$ such that $V$ runs in time $p(n)$, the random string $r$ has length at most $p(n)$, $k$ is at most $p(n)$, and each of the messages $a_1, \ldots, a_k$ has length at most $p(n)$.

Then we define $Pr[(V \leftrightarrow P)(x) = 1]$ to be the probability that, among all strings $r$ of length at most $p(n)$, $(V \rightarrow P)(x, r) = 1$.

**Definition**: The class $IP$ is the class of all problems $X$ such that there is a polynomial time function $V$ with the property that for some function $P$ and any function $\tilde{P}$, for every input $x$:

1. $x \in X$ implies that $Pr[(V \leftrightarrow P)(x) = 1] \geq \frac{2}{3}$, and
2. $x \not \in X$ implies that $Pr[(V \leftrightarrow P)(x) = 1] \leq \frac{1}{3}$.

That is: if $x \in X$, then an *honest* prover can convince $V$ that $x \in X$ about 2/3 of the time, but if $x \not \in X$, then no prover (no matter how deceptive) can convince $V$ that $x \in X$ more than 1/3 of the time.

**Theorem**: IP = PSPACE.

We will skip the details of this proof (I will leave it to you to look at the text if you're interested).

# Related Systems

* MIP: multiprover interactive proof systems. What if we allow for two independent provers?
  * Provers can discuss a strategy before talking to the verifier, but they cannot talk to each other during the interaction.
  * It's like a police investigating two suspects independently.
  * **Theorem**: MIP = NEXPTIME!
* $MIP^*$: multiprover interactive proof system with two quantum-entangled provers!
  * **Theorem** (2020): $MIP^* = RE$.
  * RE is the class of all *recursively enumerable* problems.
  * A problem $X$ is *recursively enumerable* if there is a Turing Machine $M$ such that $x \in X$ if and only if $M(x) = 1$. (Importantly, if $x \not \in X$, $M(x)$ might never output anything!)
  * This includes problems that are not even solvable!

# Problem Set 4

1. Let $q \in (.5, 1)$ be any real number. Consider the variant of BPP called $BPP_q$, defined to be the class of all problems $X$ for which there is a probabilistic TM $P$ such that if $x \in X$, then $Pr(P(x) = 1) \geq q$, and if $x \not \in X$, then $Pr(P(x) = 1) \leq 1 - q$. Show that $BPP = BPP_q$.
2. Let $n = 209$ and $a = 15$. Then $n - 1 = 208 = 13 \times 2^4$
   * Compute $15^1$, $15^2$, $15^4$, and $15^8$ mod 209.
   * Compute $15^{13} = 15^1 \times 15^4 \times 15^8$ mod 209.
   * Continue through the rest of the steps of the Miller-Rabin algorithm for $n = 209$ and $a = 15$. Does this output prime or composite?
3. A **quadratic residue** mod $n$ is a number $x$ such that there is some $z$ such that $x \equiv z^2$ (mod $n$). Consider the following protocol that proves whether $x$ is a quadratic residue modulo $n$.
   * On input $x$ and $n$, $V$ asks $P$ for some (random) quadratic residue $y$ (so $P$ knows that there is a $v$ such that $y \equiv v^2$ (mod $n$); $V$ does not know $v$).
   * $V$ randomly chooses 0 or 1 and sends it to $P$. Call this number $i$.
   * $P$ computes $w = z^i v$ (mod $n$), where $z$ is such that $z^2 \equiv x$ (mod $n$), and then sends $w$ to $V$.
   * $V$ checks if $w^2 \equiv x^i y$ (mod $n$) and outputs 1 or 0 in that case.

Show that if $x$ is a quadratic residue, then $V$ always outputs 1.
4. Pick your favorite (most interesting) open problem from this semester. State the problem, explain what it means, and explain why you think it's interesting. Alternatively: pick one concept from this semester that you thought was interesting, explain it in detail and explain what you thought was interesting about it.
