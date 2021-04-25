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

## Example: $1 + x + x^2 + \ldots$

What do we know about this function?

* $p(0) = 1 + 0 + 0^2 + \ldots = 1$.
* $p(1) = 1 + 1 + 1 + \ldots$ diverges
* $p(2) = 1 + 2 + 4 + \ldots$ also diverges.
* $p(\frac{1}{2}) = 1 + \frac{1}{2} + \frac{1}{4} + \ldots = 2$ (converges!)
* $p(-1) = 1 - 1 + 1 - 1 \ldots$ diverges.

More generally: $p(x)$ converges for all $x$ such that $\|x\| < 1$, and diverges otherwise. This is because it's a geometric series! In particular, we even know what it converges to: the series $\sum x^n$ is a geometric series with $a = 1$ and $r = x$, and so it converges to $\frac{1}{1 - x}$ for all $\|x\| < 1$.

## Derivatives and Integrals

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/A5kiabXU7uY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

The nice thing about power series is that we can use the normal rules for derivatives and integrals of polynomials. For example, since $p(x) = 1 + x + x^2 + \ldots$, $p^\prime(x) = 1 + 2x + 3x^2 + \ldots$ or $p^\prime(x) = \sum\limits_{n=0}^{\infty} (n+1) x^n$.

Symbolically, we can do something very similar using the closed form for the series. Since $p(x) = \sum\limits_{n=0}^{\infty} x^n$, taking the derivative of each term we get $p^\prime(x) = \sum\limits_{n=1}^{\infty} nx^{n-1}$. Notice that when we take the derivative, the $n = 0$ term goes away (since the derivative of a constant is 0). We can then re-write $\sum\limits_{n=1}^{\infty} nx^{n-1}$ as $\sum\limits_{n=0}^{\infty} (n+1) x^n$, by shifting the value of $n$ over by one.

Similarly, we can integrate, term-by-term, the series $p(x) = 1 + x + x^2 + x^3 + \ldots$ and, since $p(x) = \frac{1}{1 - x}$ when $\|x\| < 1$, this will be the same as integrating $\frac{1}{1 - x}$, at least for those $x$ in that interval.

$$\int \sum_{n=0}^{\infty} x^n = C + \sum_{n=0}^{\infty} \frac{x^{n+1}}{n+1}$$

Or: $\int p(x) dx = C + \sum\limits_{n=1}^{\infty} \frac{x^n}{n}$

Notice that $\int \frac{1}{1-x} dx = -\ln\|1 - x\| + C$, and so for $\|x\| < 1$, this gives us a power series representation for $\ln\|1 - x\|$. In particular, since, when $x = 0$, $\ln\|1\| = 0$, we have that $-\ln\|1 - x\| = \sum\limits_{n=1}^{\infty} \frac{x^n}{n}$, for all $\|x\| < 1$.

This series converges for all $\|x\| < 1$, similar to the series $1 + x + x^2 + \ldots$ What about if $x = 1$ or $x = -1$?

If $x = 1$, we get the harmonic series $\sum \frac{1}{n}$, which we know diverges (using the integral test).

If $x = -1$, we get the *alternating* harmonic series $\sum \frac{(-1)^n}{n}$, which converges (using the alternating series test). And now we can actually see why $\sum \frac{(-1)^{n+1}}{n}$ converges to $\ln(2)$:

$$
\begin{align}
-\ln(1 - (-1)) &= \sum_{n=1}^{\infty} \frac{(-1)^n}{n} \\
-\ln(2) &= \sum_{n=1}^{\infty} \frac{(-1)^n}{n} \\
\ln(2) &= -\sum_{n=1}^{\infty} \frac{(-1)^n}{n} \\
\ln(2) &= \sum_{n=1}^{\infty} \frac{(-1)^{n+1}}{n}
\end{align}
$$

And so the series $1 - \frac{1}{2} + \frac{1}{3} - \frac{1}{4} + \ldots$ converges to $\ln(2)$.

# Radius of Convergence

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/HUOE4aoJ9kg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

We have studied the functions $f(x) = \frac{1}{1-x}$ and its "power series representation" $p(x) = \sum\limits_{n=0}^{\infty} x^n$. We notice that $p(x)$ converges $f(x)$ if $\|x\| < 1$.

Specifically, we have looked at **power series centered around $x = 0$**. A power series centered at $x = 0$ looks like a function of the form

$$f(x) = \sum_{n=0}^{\infty} a_n x^n$$

where $a_n$ is an infinite sequence. Since $f(x) = a_0 + a_1 x + a_2 x^2 + \ldots$, if we plug in $x = 0$, we get $f(0) = a_0$, and so $f(0)$ converges! What if $x \neq 0$? There are three possibilities:

1. $f(x)$ might converge for **all** $x$,
2. $f(x)$ might diverge for **all** $x \neq 0$, or,
3. there is some real number $R$ such that if $-R < x < R$, then $f(x)$ converges.

That third point can be stated as "$f(x)$ converges in some interval of radius $R$ centered around $0$." If $x = R$ or $x = -R$, $f(x)$ may or may not converge (more specific analysis might be needed for that).

More generally, we could study series centered at any $x$-value. A series centered at $x = 5$ might look like

$$p(x) = \sum_{n=0}^{\infty} a_n (x - 5)^n$$

Or even more generally, a power series centered at $x = x_0$ would look like:

$$p(x) = \sum_{n=0}^{\infty} a_n (x - x_0)^n$$

Notice that $p(x) = a_0 + a_1 (x - x_0) + a_2 (x-x_0)^2 + \ldots$, and so $p(x_0) = a_0 + 0 + 0 + \ldots$. Therefore $p(x_0)$ converges! Similarly, there are three possibilities for whether $p(x)$ converges for $x \neq 0$:

1. $p(x)$ might converge for **all** $x$,
2. $p(x)$ might diverge for **all** $x \neq x_0$, or,
3. there is some real number $R$ such that if $-R < x - x_0 < R$, then $f(x)$ converges.

This $R$ is referred to as the **radius of convergence** of the power series $p(x)$ around $x_0$. In case (1), we say that the radius of convergence is $\infty$, and in case (2), the radius of convergence is $0$.

## Determining the radius of convergence

How do we find the radius of convergence? We use the ratio test. For example, let's look at the power series $\sum \frac{x^n}{n}$. Applying the ratio test to the terms of this series, we get:

* $a_{n+1} = \frac{x^{n+1}}{n + 1}$
* $a_n = \frac{x^n}{n}$

Dividing, we get $\frac{x^{n+1}}{n + 1} \cdot \frac{n}{x^n} = x \cdot \frac{n}{n+1}$. Now we look at the limit as $n \rightarrow \infty$ of $\|x \cdot \frac{n}{n+1} \|$, which is just $\|x\|$. Since the ratio test says that the series converges absolutely if $L < 1$, we see that we must have $\|x\| < 1$. Therefore our radius of convergence is 1.

## Example: $\frac{x^n}{n!}$

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/sI1_eIhps5A" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Lastly we look at the series $f(x) = \sum\limits_{n=0}^{\infty} \frac{x^n}{n!}$. This is the series $1 + x + \frac{x^2}{2} + \frac{x^3}{6} + \frac{x^4}{24} + \ldots$ Notice two things about this series:

1. $f(0) = 1$, since $1 + 0 + 0 + \ldots = 1$.
2. $f^\prime(x) = 1 + \frac{2x}{2} + \frac{3x}{6} + \frac{4x}{24} + \ldots$ and if we simplify these fractions, we'll see: $f^\prime(x) = f(x)$.

In particular, $f(x)$ is a solution to an initial value problem:

* $y^\prime = y$
* $y(0) = 1$

If we try to solve this using our methods of solving differential equations, we would get $y = e^x$. This means, if the power series $f(x)$ converges, it **must** converge to $e^x$! So let's see where it actually converges by finding the radius of convergence.

Since $a_{n+1} = \frac{x^{n+1}}{(n+1)!}$ and $a_n = \frac{x^n}{n!}$, we can compute the ratio:

$$|\frac{a_{n+1}}{a_n}| = |\frac{x^{n+1}}{(n+1)!} \cdot \frac{n!}{x^n}|$$

Simplifying:

$$\frac{|x|}{n+1}$$

As $n \rightarrow \infty$, this approaches $0$, **no matter what $x$ is**! Therefore this power series **converges absolutely** for every $x$. In particular, we see that $f(x) = e^x$ for all $x$.

Take a look at this animation on Desmos, which shows that as we take more and more terms of this infinite sum, we get a polynomial that approximates the graph of $e^x$ really well:

<div class="desmos-container">
  <iframe src="https://www.desmos.com/calculator/tt5csokfsm?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Next time we will go the other way: starting with a series
