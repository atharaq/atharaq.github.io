# Linear Lesson 9: Gaussian Elimination
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

A country has three types of coins of unknown values, $x_1$, $x_2$, and $x_3$. We are able to make 34 cents using $4x_1 + 2x_2 + x_3 = 34$, and 85 cents using $5x_1 + 4x_2 + 3x_3 = 85$. Determine the values of the coins, if possible.

$$
\left(\begin{matrix}4 & 2 & 1 \\
  5 & 4 & 3 \: \right|
  \end{matrix}
\: \left. \begin{matrix}
34 \\
85
\end{matrix}\right)
$$

In RREF, we should get:

$$
\left(\begin{matrix}1 & 0 & -\frac{1}{3} \\
  0 & 1 & \frac{7}{6} \: \right|
  \end{matrix}
\: \left. \begin{matrix}
-\frac{17}{3} \\
\frac{85}{3}
\end{matrix}\right)
$$

This corresponds to the equations:

$$
\begin{align}
x_1 - \frac{1}{3} x_3 &= -\frac{17}{3} \\
x_2 + \frac{7}{6} x_3 &= \frac{85}{3}
\end{align}
$$

Or:

$$
\begin{align}
x_1 = - \frac{17}{3} + \frac{1}{3} x_3 \\
x_2 = \frac{85}{3} - \frac{7}{6} x_3 \\
x_3 = 0 +  1 x_3
\end{align}
$$

$x_3$ is a free variable, and so it can be anything. That means there are infinitely many solutions, one for each possible value of $x_3$. So all solutions would be of the form $\begin{pmatrix}-\frac{17}{3} \\\ \frac{85}{3} \\\ 0 \end{pmatrix} + a \cdot \begin{pmatrix}\frac{1}{3} \\\ -\frac{7}{6} \\\ 1 \end{pmatrix}$, where $a$ is any real number.

Geometrically, this is the line through the point $\begin{pmatrix}-\frac{17}{3} \\\ \frac{85}{3} \\\ 0 \end{pmatrix}$ that goes in the direction of the vector $\begin{pmatrix}\frac{1}{3} \\\ -\frac{7}{6} \\\ 1 \end{pmatrix}$. [Take a look at this visualization](https://sagecell.sagemath.org/?z=eJx9UctugzAQvCPxD3uLIaaxFaWpKvnMD_SGONDgBKuJHZk8gK_v2sEhiapawstqxuuZcS23UHWyJd1BaZFx2h2qTnDaj21_a4exHW5tmv5c6zb5jCPAJTsQcJGbk7GEcMooS5IR6R8QRvkDMjwhiAUkRwD2SstlTQqnKpWdV4W1DDcH6lzcqb2n9l4x1v-og6cO3g3WF6qVp7PVkMdRHNUYjzv11Vhz3jXkaJQ-USecgtS1b0WRLSksSwobszdWzKysZyEb5ya31bFRm5aMF2yNBQVKg630TpIwp2DlNLTgZRjh1nfVSpzkIZiDSlHBhHpzlbXmShyRevrci7xJ8vsf9pw6__rZilFw3-sPHrpML1XwBVrN1ot3Cigwjh5escj42qEfK7czh95DD_ENGB0FZK4wsInibRHyPCCh0KpBCs6ciPytbdBe8gsMo7vt&lang=sage&interacts=eJyLjgUAARUAuQ==).

As an example of a solution, let $a = 20$. Then:

$$
\begin{align}
x_1 = -\frac{17}{3} + \frac{20}{3} = 1 \\
x_2 = \frac{85}{3} - \frac{140}{6} = \frac{85}{3} - \frac{70}{3} = \frac{15}{3} = 5 \\
x_3 = 20
\end{align}
$$

# Problem Set Questions

Reminder: problem set 2 is due **tonight** via Moodle.

# Homogeneous Systems

Recall that to solve system

$$
\left(\begin{matrix}4 & 2 & 1 \\
  5 & 4 & 3 \: \right|
  \end{matrix}
\: \left. \begin{matrix}
34 \\
85
\end{matrix}\right)
$$

we first put it into RREF:

$$
\left(\begin{matrix}1 & 0 & -\frac{1}{3} \\
  0 & 1 & \frac{7}{6} \: \right|
  \end{matrix}
\: \left. \begin{matrix}
-\frac{17}{3} \\
\frac{85}{3}
\end{matrix}\right)
$$

Then, from RREF, we were able to find a **particular** solution, $\begin{pmatrix}-\frac{17}{3} \\\ \frac{85}{3} \\\ 0 \end{pmatrix}$, **and** the general form for the entire set of all solutions: $\\{ $\begin{pmatrix}-\frac{17}{3} \\\ \frac{85}{3} \\\ 0 \end{pmatrix} + a \cdot \begin{pmatrix}\frac{1}{3} \\\ -\frac{7}{6} \\\ 1 \end{pmatrix} : a \in \mathbb{R} \\}$.

If we isolate the two parts of this solution set, we have one particular solution, $\begin{pmatrix}-\frac{17}{3} \\\ \frac{85}{3} \\\ 0 \end{pmatrix}$, and the other part, $a \cdot \begin{pmatrix}\frac{1}{3} \\\ -\frac{7}{6} \\\ 1 \end{pmatrix}$ is the set of all "homogeneous" solutions!

**Recall**: a *homogeneous* system of equations is a system of the form $A\vec{x} = \vec{0}$.

In general, to understand the set of all solutions to A\vec{x} = \vec{b}$, it suffices to find just **one** particular solution $\vec{v}$ to this equation (so that $A\vec{v} = \vec{b}$), and to understand the set of all homogeneous solutions (ie, the nullspace of $A$).

**Theorem**: Let $A$ be a matrix and consider the system $A\vec{x} = \vec{b}$. Then:  
1. If $\vec{v}$ is a particular solution and $\vec{w}$ is a homogeneous solution, then $\vec{v} + \vec{w}$ is another particular solution.
2. If $\vec{v}$ and $\vec{u}$ are particular solutions, then there is a homogeneous $\vec{w}$ such that $\vec{v} = \vec{u} + \vec{w}$.

**Proof**:

The proof for both of these is linearity, along with the definitions. Recall that $\vec{v}$ is a particular solution means that $A\vec{v} = \vec{b}$, and $\vec{w}$ is a homogeneous solution means $A\vec{w} = \vec{0}$.

1. To prove (1), consider $A(\vec{v} + \vec{w})$. By linearity, this is equal to $A\vec{v} + A\vec{w}$. But above we know that $A\vec{v} = \vec{b}$ and $A\vec{w} = \vec{0}$, so $A\vec{v} + A\vec{w} = \vec{b} + \vec{0}$. For any dimension, the zero vector does nothing to the vector $\vec{b}$. (Why?) So this is just $\vec{b}$! That means, $A(\vec{v} + \vec{w}) = \vec{b}$, so $\vec{v} + \vec{w}$ is a particular solution to this system.
2. To prove (2), just let $\vec{w} = \vec{v} - \vec{u}$. Then $A(\vec{w}) = A\vec{v} - A\vec{u}$, again by linearity. So $A(\vec{w}) = \vec{b} - \vec{b} = \vec{0}$ (why?).


## Nullspaces

Consider a linear function $F : \mathbb{R}^n \to \mathbb{R}^m$ (or an $m \times n$ matrix). Then $\vec{0} \in \mathbb{R}^n$ is in $null(F)$: $F(\vec{0}) = \vec{0}$. What are the other possibilities?

Suppose there is a vector $\vec{v} \neq \vec{0}$ such that $F(\vec{v}) = \vec{0}$. **Claim**: all scalar multiples of $\vec{v}$ are in the nullspace. Why is this? Because of linearity: $F(a \cdot \vec{v}) = a \cdot F(\vec{v}) = a \cdot \vec{0} = \vec{0}$ (why?).

So if there is *any* non-zero vector $\vec{v}$ in the nullspace of a matrix, then at least the entire one-dimensional span of $\vec{v}$ is in the nullspace (that is, the entire line that goes through $\vec{v}$). What if there are vectors $\vec{v}$ and $\vec{w}$, on different lines, in the nullspace? Then again, by linearity, any linear combination of $\vec{v}$ and $\vec{w}$ will be in the nullspace, since $F(a \cdot \vec{v} + b \cdot \vec{w}) = a \cdot F(\vec{v}) + b \cdot F(\vec{w}) = \vec{0} + \vec{0}$, so the entire plane spanned by those two vectors will be in the nullspace!

That is: if the domain of $F$ is $\mathbb{R}^n$, the nullspace of $F$ could be:

* 0-dimensional (just the zero vector)
* 1-dimensional (a line)
* 2-dimensional (a plane)
* $\ldots$
* $n$-dimensional (???)

In this last case, the only $n$-dimensional subspace of $\mathbb{R}^n$ is $\mathbb{R}^n$ itself: everything! That is, $F(\vec{v}) = \vec{0}$ always. Can you think of a matrix (let's say a $2 \times 2$ matrix) that sends *every* vector to the zero vector?

## Exercise

Determine the set of all solutions to the following augmented matrix system:

$$
\left(\begin{matrix}1 & -3 \\
  2 & -1 \: \right|
  \end{matrix}
\: \left. \begin{matrix}
1 \\
1
\end{matrix}\right)
$$

In RREF:

$$
\left(\begin{matrix}1 & 0 \\
  0 & 1 \: \right|
  \end{matrix}
\: \left. \begin{matrix}
\frac{2}{5} \\
-\frac{1}{5}
\end{matrix}\right)
$$

Here we get the solution $x_1 = \frac{2}{5}$ and $x_2 = -\frac{1}{5}$. There are no free variables, so the only homogeneous solution is $\binom{0}{0}$!

**Important**: A system of equations $A\vec{x} = \vec{b}$ has a **unique** solution if the **only** homogeneous solution is the vector $\vec{0}$. (This does not depend on $\vec{b}$ at all!).

In general: when is the only solution to the homogeneous system $A\vec{x} = \vec{0}$ just the zero vector $\vec{0}$? If the matrix $A$ is **invertible**!

# Inverse Matrices

**Definition**: An $n \times n$ ("square") matrix $A$ is **invertible** if there an $n \times n$ matrix $B$ such that $AB = I_n$ and $BA = I_n$ (two-sided). We write $B = A^{-1}$.

Notice that the number of rows must be the same as the number of columns here. This is important: a $3 \times 2$ matrix is never invertible, neither is a $2 \times 3$ matrix.

In function terms: $F : \mathbb{R}^n \to \mathbb{R}^n$ is invertible if there a matrix $G : \mathbb{R}^n \to \mathbb{R}^n$ such that $F(G(\vec{v})) = \vec{v}$ and $G(F(\vec{v})) = \vec{v}$.

How do we find $A^{-1}$? Gaussian Elimination, again! But instead of writing down the system $\left(A \\: \right\| \\: \left. \vec{b} \right)$, we write down $\left(A \\: \right\| \\: \left. I \right)$. Then, if $A$ is invertible, RREF will give us $\left(I \\: \right\| \\: \left. A^{-1} \right)$.

**Aside**: Why does this work? Technically during Gaussian Elimination, we only allow operations that represent multiplication by invertible matrices. For example, if $A$ is the matrix $\begin{pmatrix} 1 & 2 \\\ 2 & -1 \end{pmatrix}$, and we switch row 1 and row 2, technically what we are doing is taking the matrix $I = \begin{pmatrix}1 & 0 \\\ 0 & 1 \end{pmatrix}$, switching the rows of this matrix to get $M = \begin{pmatrix} 0 & 1 \\\ 1 & 0 \end{pmatrix}$, and then multiplying $MA$. Try it out: what do you get if you multiply $\begin{pmatrix} 0 & 1 \\\ 1 & 0 \end{pmatrix} \begin{pmatrix} 1 & 2 \\\ 2 & -1 \end{pmatrix}$.

## Example

$$
\left(\begin{matrix}1 & -3 \\
  2 & -1 \: \right|
  \end{matrix}
\: \left. \begin{matrix}
1 & 0 \\
0 & 1
\end{matrix}\right)
$$

$-2 \cdot$ R1 + R2:

$$
\left(\begin{matrix}1 & -3 \\
  0 & 5 \: \right|
  \end{matrix}
\: \left. \begin{matrix}
1 & 0 \\
-2 & 1
\end{matrix}\right)
$$

$\frac{1}{5} \cdot$ R2:

$$
\left(\begin{matrix}1 & -3 \\
  0 & 1 \: \right|
  \end{matrix}
\: \left. \begin{matrix}
1 & 0 \\
-\frac{2}{5} & \frac{1}{5}
\end{matrix}\right)
$$

Now eliminate the top right with 3R2 + R1:

$$
\left(\begin{matrix}1 & 0 \\
  0 & 1 \: \right|
  \end{matrix}
\: \left. \begin{matrix}
-\frac{1}{5} & \frac{3}{5} \\
-\frac{2}{5} & \frac{1}{5}
\end{matrix}\right)
$$

So that means the inverse of $\begin{pmatrix}1 & -3 \\\ 2 & -1\end{pmatrix}$ is $\begin{pmatrix}-\frac{1}{5} & \frac{3}{5} \\\ -\frac{2}{5} & \frac{4}{5} \end{pmatrix}$.

**Exercise**: Show that these are inverses by multiplying them in both ways, and showing that their products are equal to the identity matrix.

## Exercise

Find the inverses of the following, if they exist:

$$
\begin{pmatrix}
0 & 0 & 1 \\
1 & 0 & 1 \\
0 & 1 & 0
\end{pmatrix}
$$

$$
\begin{pmatrix}
1 & 0 & 2 \\
0 & 1 & -1 \\
2 & 1 & 3
\end{pmatrix}
$$

# Upcoming

**Exam 1**: Thursday, **March 10** (one week from today). We will review on Monday.
