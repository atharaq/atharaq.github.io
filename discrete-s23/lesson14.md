# Discrete Mathematics Lesson 14: Binary, Octal, and Hexadecimal Representations of Numbers
{:.no_toc}

1. Table of Contents
{:toc}

# Events Recap

* NSS Lecture reflections?

# Announcement

Keep an eye on your email / Moodle for announcements about possible cancelations / last minute changes to classes over the next two weeks. Unless I say otherwise:

* **Thursday, March 30**???
* **Thursday, April 6** will be asynchronous. The lecture notes will be posted on Moodle.
* **Monday, April 10** might be asynchronous or on Zoom. This will be announced later.

# Upcoming

* Problem Set 4: due **next week**.
* Exam 2: given next week, due the following week.
* Final Project:
  * Start thinking about topics you're interested in, tangentially related to the course.
  * Non-classical logics, set theory paradoxes, discrete probability, satisfiability / NP-completeness, first order satisfiability / incompleteness, etc.
  * Form groups (3-4 per group?). (I can form them for you.)

# Problem Set 3 / Induction

* "Inductive assumption" or "Inductive hypothesis"
* $P(n)$ is whatever you want to prove.
  * Ex: "There are $n!$ bijections between two sets of size $n$"
  * "The sum $\sum\limits_{k=0}^n \binom{n}{k} = 2^n$."
  * "There are $2^n$ assignments of truth values to $n$ variables."

## $n!$ bijections

**Base case**: $n = 0$. There is one bijection $f : \emptyset \to \emptyset$.

* What does $f : \emptyset \to \emptyset$ mean?
  * $f$ is a set of ordered pairs $(x, y)$ such that $x \in \emptyset$, $y \in \emptyset$
  * For every $x \in \emptyset$, there is exactly one $y \in \emptyset$ such that $(x, y) \in f$
  * For every $y \in \emptyset$, there is exactly one $x \in \emptyset$ such that $(x, y) \in f$.
* $f = \emptyset$ satisfies all of those.
* There is exactly one *function* $f : \emptyset \to \emptyset$
  * That is $f = \emptyset$
  * f is also a bijection (vacuously true)

**Inductive step**:

Let $n \in \mathbb{N}$ and assume that for any two sets $X$ and $Y$ of size $n$, there are $n!$ bijections between them. Let $A$ and $B$ have size $n + 1$. Fix $a \in A$. For each $b \in B$, how many bijections are there $f : A \to B$ such that $f(a) = b$? Every bijection $f : A \setminus \{ a \} \to B \setminus \{ b \}$ extends uniquely to a bijection $\hat{f} : A \to B$ such that $f(a) = b$. There are $n!$ bijections $f : A \setminus \{ a \} \to B \setminus \{ b \}$ by induction.

There are $n + 1$ different $b \in B$. For each one, there are $n!$ bijections from $A \to B$ mapping $a$ to $b$. Therefore there are $(n+1) \times n!$ bijections from $A$ to $B$. $(n+1) \times n! = (n+1)!$, so there are $(n+1)!$ bijections between two sets of size $n+1$.

# Problem Set 4 / Modular Arithmetic

Transitivity: if $x \mid y$ and $y \mid z$, then $x \mid z$?

* $x \mid y$ means there is $k$ such that $y = xk$.
* $y \mid z$ means there is $m$ such that $z = my$.
* Could this be false? Counterexample: x = ?, y = ?, z = ?
* Must it be true? Proof?

Symmetry: if $x \mid y$, does $y \mid x$?

* $x \mid y$ means there is $k$ such that $y = xk$.
* Can we find $m$ so that $x = my$?
* $y = (my)k$?
* Could this be false? Counterexample: x = ?, y = ?
* Must it be true? Proof?

If $x \neq y$, and $x \mid y$, then $\lnot (y \mid x)$?

<ul>
<li>$x \mid y$ means there is $k$ such that $y = xk$.</li>
<li>Can we conclude that there is **no** $m$ such that $x = my$?</li>
<div class="fragment">
<li>Hint: $x, y, k$ are **integers**. Meaning...?</li>
<li>Could this be false? ie, $x \mid y$ and $y \mid x$, but $x \neq y$?</li>
  <ul><li>Counterexample: x =?, y = ?</li></ul>
<li>Must it be true? Proof?</li>
</div>
</ul>

# Binary / Octal Hex

Review the notes we didn't get to last time:

* [Octal and Hex](lesson13.html#octal-and-hexadecimal)
* [Binary Arithmetic](lesson13.html#binary-arithmetic)
* [Representing Data](lesson13.html#representing-data)

