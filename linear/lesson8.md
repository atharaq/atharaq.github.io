# Linear Lesson 8: Gaussian Elimination
{:.no_toc}

1. Table of Contents
{:toc}

<!--
1. (2:30 - 3) Problem Set
2. (3 - 3:20) Augmented matrix / systems of equations.
3. (3:20 - 3:45) gaussian elim / allowable operations
4. (3:45 - 4:10) example / exercise / rref / span
-->

# Problem Set Questions

# Systems of Equations

What we just did was an example of the method known as **Gaussian elimination**. If we look back at how we worked through the solutions, the variables $x_1, x_2$, and $x_3$ were not so important, but their *coefficients* were. We needed to eliminate the coefficients as much as possible.

To keep track of all of this, we don't even need to keep track of the variables at all. We can just keep track of these coefficients, using matrices!

We first set up an **augmented matrix**, to capture the idea of $A(\vec{v}) = \vec{0}$:

$$
\left(\begin{matrix}1 & 1 & -1 \\ 2 & 0 & 5\end{matrix} \: \right| \: \left.\begin{matrix} 0 \\ 0 \end{matrix}\right)
$$

This *represents* the equation $A(\vec{v}) = \vec{0}$. Then everything we did can be captured in "elementary row operations" on this matrix:

For example, our first step was to replace $2x_1 + 5x_3 = 0$ by $-2(equation 1) + (1)(equation 2)$. We can represent this by multipying the first row by negative 2, and adding it to the second row (and replacing the second row with that sum):

$$
\left(\begin{matrix}1 & 1 & -1 \\ 0 & -2 & 7\end{matrix} \: \right| \: \left.\begin{matrix} 0 \\ 0 \end{matrix}\right)
$$

Dividing row 2 by -2 looks like this:

$$
\left(\begin{matrix}1 & 1 & -1 \\ 0 & 1 & -\frac{7}{2} \end{matrix} \: \right| \: \left.\begin{matrix} 0 \\ 0 \end{matrix}\right)
$$

Replacing row 1 by -1(row 2) + row 1:

$$
\left(\begin{matrix}1 & 0 & \frac{5}{2} \\ 0 & 1 & -\frac{7}{2} \end{matrix} \: \right| \: \left.\begin{matrix} 0 \\ 0 \end{matrix}\right)
$$

At this point, there is nothing left to do. (Why not?) We can read off the solutions at this point: $x_1 + \frac{5}{2} x_3 = 0$ and $x_2 - \frac{7}{2} x_3 = 0$. In other words, $x_1$ and $x_2$ both depend on $x_3$, and so if $x_3 = a$, then $x_1 = -\frac{5}{2}a$ and $x_2 = \frac{7}{2} a$. All solutions are of the form $a \cdot \begin{pmatrix} -\frac{5}{2} \\\ \frac{7}{2} \\\ 1 \end{pmatrix}$, for some $a \in \mathbb{R}$. (What does this look like, geometrically?)

We know we are done because the matrix is in **reduced row echelon form**:

1. The leading entry of each row is 1.
2. Each leading entry is to the right of the leading entry of the previous row.
3. If a row has only zeroes, it's at the bottom.

The method we used is called, again, **Gaussian elimination**. It is detailed in [the textbook](https://www.math.ucdavis.edu/~linear/linear-guest.pdf), in chapter 2. Take a look at at that for help with these computations!

## Gaussian Elimination

**Goal**: Given an $m \times n$ system of equations ($m$ equations, $n$ unknowns), or an $(m \times n)$ matrix, we want to get it into the form:

$$
\begin{align}
x_1 && &= \ldots \\
& x_2 & &= \ldots \\
\vdots \\
&& x_n &= \ldots
\end{align}
$$

or: an augmented matrix which looks like: $\left(\begin{matrix}1 & 0 & 0 & 0 \\\ 0 & 1 & 0 & 0 \\\ 0 & 0 & 1 & 0 \\\ 0 & 0 & 0 & 1 \end{matrix} \\: \right\| \\: \left. \begin{matrix} a_1 \\\ a_2 \\\ \vdots \\\ a_n \end{matrix} \right)$. That is, get it into an *identity matrix*.

If $m \neq n$, this wouldn't be possible. But in fact, this might not always be possible, even if $m = n$. For example:

$$
\begin{align}
x + 2y &= 1 \\
2x + 4y &= 2
\end{align}
$$

As an augmented matrix:

$$
\left(\begin{matrix}
  1 & 2 \\
  2 & 4
  \end{matrix}\right| \:
  \left. \begin{matrix} 1 \\ 2 \end{matrix}\right)
$$

Try to eliminate the 2 in the bottom left: $(-2) \cdot$ row 1 + row 2:

$$
\left(\begin{matrix}
  1 & 2 \\
  0 & 0
  \end{matrix}\right| \:
  \left. \begin{matrix} 1 \\ 0 \end{matrix}\right)
$$

So what does this mean? We end up with, basically, $x + 2y = 1$. This means any $\binom{x}{y}$ where $x + 2y = 1$ will work. So, for example, $x = -1$ and $y = 1$ will work. But also $x = -3$ and $y = 2$ will work, and so will $x = 1$ and $y = 0$. In fact, there are infinitely many different solutions here! What do the solutions look like, geometrically?

## Allowable Operations

Remember that $\left(A \\: \right\| \\: \left. \vec{b} \right)$ represents the system of equations $A(\vec{x}) = \vec{b}$. That is, we're asking the question: "find all $\vec{x}$ such that $A(\vec{x}) = \vec{b}$." (If $\vec{b} = \vec{0}$, this is asking about the null space of $A$. But in general we can ask about any vector.)

We are allowed to do three things to such a system of equations:

1. Interchanging rows. (This corresponds to swapping the order of the equations in the system, so clearly that doesn't change our solutions.)
2. Multiplying one row by a non-zero scalar. (This corresponds to multiplying both sides of an equation by the same non-zero number, which again doesn't change our solutions.)
3. Adding a multiple of one row to another. (Adding equations doesn't change the solutions either: this is what we learned in high school algebra courses!)

## Example

$$
\left(\begin{matrix}
  0 & 1 & 4 \\
  0 & -1 & 3 \\
  5 & 3 & 6
  \end{matrix} \: \right| \:
\left.\begin{matrix}
2 \\
4 \\
8\end{matrix}\right)
$$

We want the left side to look like the identity matrix. **First**: try to get it into an *upper triangular* matrix: one where all the entries below the diagonal are 0. (At the same time, we can try to get the entries on the diagonals to be 1, if possible). What should we do? We need a 1 in the top left corner. We can interchange row 1 and row 3:

$$
\left(\begin{matrix}
  5 & 3 & 6 \\
  0 & -1 & 3 \\
  0 & 1 & 4
  \end{matrix}\: \right| \:
\left.\begin{matrix}
8 \\
4 \\
2\end{matrix}\right)
$$

Next we can multiply row 1 by 1/5:

$$
\left(\begin{matrix}
  1 & \frac{3}{5} & \frac{6}{5} \\
  0 & -1 & 3 \\
  0 & 1 & 4
  \end{matrix}\: \right| \:
\left.\begin{matrix}
\frac{8}{5} \\
4 \\
2\end{matrix}\right)
$$

Now we have that 1 in the top left corner. The rest of that column matches, exactly, with the identity matrix. Next we need to work on the second column. We need a 1 in the second row of the second column, so multiply row 2 by -1:

$$
\left(\begin{matrix}
  1 & \frac{3}{5} & \frac{6}{5} \\
  0 & 1 & -3 \\
  0 & 1 & 4
  \end{matrix}\: \right| \:
\left.\begin{matrix}
\frac{8}{5} \\
-4 \\
2\end{matrix}\right)
$$

Now we can use row 2 to eliminate the entries in the second column of row 3. That is: add $(-1)\cdot$ row 2 + row 3:

$$
\left(\begin{matrix}
  1 & \frac{3}{5} & \frac{6}{5} \\
  0 & 1 & -3 \\
  0 & 0 & 7
  \end{matrix}\: \right| \:
\left.\begin{matrix}
\frac{8}{5} \\
-4 \\
6\end{matrix}\right)
$$

Now we can get a 1 in the bottom right corner by dividing row 3 by 7:

$$
\left(\begin{matrix}
  1 & \frac{3}{5} & \frac{6}{5} \\
  0 & 1 & -3 \\
  0 & 0 & 1
  \end{matrix}\: \right| \:
\left.\begin{matrix}
\frac{8}{5} \\
-4 \\
\frac{6}{7}\end{matrix}\right)
$$

Now we have an upper triangular matrix. We are almost done: we can get this into the identity matrix by adding $-\frac{3}{5}\cdot$ row 2 + row 1:

$$
\left(\begin{matrix}
  1 & 0 & 3 \\
  0 & 1 & -3 \\
  0 & 0 & 1
  \end{matrix}\: \right| \:
\left.\begin{matrix}
4 \\
-4 \\
\frac{6}{7}\end{matrix}\right)
$$

Now we can add $(-3)\cdot$ row 3 + row 1, and $3 \cdot$ row 3 + row 2:

$$
\left(\begin{matrix}
  1 & 0 & 0 \\
  0 & 1 & 0 \\
  0 & 0 & 1
  \end{matrix}\: \right| \:
\left.\begin{matrix}
\frac{10}{7} \\
-\frac{10}{7} \\
\frac{6}{7}\end{matrix}\right)
$$

So we get the solution $x_1 = \frac{10}{7}$, $x_2 = -\frac{10}{7}$, and $x_3 = \frac{6}{7}$. We can plug this back in to check that $A(\vec{x}) = \begin{pmatrix}2 \\\ 4 \\\ 8\end{pmatrix}$.

## Exercise

$$
\left(\begin{matrix}
  1 & -3 \\
  -3 & 9
  \end{matrix}\: \right| \:
\left.\begin{matrix}
2 \\
0\end{matrix}\right)
$$

# Wrapping Up

**Important**: It is possible for a solution to be *inconsistent*. We might get a row of all zeros, and the right hand side might be non-zero. In this case, we have *no solution*! In that case, we aren't able to *reduce* our matrix to the *identity* matrix, but we still get it into **reduced row echelon form** (RREF).

## Reduced row echelon form

An augmented matrix system is in **reduced row echelon form** (RREF) if:

1. For each row, the leftmost non-zero entry is a 1. This entry is called a *pivot*.
2. The pivot of each row is to the right of the pivots above it.
3. The pivot is the only *non-zero* element in its column.

Which of these two examples below are in RREF and which is not?

$$
\left(\begin{matrix}
  1 & 0 & 8 \\
  0 & 0 & 4 \\
  0 & 1 & 0
  \end{matrix}\: \right| \:
\left.\begin{matrix}
22 \\
16 \\
10\end{matrix}\right)
$$

and

$$
\left(\begin{matrix}
  1 & 0 & 1 \\
  0 & 1 & 2 \\
  0 & 0 & 0
  \end{matrix}\: \right| \:
\left.\begin{matrix}
-10  \\
10 \\
0 \end{matrix}\right)
$$

## In general

For an $m \times n$ matrix $A$ and a vector $\vec{b} \in \mathbb{R}^M$, the system $A \vec{x} = \vec{b}$ could have:

* no solutions,
* 1 solution (exactly) (a single point, which is 0-dimensional), or
* infinitely many solutions. (Possibly 1-dimensional, 2-dimensional, or higher even.)

If there are no solutions, the system is called *inconsistent*. If there are solutions (either 1 or infinitely manY), it is called *consistent*.

For example:

$$
\left(\begin{matrix}
  1 & 0 & -1 \\
  0 & 1 & 2 \\
  0 & 0 & 0
  \end{matrix}\: \right| \:
\left.\begin{matrix}
0  \\
5 \\
0 \end{matrix}\right)
$$

The solutions here are solutions to $x_1 - x_3 = 0$ and $x_2 + 2x_3 = 5$. In other words:

$$
\begin{align}
x_1 &= x_3 \\
x_2 &= 5 - 2x_3 \\
x_3 &= x_3
\end{align}
$$

Or: $\begin{pmatrix}x_1 \\\ x_2 \\\ x_3 \end{pmatrix} = \begin{pmatrix}0 \\\ 5 \\\ 0 \end{pmatrix} + x \cdot \begin{pmatrix}1 \\\ -2 \\\ 1\end{pmatrix}$, for any $x \in \mathbb{R}$. The set of all solutions forms a one dimensional space (a line)!

## Spans

**Question**: Is the vector $\begin{pmatrix}1 \\\ 1 \\\ 1\end{pmatrix}$ in the span of $\begin{pmatrix}0 \\\ 1 \\\ 1\end{pmatrix}$, $\begin{pmatrix}1 \\\ 1 \\\ 0\end{pmatrix}$ and $\begin{pmatrix}2 \\\ 3 \\\ 1 \end{pmatrix}$?

How would we figure this out? By setting up a system of equations and solving it! What's the system of equations we'd need to set up? Essentially, we are asking: are there $a$, $b$, and $c$ such that $a \cdot \begin{pmatrix}0 \\\ 1 \\\ 1 \end{pmatrix} + b \cdot \begin{pmatrix}1 \\\ 1 \\\ 0 \end{pmatrix} + c \cdot \begin{pmatrix}2 \\\ 3 \\\ 1 \end{pmatrix} = \begin{pmatrix}1 \\\ 1 \\\ 1 \end{pmatrix}$?

This is the following system of equations:

$$
\begin{align}
0a + 1b + 2c &= 1 \\
1a + 1b + 3c &= 1 \\
1a + 0b + 1c &= 1
\end{align}
$$

Which corresponds to solutions to this augmented matrix system:

$$
\left(\begin{matrix}
  0 & 1 & 2 \\
  1 & 1 & 3 \\
  1 & 0 & 1
  \end{matrix}\: \right| \:
\left.\begin{matrix}
1  \\
1 \\
1 \end{matrix}\right)
$$

That is: to check if a vector $\vec{b}$ is in the span of some vectors $\vec{v_1}, \vec{v_2}, \ldots, \vec{v_n}$, we really just write down the matrix $M$ whose columns are $\vec{v_1}, \vec{v_2}$, etc, and consider the system $\left( M \: \right\| \: \left. \vec{b} \right)$. If we can solve this system, then $\vec{b}$ is in the required span, and if we cannot, then $\vec{b}$ is not in the required span!

## Images

Consider the function $L : \mathbb{R}^2 \to \mathbb{R}^3$ given by $\begin{pmatrix}1 & 2 \\\ 3 & 4 \\\ 5 & 6 \end{pmatrix}$. Which vectors $\vec{b} \in \mathbb{R}^3$ are in the **image** of $L$? Recall that the image of $L$ is the set of all vectors $\vec{b} \in \mathbb{R}^3$ such that there is some $\vec{v} \in \mathbb{R}^2$ where $L(\vec{v}) = \vec{b}$.

We could do systems of equations to ask this question. But let's think for a second about what we are asking. Recall that $L(\binom{x}{y})$ is given by $x \cdot \begin{pmatrix}1 \\\ 3 \\\ 5 \end{pmatrix} + y \cdot \begin{pmatrix} 2 \\\ 4 \\\ 6 \end{pmatrix}$. What does this tell you about the image of $L$?

In fact: the image of any matrix is given, entirely, by the **span** of its columns! Do you see why?
