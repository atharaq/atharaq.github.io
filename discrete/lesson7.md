# Discrete Mathematics Lesson 7: Predicate Logic
{:.no_toc}

1. Table of Contents
{:toc}

Today we are revisiting logic. Many of the dieas we started talking about recently, involving set theory, will be important today as we discuss an extension of the classical, propositional logic that we first started.

# Related Propositions (5 min intro)

When we discussed propositional logic, I justified the truth table for $p \rightarrow q$ by saying "If $x > 5$ then $x > 3$" should be true for every single number $x$. But for each $x$, we get a different proposition:

* If 0 > 5, then 0 > 3.
* If 1 > 5, then 1 > 3
* If 2 > 5, then 2 > 3.
* If 3 > 5, then 3 > 3.

And so on. The problem is that it's not possible, in propositional logic, to talk about a whole set of propositions at once. Every proposition, in propositional logic, is considered independently of the others. But it seems like there should be a way to write down a *formula*, and study all the propositions we get by substituting into that formula. In other words, we need a stronger logic that lets us study some kinds of formulas, or templates for propositions. The logic we will use is called **predicate logic**, or **first-order logic**.

# Predicates and Quantifiers (10 mins)

A **predicate** represents an assertion that can be made about one or more mathematical objects. For example, the predicate $P(x)$ could represent the assertion $x > 5$. $x$ is called a **variable** for the predicate. Another predicate, with two variables, $Q(x, y)$, could represent the assertion $x > y$. The number of variables that appear in a predicate is referred to as the **arity** of the predicate. A predicate whose arity is 1 is referred to as a **unary** predicate, a predicate whose arity is 2 is referred to as a **binary** predicate, and more generally a predicate of arity $n$ is referred to as an $n$-ary predicate.

Our examples do not need to be mathematical necessarily. We could have a predicate $C(x, y)$ representing that person $x$ is a child of person $y$. Different kinds of predicates might have different objects that can be plugged in for the variables. The **universe** for a formula is the set from which the variables can take their values from. This is also sometimes referred to as the **domain of discourse**. We will see some examples where this might matter in the next section.

## Universal Quantifier

Consider the predicate $P(x)$ representing the assertion $x \geq 0$. This statement is true for every single natural number. In predicate logic, we can state this using the **universal quantifier**, $\forall$. This is read as "for all".

$$\forall x \: P(x)$$

This is read as "For all $x$, $P(x)$ is true." What do we mean by "for **all** $x$"? We mean that $P(x)$ is a true statement whenever we replace $x$ by any possible object *from our universe*. In particular, the statement $\forall x \\: (x \geq 0)$ is true if our universe is $\mathbb{N}$, but false if our universe is $\mathbb{Z}$.

**Exercise**: Consider the statement "$\forall x \\: (x > 1 \rightarrow x \geq 2)$." Is this statement true or false in the following universes:

* $\mathbb{R}$
* $\mathbb{N}$
* $\mathbb{Z}$
* $\mathbb{Q}$

<details>
    <summary>Check your answers:</summary>
    <ul>
        <li>False: $x = 1.5$ is a counterexample.</li>
        <li>True. If $x = 0$ or $x = 1$ the antecedent is false, and therefore the if-then statement is true. Otherwise both the antecedent and consequents are true, and therefore the whole statement is true.</li>
        <li>True. Similar argument to the case where the universe is $\mathbb{N}$.</li>
        <li>False. $x = 1.5$ is again a counterexample.</li>
    </ul>
</details>

## Existential Quantifier

Often in mathematics, we want to state that a particular problem has a solution. For example, the polynomial $x^2 + 2x + 1$ has a root at $x = -1$. We might also want to say that another polynomial doesn't have a solution: e, $x^2 + 1$ has no roots in $\mathbb{R}$. We can formalize this using the **existential quantifier**, $\exists$. This is read as "there exists".

For example: $\exists x \\: x^2 + 2x + 1 = 0$. We read this is "There is (at least one) $x$ such that $x^2 + 2x + 1 = 0$." This statement is true if our universe is $\mathbb{Z}$, $\mathbb{Q}$, $\mathbb{R}$, or $\mathbb{C}$. But it's not true if our universe is $\mathbb{N}$! (Can you prove that?)

Similarly, the statement $\exists x \\: x^2 + 1 = 0$ is false if our universe is $\mathbb{R}$ (or any subset of $\mathbb{R}$, including $\mathbb{Q}$ or $\mathbb{Z}$), but true in the universe $\mathbb{C}$. We will talk about negations of quantified statements later, but the statement $\lnot \exists x \\: x^2 + 1 = 0$ would, by the laws of classical logic, therefore be true in $\mathbb{R}$ and false in $\mathbb{C}$.

**Exercise**: Let $D(f, g)$ be the predicate: "The derivative of $f$ is equal to $g$." Consider the statement $\exists f \\: D(f, f)$. Determine if this statement is true or false in the following universes:

* $U_1 = \\{ p(x) : p : \mathbb{R} \to \mathbb{R} $ is a non-constant polynomial function $\\}$.
* $U_2 = \\{ f(x) : f : \mathbb{R} \to \mathbb{R}$ is a differentiable function $\\}$.

<details>
    <summary>Check your answers:</summary>
    <ul>
        <li>False: if $p(x)$ is a non-constant polynomial, then its derivative will have a smaller degree, and therefore not be equal to it.</li>
        <li>True: let $f(x) = e^x$, or any constant multiple of $e^x$.</li>
    </ul>
</details>

## Free and Bound Variables

Quick exercise:

1. Suppose our universe is $\mathbb{N}$. Is $x \geq 0$ true or false?
2. Suppose our universe is $\mathbb{N}$. Is $\forall x \\: x \geq 0$ true or false?

<details>
    <summary>Spoilers:</summary>

    <ol>
        <li><b>Neither!</b> It's a formula, not a statement. We could ask about $0 \geq 0$, or $1 \geq 0$, or $372837 \geq 0$. Those statements are all true in this universe. But "$x \geq 0$" is not a statement with a defined truth value.</li>
        <li><b>True</b>. This is a statement that actually has a defined truth value.</li>
    </ol>
</details>

A **formula** can be built up out of predicates, quantifiers, and the basic logical connectives: $\wedge, \vee$, $\lnot$, $\rightarrow$, etc. A variable which does not appear in any quantifier is called a **free variable**. A variable which has been quantified is called a **bound variable**. A **statement** is a formula with no free variables.

Moral of the story: statements have truth values. In general, a formula might not have a truth value. You can plug in for the free variables in the formula (using elements from the universe relevant to the context of the problem), and then determine the truth value of that formula, with that particular assignment of the variables:

* in $\mathbb{Z}$, the statement $3 \geq 0$ is true, and the statement $-1 \geq 0$ is false.

Or you could *quantify* over the variables, and determine the truth of the quantified statement:

* in $\mathbb{Z}$, the statement $\forall x \\: x \geq 0$ is false, and the statement $\exists x \\: x \geq 0$ is true

**Exercises**:

1. Is "$\forall y (y > x)$" a statement? Which variables are free? Which variables are bound?
2. In the formula $x < 1$, the variable $x$ is free. In $\mathbb{N}$, determine the following:
  * Find an assignment for $x$ that makes the formula true.
  * Find an assignment for $x$ that makes the formula false.
  * Is $\exists x \\: (x < 1)$ true or false in $\mathbb{N}$?
  * Is $\exists x \\: \lnot (x < 1)$ true or false in $\mathbb{N}$?

<details>
    <summary>Solutions:</summary>
    <ol>
        <li>It is not a statement. $x$ is free and $y$ is a bound variable.</li>
        <li>
            <ul>
                <li>Let $x = 0$. The statement "$0 < 1$" is true.</li>
                <li>Let $x = 1$. The statement "$1 < 1$" is false.</li>
                <li>Since $0 < 1$ is true, then $\exists x \: (x < 1)$ is true.</li>
                <li>Since $1 < 1$ is false, then $\exists x \: \lnot (1 < 1)$ is true.</li>
            </ul>
        </li>
    </ol>
</details>

## Set Theory Examples (5 mins)

Recall that $A \subseteq B$ means "Every element of $A$ is an element of $B$". We can write this using quantifiers: $\forall x (x \in A \rightarrow x \in B)$. Literally this is read "For any element $x$, if $x$ is in $A$, then $x$ is in B."

Let $A$ be any set. Re-write the following statements using predicate logic:

* $A \subseteq A$
* $\emptyset \subseteq A$

Often times, sets are defined in English sentences that can be formalized using quantifiers. For example, "an even number is a multiple of $2$". More precisely, "$x$ is even if there is $n$ such that $x = 2n$". In set theoretic notation:

$$E = \{ x : x = 2n \mbox{, for some } n \in \mathbb{N} \}$$

Then $x \in E$ if the statement "$\exists n \\: (x = 2n)$" is a true statement about $x$ in the universe $\mathbb{N}$.

**Exercises**

1. Recall that $\mathbb{Q}$ is defined as the set of those numbers which can be written as fractions $\dfrac{m}{n}$, for integers $m$ and $n$, where $n \neq 0$. Give a precise definition using quantifiers of the statement $x \in \mathbb{Q}$. What is the universe for our quantifiers?
2. Let $S$ be the set of perfect squares. Give a precise definition of the statement $x \in S$ (in the universe $\mathbb{N}$)

<details>
<summary>Check your answers</summary>
<ol>
<li>$x \in \mathbb{Q}$ can be stated as: $\exists m \exists n (n \neq 0 \wedge x = \frac{m}{n})$. The universe we are using for our quantifiers is $\mathbb{Z}$.</li>
<li>$x \in S$ if "$\exists n \: x = n^2$" is true in the universe $\mathbb{N}$</li>
</ol>
</details>

# Negations (15 mins)

Earlier we asked:

* Is $\exists x (x < 1)$ true or false in $\mathbb{N}$?
* Is $\exists x \\: \lnot (x < 1)$ true or false in $\mathbb{N}$?

The answer to both of these is **true**: $0 < 1$, so letting $x = 0$ shows that the first statement is true. $\lnot (1 < 1)$, so letting $x = 1$ shows that the second is also true.

This means that the negation of $\exists x (x < 1)$ is **not** the same as $\exists x \\: \lnot (x < 1)$. In general, the negation of a statement should be true whenever the original statement is false, and vice versa.

In English, the negation of $\exists x (x < 1)$ would be "It is not true that there is an $x$ such that $x < 1$." Put more simply: "There is no $x$ such that $x < 1$." So how would we show this? We'd have to argue why, for all $x$, it's not the case that $x < 1$. In other words: the negation of $\exists x (x < 1)$ is $\forall x \\: \lnot (x < 1)$.

In general:

* $\lnot \exists x P(x) \equiv \forall x \lnot P(x)$
* $\lnot \forall x P(x) \equiv \exists x \lnot P(x)$

These are called **De Morgan's Laws for Quantifiers**. Recall De Morgan's Laws for propositional logic: $\lnot (p \vee q) \equiv \lnot p \wedge \lnot q$ and $\lnot (p \wedge q) \equiv \lnot p \vee \lnot q$. For finite universes, the $\forall$ quantifier can be thought of as one big $\wedge$-statement, and the $\exists$ quantifier can be thought of as one big $\vee$-statement.

For example: in the universe $A = \\{1, 2, 4, 8 \\}$, suppose $P(x)$ represents "$x$ is an even number." Then $\forall x P(x)$ is false, because $P(1)$ is false.

In other words, it's not true that $P(1) \wedge P(2) \wedge P(4) \wedge P(8)$. So, in this universe, $\lnot (P(1) \wedge P(2) \wedge P(4) \wedge P(8))$ is true.  De Morgan's Laws tells us that this is the same as $\lnot P(1) \vee \lnot P(2) \vee \lnot P(4) \vee \lnot P(8)$.

But since at least one of those is true, the statement $\exists x \lnot P(x)$ is also true. Again, we can think of $\exists$ as representing a big disjunction: check if any one of the elements of the universe satisfies the condition.

**Exercises**

Write the negations of the following formulas, moving the $\lnot$ sign as far in as possible:

1. $\exists n \\: x = 2n$
2. $\exists n \\: x = 2n + 1$
3. $\forall x (x \geq 0)$

<details>
<summary>Check your answers:</summary>
<ol>
<li>$\forall n \: x \neq 2n$</li>
<li>$\forall n \: x \neq 2n + 1$</li>
<li>$\exists x \: \lnot (x \geq 0)$.</li>
</ol>
</details>

# Nested Quantifiers

Many statements require more than one quantifier to fully express. Consider the statement "Every person has a parent." Let $P(x, y)$ represent the predicate that person $x$ is a parent of person $y$. The statement "Every person has a parent" is written as "$\forall y \exists x P(x, y)$" (where our universe is the set of all people who have ever existed).

Notice that this is **not** the same thing as "$\exists x \forall y P(x, y)$". It's also **not** the same thing as "$\forall x \exists y P(x, Y)$".

* $\forall y \exists x P(x, y)$: "For every person $y$, there is a person $x$ such that $x$ is a parent of $y$." In other words: every person has a parent.
* $\exists x \forall y P(x, y)$: "There is a person $x$ such that for all people $y$, $x$ is a parent of $y$." In other words: there is a person who is a parent to everyone.
* $\forall x \exists y P(x, y)$: "For every person $x$, there is a person $y$ such that $x$ is a parent of $y$." In other words: Every person is a parent to someone.

What would $\forall x \forall y P(x, y)$ represent? What would $\exists x \exists y P(x, y)$ represent? What about $\exists y \forall x P(x, y)$?

## Number Theory Examples

How might we represent "There is no largest integer" in the universe $\mathbb{Z}$?

$$\lnot \exists x \forall y (x \geq y)$$

This is literally read as "It is not the case that there is an $x$ such that for every $y$, $x \geq y$." Recall: "There is no" is represented either as "$\lnot \exists$", or, equivalently, as $\forall \lnot$. So we could, equivalently, write this as $$\forall x \lnot [\forall y (x \geq y)]$$ Again, we can push the $\lnot$ quantifier one more step in: $$\forall x \exists y \lnot (x \geq y)$$ We might read this as "Every $x$ is smaller than some $y$." Intuitively, this should make sense as to why that says the same thing as "There is no largest integer $x$."

**Exercises**:

1. Consider the formula $\exists k \\: n = mk$. What does this represent about $m$ and $n$?
2. Write the formula "$n$ is a prime number" using quantifiers. Recall: a prime number is a number greater than $1$ which has no factors other than $1$ or itself.
3. Write the statement "There is no largest prime number." This one is quite complicated! But it can be done.

<details>
<summary>Solutions</summary>
<ol>
<li>$\exists k \: n = mk$ says that $n$ is divisible by $m$, or $m$ is a factor of $n$</li>
<li>$n$ is a prime number if $n > 1$ and, whenever $m$ is a factor of $n$, then $m$ is either $1$ or $n$. So: $n > 1 \wedge \forall m [\exists k \: (n = mk)] \rightarrow (m = 1 \vee m = n)$</li>
<li>"There is no largest prime" would be "There is no $n$ that satisfies the formula above, such that for any other $x$ satisfying that same formula, $n \geq x$." So:

$$
\begin{align}
\lnot \exists n [n > 1 &\wedge \forall m [\exists k \: (n = mk)]
\\  &\rightarrow (m = 1 \vee m = n)] \wedge
\\ \forall x \: [x > 1 &\wedge \forall m [\exists k \: (x = mk)
\\ &\rightarrow (m = 1 \vee m = x)]]
\\ \rightarrow n \geq x
\end{align}
$$
</li>
</ol>
</details>

## Function Examples

Sometimes we want our quantifiers to range over possibly different universes. We might write this as $\forall x \in A \exists y \in B \ldots$. This way, we only look at $A$ for the first quantifier and $B$ for the second quantifier. This helps us define functions. The predicate $F(x, y)$ represents a function from $A$ to $B$ if the following statement is true:

$$
\begin{align}
&[\forall x \in A \exists y \in B \: F(x, y)] \wedge \\
&[\forall x \in A \forall y \in B \forall z \in B (F(x, y) \wedge F(x, z)) \\
&\rightarrow y = z]
\end{align}
$$

This is quite a mouthful, so let's break it up.

$$\forall x \in A \exists y \in B \: F(x, y)$$

says "Every $x \in A$ has at least one $y \in B$ such that $F(x, y)$ is true." In other words, this part of the statement is ensuring that the function we're trying to define, is defined for every single element of the domain.

If this statement were not true, then there would be *some* $x \in A$ that is not associated with *any* $y \in B$. In other words, the "function" we're trying to look at would not be defined for some $x \in A$.

Now let's look at the second part of that statement:

$$
\begin{align}
&\forall x \in A \forall y \in B \forall z \in B \: (F(x, y) \wedge F(x, z)) \\
&\rightarrow y = z
\end{align}
$$

This says: "For every $x \in A$, whenever $y \in B$ and $z \in B$ are such that $F(x, y)$ and $F(x, z)$, then $y = z$." In other words, this says that the "vertical line test" passes for each $x \in A$.

What would it mean for this last statement to not be true? Negating quantifiers, we would get that there would need to be some $x \in A$, such that there are $y \in B$ and $z \in B$ such that

$$\lnot [(F(x, y) \wedge F(x, z)) \rightarrow y = z]$$

Remember that $p \rightarrow q$ is false if $p$ is true and $q$ is false. In this case, that would mean: there are $y$ and $z$ such that $F(x, y)$ and $F(x, z)$, and also $y \neq z$. That is: the vertical line test does not pass, as the graph of the function would pass through the points $(x, y)$ and $(x, z)$.

**Exercises**: Let $A$ and $B$ be sets and $f : A \to B$ a function.

1. Write the statement that $f$ is one to one.
2. Write the statement that $f$ is **not** one to one. Move the negation in as far as possible.
3. Write the statement that $f$ is onto.
4. Write the statement that $f$ is **not** onto. Move the $\lnot$ in as far as possible.

<details>
<summary>Solutions:</summary>
<ol>
  <li>$f$ is one to one if, whenever $x \neq y \in A$, then $f(x) \neq f(y)$. So: $\forall x \in A \forall y \in A \: (x \neq y \rightarrow f(x) \neq f(y))$</li>
  <li>$\lnot \forall x \in A \forall y \in A \: (x \neq y \rightarrow f(x) \neq f(y))$. This is equivalent to: $$\exists x \in A \exists y \in A \: \lnot (x \neq y \rightarrow f(x) \neq f(y))$$ We can further re-write this as: $$\exists x \in A \exists y \in A \: (x \neq y \wedge f(x) = f(y))$$ which says "There are two elements of $A$ which are different, and are mapped to the same output."</li>
  <li>$f$ is onto if, whenever $y \in B$, there is $x \in A$ such that $f(x) = y$. So: $\forall y \in B \exists x \in A \: (f(x) = y)$</li>
  <li>$\lnot (\forall y \in B \exists x \in A \: f(x) = y))$. This is equivalent to: $$\exists y \in B \forall x \in A \: \lnot (f(x) = y)$$ or, more naturally, just turn that last $\lnot (f(x) = y)$ into $f(x) \neq y$: $$\exists y \in B \forall x \in A \: f(x) \neq y$$ We can read this as "There is a $y \in B$ such that no $x \in A$ is mapped to it."</li>
</ol>
</details>

# Proof Strategies With Quantifiers

Often times, when we try to prove a mathematical statement, we can try to write it, formally, using predicate logic. The form of the statement will tell us how we might try to prove it.

If the statement we're trying to prove starts with:

* a universal quantifier: $\forall x \phi(x)$: pick an arbitrary element $x$, show that the property $\phi(x)$ must be true.
* an existential quantifier: $\exists x \phi(x)$: find a specific example of such an $x$ with that property.

The situation reverses if we want to disprove a statement:

* Disproving $\forall x \\: \phi(x)$: find a *counterexample*. That is, find a specific example of an $x$ such that $\lnot \phi(x)$ is true. For example: if $A = \\{ 1, 2, 3 \\}$ and $B = \\{ 1, 2 \\}$, the statement $\forall x (x \in A \rightarrow x \in B)$ is not true, since $x = 3$ is a counterexample. $3 \in A \rightarrow 3 \in B$ is not a true statement.
* Disproving $\exists x \\: \phi(x)$: Pick an arbitrary $x$ and show that $\lnot \phi(x)$ must be true. (That is: prove $\forall x \lnot \phi(x)$)

For example, how would one prove that $\sqrt{2}$ is irrational? Recall that $x \in \mathbb{Q}$ means $\exists m \in \mathbb{Z} \exists n \in \mathbb{Z} (n \neq 0 \wedge x = \dfrac{m}{n})$. So to show $\sqrt{2} \not \in \mathbb{Q}$, we would let $m$ and $n$ be arbitrary integers, with $n \neq 0$, and prove that $\sqrt{2} \neq \dfrac{m}{n}$.

## Example: Even and Odd

**Definition**: Let $n \in \mathbb{Z}$. We say $n$ is **even** if there is $k \in \mathbb{Z}$ such that $n = 2k$. We say $n$ is **odd** if there is $k \in \mathbb{Z}$ such that $n = 2k + 1$.

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

**Exercise**: Prove that, for any $n \in \mathbb{Z}$, if $n^2$ is even, then $n$ is even.

Hint: Let $n$ be an arbitrary integer. It may be easier to prove the contrapositive for $n$. But be precise about the contrapositive, and use the statements we have just proved.

<details>
    <summary>Proof</summary>

<p>Let $n \in \mathbb{Z}$ be an arbitrary integer. We want to show that if $n^2$ is even, then $n$ is even. The contrapositive of this statement is: if $n$ is not even, then $n^2$ is not even. So let's assume that $n$ is not even. Since every number is either even or odd, $n$ must be odd, so there is $k \in \mathbb{Z}$ such that $n = 2k + 1$. Therefore $n^2$ is $(2k+1)^2$, which is $4k^2 + 4k + 1$. Let $m = 2k^2 + 2k$, and so $4k^2 + 4k + 1 = 2m + 1$. Therefore $n^2 = 2m + 1$, and so $n^2$ is odd. Since no number is both even and odd, this means $n^2$ is not even, which completes our proof.</p>
</details>
