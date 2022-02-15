# Linear Lesson 5: Matrices
{:.no_toc}

1. Table of Contents
{:toc}

# Quiz

# Matrices

As another example, consider the function $L : \mathbb{R}^2 \to \mathbb{R}$ defined by $L(\binom{x}{y}) = x - 3y$.

First, notice that $L$ is **linear**. To see this, we first check that $L$ respects scalar multiplication. Let $\binom{x}{y}$ be a vector and $a$ be a scalar. Then $L(\binom{x}{y}) = x - 3y$, and $L(a \cdot \binom{x}{y}) = ax - 3ay$, or $a(x - 3y)$. That is, $L(a \cdot \binom{x}{y}) = a \cdot L(\binom{x}{y})$.

Next, we see that $L$ respects vector addition. Let $\binom{u_1}{u_2}$ and $\binom{v_1}{v_2}$ be two vectors. Then $L(\binom{u_1}{u_2}) + L(\binom{v_1}{v_2}) = (u_1 - 3u_2) + (v_1 - 3v_2)$. Re-arranging, this is $(u_1 + v_1) - 3(u_2 + v_2)$, which is $L(\binom{u_1}{u_2} + \binom{v_1}{v_2})$.

Now, since $L$ is linear, we can write it as a matrix:

1. What is $L(\binom{1}{0})$?
2. What is $L(\binom{0}{1})$?

Since $L(\binom{1}{0}) = 1$, and $L(\binom{0}{1}) = -3$, the matrix representation of $L$ is:

$$
\begin{pmatrix}
1 & -3
\end{pmatrix}
$$

This matrix has 1 **row** and 2 **columns**. That is, it is a $1 \times 2$ matrix. It represents the linear function $L \mathbb{R}^2 \to \mathbb{R}$! In general, if a matrix is $m \times n$ (m rows, n columns), what kind of function does it represent?

## Exercise

Let $L : \mathbb{R}^2 \to \mathbb{R}^3$ be defined by the function $L(\binom{x}{y}) = \begin{pmatrix}x - y \\\ x + y \\\ 2x \end{pmatrix}$.

1. Show that $L$ respects scalar multiplication. That is, show that $L(a \cdot \binom{x}{y}) = a \cdot L(\binom{x}{y})$.
2. Show that $L$ respects vector addition. That is, show that $L(\binom{u_1}{u_2}) + L(\binom{v_1}{v_2}) = L(\binom{u_1}{u_2} + \binom{v_1}{v_2})$.
3. Determine $L(\binom{1}{0})$ and $L(\binom{0}{1})$.
4. Write down the matrix representation of $L$. What are the dimensions of this matrix? (How many rows, how many columns)

## Non-Example

Consider the function $f : \mathbb{R}^2 \to \mathbb{R}$ given by $f(\binom{x}{y}) = xy$. Is this function linear?

If it is, we have to get that $f(a \cdot \binom{x}{y}) = a \cdot f(\binom{x}{y})$ for every scalar $a$ and vector $\binom{x}{y}$. Since $a \cdot \binom{x}{y} = \binom{ax}{ay}$, we check $f(\binom{ax}{ay})$. Plugging in, we get $f(\binom{ax}{ay}) = (ax)(ay) = a^2 xy$. In particular, if $x = y = 1$, and $a = 2$, this is not equal to $a \cdot f(\binom{x}{y})$.

That is: $f(\binom{1}{1}) = 1$, but $f(\binom{2}{2}) = 4$, so this function is **not** linear!

## Matrix Notation

Every **linear** function $L : \mathbb{R}^n \to \mathbb{R}^m$ has a matrix representation. How do we find it? First, write down the "standard basis vectors" for $\mathbb{R}^n$. There are exactly $n$ of these: $\begin{pmatrix}1 \\\ 0 \\\ \vdots \\\ 0 \end{pmatrix}, \begin{pmatrix}0 \\\ 1 \\\ \vdots \\\ 0 \end{pmatrix}, \ldots, \begin{pmatrix}0 \\\ 0 \\\ \vdots \\\ 1 \end{pmatrix}$. Call these vectors $\vec{e_1}, \vec{e_2}, \ldots, \vec{e_n}$.

Then the **columns** of the matrix representing $L$ are exactly given by $L(\vec{e_1}), L(\vec{e_2}), \ldots, L(\vec{e_n})$! There are $n$ columns. Each column is a vector in $\mathbb{R}^m$, so there are $m$ rows!

## Exercise

1. Let $F : \mathbb{R}^2 \to \mathbb{R}^3$ be the linear function specified by $F(\binom{1}{0}) = \begin{pmatrix}1 \\\ 0 \\\ 2 \end{pmatrix}$ and $F(\binom{0}{1}) = \begin{pmatrix}0 \\\ 1 \\\ 1\end{pmatrix}$. Write the matrix representation of $F$. Is it $2 \times 3$ or $3 \times 2$?
2. Let $G : \mathbb{R}^3 \to \mathbb{R}$ be the linear function specified by $G(\begin{pmatrix}1 \\\ 0 \\\ 0\end{pmatrix}) = 1$, $G(\begin{pmatrix}0 \\\ 1 \\\ 0\end{pmatrix}) = 0$, and $G(\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}) = -5$. Write the matrix representation of $G$.

# Composition

Recall the notion of *function composition*. If $f : X \to Y$ and $g : Y \to Z$ are any two functions, then $(g \circ f) : X \to Z$ is a function defined by $(g \circ f)(x) = g(f(x))$. That is: take the output of $f(x)$ and plug that into $g$.

1. Does $F \circ G$ make sense? Why or why not?
2. Does $G \circ F$ make sense? Yes! Since $F(\vec{v}) \in \mathbb{R}^3$, then we can plug that in to $G$!
   a. What is $(G \circ F)(\binom{1}{0})$?
   b. What is $(G \circ F)(\binom{0}{1})$?

Since $F(\binom{1}{0}) = \begin{pmatrix}1 \\\ 0 \\\ 2\end{pmatrix} = \begin{pmatrix}1 \\\ 0 \\\ 0\end{pmatrix} + 2 \begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}$, we use linearity to plug that in to $G$:

$$
G(\begin{pmatrix}1 \\\ 0 \\\ 2) &= G(\begin{pmatrix}1 \\\ 0 \\\ 0\end{pmatrix} + 2 \begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}) \\
&= G(\begin{pmatrix}1 \\\ 0 \\\ 0\end{pmatrix}) + 2 G(\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}) \\
&= 1 + 2(-5) \\
&= -9
$$

**Exercise**: Compute $(G \circ F)(\binom{0}{1})$. (First compute $F(\binom{0}{1})$, then break that down into linear combinations of $\begin{pmatrix}1 \\\ 0 \\\ 0\end{pmatrix}, \begin{pmatrix}0 \\\ 1 \\\ 0 \end{pmatrix}$ and $\begin{pmatrix}0 \\\ 0 \\\ 1 \end{pmatrix}$ and use linearity of $G$).

**Question**: Is $(G \circ F)$ linear? We would need to check if $(G \circ F)(\vec{v} + \vec{w}) = (G \circ F)(\vec{v}) + (G \circ F)(\vec{w})$, and if $(G \circ F)(a \cdot \vec{v}) = a \cdot (G \circ F)(\vec{v})$.

To get you started: notice that $(G \circ F)(\vec{v} + \vec{w}) = G(F(\vec{v} + \vec{w}))$ by definition of composition. Then $F$ is linear, so this is equal to $G(F(\vec{v}) + F(\vec{w}))$. Now use the fact that $G$ is linear!

The answer turns out to be yes: the composition of two linear functions is linear. You will prove this on the next problem set. But, since it is linear, we can represent it as a matrix:

$(G \circ F) = \begin{pmatrix}-9 & -5\end{pmatrix}$

Notice that $G$ is a $1 \times 3$ matrix, $F$ is a $3 \times 2$ matrix, and $(G \circ F)$ is a $1 \times 2$ matrix:

$$
\begin{pmatrix}1 & 0 & -5\end{pmatrix} \circ \begin{pmatrix}1 & 0 \\ 0 & 1 \\ 2 & 1 \end{pmatrix} = \begin{pmatrix}-9 & -5 \end{pmatrix}
$$

## Exercise

## Definition

# Application

# Homework
