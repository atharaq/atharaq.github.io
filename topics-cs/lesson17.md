# Topics in Advanced Computing Lesson 17: BPP
{:.no_toc}

1. Table of Contents
{:toc}

# Problem Set Questions?

# Miller-Rabin Primality Test

M: "On input $n$:
1. If $n = 2$, output 1.
2. If $n = 0, 1$ or $n > 2$ and is even, output 0.
3. Otherewise, let $s$ and $d$ be such that $n - 1 = 2^s \cdot d$ and $d$ is odd.
4. Pick $a$ randomly between $2, \ldots, n - 2$:
5. Let $x = a^d$ **mod** $n$. For each $i = 0, \ldots, s - 1$:
   * Compute $y = x^2$ **mod** $n$.
   * If $y = 1$ and $x \neq 1$ and $x \neq n - 1$, then stop and output 0. (We've found a nontrivial square root of 1.)
   * Otherwise, set $x = y$ and continue.
6. If we get here and $x \neq 1$, output 0. Otherwise output 1."

By the theorem, if $x$ is prime, then $Pr[M(x) = 1] = 1$, and if not, $Pr[M(x) = 1] \leq \frac{1}{4}$.

**Question**: How do we compute the operation $a^d$ **mod** $n$ quickly?

Let's think about this for $n = 99$, so $n - 1 = 48 = 2 \times 49$, and $a = 2$. How would we compute $2^{49}$ **mod** 99 quickly?

We compute $2$, $2^2$, $2^4$, $2^8$, $2^{16}$, and $2^{32}$, modulo 99! Then we use the fact that 49 = 32 + 16 + 1, so $2^{49} = 2^{32} \times 2^{16} \times 2^1$.

(2, 4, 16, 58, 97, 4)

So $2^{49} = 4 \times 97 \times 2 \equiv 4 \times (-2) \times 2 = -16$ (mod 99), which is 83.

Then we check: $83^2 \equiv 58$ (mod 99), which is not $\pm 1$, so $99$ is not prime!

## Analysis

What's the running time of this? Can we show that this runs in polynomial time (probabilistically)?

# BPP vs PH

**Lemma**: BPP = coBPP.

**Proof**: Suppose $P$ is a probabilistic algorithm that solves $X$. Notice that one can easily modify $P$ to a probabilistic algorithm that solves $\bar{X}$: if at some stage $P$ outputs 0, just output 1 instead, and vice versa.

This shows that $X \in BPP$ if and only if $\bar{X} \in BPP$, which means, $X \in BPP$ if and only if $X \in coBPP$.

**Theorem**: $BPP \subseteq \Sigma^P_2 \cap \Pi^P_2$.

We won't prove this theorem. Instead, let's discuss an easier result:

**Theorem**: $BPP \subseteq PSPACE$.

How would we prove this? Given a probabilistic algorithm $P$ which solves $X$, how would we show that there is a deterministic algorithm $M$ which solves $X$, using at most polynomial space?

**Idea**: Similar to the idea that $NP \subseteq PSPACE$. We simulate $P$ using all of its possible "random choices", re-using space when needed.

## BPP vs RP

**RP** (randomized polynomial time) is the class of those problems $X$ such that there is a probabilistic algorithm $P$, running in polynomial time, such that on input $x$:

* if $x \in X$, then $Pr[P(x) = 1] \geq \frac{2}{3}$, and
* if $x \not \in X$, then $Pr[P(x) = 0] = 1$.

Note: what did the primality algorithm show? We actually saw that $PRIMES \in BPP$. That algorithm is always correct for prime numbers, and is mostly correct for composite nubmers.  The class RP is the class of those problems X for which an algorithm exists which is usually correct for objects in X, and always correct for objects not in X.

**Theorem**: The COMPOSITE number problem is in RP. That is, there is a polynomial time randomized algorithm which, given a composite number, usually outputs "composite", and given a prime number, always outputs "prime".

**Questions**:

1. RP vs BPP?
2. RP vs NP?

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

# Reminders

* Guest lecture next Monday
* PS 3 due next Monday
* Presentation 3 will start after Thanksgiving
