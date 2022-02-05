<script src="https://sagecell.sagemath.org/static/embedded_sagecell.js"></script>
<script>sagecell.makeSagecell({"inputLocation": ".sage"});</script>

# Linear Lesson 2: Functions and Linearity
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

1. What is $\mathrm{Span}(\binom{1}{0}, \binom{0}{1})$?
2. What is $\mathrm{Span}(\binom{1}{0}, \binom{0}{1}, \binom{1}{1})$?
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

# Functions (Set-Theoretically)

Now that we have the language of set theory, we can make some definitions:

**Definition**: Given sets $X$ and $Y$, the **Cartesian product** of $X$ and $Y$, denoted $X \times Y$, is the set of all *ordered pairs* of the form $(x, y)$, where $x \in X$ and $y \in Y$.

Ordered pairs are not sets: they are **ordered**, of course, so there is a first component and a second. Now we define functions using this notation:

**Definition**: Given sets $X$ and $Y$, then a **function** $f : X \to Y$ is a subset of $X \times Y$ such that for every $x \in X$, there is **exactly** one $y \in Y$ such that $(x, y) \in f$. $X$ is called the **domain** of $f$, and $Y$ is called the **codomain** of $f$.

Of course, we never write $(x, y) \in f$. We usually just write $f(x) = y$.

**Question**: What does this have to do with the vertical line test?

**Exercise**: For now, we will use $X = Y = \mathbb{R}$. Are the following sets of ordered pairs functions or not? (**Hint**: Plot the points. See what happens.)

1. $\\{ (0, 1), (0, 2), (1, 3) \\}$
2. $\\{ (0, 1), (1, 1), (2, 1) \\}$
3. $\\{ (0, 1), (1, 2), (2, 3) \\}$

**Definition**: The set $\\{ y \in Y : $ there is $x \in X$ such that $f(x) = y \\}$ is called the **image** of $f$. (This is sometimes referred to as the *range* of $f$, but I will usually avoid this term.) For any sset $A \subseteq X$, we also define $f(A) = \\{ y : $ there is $x \in A$ such that $f(x) = y \\}$.

**Exercise**: Let $f : \mathbb{R}^2 \to \mathbb{R}$ be defined by $f(\binom{x}{y}) = 2x - y$. Determine the images of the following subsets of $\mathbb{R}^2$. Describe these set-theoretically.

1. $A = \\{ \binom{x}{x} : x \in \mathbb{R} \\}$.
2. $B = \\{ \binom{x}{y} : y = 2x \\}$.

<details>
<summary>Check your answers:</summary>
<ol>
<li>The image $f(A)$ is the set of <strong>all real numbers</strong>, $\mathbb{R}$. In this case, we are looking at $f(\binom{x}{x})$, which is $2x - x$. So $f(\binom{x}{x}) = 2x - x = x$. That means for any $y \in \mathbb{R}$, there is some $\vec{v} \in A$ such that $f(\vec{v}) = y$: in particular, the vector $\vec{v} = \binom{y}{y}$ works!</li>
<li>The image $f(B)$ is just the set with a single element in it: $\\{ 0 \\}$! This is because $f(\binom{x}{y}) = 2x - y$. Substitute in $y = 2x$ and we get $f(\binom{x}{y}) = 2x - 2x = 0$.</li>
</ol>
</details>

**Important**: More than just understanding the *rule* of a function, we need to spend time thinking about how functions *act* on sets. For example, the function $f$ above "shrinks" the line $y = 2x$ to the single point $0$. Any time we see a function in this course, we should think about what it does to different parts of the domain. In particular, we should think about what it does to *lines*, *planes*, and *hyperplanes* (higher-dimensional analogues of planes).

# Linear Functions

As mentioned earlier: vectors are half the story in linear algebra. We really care about *functions* between sets of vectors. If $V$ and $W$ are two sets of vectors (maybe $V = \mathbb{R}^2$ and $W = \mathbb{R}^3$, for example), we can define what it means for $f : V \to W$ to be a function. But really we want functions that are somehow "well-behaved". What do we mean by that?

Recall that vectors can be added and rescaled. "Addition" might mean something different in $V$ than it does in $W$ (for example, addition in $V$ might mean adding two vectors component-wise, while addition in $W$ meight mean adding two functions). Similarly, scalar multiplication might be defined differently in $V$ as it is in $W$. But if $f : V \to W$ is well-behaved, then it should *respect* addition and scalar multiplication.

**Example**: Suppose $V = W = \mathbb{R}^2$. Consider the function $T : \mathbb{R}^2 \to \mathbb{R}^2$ defined so that $T(\vec{v})$ is the vector $\vec{v}$, rotated 90$^\circ$ counterclockwise ($\pi/2$).

* What is $T(\binom{1}{0})$?
* What is $T(\binom{0}{1})$?
* What is $T(\binom{2}{1})$?
* What is $T(\binom{-1}{1})$?

<div class="sage">
<script type="text/x-sage">
G = Graphics()
M = Matrix([[0, -1], [1, 0]])
z = vector([0, 0])

v = vector([2, 1])
w = vector([-1, 1])
G += arrow(z, v, color='blue')
G += arrow(z, w, color='red')
G += arrow(z, M*v, color='blue', linestyle='dotted')
G += arrow(z, M*w, color='red', linestyle='dotted')
G.show(xmin=-2, xmax=2, ymin=-2, ymax=2, aspect_ratio=1)
</script>
</div>

Of course, we can add and rescale vectors. We could add before we rotate, or add after we rotate. That is: we could add $\binom{2}{1} + \binom{-1}{1}$, and then rotate that by $\pi / 2$, or rotate each of those two vectors, and then add the results. If $T$ is well-behaved: it shouldn't matter what we do first!

<div class="sage">
<script type="text/x-sage">
def parallelogram(v1, v2, color1='blue', color2='red', linestyle='solid'):
    G = Graphics()
    G += arrow([0, 0], v1, color=color1, linestyle=linestyle)
    G += arrow([0, 0], v2, color=color2, linestyle=linestyle)
    G += arrow(v1, v1 + v2, color=color2, linestyle=linestyle)
    G += arrow(v2, v1 + v2, color=color1, linestyle=linestyle)    
    return G

G = Graphics()
M = Matrix([[0, -1], [1, 0]])
z = vector([0, 0])

v = vector([2, 1])
w = vector([-1, 1])
G += parallelogram(v, w)
G += arrow(z, v + w, color='green')
G += parallelogram(M*v, M*w, linestyle='dotted')
G += arrow(z, M*(v + w), color='green', linestyle='dotted')
G.show(xmin=-2, xmax=2, ymin=-2, ymax=2, aspect_ratio=1)
</script>
</div>

In other words: *rotations respect vector addition*!

What about scalar multiplication? If we rescale a vector, and then rotate the result by 90 degrees, or if we rotate a vector and then rescale its result, does it change? Let's see:

<div class="sage">
<script type="text/x-sage">
G = Graphics()
M = Matrix([[0, -1], [1, 0]])
z = vector([0, 0])

v = vector([1, 1])

G += arrow(z, v)
G += arrow(z, 3*v, color='green', linestyle='dashed')
G += arrow(z, M*(3*v), color='green', linestyle='dotted')
G += arrow(z, M*v, linestyle='dotted')
G.show(xmin=-3, xmax=3, ymin=-3, ymax=3, aspect_ratio=1)
</script>
</div>

Again: rotations respect scalar multiplication!

A function which respects **both** vector addition and scalar multiplication is exactly what we meant when we said "well-behaved" earlier.

**Definition**: Suppose $V$ and $W$ are "vector spaces" (we will define what that means later). A function $T : V \to W$ is called **linear** (sometimes $T$ is said to be "a linear map", "a linear function", or "a linear transformation") if:

1. for every $\vec{u}, \vec{v} \in V$, $T(\vec{v} + \vec{w}) = T(\vec{v}) + T(\vec{w})$, and,
2. for every $\vec{v} \in V$ and every scalar $a$, $T(a \cdot \vec{v}) = a \cdot T(\vec{v})$.

**Example**: Let's continue with the rotation by $\pi / 2$ example.

1. We saw that $T(\binom{1}{0}) = \binom{0}{1}$. Since $T(a \cdot \binom{1}{0}) = a \cdot T(\binom{1}{0})$, what does this tell us about $T(\binom{x}{0})$ for any real number $x$?
2. Similarly, since we know $T(\binom{0}{1})$, can we figure out $T(\binom{0}{y})$ for any scalar $y$?
3. Notice that $\binom{x}{0} + \binom{0}{y} = \binom{x}{y}$. We know $T(\binom{x}{0})$ and $T(\binom{0}{y})$. Can we figure out $T(\binom{x}{y})$?

**Exercises**:

1. Consider the function $F : \mathbb{R} \to \mathbb{R}$ defined by $F(x) = \sqrt{x}$. This is a function between "one dimensional" vector spaces. Is $F$ linear? Why or why not?
2. Suppose $T : \mathbb{R} \to \mathbb{R}$ is linear and suppose we know $T(1) = a$. What is $T(2)$? What is $T(3)$? What is $T(x)$ for any $x$?
