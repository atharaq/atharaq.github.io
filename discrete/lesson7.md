# Discrete Mathematics Lesson 7: Predicate Logic
{:.no_toc}

1. Table of Contents
{:toc}

# Related Propositions

# Predicates and Quantifiers

* Predicates

## Universal Quantifier

* Universe, or domain of discourse

## Existential Quantifier

## Free and Bound Variables

## Set Theory Examples

## Exercises

# Negations

## Exercises

# Nested Quantifiers

## Function Examples

# Proof Strategies With Quantifiers

* Universal quantifier: $\forall x \phi(x)$: pick an arbitrary element $x$, show that the property $\phi(x)$ must be true.
* Existential quantifier: $\exists x \phi(x)$: find a specific example of such an $x$ with that property.

The situation reverses if we want to disprove a statement:

* Disproving $\forall x \: \phi(x)$: find a *counterexample*. That is, find a specific example of an $x$ such that $\lnot \phi(x)$ is true. For example: if $A = \\{ 1, 2, 3 \\}$ and $B = \\{ 1, 2 \\}$, the statement $\forall x (x \in A \rightarrow x \in B)$ is not true, since $x = 3$ is a counterexample. $3 \in A \rightarrow 3 \in B$ is not a true statement.
* Disproving $\exists x \: \phi(x)$: Pick an arbitrary $x$ and show that $\lnot \phi(x)$ must be true. (That is: prove $\forall x \lnot \phi(x)$)

## Examples

**Definition**: Let $n \in \mathbb{Z}$. We say $n$ is **even** if there is $k \in \mathbb{Z}$ such that $n = 2k$. We say $n$ is **odd** if there is k \in \mathbb{Z}$ such that $n = 2k + 1$.

How might we prove the following statements:

* Every integer is either even or odd
* No integer is both even and odd

Let's re-write these in predicate logic:

* $\forall n \exists k (n = 2k \vee n = 2k + 1)$
* $\lnot \exists n [\exists k (n = 2k) \wedge \exists m (n = 2m + 1)]$

How might we prove the first statement? Let $n$ be given. We need to find such a $k$ that works. This is not obvious unless you know the trick, but the trick is *division with remainder*. If you divide $n$ by 2, you get a remainder of either 0 or 1. How do we formalize this?

When you first learned "remainders" in elementary school, you might have been told to keep subtracting until you cannot anymore. In that spirit: let's look at all the numbers we can form by starting with $n$, and subtracting 2 over and over. That is: consider the set of numbers of the form $n - 2k$, where $k \in \mathbb{Z}$, and $0 \leq n - 2k \leq n$. We might write this set as $R = \\{ r : \exists k (n = 2k + r) \wedge (0 \leq r \leq n) \\}$.

An important property of $\mathbb{N}$ is that every subset of $\mathbb{N}$ has a least element, so let's refer to the least element of $R$ as $r$. If $r > 1$, we can subtract another 2:

$$
\begin{align}
n - 2k &= r \geq 2 \\
n - 2k - 2 &= r - 2 \geq 0\\
n - 2(k + 1) &= r - 2 \geq 0
\end{align}
$$

and so $r$ would not have been the least element of $R$, as $r - 2$ is smaller. This is a contradiction, and so $r \leq 1$. This means either $r = 0$ or $r = 1$. By definition, since $r \in R$, there must be $k$ such that $n = 2k + r$. That means, there is $k$ such that either $n = 2k$ or $n = 2k + 1$. So for our given $n$, the statement $\exists k (n = 2k \vee n = 2k + 1)$ is true. Since $n$ was arbitrary, we can generalize this to a universally quantified statement: $\forall n \exists k (n = 2k \vee n = 2k + 1)$.

How might we prove that "No integer is both even and odd"? We could do a proof by contradiction: assume that $n$ is both even and odd. Then there are $k$ and $m$ such that $n = 2k$ and $n = 2m + 1$. But then $2k = 2m + 1$. Subtracting, we would get that $2(k - m) = 1$. This means that 1 is even. But this is impossible! (Why? Can you prove why this cannot happen? What axioms, or rules, for multiplication do we need to show that, for any $x$, $2x \neq 1$?)

# Satisfiability and Incompleteness
