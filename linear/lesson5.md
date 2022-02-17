# Linear Lesson 5: Matrices
{:.no_toc}

1. Table of Contents
{:toc}

<!--
1. 2:30 - 2:50 quiz
2. 2:50 - 3:10 matrix intro + exercise
3. 3:10 - 3:40 non-ex / notation / exercise
4. 3:40 - 4:10 composition intro
-->

# Quiz

# Matrices

Consider the function $L : \mathbb{R}^2 \to \mathbb{R}$ defined by $L(\binom{x}{y}) = x - 3y$.

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

This matrix has 1 **row** and 2 **columns**. That is, it is a $1 \times 2$ matrix. It represents the linear function $L : \mathbb{R}^2 \to \mathbb{R}$! In general, if a matrix is $m \times n$ (m rows, n columns), what kind of function does it represent?

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

**Notation**: For an $m \times n$ matrix $A$, we denote its entries as  $a_{i, j}$. This is the element in the $i$-th row and $j$-th column of the matrix. The textbook uses the notation $a^i_j$

If $A$ represents a function $L$, then *outputs* of $L$ are always *linear combinations* of the columns of $A$. That is: the image of $L$ is the span of the columns of $A$. Why?

## Exercise

1. Let $F : \mathbb{R}^2 \to \mathbb{R}^3$ be the linear function specified by $F(\binom{1}{0}) = \begin{pmatrix}1 \\\ 0 \\\ 2 \end{pmatrix}$ and $F(\binom{0}{1}) = \begin{pmatrix}0 \\\ 1 \\\ 1\end{pmatrix}$. Write the matrix representation of $F$. Is it $2 \times 3$ or $3 \times 2$?
2. Use the fact that $F$ is linear to compute $F(\binom{3}{1})$.
3. Let $G : \mathbb{R}^3 \to \mathbb{R}$ be the linear function specified by $G\left(\begin{pmatrix}1 \\\ 0 \\\ 0\end{pmatrix}\right) = 1$, $G\left(\begin{pmatrix}0 \\\ 1 \\\ 0\end{pmatrix}\right) = 0$, and $G\left(\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}\right) = -5$. Write the matrix representation of $G$.
4. Use the fact that $G$ is linear to compute $G\left(\begin{pmatrix}2 \\\ 1 \\\ 2\end{pmatrix}\right)$.

## Notice

Let's look at the computation fo $F(\binom{3}{1})$ a little closer.

$$
\begin{align}
F(\binom{3}{1}) &= 3 \cdot \begin{pmatrix}1 \\\ 0 \\\ 2 \end{pmatrix} + 1 \cdot \begin{pmatrix}0 \\\ 1 \\\ 1 \end{pmatrix} \\
&= \begin{pmatrix}3 \cdot 1 + 1 \cdot 0 \\\ 3 \cdot 0 + 1 \cdot 1 \\\ 3 \cdot 2 + 1 \cdot 1 \end{pmatrix}
\end{align}
$$

In other words: to find $F(\binom{3}{1})$, we start with the matrix representation of $F$. Then we end up with a vector of the form $\begin{pmatrix} \text{row 1 of F} \cdot  \binom{3}{1} \\\ \text{row 2 of F} \cdot \binom{3}{1} \\\ \text{row 3 of F} \cdot \binom{3}{1}\end{pmatrix}$, using the *dot product* notation (from Calculus III).

**Definition**: Let $\vec{v} = \begin{pmatrix}v_1 \\\ v_2 \\\ \vdots \\\ v_n\end{pmatrix}$ and $\vec{w} = \begin{pmatrix} w_1 \\\ w_2 \\\ \vdots \\\ w_n \end{pmatrix}$. Then $\vec{v} \cdot \vec{w} = v_1 w_1 + v_2 w_2 + \ldots + v_n w_n$.

This gives us an easy way to compute outputs of linear functions!

**Exercise**:

Let $R_{\pi/4} = \begin{pmatrix} \frac{\sqrt{2}}{2} & -\frac{\sqrt{2}}{2} \\\ \frac{\sqrt{2}}{2} & \frac{\sqrt{2}}{2} \end{pmatrix}$ be the rotation matrix, rotating a vector by $\frac{\pi}{4}$ (45 degrees).

1. What is $R_{\pi/4}(\binom{1}{2})$?
2. What is $R_{\pi/4}(R_{\pi/4}(\binom{1}{2}))$?

# Composition

Recall the notion of *function composition*. If $f : X \to Y$ and $g : Y \to Z$ are any two functions, then $(g \circ f) : X \to Z$ is a function defined by $(g \circ f)(x) = g(f(x))$. That is: take the output of $f(x)$ and plug that into $g$.

1. Does $F \circ G$ make sense? Why or why not?
2. Does $G \circ F$ make sense? Yes! Since $F(\vec{v}) \in \mathbb{R}^3$, then we can plug that in to $G$!
   a. What is $(G \circ F)(\binom{1}{0})$?
   b. What is $(G \circ F)(\binom{0}{1})$?

Since $F(\binom{1}{0}) = \begin{pmatrix}1 \\\ 0 \\\ 2\end{pmatrix}$, we can plug that in to $G$ and use the "dot product" to compute it:

$$
\begin{align}
G\left(\begin{pmatrix}1 \\ 0 \\ 2\end{pmatrix}\right) &= \begin{pmatrix}1 & 0 & -5\end{pmatrix} \left(\begin{pmatrix}1 \\ 0 \\ 2\end{pmatrix}\right) \\
&= \left( \begin{pmatrix}1 \\ 0 \\ -5\end{pmatrix} \cdot \begin{pmatrix}1 \\ 0 \\ 2 \end{pmatrix} \right) \\
&= \left(1 \cdot 1 + 0 \cdot 0 + (-5) \cdot 2 \right) \\
&= -9
\end{align}
$$

**Exercise**: Compute $(G \circ F)(\binom{0}{1})$.

**Question**: Is $(G \circ F)$ linear? We would need to check if $(G \circ F)(\vec{v} + \vec{w}) = (G \circ F)(\vec{v}) + (G \circ F)(\vec{w})$, and if $(G \circ F)(a \cdot \vec{v}) = a \cdot (G \circ F)(\vec{v})$.

To get you started: notice that $(G \circ F)(\vec{v} + \vec{w}) = G(F(\vec{v} + \vec{w}))$ by definition of composition. Then $F$ is linear, so this is equal to $G(F(\vec{v}) + F(\vec{w}))$. Now use the fact that $G$ is linear!

The answer turns out to be yes: the composition of two linear functions is linear. You will prove this on the next problem set. But, since it is linear, we can represent it as a matrix:

$(G \circ F) = \begin{pmatrix}-9 & -5\end{pmatrix}$

Notice that $G$ is a $1 \times 3$ matrix, $F$ is a $3 \times 2$ matrix, and $(G \circ F)$ is a $1 \times 2$ matrix:

$$
\begin{pmatrix}1 & 0 & -5\end{pmatrix} \circ \begin{pmatrix}1 & 0 \\ 0 & 1 \\ 2 & 1 \end{pmatrix} = \begin{pmatrix}-9 & -5 \end{pmatrix}
$$

## Exercise

Consider the linear functions $A : \mathbb{R}^2 \to \mathbb{R}^3$ and $B : \mathbb{R}^2 \to \mathbb{R}^3$ defined by the following matrices:

$$
A = \begin{pmatrix}1 & 2 \\ 2 & 4 \\ 3 & 6\end{pmatrix}, \: B = \begin{pmatrix}3 & 1 \\ 0 & 5 \end{pmatrix}
$$

1. What is $A(\binom{1}{0})$? $A(\binom{0}{1})$?
2. What is $B(\binom{1}{0})$? $B(\binom{0}{1})$?
3. What is $A(B(\binom{1}{0}))$?
4. What is $A(B(\binom{0}{1}))$?
5. Write down the matrix representing $A \circ B$.

## Definition

**Definition** (Matrix multiplication): If $A$ is an $m \times n$ matrix representing a linear functino $F : \mathbb{R}^n \to \mathbb{R}^m$ and $B$ is an $n \times r$ matrix representing $G : \mathbb{R}^r \to \mathbb{R}^n$, then $AB$ is the $m \times r$ matrix representing $(F \circ G) : \mathbb{R}^r \to \mathbb{R}^m$.

That is: the *definition* of matrix multiplication that we use is just function composition. How do we actually compute the values here? It turns out that matrix multiplication can be computed using dot products!

$$
\begin{pmatrix}
a^1_1 \ldots a^1_n \\
a^2_1 \ldots a^2_n \\
\vdots \ldots \vdots \\
a^m_1 \ldots a^m_n
\end{pmatrix}
\begin{pmatrix}
b^1_1 \ldots b^1_r \\
b^2_1 \ldots b^2_r \\
\vdots \ldots \vdots \\
b^n_1 \ldots b^n_r
\end{pmatrix}
=
\begin{pmatrix}
c^1_1 \ldots c^1_r \\
c^2_1 \ldots c^2_r \\
\vdots \ldots \vdots \\
c^m_1 \ldots c^m_r
\end{pmatrix}
$$

where $c^i_j$ is given by the *dot product* of the $i$-th row of $A$ with the $j$-th column of $B$!

In particular: suppsoe $L : \mathbb{R}^n \to \mathbb{R}^m$ is a linear function and $A$ is an $m \times n$ matrix that represents $L$. If $\vec{v} \in \mathbb{R}^n$, then we can compute $A \cdot \vec{v}$ (using matrix multiplication), and we get exactly the output of $L(\vec{v})$!

## Exercise

Recall the rotation matrix $R_{\theta} = \begin{pmatrix} \cos(\theta) & -\sin(\theta) \\\ \sin(\theta) & \cos(\theta) \end{pmatrix}$.

1. Find $R_\theta \circ R_\theta$.  What does this transformation do to a vector $\vec{v}$ (geometrically)?
2. Find $R_{2 \theta}$. What does this transformation do to a vector $\vec{v}$ (geometically)?
3. What can we conclude from the above?

# Homework

On Moodle, you can either upload a PDF of your work (using a scanner or app Scannable / CamScanner, or typed via Google Docs / Word and converted to a PDF), or you can type in your work by clicking "Add Submission".

1. Use the definition of matrix multiplication as function composition to argue that $\cos(\alpha + \beta) = \cos(\alpha)\cos(\beta) - \sin(\alpha)\sin(\beta)$. Hint: consider the matrices $R_\alpha$, $R_\beta$, and compute the composition $R_\alpha \circ R_\beta$. Argue geometrically that this matrix represents $R_{\alpha + \beta}$.

2. Watch the next two videos in the Essence of Linear Algebra series:

This one discusses the idea of matrix multiplication as composition of functions:

<div class="youtube-container">
   <iframe src="https://www.youtube.com/embed/XkY2DOUCWMU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

This one discusses linear transformations in 3D:

<div class="youtube-container">
   <iframe src="https://www.youtube.com/embed/rHLEWRxRGiM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>   
</div>

I again would like to hear what people thought was interesting and/or confusing from these videos.
