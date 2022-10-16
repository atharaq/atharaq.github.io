# Topics in Advanced Computing Lesson 9: The Time Hierarchy Theorem
{:.no_toc}

1. Table of Contents
{:toc}

# Problem Set Questions?

# EXP vs NEXP

Recall: $EXP$ is the complexity class consisting of those problems which are solvable in $DTIME(O(2^{p(n)}))$ for some polynomial $p(n)$. It also has a nondeterministic analogue: $NEXP$.

One can show that if $P = NP$, then $EXP = NEXP$.

## EXP-completeness?

We have seen that there are problems which are $NP$-complete. That is: problems $X \in NP$ such that for all problems $A \in NP$, $A \leq_P X$.

**Questions**:

1. What would it mean for a problem to be $EXP$-complete?
2. What would it mean for a problem to be $NEXP$-complete?
3. If $X \in NEXP$ is $NEXP$-complete and $X \in EXP$, does that mean $EXP = NEXP$?

Here is an example of an $EXP$-complete problem: given a description of a deterministic Turing Machine $M$, an input $x$ to $M$ and an integer $k$, determine if $M(x)$ halts within $k$ steps.

# Time Hierarchy Theorem

We say $f$ is "little-oh" of $g$, written $f(n) = o(g(n))$, if for each real number $k > 0$, there is $N$ such that for all $n \geq N$, $f(n) \leq k g(n)$. In other words: $\frac{f(n)}{g(n)} \rightarrow 0$ as $n \rightarrow \infty$.

**Definition**: Let $f : \mathbb{N} \to \mathbb{N}$ be any function. $f$ is called **time-constructible** if there is a (deterministic) TM $M$ which runs in time $O(t(n))$ such that on input $1^n$, $M$ outputs the binary representation of $t(n)$.

Pretty much any (computable) function which is eventually larger than $n \log n$ is time constructible.

**Theorem**: (The Time Hierarchy Theorem) For any time constructible $f: \mathbb{N} \to \mathbb{N}$, there is a problem solvable in running time $O(t(n))$ that is not solvable in running time $o(t(n) / \log(n))$.

We will show a simpler version of this theorem. Instead, we will show: there is a problem in $DTIME(n^2)$ that is not in $DTIME(n)$. We define a machine $D$ that solves this problem as follows:

"On input $x$:
1. Let $M_x$ be the $x$-th TM in some fixed enumeration of all valid Turing Machines.
2. Let $n$ be the length of $x$ and write a row of $n^2$ 0s. This will be our "counter".
4. As long as the counter row is not empty:
   * Simulate $M_x$ on input $x$ for one (additional) step.
   * If $M_x$ halts and outputs $1$, halt and output a 0.
   * If $M_x$ halts and outputs $0$, halt and output a 1.
   * Delete one 0 from the counter row.
5. If the counter row is empty, halt and output 0."

There are a lot of things to think about. First, what does the first line mean? We can first fix an ordering of all Turing Machines: $M_0, M_1, M_2, \ldots$, where the description of $M_i$ can be produced from $i$ in time $O(\log i)$. This can be done. For example, one can order TMs according to the number of states, and use lexicographic ordering among all TMs that have the same number of states. Note that we allow machines that do not halt on all
inputs.)

Then the first line runs in time $O(n)$, if $n$ is the length of $x$. The rest of the program runs in $O(n^2)$ time. One needs to think about how long it takes to simulate $M_x$, but it is known that this kind of simulation takes $O(n \log n)$ steps, so in all the machine runs in $O(n^2)$ time.

Now how do we show that the machine does not run in $O(n)$ time? Suppose $M$ runs in time $O(n)$, and for each input $x$, $M(x) = D(x)$. Then there is some integer $x$ such that $M = M_x$. The question then is, what happens on input $x$?

* $D(x)$ will simulate $M_x(x)$, and will output the opposite.
* Since $M_x(x)$ halts in time $O(n)$, which is less than $n^2$ many steps, $D(x)$ will output the opposite!

This technique is called **diagonalization**. $D$ is a kind of "diagonal" machine that attempts to be different from every single machine in some way.

(In class, I will draw a picture of what this notion of "diagonalization" means.)

**Corollary**: $P \neq EXP$.

Can anyone explain why?

# Space Complexity

...
