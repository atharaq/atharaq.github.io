# Calculus 2 Lesson 1: Substitution
{:.no_toc}

1. Table of Contents
{:toc}

# HW Review

1. We saw in class that there are sequences of rational numbers whose limit is not rational. Is there a sequence of integers whose limit is not an integer? Explain why or why not.
2. Give an explanation, in English, of the meaning of a derivative of a function. (You may use graphs or pictures to supplement your explanation. Feel free to use [Desmos](https://www.desmos.com/) to make graphs if you need them.)
3. Give an explanation, in English, of the meaning of the definite integral of a function. (You may use graphs or pictures to supplement your explanation.)
4. Suppose f(x) is an odd function: that means, for every x, $f(-x) = -f(x)$. (For example, look at the [graph](https://www.desmos.com/calculator/cnledtgpoq) of $f(x) = \sin(x)$). Explain why, for any real number a, $\int\limits_{-a}^a f(x) dx = 0$. Again, you may use pictures/graphs to supplement your explanation.

# Integration by Substitution

Recall: **chain rule**

* Suppose $h(x) = f(g(x))$.
* Let $u = g(x)$. Then:
* $h^\prime(x) = f^\prime(g(x)) g^\prime(x)$.
* Or: $h^\prime(x) = f^\prime(u) u^\prime$.
* Or: $\frac{dh}{dx} = \frac{dh}{du} \frac{du}{dx}$

## Reverse Chain Rule

So let's do it in reverse!

<ul>
<li>$\int f^\prime(g(x)) g^\prime(x) dx$.</li>
<li class="fragment">Let $u = g(x)$.</li>
<li class="fragment">$\frac{du}{dx} = g^\prime(x)$.</li>
<li class="fragment">$\int f^\prime(u) \frac{du}{dx} dx$.</li>
<li class="fragment">$\int f^\prime(u) du = f(u) + C$.</li>
</ul>

## Example

Consider $\int 2x e^{x^2} dx$.

What would be an appropriate substitution?

* $u = x^2$
* $du = 2x dx$
* $\int e^u du = e^u + C = e^{x^2} + C$

For u: pick a term whose derivative will cancel out.

## Exercise

For the following exercises, make an appropriate u-substitution and compute the general antiderivative:

1. $\int (\sin(x))^2 \cos(x) dx$
2. $\int \sin(x) (\cos(x))^2 dx$
3. $\int \frac{\sin(x)}{\cos(x)} dx$
3. $\int \frac{\sin(x)}{(\cos(x))^2} dx$


<details>
<summary>Solutions</sumamry>
<ol>
<li>$\int (\sin(x))^2 \cos(x) dx = \frac{(\sin(x))^3}{3} + C$</li>
<li>$\int \sin(x) (\cos(x))^2 dx = -\frac{(\cos(x))^3}{3} + C$</li>
<li>$\int \frac{\sin(x)}{\cos(x)} dx = -\ln|\cos(x)| + C$, or $\ln|\sec(x)| + C$.</li>
<li>$\int \frac{\sin(x)}{(\cos(x))^2} dx = \sec(x) + C$.</li>
</ol>
</details>

## Definite Integrals

Two ways to use substitution for definite integrals:

1. Convert back to x. Ignore the bounds until the very end. Substitute as usual, integrate, and re-introduce the bounds at the end when you have found an antiderivative.
2. Update the bounds first.

## Method 1

Consider: $\int_0^1 x \sqrt{x^2 + 1} dx$.

$$
\begin{align}
u = x^2 + 1 \\
du = 2x dx \\
\int \frac{1}{2} \sqrt{u} du = \frac{u^{3/2}}{3} \\
= \frac{(x^2 + 1)^{3/2}}{3}
\end{align}
$$

Now bring back the bounds.

$$
\begin{align}
\int_0^1 x \sqrt{x^2 + 1} dx \\
= \left.\frac{(x^2 + 1)^{3/2}}{3}\right|_0^1 \\
= \frac{2 \sqrt{2}}{3} - \frac{1}{3}
\end{align}
$$

## Method 2: Update bounds

Same problem:

$$
\begin{align}
u = x^2 + 1 \\
u(0) = 0^2 + 1 = 1 \\
u(1) = 1^2 + 1 = 2 \\
\int_1^2 \frac{1}{2} \sqrt{u} du \\
= \left.\frac{u^{3/2}}{3} \right|_1^2 = \frac{2^{3/2}}{3} - \frac{1^{3/2}}{3}
\end{align}
$$

## Exercises

Use any method:

1. $\int_0^1 \frac{x}{x^2 + 1} dx$
2. $\int_{\pi/4}^{3\pi/4} (\sin(x))^2 \cos(x) dx$
3. $\int_0^2 xe^{-x^2}dx$

# MyOpenMath HW

Questions from the online homework? Recall that this homework is due **Thursday**, 1/26 at 11:59 PM.
