# Computability Lesson 15: Input/Output and Undecidability
{:.no_toc}

1. Table of Contents
{:toc}

# Warm up

Discuss the following with each other: is the function which, on input $a^n$, outputs the first $n$ digits of $\pi$ a (partial or total) computable function? Can you give an informal argument (without Turing Machines)?

# Finishing the proof from last time

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

The following sets are countably infinite:

1. $\mathbb{N}$ (obviously)
2. $\mathbb{N} \setminus \\{ 0 \\}$
3. $E = \\{ 0, 2, 4, 6, \ldots \\}$
4. $O$ = \\{ 1, 3, 5, 7, \ldots \\}$
5. $\mathbb{Z}$
6. $\mathbb{Q}$

We will also see that $\mathbb{R}$ is **not** countably infinite. That is, $\mathbb{R}$ is **uncountable**! Similarly, we will see that $\mathcal{P}(\mathbb{N})$ is uncountable!

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
