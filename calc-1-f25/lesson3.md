# Calculus I Lesson 3: More on Limits
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

1. Graph $f(x) = \frac{x^3-1}{x^2-1}$. (Graphing calculator / [Desmos](https://www.desmos.com/calculator))
2. For the points where $f(x)$ is not defined, does the graph of $f$ appear to approach a particular (finite) value?
3. Use the distributive property to show $x^3 - 1 = (x-1)(x^2+x+1)$ and $x^2 - 1 = (x-1)(x+1)$.
4. Simplify $\frac{(x-1)(x^2+x+1)}{(x-1)(x+1)}$.

## Graph

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/rttwwnfnin?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

* Notice that ${\displaystyle \lim_{x \rightarrow 1}} f(x) = \frac{3}{2}$. But $f(1)$ is not defined?
* Whenever $x \neq 1$, $f(x) = \frac{x^2+x+1}{x+1}$. So, as $x \rightarrow 1$, $f(x) \rightarrow \frac{1+1+1}{1+1} = \frac{3}{2}$.
* What happens as $x \rightarrow -1$?
  * Numerator $\rightarrow -2$, denominator $\rightarrow 0$.
  * Nothing cancels.
  * Hence: asymptote! ($\frac{-2}{.000001}$ is a large negative number)

# Questions from DeltaMath?

# Recall

* ${\displaystyle\lim_{x\rightarrow a^-}} f(x)$ refers to the limit as $x \rightarrow a$ from the **left**.
* ${\displaystyle\lim_{x\rightarrow a^+}} f(x)$ refers to the limit as $x \rightarrow a$ from the **right**.
* If both of the above exist and are equal, then ${\displaystyle \lim_{x\rightarrow a}}f(x)$ exists, and is equal to them both.

# Computing Limits

3 ways to compute limits:

1. Direct substitution
2. Algebraic manipulation
3. Squeeze Theorem

Eventually: 4th way (l'Hôpital's rule). If you know that: don't use it yet.

## Direct Substitution

Easiest method. Works for "nicely behaved functions":

* Polynomials
* Rational functions, if the denominator is not 0
* sin, cos, tan (if defined)
* exponential, logarithmic functions (if defined)

These functions are *continuous*.

## Algebraic Manipulation

* Can we cancel something?
* Can we multiply by a **conjugate**?

In other words: can we make our function equivalent to one of the ones where we can use direct substitution, except possibly at one, isolated point? (Ex: warm-up)

(Later: squeeze theorem.)

## Exercise

Use algebraic manipulation to compute these limits:

* ${\displaystyle \lim_{x\rightarrow 2}} \frac{x^2-4x+4}{x^2-4}$
* ${\displaystyle \lim_{x\rightarrow 0}} \frac{x}{x^3}$

# Conjugates

${\displaystyle \lim_{x \rightarrow 4}}\frac{\sqrt{x} - 2}{x -4}$

Direct substitution? $\frac{2-2}{4-4}$ Indeterminate.

Use algebra: multiply by the **conjugate** of $\sqrt{x}-2$:

$$
\begin{align}
&(\frac{\sqrt{x}-2}{x-4})(\frac{\sqrt{x}+2}{\sqrt{x}+2}) \\
= &\frac{x-4}{(x-4)(\sqrt{x}+2)} \\
= &\frac{1}{\sqrt{x}+2}.
\end{align}
$$

So as $x \rightarrow 4$, $\frac{\sqrt{x}-2}{x-4} \rightarrow \frac{1}{4}$.

## Exercise

Compute ${\displaystyle \lim_{x\rightarrow 9}\frac{\sqrt{x}-3}{x-9}}$.

## Example

Compute ${\displaystyle \lim_{x\rightarrow 0}\frac{\sqrt{x+1}-1}{x}}$.

Direct substitution results in $\frac{0}{0}$. Indeterminate. So multiply by conjugate:

$$
\begin{align}
(\frac{\sqrt{x+1}-1}{x})(\frac{\sqrt{x+1}+1}{\sqrt{x+1}+1}) \\
= \frac{x+1-1}{x(\sqrt{x+1}+1)} \\
= \frac{x}{x(\sqrt{x+1}+1)} \\
= \frac{1}{\sqrt{x+1}+1}.
\end{align}
$$

As $x \rightarrow 0$, this expression $\rightarrow \frac{1}{2}$

# Wavy

Compute ${\displaystyle \lim_{x\rightarrow 0}} \sin(\frac{1}{x})$. What does this look like as $x \rightarrow 0$?

* Can pick small values of $x$: $\sin(\frac{1}{.00001})$?
* Smarter values of $x$ to use? I know what $\sin(\pi/2)$ is.
* What $x$ value is that, for $y = \sin(\frac{1}{x})$?

Use reciprocals of ones we know. So: $x = \frac{2}{\pi}$, $\frac{2}{99999\pi}$, etc.

## Graph

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/lxokjy0bdk?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

What is going on?

# Upcoming

* DeltaMath: Limits due **tonight**
* Textbook homework: due **Monday, 9/15**:
  * Section 1.4 #216
  * Section 2.2 #36, 38, 46, 48, 76
  * Section 2.3 #84, 96, 128
  * Write your answers **neatly on paper**, with **your name** and **Calc I HW 3** written on the top. **Staple all the pages together**! Bring this in to class on Monday!
  * We will go over some of these problems this Thursday! Be prepared to present some of your work / ask questions on problems you are confused on!
* DeltaMath: More Limits due **Thursday, 9/19**.
* Thursday: asynchronous lesson + small groups.
  * We can work through some of the homework problems (come prepared with questions about them!), DeltaMath, etc.
  * Can work through examples done in class or from the notes.
