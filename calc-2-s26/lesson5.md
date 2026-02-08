# Calculus II Lesson 5: Partial Fractions, Center of Mass
{: .no_toc}

1. Table of Contents
{:toc}

# Quiz

# Homework questions?

* HW 1 due today.
* Exit ticket due today also.

# Upcoming

* Today: partial fractions, center of mass application
* Thursday: review for exam 1
* Exam 1: **Monday, 2/16**.
  * Chapter 1
  * Sections 3.1, 3.2, 3.4
  * Section 2.6
* Problem Presentation 1: **Monday, Feb 23**, **Thursday, Feb 26**, **Monday, March 2**.

## Problem Presentation

* Describe a **challenging problem**
    * Homework (textbook / MOM)?
    * Textbook, not assigned?
    * Anywhere else?
* Explain the solution
    * Pretend you're working through a problem "on the board" in class.
    * What formulas / techniques / etc were needed?
    * How did you know which method to use?
* Use either slides or can go over the problem on the chalkboard.
* Keep it short: roughly 5 minutes.
* See rubric on BrightSpace

## Questions?

* Meaning of Definite Integral / FTC
* Integration by substitution
* Exponential / Logarithmic Functions
* Inverse Trig
* Integration by Parts
* Trig powers
* Products of trig functions of different angles

# Partial Fractions

How do we compute the following?

$$\int \frac{1}{x^2 - 1} dx$$

First, notice that: $$\frac{1/2}{x-1} - \frac{1/2}{x+1} = \frac{1}{x^2 - 1}$$

(Algebra! Get commone denominators on the left side)

Then: $\int (\frac{1/2}{x-1} - \frac{1/2}{x+1})dx = \frac{1}{2}(\ln\|x-1\| - \ln\|x+1\|) + C$

So the question becomes: how do we go from $\frac{1}{x^2 - 1}$ to $\frac{1/2}{x-1} - \frac{1/2}{x+1}$?

**Another example**:

$$\frac{1}{(x+1)(x+2)} = \frac{A}{x+1} + \frac{B}{x+2}$$

How would I solve for $A$ and $B$?

$$
\begin{align}
\frac{1}{(x+1)(x+2)} &= \frac{A}{x+1} + \frac{B}{x+2} \\
&= \frac{A(x+2) + B(x+1)}{(x+1)(x+2)}
\end{align}
$$

* $A(x+2) + B(x+1) = 1$, no matter what $x$ is
* $x = -2$, then $B = -1$.
* $x = -1$, then $A = 1$.

So: $\frac{1}{(x+1)(x+2)} = \frac{1}{x+1} - \frac{1}{x+2}$

## Partial Fractions

This is the method of **partial fractions**.

* Rational function $\frac{P(x)}{Q(x)}$
* Factor $Q(x)$
* For most examples we will do: $Q(x) = (ax + b)(cx + d)$
* Then $\frac{P(x)}{Q(x)} = \frac{A}{ax + b} + \frac{B}{cx + d}$ is the **partial fraction decomposition**
* How to find $A$ and $B$?
  * Common denominator
  * Pick special values of $x$ that cancel nicely.
  * Use zeroes of $Q(x)$

## Exercises

Decompose into partial fractions and integrate.

1. $\int \frac{1}{(x+2)(x-1)} dx$
2. $\int \frac{1}{x^2 - 6x + 5} dx$

**Solutions**:

$$\int \frac{1}{(x+2)(x-1)} dx$$

* Using partial fractions, $\frac{1}{(x+2)(x-1)} = \frac{1/3}{x+2} - \frac{1/3}{x-1}$.
* $\int \frac{1/3}{x+2} dx - \int \frac{1/3}{x-1} dx$
* $\frac{1}{3} \ln\|x+2\| - \frac{1}{3} \ln\|x-1\| + C$

$$\int \frac{1}{x^2 - 6x + 5} dx$$

* Factor: $x^2 - 6x + 5 = (x-5)(x-1)$
* Partial Fractions: $\frac{1}{(x-5)(x-1)} = \frac{1/4}{x-5} - \frac{1/4}{x-1}$
* $\int \frac{1/4}{x-5} dx - \int \frac{1/4}{x-1} dx$
* $\frac{1}{4} \ln\|x-5\| - \frac{1}{4} \ln\|x-1\| + C$

## More general

$$\frac{1}{(x+1)(x+2)(x+3)} = \frac{A}{x+1} + \frac{B}{x+2} + \frac{C}{x+3}$$

* $x = -1$: $A(x+2)(x+3) = 1$ means $A = \frac{1}{2}$.
* $x = -2$: $B(x+1)(x+3) = 1$ means $B = -1$.
* $x = -3$: $C(x+1)(x+2) = 1$ means $C = \frac{1}{2}$.

Then we can just integrate:

$\frac{1}{2}\int \frac{dx}{x+1} - \int \frac{dx}{x+2} + \frac{1}{2} \int \frac{dx}{x+3}$

Final answer: $\frac{1}{2}\ln\|x+1\| - \ln\|x+2\| + \frac{1}{2}\ln\|x+3\| + C$

# Center of Mass

<img src="https://openstax.org/resources/42626723b995f5b5b5ef3657223f7d915b846120" style="background: currentColor" alt="Balancing point" />

Suppose:

* $m_1 = 10$ kg
* $m_2 = 20$ kg
* $x_1 = -2$
* $x_2 = 2$

What is the balancing point?

## Moments, 1D

* Looking for $x$ such that $mass \cdot distance$ is the same on both sides.
* $20(2-x) = 10(x - (-2))$
* $40 - 20x = 10x + 20$
* $20 = 30x$
* $x = \frac{20}{30} = \frac{2}{3}$

30 is the total mass of the system. 20 is the **moment** of the system with respect to the origin.

## Moments, 2D

<img src="https://openstax.org/resources/e883c540354e80eb11c32e769534a18b96206078" style="background: currentColor" alt="Point mass located at (x1, y1)" />

* $M_x$ = moment with respect to $x$-axis? $m_1 \cdot y_1$ (mass times distance to x-axis)
* $M_y$ = moment with respect to $y$-axis? $m_1 \cdot x_1$ (mass times distance to y-axis)

## Moments, 2D

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/l3ndjrv9mq?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Center of mass? Sum of all the moments:

* $M_x = 10(1) + 5(-3) = -5$
* $M_y = 10(1) + 5(4) = 30$
* Total mass: 15kg.
* Center of mass?
    * $(\frac{M_y}{M}, \frac{M_x}{M})$
    * $(2, -\frac{1}{3})$

## Center of Mass

* Pretend all mass is concentrated on this one point
* Useful for calculating gravity
    * Much harder to compute the forces on all the individual particles

## Centroid of Rectangle

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/inr2omxd5b?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

* Rectangle of uniform density $\rho$?
* $(\frac{x_1 + x_2}{2}, \frac{y}{2})$

## Centroid of Curve

<img src="https://openstax.org/resources/df3152018c89d6a7aaafdb051ee8eb6d4569925e" style="background: currentColor" alt="Region enclosed by a curve" />

* Assume uniform density $\rho$.
* Approximate the moments and total mass by rectangles.
* Split into $n$ rectangles
* Endpoints $x_0, x_1, \ldots, x_n$

## Moments of one rectangle

<img src="https://openstax.org/resources/4edea7bac957c4e910e44d8cf6308c13826cee17" style="background: currentColor" alt="One rectangle in curve" />

* $M_x$ = (mass of rectangle) $\cdot \frac{y}{2}$
* $M_y$ = (mass of rectangle) $\cdot x_i$ (if $x_i$ and $x_{i+1}$ are close)
* mass of rectangle $= \rho y \Delta x$

Let's find the moments:

* $M_x \approx \sum\limits_{i = 1}^n \rho (y \Delta x) (\frac{y}{2})$
* $M_y \approx \sum\limits_{i = 1}^n \rho (y \Delta x) (x)$
* $m \approx \sum\limits_{i = 1}^n \rho y \Delta x$

Let's take the limit. As $n \rightarrow \infty$, if $y = f(x)$:

* $M_x = \rho \int_a^b \frac{(f(x))^2}{2} dx$
* $M_y = \rho \int_a^b xf(x) dx$
* $m = \rho \int_a^b f(x) dx$
* Center of mass = $(\frac{M_y}{m}, \frac{M_x}{m})$
* $\rho$ cancels!

## Example

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/apbt3q6yak?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

* Region enclosed by $y = \sin(x)$
* $x = 0$ to $x = \pi$
* Center of mass: $(\pi/2, \pi/8)$
* Confirm this!
