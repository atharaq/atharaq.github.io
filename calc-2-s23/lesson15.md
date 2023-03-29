# Calculus II Lesson 15: Areas and Arc Lengths of Parametric Curves
{: .no_toc}

1. Table of Contents
{:toc}

# Warm Up

**Hand in**: 

1. [Section 7.2, #72](https://openstax.org/books/calculus-volume-2/pages/7-2-calculus-of-parametric-curves#fs-id1167794048157) Find all points on the curve $x(t) = 2\cos(t)$, $y(t) = 8\sin(t)$ with slope = -1.
2. 7.2 #76: Write the equation of the tangent line to the curve $x(t) = t\ln(t)$, $y(t) = \sin^2(t)$ at $t = \frac{\pi}{4}$.

# Areas Under Parametric Curves

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/quNCGcD2_Lw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Continuing on with our study of parametric curves, we can compute areas under such curves. Consider a curve given by parametric equations $x(t)$ and $y(t)$. Suppose we want to find the area under the curve from when $t = a$ to $t = b$. As we did when we computed areas under curves defined by functions $y = f(x)$, we can divide the interval up into small sub-intervals, and approximate the area by rectangles:

<img src="https://openstax.org/resources/a2db09935d39d947568703f0f8362a6abade9191" alt="Figure 7.22 from the textbook, approximating the area under a parametrically defined curve" />

The area of one such rectangle is approximated as $y(t)(x(t_{i+1}) - x(t_i))$, or, more simply, $y \Delta x$. So the area under the entire interval would be approximated by the sum

$$\sum_{i=0}^n y(t_i) \Delta(x)$$

or $\sum y(t) \Delta x \frac{\Delta t}{\Delta t}$. Moving the $\Delta t$ over, we get $\sum y(t) \frac{\Delta x}{\Delta t} \Delta t$. As we divide the interval into more and more sub-intervals, our limit becomes $\int_a^b y(t) x^\prime(t) dt$.

## Example

As an example, let's compute the area under the curve defined by $x(t) = \cos(t)$, $y(t) = \sin(t)$, from $t = 0$ to $t = \pi$.

The formula is $\int_0^{\pi} y(t) x^\prime(t) dt$. Since $x^\prime(t) = -\sin(t)$, the integral is:

$$\int_0^{\pi} -\sin^2(t) dt$$

Use the formula $\sin^2(t) = \frac{1}{2} - \frac{\cos(2t)}{t}$, and integrate:

$$-\int_0^{\pi} (\frac{1}{2} - \frac{\cos(2t)}{t}) dt = -\frac{t}{2} - \frac{\sin(2t)}{4}$$

Plug in $t = \pi$ and $t = 0$ and subtract:

$$-\frac{\pi}{2} - \frac{\sin(2\pi)}{4} + \frac{0}{2} + \frac{\sin(0)}{4}$$

Or, more simply, the area is $-\frac{\pi}{2}$. Why is this negative? Look at the graph:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/eewjpejitr?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Notice that going from $t = 0$ to $t = \pi$ goes from $(1, 0)$ to $(-1, 0)$, or from right to left. And so the area is negative.

## Exercise

Consider the curve given by the parametric equations $x(t) = t^2$ and $y(t) = t + 2$. Find the areas under the curve for the following regions:

1. From $t = -2$ to $t = 0$.
2. From $t = 0$ to $t = 2$.
3. From $t = -2$ to $t = 2$.

<details>
<summary>Check your answers</summary>

<ol>
<li>$-\frac{8}{3}$. Notice that this is negative, as it goes from right to left.</li>
<li>$\frac{40}{3}$</li>
<li>$\frac{32}{3}$</li>
</ol>
</details>

# Arc Length

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/pw8Kf7kdXS8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Next we study arc lengths of parametrically defined curves. To find arc lengths of curves, we first approximate the length by using line segments:

<img alt="Figure 7.23 from the textbook: Approximating the length of a curve by line segments" src="https://openstax.org/resources/958630c1f34eee5dd96dea6574e4a1dceae5d7d2" />

The length of a line segment between $(x_0, y_0)$ and $(x_1, y_1)$ is $\sqrt{(\Delta x)^2 + (\Delta y)^2}$. So the approximation of the arc length of the curve is given by

$$\sum_{i=0}^{n} \sqrt{(\Delta x)^2 + (\Delta y)^2}$$

Similarly, we multiply this by $\frac{\Delta t}{\Delta t}$, and using some algebra, we end up with:

$$\sum_{i = 0}^n \sqrt{\frac{\Delta x}{\Delta t}^2 + \frac{\Delta y}{\Delta t}^2} \Delta t$$

As $n \rightarrow \infty$, again the approximation should get better, and the exact arc length is given by

$$\int_a^b \sqrt{x^\prime(t)^2 + y^\prime(t)^2} dt $$

## Example

As before, let's look at the arc length of the curve defined by $x(t) = \cos(t)$ and $y(t) = \sin(t)$, from $t = 0$ to $t = \pi$. We take the derivatives: $x^\prime(t) = -\sin(t)$ and $y^\prime(t) = \cos(t)$. Squaring each, we get $(x^\prime(t))^2 = \sin^2(t)$ and $(y^\prime(t))^2 = \cos^2(t)$. Then we add: $\sin^2(t) + \cos^2(t) = 1$. Now we set up the integral:

$$\int_0^{\pi} \sqrt{(x^{\prime}(t))^2 + (y^\prime(t))^2} dt$$

Plugging in, we get $\int_0^{\pi} \sqrt{1} dt$, or $\int_0^{\pi} 1 dt = t$, from $t = 0$ to $t = \pi$, and so the length is $\pi$.

Notice, of course, that the curve we looked at was a semicircle of radius 1, and so it's length is given by $\frac{2 \pi r}{2} = \pi(1) = \pi$.

## Exercise

Find the length of the curve given by $x(t) = t \cos(t)$ and $y(t) = t \sin(t)$ from $t = 0$ to $t = 2\pi$. **Approximate your answer to three decimal points.**

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/zwdwthno5m?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Recall the steps:

1. Find $x^\prime(t)$ and square it.
2. Find $y^\prime(t)$ and square it.
3. Add them and simplify.
4. Set up the integral and solve (using a calculator to help).

<details>
<summary>Check your answer.</summary>
<ol>
<li>$(x^\prime(t))^2 = \cos^2(t) - 2t\cos(t)\sin(t) + t^2 \sin^2(t)$</li>
<li>$(y^\prime(t))^2 = \sin^2(t) + 2t\cos(t)\sin(t) + t^2 \cos^2(t)$</li>
<li>When you add and simplify, you should get $1 + t^2$, using the trig identities.</li>
<li>$\int_0^{2\pi} \sqrt{1 + t^2} dt \approx 21.256$, using a calculator.</li>
</ol>
</details>


# Next time: Polar coordinates

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/YCpI840vrYk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Next time, we will study polar coordinates. Often times, students get hung up on the definitions and conversions between "regular" coordinates and polar coordinates that they lose sight of the intuition. The reason we study polar coordinates is because certain kinds of geometric problems are better studied using polar coordinates. What might these be?

Geometrically, Cartesian coordinates are "rectangular". They describe distances to the left/right, and up/down. We might be interested in these kinds of coordinates to do things like translate functions to the left or right, or stretch / shrink objects horizontally or vertically:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/ywbwbg9ipd?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

But what if we wanted to take a point and rotate it around the origin? Or if we wanted to re-scale an object to be twice as far from the origin? Then our motivating geometric intuition is no longer rectangular, it's *circular*!

We want to move around in a circle (rotations), or to stretch out the size of the circle (re-scaling). These operations are best done using **polar coordinates**, where we describe points on the plane by their distance from the origin $r$, and the angle we make to get to that point with the $x$-axis ($\theta$). For example, in polar coordinates, the point $(1, \frac{\pi}{2})$ represents the point of distance $1$ that is 90 degrees from the $x$-axis: in other words, the point a single unit straight up from the origin.

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/dxzfcdwob6?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

If we want to re-scale it, we just multiply the $r$ coordinate by a certain amount. If we want to rotate that point around the origin, we just add to the $\theta$ coordinate. The below graph depicts what happens when we add to the angle of the point $(1, \frac{\pi}{2})$:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/ssbsks0hxo?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Next time, we will see how to convert between $(x, y)$ coordinates and $(r, \theta)$ coordinates, we will look at graphs of some polar curves, and we will start looking at calculus of polar curves.

<!-- 
Next warm up: would be to hand in 7.2 104, 114. Maybe 80?
-->