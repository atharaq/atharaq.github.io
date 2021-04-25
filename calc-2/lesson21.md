# Calculus II Lesson 21: Power Series
{: .no_toc}

1. Table of Contents
{:toc}

# Ratio Test

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/N0tBc0N1xrE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Last time we discussed the [ratio test](https://atharaq.github.io/calc-2/lesson20.html#/ratio). Recall: given a series $\sum a_n$, we look at the limits of the ratios $\|\frac{a_{n+1}}{a_n}\|$. If this limit is less than $1$, then the series converges absolutely. If it's greater than $1$, the series diverges. If it is equal to $1$, then the series converges conditionally. Here we go through two examples of using the ratio test to check for convergence of a series.

## Example 1: $\sum \frac{n}{2^n}$

First we compute $\frac{a_{n+1}}{a_n}$. Here, $a_{n+1} = \frac{n+1}{2^{n+1}}$ and $a_n = \frac{n}{2^n}$. Therefore,

$$\frac{a_{n+1}}{a_n} = \frac{n+1}{2^{n+1}} \cdot \frac{2^n}{n}$$

Simplifying, we get $\frac{n+1}{2n}$ or $\frac{1}{2} + \frac{1}{2n}$. As $n \rightarrow \infty$, this appraoches $\frac{1}{2}$. Since $\frac{1}{2} < 1$, this series **converges absolutely**.


## Example 2: $\sum \frac{n^n}{n!}$

* $a_{n+1} = \frac{(n+1)^{n+1}}{(n+1)!}$
* $a_n = \frac{n^n}{n!}$

So $\frac{a_{n+1}}{a_n} = \frac{(n+1)^{n+1}}{(n+1)!} \cdot \frac{n!}{n^n}$. Simplifying,

$$\frac{a_{n+1}}{a_n} = \frac{(n+1)^{n+1}}{(n+1) \cdot n^n}$$

Since one factor of $n+1$ cancels, we can simplify further:

$$ \frac{(n+1)^n}{n^n} = (\frac{n+1}{n})^n = (1 + \frac{1}{n})^n$$

As $n \rightarrow \infty$, $(1 + \frac{1}{n})^n \rightarrow e$. And since $e > 1$, this series **diverges**.

## Exercise

Determine if the series $\sum\limits_{n=0}^{\infty} \frac{n^2}{n!}$ converges.

<details>
<summary>Check your answer</summary>
<p>Applying the ratio test, we get $\frac{n+1}{n^2}$, which, as $n \rightarrow \infty$, approaches 0. Therefore, this series <strong>converges absolutely</strong>.</p>
</details>


# Power Series

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/niTeSUGQsdc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Polynomial functions are the easiest functions to work with in calculus. They are continuous and differentiable everywhere, we can use the power rule to take derivatives, and the "reverse" power rule to find antiderivatives. These techniques are so powerful that students often mistake *all* functions for polynomials (perhaps due to a bit of wishful thinking).

It would be nice if we could approximate any function we want using polynomials. Recall that in Calculus I, we found [linear approximations](https://atharaq.github.io/calc-1/lesson14.html#linear-approximations) to functions using derivatives. We can similarly find quadratic approximations or cubic approximations to functions. This is the idea behind **power series** (or more specifically, **Taylor series**).

**Definition**: A **power series** is an infinite sum of polynomials.

For example, we will be studying the following power series:

$$p(x) = \sum_{n = 0}^{\infty} x^n$$

Notice that when we plug in a number for $x$, we get an infinite series, and we can determine if $p(x)$ converges or not for that value of $x$ (using the convergence tests we learned about last week).
