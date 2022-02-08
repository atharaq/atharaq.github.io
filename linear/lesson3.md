<script src="https://sagecell.sagemath.org/static/embedded_sagecell.js"></script>
<script>sagecell.makeSagecell({"inputLocation": ".sage"});</script>

# Linear Lesson 3: Linear Functions
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up: Rotations

Suppose $V = W = \mathbb{R}^2$. Consider the function $T : \mathbb{R}^2 \to \mathbb{R}^2$ defined so that $T(\vec{v})$ is the vector $\vec{v}$, rotated 90$^\circ$ counterclockwise ($\pi/2$).

* What is $T(\binom{1}{0})$?
* What is $T(\binom{0}{1})$?
* What is $T(\binom{2}{0})$?
* What is $T(\binom{2}{1})$?

<div class="sage">
<script type="text/x-sage">
G = Graphics()
M = Matrix([[0, -1], [1, 0]])
z = vector([0, 0])

x = vector([2, 0])
y = vector([0, 1])
v = vector([2, 1])
G += arrow(z, x, color='green')
G += arrow(z, y, color='red')
G += arrow(z, v, color='blue')
G += arrow(z, M*x, color='green', linestyle='dotted')
G += arrow(z, M*y, color='red', linestyle='dotted')
G += arrow(z, M*v, color='blue', linestyle='dotted')
G.show(xmin=-2, xmax=2, ymin=-2, ymax=2, aspect_ratio=1)
</script>
</div>

Of course, we can add and rescale vectors. We could add before we rotate, or add after we rotate. That is: we could add $\binom{2}{0} + \binom{0}{1}$, and then rotate that by $\pi / 2$, or rotate each of those two vectors, and then add the results. If $T$ is well-behaved: it shouldn't matter what we do first!

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

v = vector([2, 0])
w = vector([0, 1])
G += parallelogram(v, w)
G += arrow(z, v + w, color='green')
G += parallelogram(M*v, M*w, linestyle='dotted')
G += arrow(z, M*(v + w), color='green', linestyle='dotted')
G.show(xmin=-2, xmax=2, ymin=-2, ymax=2, aspect_ratio=1)
</script>
</div>

In other words: *rotations respect vector addition*!

What about scalar multiplication? If we rescale a vector, and then rotate the result by 90 degrees, or if we rotate a vector and then rescale its result, does it change? That is, is $T(3 \cdot \binom{1}{1}) = 3 \cdot T(\binom{1}{1})$? Let's see:

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

# Linear Functions

As mentioned earlier: vectors are half the story in linear algebra. We really care about *functions* between sets of vectors. If $V$ and $W$ are two sets of vectors (maybe $V = \mathbb{R}^2$ and $W = \mathbb{R}^3$, for example), we can define what it means for $f : V \to W$ to be a function. But really we want functions that are somehow "well-behaved". What do we mean by that?

Recall that vectors can be added and rescaled. "Addition" might mean something different in $V$ than it does in $W$ (for example, addition in $V$ might mean adding two vectors component-wise, while addition in $W$ meight mean adding two functions). Similarly, scalar multiplication might be defined differently in $V$ as it is in $W$. But if $f : V \to W$ is well-behaved, then it should *respect* addition and scalar multiplication. That means: $f(\vec{v} + \vec{w}) = f(\vec{v}) + f(\vec{w})$, and $f(a \cdot \vec{v}) = a \cdot f(\vec{v})$. A function which respects **both** vector addition and scalar multiplication is exactly what we meant when we said "well-behaved" earlier.

**Definition**: Suppose $V$ and $W$ are "vector spaces" (we will define what that means later). A function $T : V \to W$ is called **linear** (sometimes $T$ is said to be "a linear map", "a linear function", or "a linear transformation") if:

1. for every $\vec{u}, \vec{v} \in V$, $T(\vec{v} + \vec{w}) = T(\vec{v}) + T(\vec{w})$, and,
2. for every $\vec{v} \in V$ and every scalar $a$, $T(a \cdot \vec{v}) = a \cdot T(\vec{v})$.

**Example**: Let's continue with the rotation by $\pi / 2$ example.

1. We saw that $T(\binom{1}{0}) = \binom{0}{1}$. Since $T(a \cdot \binom{1}{0}) = a \cdot T(\binom{1}{0})$, what does this tell us about $T(\binom{x}{0})$ for any real number $x$?
2. Similarly, since we know $T(\binom{0}{1})$, can we figure out $T(\binom{0}{y})$ for any scalar $y$?
3. Notice that $\binom{x}{0} + \binom{0}{y} = \binom{x}{y}$. We know $T(\binom{x}{0})$ and $T(\binom{0}{y})$. Can we figure out $T(\binom{x}{y})$?

**Exercises**:

1. Consider the function $F : \mathbb{R} \to \mathbb{R}$ defined by $F(x) = \sqrt{x}$. This is a function between "one dimensional" vector spaces. Is $F$ linear? Why or why not?
2. Suppose $T : \mathbb{R} \to \mathbb{R}$ is linear and suppose we know $T(1) = 5$. What is $T(2)$? What is $T(3)$? What is $T(x)$ for any $x$?
3. Suppose $T : \mathbb{R} \to \mathbb{R}$ is linear and suppose $T(1) = a$. What is $T(x)$ for any $x$?

# Images

**Definition**: Let $f : X \to Y$ be any function (not necessarily linear). The set $\\{ y \in Y : $ there is $x \in X$ such that $f(x) = y \\}$ is called the **image** of $f$. (This is sometimes referred to as the *range* of $f$, but I will usually avoid this term.) For any sset $A \subseteq X$, we also define $f(A) = \\{ y : $ there is $x \in A$ such that $f(x) = y \\}$.

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

## Exercises

Consider the function $T : \mathbb{R}^2 \to \mathbb{R}^2$ defined by $T(\binom{x}{y}) = \binom{x + 2y}{2x + 4y}$.

1. What is the image of the $x$-axis? That is, if $A = \\{ \binom{x}{0} : x \in \mathbb{R} \\}$, what is $T(A)$?
2. What is the image of the $y$-axis? That is, let $B = \\{ \binom{0}{y} : y \in \mathbb{R} \\}$, what is $T(B)$?
3. What is the image of the line $y = -\frac{1}{2} x$?

**Bonus**: Is $T$ linear? If it is, how would we prove this? If not, what would the counterexample be?

The idea would be: let $\vec{v} = \binom{v_1}{v_2}$ and $\vec{w} = \binom{w_1}{w_2}$ be two vectors. Compute $T(\vec{v})$ and $T(\vec{w})$ and add them. Then add $\vec{v} + \vec{w}$ and compute $T(\vec{v} + \vec{w})$. Then verify if $T(\vec{v} + \vec{w}) = T(\vec{v}) + T(\vec{w})$. (This would just check if $T$ respects vector addition, we would similarly check if $T$ respects scalar multiplication.)

## Preimages

# Injections / Surjections / Bijections

## Exercises

# Rotations

# Problem Set 1

## Quiz
