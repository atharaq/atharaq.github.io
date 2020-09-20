# Discrete Mathematics Lesson 5: Set Theory
{:.no_toc}

1. Table of Contents
{:toc}

# Ordered Pairs and Tuples

The two sets $\\{ 0, 1 \\}$ and $\\{ 1, 0 \\}$ are considered equal, because sets are determined entirely by the elements, and not their orders. So we need a new kind of object that does destinguish between orders: this is the notion of the ordered pair, or, more generally, an ordered $n$-tuple. There is a set-theoretic definition of ordered pair, but it's not super important: all that matters is that $(0, 1) \neq (1, 0)$ as ordered pairs. Our notation here is important: the parentheses represent ordered pairs, while the curly braces represent sets. More generally, we can think about ordered triples, like $(0, 1, 0)$, or ordered $n$-tuples, like $(a_1, a_2, \ldots, a_n)$.

Give two sets $A$ and $B$, the **Cartesian product** $A \times B$ is the set of all ordered pairs of the form $(a, b)$, where $a \in A$ and $b \in B$. For example, if $A$ and $B$ are both the set of real numbers $\mathbb{R}$, the set $\mathbb{R} \times \mathbb{R}$ is the normal Cartesian plane. In general, we refer to $A \times A$ as $A^2$.

Lastly, one more definition which we will refer to again later: a relation $R$ between sets $A$ and $B$ is any subset of $A \times B$. For example, if $A$ and $B$ are both the set of integers $\mathbb{Z}$, one relation we might consider is the set $\\{ (x, y) : x \leq y \\}$. This is the "order"-relation on $\mathbb{Z}$.

# Functions

By now, you have quite a bit of experience with functions, mostly functions of real numbers. Usually, you may have heard of a function as a "rule" of some sort associating some input with some output. We will provide a more formal definition here:

**Definition**: Given two sets $A$ and $B$, a function $f : A \to B$, read as "$f$ is a function from $A$ to $B$", is a subset of $A \times B$ such that for each $a \in A$, there is exactly one $b \in B$, such that $(a, b) \in f$. $A$ is referred to as the **domain** of $f$, and $B$ is referred to as the **codomain** of $f$.

This definition is meant to formalize the "vertical line test": a graph on the plane depicts a function if no $x$-value has more than one corresponding $y$-value. So, for example, the following graph depicts one function, and one relation which is not a function.

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/63ijz7utzo?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

Normally, we write $f(a) = b$ instead of $(a, b) \in f$: that is, we use functional notation rather than "set theoretic notation". Some more vocabulary / notation:

* Recall that the **domain** of $f$ is the set of all $x$-values such that $f(x)$ is defined.
* The **codomain** of $f$ constrains where $f$ can take its outputs from.
* The domain and codomain are part of the *definition* of the function itself. For example, I cannot say $f(x) = x$ is a function. I need to say what the domain and codomain of $f$ is.
  * The function $f: \mathbb{N} \to \mathbb{N}$ given by $f(n) = n$ is a **different function** from $g : \mathbb{N} \to \mathbb{Z}$ given by $g(n) = n$.
* if $a \in A$, we refer to $f(a)$ as the **image** of the point $a$.
* if $X \subseteq A$, the set $f(X) = \\{ f(a) : a \in X \\}$ is referred to as the **image** of the set $X$.
* $f(A)$ is called the image of $f$

## Examples

Our definition of a function is a set of ordered pairs with a particular property. So let's look at some examples of sets of ordered pairs:

* As a subset of $\\{ 0, 1 \\} \times \\{ a, b, c \\}$: $\\{ (0, a), (0, b), (1, c) \\}$ is **not** a function because there is no single output for $0$.
* As a subset of $\\{ 0, 1 \\} \times \\{ a, b, c \\}$: $\\{ (0, a) \\}$ is **not** a function because there is no output for $1$
* As a subset of $\\{ 0 \\} \times \\{ a, b, c \\}$: $\\{ (0, a) \\}$ **is** a function!. This is the function $f : \\{ 0 \\} \to \\{ a, b, c \\}$ given by $f(0) = a$.

How many functions are there from $\\{ 0 \\} \to \\{ a, b, c \\}$? How many from $\\{ 0, 1 \\}$ to $\\{a, b, c\\}$?

## Injections: One to One

$f : X \to Y$ is called **one to one**, or an **injection** (as an adjective, **injective**), if whenever $a \neq b \in X$, then $f(a) \neq f(b)$. Let's look at a couple of examples:

* Consider $f : \mathbb{R} \to \mathbb{R}$ defined by $f(x) = x^2$. This is **not** one to one, because $f(1) = f(-1)$.
* Let's again think of the function $g(x) = x^2$, but this time let's let $g : \mathbb{N} \to \mathbb{N}$. Then $g$ **is** one to one: among natural numbers, if $n \neq m$, then $n^2 \neq m^2$. (Can you prove this?)

## Surjections: Onto

$f : X \to Y$ is called **onto**, or a **surjection** (as an adjective, **surjective**), if whenever $y \in Y$, there is at least one $x \in X$ such that $f(x) = y$. Another way to think of this: a function $f : X \to Y$ is onto if the codomain, $Y$, is equal to the image of $f$, $f(X)$. Some examples:

* $f : \mathbb{N} \to \mathbb{N}$ given by $f(n) = n$ is onto.
* $g : \mathbb{N} \to \mathbb{Z}$ given by $g(n) = n$ is **not** onto, since there is no $x$ such that $f(x) = -1$.

Let $S$ be the set of perfect squares. Then $h : \mathbb{Z} \to S$ given by $h(n) = n^2$ is an onto function that is not one to one. It's onto because given a perfect square $s$, there is an integer $n$ such that $n^2 = s$. This is the definition of a perfect square: $\sqrt{s}$ is an integer!. It's not one to one because $1^2 = (-1)^2$.

Let's keep in mind the previous paragraph in terms of how to argue that a function is or isn't onto, and is or isn't one to one. To show that it wasn't one to one, I showed a *counterexample*: two numbers that were mapped to the same number. To show that a function is one to one, you have to prove, for any, arbitrary $n$ and $m$, if they are not equal, then $f(n) \neq f(m)$. (You could show the contrapositive: start with $n$ and $m$ such that $f(n) = f(m)$, and conclude that $n = m$.

Similarly, to show that a function is not onto, you show a counterexample: a single $y$ in the codomain that is not the image of any point. To show that a function is onto, you have to show that given an arbitrarily chosen $y$ in the codomain, you can find an $x$ in the domain where $f(x) = y$.

## Bijections: Both

A function that is both one to one and onto is called a **bijection**. A bijection is sometimes called a **one to one correspondence**. Let's look at some examples:

Let $A$ be the set of all strings ("words") of length 3 that can be made with the letters $\\{ a, b \\}$, and $B$ the set of all strings of length 3 that can be made with the numbers $\\{ 0, 1 \\}$. I will refer to $B$ as the set of all "**binary strings of length 3**". These sets can be put into a one to one correspondence by turning a's into 0s, and b's into 1s:

$$
\begin{align}
aaa \mapsto 000 \\
aab \mapsto 001 \\
aba \mapsto 010 \\
abb \mapsto 011 \\
baa \mapsto 100 \\
bab \mapsto 101 \\
bba \mapsto 110 \\
bbb \mapsto 111
\end{align}
$$

Another way to think about a bijection between two sets is to see if there is a way of "labeling" objects from one set using objects from another set. As an example, let's think of the set of those strings of length 3 that can be made with the numbers 0 and 1. Later on we will learn about binary numbers: every natural number can be represented in binary (instead of the usual decimal system). We only need three binary digits (also called **bits**) to represents the numbers $0$ through $7$. So we have a bijection, by labeling each binary string by the number that it represents: $g : \\{ 0, 1, 2, 3, 4, 5, 6, 7 \\} \to B$ would be given by:

$$
\begin{align}
g(0) &= 000\\
g(1) &= 001\\
g(2) &= 010\\
g(3) &= 011\\
g(4) &= 100\\
g(5) &= 101\\
g(6) &= 110\\
g(7) &= 111
\end{align}
$$

We will study how to convert from a number to its binary representation later this semester.

## Example: Power Sets / Binary Strings

There is an interesting bijection between power sets and binary strings. Let's stick with sets of 3 objects and strings of length 3. Let's look at the set $A = \\{ a, b, c \\}$. In a sense, we can think of binary strings of length 3 as describing subsets of $A$. Let's think of it this way: a single 0 or 1 in a particular position will represent the answer to a "yes" or "no" question (with 1 representing "yes", 0 representing "no"). So: what, exactly is the question? That is, what are the 3 yes/no questions we need to ask in order to describe a subset of $A$?

We need to know 3 bits of information to describe a subset $X \subseteq A$: is $a \in X$? Is $b \in X$? And, is $c \in X$? So, for example, the string $011$ might represent the set $\{ b, c \}$, since the $0$ represents a "no" for the first question, the $1$ represents a "yes" to the second question, and the last $1$ represents a "yes" to the third question.

This is quite an informal description of a function, but we can write it down explicitly since there are only $8$ possible binary strings of length 3:

$$
\begin{align}
000 &\mapsto \emptyset\\
001 &\mapsto \\{ c \\}\\
010 &\mapsto \\{ b \\}\\
011 &\mapsto \\{b, c \\}\\
100 &\mapsto \\{a \\}\\
101 &\mapsto \\{a, c \\}\\
110 &\mapsto \\{a, b \\}\\
111 &\mapsto \\{a, b, c \\}
\end{align}
$$

Here I am using the fact that we enumerated all 8 binary strings of length three previously. Why is this a bijection? We need to show that this function is one to one and onto. First: it's one to one, because when we look at the outputs, they are all different!

So why is it "onto"? Take a set $X \subseteq A$. We know that, since it's a subset of $A$, we can ask if $a \in X$, $b \in X$, and if $c \in X$. Each of these questions would give us a yes/no, or a 1/0 response. Put those together and we get the corresponding binary string. That is, we can invert this function!

## Non-examples

There is no bijection from the set $\\{ 0, 1 \\}$ to the set $\\{ a, b, c \\}$. Why not? Let's look at all possible functions:

* There are three functions from $\\{ 0, 1 \\}$ to $\\{ a, b, c \\}$ which map $0$ to $a$. One of these maps $1$ to $a$, one maps $1$ to $b$, and one maps $1$ to $c$. In the first two cases, $c$ is not in the image, and in the last case, $b$ is not in the image.
* Similarly, there are three functions from $\\{0, 1 \\}$ to $\\{a, b, c \\}$ which map $0$ to $b$, and three which map $0$ to $c$. Each one of these will leave *something* out of the iamge.

So when is there a bijection between two sets? It's a fairly simple characterization: the two sets need to have the same size!

**Theorem**: Let $A$ and $B$ be finite sets. There is a bijection between $A$ and $B$ if and only if $A$ and $B$ have the same number of elements in them.

**Proof**:

This is an "if and only if" statement, which means we have to prove two implications. If there is a bijection between $A$ and $B$, then $A$ and $B$ have the same number of elements. And if $A$ and $B$ have the same number of elements, then there is a bijection between the two sets.

I will leave the first implication to you on the next problem set. What do you need to prove here? You assume that $f : A \to B$ is a bijection, which means it's one to one and onto. You then need to show that $A$ and $B$ have the same number of elements. So start by assuming that $A$ has $n$ distinct elements, and let $a_1, \ldots, a_n$ enumerate those elements (so they are all different). You must conclude that $B$ also has exactly $n$ elements, somehow.

For now, though, let's prove the second implication: that if two sets have the same number of elements, then there is a bijection between them. Let's suppose that $A$ and $B$ both have size $n$, for some $n \geq 0$. We can enumerate the elements of $A$ as $\\{ a_1, a_2, \ldots, a_n \\}$, and the elements of $B$ as $\\{ b_1, b_2, \ldots, b_n \\}$. Then the function $f : A \to B$ which is defined by $a_i \mapsto b_i$ is a bijection!

This is fairly simple to see, but there are actually three things to show here:

1. The $f$ we describe is actually a function. That is, for each $a \in A$, there is exactly one $b \in B$ such that $f(a) = b$. This is true because the $a_i$ are all different: if $a_1 = a_2$, then we might have a problem. But we don't, since we assumed that these were exactly the $n$ elements of $A$.
2. $f$ is one to one. This is because, for any $i \neq j$, $b_i \neq b_j$. Again, for the same reason as before, we assume that $b_1, b_2, \ldots, b_n$ are exactly the $n$ elements of $B$.
3. $f$ is onto. Again, since $B$ has exactly $n$ elements, we see that every $b \in B$ must be labeled as $b_i$, for some $i \leq n$. That means $f(a_i) = b$, so $b$ is in the image of $f$.

# Cardinality

Our theorem above provides motivation for our following definition.

**Definition**: Let $A$ and $B$ be (possibly infinite) sets. Then $\|A\| = \|B\|$, read "the **cardinality** of $A$ is equal to the cardinality of $B$", if there is a bijection $f : A \to B$.

The word "cardinality" is now going to be used to generalize the meaning of "size" to infinite sets. This was Cantor's main observation: that really when we "count" finite sets, we are putting that set in bijection with with a set of the form $\\{1, 2, \ldots, n \\}$. Indeed: when we say that a set has $n$ elements, we list out those $n$ elements as $a_1, a_2, \ldots, a_n$. This is a bijection: $i \mapsto a_i$! Take any finite set you can think of. For example, take the set of capital letters of the English alphabet. Putting them in alphabetical order puts them in bijection with the set of integers from 1 to 26 (inclusive): $1 \mapsto `A'$, $2 \mapsto `B'$, etc.

What Cantor did, then, was to take this observation, and turn it into a definition. How do we make sense of two infinite sets being the same size? If we can "count" one using the other set as our "labels".

## Natural Numbers and Evens

Let $2\mathbb{N} = \\{ x : $ there is $n \in \mathbb{N}$ such that $x = 2n \\}$ denote the set of even natural numbers. This is the set of numbers that can be formed by multiplying a natural number by 2.

Let $f : \mathbb{N} \to 2\mathbb{N}$ be given by $f(n) = 2n$. This is a bijection! That means that $\|\mathbb{N}\| = \|2\mathbb{N}\|$. This is strange, since $\mathbb{N}$ is clearly "bigger" than $2\mathbb{N}$: $2\mathbb{N} \subseteq \mathbb{N}$, and then there are all the odd numbers like $1, 3, \ldots$. So $\mathbb{N} \setminus 2\mathbb{N}$ is also infinite. But this is the paradoxical nature of infinity. Infinite sets can be put into bijection with seemingly smaller sets.

Why is this function a bijection? Let's prove it. We will first show the contrapositive of the statement that $f$ is an injection. Suppose $m$ and $n$ are natural numbers and $2m = 2n$. Simple algebra then tells us $m = n$. This is the contrapositive of "If $m \neq n$, then $f(m) \neq f(n)$."

Now let's show that it is a surjection. Let $y \in 2\mathbb{N}$. Then there is $n \in \mathbb{N}$ such that $y = 2n$. So by definition, $f(n) = y$.

## Symmetry

Notice that our definition of $\|A\| = \|B\|$ involves a function $f : A \to B$. We want $\|A\| = \|B\|$ to mean the same thing as $\|B\| = \|A\|$. It turns out that this is true: if there is a bijection $f : A \to B$, then there is another bijection $g : B \to A$. We say that cardinality is **symmetric**: if there's a bijection from one set to another, there is another one backward.

How might we prove this? Let's only look at an example here, but you should be prepared to prove a statement like this in the future. We saw that $f : \mathbb{N} \to 2\mathbb{N}$, given by $f(n) = 2n$, is a bijection. Can we find a bijection $g : 2\mathbb{N} \to \mathbb{N}$?

Start with an even natural number $y$. By definition, that means there is some $n$ such that $2n = y$. So let's let $g(y) = n$. That is, let's let $g(y) = \dfrac{y}{2}$. Since $y$ is an even number, we can divide it by 2, and still get a natural number.

Why is this a bijection? First, it's one to one. If $\dfrac{x}{2} = \dfrac{y}{2}$, then by algebra we get $x = y$. And it's onto: if $n \in \mathbb{N}$, let $y = 2n$, and $\dfrac{2n}{2} = n$.

More generally: what did we do here? What's the relationship between $f$ and $g$?

## Natural Numbers and Integers

Before we saw that $\|\mathbb{N}\| = \|2\mathbb{N}\|$. Here we will see that $\|\mathbb{N}\| = \|\mathbb{Z}\|$. Recall that $\mathbb{Z}$ is the set of all integers, and so it contains $\mathbb{Z}$ as well as $-1, -2, -3, \ldots$ So again we will see an example of an infinite set that contains a "smaller" infinite set, but the two can be matched up in a one to one correspondence.

The idea here is that we can "re-order" the integers starting at 0 and going outward. That is, we can write the integers down in the order $0, -1, 1, -2, 2, \ldots$, alternating between negatives and positives. We have not written down, explicitly, the bijection, but we could write one down as a piecewise function:

$$
h(n) = \begin{cases} \frac{n}{2} & \mbox{if } n \mbox{ is even}\\
-\frac{n+1}{2} &\mbox{if } n \mbox{ is odd}\end{cases}
$$

Let $O$ be the set of odd numbers. Notice that $f(2\mathbb{N})$, the image of the set of even numbers, is $\mathbb{N}$, for the same reason that the function $g: 2\mathbb{N} \to \mathbb{N}$ in the previous section was a bijeciton. Also notice that $f(O)$ is the set of all negative integers: $f(1) = -1$, $f(3) = -2$, $f(5) = -3$, etc. This is not a proof, but a formal proof could be given later on.

## Transitivity

So far we have seen that $\|\mathbb{N}\| = \|2\mathbb{N}\|$ and that $\|\mathbb{N}\| = \|\mathbb{Z}\|$. We might expect, then that $\|2\mathbb{N}\| = \|\mathbb{Z}\|$. We would be correct!

In general, cardinality is **transitive**: if we have three sets $A, B, C$ and $\|A\| = \|B\|$ and $\|B\| = \|C\|$, then $\|A\| = \|C\|$. How might we prove this? We need to show: if we have a bijection $f: A \to B$ and a bijection $g : B \to C$, that we can find a bijection $h : A \to C$. Again, I will ask you to prove this in general, but let's look at a specific example here.

We want to map the numbers $0, 2, 4, 6, 8, \ldots$ to the numbers $0, -1, 1, -2, 2, \ldots$ How might we do this? well, we know that if we start with an even number, we can divide it by 2 and get a natural number. And we know that if we start with a natural number, we have some rule (above) that gives us an integer.

So let's combine these two! Let's describe (in words) a function $F : 2\mathbb{N} \to \mathbb{Z}$ informally. $F$ works by first taking an even number $n$ and dividing it by 2. Then, using the rule above, if $\dfrac{n}{2}$ is even, it divides that by 2 again. If not, it adds 1 to that, divides it by 2 again, and then negates it. This is the number that $F(n)$ would output.

Let's check a few examples:

* $\frac{0}{2}$ is $0$, which is even, so $F(0) = 0$.
* $\frac{2}{2}$ is $1$, which is odd. So then $F(2)$ will be $-\frac{1 + 1}{2}$, which is $1$
* $\frac{4}{2}$ is $2$, which is even. $F(4)$ will divide that by 2 again, so $F(4) + 1$.

We are not proving it here, but $F$ is, in fact, a bijection. Proving that it is a bijection would basically involve the same steps as proving the more general statement, so we will skip this for now.
