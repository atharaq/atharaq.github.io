# Computability Lesson 15: Input/Output and Set Theory / Cardinality
{:.no_toc}

1. Table of Contents
{:toc}

<!--
12:30 - 12:40 warm up
12:40 - 1:10 IOTM proof
1:10 - 1:55 cardinality, countability, etc
1:55 - 2:10 PS3
-->

# Warm up

Discuss the following with each other: is the function which, on input $a^n$, outputs the first $n$ digits of $\pi$ a (partial or total) computable function? Can you give an informal argument (without Turing Machines)?

**Recall**: We say a function $F : D \to \Gamma^\*$ is a partial computable function if there is an input-output TM $M$ which, for every input $w$, halts and outputs $F(w)$ if and only if $w \in D$ (if $w \notin D$, then $M$ does not halt on $w$). $F$ is total if $D$ is the set of all possible inputs

# Finishing the proof from last time

**Theorem**: Let $\mathcal{L}$ be a language, $\mathcal{L} \neq \emptyset$. The following are equivalent:

1. $\mathcal{L}$ is c.e.
2. $\mathcal{L}$ is the domain of a partial computable function.
3. $\mathcal{L}$ is the range of a total computable function.

**Proof**: We will prove these equivalencies in a cycle. We'll show $1 \implies 2$, $2 \implies 3$ and $3 \implies 1$. First: $1 \implies 2$ is easy. If $\mathcal{L}$ is c.e., then there is a TM $M$ which recognizes $\mathcal{L}$. Just modify $M$ to be an IO TM by getting rid of the reject state and turning $q_{accept}$ into $q_{halt}$. Then whenever $w \in \mathcal{L}$, $M$ will halt on input $w$. Who knows what $M$ outputs? Who cares; all that matters is that $w$ is in the domain of this partial computable function!

$2 \implies 3$ is a little harder, so we'll come back to that.

$3 \implies 1$ is simple as well, and basically what we did for enumerators. Suppose $F$ is a total computable function such that for every $w \in \mathcal{L}$, there is $s \in \Sigma^*$ such that $F(s) = w$. Then we can recognize $\mathcal{L}$ as follows:

"On input $w$,
For each string $s \in \Sigma^\*$:
1. Compute $F(s)$. If $F(s) = w$, accept.
2. If not, re-do Step 1 for the next string $s$."

Now for $2 \implies 3$. Let $F : \mathcal{L} \to \Gamma^\*$ be a partial computable function. Use the fact that $\mathcal{L} \neq \emptyset$, so that there is some specific word $y \in \mathcal{L}$.

We define a total computable function $G$ which does the following:

"On input $(w, n)$:
1. Run $F$ on $w$ for $n$ steps.
2. If $F$ halts within $n$ steps, output $w$.
3. If $F$ does not halt within $n$ steps, then output $y$."

How do we represent $(w, n)$? There are a few ways, but it's not really that important.

# Aside: Hilbert's Tenth

David Hilbert, in his famous list of unsolved problems in mathematics in 1900, posed the following question:

> Given a Diophantine equation with any number of unknown quantities and with rational integral numerical coefficients: To devise a process according to which it can be determined in a finite number of operations whether the equation is solvable in rational integers.

That is: given a polynomial in several variables (unknown how many exactly) with integer coefficients, determine if the polynomial has a root. Related to this problem, we can consider the set $HTP = \\{ p(x_1, \ldots, x_n) : p$ is a polynomial with integer coefficients in the variables $x_1, \ldots, x_n$, and there are $a_1, \ldots, a_n \in \mathbb{Z}$ such that $p(a_1, \ldots, a_n) = 0 \\}$.

**Problem**: Show that the set $HTP$ is c.e. by finding an input-output TM $F$ such that the domain of $F$ is $HTP$.

(What's the alphabet? Doesn't really matter so much. Just think about what the partial computable function $F$ should be.)

The question really asked if there is an algorithm which *decides* if a polynomial has a root. That is: is this language decidable? We showed that it's c.e. There is some interesting history to this problem:

* In 1949, Martin Davis did some work on this and conjectured that the "Diophantine sets" (sets of numbers which are defined as solutions to a polynomial equation) and c.e. sets are exactly the same sets.
* In 1950, independently, Julia Robinson conjectures that exponentiation, factorials, and primes are all Diophantine sets.
* In the late 50s and early 60s, Davis, Hilary Putnam, and Robinson show that Robinson's conjecture (referred to as "J.R.") implies Davis' conjecture (that all c.e. sets are Diophantine).
* In 1970, Yuri Matiyasevich proves Robinson's conjecture, thereby proving that all c.e. sets are Diophantine.

How does this relate to Hilbert's Tenth Problem? By this point, it had already been well established that there are c.e. sets which are not decidable! This was proved by Turing himself, from the very birth of computability theory. So by proving that all c.e. sets are Diophantine, this shows that if we take a set which is c.e. but not decidable, it shows that there can be no general algorithm to decide if a number is in a particular Diophantine set.

# Number of TMs and Languages

We have now studied the basics of computability theory. We will start exploring the difference between c.e. languages and computable languages. That is, we'll find languages that are c.e. but not computable. This means that there are "problems" which "cannot be solved by any algorithm"!

We will also see that there are languages that are not even c.e! We can see this without even any computability theory, just set theory. Set theory allows us to compare the sizes of infinite sets. We'll use these ideas to show that there are "more" languages than there are Turing Machines (in a precise sense).

So how do we compare the sizes of infinite sets? First, how do we compare the sizes of finite sets? When we first learn to count, we compare two sets of objects by lining up the two sets and checking to see that for each object of the first set, we have exactly one corresponding object in the second set.

This is called a "one to one correspondence". For example, the below picture shows a one-to-one correspondence between the sets $\\{ 1, 2, 3, 4 \\}$ and $\\{ A, B, C, D \\}$.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Bijection.svg/1920px-Bijection.svg.png" />

The mathematical term for a one to one correspondence is a **bijection**.

**Definition**: Let $f : A \to B$ be a function. Then:

1. $f$ is an **injection** (one to one) if whenever $x \neq y \in A$, then $f(x) \neq f(y)$.
2. $f$ is a **surjection** (onto) if for each $b \in B$ there is $a \in A$ such that $f(a) = b$.
3. $f$ is a **bijection** if it is one to one and onto.

We say that the sets $A$ and $B$ have the same *cardinality* if there is a bijection $f : A \to B$. This is a form of an **equivalence relation**: it is **reflexive** (every set can be put in bijection with itself), **symmetric** (if there is a bijection $f : A \to B$, then there is a bijection $g : B \to A$), and **transitive** (if there is a bijection $f : A \to B$ and a bijection $g : B \to C$, then there is one $h : A \to C$).

(**Exercise**: Can you show why cardinality is symmetric? Can you show why it's transitive?)

We make some obvious definitions, and then use these to extend our vocabulary to be able to talk about infinite sets.

**Definition**: A set $X$ is **finite** if there is $n \in \mathbb{N}$ and a bijection $f : \\{ 0, \ldots, n - 1 \\} \to X$. We say $\|X\| = n$.

(Clearly, this shows that $\mathbb{N}$ is not finite. This is the pigeonhole principle.)

**Definition**:

1. A set that is not finite is called **infinite**.
2. If $X$ is infinite and there is a bijection $f : \mathbb{N} \to X$, then we say $X$ is **countably infinite**, and $\|X\| = \aleph_0$.

The following sets are countably infinite:

1. $\mathbb{N}$ (obviously)
2. $\mathbb{N} \setminus \\{ 0 \\}$
3. $E = \\{ 0, 2, 4, 6, \ldots \\}$
4. $O = \\{ 1, 3, 5, 7, \ldots \\}$
5. $\mathbb{Z}$
6. $\mathbb{Q}$

To prove these, we need to show bijections between $\mathbb{N}$ and each of these sets. Let's do a few:

1. The function $id : \mathbb{N} \to \mathbb{N}$ given by $id(n) = n$ is a bijection.
2. $f(n) = n + 1$ is a bijection from $\mathbb{N}$ to $\mathbb{N} \setminus \\{ 0 \\}$.
3. $g(n) = 2n$ is a bijection from $\mathbb{N}$ to $E$.
4. Can you find a bijection from $E$ to $O$? Then you can use the fact that cardinality is transitive: since $E$ is countably infinite and there is a bijection between $E$ and $O$, then there is a bijection between $\mathbb{N}$ and $O$.

**Theorem**: The union of two countably infinite sets is countably infinite.

**Proof**: Suppose $A$ and $B$ are countably infinite. Assume that $A \cap B = \emptyset$ (the more general case is also true) Let $f : \mathbb{N} \to A$ and $g : \mathbb{N} \to B$ be bijections. Then we define $h : \mathbb{N} \to A \cup B$ separately on the even and odd numbers, by letting $h(2n) = f(n)$ and $h(2n + 1) = g(n)$. (Does this actually define $h$ on all natural numbers $n$?)

I claim that $h$ is a bijection. First: $h$ is one to one. Suppose $h(n) = h(m)$. First note that for all $n$, if $n$ is even, then $h(n) \in A$ and if $n$ is odd, $h(n) \in B$. Since $A \cap B = \emptyset$, then if $n$ is even and $m$ is odd, then $h(n) \neq h(m)$ since there is nothing in both sets.

Suppose $n$ is even. Then $h(n) = f(\frac{n}{2})$. By the above argument, $m$ must also be even, and so $h(m) = f(\frac{m}{2})$. Since $h(n) = h(m)$, this means $f(\frac{n}{2}) = f(\frac{m}{2})$. But since $f$ is a bijection, then $\frac{n}{2} = \frac{m}{2}$. But then $n = m$.

Similarly, we can show that if $n$ is odd, them $m$ is odd and $n = m$.

Now we show that $h$ is onto. Suppose $y \in A \cup B$. Then either $y \in A$ or $y \ in B$. Suppose $y \in A$. Since $f$ is onto, there is $n \in \mathbb{N}$ such that $f(n) = y$. Then $h(2n) = y$. If $y \not \in A$, then $y \in B$, and since $g$ is onto, there is $n \in \mathbb{N}$ such that $g(n) = y$. But then $h(2n + 1) = y$. So whether $y \in A$ or $y \in B$, there is some $x \in \mathbb{N}$ such that $h(x) = y$.

## $\mathbb{Z}$

Let's use this previous theorem to show that $\mathbb{Z}$ is countably infinite.

First, note that $\mathbb{Z}$ is the union of the natural numbers $\mathbb{N}$ and the set of all negative integers $\\{ -1, -2, -3, \ldots \\}$. But since $\mathbb{N}$ is countable, we just need to show that the set of all negative integers $\\{ -1, -2, -3, \ldots \\}$ is countable, and then by the theorem above, their union would also be countably infinite!

Define $f : \mathbb{N} \to \\{ -1, -2, -3, \ldots \\}$ by $f(n) = -1 - n$. Then $f(0) = -1, $f(1) = -2$, $f(2) = -3$, etc.

**Claim**: $f$ is a bijection.

First: $f$ is one to one, since if $f(n) = f(m)$, then $-1 - n = -1 - m$. Do a little algebra and you can convince yourself then that $n = m$.

Next: we show that $f$ is onto. That is, we show that if $y$ is a negative integer, we can find some $n \in \mathbb{N}$ such that $-1 - n = y$. Solve for $n$ here and get that $n = -1 - y$. If $y$ is negative, that is, $y < 0$, then $-y > 0$, and so $-1 - y > -1$. But since $y$ is an integer, then $-1 - y$ would then be an integer that is greater than -1; that is, it could be $0, 1, 2, \ldots$

So for any negative integer $y$, $f(-1 - y) = y$, and, moreover, $-1 - y \in \mathbb{N}$, so $f$ is onto!

## $\mathbb{Q}$

The fact that the integers are countably infinite boils down to this fact: we can list all integers in an *infinite sequence*, such that each integer shows up at some *finite* position (and shows up exactly once). We list the integers as $0, -1, 1, -2, 2, -3, 3, -4, 4, \ldots$ We could turn this "infinite sequence" into an explicit function $h : \mathbb{N} \to \mathbb{Z}$, but the actual rule is not so important as the fact that there is a way to list these numbers out.

The caveat here that each integers shows up at a finite position is important. The listing $0, 1, 2, 3, \ldots, -1, -2, -3, -4, \ldots$ is not a valid "infinite sequence" in this sense. At which position does $-2$ show up?

Now let's consider the rational numbers $\mathbb{Q} = \\{ \frac{m}{n} : m, n \in \mathbb{Z}, n \neq 0 \\}$. Are the rational numbers also countably infinite? Is there a way to list out all rational numbers in an infinite sequence? It's not entirely obvious: if we start by listing out all the integers, we will miss out on numbers likes $\frac{1}{2}, \frac{3}{2}$, etc. If we start by listing out all the numbers whose denominator is $2$, we will miss out on $\frac{1}{3}$.

It's not clear at all how we might do this! One would be forgiven for believing there is no way to list out all rational numbers in an infinite sequence. But there is a way!

For now, we will only list out the positive rational numbers. The first step is to write out all possible rational numbers in an infinite 2-dimensional array. The number on the $m$-th row and $n$-th column will be $\frac{m}{n}$:

$$
\begin{array}{ccccc}
\frac{1}{1} & \frac{1}{2} & \frac{1}{3} & \frac{1}{4} & \frac{1}{5} \ldots \\
\frac{2}{1} & \frac{2}{2} & \frac{2}{3} & \frac{2}{4} & \frac{2}{5} \ldots \\
\frac{3}{1} & \frac{3}{2} & \frac{3}{3} & \frac{3}{4} & \frac{3}{5} \ldots \\
\frac{4}{1} & \frac{4}{2} & \frac{4}{3} & \frac{4}{4} & \frac{4}{5} \ldots \\
\frac{5}{1} & \frac{5}{2} & \frac{5}{3} & \frac{5}{4} & \frac{5}{5} \ldots \\
\vdots
\end{array}
$$

Then start at the top left and "spiral around", ignoring fractions which can be reduced. So we end up with the listing: $1, 2, \dfrac{1}{2}, \dfrac{1}{3}, 3, 4, \dfrac{3}{2}, \dfrac{2}{3}, \dfrac{1}{4}, \ldots$

This spiraling is visualized in the following image: start at 1/1 on the top left, and then follow along the arrows, ignoring numbers that can be reduced (these are pointed out in red). Every rational number, expressed as $\dfrac{p}{q}$ in simplest form, will show up in this array on the $p$-th row and $q$-th column, and that position will be seen in finitely many steps. So that means this infinite listing we have will list out all positive rational numbers.

![Rationals are countable](https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Diagonal_argument.svg/485px-Diagonal_argument.svg.png "Rationals are countable")

## What else?

All of this work kind of begs the question: are all infinite sets countably infinite? It seems like we made up a definition of cardinality to be able to compare the sizes of infinite objects, but so far it turns out that all infinite objects are the same size. Maybe everything is just either "finite" or "infinite" and there isn't anything more to say?

We've checked $\mathbb{N}$, different infinite subsets of $\mathbb{N}$, $\mathbb{Z}$, and $\mathbb{Q}$. What would the next logical set to check be?

# Number of TMs

How many Turing Machines are there? In other words: is the set of all Turing Machines countable?

Recall: a TM is a 7-tuple $(Q, \Sigma, \Gamma, \delta, q_0, q_a, q_r)$. $Q$, $\Sigma$, and $\Gamma$ are all finite sets. For now, let's fix $\Sigma = \\{ a \\}$ and $\Gamma = \\{ a, \sqcup, \dot a \\}$ (maybe we need to add in a few more symbols to $\Gamma$, but probably not too many).

There are actually many, many finite sets $Q$ (so technically, the answer to our question above is: "The collection of all TMs is too big to even be called a set!"). But we are actually concerned with the set of all c.e. languages, so in that case we can really just restrict to thinking about $Q$ be sets of numbers of the form $\\{ 0, 1 , \ldots, n - 1 \\}$. Then the question would be: how many functions $\delta$ are there? Of course, there are only finitely many functions between finite sets. So that means there are only finitely many TMs with 2 states, finitely many TMs with 3 states, finitely many with 4 states, etc.

So we can list them all out, and in that way get a bijection from $\mathbb{N}$ to the set of all TMs! That is:

* $f(0) =$ the first TM in our list
* $f(1) =$ the second TM in our list
* $f(2) =$ the third TM in our list

etc.

## Number of Languages

Let's fix $\Sigma = \\{ a \\}$. Each language $\mathcal{L} \subseteq \Sigma^\*$ canonically corresponds to some set $A \subseteq \mathbb{N}$. Just let $A$ be the set of all *lengths* of words in $\mathcal{L}$ (or vice versa: given a set of numbers $A$, let $\mathcal{L} = \\{ a^n : n \in A \\}$).

That means that the **cardinality** of the set of all languages over $\Sigma^\*$ is the same as the cardinaliyt of the set of all *subsets* of $\mathbb{N}$. In other words, it's the same as the cardinality of $\mathcal{P}(\mathbb{N})$.

We've seen many infinite sets today: all of them can be put in bijection with $\mathbb{N}$. But it turns out that not *every* infinite set is countably infinite! There are **uncountable** infinite sets as well! $\mathcal{P}(\mathbb{N})$ is one example of such an uncountable set. That means: there is no bijection between $\mathbb{N}$ and $\mathcal{P}(\mathbb{N})$! We will prove this next time!

# Upcoming

* PS3 due tonight
* Presentation 1 due on VT Sunday
* Take-home exam given later this week, due after Spring Break
