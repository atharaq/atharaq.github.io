# Computability Lesson 14: Enumerators and Input/Output
{:.no_toc}

1. Table of Contents
{:toc}

# Warm-up

Using the notion of an NTM, explain why context-free languages are decidable.

<details>
<summary>Click for the idea</summary>
<p>Use two tapes. Keep the input $w$ on the first tape, and write $S$ on the second tape. Then non-deterministically pick a rule to replace $S$ with. Keep going until you no longer have any variables written on the second tape. If the two words are the same, accept, otherwise reject.</p>
</details>

# Enumerators

An **enumerator** is a variant of a TM which does not have an accept or reject state, but just has an *output* state. An enumerator starts with an empty tape. If $E$ is an enumerator, we say $w \in \mathcal{L}(E)$ if $E$ enters the output state with $w$ on its tape. Notice that an enumerator *never halts*! It runs forever. We say $E$ **enumerates** $\mathcal{L}(E)$.

**Theorem**: $\mathcal{L}$ is computably enumerable (c.e.) if and only if it is enumerated by an enumerator.

(Hence the name.)

**Proof**:

There are two things to prove: if $\mathcal{L}$ is c.e., then there is an enumerator which enumerates $\mathcal{L}$, and if $E$ enumerates $\mathcal{L}$, then there is a TM which recognizes it. Let's do this second one first:

Suppose $\mathcal{L} = \mathcal{L}(E)$. Let $M$ be the following TM, described at a "high level":

"On input $w$:
1. Run $E$.
2. When $E$ outputs $w^\prime$, compare it with $w$. If $w = w^\prime$, **accept**.
3. If not, keep going."

Clearly $\mathcal{L}(M) = \mathcal{L}(E)$, since if $w \in \mathcal{L}(E)$, then $M$ accepts $w$, and vice versa.

Now suppose $\mathcal{L}$ is c.e. and $M$ recognizes $\mathcal{L}$. We can design an enumerator for $E$ as follows:

Consider all the strings in $\Sigma^\*$. For example, if $\Sigma = \\{0, 1 \\}$, then the strings are $\varepsilon, 0, 1, 00, 01, 10, 11, 000, \ldots$ We can list out all the strings in some predefined order. That is, we can list out all the strings of length 0, then all the strings of length 1, etc. (In other words, $\Sigma^\*$ is **countably infinite**, so there is a bijection between $\mathbb{N}$ and $\Sigma^\*$.)

So suppose $s_1, s_2, s_3, \ldots$ is a list of all the strings in $\Sigma^\*$. Then we design $E$ as follows:

"Repeat for $i = 1, 2, 3, \ldots$:

1. Run $M$ on the strings $s_1, s_2, \ldots, s_i$ for $i$ steps. (That is, up until the $i$-th configuration!)
2. If $M$ accepts any of these, output it."

## Decidability

**Definition**: $\mathcal{L}$ is co-c.e. if $\overline{\mathcal{L}}$ is c.e.

**Theorem**: $\mathcal{L}$ is computable if and only if it is c.e. and co-c.e.

**Proof**:

Suppose $\mathcal{L}$ is computable. Then there is a machine $M$ which decides it. Clearly $M$ recognizes $\mathcal{L}$, so it is c.e. Let $M_2$ be defined as the same TM as $M$, with the accept and reject states swapped. Then $M_2$ recognizes $\overline{\mathcal{L}}$!

Now for the other direction: suppose $\mathcal{L}$ is c.e. and co-c.e. Let $E_1$ enumerate $\mathcal{L}$ and $E_2$ enumerate $\overline{\mathcal{L}}$. We define a decider $D$ for $\mathcal{L}$ as follows:

"On input $w$:
1. Interleave computations of $E_1$ and $E_2$.
2. If $E_1$ ever outputs $w$, **accept**.
3. If $E_2$ ever outputs $w$, **reject**."

**Questions**: Why is this a legitimate description of a TM? What does "interleave computations" here mean? How do we know we are only doing finitely much work at each step?

# Input-Output TMs

An **input-output** TM has a state $q_{halt}$ and no accept or reject states. The **domain** of an IO TM $F$ is the set $D \subseteq \Sigma^\*$ consisting of all words $w \in \Sigma^\*$ such that $F$ halts on input $w$.

$F$ computes a function, which we will also refer to as $F : D \to \Gamma^\*$, where $F(w)$ is the word on the tape when $F$ halts on input $w$. Such a function is called a **partial computable function**. If $D = \Sigma^\*$, then $F$ is called a **total computable function**.

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

We say that the sets $A$ and $B$ have the same cardinality if there is a bijection $f : A \to B$.

We make some obvious definitions, and then use these to extend our vocabulary to be able to talk about infinite sets.

**Definition**: A set $X$ is **finite** if there is $n \in \mathbb{N}$ and a bijection $f : \\{ 0, \ldots, n - 1 \\} \to X$. We say $\|X\| = n$.

(Clearly, this shows that $\mathbb{N}$ is not finite. This is the pigeonhole principle.)

**Definition**:

1. A set that is not finite is called **infinite**.
2. If $X$ is infinite and there is a bijection $f : \mathbb{N} \to X$, then we say $X$ is **countably infinite**, and $\|X\| = \aleph_0$.

**Next time**: we will see that the following sets are countably infinite:

1. $\mathbb{N}$ (obviously)
2. $\mathbb{N} \setminus \\{ 0 \\}$
3. $E = \\{ 0, 2, 4, 6, \ldots \\}$
4. $O = \\{ 1, 3, 5, 7, \ldots \\}$
5. $\mathbb{Z}$
6. $\mathbb{Q}$

We will also see that $\mathbb{R}$ is **not** countably infinite. That is, $\mathbb{R}$ is **uncountable**!

Similarly, we will see that $\mathcal{P}(\mathbb{N})$ is uncountable!

## Number of Languages

Let's fix $\Sigma = \\{ a \\}$. Each language $\mathcal{L} \subseteq \Sigma^\*$ canonically corresponds to some set $A \subseteq \mathbb{N}$. Just let $A$ be the set of all *lengths* of words in $\mathcal{L}$ (or vice versa: given a set of numbers $A$, let $\mathcal{L} = \\{ a^n : n \in A \\}$).

That means that the **cardinality** of the set of all languages over $\Sigma^\*$ is the same as the cardinaliyt of the set of all *subsets* of $\mathbb{N}$. In other words, it's the same as the cardinality of $\mathcal{P}(\mathbb{N})$. Again, we will see that this cardinality is uncountable!

## Number of TMs

How many Turing Machines are there? Recall: a TM is a 7-tuple $(Q, \Sigma, \Gamma, \delta, q_0, q_a, q_r)$. $Q$, $\Sigma$, and $\Gamma$ are all finite sets. For now, let's fix $\Sigma = \\{ a \\}$ and $\Gamma = \\{ a, \sqcup, \dot a \\}$ (maybe we need to add in a few more symbols to $\Gamma$, but probably not too many).

There are actually many, many finite sets $Q$. But we can really just restrict to thinking about $Q$ be sets of numbers of the form $\\{ 0, 1 , \ldots, n - 1 \\}$. Then the question would be: how many functions $\delta$ are there? Of course, there are only finitely many functions between finite sets. So that means there are only finitely many TMs with 2 states, finitely many TMs with 3 states, finitely many with 4 states, etc.

So we can list them all out, and in that way get a bijection from $\mathbb{N}$ to the set of all TMs! That is:

* $f(0) =$ the first TM in our list
* $f(1) =$ the second TM in our list
* $f(2) =$ the third TM in our list

etc.

# Upcoming

* PS3 due Thursday.
* Presentation 1 due **Sunday**, March 27.
* Take home exam next week, due the following week.
* Spring break 4/11 - 4/15
  * Last class before (4/7) will be asynchronous.
