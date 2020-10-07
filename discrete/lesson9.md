# Discrete Mathematics Lesson 9: Induction
{:.no_toc}

Table of Contents:
1. {:toc}

# Induction

The Principle of Mathematical Induction is an important property of $\mathbb{N}$. Let $P(x)$ be any predicate. Then the following statement **must** be true, regardless of what $P(x)$ actually means!

$$
[P(0) \wedge \forall x (P(x) \rightarrow P(x+1))] \rightarrow \forall (x P(x))
$$

What does this mean? Let's say $P(x)$ represents some property that a number $x$ could have. If $0$ has this property, and, whenever $x$ has this property, then $x + 1$ also does, then every number must have this property.

This is the idea behind **proof by induction**. There are two parts to a proof by induction:

* Base case: show that $P(0)$ is true.
* Inductive step: show that the statement $\forall x (P(x) \rightarrow P(x+1))$ is true.

Let's look at a couple of examples:

## Sum of first $n$ integers

Let $P(n)$ be the property that $\Sum_{i=0}^n i = \dfrac{n(n+1)}{2}$. For any $n$, this is a true statement, and we gave the idea of a proof in an earlier lesson:

* Add up the numbers $0 + 1 + \ldots + n$
* Reverse them, and add again: $n + (n - 1) + \ldots + 1 + 0$
* Add them *column-wise*: $n + n + \ldots + n$. How many $n$'s are there? $n + 1$ (since there's one for each number from $0$ to $n$.

Therefore adding those numbers twice gives $n(n+1)$, and so adding it just once would be half of that.

But let's try to prove this same property using induction.

**Base case**: $P(0)$ is true because the sum of the integers from $0$ to $0$ is $0$, and $\dfrac{0(1)}{2} = 0$.

**Inductive Step**: We want to prove $\forall x (P(x) \rightarrow P(x+1))$. So let $x$ be an integer such that $P(x)$ is true. That is, suppose that $\Sum_{i=0}^x i = \dfrac{x(x+1)}{2}$. We want to show that $P(x+1)$ is also true.

$P(x+1)$ is the statement that $\Sum_{i=0}^{x+1} i = \dfrac{(x+1)(x+2)}{2}$. Notice that $\Sum_{i=0}^{x+1} i = \Sum_{i=0}^x i + (x + 1)$. Since $P(x)$ is true by our assumption, we know that $\Sum_{i=0}^x i = \dfrac{x(x+1)}{2}$. Therefore:

$$\Sum_{i=0}^{x+1} i = \dfrac{x(x+1}{2} + x + 1$$

Using algebra:

$$\dfrac{x(x+1)}{2} + \dfrac{2(x+1)}{2} = \dfrac{(x+1)(x + 2)}{2}$$

The last equality is achieved by factoring $(x+1)$.

## Strategy

The hardest part of a proof by induction is often the inductive step (not always! but often). One needs to think about how to show that if $P(x)$ is true, then $P(x+1)$ must be true, no matter what $x$ is. Recall the proof strategy for universal statements: let $x$ be an *arbitrary* element of the univers (in this case, $\mathbb{N}$). Then we have an if-then statement, so we assume that the antecedent is true and need to show the consequent.

How do we prove that, if $x$ is an arbitrary integer such that $P(x)$ is true, then $P(x+1)$ must be true also? The idea is to find some way of transforming something we know about $x$ to something we know about $x + 1$. In the above example, we needed to figure out a formula for $\Sum_{i=0}^{x+1} i$.