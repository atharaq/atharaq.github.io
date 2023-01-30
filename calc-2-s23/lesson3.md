# Calculus II Lesson 3: Logarithmic Functions and Inverse Trig Functions
{: .no_toc}

1. Table of Contents
{:toc}

# Implicit Differentiation

During this lesson, you will learn integrals that result in logarithms and inverse trig functions. These functions are all *inverse* functions, and so we should first review how to find the derivatives of inverse functions. We do so using a technique, from Calc 1, known as **implicit differentiation**.

You may wish to first review the topic from the Calculus 1 textbook: [Section 3.8: Implicit Differentiation](https://openstax.org/books/calculus-volume-1/pages/3-8-implicit-differentiation).

# Logarithms

A **logarithm** is the inverse of an exponential function. That is, if $y = b^x$, then $x = \log_b(y)$, and vice versa: if we are trying to graph $y = \log_b(x)$ for some base $b$, we really should think of this as looking for $(x, y)$ values where $b^y = x$.

That is: $\log_b(x)$ and $b^x$ are inverses. If a point $(x, y)$ is on the graph of one of these functions, then switching $x$ and $y$, we get a point on the other graph. For example, if $y = 2^x$, we know that $(3, 8)$ is on the graph of this function. That means $(8, 3)$ is on the graph of $y = \log_2(x)$. That is: $\log_2(8) = 3$.

The **natural logarithm** function is $f(x) = \log_e(x)$. It is used so often that it has a special name: $\ln(x)$ means $\log_e(x)$. Again, the same general rule applies: $y = \ln(x)$ means $e^y = x$.

To find the derivative of $y = \ln(x)$, it is easier to reason **implicitly** using the equation $e^y = x$. Take the derivative of both sides with respect to $x$, and we get $e^y y^\prime = 1$. Then solve for $y^\prime$ and get $y^\prime = \dfrac{1}{e^y}$. Remember, though, that we used the equation $e^y = x$, so that means we can substitute $x$ in for $e^y$: that is, $y^\prime = \dfrac{1}{x}$!

This is covered in the excellent 3Blue1Brown video on Implicit Differentiation. Take a look at that one here, as it may help refresh your memory on this topic.

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/qb40J4N1fa4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**Exercise**: Knowing that $\tan(x) = \frac{\sin(x)}{\cos(x)}$, can you find an antiderivative $\int \tan(x) dx$? Hint: use substitution. The natural log will show up here!

# Inverse Trig

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/5I_z6oYNrBA" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
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

**On your own**: read through [Section 1.7](https://openstax.org/books/calculus-volume-2/pages/1-7-integrals-resulting-in-inverse-trigonometric-functions) of our textbook, to see the rules for integrals resulting in arctan, arcisn, and arcsec.

# Homework

**Due Monday, February 6** in class:

* Section 1.6 #324, 334, 346, 356
* Section 1.7 #394, 398
