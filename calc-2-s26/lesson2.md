# Calculus II Lesson 2: Exponential and Logarithmic Functions
{: .no_toc}

1. Table of Contents
{:toc}

# Lesson 1 questions?

* Hand in 1.5 254, 272
* Questions on Integration by substitution?

# Integration by Substitution

Recall: integration by substitution is a technique whereby we try to simplify an integral problem by making an appropriate substitution. For example:

$$ \int x^2 e^{x^3} dx $$

This can be simplified by letting $u = x^3$. Then $\frac{du}{dx} = 3x^2$, or, treating $\frac{du}{dx}$ as a fraction, we have $du = 3x^2 dx$. Then notice that $e^{x^3}$ can be replaced by $e^u$, and $x^2 dx$ can be replaced by $\frac{du}{3}$, so our simplified integral is:

$$ \frac{1}{3} \int e^u du $$

This is simply $e^u + C$, or $e^{x^3} + C$. Some things to notice about this problem:

* After substituting, we want to obtain an expression only consisting of $u$ and $du$'s, with no more $x$'s.
* Pick a term whose derivative shows up in the problem. If the derivative does not show up, at least look for something where a constant multiple of the derivative shows up.
* At the end, substitute back to get your final answer in terms of $x$.

It takes practice to develop the right intuition for these kinds of problems. I encourage you to work through the exercises in [section 1.5](https://openstax.org/books/calculus-volume-2/pages/1-5-substitution) to get that practice. Try 3-5 from each of the following groups of problems:

* 261-270
* 271-287
* 271-287

# Definite Integrals with Substitution

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/_O96A6NiNYQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## Method 1: Convert back to $x$

Let's use this technique to help compute $\int\limits_0^2 x^2 \sqrt{x^3 + 1} dx$. Let $u = x^3 + 1$, and $du = 3x^2 dx$. There are two ways to proceed here, and either method is valid. The first method:

* Turn this into an indefinite integral: $\frac{1}{3} \int \sqrt{u} du$.
* Integrate: $\frac{1}{3} \int u^{1/2} du = \frac{2}{9} u^{3/2}$. (We can ignore the constant since we will be doing a definite integral).
    * **We cannot plug in here**! We now have an antiderivative in terms of $u$, and our bounds are in terms of $x$. So we first need to convert our antiderivative to be in terms of $x$.
* Turn this back into $x$'s: $\frac{2}{9} (x^3 + 1)^{3/2}$
* Then plug in the upper and lower bounds:
    * $x = 2$: $\frac{2}{9}(2^3 + 1)^{3/2} = \frac{2}{9} (\sqrt{9})^3 = \frac{54}{9}$
    * $x = 0$: $\frac{2}{9}(0^3 + 1)^{3/2} = \frac{2}{9}$
    * Subtract: $\frac{54}{9} - \frac{2}{9} = \frac{52}{9}$

This method works fine, and is fairly simple to use. Just be sure not to forget about the upper and lower bounds at the end. To remind myself, I often keep in the bounds, but identify them as bounds in terms of $x$, and not $u$. For example: $\frac{1}{3}\int\limits_{x=0}^{x=2} \sqrt{u} du$, so that I know not to plug in the $x$ values into the $u$ variable.

## Method 2: Update the bounds / keep $u$

This next method works just as well: here we change the bounds of integration to be in terms of the $u$ variable. Let's look at the following problem:

$$\int_{\pi/4}^{\pi/2} \frac{\cos(x)}{(\sin(x))^2} dx$$

Let $u = \sin(x)$, and $du = \cos(x) dx$. Then update the bounds:

* $x = \pi/4$ means $u = \sin(\pi/4) = \sqrt{2}/2$
* $x = \pi/2$ means $u = \sin(\pi/2) = 1$

So now our integral looks like:

$$\int_{\sqrt{2}/2}^1 \frac{1}{u^2} du$$

Use the reverse power rule here and we get $\left.-u^{-1}\right\|_{\sqrt{2}/2}^1$, which is $-1 + \sqrt{2}$, or $\sqrt{2} - 1$. Notice, for this method, we **never** switch back to $x$!

Either method is fine. Sometimes, one method works better than the other, and so it's good to have both methods at your disposal. Just be sure not to mix them up: don't update the bounds and then also convert everything back to $x$.

**Exercises**: Find the following definite integrals, using any method.

1. $\int\limits_{-1}^1 x \sqrt{x^2 + 1} dx$
2. $\int\limits_0^{\pi} (\cos(x))^2 \sin(x) dx$
3. $\int\limits_0^1 x e^{x^2} dx$

<details>
  <summary>Check your answers.</summary>

  <ol>
  <li>Let $u = x^2 + 1$ and $du = 2x dx$. Then when we update the bounds, if $x = 1$ then $u = 2$, and if $x = -1$, then $u = 2$. The integral becomes $\int\limits_2^2 \frac{1}{2} \sqrt{u} du = 0$.</li>
  <li> Let $u = \cos(x)$, $du = -\sin(x) dx$. Let's use method one here: the integral becomes $\int -u^2 du$. An antiderivative of $-u^2$ is $-\frac{u^3}{3}$. Substitute back in: $-\frac{(\cos(x))^3}{3}$, from $x = 0$ to $x = \pi$. So we get: $-\frac{(-1)^3}{3} - (-\frac{1^3}{3})$, which is $\frac{2}{3}$.</li>
  <li>Let $u = x^2$, $du = 2x dx$, or $\frac{1}{2} du = x dx$. We can update the bounds: if $x = 1$ then $u = 1$, and if $x = 0$ then $u = 0$, so actually our bounds don't even change! The integral becomes $\frac{1}{2} \int\limits_0^1 e^u du$, which is $\left.\frac{1}{2} e^u \right|_0^1$. Plugging in the endpoints, we get $\frac{1}{2} e - \frac{1}{2}$.</li>
  </ol>
</details>

On your own, try 2-3 problems for each of the following sets of questions from [Section 1.5](https://openstax.org/books/calculus-volume-2/pages/1-5-substitution):

* 292-297
* 306-312

# Exponential Functions

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/bFZqQ3oqgoE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

Recall that $\frac{d}{dx} e^x = e^x$. This means that $\int e^x dx = e^x + C$. We have done a few problems involving exponential functions already, let's try a couple more:

**Exercises**:

1. $\int\limits_0^{\ln(2)} e^{-x} dx$
2. $\int x e^{-x^2} dx$

<details>
<summary>Check your answers</summary>
<ol>
<li>An antiderivative of $e^{-x}$ is $-e^{-x}$, and so plugging in, we get $-e^{-\ln(2)} = -\frac{1}{2}$, and $-e^{-0} = -1$, and so our answer is $-\frac{1}{2} - (-1) = \frac{1}{2}$.</li>
<li> Let $u = -x^2$, and so $du = -2x dx$. Or: $-\frac{1}{2} du = x dx$. The integral simplifes to $-\frac{1}{2} \int e^u du = -\frac{1}{2} e^u + C$. Substitute back: $-\frac{1}{2} e^{-x^2} + c$.</li>
</ol>
</details>

Interesting note: the function $f(x) = e^{-x^2}$ does not have an elementary antiderivative. In other words, $\int e^{-x^2}dx$ is not possible to compute, while $\int x e^{-x^2} dx$ is solvable using a simple substitution. Changing a function very slightly can cause a problem to go from being easy (or at least doable) to impossible!

Moreover, this is not just an academic concern! The function $f(x) = \frac{e^{-\frac{1}{2}x^2}}{\sqrt{2\pi}}$ is known in statistics as the "Gaussian curve" or the "normal distribution". Areas between points on this curve correspond to probabilities that events occur within a certain number of standard deviations of the mean of a normal distribution. If you haven't studied statistics, we won't be studying it here, but I just wanted to point out that this curve is extremely important in understanding distributions of data.

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/dlswvridnz?embed" width="500px" height="500px" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

## Bases other than $e$

What do we do with integrals of exponential functions whose bases are constants other than $e$? We use $e$ and $\ln$ to re-write those functions.

Recall that $\ln(x)$ is the inverse of $e^x$. That means: if $y = \ln(x)$, then $e^y = x$. In other words, $e^{\ln(x)} = x$. So, for example, $e^{\ln(2)} = 2$. We can use this to re-write the function $2^x$:

Since $2 = e^{\ln(2)}$, then $2^x = {e^{\ln(2)}}^x$. Using exponent rules, we get $2^x = e^{\ln(2) \cdot x}$. Therefore:

$$\int 2^x dx = \int e^{\ln(2) \cdot x} dx = \frac{1}{\ln(2)} e^{\ln(2) \cdot x} + C= \frac{2^x}{\ln(2)} + C$$

**Exercise**: Use the same logic to find the following antiderivatives:

1. $\int 10^x dx$
2. $\int (\frac{1}{2})^x dx$
3. $\int 3^x dx$

Do you see the general pattern?

# Implicit Differentiation

We will now turn to integrals that result in logarithms and inverse trig functions. These functions are all *inverse* functions, and so we should first review how to find the derivatives of inverse functions. We do so using a technique, from Calc 1, known as **implicit differentiation**.

You may wish to first review the topic from the Calculus 1 textbook: [Section 3.8: Implicit Differentiation](https://openstax.org/books/calculus-volume-1/pages/3-8-implicit-differentiation).

# Logarithms

A **logarithm** is the inverse of an exponential function. That is, if $y = b^x$, then $x = \log_b(y)$, and vice versa: if we are trying to graph $y = \log_b(x)$ for some base $b$, we really should think of this as looking for $(x, y)$ values where $b^y = x$.

That is: $\log_b(x)$ and $b^x$ are inverses. If a point $(x, y)$ is on the graph of one of these functions, then switching $x$ and $y$, we get a point on the other graph. For example, if $y = 2^x$, we know that $(3, 8)$ is on the graph of this function. That means $(8, 3)$ is on the graph of $y = \log_2(x)$. That is: $\log_2(8) = 3$.

The **natural logarithm** function is $f(x) = \log_e(x)$. It is used so often that it has a special name: $\ln(x)$ means $\log_e(x)$. Again, the same general rule applies: $y = \ln(x)$ means $e^y = x$.

To find the derivative of $y = \ln(x)$, it is easier to reason **implicitly** using the equation $e^y = x$. Take the derivative of both sides with respect to $x$, and we get $e^y y^\prime = 1$. Then solve for $y^\prime$ and get $y^\prime = \dfrac{1}{e^y}$. Remember, though, that we used the equation $e^y = x$, so that means we can substitute $x$ in for $e^y$: that is, $y^\prime = \dfrac{1}{x}$!

This is covered in the excellent 3Blue1Brown video on Implicit Differentiation. Take a look at that one here, as it may help refresh your memory on this topic.

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/qb40J4N1fa4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

**Exercise**: Knowing that $\tan(x) = \frac{\sin(x)}{\cos(x)}$, can you find an antiderivative $\int \tan(x) dx$? Hint: use substitution. The natural log will show up here!

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/VLBmboGRazQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

**Exercises**: Compute the following:

1. $\int\limits_0^1 \frac{2}{x+1} dx$
2. $\int \cot(x) dx$. Recall that $\cot(x) = \frac{\cos(x)}{\sin(x)}$
3. $\int \frac{x}{x^2+1} dx$

<details>
<summary>Check your answers</summary>
<ol>
<li>$2 \ln(2)$</li>
<li>$\ln|\sin(x)| + C$</li>
<li>$\frac{1}{2}\ln(x^2+1) + C$. Note that absolute values are not needed here as $x^2 + 1$ is always positive.</li>
</ol>
</details>

**Classwork to hand in**: 1.6 #356.

# Preview

## Trig Functions

Recall the derivatives of trig functions:

* $\frac{d}{dx} \sin(x) = \cos(x)$
* $\frac{d}{dx} \cos(x) = -\sin(x)$
* $\frac{d}{dx} \tan(x) = (\sec(x))^2$
* $\frac{d}{dx} \sec(x) = \sec(x)\tan(x)$

These can all be found in [Appendix B](https://openstax.org/books/calculus-volume-2/pages/b-table-of-derivatives) of our textbook.

For antiderivatives, we can reverse these:

* $\int \cos(x) dx = \sin(x) + C$
* $\int \sin(x) dx = -\cos(x) + C$

We should at least know those two. Many others can be found by knowing those two and using substitution and/or other integration techniques that we will study later this semester.

## Inverse Trigonometric Functions

Knowing the derivatives of inverse trig functions can help us know certain antiderivatives. This is tricky: the derivatives of inverse trig functions look *nothing* like inverse trig functions!

Tricky does not mean "impossible", however. We can find them using implicit differentiation. Let's do one example: the derivative of $\arctan(x)$.

$y = \arctan(x)$ means $\tan(y) = x$ and $-\pi/2 < y < \pi/2$. (This is literally the **definition** of $\arctan(x)$: it's the inverse of $y = \tan(x)$, which means we switch x and y, but we need to restrict the range since $\tan(x)$ is periodic.)

So to find $y^\prime$, we can use implicit differentiation on $\tan(y) = x$. That is: take the derivative of both sides and use the chain rule:

$$
\begin{align}
(\tan(y))^\prime = x^\prime \\
(\sec(y))^2 y^\prime = 1 \\
y^\prime = (\cos(y))^2
\end{align}
$$

Now, to get things back in terms of $x$, we draw a picture:

![x = tan(theta) picture](https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Trigonometric_functions_and_inverse2.svg/296px-Trigonometric_functions_and_inverse2.svg.png "x = tan(theta)")

Since $\tan(y) = x$, $y$ is the angle $\theta$ in that picture, and so $\cos(y)$ is $\frac{1}{\sqrt{1+x^2}}$. Therefore $(\cos(y))^2 = \frac{1}{1 + x^2}$.

All of this means that $\frac{d}{dx} \arctan(x) = \frac{1}{1 + x^2}$. Therefore, $\int \frac{1}{1+x^2} dx = \arctan(x) + C$.

What about $\int \frac{1}{9 + x^2}dx$? In this case, we need to factor out $\frac{1}{9}$:

$$
\begin{align}
\frac{1}{9}\int \frac{1}{1 + \frac{x^2}{9}} dx$ \\
= \frac{1}{9} \int \frac{1}{1 + (\frac{x}{3})^2} dx
\end{align}
$$

Let $u = \frac{x}{3}$, so $du = \frac{1}{3} dx$, or $dx = 3 du$, and continue:

$$
\begin{align}
\frac{1}{9} \int \frac{3}{1 + u^2} du \\
= \frac{1}{3} \int \frac{1}{1 + u^2} du \\
= \frac{1}{3} \arctan(u) + C \\
= \frac{1}{3} \arctan(\frac{x}{3}) + C
\end{align}
$$

In general: $\int \frac{1}{a^2 + u^2} du = \frac{1}{a} \arctan(\frac{u}{a}) + C$, for any constant real number $a$.

The other inverse trig functions are listed in [Section 1.7](https://openstax.org/books/calculus-volume-2/pages/1-7-integrals-resulting-in-inverse-trigonometric-functions) of the textbook. I point these out not so that you necessarily memorize these formulas or even know how to come up with them  yourselves, just so that you know that if an integral has a particular form and substitution does not work, you can double check to see if it maches one of these forms.

# MyOpenMath HW

There is also a homework on MyOpenMath due next **Friday, 2/6** at 11:59 PM. Get started on the ones you can do now. Some of these problems we can go over next week in class and/or in office hours.
