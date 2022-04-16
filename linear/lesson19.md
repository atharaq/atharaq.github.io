# Linear Lesson 19: Bases, Matrix Representations
{:.no_toc}

1. Table of Contents
{:toc}

# Take Home Exam Questions

Reminder: take home exam due **Thursday**.

# Set Theoretic Notation

One of the major issues I am noticing is that students are unable to read set-theoretic notation properly.

If $X = \\{ x : $ some property $P$ about $x$ holds $\\}$, and we want to prove something about the elements of $X$, we start: "Let $x \in X$. Then we know that $x$ has property $P$." So for example: if $K = \\{ v \in V: T(v) = \vec{0} \\}$, and we want to prove something about $K$, we start: "Let $v \in K$. Then $T(v) = \vec{0}$."

**Question**: Consider the vector space $V = \mathbb{R}^2$. Is the set $D = \\{ \binom{x}{y} : x^2 + y^2 < 1 \\}$ a subspace of $V$?

How might we approach this?

# Review of Bases

Recall: if $V$ is a finite dimensional vector space, a **basis** is a linearly independent spanning set. I will state some results that were in my notes on "Bases and Dimension":

## Some Results

For all of the following results, we assume that $V$ is a finite dimensional vector space and all of the vectors mentioned are in $V$.

(1) **Theorem**: If $\\{ v_1, \ldots, v_n \\}$ is a linearly independent set and $\\{ w_1, \ldots, w_m \\}$ is a spanning set, then $n \leq m$.

For example: in $\mathbb{R}^2$, the set $\\{ \binom{1}{0}, \binom{1}{1} \\}$ is linearly independent (how would we show this?) and $S = \\{ \binom{1}{0}, \binom{0}{1}, \binom{2}{2} \\}$ spans $\mathbb{R}^2$. Of course, $2 \leq 3$. Moreover, $S$ is not linearly independent. Why not?

(The power of this theorem is when we deal with abstract vector spaces whose dimension we don't know ahead of time.)

(2) **Theorem**: If $B_1$ and $B_2$ are two basis sets, then $\|B_1\| = \|B_2 \|$. That is, every basis has the same size.

The idea to prove this is that is to use (1): since $B_1$ is linearly independent and $B_2$ spans $V$, then $\|B_1\| \leq \|B_2\|$. But also, $B_1$ spans $V$ and $B_2$ is linearly independent, so $\|B_2\| \leq \|B_1\|$!

Again, the upshot is that all basis sets have the same size. So we **define** the dimension of $V$, $\dim(V)$, to be the size of any basis set. Moreover:

(3) **Every** linearly independent set of the *right size* is a basis set.

Let's look at $\mathbb{R}^2$ again, with the standard basis $\\{ \binom{1}{0}, \binom{0}{1} \\}$. That means $\dim(\mathbb{R}^2) = 2$. Consider the set $S = \\{ \binom{1}{1}, \binom{2}{3} \\}$. We will not prove (3), but we can use it to show that $S$ is a basis set. How?

Clearly $S$ has the right size (2). This result means we just need to show that it's linearly independent. How do we do that? Set up a system of equations:

$$
a \cdot \binom{1}{1} + b \cdot \binom{2}{3} = \binom{0}{0}
$$

If you solve this, you get $a = 0$ and $b = 0$, and so the **only** linear combination of $\binom{1}{1}$ and $\binom{2}{3}$ that makes $\binom{0}{0}$ is $0 \cdot \binom{1}{1} + 0 \cdot \binom{2}{3}$. Therefore these vectors are independent.

This means that $S$ **must** span $\mathbb{R}^2$. In other words:

* $\binom{1}{0} \in Span(\binom{1}{1}, \binom{2}{3})$, and
* $\binom{0}{1} \in Span(\binom{1}{1}, \binom{2}{3})$.

We can see this directly:

* $\binom{1}{0} = 3 \binom{1}{1} - 1 \binom{2}{3}$,
* $\binom{0}{1} = -2 \binom{1}{1} + 1 \binom{2}{3}$.

Since every vector in $\mathbb{R}^2$ can be expressed as a linear combination of $\binom{1}{0}$ and $\binom{0}{1}$, using these equations to express these in terms of $\binom{1}{1}$ and $\binom{2}{3}$ we can change our "coordinate basis" to express every vector in terms of $\binom{1}{1}$ and $\binom{2}{3}$! We will see this later on when we talk about "change of basis matrices".

(4) **Every** linearly independent set can be extended to a basis.

Remember, we already know that if $\dim(V) = n$ and $S$ is a linearly independent set, then $\|S\| \leq n$. If it's equal to $n$, then it's a basis set: that was (3). If it's less than $n$, then you can extend it to a basis. How? Let's look at an example.

Consider $V = \mathcal{P}_2$, the vector space of polynomials of degree $\leq 2$. A basis for this vector space is $B = \\{ 1, x, x^2 \\}$: every polynomial of the form $ax^2 + bx + c$ can be written as a linear combination of those three; and they're independent.

Consider the set $S = \\{ x + 1, x + 2 \\}$. It's not hard to see that these are independent (check this yourself!). How do we extend this to a basis? Check to see which, if any, of the elements of $B$ are missing from the span of $S$!

* $1: We can write $1$ as $1 \cdot (x + 2) - 1 \cdot (x + 1)$, so $1 \in Span(S)$.
* $x$: We can write $x$ as $2 \cdot (x + 1) - 1 \cdot (x + 2)$, so $x \in Span(S)$.
* $x^2$: $a \cdot (x + 1) + b \cdot (x + 2) = (a + b)x + (a + 2b)$. This is never going to be a quadratic, so $x^2$ is not in the span!

Therefore, the set $\\{ x + 1, x + 2, x^2 \\}$ is linearly independent! (Think about why this process works.) And it has size 3, so it's a basis!

(5) Given a basis $v_1, \ldots, v_n$ and a vector $v$, there is a *unique* way to write $v$ as a linear combination of $v_1, \ldots, v_n$. Moreover, if $v = a_1 v_1 + \ldots + a_n v_n$, we say that the "coordinate vector" $\begin{pmatrix} a_1 \\\ a_2 \\\ \vdots \\\ a_n \end{pmatrix}$ *represents* the vector $v$.

For example, if $V = \mathbb{R}^2$ with basis $v_1 = \binom{1}{1}$ and $v_2 = \binom{2}{3}$, and $v = 3\binom{1}{1} - \binom{2}{3}$, then the coordinate vector $\binom{3}{-1}$ *represents* $v$.

# Linear Transformations

<!-- By 3:30 -->

At the beginning of the semester, we defined linear transformations between the vector spaces $\mathbb{R}^n$ and $\mathbb{R}^m$ for any $n$ and $m$. We used this property of *linearity* to then define matrices. Recall: if $L : \mathbb{R}^2 \to \mathbb{R}^3$ is linear, we just need to know what $L\binom{1}{0}$ is and $L\binom{0}{1}$ are, and then the columns of our matrix end up begin those vectors.

We can in fact generalize this process to work with any vector spaces and any basis sets for those vector spaces! We don't have to just use the "standard" coordinate system. We will see, later on, that sometimes using alternate coordinate systems might be more instructive (sometimes there is a "right" coordinate system to use to study a particular linear function $L$).

Let $L : V \to W$ be a linear transformation, $\dim(V) = n$ and $\dim(W) = m$. If $V$ has a basis $v_1, \ldots, v_n$ and $W$ has a basis $w_1, \ldots, w_m$, that means we have the following facts:

* Every vector $v \in V$ can be written, uniquely, as a linear combination $a_1 v_1 + \ldots + a_n v_n$.
* By linearity, $L(v) = a_1 L(v_1) + \ldots + a_n L(v_n)$.
* In order to figure out $L(v)$, then, we just need to know what $L(v_1), \ldots, L(v_n)$ are.
* Since $L(v_i) \in W$, we can write each of these as linear combinations:
  * $L(v_1) = a_{1, 1} w_1 + a_{2, 1} w_2 + \ldots + a_{m, 1} w_m$
  * $L(v_2) = a_{1, 2} w_1 + a_{2, 2} w_2 + \ldots + a_{m, 2} w_m$
  * ...
  * $L(v_i) = a_{1, i} w_1 + a_{2, i} w_2 + \ldots + a_{m, i} w_m$

That is, each $L(v_i)$ has some "decomposition" into a linear combination of $w_1, \ldots, w_m$. This decomposition would turn in to the $i$-th column of the matrix representation of $L$! There are a few notations for this, the book *Linear Algebra Done Right* by Axler uses:

$$M(L; (v_1, \ldots, v_n), (w_1, \ldots, w_m)) = \begin{pmatrix} a_{1, 1} & a_{1, 2} & \ldots & a_{1, n} \\ \vdots & \vdots & \vdots & \vdots \\ a_{m, 1} & a_{m_2} & \ldots & a_{m, n} \end{pmatrix}$$

Usually, if the bases are understood, I'll just write $M(L)$. This would be an $m \times n$ matrix, since, $\dim(V) = n$ and $\dim(W) = m$, and $L : V \to W$. That is, the dimension of the domain is the number of columns, and the dimension of the codomain is the number of rows.

## Examples

Let $V = \mathbb{C} = \\{ a + b i : a, b \in \mathbb{R} \\}$. The vectors $v_1 = 1$ and $v_2 = i$ form a basis for $\mathbb{C}$.

Let $W = \mathcal{P}_2 = \\{ a + bx + cx^2 \\}$. The vectors $w_1 = 1$, $w_2 = x$ and $w_3 = x^2$ form a basis for $W$.

Consider $L : V \to W$ given by $L(a + bi) = a + bx + bx^2$. (Exercise: show that this is linear.)

There is a matrix representation: $M(L)$. What would the dimensions of $M(L)$ be? Since $\dim(V) = w$ and $\dim(W) = 3$, $M(L)$ is $3 \times 2$.

To find the matrix representation:

* $L(v_1) = L(1) = 1$, or $1 \cdot 1w_1 + 0w_2 + 0w_3$, so the first column is $\begin{pmatrix}1 \\\ 0 \\\ 0 \end{pmatrix}$.
* $L(v_2) = L(1i) = 1x + x^2$, or $0w_1 + 1w_2 + 1w_3$, so the second column is $\begin{pmatrix}0 \\\ 1 \\\ 1 \end{pmatrix}$.

So our matrix is $\begin{pmatrix}1 & 0 \\\ 0 & 1 \\\ 0 & 1 \end{pmatrix}$.

## Exercise

Let $\mathcal{P}_3 = \\{ a + bx + cx^2 + dx^3 \\}$ and $\mathcal{P}_2 = \\{ a + bx + cx^2 \\}$. Let $D : \mathcal{P}_3 \to \mathcal{P}_2$ be given by differentiation; that is, $D(p(x)) = p^\prime(x)$. (Recall that the derivative of a polynomial of degree 3 is a polynomial of degree 2, so this works).

Use the bases: $v_1 = x^3, v_2 = x^2, v_3 = x, v_4 = 1$, and $w_1 = x^2, w_2 = x, w_3 = 1$.

1. Write $D(v_1)$, $D(v_2)$, $D(v_3)$, and $D(v_4)$ in terms of the basis vectors $w_1, w_2, w_3$.
2. Turn this into a $3 \times 4$ matrix representation of $D$.

Once we have a matrix representation, let's use it to determine $D(5x^3 - 4x^2 + 12x + 7)$. That is, write $5x^3 - 4x^2 + 12x + 7$ as a vector using basis $v_1, v_2, v_3, v_4$, and then apply the matrix $M(D)$ to it:

$$
\begin{pmatrix}3 & 0 & 0 & 0 \\ 0 & 2 & 0 & 0 \\ 0 & 0 & 1 & 0 \end{pmatrix}\begin{pmatrix}5 \\ - 4 \\ 12 \\ 7 \end{pmatrix} = \begin{pmatrix}15 \\ -8 \\ 12 \end{pmatrix}
$$


Aside: Can you find basis sets for $\mathcal{P}_3$ and $\mathcal{P}_2$ so that $D$ can be represented as

$$
\begin{pmatrix}
1 & 0 & 0 & 0 \\
0 & 1 & 0 & 0 \\
0 & 0 & 1 & 0
\end{pmatrix}
$$

Lastly, let's look at the **kernel** of $D$. That is, the set $\\{ p(x) \in P_3 : D(p(x)) = \vec{0} \\}$. We could use the matrix to look at this:

$$
\left( \begin{matrix} 3 & 0 & 0 & 0 \\ 0 & 2 & 0 & 0 \\ 0 & 0 & 1 & 0\end{matrix} \: \right| \: \left. \begin{matrix}0 \\ 0 \\ 0\end{matrix} \right)
$$

Solving this, we end up reducing it to the following matrix equation:

$$
\begin{pmatrix}
1 & 0 & 0 & 0 \\
0 & 1 & 0 & 0 \\
0 & 0 & 1 & 0
\end{pmatrix}
\begin{pmatrix}a_1 \\ a_2 \\ a_3 \\ a_4 \end{pmatrix} =
\begin{pmatrix}0 \\ 0 \\ 0 \end{pmatrix}
$$

Multiplying, we see that $a_1 = 0$, $a_2 = 0$, and $a_3 = 0$, while $a_4$ is a free variable. Recall that for the basis $w_1 = x^3, w_2 = x^2, w_3 = x, w_4 = 1$, the coordinate vector $\begin{pmatrix}a_1 \\\ a_2 \\\ a_3 \\\ a_4 \end{pmatrix}$ represents $a_1 x^3 + a_2 x^2 + a_3 x + a_4$. So what we've seen, then, is that the kernel is just those functions which only have constant terms! (Of course, we knew that from calculus, but it doesn't hurt to look at this again.) That is, $ker(D) = \\{ p(x) = a : a \in \mathbb{R} \\}$.

## Coming Up

* What happens if $L : V \to V$, but we use two different sets of basis vectors for the inputs and the outputs? "Change of basis" matrices.
* Application: linear recurrence relations.
  * Used in computer science to study the running time of recursive algorithms.
  * Also comes up in number theory
* For an $L : V \to V$, what is the "correct" basis to use? Is there a basis that makes the matrix $M(L)$ a diagonal matrix?
* Final Project Groups / Topics
