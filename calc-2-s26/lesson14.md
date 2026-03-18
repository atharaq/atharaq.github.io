# Calculus II Lesson 14: Linear First Order Differential Equations / Parametric Equations Intro
{: .no_toc}

1. Table of Contents
{:toc}

# Linear First Order Differential Equations

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/rTONkmQnHr4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

A differential equation of the form $a(x)y^\prime + b(x) y = c(x)$ is called a **linear first-order differential equation**. It's first-order because, as we saw last time, the highest derivative that shows up is $y^\prime$ (first derivative). It's linear because the powers of $y$ and $y^\prime$ are both 1. The **standard form** for a linear first order differential equation is $y^\prime + p(x) y = q(x)$. That is, when the coefficient of $y^\prime$ is just 1.

To solve a linear first order differential equation, we first notice that if we multiply the expression $y^\prime + p(x) y$ by an expression $\mu(x)$, we end up with $\mu(x) y^\prime + (\mu(x) p(x)) y$. Moreover, notice that using the product rule for derivatives $(\mu(x) y)^\prime = \mu(x) y^\prime + \mu^\prime(x) y$. That is, $\mu(x) (y^\prime + p(x) y) = (\mu(x) y)^\prime$ if $\mu^\prime(x) = \mu(x) p(x)$. In other words, if we can solve the differential equation $\mu^\prime = \mu p(x)$, and then multiply both sides by this factor we can simplify the differential equation to just $(\mu(x) y)^\prime = \mu(x) q(x)$. We then can solve that by integrating and then solving for $y$. Note that there is a formula to find $\mu(x)$, which we will see.

This is known as the *integrating factor* method. So the steps to solving a linear first order differential equation are:

1. Put the equation in standard form $y^\prime + p(x) y = q(x)$.
2. Find an *integrating factor*, $\mu(x) = e^{\int p(x) dx}$. Notice that this solves the differential equation $\mu^\prime(x) = \mu(x) p(x)$.
3. Multiply both sides by $\mu(x)$ so the equation becomes $(\mu(x) y)^\prime = \mu(x) q(x)$.
4. Integrate both sides: $\mu(x) y = \int \mu(x) q(x) dx + C$.
5. Divide by $\mu(x)$.

Let's work through the example of $y^\prime + 2y = 1$, with $y(0) = 0$. Since it's already in standard form, we start by finding $\mu(x)$. Since $p(x) = 2$, the integrating factor is $\mu(x) = e^{\int 2 dx}$, which is just $e^{2x}$. Notice that *any* antiderivative of $p(x)$ will work here.

Then we multiply both sides by $e^{2x}$: $(e^{2x} y)^\prime = e^{2x}$. Integrate and the equation is $e^{2x} y = \frac{1}{2} e^{2x} + C$. We can solve this now:

$y = \frac{e^{2x} + C}{2e^{2x}} = \frac{1}{2} + \frac{C}{e^{2x}}$, or $y = \frac{1}{2} + Ce^{-2x}$. Now we can use $y(0) = 0$ to find the solution: $y(0) = 0$ means that $\frac{1}{2} + C = 0$. So $C = -\frac{1}{2}$.

Therefore our final answer is $y = \frac{1}{2} - \frac{1}{2} e^{-2x}$.

# Physics

Physics application: air resistance.

* A falling object experiences two forces:
  * Acceleration due to gravity: $F_g = mg = 9.8m$ (assume downward is positive)
  * Air resistance (assume proportional to velocity): $F_A = -kv$ (opposite direction)
* Sum of forces = mass $\cdot$ acceleration = $m \frac{dv}{dt}$


<figure>
<img alt="Air resistance on a ball" style="background: currentColor" src="https://openstax.org/apps/archive/20230220.155442/resources/7204f86c68a6bc61fe612b898938cea7992fdb93" />
<figcaption>From Section 4.5 of the textbook</figcaption>
</figure>

We get a differential equation! $m\frac{dv}{dt} = 9.8m - kv$.

**Exercise**: A penny with weight 0.0025 kg is dropped from the top of the Empire State Building (369m). The force of air resistance on the penny is assumed to be about $-.0025v$. Set up and solve a differential equation to find the formula for the velocity $v(t)$ of the penny at time $t$.

* Set up the differential equation: $0.0025 v^\prime = 9.8(0.0025) - 0.0025v$.
* Simplify: $v^\prime = 9.8 - v$
* Standard form: $v^\prime + v = 9.8$ (linear first order equation!)
* Initial condition: $v(0) = 0$ (dropped at rest)

## Steps

Steps to solving a linear first order differential equation:

1. Get in standard form $y^\prime + p(x)y = q(x)$.
2. **Integrating factor**: $\mu(x) = e^{\int p(x) dx}$
3. Multiply both sides by $\mu(x)$: $(\mu(x) y)^\prime = \mu(x) q(x)$
4. Integrate: $\mu(x) y = \int \mu(x) q(x) dx + C$.
5. Divide by $\mu(x)$ / plug in initial conditions / solve.

## Exercise

Solve the differential equation from earlier:

$v^\prime + v = 9.8$, with $v(0) = 0$

Now that we have $v(t)$:

* What is the *terminal velocity* of the penny?
* ie, as $t \rightarrow \infty$, what is $v(t)$?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/8jdok69txd?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

# Logistic

* Earlier: modeled population growth as exponential
* $P^\prime = kP$
* What happens to population as $t \rightarrow \infty$?

## Carrying Capacity

* Several factors limit unbounded growth.
* Food scarcity, predator-prey relations, etc.
* Definition: **carrying capacity**: the maximum population that can be sustained in an environment indefinitely. Denoted with a constant $K$.
* Eventually, $P \rightarrow K$
* Equation: $\frac{dP}{dt} = rP(1 - \frac{P}{K})$.
* When $P$ is small? Roughly exponential.
* As $P \rightarrow K$?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/9szimnhv6b?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

## Other situations?

* Epidemiology! (Spread of diseases)
* Number of infections over time cannot grow exponentially.
* Why?

# Slope Fields

* How might one "graph" a differential equation?
* $y^\prime = -\frac{x}{y}$?
* At each $(x, y)$ coordinate, compute $\frac{x}{y}$.
* Make a short line segment at that point with that slope.

<figure>
<img src="https://openstax.org/apps/archive/20230220.155442/resources/cbc765cea50bbb7e778db1f23c0f7eff20a1d72e" style="background: currentColor" alt="Slope field for y' = 3x + 2y - 4" />
<figcaption>$y^\prime = 3x + 2y - 4$ (textbook section 4.2)</figcaption>
</figure>

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

