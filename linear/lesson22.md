# Linear Lesson 22: Linear Recurrence Relations / Eigenvalues and Eigenvectors
{:.no_toc}

1. Table of Contents
{:toc}

Similar to last time, you will go through the notes and answer some questions along the way on Moodle.

# Review and Definitions

To review: we studied the vector space of infinite sequences $\mathbb{R}^\mathbb{N}$. Within this vector space, some of these sequences are defined via *recurrence relations*. A recurrence relation is a definition of an infinite sequence where later terms are defined by earlier ones. A simple example would be $x_{n+1} = 2x_n$. A *solution* to a recurrence relation is an infinite sequence that satisfies the given definition. So a solution to $x_{n+1} = 2x_n$ would be the sequence $(1, 2, 4, 8, 16, \ldots)$. Of course, this isn't the only solution: the  sequence $(3, 6, 12, 24, \ldots)$ is another solution. (In fact: any *scalar multiple* of a solution to this recurrence is another solution to this recurrence; this is a hint that linear algebra might play a role!)

As an aside: probably the most famous recurrence relation is the Fibonacci relation. The Fibonacci sequence is defined as the infinite sequence $(x_0, x_1, \ldots)$ where $x_0 = 0$, $x_1 = 1$, and $x_{n+2} = x_{n+1} + x_n$ for each $n$.

Last time we studied the recurrence relation $x_{n+2} = 3x_{n+1} - 2x_n$. The set of solutions to this recurrence relation turns out to be a subspace of $\mathbb{R}^\mathbb{N}$. In fact, it turns out to be the kernel of a particular linear transformation, so we referred to this space as $K$. We also saw that $\dim(K) = 2$, with basis $b_1 = (1, 0, -2, -6, \ldots), b_2 = (0, 1, 3, 7, \ldots)$.

Every solution to this recurrence relation is determined by $x_0$ and $x_1$. For example, if $x_0 = -2$ and $x_1 = 1$, then $x_2 = 3 - 2(-2) = 7$, and then $x_3 = 21 - 2 = 19$, etc. We could, in principle, compute the 10th term of this sequence by continuing on in this pattern, but that does not seem very efficient. So the problem was to find a formula so that $n$, we can compute the $n$-th term of this sequence.

To find the $n$-th term of a sequence, we turned to the "shift" map, which takes in a vector $(x_0, x_1, x_2, \ldots)$ and "shifts" everything over by one to the left, getting rid of the first term, so $T(x_0, x_1, x_2, \ldots) = (x_1, x_2, x_3, \ldots)$.

**Exercise 1**: If $T(x_0, x_1, x_2, \ldots) = (x_1, x_2, x_3, \ldots)$, what is $T^2(x_0, x_1, x_2, \ldots)$? What is $T^n(x_0, x_1, x_2, \ldots)$?

This exercise should help explain why we were interested in this shift map. We really want to find an easy way to compute $T^n$, for any $n$.

By using this shift map, we found that if an infinite sequence starting with $(1, r, \ldots)$ satisfying this recurrence relation has the property that $T(1, r, \ldots)$ is just a scalar multiple of itself, then we can actually compute what $r$ must be in this case. That is: $r$ must satisfy the equation $r^2 = 3r - 2$.

This equation is referred to as the **characteristic equation** for this recurrence. In general, there is a close correspondence between recurrence relations and their characteristic equations:

* The characteristic equation for the Fibonacci recurrence, $x_{n+2} = x_{n+1} + x_n$ is the equation $r^2 = r + 1$.
* The characteristic equation for $x_{n+1} = 2x_n$ is the equation $r = 2$.
* The characteristic equation for $x_{n+3} = 6x_{n_2} - 11x_{n-1} + 6$ is $r^3 = 6r^2 - 11r + 6$.
* etc. The degree of the characteristic equation matches how far ahead of $n$ you go in your recurrence relation.

Solutions to this characteristic equation turn out to be important to understanding all solutions to the recurrence relation. That is: *every* solution to the recurrence $x_{n+2} = 3x_{n+1} - 2x_n$ is a sequence defined by the formula $a r_1^n + b r_2^n$, where $r_1$ and $r_2$ are the solutions to the characteristic equation!

## Another Example

Professor Meyer teaches an origami class here at Purchase as a gen-ed math course. While planning her class, she mentioned to me that she can get her students to fold a paper into thirds by using a kind of limit argument from calculus (without actually teaching the students calculus). The argument goes like this: fold the paper in half, then fold that in half, then find the midpoint of the two folds before, and then keep doing that.

In other words, she had the "construct" the sequence $(1, 0, \frac{1}{2}, \frac{1}{4}, \ldots)$, defined by $x_0 = 1, x_1 = 0$, and $x_{n+2} = \frac{1}{2} x_{n+1} + \frac{1}{2} x_n$. It turns out that the limit of this sequence is exactly $\frac{1}{3}$!

**Exercise 2**: Find the characteristic equation of this recurrence relation. Solve it, you should get two values, $r_1$ and $r_2$.

Now, similar to the problem from Monday, *every* solution to this recurrence will have the form $a r_1^n + b r_2^n$. That is: every solution to this recurrence is a linear combination of the two solutions $(1, r_1, r_2^2, \ldots)$ and $(1, r_2, r_2^2, \ldots)$. These two solutions *span* the set of all solutions to this recurrence relation.

**Exercise 3**: For the solution $x_n = a r_1^n + b r_2^n$, suppose $x_0 = 1$ and $x_2 = 0$. Solve for $a$ and $b$. In other words, solve the following system (when you plug in $n = 0$ and $n = 1$):

$$
\begin{align}
a + b = 1 \\
ar_1 + br_2 = 0
\end{align}
$$

Make sure to plug in for $r_1$ and $r_2$ from exercise 2.

**Exercise 4**: Using $a$, $b$, and $r_1$ and $r_2$, find the limit as $n \rightarrow \infty$ of $a r_1^n + b r_2^n$.

## Non-Homogeneous Recurrences

We will study this more next week. But a famous example of recurrence relations comes from the [Towers of Hanoi](https://en.wikipedia.org/wiki/Tower_of_Hanoi) puzzle from computer science. I won't get into it, but this is the recurrence given by $s_0 = 0$, $s_1 = 1$, and $s_{n+1} = 2s_n + 1$.

This recurrence relation is unfortunately not homogeneous; if we subtract $2s_n$ from both sides we get $s_{n+1} - 2s_n = 1$; the recurrences we have been working with above all end up with a 0 on the right hand side (that's why we used the *kernel* last time!).

This means that solutions to the recurrence relation $s_{n+1} = 2s_n + 1$ do *not* form a vector space. So how do we solve this? We turn it into a homogeneous equation!

Notice that $s_{n+1} - 2s_n = 1$ for every $n$. This also means taht $s_{n+2} - 2s_{n+1} = 1$ as well. Putting these together:

$$s_{n+1} - 2s_n = s_{n+2} - 2s_{n+1}$$

Simplifying:

$$s_{n+2} = 3s_{n+1} - 2s_n$$

This is a homogeneous recurrence relation! (It's *homogeneous* because, if we subtract all the $s$-terms, we end up with a 0 on the right!) In fact, this is the recurrence relation we solved last time.

# Eigenvalues / Eigenvectors

At a more abstract level, what did we do over the last lesson and a half?

* We analyzed a linear map $L : \mathbb{R}^\mathbb{N} \to \mathbb{R}^\mathbb{N}$.
* We found the kernel $K$ of that map and found that $\dim(K) = 2$.
* We looked at another map $T : K \to K$ (the "shift" map).
* Then we found a "nice basis" $\vec{v_1}, \vec{v_2}$ for $K$ so that $T(\vec{v_1}) = r_1 \vec{v_1}$ and $T(\vec{v_2}) = r_2 \vec{v_2}$, for some scalars $r_1$ and $r_2$.

This allowed us to come up with quick computations of $T^n$, for example. In fact, we didn't show this, but it turns out that the matrix representation for $T$, with respect to the basis $\vec{v_1}, \vec{v_2}$, is a diagonal matrix $\begin{pmatrix}r_1 & 0 \\\ 0 & r_2 \end{pmatrix}$. The fact that it's a diagonal matrix is what allows computation with $T$ to be very quick, and what allowed us to compute $T^n$ without needing to multiply matrices over and over again.

In general, if $L : V \to V$ is a linear function (note that the domain and codomain are the same here), then a vector $v \in V$ is called an **eigenvector** of $L$ if there is a scalar $\lambda$ ("lambda") such that $L(v) = \lambda v$. The scalar $\lambda$ is called an **eigenvalue** of $L$. The idea is that the vector $v$ is stretched by $L$ (but it's kept in the same direction). $\lambda$ is the "stretching factor".

If $\dim(V) = n$ and $L$ has $n$ linearly independent eigenvectors, then $L$ can be represented as an $n \times n$ diagonal matrix. This would be ideal. Sometimes, $L$ might not have $n$ linearly independent eigenvectors, but could still be represented as such.

Consider the following matrix: $A = \begin{pmatrix}2 & 0 \\\ -1 & 3 \end{pmatrix}$. Can we find eigenvectors for this matrix? How would we do so?

That is, we need to find $\binom{x}{y}$ and $\lambda$ so that $A\binom{x}{y} = \lambda \binom{x}{y}$. It's not obvious how to solve this, there are too many unknowns here. The general strategy is going to be as follows:

* The equation $Av = \lambda v$ will hold if and only if $(A - \lambda I)v = \vec{0}$ holds. That is, if $v$ is in the kernel of the matrix $(A - \lambda I)$. By $(A - \lambda I)$, we mean take the identity matrix $I$, multiply all the diagonal entries by $\lambda$, and subtract that from the matrix $A$.
* $v = \vec{0}$ is always a solution to the above, so we ignore that.
* The matrix $(A - \lambda I)$ has non-zero elements in its kernel if and only if its determinant is zero.
* So we compute the determinant of $A - \lambda I$. This will give us a polynomial in terms of $\lambda$. Solve for $\lambda$ and we'll find the eigenvalues.
* For each eigenvalue $\lambda$, we plug it back in to $A - \lambda I$ and find a vector $v$ that is in the kernel. This will be a corresponding eigenvector.

Let's do an example with the matrix $A = \begin{pmatrix}2 & 0 \\\ -1 & 3 \end{pmatrix}$. The matrix $A - \lambda I$ is $\begin{pmatrix}2 - \lambda & 0 \\\ -1 & 3 - \lambda \end{pmatrix}$.

**Exercise 5**: Find the determinant of the above matrix.

This gives you the **characteristic polynomial** of the matrix (yes we're re-using the term; yes, it's related!).

**Exercise 6**: Set the characteristic polynomial equal to zero and solve for it. You should get two values, $\lambda_1$ and $\lambda_2$.

**Exercise 7**: For each of the $\lambda_1$ and $\lambda_2$ above, plug back in and find $\binom{x}{y}$ in the kernels. That is: find $\binom{x_1}{y_1}$ such that $(A - \lambda_1 I)\binom{x_1}{y_1} = \binom{0}{0}$.  and find $\binom{x_2}{y_2}$ such that $(A - \lambda_2 I)\binom{x_2}{y_2} = \binom{0}{0}$. There will be many solutions here: try plugging in zeros and ones as much as possible.

If you do this right, you should get two vectors, $v_1 = \binom{x_1}{y_1}$ and $v_2 = \binom{x_2}{y_2}$. You should get that $Av_1 = \lambda_1 v_1$ and $Av_2 = \lambda_2 v_2$. Moreover, $v_1$ and $v_2$ should be linearly independent. That means they form a basis for $\mathbb{R}^2$.

**Exercise 8**: Write the matrix representation of $A$ with respect to the basis $v_1, v_2$. (Hint: it should be a diagonal matrix!)

As before, submit your work on Moodle (either via text entry or PDF upload of your notes).
