# Discrete Mathematics Lesson 9: Induction
{:.no_toc}

1. Table of Contents:
{:toc}

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

Let $P(n)$ be the property that $\sum\limits_{i=0}^n i = \dfrac{n(n+1)}{2}$. For any $n$, this is a true statement, and we gave the idea of a proof in an earlier lesson:

* Add up the numbers $0 + 1 + \ldots + n$
* Reverse them, and add again: $n + (n - 1) + \ldots + 1 + 0$
* Add them *column-wise*: $n + n + \ldots + n$. How many $n$'s are there? $n + 1$ (since there's one for each number from $0$ to $n$.

Therefore adding those numbers twice gives $n(n+1)$, and so adding it just once would be half of that.

But let's try to prove this same property using induction.

**Base case**: $P(0)$ is true because the sum of the integers from $0$ to $0$ is $0$, and $\dfrac{0(1)}{2} = 0$.

**Inductive Step**: We want to prove $\forall x (P(x) \rightarrow P(x+1))$. So let $x$ be an integer such that $P(x)$ is true. That is, suppose that $\sum\limits_{i=0}^x i = \dfrac{x(x+1)}{2}$. We want to show that $P(x+1)$ is also true.

$P(x+1)$ is the statement that $\sum\limits_{i=0}^{x+1} i = \dfrac{(x+1)(x+2)}{2}$. Notice that $\sum\limits_{i=0}^{x+1} i = \sum\limits_{i=0}^x i + (x + 1)$. Since $P(x)$ is true by our assumption, we know that $\sum\limits_{i=0}^x i = \dfrac{x(x+1)}{2}$. Therefore:

$$\sum\limits_{i=0}^{x+1} i = \dfrac{x(x+1}{2} + x + 1$$

Using algebra:

$$\dfrac{x(x+1)}{2} + \dfrac{2(x+1)}{2} = \dfrac{(x+1)(x + 2)}{2}$$

The last equality is achieved by factoring $(x+1)$.

## Strategy

The hardest part of a proof by induction is often the inductive step (not always! but often). One needs to think about how to show that if $P(x)$ is true, then $P(x+1)$ must be true, no matter what $x$ is. Recall the proof strategy for universal statements: let $x$ be an *arbitrary* element of the univers (in this case, $\mathbb{N}$). Then we have an if-then statement, so we assume that the antecedent is true and need to show the consequent.

How do we prove that, if $x$ is an arbitrary integer such that $P(x)$ is true, then $P(x+1)$ must be true also? The idea is to find some way of transforming something we know about $x$ to something we know about $x + 1$. In the above example, we needed to figure out a formula for $\sum\limits_{i=0}^{x+1} i$, supposing that we knew one for $\sum\limits_{i=0}^{x} i$. This is the general pattern: suppose you know something about a number $n$, use that to prove something about the number $n + 1$.

The thinking behind this is similar to the thinking you might find when studying recursion in computer programming: if you can solve a smaller problem, can you use solutions to that smaller problem to solve a larger problem?

# Example: Power Sets

Notice the following:

* $\|\emptyset\| = 0$. $\mathcal{P}(\emptyset) = \\{ \emptyset \\}$, which has size 1.
* Let $X = \\{ 1 \\}$. Then $\mathcal{P}(X) = \\{ \emptyset, \\{ 1 \\} \\}$, size 2.
* Let $X = \\{1, 2 \\}$. Then $\mathcal{P}(X) = \\{ \emptyset, \\{1 \\}, \\{2 \\}, \\{1, 2 \\} \\}$, which has size 4.
* Let $X = \\{1, 2, 3 \\}$. Then $\mathcal{P}(X) = \\{ \emptyset, \\{1 \\}, \\{2 \\}, \\{3 \\}, \\{1, 2 \\}, \\{1, 3 \\}, \\{2, 3 \\}, \\{1, 2, 3 \\}\\}$, which has size 8.

In general: it seems like the pattern is that adding one element to a set doubles the size of the power set. The power sets all have sizes that are increasing powers of 2: if $\|X\| = n$, then $\|\mathcal{P}(X)\| = 2^n$.

How might we prove this? Let $P(n)$ represent the assertion "Every set of size $n$ has $2^n$ subsets." We can prove the base case:

If $n = 0$, the only set of size $0$ is the empty set. The only subset of the empty set is the empty set itself, and therefore the statement "Every set of size $0$ has $1$ subset" is true.


Now we try to prove the inductive step. Let $n$ be any number and assume that $P(n)$ is true (**inductive hypothesis**): every set of size $n$ has $2^n$ subsets. We want to prove "Every set of size $n+1$ has $2^{n+1}$ subsets." So let $X$ be a set of size $n + 1$. The strategy is to somehow find a way to use the fact that any set of size $n$ has $2^n$ subsets to count the number of subsets of $X$. How do we use this fact?

We need to first get a set of size $n$. To get a set of size $n$ from a set of size $n + 1$, just delete an element. Let's look at a quick example for $n = 4$ first. Let $X = \\{ 1, 2, 3, 4 \\}$. We know that the power set of $\\{ 1, 2, 3 \\}$ has 8 elements. How many subsets are there of $X$? Well all of the subsets of $\\{1, 2, 3 \\}$ are also subsets of $X$, so there are at least those 8. The other subsets of $X$ are those which contain the number 4. How many subsets of $X$ are there which contain the number 4? A counting argument will give us 8 again: there are 3 yes/no questions to ask (is 1 in the set? Is 2? Is 3?).

In fact, for any set $X$, if $a \in X$, there is a *bijection* between the subsets of $X$ which contain $a$ and the subsets of $X$ which don't. This bijection is given by taking a subset of $X$ which does **not** contain the element $a$ and adding in the element $a$ to that set. In the case $X = \\{ 1, 2, 3, 4 \\}$ and $a = 4$:

* $\emptyset \mapsto \\{ 4 \\}$
* $\\{ 1 \\} \mapsto \\{ 1, 4 \\}$
* $\\{ 2 \\} mapsto \\{ 2, 4 \\}$
* etc.

Why is this a bijection? What is the domain and codomain of the function? The domain is the set $\\{ A \subseteq X : 4 \not \in A \\}$ and the codomain is $\\{ A \subseteq X : 4 \in A \\}$. First let's show it's one to one. Let $A \subseteq \\{ 1, 2, 3 \\}$ and $B \subseteq \\{1, 2, 3 \\}$. Assume that $A \cup \\{ 4 \\} = B \cup \\{ 4 \\}$. Then every element of $A$ is an element of $B \cup \\{ 4 \\}$. But if $a \in A$, then $a \neq 4$, and so $a \in B$. Similarly, every element of $B$ can be shown to be an element of $A$.

Now let's show that it's onto: let $A \subseteq \\{ 1, 2, 3, 4 \\}$ and suppose $4 \in A$. We want to find a subset $B$ of $\\{ 1, 2, 3 \\}$ such that $B \cup \\{ 4 \\} = A$. This is easy: just remove $4$ from $A$. That is, let $B = A \setminus \\{ 4 \\}$.

What have we shown? Since there are 8 subsets of $X$ which do not contain $4$, there are also 8 subsets of $X$ which do, and therefore there are 16 subsets of $X$ total (since every subset of $X$ either does, or does not, contain the number $4$).

Can you generalize this argument? Let $X$ be any set of size $n$. Let $a \in X$. Find a bijection between those subsets of $X$ which do not contain $a$, and those which do. Then, use the inductive assumption to show that there are $2^n$ subsets of $X$ which do not contain $a$, and $2^n$ which do. Therefore there are $2^n + 2^n = 2^{n+1}$ subsets of $X$ total.
