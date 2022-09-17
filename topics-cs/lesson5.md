# Topics in Advanced Computing Lesson 5: Verifiers and Reductions
{:.no_toc}

1. Table of Contents
{:toc}

# Verifiers

As we've seen, nondeterminism is tricky to think about. We describe an alternate definition of the class $NP$ using **verifiers**.

**Definition**: Let $X$ be a problem and $V$ a Turing Machine which accepts two inputs. $V$ is called a **verifier** for $X$ if for each $x \in \\{ 0, 1 \\}^*$, both of the following are true:
* $x \in X$ if and only if there is (at least one) $c \in \\{0, 1 \\}^*$ such that when initialized with inputs $(x, c)$, $V$ halts and outputs 1, and,
* if $x \not \in X$, then for every $c \in \\{ 0, 1 \\}^*$, when $V$ is initialized with inputs $(x, c)$, $V$ halts and outputs 0.

The idea is that $c$ is a *certificate*. The verifier $V$ doesn't have to actually solve the problem posed by input $x$, but it should just verify that $c$ witnesses a solution to $x$. If this is a little vague, then consider the following example for the "composites" problem before.

## Example

Consider the following verifier $V$ for checking if a number is composite:

"On input $(x, c)$, where $x$ has length $n$:
1. First check if $c = x$ or if $c = 1$. If so, write a 0 on the output tape and halt. Otherwise, continue to step 3.
3. Check if $x$ is a multiple of $c$.
4. If $x$ is a multiple of $c$, write a $1$ on the output tape and halt.
5. Otherwise, write a $0$ on the output tape and halt."

For example, if $x = 100$, we can let $c = 10$, so $V$ will halt and output 1. But if $x = 7$, no matter which $c$ we pick, $V$ will halt and output 0 because $7$ is prime. Notice that this is basically the same as the "nondeterministic" algorithm above, except without the first $n$ guesses.

## Theorem

**Theorem 1**: A problem $X$ is in $NP$ if and only if it has a verifier which runs in polynomial time.

This is an "if and only if" statement, and so it has two directions: If $X$ has a polynomial time NTM $N$, then it has a has a polynomial time verifier $V$, and vice versa.

Suppose $N$ is a polynomial-time NTM for a problem $X$. Since $N$ is a polynomial time NTM, that means that no matter which nondeterministic choices $N$ makes, its running time is still polynomial. Morever, if $x \in X$, that means that when $N$ runs on input $x$, there is at least one sequence $\vec{v}$ of nondeterministic choices such that $N$ halts in polynomial time on $x$ and outputs 1.

So a verifier for $X$ would work as follows. Use the sequence $\vec{v}$ as your "certificate".

"On input $(x, \vec{v})$:  
1. Simulate $N$ on $x$ using $\vec{v}$ to determine which nondeterministic choices to make.
2. Output whatever $N$ outputs.

**Exercise**: Why does this $V$ run in polynomial time?

Now we show the reverse direction. First we do a warm-up:

**Theorem**: Suppose $V$ is a polynomial-time verifier for $X$, and so its running time is $O(n^k)$ for some $k$. Then for each $x \in X$, the certificate $c$ which works (so that $V$ outputs 1 on input $(x, c)$) must have length at most $n^k$.

Based on this, if we have a verifier $V$ for $X$ that runs in time $O(n^k)$, an NTM for $X$ might work as follows:

"On input $x$:  
1. Non-deterministically guess a string $c$ of length at most $n^k$.
2. Run $V$ on input $(x, c)$, and output whatever it outputs.

**Exercise**: Why does this non-deterministic algorithm work? Why does it run in $O(n^k)$ steps?

# NP Problems

Most problems in NP have similar flavors. "Given some input $x$, check if there is $y$ such that some property is true about $x$ and $y$." In such a case, the "certificate" would be the $y$ that we're checking for. That is: the certificate is a *solution* that we are checking. Here are some examples.

* Given natural numbers $a, b, c$, determine if there are natural numbers $x$ and $y$ such that $ax^2 + by = c$. (What would be the "certificate"?)
* **Independent set**: given a graph $G$ and a natural number $k$, determine if there is a subset of size $k$ of $G$'s verticies that are *independent*: that is, a set of vertices such that none of them have edges with each other.
* **Subset sum**: Given a list of $n$ integers, $x_1, \ldots, x_n$ and a target integer $t$, determine if there is a subset of the integers that adds up to $t$.
* **Factoring**: Given three natural numbers $x$, $L$, $U$, determine if $x$ has a factor $y$ in between $L$ and $U$.
* **Graph isomorphism**: Two graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$ are called *isomorphic* if there is a function $f : V_1 \to V_2$ that is one to one and onto, and, for each $v, w \in V_1$, there is an edge $(v, w) \in E_1$ if and only if $(f(v), f(w)) \in E_2$. For example: <img class="noreverse" alt="Graph with vertices 1, 2, 3, 4 and a graph with vertices a, b, c, d turn out to be the same exact graph" src="https://atharaq.github.io/computability/graph.jpeg" />

**Exercise**: In small groups, pick one of these problems and come up with a polynomial time verifier for the problem. What is the "certificate"? Describe your algorithm for verifying that certificate.

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

## SAT and Integer Programming

Before we study the Cook-Levin theorem, we show some examples of polynomial time reductions. First, we need some definitions:

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

Now let's look at a completely different problem: **integer programming** (IPROG). The integer programming problem asks: given variables $x_1, \ldots, x_n$, and a set of $m$ linear inequalities of the form $a_1x_1 + a_2 x_2 + \ldots + a_n x_n \leq b$ (for some rational numbers $a_1, \ldots, a_n, b$), determine if there is an assignment of integer values for $x_1, \ldots, x_n$ that satisfies the inequalities.

**Theorem**: $SAT \leq_P IPROG$.

Recall: the point of a reduction is to take an instance of SAT and turn it into an instance of IPROG. In other words: given a Boolean formula $\phi$, we should be able to come up with a system of linear inequalities so that $\phi$ is satisfiable if and only if the system of linear inequalities has an integer solution.

**Proof**:

Let $\phi$ be a Boolean formula in CNF with variables $p_1, \ldots, p_n$. We set up the following inequalities:

* $0 \leq p_i \leq 1$ for each $i = 1, \ldots, n$. (This is to make sure that the $p_i$ evalute to either 1/0, or TRUE/FALSE),
* We turn each clause into an inequality with the following rule:
  * If $p_i$ is in a clause, we keep it,
  * If $\lnot p_i$ is in a clause, turn it into $1 - p_i$ (notice that $1 - p_i = 1$ if and only if $p_i = 0$; that is, $1 - p_i$ is TRUE if and only if $p_i$ is FALSE),
  * Then take the sum of the terms in the clause. This sum should be **at least** 1: in other words, $p \vee q$ is true if and only if $p + q \geq 1$.

For example, $(p_1 \vee p_2)$ would turn into $p_1 + p_2 \geq 1$, while $(p_1 \vee \lnot p_2 \vee p_3)$ would turn into $p_1 + (1 -  p_2) + (1 - p_3) \geq 1$.

Now notice the following:

* If we have integers $p_1, \ldots, p_n$ which satisfy these inequalities, then they are each Boolean variables (0 or 1), and satisfy each of the clauses. Therefore they satisfy the conjunction of all the clauses!
* In other words: $\phi$ is satisfiable if and only if the resulting system of inequalities we get is also satisfiable.
* Notice that if $\phi$ has $n$ variables and $m$ clauses, we end up with a system of $m + n$ inequalities.
* Also notice that for each clause, it takes only polynomial time (in the length of the clause) to "rewrite it" as an inequality.
* Therefore it takes only polynomial time to rewrite the entire conjunction as a system of inequalities!

# Upcoming

* Reading: 2.1 - 2.6
* 3SAT and INDSET.
* SAT vs 3SAT
* Cook-Levin Theorem?
* Problem Set 1 due **Thursday**
* Talk 1 starting next week.
