# Calculus I Lesson 6: Derivatives, Continued

# Notations

Let's continue discussing derivatives. First a bit of notation. There are a few ways in which we might refer to taking a derivative. They all mean the same thing

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

This part of the lesson will be an interactive Desmos activity. [Complete this activity here.](https://student.desmos.com/join/7qd2dh) Please, again, enter in your full name here. **I will be checking this for completion as part of your "Check-in" grade.**

# Sketching Graphs of Derivatives

View this part on YouTube from the patrickJMT channel:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/QoTGPUArfTI" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Please look at problems 64 - 67 in [Section 3.2 of the textbook](https://openstax.org/books/calculus-volume-1@12.1/pages/3-2-the-derivative-as-a-function) to review this part.

# Position, Velocity, Acceleration

View this part on YouTube (also from patrickJMT):

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/QoTGPUArfTI" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Please look at problems 151-155 in [Section 3.4 of the textbook](https://openstax.org/books/calculus-volume-1/pages/3-4-derivatives-as-rates-of-change) to review this part.
