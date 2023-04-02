# Discrete Mathematics Lesson 15: Big Oh, Big Theta, Recurrence Relations
{:.no_toc}

1. Table of Contents
{:toc}

# Recurrence Relations

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/QJkaFC16mUQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/6S3siXmw3Vk" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/UVKQ78FuEuc" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

# Upcoming

* Take-home exam 2 will be posted soon.
* Next set of presentations will be April 17 - 24. Perhaps just two days?