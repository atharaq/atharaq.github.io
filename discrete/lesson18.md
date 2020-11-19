# Discrete Mathematics Lesson 18: Partial Orders
{:.no_toc}

1. Table of Contents
{:toc}

# Partial Orders

Recall some important properties of relations:

* R is **reflexive** if $\forall x (x \mathrel{R} x)$
* R is **symmetric** if $\forall x \forall y (x \mathrel{R} y \rightarrow y \mathrel{R} x)$
* R is **antisymmetric** if $\forall x \forall y (x \mathrel{R} y \wedge y \mathrel{R} x \rightarrow x = y)$
* R is **transitive** if $\forall x \forall y \forall z (x \mathrel{R} y \wedge y \mathrel{R} z \rightarrow x \mathrel{R} z)$

Given a set $X$, a relation $\sqsubseteq$ is called a **partial order** if it is reflexive, antisymmetric, and transitive. This definition is meant to generalize the $\leq$ relation on numbers ($\mathbb{Z}, \mathbb{Q}$ or $\mathbb{R}$):

* for any $x$, $x \leq x$.
* if $x \leq y$ and $y \leq x$, then we know $x = y$
* if $x \leq y$ and $y \leq z$, then we know $x \leq z$.

These are properties we use often when proving statements involving inequalities. For example, if we know that $2^{n+1} \leq (n+1) \cdot 2^n$ and then $(n+1)\cdot 2^n \leq (n+1)!$, then we conclude that $2^{n+1} \leq (n+1)!$ by transitivity.

The word "partial" is used because there is no requirement that any two elements must be comparable. There are two important examples of partial orders that we have seen already: the subset and divisibility relations.

**Exercise**: Let $X = \\{ a, b, c \\}$ and $\sqsubseteq$ be given by the following:

* $a \sqsubseteq a$, $b \sqsubseteq b$, $c \sqsubseteq c$
* $a \sqsubseteq b$, $c \sqsubseteq b$

Determine if $\sqsubseteq$ is a partial order on $X$.

<details>
    <summary>Check your answer:</summary>
    <p>$\sqsubseteq$ is <strong>reflexive</strong> because of the relations in first bullet point.</p>
    <p>There are no $x \neq y$ such that $x \sqsubseteq y$ and $y \sqsubseteq x$, so the relation is <strong>antisymmetric</strong>.</p>
    <p>If we look at all $x, y, z$ where $x \sqsubseteq y$ and $y \sqsubseteq z$, the options are:</p>
    <ul>
        <li>$x = a$, $y = a$, $z = a$.</li>
        <li>$x = a$, $y = a$, $z = b$.</li>
        <li>$x = a$, $y = b$, $z = b$.</li>
        <li>$x = b$, $y = b$, $z = b$.</li>
        <li>$x = c$, $y = c$, $z = c$.</li>
        <li>$x = c$, $y = c$, $z = b$.</li>
        <li>$x = c$, $y = b$, $z = b$.</li>
    </ul>
    <p>In each of these options, $x \sqsubseteq z$, so $\sqsubseteq$ is <strong>transitive</strong>.</p>
    <p>Therefore $\sqsubseteq$ <strong>is a partial order</strong>.</p>
</details>

**Exercise**: Let $X = \\{ a, b, c \\}$ and $\sqsubseteq$ be given by the following:

* $a \sqsubseteq a$, $b \sqsubseteq b$, $c \sqsubseteq c$
* $a \sqsubseteq c$, $c \sqsubseteq b$, $a \sqsubseteq b$
* $b \sqsubseteq a$

Determine if $\sqsubseteq$ is a partial order on $X$.

<details>
    <summary>Check your answer:</summary>
    <p>$\sqsubseteq$ is <strong>reflexive</strong> because of the relations in first bullet point.</p>
    <p>$\sqsubseteq$ is <strong>not antisymmetric</strong>, since $a \sqsubseteq b$ and $b \sqsubseteq a$, with $a \neq b$.</p>
    <p>Therefore $\sqsubseteq$ is <strong>not</strong> a partial order.</p>
</details>

**Notation**: In addition to $\sqsubseteq$, sometimes the $\preceq$ or $\preccurlyeq$ symbols are used to denote partial orders. If we're talking about the usual ordering on numbers, we will of course use the regular notation $\leq$ or $\geq$.

## Hasse Diagrams

A nice way to visualize partial orders is with **Hasse diagrams**. Put a vertex for each element. If $x \sqsubseteq y$, $x \neq y$, and there is no $z$ in between (ie no $z$ such that $x \sqsubseteq z \sqsubseteq y$) then draw a line upwards from $x$ to $y$.

In this visualization, we would tell if $a \sqsubseteq b$ by checking if there is a path upwards from $a$ to $b$.

**Example**: Let $X = \\{ a, b, c, d \\}$, with the following relations:

* $a \sqsubseteq a$, $b \sqsubseteq b$, $c \sqsubseteq c$, $d \sqsubseteq d$
* $a \sqsubseteq c$, $b \sqsubseteq c$
* $a \sqsubseteq d$, $b \sqsubseteq d$, and $c \sqsubseteq d$

This has the following Hasse diagram:

**insert picture**

**Exercise**: Let $X = \\{ a, b, c, d, e \\}$, with the following relations:

* all the reflexive relations ($a \sqsubseteq a$, $b \sqsubseteq b$, etc)
* $a \sqsubseteq c$, $b \sqsubseteq c$
* $a \sqsubseteq d$, $b \sqsubseteq d$, and $c \sqsubseteq d$
* $a \sqsubseteq e$, $b \sqsubseteq e$, and $c \sqsubseteq e$

<details>
    <summary>Check your answer</summary>
    <img class="noreverse" src="" title="Hasse diagram for exercise" alt="Hasse diagram for exercise" />
</details>

## Subsets

Let $U$ be any set and $X = \mathcal{P}(U)$. Then the relation $A \subseteq B$ is a partial order on $X$:

* For every $A \in X$, $A \subseteq A$, since every element of $A$ is of course an element of $A$ (so $\subseteq$ is reflexive).
* If $A \subseteq B$ and $B \subseteq A$, then $A = B$ (antisymmetric). This is our definition of set equality: two sets are equal if they have the same elements.
* If $A \subseteq B$ and $B \subseteq C$, then $A \subseteq C$. You will prove this on the homework / problem set, but it's not hard to show.

Let's look at the particular example of $X = \mathcal{P}(\\{0, 1 \\})$.

**Insert Picture**

Notice the following:

* For every $A \in X$, $A \subseteq \\{0, 1 \\}$. This means that $\\{0, 1 \\}$ is the **maximum** element of the partial order.
* For every $B \in X$, $\emptyset \subseteq B$. This means that $\emptyset$ is the **minimum** element of the partial order.

## Maximal vs Maximum, Minimal vs Minimum

Given a set $X$ and a partial order $\sqsubseteq$, an element $a \in X$ is called a **maximal** element if there is no $b \in X$ such that $a \sqsubseteq b$. That is: $\lnot \exists b (a \sqsubseteq b)$.

$a \in X$ is called the **maximum** element if $\forall b (b \sqsubseteq a)$. These sound like the same idea, and sometimes these are two terms that mean the same thing. For example, in $\mathcal{P}(\\{0, 1 \\})$, the set $\\{0, 1 \\}$ is both a maximal element and a maximum element.

But it's possible for a partial order to have maximal elements, but no maximum elements. For example, suppose one prefers chocolate or vanilla flavored ice cream to strawberry flavored ice cream, but has no preference between chocolate or vanilla. We can think of this as a partial order, where "chocolate" and "vanilla" are maximal elements, but there is no one, singular maximum.

Similarly, there is a distinction between **minimal** elements and the **minimum** of a partial order.

* $a \in X$ is **minimal** if there is no $b \in X$ such that $b \sqsubseteq a$.
* $a \in X$ is the **minimum** if $\forall b \in X (a \sqsubseteq b)$.

**Exercise**: One way to compare students' SAT scores is by "double domination". Represent a students SAT score by an ordered pair (math, verbal). Then we define $(a, b) \preceq (x, y)$ if $a \leq x$ and $b \leq y$. That is, we can put students in order only if one student outperforms the other in **both** categories.

Consider the following students, with their (math, verbal) scores:

* Alice: $(750, 730)$
* Bob: $(780, 700)$
* Carol: $(600, 700)$
* David: $(500, 520)$
* Eve: $(800, 580)$

Is there a maximum element among these students? Is there a minimum element? What are the maximal and minimal elements?

<details>
    <summary>Check your answers</summary>
    <p>There is no maximum element. There are three maximal elements: Alice, Bob, and Eve.</p>
    <p>There is a minimum element: David. David is also the sole minimal element: this is not a surprise, as if there is a minimum element, then it must be minimal.</p>
</details>

# Linear Orders

As we have seen, there is an important property of "regular" inequalities (for numbers) that is not true about some of these partial orders: for inequalities, all numbers are **comparable** with each other. That is, given $x, y \in \mathbb{R}$, either $x \leq y$ or $y \leq x$ (or both).

A partial order which has this property is called a **total** order, or a **linear** order.

**Example**: Consider the set $X = \\{ 2^i : 0 \leq i \leq 10 \\}$, with $x \sqsubseteq y$ iff $x \mid y$ (if $x$ divides $y$). This relation is a linear order:

* It's reflexive: $2^i \mid 2^i$ for any $i$.
* It's antisymmetric: if $2^i \mid 2^j$ and $2^j \mid 2^i$, then that means $2^j = k 2^i$, and $2^i = m \cdot 2^j$, so combining that we get $2^i = km \cdot 2^i$, that is, $km = 1$. Since $2^i$ and $2^j$ are both positive, $k$ and $m$ must both be equal to $1$, and so $i = j$.
* It's transitive: if $2^i \mid 2^j$ and $2^j \mid 2^k$, then $2^k = n \cdot 2^j$ and $2^j = m \cdot 2^i$. Combining these, $2^k = nm \cdot 2^i$, and so $2^i \mid 2^j$.
* All two elements are comparable: let $0 \leq i, j \leq 10$. If $i \leq j$, then $2^i \cdot 2^{j-i} = 2^j$, so $2^i \mid 2^j$. If $i \geq j$, then $2^j \cdot 2^{i-j} = 2^i$, so $2^j \mid 2^i$. Either way, $2^i$ and $2^j$ are comparable.

## Lexicographic ordering

At one point this semester, I stated that there is no order on the complex numbers $\mathbb{C}$. This is not strictly true: we can use the **lexicographic** ordering on complex numbers. $a + bi \preceq c + di$ iff $a < c$ **or** ($a = c$ **and** $b \leq d$). In this, elements on the complex plane are ordered from left to right and then bottom to top: anything on the left of the complex plane is smaller than anything on the right, and two points on the same vertical line of the complex plane (ie with the same "real part") are ordered bottom to top.

This is, in fact a linear order! Let's show that it satisfies all four properties:

**Reflexive**: $a + bi \preceq a + bi$ since $a = a$ and $b \leq b$.

**Antisymmetric**: If $a + bi \preceq c + di$ and $c + di \preceq a + bi$, we have a few cases to examine. What if $a < c$? Then it's impossible for $c < a$ or $c = a$, so $c + d i \not \preceq a + bi$. Therefore $a = c$. Now since $a + bi \preceq c + di$, we know $a = c$ and $b \leq d$. Similarly, since $c + di \preceq a + bi$, $c = a$ and $d \leq b$. Therefore since $b \leq d$ and $d \leq b$, by antisymmetry we conclude $b = d$. That is, we now have concluded that $a = c$ and $b = d$, that is, that $a + bi = c + di$.

**Transitive**: Suppose $a + bi \preceq c + di$ and $c + di \preceq e + fi$. There are several cases, again.

* Suppose $a < c$. Then since $c + di \preceq e + fi$, either $c < e$ or $c = e$ and $d \leq f$. Either way, $c \leq e$. Therefore, since $a < c \leq e$, by transitivity we conclude $a < e$ so $a + bi \preceq e + fi$.
* Now suppose $a = c$ and $b \leq d$. Then if $c < e$, we have $a = c < e$, so $a < e$ so $a + bi \preceq e + fi$. If $c = e$ and $d \leq f$, then by transitivity (of equals) $a = e$, and by transitivity (of $\leq$), $b \leq f$. So $a + bi \preceq e + fi$.

**Comparability**: Suppose $a + bi$ and $c + di$ are any two complex numbers. Then either $a \leq c$ or $c \leq a$ since $a$ and $c$ are just real numbers with the regular ordering. So there are three options: either $a < c$, $c < a$ or $a = c$. The first option gives $a + bi \preceq c + di$, and the second option gives $c + di \preceq a + bi$. For the third option, we then compare $b$ and $d$, and again since any two real numbers can be compared, either $b \leq d$ or $d \leq b$. Either way, we can compare $a + bi$ and $c + di$.

Given a partial order $\sqsubseteq$ on a set $X$, we can get a partial order on the set of ordered pairs of elements of $X$ (or on the set of ordered triples, or ordered $n$-tuples more generally) using this same idea of the **lexicographic** order. The word **lexicographic** comes from the word "lexicon", meaning dictionary. In the dictionary, you compare words letter by letter: compare the first letters of each, and if they are the same, then move on to the second letter. Similarly, given ordered pairs $(a, b)$ and $(x, y)$, compare $a$ and $x$ first. If $a = x$, then compare $b$ and $y$.

If $\sqsubseteq$ is a linear order, then this lexicographic order is also a linear order. But if not, it's still a partial order. All of the proofs of facts like this are similar.

**Question**: What goes wrong here? I mentioned in class at some point that there really isn't a "nice" order on the complex numbers. Why do I not consider this one to be "nice"?

The issue isn't so much about the ordering, itself, but more about how the ordering interacts with the operations on $\mathbb{C}$. For example, from this order, we get $0 \preceq i$, since $0$ and $i$ have the same real part, but $i$ sits above $0$ on the complex plane.

A basic property of inequalities with real numbers we use often is that we can "multiply both sides" of an inequality by a positive number. That is, if $0 \leq x$, then for any $a \leq b$, $ax \leq bx$. This property does **not** translate to this ordering of the complex numbers. In particular: $0 \leq i$, but $0 \cdot i \not \leq i \cdot i$, since $i \cdot i = -1$!

# Trees

Another special kind of partial order is called a **tree**. We will be exploring trees some more at the very end of the semester, but first let's look at an example.

Consider the following set of binary sequences of length at most 2: the empty sequence (represented by $\varepsilon$), 0, 1, 00, 01, 10, 11. For two sequences $a$ and $b$, we say $a \sqsubseteq b$ if $b$ is an extension of $a$ to the right. For example, $01$ and $00$ are both extensions of $0$. We get the following Hasse diagram:

**insert picture**

Notice that there is a minimum element here: $\varepsilon$. This is called the **root** of the tree. There is no maximum, but there are several maximal elements: $00, 01, 10, 11$. These are sometimes referred to as **leaves** of the tree.

So what makes this a tree? In addition to being a partial order, this tree has the property that each "branch" is a linear order. That is: given any $x$ in the tree, the set $\\{ y : y \sqsubseteq x \\}$ is a linear order.

**Examples**:

1. Let $T_1 = \\{ a, b, c, d \\}$ with all the reflexive relations along with $a \sqsubseteq b$, $a \sqsubseteq c$, and $a \sqsubseteq d$. This is a tree: for each $x \in T_1$ the set $\\{ y : y \sqsubseteq x \\}$ is just $\\{ a, x \\}$, which is a linear order since $a \sqsubseteq x$ always.
2. Let $T_2 = \\{a, b, c, d \\}$ with all the relations above, along with $b \subseteq c$ and $d \subseteq c$. This is **not** a tree: $b$ and $d$ are incomparable, but are both below $c$.

Often, trees in computer science are pictured upside down, so that the root is on top, and the leaves on the bottom.

**insert picture**

**Exercise**: Let $T = \\{ 0, a, b, ab, aba, ba, baa \\}$ with the relations as follows:

* All the reflexive relations.
* $0 \sqsubseteq x$ for every $x$
* $a \sqsubseteq ab \sqsubseteq aba$
* $b \sqsubseteq ba \sqsubseteq baa$
* Any relations implied by transitivity (ie $a \sqsubseteq aba$ and $0 \sqsubseteq baa$)

Show that $T$ is a tree.

<details>
    <summary>Check your answer</summary>
    <p>Reflexivity and transitivity are given to you. Antisymmetry is also clear since there are no loops.</p>
    <p>So all we really need to check is that the two sets $B_1 = \\{ x : x \sqsubseteq aba \\}$ and $B_2 = \\{ x : x \sqsubseteq baa \\}$ are linearly ordered.</p>
    <p>$B_1 = \\{ 0, a, ab, aba \\}$ and is ordered $0 \sqsubseteq a \sqsubseteq ab \sqsubseteq aba$, which is a linear order.</p>
    <p>$B_2 = \\{ 0, b, ba, baa \\}$ and is ordered $0 \sqsubseteq b \sqsubseteq ba \sqsubseteq baa$, which is also a linear order.</p>
</details>
