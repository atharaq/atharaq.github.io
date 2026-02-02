# Calculus II Lesson 3: Inverse Trig Functions, Integration by Parts
{: .no_toc}

1. Table of Contents
{:toc}

# Last time

* Exponential functions
* Logarithms
* Questions?

Exit ticket from last time: $\int_0^{\pi/4} \tan(x) dx$. What's the right $u$ in this case?

# Inverse Trig

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/5I_z6oYNrBA" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

$y = \arctan(x)$ means $\tan(y) = x$ and $-\pi/2 < y < \pi/2$. (This is literally the **definition** of $\arctan(x)$: it's the inverse of $y = \tan(x)$, which means we switch x and y, but we need to restrict the range since $\tan(x)$ is periodic.)

Taking the derivative, implicitly, we get that $1 = (\sec(y))^2 y^\prime$. Since $\sec(y)$ means $\dfrac{1}{\cos(y)}$, we can multiply both sides by $(\cos(y))^2$ and get $y^\prime = (\cos(y))^2$. This is where things get tricky. How do we plug back in $y = \arctan(x)$ into $(\cos(y))^2$ and simplify? Let's look at a triangle:

![x = tan(theta) picture](https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Trigonometric_functions_and_inverse2.svg/296px-Trigonometric_functions_and_inverse2.svg.png "x = tan(theta)")

Let's think about the relationship between the trig functions, inverse trig functions, and angles:

* Trig functions take *angles* as inputs, and output *ratios* (x / hypotenuse, y / hypotenuse, y / x, etc)
* Inverse trig functions take *ratios* as inputs, and output *angles*.

So if $y = \arctan(x)$, $y$ is the angle that we need to get $\tan(y) = x$ as our output. From the picture, if we want $\tan(\theta) = x$, we can draw a right triangle, with an angle $\theta$, whose opposite side is $x$ and adjacent side is $1$. Then the hypotenuse of the triangle (using the Pythagorean Theorem) is $\sqrt{x^2 + 1}$. In this case, we are looking for cosine of that angle, which would be $\dfrac{1}{\sqrt{x^2+1}}$. So:

$$y^\prime = (\cos(y))^2 = \left(\frac{1}{\sqrt{x^2+1}}\right)^2 = \frac{1}{x^2 + 1}$$

Now we have an **explicit** derivative of $\arctan(x)$!

The other inverse trig functions are listed in [Section 1.7](https://openstax.org/books/calculus-volume-2/pages/1-7-integrals-resulting-in-inverse-trigonometric-functions) of the textbook. I point these out not so that you necessarily memorize these formulas or even know how to come up with them  yourselves, just so that you know that if an integral has a particular form and substitution does not work, you can double check to see if it maches one of these forms.

# Integration by Parts

Recall that substitution can be thought of as the "Reverse chain rule". Now we will look at the reverse of the "product rule". Recall the product rule: $(fg)^\prime = f^\prime g + fg^\prime$.

So if we reverse this: $\int f^\prime(x)g(x) dx + \int f(x) g^\prime(x) dx = f(x) g(x) + C$

Let $u = f(x)$ and $v = g(x)$. Then $du = f^\prime(x) dx$ and $dv = g^\prime(x)dx$. If we substitute: $\int v du + \int u dv = uv$.

Simplifying, we get the **integration by parts formula**: $\int u dv = uv - \int v du$.

## Example

$\int x e^x dx$. Must pick $u$ and $dv$.

* Let $u = x$, $dv = e^x dx$.
* Then $du = dx$, $v = e^x$
* $uv - \int v du = xe^x - \int e^x dx$
* Or just $xe^x - e^x + C$

Q: What if we chose $u = e^x$, $dv = x dx$?

* $u = e^x$, $dv = x dx$
* $du = e^x dx$, $v = \frac{x^2}{2}$
* $uv - \int vdu = \frac{x^2}{2} e^x - \int \frac{x^2}{2} e^x dx$


Wait: this is **more complicated** than original problem! **Moral of the story**: pick $u$ and $v$ carefully!

# Guidance

Picking $u$ and $v$ takes some intuition. Here are some general tips:

* $u$ should be easy to differentiate.
* $du$ should be simpler than $u$
* $dv$ should be easy to integrate
* $v$ should not be much more complicated than $dv$

More explicitly, for $u$, we usually look for (in this order):

* logarithms ($\ln(x)^\prime = \frac{1}{x}$)
* inverse trig functions
* polynomials / algebraic functions

For $dv$:

* trig (sin / cos)
* exponential functions

Rule of thumb for $u$: "LIPET". Logs, Inverse trig, Polynomials, Exponentials, Trig. 

## Exercises

1. $\int x \ln(x) dx$
2. $\int \frac{\ln(x)}{x^2} dx$

<details>
<summary>Check your answers</summary>
<ol>
  <li>$\frac{x^2 \ln(x)}{2} - \frac{x^2}{4} + C$</li>
  <li>$-\frac{\ln(x)}{x} - \frac{1}{x} + C$</li>
</ol>
</details>

# Homework

**Due Monday, February 9** in class:

* Section 1.6 #324, 334, 346
* Section 1.7 #394, 398
