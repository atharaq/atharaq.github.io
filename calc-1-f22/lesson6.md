# Calculus I Lesson 6: Basic Derivatives
{:.no_toc}

1. Table of Contents
{:toc}

# Quiz

# Secant Lines $\rightarrow$ Tanagent Lines

So how do we actually compute the slope of a tangent line at a point $x = a$ on the graph of a function $y = f(x)$? We approximate it using secant lines, and take the limit!

Recall that the secant line on a graph is a line between two points on a graph. Let's say that the points are at $x = a$ and $x = b$. As ordered pairs, the point at $x = a$ is plotted at $(a, f(a))$ and the point at $x = b$ is plotted at $(b, f(b))$. The slope of the line between these points is given by the average rate of change formula:

$$\frac{\Delta y}{\Delta x} = \frac{f(b)-f(a)}{b-a}$$

As $b \rightarrow a$, the secant line approaches the line tangent to graph at $x = a$. That's what happens in this graph:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/pvbubabvbu?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

With our knowledge of limits, we can define the derivative as a limit. The derivative of $f(x)$ at $x = a$ is denoted $f^\prime(a)$. The definition is given by this limit:

$$f^\prime(x) = \lim_{x\rightarrow a} \frac{f(x)-f(a)}{x-a}$$

## Exercise

Find the derivative of $f(x) = x^2$ at the point $x = 3$. That is, find $f^\prime(3)$. The definition above means we need to compute

$$\lim_{x\rightarrow 3} \frac{x^2 - 9}{x-3}$$

As a hint, you need to use algebraic manipulation for this limit.

<details>
<summary>Check your answer</summary>

<p>First let us use algebra to find a function that is equivalent to $\frac{x^2-9}{x-3}$, except at $x = 3$, and is continuous at $x = 3$.</p>

$$\frac{x^2-9}{x-3} = \frac{(x+3)(x-3)}{x-3} = x+3$$

<p>So, as $x \rightarrow 3$, this limit exists and is equal to $3$</p>
</details>

## Another derivative formula

Another way to think about secant lines is, instead of thinking about two points, think about one point and a distance.

That is, let's say we want to find a good approximation of the tangent line at a point $x = a$. We look at the point at $(a, f(a))$. Then, instead of picking another $x$-value $b$, we pick a small *increment*, let's call it $h$. Now let's look at the point where $x = a + h$. That is, we draw the secant line from $(a, f(a))$, to $(a+h, f(a+h))$. This is what is happening in the graph below:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/m6omcjykuo?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

The slope of the secant line is $\frac{f(a+h)-f(a)}{(a+h)-a} = \frac{f(a+h)-f(a)}{h}$. As $h \rightarrow 0$, the secant line again approaches a tangent line. So again, we can come up with the formula for the derivative:

$$f^\prime(x) = \lim_{h \rightarrow 0} \frac{f(x+h)-f(x)}{h}$$

Let's use this to determine the value of the derivative of the function $f(x) = x^2$, at *any* given point $x$. First let's compute $\frac{f(x+h)-f(x)}{h}$. Since $(x+h)^2$ is $(x+h)(x+h) = x^2 + 2xh + h^2$, we get:

$$\begin{align*}
\frac{f(x+h)-f(x)}{h} &= \frac{x^2 + 2xh + h^2 - x^2}{h}
\\ &= \frac{2xh+h^2}{h}
\end{align*}$$

For all $h \neq 0$, we can use some algebra to simplify this fraction. We get $\dfrac{2xh+h^2}{h} = \dfrac{h(2x+h)}{h}$, which is $2x + h$. So, as $h \rightarrow 0$, the limit is $2x$.

That is, the derivative of $f(x) = x^2$ is $f^\prime(x) = 2x$.

Take a look at this example, from the YouTube Channel PatrickJMT. This shows a more complicated example of using algebra to compute a complicated limit.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/vzDYOHETFlo" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

# Reminders

* DeltaMath HW 3 due tonight.
* Written HW 4 due Monday.
* DeltaMath HW 4 due next Thursday.
