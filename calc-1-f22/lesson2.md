# Calculus I Lesson 2: Limits
{:.no_toc}

1. Table of Contents
{:toc}

# Inverses

You should be familliar with the concept of inverse functions. The basic notion is that if $y = f(x)$, then the inverse function (if it exists) is the function which swaps $x$ and $y$. We write that as $f^{-1}$: so if $y = f(x)$, then $x = f^{-1}(y)$.

Simple examples:

1. If $f(x) = 2x$, then the inverse function is $f^{-1}(x) = \dfrac{x}{2}$.
2. If $f(x) = x + 3$, then the inverse function is $f^{-1}(x) = x - 3$.

Not all functions have inverses. A function has an inverse if it passes the **horizontal line test**: that is, if every horizontal line you draw on the graph of the function hits the function in at most one point. For some functions, this does not happen. For example, look at the graph of $f(x) = x^2$: the line $y = 1$ hits the graph in two places.

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/2rpj5ivdo2?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

In this case, we *restrict the domain*:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/7cqprb3juc?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

Now notice that for $x \geq 0$, if $y = x^2$, then $x = \sqrt{y}$. Of course we know this intuitively: the square root function is the inverse of the squaring function, but only for positive numbers.

## Logarithms are Inverses

Students often have trouble computing logarithms. This is because logarithms are inverse functions. We determine the value of $\log_b(x)$ by asking the question: "What power do I need to raise $b$ to, in order to get $x$?" Some examples:

1. $\log_2(8) = 3$ because $2^3 = 8$.
2. $\log_2(2) = 1$, because $2^1 = 2$.
3. $\ln(1) = 0$, because $e^0 = 1$. (Note: remember that $\ln$ means $\log_e$!) More generally, $\log_b(1) = 0$.
4. $\ln(e^x) = x$, or more generally, $\log_b(b^x) = x$.
5. $e^{\ln(x)} = x$, or more generally, $b^{\log_b(x)} = x$.

We use this same intuition to figure out inverse trig functions. For example, $\arcsin(1) = \pi/2$, because $\sin(\pi/2) = 1$. Similar to the parabola above, trig functions do not have inverses unless we restrict the domain of the functions. [Review the restricted domains of inverse trigonometric functions in the textbook](https://openstax.org/books/calculus-volume-1/pages/1-4-inverse-functions#fs-id1170572141300).

## Derivatives: Rates of Change

To discuss the notion of "rate of change" more precisely, let's talk about a specific example. Let's say we drop a ball from a height of 45 meters. Its height (in meters), $t$ seconds later, is (roughly) given by the equation

$$h(t) = 45 - 5t^2$$
<div class="desmos-container"><iframe title="Dropping a ball graph" src="https://www.desmos.com/calculator/ubtswqoxv5?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

There are several questions about the velocity of the ball we can ask:

1. What is the *average* velocity of the ball in the first second after it is dropped? (From $t = 0$ to $t = 1$)?
2. What is the *average* velocity of the ball from $t = 1$ to $t = 3$?
3. What is the *average* velocity of the ball from $t = 1$ to $t = 2$?

Try to work these out on your own. Velocity is a rate of change. The *average rate of change* for a function $f(x)$ from $x = a$ to $x = b$ is given by the formula
$$\dfrac{\Delta y}{\Delta x} = \dfrac{f(b) - f(a)}{b - a}$$

<details>
<summary>Check your answers here:</summary>
<ol>
<li>$\dfrac{f(1)-f(0)}{1-0} = -5$ m / s.</li>
<li>$\dfrac{f(3)-f(1)}{3-1} = -20$ m / s.</li>
<li>$\dfrac{f(2)-f(1)}{2-1} = -15$ m / s.</li>
</ol>
</details>

Note: why are these answers all negative?

How do these quantities show up on the graph above? These all show up as slopes of secant lines: lines between two points on the graph.
<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/g1oa7aedyd?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

All of these refer to the velocity of the ball between two points in time: the change in the distance divided by the change in time. But what *is* the velocity of the ball at **exactly** 1 second after it is dropped? We see that average speed is something we can compute by seeing how far the ball moved in a certain amount of time. But instantaneous speed does not really make sense intuitively. So what does it actually mean?

Well, what could it mean? Write down some of your thoughts. As part of the lesson check in (later), you will be asked to discuss these thoughts a bit.  Let's zoom in on the graph near $t = 1$, and play around with different secant lines. This dynamic graph below shows what happens when we graph the secant lines between $t = 1$ and points close to that, allowing the value of $a$ to change from 0.5 to 1.5.

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/9gpc6fmosr?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

[View this graph on Desmos](https://www.desmos.com/calculator/9gpc6fmosr){:target="_blank"}.
Zoom in and out, and pause the "$a$" slider on the left at various points to see how the graph changes. Remember: the slopes of these lines tell you the average speed of the ball between those two points in time ($t = 1$ and $t = a$). What happens as $a$ gets really, really close to $t = 1$?

## Unifying theme: Limits

The key point above is that there really isn't an *algebraic* way to define the speed of an object at an **exact** instant in time. We can look at the rate of change between two, different points in time, but not for just a single, individual point.

This is where the concept of calculus really kicks in. The difference between calculus and algebra is the notion of a **limit**. Instead of thinking about the "instantaneous speed" of the ball exactly 1 second after it is dropped, we first think about average speeds between two points, and then think about what happens as those two points get closer and closer together.

In other words, the **instantaneous** speed at $t = 1$ is defined to be the limit of the *average* speeds between $t = 1$ and $t = a$, as the number $a$ gets closer and closer to 1. In the next few lessons, we will explore this concept of a limit more closely, but this is the intuition. In terms of the graph we saw above, we think about how the secant lines get closer and closer to something else: a *tangent* line!

A *secant* line on a graph is a line that connects two points on the graph. The graph below depicts a tangent line:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/zbbni7eoid?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

What do you think a good definition of a tangent line is? What do you think is the relationship between average rates of change and secant lines on the one hand, and instantaneous rates of change and tangent lines on the other?

# Desmos Activity

Before reading the rest of these notes, please go through this [interactive activity on Desmos](https://student.desmos.com/join/kfm243). Please use your **real name** for **attendance purposes**, though I can/will make all responses anonymous.

# Wrap up

Let $f(x)$ be a function. Then ${\displaystyle\lim_{x \rightarrow a}} f(x)$ is read "the limit as x approaches a of $f(x)$". We've seen a few things already:

First of all: limits do not always exist! Some functions do not "approach" anything near a given point. This was fascinating to me as a student: I never knew that it was possible for something in mathematics to just "not exist".

Secondly, a function can approach different values if we approach $a$ from the left and from the right. This is why we define the "left" and "right" side limits:

* ${\displaystyle \lim_{x \rightarrow a^-}} f(x)$ means "The limit as $x$ approaches $a$, from the left, of $f(x)$". I will often, informally, refer to this as the "left hand limit".
* ${\displaystyle \lim_{x \rightarrow a^+}} f(x)$ means "The limit as $x$ approaches $a$, from the right, of $f(x)$". I will often, informally, refer to this as the "right hand limit".

If both of these **one-sided** limits exist and are equal to each other, then ${\displaystyle \lim_{x \rightarrow a}} f(x)$ exists, and is the same as both of those one-sided limits. I will often, informally, refer to ${\displaystyle \lim_{x \rightarrow a}} f(x)$ as the "two-sided" limit.

Thirdly, a function can approach a limit that is different from the actual value of the function. That is, it's possible for ${\displaystyle \lim_{x \rightarrow a}} f(x)$ to exist, but to be different from $f(a)$. This often happens when we have a "hole" in the graph of the function.

Lastly, the best possible behavior regarding limits of a function is if the function simply approaches the actual value of the function there. That is, if ${\displaystyle \lim_{x \rightarrow a}} f(x) = f(a)$. Obviously this option is quite nice, and so we will often want functions that have this behavior. We will call this property *continuity*, and this will be an important subject during this semester.

Before we close, let's go through some exercises involving *piecewise functions*, functions whose values are determined differently on different parts of their domains.

## Exercise

For the following functions, find the left-hand, right-hand, and two-sided limits, if they exist:

1. Find ${\displaystyle \lim_{x \rightarrow 0^-}} f(x)$, ${\displaystyle \lim_{x \rightarrow 0^+}} f(x)$, and ${\displaystyle \lim_{x \rightarrow 0}} f(x)$ for $$f(x) = \begin{cases} -x &\mbox{if } x < 0 \\ 2x &\mbox{if } x \geq 0 \end{cases}$$.
2. Find ${\displaystyle \lim_{x \rightarrow 1^-}} g(x)$, ${\displaystyle\lim_{x \rightarrow 1^+}} g(x)$, and ${\displaystyle\lim_{x \rightarrow 1}} g(x)$ for $$g(x) = \begin{cases} 0 &\mbox{if } x = 1 \\ 1 &\mbox{if } x \neq 1 \end{cases}$$.
