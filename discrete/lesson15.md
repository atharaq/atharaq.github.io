# Discrete Mathematics Lesson 15: Big Oh, Big Theta, Recurrence Relations
{:.no_toc}

1. Table of Contents
{:toc}

# Big Oh / Big Theta

Recall: for functions $f : \mathbb{N} \to \mathbb{R}$ and $g : \mathbb{N} \to \mathbb{R}$, we say $f = O(f)$ ($f$ is "Big Oh" of $g$) if there is $N \in \mathbb{N}$ and $k \in \mathbb{R}$ such that for all $n \geq N$, $f(n) \leq k \cdot \|g(n)\|$. In symbols:

$$\exists N \in \mathbb{N} \exists k \in \mathbb{R} \forall n \in \mathbb{N} (n \geq N \rightarrow f(n) \leq k \cdot |g(n)|)$$

**Example**: Let $f(n) = an + b$, for some constants $a, b \in \mathbb{R}$. We show that $f(n)$ is $O(n^2)$, and $n^2$ is **not** $O(n)$:

**Proof**:

Since $n \geq 0$, we know that, for every $n \in \mathbb{N}$, $an + b \leq \|a\|n + \|b\|n = (\|a\| + \|b\|)n$. Let $k = \|a\| + \|b\|$.

Before we finish the proof, let's first show that for all $n \in \mathbb{N}$, $n \leq n^2$. An important property of the ordering ($<$ and $>$) of real numbers is that for all $a, b, c$, if $c > 0$ and $a < b$, then $ac < bc$. If $n = 0$ or $n = 1$, we see that $n = n^2$. If $n > 1$, letting $a = 1, b = n$ and $c = n$ from the ordering property above shows that $n < n^2$.

Now continue the proof we started above. Since $n \leq n^2$ for every $n \in \mathbb{N}$ and $k \geq 0$, we have $kn \leq kn^2$, and therefore $an + b \leq kn \leq kn^2$ for every $n$ \in \mathbb{N}$. Therefore, $N = 0$ and the $k$ we found above work to show that $an + b \leq k n^2$ for all $n \geq N$.

Now we show that $n^2$ is **not** $O(n)$. Recall how to negate quantifiers: we want to show that the following statement is false: $$\exists N \in \mathbb{N} \exists k \in \mathbb{R} \forall n \in \mathbb{N} (n \geq N \rightarrow n^2 \leq kn)$$

That means that we want to show its negation is true. Negating quantifiers and conditionals is tricky, but we should end up with the following statement that we want to prove: $$\forall N \in \mathbb{N} \forall k \in \mathbb{R} \exists n \in \mathbb{N} (n \geq N \wedge n^2 > kn)$$

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

First notice that if $an + b \geq 0$ for all $n \in \mathbb{N}$, then $a, b \geq 0$. This is obvious for $b$, since plugging in $n = 0$ would show that $b \geq 0$. If $a < 0$ then letting $n > -\dfrac{b}{a}$ would give $an + b < 0$, which contradicts our assumption. So we can assume that $a, b \geq 0$.

Next, since $b < bn$ for all $n > 1$, $an + b \leq an + bn$ for all $n > 1$. Therefore $an + b \leq (a + b)n$ for all $n > 1$. Let $k_1 = a + b$ and $N_1 = 2$, and conclude that for all $n \geq N_1$, $an + b \leq k_1 n$.

For the other direction, let $k_2$ be such that $k_2a \geq 1$. Because $a \geq 0$, we must have that $k_2 \geq 0$. Therefore $k_2 (an + b) \geq n + k_2 b \geq n$ for all $n \in \mathbb{N}$, since $k_2 \geq 0$ and $b \geq 0$. Let $N_2 = 0$ and conclude that for all $n \geq N_2$, $n \leq k_2(an + b)$.

# Recurrence Relations

A **sequence** is some ordered list: usually an ordered list of numbers. A sequence can be finite or infinite, though often we will focus on infinite sequences. Technically, a sequence is a certain kind of function, as per the following definition:

**Definition**: A **sequence** is a function with domain $\mathbb{N}$ or $\{ 0, 1, \ldots, n \}$ for some $n \in \mathbb{N}$.

We will follow [notation used in the textbook](http://discrete.openmathbooks.org/dmoi3/sec_seq_intro.html): $a_0, a_1, a_2, \ldots$ will denote the first few terms of a sequence, while $(a_n)_{n \in \mathbb{N}}$ denotes the entire sequence (described at once).

## Telescoping

## Iteration

## Characteristic Root
