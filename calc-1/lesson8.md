# Calculus I Lesson 8: Trig Derivatives

# Derivatives of sine and cosine

First watch this video, where I go through the derivatives of $\sin(x)$ and $\cos(x)$:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/NWdc0-mUaWk" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**Summary**:

* $(\sin(x))^\prime = \cos(x)$
* $(\cos(x))^\prime = -\sin(x)$

**Exercises**: Find the derivatives of the following functions, using the product rule and the trig derivatives above:

1. $y = x^2 \sin(x)$
2. $y = \cos(x)\sin(x)$
3. $y = (\cos(x))^2$. Recall that this is $\cos(x)\cos(x)$.

<details>
<summary>Check your answers:</summary>
<ol>
<li>$2x\sin(x) + x^2 \cos(x)$</li>
<li>$-(\sin(x))^2 + (\cos(x))^2$, or $(\cos(x))^2 - (\sin(x))^2$</li>
<li>$-2\sin(x)\cos(x)$</li>
</ol>
</details>


## Higher derivatives of sin and cosine

Notice the following: let $y = \sin(x)$

* $y^\prime = \cos(x)$
* $y^{\prime\prime} = -\sin(x)$
* $y^{\prime\prime\prime} = -\cos(x)$
* $y^{(4)} = \sin(x)$
* $y^{(5)} = \cos(x)$
* $y^{(6)} = -\sin(x)$

etc.

**Exercises**:

1. What is the 100th derivative of $\sin(x)$?
2. What is the 101st derivative of $\sin(x)$?
3. Explain the pattern of the derivatives of sin and cosine as best as you can.
4. Have you seen any other patterns like this before?

Now take a look at the following video:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/v3CnJ2O7hVA" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Quotient Rule

Watch this video where I go over the quotient rule:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/MIRiVw-3VZk" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

To recap: if we have two functions $f(x)$ and $g(x)$, and we know that they are both differentiable (at some point $x = a$)j, we can figure out the derivative of $h(x) = \dfrac{f(x)}{g(x)}$, assuming that $g(x) \neq 0$ at that point. The **quotient rule** is:

$$(\dfrac{f(x)}{g(x)})^\prime = \dfrac{f^\prime(x) g(x) - g^\prime(x) f(x)}{(g(x))^2}$$

As an aside: the method we used to figure this out is called **implicit differentiation**. We will be revisiting this method often: if we have an equation with $x$ and $y$ in it, and we don't quite know the derivative of $y$ by itself, we sometimes can differentiate *implicitly*. This means that we leave a placeholder, $y^\prime$, for the derivative.

In this example, if $y = \dfrac{f(x)}{g(x)}$, we don't know $y^\prime$. But, if we multiply both sides by $g(x)$, we know that $(y\cdot g(x))^\prime = f^\prime(x)$. Then we can use the product rule on the left hand side:

$$y^\prime g(x) + g^\prime(x) y = f^\prime(x)$$

We want to get $y^\prime$ by itself. So subtract $g^\prime(x) y$:

$$y^\prime g(x) = f^\prime(x) - g^\prime(x)y$$

Now divide both sides by $g(x)$:

$$y^\prime = \dfrac{f^\prime(x)}{g(x)} - \dfrac{g^\prime(x) y}{g(x)}$$

Replace $y$ by $\dfrac{f(x)}{g(x)}$:

$$y^\prime = \dfrac{f^\prime(x)}{g(x)} - \dfrac{g^\prime(x) f(x)}{(g(x))^2}$$

And now get a common denominator to finish the problem:

$$y^\prime = \dfrac{f^\prime(x) g(x) - g^\prime(x) f(x)}{(g(x))^2}$$

**Exercises**:

1. Find the derivative of $\tan(x) = \dfrac{\sin(x)}{\cos(x)}$.
2. Find the derivative of $\sec(x) = \dfrac{1}{\cos(x)}$.
