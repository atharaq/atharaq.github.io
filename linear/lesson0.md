<script src="https://sagecell.sagemath.org/static/embedded_sagecell.js"></script>
<script>sagecell.makeSagecell({"inputLocation": ".sage"});</script>

# Linear Lesson 0: Vectors / Geometry / Intro to course
{:.no_toc}

1. Table of Contents
{:toc}

# Linear Algebra

## How to succeed

* Study **both** geometric and algebraic concepts.
* Don't get lost in the trees and neglect the forest. That is: keep the big picture in mind at all times!
* Form study groups.
* Find online resources. There are many for linear algebra!
  * Some of these have more of a computational bent. I tend to worry more about concepts than computation.

Traditionally, linear algebra is hard for two reasons:

1. Computationally. Matrix operations can take a long time. They aren't exactly "hard", but there may be many steps, and so it can be error prone and easy to make mistakes.
2. Conceptually. Making sense of abstractions, abstract vector spaces, definitions, and proofs about these concepts. Most of us have not had proper training in this. Most of mathematics, up to this point, has really focused on computation rather than abstract concepts. So we will need to train our brains to think abstractly.

The first chapter of [the Grossman text](https://jp-g.de/Skripte/LA-GES-CS-JPG.pdf) goes through some material on logic and set theory that can help with thinking about proofs. We will try to talk about proofs as we do them.

## Aside: abstraction

Why do mathematicians love abstraction?

* We don't get bogged down by irrelevant details.
* Think about the complexity of what we see. The "objects" that we see are made up of countless molecules, each with a particular molecular structure, etc. We ignore all of those details when reasoning about real-world objects like throwing baseballs in the air.
* If we prove something once in an abstract setting, we can use it in many different specific instances. For example, the theorems of linear algebra are applicable in computer science, engineering, statistics, economics, other sciences...

Of course, it does take some getting used to. We hope to first build some intuition using 2D and 3D geometry.

# Vectors

What is a vector? By now, you must have learned something about vectors, either in high school physics, or in Calc III, or at some other point in your life. The physics definition of a vector is "a quantity which has both magnitude and direction." For example, force acting on an object pulling it down to the ground (gravity) is different from a force of equal magnitude pushing up against the object.

Please watch the following video, which talks about vectors in several contexts.

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/fNk_zzaMoSs" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

This video comes from the YouTube channel 3Blue1Brown, which has a series about Linear Algebra called "Essence of Linear Algebra". I strongly recommend watching these videos throughout the semester; there are 16 of these, but they are usually about 10 minutes long and convey a deep concept about linear algebra.

## 2D

In two dimensions, we think of vectors as **arrows starting at the origin**. Just draw any arrow, starting at the origin, to any point on the plane, and you have a vector. For example, the below shows the vector $\vec{v} = \binom{-2}{1}$. To see the vector displayed, click "Evaluate" below:

<div class="sage">
<script type="text/x-sage">
G = Graphics()
origin = vector([0, 0])
v = vector([-2, 1])
G += arrow(origin, v)
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

What can do we with vectors?

**Rescaling**: Given a vector, we can resize it. For example, we can double its size. The below shows $\vec{v}$ and $2\cdot \vec{v}$:

<div class="sage">
<script type="text/x-sage">
G = Graphics()
origin = vector([0, 0])
v = vector([-2, 1])
G += arrow(origin, v, color='blue')
G += arrow(origin, 2*v,  color='orange', linestyle='dotted')
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

**Addition**: Given two vectors, we can add them. We add using the *tip-to-tail* method. Put the tail (starting point) of one vector at the tip (endpoint) of the other, and then see where you end up. Here we show the vectors $\vec{v} = \binom{-2}{1}, \vec{w} = \binom{5}{2},$ and $\vec{v} + \vec{w}$.

<div class="sage">
<script type="text/x-sage">
G = Graphics()
origin = vector([0, 0])
v = vector([-2, 1])
w = vector([5, 2])
G += arrow(origin, v, color='blue')
G += arrow(origin, w,  color='red')
G += arrow(origin, v + w, color='green')
G += arrow(v, v + w, color='red', linestyle='dotted')
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

When we start at $\vec{v}$ and add $\vec{w}$, we get $\vec{v} + \vec{w}$. We could start at $\vec{w}$ and add $\vec{v}$. Draw this out in your notebook: what do you notice?

**Algebraically**:

1. Re-scale vectors by multiplying each coordinate by the scalar. For example, if $\vec{v} = \binom{-2}{1}$, then $3 \cdot \vec{v} = \binom{-6}{3}$.
2. Add vectors by adding their coordinates. So $\binom{-2}{1} + \binom{5}{2} = \binom{3}{3}$.

**Exercise**: Explain why this means that vector addition is commutative.

## 3D

We can also think about three-dimensional vectors. (In fact, we can also talk about 1D vectors. What are they?) A vector in 3D has an $x$-coordinate, $y$-coordinate, and $z$-coordinate. They also can be re-scaled and added! Let's give a couple of examples:

**Rescaling**: Here we have the vector $\vec{v} = \begin{pmatrix}2 \\\ -1 \\\ 1\end{pmatrix}$ and the vector $2 \cdot \vec{v}$.

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

G = axes(xmin=-5, xmax=5, ymin=-5, ymax=5, zmin=-5, zmax=5)
origin = vector([0, 0, 0])
v = vector([2, -1, 1])
G += arrow(origin, v, color='blue')
G += arrow(origin, 2*v, color='orange')
G.show()
</script>
</div>

**Addition**: Here we add $\vec{v} = \begin{pmatrix}2 \\\ -1 \\\ 1\end{pmatrix}$ and $\vec{w} = \begin{pmatrix}1 \\\ 3 \\\ 2\end{pmatrix}$.

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

G = axes(xmin=-5, xmax=5, ymin=-5, ymax=5, zmin=-5, zmax=5)
origin = vector([0, 0, 0])
v = vector([2, -1, 1])
w = vector([1, 3, 2])
G += arrow(origin, v, color='blue')
G += arrow(origin, w, color='red')
G += arrow(origin, v + w, color='green')
G += arrow(v, v + w, color='red')
G += arrow(w, w + v, color='blue')
G.show()
</script>
</div>

Do you still see the parallelogram in three dimensions? The parallelogram is kind of a geometric proof that vector addition is commutative!

Can you figure out how to define rescaling and addition for three dimensional vectors?

# Abstraction

**Vectors** are objects which can be added and rescaled. Besides 1D / 2D / 3D / etc "arrows", what other objects can be added and re-scaled?

One good example is **functions**. For example, if $f(x)$ and $g(x)$ are functions with domain $\mathbb{R}$, then $(f + g)(x)$ is also a function with domain $\mathbb{R}$. And so is $2 \cdot f(x)$, which is defined just as the function whose $y$-values are $2 \times f(x)$ for each $x$-value.

We can also look at more specific cases of functions:

* If $f(x)$ and $g(x)$ are both **polynomials**, then $f + g$ is a polynomial. (Do you know why?)
* If $f(x)$ and $g(x)$ are both **continuous**, then $f + g$ is continuous. (Why?)
* If they are both **differentiable**?
* If they both have convergent Taylor series?
* If they are both **non-zero**?

One of the above is false. Which one?

In general, though, much of the theory of vectors (and linear functions between vector spaces, which is coming soon) can be applied to sets of functions as well. This is what I meant when I said we will try to prove things abstractly. If we can prove properties of vectors, using only the fact that they can be added and rescaled, then it doesn't matter if the vectors, themselves, have some sort of geometric meaning; nor does it matter what *kind* of vectors they are. Imagine if we had to prove a theorem once for 1D vectors, again for 2D, again for 3D, and again for each of the classes of functions mentioned above!

# Reachability

Let's go back to the 2D setting for now.

# Homework
