# Calculus I Lesson 20: Applications of Integrals and Substitution
{:.no_toc}

1. Table of Contents
{:toc}

Last time we learned about the Fundamental Theorem of Calculus. This taught us a convenient way to evaluate integrals: if $F(x)$ is any antiderivative of $f(x)$, then:

$$
\int_a^b f(x) dx = F(b) - F(a)
$$

For example, the area under $y = x^2$ from $x = 1$ to $x = 2$ is $\int\limits_1^2 x^2 dx = \left.\frac{x^3}{3} \right\|_1^2$, which is $\frac{8}{3} - \frac{1}{3}$, or $\frac{7}{3}$.

We will be this often to figure out areas under curves in applications problems.

# Application 1: Work

<div class="youtube-container">

</div>


# Application 2: Velocity

<div class="youtube-container">

</div>



## Integrals and Multiplication

# Integration by Substitution

<div class="youtube-container">

</div>

As we have seen, to evaluate definite integrals, it is important to be able to find antiderivatives. This is sometimes not quite easy, and so we need to learn some techniques to help us find antiderivatives. Some of these techniques are based on rules for derivatives. In this course, we will learn one of these techniques: integration by substituion. We can learn more techniques in Calculus 2.

Integration by substitution is based on the chain rule. Let's go through a chain rule example. What's the derivative of $\ln(x^2 + 1)$? Recall: one way to think about this is to make a substitution: let $u = x^2 + 1$, and then we are looking at the derivative of $\ln(u)$. So:

$$
\begin{align}
(\ln(x^2+1))^\prime &= \frac{d}{dx} (\ln(u)) \\
&= \frac{1}{u} \frac{du}{dx} \\
&= \frac{1}{x^2+1} (x^2+1)^\prime \\
&= \frac{2x}{x^2 + 1}
\end{align}
$$

This means that $\int \frac{2x}{x^2 + 1} dx = \ln(x^2 + 1) + C$. How would we figure this out? By making a substitution and working backward.

If we let $u = x^2 + 1$, we notice that this integral is just $\int \frac{1}{u} \cdot \frac{du}{dx} dx$. Notice that it looks like the dx "cancels out" and we are left with $\int \frac{1}{u} du$, which we know is $\ln(u) + C$. Now plug back in $u = x^2 + 1$ and get $\ln(x^2 + 1) + C$, which is exactly what we knew was the general antiderivative!

In other words, the strategy for integration by substitution involves letting $u$ be some expression that appears in the problem, and then replacing $dx$ by $du = \frac{du}{dx} dx$. At that point, we hope to have a simple expression in terms of $u$ and $du$ (no $x$ or $dx$ terms should be left!). Integrate, and then substitute back in for $u$ for your final answer.

**Example**: Find $\int \sin(x) \cos(x) dx$. Here, let $u = \sin(x)$, and $du = \cos(x) dx$. Then we are integrating $\int u du$, which is $\frac{u^2}{2} + C$. Now substitute back and our final answer is $\frac{(\sin(x))^2}{2} + C$.

Notice: we found a term, $\sin(x)$, and its derivative $\cos(x)$ in the formula we were integrating. A good piece of advice: look for a term whose derivative shows up in the problem. Moreover, look for a term whose derivative shows up in the **numerator** of the problem.

A bad example would be $\int \frac{x^2 + 1}{2x} dx$. Here we cannot let $u = x^2 + 1$, since $\frac{du}{dx}$ only shows up in the denominator of the problem, and then wouldn't cancel out with $dx$. In other words, we want to replace $\frac{du}{dx} dx$ by $du$. We can't replace $\frac{dx}{\frac{du}{dx}}$ by $du$.

**Exercises**: Find the following general antiderivatives:

1. $\int \tan(x) dx$. Hint: use $\tan(x) = \frac{\sin(x)}{\cos(x)}$.
2. $\int xe^{x^2} dx$. Hint: if you don't find $\frac{du}{dx}$ anywhere, but you find a constant multiple of $\frac{du}{dx}$, then can you figure out what $du$ would be in terms of $dx$? Maybe you need to multiply or divide by a constant.

<details>
    <summary>Check your answers</summary>
    <ol>
        <li>Let $u = \cos(x)$, and then $du = -\sin(x) dx$. Pull out the negative and we are integrating $-\int \frac{du}{u}$, which is $-\ln(\cos(x)) + C$. One of the rules for logarithms tells us that $-\ln(\cos(x)) = \ln(\sec(x))$, and so the final answer is usually written as $\ln(\sec(x)) + C$.</li>
        <li>Let $u = x^2$. Then $du = 2x dx$, or $\frac{du}{2} = x dx$. Since we are integrating $e^{x^2} \cdot (x dx)$, when we make our substitution we get $\int \frac{e^u}{2} du$, which is $\frac{1}{2}e^u + C$. Substituting back, our final answer is $\frac{1}{2} e^{x^2} + C$.</li>
    </ol>
</details>

Next time, we will look at using substitution with definite integrals.
