<script src="https://sagecell.sagemath.org/static/embedded_sagecell.js"></script>
<script>sagecell.makeSagecell({"inputLocation": ".sage"});</script>

# Linear Lesson 3: Linear Functions
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up: Rotating by 90 degrees

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

# Injections / Surjections / Bijections

**Definition**: Let $f : X \to Y$ be a function. $f$ is called **injective** (or "one to one") if, whenever $x \neq y \in X$, then $f(x) \neq f(y)$. $f$ is called **surjective** (or "onto") if whenever $y \in Y$, there is $x \in X$ such that $f(x) = y$. $f$ is called a **bijection** if it is both injective and surjective.

**Example**: The function $f : \mathbb{R}^2 \to \mathbb{R}$ defined by $f(\binom{x}{y}) = 2x - y$ is a surjection. Why? This is because, if $z \in \mathbb{R}$, then we can let $x = z$ and $y = z$, and then $f(\binom{x}{y}) = 2x - y = 2z - z = z$. So there is $\binom{x}{y} \in \mathbb{R}^2$ such that $f(\binom{x}{y}) = z$.

**Question**: Is this function an injection? (Hint: when is $f(\binom{x}{y}) = 0$?)

## Another Example

Consider the function $f : \mathbb{R}^2 \to \mathbb{R}^2$ defined by $f(\binom{x}{y}) = \binom{x + y}{x - y}$.

* What is $f(\binom{1}{0})$?
* What is $f(\binom{0}{1})$?
* What is the image of the $x$-axis?
* What is the image of the $y$-axis?

(picture)

$f$ is a linear function (I won't prove that here). The nice thing about linearity is that once we know the images of $f(\binom{1}{0})$ and $f(\binom{0}{1})$, we can figure out $f(\binom{x}{y})$ for any $x$ and any $y$. If $f$ is linear, then $f(\binom{x}{y})$ is always some linear combination of $f(\binom{1}{0})$ and $f(\binom{0}{1})$! In particular, the image of $f$ will be the **span** of $f(\binom{1}{0})$ and $f(\binom{0}{1})$! (Do you see why?)

**Question**: Is $f$ a surjection? That is, if $\vec{u} = \binom{a}{b}$, are there $x$ and $y$ such that $f(\binom{x}{y}) = \binom{a}{b}$? Let's think of this geometrically first. Since $f(\binom{1}{0}) = \binom{1}{1}$ and $f(\binom{0}{1} = \binom{1}{-1}$, and these two vectors do not lie on the same plane, we can conclude that their span is the entire plane $\mathbb{R}^2$.

Algebraically, we can prove our answer by showing that for every $\binom{a}{b}$, there are $x$ and $y$ so that the system

$$
\begin{align}
x + y &= a \\
x - y &= b
\end{align}
$$

has a solution. (How do we show this? Solve for $x$ and $y$ in terms of $a$ and $b$)

**Injectivity**: This is a bit harder. We will look at this once, but in the future we will have a better method to show injectivity later on in the semester.

The question is: if $T(\vec{u}) = T(\vec{v})$, does this mean that $\vec{u} = \vec{v}$? Let's let $\vec{u} = \binom{u_1}{u_2}$ and $\vec{v} = \binom{v_1}{v_2}$. Suppose that $\
binom{u_1 + u_2}{u_1 - u_2} = \binom{v_1 + v_2}{v_1 - v_2}$. Then $u_1 + u_2 = v_1 + v_2$ and $u_1 - u_2 = v_1 - v_2$. Does this mean that $u_1 = v_1$ and $u_2 = v_2$? It's not immediately clear. If you do some algebra, though, you might see:

$$
\begin{align}
u_1 - v_1 &= v_2 - u_2 \\
u_1 - v_1 &= u_2 - v_2
\end{align}
$$

That means we can set $v_2 - u_2 = u_2 - v_2$, and solve. If you solve this you get that $u_2 = v_2$. **Exercise**: Plug this in, and show that $u_1 = v_1$< therefore showing that $f$ is injective.

**Notice**: The definition of "injective function" is that if $x \neq y$, then $f(x) \neq f(y)$. What we actually proved is that if $f(x) = f(y)$, then $x = y$. Logically, this is equivalent to the original definition, since it's just the *contrapositive* of the original statement.

# Rotations

Let $\theta$ be any angle. Let $R_\theta : \mathbb{R}^2 \to \mathbb{R}^2$ be the "rotation by $\theta$ function."

(picture)

The picture shows that $R_\theta$ is linear! That means, again, we only need to know what $R_\theta(\binom{1}{0})$ and $R_\theta(\binom{0}{1})$ are in order to figure out what $R_\theta(\binom{x}{y})$ is for any $x$ and any $y$.

So, what is $R_\theta(\binom{1}{0})$? This is unit circle trig!

(picture)

$R_\theta(\binom{1}{0}) = \binom{\cos(\theta)}{\sin(\theta)}$! What about $R_\theta(\binom{0}{1})$?

(picture)

Here, again, we can figure out the coordinates using trig, and we get $R_\theta(\binom{0}{1}) = \binom{-\sin(\theta)}{\cos(\theta)}$. Now we can figure out $R_\theta(\binom{x}{y})$ using these two values!

**Exercise**: Find $R_\theta(\binom{2}{1}$. Hint: write $\binom{2}{1}$ as a linear combination of $\binom{1}{0}$ and $\binom{0}{1}$, and then use linearity.

**Solution**: Since $\binom{2}{1} = 2 \cdot \binom{1}{0} + \binom{0}{1}$, we get $R_\theta(\binom{2}{1}) = 2 \cdot R_\theta(\binom{1}{0}) + R_\theta(\binom{0}{1})$. Then plug in the values we had before, so $R_\theta(\binom{2}{1}) = 2 \cdot \binom{\cos(\theta)}{\sin(\theta)} + \binom{-\sin(\theta)}{\cos(\theta)}$. Then add these vectors and we get $\binom{2\cos(\theta) - \sin(\theta)}{2 \sin(\theta) + \cos(\theta)}$.

In general, *every* vector in $\mathbb{R}^2 can be written as a linear combination of $\binom{1}{0}$ and $\binom{0}{1}$. So because of linearity, if we know $R_\theta(\binom{1}{0}})$ and $R_\theta(\binom{0}{1})$, we know $R_\theta(\binom{x}{y})$ for every $x$ and $y$! This is what we do below:

First, we know that $R_\theta(\binom{x}{0}) = x \cdot \binom{\cos{\theta}}{\sin(\theta}}$, and $R_\theta(\binom{0}{y}) = y \cdot \binom{-\sin(\theta)}{\cos(\theta)}$. And because rotations respect vector addition, $R_\theta(\binom{x}{y}) = R_\theta(\binom{x}{0}) + R_\theta(\binom{0}{y})$. Putting these together:

$$R_\theta(\binom{x}{y}) = x \cdot \binom{\cos(\theta){\sin(\theta)} + y \cdot \binom{-\sin(\theta)}{\cos(\theta)}$.

Again: these two values of $R_\theta$ are all we need to know in order to determine every output of this function!

## Matrix Notation

To keep track of these two special values that tell us everything we need to know about this function, we use **matrix notation**:

$$
\begin{pmatrix}
\cos(\theta) & -\sin(\theta) \\
\sin(\theta) & \cos(\theta)
\end{pmatrix}
$$

We say that this matrix **represents** the linear function $R_\theta$. Every linear function has a matrix representation! This will be the chief object of study in this course.

# Problem Set 1

## Quiz
