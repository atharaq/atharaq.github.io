# Calculus II Lesson 7: Improper Integrals
{: .no_toc}

1. Table of Contents
{:toc}

# Warm up

Let's finish the problem from last time:

Find the center of mass of the region bounded by $y = \cos(2x)$, the $x$-axis, $x = -\frac{\pi}{4}$, and $x = \frac{\pi}{4}$. Last time you should have been able to find $m$ and $M_y$, now find $M_x$, and the $(x, y)$ coordinates of the center of mass.

# Reminders

* Exam 1 due **Friday**.
* Submit via Moodle.
  * Single PDF file: use CamScanner, Scannable, MS Office Lens, Adobe Scan, etc.
  * Show **all** your work.
* Come on Thursday prepared with questions!

# Improper Integrals

How do we evaluate integrals where one bound goes off to infinity?

1. $\int\limits_a^{\infty} f(x) dx = \lim\limits_{b \rightarrow \infty} \int\limits_a^b f(x) dx$, if this limit exists.
2. $\int\limits_{-\infty}^{b} f(x) dx = \lim\limits_{a \rightarrow -\infty} \int\limits_a^b f(x) dx$, if this limit exists.

**Definitions**:

1. $\int\limits_a^{\infty} f(x) dx = \lim\limits_{b \rightarrow \infty} \int\limits_a^b f(x) dx$, if this limit exists.
2. $\int\limits_{-\infty}^{b} f(x) dx = \lim\limits_{a \rightarrow -\infty} \int\limits_a^b f(x) dx$, if this limit exists.

If the limit exists, we say it **converges**. If not, we say it **diverges**.

**Exercise**

Compute the following definite integrals by taking the appropriate limit.

1. $\int\limits_0^{\infty} xe^{-x^2} dx$
2. $\int\limits_0^{\infty} e^{-x} dx$

## Divergence

How would we find $\int_0^{\infty} (e^{-x} + 1) dx$ **without computing**?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/o0plfqccr8?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

What do you notice about this region?

**Question**: If $\lim\limits_{x \rightarrow \infty} f(x) \neq 0$, then can $\int\limits_0^{\infty} f(x)dx$ converge? Why or why not?

## Example

Compute the following improper integral: $$\int_0^{\infty} \frac{1}{x} dx$$

Since $\frac{1}{x} \rightarrow 0$, must this integral converge?

## Limits at infinity / Divergence

* If the limit of a function at infinity is not 0, then the improper integral *must* diverge.
* If limit is 0, then we do not know about the improper integral! The integral can diverge even if the limit at infinity is 0.

## Exercise

1. $\int_1^{\infty} \frac{1}{x^2} dx$
2. Does $\int\limits_0^{\infty} e^{-x^2} dx$ converge or diverge?

Hint on (2): *compare* $e^{-x^2}$ with $e^{-x}$, which we already know converges.

# Discontinuities

$\int_0^4 \frac{1}{\sqrt{4-x}} dx$? Ideas?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/jb6kzjrwon?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

**Solution**: Set up a limit:

$$\lim\limits_{b \rightarrow 4^-} \int\limits_0^b \frac{1}{\sqrt{4-x}}dx$$

Re-write the function as $(4-x)^{-\frac{1}{2}}$, and use the power rule: $$\lim\limits_{b \rightarrow 4^-} \left. -2(4-x)^{\frac{1}{2}}\right|_0^b = \lim\limits_{b\rightarrow 4^-} -2(4-b)^{1/2} + 2(4)^{1/2}$$

Continuing: $$\lim\limits_{b\rightarrow 4^-} -2(4-b)^{1/2} + 2(4)^{1/2} = \lim\limits_{b\rightarrow 4^-} -2(4-b)^{1/2} + 4$$

As $b \rightarrow 4^{-}$, what happens to $(4-b)^{1/2}$? It approaches 0! So the limit is just **4**!

**Question**: why is it important here that we approached 4 from the left?

**Exercise**:

$$\int_0^2 x \ln(x) dx$$

(Where is the discontinuity here?)

## Middle of Interval

$\int_{-1}^1 \frac{1}{x^2} dx$. Ideas?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/kzgng8xu4u?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

**Idea**: Split into 2 integrals.

$\int_{-1}^0 \frac{1}{x^2} dx + \int_0^1 \frac{1}{x^2} dx$

$$
\begin{align}
&\lim_{b\rightarrow 0^-} \int_{-1}^b \frac{1}{x^2} dx &+ \lim_{a \rightarrow 0^+} \int \frac{1}{x^2} dx \\
&= \lim_{b\rightarrow 0^-} \left. (-\frac{1}{x}) \right|_{-1}^b &+ \lim_{a \rightarrow 0^+} \left.(-\frac{1}{x})\right|_a^1 \\
&= \ldots &+ \lim_{a \rightarrow 0^+} -1 + \frac{1}{a}
\end{align}
$$

which diverges. (The other side diverges too.)

## Multiple?

What should we do if we have multiple discontinuities?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/byb625k9x5?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

# Areas between curves

Determine the area of the region bounded by the curves $y = x$ and $y = x^2$.

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/c1dvtpxv0a?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Ideas? First: Where do these curves intersect? What are the endpoints of the region?

$$
\begin{align}
x &= x^2 \\
x - x^2 &= 0 \\
x(1 - x) &= 0 \\
x = 0 \text{ or } x &= 1
\end{align}
$$

What's the area under just one of those curves?

$$\int_0^1 x dx = \left.\frac{x^2}{2}\right|_0^1 = \frac{1}{2}$$

$$\int_0^1 x^2 dx = \left.\frac{x^3}{3}\right|_0^1 = \frac{1}{3}$$

Then just subtract those areas! $A = \frac{1}{2} - \frac{1}{3} = \frac{1}{6}$.

Or: take the integral of the difference!

$$\int_0^1 (x - x^2) dx = \left.\frac{x^2}{2}-\frac{x^3}{3}\right|_0^1 - \frac{1}{6}$$

**Question**: Why $x - x^2$ and not $x^2 - x$?

## Strategy

1. Determine where they intersect
2. Determine which function is greater in this region
3. Set up the integral $\int_a^b \|f(x) - g(x)\| dx$.

(Use (2) to determine whether the integral is of $f(x) - g(x)$ or $g(x) - f(x)$.)

## Exercises

1. Find the area between $f(x) = x$ and $g(x) = x^3$ in the first quadrant.
2. Find the area between $f(x) = \sin(x)$ and $g(x) = \cos(x)$ between $x = \pi/4$ and $x = 5\pi/4$.
