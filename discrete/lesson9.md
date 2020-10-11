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
* Let $X = \\{1, 2, 3 \\}$. Then:

$$
\begin{align}
\mathcal{P}(X) = \{ \emptyset, \\
  \{1 \}, \{2 \}, \{3 \}, \\
  \{1, 2 \}, \{1, 3 \}, \{2, 3 \}, \\
  \{1, 2, 3 \} \}
\end{align}
$$

which has size 8.

In general: it seems like the pattern is that adding one element to a set doubles the size of the power set. The power sets all have sizes that are increasing powers of 2: if $\|X\| = n$, then $\|\mathcal{P}(X)\| = 2^n$.

How might we prove this? Let $P(n)$ represent the assertion "Every set of size $n$ has $2^n$ subsets." We can prove the base case:

If $n = 0$, the only set of size $0$ is the empty set. The only subset of the empty set is the empty set itself, and therefore the statement "Every set of size $0$ has $1$ subset" is true.


Now we try to prove the inductive step. Let $n$ be any number and assume that $P(n)$ is true (**inductive hypothesis**): every set of size $n$ has $2^n$ subsets. We want to prove "Every set of size $n+1$ has $2^{n+1}$ subsets." So let $X$ be a set of size $n + 1$. The strategy is to somehow find a way to use the fact that any set of size $n$ has $2^n$ subsets to count the number of subsets of $X$. How do we use this fact?

We need to first get a set of size $n$. To get a set of size $n$ from a set of size $n + 1$, just delete an element. Let's look at a quick example for $n = 4$ first. Let $X = \\{ 1, 2, 3, 4 \\}$. We know that the power set of $\\{ 1, 2, 3 \\}$ has 8 elements. How many subsets are there of $X$? Well all of the subsets of $\\{1, 2, 3 \\}$ are also subsets of $X$, so there are at least those 8. The other subsets of $X$ are those which contain the number 4. How many subsets of $X$ are there which contain the number 4? A counting argument will give us 8 again: there are 3 yes/no questions to ask (is 1 in the set? Is 2? Is 3?).

In fact, for any set $X$, if $a \in X$, there is a *bijection* between the subsets of $X$ which contain $a$ and the subsets of $X$ which don't. This bijection is given by taking a subset of $X$ which does **not** contain the element $a$ and adding in the element $a$ to that set. In the case $X = \\{ 1, 2, 3, 4 \\}$ and $a = 4$:

* $\emptyset \mapsto \\{ 4 \\}$
* $\\{ 1 \\} \mapsto \\{ 1, 4 \\}$
* $\\{ 2 \\} \mapsto \\{ 2, 4 \\}$
* etc.

Why is this a bijection? What is the domain and codomain of the function? The domain is the set $\\{ A \subseteq X : 4 \not \in A \\}$ and the codomain is $\\{ A \subseteq X : 4 \in A \\}$. First let's show it's one to one. Let $A \subseteq \\{ 1, 2, 3 \\}$ and $B \subseteq \\{1, 2, 3 \\}$. Assume that $A \cup \\{ 4 \\} = B \cup \\{ 4 \\}$. Then every element of $A$ is an element of $B \cup \\{ 4 \\}$. But if $a \in A$, then $a \neq 4$, and so $a \in B$. Similarly, every element of $B$ can be shown to be an element of $A$.

Now let's show that it's onto: let $A \subseteq \\{ 1, 2, 3, 4 \\}$ and suppose $4 \in A$. We want to find a subset $B$ of $\\{ 1, 2, 3 \\}$ such that $B \cup \\{ 4 \\} = A$. This is easy: just remove $4$ from $A$. That is, let $B = A \setminus \\{ 4 \\}$.

What have we shown? Since there are 8 subsets of $X$ which do not contain $4$, there are also 8 subsets of $X$ which do, and therefore there are 16 subsets of $X$ total (since every subset of $X$ either does, or does not, contain the number $4$).

Can you generalize this argument? Let $X$ be any set of size $n$. Let $a \in X$. Find a bijection between those subsets of $X$ which do not contain $a$, and those which do. Then, use the inductive assumption to show that there are $2^n$ subsets of $X$ which do not contain $a$, and $2^n$ which do. Therefore there are $2^n + 2^n = 2^{n+1}$ subsets of $X$ total.

# Strong induction

There is another form of induction known as "strong induction": suppose $P(x)$ is a predicate such that $P(0)$ is true and, for each natural number $n$, if for all $k < n$, $P(k)$ is true, then $P(n)$ is also true. Then we can conclude that $\forall x P(x)$ is true.

So the strategy here is similar: prove the base case. Then let $n$ be an arbitrary integer and assume that $\forall k < n (P(k))$ is true. Use that to try to prove $P(n)$. Then you can conclude that $\forall x (P(x))$ is true.

Take a look at [Example 2.5.5 from *Discrete: An Open Introduction*](http://discrete.openmathbooks.org/dmoi3/sec_seq-induction.html#Rgt). In this example you prove that every natural number greater than $1$ can is either a prime or can be written as a product of primes.

# Incorrect Proofs By Induction

Consider the following argument that all horses are the same color. Let $P(x)$ be the statement that, in any group of size $x$, all the horses in that group are the same color. Notice that $P(0)$ is trivially true (as is $P(1)$).

Let $n$ be any given natural number and assume that $P(n)$ is true: that is, in any group of $n$ horses, all the horses in that group are the same color. We want to show $P(n+1)$, so suppose we have a set $X$ consisting of $n + 1$ horses. Exclude the first horse, and we have a set of $n$ horses. Those are all the same color by the inductive hypothesis. Exclude the last horse, and we again have a set of $n$ horses, which are all the same color by the inductive hypothesis. Considering each case, we conclude that the first horse is the same color as the rest of the group, which is the same color as the last horse.

Where does this argument go wrong? See if you can spot the subtle flaw in the argument. [This argument has its own Wikipedia page](https://en.wikipedia.org/wiki/All_horses_are_the_same_color) which goes through, with visual explanations, what goes wrong here.

# Exercises

There are lots of good exercises on proof by induction available in *Discrete: An Open Introduction*. Click here for the [exercises from Section 2.5](http://discrete.openmathbooks.org/dmoi3/sec_seq-induction.html#YsG) on induction. I encourage you to go through as much of these as you can on your own, in addition to the check-in.

# Recursive Definitions

Often times, induction is used to prove properties about **recursively defined functions**. A simple example of a recursively defined function is factorial:

$$
n! = \begin{cases} 1 &\mbox{if } n = 0\\
n \times (n-1)! &\mbox{if } n > 0\end{cases}
$$

A recursively defined function has to have a base case (sometimes, more than one base case is given). Above, the base case is when $n = 0$. Then a recursive definition has a part where, in order to compute the value of the function for some $n$, you need to know the values of the function for smaller inputs. (This is exactly the same as the concept of recursion from computer science.)

The binomial coefficients we have seen also can be defined recursively using Pascal's triangle. Recall Pascal's triangle is the pattern formed by starting with 1's on the end, and then adding two consecutive numbers from the row above:

$$
\begin{array}{cccccc}
1 & & & & & \\
1 & 1 & & & & \\
1 & 2 & 1 & & & \\
1 & 3 & 3 & 1 & & \\
1 & 4 & 6 & 4 & 1 & \\
1 & 5 & 10 & 10 & 5 & 1
\end{array}
$$

This definition is given by:

$$
\binom{n}{k} = \begin{cases} 1 &\mbox{if } k = 0 \mbox{ or } k = n \\
\binom{n-1}{k-1}+\binom{n-1}{k} &\mbox{if } 1 \leq k \leq n - 1
\end{cases}
$$

We can prove that this definition is equivalent to the definition $\binom{n}{k} = \dfrac{n!}{k!(n-k)!}$ for all $n$ and $k \leq n$:

* If $k = 0$ or $k = n$, just plug in and verify that both definitions give you $\binom{n}{k} = 1$.
* If $1 \leq k \leq n - 1$, then we need to show:

$$\dfrac{(n-1)!}{(k-1)!(n-k)!} + \dfrac{(n-1)!}{k!(n-1-k)!} = \dfrac{n!}{k!(n-k)!}$$

We can show this using some algebra. First, get a common denominator on the left hand side:

$$
\begin{align}
\frac{k}{k}\frac{(n-1)!}{(k-1)!(n-k)!} + \frac{n-k}{n-k}\dfrac{(n-1)!}{k!(n-1-k)!} = \\
\frac{k (n-1)! + (n-k) (n-1)!}{k!(n-k)!}
\end{align}
$$

Now notice that $k(n-1)! + (n-k)(n-1)! = n(n-1)!$, which is just $n!$. So we simplify and get $\dfrac{n!}{(n-k)!}$ on both sides.

We did not need to use induction to prove that these definitions are equivalent. But the recursive definition may be more helpful when we want to prove other results by induction. Think about how you might prove the binomial theorem:

**Theorem**: (Binomial Theorem). Let $x, y$ be variables and $n \geq 0$. Then:

$$(x + y)^n = \sum_{k=0}^n \binom{n}{k} x^{n-k} y^k$$

Think about what a proof by induction for this would look like. First you can let $n = 0$, and realize that $(x + y)^0$ is just $1$. On the other side, what do you get?

Then for the inductive step, you let $n$ be an arbitrary natural number and assume that $(x + y)^n = \sum\limits_{k=0}^n \binom{n}{k} x^{n-k} y^k$. Then consider $(x + y)^{n+1}$. Think of this as $(x + y)(x + y)^n$. Now re-write this as $x(x + y)^n + y(x + y)^n$ using the distributive property, and then use the inductive hypothesis. Can you finish the proof?

**Corollary**: Let $n \geq 0$. Then $$\sum_{k=0}^n \binom{n}{k} = 2^n$$.

Proof hint: Plug in $x = 1$ and $y = 1$ to the Binomial Theorem. What do you get?

**Question**: Can you give a set-theoretic proof of the above identity? Where are the formulas $\binom{n}{k}$ and $2^n$ used in set theory?
