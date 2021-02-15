# Calculus II Lesson 4: Integration by Parts and Trigonometric Integrals
{: .no_toc}

1. Table of Contents
{:toc}

# Quiz

Before starting today's lesson, please make sure to note that there is a **quiz** on MyOpenMath today. The quiz must be done by **Thrusday, February 18** at 11:59 PM, but please work on it earlier than that. This quiz is based on the lessons from the first two weeks of class.

For quizzes, I allow students to correct any work they got wrong. We can discuss this on Thursday.

# Review of Integration by Parts

Recall the integration by parts formula:

$$\int u dv = uv - \int v du$$

The challenge for integration by parts questions is often to choose $u$ and $dv$ correctly. Remember the general rules:

* $u$ should be easy to differentiate
* $du$ should be simpler than $u$
* $dv$ should be easy to integrate
* $v$ should not be much more complicated than $dv$

For $u$, prefer $\ln$, inverse trig functions, and polynomials / algebraic functions (in that order). For $dv$, generally prefer trig functions and exponential functions.

**Example**: Find the general antiderivative: $\int x \cos(x) dx$. Following our rules above, we set $u = x$ and $dv = \cos(x) dx$. Then:

* $du = dx$
* $v = \sin(x)$

Then plug into the formula: $uv - \int v du = x \sin(x) - \int \sin(x) dx$. Then computing one more integral, the general antiderivative is $x \sin(x) + \cos(x) + C$.

## Multiple Steps

It's possible that one needs to integrate by parts multiple times. For example, what if the previous problem were changed to $\int x^2 \cos(x) dx$? Then we would set $u = x^2$, $dv = \cos(x) dx$, and end up with $x^2 \sin(x) - \int 2x \sin(x) dx$. Then to compute $\int 2x \sin(x) dx$ at the end we would again need to integrate by parts. So be aware that you may need to continue on several steps! Our saving grace, though, is that the integral we are computing in the second step, $\int 2x \sin(x) dx$, is simpler than the original integral $\int x^2 \cos(x) dx$.

There are times when it seems like we may be going around in circles. Here is an example. Compute $\int e^x \cos(x) dx$.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/0Zz_WVWA48s" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

There is no obvious $u$ here. Remember: for $u$, we want a term so that $du$ is simpler. But whether we choose $u = e^x$ or $u = \cos(x)$, we end up with a similarly complex problem. So what should we do? Just pick one.

Let $u = e^x$, $dv = \cos(x) dx$. Then $du = e^x dx$, and $v = \sin(x)$. So our integral is:

$$\int e^x \cos(x) dx = e^x \sin(x) - \int e^x \sin(x) dx$$

Now what should we do? As I said above, let's integrate by parts again. Let $u = e^x$, and $dv = \sin(x) dx$. Then $du = e^x dx$ and $v = -\cos(x)$. So now $\int e^x \cos(x) dx$ is:

$$e^x \sin(x) - (e^x(-\cos(x)) - \int (e^x)(-\cos(x)) dx)$$

Distributing negatives, we get $e^x \sin(x) + e^x \cos(x) - \int e^x \cos(x) dx$. But now we are back where we started: the original problem was to compute $\int e^x \cos(x) dx$!

So what do we do? Take a second to look at everything we have done. We know that the integral $\int e^x \cos(x) dx$ is equal to:

$$e^x \sin(x) + e^x \cos(x) - \int e^x \cos(x) dx$$

The fact that $\int e^x \cos(x) dx$ is on both sides makes it appear that we did something wrong. But actually we can use algebra to solve this problem: add $\int e^x \cos(x) dx$ to both sides! Then:

$$2 \int e^x \cos(x) dx = e^x \sin(x) + e^x \cos(x)$$

Or, $\int e^x \cos(x) dx = \frac{e^x \sin(x) + e^x\cos(x)}{2} + C$.

**Exercise**: Find the antiderivative of $\int e^x \sin(x) dx$.

# Trigonometric Integrals

Before we go through trig integrals, please note this [reference page](https://divisbyzero.com/2021/02/09/essential-trigonometry-for-calculus/) on trig formulas, identities, and the unit circle. I will be referencing a few of the formulas / identities here as we need them. In particular, we will first need the Pythagorean identity:

$$\sin^2(x) + \cos^2(x) = 1$$

## Odd Powers

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/zV09QQCACac" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Let's go through an example here. Determine $\int \cos^3(x) \sin^2(x) dx$. Here we can re-write $\cos^3(x)$ as $\cos(x)\cdot \cos^2(x)$. Then use the fact that $\sin^2(x) + \cos^2(x) = 1$ to re-write $\cos^2(x)$ as $1 - \sin^2(x)$. That is, our integral is now:

$$\int \cos(x) \cdot (1 - \sin^2(x))\sin^2(x) dx$$

Let $u = \sin(x)$. Then $du = \cos(x) dx$, and we can simplify the integral to:

$$\int (1 - u^2)u^2 du$$

or:

$$\int u^2 - u^4 du$$

Then we integrate using the power rule: $\frac{u^3}{3} - \frac{u^5}{5} + C$. Substitute back and our general antiderivative is $\frac{\sin^3(x)}{3} - \frac{\sin^5(x)}{5} + C$.

**Strategy**: If we see an odd power of $\sin$ or $\cos$, pull one factor out, and re-write using $\sin^2(x) = 1 - \cos^2(x)$, or $\cos^2(x) = 1 - \sin^2(x)$. Then use integration by substitution, with either $u = \cos(x)$ or $u = \sin(x)$.

**Exercise**: Use this strategy on the following examples:

1. $\int \cos^3(x) dx$
2. $\int \sin^3(x) dx$
3. $\int \sin^3(x) \cos(x) dx$
4. $\int \cos^5(x) \sin^2(x) dx$

<details>
<summary>Check your answers</summary>
<ol>
<li>$\sin(x) - \frac{\sin^3(x)}{3} + C$</li>
<li>$\frac{\cos^3(x)}{3} - \cos(x) + C$</li>
<li>$\frac{\sin^4(x)}{4}+C$. Note that there is more than one acceptable answer here. Why might that be? The $+C$ is doing some work here. Take a look at <a href="https://www.desmos.com/calculator/2s4z2531px">this graph</a>, and recall that two functions which differ by a constant have the same derivative.</li>
<li>$\frac{\sin^7(x)}{7} - \frac{2\sin^5(x)}{5} + \frac{\sin^3(x)}{3} + C$</li>
</ol>
</details>

## Even Powers

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/qb4YwYd-ftA" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

If the powers of both $\sin$ and $\cos$ are even, then we have to find another trick. Here we recall the double angle formulas for cosine (there are three of them):

* $\cos(2x) = \cos^2(x) - \sin^2(x)$
* $\cos(2x) = 2 \cos^2(x) - 1$
* $\cos(2x) = 1 - 2 \sin^2(x)$

We will actually use the last two of these. Moreover, we'll be using them in reverse. That is, we're going to try to convert $\cos^2(x)$ and $\sin^2(x)$ into expressions involving $\cos(2x)$. To do this, we do some algebra, and compute:

* $\cos^2(x) = \frac{1}{2} + \frac{1}{2}\cos(2x)$
* $\sin^2(x) = \frac{1}{2} - \frac{1}{2}\cos(2x)$

Here's an example. Suppose we want to compute $\int \cos^2(x) dx$. We use the formula above to convert everything this into $\int \frac{1}{2} + \frac{1}{2}\cos(2x) dx$. Now integrate (use substitution with $u = 2x$ if you need to) and the general antiderivative is $\frac{x}{2} + \frac{1}{4} \sin(2x) + C$.

Another example: $\int \cos^2(x) \sin^2(x) dx$. Here we need to use both formulas. Try this out yourself, and then watch along the video as I go through the problem.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/qBi7qSi-IWg" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

<details>
<summary>Click for the final answer:</summary>
<p>$\frac{x}{8} - \frac{\sin(4x)}{32} + C$</p>
<p>Please watch the video above for the details on all of this! This is a challenging problem, you may need to go through this multiple times.</p>
</details>

**Exercises**:

1. $\int\limits_{-\pi}^{\pi} \cos^3(x) dx$
2. $\int \cos^4(x) dx$
3. $\int \cos(x) \sin^2(x) dx$

<details>
<summary>
Check your answers:
</summary>
<ol>
<li>0</li>
<li>$\frac{3x}{8}+\frac{\sin(2x)}{4}+\frac{\sin(4x)}{32}+C$</li>
<li>$\frac{\sin^3(x)}{3} + C$. This can be solved just using substitution: $u = \sin(x)$.</li>
</ol>
</details>

## Different angles

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/OR_RO5Uesdg" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

As before, I will remind you of some of the trig identities that we may need before we use them here:

* $\cos(a+b) = \cos(a) \cos(b) - \sin(a) \sin(b)$
* $\cos(a  - b) = \cos(a) \cos(b) + \sin(a) \sin(b)$
* $\sin(a + b) = \sin(a) \cos(b) + \cos(a) \sin(b)$
* $\sin(a - b) = \sin(a) \cos(b) - \cos(a) \sin(b)$

We will use these to help compute integrals of the form $\int \sin(ax) \cos(bx) dx$, $\int \cos(ax) \cos(bx) dx$, and $\int \sin(ax) \sin(bx) dx$. For example, how do we compute $\int \sin(5x) \cos(2x) dx$? We re-write $\sin(5x)\cos(2x)$ using the formulas above.

Since $\sin(5x + 2x) = \sin(5x) \cos(2x) + \cos(5x)\sin(2x)$, and $\sin(5x - 2x) = \sin(5x) \cos(2x) - \cos(5x) \sin(2x)$, if we add these together, we get that $\sin(7x) + \sin(3x) = 2\sin(5x) \cos(2x)$. In other words, $\sin(5x) \cos(2x) = \frac{\sin(7x) + \sin(3x)}{2}$.

More generally, we can use the following formulas:

* $\sin(ax)\cos(bx) = \frac{\sin(ax - bx) + \sin(ax + bx)}{2}$
* $\cos(ax)\cos(bx) = \frac{\cos(ax - bx) + \cos(ax + bx)}{2}$
* $\sin(ax)\sin(bx) = \frac{\cos(ax - bx) - \cos(ax + bx)}{2}$

Let's do an example: $\int\limits_0^{\pi/2} \sin(3x)\cos(2x) dx$. Using the first formula, we re-write $\sin(3x) \cos(2x)$ as $\frac{\sin(x) + \sin(5x)}{2}$, and so we are looking for $\frac{1}{2}\int\limits_0^{\pi/2} (\sin(x) + \sin(5x))dx$, which is $\left.\frac{1}{2}(-\cos(x) - \frac{\cos(5x)}{5})\right\|_0^{\pi/2}$.

Plugging in, we get $\frac{1}{2}(-\cos(\pi/2) - \frac{\cos(5\pi/2)}{5}) - \frac{1}{2}(-\cos(0) - \frac{\cos(0)}{5})$, which is $0 - \frac{1}{2}(-1 - \frac{1}{5})$, or just $\frac{3}{5}$.

As practice, go through exercises 103-108 in [Section 3.2](https://openstax.org/books/calculus-volume-2/pages/3-2-trigonometric-integrals) of the textbook.

# Homework

Due **Friday, February 19** on Moodle:

Section 1.6 #346 (look at #383 - 387, but don't need to hand those in)
Section 1.7 (page 111) #394, 398
Section 3.1 (page 270) #7, 8, 47, 48, 52
Section 3.2 (page 283) #80, 98, 104
