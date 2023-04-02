# Calculus II Lesson 16: Polar Coordinates
{: .no_toc}

1. Table of Contents
{:toc}

# Warm Up

**Hand in**:

1. [Section 7.2, #104](https://openstax.org/books/calculus-volume-2/pages/7-2-calculus-of-parametric-curves#fs-id1167794048157) Find the area of the region bounded by the curve $x(t) = 2\cot(t)$, $y(t) = 2\sin^2(t)$, over $0 \leq t \leq \pi$.
2. 7.2 #114: Find the length of one arch of the cycloid $x(t) = 4(t - \sin(t))$, $y(t) = 4(1 - \cos(t))$.

Graph for #2: 

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/slln0uq2zx?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

For #2, first you need to figure out one "one arch" corresponds to in terms of the values of $t$. Looking at the graph, it starts when $y = 0$. One arch is the next time that $y = 0$. So set $y(t) = 0$ and solve for $t$ first.

## Questions?

* MyOpenMath due today.
* Presentation 3 due **next Monday** 4/10.

# Polar Coordinates

The idea behind polar coordinates it hat we describe points on the plane in an alternate way. Instead of using $(x, y)$, which describe horizontal and vertical distances from the origin, we use $(r, \theta)$, which describe:

* $r$: "radius" (distance from origin)
* $\theta$: "angle" (when you draw a straight line to the point)

As we said last time, this is useful if our motivating geometry is "circular" or "rotational".

## Playing with desmos

[Graph of $y = x^2 + a$ on Desmos](https://www.desmos.com/calculator/adrjrmff7a)

* What happens when we change $y = x^2$ to $y = x^2 + a$?
* What about $y = (x - b)^2 + a$?
* What about $y = cx^2$?

The goal is to be able to ask similar questions about *polar graphs*: what if we graph $r$ as a function of $\theta$? For example, in the above link we can graph $r = \cos(3\theta)$ and its transformations.

## Physics analogy

Recall: what is a **vector** (in physics)?

A quantity which has *magnitude* and *direction*. For example, a 2 pound force horizontally pushing an object to the right is not the same as a 2 pound force pushing an object down. Often times, 2D vectors are described as points on the plane: $(x, y)$ coordinates. The magnitude would be their distance from the origin, and the direction would just be whatever direction they are pointing in. But if we wanted to, we could just use polar to describe those ideas directly: the magnitude is $r$, direction is $\theta$.

## Converting

**Question**: How do we convert from $(x, y)$ coordinates to $(r, \theta)$ (and back)?

**Example**: express the point $(1, \sqrt{3})$ in polar coordinates.

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/a3uqlxlitj?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Take a look at the following figure from the textbook:

<img alt="Figure 7.27: a point on the plane in polar / rectangular coordinates" src="https://openstax.org/apps/archive/20230220.155442/resources/932155f04af9236bbe09f7ba933f710a2032c227" style="background: currentColor" />

Notice that we can use what we know about triangles to convert. So to go from $(x, y)$ to $(r, \theta)$, we use the following formulas:
  * $r^2 = x^2 + y^2$
  * $\tan(\theta) = \frac{y}{x}$

To go the other way, notice that $\frac{x}{r} = \cos(\theta)$ and $\frac{y}{r} = \sin(\theta)$, so we have the following formulas:
  * $x = r \cos(\theta)$
  * $y = r \sin(\theta)$

Now some definitions. In polar, we don't really have an $x$-axis, exactly, so what exactly is $\theta$ measuring? We define a single point, the **pole** (which corresponds to the origin in rectangular coordinates), and from that pole, we draw a ray (half of a line, so it only extends in one direction) going immediately to the right (forever). That ray is referred to as the **polar axis**. This corresponds to the positive $x$-axis.

The "gridlines" for a polar graph would look a little different: for the $r$-values, you'd have concentric circles, and for $\theta$, you have rays at each angle.

<img alt="Figure 7.28: The polar coordinate system. A series of concentric circles is drawn with spokes indicating different values between 0 and 2π in increments of π/12. The first quadrant starts with 0 where the x axis would be, then the next spoke is marked π/12, then π/6, π/4, π/3, 5π/12, π/2, and so on into the second, third, and fourth quadrants. The polar axis is noted near the former x axis line." src="https://openstax.org/apps/archive/20230220.155442/resources/1918fadd9ac1dfa9eba762343c7053581250894f" style="background: currentColor" />

## Exercise

Plot the following points expressed in polar, and express them in $(x, y)$ coordinates:

1. $(1, \frac{\pi}{2})$
2. $(2, -\frac{\pi}{4})$
3. $(3, \frac{3\pi}{4})$

(After going over the exercise): Notice that $(2, -\frac{\pi}{4}) = (2, \frac{7\pi}{4}) = \ldots$ The same point can be represented in infinitely many ways (in polar). Why is this?

<details>
<summary>Click for the answer</summary>
<p>It's the same reason that sin and cos are periodic functions: every $2\pi$, the angle $\theta$ gets to the same point on the plane.</p>
</details>

# Graphs

Previously saw an example of a polar graphs. In general, we want to graph functions of the form $r = f(\theta)$.

Let's do an exmaple: $r = 2\cos(\theta)$. Like we did with parametric equations, we start by making a table:

$$
\begin{array}{c|c}
\theta & r = 2\cos(\theta) \\
\hline
0 & 2 \\
\frac{\pi}{6} & \sqrt{3} \approx 1.73 \\
\frac{\pi}{4} & \sqrt{2} \approx 1.41 \\
\frac{\pi}{3} & 1 \\
\frac{\pi}{2} & 0 \\
\frac{2\pi}{3} & -1 \\
\pi & -2
\end{array}
$$

So what does the graph look like?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/zwvhlpstpl?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

## Special Curves

[Section 7.3 of the textbook](https://openstax.org/books/calculus-volume-2/pages/7-3-polar-coordinates) has a good list of examples of types of polar curves. It's worth going through some of those. Here are just a couple:

* Cardioid: $r = 2 + 2 \cos(\theta)$
* Rose: $r = 5\sin(2\theta)$ (4 petals)
* $r = 2 \sin(3\theta)$ (3 petals)
* $r = 2\sin(\frac{3}{7} \theta)$ (more complicated rose)
* $r = 4\sin(\pi \theta)$ Hmmm...

# Calculus

Any polar curve $r = f(\theta)$ can be converted to paramteric equations:

* $x = r\cos(\theta) = f(\theta)\cos(\theta)$
* $y = r\sin(\theta) = f(\theta)\sin(\theta)$

So actually $\frac{dy}{dx}$ can be found as before: $\frac{y^\prime(\theta)}{x^\prime(\theta)}$. You just need to use the product rule for each of $y$ and $x$. For example, let's find the equation of the line tangent to the rose $r = 2\sin(2\theta)$ at $\theta = \frac{\pi}{4}$.

First let's find the point. When $\theta = \pi/4$:

* $x = r\cos(\pi/4) = 2\sin(\pi/2)\cos(\pi/4)$, so $x = \sqrt{2}$.
* $y = r\sin(\pi/4) = 2\sin(\pi/2)\sin(\pi/4)$, so $y = \sqrt{2}$.

Now let's find the derivatives:

* $x^\prime(\theta) = (2\sin(2\theta)\cos(\theta))^\prime$.
* Product rule: $4\cos(2\theta)\cos(\theta) - 2 \sin(2\theta) \sin(\theta)$.
* $x^\prime(\pi/4) = -\sqrt{2}$.
* $y^\prime(\theta) = 4\cos(2\theta)\sin(\theta) + 2\sin(2\theta)\cos(\theta)$.
* $y^\prime(\pi/4) = \sqrt{2}$.

So the slope is $\sqrt{2} / -\sqrt{2}$ or $-1$.

Now that we have the point and the slope, we have our equation: $y  - \sqrt{2} = -(x - \sqrt{2})$. Graph:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/evvrvfaepj?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

# Playing with desmos again

**Question**: How might we "rotate" $y = x^2$ by $45^\circ$? ($\frac{\pi}{4}$)
* 120 degrees? 30 degrees? etc?
* In rectangular, $(x,y)$ coordinates? Impossible.

Solution? Switch to polar! $y$ becomes $r\sin(\theta)$, and $x$ becomes $r\cos(\theta)$. Since $y = x^2$, we have:

* $r\sin(\theta) = r^2 \cos^2(\theta)$
* Solve for $r$:
* $r = \sec(\theta)\tan(\theta)$
* Rotate: $r = \sec(\theta - \pi/4)\tan(\theta - \pi/4)$!
* [Graph!](https://www.desmos.com/calculator/xswxtshltr)
