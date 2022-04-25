# Linear Lesson 21: Homogeneous Linear Recurrence Relations
{:.no_toc}

1. Table of Contents
{:toc}

For today's lesson, we will do one short example, which I will ask you to "fill in the blanks" for to help check your knowledge of vector spaces and linear maps. You will record your responses on Moodle.

Consider the vector space $\mathbb{R}^\mathbb{N} = \\{ (x_0, x_1, \ldots) : x_n \in \mathbb{R}$ for all $n \in \mathbb{N} \\}$. This is the vector space of all infinite sequences that we studied in one of our problem sets. This vector space is useful to solving **linear recurrence relations**. 

Today we will look at one specific example of a recurrence relation: $x_{N+2} = 3x_{N+1} - 2x_N$. A *solution* to this relation is an infinite sequence $(x_0, x_1, x_2, \ldots)$ such that for each $n \in \mathbb{N}$, $x_{n+2} = 3x_{N+1} - 2x_n$.

Consider the function $L : \mathbb{R}^\mathbb{N} \to \mathbb{R}^\mathbb{N}$ given by $L( (x_0, x_1, x_2,\ldots)) = (x_2 - 3x_1 - 2x_0, x_3 - 3x_2 - 2x_1, \ldots )$. This is, if $x (x_0, x_1, \ldots)$, then $L(x)$ is the sequence $y = (y_0, y_1, \ldots)$ whose $n$-th term 

