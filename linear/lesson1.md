<script src="https://sagecell.sagemath.org/static/embedded_sagecell.js"></script>
<script>sagecell.makeSagecell({"inputLocation": ".sage"});</script>

# Linear Lesson 1: Linearity
{:.no_toc}

1. Table of Contents
{:toc}

# Last Time

Last time, we talked about vectors, mostly in two dimensions. We said that vectors can be added (tip to tail, component-wise) and re-scaled (stretched out in the same direction). I encourage you to look at the visualizations from [Lesson 0](lesson0.html).

We then did the "Find Gauss" activity. Moving in the two directions $\vec{h} = \binom{3}{1}$ and $\vec{m} = \binom{1}{2}$, we were able to reach Gauss at $\vec{g} = \binom{107}{64}$ by going on the hovercraft for 30 hours and on the magic carpet for 17 hours. Algebraically, we saw $30 \cdot \vec{h} + 17 \cdot \vec{m} = \vec{g}$.

## Homework

For homework, we looked at related questions: given two vectors (either two or three dimensional vectors), are we able to reach every vector using those two? These kinds of questions may be challenging, simply because of the way in which they are worded. For example (using different numbers):

**True or false**: There is a vector in $\mathbb{R}^2$ that **cannot** be reached using vectors $\binom{1}{3}$ and $\binom{2}{6}$.

To say that this is **true** would mean that we can find **one** vector that cannot be reached by these. Let's look at the picture:

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

G = Graphics()
v = vector([1, 3])
w = vector([2, 6])
G += grid(v, w)
G.show()
</script>
</div>

Notice that all the combinations of $\binom{1}{3}$ and $\binom{2}{6}$ lie on the same line (in fact, they all lie on the line $y = 3x$. Do you see why?) So it is clear that there are vectors which do not lie on that line: take any vector $\binom{x}{y}$ where $y \neq 3x$. For example, take $x = 0$ and $y = 1$:

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

G = Graphics()
v = vector([1, 3])
w = vector([2, 6])
z = vector([0, 1])
G += grid(v, w)
G += arrow([0, 0], z, color='green')
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

Algebraically, we can also check to see if the following system of equations has a solution:

$$
\begin{align}
a + 2b &= 0 \\
3a + 6b &= 1
\end{align}
$$

So again: to say that "There is a vector that cannot be reached using $\vec{v}$ and $\vec{w}$" means that we can find at least one single vector that we cannot reach. Alternatively: to say that this kind of statement is false means to say that **every** vector can be reached. That is to say: the negation (logical opposite) of "there is a vector that cannot be reached" is "every vector can be reached."

**Example**: True or false: every vector in $\mathbb{R}^2$ can be reached using the vectors $\binom{1}{1}$ and $\binom{0}{1}$.

What do you think?

First, let's look at the geometry here:

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

G = Graphics()
v = vector([1, 1])
w = vector([0, 1])
G += grid(v, w)
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

What do you think? Does it look like we can get anywhere we want on the plane?

<details>
<summary>Now let's check, algebraically:</summary>
<p>The question is, if we have a vector $\binom{x}{y}$, can we reach it using $a \cdot \binom{1}{1} + b \cdot \binom{0}{1}$? Write it out as a system of equations:</p>
<p>
$$
\begin{align}
&a \cdot \binom{1}{1} &+ b \cdot \binom{0}{1} &= \binom{x}{y} \\
&a  &&= x \\
&a &+ b &= y
\end{align}
$$
</p>
<p>If you know $x$ and $y$, you can solve for $a$ and $b$: let $a = x$, and $b = y - a$, or $b = y - x$.</p>
<p>In other words: this statement is <strong>true</strong>. Every vector can be reached!</p>
</details>

## 3D Reachability?

## Functions as Vectors

We can also look at more specific cases of functions:

* If $f(x)$ and $g(x)$ are both **polynomials**, then $f + g$ is a polynomial. (Do you know why?)
* If $f(x)$ and $g(x)$ are both **continuous**, then $f + g$ is continuous. (Why?)
* If they are both **differentiable**?
* If they both have convergent Taylor series?
* If they are both **non-zero**?

One of the above is false. Which one?

# Definitions

## Scalar Multiples

## Linear Combinations

# Exercise 2

## Span

## Geometry

## 3D Geometry

# Functions

## Definition

## Linearity

# Pre-work Lesson 2
