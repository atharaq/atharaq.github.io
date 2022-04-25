# Linear Lesson 21: Homogeneous Linear Recurrence Relations
{:.no_toc}

1. Table of Contents
{:toc}

For today's lesson, we will do one short example, which I will ask you to answer short response / fill in the blank questions to help check your knowledge of vector spaces and linear maps. You will record your responses on Moodle.

Consider the vector space $\mathbb{R}^\mathbb{N} = \\{ (x_0, x_1, \ldots) : x_n \in \mathbb{R}$ for all $n \in \mathbb{N} \\}$. This is the vector space of all infinite sequences that we studied in one of our problem sets. This vector space is useful to solving **linear recurrence relations**.

Today we will look at one specific example of a recurrence relation: $x_{N+2} = 3x_{N+1} - 2x_N$. A *solution* to this relation is an infinite sequence $(x_0, x_1, x_2, \ldots)$ such that for each $n \in \mathbb{N}$, $x_{n+2} = 3x_{n+1} - 2x_n$. Notice that for a solution to this recurrence relation, if we know $x_0$ and $x_1$, then plugging in $n = 0$ we get that $x_2 = 3x_1 - 2x_0$, and can compute $x_2$. Similarly:

* Since $x_3 = 3x_2 - 2x_1$, after we've computed $x_2$ we can compute $x_3$.
* Since $x_4 = 3x_3 - 2x_2$, after we've computed $x_3$ we can compute $x_4$.
* Etc.

**Exercise 1** (Respond on Moodle) Suppose $x_0 = 0$ and $x_2 = 1$, and for each $n$, $x_{n+2} = 3x_{n+1} - 2x_n$. Compute $x_3, x_4,$ and $x_5$.

Consider the function $L : \mathbb{R}^\mathbb{N} \to \mathbb{R}^\mathbb{N}$ given by $L( (x_0, x_1, x_2,\ldots)) = (x_2 - 3x_1 + 2x_0, x_3 - 3x_2 + 2x_1, \ldots )$. This is, if $x (x_0, x_1, \ldots)$, then $L(x)$ is the sequence $y = (y_0, y_1, \ldots)$ whose $n$-th term $y_n = x_{n+2} - 3x_{n+1} + 2x_n$.

Exercise: (No need to submit this, but do it to make sure you are able to). Prove that $L$ is linear. That is, $L(x + y) = L(x) + L(y)$ and $L(a \cdot x) = a \cdot L(x)$.

**Exercise 2**: (Respond on Modle) Since $L$ is linear, the set $K = \\{ x \in \mathbb{R}^\mathbb{N} : L(x) = \vec{0} \\}$, called the (fill in the blank \#1) of $L$, is a (fill in the blank \#2) of $\mathbb{R}^\mathbb{N}$.

*Claim*: $\dim(K) = 2$. To see this, notice that $\vec{x} \in K$, it's really just determined by its first two elements. That is, if $\vec{x} = (x_0, x_1, x_2, \ldots)$, since $(x_2 - 3x_1 + 2x_0, x_3 - 3x_2 + 2x_1, x_4 - 3x_3 + 2x_1, \ldots) = (0, 0, 0, \ldots, )$, that means that $x_2 = 3x_1 - 2x_0$, $x_3 = 3x_2 - 2x_1$, etc. Therefore, if we know $x_0$ and $x_1$, we can figure out $x_2$, and then from $x_1$ and $x_2$, we can figure out $x_3$, etc, as we did above. So suppose $x_0 = a$ and $x_1 = b$. Then $x_2 = 3b - 2a$, $x_3 = 3(3b - 2a) - 2a$, etc.

Moreover, let $\vec{x} = (1, 0, \ldots)$ and $\vec{y} = (0, 1, \ldots)$. Then $(a, b, \ldots) = a \vec{x} + b \vec{y}$. **Exercise 3** (Respond on Moodle): In other words, the vectors $\vec{x}$ and $\vec{y}$ (fill in the blank) $K$.

Moreover, they are also linearly independent. To see this, suppose $a \cdot \vec{x} + b \cdot \vec{y} = (0, 0, 0, \ldots)$. Expanding, you get $(a, b, 3b - 2a, \ldots) = (0, 0, \ldots)$, and so $a = 0$ and $b = 0$.

**Exercise 4**: Since these two vectors are linearly independent and span $K$, they form a (fill in the blank) for $K$, and therefore $\dim(K) = 2$.

Now we know that this set is two dimensional, but the basis used does not give us much insight into what solutions actually look like. Ideally, we would like a **closed form** for our solutions to this recurrence relation. That is, we would like to find a formula (really just a formula for a function $f(n)$ so that $x_n = f(n)$) for our solutions. To do this, we introduce another linear function, and look for an *alternate* basis. Consider the function $T : K \to \mathbb{R}^\mathbb{N}$ defined by $T(x_0, x_1, x_2, \ldots) = (x_1, x_2, x_3, \ldots)$. That is, this is the "shift" function. For example, if $\vec{v} = (1, 3, 7, 15, \ldots)$, then $T(\vec{v}) = (3, 7, 15, \ldots)$.

Exercise (don't need to submit this, but again, this is a possible test / problem set question): show that $T$ is linear, and that for all $\vec{v} \in K$, $T(\vec{v}) \in K$. That is, if $\vec{v} = (v_0, v_1, v_2, \ldots)$ is such that $v_{n+2} = 3 v_{n+1} - 2v_n$, and $T(\vec{v}) = (w_0, w_1, \ldots)$, show that $w_{n+2} = 3w_{n+1} - 2w_n$.

We are going to look for a "nice" basis for $K$ that makes computing $T$ easy. Similar to what we saw last week, we will look to see if there are vectors $\vec{v}$ such that $T$ simply re-scales $\vec{v}$. If we can find two examples of such, then the matrix representation for $T$ would be diagonal.

Consider $\vec{v} = (1, r, 3r - 2, 3(3r - 2) - 2r, \ldots)$. If there is a scalar $a$ such that $T(\vec{v}) = a \vec{v}$, then notice that $a = r$. That is: $T(\vec{v}) = (r, 3r - 2, 3(3r - 2) - 2r, \ldots)$; if $(r, 3r - 2, 3(3r - 2) - 2r, \ldots) = (a, ar, a(3r - 2), a(3(3r - 2) - 2r), \ldots)$, then $a = r$.

**Exercise 5**: In the above, plug in $a = r$, and set the second terms equal to each other. In other words, set $r^2 = 3r - 2$. Solve this equation. What values do you get for $r$?

**Exericse 6**: In Exercise 5 above, you should have gotten two values for $r$. Call them $r_1$ and $r_2$. Write the first four terms of the sequences $(1, r_1, 3r_1 - 2, 3(3r_1 - 2) - 2r_1, \ldots)$ and $(1, r_2, 3r_2 - 2, 3(3r_2 - 2) - 2r_2, \ldots)$. Find a formula for the $n$-th term of each of these sequences.

Now we have two vectors $\vec{v_1} = (1, r_1, \ldots)$ and $\vec{v_2} = (1, r_2, \ldots)$, if we can show that they are linearly independent, since $K$ has dimension two, we get that they span $K$. In other words, every sequence $(x_0, x_1, 3x_1 - 2x_0, \ldots)$ can be written as $a \cdot (1, r_1, \ldots) + b \cdot (1, r_2, \ldots)$. Exercise: (Don't submit): show that these are linearly independent. *Hint*: To see this, suppose $a \cdot (1, r_1, \ldots) + b \cdot (1, r_2, \ldots) = (0, 0, \ldots)$. Then $a + b = 0$ and $ar_1 + br_2 = 0$. Plugging in for $r_1$ and $r_2$ will give you a system of equations; you can then show that the only solutions are $a = 0$ and $b = 0$.

Now, since $\vec{v_1}$ and $\vec{v_2}$ span $K$, every vector can be written as $a \cdot \vec{v_1} + b \cdot \vec{v_2}$. In exercise 6, you found formulas for the $n$-th term of $\vec{v_1}$ and the $n$-th term of $\vec{v_2}$. So using these, we can find clsoed forms for every sequence!

For example, for the sequence $(0, 1, 3, 3\cdot 3 - 2 \cdot 1, \ldots)$, if we write this as $a \cdot \vec{v_1} + b \cdot \vec{v_2}$, we get the system

$$
\begin{align}
a + b &= 0 \\
a r_1 + b r_2 &= 1
\end{align}
$$

**Exercise 7**: Solve the above system of equations for $a$ and $b$.

Now that we know $a$ and $b$, that means that the $n$-th term of $(0, 1, 3, \ldots)$ is given exactly by ($a \times$ the $n$-th term of $\vec{v_1}) + b \times$ the $n$-th term of $\vec{v_2}$.

**Exercise 8**: Using the formulas for $\vec{v_1}$ and $\vec{v_2}$, find the formula for the $n$-th term of of $(0, 1, 3, 3 \times 3 - 2 \times 1, \ldots)$.

Submit your answers on Moodle. For formulas, you can use the ^ symbol (carat) for exponents and the _ symbol (underscore) for subscripts.
