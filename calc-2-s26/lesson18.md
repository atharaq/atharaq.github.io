# Calculus II Lesson 18: Describing Sequences
{: .no_toc}

1. Table of Contents
{:toc}

# Presentations

* Schedule for next week?

# Questions

* Arc length in Polar
* Areas in polar
* Intro to sequences.
  * What are real numbers?

## Upcoming

* Presentations: continuing 3 classes.
* MyOpenMath 4 due tonight, written HW due Monday. Questions?
* Exam 3: 4/23 or 4/27.

# Describing Sequences

For the most part, last time we worked with **closed-form expressions**, where a formula describes each element of the sequence, just in terms of $n$. Finding such closed-form expressions is kind of an art form.

For example, consider the following sequence:

$$0, \frac{1}{2}, \frac{3}{4}, \frac{7}{8}, \frac{15}{16}, \ldots $$

It might not be obvious what the closed form expression for this sequence would be. It really just depends on how you look at the number. Here, I'd recommend starting with the denominators: 1, 2, 4, 8, 16. These are all powers of 2, so the denominator of the term $a_n$ can be expressed as $2^n$. Then notice that the numerator is just 1 less than that, and so $a_n = \frac{2^n - 1}{2^n}$.

This can help us find the limits of such a sequence: perhaps, eyeballing it, we can tell that this sequence converges to 1, but how might we be sure? We can compute the limit of $\frac{2^n - 1}{2^n}$. To do this, notice that we can separate this fraction out to $1 - \frac{1}{2^n}$, and so, as $n \rightarrow \infty$, this approaches $1 - 0$, or just $1$.

## Summary

* **Closed-form** expression: a formula which describes each element of a sequence.
* ie: $a_n = f(n)$
* Finding closed-form expressions: trial and error, play around, look for patterns.

## Closed Forms

Try to find closed form expressions for the following sequences:

<ul>
<li>1, 1, 2, 6, 24, 120, 720, $\ldots$</li>
<li class="fragment">1, 1, $\frac{1}{2}$, $\frac{1}{6}$, $\frac{1}{24}$, $\frac{1}{120}$, $\frac{1}{720}$, $\ldots$</li>
<li class="fragment">1, -1, $\frac{1}{2}$, $-\frac{1}{6}$, $\frac{1}{24}$, $-\frac{1}{120}$, $\frac{1}{720}$, $\ldots$
</ul>

## Even and Odd

<ul>
<li>Let $a_n$ be the sequence $\frac{1}{n!}$.</li>
<li class="fragment">"Even" parts of $a_n$: $1, \frac{1}{2}, \frac{1}{24}, \frac{1}{720}, \ldots$?</li>
<li class="fragment">"Odd" parts of $a_n$: $1, \frac{1}{6}, \frac{1}{120}, \ldots$?</li>
</ul>

## Exercise

Find a closed form expression for the following sequences:

* $1, \frac{1}{3}, \frac{1}{5}, \frac{1}{7}, \ldots$
* $1, -\frac{1}{3}, \frac{1}{5}, -\frac{1}{7}, \ldots$
* $-1, \frac{1}{3}, -\frac{1}{5}, \frac{1}{7}, \ldots$

# Recurrences

* Some sequences are hard to describe with a closed form.
* Ex: $1, 0, \frac{1}{2}, \frac{1}{4}, \frac{3}{8}, \frac{5}{16}, \ldots$

## Recurrences

* Describe recursively (or with a recurrence relation):
* $a_0 = 1$, $a_1 = 0$
* $a_n = \frac{a_{n-1} + a_{n-2}}{2}$
* What is $a_8$?

## Fibonacci

* $a_0 = 1$, $a_1 = 1$
* $a_n = a_{n-1} + a_{n-2}$
* First few terms: $1, 1, 2, 3, 5, 8, 13, \ldots$
* $\lim\limits_{n \rightarrow \infty} a_n = \infty$
* Ratios?
* $\frac{a_1}{a_0}, \frac{a_2}{a_1}, \frac{a_3}{a_2}, \ldots$?

## Limits

Suppose $\lim\limits_{n \rightarrow \infty} \frac{a_{n+1}}{a_n} = L$. Then notice:

* $a_{n+1} = a_n + a_{n-1}$
* $\frac{a_{n+1}}{a_n} = \frac{a_n + a_{n-1}}{a_n} = 1 + \frac{a_{n-1}}{a_n}$
* As $n \rightarrow \infty$: $1 + \frac{1}{L} = L$
* Solve: $L^2 = L + 1$.
* $L = \frac{1 \pm \sqrt{5}}{2}$
* $\phi = \frac{1 + \sqrt{5}}{2}$ is the "golden ratio"!

# Continuity

Recall: $f$ continuous at $x = a$ if $a$ is in the domain of $f$, and

$$\lim_{x \rightarrow a} f(x) = f(a)$$

(Draw example graph)

## Theorem

Suppose $a$ is in the domain of $f(x)$. Then $f$ is continuous at $x = a$ *if and only if* whenever $(a_n)$ is a sequence such that each $a_n$ is in the domain of $f$, and

$$\lim_{n \rightarrow \infty} a_n = a$$

then

$$\lim_{n \rightarrow \infty} f(a_n) = f(a)$$

## In other words

"$f$ is continuous" means:

$$f(\lim_{n \rightarrow \infty} a_n) = \lim_{n \rightarrow \infty} f(a_n)$$

* More than just "left hand and right hand" limits coincide.
* Can approach $x = a$ in many ways!
* Note: Keep this in mind in Calc 3.
* (Draw out the plane)

# Kinds of sequences

**Exercise**: Find the next two terms of each of these sequences:

1. 0, 2, 4, 6, 8, ...
2. 25, 29, 33, 37, ...
3. 1, -2, -5, -8, -11, ...

What do these sequences have in common?

## Arithmetic Sequences

* Differences between consecutive terms is constant.
* Closed form for arithmetic sequences: **linear**.
* If $a_0$ is the first term, $d$ is the "common difference", then $a_n = a_0 + d \cdot n$.
* Compare to $y = mx + b$ (linear function)

## Examples

Closed forms for:

1. 0, 2, 4, 6, 8, ...:
2. 25, 29, 33, 37, ...:
3. 1, -2, -5, -8, -11, ...:

<details>
<summary>Answers:</summary>
<ol>
<li> $a_n = 2n$</li>
<li>$b_n = 25 + 4n$</li>
<li>$c_n = 1 - 3n$</li>
</ol>
</details>

## Limits

If $a_n$ is an arithmetic sequence, then $\lim\limits_{n \rightarrow \infty} a_n = \pm \infty$. Why?

* Similarly: $y = mx + b$. $m > 0$? $\lim\limits_{x\rightarrow \infty}$?
* $m < 0$? Limit?

## More sequences

* 1, 2, 4, 8, 16, ...
* 1, $\frac{1}{3}$, $\frac{1}{9}$, $\frac{1}{27}$, ...
* $\frac{9}{10}, \frac{9}{100}, \frac{9}{1000}, \ldots$

## Geometric sequences

* *Ratios* between successive terms is constant.
* Closed form: $a_n = a_0 \cdot r^n$, where $r$ is the "common ratio".
* Example: $\frac{9}{10}, \frac{9}{100}, \frac{9}{1000}, \ldots$ ?

## Exercise

Come up with examples of geometric sequences with the following properties:

* $r = 1$
* $r = -1$
* $|r| > 1$
* $0 < r < 1$

In each case, what is $\lim\limits_{n \rightarrow \infty} a_n$?

# Next week

* Series ("Infinite sums")
* Adding up all the terms of an infinite sequence
* Zeno's Paradox: "Motion is Impossible"
* $0.99999\ldots$
