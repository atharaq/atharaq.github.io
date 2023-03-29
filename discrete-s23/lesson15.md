# Discrete Mathematics Lesson 15: Big Oh, Big Theta, Recurrence Relations
{:.no_toc}

1. Table of Contents
{:toc}

# Warm up:

Express the number 125 (decimal) in each of the following numbers in binary, octal and hexadecimal.

## Notation (C++ / Java)

Instead of subscripts, prefixes are used in some programming languages. For Java, C++, and probably others:

* 0b10 represents the **binary number** 10 (ie the number two)
* 0x10 represents the **hexadecimal number** 10 (ie sixteen)
* 0d10 represents the **decimal number** 10 (ten)
* 010 represents the **octal number** 10 (eight)

## PS4 Questions?

# More catch up:

* [Number Theory](lesson13.html#number-theory)
* [Binary Arithmetic](lesson13.html#binary-arithmetic)
* [Representing Data](lesson13.html#representing-data)

# Sizes / Data Representations

* $n$ bits: numbers $0$ through $2^n - 1$
* $n$ digits: numbers $0$ through $10^n$ - 1, etc
* How many bits to represent the number $n$?
  * $\lfloor \log_2(n) \rfloor + 1$

# Growth of Functions / Big Oh

Example: UNIX Time

* UNIX systems originally store time as a **signed 32-bit integer**
  * Seconds after the "epoch" January 1 1970 (00:00:00 UTC)
  * Signed 32 bits: 1 bit for $\pm$, 31 bits for data
  * Maximum value: $2^{31} - 1$ = 2,147,483,647.
  * 2,147,483,647 seconds $\approx$ 68 years.
  * Integer overflow on January 19, 2038 at 03:14:07
* Solution? Use more bits (not always a solution, but ok)

## 64-bit time

* **signed 64-bit integers**: maximum value $2^{63} - 1 \approx 9 \times 10^{18}$.
* Or $\approx$ 290 billion years.
* Age of the universe $\approx$ 14 billion years
* Solar system dies in $\approx$ 7-8 billion years.

**Moral of the story**: Exponential functions grow "ridiculously fast"! Doubling the number of bits squares the magnitude of the numbers we can represent

How can we make the statement that exponential functions grow "ridiculously fast" precise? More specifically, how can we say exponential functions grow faster than polynomials? Conversely, how do we express the idea that logarithmic functions grow slower than linear functions?

## Big Oh

**Definition**: Let $f : \mathbb{N} \to \mathbb{R}$ and $g : \mathbb{N} \to \mathbb{R}$. We say $f \in O(g)$, or, abusing notation, $f(x) = O(g(x))$, if there is $N \in \mathbb{N}$ and a positive real number $k$ such that for all $n \geq N$, $$|f(n)| \leq k \cdot |g(n)|$$

## Examples

$f(n) = n^3$, $g(n) = 2^n$. Claim: $n^3 = O(2^n)$.

* $f(0) = 0, g(0) = 1$
* $f(1) = 1, g(1) = 2$
* $f(2) = 8, g(2) = 4$
* $f(3) = 27, g(3) = 8$
* $\vdots$
* $f(10) = 1000, g(10) = 1024$. Aha!

$\forall n \geq 10 (n^3 \leq 2^n)$ Proof? Really what we want to show is: $\lim\limits_{n \rightarrow \infty} \frac{n^3}{2^n} = 0$

Solution: l'Hopital's rule:

$$
\begin{align}
\lim_{n \rightarrow \infty} \frac{n^3}{2^n} &= \lim_{n \rightarrow \infty} \frac{3n^2}{\ln(2) 2^n} \\
&= \lim_{n \rightarrow \infty} \frac{6n}{\ln(2)\ln(2) 2^n} = \lim_{n \rightarrow \infty} \frac{6}{\ln(2)\ln(2)\ln(2) 2^n}\\
&= 0
\end{align}
$$

## Exercises

* Show that $\log_2(n) = O(n)$.
* Show that $n \neq O(\log_2(n))$.
* Show that $\log_b(n) = \ln(n)$ for any $b > 1$.

## Connection between limits and Big Oh?

**Theorem**: If $\lim\limits_{n \rightarrow \infty} |\frac{f(n)}{g(n)}| = L < \infty$, then $f(n) = O(g(n))$.

What does this limit mean?

$$\forall \varepsilon > 0 \exists N \forall n \geq N  ( L - \varepsilon < |\dfrac{f(n)}{g(n)}| < L + \varepsilon)$$

* Let $\varepsilon = 1$.
* Then $\exists N \forall n \geq N |f(n)| \leq (L + 1)g(n)$.
* So $f(n) = O(g(n))$ by definition ($k = L + 1$).

## Converse?

If $f(n) = O(g(n))$, must $\lim\limits_{n\rightarrow \infty} \frac{f(n)}{g(n)}$ exist?

Hint: what about $f(n) = \sin(\frac{n \pi}{2})$, $g(n) = 1$?

It turns out that the actual converse uses "lim sup", not limits.

## General Big Oh facts (Prove these)

* $n^k = O(n^m)$ whenever $k \leq m$
* $\log(n) = O(n^k)$ for any **positive real number** $k$
* $a_0 + a_1 n + \ldots + a_k n^k = O(n^k)$.
  * Hint: $a_0 + a_1 n + \ldots + a_k n^k \leq |a_0| n^k + |a_1| n^k + \ldots + |a_k| n^k$ for all $n \geq 0$.
* $n^k = O(2^n)$ (for any positive real $k$)
* $2^n = O(n!)$
* $n! = O(n^n)$
* There are intermediates: e.g. $n\log(n) = O(n^2)$

## "Big Omega" and "Big Theta"

* $f = \Omega(g)$ if there are $N \in \mathbb{N}$ and a positive real $k$ such that for all $n \geq N$, $f(n) \geq k|g(n)|$.
* $f = \Theta(g)$ if $f = O(g)$ and $f = \Omega(g)$

$f = \Omega(g)$ if and only if $g = O(f)$. So roughly: $f = \Theta(g)$ means $f = O(g) and $g = O(f)$.

**Example**: $f(n) = 2n^2 - 3n + 1$, $g(n) = n^2$. $f = \Theta(g)$. Why?

# Big Oh / Big Theta

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/hm3zxd8s254" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Again: for functions $f : \mathbb{N} \to \mathbb{R}$ and $g : \mathbb{N} \to \mathbb{R}$, we say $f = O(g)$ ($f$ is "Big Oh" of $g$) if there is $N \in \mathbb{N}$ and $k \in \mathbb{R}$ such that for all $n \geq N$, $f(n) \leq k \cdot \|g(n)\|$. In symbols:

$$\exists N \in \mathbb{N} \exists k \in \mathbb{R} \forall n \in \mathbb{N} (n \geq N \rightarrow f(n) \leq k \cdot |g(n)|)$$

**Example**: Let $f(n) = an + b$, for some constants $a, b \in \mathbb{R}$. Assume that $f(n) \geq 0$ for all $n \in \mathbb{N}$ (we can prove the statement more generally, but the assumption helps simplify the proof so we don't have to worry about absolute values). We show that $f(n)$ is $O(n^2)$, and $n^2$ is **not** $O(n)$:

**Proof**:

First, notice that if $an + b \geq 0$, then, letting $n = 0$, we conclude that $b \geq 0$. Further, if $a < 0$, then letting $n > -\dfrac{b}{a}$ would imply that $an + b < 0$, which contradicts our assumption. Therefore $a \geq 0$ as well.

Next, if $n \geq 1$, $b \leq bn$. Therefore $an + b \leq an + bn$, for every $n \in \mathbb{N}$ such that $n \geq 1$. Let $k = a + b$, and so $an + b \leq kn$, for every $n \in \mathbb{N}$.

Before we finish the proof, let's first show that for all $n \in \mathbb{N}$, $n \leq n^2$. An important property of the ordering ($<$ and $>$) of real numbers is that for all $a, b, c$, if $c > 0$ and $a < b$, then $ac < bc$. If $n = 0$ or $n = 1$, we see that $n = n^2$. If $n > 1$, letting $a = 1, b = n$ and $c = n$ from the ordering property above shows that $n < n^2$.

Now continue the proof we started above. Since $n \leq n^2$ for every $n \in \mathbb{N}$ and $k \geq 0$, we have $kn \leq kn^2$, and therefore $an + b \leq kn \leq kn^2$ for every $n \geq 1$. Therefore, $N = 1$ and the $k$ we found above work to show that $an + b \leq k n^2$ for all $n \geq N$.

Now we show that $n^2$ is **not** $O(n)$. Recall how to negate quantifiers: we want to show that the following statement is false:

$$\exists N \in \mathbb{N} \exists k \in \mathbb{R} \forall n \in \mathbb{N} (n \geq N \rightarrow n^2 \leq kn)$$

That means that we want to show its negation is true. Negating quantifiers and conditionals is tricky, but we should end up with the following statement that we want to prove:

$$\forall N \in \mathbb{N} \forall k \in \mathbb{R} \exists n \in \mathbb{N} (n \geq N \wedge n^2 > kn)$$

So let $N \in \mathbb{N}$ and $k \in \mathbb{R}$ be given. We want to find $n \in \mathbb{N}$ that is greater than $N$ such that $n^2 > kn$. If $k \leq 0$, we are done: any $n > N$ would work, since $n^2 > 0$ for all $n > 0$. So assume $k > 0$. If $n > k$, then $n^2 > kn$. So let $n$ be any natural number greater than the maximum of $k$ and $N$.

**Exercise**: Show that $n$ is **not** $O(\sqrt{n})$.

<details>
    <summary>Check your answer</summary>
    <p>Let $N \in \mathbb{N}, k \in \mathbb{R}$ be given. We want $n \geq N$ such that $n > k \sqrt{n}$. If $k \leq 0$, then any $n \geq 1$ will suffice. So we assume $k > 0$. Let $n$ be large enough such that $\sqrt{n} > k$. Then $n > k \sqrt{n}$, using the property that if $a < b$ and $c > 0$, then $ac < bc$. Therefore, letting $n$ be larger than the maximum of $N$ and $k$ proves the result.
    </p>
</details>

## Transitivity

Suppose $f$ is $O(g)$ and $g$ is $O(h)$. Must it be true that $f$ is $O(h)$? The answer is **yes**: Big Oh is transitive! I'll start the proof here, and let you finish the details on your own.

**Proof**: Suppose $f$ is $O(g)$. Then there are $N_1 \in \mathbb{N}$ and $k_1 \in \mathbb{R}$ such that for all $n \geq N$, $f(n) \leq k_1 \|g(n)\|$. Similarly, there are $N_2$ and $k_2$ such that for all $n \geq N_2$, $g(n) \leq k_2 \|h(n)\|$. ...

(Finish the proof of this on your own!)

## $\log(n)$ and $\sqrt{n}$

Last time we saw that $\log_2(n)$ is $O(\ln(n))$. Show that $\ln(n)$ is $O(\sqrt{n})$, and conclude, then, using transitivity, that $\log_2(n)$ is $O(\sqrt{n})$.

Hint: Use l'Hopital's rule to find the limit as $n \rightarrow \infty$ of $\dfrac{\ln{n}}{\sqrt(n)}$. Use the [theorem we proved earlier](#connection-between-limits-and-big-oh) to conclude that $\ln(n)$ is $O(\sqrt{n})$. Then use transitivity.

<details>
    <summary>Check your solution.</summary>
    <p>By l'Hopital's rule,
        $$
        \begin{align}
        \lim_{n\rightarrow \infty} \frac{\ln{n}}{\sqrt{n}} &= \lim_{n \rightarrow \infty} \frac{n^{-1}}{.5n^{-.5}} \\
        &= \lim_{n\rightarrow \infty} \frac{2}{\sqrt{n}} \\
        &= 0
        \end{align}
        $$ By the theorem, this implies that $\ln(n)$ is $O(\sqrt{n})$. Since we already know that $\log_2(n)$ is $O(\ln(n))$ and that Big Oh is transitive, this implies $\log_2(n)$ is $O(\sqrt{n})$ also.
    </p>
</details>

In general, since for all base $b$, $\log_b(n)$ are all equivalent according to Big Oh (and in fact according to Big Theta), in computer science we usually just use $\log(n)$ to represent *any* logarithmic function. Usually, the base that matters most in CS applications is base 2, but if we need to use calculus it may be easier to use $\ln$, as we saw above.

## Degree one functions

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/lHWfvw91t08" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Let $f(n) = an + b$ and $g(n) = cn + d$, for $a, b, c, d \in \mathbb{R}$ (some constants), with $a, c \neq 0$. Assume that $f(n) \geq 0$ and $g(n) \geq 0$ for all $n \in \mathbb{N}$ (this makes the proof simpler, so that we can ignore absolute values). Show that $f(n)$ is $\Theta(g(n))$.

**Proof**: We actually just show that for any $a, b \in \mathbb{R}$, if $an + b \geq 0$ for all $n \in \mathbb{N}$, then $an + b$ is $\Theta(n)$. Think about why this suffices to prove the statement above.

We find $N_1, N_2, k_1, k_2 \in \mathbb{R}$ such that for all $n \geq N_1$, $an + b \leq k_1 n$ and for all $n \geq N_2$, $n \leq k_2 (an + b)$.

As we saw before, if $an + b \geq 0$ for all $n \in \mathbb{N}$, then $a, b \geq 0$. Now, since $b < bn$ for all $n > 1$, $an + b \leq an + bn$ for all $n > 1$. Therefore $an + b \leq (a + b)n$ for all $n > 1$. Let $k_1 = a + b$ and $N_1 = 2$, and conclude that for all $n \geq N_1$, $an + b \leq k_1 n$.

For the other direction, let $k_2$ be such that $k_2a \geq 1$. Because $a \geq 0$, we must have that $k_2 \geq 0$. Therefore $k_2 (an + b) \geq n + k_2 b \geq n$ for all $n \in \mathbb{N}$, since $k_2 \geq 0$ and $b \geq 0$. Let $N_2 = 0$ and conclude that for all $n \geq N_2$, $n \leq k_2(an + b)$.

**In general**: any two polynomials $f(n)$ and $g(n)$ are equivalent according to Big Oh / Big Theta (ie, $f = O(g)$ and $g = O(f)$) if they have the same degree. Coefficients do not affect Big Oh at all, and neither do lower-degree terms. $n$ and $10000n$ are in the same "Big Oh" class.
