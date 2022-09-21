# Topics in Advanced Computing Lesson 6: Reductions
{:.no_toc}

1. Table of Contents
{:toc}

# Warm up

In small groups, pick one of the following problems and show that they are in NP:

* **Independent set**: given a graph $G$ and a natural number $k$, determine if there is a subset of size $k$ of $G$'s verticies that are *independent*: that is, a set of vertices such that none of them have edges with each other.
* **Graph isomorphism**: Two graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$ are called *isomorphic* if there is a function $f : V_1 \to V_2$ that is one to one and onto, and, for each $v, w \in V_1$, there is an edge $(v, w) \in E_1$ if and only if $(f(v), f(w)) \in E_2$. For example: <img class="noreverse" alt="Graph with vertices 1, 2, 3, 4 and a graph with vertices a, b, c, d turn out to be the same exact graph" src="https://atharaq.github.io/computability/graph.jpeg" /> The graph isomorphism problem asks: given (the adjacency matrices for) two graphs $G_1$ and $G_2$, determine if the graphs are isomorphic.
* **Integer Programming**: Given a list of $m$ linear inequalities over the $n$ variables $x_1, \ldots, x_n$, determine if there is an assignment of integers values to $x_1, \ldots, x_n$ that satisfies all $m$ inequalities.
* **Vertex cover**: Given a graph $G$ and an integer $k$, determine if there is a subset $S$ of the vertices of size at most $k$ such that each edge in $G$ has at least one of its endpoints in $S$.

# Problem Set Questions?

# Exponential Time

**Definition**: $EXP$ is the class of all problems solvable in $DTIME(O(2^{n^k}))$ for some $k \in \mathbb{N}$. These are the class of problems solvable in **exponential time**.

**Theorem 2**: If a problem $X$ is in class $NP$, then it is in class $EXP$.

It is, again, unknown, whether the reverse implication is true or not. That is, the following is an **open question**: is there a problem solvable in exponential time which is not verifiable in polynomial time?

**Proof**: We suppose $X$ has a polynomial time verifier $V$. That is, there is an integer $k$ such that for each input $x$ of length $n$:

* if $x \in X$, there is some string $c$ such that on input $(x, c)$, $V$ halts and outputs $1$ in time $O(n^k)$, and,
* if $x \not \in X$, then for any string $c$, on input $(x, c)$, $V$ halts and outputs $0$ in time $O(n^k)$.

Notice again that if $x \in X$ has length $n$, the string $c$ that works must have length at most $n^k$ (technically $O(n^k)$). We describe a deterministic algorithm that solves $X$ in time $O(2^{n^k})$:

"On input $x$ of length $n$:
1. For each string $c$ of length at most $n^k$, run $V$ on input $(x, c)$.
  * If $V$ outputs $1$, then output 1.
  * If it outputs $0$, then continue on to the next string $c$.
2. If $V$ outputted $0$ for every string we checked, then output $0$."

So far, we have the following relationships: $P \subseteq NP \subseteq EXP$. That is: every problem solvable in polynomial time is verifiable in polynomial time, and every problem verifiable in polynomial time is solvable in exponential time.

* $P \subseteq NP$ was mentioned briefly last time, and will probably be a homework exercise at some point.
* $NP \subseteq EXP$ is Theorem 2 above.

Later on, we will see (using the "Time Hierarchy Theorem") that $P \neq EXP$. That means, based on the above, either $P \neq NP$ or $NP \neq EXP$ (or both: it's possible that $P \subsetneq NP$ and $NP \subsetneq EXP$).

# Reductions

Our main tool for studying complexity theory is called a **reduction**. The idea is that instead of solving a hard problem $A$, we "reduce" it to an already solved problem $B$. Then we know that solving $A$ is no harder than solving $B$. If we keep track of how long it takes to do the reduction, we can measure complexity-theoretic relationships.

**Definition**: Let $A$ and $B$ be problems.

1. We say that a problem $A$ is **polynomial-time reducible** to $B$, denoted $A \leq_P B$, if there is a polynomial-time computable function $f$ such that for each input $x$, $x \in A$ if and only if $f(x) \in B$.
2. We say $B$ is **NP-hard** if $A \leq_P B$ for each $A \in NP$.
3. We say $B$ is **NP-complete** if $B$ is NP-hard and $B \in NP$.

In some sense: NP-complete problems would be the "hardest" problems in NP. It's surprising, but there is a result (the Cook-Levin Theorem) that says that there are NP-complete problems!

**Theorem**:
1. If $A \leq_P B$ and $B \leq_P C$, then $A \leq_P C$. ($\leq_P$ is transitive).
2. If $A$ is NP-hard, and $A \in P$, then $P = NP$.
3. If $A$ is NP-complete, then $A \in P$ if and only if $P = NP$.
4. If $A$ is NP-hard and $A \leq_P B$, then $B$ is NP-hard.

(Proofs are all exercises. Some might be on a future problem set.)

## Vertex Cover vs Integer Programming

Before we study the Cook-Levin theorem, we show some examples of polynomial time reductions. First, we need some definitions:

**Theorem**: $VERTEX-COVER \leq_P IPROG$. That is, there is a polynomial time algorithm which, given a graph $G$ and integer $k$, outputs a system of inequalities which has a solution if and only if the original graph had a vertex cover of size $k$.

Suppose $G = (V, E)$ is our graph and $k$ is the size of the vertex cover we want. The idea is that for each vertex $v \in V$, we associate a variable $x_v$. We set up the inequalities $0 \leq x_v \leq 1$, so that each $x_v$ is either $0$ or $1$. Then we come up with more inequalities that add in the constraints that say:

* If there is an edge between $v$ and $w$, then at least one of $x_v$ or $x_w$ must be 1.
* No more than $k$ of the $x_v$ can be $1$.

If we are able to successfully come up with these inequalities, then any solution $x_1, \ldots, x_n$ to this system of inequalities will encode a set: the set $S = \\{ v \in V : x_v = 1 \\}$ will be our vertex cover! To see this:

* Since no more than $k$ of the $x_v$ is 1, $S$ has size at most $k$.
* Since, for each edge $(v, w)$, at least one of $x_v$ or $x_w$ is equal to 1, then at least one of $v$ or $w$ is in $S$.

So how we do we express these two conditions as inequalities?

1. For each edge $(v, w) \in E$, we put the inequality $x_v + x_w \geq 1$ in our system. (Notice that if $x_v$ and $x_w$ are both either 0 or 1, then the only way for this inequality to fail to hold is if $x_v = x_w = 0$; this is what we're trying to avoid.)
2. Lastly, add in the inequality $\sum\limits_{v \in V} x_v \leq k$. Again, since each of the variables is either 0 or 1, the only way to get higher than $k$ is if more than $k$ of them are set equal to 1.

This means that if one can solve the integer programming problem in polynomial time, then one can also solve the vertex cover problem in polynomial time!

(**Note**: Both of these problems are known to be **NP-complete**.)

## SAT and Integer Programming

**Definition**: A **propositional variable** is a variable which can be either true or false (boolean). A **Boolean formula** over propositional variables $p_1, \ldots, p_n$ is either:
* A variable,
* A negation of a smaller formula: $(\lnot \psi)$,
* a conjunction of two smaller formulas: $(\phi \wedge \psi)$, or
* a disjunction of two smaller formulas: $(\phi \vee \psi)$.

(This is an "inductive definition".)

If $\phi$ is a Boolean formula over variables $p_1, \ldots, p_n$, an **assignment** to $\phi$ is a binary sequence of length $n$ (that is, a sequence of $n$ bits). If $\phi$ is a formula over variables $p_1, \ldots, p_n$, and $z$ is an assignment to $\phi$, then $\phi(z)$ is the value of $\phi$ when the variables $p_1, \ldots, p_n$ are replaced by the respective bits of $z$ (where $1$ denotes TRUE and $0$ denotes FALSE). To evaluate these, we use the basic truth tables:

* $\lnot p$ is true if $p$ is false.
* $p \wedge q$ is true if **both** $p$ and $q$ are true.
* $p \vee q$ is true if **at least one** of $p$ or $q$ is true.

For example: let $\phi = (p_1 \vee p_2 \vee \lnot p_3) \wedge (\lnot p_1 \vee \lnot p_2 \vee \lnot p_3)$.

* $\phi(0, 0, 0)$ is true, since "FALSE or FALSE or not FALSE" is true, and "not FALSE or not FALSE or not FALSE" is also true.
* $\phi(1, 1, 1)$ is false, since the second conjunct is "not TRUE or not TRUE or not TRUE", which is false.

A formula $\phI$ is called **satisfiable** if there is an assignment $z$ to $\phi$ such that $\phi(z)$ evaluates to true.

**Definition**: A formula is is **conjunctive normal form** (CNF) is it is a conjunction of disjunctions.

For example: $p_1 \vee (p_2 \wedge p_3)$ is not in CNF, but $(p_1 \vee p_2) \wedge (p_1 \vee p_3)$ is. We refer to each conjunct as a *clause*. So for example, $(p_1 \vee p_2) \wedge (p_1 \vee p_3)$ has two clauses.

**Definition**: SAT is the problem: given a Boolean formula $\phi$ with variables $p_1, \ldots, p_n$ in CNF, determine if there is a satisfying assignment $z$ to $\phi$.

**Exercise**: Show that $SAT \in NP$. (What's the certificate?)

**Theorem**: $SAT \leq_P IPROG$.

Recall: the point of a reduction is to take an instance of SAT and turn it into an instance of IPROG. In other words: given a Boolean formula $\phi$, we should be able to come up with a system of linear inequalities so that $\phi$ is satisfiable if and only if the system of linear inequalities has an integer solution.

**Proof**:

Let $\phi$ be a Boolean formula in CNF with variables $p_1, \ldots, p_n$. Similar to our previous example, we set up a system of inequalities. First, for each propositional variable $p_i$, we associate an integer variable $x_i$ and put in the inequality $0 \leq x_i \leq 1$ for each $i$. The idea is that $x_i = 0$ means $p_i$ is FALSE, and $x_i = 1$ means $p_i$ is TRUE.

Next, we turn each clause into an inequality with the following rule:
  * If $p_i$ is in a clause, we keep it as $x_i$,
  * If $\lnot p_i$ is in a clause, turn it into $1 - x_i$ (notice that $1 - x_i = 1$ if and only if $x_i = 0$; that is, $1 - x_i = 1$ if and only if $p_i$ is FALSE),
  * Then take the sum of the terms in the clause. This sum should be **at least** 1: in other words, $p_i \vee p_j$ is true if and only if $x_i + x_j \geq 1$.

For example, $(p_1 \vee p_2)$ would turn into $x_1 + x_2 \geq 1$, while $(p_1 \vee \lnot p_2 \vee p_3)$ would turn into $x_1 + (1 -  x_2) + (1 - x_3) \geq 1$.

Now notice the following:

* If we have integers $x_1, \ldots, x_n$ which satisfy these inequalities, then setting $p_i$ to be TRUE if and only if $x_i = 1$, the assignment for the $p_i$'s satisfies each of the clauses. Therefore this assignment satisfies the conjunction of all the clauses!
* In other words: $\phi$ is satisfiable if and only if the resulting system of inequalities we get is also satisfiable.
* Notice that if $\phi$ has $n$ variables and $m$ clauses, we end up with a system of $m + n$ inequalities.
* Also notice that for each clause, it takes only polynomial time (in the length of the clause) to "rewrite it" as an inequality.
* Therefore it takes only polynomial time to rewrite the entire conjunction as a system of inequalities!

# Upcoming

* Presentation 1 over the next two weeks.
  * Schedule is on Moodle.
  * Meet with me before your presentations!
* If time: Cook-Levin Theorem: SAT and 3SAT: both are NP-complete! (Therefore: IPROG is NP-complete)
