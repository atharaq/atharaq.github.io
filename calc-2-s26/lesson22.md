# Calculus II Lesson 22: Power Series / Taylor Series
{: .no_toc}

1. Table of Contents
{:toc}

# Presentation notes

Technical communication:

* [Written communication](https://math.hmc.edu/su/wp-content/uploads/sites/10/2020/06/Writing-Math-Well-HMC-Math.pdf)
* Describe the problem as you are writing.
* Talk out the steps loudly and clearly as you are writing.
* Know what you can skip and what you shouldn't.

# Power Series

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/niTeSUGQsdc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
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
<iframe src="https://www.youtube.com/embed/A5kiabXU7uY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
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
<iframe src="https://www.youtube.com/embed/HUOE4aoJ9kg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
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
<iframe src="https://www.youtube.com/embed/sI1_eIhps5A" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
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

* Exam 3 next Thursday.