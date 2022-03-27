# Linear Lesson 15: Linear Transformations
{:.no_toc}

1. Table of Contents
{:toc}

# Quiz

# Last week

Last week we discussed vector spaces (sets with operations of addition and scalar multiplication defined on them, satisfying certain properties). We looked at a few examples of vector spaces, and proved a simple result, that re-scaling the zero vector results in staying at the zero vector. Let's prove some other basic results.

## Basic Results

...

## Subspaces

We also defined *subspaces*: if $V$ is a vector space and $W \subseteq V$, then $W$ is a subspace if it's also a vector space. In particular, to show that $W$ is a subspace, we need to show:

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

**Proof**: We will prove this in a similar manner to the proof we did last week. Since $\vec{0}_V + \vec{0}_V = \vec{0}_V$, we know that $L(\vec{0}_V + \vec{0}_V) = L(\vec{0}_V$. By linearity, the left side is equal to $L(\vec{0}_V) + L(\vec{0}_V)$. That is: $L(\vec{0}_V) + L(\vec{0}_V) = L(\vec{0}_V)$. Now we will subtract $L(\vec{0}_V)$ from both sides. Since subtraction isn't defined, we use additive inverses: there is some vector $w \in W$ such that $L(\vec{0}_V) + w = \vec{0}_W$. We add that to both sides:

$$ (L(\vec{0}_V) + L(\vec{0}_V)) + w = L(\vec{0}_V + w$$

By associativity, we can regroup on the left as $L(\vec{0}_V) + (L(\vec{0}_V) + w)$. Now $L(\vec{0}_V) + w$ can be replaced by $\vec{0}_W$ on both sides, obtaining:

$$ L(\vec{0}_V) + \vec{0}_W = \vec{0}_W $$

Since $\vec{0}_W$ is the zero vector in $W$, then $L(\vec{0}_V) + \vec{0}_W = L(\vec{0}_W)$. So finally we have $L(\vec{0}_V) = \vec{0}_W$, completing our proof.

## Matrices

Let's look at some examples of linear functions. The first example we will look at are $m \times n$ matrices: these are linear transformations $M : \mathbb{R}^n \to \mathbb{R}^n$.

## Differentiation

## Integration

## Differential Equations

# Kernels and Images
