# Topics in Advanced Computing Lesson 7: Cook-Levin Theorem
{:.no_toc}

1. Table of Contents
{:toc}

# SAT is NP-Complete

My favorite explanation of this result appears online on Wikipedia: [Cook-Levin Theorem Proof](https://en.wikipedia.org/wiki/Cook%E2%80%93Levin_theorem#Proof). We will follow this treatment.

**Theorem**: SAT is NP-hard.

**Proof**:

Let $A$ be any problem in NP. Then there is a nondeterministic Turing Machine $N$ which runs in $O(p(n))$ steps for some polynomial $p(n)$. Recall that a Turing Machine has finitely many **states** (we will refer to the set of these states as $Q$), a **tape** (perhaps more than one, but we will assume one tape), and some **rules**. Since $N$ is nondeterministic, the rules are allowed to be nondeterministic: that is, at some state $s$, seeing some symbol $a$ on the tape, $N$ specifies a set of possible "next moves", without determining exactly which one it will go to.

On input $x$, $N$'s tape is initialized with $x$ written on it and blanks in all the cells after the end of $x$. Then $N$ runs by starting in its start state $s$, with its read-write head initialized at the beginning of the tape (call that position $0$), looking at the first symbol of $x$. Based on that state and the symbol, $N$ looks up the possible "next moves" which it can take. A possible "move" involves three things:

* Writing something to the current cell,
* Move the read-write head left or right on the tape (cannot move left past the beginning, but that's a technical condition), and
* Switching to a new state $q$.

So computation for $N$ on input $x$ is, essentially, a sequence of these valid moves, ending when we get to a $q_{halt}$ state. At each step, we need to keep track of:

* which state we are in
* what cell the read-write head is looking at, and
* what the current contents of the tape are.

If $x$ has size $n$, then by the definition of running time, no matter which choices of possible "next moves" we make at each step, we end up in $q_{halt}$ after at most $p(n)$ steps. Notice that that means that we cannot get past cell $p(n)$ on the tape. If $x \in A$, then there is some possible sequence of valid moves that can be made that ends up in the halting state with the TM outputting 1. And if $x \not \in A$, no matter what possible sequence of valid moves we make, we end up in the halting state with the TM outputting 0.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/CookLevin_svg.svg/1599px-CookLevin_svg.svg.png" alt="A tabular view of computation on N" />

We make a slight modification to the above: instead of outputting the contents of the tape when we get to $q_{halt}$, we assume our machine has two special states: $q_{yes}$ and $q_{no}$. If we ever get to $q_{yes}$, the machine immediately stops running and outputs $1$, and if we get to $q_{no}$, it stops running and outputs $0$.

So again, suppose we have $N$ an NTM solving $A$ in nondeterministic $p(n)$ time. Given input $x$, we build a Boolean formula $\phi$ so that $N$ has an accepting computation on $x$ if and only if $\phi$ has a satisfying assignment.

First, we need a large set of variables:

* For each $0 \leq j < p(n)$, and for each state $q$, we need a variable $Q_{q, j}$ which should be true if, at step $j$ the TM is in state $q$,
* For each $0 \leq i < p(n)$ and $0 \leq j < p(n)$, we need a variable $H_{i, j}$ which should be true if, at step $j$, the read/write head of the TM is pointed to cell $i$ of the tape, and
* For each $0 \leq i < p(n)$, $0 \leq j < p(n)$ and for each symbol $a$ that is allowed to be written to the tape, we need a variable $T_{i, j, a}$ which is true if at step $j$, the symbol $a$ is written on the tape in cell $i$.

**Exercise**: In terms of Big Oh, how many variables do we need?

The formula is a conjunction of several clauses.

**Initial Clauses**: First, we need to specify what computation looks like initially:

* Start state: If $s$ is the start state, we need $Q_{s, 0}$ as a clause (states that at step $0$, the TM is in state $s$, the start state).
* Tape: Let $x = x_0 x_1 \ldots x_{n-1}$, where each $x_i$ is a single bit. Then we need, for each $0 \leq i < n$, $T_{i, 0, x_i}$ (states that the tape cell at position $i$ has $x_i$ written on it at step 0).
  * For $n \leq i < p(n)$, we also need $T_{i, 0, \sqcup}$ (stating that all cells past the input have a blank / space written on it).
* Position: $H_{0, 0}$ (states that the read/write is initially in cell 0).

**Exclusive Clauses**: Next, we need some clauses stating that we aren't in more than one state or have more than one thing written on the tape at any given time:

* State: For any two states $q \neq q^\prime$ and each $0 \leq j < p(n)$, we need the clause $\lnot Q_{q, j} \vee \lnot Q_{q^\prime, j}$ (states that we are not in more than one state at a time)
* Tape: We need three clauses for the tape:
  * For each $0 \leq i < p(n)$, $0 \leq j < p(n)$ and symbols $a \neq a^\prime$, we need $\lnot T_{i, j, a} \vee \lnot T_{i, j, a^\prime}$ (states that we don't have more than one symbol on the tape at once)
  * We need a clause asserting the only way for the contents of cell $i$ to change from step $j$ to $j + 1$ is if the read-write head was looking at it: for each $i$, $j$, and $a \neq a^\prime$, $T_{i, j, a} \wedge T_{i, j+1, a^\prime} \rightarrow H_{i, j}$,
* Position: For any two cells $0 \leq i < i^\prime < p(n)$ and any step $0 \leq j < p(n)$, we need the clause $\lnot H_{i, j} \vee \lnot H_{i^\prime, j}$ (states that the read/write head does not point to more than one cell at a time)

**Transition Clauses**: By "transitions", we mean the "rules" that transition the machine from one step to the next. How are transitions specified? Essentially we have a function $\delta$ which, given a state $q$ and a symbol $a$, outputs a set of possible triples $(q^\prime, a^\prime, d)$, where $q^\prime$ is the state that you can go to, $a^\prime$ is the symbol that can be written on the tape, and $d$ is either $+1$ or $-1$, meaning you can go to the right one cell (+1), or to the left one cell (-1).

So then, for each cell $0 \leq i < p(n)$, step $0 \leq j < p(n)$, state $q$ and symbol $a$, we need the following clause:

$$(H_{i, j} \wedge Q_{q, j} \wedge T_{i, j, a}) \rightarrow \bigvee\limits_{(q^\prime, a^\prime, d) \in \delta(q, a)} (H_{i + d, j+1} \wedge Q_{q^\prime, j + 1} \wedge T_{i + d, j + 1, a^\prime})$$

This asserts that if at step $j$, $N$ is in state $q$, the read-write head is in position $i$, and an $a$ is written on the tape, then at least one of the possible "next moves" happens.

**Finishing Clause**: We need to assert that there is some step $0 \leq j < p(n)$ such that we end up in $q_{yes}$. That is:

$$\bigvee\limits_{0 \leq j < p(n)} Q_{q_{yes}, j}$$

Our formula $\phi$ will be the conjunction of all the clauses listed above.

**Exercise**: How long (in terms of Big Oh) is the formula?

**Claim 1**: Suppose on input $x$, $N$ has an accepting computation. Then there are assignments to all the variables $Q_{q, j}$, $H_{i, j}$ and $T_{i, j, a}$ that satisfies the formula above.

**Claim 2**: Suppose $\phi$ has a satisfying assignment. Then $N$ has an accepting computation.

Do you see why?

## Corollary

Recall that we have already seen that $SAT \leq_P IPROG$. This means that if the integer programming problem has a polynomial time solution, then $SAT$ does as well. Therefore, if $IPROG \in P$, then $P = NP$, and so $IPROG$ is also NP-complete!

# CLIQUE is NP-Complete

Given a graph $G$ and a number $k$, a $k$-clique is a subset of vertices of size $k$ which are all connected to one another. For example the following graph has a 3-clique:

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/6n-graf-clique.svg/2560px-6n-graf-clique.svg.png" alt="Graph with vertices 1-6, with edges (1, 2), (2, 3), (3, 4), (4, 5), (4, 6), and (1, 5)" />

The problem $CLIQUE$ is, given a graph $G$ and a number $k$, determine if $G$ contains a $k$-clique.

**Theorem**: $CLIQUE \in NP$.

(Exercise).

The problem **3-SAT** is similar to SAT but all the clauses for the input formula are required to have at most 3 literals in them. 3-SAT is known to be NP-complete as there is a simple algorithm which reduces SAT to 3-SAT. We will not go over this now.

**Theorem**: $3-SAT \leq_P CLIQUE$.

**Proof**:

Suppose $\phi(p_1, \ldots, p_n)$ is a formula with $n$ variables and $m$ clauses. We build a graph $G$ with $m$ groups of triples (three vertices); the triples correspond to the clauses of $\phi$. For example, if we have a clause $p_1 \vee p_1 \vee \lnot p_2$, we put three nodes labeled $p_1$, $p_1$ and $\lnot p_2$ in our graph.

We put edges between all vertices except if they are in the same triple (if they correspond to two literals from the same clause), or if they are contradictory (if one corresponds to $p$ and one to $\lnot p$, for some variable $p$).

For example, if we start with the formula $$(p_1 \vee p_2 \vee \lnot p_3) \wedge (\lnot p_1 \vee \lnot p_2 \vee \lnot p_3) \wedge (p_1 \vee p_1 \vee \lnot p_2)$$ we get a graph with 9 vertices (3 triples). A satisfying assignment for $\phi$ would correspond to a 3-clique in this graph.

<img class="noreverse" src="images/reduction.jpeg" alt="Example of a formula and the corresponding graph" />

**Claim**: $\phi$ is satisfiable if and only if $G$ has an $m$-clique.
