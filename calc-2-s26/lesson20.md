# Calculus II Lesson 20: Convergence Tests
{: .no_toc}

1. Table of Contents
{:toc}

# Presentations

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

# Divergence Test

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/ABSs3CqJOSk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

Geometric series are particularly nice, but there are other series as well. Let's look at the constant series $\sum\limits_{n = 0}^{\infty} \frac{1}{2}$. It should be clear that this diverges: the partial sums are $\frac{1}{2}, 1, \frac{3}{2}, 2 \frac{5}{2}, \ldots$ which continue to get bigger and bigger. Similarly, the series $\sum\limits_{n = 0}^{\infty} \frac{1}{1000000}$ also diverges, even if it grows pretty slowly. Moreover there is a nice theorem that generalizes both of these:

**Theorem**: If $\lim\limits_{n \rightarrow \infty} a_n \neq 0$, then $\sum\limits_{n=0}^{\infty} a_n$ diverges.

That is: if the limit of a sequence either does not exist, or exists but is not 0, then the sum of that sequence diverges. This is known as the **Divergence Test**.

For example, the series $0 + \frac{1}{2} + \frac{2}{3} + \frac{3}{4} + \frac{4}{5} + \ldots$ diverges, since the sequence can be written as $a_n = \frac{n}{n+1}$. This sequence approaches $1$, and so the series diverges.

## Converse?

The Divergence Theorem tells you directly which series diverge. But does it tell you anything about which series must converge? Not necessarily. For example, let's look at the "Harmonic Series" $\sum \frac{1}{n}$:

* $1 + \frac{1}{2} + \frac{1}{3} + \frac{1}{4} \geq 2$, since $\frac{1}{3} + \frac{1}{4} \geq \frac{1}{2}$.
* $1 + \frac{1}{2} + \ldots + \frac{1}{8} \geq 2.5$, since $\frac{1}{5} + \frac{1}{6} + \frac{1}{7} + \frac{1}{8} \geq \frac{1}{2}$
* $1 + \ldots + \frac{1}{16} \geq 3$, for similar reasons.

This series diverges! It goes off to infinity quite slowly, but it does, in fact, go off to infinity. How can we tell?

# Integral Test

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/cmXIKn6A0Co" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

One way to tell is by graphing the function $f(x) = \frac{1}{x}$ and drawing in the "Riemann sum" approximations.

<img src="https://openstax.org/resources/6f54f61c1ccfb6a0dc8dbcd8be64b5333e7a35b0" alt="Figure 5.12 from the textbook: the sum of 1 + 1/2 + 1/3 + 1/4 + ... is larger than the integral from 1 to infinity of 1/x" />

Notice that the rectangles are all above the graph, and, therefore, we can see:

$$\sum_{n = 1}^{\infty} \frac{1}{n} \geq \int_1^{\infty} \frac{1}{x} dx$$

Further, we know how to compute this integral: since the antiderivative of $\frac{1}{x}$ is $\ln(x)$, this integral can be computed as the limit as $b \rightarrow \infty$ of $\ln(b) - \ln(1)$, which is $\infty$. Therefore, the series must also diverge.

Similarly, let's look at the series $\sum\limits_{n = 1}^{\infty} \frac{1}{n^2}$. We can similarly compare it to the integral of $f(x) = \frac{1}{x^2}$. In fact, there are two ways we can compare it:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/iauoqi5fcb?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

and

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/q8nhlmziwl?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Notice that this means that if

$$\int_1^\infty \frac{1}{x^2} dx$$

converges, then so does

$$\sum_{n=1}^{\infty} \frac{1}{n^2}$$

and if the integral diverges, then so does the series. And, again, we know how to compute the integral:

$$
\begin{align}
&\lim_{b \rightarrow \infty} \int_1^b \frac{1}{x^2} dx \\
&= \lim_{b \rightarrow \infty} (-\frac{1}{b} + 1) \\
&= 1
\end{align}
$$

Since the integral converges, the series also converges. This is known as the **Integral Test**: suppose $(a_n)$ is a sequence of positive terms, and $f(x)$ is a function with the following properties:

* $f(x)$ is decreasing,
* $f(x)$ is continuous, and
* there is some $N$ such that for all $n \geq N$, $a_n = f(n)$

Then either $$\int_N^{\infty} f(x) dx \textrm{ and } \sum_{n = 1}^{\infty} a_n$$ both converge or they both diverge. Note that this does not necessarily mean that they both converge to the same value: we can see that the integral of $\frac{1}{x^2}$ from $1$ to $\infty$ converged to $1$. But the series actually converges to $\frac{\pi^2}{6}$: this is known as the [Basel problem](https://en.wikipedia.org/wiki/Basel_problem).


## Exercises

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

* If a series $\sum \mid a_n \mid$ converges, we say it converges **absolutely**.
* If not, but $\sum a_n$ converges, we say it converges **conditionally**.

It turns out that series that converge conditionally do not *respect the commutative law of addition*! (This is crazy!)

In fact: if a series converges conditionally, then:

1. There is a way to rearrange it so that it diverges, and,
2. for each real number $r$, there is a way to rearrange the series so that it converges to $r$.

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

* Power series, Taylor series
* Exam 3: Monday, 4/27 or Thursday 4/30
* Final exam: May 7 **9 AM - 11:30 AM**.
* Math/CS Career Panel April 22 5 PM.
