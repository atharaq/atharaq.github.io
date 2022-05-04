# Linear Lesson 24: Eigenspaces and Diagonalization
{:.no_toc}

1. Table of Contents
{:toc}

# Reminders / Upcoming

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

## Change of Bases
