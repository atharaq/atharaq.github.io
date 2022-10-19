# Calculus I Lesson 14: Related Rates
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

An airplane is flying overhead at a constant elevation of 4000ft. A man is viewing the plane from a position 3000ft from the base of a radio tower. The airplane is flying horizontally away from the man. If the plane is flying at the rate of 600ft/sec, at what rate is the distance between the man and the plane increasing when the plane passes over the radio tower?

In small groups:

1. Draw a picture. Label it with variables.
2. Relate your variables with an equation.
3. Differentiate implicitly.

## Homework questions?

## Funnel Example

Water is draining from the bottom of a cone-shaped funnel at the rate of 0.05 $\mathrm{ft}^3 / \mathrm{sec}$. The height of the funnel is 2 ft and the radius at the top of the funnel is 1ft. At what rate is the height of the water in the funnel changing when the height of the water is $\frac{1}{2}$ ft?

<img src="https://openstax.org/resources/3cc93b86da3e1bb1b4269fb6c1adac832bad6253" data-media-type="image/jpeg" alt="A funnel is shown with height 2 and radius 1 at its top. The funnel has water to height h, at which point the radius is r." />

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

## Another Example

(Section 4.1 #10):

A 6-ft-tall person walks away from a 10-ft lamppost at a constant rate of 3ft/sec. What is the rate that the tip of the shadow moves away from the pole when the person is 10ft away from the pole?

In small groups (again):

1. Draw a picture. Label it with variables.
2. Relate your variables with an equation. **Hint**: Your picture should have *similar triangles*. The corresponding side lengths can be put in proportion.
3. Differentiate implicitly.
4. Solve.

## Solution

<img src="https://openstax.org/apps/archive/20220815.182343/resources/dddabf1f33f8de8e69c0e6cf80c2ffc7ebc7eeff" />

Let $x$ be the distance from the person to the tip of their shadow, and let $y$ be the distance from the person to the base of the lamppost. Then $y = 10$ and $y^\prime = 3$ at the moment we are looking for.

Set up a proportion: $\frac{x}{6} = \frac{x + y}{10}$. Cross multiply to get $10x = 6(x + y)$.

Now go back to our original equation and differentiate both sides implicitly: $$10x^\prime = 6(x^\prime + y^\prime).$$ Plug in $y^\prime = 3$ and solve:

* $10x^\prime = 6x^\prime + 18$.
* $4x^\prime = 18$.
* So $x^\prime = 4.5$ feet per second.

Recall that the question is asking for the speed at which the tip of the shadow moves away from the pole. What is $x^\prime$ in the context of this problem?

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

<img src="https://openstax.org/resources/e585f057904f6a4921f41459177c281a6e560558" data-media-type="image/jpeg" alt="The function f(x) is shown, which curves upward from quadrant III, slows down in quadrant II, achieves a local maximum on the y-axis, decreases to achieve a local minimum in quadrant I at x = 1, increases to a local maximum at x = 2 that is greater than the other local maximum, and then decreases rapidly through quadrant IV." >

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

<img src="https://openstax.org/resources/a60e8cf30409df9c4c687f5fcde44a2584ce2864" data-media-type="image/jpeg" alt="This figure has five parts a, b, c, d, and e. In figure a, a parabola is shown facing down in quadrant I; there is a horizontal tangent line at the local maximum marked f’(c) = 0. In figure b, there is a function drawn with an asymptote at c, meaning that the function increases toward infinity on both sides of c; it is noted that f’(c) is undefined. In figure c, a version of the absolute value graph is shown that has been shifted so that its minimum is in quadrant I with x = c. It is noted that f’(c) is undefined. In figure d, a version of the function f(x) = x3 is shown that has been shifted so that its inflection point is in quadrant I with x = c. Its inflection point at (c, f(c)) has a horizontal line through it, and it is noted that f’(c) = 0. In figure e, a version of the function f(x) = x1/3 is shown that has been shifted so that its inflection point is in quadrant I with x = c. Its inflection point at (c, f(c)) has a vertical line through it, and it is noted that f’(c) is undefined." id="10">

# Upcoming

* Quiz on Monday!
* Homework 6, due next Thursday:
   * Section 3.9 #332, 334, 343
   * Section 4.1 #12, 13
