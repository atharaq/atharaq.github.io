# Calculus II Lesson 6: Center of Mass
{: .no_toc}

1. Table of Contents
{:toc}

# Warm Up

**Together**: Section 3.4, #204: $\int \dfrac{2}{x^2 - x - 6}dx$.

**Hand in**: Section 3.4 #200: $\int \dfrac{dx}{x(x-1)(x-2)(x-3)}$.

## Quiz questions?

# Center of Mass, Intro

In the notes from Monday's lecture,  we discussed this idea of the **center of mass** of a system. The idea is that it is the "balancing point" of the system. We will go through a couple of warm up examples first.

## 1D Example

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/RSOzkbkiSnA" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

First consider a one dimensional system, with two objects each concentrated on points on the $x$-axis. Then the center of mass is found by taking a weighted average of each object's location.

<img src="https://openstax.org/apps/image-cdn/v1/f=webp/apps/archive/20260105.231123/resources/42626723b995f5b5b5ef3657223f7d915b846120" style="background: currentColor" alt="Balancing point" />

For example, if, in the above image, the mass $m_1$ is 10kg and is at position $x_1 = -2$, and $m_2$ is 5kg at position $x_2 = 2$, then the center of mass can be found algebraicaly. We look for $x$ such that $10(x + 2) = 5(2 - x)$. Solving for $x$, we get $10x + 20 = 10 - 5x$. Solve this equation and get $x = \frac{10}{15}$, or $\frac{2}{3}$.

The idea is that the center of mass is found by adding up the **moments** of each object, and dividing by the sum of their masses. The **moment** of an object with respect to a point is the mass of the object multiplied by the distance from that object to a point. In this case, we add up the moments of each object with respect to the origin.

## 2D Example

Let's do a similar example, but in two dimensions. Suppose we have two objects with masses concentrated on points on the plane:

<div class="desmos-container">
  <iframe src="https://www.desmos.com/calculator/91subwwlon?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Then the center of mass of this system can similarly be found by adding up the moments of each object, and dividing by the total mass. But in two dimensions, we have to look at the moments of each object with respect to each axis.

The moment of an object with respect to the $x$-axis, $M_x$, is its mass multiplied by the $y$-value of its position. The moment with respect to the $y$-axis is the mass multiplied by the $x$-value of the position. We add up each individual moment to get the moments of the system. We add up the individual masses to get the mass of the system, $m$. The **center of mass** is located as position $(\frac{M_y}{m}, \frac{M_x}{m})$.

In other words, the center of mass is located at $(\frac{m_1x_1 + m_2 x_2}{m_1 + m_2}, \frac{m_1y_1 + m_2 y_2}{m_1 + m_2})$, which is similarly a kind of weighted average.

# Center of Mass, Continuous Region

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/H4RQc0PzZc8" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

Now we assume that the masses of our objects are distributed continuously throughout a region. For some regions, it is not challenging to find its center of mass: if the region is a rectangle of uniform density $\rho$, its center of mass is at the actual center of the rectangle:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/toml3nhgba?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

For more complicated regions, we can approximate the region with rectangles as we do for areas. We still need to assume the region has uniform density, $\rho$. We find the centers of mass of each of those rectangles, and use those to compute the center of mass for the region as a whole. In other words, we can assume that the entirety of the mass of each rectangle lies at its center (this is actually the entire point of the concept: the center of mass of an object is the point at which we can assume all of its mass is concentrated on, for the purposes of more complicated calculations.)

## Derivation

Then we use the same idea above: use the moments and masses of each rectangle to compute $M_x, M_y$ and $m$, and then the center of mass is located at $(\frac{M_y}{m}, \frac{M_x}{m})$. The computation is as follows:

<img src="https://openstax.org/apps/image-cdn/v1/f=webp/apps/archive/20260105.231123/resources/df3152018c89d6a7aaafdb051ee8eb6d4569925e" style="background: currentColor" alt="Region enclosed by a curve" />

Suppose we have a region enclosed by a curve $y = f(x)$. We split up our curve into $n$ rectangles. For one rectangle, its center is at $(\frac{x_i + x_{i+1}}{2}, \frac{f(x_i)}{2})$.

<img src="https://openstax.org/apps/image-cdn/v1/f=webp/apps/archive/20260105.231123/resources/4edea7bac957c4e910e44d8cf6308c13826cee17" style="background: currentColor" alt="One rectangle in curve" />

Notice that the mass of each rectangle is its area multiplied by the density, $\rho$:

$$m = \rho f(x_i) \Delta x$$

The moments of that rectangle are then computed as follows:

$$
\begin{align}
M_x &= \frac{f(x_i)}{2} m \\
M_y &= \frac{x_i + x_{i+1}}{2} m
\end{align}
$$

To simplify matters, we will assume that $x_i$ and $x_{i+1}$ are very close (as they will get closer to each other as $n \rightarrow \infty$). So $M_y = x_i m$. Replacing $m$ with $\rho f(x_i) \Delta x$ in each of the above formulas, we have:

$$
\begin{align}
M_x &= \frac{\rho}{2} (f(x_i))^2 \Delta x \\
M_y &= \rho x_i f(x_i) \Delta x
\end{align}
$$

We add up each of these moments to get the (approximation of the) moments of the entire region:

$$
\begin{align}
M_x &= \sum_{i=1}^n \frac{\rho}{2} (f(x_i))^2 \Delta x \\
M_y &= \sum_{i=1}^n \rho x_i f(x_i) \Delta x
\end{align}
$$

As $n \rightarrow \infty$, these sums become integrals, and we get our exact formulas for the moments of the curve:

$$
\begin{align}
M_x &= \frac{\rho}{2} \int_a^b f(x)^2 dx \\
M_y &= \rho \int_a^b x f(x) dx
\end{align}
$$

The mass of the region can be found by similarly adding up the masses of each rectangle ($\rho f(x_i) \Delta x$), and taking the limit as $n \rightarrow \infty$. We end up with:

$$m = \rho \int_a^b f(x) dx$$

Our center of mass can be found using these formulas, at the coordinate $(\frac{M_y}{m}, \frac{M_x}{m})$. Notice that the density constant $\rho$ will cancel out, so we can effectively ignore it (or just assume that it's equal to 1).

## Example

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/4BcemHZ8KE4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

Let's use these formulas to find the center of mass of the region bounded by $y = \sin(x)$, with $0 \leq x \leq \pi$.

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/lyjslvsepv?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

First let's compute the mass (assuming $\rho = 1$):

$$m = \int_0^\pi \sin(x) dx = \left.-\cos(x)\right|_0^\pi$$

Plugging in the endpoints, the mass is $-\cos(\pi) + \cos(0) = 2$.

Now we compute $M_x$:

$$\frac{1}{2} \int_0^\pi (\sin(x))^2 dx$$

Using what we learned in [Lesson 4](lesson4.html#even-powers), we replace $\sin^2(x)$ with $\frac{1}{2} - \frac{1}{2} \cos(2x)$:

$$\frac{1}{2} \int_0^\pi (\frac{1}{2} - \frac{1}{2} \cos(2x)) dx = \left.(\frac{x}{4} - \frac{\sin(2x)}{8})\right|_0^\pi$$

Plugging in endpoints, $M_x = (\frac{\pi}{4} - \frac{\sin(2\pi)}{8}) - (0 - \frac{\sin(0)}{8})$, or $M_x = \frac{\pi}{2}$.

Now we compute $M_y$:

$$\int_0^\pi x \sin(x) dx$$

We use [Integration by parts](lesson4.html#integration-by-parts) for this problem. Since $\sin(x)$ is easy to integrate, and the integral of $\sin(x)$ does not increase the complexity of the problem, we let:

* $u = x$
* $dv = \sin(x) dx$
* $du = dx$
* $v = -\cos(x)$

We compute the general antiderivative:

$$
\begin{align}
&-x\cos(x) - \int -(\cos(x)) dx \\
= &-x \cos(x) + \int \cos(x) dx
\end{align}
$$

Computing one more integral, our $M_y$ is $\left.(-x\cos(x) + \sin(x))\right\|_0^\pi$. Plug in the endpoints:

$$(-\pi \cos(\pi) + \sin(\pi)) - (-0\cos(0) + \sin(0))$$

Which is just $\pi$. To recap, we have:

* $m = 2$
* $M_x = \frac{\pi}{4}$
* $M_y - \pi$

So our center of mass $(\frac{M_y}{m}, \frac{M_x}{m})$ is ($\frac{\pi}{2}, \frac{\pi}{8})$. Here is the region with the center of mass plotted:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/3djgqeuywq?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

As an exercise, find the centers of mass of the following regions, assuming a uniform density:

1. The region bounded by $y = 4 - x^2$ and the $x$-axis, with $-2 \leq x \leq 2$.
2. The region bounded by $y = \cos(x)$ and the $x$-axis, with $0 \leq x \leq \frac{\pi}{2}$.

<details>
<summary>
Check your answers:
</summary>
<ol>
  <li>$(0, \frac{8}{5})$</li>
  <li>$(\frac{\pi}{2} - 1, \frac{\pi}{8})$</li>
</ol>
</details>

**Hand in**: Section 2.6 #273: Find the center of mass of the region bounded by $y = \cos(2x)$, the $x$-axis, $x = -\frac{\pi}{4}$, and $x = \frac{\pi}{4}$.

# Upcoming

Be sure to submit your problem presentation on VoiceThread by **Monday, February 13**.

There is also MyOpenMath homework due **Monday, February 20**. Try and do a little bit of each over the next few days, so that you don't have to worry about catching up on a lot of things by next week.

## Exam 1 Practice Problems

**Exam 1** is on Monday. 

Here are some topics and practice problems for each topic that you should look at.

* Interpreting areas under curves. This should be review from calculus, but you can look at [this activity from Spring 2021](https://atharaq.github.io/calc-2/lesson2.html#meaning-of-the-definite-integral) as an idea.
* (Substitution) Section 1.5 #271 - 280, 292 - 297
* (Exponential / Logarithmic functions) Section 1.6 #331 - 340
* (Inverse Trig) Section 1.7 #397 - 402, 411 - 413
* Chapter 1 Review Exercises #447 - 451
* (Integration by Parts) Section 3.1 #6 - 20, 38 - 45
* (Trig Integrals) Section 3.2 #73, 74, 79 - 86, 97 - 100, 103 - 108
* (Partial Fractions) Section 3.4 #182, 184, 196, 198, 202 - 204
* Chapter 3 Review #412, 415, 418, 419
* (Center of Mass) Section 2.6 #263 - 269, 273 - 276, 286
