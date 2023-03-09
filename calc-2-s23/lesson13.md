# Calculus II Lesson 13: Linear First-order Differential Equations
{: .no_toc}

1. Table of Contents
{:toc}

# Quiz

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

# Exam 2

Next week:

* Exam 2
* Cumulative (some topics from exam 1)
  * Explicitly and implicitly!
  * Meaning, you should know how to integrate by parts / partial fractions / etc, to help with applications problems.

Since Exam 1:

* Improper integrals (3.7)
* Areas between curves (2.1)
* Volumes (2.2 - 2.3)
  * Disk Method: $V = \int \pi (f(x))^2 dx$
  * Washer: $V = \int \pi (f(x)^2 - g(x)^2) dx$
  * Shell: $V = \int 2\pi x f(x) dx$
* Arc Length (2.4)
* Differential Equations:
  * Basic (4.1), position / velocity / acceleration
  * Separable (4.3), exponential growth
  * Linear (4.5)
