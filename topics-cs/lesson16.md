# Topics in Advanced Computing Lesson 16: Randomized Algorithms
{:.no_toc}

1. Table of Contents
{:toc}

# Randomized Computation

We will now study complexity classes given by *randomized* algorithms. First we will need to define *probabilistic* Turing Machines, and then we will define a complexity class that corresponds to polynomial time probabilistic algorithms. These kinds of algorithms, if we were to try to produce one in real life, would require some sort of true random number generator. It is open whether any actually exist, but actually this will lead us into another complexity class I wish to discuss later in the semester: *quantum* algorithms.

Consider a *nondeterministic TM* $N$. Instead of saying that, for an input $w$, $N(w) = 1$ if there is *some* sequence of nondeterministic choices it can make resulting, eventually, in an output of 1, we can instead think of the nondeterministic machine as making its choices randomly. Then instead of saying that $N(w) = 1$, or $N(w) = 0$, we can assign a probability that $N(w) = 1$ and a probability that $N(w) = 0$.

In other words, the probability that $N(w) = 1$ is, roughly, the fraction of possible computations that $N$ can make which result in an output of 1.

We say that probabilistic TM $P$ solves a problem $X$ with error $\varepsilon$ if, for each input $x$, either $P(x) = 0$ or $P(x) = 1$, and:

1. $x \in A$ implies that $Pr[P(x) = 1] \geq 1 - \varepsilon$, and,
2. $x \not \in A$ implies that $Pr[P(x) = 0] \geq 1 - \varepsilon$.

Often times, we simplify it to just say: $P$ solves a problem $X$ if it solves a problem with error at most $\frac{1}{3}$. That is, if at least $\frac{2}{3}$ of the time, it gets the answer right.

**Definition**: Let $T : \mathbb{N} \to \mathbb{N}$ be a function.

1. We say that a probabilistic TM $P$ solves a problem $X$ in time $T$ if for every input $x$ of length $n$, $P(x)$ halts in at most $T(n)$ steps (regardless of the random choices it makes), and, if $x \in X$, then $Pr[P(x) = 1] \geq  \frac{2}{3}$, and if $x \not \in X$, then $Pr[P(x) = 0] \geq \frac{2}{3}$.
2. The class $BPTIME(T(n))$ is the collection of all problems solveable by a probabilistic TM in time $T(n)$. BPTIME stands for *Bounded-error probabilistic time*.
3. The class $BPP = \bigcup\limits_{k > 0} BPTIME(O(n^k)).$

**Question**: What's special about $\frac{1}{3}$ and $\frac{2}{3}$? (Answer: nothing! Proof is an exercise.)

# Primes

Consider the problem of determining whether a number $x$ is prime. As we've said before, the naive algorithm is *exponential*:

"On input $x$ of length $n$:
1. For each $y = 2, \ldots, \sqrt{x}$:
   * Check if $y$ is a factor of $x$.
   * If so, output 0.
   * If not, check the next $y$.
2. If we get here, output 1."

If $x$ has length $n$, $x = O(2^n)$, so $\sqrt{x} = O(2^{\frac{n}{2}})$. So this algorithm is not very efficient for large $n$. (Aside: primality testing is important for cryptography schemes: we often pick large primes to use as our "keys" for cryptographic protocols).

In the 1970s and 1980s, Gary L. Miller and Michael O. Rabin ("Ray-bin") devised a probabilistic, polynomial-time algorithm using number theory which determines if a number is prime (with a small error). This turned out to be the best known algorithm until 2002, when Agrawal, Kayal and Saxena proved that the problem can be solved with a deterministic polynomial time algorithm. We will only study the probabilistic algorithm for now.

In order to understand the probabilistic algorithm, we need to study some number theory.

## Number Theory

**Definition**: Let $a, b$ and $n$ be positive integers. Then $a \equiv b$ (mod $n$) means $n$ is a factor of $a - b$.

**Lemma**: $a \equiv b$ (mod $n$) if and only if there is an integer $r$ such that $0 \leq r < n$ and integers $q_1$ and $q_2$ such that $a = q_1 n + r$ and $b = q_2 n + r$.

The idea behind this lemma is that $r$ is the remainder upon dividing $a$ or $b$ by $n$, and $q_1$ and $q_2$ are the quotients when dividing $a$ or $b$ by $n$. Then $a \equiv b$ (mod $n$)$ means that $a$ and $b$ have the same remainder when dividing by $n$. We refer to the operation of finding the remainder after dividing by $n$ as the **mod** operation: that is, $a \mathbf{mod} n$ is the remainder $r$ when we divide $a$ by $n$.

**Theorem**: (Fermat's Little Theorem) Suppose $n$ is a prime number and $a$ is any positive integer. Then $a^n \equiv a$ (mod $n$). Moreover, if $0 \leq a < n$, then $a^{n - 1} \equiv 1$ (mod $n$).

(We won't cover this proof in class, but keeping it in the notes just in case anyone is interested):

**Proof**: We will just prove the second part, which assumes that $a$ is not divisible by $n$. We claim that no two of $a$, $2a$, $3a$, \ldots, $(n-1)a$ are congruent modulo $n$.

To see this, we prove this by contradiction. Assume that $k_1$ and $k_2$ are the least pair such that $k_1 > k_2$ and $k_1 a \equiv k_2 a$ (mod $n$). Then $k_1 a - k_2 a$ is divisible by $n$, so there is a quotient $q$ such that $k_1 a - k_2 a = qn$. Factor out a, and we get $a (k_1 - k_2) = qn$. Since $a$ is not divisible by $n$, this means that $k_1 - k_2$ is divisible by $n$. (This is a property of prime numbers: if $p$ is prime and $p$ is a factor of $ab$, then either $p$ is a factor of $a$ or $p$ is a factor of $b$). But what could the $k_1$ and $k_2$ be? They are both members of the set $\\{ 1, 2, \ldots, n - 1 \\}$, and so $k_1 - k_2$ is in the set $\\{ 1, 2, \ldots, n - 2 \\}$. $n$ is not a factor of any of these numbers, since the only multiple of $n$ less than $n$ is $0$.

Now notice that these are $n - 1$ different numbers, each with a different remainder when dividing by $n$. What are the possible remainders when dividing by $n$? They could be $0, 1, 2, \ldots, n - 1$. Since none of $a, 2a, \ldots, (n-1)a$ are divisible by $n$, their remainders can't be 0, so they all must be different numbers from the set $\\{1, 2, \ldots, n - 1 \\}$. Therefore, the product of all of the numbers $a \cdot (2a) \cdot (3a) \cdots (n-1)a$, modulo $n$, is equivalent to $a^{n-1} (n - 1)!$. That is: $$a^{n-1} (n-1)! \equiv (n-1)! \mathrm{ mod} n.$$ It turns out that, just like regular multiplication, there is a cancellation law for modular multiplication: if $xy \equiv zy$ (mod $n$), $n$ is prime and $y$ is not divisible by $n$, then $x \equiv z$ (mod $n$). (Note: when might this cancelation law fail? Think about $x = 4$, $y = 3$, $z = 2$, and $n = 6$.)

Since $(n - 1)!$ is not divisible by $n$, then, we can conclude $a^{n-1} \equiv 1$ (mod $n$).

(Note that the first part of the theorem follows from the second part!)

The converse is not true: there are numbers $n$ with the property that for all $1 \leq a \leq n - 1$, $a^{n-1} \equiv 1$ (mod $n$), but $n$ is not prime. For example: 561 has this property. Numbers that are not prime, but satisfy Fermat's Little Theorem, are called **Carmichael Numbers**. So let's try another idea.

## Square roots of 1

**Lemma**: If $p$ is a prime number and $a^2 \equiv 1$ (mod $p$), then either $a \equiv 1$ (mod $p$) or $a \equiv -1$ (mod $p$).

**Proof**: Suppose $a^2 = 1 + np$. Then $a^2 - 1 = (a - 1)(a + 1) = np$. In other words, $p$ is a factor of $(a-1)(a+1)$. In general, if $p$ is a prime number, then $p$ is a factor of $xy$ if and only if either $p$ is a factor of $x$ or of $y$. Thereofer, either $a - 1 \equiv 0$ (mod $p$) or $a + 1 \equiv 0$ (mod $p$).

## Strong probable primes

**Definition**: Let $n$ be an odd positive integer. Write $n - 1 = 2^s \cdot d$, where $d$ is odd. Let $a$ be a positive integer with no factors in common with $n$. Then $n$ is a **strong probable prime to base $a$** if either $a^d \equiv 1$ (mod $n$) or there is $k$ such that $0 \leq k < s$ such that $a^{2^k \cdot d} \equiv -1$ (mod $n$).

Let's look at $n = 13$. Then $s = 2$ and $d = 3$. Let's pick $a = 3$. We can ask: is $3^3 \equiv 1$ (mod $13$)? If so, then right away we will know that $3^12 \equiv 1$ (mod $13$). (In this case it is).

Let's try another number, $a = 5$. We ask: is $5^3 \equiv 1$ (mod $13$)? The answer is no: it's actually congruent to 8. ($5 \times 5 = 25$, which reduces to $-1$ modulo 13, and then $-1 \times 5 = -5$, which is congruent to $13 - 5 = 8$.)

So then we ask: is $5^6 \equiv \pm 1$ (mod 13)? In this case: $5^6 \equiv 8^2 \equiv -1$ (mod 13), since $64 + 1 = 65 = 13 \times 5$.

In general, if $n$ is prime, starting with $a$, if we compute $a^d$, then $a^{2d}$, then $a^{4d}$, all the way until we get to $a^{n - 1}$, we must, eventually, get $1$ by Fermat's Little Theorem. By the Lemma, either we start out with 1, or we eventually get to a -1 in this sequence. So that means: if $n$ is a prime, then it is a strong probable prime for all of its bases. Moreover, if $n$ is *not* a strong probable prime to some base $a$, then $n$ **must** be composite!

What if $n$ is not prime? If $n$ is composite, then it might still fail this primality test: there may be **strong liars**. We say that $a$ is a **strong liar** for $n$ if $n$ is composite but is also a strong probable prime to base $a$. How many are there?

**Theorem**: If $n$ is an odd prime, then $n$ is a strong probable prime to every base $a$ such that $2 \leq a \leq n -1 $. If $n$ is composite, then there are at most $\frac{n - 1}{4}$ strong liars $a$ for $n$ between $2 \leq a \leq n - 2$.

These results give us the entire idea behind the Miller-Rabin primality test:

M: "On input $n$:
1. If $n = 2$, output 1.
2. If $n = 0, 1$ or n > 2$ and is even, output 0.
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

We compute $2$, $2^2$, $2^4$, $2^8$, $2^{16}$, and $2^{32}$, modulo 99! Then we use the fact that 49 = 32 + 16 + 1, so $2^{49} = 2^32 \times 2^16 \times 2^1$.

(2, 4, 16, 58, 97, 4)

So $2^{49} = 4 \times 97 \times 2 \equiv 4 \times (-2) \times 2 = -16$ (mod 99), which is 83.

Then we check: $83^2 \equiv 58$ (mod 99), which is not $\pm 1$, so $99$ is not prime!

# Reminders

* Guest lecture next Monday
* PS 3 due next Monday
* Presentation 3 will start after Thanksgiving
