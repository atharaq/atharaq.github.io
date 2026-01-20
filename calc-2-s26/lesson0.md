# Calculus 2 Lesson 0: Welcome!
{:.no_toc}

1. Table of Contents
{:toc}

# Real Numbers

Go through the [handout on real numbers](numbers_handout.pdf) with a classmate. Just do side 1 first, then we will discuss as a class, and then work on side 2.

Topics for discussion:

* What are:
  * $\mathbb{N}$ natural numbers? What are they used for?
  * $\mathbb{Z}$ integers? Useful for?
  * $\mathbb{Q}$ rational numbers? Useful for?
  * $\mathbb{R}$ real numbers? Used for?
* Give an example of a number you **know** to be irrational, but is not $\pi, e,$ or a root like $\sqrt{2}$ or $\sqrt[3]{5}$?
  * $0.10110111011110\ldots$
  * How do you **know** for sure it is irrational?
  * What makes this number **real**?
  * Notice that its *finite approximations* are rational!

# Syllabus

* Spend some time looking at the [course syllabus](syllabus.html).
* Expectation: at least 8 hours of work outside of class per week.
  * Could be homework or studying.
  * "Studying" means: make sure to do lots of practice problems!

# Prerequisite material

I expect that most of you have learned about integrals already in Calculus I. Indeed, I covered integration in [lessons 20-23](https://atharaq.github.io/calc-1-f25/) of my Calc I course last semester. You are free to look at those notes and videos if you ever need a refresher. Of course, I'm sure that there are some things that students may have forgotten in the meantime. Coming in, I expect you to know the following:

* The geometric meaning and the limit definition of the "definite integral".
* The relationship between derivatives and definite integrals (the "Fundamental Theorem of Calculus").
* How to use simple derivative facts to evaluate definite integrals
  * For example: since $\frac{d}{dx} (\sin(x)) = \cos(x)$, we can compute $\int\limits_0^\pi \cos(x) dx$ as $\sin(\pi) - \sin(0)$, which is just $0$.
* Some basic antiderivative facts:
  * An antiderivative of $x$ is $\frac{x^2}{2}$.
  * An antiderivative of $x^2$ is $\frac{x^3}{3}$.
  * The reverse power rule in general: an antiderivative of $x^n$ (x raised to any power) is $\frac{x^{n+1}}{n+1}$. Increase the power by one and then divide by it!
  * An antiderivative of $\frac{1}{x}$ is $\ln\|x\|$, since the derivative of $\ln\|x\|$ is $\frac{1}{x}$.
  * [Many more in our textbook!](https://openstax.org/books/calculus-volume-2/pages/a-table-of-integrals)

Ideally, you would also have been introduced to the technique of **integration by substitution**. I know that this is not always covered in every Calculus I course, and so I will talk a bit about it on Monday.

## Resources

If you need a refresher on any of the information above, there are many resources that work well:

* [Chapter 1 of our textbook](https://openstax.org/books/calculus-volume-2/pages/1-introduction) covers all of this, from sections 1.1 to 1.4 (and 1.5 is on substitution).
* [Paul's Online Notes](https://tutorial.math.lamar.edu/Classes/CalcI/IntegralsIntro.aspx) for Calculus I includes this information as well. This is one of my favorite resources on the internet!
* [Khan Academy](https://www.khanacademy.org/math/calculus-2) has many materials reviewing these as well.

# Functions

Let's take a closer look at the concept of a function, first.

Which of the following graphs are graphs of functions? Why?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/lzvahclanh?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/astyaydeud?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/aubee1nfgq?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/eqd7naoskv?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

What, exactly, is a function? (Something that passes the **vertical line test**.)

## Inverses

**Exercise**: Which of the following have inverses?

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/13hc7t2edp?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/37cvqrb4w8?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/fdmlvszcch?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/z69hwucmtl?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

A function has an inverse if it is **one to one**. That is, if it passes the **horizontal line test**. If $f(x)$ has an inverse, we denote that function $f^{-1}(x)$. Then:

* $f(x) = y$ means $f^{-1}(y) = x$,
* $f^{-1}(f(x)) = x$, and,
* $f(f^{-1}(x)) = x$.

**Exercise**: Consider the following graph:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/7v7vh9zv8y?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

That is, we can see that:

* $f(-2) = 0$,
* $f(0) = -2$, and,
* $f(3) = 2$.

Find:

1. $f^{-1}(-2)$.
2. $f^{-1}(0)$.
3. $f^{-1}(2)$.

In general, we might not know how to *compute* the inverse function, just that it exists. Instead, if we know $f(x)$ and we want to know, say, $f^{-1}(25)$, look for an $x$-value so that $f(x) = 25$.

**Example**: Let $f(x) = 2^x$. Find $f^{-1}(8)$.

That is, we look for $x$ such that $2^x = 8$. Since $2^3 = 8$, this means $x = 3$; that is, $f^{-1}(8) = 3$.

(Question: what function is $f^{-1}(x)$ here?)

# Derivatives

**Exercise**: Consider the following graph of a function $g(x)$:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/37cvqrb4w8?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

1. What is $g^\prime(0)$?
2. Is $g^\prime(1)$ positive or negative?
3. What about $g^\prime(-2)$?

**Exercise**: With a partner:

1. Share your best explanations (in English) with each other of what the derivative means.
2. In physics, what is the derivative of velocity known as? What does that actually mean?
3. Suppose $v(t)$ is your velocity at time $t$. If you are slowing down at time $t$, what does that mean for $v^\prime(t)$?
4. If $v^\prime(t) = 0$, what does that tell you about your velocity at time $t$?

## Antiderivatives

1. What is an antiderivative?
2. Can a function have more than one antiderivative? Give an example?
3. Find antiderivatives of the following:
   * $f(x) = x + 1$.
   * $g(x) = e^x$.

## Definite Integrals

1. What is meant by $\int\limits_a^b f(x) dx$?
2. How do we compute this?
3. Why is there a relationship between this quantity (the definite integral) and antiderivatives?

<details>
<summary>Possible answers</summary>
<ol>
<li>The definite integral from $a$ to $b$ measures the area under the curve $y = f(x)$ from $x = a$ to $x = b$.</li>
<li>We compute this using the Fundamental Theorem of Calculus: find an antiderivative $F(x)$ of $f(x)$, and then plug in $F(b) - F(a)$.</li>
<li>The idea is that if $f(x) = F^\prime(x)$, then $f(x)$ is like a small change in $F(x)$. Then, the integral is "adding up all the small changes". If you add up a bunch of small changes, you just get the overall change.</li>
</ol>
</details>

# Written Homework

Your first assignment is due on BrightSpace **before class on Monday**:

1. We saw in class that there are sequences of rational numbers whose limit is not rational. Is there a sequence of integers whose limit is not an integer? Explain why or why not.
2. Give an explanation, in English, of the meaning of a derivative of a function. (You may use graphs or pictures to supplement your explanation. Feel free to use [Desmos](https://www.desmos.com/) to make graphs if you need them.)
3. Give an explanation, in English, of the meaning of the definite integral of a function. (You may use graphs or pictures to supplement your explanation.)
4. Suppose f(x) is an odd function: that means, for every x, $f(-x) = -f(x)$. (For example, look at the [graph](https://www.desmos.com/calculator/cnledtgpoq) of $f(x) = \sin(x)$). Explain why, for any real number a, $\int\limits_{-a}^a f(x) dx = 0$. Again, you may use pictures/graphs to supplement your explanation.

# MyOpenMath Homework

There is also an assignment on MyOpenMath. This is a website we will be using for online homework this semester. Check on BrightSpace for the link and login information. Get started soon, so that if you have trouble on any of these problems, we can discuss it on Monday!
