# Linear Lesson 20: Change of Basis
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

1. Suppose $\dim(V) = n, \dim(W) = m$ and $T : V \to W$ is linear. What are the dimensions of $M(T)$?

2. Suppose $\dim(V) = 2$ and $\dim(W) = 4$, and $v_1, v_2$ is a basis for $V$, and $w_1, w_2, w_3, w_4$ is a basis for $W$. Let $T : V \to W$ be defined by $T(v_1) = w_1$ and $T(v_2) = w_2$. What is the matrix representation of $T$?

3. Let $P_3$ be the vector space of polynomials of degree at most 3, and $P_2$ the vector space of polynomials of degree at most 2. Let $D : P_3 \to P_2$ be the differentiation function $D(p(x)) = p^\prime(x)$. Find bases for $P_3$ and $P_2$ such that the matrix representation of $D$ with respect to those bases $M(D)$ is $\begin{pmatrix}1 & 0 & 0 & 0 \\\ 0 & 1 & 0 & 0 \\\ 0 & 0 & 1 & 0 \end{pmatrix}$.

# Matrix Representations

Recall: $L : V \to W$, $V$ has basis $v_1, \ldots, v_n$, $W$ has basis $w_1, \ldots, w_m$. Write:

* $L(v_1) = a_{1,1} w_1 + \ldots + a_{m,1} w_m$
* $L(v_2) = a_{1,2} w_1 + \ldots + a_{m,2} w_m$
* $\vdots$
* $L(v_n) = a_{1, n} w_1 + \ldots + a_{m, n} w_m$

Then the matrix representation of $L$, $M(L)$, is:

(picture)

We've seen that there are lots of different bases for the same vector spaces. Let's look at $\mathbb{R}^2$ and use the basis $B = \\{ \binom{2}{1}, \binom{-1}{1} \\}$ for our "inputs", and the standard basis $\binom{1}{0}$ and $\binom{0}{1}$ for our "outputs". Suppose $T(v) = v$ is the identity function. What is the matrix representation of $T$?

Since $T\binom{2}{1} = \binom{2}{1}$, and $\binom{2}{1} = 2 \binom{1}{0} + 1 \binom{0}{1}$, our first column is just $\binom{2}{1}$. And since $T\binom{-1}{1} = \binom{-1}{1}$, the second column is $\binom{-1}{1}$. That is, $M(T) = \begin{pmatrix}2 & -1 \\\ 1 & 1 \end{pmatrix}$.

What if we went the other way around? If $I : \mathbb{R}^2 \to \mathbb{R}^2$ is the identity function, with "input basis" $\binom{1}{0}, \binom{0}{1}$, and "output basis" $\binom{2}{1}, \binom{-1}{1}$, how would we figure out the matrix representaiton here? $I\binom{1}{0} = \binom{1}{0}$, but how do we express $\binom{1}{0}$ in terms of $\binom{2}{1}$ and $\binom{-1}{1}$?

This is exactly the idea behind the **change of basis** matrix. In fact, what we need to do is take the matrix for $T$ above, and invert it (because we are literally just going the other way around)! 

**Exercise**: Find the inverse of $M(T) = \begin{pmatrix}2 & -1 \\\ 1 & 1 \end{pmatrix}$.

# Change of Basis



# Problem Set 5
