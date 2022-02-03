<script src="https://sagecell.sagemath.org/static/embedded_sagecell.js"></script>
<script>sagecell.makeSagecell({"inputLocation": ".sage"});</script>

# Linear Lesson 1: Linear Combinations and Span
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

What happens when we try to solve this system?

Again: to say that "There is a vector that cannot be reached using $\vec{v}$ and $\vec{w}$" means that we can find at least one single vector that we cannot reach. Alternatively: to say that this kind of statement is false means to say that **every** vector can be reached. That is to say: the negation (logical opposite) of "there is a vector that cannot be reached" is "every vector can be reached."

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
&a \cdot \binom{1}{1} + b \cdot \binom{0}{1} &= \binom{x}{y} \\
&a  &= x \\
&a + b &= y
\end{align}
$$
</p>
<p>If you know $x$ and $y$, you can solve for $a$ and $b$: let $a = x$, and $b = y - a$, or $b = y - x$.</p>
<p>In other words: this statement is <strong>true</strong>. Every vector can be reached!</p>
</details>

## 3D Reachability?

The last question on the homework was about reachability in three dimensions. Let's do a similar example:

**True or false**: every vector in $\mathbb{R}^3$ is reachable from the vectors $\vec{v} = \begin{pmatrix}0 \\\ 1 \\\ 0\end{pmatrix}$ and $\vec{w} = \begin{pmatrix}1 \\\ 0 \\\ 2\end{pmatrix}$.

Showing that this kind of "every vector is reachable" statement is true is, again, somewhat tricky. We would need to take a vector of the form $\vec{r} = \begin{pmatrix}x \\\ y \\\ z\end{pmatrix}$, where we don't know $x$, $y$, or $z$ (they can be any real number), and try to reach it using $\vec{v}$ and $\vec{w}$. Or, to show that it's false, we just need to find **one** vector that is not reachable.

Again, it's a good idea to first try to visualize this. It may be hard to draw, but we can plot it in Sage:

<div class="sage">
<script type="text/x-sage">
def axes(xmin=-1,xmax=1,ymin=-1,ymax=1,zmin=-1,zmax=1,**kwds):
    ex = vector((1,0,0))
    ey = vector((0,1,0))
    ez = vector((0,0,1))
    G =  line3d([xmin*ex,xmax*ex],**kwds)
    G += line3d([ymin*ey,ymax*ey],**kwds)
    G += line3d([zmin*ez,zmax*ez],**kwds)
    return G

def grid(v1, v2, endpoints=[-3, 3, -3, 3], color1='blue', color2='red'):
    G = Graphics()
    for i in range(endpoints[0], endpoints[1]):
        for j in range(endpoints[2], endpoints[3]):
            base = i * v1 + j*v2
            G += arrow(base, base+v1, color=color1)
            G += arrow(base, base+v2, color=color2)
    return G

G = axes(xmin=-5, xmax=5, ymin=-5, ymax=5, zmin=-5, zmax=5)
v = vector([0, 1, 0])
w = vector([1, 0, 2])
G += grid(v, w)
G.show()
</script>
</div>

What do you notice about the geometry here? Intuitively, using this geometric picture, what is your guess? Is every vector reachable (true) or is there at least one that isn't (false)?

Algebraically, we want to determine if every system of equations of the following form has solutions for $a$ and $b$:

$$
\begin{align}
a \cdot \begin{pmatrix}0 \\ 1 \\ 0\end{pmatrix} + b \cdot \begin{pmatrix} 1 \\ 0 \\ 2 \end{pmatrix} &= \begin{pmatrix}x \\ y \\ z\end{pmatrix} \\
b &= x \\
a &= y \\
2b &= z
\end{align}
$$

Using some algebraic substitution, you can see that this is only solvable if $z = 2x$. So for example, the vector $\begin{pmatrix}0 \\\ 0 \\\ 1 \end{pmatrix}$ cannot be reached! **The statement is false**!

<div class="sage">
<script type="text/x-sage">
def axes(xmin=-1,xmax=1,ymin=-1,ymax=1,zmin=-1,zmax=1,**kwds):
    ex = vector((1,0,0))
    ey = vector((0,1,0))
    ez = vector((0,0,1))
    G =  line3d([xmin*ex,xmax*ex],**kwds)
    G += line3d([ymin*ey,ymax*ey],**kwds)
    G += line3d([zmin*ez,zmax*ez],**kwds)
    return G

def grid(v1, v2, endpoints=[-3, 3, -3, 3], color1='blue', color2='red'):
    G = Graphics()
    for i in range(endpoints[0], endpoints[1]):
        for j in range(endpoints[2], endpoints[3]):
            base = i * v1 + j*v2
            G += arrow(base, base+v1, color=color1)
            G += arrow(base, base+v2, color=color2)
    return G

G = axes(xmin=-5, xmax=5, ymin=-5, ymax=5, zmin=-5, zmax=5)
v = vector([0, 1, 0])
w = vector([1, 0, 2])
o = vector([0, 0, 0])
r = vector([0, 0, 1])
G += grid(v, w)
G += arrow(o, r, color='green')
G.show()
</script>
</div>

Alternatively: if you remember Calc 3, you can use the cross product between two three-dimensional vectors to find a vector that does not lie on the same **plane** as the first two.

## Functions as Vectors

We didn't really get into this last time, but I wanted to talk a bit more about this again today. Recall that the *abstract* notion of vectors are "objects that can be added and re-scaled". I mentioned, briefly, that functions can be added and rescaled also!

For example, if $f(x)$ and $g(x)$ are functions with domain $\mathbb{R}$, then $(f + g)(x)$ is also a function with domain $\mathbb{R}$. And so is $2 \cdot f(x)$, which is defined just as the function whose $y$-values are $2 \times f(x)$ for each $x$-value.

* If $f(x)$ and $g(x)$ are both **polynomials**, then $f + g$ is a polynomial. (Do you know why?)
* If $f(x)$ and $g(x)$ are both **continuous**, then $f + g$ is continuous. (Why?)
* If they are both **differentiable**?
* If they both have convergent Taylor series?
* If they are both **non-zero**?

One of the above is false. Which one?

<details>
<summary>Check your guess:</summary>
<p>If $f(x) = 2x$ and $g(x) = -2x$, they are both non-zero functions. But $f(x) + g(x)$ is the constant zero function!</p>
</details>

# Definitions

Now that we've seen a bit of the geometry, the algebra, and have some intuition behind the major concept of a vector, let's back up and make an important definitions.

We've already seen that vectors can be added and re-scaled. Technically we say that, given a vector $\vec{v}$ (any kind of vector, we are being purely abstract here), and any real number $a$, the vector $a \cdot \vec{v}$ is called a **scalar multiple** of $\vec{v}$.

Given vectors $\vec{v_1}$ and $\vec{v_2}$ and real numbers $a_1$ and $a_2$, the vector $a_1 \cdot \vec{v_1} + a_2 \cdot \vec{v_2}$ is called a **linear combination** of $\vec{v_1}$ and $\vec{v_2}$. We've seen this! In the "Carpet Ride" exercise, we saw that we needed to find a linear combination of the "hoverboard" vector and the "magic carpet" vector that reached Gauss's cabin.

We can extend this definition to talk about linear combinations of three vectors, or four vectors, or, more abstractly, $n$ vectors. Given $n$ vectors $\vec{v_1}, \vec{v_2}, \ldots \vec{v_n}$ and $n$ real numbers $a_1, \ldots, a_n$, the vector $a_1 \cdot \vec{v_1} + a_2 \cdot \vec{v_2} + \ldots + a_n \cdot \vec{v_n}$ is a **linear combination** of the vectors $\vec{v_1}, \ldots, \vec{v_n}$.

**Question**: What would a linear combination of a single vector be?

# Exercise 2

Let's look at this second exercise, based off of the same problem from last time. We are again trying to ask a similar question to the homework: is there any point on the plane that cannot be reached with the two vectors $\binom{3}{1}$ and $\binom{1}{2}$?

## Span

Now it's time for another definition, stated abstractly: given a set of vectors $\vec{v_1}, \vec{v_2}, \ldots \vec{v_n}$, the **span** of these vectors, denoted Span($\vec{v_1}, \ldots, \vec{v_n}$) is the set of **all** possible linear combinations of these vectors.

In other words: the first exercise asked us if the vector $\binom{107}{64}$ is in the Span of $\binom{3}{1}$ and $\binom{1}{2}$. The second exercise asked if **every** vector in $\mathbb{R}^2$ is in the Span of $\binom{3}{1}$ and $\binom{1}{2}$.

## Geometry

What does the span of a single vector look like? Since you only have one vector, the linear combinations of that vector are just its scalar multiples. We stretch that vector out, along the same line! For example, the below shows the span of the vector $\binom{1}{2}$.

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
v = vector([1, 2])
w = vector([0, 0])
G += grid(v, w)
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

**Key geometric idea**: The span of a single vector is the entire line through the origin that the vector lies on.

What if we have two vectors? There are multiple possibilities:

1. The vectors are not on the same line (like in the hoverboard / magic carpet problem). In this case, the two vectors span a **plane**.
2. They might lie on the same line. In this case, what would their span be?
3. One of the vectors might be the zero vector. In this case, what would happen?

## 3D Geometry

Slightly more interesting things may happen in three dimensions. Let's again try one vector:

<div class="sage">
<script type="text/x-sage">
def axes(xmin=-1,xmax=1,ymin=-1,ymax=1,zmin=-1,zmax=1,**kwds):
    ex = vector((1,0,0))
    ey = vector((0,1,0))
    ez = vector((0,0,1))
    G =  line3d([xmin*ex,xmax*ex],**kwds)
    G += line3d([ymin*ey,ymax*ey],**kwds)
    G += line3d([zmin*ez,zmax*ez],**kwds)
    return G

def grid(v1, v2, endpoints=[-3, 3, -3, 3], color1='blue', color2='red'):
    G = Graphics()
    for i in range(endpoints[0], endpoints[1]):
        for j in range(endpoints[2], endpoints[3]):
            base = i * v1 + j*v2
            G += arrow(base, base+v1, color=color1)
            G += arrow(base, base+v2, color=color2)
    return G

G = axes(-5, 5, -5, 5, -5, 5)
v = vector([1, 2, 3])
z = vector([0, 0, 0])
G += grid(v, z)
G.show()
</script>
</div>

Now let's try two vectors, not on the same line:

<div class="sage">
<script type="text/x-sage">
def axes(xmin=-1,xmax=1,ymin=-1,ymax=1,zmin=-1,zmax=1,**kwds):
    ex = vector((1,0,0))
    ey = vector((0,1,0))
    ez = vector((0,0,1))
    G =  line3d([xmin*ex,xmax*ex],**kwds)
    G += line3d([ymin*ey,ymax*ey],**kwds)
    G += line3d([zmin*ez,zmax*ez],**kwds)
    return G

def grid(v1, v2, endpoints=[-3, 3, -3, 3], color1='blue', color2='red'):
    G = Graphics()
    for i in range(endpoints[0], endpoints[1]):
        for j in range(endpoints[2], endpoints[3]):
            base = i * v1 + j*v2
            G += arrow(base, base+v1, color=color1)
            G += arrow(base, base+v2, color=color2)
    return G

G = axes(-5, 5, -5, 5, -5, 5)
v = vector([1, 2, 3])
w = vector([0, 1, 2])
G += grid(v, w)
G.show()
</script>
</div>

Three vectors? Let's try $\vec{v} = \begin{pmatrix}1 \\\ 2 \\\ 3\end{pmatrix}, \vec{w} = \begin{pmatrix}0\\\1\\\2\end{pmatrix}$, and $\vec{u}=\begin{pmatrix}-1\\\0\\\1\end{pmatrix}$. None of these are on the same line:

<div class="sage">
<script type="text/x-sage">
def axes(xmin=-1,xmax=1,ymin=-1,ymax=1,zmin=-1,zmax=1,**kwds):
    ex = vector((1,0,0))
    ey = vector((0,1,0))
    ez = vector((0,0,1))
    G =  line3d([xmin*ex,xmax*ex],**kwds)
    G += line3d([ymin*ey,ymax*ey],**kwds)
    G += line3d([zmin*ez,zmax*ez],**kwds)
    return G

def grid(v1, v2, v3, endpoints=[-2, 2, -2, 2, -2, 2], color1='blue', color2='red', color3='green'):
    G = Graphics()
    for i in range(endpoints[0], endpoints[1]):
        for j in range(endpoints[2], endpoints[3]):
            for k in range(endpoints[4], endpoints[5]):
                base = i * v1 + j*v2 + k*v3
                G += arrow(base, base+v1, color=color1)
                G += arrow(base, base+v2, color=color2)
                G += arrow(base, base+v3, color=color3)
    return G

G = axes(-5, 5, -5, 5, -5, 5)
v = vector([1, 2, 3])
w = vector([0, 1, 2])
u = vector([-1, 0, 1])
G += grid(v, w, u)
G.show()
</script>
</div>

What happened? It turned out the the vector $\vec{u}$ is already in the span of $\vec{v}$ and $\vec{w}$! In fact, you can check: $\vec{u} = -1 \cdot \vec{v} + 2 \cdot \vec{w}$. That means it lies **on the same plane** as the vectors $\vec{v}$ and $\vec{w}$. The span of these three vectors is *two-dimensional*!

Of course, if we picked a vector that was *not* on the same plane, we'd get a very different picture. Here we change $\vec{u}$ to be the vector $\begin{pmatrix}0\\\0\\\1\end{pmatrix}$.

<div class="sage">
<script type="text/x-sage">
def axes(xmin=-1,xmax=1,ymin=-1,ymax=1,zmin=-1,zmax=1,**kwds):
    ex = vector((1,0,0))
    ey = vector((0,1,0))
    ez = vector((0,0,1))
    G =  line3d([xmin*ex,xmax*ex],**kwds)
    G += line3d([ymin*ey,ymax*ey],**kwds)
    G += line3d([zmin*ez,zmax*ez],**kwds)
    return G

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

G = axes(-5, 5, -5, 5, -5, 5)
v = vector([1, 2, 3])
w = vector([0, 1, 2])
u = vector([0, 0, 1])
G += grid(v, w, u)
G.show()
</script>
</div>

Now it's getting quite complicated to visualize. But it's clear that it's no longer a flat, 2D plane. It has some depth. How much? In other words: is there a vector in $\mathbb{R}^3$ that *cannot* be reached, eventually, by these three? How would we figure this out?

Again, we can try to guess geometrically, but here it helps to do the algebra. We ask, basically, if the following system of equations always has a solution if we know $x$, $y$, and $z$:

$$
\begin{align}
a &= x \\
2a + b &= y \\
3a + 2b + c &= z
\end{align}
$$

Right away, if we know $x$, we know $a = x$. Substituting in, we can solve for $b$ by plugging in $x$ for $a$; so $b = y - 2x$. Then we can solve for $c$: $c = z - 2x - 2y$. In other words: if you know $x, y$, and $z$, there is a linear combination of $\vec{v}, \vec{w}$ and $\vec{u}$ that reaches $\begin{pmatrix}x\\\y\\\z\end{pmatrix}$. The span of these three vectors is **all** of $\mathbb{R}^3$!

# Pre-work Lesson 2

On Moodle, answer the following question in the assignment space for this:

1. Question 2 of the last pre-work stated: "True or false: there is a vector in $\mathbb{R}^2$ that **cannot** be reached using combinations of vectors $\binom{1}{1}$ and $\binom{2}{2}$." Restate this question using the terms we learned today (linear combinations, span).
2. Two vectors on different lines "span" a plane. What do three vectors on different planes span? How does your answer change if our vectors are in $\mathbb{R}^4$, four-dimensional space?
3. Make a guess: what is the minimum number of vectors we need to "span" the set of all vectors in $\mathbb{R}^4$?
