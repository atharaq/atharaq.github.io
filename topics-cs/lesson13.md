# Topics in Advanced Computing Lesson 12: PSPACE-completeness
{:.no_toc}

1. Table of Contents
{:toc}

# Correction

Last time we looked at the recursive algorithm for solving the formula game. We said that if the formula has length $m$ and contains $n$ quantified variables, our algorithm would take $O(mn)$ space. In fact, we can do better:

* For each recursive call, just use **a single extra bit** of memory, corresponding to whether you set the new variables to $1$ or $0$.
* If you have a formula $\phi$, with variables $x_1, \ldots, x_n$ in it, and you have a sequence of $n$ bits, you can, essentially, run the "SAT verifier" algorithm: is $\phi$ true with this sequence of $n$ bits?

In other words: we don't need to copy the *whole* formula over each time.

# Geography Game

A simple two player game for children: players alternate naming cities. Player one picks any city, then player two must respond with a city which starts with the last name of player one's city. Then play continues in this manner:

* Purchase -> Edison -> Newark -> Kalamazoo -> Oxford -> ...

Play continues until one player can no longer name a city. In the *generalized* version of this game, we abstract away the notion of a city and letters to a (directed) graph.

<img src="images/geography_sipser.png" alt="Directed graph with nodes 1-9; Taken from Sipser, Introduction to the Theory of Computation" />

We pick one specific node to act as our "start node". Players alternate picking "next nodes". Let's play this game. Who has a winning strategy (for this graph)?

The **geography game**, in general, asks: given a directed graph $G$ and a designated start node $v$, does player I have a winning strategy in the geography game for $(G, b)$? This game is also PSPACE-complete.

## $GG \in PSPACE$

First we show that the game is in PSPACE. Suppose we are given a directed graph $G$ and a start node $v$. What might our algorithm be? Hint: think recursively, again!

M: On input $(G, v)$:

1. If $v$ has no out-edges, then player I has no initial move, so halt and output **FALSE**.
2. For each $w$ that $v$ points to:
  * Remove $v$ and all edges (in or out of $v$) to get a new graph $G^\prime$.
  * Run $M(G^\prime, w)$. If this outputs **FALSE**, then player II has no winning strategy for the game starting at $w$, so player I will win: output **TRUE**.
  * If it outputs **TRUE**, continue (the for loop).
3. If all of the above output **TRUE**, then player II has a winning strategy, so output **FALSE**.

How much space is required for this algorithm? In the recursion, we again don't need to copy over all of the graph, we just need to keep track of which vertices we have deleted.

**Exercise**: Suppose $G$ has $n$ vertices. How much space does this algorithm require?

## $GG$ is $PSPACE$-hard

Now we show that $FORMULA$-$GAME \leq_P GG$. That is, given a QBF $\phi$, we construct a graph $G$ and designated start vertex $v$ so that $\exists$ has a winning strategy for the formula game for $\phi$ if and only if player I has a winning strategy for the geograph game for $(G, v)$. Moreover, this construction should be done in polynomial time.

First, we make a couple of assumptions:

* Assume that the first and last quantifiers in $\phi$ are both $\exists$.
* Assume that the quantifiers alternate between $\exists$ and $\forall$.
* Assume that, after the block of quantifiers, the formula is in CNF.

This is possible: for example, if $\phi = \exists x_1 \exists x_2 (x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$, we can add in an extra quantifier over a dummy variable, so that we have an equivalent formula: $\theta = \exists x_1 \forall y \exists x_2 (x_1 \vee x_2) \wedge (\lnot x_1 \vee \lnot x_2)$. Then $\theta$ is true if and only if $\phi$ is true, and it only take linear time to make this change.

Given $\phi$, we construct a graph in two stages. First, we build a specific pattern that represents the blocks of alternating quantifiers:

* We start at the top with a node $v$. $v$ should have two edges: a "TRUE" and a "FALSE" edge, representing whether $\exists$ plays $x_1$ is TRUE or FALSE.
* Each of those vertices connect to another vertex below $v$ to make a diamond structure.
* Then this vertex connects to a single vertex below it.
* This then leads into another "diamond" pattern for $x_2$ and then this pattern continues.

If you're following, player I would pick T/F for $x_1$, then player II would be forced to connect the diamond, and I would be forced to lead into the next diamond, allowing II to choose T/F for $x_2$)

After all of these diamonds, the bottom node connects to some fixed node $c$, which will represent the clauses. For each clause $\phi_1, \ldots, \phi_m$, we create corresponding nodes $c_1, \ldots, c_m$, with $c$ having edges to each of these clause nodes.

<img src="https://upload.wikimedia.org/wikipedia/commons/e/eb/Generalized_geography_3.png" alt="Generalized Geography Graph for a formula; via WikiMedia / Sipser" />

For each clause, we create nodes that correspond to each literal in the clause. For example, if $\phi$ is $\exists x_1 \forall x_2 (x_1 \vee x_2) \wedge (x_1 \vee \lnot x_2)$, we would have two clause nodes $c_1$ and $c_2$. $c_1$ would point to two vertices labeled $x_1$ and $x_2$, and $c_2$ would point to two *other* vertices, labeled $x_1$ and $\lnot x_2$. Then we connect each $x_i$ node to the "TRUE" label for $x_i$, and $\lnot x_i$ node to the FALSE label for $x_i$.

**Exercise**: Explain why, if $\exists$ has a winning strategy, then Player I has a winning strategy in this game, and vice versa.

# Oracles

We already have one way of when a problem is "easier than" another: namely $\leq_P$, polynomial-time reductions. There is another concept from computability theory that captures a similar notion: oracles.

An **oracle** for a problem $X$ is a function which, on input $x$, returns 1 if $x \in X$ and 0 otherwise. We ignore the computational complexity of an oracle: just treat it like a black box, or pretend that it takes only one step to make that function call. An **oracle machine** is a Turing Machine which is augmented by an oracle. That is, at any given step, it could ask if the string on its tape is in the problem for which it has an oracle.

**Example**: If we have an oracle for $SAT$, then we can solve $TAUT$ in polynomial-time. To see this, suppose $\phi$ is a formula. Then $\phi$ is a tautology if and only if $\lnot \phi$ is not satisfiable. So first check if $\lnot \phi \in SAT$: if it is, output FALSE, if not, output TRUE!

**Definition**: The class $P^{NP}$ is the class of all those problems which are solvable in polynomial-time with an oracle for some NP-complete problem (for example, for SAT). More generally, if $A$ is any class, then:

* $P^A$ is the class of those problems solvable in polynomial time with an oracle for some $A$-complete problem,
* $NP^A$ is the class of those problems solvable in non-deterministic polynomial time with an oracle for some $A$-complete problem, and
* co-$NP^A$ is the class of those problems whose complements are in $NP^A$.

The example shows that $P^{NP}$ contains the class co-NP, since TAUT is co-NP-complete. It's also clear that $P^{NP}$ contains both $P$ and $NP$. It's an open question whether this class is simply equal to just P or to NP: the conjecture is that it is different. But moreover, we can use oracles to build a kind of hierarchy of complexity classes in exactly this way.

**Definition** (Polynomial Time Hierarchy) Set $\Sigma^P_0 = \Pi^P_0 = \Delta^P_0 = P$. This is the base class of the hierarchy. Then, for each $i \geq 0$:

* $\Sigma^P_{i+1} = NP^{\Sigma^P_i}$,
* $\Pi^P_{i+1}$ = co-$NP^{\Sigma^P_i}$, and,
* $\Delta^P_{i+1} = P^{\Sigma^P_i}$.

Notice that $\Sigma^P_1 = NP$ and $\Pi^P_1 =$ co-NP. We have the following inclusions:

<img src="https://upload.wikimedia.org/wikipedia/commons/9/9e/Polynomial_time_hierarchy.svg" alt="Image depicting the inclusions in the polynomial time hierarchy." />

In particular, we have $\Sigma^P_i \subseteq \Delta^P_{i+1} \subseteq \Sigma^P_{i+1}$, and $\Pi^P_i \subseteq \Delta^P_{i+1} \subseteq \Pi^P_{i+1}$ for each $i$.

**Open question**: Is there a level $k$ such that $\Sigma^P_k = \Sigma^P_{k+1}$? In particular, is there a level $k$ so that the entire polynomial hierarchy is contained in $\Sigma^P_k$?

(The conjecture is that there is no such level, that there are always "harder" problems each level up.)

We will study:

* Alternate definitions of the polynomial hierarchy.
* Theorem: $PH \subseteq PSPACE$.
* Conjecture: $PH \neq PSPACE$.

# Upcoming

* Paper due next week (3-5 pages)
* PS 3 will be given out next week, due the following week (11/17).
* Guest speaker 11/21.
* Presentation 3 will be after Thanksgiving
* PS 4 and Final Paper due last week of classes / finals week.
