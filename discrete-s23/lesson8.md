# Discrete Mathematics Lesson 8: More Predicate Logic / Review
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

Suppose $L(x, y, t)$ means "Person x loves Person y at Time t."

* Write "Everybody loves somebody sometime" in predicate logic
* Translate $\exists x \forall y \forall t (L(x, y, t))$ to English
* Translate $\exists y \forall x \exists t (L(x, y, t))$ to English
* Translate $\exists t \forall x \forall y (L(x, y, t))$ to English

**Challenge**: Let $p$ be some person in our universe. Translate $\exists y \forall t (L(p, y, t) \wedge \forall z L(p, z, t) \rightarrow z = y)$.

# Problem Set 2

## Uncountability

* "Infinite binary sequence"? Ex: $(0, 1, 1, 0, 1, 0, \ldots)$
* A sequence: for each $n$, there is a 0 or 1 at position $n$.
* Usually defined as a function $s : \mathbb{N} \to \{ 0, 1 \}$, so $s(0)$ is the first bit, $s(1)$ is the second, etc

How would we show that the set of all binary sequences is uncountable? Diagonalization! Let $f : \mathbb{N} \to B$ be a function. We will show it's not a *surjection*:

Example:

* $f(0) = (\mathbf{0}, 0, 0, 0, \ldots)$
* $f(1) = (0, \mathbf{1}, 0, 1, \ldots)$
* $f(2) = (0, 1, \mathbf{1}, 1, \ldots)$
* $f(3) = (0, 1, 1, \mathbf{0}, \ldots)$

Can we find an infinite sequence $s$ which is different from each of these? Different from $f(0)$ at bit 0, from $f(1)$ at bit 1, from $f(2)$ at bit 2, etc?

## Symmetry

Suppose $f : A \to B$ is a bijection. Can you find a bijection $g : B \to A$?

Hint: **inverse** function!

* Prove that $f$ has an inverse: that is, prove that there is a function $g : B \to A$ such that $(g \circ f)(x) = x$
* Prove that that $g$ is a bijection.

## Transitivity

Suppose $f : A \to B$ is a bijection and $g : B \to C$ is a bijection. Can you find a bijection $h : A \to C$?

Hint: **composition** of functions!

* Define $(g \circ f) : A \to C$.
* Show that $(g \circ f)$ is a bijection.

# Predicate Logic

* $\forall x$: "For every $x$ in our universe..."
  * Prove $\forall x P(x)$: Let $x$ be an **arbitrary** member of the universe. Then (argue why $P(x)$ must be true).
  * Disprove $\forall x P(x)$: find one *counterexample*: one $x$ in the unvierse with the property that $P(x)$ is false.
* $\exists x$: "There exists (at least one) $x$ in the universe..."
  * Prove $\exists x P(x)$: find a specific example of $x$ in the universe where $P(x)$ is true.
  * Disprove: Let $x$ be an arbitrary member of the unvierse. Show that $P(x)$ is false.

First: finish the notes from last time:

* [Free and bound variables](lesson7.html#free-and-bound-variables)
* [Set Theory Examples](lesson7.html#set-theory-examples)
* [Negations](lesson7.html#negations-15-mins)
* [Nested quantifiers](lesson7.html#nested-quantifiers)
* [Proof strategies](lesson7.html#proof-strategies-with-quantifiers)

Reminder that you should always go through the notes and videos on your own as well, and come to class prepared with questions about those.

## More Examples

**Example 1**: Write the statement that between any two numbers, there is another number.

<details>
<summary>Click for answer</summary>
<p>$\forall x \forall y (x < y \rightarrow \exists z (x < z \wedge z < y))$</p>
</details>

Find a universe in which this is true, and a universe in which this is false.

**Example 2**: Write a statement, using only integers, that $\sqrt{2}$ is irrational

<details>
<summary>Click for answer</summary>
<p>$\forall m \in \mathbb{Z} \forall n \in \mathbb{Z} (m^2 \neq 2n^2)$</p>
</details>

## Injections / Surjections / Bijections

**Example 3**: Injections / Surjections / Bijections

Write the statement that $f : A \to B$ is one to one:

<details>
<summary>Click for answer</summary>
<p>$\forall x \in A \forall y \in A (x \neq y \rightarrow f(x) \neq f(y))$</p>
</details>

**Exercise**: Show that $f : \mathbb{N} \setminus \{ 0 \} \to \mathbb{N}$ given by $f(n) = \dfrac{n^2 - n}{2}$ is one to one.

We show the contrapositive: let $x, y \in \mathbb{N} \setminus \{ 0 \}$ and suppose $\dfrac{x^2 - x}{2} = \dfrac{y^2 - y}{2}$. Then: $x^2 - x = y^2 - y$. So $x^2 - y^2 + (y - x) = 0$. Then do some algebra:

Factoring, you get $(x+y)(x - y) - (x - y) = 0$. Do a little more algebra and you see it factors as $(x- y)(x+y - 1) = 0$. Therefore, either $x = y$ or $x + y = 1$.

**Question**: Why can't $x + y = 1$ if $x, y \in \mathbb{N} \setminus \{ 0 \}$?


**Exercise**: Show that $g : \mathbb{N} \setminus \{ 0 \} \times \mathbb{N} \setminus \{ 0 \} \to \mathbb{N}$ given by $g(a, b) = a^b - b^a$ is **not** one to one.

Notice  $g(1, 1) = 1 - 1 = 0$, and $g(2, 2) = 4 - 4 = 0$. (This is enough to conclude that it's not onto. Why?)


**Exercise**: Write the statement that $f : A \to B$ is onto.

<details>
<summary>Click for answer</summary>
<p>$\forall y \in B \exists x \in A (f(x) = y)$</p>
</details>

**Example**: Show that $g : \mathbb{N} \setminus \{ 0 \} \times \mathbb{N} \setminus \{ 0 \} \to \mathbb{N}$ given by $g(a, b) = a^b - b^a$ is onto.

Proof: Let $y \in \mathbb{N}$. Find $a, b$ such that $a^b - b^a = y$. Easiest way: choose $b = 1$! Then it just says: $a - 1^a = y$. But since $1^a = 1$, for any $a$, we can solve for $a$ here: $a = y + 1$.

Again notice: we only need **one** example for each $y$. There may be plenty.

**Example**: Show that $f : \mathbb{N} \setminus \{ 0 \} \to \mathbb{N}$ given by $f(n) = \dfrac{n^2 - n}{2}$ is **not** onto.

Compute some values: $f(1) = 0, f(2) = 1, f(3) = 3, f(4) = 6$, etc. Seems like $y = 2$ is missed? So now the question becomes: Is there a solution to: $\dfrac{n^2 - n}{2} = 2$?

Do some algebra: $n^2 - n = 4$, or just $n^2 - n - 4 = 0$. Then use the quadratic formula:  $n = \dfrac{1 \pm \sqrt{17}}{2}$. Not a natural number!

**Example**: Write the statement that $f : A \to B$ is a bijection.

<details>
<summary>Click for answer</summary>
<p>$\forall y \in B [\exists x \in A (f(x) = y \wedge \forall z \in A (f(z) = y \rightarrow x = z))]$</p>
</details>

"Every $y \in B$ has one and only one $x \in A$ mapping to it."

Or: write down both statements that f is one to one, and that f is onto, and put an $\wedge$ symbol between them.

**Example**: Show that $f : \mathbb{Q} \to \mathbb{Q}$ given by $f(x) = 2x - 1$ is a bijection.

* Show it's one to one: if $2x - 1 = 2y - 1$, then doing some algebra we conclude $x = y$.
* Show it's onto: if $y \in \mathbb{Q}$, find $x$ such that $2x - 1 = y$.
  * How? Solve for $x$:
  * $x = \dfrac{y+1}{2}$
