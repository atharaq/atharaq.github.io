# Calculus I Lesson 14: Linear Approximations, The Mean Value Theorem and the Shape of Graphs
{:.no_toc}

1. Table of Contents
{:toc}

# Review of Maxima / Minima

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/hOBeg2kUMcE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Last time we studied maxima and minima. Let $[a, b]$ be an interval. The function $f(x)$ has an **absolute maximum** over $[a, b]$ at a point $c$ if for every $x$ in that interval (ie, $a \leq x \leq b$), $f(c) \geq f(x)$. Similarly, $f(x)$ has an **absolute minimum** over $[a, b]$ at $c$ if for every $x$ in the interval, $f(c) \leq f(x)$.

We also studied "local" maxima and minima: a function $f(x)$ has a **local maximum** at a point $c$ if there is an interval $(a, b)$ around $c$ such that $f(x) \leq f(c)$ for all $a < x < b$. We can similarly define **local minimum**. Take a look at the following figure [from the textbook, section 4.3](https://openstax.org/books/calculus-volume-1/pages/4-3-maxima-and-minima):

<img src="https://openstax.org/resources/e585f057904f6a4921f41459177c281a6e560558" data-media-type="image/jpeg" alt="The function f(x) is shown, which curves upward from quadrant III, slows down in quadrant II, achieves a local maximum on the y-axis, decreases to achieve a local minimum in quadrant I at x = 1, increases to a local maximum at x = 2 that is greater than the other local maximum, and then decreases rapidly through quadrant IV." />

Last time we saw:

* over a closed interval $[a, b]$, $f$ has its absolute maxima / minima either at the endpoints ($x = a$ or $x = b$), at points $x = c$ where $f^\prime(c) = 0$, or at points $x = c$ where $f^\prime(c)$ does not exist.
* $f$ has its local minima / maxima at its critical points: when $f^\prime(c) = 0$ or when $f^\prime(c)$ does not exist.

It's important to note: not **every** critical point must be a local maxima or minima! For example: look at $f(x) = x^3$. The derivative is $f^\prime(x) = 3x^2$, which is equal to 0 at $x = 0$. But at $x = 0$, the graph does not have a minimum or a maximum:

<div class="desmos-container">
    <iframe src="https://www.desmos.com/calculator/3whllsq9zy?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Later we will see how we can use the first and second derivatives to determine whether a critical point is a local maximum, minimum, or neither.

**Practice**: Take a look at problems 90-95, 100-103, and 118-123 from [Section 4.3](https://openstax.org/books/calculus-volume-1/pages/4-3-maxima-and-minima) of the textbook.

# Linear Approximations

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/_7E0vxTVfOs" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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
<p>Checking this with a calculator, $f(0.1) \approx 3.66$, so the approximation was off by 0.06.</p>
</details>

Of course, checking our answer with a calculator gives us a better approximation than the linear approximation we get. How do you think calculators approximate these transcendental functions that are hard to compute? They use other kinds of approximations. In Calculus 2, we will study Taylor Series, which gives us a way to determine higher-order approximations (like quadratic approximations, cubic approximations, etc).

# The Mean Value Theorem and its applications

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/DqbyCwErsMY" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/AgYmWg8xRvE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Recall that if $f(x)$ has a local extremum (minimum or maximum) at a point $x = a$, then either $f^\prime(a) = 0$ or $f^\prime(a)$ does not exist. That is, $x = a$ must be a **critical point** of the function. But before, we saw that not every critical point of a function is a local extremum: for example, $f(x) = x^3$ does not have a minimum or maximum at $x = 0$.

So, if we find the critical points of a function, how can we tell if there is a maximum, minimum, or neither at those critical points? Take a look at this image (Figure 4.31) from [Section 4.5](https://openstax.org/books/calculus-volume-1/pages/4-5-derivatives-and-the-shape-of-a-graph) of the textbook:

<img src="https://openstax.org/resources/4cd70a3660d24cf50b348a55119d1776701633fb" data-media-type="image/jpeg" alt="A function f(x) is graphed. It starts in the second quadrant and increases to x = a, which is too sharp and hence f’(a) is undefined. In this section f’ > 0. Then, f decreases from x = a to x = b (so f’ < 0 here), before increasing at x = b. It is noted that f’(b) = 0. While increasing from x = b to x = c, f’ > 0. The function has an inversion point at c, and it is marked f’(c) = 0. The function increases some more to d (so f’ > 0), which is the global maximum. It is marked that f’(d) = 0. Then the function decreases and it is marked that f’ > 0." />

Notice that when $f$ has a local maximum, then to the left $f$ is increasing, and to the right it's decreasing. In terms of the derivative, that means $f^\prime > 0$ to the left of a local maximum, and $f^\prime < 0$ to the right. This makes sense intuitively: the graph increases up until the peak, and then decreases afterward.

Similarly, if $f^\prime < 0$ to the left of $x = a$ and then $f^\prime > 0$ to the right, then $x = a$ is a local minimum. What happens at those points where $f^\prime > 0$ on both sides, or when $f^\prime < 0$ on both sides? That's when $f$ does not have a local maximum or a local minimum at that point.

**Exercise**: Find all the critical points of $f(x) = x^3 - 3x$. Classify each critical point as being a local maximum, local minimum, or neither.

<details>
    <summary>Solution:</summary>
    <p>First take the derivative $f^\prime(x) = 3x^2 - 3$. Setting this equal to 0 and solving, we get $3(x^2 - 1) = 0$, or $(x+1)(x-1) = 0$. This means either $x = -1$ or $x = 1$.</p>
    <p>So our critical points are $x = -1$ and $x = 1$. We need to determine if $f^\prime(x)$ is positive or negative to the left of $x = -1$, between $x = -1$ and $x = 1$, and to the right of $x = 1$.</p>
    <p>Because $f^\prime(x)$ is continuous, we only need to check one point in each of the intervals $(-\infty, -1)$, $(-1, 1)$, and $(1, \infty)$.</p>
    <p>Let's check $x = -2$: $f^\prime(-2) = 3(4) - 3 = 9$, which is positive, so $f$ is increasing on $(-\infty, -1)$.</p>
    <p>Check $x = 0$: $f^\prime(0) = 3(0) - 3 = -3$, which is negative, so $f$ is decreasing on $(-1, 1)$.</p>
    <p>Check $x = 2$: $f^\prime(2) = 3(4) - 3 = 9$, which is postiive, so $f$ is increasing on $(1, \infty)$.</p>
    <p>Therefore, $f$ increases until $x = -1$, decreases until $x = 1$, and then increases again off to infinity. So $x = -1$ is a <strong>local maximum</strong> and $x = 1$ is a <strong>local minimum</strong></p>
</details>

The textbook solves these in a slightly different way using "sign analysis". I'll let you check that out yourself: see Example 4.17 in [Section 4.5](https://openstax.org/books/calculus-volume-1/pages/4-5-derivatives-and-the-shape-of-a-graph).

We can use this first derivative test to study properties of the graph of a function, given the graph of its derivative. For example, if you see that the graph of $f^\prime$ is positive, then crosses the $x$-axis at the point $x = a$, and then goes negative, then $x = a$ is a local minimum. Take a look at exercises 201-207 and 221-222 from [Section 4.5](https://openstax.org/books/calculus-volume-1/pages/4-5-derivatives-and-the-shape-of-a-graph) to practice this.

## Second Derivative Test

Last time we alluded to the fact that you can use the second derivative to classify maxima and minima. The first derivative test says:

* if $f(x)$ is differentiable on an interval except possibly at one point $x = c$,
* $x = c$ is a critical point,
* $f^\prime(x) > 0$ when $x < c$, and
* $f^\prime(x) < 0$ when $x > c$,

then $f(c)$ is a local maximum. If $f$ is twice differentiable on that interval, then notice that $f^\prime$ is *decreasing* at $x = c$, since it goes from positive, to 0, to negative. Therefore, $f^{\prime\prime}(c) < 0$. This is the idea behind the **Second Derivative Test**:

If $f^\prime(c) = 0$ and $f^{\prime\prime}$ is continuous over an interval containing $c$, then:

* if $f^{\prime\prime}(c) > 0$, then $f$ has a **local minimum** at $x = c$.
* if $f^{\prime\prime}(c) < 0$, then $f$ has a **local maximum** at $x = c$.
* if $f^{\prime\prime}(c) = 0$, then $f$ has neither at $x = c$.

**Example**: Consider the function $f(x) = x^4 - 2x^2$. Find its critical points and classify all of them as local minima, maxima, or neither.

**Solution**: Since $f^\prime(x) = 4x^3 - 4x$, we set this equal to 0 to find the critical points. Factoring out $4x$ we get $4x(x^2 - 1) = 0$. Divide by 4 and factor:

$$x(x+1)(x-1) = 0$$

so our critical points are $x = -1, x = 0, x = 1$.

The second derivative $f^{\prime\prime}(x) = 12x^2 - 4$. Plug in each of these:

* $12(-1)^2 - 4 = 8 > 0$, so $x = -1$ is a local **minimum**.
* $12(0)^2 - 4 = -4 < 0$, so $x = 0$ is a local **maximum**.
* $12(1)^2 - 4 = 8 > 0$, so $x = 1$ is a local **minimum**.

Graph:

<div class="desmos-container">
    <iframe src="https://www.desmos.com/calculator/wkqemoohdg?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

## Concavity

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/6lb9Z9vWYZE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Another important feature of the shape of the graph of a function is the **concavity** of the function. The textbook describes concavity as referring to whether a function "curves upward" or "curves downward". Personally, I have trouble figuring out what "curving upward" or "curving downward" means just by looking at a graph. However, I'd like to point out the following graph:

<div class="desmos-container">
    <iframe src="https://www.desmos.com/calculator/mvtb0tmrc5?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Notice that at $x = -1$, the tangent line is drawn *above* the graph of $f(x)$, and at $x = 1.5$, the tangent line is *below* the graph. This is how I understand concavity: the graph is **concave up** at a point (or "curves upward") if it lies above the tangent line at that point, and is **concave down** (or "curves downward") if it lies below the tangent line.

It turns out that concavity of a function is determined by whether the first derivative is increasing or decreasing: if $f^\prime$ is increasing on an interval, then $f$ is concave up, and if $f^\prime$ is decreasing, then $f$ is concave down. Of course, if $f$ has a second derivative, then we can just check if that second derivative is positive or negative: if $f^{\prime\prime} > 0$ on an interval, then $f$ is concave up on that interval. If $f^{\prime\prime} < 0$ on an interval, then $f$ is concave down on that interval.

An **inflection point** is a point where $f$ changes concavity. Again, if the function has a second derivative, we can check where $f^{\prime\prime}$ goes from positive to negative, or negative to positive: this would occur either at points where $f^{\prime\prime} = 0$ or where the second derivative is not defined.

**Exercise**: For the function $f(x) = x^4 - 4x^3 - 18x^2 - x + 3$, determine all intervals where $f$ is concave up, all intervals where $f$ is concave down, and all points of inflection. Sketch a graph and locate these intervals on the graph.


<details>
    <summary>Check your solution</summary>
    <p>Let's check the second derivative. $f^\prime(x) = 4x^3 - 12x^2 - 36x - 1$, and so $f^{\prime\prime}(x) = 12x^2 - 24x -36$. Since this is continuous, we check where it is equal to 0:</p>
    <p>$12x^2 - 24x - 36 = 0$. Factor out 12: $12(x^2 - 2x - 3) = 0$. Divide by 12 and factor.</p>
    <p>$(x-3)(x+1) = 0$, and so the second derivative is equal to 0 at $x = -1$ and $x = 3$.</p>
    <p>For each of the intervals $(-\infty, -1)$, $(-1, 3)$ and $(3, \infty)$, we check whether $f^{\prime\prime}$ is positive or negative:</p>
    <p>For $(-\infty, -1)$, check the points $x = -2$: $f^{\prime\prime}(-2) = 12(4) - 24(-2) - 36 = 60 > 0$, so $f$ is <strong>concave up</strong> on $(-\infty, -1)$.</p>
    <p>For $(-1, 3)$, check $x = 0$: $f^{\prime\prime}(0) = -36 < 0$, so $f$ is <strong>concave down</strong> on $(-1, 3)$. At this point we can conclude that $x = -1$ is an <strong>inflection point</strong>, since $f$ changes concavity there.</p>
    <p>For $(3, \infty)$, check $x = 4$: $f^{\prime\prime}(4) = 60 > 0$, so $f$ is <strong>concave up</strong> on $(3, \infty)$. Again, $x = 3$ is an <strong>inflection point</strong>. Take a look at the graph and sketch out the tangent lines to see where the graph is concave up and concave down:</p>
    <div class="desmos-container">
    <iframe src="https://www.desmos.com/calculator/p0ukeylkgp?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
    </div>
</details>

Take a look at exercises 211-217 and 224-230 from [Section 4.5](https://openstax.org/books/calculus-volume-1/pages/4-5-derivatives-and-the-shape-of-a-graph).
