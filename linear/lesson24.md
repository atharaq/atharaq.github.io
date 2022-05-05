# Linear Lesson 24: Eigenspaces and Diagonalization
{:.no_toc}

1. Table of Contents
{:toc}

# Reminders / Upcoming

* Presentation 3 due this Sunday.
* Final Project:
  * Topics: ASAP!
  * Presentation: Thursday, 5/12. (about 10 minutes, no more than 15)
  * Paper: Thursday, 5/19. (about 5-10 pages)
* Take Home Exam 3 due Monday, May 16

# Eigenvalues / Eigenvectors

**Definition**: Let $L : V \to V$ be linear.  
1. A scalar $\lambda$ is called an **eigenvalue** of $L$ if there is a vector $v \in V$ such that $L(v) = \lambda v$.
2. The vector $v$ above is called an **eigenvector** of $L$.

Notice that if $L(v) = \lambda v$, then by linearity, $L(2v) = 2 L(v) = 2 (\lambda v) = \lambda \cdot (2v)$. That is: if $v$ is an eigenvector, so is $2v$. In fact, the set of all eigenvectors that correspond to the eigenvalue $\lambda$ forms a subspace of $V$!

**Theorem**: Suppose $L : V \to V$ is linear and $\lambda$ is an eigenvalue. Then the set $\\{ v \in V : L(v) = \lambda v \\}$ is a subspace of $V$.

**Proof**: Clearly $L(\vec{0}) = \lamda \cdot \vec{0}$ for any $\lambda$, since $\lamda \cdot \vec{0} = \vec{0}$.

Suppose $L(v) = \lambda v$ and $a$ is a scalar. Then we use the same argument we just used above: by linearity, $L(a \cdot v) = a L(v) = a (\lambda v)$. But this is just $\lambda \cdot (av)$, so $av$ is an eigenvector with eigenvalue $\lambda$.

Now to show closure under addition: suppose $L(v_1) = \lambda v_1$ and $L(v_2) = \lambda v_2$. What is $L(v_1 + v_2)$? Can you show that this is equal to $\lambda (v_1 + v_2)$?

**Definition**: Let $L : V \to V$ be linear and $\lambda$ an eigenvalue. The set $\\{ v \in V : L(v) = \lambda v \\}$ is called the **eigenspace** of $L$.
2. The dimension of the eigenspace corresponding to $\lambda$ is called the **geometric multiplicity** of $\lambda$.

Suppose $\dim(V) = n$. Recall that the reason we care about eigenvectors / eigenvalues is that we want to represent $L$ as a diagonal matrix. If we represent $L$ using the standard basis, it might not be a diagonal matrix, but the idea is that if we can find $n$ linearly independent eigenvectors, then those $n$ can be the basis we use.

In other words, we can *diagonalize* $L$ by using the *change of basis* matrices.

# Diagonalization

**Definition**: An $n \times n$ matrix $A$ is called **diagonalizable** if there is an invertible $n \times n$ matrix $X$ and a diagonal matrix $D$ such that $A = X^{-1} D X$.

The idea:

* $D$ is the matrix representation of $A$ with respect to a basis of all eigenvectors.
* The matrices $X$ and $X^{-1}$ are the *change-of-basis* matrices that go from the standard basis to this alternate eigenvector basis.
* That is, $A$ and $D$ represent the **same** linear map, with respect to different sets of basis vectors.
* $A$ and $D$ are called **similar** matrices: two matrices $A$ and $B$ are similar if there is an invertible matrix $X$ such that $A = X^{-1} B X$.

**Theorem**: Let $A$ and $B$ be similar matrices. Then $A$ and $B$ have the **same** eigenvalues.

Proof idea: The $X$ and $X^{-1}$ are "change of basis matrices". Use them to change between the bases used in $A$ vs the bases used in $B$.

Suppose $A = X^{-1} B X$ for some $X$. First we show that if $A(v) = \lambda v$, then there is $w$ such that $Bw = \lambda w$. In fact, $w$ will just be $X(v)$. *Exercise*: Show that $B(w) = \lamda w$. Use the fact that $A = X^{-1} B X$ means that $XA(v) = BX(v)$ for all $v$. So $B(w) = B(X(v)) = BX(v) = XA(v)$. Then use the fact that $v$ is an eigenvector of $A$.

Now vice versa: if $B(v) = \lambda v$, let $w = X^{-1}(v)$ and then show that $A(w) = \lambda w$.

**Theorem**: An $n \times n$ matrix is diagonalizable if and only if the sum of the dimensions of all the eigenspaces of $A$ is exactly $n$. That is, $A$ is diagonalizable if and only if it has $n$ linearly independent eigenvectors.

## Example

Geometrically, if $T : V \to V$ is linear, an eigenvector of $T$ is a direction that $T$ stretches or shrinks. Let's look at an example: $A = \begin{pmatrix}7 & -10 \\\ 5 & -8 \end{pmatrix}$.

The idea is that $v$ should be a vector such that $v$ and $T(v)$ are on the same line. Let's compute the eigenvalues: $A - \lambda I = \begin{pmatrix}7 - \lambda & -10 \\\ 5 & -8 - \lambda \end{pmatrix}$. Then $\det(A - \lambda I)$ is $(7 - \lambda)(-8 - \lambda) + 50$. Doing some algebra, this simplifies to $lambda^2 + \lambda - 6$. We refer to this polynomial as the **characteristic polynomial** of $A$.

Setting this equal to zero and factoring, we get $(\lambda + 3)(\lambda - 2) = 0$. So our eigenvalues are $\lambda = -3$ and $\lambda = 2$.

Now let's determine the eigenspaces for each of these eigenvalues:

$\lambda = -3$: We look for the kernel of $A + 3I$: $\begin{pmatrix}10 & -10 \\\ 5 & -5 \end{pmatrix}$. That is, we solve

$$
\left(\begin{matrix}10 & -10 \\ 5 & -5 \right| \: \left. \:\begin{matrix} 0  \\ 0 \end{matrix}\right)
$$

In RREF:

$$
\left(\begin{matrix}1 & -1 \\ 0 & 0 \right| \: \left. \:\begin{matrix} 0  \\ 0 \end{matrix}\right)
$$

That is, we look for the solutions to $x - y = 0$, which is just $x = y$. So the eigenspace is $\\{ \binom{x}{x} : x \in \mathbb{R} \\}$, which is spanned by $v_1 = \binom{1}{1}$. Notice that $A\binom{1}{1} = \binom{-3}{-3} = -3 \binom{1}{1}$.

For $\lambda = 2$, we look for the solutions to:

$$
\left(\begin{matrix}5 & -10 \\ 5 & -10 \right| \: \left. \:\begin{matrix} 0  \\ 0 \end{matrix}\right)
$$

In RREF:

$$
\left(\begin{matrix}1 & -2 \\ 0 & 0 \right| \: \left. \:\begin{matrix} 0  \\ 0 \end{matrix}\right)
$$

This gives us the equation $x - 2y = 0$, or $x = 2y$. So our eigenspace is the set $\\{ \binom{2y}{y} : y \in \mathbb{R} \\}$, so for example, the vector $v_2 = \binom{2}{1}$ spans it. Again, notice that $A(v_2) = \binom{4}{2} = 2v_2$.

Notice that $v_1 = \binom{1}{1}$ and $v_2 = \binom{2}{1}$ are linearly independent so they form a basis for $\mathbb{R}^2$. The *change of basis* matrices, then, to go between standard coordinates and $v_1$/$v_2$ coordinates are:

* $X^{-1} = \begin{pmatrix}1 & 2 \\\ 1 & 1 \end{pmatrix}$ goes from $v_1$/$v_2$ to standard coordinates.
* $X$ is the inverse of the above, which turns out to be $\begin{pmatrix}-1 & 2 \\\ 1 & -1 \end{pmatrix}$.

The matrix representation of $A$ with respect to $v_1$/$v_2$ coordinates is $D = \begin{pmatrix}-3 & 0 \\\ 0 & 2 \end{pmatrix}$. So that means: $X^{-1} D X$ is the *diagonalization* of $A$!

That is, to diagonalize an $n \times n$ matrix $M$:

* Find its eigenvalues and eigenvectors. Make sure that there are $n$ linearly independent eigenvectors (if there aren't, you cannot diagonalize).
* Write down the matrix $D$, whose diagonal entries are the eigenvalues of $M$.
* Write down the matrix $X^{-1}$, whose columns are the eigenvectors of $M$.
  * The order of the eigenvectors should match the order of their corresponding eigenvalues when you write down $D$ and $X^{-1}$.
  * That is, the first column, $v_1$, should be an eigenvector corresponding to the eigenvalue $\lambda_1$ written in the first entry of $D$.
* Invert $X^{-1}$ to get $X$.

Then $M = X^{-1} D X$. The idea is that $X$ converts from "standard" coordinates to this basis of eigenvectors. Then $D$ represents what $M$ does to each eigenvector (it just re-scales each of them). Then $X^{-1}$ converts back to standard coordinates!

## Non-diagonalizable Example

Let $A = \begin{pmatrix}2 & -1 \\\ 1 & 0 \end{pmatrix}$. Then $A - \lambda I$ is $\begin{pmatrix}2 - \lambda & -1 \\\ 1 & -\lambda\end{pmatrix}$, so $\det(A - \lambda I) = (2 - \lambda)(-\lambda) + 1$. Simplifying, we get that the characteristic polynomial is $\lambda^2 - 2\lambda + 1$. Setting this equal to zero: $\lambda^2 - 2\lambda + 1 = 0$ factors as $(\lambda - 1)^2 = 0$.

That is, there is only one eigenvalue, $\lambda = 1$. We say that $\lambda = 1$ has an **algebraic multiplicity** 2, since the term $(\lambda - 1)$ appears with exponent $2$ in the characteristic polynomial.

What is the geometric multiplicity of $\lambda = 1$? Check: what's the kernel of $\begin{pmatrix}1 & -1 \\\ 1 & -1 \end{pmatrix}$? In RREF:

$$
\left(\begin{matrix}1 & -1 \\ 0 & 0 \right| \: \left. \:\begin{matrix} 0  \\ 0 \end{matrix}\right)
$$

That is, the solutions to this are the solutions to $x - y = 0$. In other words, the set of all solutions is the set $\\{ \binom{x}{x} : x \in \mathbb{R} \\}$, which is a one-dimensional space spanned by the vector $\binom{1}{1}$. That is, the geometric multiplicity doesn't match the algebraic multiplicity!

In other words: *not every matrix is diagonalizable*! A matrix is only diagonalizable if the algebraic and geometric multiplicities of all the eigenvalues match up!
