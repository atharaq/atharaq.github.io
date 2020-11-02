# Discrete Mathematics Lesson 15: Big Oh, Big Theta, Recurrence Relations
{:.no_toc}

1. Table of Contents
{:toc}

# Big Oh / Big Theta

Recall: for functions $f : \mathbb{N} \to \mathbb{R}$ and $g : \mathbb{N} \to \mathbb{R}$, we say $f = O(f)$ ($f$ is "Big Oh" of $g$) if there is $N \in \mathbb{N}$ and $k \in \mathbb{R}$ such that for all $n \geq N$, $f(n) \leq k \cdot \|g(n)\|$. In symbols:

$$\exists N \in \mathbb{N} \exists k \in \mathbb{R} \forall n \in \mathbb{N} (n \geq N \rightarrow f(n) \leq k \cdot |g(n)|)$$

**Example**: Let $f(n) = an + b$, for some constants $a, b \in \mathbb{R}$. Assume that $f(n) \geq 0$ for all $n \in \mathbb{N}$ (we can prove the statement more generally, but the assumption helps simplify the proof so we don't have to worry about absolute values). We show that $f(n)$ is $O(n^2)$, and $n^2$ is **not** $O(n)$:

**Proof**:

First, notice that if $an + b \geq 0$, then, letting $n = 0$, we conclude that $b \geq 0$. Further, if $a < 0$, then letting $n > -\dfrac{b}{a}$ would imply that $an + b < 0$, which contradicts our assumption. Therefore $a \geq 0$ as well.

Next, if $n \geq 1$, $b \leq bn$. Therefore $an + b \leq an + bn$, for every $n \in \mathbb{N}$ such that $n \geq 1$. Let $k = a + b$, and so $an + b \leq kn$, for every $n \in \mathbb{N}$.

Before we finish the proof, let's first show that for all $n \in \mathbb{N}$, $n \leq n^2$. An important property of the ordering ($<$ and $>$) of real numbers is that for all $a, b, c$, if $c > 0$ and $a < b$, then $ac < bc$. If $n = 0$ or $n = 1$, we see that $n = n^2$. If $n > 1$, letting $a = 1, b = n$ and $c = n$ from the ordering property above shows that $n < n^2$.

Now continue the proof we started above. Since $n \leq n^2$ for every $n \in \mathbb{N}$ and $k \geq 0$, we have $kn \leq kn^2$, and therefore $an + b \leq kn \leq kn^2$ for every $n \geq 1$. Therefore, $N = 1$ and the $k$ we found above work to show that $an + b \leq k n^2$ for all $n \geq N$.

Now we show that $n^2$ is **not** $O(n)$. Recall how to negate quantifiers: we want to show that the following statement is false:

$$\exists N \in \mathbb{N} \exists k \in \mathbb{R} \forall n \in \mathbb{N} (n \geq N \rightarrow n^2 \leq kn)$$

That means that we want to show its negation is true. Negating quantifiers and conditionals is tricky, but we should end up with the following statement that we want to prove:

$$\forall N \in \mathbb{N} \forall k \in \mathbb{R} \exists n \in \mathbb{N} (n \geq N \wedge n^2 > kn)$$

So let $N \in \mathbb{N}$ and $k \in \mathbb{R}$ be given. We want to find $n \in \mathbb{N}$ that is greater than $N$ such that $n^2 > kn$. If $k \leq 0$, we are done: any $n > N$ would work, since $n^2 > 0$ for all $n > 0$. So assume $k > 0$. If $n > k$, then $n^2 > kn$. So let $n$ be any natural number greater than the maximum of $k$ and $N$.

**Exercise**: Show that $n$ is **not** $O(\sqrt{n})$.

<details>
    <summary>Check your answer</summary>
    <p>Let $N \in \mathbb{N}, k \in \mathbb{R}$ be given. We want $n \geq N$ such that $n > k \sqrt{n}$. If $k \leq 0$, then any $n \geq 1$ will suffice. So we assume $k > 0$. Let $n$ be large enough such that $\sqrt{n} > k$. Then $n > k \sqrt{n}$, using the property that if $a < b$ and $c > 0$, then $ac < bc$. Therefore, letting $n$ be larger than the maximum of $N$ and $k$ proves the result.
    </p>
</details>

## Transitivity

Suppose $f$ is $O(g)$ and $g$ is $O(h)$. Must it be true that $f$ is $O(h)$? The answer is **yes**: Big Oh is transitive! I'll start the proof here, and let you finish the details on your own.

**Proof**: Suppose $f$ is $O(g)$. Then there are $N_1 \in \mathbb{N}$ and $k_1 \in \mathbb{R}$ such that for all $n \geq N$, $f(n) \leq k_1 \|g(n)\|$. Similarly, there are $N_2$ and $k_2$ such that for all $n \geq N_2$, $g(n) \leq k_2 \|h(n)\|$. ...

(Finish the proof of this on your own!)

## $\log(n)$ and $\sqrt{n}$

Last time we saw that $\log_2(n)$ is $O(\ln(n))$. Show that $\ln(n)$ is $O(\sqrt{n})$, and conclude, then, using transitivity, that $\log_2(n)$ is $O(\sqrt{n})$.

Hint: Use l'Hopital's rule to find the limit as $n \rightarrow \infty$ of $\dfrac{\ln{n}}{\sqrt(n)}$. Use the [theorem we proved last time](https://atharaq.github.io/discrete/lesson14.html#/connection-between-limits-and-big-oh) to conclude that $\ln(n)$ is $O(\sqrt{n})$. Then use transitivity.

<details>
    <summary>Check your solution.</summary>
    <p>By l'Hopital's rule,
        $$
        \begin{align}
        \lim_{n\rightarrow \infty} \frac{\ln{n}}{\sqrt{n}} &= \lim_{n \rightarrow \infty} \frac{n^{-1}}{.5n^{-.5}} \\
        &= \lim_{n\rightarrow \infty} \frac{2}{\sqrt{n}} \\
        &= 0
        \end{align}
        $$ By the theorem, this implies that $\ln(n)$ is $O(\sqrt{n})$. Since we already know that $\log_2(n)$ is $O(\ln(n))$ and that Big Oh is transitive, this implies $\log_2(n)$ is $O(\sqrt{n})$ also.
    </p>
</details>

In general, since for all base $b$, $\log_b(n)$ are all equivalent according to Big Oh (and in fact according to Big Theta), in computer science we usually just use $\log(n)$ to represent *any* logarithmic function. Usually, the base that matters most in CS applications is base 2, but if we need to use calculus it may be easier to use $\ln$, as we saw above.

## Degree one functions

Let $f(n) = an + b$ and $g(n) = cn + d$, for $a, b, c, d \in \mathbb{R}$ (some constants), with $a, c \neq 0$. Assume that $f(n) \geq 0$ and $g(n) \geq 0$ for all $n \in \mathbb{N}$ (this makes the proof simpler, so that we can ignore absolute values). Show that $f(n)$ is $\Theta(g(n))$.

**Proof**: We actually just show that for any $a, b \in \mathbb{R}$, if $an + b \geq 0$ for all $n \in \mathbb{N}$, then $an + b$ is $\Theta(n)$. Think about why this suffices to prove the statement above.

We find $N_1, N_2, k_1, k_2 \in \mathbb{R}$ such that for all $n \geq N_1$, $an + b \leq k_1 n$ and for all $n \geq N_2$, $n \leq k_2 (an + b)$.

As we saw before, if $an + b \geq 0$ for all $n \in \mathbb{N}$, then $a, b \geq 0$. Now, since $b < bn$ for all $n > 1$, $an + b \leq an + bn$ for all $n > 1$. Therefore $an + b \leq (a + b)n$ for all $n > 1$. Let $k_1 = a + b$ and $N_1 = 2$, and conclude that for all $n \geq N_1$, $an + b \leq k_1 n$.

For the other direction, let $k_2$ be such that $k_2a \geq 1$. Because $a \geq 0$, we must have that $k_2 \geq 0$. Therefore $k_2 (an + b) \geq n + k_2 b \geq n$ for all $n \in \mathbb{N}$, since $k_2 \geq 0$ and $b \geq 0$. Let $N_2 = 0$ and conclude that for all $n \geq N_2$, $n \leq k_2(an + b)$.

# Recurrence Relations

A **sequence** is some ordered list: usually an ordered list of numbers. A sequence can be finite or infinite, though often we will focus on infinite sequences. Technically, a sequence is a certain kind of function, as per the following definition:

**Definition**: A **sequence** is a function with domain $\mathbb{N}$ or $\\{ 0, 1, \ldots, n \\}$ for some $n \in \mathbb{N}$.

We will follow [notation used in the textbook](http://discrete.openmathbooks.org/dmoi3/sec_seq_intro.html): $a_0, a_1, a_2, \ldots$ will denote the first few terms of a sequence, while $(a_n)_{n \in \mathbb{N}}$ denotes the entire sequence (described at once). Please review the textbook sections on sequences: the relevant ones for us are [section 2.1](http://discrete.openmathbooks.org/dmoi3/sec_seq_intro.html), linked before, and [section 2.4 on recurrence relations](http://discrete.openmathbooks.org/dmoi3/sec_recurrence.html). The subscripts are referred to as *indices*.

Before moving on, take some time to go through [Example 2.1.1](http://discrete.openmathbooks.org/dmoi3/sec_seq_intro.html#Kex) from the textbook to get familiar with some sequences.

**Definition**: A **closed formula** for a sequence $(a_n)_{n \in \mathbb{N}}$ is a formula that depends on $n$ only (and not on previous terms).

**Definition**: A **recurrence relation** is an equation relating a term in a sequence to previous terms in that sequence. A **recursive definition** for a sequence consists of a recurrence relation and an initial condition.

In computer science, particularly when we study recursive algorithms, running times of algorithms can often be expressed using recurrence relations with initial conditions. Solving recurrence relations can be a challenge and so we will briefly look at some strategies here. This is a topic that might deserve more study if you are interested in studying analysis of algorithms.

The first thing you should do when confronted with a recurrence relation is plug in and determine the first few elements of the sequence. Then you might be able to spot a pattern (and if you're lucky, your intuition will be right and you can prove it by substituting in).

**Example**: Let $a_0 = 2$ and $a_n = 2a_{n-1} - 1$. The first few terms of this sequence are:

* $a_0 = 2$
* $a_1 = 3$
* $a_2 = 5$
* $a_3 = 9$
* $a_4 = 17$

If you look closely, this is one more than the following sequence of powers of 2: $1, 2, 4, 8, 16$. That is: it looks like $a_n = 2^n + 1$.

**Proof**: Notice that $a_0 = 2^0 + 1$. So our formula works for the base case.

Now plug in $a_n = 2^n + 1$ to our recurrence relation. We get: $2^n + 1 = 2 \times (2^{n-1} + 1) - 1$. The right side of this equation simplifies to $2^n + 2 - 1$, which is $2^n + 1$, and so the formula is correct for all $n$.

(Note: This is technically a proof by induction, though we didn't state it as such. Do you see why?)

## Telescoping

Sometimes adding terms together helps us find a closed form. Adding the terms of a sequence produces a **series**. A **telescoping series** is a series where most terms cancel out. For example, if our recursive definition of a sequence is given by $a_n = a_{n-1} + 1$ with $a_0 = 10$, we can rearrange this to see that $a_n - a_{n-1} = 1$. That means:

* $a_1 - a_0 = 1$
* $a_2 - a_1 = 1$
* $a_3 - a_2 = 1$
* $\ldots$
* $a_n - a_{n-1} = 1$

When we add all of these together, the sum *telescopes*. That is, intermediate terms cancel, and we are left with $a_n - a_0 = 1 + 1 + 1 + \ldots + 1$ ($n$ times).

Since we know $a_0 = 10$ and we know $a_n - a_0 = n$, we have a closed form for $a_n$: $a_n = n + 10$. This is a fairly simple example, but it gives us the idea that telescoping can be a powerful method. Let's use it to solve the following recurrence relation, given in [Exercise 3](http://discrete.openmathbooks.org/dmoi3/sec_recurrence.html#bQc) of section 2.4:

**Example**: Solve the recurrence relation $a_n = a_{n-1} + 2^n$, with $a_0 = 5$.

Before we solve it, let's get a feel for consecutive differences:

* $a_1 - a_0 = 2$
* $a_2 - a_1 = 4$
* $a_3 - a_2 = 8$
* More generally, $a_n - a_{n-1} = 2^n$.

Adding these together and telescoping we get $a_n - a_0 = 2 + 4 + \ldots + 2^n$. Since we know, from check-in 9, that $1 + 2 + 4 + \ldots + 2^n = 2^{n+1} - 1$, we have $a_n - a_0 = 2^{n+1} - 2$. Since $a_0 = 5$, our solution is $a_n = 2^{n+1} + 3$.

**Exercise**: Solve the recurrence relation $a_n = a_{n-1} + (2n - 1)$, with $a_0 = 1$.

<details>
    <summary>Check your answer:</summary>
    <p>Let's check the first few terms of the sequence: $a_0 = 1$, $a_1 = 2$, $a_2 = 5$, $a_3 = 10$, etc.</p>
    <p>The first few consecutive differences we get are $a_1 - a_0 = 1$, $a_2 - a_1 = 3$, $a_3 - a_2 = 5$, etc. So $a_n - a_{0}$ is the sum $1 + 3 + \ldots + (2n - 1)$.</p>
    <p>In Problem Set 4, we saw that $1 + 3 + \ldots + (2n - 1) + (2n + 1) = (n+1)^2$. This is one fewer term in the sum, and so the sum would be $n^2$.</p>
    <p>Therefore, $a_n - a_0 = n^2$, and since $a_0 = 1$, $a_n = n^2 + 1$.</p>
</details>

## Characteristic Root

There is a powerful, algebraic method we can use to solve certain types of recurrence relations: *linear homogeneous recurrence relations with constant coefficients*.

**Definition**: A **linear homogeneous recurrence relations with constant coefficients** is a recurrence relation of the form

$$a_n = c_1 a_{n-1} + c_2 a_{n-2} + \ldots + c_k a_{n-k}$$

where $k \geq 1$, $c_1, \ldots, c_k \in \mathbb{R}$ are constants and $c_k \neq 0$. $k$ is called the **degree** of the recurrence relation.

For such a relation to have a unique solution, the initial condition needs to specify values for $a_0, a_1, \ldots, a_{k-1}$: notice that in that case, you can use the recurrence relation to then define $a_k$, and then use $a_1, \ldots, a_k$ to define $a_{k+1}$, and continue on.

A note on terminology: the words *linear* and *homogeneous* come from linear algebra: the $n$-th term of a sequence of this form can be found by looking at a particular $k \times k$ matrix. We won't get into this here, but the linear algebra involved allows us to find closed forms for these kinds of sequences easily. The idea is that, using linear algebra, you can prove that solutions must be sums of constant multiples of sequences of the form $a_n = r^n$, for some constant base $r$.

I will describe the technique for $k = 2$, but the technique can be studied in more generality. Let's consider the famous "Fibonacci" example: $a_n = a_{n-1} + a_{n-2}$, with the initial condition $a_0 = 0$ and $a_1 = 1$.

Let's assume that our solution would have the form $a_n = r^n$. Then, plugging in, we get $r^n = r^{n-1} + r^{n-2}$. Subtracting and factoring, we get $r^{n-2} (r^2 - r - 1) = 0$. The equation $r^2 - r - 1 = 0$ is called the **characteristic equation** of the recurrence relation. Its roots are called the **characteristic roots**. We find them using the quadratic formula:

$$r = \frac{1 \pm \sqrt{5}}{2}$$

Now what do we do? There is a theorem, which we will state for just degree 2 recurrence relations (but there is an analogue in general):

**Theorem**: Suppose $a_n = c_1 a_{n-1} + c_2 a_{n-2}$ is a recurrence relation. Its characteristic equation is $r^2 - c_1 r - c_2 = 0$. If this equation has two **distinct** roots $r_1 \neq r_2$, then the recurrence relation has a closed form $a_n = a r_1^n + b r_2^n$, where $a, b$ are constants determined by the initial conditions on $a_0$ and $a_1$.

In our case, that means we have $r_1 = \dfrac{1 - \sqrt{5}}{2}$ and $r_2 = \dfrac{1+\sqrt{5}}{2}$ as our two distinct roots, and so $a_n = a\cdot r_1^n + b \cdot r_2^n$. To find $a$ and $b$, let's use some algebra using the intial conditions $a_0 = 0$ and $a_1 = 1$. Plugging in $n = 0$ gives us $a + b = 0$, or $a = - b$. Plugging in $n = 1$:

$$
\begin{align}
a \cdot \frac{1-\sqrt{5}}{2} + b \cdot \frac{1+\sqrt{5}}{2} &= 1 \\
a \cdot \frac{1 - \sqrt{5}}{2} - a \cdot \frac{1 + \sqrt{5}}{2} &= 1 \\
a \cdot (-\sqrt{5}) &= 1
\end{align}
$$

So $a = -\frac{1}{\sqrt{5}}$ and $b = \frac{1}{\sqrt{5}}$. Therefore our solution is $a_n = -\frac{1}{\sqrt{5}} \cdot r_1^n + \frac{1}{\sqrt{5}} r_2^n$, where $r_1$ and $r_2$ are the two solutions to the characteristic equation above.

**Exercise**: Use the characteristic root method to find a closed formula for the recurrence relation $a_n = a_{n-1} + 2a_{n-2}$, with initial conditions $a_0 = 0$ and $a_1 = 2$.

<details>
<summary>Check your answer (full solution not provided)</summary>
<p>$a_n = \frac{2}{3} \cdot 2^n + (-\frac{2}{3}) \cdot (-1)^n$</p>
<p>Before moving on from this problem, notice: every element of this sequence is an integer. Why is that?</p>
<p>Do a little bit of algebra and you get $a_n = \frac{2}{3}(2^n - (-1)^n)$. Saying that, for every $n$, this is always an integer, is saying that if $n$ is even, then $2^n - 1 \equiv 0$ (mod 3), and if $n$ is odd, then $2^n + 1 \equiv 0$ (mod 3). Can you prove this?</p>
</details>
