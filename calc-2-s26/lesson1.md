# Calculus 2 Lesson 1: Substitution
{:.no_toc}

1. Table of Contents
{:toc}

# Integration by Substitution

The notes below are a **very brief review**. If you have never encountered integration by substitution before, you may wish to look at the following:

* [Fall 2022, Calculus 1, Lesson 22](https://atharaq.github.io/calc-1-f22/lesson22.html#integration-by-substitution)
* [Fall 2022, Calculus 1, Lesson 23](https://atharaq.github.io/calc-1-f22/lesson23.html)

Those notes come with embedded videos where I go over some problems and provide more depth in my explanations. There are also lots of videos on YouTube that go over this technique. Here are some examples:

1. [Khan Academy](https://www.youtube.com/watch?v=b76wePnIBdU)
2. [Khan Academy Example 2](https://www.youtube.com/watch?v=oqCfqIcbE10)
3. [PatrickJMT](https://www.youtube.com/watch?v=qclrs-1rpKI)
4. [PatrickJMT more complicated examples](https://www.youtube.com/watch?v=x06V9xuLdqg)

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
<summary>Solutions</summary>
<ol>
<li>$\int (\sin(x))^2 \cos(x) dx = \frac{(\sin(x))^3}{3} + C$</li>
<li>$\int \sin(x) (\cos(x))^2 dx = -\frac{(\cos(x))^3}{3} + C$</li>
<li>$\int \frac{\sin(x)}{\cos(x)} dx = -\ln|\cos(x)| + C$, or $\ln|\sec(x)| + C$.</li>
<li>$\int \frac{\sin(x)}{(\cos(x))^2} dx = \sec(x) + C$.</li>
</ol>
</details>

## Definite Integrals

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/_O96A6NiNYQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

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

# Classwork

For this lesson, please do the following problems: Section 1.5: 254, 262-270, 272, 276.

**Hand in** on Thursday: 254, 272.

# Homeworks

1. Reminder that there is a homework on BrightSpace which is due Monday, 1/26.
2. The MyOpenMath homework is due **Friday**, 1/30 at 11:59 PM.

