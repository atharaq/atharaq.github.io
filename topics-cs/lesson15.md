# Topics in Advanced Computing Lesson 15: Polynomial Hierarchy
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up: Circuits

A Boolean circuit is a collection of gates (ANDs, ORs, and NOTs) and inputs connected by wires. There is one special gate called the *output gate*. There may be several *input gates* $x_1, \ldots, x_n$. A Boolean circuit computes a kind of function $f : \\{ 0, 1 \\}^n \to \\{0, 1\\}$.

Consider the problem of **circuit minimization**: given a circuit $A$ and a number $k$, determine if there is a circuit $B$ which computes the same function as $A$ and uses at most $k$ gates.

Show that this is in $\Sigma^P_2$. Use the definition that $\Sigma^P_2 = NP^{NP}$. That is: come up with an algorithm $M$, such that if $A$ is a circuit with $n$ inputs, $k$ is a number and $B$ is another circuit (which will be the certificate), we can check that $B$ uses at most $k$ gates and, using an oracle (which oracle?) check that for all inputs $x_1, \ldots, x_n$, $A(x_1, \ldots, x_n) = B(x_1, \ldots, x_n)$.

# PSPACE vs PH

**Definition**: We saw the polynomial hierarchy last time. $PH$ ("Polynomial Hierarchy") is the set of all problems that appear anywhere on the polynomial hierarchy.

**Theorem 1**: $PH \subseteq PSPACE$.

**Proof**: Let's just show that $\Sigma^P_2 \subseteq PSPACE$. Recall the logical definition of $\Sigma^P_2$: $X \in \Sigma^P_2$ if there is a polynomial time machine $M$ and a polynomial $q(n)$ such that for each $x$ of length $n$, $x \in X$ if and only if $\exists y_1 \in \\{0, 1 \\}^{q(n)} \forall y_2 \in \\{ 0, 1 \\}^{q(n)} M(x, y_1, y_2) = 1$.

Using this, we should be able to design an algorithm which runs using at most polynomial space and solves $X$.

"On input $x$ of length $n$:

1. For each $y_1$ of length at most $q(n)$:
   * For each $y_2$ of length at most $q(n)$:
     * Check if $M(x, y_1, y_2) = 1$. If so, continue this loop (look at the next $y_2$).
     * If not, go back to the original (outer) loop and look at the next possible $y_1$.
   * If we get here, then we have checked all the $y_2$'s for this $y_1$, and $M(x, y_1, y_2) = 1$ always. So output 1.
2. If we get here, then we have checked every $y_1$, and for each one, we have found a $y_2$ where $M(x, y_1, y_2) = 0$. So there is no single $y_1$ that works for all $y_2$, so we output 0."

**Exercise**: Explain why this only takes $O(q(n))$ space.

**Lemma**: Suppose $X \in \Sigma^P_n$ and $Y \leq_P X$. Then $Y \in \Sigma^P_n$.

The intuition here is that $Y$ is *easier* than $X$. Can we formalize this?

**Proof**: Since $X \in \Sigma^P_n$, then $X$ is verifiable in polynomial time with an oracle for some $\Sigma^P_{n-1}$-complete problem $A$. Let's call this verifier $V$: $V$ runs in polynomial time, on input $x$ with a certificate $c$, and uses the oracle $A$. If $Y \leq_P X$, then there is a function $f$, computable in polynomial time, which reduces $Y$ to $X$. So let's also verify $Y$ using $A$:

"On input $x$, with certificate $c$:
1. Compute $f(x)$.
2. Run $V(f(x), c)$ and output whatever it outputs."

Remember that $x \in Y$ if and only if $f(x) \in X$. Since $V$ is a verifier for $X$, then if $f(x) \in X$, there is some certificate $c$ such that $V(f(x), c) = 1$. So if $x \in Y$, there is a certificate $c$ such that the above algorithm outputs 1, and if not, for every certificate $c$, the above algorithm outputs 0.

Moreover, if $V$ runs in polynomial time $p(n)$, and $f(x)$ runs in polynomial time $q(n)$, then the above algorithm runs in $q(n) + p(q(n))$ steps, which is $O(p(q(n)))$, which is still polynomial time.

**Theorem 2**: If $PH = PSPACE$, then there is a level $n$ such that $PH = \Sigma^P_n$.

**Proof**: If $PSPACE = PH$, then the Formula Game is in $PH$ somwhere. Suppose this problem is in $\Sigma^P_n$. Since this problem is $PSPACE$-complete, then any problem in $PSPACE$ (and therefore any problem in $PH$) is reducible to this game. By the above lemma, each problem in $PH$ then is in $\Sigma^P_n$!

# Randomized Computation

We will now study complexity classes given by *randomized* algorithms. First we will need to define *probabilistic* Turing Machines, and then we will define a complexity class that corresponds to polynomial time probabilistic algorithms. These kinds of algorithms, if we were to try to produce one in real life, would require some sort of true random number generator. It is open whether any actually exist, but actually this will lead us into another complexity class I wish to discuss later in the semester: *quantum* algorithms.

Consider a *nondeterministic TM* $N$. Instead of saying that, for an input $w$, $N(w) = 1$ if there is *some* sequence of nondeterministic choices it can make resulting, eventually, in an output of 1, we can instead think of the nondeterministic machine as making its choices randomly. Then instead of saying that $N(w) = 1$, or $N(w) = 0$, we can assign a probability that $N(w) = 1$ and a probability that $N(w) = 0$.

In other words, the probability that $N(w) = 1$ is, roughly, the fraction of possible computations that $N$ can make which result in an output of 1.

Next time we will look at an example of a randomized algorithm which checks if a number is prime. This algorithm will have the following properties:

* It runs in polynomial time in terms of the *length* of the input $x$,
* If $x$ is a prime number, then the algorithm outputs TRUE with probability 1, and
* If $x$ is composite, then the algorithm outputs FALSE with probability at least 3/4.

In other words, this algorithm *might* be wrong, but if it is, it's not wrong often. So *most likely*, the algorithm will output the correct answer!

# Problem Set 3

1. Consider the formula $\phi = \exists x_1 \forall x_2 \exists x_3 \forall x_4 [(x_1 \vee x_2 \vee \lnot x_3) \wedge (\lnot x_1 \vee \lnot x_2 \vee x_4) \wedge (\lnot x_2 \vee \lnot x_3 \vee \lnot x_4)]$.
   * Draw the resulting directed graph $G$ obtained by the reduction from the formula game to the geography game.
   * Show that $\exists$ has a winning strategy in the formula game for this $\phi$.
2. Recall that the vertex cover problem is NP-complete. The vertex cover problem asked: given a graph $G$ and a number $k$, is there a subset $S$ of its vertices of size $k$ such that every edge has at least one vertex in $S$? Consider the following modification problem: given a graph $G$ and a number $k$, is there a subset $S$ of size $k$ such that $S$ is a vertex cover for $G$, but no set smaller than $S$ is a vertex cover for $G$? Show that you can solve this problem in polynomial time using an oracle for the vertex cover problem.
3. Show that if $P = NP$, then $P = PH$.
4. Show that if $NP = coNP$, then $NP = PH$.
