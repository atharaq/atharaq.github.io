# Calculus I Lesson 7: Derivative Rules
{:.no_toc}

1. Table of Contents
{:toc}

# Warm up

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

There are a few ways in which we might refer to taking a derivative. They all mean the same thing

* We might refer to the derivative of $f(x)$ as $f^\prime(x)$
* If $y$ is defined as a function of $x$, we might refer to the derivative of $y$ with respect to $x$ as $\dfrac{dy}{dx}$.

The $\dfrac{dy}{dx}$ notation is meant to evoke the "average rate of change" $\dfrac{\Delta y}{\Delta x}$. The idea is, as $\Delta x \rightarrow 0$, $\dfrac{\Delta y}{\Delta x} \rightarrow \dfrac{dy}{dx}$.

# Product Rule

We have seen a few examples of derivatives already, and also learned the sum and constant multiple rules. Today we will learn the product rule and power rules. Let's review an important example first: the derivative of $x^2$ is $2x$. We figured this out by looking at  In this video, I take a geometric look at this derivative.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/K6-AIFxqb-A" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

$x^2$ represents the area of a square whose side length is $x$. The derivative represents the rate at which the derivative changes in terms of how fast $x$ is changing. So how does this change? Let $\Delta x$ represent a small change in the side length. Then the change in the area is $2x\Delta x + (\Delta x)^2$. The rate of change of the area, with respect to changing $x$, is $\dfrac{2x \Delta x + (\Delta x)^2}{\Delta x}$, which, as $\Delta x \rightarrow 0$, appraoches $2x$.

Similarly, we can think of a product of two functions $f(x) \cdot g(x)$ as representing the area of a rectangle whose side lengths are $f(x)$ and $g(x)$. What happens as we change $x$ by a small amount, say $\Delta x$? The area changes by $(\Delta f)g + (\Delta g)f + \Delta f \Delta g$. The rate of change of the area, with respect to changing $x$, is $\dfrac{(\Delta f)g + (\Delta g)f + \Delta f \Delta g}{\Delta x}$, which is $\dfrac{\Delta f}{\Delta x}g + \dfrac{\Delta g}{\Delta x}f + \dfrac{\Delta f}{\Delta x}\Delta g$ As $x \rightarrow 0$, this approaches $f^\prime(x)g(x) + g^\prime(x)f(x)$. The last term goes away since, as $\Delta x \rightarrow 0$, $\Delta g \rightarrow 0$ also. This is the **product rule** for derivatives!

**Product rule**: Let $f$ and $g$ be functions that are differentiable at $x$. Then $(f(x)g(x))^\prime = f^\prime(x)g(x) + g^\prime(x) f(x)$.

## Exercises

1. Use the sum rules from last time to find the derivative of $x^2 + x + 1$.
2. Find the derivative of $x - 1$.
3. Find the derivative of $(x-1)(x^2 + x + 1)$ using the product rule.

<details>
    <summary>Solution:</summary>
    <ol>
        <li>$2x + 1$</li>
        <li>1</li>
        <li>Using the product rule: $1(x^2 + x + 1) + (x-1)(2x + 1)$. This simplifies to $x^2 + x + 1 + 2x^2 + x - 2x - 1$, which is $3x^2$</li>
    </ol>
</details>

The next set of exercises is meant to help you discover the power rule.

1. Use the fact that $(x^2)^\prime = 2x$ and $x^\prime = 1$ to find $(x^3)^\prime$. (Hint: $x^3 = x^2 \cdot x$.)
2. Use your answer to part 1, and the fact that $x^4 = x^3 \cdot x$ to find the derivative of $x^4$.
3. Use your answer to part 2 to find the derivative of $x^5$.

Can you find a pattern?

# Power Rule

Hopefully the exercises in the previous part helped you figure out the power rule.

**Power rule** (part 1): Let $n > 0$ be a positive integer. Then the derivative of $x^n$ is $nx^{n-1}$.

This rule will actually generalize to other powers of $x$: like $x^{\frac{1}{2}}$, or $x^\pi$, but we won't study those just yet.

Combining the power rule with the other rules we learned so far helps us compute derivatives of all polynomials. For example, let $f(x) = 2x^3 - 4x^2 + 3x - 1$. To find the derivative, we find the derivative of each individual term, and add/subtract them (using the sum rule). So we need to find the derivatives of the following:

* $2x^3$
* $4x^2$
* $3x$
* $-1$

The derivative of $x^3$ is $3x^2$, by the power rule. But by the constant multiple rule, that means the derivative of $2x^3$ is $2 \times 3x^2$, which is $6x^2$. Similarly, the derivative of $4x^2$ is $4 \times 2x$, which is $8x$. The derivative of $3x$ is $3$, and the derivative of $-1$ is $0$, since it's a constant function.

That means the derivative of $2x^3 - 4x^2 + 3x - 1$ is $6x^2 - 8x + 3$.

**Moral of the story**: Given a polynomial, the derivative can be found by using the power rule on each individual term, multiplying by the coefficient of that term, and adding the terms together.

## Exercises

Use the power rule to find the derivative of the following:

1. $f(x) = 3x^4 + 4x^3 + 5x^2 + 6x + 7$
2. $g(x) = x^3 + x^2 + x + 1$

Use the power rules and product rules, together, to find the derivatives of the following:

1. $h(x) = (x^3 - 1)(3x^2 - 2x + 1)$
2. $j(x) = (x+1)^2$, using the fact that $(x+1)^2$ is $(x+1)(x+1)$.
3. $k(x) = (4x - 3)^2$.
4. $F(x) = (3x - 1)^3$. Here you would need to first use the product rule to find the derivative of $(3x - 1)^2$, and then again use the product rule to find the derivative of $(3x - 1)^2 \cdot (3x - 1)$.

# Differentiability and Continuity

Let's look at some graphs of discontinuous functions. First, with a hole:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/egipc2b0rh?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

What do you notice about the secant lines to the right and left of 0?

Now let's look at a graph with a jump:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/3bjmb1eah5?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Based on the graphs we've seen, which of the following statements are true?

* If the derivative exists at a point, the limit as we approach that point must exist.
* If the derivative exists at x = a, the limit as we approach x = a must equal f(a)
* The derivative can exist at x = a for a function that is not continuous at x = a.

Now let's look at a graph of a continuous function.

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/lvilouocru?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Based on the previous graphs, what conclusions can we draw? Explain your choices.

* If a function is continuous at a point, it must be differentiable at that point.
* If a function is differentiable at a point, it must be continuous at that point.
* A function can be continuous at a point but not differentiable at that point.
* A function can be differentiable but not continuous at that point.
* None of these can be true.

**Theorem**: Suppose $f(x)$ is differentiable at $x = a$. Then $f(x)$ is continuous at $x = a$.

Proof: The limit as $x \rightarrow a$ of $\dfrac{f(x)-f(a)}{x - a}$ must exist. Suppose it's equal to $L$. Then, as $x \rightarrow a$, $f(x) - f(a) \rightarrow (x - a)L$, which approaches $0$. That means, as $x \rightarrow a$, $f(x) \rightarrow f(a)$.

## Differentiable, Continuous, both, neither

$$
f(x) = \begin{cases}x^2 - 1 &\mbox{if } x < 1 \\
x - 1 &\mbox{if } x \geq 1 \end{cases}
$$

Is $f(x)$ differentiable, continuous, both, or neither at the following points:

* $x = 0$
* $x = 1$
* $x = 2$

## x = 0

$x^2 - 1$ is differentiable at $x = 0$. Therefore it is also continuous.

Answer: **Both**

## x = 1

Need to check left and right hand limits of

$$
\lim_{x \rightarrow 1} \frac{f(x) - f(1)}{x - 1}
$$

From the left: $\dfrac{(x^2 - 1) - 0}{x - 1} \rightarrow x + 1 \rightarrow 2$.

From the right: $\dfrac{x -1 - 0}{x - 1} \rightarrow 1$. Not differentiable

## x = 1

Now we check if $f(x)$ is continuous at $x = 1$:

* $f(1) = 0$
* ${\displaystyle\lim_{x\rightarrow 1^-}} f(x) = {\displaystyle\lim_{x \rightarrow 1^-}} x^2 - 1 = 0$
* ${\displaystyle \lim_{x\rightarrow 1^+}} f(x) = {\displaystyle \lim_{x \rightarrow 1^+}} x - 1 = 0$.

So $f$ is **continuous** at $x = 1$.

## x = 2

$x - 1$ is differentiable, its derivative is $1$ near $x = 2$. Differentiable functions are continuous, so **both**.

## Graph

<iframe src="https://www.desmos.com/calculator/ark01rjrv4?embed" width="500px" height="500px" style="border: 1px solid #ccc" frameborder=0></iframe>

# Upcoming

* Quiz Corrections due Thursday
* DeltaMath HW 4 due Thursday
* DeltaMath HW 5 due next Monday (10/3)
* Take Home Exam 1 given next Monday (10/3), due following Monday (10/10)
