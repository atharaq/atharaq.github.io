# Linear Lesson 12: Determinants, generalized
{:.no_toc}

1. Table of Contents
{:toc}

# Pre-work

1. What does a negative determinant mean (for a 2 x 2 matrix)
2. What would a determinant of zero mean? (For a 2 x 2 matrix)
3. What does the determinant of a 3 x 3 matrix mean?

**Negative determinant**: Consider the matrix $A = \begin{pmatrix}1 & 2 \\\ 2 & 1 \end{pmatrix}$. What does it do to the unit square?

<img src="unit-square.png" />

In this picture, the "blue" arrow is what happens to the "x" vector $\binom{1}{0}$, and the "red" one is the image of the "y" vector $\binom{0}{1}$:

<img src="neg-det-2d.png" />

Notice that the blue arrow is now "on the wrong side" of the red arrow. This is why the detemrinant of this matrix is negative: it represents the "orientation" of the parallelogram being changed.

**Zero determinant**: For a matrix $B = \begin{pmatrix}a & b \\\ c & d\end{pmatrix}$, if $ad - bc = 0$, then $ad = bc$. When can this happen?

* If either $a = 0$ or $d = 0$ and either $b = 0$ or $c = 0$, or
* If $\frac{a}{c} = \frac{b}{d}$.

In the first case, we would either have a row of all zeros or a column of all zeros. If it's a column of all zeros, then the matrix maps the unit square to a single vector. In other words, it maps a 2D area to a 1D line.

In the second case, both vectors $\binom{a}{c}$ and $\binom{b}{d}$ are on the same line! We can tell because if $\frac{a}{c} = \frac{b}{d}$, then that means there is some number $k$ that you can "reduce" the numerator and denominator on one side to get to the other. In other words: $ak = b$ and $ck = d$, so the *vectors* $\binom{a}{c}$ and $\binom{b}{d}$ are scalar multiples of each other!

But in both of these cases, we get the same picture: the unit square is mapped onto a line! This means that the area would be zero, since we no longer have a 2D shape! For example, consider the matrix $M = \begin{pmatrix}1 & 2 \\\ 1 & 2\end{pmatrix}$. This is what happens to the unit square:

<img src="det-zero.png" />

This is interesting geometrically, but it also tells us something deep about the function itself: *all* of the outputs of $M$ will lie on that same line. So that means the image of $M$ is one-dimensional! Since $M$ maps a 2D space into a 1D space, it cannot be invertible (would the inverse of $\binom{2}{2}$ be $\binom{0}{1}$ or $\binom{2}{0}$? There are many things that are mapped to the same vector!). **In general**: a matrix $A$ is invertible if and only if $mathrm{det}(A) \neq 0$.

**3 x 3**: This is what we will talk about today! The determinant of a $3 \times 3$ matrix is still supposed to represent a scaling factor. But since we're in three dimensions, instead of talking about what happens to the unit square, we will talk about what happens to the **unit cube**. And instead of it becoming a parallelogram, it can becomes a 3D shape known as a *parallelepiped*. Let's go through some examples to figure out how to compute it.

# Volumes

Consider the unit cube:

(picture)

The volume is $1 \times 1 \times 1 = 1$.

What is the volume of the image of the unit cube under the following transformations?

First: $A = \begin{pmatrix}2 & 0 & 0 \\\ 0 & 1 & 0 \\\ 0 & 0 & 1 \end{pmatrix}$

(picture / link)

Notice that multiplying one row by a scalar re-scales the volume. (This makes sense, right? $V = l \times w \times h$ for a rectangular prism?)

What if we add a scalar multiple of one row to another?

$B = \begin{pmatrix}1 & 0 & 0 \\\ 2 & 1 & 0 \\\ 0 & 0 & 1 \end{pmatrix}$

(picture)

The formula for volume is $Area(base) \times height$. So first we need to find the area of the base. That base is just in the $xy$-plane, it's a parallelogram:

(picture)

We know the area of a parallelogram with sides at $\binom{1}{2}$ and $\binom{0}{1}$: this is $1 \times 1 - 0 \times 2 = 1$. The height of this shape is $1$, so the volume is $1 \times 1 = 1$.

This will generalize: adding a scalar multiple of one row to another will not change the resulting volume!

What if we swap rows?

$C = \begin{pmatrix}0 & 1 & 0 \\\ 1 & 0 & 0 \\\ 0 & 0 & 1 \end{pmatrix}$

(picture / link?)

We still get a unit cube, but **orientation** changes. Instead of "right" / "forward" / "up" orientation ($\hat{i}$ / $\hat{j}$ / $\hat{k}$), the cube is *oriented* a different way: $\hat{j}$ / $\hat{i}$ / $\hat{k}$. If you remember something about the "right-hand rule" (point your right hand in the direction of the first vector, then curl in the direction of the second), this has a "negative" orientation!

In other words: swapping rows *negates* the "signed" volume of the cube, where the sign represents a "positively" or "negatively" oriented cube.

## Examples

Using these rules, let's do some examples, before working our way to some generalizations. What is the volume of the image of the unit cube under the transformation $M = \begin{pmatrix}1 & 0 & 1 \\\ 0 & 1 & 1 \\\ 1 & 1 & 0 \end{pmatrix}$

Let's try to get this to the identity matrix, but keep track of what we do at each step!

$$
\begin{pmatrix}1 & 0 & 1 \\ 0 & 1 & 1 \\ 1 & 1 & 0 \end{pmatrix}
$$

Start by doing -1 R1 + R3:

$$
\begin{pmatrix}1 & 0 & 1 \\ 0 & 1 & 1 \\ 0 & 1 & -1 \end{pmatrix}
$$

Now -1 R2 + R3:

$$
\begin{pmatrix}1 & 0 & 1 \\ 0 & 1 & 1 \\ 0 & 0 & -2 \end{pmatrix}
$$

Now multiply R3 by $-\frac{1}{2}$:

$$
\begin{pmatrix}1 & 0 & 1 \\ 0 & 1 & 1 \\ 0 & 0 & 1 \end{pmatrix}
$$

Now add -1R3 + R1 and -1R3 + R2 to finally get the identity:

$$
\begin{pmatrix}1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{pmatrix}
$$

So we have the identity matrix. We know that this keeps the unit cube as it is, so the volume of its unit cube is 1. To find the volume of the image of the unit cube under $M$, we work backwards (opposite steps in the opposite order):

* We can ignore all of the times we added scalar multiples of one row to another, since that doesn't change the volume.
* We only need to worry about "interchanging rows" (which we never did), and "multiplying a row by a scalar".
* The only time we multiplied a row by a scalar was when we multiplied by $-\frac{1}{2}$. So working backwards, we should divide $1 \div -\frac{1}{2} = -2$

So the volume of the cube under this transformation is -2!

## Triangular and Diagonal Matrices

As another example, what if our matrix looks like $A = \begin{pmatrix} a_{1, 1} & a_{1, 2} & a_{1, 3} \\\ 0 & a{2, 2} & a_{2, 3} \\\ 0 & 0 & a_{3, 3} \end{pmatrix}$?

(picture)

In this case, the volume will just be $a_{1, 1} \times a_{2, 2} \times a_{3, 3}$!

**Definition**:

# Determinants

## Aside: $n = 1 \implies n = 2$

## Inductive Definition

# Properties
