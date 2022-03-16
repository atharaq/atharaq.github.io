# Linear Lesson 12: Determinants, generalized
{:.no_toc}

1. Table of Contents
{:toc}

# Pre-work

1. What does a negative determinant mean (for a 2 x 2 matrix)
2. What would a determinant of zero mean? (For a 2 x 2 matrix)
3. What does the determinant of a 3 x 3 matrix mean?

**Negative determinant**: Consider the matrix $A = \begin{pmatrix}1 & 2 \\\ 2 & 1 \end{pmatrix}$. What does it do to the unit square? In this picture, the "blue" arrow is what happens to the "x" vector $\binom{1}{0}$, and the "red" one is the image of the "y" vector $\binom{0}{1}$:

(picture)

Notice that the blue arrow is now "on the wrong side" of the red arrow. This is why the detemrinant of this matrix is negative: it represents the "orientation" of the parallelogram being changed.

**Zero determinant**: For a matrix $B = \begin{pmatrix}a & b \\\ c & d\end{pmatrix}$, if $ad - bc = 0$, then $ad = bc$. When can this happen?

* If either $a = 0$ or $d = 0$ and either $b = 0$ or $c = 0$, or
* If $\frac{a}{c} = \frac{b}{d}$.

In the first case, we would either have a row of all zeros or a column of all zeros. If it's a column of all zeros, then the matrix maps the unit square to a single vector. In other words, it maps a 2D area to a 1D line.

In the second case, both vectors $\binom{a}{c}$ and $\binom{b}{d}$ are on the same line! We can tell because if $\frac{a}{c} = \frac{b}{d}$, then that means there is some number $k$ that you can "reduce" the numerator and denominator on one side to get to the other. In other words: $ak = b$ and $ck = d$, so the *vectors* $\binom{a}{c}$ and $\binom{b}{d}$ are scalar multiples of each other!

But in both of these cases, we get the same picture: the unit square is mapped onto a line! This means that the area would be zero, since we no longer have a 2D shape!

(picture)

**3 x 3**: This is what we will talk about today! The determinant of a $3 \times 3$ matrix is still supposed to represent a scaling factor. But since we're in three dimensions, instead of talking about what happens to the unit square, we will talk about what happens to the **unit cube**. And instead of it becoming a parallelogram, it can becomes a 3D shape known as a *parallelopiped*. Let's go through some examples to figure out how to compute it.

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

Using these rules, let's do some examples, before working our way to some generalizations.

## Diagonal and Triangular Matrices

# Determinants

## Aside: $n = 1 \implies n = 2$

## Inductive Definition

# Properties
