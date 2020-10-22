# Discrete Mathematics Lesson 12: Modular Multiplication, and Intro to Binary
{:.no_toc}

1. Table of Contents
{:toc}

Last time we started studying modular arithmetic. We saw that checking congruences modulo $n$ addition really requires only knowing the addition table for the numbers $0, \ldots, n - 1$ modulo $n$.

Follow along the video for today's lesson here:

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/F64s9p-jr7E" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Multiplication

**Theorem**: Let $n \in \mathbb{N}$, $n > 1$, and $a, b, x, y \in \mathbb{Z}$. If $a \equiv x$ (mod $n$) and $b \equiv y$ (mod $n$), then $ab \equiv xy$ (mod $n$).

**Proof**: Assume $n$ divides $a - x$ and $n$ divides $b - y$. This means there are $k, m$ such that $a - x = kn$ and $b - y = mn$. So $a = x + kn$ and $b = y + mn$. Therefore $ab = (x + kn)(y + mn)$. Distributing, we get $ab = xy + xmn + kny + kmn^2$. Subtracting $xy$ from both sides, we get $ab - xy = xmn + kny + kmn^2$. Since $n$ is a factor of each of the terms on the right, we can factor out $n$ and see $ab - xy = n(xm + ky + kmn)$. That is, $n \mid (ab - xy)$, and so $ab \equiv xy$ (mod $n$).

## Examples

We can use this result to help us simplify modular multiplication problems. For example, what is $23 \times 37$ **mod** 10? Since $23 \equiv 3$ (mod 10) and $37 \equiv 7$ (mod 10), $23 \times 37 \equiv 3 \times 7$ (mod 10), which is 21. 21 **mod** 10 = 1, and so $23 \times 37$ **mod** 10 = 1.

**Exercises**: Use this strategy of "reducing modulo $n$" to compute the following:

1. $101 \times 101$ **mod** 100
2. $287 \times 36$ **mod** 3
3. $353 \times 128$ **mod** 5

## Negatives

Personally, I sometimes find it easier to use certain negative integers in evaluating modular arithmetic expressions rather than large positive ones. For example, for any $n$, $n - 1 \equiv -1$ (mod $n$). So, $35 \times 5 \equiv (-1 \times 5)$ (mod 36), which is further congruent to -5 modulo 36. But $-5 \equiv 31$ (mod 36).

In general: for any $k, n$, $n - k \equiv (-k)$ (mod $n$). Use this to your advantage!

**Exercise**: Prove that, for any $n > 1$ and any positive integer $k$, $(n-1)^{2k} \equiv 1$ (mod $n$).

(There are two ways to prove this: algebraically, by computing $(n-1)^2, or using the hint above about negative numbers.)

## Multiplication Tables

Similar to addition tables, the main theorem shows that for any $n$, we only need to know the multiplication tables for $0, \ldots, n - 1$ modulo $n$, in order to describe everything there is to say about multiplication modulo $n$.

**Example**: Let's look at the multiplication table modulo $4$:

$$
\begin{array}{c|c|c|c|c}
\cdot & 0 & 1 & 2 & 3 \\
\hline
0 & 0 & 0 & 0 & 0 \\
1 & 0 & 1 & 2 & 3 \\
2 & 0 & 2 & 0 & 2 \\
3 & 0 & 3 & 2 & 1
\end{array}
$$

**Exercise**: Write down the multiplication table module $5$.

## Inverses

Notice that for the multiplication table modulo 4, 2 does not have a multiplicative inverse! That is, there is no number $x$ such that $2x \equiv 1$ (mod 4). This means that, mod 4, not all "equations" can be solved. That is:

* For every integer $y$, the congruence $3x \equiv y$ (mod 4) has a solution. This solution is given by $x = 3y$, because $3 \times 3y \equiv (3 \times 3) \times y \equiv 1y$ (mod 4).
* But there are integers $y$ such that $2x \equiv y$ (mod 4) has no solutions. In particular, $2x \equiv 3$ (mod 4) has no solution.

This leads us to the natural question: if we are given a congruence of the form $ax \equiv b$ (mod $n$), how can we tell, in terms of $a, b$ and $n$, whether there is a solution? It turns out that there is always a solution (no matter what $b$ is) if $a$ has a multiplicative inverse modulo $n$. THat is, if there is $x$ such that $ax \equiv 1$ (mod $n$).

**Definition**: Let $a$ and $b$ be integers.
1. The greatest common divisor of $a$ and $b$, denoted gcd($a$, $b$), is the largest integer $k$ such that $k \mid a$ and $k \mid b$.
2. $a$ and $b$ are called *relatively prime* if gcd($a$, $b$) = 1.

If you're interested: the Euclidean algorithm is an efficient algorithm for computing the gcd of two integers. This might be something you can present in a problem presentation.

This next theorem helps us answer the question of when a number has an inverse mod $n$.

**Theorem**: Let $n > 1$ and $a \in \mathbb{Z}$. If $a$ and $n$ are relatively prime then $a$ has a multiplicative inverse modulo $n$. That is, there is $x$ such that $ax \equiv 1$ (mod $n$).

I will skip the proof of this one.

**Examples**:

Let $n = 10$. Then the $2, 4, 5, 6,$ and $8$ share factors with $10$. Those numbers do not have multiplicative inverses. But all the others do!

* If $a = 1$: this is easy! 1 is its own inverse.
* If $a = 3$: $3 \times 7 = 21 \equiv 1$ (mod 10), and so $3$ and $7$ are inverses of each other.
* If $a = 7$: we just saw 3 and 7 are inverses of each other.
* If $a = 9$: 9 is its own inverse as well. See [the exercise in the "Negatives" section](#negatives).

**Exercise**: Let $n = 12$. Which numbers are relatively prime to $n$? For each of these numbers, find their inverses.

# Equivalence Relations

This section is a preview of an important kind of mathematical structure we will see later on: equivalence relations.

Recall that a relation is a set of ordered pairs. Equivalence relations are sets of ordered pairs that are reflexive, symmetric, and transitive. What do these mean?

"Reflexive":

* For any $n > 1$, and any $x$, $x \equiv x$ (mod $n$).

For example, $5 \equiv 5$ (mod 10). Is this obvious? Think about what this means: congruence modulo 10 means that 10 divides the difference $5 - 5$. This is actually just saying that 10 is a factor of 0. This is true: $0 = 10 \times 0$, and so $0$ is a multiple of 10 (or, 10 divides 0)!

"Symmetric":

* For any $n > 1$, and any $x$ and $y$, if $x \equiv y$ (mod $n$) then $y \equiv x$ (mod $n$).

For example: $3 \equiv 1$ (mod 2), because $2 \mid (3 - 1)$. This is because $3 - 1 = 2 \times 1$. But $1 - 3 = 2 \times (-1)$, so $2 \mid (1 - 3)$ also! That is, $1 \equiv 3$ (mod 2) is also true.

Another example: $27 \equiv 21$ (mod 3), because $27 - 21 = 3 \times 2$. But $21 - 27 = 3 \times (-2)$, so $3 \mid (21 - 27)$, which means $21 \equiv 27$ (mod 3).

In other words: $x \equiv y$ (mod $n$) means that there is an integer $k$ such that $x - y = nk$. What can you then conclude about $y - x$?

"Transitive":

* For any $n > 1$, and any $x, y,$ and $z$, if $x \equiv y$ (mod $n$) and $y \equiv z$ (mod $n$), then $x \equiv z$ (mod $n$).

Example: $31 \equiv 16$ (mod 5) and $16 \equiv 11$ (mod 5) because $31 - 16 = 5 \times 3$, and $16 - 11 = 5 \times 1$. And lastly $31 \equiv 11$ (mod 5) because $31 - 11 = 5 \times 4$. Notice: $31 - 11 = (31 - 16) + (16 - 11)$, which is $5 \times 3 + 5 \times 1$. Do you see how you might generalize this?

# Base Systems / Binary (Base 2)

The usual, decimal number system is the "base 10" number system. Numbers are expressed in terms of powers of 10: the number 3125 refers to the number $3 \times 10^3 + 1 \times 10^2 + 2 \times 10^1 + 5 \times 10^0$. We need the 10 symbols of 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9, and all numbers can be represented using this decimal number system. These symbols are, of course, referred to as **digits**. But, this is important: **there is absolutely nothing special about the number 10**.

In a computer, numbers are represented using electrical states of either "on" or "off". These two states can be represented with the symbols 0 and 1: and so computers can represent numbers in a "base 2" system. We call this the **binary number system**. The symbols 0 and 1 are referred to as **bits**, which means "binary digits".

Similar to the decimal system, numbers in binary are expressed in terms of powers of 2: the number 101101 refers to the number $1 \times 2^5 + 0 \times 2^4 + 1 \times 2^3 + 1 \times 2^2 + 0 \times 2^1 + 1 \times 2^0$, which is 45 in the decimal system.

We will work, next time, on algorithms for converting from decimal to binary, as well converting between these and other bases (base 8, octal, and base 16, hexadecimal, are also handy to know). For now, though, practice converting from binary to decimal:

**Examples**:

* The number 11, in binary, equals 3 in decimal.
* 100, in binary, equals 4 in decimal.
* 111, in binary, equals 7 in decimal. (Why? $111 = 1 \times 4 + 1 \times 2 + 1 \times 1$)
* 1000, in binary, equals 8 in decimal.
* 1111, in binary, equals 15 in decimal: $1 \times 8 + 1 \times 4 + 1 \times 2 + 1 \times 1 = 15$.
* 10000 in binary equals 16 in decimal.

Notice a pattern? **Exercise**: Take a number whose binary representation is just a string of $n$ 1's (like 111, 1111, 11111). What happens when you add 1 to that number? Have we studied this problem before (check in 9)?
