# Lesson 17: Undecidability and Reductions
{:.no_toc}

1. Table of Contents
{:toc}

# Reading

Readings: Sipser 4.1 - 4.2 or MS 5.1 - 5.2, 5.4 - 5.8

## Announcements

* April 2: Presidential primary. Go vote (if you didn't vote early already).
* Take Home Exam due Sunday.
* April 24, 5 PM: Tech Career Panel.
* Advising week: make an appointment with your advisor!
  * Electives next semester include Discrete Mathematics, Topics in Advanced Computing, Numerical Analysis
  * Also: ECO 3080 Game Theory, ECO 3070 Econometrics, NME 3215 Experimental Game Lab
  * Registration starts next week.
* Presentation 1 is **overdue**.
* Final Projects: start forming groups of 3-4.
  * Research a topic with your group, present an overview of the topic and write a short, expository paper about it.
  * Will post some sample topics next week, along with a rubric.

## Questions?

Take Home Exam due Sunday. Any questions?

# Uncountability of $\mathcal{P}(\mathbb{N})$

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

**Claim**: $f(n) \neq X$ for any $n$. That is, $X_n \neq X$ for each $n$! Can you prove this? (**Exercise**.)

<!-- Let $n \in \mathbb{N}$. We show that $X \neq X_n$ by showing that the two sets disagree about whether $n$ is an element!

1. Suppose $n \in X_n$. Then $n \not \in X$ by our definition of $X$, so $X$ and $X_n$ are different!
2. Now suppose $n \not \in X_n$. Then $n \in X$ by our definition of $X$, so again the sets are different! -->

# Undecidability

Now that we know that there are sets which are not c.e., can we give an explicit example of such a set? In order to do so, we need to look at string representations of TMs, or "codes" of TMs. One way to do this is to describe a TM using its 7-tuple. So given a TM $M = (Q, \Sigma, \Gamma, \delta, q_0, q_a, q_r)$, let $\langle M \rangle$ be that 7-tuple. For example, it $\langle M \rangle$ might be a string that looks like $(\\{ 0, 1, 2 \\}, \\{ a \\}, \\{ a, \sqcup, \dot{a} \\}, \\{ ((0, a), (1, a, R)), \ldots  \\}, 0, 1, 2)$. The exact details don't really matter: in fact, it's easier to think about TMs as being actual computer programs, and their "string representations" as being the source code of the programs!

It is decidable to check, given a string, if it represents a valid 7-tuple string representation of a TM. Once we have representations of TMs, consider the language

$$
X_{TM} = \{ \langle M \rangle : M \text{ does not accept } \langle M \rangle \}.
$$

In other words, $X_{TM}$ is the set of codes of machines which do not accept their own source code. (Do you see how this is similar to the "diagonal" arguments given above?)

Suppose this language is c.e., and that $M$ recognizes it. We ask: does $M$ accept $\langle M \rangle$? Can you prove that, either way, youw ill get a contradiction?

<!--
Assume it does, then $\langle M \rangle \in \mathcal{L}(M)$ by definition. And of course, since $M$ recognizes $X_{TM}$, then that means $\langle M \rangle \in X_{TM}$. But look at the definition of $X_{TM}$: $\langle M \rangle \in X_{TM}$ iff $M$ does not accept $\langle M \rangle$. But we just assumed that $M$ did accept $\langle M \rangle$, so that's a contradiction!

Now assume that $M$ does not accept $\langle M \rangle$. I claim we will arrive at a contradiction here as well! Do you see why?
-->

# $A_{TM}$

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/PUc4EzjJRCM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

"On input $\langle M \rangle$:
1. Run $D$ on $\langle M, \langle M \rangle \rangle$.
2. If $D$ accepts, reject.
3. If $D$ rejects, accept."

That is, $X$ accepts $\langle M \rangle$ if and only of $D$ rejects $\langle M, \langle M \rangle \rangle$. If $D$ really is a decider for $A_{TM}$, then this happens if and only if $\langle M, \langle M \rangle \rangle \not \in A_{TM}$. That is, $X$ accepts $\langle M \rangle$ if and only if $M$ does not accept $\langle M \rangle$. Similarly, you can see that $X$ rejects $\langle M \rangle$ if and only if $M$ rejects $\langle M \rangle$; in other words. $X$ really is a decider for $X_{TM}$, assuming $D$ is a decider for $A_{TM}$. Since $X_{TM}$ is undecidable, then $A_{TM}$ must be as well.

## $E_{TM}$

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/k7BazjiJNYo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/8k-F4xU63e4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Our general strategy for these examples has been to *reduce* one problem to another. We show that one problem $\mathcal{L}_1$ is "easier than (or at least as easy as)" another problem $\mathcal{L}_2$. If we already know that $\mathcal{L}_1$ is not decidable, then $\mathcal{L}_2$ would also be decidable.

**Definition**: An *oracle* for a problem $\mathcal{L}$ is a function $O : \Sigma^{\*} \to \{ YES, NO \}$ such that $O(w) = YES$ iff $w \in \mathcal{L}$, and $O(w) = NO$ iff $w \not \in \mathcal{L}$. An *oracle Turing Machine* is a regular Turing Machine augmented with an oracle.

The idea of this definition is to formalize the results from the previous section. For example, if we have an oracle for $E_{TM}$, we could decide $A_{TM}$.

**Definition**: Let $\mathcal{L}_1$ and $\mathcal{L}_2$ be languages. Then:

1. $\mathcal{L}\_1$ is **Turing-reducible** to $\mathcal{L}\_2$ if, given an oracle for $\mathcal{L}\_2$, we can decide $\mathcal{L}\_1$. We write $\mathcal{L}\_1 \leq\_{T} \mathcal{L}\_2$.
2. $\mathcal{L}_1$ is **Turing-equivalent** to $\mathcal{L}\_2$ if $\mathcal{L}_1 \leq_T \mathcal{L}_2$ and $\mathcal{L}_2 \leq_T \mathcal{L}_1$. We write $\mathcal{L}_1 \equiv_T \mathcal{L}_2$.

So far we have seen:

* $A_{TM} \leq_T E_{TM}$
* $E_{TM} \leq_T EQ_{TM}$
* $X_{TM} \leq_T A_{TM}$

All of these were Turing reductions, we just didn't use the term at the time! Note that $\leq_T$ is transitive, so, for example, $A_{TM} \leq_T EQ_{TM}$. To see this: notice that given an oracle for $EQ_{TM}$, we can decide $E_{TM}$. And then given a decider for $E_{TM}$, we can decide $A_{TM}$.

We can also prove this more directly. Consider the following oracle TM $A$ which uses an oracle for $EQ_{TM}$:

"On input $\langle M, w \rangle$:

1. Construct $M_1$ which accepts everything.
2. Construct $M_2$, which, on input $x$, does the following:
   * If $x \neq w$, accept.
   * If $x = w$, run $M$ on $w$. If $M$ accepts, accept.
3. Check if $\langle M_1, M_2 \rangle \in EQ_{TM}$. If so, **accept**. Otherwise, **reject**."

## Exercise

Show that $A_{TM} \equiv_T \overline{A_{TM}}$. (This is actually easy!) Conclude the following:

**Theorem**: There are c.e. languages which are Turing-equivalent to languages that are *not* c.e.

## Harder exercise

Show that $REG_{TM} = \\{ \langle M \rangle : \mathcal{L}(M)$ is regular $\\}$ is undecidable.

Hint: try to decide $A_{TM}$. On input $\langle M, w \rangle$, construct a TM $M^\prime$ such that $\mathcal{L}(M^\prime) = \\{ a^n b^n : n \in \mathbb{N} \\}$ if $M$ does not accept $w$, and $\mathcal{L}(M^\prime) = \Sigma^{\*}$ if $M$ does accept $w$.

## EQ vs TOT

Recall that $EQ_{TM} = \\{ \langle M_1, M_2 \rangle : \mathcal{L}(M_1) = \mathcal{L}(M_2) \\}$. Consider the language $TOT = \\{ \langle F \rangle : F$ is a total computable function $\\}$.

**Exercise**: Show that $TOT \leq_T EQ_{TM}$.

Hint: Given $\langle F \rangle$, construct two TMs. One of them, $M_1$ should accept everything. What should the other, $M_2$ do? We want to be sure that if $M_1$ and $M_2$ have the same language, then $F$ should be a total function. But if $F$ ever does not halt on some input $w$, then the language of $M_2$ should not be everything.

See the solution in the video below:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/FQi1Bu7jUnY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Next Time

* I will post notes / videos for an **asynchronous** lesson. Go through them at your own pace, but before Monday.
* Work on the take-home exam!
* We will spend class time on Thursday going over the exam. I will give whatever hints I can give, and will work with you all individually to go over whatever problems you are stuck on.
  * Come prepared! Make sure you've done as much as you can.