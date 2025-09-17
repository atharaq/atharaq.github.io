# Calculus I Lesson 6: Basic Derivatives
{:.no_toc}

1. Table of Contents
{:toc}

# Quiz

# Derivative of a Line

Recall that the graph of a function of the form $f(x) = mx + b$, where $m$ and $b$ are some fixed constants, is a straight line. THe line has slope $m$ and $y$-intercept $b$. What would the derivative of a line be?

Note that between any two points on a line, the "average rate of change" between them is just the slope. That is, rates of change on a line are always equal to $m$! So intuitively, as the two points get closer together, the average rate of change is still $m$, so the derivative should be $m$ as well. This is true! Let's prove it.

Suppose $f(x) = mx + b$. We can use either definition of the derivative to show that, at any point $x = a$, the derivative $f^\prime(a) = m$. Let's use the first definition. We need to compute ${\displaystyle\lim_{x\rightarrow a}}\frac{f(x)-f(a)}{x - a}$. Notice that $f(x) - f(a)$ is $(mx + b) - (ma + b)$. This is just $mx - ma$, or $m(x - a)$. So:

$$\lim_{x\rightarrow a} \frac{f(x)-f(a)}{x-a} = \lim_{x\rightarrow a} \frac{m(x-a)}{x - a} = m$$

So $f^\prime(a) = m$, at every point on the graph. **The derivative of a line is the slope of that line!**

## Derivative of a Constant Function

Similarly, we can use the definition of the derivative to find the derivative of a constant function. If $f(x) = k$ is a constant, then $f(x+h) = k$ also. So $\dfrac{f(x+h)-f(x)}{h} = \dfrac{k - k}{h} = \dfrac{0}{h}$. That means that $f^\prime(x) = 0$. This argument is covered in the following KhanAcademy video:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/OsPNBYmqxLo" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Exercise

Find the derivative of $f(x) = \|x\|$ at $x = 0$. Hint: the absolute value function can be defined as a piecewise function:

$$f(x)=\begin{cases}-x &\mbox{if } x < 0
\\ x &\mbox{if } x \geq 0 \end{cases}$$

Since this is a piecewise function, you will need to look at the right hand and left hand limits of $\frac{f(x)-f(0)}{x-0}$.

<details>
  <summary>Solution:</summary>

<p>$f^\prime(0)$ <strong>does not exist</strong>! Remember that limits do not always exist. Let's compute the following limits: ${\displaystyle\lim_{x\rightarrow 0^-} \frac{f(x) - f(0)}{x - 0}$ and ${\displaystyle\lim_{x\rightarrow 0^+} \frac{f(x) - f(0)}{x - 0}$.</p>

<p>As $x \rightarrow 0^-$, $f(x) = -x$. So we are looking at the limit of $\frac{-x}{x}$, which is $-1$.</p>
<p>As $x \rightarrow 0^+$, $f(x) = x$. So we are looking at the limit of $\frac{x}{x}$, which is 1.</p>
<p>Since the two one-sided limits are different, the (two-sided) limit does not exist (DNE)!</p>
</details>

## Differentiability

We've seen that not every function has a derivative at every point. Given a function $f(x)$, we say $f(x)$ is **differentiable** at $x = a$ if the derivative $f^\prime(a)$ exists. That is, if ${\displaystyle\lim_{x\rightarrow a}}\frac{f(x)-f(a)}{x-a}$ exists. Alternatively, we could have used the other definition of a derivative &mdash; they are equivalent definitions.

$f(x)$ is called a **differentiable function** if it is differentiable at every point at which it is defined. That is, if it is differentiable at each point in its domain.

**Example**: Determine if the following function is differentiable at the given points:

$$f(x)=\begin{cases}-1 &\mbox{if } x < 0
\\ 1 &\mbox{if } x \geq 0 \end{cases}$$

1. At $x = -1$.
2. At $x = 0$.
3. At $x = 1$.

# Constant Multiple and Sum Rules

As we've seen, the definition of the derivative is somewhat cumbersome to use. Instead of using this definition forever, we will first try to prove some rules about the derivative. We would then be able to use what we've already computed, plus these rules, to figure out other examples.

You can watch the following Khan Academy video, where he goes through the two rules we will study today: the constant multiple rule and the sum rule.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/uCLZyTliZj0" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Let's work a bit *abstractly*. That is, we will use properties of functions, rather than concrete examples of functions.

Our first rule will be the **constant multiple rule**. Let's say that we have a function $f(x)$ that we know has a derivative at $x = a$. Let's say that $f^\prime(a) = c$. If $g(x)$ is equal to some constant multiple of $f(x)$, say $g(x) = k f(x)$, then we want a rule that will tell us $g^\prime(a)$ in terms of $f^\prime(a)$. Let's compute $g^\prime(a)$:

$$\begin{align}
\lim_{x\rightarrow a} \frac{g(x)-g(a)}{x-a} &= \lim_{x\rightarrow a} \frac{kf(x) - kf(a)}{x - a} \\
&= \lim_{x\rightarrow a} k \frac{f(x) - f(a)}{x - a} \\
&= k \lim_{x \rightarrow a} \frac{f(x) - f(a)}{x - a} \\
&= k f^\prime(a)
\end{align}$$

This means that $g^\prime(a)$ exists, and is equal to $k$ times $f^\prime(a)$. This is the **constant multiple rule**: if $f(x)$ is differentiable, then for any constant $k$, $kf(x)$ is differentiable, and $(kf(x))^\prime = kf^\prime(x)$.

For example, we have seen that if $f(x) = x^2$, then for each $x$ value, the derivative exists, and $f^\prime(x) = 2x$. What should that mean for a function like $g(x) = 3x^2$? In this case, $g(x) = 3f(x)$, so by the constant multiple rule, $g^\prime(x) = 3f^\prime(x)$. So that means $g^\prime(x) = 3 \times 2x = 6x$.

## Exercise

Determine the derivative of $f(x) = 5x^2$.

<details>
  <summary>Check your answer</summary>
  <p>Since the derivative of $x^2$ is $2x$, the derivative of $5x^2$ is $5 \times 2x$, which is $10x$.</p>
</details>

## Sum Rule

Now let's suppose that $f(x)$ and $g(x)$ are two functions that are both differentiable at $x = a$. What would the derivative of the function $h(x) = f(x) + g(x)$ be at $x = a$? It's again what we might expect: $h^\prime(a) = f^\prime(a) + g^\prime(a)$. Let's see how this works.

Again, we need to compute ${\displaystyle \lim_{x\rightarrow a}}\frac{h(x)-h(a)}{x - a}$. The numerator is $(f(x)+g(x)) - (f(a) + g(a))$. Group the $f$'s together and the $g$'s together, and the numerator is $(f(x) - f(a)) + (g(x) - g(a))$. So we need to compute the limit ${\displaystyle \lim_{x\rightarrow a}}\frac{(f(x) - f(a)) + (g(x) - g(a))}{x - a}$. By separating this into two fractions, we get:

$$\lim_{x\rightarrow a} \frac{f(x) - f(a)}{x - a} + \frac{g(x) - g(a)}{x - a}$$

which is just $f^\prime(a) + g^\prime(a)$.

## Exercises

Recall that $(x^2)^\prime = 2x$, and for any linear function, $(mx + b)^\prime = m$. Find the derivatives of the following functions:

1. $f(x) = 3x^2 + 5x$
2. $g(x) = 2x^2 + 3x + 1$
3. $h(x) = x^2 - 2x + 1$

<details>
<summary>Check your answers</summary>
<ol>
<li>$f^\prime(x) = 6x + 5$. Take the derivative of each term, so $(3x^2)^\prime$ is $6x$, and $(5x)^\prime$ is $5$.</li>
<li>Again take the derivative of each term: $(2x^2)^\prime$ is $4x$, $(3x)^\prime$ is $3$, and $(1)^\prime$ is 0, so the derivative of $4x + 3$.</li>
<li>$h^\prime(x) = 2x - 2$</li>
</ol>
</details>

# Notations

Let's continue discussing derivatives. First a bit of notation. There are a few ways in which we might refer to taking a derivative. They all mean the same thing

* We might refer to the derivative of $f(x)$ as $f^\prime(x)$
* If $y$ is defined as a function of $x$, we might refer to the derivative of $y$ with respect to $x$ as $\dfrac{dy}{dx}$.

The $\dfrac{dy}{dx}$ notation is meant to evoke the "average rate of change" $\dfrac{\Delta y}{\Delta x}$. The idea is, as $\Delta x \rightarrow 0$, $\dfrac{\Delta y}{\Delta x} \rightarrow \dfrac{dy}{dx}$.

# Reminders

* DeltaMath HW 3 due tonight.
* Written HW 4 due Monday.
* DeltaMath HW 4 due next Thursday.
