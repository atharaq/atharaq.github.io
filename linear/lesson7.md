# Linear Lesson 7: Systems of Equations
{:.no_toc}

1. Table of Contents
{:toc}

<!--
1. 2:30 - 3:15 homework responses / application
2. 3:15 - 3:35 kernels / nullspaces
3. 3:35 - 3:55 Gaussian elimination
4. 3:55 - 4:10 ???

-->

# Reminders:

1. Problem Set 2 due next **Thursday** (March 3).
2. Presentation 1 due **Sunday** on Moodle / VoiceThread.

# Homework comments

...

# Application: Population Dynamics

Suppose we have two cities $A$ and $B$, and in both cities, birth rates are equal to death rates, so the total population is stable. Every year, 10% of residents of city A move to city B, and 20% of residents of city B move to city A. Let $a$ be the population of city $A$ and $B$ is the population of city B in a given year. Let $a^\prime$ and $b^\prime$ be the respective populations of cities $A$ and $B$ after all the previous movement.

Then the function $F : \mathbb{R}^2 \to \mathbb{R}^2$ that maps $\binom{a}{b}$ to $\binom{a^\prime}{b^\prime}$. In fact, this function is linear, so we can represent it with a matrix. What is that matrix?

After one year, the population of $A$ is given by $.9 a + .2 b$ (90% of the residents of A last year, and 20% of the residents of B last year). Similarly, the population of $B$ is given by $.1 a + .8 b$. That is, the matrix representation of $F$ is:

$$F = \begin{pmatrix}.9 & .2 \\ .1 & .8 \end{pmatrix}$$

**Exercise**: Compute $F \cdot F$. What does this matrix represent?

<details>
<summary>Solution</summary>
<p>$$\begin{pmatrix}.9 & .2 \\ .1 & .8 \end{pmatrix} \begin{pmatrix} .9 & .2 \\ .1 & .8 \end{pmatrix} = \begin{pmatrix} .83 & .34 \\ .17 & .66 \end{pmatrix}$$</p>
<p>This represents what happens after 2 years. That is: in two years, the population of A will be $.83a + .34 b$, and the population of B will be $.17 a + .66 b$.</p>
</details>

**Question**: Is there a "stable" population? That is, are there $a$ and $b$ so that $F(\binom{a}{b}) = \binom{a}{b}$? Let's see!

$$
\begin{align}
.9 a + .2b &= a \\
.1 a + .8 b &= b \\
\hline
-.1a + .2b &= 0 \\
.1a - .2b &+ 0 \\
\hline
.1a &= 2b \\
a &= 2b
\end{align}
$$

Any numbers $a$ and $b$ such that $a = 2b$ should work. So in other words, $F(\binom{200}{100})$ should be equal to $\binom{200}{100}$. Is it?

(Aside: what is the *geometry* of the set of solutions here? Think of $a$ as being on the $x$-axis and $b$ as being on the $y$-axis.)

# Identity Matrix

**Exercise**: Consider $I : \mathbb{R}^3 \to \mathbb{R}^3$ defined by $I(\vec{v}) = \vec{v}$. $I$ is called the **identity** function (since the output of the function is *identical* to the input).

1. Show that $I$ is linear.
2. What is the matrix representation of $I$? (What do we need to compute to figure this out?)
3. Can we generalize this to $\mathbb{R}^n$? If $I_n : \mathbb{R}^n \to \mathbb{R}^n$ is defined so that $I_n(\vec{v}) = \vec{v}$, is $I_n$ linear? What would its matrix representation be?

## Multiplying by $I$

Consider the matrix $A = \begin{pmatrix}0 & 1 & 2 \\\ 2 & 1 & -1 \\\ 1 & 1 & 1\end{pmatrix}$. What is $AI$? What is $IA$? Can we prove something about this in general?

**Theorem**: Let $A : \mathbb{R}^n \to \mathbb{R}^n$ be any (linear) function, and $I_n : \mathbb{R}^n \to \mathbb{R}^n$ be the identity function given by $I_n(\vec{v}) = \vec{v}$. Then $(A \circ I_n)(\vec{v}) = A(\vec{v})$ and $(I_n \circ A)(\vec{v}) = A(\vec{v})$.

As matrices, this means that $AI_n = A$ and $I_n A = A$.

# Kernels / Nullspaces

In the above problem, we simplified the question to determining when a particular system of equations, where the right hand side are all zeroes, has a solution. A system of equations where the constant terms are all zeroes is called a **homogeneous** system.

This is equivalent to asking the following question: given a linear function $F : \mathbb{R}^n \to \mathbb{R}^m$, which vectors $\vec{v} \in \mathbb{R}^n$ are such that $F(\vec{v}) = \vec{0}$, the **zero vector**. (There is a *different* zero vector for each dimension, but we usually just figure out the dimension from the appropriate context.)

In general: every homogeneous system of equations has a solution: namely, the zero vector. Why? Let's look at an example:

$$
\begin{pmatrix}2 & -1 & 0 \\ 1 & 5 & 3\end{pmatrix} \begin{pmatrix} 0 \\ 0 \\ 0 \end{pmatrix} = \begin{pmatrix}0 \\ 0\end{pmatrix}
$$

Do you see why? In fact, we argued this earlier, just using the definition of linearity. Since $\vec{0} + \vec{0} = \vec{0}$, we know that $F(\vec{0}) + F(\vec{0}) = F(\vec{0})$, and so subtracting $F(\vec{0})$ from both sides, we get $F(\vec{0}) = \vec{0}$.

In the system we saw in the application, there was a non-zero solution. That is, the set of solutions contained a vector $\vec{v} \neq \vec{0}$.

**Definition**: If $F : \mathbb{R}^n \to \mathbb{R}^m$ is linear, the **kernel** of $F$ is the set $ker(F) = \\{ \vec{v} \in \mathbb{R}^n : F(\vec{v}) = \vec{0} \\}$.

If $A$ is an $m \times n$ matrix representing $F$, we refer to the same concept as the **nullspace** of $A$, or $null(A)$.

## Example

Find the nullspace of the following matrix:

$$
A = \begin{pmatrix} 1 & 1 & -1 \\ 2 & 0 & 5 \end{pmatrix}
$$

How would we find this? Well again, this is really asking about the following system of equations:

$$
\begin{align}
x_1 + &x_2 - &x_3 &= 0 \\
2x_1 & &+ &5x_3 &=0
\end{align}
$$

We can multiply the first equation by -2 and add that to the second equation, to eliminate $x_1$ in that second equation:

$$
\begin{align}
x_1 &+ x_2 &- x_3 &= 0 \\
&-2 x_2 &+ 7x_3 &= 0
\end{align}
$$

We can divide the second equation by -2:

$$
\begin{align}
x_1 + &x_2 &- x_3 &= 0 \\
& x_2 &- \frac{7}{2} x_3 &= 0
\end{align}
$$

Now we can take (-1) times the second equation, add it back to the first, and eliminate $x_2$ in that equation:

$$
\begin{align}
x_1 & &+ \frac{5}{2} x_3 &= 0 \\
& x_2 &- \frac{7}{2} x_3 &= 0
\end{align}
$$

Now we can solve for $x_1$ and $x_2$ in terms of $x_3$! $x_1 = -\frac{5}{2}x_3$ and $x_2 = \frac{7}{2} x_3$. $x_3$ is a free variable, and can be any real number, so for example, $x_3 = 2$ is a solution. In that case, we get $\vec{v} = \begin{pmatrix}-5 \\\ 7 \\\ 2 \end{pmatrix}$.

What are all the solutions here?

$null(A) = \\{ \begin{pmatrix}-\frac{5}{2} x \\\ \frac{7}{2} x \\\ x \end{pmatrix} : x \in \mathbb{R} \\}$. There are infinitely many solutions! In fact, this is a *one-dimensional* subspace of $\mathbb{R}^3$ (it's a line)!

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

or: an augmented matrix which looks like: $\left(\begin{matrix}1 & 0 & 0 & 0 \\\ 0 & 1 & 0 & 0 \\\ 0 & 0 & 1 & 0 \\\ 0 & 0 & 0 & 1 \end{matrix}\right\| \: \left. \begin{matrix} \vdots \end{matrix} \right)$. That is, get it into an *identity matrix*.

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

Try to eliminate the 2 in the bottom left: $(-1) \cdot$ row 1 + row 2:

$$
\left(\begin{matrix}
  1 & 2 \\
  0 & 0
  \end{matrix}\right| \:
  \left. \begin{matrix} 1 \\ 0 \end{matrix}\right)
$$

So what does this mean? We end up with, basically, $x + 2y = 1$. This means any $\binom{x}{y}$ where $x + 2y = 1$ will work. So, for example, $x = -1$ and $y = 1$ will work. But also $x = -3$ and $y = 2$ will work, and so will $x = 1$ and $y = 0$. In fact, there are infinitely many different solutions here! What do the solutions look like, geometrically?

## Allowable Operations

Remember that $\left(A \right\| \: \left. \vec{b} \right)$ represents the system of equations $A(\vec{x}) = \vec{b}$. That is, we're asking the question: "find all $\vec{x}$ such that $A(\vec{x}) = \vec{b}$." (If $\vec{b} = \vec{0}$, this is asking about the null space of $A$. But in general we can ask about any vector.)

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

Nowe we have an upper triangular matrix. We are almost done: we can get this into the identity matrix by adding $-\frac{3}{5}\cdot$ row 2 + row 1:

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

## Linear combinations / Spans

**Question**: Is the vector $\begin{pmatrix}1 \\\ 1 \\\ 1\end{pmatrix}$ in the span of $\begin{pmatrix}0 \\\ 1 \\\ 1\end{pmatrix}$, $\begin{pmatrix}1 \\\ 1 \\\ 0\end{pmatrix}$ and $\begin{pmatrix}2 \\\ 3 \\\ 1 \end{pmatrix}$?

How would we figure this out? By setting up a system of equations and solving it! What's the system of equations we'd need to set up?
