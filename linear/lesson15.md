# Linear Lesson 15: Linear Transformations
{:.no_toc}

1. Table of Contents
{:toc}

# Quiz

# Big Picture

Moving forward, we want to develop the theory of "finite-dimensional vector spaces". What should this mean?

1. $\mathbb{R}^2$ is 2-dimensional, because it's spanned by $\binom{1}{0}$ and $\binom{0}{1}$.
2. $\mathbb{R}^3$ is 3-dimensional, because it's spanned by $\begin{pmatrix}1 \\\ 0 \\\ 0\end{pmatrix}, \begin{pmatrix} 0 \\\ 1 \\\ 0 \end{pmatrix}$ and $\begin{pmatrix} 0 \\\ 0 \\\ 1 \end{pmatrix}$.
3. $\mathcal{P}_2$ is 3-dimensional, because it's spanned by $1$, $x$, and $x^2$! That is: any polynomial of degree at most 2 can be written as a linear combination of $1$, $x$ and $x^2$.

In order to discuss this, we will need to define linear combinations, spans, and the notion of linear independence as well. We will come back to these ideas later this week. But this will explain, for example, why sets of solutions to homogeneous systems of equations similarly have a notion of dimension. Hopefully this will help connect the dots between some of the problems we solved earlier in the semester, and the theory we will be developing now.

# Last week

Last week we discussed vector spaces (sets with operations of addition and scalar multiplication defined on them, satisfying certain properties). We looked at a few examples of vector spaces, and proved a simple result, that re-scaling the zero vector results in staying at the zero vector. Let's prove some other basic results.

## Basic Results

The nice thing about isolating these properties of vector spaces is that if we prove theorems just with these properties (ie, not restricting to $\mathbb{R}^2$ or $\mathbb{R}^3$), then we know these results for all kinds of vector spaces. If we prove something, we will know it for any space with the same properties, even ones we didn't think of! That's really powerful.

**Theorem**: Let $V$ be a vector space. Then:

1. $v + (-1) \cdot v = \vec{0}$. In other words, the additive inverse of $v$ is $(-1) \cdot v$.
2. $2 \cdot v = v + v$.

These may seem obvious, but they are not directly stated by the vector space axioms, so we should prove them. In particular, the second one says that re-scaling by $2$ really does just means "add the vector to itself".

**Proof**:

1. Since $v = 1 \cdot v$ (Property 10), we have $v + (-1) \cdot v = 1 \cdot v + (-1) \cdot v$. By Property 7, $1 \cdot v + (-1) \cdot v = (1 + (-1)) \cdot v$. Just by normal (real number) addition, this is $0 \cdot v$. On your homework, you will prove that $0 \cdot v = \vec{0}$ for every vector $v$.
2. $2 \cdot v = (1 + 1) \cdot v$, and by Property 7 again, this is $1 \cdot v + 1 \cdot v$. And since $1 \cdot v = v$ (Property 10), this is $v + v$.

Note that we can of course do the same thing for $3 \cdot v = v + v + v$, and so on. By induction, we could figure out $n \cdot v$ for each integer $n$. Similarly, we can say something about $\frac{1}{2} \cdot v$, since we know that $\frac{1}{2} \cdot v + \frac{1}{2} \cdot v = v$. More generally, there usually isn't much choice for how something like $\frac{p}{q} \cdot v$ would be defined.

What about something like $\sqrt{2} \cdot v$ or $\pi \cdot v$? The vector space properties are all *algebraic* properties; they don't really mention anything about limits (or continuity). So there really is actually no need for this to match up what we think it should be (ie should $\sqrt{2} \cdot v$ somehow be "between" $1.4 \cdot v$ and $1.5 \cdot v$? What does "between" even mean here?).

...but often, most vector spaces are defined with some hidden *additional* structure, that usually does say something about limits / continuity, and so these irrational scalar multiples end up begin what we expect anyway.

## Subspaces

Last week, we defined *subspaces*: if $V$ is a vector space and $W \subseteq V$, then $W$ is a subspace if it's also a vector space. In particular, to show that $W$ is a subspace, we need to show:

1. $W$ is closed under addition and scalar multiplication.
2. $\vec{0}_V \in W$, the zero vector of $V$ is in $W$.

Where do subspaces come from? There are two main ways one obtains subspaces: by looking at kernels and images of linear transformations, and by looking at the span of a set of vectors.

# Linear Transformations

**Definition**: Suppose $V$ and $W$ are vector spaces and $L : V \to W$ is a function. Then $L$ is a **linear transformation** (or a linear function, or a linear map) if:

1. for all $v_1, v_2 \in V$, $L(v_1 + v_2) = L(v_1) + L(v_2)$, and 
2. for all $v \in V$ and $\alpha \in \mathbb{R}$, $L(\alpha \cdot v) = \alpha \cdot L(v)$.

This should match up with our previous definition of linear functions, when we only focused on linear functions between the vector spaces $\mathbb{R}^n$.

One should point out: the addition in $V$ and the addition in $W$ could be very different. For example, $V$ might be the set $\mathbb{R}^2$ while $W$ might be the set $\mathcal{P}$. Then when we write $L(v_1 + v_2) = L(v_1) + L(v_2)$, we mean that, on the left, we add in $V$ first (so we add two-dimensional vectors), then apply the function $L$ to that sum. This should be the same as applying $L$ to each individual vector, getting polynomials in $\mathcal{P}$, and then adding those polynomials.

For example, the map $L : \mathbb{R}^2 \to \mathcal{P}$ defined by $L\binom{a}{b} = ax + bx^2$ is a linear map. To see this:

1. If $\binom{a}{b}, \binom{c}{d} \in \mathbb{R}^2$, then $L(\binom{a}{b} + \binom{c}{d}) = L\binom{a + c}{b + d} = (a + c)x + (b + d)x^2$. Since $L\binom{a}{b} = ax + bx^2$ and $L\binom{c}{d} = cx + dx^2$, then adding we get $L\binom{a}{b} + L\binom{c}{d} = (ax + bx^2) + (cx + dx^2)$. Some algebra will show that this is the same as $(a + c)x + (b + d)x^2$, showing that $L$ respects vector addition.
2. If $\binom{a}{b} \in \mathbb{R}^2$ and $\alpha \in \mathbb{R}$, then $L(\alpha \cdot \binom{a}{b}) = L\binom{\alpha a}{\alpha b} = (\alpha a) x + (\alpha b)x^2$. Similarly, $\alpha \cdot L\binom{a}{b} = \alpha \cdot (ax + bx^2)$. By definition of scalar multiplication in $\mathcal{P}$, this is $(\alpha a)x + (\alpha b)x^2$.

We will do several examples of these today, and the proofs are all similar: compute $L(v_1 + v_2)$ and $L(v_1) + L(v_2)$ and show they're the same, and then similarly compute $L(\alpha \cdot v)$ and $\alpha \cdot L(v)$ and show those are the same.

Before we do this, we will prove the following simple result about linear maps: they must map the zero vector of one space to the zero vector of another.

**Theorem**: Suppose $L : V \to W$ is a linear transformation, $\vec{0}_V \in V$ is the zero vector in $V$ and $\vec{0}_W \in W$ is the zero vector in $W$. Then $L(\vec{0}_V) = \vec{0}_W$.

**Proof**: We will prove this in a similar manner to the proof we did last week. Since $\vec{0}_V + \vec{0}_V = \vec{0}_V$, we know that $L(\vec{0}_V + \vec{0}_V) = L(\vec{0}_V)$. By linearity, the left side is equal to $L(\vec{0}_V) + L(\vec{0}_V)$. That is: $L(\vec{0}_V) + L(\vec{0}_V) = L(\vec{0}_V)$. Now we will subtract $L(\vec{0}_V)$ from both sides. Since subtraction isn't defined, we use additive inverses: there is some vector $w \in W$ such that $L(\vec{0}_V) + w = \vec{0}_W$. We add that to both sides:

$$ (L(\vec{0}_V) + L(\vec{0}_V)) + w = L(\vec{0}_V + w$$

By associativity, we can regroup on the left as $L(\vec{0}_V) + (L(\vec{0}_V) + w)$. Now $L(\vec{0}_V) + w$ can be replaced by $\vec{0}_W$ on both sides, obtaining:

$$ L(\vec{0}_V) + \vec{0}_W = \vec{0}_W $$

Since $\vec{0}_W$ is the zero vector in $W$, then $L(\vec{0}_V) + \vec{0}_W = L(\vec{0}_W)$. So finally we have $L(\vec{0}_V) = \vec{0}_W$, completing our proof.

## Matrices

Let's look at some examples of linear functions. The first example we will look at are $m \times n$ matrices: these are linear transformations $M : \mathbb{R}^n \to \mathbb{R}^n$.

How do we know these are linear? How do we know, for example, that $M(\vec{v} + \vec{w}) = M(\vec{v}) + M(\vec{w})$? How do we know that 

We know these because this is how we *defined* matrices! Remember, we defined linear functions on $\mathbb{R}^n$, and then said that if $M$ is linear, then $M(\vec{v})$ depends only on what $M$ does to the "standard basis vectors". Then we used those to define what $M$ does to every other vector, and this turned out to be our "dot product" definition of how to plug a vector in to a linear function defined by a matrix.

In other words: matrices are built, from the ground up, to be linear. Matrices are exactly what you get if you try to force a function to be linear.

## Differentiation

Consider the function $D : C^1(\mathbb{R}) \to C^0(\mathbb{R})$ defined by $D(f) = f^\prime$. That is, since $C^1(\mathbb{R})$ contains all the differentiable functions $f$ such that $f^\prime$ is a continuous function, then if $f \in C^1(\mathbb{R})$, then $f^\prime \in C^0(\mathbb{R})$. So we defined a function between sets of function spaces! I claim that $D$ is a linear transformation.

That is: $D(f + g) = D(f) + D(g)$ and $D(\alpha \cdot f) = \alpha \cdot f)$. Let's verify these:

* Notice that $D(f + g) = (f + g)^\prime$. By the "sum" rule for derivatives, this is just $f^\prime + g^\prime$. The derivative of a sum of functions is the sum of the derivatives!
* Similarly, $D(\alpha \cdot f) = (\alpha \cdot f)^\prime$. By the "constant multiple rule", this is just $\alpha \cdot f^\prime$.

These are rules that we studied in Calculus I, and that we can prove using the limit definition of the derivative. We won't prove them here, but this is why, for example, to compute the derivative of $2e^x + \sin(x)$, we compute the derivatives of $e^x$ and $\sin(x)$ separately, and then combine using the constant multiple and sum rules: $(2 e^x + \sin(x))^\prime = 2e^x + \cos(x)$.

The fact that differentiation is linear is extremely important to the study of calculus. If it weren't, we would not be able to compute derivatives so easily. Each derivative would have to be studied separately, instead of just learning a couple of rules and then using those rules everywhere.

## Differential Equations

Recall that last week I said that the set of functions $f$ such that $f^{\prime\prime} = -f$ forms a vector space. Let's re-write this differential equation to be $f^{\prime\\prime} + f = 0$. Then we can consider this as the set of zeros of the function $L : C^{\infty}(\mathbb{R}) \to C^{\infty}(\mathbb{R})$ defined by $L(f) = f^{\prime\prime} + f$. That is, the solutions to the differential equation above, are the solutions to the equation $L(f) = 0$.

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

Similarlyk, suppose $w \in T(V)$ and $\alpha \in \mathbb{R}$. By definition of $T(V)$, there is $v \in V$ such that $T(v) = w$. Then $\alpha \cdot T(v) = \alpha \cdot w$. By linearity, we know that $\alpha \cdot T(v) = T(\alpha \cdot v)$, so that means T(\alpha \cdot v) = \alpha \cdot w$. Since $V$ is a vector space, $\alpha \cdot v \in V$, so $\alpha \cdot w \in T(V)$ by definition.

## Examples

Let's go back and think about the kernels and images of the functions we looked at earlier. Let's first think about the differentiation function $D : C^1(\mathbb{R}) \to C^0(\mathbb{R})$. What is the kernel of $D$? Recall, $D(f) = f^\prime$.

That is, what are the functions $f$ such that $f^\prime = \vec{0}$, the zero function? That is, $f^\prime(x) = 0$ for all $x$? These are the **constant** functions! That is, $K = \\{ c(x) : c(x)$ is a constant function$ \\}$.

What's the image $D(C^1(\mathbb{R}))?$ That is, what are the functions $f \in C^0(\mathbb{R})$ such that there is some function $g \in C^1(\mathbb{R})$ where $g^\prime = f$? This asks: which functions have antiderivatives?

It turns out: **every** continuous function has an antiderivative. Continuous functions have infinitely many antiderivatives actually! But in particular, we can always define one using the definite integral: $g(x) = \int_0^x f(t) dt$ is an antiderivative of $f(x)$, since the Fundamental Theorem of Calculus tells us that $g^\prime(x) = f(x)$ for each $x$.

