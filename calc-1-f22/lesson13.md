# Calculus I Lesson 13: Logarithmic Differentiation
{:.no_toc}

1. Table of Contents
{:toc}

# Exam Recap

**Question 6**: Find the equation of a tangent line of $h(x) = x^3 - 12x$ at $x = 2$.

* Find the point: $(2, h(2))$.
* Find the slope: $h^\prime(2)$. Use any method to find this derivative.
* Now use point-slope form: $y - h(2) = h^\prime(2)(x - 2)$.
* In this case, the slope is 0. What does that mean?

**Question 7**: What is the definition of the derivative?

**Question 9**: Continuous, differentiable, both or neither?

First recall what these mean.

* $f(x)$ is continuous at $x = a$ if $\lim\limits_{x \rightarrow a} f(x) = f(a)$.
  * That means both sides need to be defined! The limit has to exist!
* $f(x)$ is differentiable at $x = a$ if $\lim\limits_{x \rightarrow a} \frac{f(x) - f(a)}{x - a}$ exists.

Let's look at the example from the test.

$$f(x) = \begin{cases}0 &\mbox{if } x < 0 \\
x^2 &\mbox{if } 0 \leq x \leq 1 \\
x &\mbox{if } 1 < x < 2 \\
2x - 1 &\mbox{if } x \geq 2\end{cases}$$

Let's just check $x = 0$.

$$\lim_{x \rightarrow 0^-} \frac{f(x) - f(0)}{x - 0} = \lim_{x \rightarrow 0^-}\frac{0 - 0}{x} = 0$$

$$\lim_{x\rightarrow 0^+} \frac{f(x) - f(0)}{x - 0} = \lim_{x\rightarrow 0^+} \frac{x^2 - 0}{x - 0} = \lim_{x \rightarrow 0^+} x = 0$$

The two sides are the same, so $f(x)$ is differentiable at $x = 0$. That also means that $f(x)$ is continuous at $x = 0$ (why?), so the answer is **both**.

# Derivative of $x^x$

We cannot use the power rule to find the derivative of $y = x^x$, since the exponent is a variable and not a constant. But we also can't use the rule that the derivative of an exponential function $b^x$ is $b^x \ln(b)$, since the base is not a constant either. We can use the technique of logarithmic differentiation to help, though: let $y = x^x$ and then consider $\ln(y) = \ln(x^x)$. Using rules for logarithms, this simplifies to $\ln(y) = x \ln(x)$. Now take the derivative of both sides:

$$\frac{y^\prime}{y} = 1 \ln(x) + (\frac{1}{x})x = \ln(x) + 1$$

Solve for $y^\prime$: $y^\prime = y(\ln(x) + 1)$. Substitute back $y = x^x$ and get $y^\prime = x^x (\ln(x) + 1)$.

## Other logarithms

What is the derivative of $y = \log_2(x)$? Again, we can figure this out implicitly. First we know that $y = \log_2(x)$ means that $2^y = x$. Now take the derivative of this:

$$2^y \ln(2) y^\prime = 1$$

Solve for $y^\prime$: $y^\prime = \dfrac{1}{2^y \ln(2)} = \dfrac{1}{x \ln(2)}$, using the fact that $2^y = x$.

Can you guess the general pattern for the derivative of $y = \log_b(x)$? Try to follow the same steps to find the derivative of $y = \log_10(x)$. The textbook goes over this in [Section 3.9](https://openstax.org/books/calculus-volume-1/pages/3-9-derivatives-of-exponential-and-logarithmic-functions), Theorem 3.16.

# Power Rule, generalized.

Recall that we have seen that the derivative of $x^n$ is $n x^{n-1}$ for positive integers $n$. It also worked for $n = -1$ and $n = -2$. With a little work we can see that it works for all integers $n$. We've also seen it for $x^{\frac{1}{2}}$, that is, $\sqrt{x}$. In fact, it works for all real numbers, so even functions like $x^\pi$! (Now that we actually can make sense of what that even means!)

**Theorem**: For *any* real number $r \neq 0$, if $f(x) = x^r$, then $f^\prime(x) = r x^{r - 1}$.

How can we see this for all real numbers $r$? We can use **logarithmic differentation** again. First, let $y = x^r$. Then take the natural log of both sides:

$$\ln(y) = \ln(x^r).$$

Continue as follows:

1. Use the properties of logarithms to simplify $\ln(x^r)$.
2. Find the derivative (with respect to $x$) of both sides of the expression you just obtained.
3. Solve for $y^\prime$.
4. Replace $y$ with $x^r$, and simplify.

# Related Rates

We are now ready to start our unit on applications of derivatives. Our first set of applications come from **related rates**. These are problems where multiple rates of change are related to one another in some equations.

**Example**: A 10-ft ladder is leaning against a wall. If the top of the ladder slides down the wall at a rate of 2 ft/sec, how fast is the bottom moving along the ground when the bottom of the ladder is 5 ft from the wall?

<img src="https://openstax.org/resources/5985bce6625143cae885714f862041da23457e09" data-media-type="image/jpeg" alt="A right triangle is formed by a ladder leaning up against a brick wall. The ladder forms the hypotenuse and is 10 ft long." />

## Solution

* $x$ = horizontal distance from the bottom of the ladder to the wall
* $y$ = distance from the top of the ladder to the floor
* $x^2 + y^2 = 100$.

What do we know? What do we want to know?

* We know that $y^\prime = -2$.
* We know what $x = 5$.
* We can figure out $y$ (Pythagorean theorem).
* We need to figure out $x^\prime$?

There are a few ways we can do this. We can write equations for $y(t)$, the height of the top of the ladder at time $t$, and $x(t)$, the distance from the bottom of the ladder to the wall at time $t$. Then we can compute $x^\prime$. This turns out to be really hard!

A better idea would be to reason *implicitly*. Use $x^2 + y^2 = 100$, take the derivative *with respect to $t$* of both sides. We get $$2xx^\prime + 2yy^\prime = 0.$$ Again, we know that $x = 5$ and $y^\prime = -2$. Using the Pythagorean Theorem, we get $y = \sqrt{75}$. So we can fill in: $$2(5)x^\prime + 2(\sqrt{75})(-2) = 0.$$ Solving for $x^\prime$, we get $x^\prime = 2\sqrt{3}$ ft / sec.

## General Strategy

* Draw a figure, declare variables
* Relate the variables with an equation
* Differentiate both sides of the equation (use chain rule)
* Substitute and solve

## YouTube Playlist

Related Rates is a challenging topic, so I suggest the following resource that I found helpful: [patrickJMT's playlist of related rates problems](https://www.youtube.com/watch?v=jv4gTxWqeBE&list=PLDC0E2E78840869A5). There are 8 videos in this playlist, going through a few different types of related rates problems. We will continue to do more on Thursday.
