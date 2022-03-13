# Computability Lesson 12: Formal Description of TMs
{:.no_toc}

1. Table of Contents
{:toc}

# Reading

Sipser section 3.1 / MS sections 4.1 - 4.2

# Warm-up

Describe how you would construct a TM to decide the language $\mathcal{L}_+ = \\{ a^n + a^m = a^{n+m} : n, m \in \mathbb{N} \\}$. Some valid strings in this language include:

* $+=$ (if $n$ and $m$ are both 0)
* $a+=a$ (if $n = 1$, $m = 0$)
* $ + a = a$ (if $n = 0$, $m = 1$)
* $a + a = aa$, etc.

There is no need to give the exact state diagram. Just give the idea of what the TM would do (that is, how does the tape look and how does the TM move its read-write head). This is referred to as an **implementation-level description**.

**Answer**:

1. Check to see that there is either an $a$ or a $+$ at the beginning of the tape.
   * If we see anything else (like an equals sign), **reject**.
   * If we see an "a", replace it with a blank, and move to step 2.
   * If we see a "+", replace it with a blank, and move to step 6.
2. Enter a state which skips the LHS of the equation (if we don't see a +, **reject**).
3. After the equals sign, cross out the first "a". If we don't see an equals sign, **reject**. If we don't see an "a" after the equals sign, **reject**.
4. Go back to the beginning of the tape (using the blank symbol to recognize that). Cross out the first "a" before the +.
5. Repeat steps 2-4 until there are no more a's on the left of the plus sign. If there are no more (so we cannot complete step 4), go to step 6.
6. Cross out the first "a" on the right of the +. (If there aren't any, go to step 9.)
7. Go past the equals sign, and cross out the first uncrossed "a". If there aren't any, **reject**.
8. Go back to the plus sign and repeat steps 6 and 7 until there are no more uncrossed "a"s on the left side of the equation. Once this is done, go to step 9.
9. If there are no more uncrossed a's on the right side of the equals sign, **accept**. Otherwise, **reject**.

Convince yourself of two things:

* These steps correctly recognize this language.
* These steps can be implemented with finitely many states. (Some of these steps may take multiple states to do some things, but *finitely* many could still be a lot.)

How would the tape look on the string $a + a = aa$?

(image)

How would the tape look on $a + a = a$?

(image)

What about for $a + a = aaa$?

(image)

## Exercise

Give an "implementation level" description of a TM which decides $\mathcal{L}_< = \\{ a^n < a^m : n < m \\}$. Describe how the TM works (its tape and read-write head) on inputs:

1. "a < a" (rejected)
2. "a < aa" (accepted)

# Formal Description

A **Turing Machine** is a 7-tuple $(Q, \Sigma, \Gamma, \delta, q_0, q_{\text{accept}}, q_{\text{reject}})$, where:

* $Q$ is a finite set (the states),
* $\Sigma$ is a finite, non-empty set not containing the "␣" symbol (the **input alphabet**). (In latex, use `\textvisiblespace` or `$\sqcup$`),
* $\Gamma$ is a finite set (the **tape alphabet**), where $\sqcup \in \Gamma$ and $\Sigma \subseteq \Gamma$,
* $\delta : Q \times \Gamma \to Q \times \Gamma \times \\{ L, R \\}$ is the **transition function**,
* $q_0 \in Q$ is the **start state**,
* $q_{\text{accept}} \in Q$ is the **accept** state, and
* $q_{\text{reject}} \in Q$ is the **reject** state, and $q_{\text{accept}} \neq q_{\text{reject}}$.

A **configuration** of a TM is a description of the following:

* the current contents of the tape,
* the location of the read-write head,
* the current state the TM is in.

There are many ways to do this. The book uses the convention $uqv$, where $u$ and $v$ are strings over $\Gamma$, $q$ is the state the TM is in, the string $uv$ is written on the tape, and the read head is pointing the first symbol of $v$. I prefer the following notation:

**Notation**: A *configuration* of a TM is given by the triple $(w, i, q)$, where $w \in \Gamma^*$ is the string on the tape (starting from the "left-edge" of the tape, which may contain blanks, all the way until the rightmost non-blank symbol), $i \in \mathbb{N}$ is the position of the read-head on the tape, and $q \in Q$ is the state the TM is currently in.

Say a configuration $(w, i q)$ **yields** a configuration $(w^\prime, j, q^\prime)$ if the following are true:

* $w_k = w^\prime_k$ for each $k \neq i$, and
* One of the following is true:
  * $\delta(q, w_i) = (q^\prime, w_i^\prime, R)$, and $j = i + 1$,
  * $i > 0$, $\delta(q, w_i) = (q^\prime, w_i^\prime, L)$ and $j = i - 1$ or,
  * $i = j = 0$, and $\delta(q, w_i) = (q^\prime, w_i^\prime, L)$. (You cannot go "left" from position 0 on the tape)

Technicality: if $i > \|w\|$, we allow for $w_i$ to be the blank symbol ␣.

Now we can define computations.

**Definition**: Let $M = (Q, \Sigma, \Gamma, \delta, q_0, q_{\text{accept}}, q_{\text{reject}})$ be a TM.

1. On input $w \in \Sigma^*$, the **start configuration** is $(w, 0, q_0)$. (The word $w$ is on the tape, the "read head" is at position 0, and we are in the start state).
2. An **accepting configuraiton** is any configuration $(u, i, q_{\text{accept}})$ (no matter what $u \in \Gamma^*$ and $i \in \mathbb{N}$ are). Similarly, a **rejecting configuration** is any configuration $(u, i, q_{\text{reject}})$.
3. A **halting configuration** is either an accepting or rejecting configuration.

$M$ **accepts** $w$ if there is a sequence of configurations $C_1, \ldots, C_k$, for some $k \in \mathbb{N}$ such that:

1. $C_1$ is the start configuration.
2. $C_k$ is the accepting configuration, and,
3. For each $i < k$, $C_i$ yields $C_{i+1}$.

**Definition**:

1. $\mathcal{L}(M) = \\{ w \in \Sigma^*$ : M$ accepts $w \\}$ is the language **recognized** by $M$.
2. If $\mathcal{L}$ is a language and there is $M$ such that $\mathcal{L}(M) = \mathcal{L}$, we call $\mathcal{L}$ **computably enumerable** (c.e.). Historically, the term "recursively enumerable" (or r.e) was also used. The textbook uses the term "Turing recognizable". These all mean the same thing, but I will use the term used by computability theorists.

Suppose $M$ recognizes $\mathcal{L}$. We then know, if $w \in \mathcal{L}$, that $M$ accepts $w$. We do not know, unforunately, that if $w \not \in \mathcal{L}$, that $M$ rejects $w$. That is: given a word, we might not know if the computation is going to finish!

If, however, $M$ **halts** on every input, we say $M$ is a **decider**, and that $\mathcal{L}(M)$ is **computable** (the book uses *decidable*).

# Levels of Description

Technically, we didn't give a TM for the warm-up $\mathcal{L}_+$. But we did describe the process in enough detail that we probably *could* write a formal description of a TM that recognizes this language. We gave, as I mentioned, an "implementation-level" description of a TM that recognized the language. This is somehow in-between the very formal state diagrams we gave last time, and the very informal notion of an algorithm (which we also gave when we described an algorithm for "checking if a number is a power of $2$").

So in summary, we could describe a TM in three possible amounts of detail:

1. At the lowest level, we have the **formal description** of the TM with a state diagram (including the transition function). This can be very hard to understand and hard to draw, because many TMs will have a large number of states.
2. We could describe the TM at an **implementation level**, by describing how the TM controls the read-write head and updates its tape.
3. We could give a **high-level** description by describing the *algorithm*, ignoring implementation details.

**Example**: Assume that multiplication is computable. Give a "high-level description" of an algorithm which decides $P = \\{ a^p : p \in \mathbb{N}$ is a prime number $\\}$.

"On input $a^p$:  
1. Check if $p = 1$. If it is, reject.  
2. Repeat for each $i = 2, \ldots, p - 1$:
   * Check if $i$ is a factor of $p$ (how would we do this? Search for an $x$ such that $ix = p$. Start at $x = 2$ and stop when $ix \geq p$).
   * If it is, **reject**.
   * If it isn't, increase $i$ by one and go back to step 2.
3. If we get through all of the $i$'s, accept."

This is a high-level description of an algorithm. It uses things that we assumed to be computable (like multiplication, "incrementing by one", and looping), but it's not hard to argue that each of these, individually, is computable.

It can be tricky to give high-level descriptions. How do you know if your description is at too high of a level? Essentially, if you can convince yourself (and the reader) that each step only takes finitely many operations (each of which will terminate in finite time), then you are okay. (*Exercise*: Convince yourself that the description given above is kosher.)

For now, we will mostly use implementation-level descriptions. But eventually, we will likely transition to higher level descriptions.

# Variants of TMs

## Stay-put Turing Machine

**Definition**: A "stay-put" TM is similar to a TM with the transition function changed to $\delta : Q \times \Gamma \to Q \times \Gamma \times \\{ L, R, S \\}$. If $\delta(q, a) = (q^\prime, b, S)$, then the machine will move from state $q$ to $q^\prime$, write a "b" in the cell the read-write head is pointing to, and keep the read-write head pointing to the same location.

(We would similarly need to modify the definition of computation, but I will omit those details.)

**Theorem**:

1. A language is computably enumerable if and only if it is recognized by a stay-put TM.
2. A language is computable (decidable) if and only if it is decided by a stay-put TM.

**Proof**:

If $M$ is a TM, then it automatically satisfies the definition of a "stay-put" TM. So, in particular, if a language is c.e., there is a TM which recognizes it, and so there is a stay-put TM which recognizes it. Similarly, if a language is computable, there is a TM which decides it, and so that TM is also a stay-put TM which decides the language.

Conversely, we need to show that given a stay-put TM $M$, we can convert it to a regular TM $M^\prime$ which would recognize (and/or decide) the same language. We can do this, simply, by replacing every transition of the form

(image)

with:

(image)

We would need to do add such a new state for each transition of this form. But since $M$ has finitely many transitions, there would only be finitely many new states we'd need to add to get $M^\prime$. We won't give a full description of this, but this should be enough to convince ourselves of the following facts:

* $M$ accepts a string $w$ if and only if $M^\prime$ accepts $w$.
* $M$ rejects a string $w$ if and only if $M^\prime$ rejects $w$.

This then proves the theorem. (Do you see why? Convince yourself.)

## Other variations

It turns out that this notion of Turing Machine is very robust. They are equivalent to many other notions. We will consider a few variations: multitape TMs, non-deterministic TMs, and enumerators. For today, we will just focus on multitape TMs. Specifically, we will think about TMs which have two tapes (and can move the read-write heads on both of them simultaneously). The argument for general $k$-tape TMs is similar.

## 2-tape TMs

**Definition**: A 2-tape Turing Machine is a TM with two tapes, with the transition function modified to be $\delta : Q \times \Gamma^2 \to Q \times \Gamma^2 \times \\{ L, R, S \\}^2$.

For example, $\delta(q, a, b) = (q^\prime, c, d, L, S)$ means that at state $q$, if we see an $a$ on tape 1 and $b$ on tape 2, we transition to state $q^\prime$, write $c$ on tape 1, $d$ on tape 2, move left on tape 1, and stay put on tape 2.

**Theorem**: Every 2-tape TM has an equivalent 1-tape TM.

**Proof**: The idea is to keep track of both tapes and their read-write head positions. That is:

(image)

To simulate this with just one tape, write the contents of both tapes on the one tape, separated by some delimeter. We will use the \# character for this purpose:

(image)

We also need to mark off the symbols that are currently under the read-write heads:

(image)

We do this by enlarging the alphabet to have these "marked" symbols as well. Then the TM should scan through the tape, keep track of the "marked" symbols, figure out what to do, and then do another scan to update the tape contents.

**Question**: Since the tapes are "infinite", how do we know where to put the "delimeter"? What if we move past what we think is the "edge" of one tape?

In such a case, we would need to add a blank space and shift the contents to the right.

How would we do this? Can you figure out how to implement a "shift" operation on a TM?

# Homework + PS3

Two things are posted on Moodle:

1. Pre-work for Lesson 13 **due Thursday**, before class.
2. Problem Set 3 **due next Thursday** (3/24) at 11:59 PM.

Get started on these early and come prepared with questions if you have trouble on any of these.

# Presentation 1?

...
