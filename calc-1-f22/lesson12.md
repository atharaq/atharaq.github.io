# Calculus I Lesson 12: Exponential Functions
{:.no_toc}

1. Table of Contents
{:toc}

# Review of Exponential Functions

An exponential function is a function of the form $y = b^x$, where $b$ is some constant. We exclude $b \leq 0$, since, for negative numbers, $b^{\frac{1}{2}}$ is not defined, for example.

Before we study the derivatives of these kinds of functions, I'd like to review these functions a bit. First of all, what do exponents even mean?

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/T988wK9rQQg" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## Exponents?

If that sounded like a rhetorical question, it wasn't. We know what *some* exponents mean. For example, $2^3$ means $2 \times 2 \times 2$. We also know that $2^0$ is 1, and $2^{-4}$ means $\dfrac{1}{2 \times 2 \times 2 \times 2}$. So we can make sense of integer exponents.

We can also make sense of exponents that are fractions: $2^{\frac{3}{4}}$ means $\sqrt[4]{2^3}$. But what does $2^\pi$ mean?

Before we answer this, it's worth mentioning: do we really know what the **basic operations** (addition, subtraction, multiplication, division) really mean for irrational numbers like $\pi$?

## Addition? Multiplication?

We usually think of addition as repeated counting: $5 + 7 = 12$, because if we had $5$ apples on one side and $7$ apples on another, then we have $12$ apples total. But of course, there is no notion of $\sqrt{2}$ apples. What does $2 + \sqrt{2}$ mean? It's really about **measurement**, rather than counting: "slide the number line over by a length of $\sqrt{2}$."

Similarly, multiplication is usually thought of as repeated addition. $2 \times 3$ means $2$ groups of $3$. What does $\pi \times 3$ mean? $\pi$ groups of 3? Again, we need to re-think this notion slightly: instead of making groups, we **re-scale**: multiplying by $\pi$ means we stretch out the number line until the tick marks are spaced apart by a length of $\pi$.

In a sense our operations are **transformations** of the number line by sliding (addition) or stretching/shrinking (multiplication).

Incidentally, this helps us understand multiplying negatives: multiplying by a negative involves both the re-scaling as well as reflecting the whole line about the center.

## Exponents!

So what does this mean for exponents? The whole point is that we need to re-interpret exponentiation. Really, the **only** way to make sense of exponential functions is to use calculus: $2^\pi$ is defined as whatever value makes the function $2^x$ continuous as $x \rightarrow \pi$. In other words: we know what $2^3$ is, we know how to calculate $2^{3.1}$, and $2^{3.14}$, and $2^{3.141}$, and all of these numbers approach some limit as $x \rightarrow \pi$. $2^\pi$ is defined to be this limit.

## Growth

Exponential functions are used to model **continuous growth**. Let's go through a classical investment example.

**Example**: An investment earns 10% annually. We initially invest 1000 dollars. How much do we have after $t$ years?

Let $A(t)$ be the function that represents the amount of money invested after $t$ years.

* $A(0) = 1000$
* $A(1) = 1100$ (10% more than 1000: add 100)
* $A(2) = 1210$ (10% more than 1100: add 110)
* $A(3) = 1331$ (10% more than 1210: add 121)

This function is given, algebraically, by $A(t) = 1000 \cdot (1.1)^t$.

Notice that the amount the investment grows by is directly proportional to the amount invested. If we have 1,000,000 dollars invested, we will earn 100,000. If we have 1,000,000,000 invested, we will earn 100,000,000!

This is worth re-iterating: the key fact about exponential functions is that their **growth is proportional to their value**. We will see that this fact is reflected in their derivatives: $y^\prime$ is proportional to $y$, no matter where we look on the graph.

Next time we will study derivatives of exponential functions and their inverses, logarithmic functions. Please review [Section 1.5 on exponential and logarithmic functions](https://openstax.org/books/calculus-volume-1/pages/1-5-exponential-and-logarithmic-functions) as well as [Section 3.9 on the derivatives of exponential and logarithmic functions](https://openstax.org/books/calculus-volume-1/pages/3-9-derivatives-of-exponential-and-logarithmic-functions).

# Exponential Functions

Recall that an exponential function is a function of the form $f(x) = b^x$, where $b$ is a constant, positive real number. The most important fact about exponential functions that we need for this section is the rule for addition inside exponents: for any exponential function $b^x$, and any real numbers $x$ and $y$:

$$b^{x+y} = b^x b^y$$

This rule allows us to find a formula for the derivative of exponential functions. Suppose $f(x) = b^x$. To compute $f^\prime(x)$, we compute $\dfrac{b^{x+h}-b^x}{h}$ and then take the limit as $h \rightarrow 0$ of the expression we get. Since $b^{x+h} = b^x b^h$, we see:

$$\frac{b^{x+h}-b^x}{h} = \frac{b^xb^h - b^x}{h} = b^x \frac{b^h - 1}{h}$$

Notice that $b^x$ does not depend on $h$ at all, and so the limit as $h \rightarrow 0$ of the above expression will be $b^x \cdot \lim\limits_{h\rightarrow 0} \dfrac{b^h - 1}{h}$.

This expression on the right, $\dfrac{b^h - 1}{h}$, looks challenging to compute. For example, it's not obvious what this would be if $b = 2$. Let's compute $\dfrac{2^h - 1}{h}$ for small, *positive* values of $h$:

$$
\begin{array}{c|c}
h & \dfrac{2^h - 1}{h} \\
\hline
.1 & .7177 \\
.01 & .6956 \\
.001 & .6934 \\
.0001 & .6932
\end{array}
$$

Now let's compute this same expression for small, *negative* values of $h$:

$$
\begin{array}{c|c}
h & \dfrac{2^h - 1}{h} \\
\hline
-.1 & .6697 \\
-.01 & .6908 \\
-.001 & .6929 \\
-.0001 & .6931
\end{array}
$$

It seems like this does have some limit, but it's not clear what it is. In fact, this actually turns out to be the derivative of $f(x) = 2^x$ at $x = 0$: recall, to find the derivative at the point $x = 0$, we can use the formula ${\displaystyle \lim_{x \rightarrow 0} \frac{f(x) - f(0)}{x - 0} }$. In the case of $f(x) = 2^x$, we would get

$$
\lim_{x \rightarrow 0} \frac{2^x - 1}{x}
$$

which is exactly the same as ${\displaystyle \lim_{h \rightarrow 0} \frac{2^h - 1}{h} }$. That is, if $f(x) = 2^x$, then $f^\prime(x) = f(x) \cdot f^\prime(0)$! Recall last time we mentioned that the derivative of an exponential function, at any point, is proportional to the value of the function itself. This is exactly what I mean: $f^\prime(0)$ is some number (a constant, does not depend on $x$), and $f^\prime(x)$ is exactly that same constant multiplied by $f(x)$, no matter what $x$ is.

This same phenomenon happens for every exponential function: if $f(x)$ is an exponential function, then $f^\prime(x) = f(x) \cdot f^\prime(0)$. **The derivative of an exponential function is proportional to the value of the function itself.**

Now take a look at this video from the "Essence of Calculus" series on exponential functions:

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/m2MIpDrF7Es" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# The number $e$

With some work, or just by plugging in numbers or looking at graphs, you can verify, for yourself, that the limit ${\displaystyle \lim_{h \rightarrow 0} \frac{b^h - 1}{h}}$ exists for any positive real number $b$. These limits would be different for different values of $b$, but they all exist. For $b = 2$, for example, we saw that this limit was around 0.693. For $b = 10$, this limit would be about 2.303. That means that if $f(x) = 2^x$, then $f^\prime(x) \approx 0.693 \cdot 2^x$. If $g(x) = 10^x$, then $g^\prime(x) \approx 2.303 \cdot 10^x$. It stands to reason, then, that there is some base, somewhere between $b = 2$ and $b = 10$, such that that limit would be exactly 1. There is such a number: $e \approx 2.71828\ldots$ You've likely seen $e$ in the context of studying compound interest: there, the number $e$ was defined as a limit:

$$e = \lim_{n \rightarrow \infty} (1 + \frac{1}{n})^n$$

It turns out that there are *many* equivalent ways of defining the number $e$. What I mean by this is that you could start with the definition that $e$ is the number $b$ such that ${\displaystyle \lim_{h \rightarrow 0} \frac{b^h - 1}{h}} = 1$, and prove that it's also equal to the limit as $n \rightarrow \infty$ of $(1 + \dfrac{1}{n})^n$, or  you could start with the assumption that $e$ is equal to this limit, and prove that the derivative of $e^x$ at $x = 0$ is exactly $1$.

Either way, we end up with the result that if $f(x) = e^x$, then $f^\prime(x) = e^x$. That is, $e^x$ is its own derivative! This is another really remarkable fact about the number $e$, which we could take as a sort of defining feature.

Using all of our rules, then, we can find more complicated derivatives.

**Examples**:

1. Let $y = e^{2x}$. Using the chain rule, let $u = 2x$. Then $\frac{dy}{dx} = \frac{dy}{du} \frac{du}{dx} = e^u \cdot 2 = 2 e^{2x}$.
2. Let $y = e^{\sin(x)}$. Let $u = \sin(x)$. Then $\frac{dy}{dx} = e^{\sin(x)} \cdot \cos(x)$.

# Exercises

Using all the rules you know, find the derivatives of the following functions:

1. $f(x) = e^{x^2} \cos(x)$
2. $g(x) = \dfrac{e^{2x}}{\sin(x)}$

# Logarithmic Functions

A **logarithm** is the inverse of an exponential function. That is, if $y = b^x$, then $x = \log_b(y)$, and vice versa: if we are trying to graph $y = \log_b(x)$ for some base $b$, we really should think of this as looking for $(x, y)$ values where $b^y = x$.

That is: $\log_b(x)$ and $b^x$ are inverses. If a point $(x, y)$ is on the graph of one of these functions, then switching $x$ and $y$, we get a point on the other graph. For example, if $y = 2^x$, we know that $(3, 8)$ is on the graph of this function. That means $(8, 3)$ is on the graph of $y = \log_2(x)$. That is: $\log_2(8) = 3$.

The **natural logarithm** function is $f(x) = \log_e(x)$. It is used so often that it has a special name: $\ln(x)$ means $\log_e(x)$. Again, the same general rule applies: $y = \ln(x)$ means $e^y = x$.

To find the derivative of $y = \ln(x)$, it is easier to reason **implicitly** using the equation $e^y = x$. Take the derivative of both sides with respect to $x$, and we get $e^y y^\prime = 1$. Then solve for $y^\prime$ and get $y^\prime = \dfrac{1}{e^y}$. Remember, though, that we used the equation $e^y = x$, so that means we can substitute $x$ in for $e^y$: that is, $y^\prime = \dfrac{1}{x}$!

This is covered in the excellent 3Blue1Brown video on Implicit Differentiation. Take a look at that one here, as it may help refresh your memory on this topic.

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/qb40J4N1fa4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Other bases: Logarithmic Differentiation

So far, we know a couple of things:

* If $f(x) = b^x$ for some base $b$, then $f^\prime(x) = b^x f^\prime(0)$.
* If $f(x) = e^x$, then $f^\prime(x) = e^x$ also: that is, $f^\prime(0) = 1$.

So for other bases $b \neq e$, how can we find that derivative at $0$? To try to tackle this problem, we will use a technique called **logarithmic differentiation**. Logarithmic differentiation roughly means that, starting with a function $y = f(x)$, we look at $\ln(y) = \ln(f(x))$, use the rules for logarithms to simplify $\ln(f(x))$, take the derivative of both sides (implicitly on the left side), and then solve for $y^\prime$.

I go over this technique in this video:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/eaMeqp_L7Ec" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

For example, let's take a look at $f(x) = 10^x$. Let $y = 10^x$ and then look at the natural log of both sides:

$$\ln(y) = \ln(10^x)$$

Using the rules for logarithms, $\ln(10^x) = x \ln(10)$, or $\ln(10) \cdot x$. So we have $\ln(y) = \ln(10) \cdot x$. Now take the derivative of both sides. On the left, $(\ln(y))^\prime = (\dfrac{1}{y}) \cdot y^\prime = \dfrac{y^\prime}{y}$. As we do more of these logarithmic differentiation problems, you will see this term $\dfrac{y^\prime}{y}$ show up often.

Then on the right, since $\ln(10) \cdot x$ is a constant multiplied by $x$, the derivative is just $\ln(10)$. So:

$$\dfrac{y^prime}{y} = \ln(10)$$

Therefore $y^\prime = \ln(10) \cdot y = \ln(10) \cdot 10^x$, using the fact that $y = 10^x$ is what we started with.

Recall: if $f(x) = b^x$, then $f^\prime(x) = b^x \cdot f^\prime(0)$. That is, $f^\prime(x)$ is just $f(x)$ multiplied by some constant. What is that constant? It turns out, in the case of $b = 10$, that that constant was just $\ln(10)$! In general, for any base $b$, that constant will be $\ln(b)$! Can you figure out how to prove that using the technique of logarithmic differentiation?

# Homework / Upcoming

1. DeltaMath due Thursday (10/13)
2. Topic statement due Monday (10/17)
3. DeltaMath due Monday (10/17)
4. Written Homework 5 due next Thursday (10/20):
   * Section 3.5: #180, 192, 201
   * Section 3.6: #230, 232, 248, 254
   * Section 3.8: #302, 316, 325
5. Quiz next Thursday? Or following Monday?
