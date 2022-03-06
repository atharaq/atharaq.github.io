# Linear Lesson 10: Inverse Matrices + Exam Review
{:.no_toc}

1. Table of Contents
{:toc}

<!--
* 2:30 - 3:15 Inverse Matrices
* 3:15 - 4:10 Exam Review
-->

# Helpful Videos from Fellow Students

* Proving a function is linear: Jose F.
* Proving a function is not linear: Sara E.
* Explaining that composing rotations is adding angles: Sofia J.

# Inverse Matrices

**Warm-up**: Find the inverses of the following matrices, if they exist:

$$
\begin{pmatrix}
1 & 1 \\
1 & -1
\end{pmatrix}
$$

$$
\begin{pmatrix}
1 & 0 & 2 \\
0 & 1 & -1 \\
2 & 1 & 3
\end{pmatrix}
$$

Recall: use augmented matrix form with $\left(A \\: \right\| \\: \left. I \right)$, and attempt to put these into RREF.

## Notice

Consider the matrix $A = \begin{pmatrix}1 & 1 \\\ 1 & -1 \end{pmatrix}$. This is the linear function given by $A\binom{1}{0} = \binom{1}{1}$ and $A\binom{0}{1} = \binom{1}{-1}$.

* What is $A^{-1}\binom{1}{1}$?
* What is $A^{-1}\binom{1}{-1}$?

Recall the question from Problem Set 1: is $\binom{1}{0} \in \textrm{Span}(\binom{1}{1}, \binom{1}{-1})$? This is asking if there are $a$ and $b$ such that $a\cdot \binom{1}{1} + b \cdot \binom{1}{-1} = \binom{1}{0}$. We saw earlier that to answer this, we set up an augmented matrix system and use Gaussian Elimination:

$$
\left(\begin{matrix}1 & 1 \\ 1 & -1 \end{matrix} \: \right| \: \left.\begin{matrix} 1 \\ 0 \end{matrix}\right)
$$

But this is just asking: is there a vector $\vec{v}$ such that $A\vec{v} = \binom{1}{0}$? If so, this vector $\vec{v} = \binom{a}{b}$ would give us exactly the $a$ and $b$ that we need!

When we write the matrix equation in this way, $A\vec{v} = \binom{1}{0}$, it suggests another way to solve the problem: multiply both sides, on the left, by $A^{-1}$! Then $A^{-1} A\vec{v} = A^{-1} \binom{1}{0}$!

Of course: $A^{-1} A = I$, and $I \vec{v} = \vec{v}$, so this just means $\vec{v} = A^{-1} \binom{1}{0}$.

Similarly, if we want to know if $\binom{0}{1}$ is in the span, we just check $A^{-1}\binom{0}{1}$. If $A$ is not invertible, so $A^{-1}$ doesn't exist, what would that mean?

## Exercise

Determine if the vectors $\begin{pmatrix}1 \\\ 4 \\\ 7\end{pmatrix}$, $\begin{pmatrix} 2 \\\ 5 \\\ 8 \end{pmatrix}$, and $\begin{pmatrix}3 \\\ 6 \\\ 9 \end{pmatrix}$ span all of $\mathbb{R}^3$.

Hint: all we need to do is check to see if a particular matrix (which one?) is invertible. Because if it is invertible, that's enough to tell you that $\begin{pmatrix}1 \\\ 0 \\\ 0 \end{pmatrix}$, $\begin{pmatrix}0 \\\ 1 \\\ 0 \end{pmatrix}$, and $\begin{pmatrix}0 \\\ 0 \\\ 1 \end{pmatrix}$ are in the span of these vectors by looking at $A^{-1} \vec{v}$ for each of these vectors.

## Elementary Row Operations / Elementary Matrices

As an aside: why does Gaussian Elimination work to find inverse matrices?

Why does this work? Technically during Gaussian Elimination, we only allow operations that represent multiplication by invertible matrices. For example, if $A$ is the matrix $\begin{pmatrix} 1 & 2 \\\ 2 & -1 \end{pmatrix}$, and we switch row 1 and row 2, technically what we are doing is taking the matrix $I = \begin{pmatrix}1 & 0 \\\ 0 & 1 \end{pmatrix}$, switching the rows of this matrix to get $M = \begin{pmatrix} 0 & 1 \\\ 1 & 0 \end{pmatrix}$, and then multiplying $MA$. Try it out: what do you get if you multiply $\begin{pmatrix} 0 & 1 \\\ 1 & 0 \end{pmatrix} \begin{pmatrix} 1 & 2 \\\ 2 & -1 \end{pmatrix}$.

Similarly, if we multiply row 1 by negative 2 and add it to row 2, it's  the same as multiplying $\begin{pmatrix}1 & 0 \\\ -2 & 1 \end{pmatrix} \begin{pmatrix}1 & 2 \\\ 2 & -1 \end{pmatrix}$.

The "allowable" operations are called **elementary row operations**, and their corresponding matrices are **elementary matrices**. When we solve an equation $A\vec{x} = \vec{b}$ by doing Gaussian elimination, we are actually multiplying both sides of the equation by elementary matrices. So our first step might be $E_0 A \vec{x} = E_0 \vec{b}$, where $E_0$ is some elementary matrix (maybe interchanging rows). Then we might do another step, and get $E_1 E_0 A \vec{x} = E_1 E_0 \vec{b}$. We keep going, until the left hand side of the equation is the identity matrix! That is: we keep going until we have $E_n \cdot E_{n-1} \cdot \ldots E_1 \cdot E_0 \cdot A \vec{x} = I \vec{x}$!. That means that $(E_n \cdot E_{n-1} \cdot \ldots E_1 \cdot E_0)$ is actually the inverse of $A$!

# Exam Review

Topics:

* Span and Linear combinations
* Linear Functions
  * Showing a function is linear.
  * Expressing a linear function as a matrix.
  * Describing the linear function represented by a matrix.
  * Images and Kernels of linear functions.
* Matrices
  * Multiplying matrices
  * Inverse matrices
* Application: Discrete Dynamical Systems (population dynamics)
* Gaussian Elimination

These are not separate topics: for instance, you now know that to determine if a vector is in the span of a set of vectors, you can set up an augmented matrix system, and use Gaussian Elimination.

## Example

Consider the function $F : \mathbb{R}^3 \to \mathbb{R}^4$ given $F\begin{pmatrix}x_1 \\\ x_2 \\\ x_3 \end{pmatrix} = \begin{pmatrix} x_1 \\\ x_3 \\\ x_2 \\\ x_1 \end{pmatrix}$.

1. Does $F$ respect scalar multiplication?
2. Does $F$ respect vector addition?
3. Write $F$ as a matrix.
4. What are the dimensions of the matrix representation of $F$?
5. Is there a vector $\vec{v}$ such that $F(\vec{v}) = \begin{pmatrix}0 \\\ 0 \\\ 0 \\\ 1\end{pmatrix}$? If so, what is $\vec{v}$? If not, why not?

## Example

Find the image and kernel of the function $A$ given by $\begin{pmatrix}1 & 2 & 3 \\\ 2 & 4 & 6 \end{pmatrix}$.

Hint: set up an augmented matrix system:

$$
\left(\begin{matrix}1 & 2 & 3 \\ 2 & 4 & 6 \end{matrix} \: \right| \: \left.\begin{matrix} x \\ y \end{matrix}\right)
$$

1. (Image): Determine for which $x$ and $y$ this system has solutions.
2. (Kernel): Then determine, if $x = 0$ and $y = 0$, what those solutions are.

## Many more examples

Many more examples are on the **practice exam** posted on Moodle. Take a look at that, discuss those with each other, and come by office hours tomorrow and Thursday!
