# Linear Lesson 14: Vector Spaces (Continued)
{:.no_toc}

1. Table of Contents
{:toc}

# Warm-up: Algebra

With at least one partner, discuss the following: what are all the properties of numbers that allow you to solve the following equation: $$2x + 3 = 9 - x.$$

## Linear Combinations

Recall that we began the semester asking about questions of "reachability". Eventually we defined the notions of linear combinations and spans. The point of the 10 vector space properties is to ensure that linear combinations make sense. For example: the fact that we have closure under addition and scalar multiplication means that if $v, w \in V$, then $3 \cdot v + 4 \cdot w \in V$, so it means that it makes sense to talk about this linear combination.

What about some of the other properties? Associativity of addition means that if we want to talk about $a_1 \cdot v_1 + a_2 \cdot v_2 + a_3 \cdot v_3$, we don't have to worry whether this means $(a_1 \cdot v_1 + a_2 \cdot v_2) + a_3 \cdot v_3$, or $a_1 \cdot v_1 + (a_2 \cdot v_2 + a_3 \cdot v_3)$.

The other properties tell us that scalar multiplication and vector addition "play nicely" with each other. For example, if I rescale a vector by 5, it's the same as, separately, re-scaling the vector by 2 and by 3, and then adding those results. That is exactly what we should expect. Moreover, it simplifies notation when writing linear combinations: we don't need to worry about, for example, linear combinations of the form $a \cdot v + b \cdot v + c \cdot w$ in order to think about the span of $v$ and $w$!

# Functions as Vector Spaces

Let $\mathcal{F}(\mathbb{R})$ be the set of all functions $f : \mathbb{R} \to \mathbb{R}$. There are lots of functions here, we are literally talking about all functions. Some might not be continuous anywhere, might not have any "rule" for them, etc.

We can define how to "add" functions and how to multiply functions by a scalar (real number). If $f$ and $g$ are functions, then we define $f + g$ to be the function $(f + g)(x) = f(x) + g(x)$.

Similarly, if $f$ is a function and $r \in \mathbb{R}$, then we define $r \cdot f$ to be the function $(r \cdot f)(x) = r f(x)$. That is, it's the function defined so that, given input $x$, you compute $f(x)$ and then multiply that by the real number $r$.

Clearly this shows that properties 1 and 2 hold. We should show the other eight properties. I won't really say much about most of them, as most of them are routine to verify.

3. Associativity: $(f(x) + g(x)) + h(x) = f(x) + (g(x) + h(x))$, this follows from associativity of addition of real numbers.
4. Commutativity also follows from commutativity of addition of real numbers.
5. The zero vector here will be the function $z(x) = 0$, the function that outputs zero for all numbers $x$. Clearly, $(f + z)(x) = f(x) + 0 = f(x)$.
6. What should the "additive inverse" of $f(x)$ be?
7. $((\alpha + \beta) \cdot f)(x)$ is just the function $(\alpha + beta)f(x)$. Then distributivity should show that this is equal to $(\alpha \cdot f)(x) + (\beta \cdot f)(x)$.

Similarly, 8, 9, and 10 are routine, so I won't show too much about these.

## Continuous Functions

The vector space $\mathcal{F}(\mathbb{R})$ has very badly behaved functions in it, including functions that are extremely hard to define, functions that are continuous but nowhere differentiable, functions that are discontinuous at infinitely many points but continuous and differentiable everywhere else, etc. Let's restrict this a bit and only consider *continuous functions*.

The set $C^0(\mathbb{R}) = \\{ f \in \mathcal{F}(\mathbb{R}) : f$ is continuous at every $x \in \mathbb{R} \\}$. This set is also a vector space! First notice that the operations of addition and scalar multiplication on $\mathcal{F}(\mathbb{R})$ could be applied to continuous functions, and that $C^0(\mathbb{R})$ is closed under these operations!

That is: if $f$ and $g$ are continuous, then $f + g$ is continuous, and if $f$ is continuous, then $r \cdot f$ is continuous (for all $r \in \mathbb{R}$). These follow from properties of limits and continuity that you may have studied in Calc I.

What t about the other 8 properties? Well if addition is associative when we add *any* functions, then it's still associative if we only look at the continuous ones. Similarly for the properties of scalar multiplication and distribuitivity and things like that. We do need to check the existence of the "zero" vector here, but that's just asking: is the function $z(x) = 0$ continuous at each $x$? The answer is clearly yes, since if you graph $z(x)$ you get a straight line (the $x$-axis).

## Polynomials

Continuous functions are more nicely behaved, but we can refine them further in many ways. I will discuss other refinements of this vector space later, but for now, let's think about $\mathcal{P} = \\{ f \in \mathcal{F}(\mathbb{R}) : f$ is a polynomial function $\\}$. Recall that a polynomial is a function of the form $f(x) = a_0 + a_1 x + \ldots + a_n x^n$, for some natural number $n$.

Notice that if $f$ and $g$ are both polynomials, their sum is also a polynomial. Just add "like" terms, so for example, if $f(x) = 1 + 2x + 3x^2$ and $g(x) = 2 + 3x + 4x^3$, then (f + g)(x) = 3 + 5x + 3x^2 + 4x^3$, which is also a polynomial.

Similarly, if you rescale a polynomial, it's still a polynomial. $1.5 \cdot (4 + x - x^2 + 2x^4) = 6 + 1.5 x - 1.5x^2 + 3 x^4$. And the zero function is still a polynomial (by definition). Again, this means that $\mathcal{P}$ is also a vector space! In fact, this is going to be an interesting vector space we will study later on for a particular reason: it is **infinite dimensional**. That is, no finite set of polynomials will span this entire vector space!

## Polynomials of Degree $\leq$ 2

For an example of a finite dimensional vector space, let's consider the set of polynomials of degree less than or equal to 2, referred to as $\mathcal{P}_2$. This set is also a vector space. Again, all we need to check at this point is that the set is closed under addition (so if we add $(a_0 + a_1 x + a_2 x^2) + (b_0 + b_1 x + b_2 x^2)$, we get another polynomial of degree at most 2), closed under scalar multiplication (so that $r \cdot (a_0 + a_1 x + a_2 x^2)$ is a polynomial of degree at most 2), and that the zero polynomial is here. I'll leave this as an exercise here.

## Non Example

What about the set of all polynomials of degree exactly equal to 2? This is not a vector space for a few reasons:

1. The zero polynomial is not in this set (the degree of the zero polynomial is traditionally considered to be -1).
2. Moreover, this set is not closed under addition! $x^2 + x$ and $-x^2$ are both polynomials of degree 2, but if we add them, we just get $x$, which is a polynomial of degree 1!

# Subspaces

**Definition**: Let $V$ be a vector space and $W \subseteq V$ such that $W$ is *also* a vector space (under the same definitions of addition and scalar multiplication as in $V$). Then $W$ is called a **subspace** of $V$.

We have seen that $\mathcal{P}_2$ is a subspace of $\mathcal{P}$, that $\mathcal{P}$ is a subspace of $C^0(\mathbb{R})$, and that all of these are subspaces of $\mathcal{F}(\mathbb{R})$!

(picture)

Often times, to show that a set is a vector space, we see if we can show that it is a subspace of some larger set that we already know is a vector space. That is, it's much easier to show a set is a subspace. This is because if you already know that $V$ is a vector space and $W \subseteq V$, you get some of the properties of vector spaces for free. ($W$ "inherits" some of those from $V$). So you really only need to show:

* $W$ is closed under addition.
* $W$ is closed under scalar multiplication.
* $W$ contains the zero vector $\vec{0}_V$.

If you can show these, then you show that $W$ is a subspace of $V$!

# Some Basic Results

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

## Another Result

This next result is again something that seems obvious, but I want to show, in precise detail, which properties of vector spaces we are using here.

**Theorem**: Let $V$ be a vector space and $\vec{0} \in V$ the zero vector. Then if $a$ is any scalar, $a \cdot \vec{0} = \vec{0}$.

**Proof**: By property (8) of vector spaces, $a \cdot (\vec{0} + \vec{0}) = a \cdot \vec{0} + a \cdot \vec{0}$.

But by property (5), $\vec{0} + \vec{0} = \vec{0}$. That means, the left side is just $a \cdot \vec{0}$. In other words, we've shown $a \cdot \vec{0} = a\cdot \vec{0} + a \cdot \vec{0}$.

By property (6), there is a vector $v$ that is the additive inverse of $a \cdot \vec{0}$. Add $v$ to both sides:

$$
\begin{array}{lr}
v + a \cdot \vec{0} = v + (a \cdot \vec{0} + a \cdot \vec{0}) & \\
\vec{0} = v + (a \cdot \vec{0} + a \cdot \vec{0}) & \text{By property (6), additive inverses} \\
\vec{0} = (v + a \cdot \vec{0}) + a \cdot \vec{0} & \text{By property (3), associativity} \\
\vec{0} = \vec{0} a \cdot \vec{0} & \text{Property (6), additive inverses} \\
\vec{0} = a \cdot \vec{0} + \vec{0} & \text{Property (4), commutativity} \\
\vec{0} = a \cdot \vec{0} & \text{Property (5), the zero property}
\end{array}
$$

In other words, we use these different vector space properties over and over again until we can show that $a \cdot \vec{0} = 0$, no matter what $a$ is.

There is a similar problem on the next problem set.

# Problem Set 4

Due **Monday, 4/4** on Moodle:

1. Let $V$ be a vector space and $\vec{0} \in V$ the zero vector. Prove that, for all $\vec{v} \in V$: $0 \cdot \vec{v} = \vec{0}$.
2. An infinite *sequence* is a list $x = (x_0, x_1, \ldots)$ (for each $n \in \mathbb{N}$, $x_n$ is a *term* of that sequence), where each $x_n$ is a real number. Two infinite sequences are added term by term: $$x + y = (x_0 + y_0, x_1 + y_1, \ldots).$$ Scalar multiplication can be defined by: $$a \cdot x = (ax_0, ax_1, \ldots)$$ Show that the set of all infinite sequences forms a vector space. (That is: show that it satisfies all 10 properties listed in [the lecture notes for lesson 13](lesson13.html#vector-spaces).)
3. Let $\mathcal{F}_2 = \\{ (x_0, x_1, \ldots) : x_{n+2} = x_{n+1} + x_n \\}$. Show that $\mathcal{F}_2$ is closed under addition and scalar multiplication (as defined in the previous problem).
