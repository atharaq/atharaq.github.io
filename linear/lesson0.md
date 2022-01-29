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

Let's go back to the 2D setting for now. Let's explore the "Magic Carpet Ride" problem (this is taken from the "Inquiry-Oriented Linear Algebra" curriculum; a PDF of this problem is available on Moodle):

> You	are	a	young	traveler,	leaving	home for	the	first	time. Your parents want to help you on your journey, so just before	your departure,	they give you two gifts. Specifically,	they give	you	two	forms	of transportation: a hover board and a magic carpet. Your	parents	inform you that both the hover board and the magic carpet have	restrictions in how they operate:

We denote the restriction	on the hover board’s movement	by the vector $\binom{3}{1}$. By this	we mean	that if the	hover	board	traveled “forward” for	one	hour,	it would move along	a	“diagonal” path that would result	in a displacement	of 3 miles East and 1	mile North of its starting location.

We denote the restriction on the magic carpet's movement by the vector $\binom{1}{2}$. Similarly, this means that every hour on the magic carpet, you move 1 mile East and 2 miles North of your starting location.

You wish to visit the Old Man Gauss. Gauss lives in a cabin that is 107 miles East and 64 miles North of your home.

In class, we worked on this task: can you use the hover board and magic carpet to get to Gauss's cabin? If so, how? If not, why not?

In other words: is the vector $\vec{t} = \binom{107}{64}$ **reachable** using the vectors $\vec{h} = \binom{3}{1}$ and $\vec{c} = \binom{1}{2}$?

## Geometry

One way to think about this is to see what points are reachable using these two vectors. We've see that the vectors $\vec{v}$ and $\vec{w}$ form a parallelogram; if you keep adding different multiples of $\vec{v}$ and $\vec{w}$, you get a whole *grid* of parallelograms:

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
origin = vector([0, 0])
v = vector([3, 1])
w = vector([1, 2])
G += grid(v, w)
G.show(xmin=-5, xmax=5, ymin=-5, ymax=5)
</script>
</div>

These are all using **integer** multiples of the vectors. What would happen if we used decimal multiples? What do they correspond to in this problem?

## Solution, Algebraically

As a class, we determined that we are really asking: are there numbers $a$ and $b$, so that if we travel on the hoverboard for $a$ hours and the magic carpet for $b$ hours, that we end up **exactly** at $\binom{107}{64}$? In other words, we need to solve this vector equation:

$$a \cdot \binom{3}{1} + b \cdot{1}{2} = \binom{107}{64}$$

If we expand this out, we end up getting a system of two equations with two variables, $a$ and $b$:

$$
\begin{align}
3a + b &= 107 \\
a + 2b &= 64
\end{align}
$$

We can solve this using algebraic techniques (elimination or substitution).

<details>
<summary>Answer:</summary>
<p>If we solve this system, we get $a = 30$ and $b = 17$. This means that <strong>yes</strong>, we can reach Gauss's cabin using just these two directions.</p>
</details>

# Pre-work Lesson 1

1. Similar problems to the above are posted on Moodle ("Pre-work Lesson 1"). Try these out! This is due before class on **Thursday**!
2. Watch the [Essence of Linear Algebra, Chapter 1](https://www.youtube.com/watch?v=fNk_zzaMoSs) video.
3. Come to Thursday's class prepared with any questions you had about the homework, today's lesson, or the video!
