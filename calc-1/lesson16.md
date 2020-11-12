# Calculus I Lesson 16: Limits at Infinity
{:.no_toc}

1. Table of Contents
{:toc}

Before we start the main content of today's lesson, I wanted to share the following video about the fascinating story of the Honeycomb Conjecture, mentioned in the previous lesson:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/kxDEcODUEP0" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Now onto the main lesson:

# Limits at Infinity

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/akLxk16USSw" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Previously, when we studied limits, we looked at what happens as a function approaches a particular point. It's also important to understand the **end-behavior** of functions. This is also discussed using the language of limits:

$$\lim_{x \rightarrow \infty} f(x) = L$$

means that as $x$ gets larger, $f(x)$ gets closer and closer to $L$. For example, the function $f(x) = \dfrac{1}{x}$ approaches $0$ as $x \rightarrow \infty$:

<div class="desmos-container">
    <iframe src="https://www.desmos.com/calculator/jhjv7cc8mh?embed"  style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Notice that on the right, the function gets closer and closer to the $y$-axis. If $\lim\limits_{x \rightarrow \infty} f(x) = L$, then the line $y = L$ is a **horizontal asymptote** of the function $f(x)$. Similarly, we can look at $\lim\limits_{x \rightarrow -\infty} f(x)$, and if this has a limit, then there is also a horizontal asymptote of $f(x)$.

**Example**: Find $\lim\limits_{x \rightarrow \infty} \dfrac{2x + 1}{x}$.

Notice that $\dfrac{2x + 1}{x} = \dfrac{2x}{x} + \dfrac{1}{x}$, or $2 + \dfrac{1}{x}$. Therefore, as $x \rightarrow \infty$, $\dfrac{2x+1}{x} \rightarrow 2 + 0$, which is $2$.

**Example**: Find $\lim\limits_{x \rightarrow \infty} \dfrac{2x - 1}{3x - 2}$.

Here there is a trick: divide the numerator and denominator by $x$:

$$ \frac{2x - 1}{3x - 2} = \frac{ \frac{2x - 1}{x}}{\frac{3x - 2}{x}} = \frac{2 - \frac{1}{x}}{3-\frac{2}{x}}$$

So as $x \rightarrow \infty$, $\dfrac{2x - 1}{3x - 2} \rightarrow \frac{2 - 0}{3 - 0} = \frac{2}{3}$.

**Exercises**:

Find the following limits:

1. $\lim\limits_{x \rightarrow \infty} \dfrac{x - 1}{x^2 - 1}$. (Hint: factor)
2. $\lim\limits_{x \rightarrow \infty} \dfrac{x^2 + 1}{x^2 - 1}$. (Hint: divide the numerator and denominator by $x^2$.)
3. $\lim\limits_{x \rightarrow \infty} \dfrac{\sin(x)}{x^2}$.

<details>
    <summary>Check your answers</summary>
    <ol>
        <li>$\dfrac{x-1}{(x+1)(x-1)}=\dfrac{1}{x+1}$. As $x \rightarrow \infty$, this approaches 0.</li>
        <li>$\dfrac{x^2+1}{x^2 - 1} = \dfrac{1 + \frac{1}{x^2}}{1 - \frac{1}{x^2}}$. As $x \rightarrow \infty$, this appraoches $1$.</li>
        <li>Notice that $\|\sin(x)\| \leq 1$. That means, for every $x$, $-\frac{1}{x^2} \leq \frac{\sin(x)}{x^2} \leq \frac{1}{x^2}$. As $x \rightarrow 0$, $\frac{1}{x^2}$ and $-\frac{1}{x^2}$ both approach 0, and so the Squeeze Theorem implies that this function approaches 0 as well.</li>
    </ol>
</details>

Some other examples that should not be surprising:

* $\lim\limits_{x \rightarrow \infty} x^2 = \infty$, since, as we make $x$ larger, $x^2$ also gets larger.
* $\lim\limits_{x \rightarrow -\infty} x^2 = \infty$, since, as we make $x$ more negative, $x^2$ becomes a larger positive number.
* $\lim\limits_{x \rightarrow \infty} x^3 = \infty$, since, as $x$ gets larger, $x^3$ also gets larger.
* $\lim\limits_{x \rightarrow -\infty} x^3 = -\infty$, since, as $x$ gets more negative, $x^3$ becomes more negative.
* $\lim\limits_{x \rightarrow \infty} \cos(x)$ does not exist! Do you see why? The graph of $\cos(x)$ does not get closer to one specific number.


**Exercises**:

Find the following limits:

1. $\lim\limits_{x \rightarrow \infty} \cos(x^2)$.
2. $\lim\limits_{x \rightarrow \infty} e^{-x^2}$.

<details>
    <summary>Check your answers</summary>
    <ol>
        <li>DNE. Since $\cos$ oscillates between $-1$ and $1$, even as $x \rightarrow \infty$, $\cos(x^2)$ does not settle down to one particular number.</li>
        <li>0. Notice that as $x \rightarrow \infty$, $-x^2 \rightarrow -\infty$. So the exponent approaches $-\infty$. As $y \rightarrow -\infty$, $e^y \rightarrow 0$, so that means $e^{-x^2} \rightarrow 0$.</li>
    </ol>
</details>

For more practice, please look at Exercises 261-270 from [Section 4.6](https://openstax.org/books/calculus-volume-1/pages/4-6-limits-at-infinity-and-asymptotes).

# L'Hôpital's Rule

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/SXlb5WuHlPE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Sometimes, when evaluating limits at infinity, we end up with an expression looking like $\frac{\infty}{\infty}$, which we cannot evaluate. Some expressions of that form may end up approaching a finite limit, like $\frac{2x+1}{x - 1} \rightarrow 2$. Some may end up approaching infinity, like $\frac{x^2+1}{x + 2}$. Some may end up not existing at all!

$\frac{\infty}{\infty}$ is called an **indeterminate form** for this reason: the form of the limit does not determine the value. But there is something we can do in this case!

**Theorem** (L'Hôpital's Rule) Suppose $f$ and $g$ are differentiable functions, $\lim\limits_{x \rightarrow a} f(x) = \infty$, and $\lim\limits_{x \rightarrow a} g(x) = \infty$. Then

$$\lim_{x \rightarrow a} \frac{f(x)}{g(x)} = \lim_{x \rightarrow a} \frac{f^\prime(x)}{g^\prime(x)}$$

provided the right hand side exists or is $\pm \infty$. Note that this theorem applies in the case that $a = \pm \infty$ as well.

**A note of caution**: this is **not** the quotient rule! This just means to take the derivative of the numerator and the denominator, separately!

For example, as $x \rightarrow \infty$, both $\ln(x)$ and $x$ approach $\infty$. So,

$$\lim_{x \rightarrow \infty} \frac{\ln(x)}{x} = \lim_{x \rightarrow \infty} \frac{\frac{1}{x}}{1} = 0$$

**Exercises**:

Determine the following limits using l'Hôpital's rule:

1. $\lim\limits_{x \rightarrow \infty} \frac{x^2}{e^x}$
2. $\lim\limits_{x \rightarrow \infty} \frac{e^x}{x^3}$
3. $\lim\limits_{x \rightarrow \infty} \frac{e^x}{x^{100}}$

<details>
    <summary>Check your answers</summary>
    <ol>
        <li>Applying l'Hôpital's rule twice, we end up with $\frac{2}{e^x}$, which approaches $0$ as $x \rightarrow \infty$.</li>
        <li>Applying l'Hôpital's rule three times, we end up with $\frac{e^x}{6}$, which approaches $\infty$.</li>
        <li>Notice the pattern: applying l'Hôpital's rule over and over again, eventually the denominator will become a constant, and the numerator will still be $e^x$. $\frac{e^x}{k}$ approaches $\infty$ for any constant $k$.</li>
    </ol>
</details>

## Other Indeterminate Forms

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/y8gmBl0l2HI" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

There are several other indeterminate forms that l'Hôpital's rule may apply to:

* If $\lim\limits_{x \rightarrow a} f(x) = 0$ and $\lim\limits_{x \rightarrow a} g(x) = 0$, then $$\lim\limits_{x \rightarrow a} \frac{f(x)}{g(x)}$ is indeterminate. (0 / 0)
* If $\lim\limits_{x \rightarrow a} f(x) = 0$ and $$\lim\limits_{x \rightarrow a} g(x) = \infty$, then $$\lim\limits_{x \rightarrow a} f(x)g(x)$ is indeterminate. ($0 \cdot \infty$)
* Other indeterminate forms:
    * $\infty - \infty$
    * $\infty^0$
    * $0^{\infty}$
    * $1^{\infty}$

You can look at [Section 4.8](https://openstax.org/books/calculus-volume-1/pages/4-8-lhopitals-rule) in the textbook for more information on these other forms. But for now, I will only focus on the $\infty / \infty$, $0 / 0$ and $0 \cdot \infty$ forms. The $0 / 0$ case is very similar to $\infty / \infty$: take the derivative of the numerator and denominator, separately, and then check the limit again. So let's look at an example of a limit of the form $0 \cdot \infty$:

$$\lim_{x \rightarrow 0^+} x \ln(x)$$

Here it is good to know that l'Hôpital's rule can be used in the case of one-sided limits as well. But first, since we do not have a numerator and a denominator, we should instead turn this into a quotient: $x \ln(x) = \frac{\ln(x)}{1 / x}$, and now we can take the derivative of the numerator and denominator separately:

$$
\begin{align}
\lim_{x \rightarrow 0^+} x \ln(x) &= \lim_{x \rightarrow 0^+} \frac{1 / x}{-1 / x^2} \\
&= \lim_{x \rightarrow 0^+} \frac{-x^2}{x} \\
&= \lim_{x \rightarrow 0^+} -x = 0
\end{align}
$$

**Exercise**: Find $\lim\limits_{x \rightarrow \infty} x^2 e^{-x}$.

<details>
    <summary>Check your answer</summary>
    <p>First notice that as $x \rightarrow \infty$, $x^2 \rightarrow \infty$ and $e^{-x} \rightarrow 0$, so we can apply l'Hopital's rule.</p>
    <p>Re-write $x^2 e^{-x}$ as $\frac{x^2}{e^x}$, and then apply l'Hopital's rule twice. We end up with $\frac{2}{e^x}$, which approaches 0 as $x \rightarrow \infty$.</p>
</details>

Please make sure to look at the DeltaMath homework for today to help review this lesson!
