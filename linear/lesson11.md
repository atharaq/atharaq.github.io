# Linear Lesson 11: Exam Recap / Determinants
{:.no_toc}

1. Table of Contents
{:toc}

# Inconsistency

How can you show that a system is *inconsistent*? You put it in RREF and find a row of all zeros (on the left) that is non-zero on the right.

## Example

**Question**: Show that $\begin{pmatrix}0 \\\ 0 \\\ 1 \end{pmatrix}$ is not in the image of $M = \begin{pmatrix}1 & 0 \\\ 1 & 1 \\\ 0 & 1 \end{pmatrix}$.

How would we do this? Set up an augmented system and use Gaussian Elimination:

$$
\left(\begin{matrix}1 & 0 \\ 1 & 1 \\ 0 & 1 \end{matrix} \: \right| \: \left.\begin{matrix} 0 \\ 0 \\ 1 \end{matrix}\right)
$$

Remember: **eliminate the first column first!** Use -1R1 + R2:

$$
\left(\begin{matrix}1 & 0 \\ 0 & 1 \\ 0 & 1 \end{matrix} \: \right| \: \left.\begin{matrix} 0 \\ 0 \\ 1 \end{matrix}\right)
$$

Now eliminate the second column: -R2 + R3:

$$
\left(\begin{matrix}1 & 0 \\ 0 & 1 \\ 0 & 0 \end{matrix} \: \right| \: \left.\begin{matrix} 0 \\ 0 \\ 1 \end{matrix}\right)
$$

That last row shows the inconsistency: it represents the equation 0 = 1.

## Similar question

Now what if I asked the similar question: *find* a vector that is not in the span of $M = \begin{pmatrix}1 & 0 \\\ 1 & 1 \\\ 0 & 1 \end{pmatrix}$? What would we do? (This was **question 4(a)** on the exam, with different vectors). Again, set up an augmented system and use Gaussian Elimination, but this time, we set it up with the vector $\begin{pmatrix}x \\\ y \\\ z\end{pmatrix}$ as the "right hand side":

$$
\left(\begin{matrix}1 & 0 \\ 1 & 1 \\ 0 & 1 \end{matrix} \: \right| \: \left.\begin{matrix} x \\ y \\ z \end{matrix}\right)
$$

Similarly, we eliminate the first column with -R1 + R2

$$
\left(\begin{matrix}1 & 0 \\ 0 & 1 \\ 0 & 1 \end{matrix} \: \right| \: \left.\begin{matrix} x \\ y - x\\ z \end{matrix}\right)
$$

Now eliminate column 2 with -R2 + R3:

$$
\left(\begin{matrix}1 & 0 \\ 0 & 1 \\ 0 & 0 \end{matrix} \: \right| \: \left.\begin{matrix} x \\ y - x\\ z - (y - x) \end{matrix}\right)
$$

Now we just need to find an inconsistency. That is, we need to find values of $x$, $y$, and $z$ that make the bottom row non-zero. Just plug in zeros for $x$ and $y$ and then find *anything* for $z$ that will make it non-zero: $z - (0 - 0) \neq 0$, just let $z$ be anything that's not zero!

For example, the vector $\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}$ gives us an inconsistency (as demonstrated earlier). But so does $\begin{pmatrix}0 \\\ 0 \\\ 4 \end{pmatrix}$, and many other vectors.

## Spanning

So we have shown that the vector $\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}$ is not in the image of $M = \begin{pmatrix}1 & 0 \\\ 1 & 1 \\\ 0 & 1 \end{pmatrix}$. This means that $\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix} \not \in \mathrm{Span}\left( \begin{pmatrix}1 \\\ 1 \\\ 0\end{pmatrix}, \begin{pmatrix} 0 \\\ 1 \\\ 1 \end{pmatrix} \right)$.

**Question**: Add in the vector $\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}$ to $\mathrm{Span}\left( \begin{pmatrix}1 \\\ 1 \\\ 0\end{pmatrix}, \begin{pmatrix} 0 \\\ 1 \\\ 1 \end{pmatrix} \right)$. Are there any vectors not in this span?

That is: the two vectors $\begin{pmatrix}1 \\\ 1 \\\ 0\end{pmatrix}$ and $\begin{pmatrix} 0 \\\ 1 \\\ 1 \end{pmatrix}$ span a plane in $\mathbb{R}^3$. The vector $\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}$ is not on that plane. If I add in this third vector, will we now span all of $\mathbb{R}^3$?

The answer should be **yes**, since we are adding a third "dimension" to our set. But how would we prove it? By showing that the matrix $A = \begin{pmatrix}1 & 0 & 0 \\\ 1 & 1 & 0 \\\ 0 & 1 & 1 \end{pmatrix}$ is invertible! This is **question 4(c)** on the exam.

As an aside: what is this matrix $A$? It's the function that we get by letting $A\begin{pmatrix}1 \\\ 0 \\\ 0 \end{pmatrix} = M\binom{1}{0}$, $A\begin{pmatrix}0 \\\ 1 \\\ 0\end{pmatrix} = M\binom{0}{1}$, and $A\begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix} = \begin{pmatrix}0 \\\ 0 \\\ 1\end{pmatrix}$.

## Extra Credit

**Due Thursday** on Moodle...

# Areas

(area of parallelogram calculation)

## Determinants

## Determinant of AB

# Homework
