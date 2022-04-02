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

Consider the language $A_{TM} = \\{ \langle M, w \rangle : M$ accepts $w \\}$. I claim that this language is c.e. but not decidable!

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

**Proof**: Assume by way of contardiction ([BWOC](https://pbs.twimg.com/media/EwH-hipXcAUM2M3?format=png&name=small)) that $A_{TM}$ is decidable and $D$ is a decider for it. Then we can decide $X_{TM}$ as follows:

"On input $\langle M \rangle:
1. Run $D$ on $\langle M, \langle M \rangle \rangle".
2. If $D$ accepts, reject.
3. If $D$ rejects, accept.

## $E_{TM}$

# Reductions

## Exercise

## EQ vs TOT

# m-reductions

## Strategy

## Example

## TOT
