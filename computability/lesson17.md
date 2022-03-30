# Lesson 17: Uncountability and Undecidability
{:.no_toc}

1. Table of Contents
{:toc}

# Reading

Readings: Sipser 4.1 - 4.2 or MS 5.1 - 5.2, 5.4 - 5.8

# Cantor's Diagonal Argument

So after studying all of these sets, we may be forgiven for thinking that all infinite sets can be put in one to one correspondence with each other. Throughout history, most mathematicians believed this! If a set is infinite, it never ends, so of course you can match it up with another set that doesn't end, right?

But this informal reasoning does not pan out. We have a rigorous definition of a one to one correspondence: a bijection. Is there a set which is "too large" to be put in bijection with the natural numbers $\mathbb{N}$? It turns out that the real numbers $\mathbb{R}$ is!


How might we prove that this set is not countable? Before we try to write a real proof, we can check that we don't know of any bijection between $\mathbb{N}$ and $\mathbb{R}$. For example, the function $f : \mathbb{N} \to \mathbb{R}$ given by $f(n) = \sqrt{n}$ is not a bijection: $\pi$ is not in the image of $f$.

But we need something stronger than just "Every function I've looked at is not a bijection." We need to show that there is **no** bijection $f : \mathbb{N} \to \mathbb{R}$. This is saying: "I can prove that, for every single function $f : \mathbb{N} \to \mathbb{R}$, something goes wrong."

That is, if I looked at a few functions, and showed that they weren't bijections, that's not enough. Maybe the square root example we thought of just wasn't clever enough. Perhaps we just weren't clever enough in coming up with the rule, like what happened with $\mathbb{Q}$? If we really want to prove that there is no bijection, we have to give an argument that works for every function $f : \mathbb{N} \to \mathbb{R}$.

That is, given a function $f : \mathbb{N} \to \mathbb{R}$, we have to show that $f$ is not a bijection. In fact, what we will show is that $f$ is not a surjection: it's not onto. We will argue in a very general way, so that this argument can be applied to every function from $\mathbb{N}$ to $\mathbb{R}$, thereby showing there is no surjection from $\mathbb{N}$ to $\mathbb{R}$.

The idea will be to find a real number $r$ which is different from $f(0)$, different from $f(1)$, different from $f(2)$, etc. This was **Cantor's Diagonal Argument**: if you list out the numbers $f(0), f(1)$ etc in a vertical table, you can find a real number that's not on that list by picking a number whose $n$-th digit after the decimal place is different from that of $f(n)$. To make this rule concrete, let's say that our number $r$ is defined by the following rule: if the $n$-th digit of $f(n)$ is equal to $1$, then the $n$-th digit of $r$ will be 2. Otherwise, the $n$-th digit of $r$ will be 1.

What does that mean? Let's look at an example. Suppose $f$ is given by the following table:

$$
\begin{align}
f(0) &= 0.131569108 \ldots \\
f(1) &= 2.718281828 \ldots \\
f(2) &= 3.141592653 \ldots \\
f(3) &= 1.741213562 \ldots \\
f(4) &= 2.618128176 \ldots \\
\vdots
\end{align}
$$

Let's look at the diagonal digits here:

$$
\begin{align}
f(0) &= \mathbf{0}.131569108 \ldots \\
f(1) &= 2.\mathbf{7}18281828 \ldots \\
f(2) &= 3.1\mathbf{4}1592653 \ldots \\
f(3) &= 1.74\mathbf{1}213562 \ldots \\
f(4) &= 2.618\mathbf{1}28176 \ldots \\
\vdots
\end{align}
$$

If we apply the diagonal argument, we end up with a number $r$ that starts off as $1.1122\ldots$. We know that this number we end up with cannot be on this list! That's because the number won't be equal to $f(n)$ for any $n$: at the $n$-th place after the decimal, $f(n)$ and $r$ are different!

This is a subtle argument: for each $f$, there is a *different* $r$ that we can find that is not in the image of $f$. So there is no way for a function $f : \mathbb{N} \to \mathbb{R}$ to be a surjection. In terms of cardinality, this means $\|\mathbb{R}\| \neq \aleph_0$.

## Uncountability of $\mathcal{P}(\mathbb{N})$

**Theorem**: No function $f : \mathbb{N} \to \mathcal{P}(\mathbb{N})$ is surjective.  
**Theorem**: For any set $X$, no function $f : X \to \mathcal{P}(X)$ is surjective.

The proofs of both of these are similar, so we will focus on the first one. Recall: what does $\mathcal{P}(\mathbb{N})$ mean? It's the set of all *subsets* of $\mathbb{N}$. In particular, if $f$ is a function from $\mathbb{N}$ to the set of subsets of $\mathbb{N}$, then $f(0)$ is some set $X_0$, $f(1)$ is some other set $X_1$, etc.

**Proof**: The proof is fairly simple. Suppose $f : \mathbb{N} \to \mathcal{P}(\mathbb{N})$ is any function. We find a set $X$ such that $f(n) \neq X$ for any $n \in \mathbb{N}$. We define this $X$ as $X = \\{ n : n \not \in f(n) \\}$. It turns out, this will lead us to the same kind of contradiction we saw above!

To make this more clear, let's list out all the elements of the range of $f$:

* $f(0) = X_0 = \\{ \ldots \\}$
* $f(1) = X_1 = \\{ \ldots \\}$
* $f(2) = X_2 = \\{ \ldots \\}$
* etc.

Then we put $0 \in X$ if $0 \not \in X_0$, or keep $0 \not \in X$ if $0 \in X_0$. Similarly, put $1 \in X$ if $1 \not \in X_1$, and keep $1 \not \in X$ if $1 \in X_1$.

(Note that it's possible that $X = \emptyset$.)

**Claim**: $f(n) \neq X$ for any $n$. That is, $X_n \neq X$ for each $n$! Can you prove this?

Let $n \in \mathbb{N}$. We show that $X \neq X_n$ by showing that the two sets disagree about whether $n$ is an element!

1. Suppose $n \in X_n$. Then $n \not \in X$ by our definition of $X$, so $X$ and $X_n$ are different!
2. Now suppose $n \not \in X_n$. Then $n \in X$ by our definition of $X$, so again the sets are different!

## Languages that are not c.e.

Recall: fix $\Sigma = \\{ a \\}$. Each language $\mathcal{L} \subseteq \Sigma^\*$ canonically corresponds to some set $A \subseteq \mathbb{N}$. Just let $A$ be the set of all *lengths* of words in $\mathcal{L}$ (or vice versa: given a set of numbers $A$, let $\mathcal{L} = \\{ a^n : n \in A \\}$).

That means that the **cardinality** of the set of all languages over $\Sigma^\*$ is the same as the cardinaliyt of the set of all *subsets* of $\mathbb{N}$. In other words, it's the same as the cardinality of $\mathcal{P}(\mathbb{N})$. We saw that this set was uncountable!

Moreover, we saw last time that the set of all TMs, and therefore the set of all c.e. languages, is countable!

That means that there are (infinitely many) languages, even over this small alphabet, which are not even c.e.!

# Undecidability

Now that we know that there are sets which are not c.e., can we give an explicit example of such a set? In order to do so, we need to look at string representations of TMs, or "codes" of TMs. One way to do this is to describe a TM using its 7-tuple. So given a TM $M = (Q, \Sigma, \Gamma, \delta, q_0, q_a, q_r)$, let $\langle M \rangle$ be that 7-tuple. For example, it $\langle M \rangle$ might be a string that looks like $(\\{ 0, 1, 2 \\}, \\{ a \\}, \\{ a, \sqcup, \dot{a} \\}, \\{ ((0, a), (1, a, R)), \ldots  \\}, 0, 1, 2)$. The exact details don't really matter: in fact, it's easier to think about TMs as being actual computer programs, and their "string representations" as being the source code of the programs!

It is decidable to check, given a string, if it represents a valid 7-tuple string representation of a TM. Once we have representations of TMs, consider the language

$$
X_{TM} = \{ \langle M \rangle : M \text{ does not accept } \langle M \rangle \}
$$

In other words, $X_{TM}$ is the set of codes of machines which do not accept their own source code. (Do you see how this is similar to the "diagonal" arguments given above?)

Suppose this language is c.e., and that $M$ recognizes it. We ask: does $M$ accept $\langle M \rangle$? 

Assume it does, then $\langle M \rangle \in \mathcal{L}(M)$ by definition. And of course, since $M$ recognizes $X_{TM}$, then that means $\langle M \rangle \in X_{TM}$. But look at the definition of $X_{TM}$: $\langle M \rangle \in X_{TM}$ iff $M$ does not accept $\langle M \rangle$. But we just assumed that $M$ did accept $\langle M \rangle$, so that's a contradiction!

Now assume that $M$ does not accept $\langle M \rangle$. I claim we will arrive at a contradiction here as well! Do you see why?

## c.e. but no decidable

Next week, we will see that there are languages that are c.e. but not decidable. We will consider the following languages:

* $A_{TM} = \\{ \langle M, w \rangle : M$ accepts $w \\}$. This is called the **acceptance** problem.
* $H_{TM} = \\{ \langle M \rangle : M$ halts on input $\langle M \rangle \\}$. This is the **halting** problem.

We will see that these are c.e. but not computable. We will see other problems, like the "emptiness" problem, the "equality" problem, and some others. We will prove that those are undecidable by "reducing" them to the acceptance or halting problems: if we were able to decide them, then we would also be able to decide the acceptance or the halting problem.

