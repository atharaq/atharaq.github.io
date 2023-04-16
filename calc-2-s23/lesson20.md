# Calculus II Lesson 20: Convergence Tests
{: .no_toc}

1. Table of Contents
{:toc}

# Questions?

* [Last week's homework](lesson17.html#homework)
* [This week's homework](lesson19.html#homework)
* MyOpenMath?
* Previous lessons:
  * Arc length / areas in polar
  * Describing Sequences / closed forms
  * Zeno's Paradox
  * $0.999\ldots$
  * Infinite series
  * Geometric series
  * Divergence Test
  * Convergence Test

# Warm-up

Use the integral test to determine if the following series converge or diverge:

1. $\sum\limits_{n=1}^{\infty} \frac{1}{\sqrt{n}}$
2. $\sum\limits_{n=1}^{\infty} \frac{1}{n^{3/2}}$

## p-series

In general:

* $\sum\limits_{n=1}^{\infty} \frac{1}{n^p}$ is called a $p$-series.
* A $p$-series converges if $p > 1$
* Diverges if $p \leq 1$.

## Comparison

Notice:

$$
\begin{align}
1 + \frac{1}{\sqrt{2}} + \frac{1}{\sqrt{3}} + \frac{1}{\sqrt{4}} + \ldots \\
\geq 1 + \frac{1}{2} + \frac{1}{3} + \frac{1}{4} + \ldots \rightarrow \infty
\end{align}
$$

Since $\frac{1}{\sqrt{n}} \geq \frac{1}{n}$ for all $n \geq 1$.

# Alternating

**Definition**: An **alternating** series is one in which the terms alternate between positive and negative.

Example: $1 - \frac{1}{2} + \frac{1}{3} - \frac{1}{4} + \ldots$

$$ = \sum_{n = 0}^{\infty} \frac{(-1)^{n}}{n+1} $$

**Examples**:

* $1 - \frac{1}{2} + \frac{1}{3} - \frac{1}{4} + \ldots$ converges! ($\rightarrow \ln(2)$)
* $1 - 1 + 1 - 1 +1 \ldots$ diverges.
* $1 - \frac{1}{3} + \frac{1}{5} - \frac{1}{7} + \ldots$...?

<details>
<summary>Does this converge?</summary>
<p>This also converges! In fact this converges to $\frac{\pi}{4}$, giving us a formula to compute $\pi$! (This converges quite slowly, though...)</p>
</details>

**Theorem**: Suppose either:

* $a_n = (-1)^n b_n$, or,
* $a_n = (-1)^{n+1} b_n$,

where $b_n \geq 0$, $\lim\limits_{n \rightarrow \infty} b_n = 0$, and $b_n$ is decreasing. Then $\sum\limits_{n=0}^{\infty} a_n$ converges.

In other words: any alternating series where the absolute values of the terms decrease and appraoch 0 converges!

**Non-example**: Does the series $1 - \frac{1}{4} + \frac{1}{2} - \frac{1}{16} + \frac{1}{4} - \frac{1}{64} + \frac{1}{8} - \ldots$ converge?

This test is **inconclusive**. $b_n = 1, \frac{1}{4}, \frac{1}{2}, \frac{1}{16}, \ldots$. Not decreasing!

## Alternating Harmonic Series

Recall the **Commutative law of addition**:

* $x + y = y + x$. Right?
* $x_1 + x_2 + x_3 + \ldots + x_n = x_7 + x_{23} + \ldots + x_2$

In other words: if you add up a bunch of numbers, you can add them in whatever order you like. We already saw, for example, that the alternating harmonic series converges to $\ln(2)$: $$1 - \frac{1}{2} + \frac{1}{3} - \frac{1}{4}  + \ldots \rightarrow \ln(2).$$

What happens when we rearrange?

$$
\begin{align}
&(1 - \frac{1}{2}) - \frac{1}{4} + (\frac{1}{3} - \frac{1}{6}) - \frac{1}{8} + (\frac{1}{5} - \frac{1}{10}) - \ldots \\
&=\frac{1}{2}(1 - \frac{1}{2} + \frac{1}{3} - \frac{1}{4} + \frac{1}{5} - \ldots
\end{align}
$$

converges to $\frac{1}{2} \ln(2)$!

## Conditional Convergence

* Alternating harmonic series converges to $\ln(2)$
* Rearranging some terms, it converges to $\frac{\ln(2)}{2}$
* This is because of **conditional convergence**!

**Definitions**:

* If a series $\sum |a_n|$ converges, we say it converges **absolutely**.
* If not, but $\sum a_n$ converges, we say it converges **conditionally**.

It turns out that series that converge conditionally do not *respect the commutative law of addition*! (This is crazy!)

# Comparison Test

Suppose $0 \leq a_n \leq b_n$. Then:

1. If $\sum b_n$ converges, then $\sum a_n$ converges.
2. If $\sum a_n$ diverges, then $\sum b_n$ diverges.

"If the bigger series converges, so does the smaller series. If the smaller series diverges, so does the bigger series."

**Example**:

$$\sum_{n = 1}^{\infty} \frac{1}{n^2 + 1}$$

* Compare with $\sum\limits_{n = 1}^{\infty} \frac{1}{n^2}$: converges ($p$-series).
* Notice: $\frac{1}{n^2 + 1} \leq \frac{1}{n^2}$ for all $n$.
* (Algebra)
* The bigger series converges.
* So this also converges!

**Example 2**:

$$\sum_{n = 1}^{\infty} \frac{1}{2^n + n^2}$$

What should we compare this with?

**Example 3**:

$$1 + \frac{1}{3} + \frac{1}{5} + \ldots$$

What should we compare this with?

# Ratio

The **ratio test** is one of the most important tests for convergence we can use. Given a series $\sum a_n$, look at the *ratios*:

$$ \lim_{n \rightarrow \infty} |\frac{a_{n+1}}{a_n}| = L$$

* $L < 1$: absolute convergence
* $L > 1$: divergence
* $L = 1$: inconclusive

**Example**:

$$\sum_{n=0}^{\infty} \frac{1}{n!} = 1 + 1 + \frac{1}{2} + \frac{1}{6} + \ldots$$

* $a_{n+1} = \frac{1}{(n+1)!}$
* $a_n = \frac{1}{n!}$
* $\frac{a_{n+1}}{a_n} = \frac{n!}{(n+1)!} = \frac{1}{n+1} \rightarrow 0$
* So this series converges absolutely!
* In fact: the series converges to $e$!

**Exercise**:

Determine if the following series converge:

1. $\sum_{n = 0}^{\infty} \frac{3^n}{n!}$
2. $\sum_{n = 0}^{\infty} \frac{3^n}{(-2)^{n+1} \cdot n}$

# Upcoming

* 4/20: Power series, 4/24: Taylor series
* Exam 3 (take home) given 4/24, due May 1.
* Final exam (given May 1, due May 8)
* One more problem presentation (May 7?)