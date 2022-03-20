# Linear Lesson 13: Vector Spaces (Introduction)
{:.no_toc}

# Warm-up

##

# Problem Set Questions

Let $A$ be an $m \times n$ matrix with entries $a_{i,j}$, for $1 \leq i \leq m$ and $1 \leq j \leq n$. (That is: $a{i,j}$ is the entry in the $i^{\text{th}}$ row and $j^{\text{th}}$ column.) Let $B$ be an $n \times r$ matrix with entries $b_{j,k}$, for $1 \leq j \leq n$ and $1 \leq k \leq r$, and let $C$ be an $r \times s$ matrix with entries $c_{k,l}$, for $1 \leq k \leq r$ and $1 \leq l \leq s$.
  * What is the entry in the $i^\text{th}$ row and $k^\text{th}$ column of the matrix $AB$? Use $\Sigma$ notation to express this as compactly as possible.
  * What is the entry in the $j^\text{th}$ row and $l^\text{th}$ column of $BC$?
  * Show that $A(BC) = (AB)C$. This shows that matrix multiplication is associative.

# Dimensions

[Who's at higher risk for COVID](https://www.mayoclinic.org/diseases-conditions/coronavirus/in-depth/coronavirus-who-is-at-risk/art-20483301)

[Association between Social / Demographic Factors and COVID case / death rates](https://jamanetwork.com/journals/jamanetworkopen/fullarticle/2775732)

# Vector Spaces

We have seen sets of vectors before. For example, $\mathbb{R}^2, \mathbb{R}^3$, etc. These sets all satisfy certain properties:

* Vectors can be added ($\vec{v} + \vec{w}$ is a vector if $\vec{v}$ and $\vec{w}$ are).
* Vectors can be re-scaled ($a \cdot \vec{v}$ is a vector if $\vec{v}$ is a vector and $a$ is a scalar).

But there are many other properties, we just didn't state them all. For example, the existence of a "zero vector" which does nothing when added to any other vector, or the existence of "additive inverses" which cancel each other out (vectors pointing in exact opposite directions, getting back to the origin). We'll list all these properties now for future reference (there are 10 of them):

**Definition**: A **vector space** (over the real numbers $\mathbb{R}$) is a set $V$ with operations $+$ (vector addition) and $\cdot$ (scalar multiplication) satisfying:

1. $V$ is **closed** under addition. That is, if $v, w \in V$, then $v + w \in V$.
2. $V$ is **closed** under scalar multiplication. That is, if $v \in V$ and $a \in \mathbb{R}$, then $a \cdot v \in V$.
3. $+$ is **associative**: $v + (w + z) = (v + w) + z$.
4. $+$ is **commutative**: $v + w = w + v$.
5. There is a **zero vector** $\vec{0} \in V$ such that for all vectors $v \in V$, $v + \vec{0} = v$.
6. Every $v \in V$ has an **additive inverse**: ie, for each $v$, there is $w \in v$ such that $v + w = \vec{0}$.
7. If $\alpha, \beta \in \mathbb{R}$ (scalars) and $v \in V$, then $(\alpha + \beta) \cdot v = \alpha \cdot v + \beta \cdot v$.
   * Note that $\alpha + \beta$ is "addition in $\mathbb{R}$", while $\alpha \cdot v + \beta \cdot v$ is "addition in $V$".
   * These notions of addition are not the same!
   * This property says that "scalar multiplication distributes over scalar addition".
 8. If $\alpha \in \mathbb{R}$ and $v, w \in V$, then $\alpha \cdot (v + w) = \alpha \cdot v + \alpha \cdot w$.
   * Here the "+" on both sides is in $V$.
   * This means "Scalar multiplication distributes over vector addition."
 9. If $\alpha, \beta \in \mathbb{R}$ and $v \in V$, then $\alpha \cdot (\beta \cdot v) = (\alpha \beta) \cdot v$.
   * On the left, we do scalar multiplication $\beta \cdot v$ first, then do another scalar multiplication.
   * On the right, we multiply the real numbers first, and then re-scale $v$ by that amount.
10. $1 \cdot v = v$ for all vectors $v \in V$.

## Examples
