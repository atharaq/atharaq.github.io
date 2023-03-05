# Calculus II Lesson 12: Differential Equations
{: .no_toc}

1. Table of Contents
{:toc}

# Upcoming

* MyOpenMath HW due tonight (questions?)
* Quiz Thursday
* Exam 2 **in-class** next Thursday (3/16).
  * Later that day: NSS Lecture Series at 4:30!

# Differential Equations

* Scientific experiments: can be easier to observe *changes* to data
* Might not know the *actual* formula describing your data
* How a quantity changes may be related to the quantity itself
  * Ex: the more money you have, the more it earns in interest / investment

Sometimes:

* Can be easier to find the relationship between the change and the quantity
* Set up a *differential equation*

## Example

* Suppose we are growing a bacteria culture.
* The larger the culture, the bigger the growth of the culture at any given time.
* Let $m(t)$ be the mass of the culture at time $t$. (Can easily measure its mass.)
* We notice: at any given $t$ (in seconds?), the culture grows at a rate $.05m(t)$
  * Idea: take lots of measurements, compare mass to previous mass. Look for a pattern.
* Initial mass: 2 grams. Mass in 10 minutes?

We have a *differential equation*:

$$m^\prime(t) = .05 m(t)$$

What functions are proportional to their own derivatives? **Exponential functions!** Guess $m(t) = Ae^{kt}$, and use $m^\prime$ and $m(0)$ to find these constants $A$ and $k$.

## Solution

$$
\begin{align}
m(t) &= Ae^{kt} \\
m^\prime(t) &= Ake^{kt} \\
 &= .05 m(t) \\
 &= .05 Ae^{kt} \\
k &= .05
\end{align}
$$

So we have:

* $m(t) = Ae^{.05t}$
* $m(0) = 2$

Find $A$?

$$
\begin{align}
Ae^{0} = 2 \\
A = 2
\end{align}
$$

Solution:

* $m(t) = 2e^{.05t}$
* $m(10) = 2e^{.5} \approx 3.3$ grams.

# Overview

* Any equation involving the *derivative* of a quantity is known as a **differential equation**.
* Example: $y^\prime = x$.
* A function $y = f(x)$ satisfying that equation is called a **solution** to the differential equation.
* In general: differential equations do not have unique solutions:
  * $y = \frac{x^2}{2}$ is a solution to $y^\prime = x$.
  * $y = \frac{x^2}{2} + 1$ is another solution.

## Solutions to differential equations

* We look for a **general form** for a solution:
  * $y = \frac{x^2}{2} + C$.
* If we have an **initial condition**, we can find an exact solution.
  * Suppose $y^\prime = x$ and $y(0) = -1$.
  * Then $y = \frac{x^2}{2} + C$.
  * $-1 = \frac{0^2}{2} + C$
  * $C = -1$.
  * So: $y = \frac{x^2}{2} - 1$.

## Order

The **order** of a differential equation is the highest derivative that appears in the equation. **Exercise**: Identify the orders of the following:

1. $y^\prime = y + x$
2. $(y^\prime)^2 = (y - x)^2$
3. $y^{\prime\prime} = -y$
4. $y^{\prime\prime\prime} + (y^\prime)^5 = y$

We will mostly focus on first-order differential equations, but some simple higher order differential equations can be solved.

## Example

A ball is thrown straight into the air with an initial velocity of 5 meters per second. It is acted on by a constant, downward force of gravity, causing an acceleration of $-9.8$ $m/s^2$.

1. Find a formula $v(t)$ for the velocity at time $t$ seconds after the ball is thrown.
2. How many seconds after the ball is thrown does it reach its maximum height?
3. If the ball is thrown at a height of 2 meters above the ground, what is the maximum height reached?

## Solution 

Since $v^\prime(t) = a(t)$, and $a(t) = -9.8$, we know:

* $v^\prime(t) = -9.8$
* $v(0) = 5$.

So: $v(t) = -9.8t + C$. Since $v(0) = 5$, we can compute $5 = -9.8(0) + C$, so $C = 5$.

So our formula for the velocity is $v(t) = -9.8t + 5$. Going back to Calc I:

* the ball reaches its maximum height when its upward velocity is 0
* $v(t) = -9.8t + 5 = 0$
* Solve for $t$: $t = \frac{-5}{-9.8} \approx .51$ seconds.
* Derivative of height: velocity.
* $h^\prime(t) = -9.8t + 5$.
* So: $h(t) = -4.9t^2 + 5t + C$.
* $h(0) = 2$ means $-4.9(0) + 5(0) + C = 2$
* So $C = 2$

Therefore $h(t) = -4.9t^2 + 5t + 2$. Then $h(\frac{5}{9.8}) \approx 3.28$ meters. This is basically the exam 1 extra credit problem.

## Wrap-up

* We really solved a *second-order* differential equation:
* $h^{\prime\prime}(t) = -9.8$
* Initial condition: $h(0) = 2$ and $h^\prime(0) = 5$.
* We did this by splitting it up into two steps:
  * First find $h^\prime(t)$
  * Then find $h(t)$.

# Separable Equations

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/Ngu65TwQU_8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

A differential equation of the form $y^\prime = f(x)g(y)$ is called a **separable equation**. We solve it by separating varaibles:

$$\frac{y^\prime}{g(y)} = f(x)$$

Then we integrate both sides: the left side with respect to $y$, and the right side with respect to $x$:

$$\int \frac{dy}{g(y)} = \int f(x) dx$$

Let's do a simple example: $y^\prime = y$, with $y(0) = 1$. We separate variables and set up the integrals:

$$\int \frac{dy}{y} = \int 1 dx$$

We end up with:

$$\ln(y) = x + C$$

Solve this for $y$. Since the inverse of $\ln(y) = x$ is $e^x = y$, we have:

$$y = e^{x + C}$$

Since $e^{x+C} = e^x \cdot e^C$, and $e^C$ is just another constant, we re-write our solution as $y = A e^x$, where $A$ is a constant.

Now we plug in our initial conditions: $y(0) = 1$ means $1 = A e^0$, or $A = 1$. Therefore our solution is $y = e^x$.

As a side note: there are many equivalent ways of defining the number $e$. One way is the classic limit definition using compound interest: $e = \lim\limits_{n \rightarrow \infty} (1 + \frac{1}{n})^n$. Another way is to define $e$ using differential equations: here we used our knowledge of $e$ and $\ln$ to solve the above differential equation, but you can *start* with the differential equation $f^\prime(x) = f(x)$ and $f(0) = 1$, and *define* $e$ to be $f(1)$.

Each of these definitions can be used as a starting point, and then we can prove, mathematically, that the other properties of $e$ hold. That is, for example, we could start with $e$ using the differential equations definition, and then we can prove that $f(1)$ is exactly equal to that limit definition.

There are still other definitions of $e$ ([the textbook provides another one in section 2.7](https://openstax.org/books/calculus-volume-2/pages/2-7-integrals-exponential-functions-and-logarithms)). Why do mathematicians define $e$ in so many ways? Really because mathematicians tried, for a long time, to make mathematics rigorous. They wanted to find the exact axioms and definitions that we can start with, so that, making those assumptions, we can *prove* everything else there is to know about mathematics. Calculus was especially tricky to make rigorous; the history of mathematics often involves terms (like limits and continuity) being redefined to try to make the intuitive results actually *provable*.

## Example and check

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/GQe1tu70lt4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

In this video I go through another example of a separable differential equation:

$$
\begin{align}
y^\prime &= \frac{x}{y} \\
y(0) &= 2
\end{align}
$$

We solve this by separating variables and integrating:

$$\int y dy = \int x dx$$

Integrating:

$$\frac{y^2}{2} = \frac{x^2}{2} + C$$

Or $y^2 = x^2 + C$. Taking square roots, either $y = \sqrt{x^2 + C}$ or $y = -\sqrt{x^2 + C}$. Since $y(0) = 2 > 0$, we know that the second option is not possible, so it must be that $y = \sqrt{x^2 + C}$.

Now we plug in our initial condition: $y(0) = 2$ means that $\sqrt{C} = 2$. Therefore $C = 4$, and so the solution to the original equation is $y = \sqrt{x^2 + 4}$.

We can check that this solution works by plugging it back into the original differential equation. First, it's clear that this solution satisfies the initial condition, $y(0) = 2$. Next, we show that it satisfies $y^\prime = \frac{x}{y}$.

Since $y = (x^2 + 4)^{\frac{1}{2}}$, we take the derivative. Using the power rule and chain rule: $y^\prime = \frac{1}{2} (x^2 + 4)^{-\frac{1}{2}} \cdot (2x)$, or $y^\prime = \frac{x}{\sqrt{x^2+4}}$. But this is exactly $\frac{x}{y}$, which is what we wanted to show!

## Mass Example

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/Jiboeeqk75o" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**Problem**: A culture of bacteria grows at a rate proportional to its mass. If the culture initially weighs 10g, and in one hour, it weighs 15g, find a formula $m(t)$ for its mass (in grams) $t$ hours after that initial measurement.

I solve this problem in the above video. First, we set up a differential equation: $m^\prime(t) = km(t)$. We don't know what $k$ is, but we know it must be a constant, since the problem states that $m^\prime$ is proportional to $m$. Then we have two initial conditions: $m(0) = 10$ and $m(1) = 15$.

We solve the equation by separating variables:

$$
\begin{align}
\int \frac{dm}{m} = \int k dt \\
\ln(m) = kt + C \\
m = e^{kt + C} = e^{kt} e^C
\end{align}
$$

Since $e^C$ is a constant, we can refer to this as another constant $A$, and our solution is $m(t) = Ae^{kt}$.

Notice that we have two unknown constants here: $A$ and $k$. We can use the two initial conditions to find it: $m(0) = 10$ means taht $Ae^{0} = 10$. Therefore $A = 10$, so $m(t) = 10 e^{kt}$.

$m(1) = 15$ means $10e^{k} = 15$, or $e^k = 1.5$. Therefore $k = \ln(1.5) \approx 0.41$. The solution, then, is $y = 10 e^{\ln(1.5) t}$. Using rules for exponents, $e^{\ln(1.5) t} = (e^{\ln(1.5)})^t$, and since $e^{\ln(x)} = x$, we can further simplify our solution to $m(t) = 10 \cdot 1.5^t$.

## Textbook Section

Material on separable equations is covered in [Section 4.3](https://openstax.org/books/calculus-volume-2/pages/4-3-separable-equations) in the textbook. There are several other worked examples there, I strongly encourage going through those as well as the exercises in that section.

# Linear First Order Differential Equations

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/rTONkmQnHr4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
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

$y = \frac{e^2x + C}{2e^{2x}} = \frac{1}{2} + \frac{C}{e^{2x}}$, or $y = \frac{1}{2} + Ce^{-2x}$. Now we can use $y(0) = 0$ to find the solution: $y(0) = 0$ means that $\frac{1}{2} + C = 0$. So $C = -\frac{1}{2}$.

Therefore our final answer is $y = \frac{1}{2} - \frac{1}{2} e^{-2x}$.

## Examples from the book

This particular method can be challenging. I encourage you to also follow along the [examples in the textbook](https://openstax.org/books/calculus-volume-2/pages/4-5-first-order-linear-equations). Try to use these 5 steps before you see the textbook do the problem, and then follow along as the textbook solves these problems as well.
