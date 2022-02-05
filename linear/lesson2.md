<script src="https://sagecell.sagemath.org/static/embedded_sagecell.js"></script>
<script>sagecell.makeSagecell({"inputLocation": ".sage"});</script>

$\DeclareMathOperator{\Span}{Span}$

# Linear Lesson 2: Functions and Linearity
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

1. What is $\Span(\binom{1}{0}, \binom{0}{1})$?
2. What is $\Span(\binom{1}{0}, \binom{0}{1}, \binom{1}{1})$?
3. On one set of axes, draw out as many linear combinations as you can of $\binom{1}{0}$ and $\binom{0}{1}$. On another, draw out as many as linear combinations as you can of $\binom{1}{0}, \binom{0}{1},$ and $\binom{1}{1}$. What differences do you notice?

Here we see linear combinations of $\binom{1}{0}$ and $\binom{0}{1}$:

<div class="sage">
<script type="text/x-sage">
def grid(v1, v2, endpoints=[-3, 3, -3, 3], color1='blue', color2='red'):
    G = Graphics()
    for i in range(endpoints[0], endpoints[1]):
        for j in range(endpoints[2], endpoints[3]):
            base = i * v1 + j*v2
            G += arrow(base, base+v1, color=color1)
            G += arrow(base, base+v2, color=color2)
    return G

vectors = [vector([1, 0]), vector([0, 1])]
G = grid(vectors[0], vectors[1])
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

Here we see linear combinations of $\binom{1}{0}, \binom{0}{1},$ and $\binom{1}{1}$:

<div class="sage">
<script type="text/x-sage">
def grid(v1, v2, v3, endpoints=[-3, 3, -3, 3, -3, 3], color1='blue', color2='red', color3='green'):
    G = Graphics()
    for i in range(endpoints[0], endpoints[1]):
        for j in range(endpoints[2], endpoints[3]):
            for k in range(endpoints[4], endpoints[5]):
                base = i * v1 + j*v2 + k*v3
                G += arrow(base, base+v1, color=color1)
                G += arrow(base, base+v2, color=color2)
                G += arrow(base, base+v3, color=color3)
    return G

vectors = [vector([1, 0]), vector([0, 1]), vector([1,1])]
G = grid(vectors[0], vectors[1], vectors[2])
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

# Functions

Vectors are half of the story in linear algebra. The other half: **linear functions**. First, let's remind ourselves what functions are.

* What is your best definition of a *function*?
* Does your definition change if we talk about different kinds of functions?
  * For example, do we need a different definition for functions $f : \mathbb{R} \to \mathbb{R}$ and functions $G : \mathbb{R}^2 \to \mathbb{R}^3$?

Coming up with definitions is hard, but hopefully we remember the notion of the *vertical line test* from earlier mathematics courses. A function is "something that passes the vertical line test". This means that for each "$x$"-value, there is at most one $y$-value so that the ordered pair $(x, y)$ appears on the graph.

This definition actually does generalize if we think about ordered pairs in the right way. Instead of thinking about $x$ and $y$ as real numbers, in this course $x$ and $y$ will be some kind of vectors. They don't even need to be the same type of vector! But the point is: for each $x$-value, we can only have at most one $y$-value. We will make this formal below.

# Set Theory

In mathematics, we formalize everything using set theory. A **set** is just a collection of objects. We denote sets using curly braces, $\\{$ and $\\}$. For example, the set $A = \\{ 0,$ "Hello" $\\}$ is a set of two elements, the number 0 and the string "Hello".

**Notation**: We say $0 \in A$, or "$0$ is an element of the set $A$." We say $1 \not \in A$, or "$1$ is not an element of $A$." We usually use capital letters $A, B, C, \ldots$ to denote sets and lower case letters $x, y, z, \ldots$ to denote elements.

We can define sets by listing out their elements (as above), or using "set-builder notation": $\mathcal{P}_2 = \\{ p(x) : p(x)$ is a polynomial of degree $\leq 2 \\}$. This is read: $\mathcal{P}_2$ is the set of all $p(x)$ such that $p(x)$ is a polynomial of degree $\leq 2$.

Then $p(x) = x^2 - 4 \in \mathcal{P}_2$, but $q(x) = x^3 + 2x^2 + 1 \not \in \mathcal{P}_2$.

## Some Common Sets

* $\mathbb{N} = \\{ 0, 1, 2, \ldots \\}$ the set of **natural numbers**.
* $\mathbb{Z} = \\{ \ldots, -2, -1, 0, 1, 2, \ldots \\}$ the set of all **integers**.
* $\mathbb{Q} = \\{ \frac{m}{n} : m \in \mathbb{Z}, n \in \mathbb{Z}, n \neq 0 \\}$. What is this set?
* $\mathbb{R}$ the set of all **real numbers**. (Not providing a definition here.)
* $\mathbb{C}$ the set of all **complex numbers**.
* $\emptyset$: the **empty set**, or the set with nothing in it. (This is the unique set which has zero elements.)

Often when I say **scalar** in this class, we could use either $\mathbb{R}$ or $\mathbb{C}$. I will stick to $\mathbb{R}$ as much as possible, but sometimes it will be nice, algebraically, to use $\mathbb{C}$.

Using these sets, we can define many others.

**Example**: If $E = \\{ n : n \in \mathbb{Z}$ and there is $k \in \mathbb{Z}$ such that $n = 2k \\}$.

* Is $0 \in E$?
* $1 \in E$?
* $2 \in E$?
* Describe $E$ in English.

## Notice

Sets are determined by their **elements**: not by "multiplicity", not by "order", and not by how they are described. That is: the sets $\\{ 0, 1, 2 \\}$, $\\{ 2, 2, 1, 0 \\}$, and $\\{ n : n \in \mathbb{N}$ and $n \leq 2 \\}$ are all **the same set**!

## Subsets

For sets $A$ and $B$, we say $A \subseteq B$, or "$A$ is a **subset** of $B$", if every element of $A$ is an element of $B$. In other words, if we want to show that $A$ is **not** a subset of $B$, we need to find a *counterexample*: some element of $A$ that is **not** an element of $B$. For example, if $A = \\{ 0, 1, 2 \\}$ and $B = \\{ 1, 2 \\$, are the following true or false?

* Is $A \subseteq B$? If so, give an argument, if not, a counterexample.
* Is $B \subseteq A$? If so, give an argument, if not, a counterexample.

**Exercise**: Determine if the following are true or false:

1. $\\{ -1, 0 \\} \subseteq \\{ 0, -1 \\}$.
2. $\emptyset \subseteq \\{ 0 \\}$.
3. $\\{ 0 \\} \subseteq \emptyset$.
4. $\mathbb{R} \subseteq \mathbb{Q}$.

In general, to show $A \subseteq B$, we need to show an "implication". That is, our arguments usually have the following form: "Let $x \in A$." (give an argument) "Then $x \in B$. Therefore $A \subseteq B.$"

For example: suppose $A = \\{ n \in \mathbb{N} : n > 1$ and there is $k \in \mathbb{N}$ such that $k^2 = n \\}$, and $B = \\{ n \in \mathbb{N} : n$ is a composite number $\\}$. We show that $A \subseteq B$:

**Proof**: Let $n \in A$. Then we know that there is $k \in \mathbb{N}$ such that $k^2 = n$. Moreover, we know that $n \neq 1$ so $k \neq 1$. This tells us that $k$ is a factor of $n$, and, importantly, $k \neq n$. (Do you see why? If $k = n$, divide both sides by $k$ and you get $k = 1$, which contradicts that $n \neq 1$) So $n$ has a factor that is not equal to $1$ and is not equal to $n$. That means $n$ is not a prime number, so it must be composite. Therefore $n \in B$.

## Functions

## Domains / Codomains / Images

## Injections / Surjections / Bijections

# Linear Functions
