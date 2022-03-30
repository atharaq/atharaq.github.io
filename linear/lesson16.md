# Linear Lesson 16: More on Linear Transformations

# Warm up

These are from Problem Set 4 (questions 1 and 2). We won't solve them here, but please *discuss* your ideas with each other on these for now.

1. Let $V$ be a vector space and $\vec{0}$ the zero vector. Show that for any vector $v \in V$, $0 \cdot v = \vec{0}$.
2. An infinite *sequence* is a list $x = (x_0, x_1, \ldots)$ (for each $n \in \mathbb{N}$, $x_n$ is a *term* of that sequence), where each $x_n$ is a real number. Two infinite sequences are added term by term: $$x + y = (x_0 + y_0, x_1 + y_1, \ldots).$$ Scalar multiplication can be defined by: $$a \cdot x = (ax_0, ax_1, \ldots)$$ Show that the set of all infinite sequences forms a vector space. (That is: show that it satisfies all 10 properties listed in [the lecture notes for lesson 13](lesson13.html#vector-spaces).)

For #2, in particular, what is the "zero" vector for this vector space? What are the additive inverses for this vector space? How would we show that associativity, commutativity, distributivity, etc. properties?

## Problem Set Questions

Any other questions from the problem set?

## Quiz Questions

# Linear Transformations

Let's go back and show that the function $L : C^{\infty}(\mathbb{R}) \to C^{\infty}(\mathbb{R})$ defined by $L(f) = f^{\prime\prime} + f$ is linear. Recall that last week I said that the set of functions $f$ such that $f^{\prime\prime} = -f$ forms a vector space. If we re-write this differential equation to be $f^{\prime\\prime} + f = 0$, then we can consider this as the set of zeros of the function $L$. That is, the solutions to the differential equation above, are the solutions to the equation $L(f) = 0$.

We won't go too deeply into the solutions here, but it is worth noting that $L$ is yet another example of a linear transformation! To see this:

* $L(f + g) = (f + g)^{\prime\prime} + (f + g)$. By the sum rule for differentiation, this is $(f^{\prime\prime} + g^{\prime\prime}) + (f + g)$, and then reorganizing gives us $(f^{\prime\prime} + f) + (g^{\prime\prime} + g)$. That is, $L(f + g) = L(f) + L(g)$.
* $L(\alpha \cdot f) = (\alpha \cdot f)^{\prime\prime} + (\alpha \cdot f)$. Again using the constant multiple rule, this is $\alpha \cdot f^{\prime\prime} + \alpha \cdot f$, or just $\alpha \cdot (f^{\prime\prime} + f)$. (This last part actually uses the fact that $C^{\infty}(\mathbb{R})$ is a vector space, and applies property 8).

So this means that $L$ is linear! In fact, much of the study of differential equations is devoted, specifically, to *linear* differential equations, so that we can apply techniques from linear algebra to them! We will try to study some of the theory of these later in the semester, as this is an area of mathematics that has many applications.

## Non-Example

Consider the function $D : C^1(\mathbb{R}) \to C^0(\mathbb{R})$ defined by $D(f) = f^\prime - e^x$. That is, if $f(x) = x^2$, $D(f)$ is the function $2x - e^x$. This function is not linear! It's not obvious why, but let's check: if $f \in C^1(\mathbb{R})$, is $D(2 \cdot f) = 2 \cdot D(f)$?

$D(2 \cdot f) = (2 \cdot f)^\prime - e^x$. This is just $2 \cdot f^\prime - e^x$. Is this always equal to $2 \cdot (f^\prime - e^x)$? It doesn't seem like it, since $2 \cdot (f^\prime - e^x) = 2f^\prime - 2e^x$. How do we *prove*, though, that these aren't always equal? By finding a counterexample!

In this case, a counterexample would be any function $f(x)$ and any $x$-value such that $2 f^\prime(x) - e^x \neq 2 f^\prime(x) - 2e^x$. Let's let $f(x) = x$, and $x = 0$. Then $2 f^\prime(x) - e^x = 2 - e^x$, and when $x = 0$, this is $2 - 1 = 1$. On the other hand, $2 f^\prime(x) - 2e^x = 2 - 2e^x$ and when $x = 0$ this is $2 - 2 = 0$. So they aren't the same!

# Kernels and Images

We started this discussion of linear transformations by saying that they are a source of subspaces by looking at their kernels and images. Let's make that concrete. Recall the notions of kernels and images from earlier in the semester:

**Definition**: Let $T : V \to W$ be a linear transformation. Then:

1. The set $K = \\{ v \in V : T(v) = \vec{0}_W \\}$ is called the **kernel** of $T$, and
2. The set $T(V) = \\{ w \in W : $ there is $v \in V$ such that $T(v) = w \\}$ is called the **image** of $T$.

Notice that $\vec{0}_V \in K$ and $\vec{0}_W \in T(V)$, since $T(\vec{0}_V) = \vec{0}_W$ from the theorem we proved earlier.

**Theorem**: If $V$ and $W$ are vector spaces and $T : V \to W$ is a linear transformation, then $K$ is a subspace of $V$ and $T(V)$ is a subspace of $W$.

**Proof**: Let's first prove that the kernel is a subspace of $V$. What do we need to show?

1. If $v_1, v_2 \in K$, then $v_1 + v_2 \in K$,
2. If $v \in K$ and $\alpha \in \mathbb{R}$, then $\alpha \cdot v \in K$, and,
3. $\vec{0}_V \in K$.  This part we already know!

So suppose that $v_1$ and $v_2$ are both in the kernel. Then that means $T(v_1) = \vec{0}_W$ and $T(v_2) = \vec{0}_W$. We want to show that $T(v_1 + v_2) = \vec{0}_W$ also. How do we know that? Use linearity! (*Exercise*: Finish this proof.)

Similarly, if $T(v) = \vec{0}_W$, then we want to show that for any scalar $\alpha$, $T(\alpha \cdot v) = \vec{0}_W$. But by linearity, $T(\alpha \cdot v) = \alpha \cdot T(v)$. Since we know $T(v) = \vec{0}_W$, then that means $T(\alpha \cdot v) = \alpha \cdot \vec{0}_W$. But last time we proved that $\alpha \cdot \vec{0} = \vec{0}$ in any vector space, so that means that this $T(\alpha \cdot v) = \vec{0}_W$!

Now let's prove that the image is a subspace of $W$. That is, we need to show:

1. If $w_1, w_2 \in T(V)$, then $w_1 + w_2 \in T(V)$,
2. If $w \in T(V)$ and $\alpha \in \mathbb{R}$, then $\alpha \cdot w \in T(V)$, and,
3. $\vec{0}_W \in T(V)$. Again, we already know this part!

Suppose $w_1$ and $w_2$ are in the image of $T$. That means, by the definition of $T(V)$, that there are vectors $v_1$ and $v_2$ in $V$ such that $T(v_1) = w_1$ and $T(v_2) = w_2$. Can you find a vector in $V$ that is mapped to $w_1 + w_2$? Again, use linearity here.

Similarlyk, suppose $w \in T(V)$ and $\alpha \in \mathbb{R}$. By definition of $T(V)$, there is $v \in V$ such that $T(v) = w$. Then $\alpha \cdot T(v) = \alpha \cdot w$. By linearity, we know that $\alpha \cdot T(v) = T(\alpha \cdot v)$, so that means $T(\alpha \cdot v) = \alpha \cdot w$. Since $V$ is a vector space, $\alpha \cdot v \in V$, so $\alpha \cdot w \in T(V)$ by definition.

## Examples

Recall the function $D : C^1(\mathbb{R}) \to C^0(\mathbb{R})$ given by $D(f) = f^\prime$. What is the kernel of $D$? That is, what are the functions $f$ such that $f^\prime = \vec{0}$, the zero function? That is, $f^\prime(x) = 0$ for all $x$? These are the **constant** functions! That is, $K = \\{ c(x) : c(x)$ is a constant function$ \\}$.

What's the image $D(C^1(\mathbb{R}))?$ That is, what are the functions $f \in C^0(\mathbb{R})$ such that there is some function $g \in C^1(\mathbb{R})$ where $g^\prime = f$? This asks: which functions have antiderivatives?

It turns out: **every** continuous function has an antiderivative. Continuous functions have infinitely many antiderivatives actually! But in particular, we can always define one using the definite integral: $g(x) = \int_0^x f(t) dt$ is an antiderivative of $f(x)$, since the Fundamental Theorem of Calculus tells us that $g^\prime(x) = f(x)$ for each $x$.

## Differential Equations

Recall, again, the function $L : C^{\infty}(\mathbb{R}) \to C^{\infty}(\mathbb{R})$ defined by $L(f) = f^{\prime\prime} + f$. What is the kernel of $f$? These are the functions such that $f^{\prime\prime} + f = 0$: that is, these are solutions to the differential equation $f^{\prime\prime} = -f$.

We saw, last time, that $\sin(x) \in ker(L)$, and that $\cos(x) \in ker(L)$. Since the kernel of $L$ is a subspace, that means that it is closed under scalar multiplication and vector addition. Since it's closed under scalar multiplication, then $a \cdot \sin(x) \in ker(L)$ for any scalar $a \in \mathbb{R}$, and $b \cdot \cos(x) \in ker(L)$ for any scalar $b \in \mathbb{R}$. But then, since $ker(L)$ is closed under vector addition, then every function of the form $a \cdot \sin(x) + b \cdot \cos(x) \in ker(L)$ for each scalar $a$ and $b$.

We will see, in fact, that these are all of them. That is, the set of solutions to this differential equation forms a vector space of dimension 2!

## Another Example

Recall that for each $n$, the set $\mathbb{R}^n$ is a vector space. The linear functions $L : \mathbb{R}^n \to \mathbb{R}^m$ are the $m \times n$ matrices. Consider the matrix $A = \begin{pmatrix}0 & 1 \\\ 0 & 0 \end{pmatrix}$.

1. What is $ker(A)$?
2. What is $A(\mathbb{R}^2)$?

First let's look at the kernel. When is $A\vec{v} = \vec{0}$? In other words, which $x$ and $y$ are such that $\begin{pmatrix}0 & 1 \\\ 0 & 0 \end{pmatrix} \begin{pmatrix}x \\\ y \end{pmatrix} = \begin{pmatrix}0 \\\ 0 \end{pmatrix}$?

Expanding, we get: $y = 0$ and $0 = 0$. In other words, the only condition is that $y = 0$.

So $ker(A) = \\{ \binom{x}{0} : x \in \mathbb{R} \\}$. This is the $x$-axis!

Now let's look at the image of $A$: what are those $\binom{a}{b}$ such that there are $\binom{x}{y}$ where $\begin{pmatrix}0 & 1 \\\ 0 & 0 \end{pmatrix} \begin{pmatrix}x \\\ y \end{pmatrix} = \begin{pmatrix}a \\\ b \end{pmatrix}$? The first line says $y = a$, and the second line says $0 = b$. So in other words, $\binom{a}{b} = \binom{y}{0}$ for some $y \in \mathbb{R}$.

The image is $\\{ \binom{a}{0} : a \in \mathbb{R} \\}$. This is the $y$-axis!

(picture?)

# Spans

Consider the set $\mathbb{R}^2$ and the vector $\vec{0} = \binom{0}{0}$. Notice that the set $\\{ \vec{0} \\}$ is a subspace!

1. $a \cdot \vec{0} = \vec{0}$ (we proved this last time), so this set is closed under scalar multiplication.
2. $\vec{0} + \vec{0} = \vec{0}$ by property 5 of vector spaces, so this set is closed under vector addition.
3. $\vec{0}$ is clearly in this set.

Because it satisfies these three conditions, this set is a subspace of $\mathbb{R}^2$!

**Theorem**: For any vector space $V$, if $\vec{0}_V$ is the "zero vector", then $\\{ \vec{0} \\}$ is a subspace of $V$.

(The proof is the same for any vector space!)

Now let's think about another point: $v = \binom{1}{1}$. Is the set $\\{ \binom{1}{1} \\}$ a subspace of $\mathbb{R}^2$? No! It doesn't contain the zero vector!

Okay: so is the set $\\{ \vec{0}, \binom{1}{1} \\}$ a subspace? It has the zero vector, but it's not closed under scalar multiplication (or vector addition): in particular, $2 \cdot \binom{1}{1}$ is not in this set.

In fact, we need *every* scalar multiple of $\binom{1}{1}$. These look like $\binom{a}{a}$, for some $a \in \mathbb{R}$. So now let's ask: is the set $\\{ \binom{a}{a} : a \in \mathbb{R} \\}$ a subspace of $\mathbb{R}^2$?

1. Is $b \cdot (\binom{a}{a})$ in the set? Yes, since $b \cdot \binom{a}{a} = \binom{ab}{ab}$, and $ab \in \mathbb{R}$.
2. Is $\binom{a}{a} + \binom{b}{b}$ in this set? Yes, since this sum is $\binom{a + b}{a + b}$, and $a + b \in \mathbb{R}$.
3. Is $\vec{0}$ in this set? Yes, since we can let $a = 0$.

What does this set look like?

(image?)

## Two vectors

Consider the vector space $\mathbb{R}^3$ and the vectors $\vec{v_1} = \begin{pmatrix}1 \\\ 1 \\\ 0 \end{pmatrix}$ and $\vec{v_2} = \begin{pmatrix}0 \\\ 1 \\\ 1 \end{pmatrix}$.

Clearly, the set $\\{ \vec{v}_1, \vec{v}_2 \\}$ is not a subspace: we need at least $\vec{0}$, $\vec{v_1}$, all scalar multiples of $\vec{v_1}$ ($\alpha \cdot \vec{v_1}$ for all $\alpha \in \mathbb{R}$), $\vec{v_2}$, and all scalar multiples of $\vec{v_2}$ ($\beta \cdot \vec{v_2}$ for each $\beta \in \mathbb{R}$).

But that's not all! Since $2 \cdot \vec{v_1}$ and $\sqrt{3} \cdot \vec{v_2}$ are each scalar multiples of $\vec{v_1}$ and $\vec{v_2}$, and any subspace has to be closed under scalar multiplication and vector addition, we would need to allow $2 \cdot \vec{v_1} + \sqrt{3} \cdot \vec{v_2}$.

Similarly, for any scalars $a$ and $b$, we will need all vectors of the form $a \cdot \vec{v_1} + b \cdot \vec{v_2}$ in our set. But if we have all of these, then we finally do have a subspace! That is, if $W = \\{ a \cdot \vec{v_1} + b \cdot \vec{v_2} : a, b \in \mathbb{R} \\}$, then $W$ is a subspace!

To see this:

1. Let $\alpha$ be a scalar and $v = a \cdot \vec{v_1} + b \cdot \vec{v_2} \in W$. Then $\alpha \cdot v = \alpha \cdot (a \cdot \vec{v_1} + b \cdot \vec{v_2})$. Using the properties of vector spaces, we can simplify this into $(\alpha \times a) \cdot \vec{v_1} + (\alpha \times b) \cdot \vec{v_2}$, and this is in $W$ since it's a sum of scalar multiples of $\vec{v_1}$ and $\vec{v_2}$.
2. Let $a_1 \cdot \vec{v_1} + b_1 \vec{v_2} \in W$ and $a_2 \cdot \vec{v_1} + b_2 \cdot \vec{v_2} \in W$. Can you explain why their sum is in $W$?
3. Can you see which scalars $a$ and $b$ we can use to show that $\vec{0} \in W$? (That is, which $a$ and $b$ are such that $a \cdot \vec{v_1} + b \cdot \vec{v_2} = \vec{0}$, no matter what $\vec{v_1}$ and $\vec{v_2}$?)

In other words, the set $W = \\{ \begin{pmatrix}a \\\ a \\\ 0 \end{pmatrix} + \begin{pmatrix}0 \\\ b \\\ b \end{pmatrix} : a, b \in \mathbb{R} \\}$ is a subspace. We can also write this as $W = \\{ \begin{pmatrix} a \\\ a + b \\\ b \end{pmatrix} \\}$.

## Generality

What we have seen is this: since subspaces have to be closed under scalar multiplications and vector additions, if $W$ is a subspace and we have some vectors $v_1, v_2, \ldots, v_n \in W$, then **all linear combinations** of $v_1, v_2, \ldots, v_n$ must be in $W$! Recall, how do we define linear combinations?

**Definition**: Let $V$ be a vector space and $v_1, \ldots, v_n \in V$. Then:

1. A **linear combination** of $v_1, \ldots, v_n$ is a vector of the form $a_1 \cdot v_1 + \ldots + a_n \cdot v_n$, where $a_1, \ldots, a_n$ are scalars.
2. The **span** of $v_1, \ldots, v_n$, denoted $Span(v_1, \ldots, v_n)$, is the set of all linear combinations of $v_1, \ldots, v_n$.
3. We say that $\\{ v_1, \ldots, v_n \\}$ **spans** $V$ if $Span(v_1, \ldots, v_n) = V$. We also refer to $\\{ v_1, \ldots, v_n \\}$ as a **spanning set** for $V$.

**Theorem**: Let $V$ be a vector space and $v_1, \ldots, v_n \in V$. Then:

1. $Span(v_1, \ldots, v_n)$ is a subspace of $V$.
2. If $W \subseteq V$ is a subspace of $V$ and $v_1, \ldots, v_n \in W$, then $Span(v_1, \ldots, v_n) \subseteq W$.

In other words: the span of a set of vectors in a vector space $V$ is the *smallest* subspace of $V$ containing those vectors!

## Upcoming

Next week, we will prove the above theorem. Then we will discuss the concepts of linear independence, which will allow us to develop the theory of "dimension". In particular, we will see that all linearly independent sets "of the right size" will be spanning sets. These sets will be called bases!

Reminders:

1. PS4 is due Monday.
2. If you didn't already, please do a problem presentation (due this past Sunday).
3. Next Thursday will be asynchronous, and a take-home exam will be given then.
4. Quiz corrections due Monday.
