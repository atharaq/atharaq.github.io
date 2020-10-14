# Calculus I Lesson 10: Exponential Functions
{:.no_toc}

Table of Contents
1. {:.toc}

# Review of Chain Rule

Recall the chain rule: if $h(x) = f(g(x))$, then $h^\prime(x) = f^\prime(g(x)) g^\prime(x)$.

Sometimes, this rule is thought of as a "substitution" rule. Let $y = f(g(x))$ and $u = g(x)$. Then we can think of $y$ as a function of $u$, as $y = f(u)$, or we can think of $y$ as a function of $x$, as $f(g(x)$. The chain rule relates the derivative of $y$ with respect to $u$, and the derivative of $y$ with respect to $x$:

$$\frac{dy}{dx} = \frac{dy}{du} \cdot \frac{du}{dx}$$

The biggest challenge for using the chain rule is decomposing complicated functions into simpler functions that we "plug in" to each other. The textbook gives some good exercises on this: [Section 3.6, #220-227](https://openstax.org/books/calculus-volume-1/pages/3-6-the-chain-rule). Let's go through a couple of these:

**221**: $y = (3x^2 + 1)^3$. The "inside" function is $3x^2 + 1$, so let $u = 3x^2 + 1$. Then we substitute and $y = u^3$. So:

$$\frac{dy}{dx} = 3u^2 (\frac{du}{dx}) = 3(3x^2+1)^2 (6x)$$

Or simplifying a little bit: $18x(3x^2+1)^2$.

**222**: $y = \sin^5(x)$. I usually would write this as $y = (\sin(x))^5$. So let $u = \sin(x)$ and $y = u^5$. Then $y^\prime = 5u^4 u^\prime$, or $5(\sin(x))^4 \cos(x)$.

On your own: go through the rest of the exercises 220 to 227. Post on Piazza if you get stuck on any of these!

# Implicit Differentiation

An important application of the Chain Rule is called "implicit differentiation". Let's go through a quick example, and then you can take a look at the video on Khan Academy afterward.

Consider the following graph of the *hyperbola* $xy = 1$:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/7u8mylkvyb?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

How might we find the equation of the tangent line at $x = 1$? The obvious way would be to solve for $y$ and then find the derivative of $\dfrac{1}{x}$. But we can also differentiate *implicitly*, meaning "take the derivative of an expression containing $y$". That is, we can take the derivative of both sides of the equation $xy = 1$, and then use that to figure out what the derivative is when $x = 1$.

The derivative of $(xy)$ is, using the product rule, $x^\prime y + y^\prime x$. Since we know that the derivative of $x$ is $1$, this simplifies to $y + y^\prime x$. The derivative of $1$ is $0$, since that's a constant. So if we take the derivative of both sides, we get:

$$y + y^\prime x = 0$$

We can then solve for $y^\prime$ using algebra: subtract $y$ from both sides and then divide by $x$ to get $y^\prime = -\dfrac{y}{x}$.

In the original equation $xy = 1$, when $x = 1$, we can solve for $y$ and get $y = 1$ also. So we are looking for the equation of the line tangent to $xy = 1$ at the point $(1, 1)$. Plug in $x = 1$ and $y = 1$ to $y^\prime = -\dfrac{y}{x}$ and we get $y^\prime = -1$.

So our tangent line would have the equation $y - 1 = (-1)(x - 1)$, in point-slope form.

Take a look at this video from Khan Academy and look at how to find the derivatives of graphs of a circle.

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/mSVrqKZDRF4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## Exercises

Take a look at the exercises 300-309 from [Section 3.8](https://openstax.org/books/calculus-volume-1/pages/3-8-implicit-differentiation).

## Derivative of $y = \frac{1}{x}$

Earlier we used implicit differentiation to find equations of tangent lines to the graph of $xy = 1$. But we can use the same technique to find the (explicit) derivative of $y = \dfrac{1}{x}$. First, multiply by $x$ on both sides and then use implicit differentiation as before: $xy = 1$ means that $y + y^\prime x = 0$. Now solve for $y^\prime$, as we did before: $y^\prime = -\dfrac{y}{x}$.

This is what we got before, but is still an *implicit* equation. Instead, we can get an *explicit* equation, by substituting back in for $y$: since $y = \dfrac{1}{x}$, we get:

$$y^\prime = -\frac{\frac{1}{x}}{x} = -\frac{1}{x^2}$$

We did a very similar thing earlier when we learned the quotient rule. Instead of taking the derivative of $y = \frac{f(x)}{g(x)}$, we took the derivative of $g(x)y = f(x)$ using the product rule, and then simplified and solved for $y^\prime$.

We will often use this method to help us find the derivative of **inverse** functions: if we have a function $y = f(x)$ and we know the derivative of $f(x)$, how might we find the derivative of its inverse $f^{-1}$? We use the fact that $y = f^{-1}(x)$ means the same thing as $x = f(y)$, and then differentiate implicitly.

## Derivative of arctan

Here is an example of finding the derivative of an inverse function. $y = \arctan(x)$ means $x = \tan(y)$. Taking the derivative, implicitly, we get that $1 = (\sec(y))^2 y^\prime$. Since $\sec(y)$ means $\dfrac{1}{\cos(y)}$, we can multiply both sides by $(\cos(y))^2$ and get $y^\prime = (\cos(y))^2$. This is where things get tricky. How do we plug back in $y = \arctan(x)$ into $(\cos(y))^2$ and simplify? Let's look at a triangle:

![x = tan(theta) picture](https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Trigonometric_functions_and_inverse2.svg/296px-Trigonometric_functions_and_inverse2.svg.png "x = tan(theta)") \

Let's think about the relationship between the trig functions, inverse trig functions, and angles:

* Trig functions take *angles* as inputs, and output *ratios* (x / hypotenuse, y / hypotenuse, y / x, etc)
* Inverse trig functions take *ratios* as inputs, and output *angles*.

So if $y = \arctan(x)$, $y$ is the angle that we need to get $\tan(y) = x$ as our output. From the picture, if we want $\tan(\theta) = x$, we can draw a right triangle, with an angle $\theta$, whose opposite side is $x$ and adjacent side is $1$. Then the hypotenuse of the triangle (using the Pythagorean Theorem) is $\sqrt{x^2 + 1}$. In this case, we are looking for cosine of that angle, which would be $\dfrac{1}{\sqrt{x^2+1}}$. So:

$$y^\prime = (\cos(y))^2 = (\frac{1}{\sqrt{x^2+1}})^2 = \frac{1}{x^2 + 1}$$

Now we have an **explicit** derivative of $\tan(x)$!

# Review of Exponential Functions

## Exponents?

## What does

## Growth
