# Calculus II Lesson 17: Areas and Arc Lengths of Polar Curves
{: .no_toc}

1. Table of Contents
{:toc}

# Arc Lengths of Polar Curves

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/ngRa92gU84g" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Last time, we discussed graphs of polar curves. In the video above, I go through the steps involved in deriving the formula for the arc length of a polar curve.

Follow along and take a look at the slides from last time:

* [Deriving the formula slide](https://atharaq.github.io/calc-2/lesson16.html#/arc-lengths)
* [Formula and example](https://atharaq.github.io/calc-2/lesson16.html#/polar-arc-length)

I go through the above example in the following video:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/ZPrD2xU9fpU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

As an exercise, find the arc length of the curve $r = 4 \sin(\theta)$ from $\theta = 0$ to $\theta = \pi$.

<details>
    <summary>Check your answer</summary>
    <p>First compute $r^\prime: 4\cos(\theta)$. Then square $r$ and $r^\prime$:

        $$(r^\prime)^2 + r^2 = 16(\cos^2(\theta)) + 16(\sin^2(\theta)) = 16$$
    </p>
    <p>Since $\sqrt{16} = 4$, we set up the integral:

        $$\int_0^{\pi} 4d\theta = \left. 4\theta\right|_0^\pi = 4\pi$$
    </p>
</details>

# Areas Bounded By Polar Curves

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/8tBMJnvln4M" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

In this part, we look at the formula for finding the area of a region bounded by a polar curve between two "rays". Follow along with the slides from last time:

* [We approximate areas with circular sectors](https://atharaq.github.io/calc-2/lesson16.html#/areas)
* [The area of a circular sector](https://atharaq.github.io/calc-2/lesson16.html#/circular-sectors)
* [Formula](https://atharaq.github.io/calc-2/lesson16.html#/formula)
* [Example](https://atharaq.github.io/calc-2/lesson16.html#/example)
* [Solution, part 1](https://atharaq.github.io/calc-2/lesson16.html#/example-1)
* [Solution, part 2](https://atharaq.github.io/calc-2/lesson16.html#/example-2)

# Intro to sequences

Our last unit for the semester is going to be on sequences and series. We briefly mentioned the concept at the beginning of the semester, when we talked about what real numbers like $\pi$ even mean. What does it mean for a number to "go on forever"?

## Review of limits

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/y13LQXPhca8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Before we talk about sequences, we should review the concepts of limits from Calculus I. Take a look at the video above, and try to write down your ideas of what the notions of "limit" mean:

$$\lim_{x \rightarrow a} f(x) = L$$

means that we can control how close to $L$ we make $f(x)$, just by making sure we look close enough to $x = a$.

Similarly, let's review the concept of the limit at infinity:

$$\lim_{x \rightarrow \infty} f(x) = L$$

means that we can control how close to $L$ we make $f(x)$ by making sure we look at *large enough* values of $x$.

## Definitions and examples

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/lkUlwRIjPQ4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Now that we've reviewed limits, what exactly are sequences? Sequences are lists of numbers. For example, the sequence $1, 3, 5, 7, \ldots$ is the list of all odd numbers in order.

Formally, the definition of a sequence is a function with domain $\mathbb{N} = \{ 0, 1, 2, \ldots \}$. So for example, the sequence above is given by the function $f(n) = 2n + 1$: $f(0) = 1$, $f(1) = 3$, $f(2) = 5$, etc. Usually, though, we don't use function notation to write sequences, we use "subscript" notation: $a_0, a_1, a_2, \ldots$

Since sequences are just functions, we can use the definitions of limits of functions given above. But the question is: do those definitions make sense, if the domains of our functions is the set of natural numbers $\{ 0, 1, 2, \ldots \}$?

In other words, if we have a sequence $\{ a_n : n \in \mathbb{N} \}$, can we define $\lim\limits_{n \rightarrow 5} a_n$? What would that even mean? Can $n$ get "closer and closer" to 5? Not really: the closest $n$ can get to 5 is just $n = 4$ or $n = 6$: there is nothing "closer" than that.

But we *can* talk about $\lim\limits_{n \rightarrow \infty} a_n$. This makes sense: the limit as $n \rightarrow \infty$ is equal to $L$ if the distances $\|a_n - L\|$ become arbitrarily small. The same definition for $\lim\limits_{x \rightarrow \infty} f(x)$ can be used for the definition of limits of sequences.

We say a sequence **converges** if it has a limit, and **diverges** if not.

For example, let $a_n = \frac{1}{n+1}$. This is the sequence $1, \frac{1}{2}, \frac{1}{3}, \ldots$ Hopefully it's not too hard to see that this sequence converges to $0$.

As another example, let $a_n = (-1)^n$. This is the sequence $1, -1, 1, -1, \ldots$ which does not converge (for the same reason that $\sin(x)$ does not have a limit at infinity).

## Closure properties

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/ICjgh8MIOM8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**Notation**:

1. By "sequence of real numbers", I mean a sequence $\{a_n\}_{n \in \mathbb{N}}$ such that each $a_n$ is a real number.
2. Similarly, I can talk about a "sequence of integers", a "sequence of rational numbers", etc.

We have seen that there are sequences of *positive* numbers that converge to a limit that is not positive (0): the sequence $1, \frac{1}{2}, \frac{1}{3}, \frac{1}{4}, \ldots \rightarrow 0$. This is somewhat surprising: we might think that if every number in our sequence has some property, then the limit should have that property too!

In other words, we might want to know: what properties of numbers are preserved by limits? One example of such a property is the property of being an integer:

**Theorem**: Every convergent sequence of integers converges to an integer.

(I won't prove this, but you can try to think about it.) In fact, it turns out that if a sequence of integers converges, then the sequence must eventually be constant. For example, if a sequence converges to 30, the numbers in the sequence cannot get "closer and closer" to 30 if they aren't decimals / fractions. The only way they can converge to 30 is if they are just all 30 at some point.

On the other hand, sequences of rational numbers can converge to irrational numbers -- we have seen this phenomenon before.

The number $\sqrt{2} \approx 1.41421 \ldots$ This can be approximated using the sequence given by the first $n$ digits of $\sqrt{2}$: $a_0 = 1$, $a_1 = 1.4$, $a_2 = 1.41$, etc.

This brings me back to something I asked at the beginning of the year: what even are real numbers? We know what rational numbers are (fractions), but what does it mean for a number to have infinitely many digits?

Instead of thinking about digits, we should think about real numbers as just those numbers which can be approached by sequences of rational numbers.

**Exercise**: For the following sets $X$ (each of which is an interval), is there a sequence of numbers in $X$ which converges to a limit **not** in $X$?

1. $X = [0, 1]$ (the closed interval containing the endpoints)
2. $X = (0, 1)$
3. $X = [1, \infty)$
4. $X = [1, 2)$

<details>
    <summary>Check your answer</summary>
    <ol>
        <li>No.</li>
        <li>Yes: the sequence $\frac{1}{2}, \frac{2}{3}, \frac{3}{4}, \ldots$ converges to 1.</li>
        <li>No.</li>
        <li>Yes: the seuqence $\frac{3}{2}, \frac{7}{4}, \frac{15}{8}, \frac{31}{16}, \ldots$ converges to 2</li>
    </ol>
    <p>The intuition is if an interval contains its boundary points, it is closed under limits of sequences.</p>
</details>

# Next time: describing sequences

For the most part, today, we have worked with **closed-form expressions**, where a formula describes each element of the sequence, just in terms of $n$. Finding such closed-form expressions is kind of an art form.

For example, consider the following sequence:

$$0, \frac{1}{2}, \frac{3}{4}, \frac{7}{8}, \frac{15}{16}, \ldots $$

It might not be obvious what the closed form expression for this sequence would be. It really just depends on how you look at the number. Here, I'd recommend starting with the denominators: 1, 2, 4, 8, 16. These are all powers of 2, so the denominator of the term $a_n$ can be expressed as $2^n$. Then notice that the numerator is just 1 less than that, and so $a_n = \frac{2^n - 1}{2^n}$.

This can help us find the limits of such a sequence: perhaps, eyeballing it, we can tell that this sequence converges to 1, but how might we be sure? We can compute the limit of $\frac{2^n - 1}{2^n}$. To do this, notice that we can separate this fraction out to $1 - \frac{1}{2^n}$, and so, as $n \rightarrow \infty$, this approaches $1 - 0$, or just $1$.

# Homework

Due **Friday, April 16** at 11:59 PM on Moodle:

7.3 #168, 170
7.4 #190, 192, 194, 220

There is an assignment on MyOpenMath due tomorrow and there will also be another MyOpenMath assignment due next Tuesday as well.
