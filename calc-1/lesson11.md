# Calculus Lesson 11: Derivatives of Exponential and Logarithmic Functions
{:.no_toc}

1. Table of Contents
{:toc}

# Quiz
{:.no_toc}

Before starting, be sure to check Moodle for **Quiz 2**.

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

With some work, or just by plugging in numbers or looking at graphs, you can verify, for yourself, that the limit ${\displaystyle \lim_{h \rightarrow 0} \frac{b^h - 1}{h}}$ exists for any positive real number $b$. These limits would be different for different values of $b$, but they all exist. For $b = 2$, for example, we saw that this limit was around 0.693. For $b = 10$, this limit would be about 2.303. That means that if $f(x) = 2^x$, then $f^\prime(x) \approx 0.693 \cdot 2^x$. If $g(x) = 10^x$, then $g^\prime(x) \approx 2.303 \cdot 10^x$. It stands to reason, then, that there is some base, somewhere between $b = 2$ and $b = 10$, such that that limit would be exactly 1. There is such a number: $e \approx 2.71828$ You've likely seen $e$ in the context of studying compound interest: there, the number $e$ was defined as a limit:

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

## Derivative of $x^x$

We cannot use the power rule to find the derivative of $y = x^x$, since the exponent is a variable and not a constant. But we also can't use the rule that the derivative of an exponential function $b^x$ is $b^x \ln(b)$, since the base is not a constant either. We can use the technique of logarithmic differentiation to help, though: let $y = x^x$ and then consider $\ln(y) = \ln(x^x)$. Using rules for logarithms, this simplifies to $\ln(y) = x \ln(x)$. Now take the derivative of both sides:

$$\frac{y^\prime}{y} = 1 \ln(x) + (\frac{1}{x})x = \ln(x) + 1$$

Solve for $y^\prime$: $y^\prime = y(\ln(x) + 1)$. Substitute back $y = x^x$ and get $y^\prime = x^x (\ln(x) + 1)$.

## Other logarithms

What is the derivative of $y = \log_2(x)$? Again, we can figure this out implicitly. First we know that $y = \log_2(x)$ means that $2^y = x$. Now take the derivative of this:

$$2^y \ln(2) y^\prime = 1$$

Solve for $y^\prime$: $y^\prime = \dfrac{1}{2^y \ln(2)} = \dfrac{1}{x \ln(2)}$, using the fact that $2^y = x$.

Can you guess the general pattern for the derivative of $y = \log_b(x)$? Try to follow the same steps to find the derivative of $y = \log_10(x)$. The textbook goes over this in [Section 3.9](https://openstax.org/books/calculus-volume-1/pages/3-9-derivatives-of-exponential-and-logarithmic-functions), Theorem 3.16.

# Check-In

After going through the lesson and the videos, answer the following on Moodle:

1. The steepness of an exponential function at any point x = a is proportional to the value of that function, f(a). What does this mean in your own words? Describe what this means in the context of either the example of investing money in [Lesson 10](lesson10.html#growth), or in the 3Blue1Brown video on the size of a population which grows over time.
2. In your own words, what is "natural" about the natural log and about e?
3. Let's take the first steps toward showing the power rule for functions of the form $y = x^r$. Use the properties of logarithms to simplify $\ln(x^r)$.
4. Find the derivative (with respect to $x$) of the expression you wrote down in question 3.
