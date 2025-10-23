# Calculus I Lesson 15: Optimization, Linear Approximation
{:.no_toc}

1. Table of Contents
{:toc}

# Presentaions

# Warm-up

(This was in the notes last time, but we didn't get to it.)

Water is draining from the bottom of a cone-shaped funnel at the rate of 0.05 $\mathrm{ft}^3 / \mathrm{sec}$. The height of the funnel is 2 ft and the radius at the top of the funnel is 1ft. At what rate is the height of the water in the funnel changing when the height of the water is $\frac{1}{2}$ ft?

<img src="https://openstax.org/apps/image-cdn/v1/f=webp/apps/archive/20250916.165151/resources/3cc93b86da3e1bb1b4269fb6c1adac832bad6253" data-media-type="image/jpeg" alt="A funnel is shown with height 2 and radius 1 at its top. The funnel has water to height h, at which point the radius is r." />

To declare our variables:

* $r$ = radius at the surface level
* $h$ = height at the surface level

Then we can relate these using some basic geometry. Since the height of the funnel is 2 and the radius at the top of the funnel is 1, we see that $h = 2r$, or $r = \frac{h}{2}$. Moreover we can relate the volume to the height using the formula for volume of a cone: $V = \frac{1}{3} \pi r^2 h$, or $V = \frac{1}{12} \pi h^3$.

Then differentiate both sides: $V^\prime = (\frac{1}{12} \pi) \cdot 3h^2 h^\prime$. Now let's plug in what we know: $$-0.05 = \frac{\pi}{4} (\frac{1}{2})^2 h^\prime.$$

Now simplify and solve for $h^\prime$:

$$
\begin{align}
-0.05 = \frac{\pi}{16} h^\prime \\
h^\prime = \frac{(-0.05) \times 16}{\pi} \approx -0.255 \mbox{ ft / sec}
\end{align}
$$

As a follow-up: what about when the funnel is full ($h = 2$)? The steps end up being exactly the same, except with $h = 2$ at the end.

$$
\begin{align}
V^\prime = (\frac{1}{12} \pi) \cdot 3h^2 h^\prime \\
-0.05 = \frac{\pi}{4} (2^2) h^\prime \\
-0.05 = \pi h^\prime \\
h^\prime = \frac{-0.05}{\pi} \approx -0.016 \mbox{ ft / sec}
\end{align}
$$

So the rate of change of the height is *slower* when the funnel is full. Does this make sense?


# Optimization

Continuity is a powerful concept:

* Transforms properties of "domains" $\to$ properties of "ranges"
* Connected domains $\to$ connected ranges
* Closed and bounded domains $\to$ closed and bounded ranges

Instead of just thinking about functions as giving us an output whenever we have some input, we should also think about how the function *transforms* a domain.

## Extreme Value Theorem

**Theorem**: If $f$ is a continuous function on a closed interval $[a, b]$, then it has a **maximum** and a **minimum** in $[a, b]$.

## Counterexample?

$f(x) = \tan(x)$ on $(-\pi/2, \pi/2)$:

<iframe src="https://www.desmos.com/calculator/rm8aijaqie?embed" width="500px" height="500px" style="border: 1px solid #ccc" frameborder=0></iframe>

What happens on $(-\pi/2, \pi/2)$? Is there a maximum value? Minimum value? Why not?

## Finding maxima/ minima

Finding maxima / minima is easiest when $f$ is differentiable. Suppose $f(x)$ is differentiable on $(a, b)$ and continuous on $[a, b]$. Then there are 3 options for where maxima / minima can be:

1. $x = a$ or $x = b$ (endpoints)
2. When $f^\prime(x) = 0$
3. When $f^\prime(x)$ DNE

Points satisfying (2) or (3) are called **critical points** of $f$.

## Critical Points

<img src="https://openstax.org/apps/image-cdn/v1/f=webp/apps/archive/20250916.165151/resources/e585f057904f6a4921f41459177c281a6e560558" data-media-type="image/jpeg" alt="The function f(x) is shown, which curves upward from quadrant III, slows down in quadrant II, achieves a local maximum on the y-axis, decreases to achieve a local minimum in quadrant I at x = 1, increases to a local maximum at x = 2 that is greater than the other local maximum, and then decreases rapidly through quadrant IV." >

## Example

Find the minimum value of $f(x) = x^3 - x^2$ on the interval $[-2, 2]$:

$$
\begin{align}
f^\prime(x) = 3x^2 - 2x = 0 \\
x(3x - 2) = 0 \\
x = 0 \mbox{ or } x = 2/3
\end{align}
$$

Points to check: $x = -2, 0, 2/3, 2$

* $f(-2) = -12$
* $f(0) = 0$
* $f(2/3) = -4/27$
* $f(2) = 4$

The minimum value occurs at $x = -2$. The minimum value of the function is -12.

Take a look at the graph:

<iframe src="https://www.desmos.com/calculator/qzajtckogc?embed" width="500px" height="500px" style="border: 1px solid #ccc" frameborder=0></iframe>

## Local Minima / Maxima

* $x = 0$ is a **local maximum** of $f(x)$
* $x = 2/3$ is a **local minimum** of $f(x)$

How can you tell when a point is a local min or local max?

<img src="https://openstax.org/apps/image-cdn/v1/f=webp/apps/archive/20250916.165151/resources/a60e8cf30409df9c4c687f5fcde44a2584ce2864" data-media-type="image/jpeg" alt="This figure has five parts a, b, c, d, and e. In figure a, a parabola is shown facing down in quadrant I; there is a horizontal tangent line at the local maximum marked f’(c) = 0. In figure b, there is a function drawn with an asymptote at c, meaning that the function increases toward infinity on both sides of c; it is noted that f’(c) is undefined. In figure c, a version of the absolute value graph is shown that has been shifted so that its minimum is in quadrant I with x = c. It is noted that f’(c) is undefined. In figure d, a version of the function f(x) = x3 is shown that has been shifted so that its inflection point is in quadrant I with x = c. Its inflection point at (c, f(c)) has a horizontal line through it, and it is noted that f’(c) = 0. In figure e, a version of the function f(x) = x1/3 is shown that has been shifted so that its inflection point is in quadrant I with x = c. Its inflection point at (c, f(c)) has a vertical line through it, and it is noted that f’(c) is undefined." id="10">

## Wrap-up of Maxima / Minima

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/hOBeg2kUMcE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

To summarize:

Let $[a, b]$ be an interval. The function $f(x)$ has an **absolute maximum** over $[a, b]$ at a point $c$ if for every $x$ in that interval (ie, $a \leq x \leq b$), $f(c) \geq f(x)$. Similarly, $f(x)$ has an **absolute minimum** over $[a, b]$ at $c$ if for every $x$ in the interval, $f(c) \leq f(x)$.

We can also study "local" maxima and minima: a function $f(x)$ has a **local maximum** at a point $c$ if there is an interval $(a, b)$ around $c$ such that $f(x) \leq f(c)$ for all $a < x < b$. We can similarly define **local minimum**. Take a look at the following figure [from the textbook, section 4.3](https://openstax.org/books/calculus-volume-1/pages/4-3-maxima-and-minima):

<img src="https://openstax.org/apps/image-cdn/v1/f=webp/apps/archive/20250916.165151/resources/e585f057904f6a4921f41459177c281a6e560558" data-media-type="image/jpeg" alt="The function f(x) is shown, which curves upward from quadrant III, slows down in quadrant II, achieves a local maximum on the y-axis, decreases to achieve a local minimum in quadrant I at x = 1, increases to a local maximum at x = 2 that is greater than the other local maximum, and then decreases rapidly through quadrant IV." />

We know:

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
<iframe src="https://www.youtube.com/embed/_7E0vxTVfOs" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
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
  <iframe src="https://www.youtube.com/embed/DqbyCwErsMY" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

The next major application of derivatives involves the shape of graphs. We have studied this already, but not really from a rigorous perspective. That is, intuitively we know that if $f^\prime(a) > 0$, then $f(x)$ is increasing at (or near) that point. But *how* do we know this? Can we justify this with a rigorous proof?

To actually prove this fact, we need the Mean Value Theorem:

**Theorem**: Let $f(x)$ be continuous over the interval $[a, b]$ and differentiable over $(a, b)$. Then there is a point $c$ in the interval $(a, b)$ such that $$f^\prime(c) = \frac{f(b) - f(a)}{b - a}$$

That is, there is a point inside the interval whose derivative is exactly equal to the average rate of change between $a$ and $b$.

We will not prove this theorem, but if you are interested, you can look at the proof in [Section 4.4 of the textbook](https://openstax.org/books/calculus-volume-1/pages/4-4-the-mean-value-theorem). I do want to point your attention to [Figure 4.25](https://openstax.org/books/calculus-volume-1/pages/4-4-the-mean-value-theorem#CNX_Calc_Figure_04_04_005):

<img src="https://openstax.org/apps/image-cdn/v1/f=webp/apps/archive/20250916.165151/resources/93636db137f86180ba6563682c50d33f697d9396" data-media-type="image/jpeg" alt="A vaguely sinusoidal function y = f(x) is drawn. On the x-axis, a, c1, c2, and b are marked. On the y-axis, f(a) and f(b) are marked. The function f(x) starts at (a, f(a)), decreases to c1, increases to c2, and then decreases to (b, f(b)). A secant line is drawn between (a, f(a)) and (b, f(b)), and it is noted that this line has slope (f(b) – f(a))/(b − a). The tangent lines at c1 and c2 are drawn, and these lines are parallel to the secant line. It is noted that the slopes of these tangent lines are f’(c1) and f’(c2), respectively." />

The mean value theorem says that there is a point $c$ where the tangent line is parallel to the secant line between $(a, f(a))$ and $(b, f(b))$. As an example, imagine that you are on a road trip. Let's say that you were driving for 2 hours before stopping, and in those 2 hours, you drove 80 miles. That means, on average, you drove 40mph. The Mean Value Theorem says that there **must** be a time during that drive where your speedometer showed **exactly** 40mph!

**Exercise**: You pass a speed camera at 10:00 AM going 50 mph. At 10:30 AM you pass another speed camera located 35 miles apart, again going 50 mph. If the speed limit is 60 mph, were you ever speeding?

Take a look at exercises 190-191 in [Section 4.4 of the textbook](https://openstax.org/books/calculus-volume-1/pages/4-4-the-mean-value-theorem).

# Upcoming:

Topics:

* Applying the MVT: increasing / decreasing / constant intervals, first derivative and second derivative test, concavity
* Exam 2

Upcoming Work:

* Homework 6 due Monday
* DeltaMath due next Thursday
* Quiz corrections due Monday
