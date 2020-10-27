# Calculus I Lesson 14: Linear Approximations, The Mean Value Theorem and the Shape of Graphs
{:.no_toc}

1. Table of Contents
{:toc}

# Review of Maxima / Minima

Last time we studied maxima and minima. Let $[a, b]$ be an interval. The function $f(x)$ has an **absolute maximum** over $[a, b]$ at a point $c$ if for every $x$ in that interval (ie, $a \leq x \leq b$), $f(c) \geq f(x)$. Similarly, $f(x)$ has an **absolute minimum** over $[a, b]$ at $c$ if for every $x$ in the interval, $f(c) \leq f(x)$.

We also studied "local" maxima and minima: a function $f(x)$ has a **local maximum** at a point $c$ if there is an interval $(a, b)$ around $c$ such that $f(x) \leq f(c)$ for all $a < x < b$. We can similarly define **local minimum**. Take a look at the following figure [from the textbook, section 4.3](https://openstax.org/books/calculus-volume-1/pages/4-3-maxima-and-minima):

<img src="https://openstax.org/resources/e585f057904f6a4921f41459177c281a6e560558" data-media-type="image/jpeg" alt="The function f(x) is shown, which curves upward from quadrant III, slows down in quadrant II, achieves a local maximum on the y-axis, decreases to achieve a local minimum in quadrant I at x = 1, increases to a local maximum at x = 2 that is greater than the other local maximum, and then decreases rapidly through quadrant IV." />

Last time we saw:

* over a closed interval $[a, b]$, $f$ has its absolute maxima / minima either at the endpoints ($x = a$ or $x = b$), at points $x = c$ where $f^\prime(c) = 0$, or at points $x = c$ where $f^\prime(c)$ does not exist.
* $f$ has its local minima / maxima at its critical points: when $f^\prime(c) = 0$ or when $f^\prime(c)$ does not exist.

**Practice**: Take a look at problems 90-95, 100-103, and 118-123 from [Section 4.3](https://openstax.org/books/calculus-volume-1/pages/4-3-maxima-and-minima) of the textbook.

# Linear Approximations

An important reason to study derivatives is that they give us nice *approximations* to functions. We have previously seen that the tangent line to the graph of a function stays really close to the function itself.  Take a look at this graph of $y = e^x$ and the tangent line at $x = 0$, $y = x + 1$:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/ke8yjpmngf?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Notice that really close to $x = 0$, the graphs almost overlap. That means that the graph of $y = x + 1$ approximates the graph of $y = e^x$ near $x = 0$. In general, given a graph $y = f(x)$, the tangent line to the graph at $x = a$ is the **best linear approximation** of the function $y = f(x)$ near $x = a$.

How do we find this linear approximation? We already know how: find the equation of the tangent line. You do so by finding a point and a slope: $m = f^\prime(a)$, and the point is $(a, f(a))$. So the line can be found using point-slope form: $y - f(a) = f^\prime(a) (x - a)$, or, solving for $y$, we get:

$$y = f(a) + f^\prime(a) (x - a)$$

**Example**: Find the linear approximation to the function $f(x) = 3e^{2x}$ at the point $x = 0$. Use this line to approximate the value of $f(0.1)$.

<details>
<summary>Try this out on your own first, then click here to your answer!</summary>

<p>The point is $(0, f(0))$. Since $f(0) = 3e^0 = 3$, the point is $(0, 3)$.</p>
<p>The slope of $f^\prime(0)$. So take the derivative: $f^\prime(x) = 3\cdot(2e^{2x}) = 6e^{2x}$. Then $f^\prime(0) = 6e^{0} = 6$.</p>
<p>Putting everything together, we get $y = 3 + 6(x - 0)$, or $y = 6x + 3$.</p>
<p>At $x = 0.1$, this gives us a $y$-value of $y = 6(0.1) + 3$, or $y = 3.6$</p>
<p>Checking this with a calculator, $f(0.1) \approx 3.66$, so the approximation was off by 0.04.</p>
</details>

Of course, checking our answer with a calculator gives us a better approximation than the linear approximation we get. How do you think calculators approximate these transcendental functions that are hard to compute? They use other kinds of approximations. In Calculus 2, we will study Taylor Series, which gives us a way to determine higher-order approximations (like quadratic approximations, cubic approximations, etc).

# The Mean Value Theorem and its applications

The next major application of derivatives involves the shape of graphs. We have studied this already, but not really from a rigorous perspective. That is, intuitively we know that if $f^\prime(a) > 0$, then $f(x)$ is increasing at (or near) that point. But *how* do we know this? Can we justify this with a rigorous proof?

To actually prove this fact, we need the Mean Value Theorem:

**Theorem**: Let $f(x)$ be continuous over the interval $[a, b]$ and differentiable over $(a, b)$. Then there is a point $c$ in the interval $(a, b)$ such that $$f^\prime(c) = \frac{f(b) - f(a)}{b - a}$$

That is, there is a point inside the interval whose derivative is exactly equal to the average rate of change between $a$ and $b$.

We will not prove this theorem, but if you are interested, you can look at the proof in [Section 4.4 of the textbook](https://openstax.org/books/calculus-volume-1/pages/4-4-the-mean-value-theorem). I do want to point your attention to [Figure 4.25](https://openstax.org/books/calculus-volume-1/pages/4-4-the-mean-value-theorem#CNX_Calc_Figure_04_04_005):

<img src="https://openstax.org/resources/93636db137f86180ba6563682c50d33f697d9396" data-media-type="image/jpeg" alt="A vaguely sinusoidal function y = f(x) is drawn. On the x-axis, a, c1, c2, and b are marked. On the y-axis, f(a) and f(b) are marked. The function f(x) starts at (a, f(a)), decreases to c1, increases to c2, and then decreases to (b, f(b)). A secant line is drawn between (a, f(a)) and (b, f(b)), and it is noted that this line has slope (f(b) – f(a))/(b − a). The tangent lines at c1 and c2 are drawn, and these lines are parallel to the secant line. It is noted that the slopes of these tangent lines are f’(c1) and f’(c2), respectively." />

The mean value theorem says that there is a point $c$ where the tangent line is parallel to the secant line between $(a, f(a))$ and $(b, f(b))$. As an example, imagine that you are on a road trip. Let's say that you were driving for 2 hours before stopping, and in those 2 hours, you drove 80 miles. That means, on average, you drove 40mph. The Mean Value Theorem says that there **must** be a time during that drive  where your speedometer showed **exactly** 40mph!

**Exercise**: You pass a speed camera at 10:00 AM going 50 mph. At 10:30 AM you pass another speed camera located 35 miles apart, again going 50 mph. If the speed limit is 60 mph, were you ever speeding?

Take a look at exercises 190-191 in [Section 4.4 of the textbook](https://openstax.org/books/calculus-volume-1/pages/4-4-the-mean-value-theorem).

## Increasing / Decreasing / Constant

The main application of the mean value theorem is to provide rigorous proofs of some of the intuitive notions we have about the shape of the graph of a function. Intuitively, if $f^\prime(x)$ is positive on an interval, then $f(x)$ should be increasing on that interval. How do we actually prove this? In other words, $f^\prime(x) > 0$ means that for each $x$, $$\lim_{h \rightarrow 0} \frac{f(x+h)-f(x)}{h} > 0$$ How do we then conclude that whenever $a < b$, then $f(a) < f(b)$?

We do so using the mean value theorem!

**Theorem**: Suppose $f(x)$ is continuous on $[a, b]$ and differentiable on $(a, b)$. If $f^\prime(x) > 0$ for every $x$ in $(a, b)$, then $f$ is an increasing function over $[a, b]$.

**Proof**: Suppose $x_0 < x_1$ are in the interval $[a, b]$. Then by the mean value theorem, there is a point $c$ between $x_0$ and $x_1$ such that $$f^\prime(c) = \frac{f(x_1) - f(x_0)}{x_1 - x_0}$$. Since $f^\prime(c) > 0$ and $x_1 - x_0 > 0$, this means that $f(x_1) - f(x_0) > 0$. In other words, $f(x_1) > f(x_0)$ whenever $x_1 > x_0$ in the interval $[a, b]$.

Similarly, we can prove that if $f^\prime(x) < 0$ on an interval, then $f$ is decreasing over that interval, and if $f^\prime(x) = 0$ on an interval, then $f$ is constant on that interval. These proofs are found in [Section 4.4 of the textbook](https://openstax.org/books/calculus-volume-1/pages/4-4-the-mean-value-theorem).

This last result gives us an important property of derivatives: if two functions have the same derivative, they might not be the same function, but they must differ by a constant. For example, the function $f(x) = x^2$ and the function $g(x) = x^2 + 2$ have the same derivative, $2x$, but are not the same function.

In other words, two functions whose derivatives are the same would have to look "parallel" to each other:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/r3jaeptvlq?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Notice that at every point, the tangent lines have the same slope, and the distance between the graphs doesn't change.

**Theorem**: Suppose $f^\prime(x) = g^\prime(x)$ for all x in $(a, b)$. Then $f(x) - g(x)$ is a constant.

**Proof**: Let $h(x) = f(x) - g(x)$. Then $h^\prime(x) = f^\prime(x) - g^\prime(x)$. Since, for every $x$ in $(a, b)$, $f^\prime(x) = g^\prime(x)$, then $h^\prime(x) = 0$ on this interval. [Theorem 4.6](https://openstax.org/books/calculus-volume-1/pages/4-4-the-mean-value-theorem#fs-id116504264570) from the textbook implies then that $h(x)$ is a constant function on the interval $(a, b)$. Therefore $f(x) - g(x)$ is a constant.

**Example**: Consider the functions $f(x) = (\sec(x))^2$ and $g(x) = (\tan(x))^2$. Their derivatives are $f^\prime(x) = 2\sec(x)\sec(x)\tan(x)$, which simplifies to $2(\sec(x))^2\tan(x)$, and $g^\prime(x) = 2\tan(x)(\sec(x))^2$. Notice that $f^\prime(x) = g^\prime(x)$ for every $x$. But $f(0) = 1$ and $g(0) = 0$, so these are **not** the same function. But in general, $f(x) = g(x) + 1$:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/lsmqvxgjps?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

## First Derivative Test

...

## Concavity

...

## Second Derivative Test

...
