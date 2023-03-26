# Calculus II Lesson 13: Linear First-order Differential Equations
{: .no_toc}

1. Table of Contents
{:toc}

# Exam 2

* Differential Equations!

# Announcement

Keep an eye on your email / Moodle for announcements about possible cancelations / last minute changes to classes over the next two weeks. Unless I say otherwise:

* **Thursday, April 6** will be asynchronous. The lecture notes will be posted on Moodle.
* **Monday, April 10** might be asynchronous or on Zoom. This will be announced later.

# 2D Curves

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/t5gl4c8pxk?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

* Not a function
* But...can still study tangent lines!
* Every 2D curve can be described with *parametric equations*

**Parametric Equations**: Instead of $y = f(x)$, we have two functions: $x(t)$ and $y(t)$. $x(t)$ and $y(t)$ describe the $(x, y)$ coordinates of the curve at time $t$. $t$ is referred to as the *parameter*.

**Example**: Graph the curve described by $x(t) = t^2$, $y(t) = t + 1$:

| $t$ | $x$ | $y$ |
| --- | --- | --- |
| -2  |  4  |  1 |
| -1  | 1   | 0 |
| 0 |     0 |   1 |
| 1  |   1 |   2 |
| 2 |    4   | 3 |

Graph: 

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/vtddnk5bqn?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

## Exercise

Graph the parametric curve given by:

* $x(t) = 2 \cos(t)$
* $y(t) = 2 \sin(t)$

from $t = 0$ to $t = 2\pi$.

Find the point on the graph when $t = \pi/4$.

## Dimension

Aside: is a circle a *one*-dimensional object or a *two*-dimensional object?

* The *space* we draw the circle in is two-dimensional. (We could draw it in a three dimensional space if we wanted to...)
* Is the circle *itself* 2D?
* To describe points on a circle, we really need only one variable.
* Mathematically: one-dimensional object living in a two-dimensional space.

## Desmos

Aside: graphing parametric curves in desmos.

* Instead of writing in a function $f(x) = \ldots$:
* Input *coordinate* functions: $(x(t), y(t))$.
* ie: $(2\cos(t), 2\sin(t))$.
* Must provide range, ie $0 \leq t \leq 2\pi$
* [Example](https://www.desmos.com/calculator/b0mork1xom)

# Calculus

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/4x9thzc8jz?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

* If the curve is "smooth", we can find derivatives.
* $x(t) = 2\cos(t)$
* $y(t) = 2\sin(t)$
* $x^\prime(t) = -2\sin(t)$ means?
* $x^\prime(0) = -2\sin(0) = 0$ means?

## Derivatives

* $x^\prime(t)$: rate of change of the curve in the $x$-direction
* $y^\prime(t)$: rate of change of the curve in the $y$-direction
* What about the slope of a tangent line?
* $\frac{dy}{dt} = y^\prime(t)$
* $\frac{dx}{dt} = x^\prime(t)$


Chain rule! $\frac{dy}{dx} = \frac{y^\prime(t)}{x^\prime(t)}$

## Tangent Lines

Example: Find the equation of the tangent line to the graph of $x(t) = 2\cos(t)$, $y(t) = 2\sin(t)$ at $t = \pi/4$.

* Use *point-slope* form: $y - y_0 = m(x - x_0)$
* $y_0 = y(\pi/4) = 2\sin(\pi/4) = \sqrt{2}$
* $x_0 = x(\pi/4) = 2\cos(\pi/4) = \sqrt{2}$
* $m = \frac{y^\prime(\pi/4)}{x^\prime(\pi/4)}$
* $y^\prime(t) = 2\cos(t)$, $x^\prime(t) = -2\sin(t)$
* $y^\prime(t) = 2\cos(t)$, $x^\prime(t) = -2\sin(t)$
* $y^\prime(\pi/4) = 2\cos(\pi/4) = \sqrt{2}$
* $x^\prime(\pi/4) = -2\sin(\pi/4) = -\sqrt{2}$
* $\frac{dy}{dx} = \frac{\sqrt{2}}{-\sqrt{2}} = -1$

Equation: $y - \sqrt{2} = -1(x - \sqrt{2})$.

## Exercise

Find the equation of the line tangent to the parametric curve given by the equations $x(t) = t^2, y(t) = t^3$ when $t = 2$.

# Coming Up

* Areas and Arc Lengths of Parametric Curves
* Polar Coordinates
* Presentation 3 (4/7?)
