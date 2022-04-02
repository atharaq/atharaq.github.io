# Lesson 18: Undecidability
{:.no_toc}

1. Table of Contents
{:toc}

# Reading

Sipser 5.1, 5.3 (skip 5.2), 6.3

# Last time

Last time we saw:

* $\mathbb{R}$ is uncountable.
* $\mathcal{P}(\mathbb{N})$ is uncountable.
  * Therefore the set of all languages over $\Sigma = \\{ a \\}$ is uncountable.
* The set of c.e. languages over $\Sigma = \\{ a \\}$ is countable.
* Therefore there are languages which are not c.e.

We also saw that $X_{TM} = \\{ \langle M \rangle : M$ does not accept $\langle M \rangle \\}$ is not c.e.!

To review this: suppose that $M$ recognizes $X_{TM}$. Then consider the two possibilities of either $M$ accepting $\langle M \rangle$ or not accepting $\langle M \rangle$:

1. If $M$ accepts $\langle M \rangle$, then since $\mathcal{L}(M) = X_{TM}$, $\langle M \rangle \in X_{TM}$. But then, by definition, $\langle M \rangle \in X_{TM}$ if and only if $M$ does not accept $\langle M \rangle$. This is a contradiction!
2. If $M$ does not accept $\langle M \rangle$, then $\langle M \rangle \in X_{TM}$. But then $M$ does not accept some word that is in $X_{TM}$, which contradicts the assumption that $M$ recognizes $X_{TM}$.

Either way we arrive at some sort of contradiction, and so no such $M$ can exist!

# $A_{TM}$

Consider the language $A_{TM} = \\{ \langle M, w \rangle : M$ accepts $w \\}$. This is the **acceptance problem**. I claim that this language is c.e. but not decidable!

## $A_{TM}$ is c.e.!

We can give a "high level" description for a TM $A$ which recognizes $A_{TM}$:

$A$: "On input $\langle M, w\rangle$: (if the input does not have this form, *reject*)

1. Simulate $M$ on $w$.
2. If $M$ accepts, accept.
3. If $M$ rejects, reject."

Think about this for a bit. How would this work? Somehow, we have a single Turing Machine which can simulate any other TM? This TM $A$ has some finitely many states. How would it simulate a TM which had significantly more states?

It turns out that this is not a problem. Let's think about this on the "implementation level." Suppose our input is a (finite) string which describes a TM $M$ and an input $w$. Keep that on tape 1. Use tape 2 as your "simulation" tape: at any given point, keep track of the current "configuration" of $M$. So at the beginning, write $(w, 0, q_0)$ on tape 2. Check tape 2 for what symbol we're looking at ($w_0$), and then search tape 1 for what $\delta$ says to do at the state we are in ($q_0$) when we see the symbol $w_0$ on the tape. Once we figure this out, we can update tape 2, and then continue the simulation.

It turns out that we don't, in fact, need infinitely many states to do all of this! This "implementation-level" design can be made fully formal (though we won't actually do that).

## $A_{TM}$ is undecidable

(Remember the quote about pulling olives from a jar?) The first undecidability result we saw, for $X_{TM}$, used a kind of diagonalization argument. Here we will use a different argument: that if we assume $A_{TM}$ is decidable, we would also be able to decide $X_{TM}$. This is a *reducibility* argument: reduce one problem to another. We will see many kinds of reductions as we study this topic, as well as the topic of complexity theory.

**Theorem**: $A_{TM}$ is undecidable.

**Proof**: Assume by way of contradiction ([BWOC](https://pbs.twimg.com/media/EwH-hipXcAUM2M3?format=png&name=small)) that $A_{TM}$ is decidable and $D$ is a decider for it. Then we can decide $X_{TM}$ as follows. Let $X$ be the following machine:

"On input $\langle M \rangle:
1. Run $D$ on $\langle M, \langle M \rangle \rangle$.
2. If $D$ accepts, reject.
3. If $D$ rejects, accept."

That is, $X$ accepts $\langle M \rangle$ if and only of $D$ rejects $\langle M, \langle M \rangle \rangle$. If $D$ really is a decider for $A_{TM}$, then this happens if and only if $\langle M, \langle M \rangle \rangle \not \in A_{TM}$. That is, $X$ accepts $\langle M \rangle$ if and only if $M$ does not accept $\langle M \rangle$. Similarly, you can see that $X$ rejects $\langle M \rangle$ if and only if $M$ rejects $\langle M \rangle$; in other words. $X$ really is a decider for $X_{TM}$, assuming $D$ is a decider for $A_{TM}$. Since $X_{TM}$ is undecidable, then $A_{TM}$ must be as well.

## $E_{TM}$

Consider the **emptiness problem**: $E_{TM} = \\{ \langle M \rangle : \mathcal{L}(M) = \emptyset \\}$. This is the set of those Turing Machines which do not recognize anything.

**Theorem**: $E_{TM}$ is undecidable.

Similar to above, the idea will be to prove this by contradiction. Suppose that $E_{TM}$ is decidable and we have a decider $D$ for it. We will use this to construct a decider $A$ for $A_{TM}$.

**Proof**: Suppose $D$ is a decider for $E_{TM}$. We let $A$ be the following machine:

"On input $\langle M, w \rangle$:

1. Construct $M^\prime$, which does the following: 'On input $x$:
   * If $x \neq w$, reject.
   * If $x = w$, run $M$ on input $w$. If $M$ accepts, accept.'
2. Run $D$ on $\langle M^\prime \rangle$. If $D$ accepts, **reject**. If $D$ rejects, **accept**."

The idea here is that we construct a machine $M^\prime$ such that $\mathcal{L}(M^\prime) = \\{ w \\}$, if $M$ accepts $w$, and $\emptyset$ otherwise. This is a valid description of a Turing Machine $M^\prime$, since, if you know $M$ and $w$, you can certainly hardcode this in to the description of $M^\prime$. ($M^\prime$ can simulate $M$ on $w$ similar to what we said above about $A_{TM}$, or you can just put all the states / transitions from $M$ into $M^\prime$).

It's worth noting that $M^\prime$ might run forever on $w$ (if $M$ runs forever on $w$). This is okay! TMs are allowed to *run* forever; we just need to be able to *describe* it in finite time for our machine $A$.

Then if $D$ decides if $\mathcal{L}(M^\prime) = \emptyset$, $A$ will be able to decide if $M$ accepts $w$!

**Exercise**: Show that $EQ_{TM} = \\{ \langle M_1, M_2 \rangle : \mathcal{L}(M_1) = \mathcal{L}(M_2) \\}$ is undecidable by showing that if we could decide it, we would also be able to decide $E_{TM}$.

# Reductions

Our general strategy for these examples has been to *reduce* one problem to another. We show that one problem $\mathcal{L}_1$ is "easier than (or at least as easy as)" another problem $\mathcal{L}_2$. If we already know that $\mathcal{L}_1$ is not decidable, then $\mathcal{L}_2$ would also be decidable.

**Definition**: An *oracle* for a problem $\mathcal{L}$ is a function $O : \Sigma^{\*} \to \{ YES, NO \}$ such that $O(w) = YES$ iff $w \in \mathcal{L}$, and $O(w) = NO$ iff $w \not \in \mathcal{L}$. An *oracle Turing Machine* is a regular Turing Machine augmented with an oracle.

The idea of this definition is to formalize the results from the previous section. For example, if we have an oracle for $E_{TM}$, we could decide $A_{TM}$.

**Definition**: Let $\mathcal{L}_1$ and $\mathcal{L}_2$ be languages. Then:

1. $\mathcal{L}_1$ is **Turing-reducible** to $\mathcal{L}_2$ if, given an oracle for $\mathcal{L}_2$, we can decide $\mathcal{L}_1$. We write $\mathcal{L}_1 \leq_{T} \mathcal{L}_2$.
2. $\mathcal{L}_1$ is **Turing-equivalent** to $\mtahcal{L}_2$ if $\mathcal{L}_1 \leq_T \mathcal{L}_2$ and $\mathcal{L}_2 \leq_T \mathcal{L}_1$. We write $\mathcal{L}_1 \equiv_T \mathcal{L}_2$.

## Exercise

## EQ vs TOT

# m-reductions

## Strategy

## Example

## TOT
