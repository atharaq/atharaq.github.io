# Topics in Advanced Computing Lesson 12: PSPACE-completeness
{:.no_toc}

1. Table of Contents
{:toc}

# Complexity Theory as Games

* Generalized versions of "one-player" games like Super Mario, Donkey Kong, etc are NP-hard! See: [Aloupis, Demaine, Guo](https://arxiv.org/abs/1203.1895)
  * [PDF version of the paper](https://arxiv.org/pdf/1203.1895.pdf)
  * [HTML5 version of the paper](https://ar5iv.labs.arxiv.org/html/1203.1895)
* P captures short "zero-player" games: Conway's game of life.
* PSPACE captures "two player games" with perfect information!

# Games and PSPACE Completeness

A two-player game with perfect information is a game in which two players alternate taking moves, with each player knowing all the moves that came before. Let's describe a logic game, called the **formula game**.

We know what a Boolean formula $\phi(x_1, \ldots, x_n)$ is. Now let's add in **quantifiers**. The quantifier $\forall$ is read "for all", and $\exists$ is read "there exists". For example, the formula $\forall x_1 \exists x_2 (x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$ means: "For every value of $x_1$, there is some value of $x_2$ such that either $x_1$ or $x_2$ is TRUE **and** either $x_1$ or $x_2$ is FALSE." This is now a **statement**: it has a truth value! Is it true or false?

* Suppose $x_1$ is TRUE. Then $(x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$ can be made true if $x_2$ is FALSE.
* Suppose $x_1$ is FALSE. Then $(x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$ can be made true if $x_2$ is TRUE.

So $\forall x_1 \exists x_2 (x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$ is TRUE!

**Definition**: A **quantified boolean formula** (QBF) is a Boolean formula $\phi(x_1, \ldots, x_n)$ with a block of quantifiers for each of the $x_i$'s at the beginning.

For example, $\forall x_1 (x_1 \vee x_2)$ is not a QBF, but $\forall x_1 \forall x_2 (x_1 \vee x_2)$ is.

Now let's describe the **formula game**. The two players are "Abelard" and "Eloise", denoted $\forall$ and $\exists$, respectively. Given a QBF $\phi$, we take turns: at stage $i$, player $\forall$ goes if $x_i$ is quantified by a $\forall$, and $\exists$ goes if $x_i$ is quantified by $\exists$. (Makes sense, right?) Each player plays either TRUE or FALSE (or 0 or 1 if you prefer).

If there are $n$ variables in $\phi$, then the game lasts for $n$ rounds. At the end of the game, $\forall$ wins if the formula ends up evaluating to FALSE, and $\exists$ wins if the formula evaluates to TRUE.

We say that a player has a **winning strategy** in a game if there is a function that, for each possible state of the game, picks out a valid move in such a way that if a player follows this strategy, they will always win.

**Example**: Let $\phi$ be the formula $\forall x \exists y (x \wedge \lnot y) \vee (\lnot x \wedge y)$.

1. Suppose $\forall$ plays $x = 0$. What would you play for $y$?
2. Suppose $\forall$ plays $x = 1$. What would you play for $y$?
3. Does either player have a winning strategy for the formula game for $\phi$?

**Claim**: A quantified Boolean Formula $\phi$ is true if and only if $\exists$ has a winning strategy in the formula game for $\phi$.

We show this for statements which have two variables, but the general proof is similar. If $\phi$ has two variables $x$ and $y$, then $\phi$ could look like one of the following:

* $\forall x \exists y \psi(x, y)$
* $\exists x \forall y \psi(x, y)$
* $\exists x \exists y \psi(x, y)$
* $\forall x \forall y \psi(x, y)$

Where $\psi(x, y)$ is a propositional formula with variables $x$ and $y$.

Let's just look at the first case. $\phi = \forall x \exists y \psi(x, y)$. If $\exists$ has a winning strategy, then if $\forall$ plays TRUE, $\exists$ can play some $y$ according to her strategy so that $\psi(x, y)$ is true. If $\forall$ plays FALSE, then $\exists$ still can play some $y$ so that $\psi(x, y)$ is true.

Conversely, if the statement is true, then for each $x$, there is some $y$ so that $\psi(x, y)$ is true. That means, the winning strategy for $\exists$ is the following: if $x = 0$, pick $y$ so that $\psi(0, y)$ is true, and if $x = 1$, pick $y$ so that $\psi(1, y)$ is true. $\forall$ would have no winning strategy here: no matter what $\forall$ plays, $\exists$ can counter with something to make $\phi$ true. That's the nature of what $\forall x \exists y \psi(x, y) = TRUE$ means!

**Theorem**: The "Formula Game" is PSPACE-complete.

What does this mean? First, by the "Formula Game", we mean: "Given a QBF $\phi$, does $\exists$ have a winning strategy?" Or: "On input $\phi$, determine if $\exists$ has a winning strategy." This problem is PSPACE-complete.

**Definition**: $X$ is PSPACE-complete if $X \in PSPACE$ and whenever $A \in PSPACE$, $A \leq_P X$.

We will only show that this game is in PSPACE. The proof that it is PSPACE-hard is involved, in a similar manner to the proof of the Cook-Levin Theorem.

So why is the formula game in PSPACE? One can determine if a QBF is true using polynomial space. We describe an algorithm $M$ as follows:

"On input $\phi$:

1. If $\phi$ contains no quantifiers, then it only has constants (no variables), so we can just evaluate it. Return TRUE or FALSE based on the value of $\phi$.
2. If $\phi = \exists x \psi$, then recursively run $M(\psi[0])$ and $M(\psi[1])$. That is, run $M$ on input $\psi$ where we replace $x$ by 0 everywhere, and then again when we replace $x$ by 1 everywhere. If either return TRUE, then return TRUE. Otherwise return FALSE.
3. If $\phi = \forall x \psi$, then recursively run $M(\psi[0])$ and $M(\psi[1])$. If both return TRUE, then return TRUE. Otherwise return FALSE."

Another way to think of this: turn $\exists x \psi$ into $\psi(0) \vee \psi(1)$, and turn $\forall x \psi$ into $\psi(0) \wedge \psi(1)$. Recursively check each of these subformulas, erasing the extra memory used when we are done using it. If $\phi$ has $m$ variables, then we only need to store, at most, $m$ additional bits to figure out what assignment we are using. So this problem is solvable in polynomial space in terms of the length of $\phi$!

# Geography Game

A simple two player game for children: players alternate naming cities. Player one picks any city, then player two must respond with a city which starts with the last name of player one's city. Then play continues in this manner:

* Purchase -> Edison -> Newark -> Kalamazoo -> Oxford -> ...

Play continues until one player can no longer name a city. In the *generalized* version of this game, we abstract away the notion of a city and letters to a (directed) graph.

<img src="images/geography_sipser.png" alt="Directed graph with nodes 1-9; Taken from Sipser, Introduction to the Theory of Computation" />

We pick one specific node to act as our "start node". Players alternate picking "next nodes". Let's play this game. Who has a winning strategy (for this graph)?

The **geography game**, in general, asks: given a directed graph $G$ and a designated start node $v$, does player I have a winning strategy in the geography game for $(G, b)$? This game is also PSPACE-complete, which we will see next time.

# Upcoming

* Presentations this week and next week.
* Midterm paper due November 10 (3-5 pages)
  * Go in depth on one topic that you covered in the overview and/or in the second presentation. Try to explain how that works.
  * Rubric is posted on Moodle: 2 points for grammar / tone; 4 for background / motivation; 4 for depth.
