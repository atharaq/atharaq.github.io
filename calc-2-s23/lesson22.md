# Calculus II Lesson 22: Taylor Series
{: .no_toc}

1. Table of Contents
{:toc}

# Warm up

**Hand in**: Consider the series $p(x) = \sum_{n=0}^{\infty} \frac{x^n}{n!}$.

1. Show that $p(x)$ converges for every real number $x$.
2. Show that $p(x)$ is a solution to the differential equation $y^\prime = y$, with initial value $y(0) = 1$.
3. Find another function which satisfies that same differential equation.

<details>
<summary>Graph of power series</summary>
<div class="desmos-container">
  <iframe src="https://www.desmos.com/calculator/tt5csokfsm?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>
</details>

# Power Series

Last time:

* Power series
* Radius of convergence (ratio test)

# Taylor series

We saw, above, that the power series for $e^x$ is $1 + x + \frac{x^2}{2} + \ldots$ by starting with the power series, and figuring out that it converged to $e^x$. But in reality, we'd like to start with a function, and find its power series.

In other words: start with $f(x) = e^x$. Can we find $g(x) = a_0 + a_1 x + a_2 x^2 + \ldots$ Or $g(x) = \sum\limits_{n=0}^{\infty} a_n x^n$ (centered at $x = 0$).

We want to be sure that $g(x) = f(x)$ (for as many $x$ as possible). To bring this back to the ideas from last time:

* What is the best *polynomial* representation of $f(x)$ near $x = 0$?
* Degree 1 approximation: $y = f(0) + f^\prime(0)x$
* Degree 2?

## Linear approximation

If we want a linear approximation, like $$ y = a_0 + a_1 x,$$ then we want a function $y$ with:

* Want $y(0) = f(0)$ and $y^\prime(0) = f^\prime(0)$
* Hence: $a_0 = f(0)$, $a_1 = f^\prime(0)$,
* So $y = f(0) + f^\prime(0)x$.

What if we want higher degrees?

* $g^\prime(0) = f^\prime(0)$
* $g^{\prime\prime}(0) = f^{\prime\prime}(0)$
* $g^{\prime\prime\prime}(0) = f^{\prime\prime\prime}(0)$
* etc.

# Example: $e^x$

Find a power series representation for $f(x) = e^x$.

$$g(x) = a_0 + a_1x + a_2 x^2 + a_3 x^3 + \ldots$$

Let's plug in: $g(0) = f(0)$ means that $a_0 = f(0)$.

Now take the derivative: $g^\prime(x) = a_1 + 2a_2x + 3a_3 x^2 + \ldots$ If $g^\prime(0) = f^\prime(0)$ then notice that $g^\prime(0) = a_1$, so $a_1 = f^\prime(0)$.

So far we have:

* $a_0 = f(0)$
* $a_1 = f^\prime(0)$

(This is what we knew earlier from the "linear approximation").  Since $f^\prime(x) = e^x$, these are easy to see: $a_0 = 1, a_1 = 1$.

If we stop here, we get $g(x) = 1 + x$, a **linear approximation** of $f(x) = e^x$. What about higher terms, like $a_2$?

Again: $f^{\prime\prime}(x) = e^x$, so $f^{\prime\prime}(0) = 1$. What is $g^{\prime\prime}(x)$?

* $g^{\prime\prime}(x) = 2a_2 + 6a_3x + \ldots$
* $g^{\prime\prime}(0) = 2a_2 = 1$
* So: $a_2 = \frac{1}{2}$

If we stop? $g(x) = 1 + x + \frac{x^2}{2}$. Degree two approximation. Now for $a_3$?

* $g^{\prime\prime\prime}(x) = 6a_3 + \ldots$
* At $x = 0$, $6a_3 = 1$, so $a_3 = \frac{1}{6}$.

Now: $g(x) = 1 + x + \frac{x^2}{2} + \frac{x^3}{6}$.

**Question**: What's the pattern?

$$g(x) = \sum_{n=0}^{\infty} a_n x^n$$

* $g^\prime(x) = \sum_{n=1}^{\infty} n \cdot a_n x^{n - 1}$.
* $g^{\prime\prime}(x) = \sum_{n=2}^{\infty} (n \cdot (n - 1) \cdot a_n) x^{n - 2}$.
* $g^{\prime\prime\prime}(x) = \sum_{n=3}^{\infty} (n \cdot (n - 1) \cdot (n - 2) \cdot a_n) x^{n - 3}$.
* etc.

Now plug in $x = 0$ to each of these. Only term that remains is the $x^0$ term:

* $g^{\prime}(0) = a_1$
* $g^{\prime\prime}(0) = 2a_2$
* $g^{\prime\prime\prime}(0) = 6a_3$

# Taylor Series

In general, if $f(0), f^\prime(0), f^{\prime\prime}(0)$, etc. all exist, we can form the **Taylor series** centered at $x = 0$ by letting:

* $a_0 = f(0)$
* $a_1 = f^\prime(0)$
* $a_2 = \frac{f^{\prime\prime}(0)}{2}$
* $a_3 = \frac{f^{\prime\prime\prime}(0)}{6}$
* $a_4 = \frac{f^{(4)}(0)}{24}$ (fourth derivative)

So the Taylor series for $f(x)$ centered at $x = 0$ is:

$$\sum_{n=0}^{\infty} \frac{f^{(n)}(0)}{n!} x^n$$

(We can then try to find a closed form for these terms, and ask where it converges, etc.)

# Exercise

Find a Taylor series representation for $f(x) = \cos(x)$.

Hints:

* First find $f^{\prime}(x), f^{\prime\prime}(x)$, etc. There is a pattern.
* Plug in $x = 0$ to each of these to find $a_0, a_1, a_2, a_3$, etc.
* Write it out as $\sum a_n x^n$
* See if you can find a closed form expression.

## Solution

* Derivatives: $\cos(x), -\sin(x), -\cos(x), \sin(x)$, repeating forever.
* Plugging in 0: $1, 0, -1, 0, \ldots$
* Odd terms disappear!
* So: $1 - \frac{x^2}{2} + \frac{x^4}{4!} - \ldots$
* Closed form for $1, \frac{-1}{2!}, \frac{1}{4!}, \frac{-1}{6!}, \ldots$?

## Closed form

* Alternating reciprocals of even factorials.
* $\frac{(-1)^n}{(2n)!}$

So our closed form is:

$$g(x) = \sum_{n=0}^{\infty} \frac{(-1)^n}{(2n)!} x^{2n}$$

(Notice that the power of $x$ matches the factorial. Only even powers show up here.) Look at what happens for the graph:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/sy42p5jw2o?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

## Radius of Convergence

Ratio test:

* $a_{n+1} = \frac{(-1)^{n+1}}{2(n+1)!} x^{2(n+1)}$
* $a_{n} = \frac{(-1)^{n}}{2n)!} x^{2n)}$
* Divide: $\frac{-x^2}{(2n+2)(2n+1)}$
* Absolute values and limits: as $n \rightarrow \infty$, this approaches $0$.
* Absolutely convergent.

## Derivative?

$$f(x) = 1 - \frac{x^2}{2} + \frac{x^4}{4!} - \frac{x^6}{6!} + \ldots$$

* Derivative: $f^\prime(x) = -x + \frac{x^3}{3!} - \frac{x^5}{5!} + \ldots$
* We know: $f^\prime(x) = -\sin(x)$.
* So: what's the Taylor series for $\sin(x)$ (centered at $x = 0$)?

# Arctan

Harder question: find the Taylor series for $\arctan(x)$ centered at $x = 0$. This might not be so easy. But instead, look at the derivative of $\arctan$: its' $\frac{1}{1 + x^2}$.

What's the Taylor series for that? (Also not that easy. Darn.)

What if we used something we already knew? We know that $\frac{1}{1 - x} = 1 + x + x^2 + \ldots$ Can we use that to find a Taylor series for $\frac{1}{1 + x^2}$?

* Taylor series for $\frac{1}{1-x} = 1 + x + x^2 + \ldots$
* Taylor series for $\frac{1}{1 - (-(x^2))}$?
* $1 + (-x^2) + (-x^2)^2 + \ldots$
* Or: $1 - x^2 + x^4 - x^6 + \ldots$

So now we know the Taylor series for the derivative. Then integrate: $\int (1 - x^2 + x^4 - \ldots)dx = C + x - \frac{x^3}{3} + \frac{x^5}{5} - \ldots$

Since $\arctan(0) = 0$, we get $C = 0$. Therefore we have our Taylor series: $x - \frac{x^3}{3} + \frac{x^5}{5} - \ldots$

What's the closed form? $$\sum_{n=0}^{\infty} \frac{(-1)^n}{2n+1} x^{2n+1}$$

Next: find the **radius of convergence** for this series by using the ratio test:

$$ |\frac{(-1)^{n+1} x^{2n+3}}{2n+3} \cdot \frac{2n+1}{(-1)^n x^{2n+1}} | $$

Simplifies: $$ x^2 \frac{2n+1}{2n+3}.$$

* As $n \rightarrow \infty$, $x^2 \frac{2n+1}{2n+3} \rightarrow x^2$.
* Ratio test: converges if $x^2 < 1$.
* That means: $-1 < x < 1$.
* Endpoints? Specifically, $x = 1$?

Does this converge at $x = 1$? Yes: alternating series test.

$$1 - \frac{1}{3} + \frac{1}{5} - \ldots$$

But $\arctan(1) = \frac{\pi}{4}$! So this gives us a way to compute $\pi$!

(It converges pretty slowly, so this is not the best approximation. But it does work!)

# Coming up

* Exam 3 due next Monday (5/1).
* Review on Thursday.
* Final exam sent out 5/1 (Monday), due 5/8.
* Presentation 4 due Sunday, 5/7 (about 2 weeks).
