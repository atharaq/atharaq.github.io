# Linear Lesson 6: Matrix Multiplication / Application
{:.no_toc}

1. Table of Contents
{:toc}

<!--
1. 2:30 - 2:45 quiz comments
2. 2:45 - 3:00 problem set comments
3. 3:00 - 3:10 warmup: matrix multiplication
4. 3:10 - 3:15 discussion: which multiplications make sense / which don't.
5. 3:15 - 3:45 application: discrete dynamics
6. 3:45 - 4    kernels / nullspaces.
7. 4 - 4:10 Gaussian elimination
-->

# Quiz Comments

1. Know your definitions! These definitions are a core part of the course. Memorization strategies like flashcards can help.
2. "Every vector" vs "There is a vector".
   * To show something is true about "every vector", you let $\vec{v}$ be an arbitrary vector (so for example, if you need to show something about *every vector* in $\mathbb{R}^3$, you let $\vec{v} = \begin{pmatrix}x \\\ y \\\ z \end{pmatrix}$, and don't assume anything about $x$, $y$, or $z$!)
   * To show "There is a vector...", you find a specific example (specific numbers for $x$, $y$, $z$, etc).
3. Using the definitions:
   * To show $f$ is linear: $f(\vec{v} + \vec{w}) = f(\vec{v}) + f(\vec{w})$. Plug in to both sides of this equation. Same for scalar multiplication. (This is an "every" statement. "For every $\vec{v]$ and $\vec{w}$...")
   * To show $f$ is not linear: *find* vectors $\vec{v}$ and $\vec{w}$ so that $f(\vec{v} + \vec{w}) \neq f(\vec{v}) + f(\vec{w})$. Or find $\vec{v}$ and a scalar $a$ so that $f(a \cdot \vec{v}) \neq a \cdot f(\vec{v})$.

Questions?

# Problem Set Comments

# Warmup

Consider the following matrices $A$ and $B$:

$$
A = \begin{pmatrix}1 & 2 & 0 \\ 1 & 3 & 4 \\ 0 & 0 & 1\end{pmatrix}, \: B = \begin{pmatrix}-1 & 1 & 0\\ 2 & 0 & 5 \end{pmatrix}
$$

1. Thinking of $A$ and $B$ as functions, what are the domains of $A$ and $B$?
2. Which function compositions makes sense $A \circ B$, $B \circ A$, both, or neither?
3. Compute $A\left(\begin{pmatrix}1 \\\ 0 \\\ 0 \end{pmatrix}\right)$, $A\left(\begin{pmatrix}0 \\\ 1 \\\ 0 \end{pmatrix}\right)$, and $A\left(\begin{pmatrix}0 \\\ 0 \\\ 1 \end{pmatrix}\right)$.
4. Compute $B(A\left(\begin{pmatrix}1 \\\ 0 \\\ 0 \end{pmatrix}\right))$, $B(A\left(\begin{pmatrix}0 \\\ 1 \\\ 0 \end{pmatrix}\right))$, and $B(A\left(\begin{pmatrix}0 \\\ 0 \\\ 1 \end{pmatrix}\right))$.

Write down the matrix representation of $B \circ A$.

## Matrix Multiplication

**Recall**: If $L$ is a linear function, the matrix representation of $L$ is found by determining what $L$ does to each of the *standard basis vectors* $\vec{e}_1, \ldots, \vec{e_n}$. If the domain of $L$ is $\mathbb{R}^3$ for example, we need to compute $L\left(\begin{pmatrix}1 \\\ 0 \\\ 0 \end{pmatrix}\right), L\left(\begin{pmatrix}0 \\\ 1 \\\ 0 \end{pmatrix}\right)$, and $L\left(\begin{pmatrix{0 \\\ 0 \\\ 1 \end{pmatrix}\right)$.  Then we write these vectors down as the *columns* of our matrix.

So if we want to find the matric representation of $(B \circ A)$, we need to compute $B(A(\vec{e}_1))$, $B(A(\vec{e}_2))$, and $B(A(\vec{e}_3))$. But $A(\vec{e_1})$ is just the first column of A$, $A(\vec{e}_2)$ is the second column, and $A(\vec{e}_3)$ is the third column.

For any vector $\vec{v}$, to compute $B(\vec{v})$, we compute $\binom{\text{row 1 of B} \cdot \vec{v}}{\text{row 2 of B} \cdot \vec{v}}$.

So to sum up: the first column of $(B \circ A)$ is just $\binom{\text{row 1 of B} \cdot \text{column 1 of A}}{\text{row 2 of B} \cdot \text{column 1 of A}}$!

What about all the other columns of $(B \circ A)$?

# Application

# Kernels / Nullspaces

# Systems of Equations

# Problem Set 2

# Presentation 1
