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

What about all the other columns of $(B \circ A)$? Can you describe the general rule for multiplying matrices?

# Application: Population Dynamics

Suppose we have two cities $A$ and $B$, and in both cities, birth rates are equal to death rates, so the total population is stable. Every year, 10\% of residents of city A move to city B, and 20\% of residents of city B move to city A. Let $a$ be the population of city $A$ and $B$ is the population of city B in a given year. Let $a^\prime$ and $b^\prime$ be the respective populations of cities $A$ and $B$ after all the previous movement.

Then the function $F : \mathbb{R}^2 \to \mathbb{R}^2$ that maps $\binom{a}{b}$ to $\binom{a^\prime}{b^\prime}$. In fact, this function is linear, so we can represent it with a matrix. What is that matrix?

After one year, the population of $A$ is given by $.9 a + .2 b$ (90\% of the residents of A last year, and 20\% of the residents of B last year). Similarly, the population of $B$ is given by $.1 a + .8 b$. That is, the matrix representation of $F$ is:

$$F = \begin{pmatrix}.9 & .2 \\ .1 & .8 \end{pmatrix}$$

**Exercise**: Compute $F \cdot F$. What does this matrix represent?

<details>
<summary>Solution</summary>
<p>$$\begin{pmatrix}.9 & .2 \\ .1 & .8 \end{pmatrix} \begin{pmatrix} .9 && .2 \\ .1 & .8 \end{pmatrix} = \begin{pmatrix} .83 & .34 \\ .17 & .66 \end{pmatrix}$$</p>
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
x_1 &+ x_2 &- x_3 &= 0 \\
2x_1 & &+ 5x_3 &=0
\end{align}
$$

We can multiply the first equation by -2 and add that to the second equation, to eliminate $x_1$ in that second equation:

$$
\begin{align}
x_1 &+ x_2 &- x_3 &= 0 \\
&-2_x2 &+ 7x_3 &= 0
\end{align}
$$

We can divide the second equation by -2:

$$
\begin{align}
x_1 &+ x_2 &- x_3 &= 0 \\
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

Now we can solve for $x_1$ and $x_2$ in terms of $x_3$! $x_1 = -\frac{5}{2}x_3$ and $x_2 = frac{7}{2} x_3$. $x_3$ is a free variable, and can be any real number, so for example, $x_3 = 2$ is a solution. In that case, we get $\vec{v} = \begin{pmatrix}-5 \\\ 7 \\\ 2 \end{pmatrix}$.

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

Replacing row 1 by 1(row 2) + row 1:

$$
\left(\begin{matrix}1 & 0 & \frac{5}{2} \\ 0 & 1 & -\frac{7}{2} \end{matrix} \: \right| \: \left.\begin{matrix} 0 \\ 0 \end{matrix}\right)
$$

At this point, there is nothing left to do. (Why not?) This matrix is in **reduced row echelon form**:

1. The leading entry of each row is 1.
2. Each leading entry is to the right of the leading entry of the previous row.
3. If a row has only zeroes, it's at the bottom.

# Problem Set 2

# Presentation 1
