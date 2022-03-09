# Computability Lesson 10: Ambiguity and Pushdown Automata
{:.no_toc}

1. Table of Contents
{:toc}

# Pushdown Automata Questions?

# Turing Machines

Recall the notion that Turing described in his paper, and we talked about in our first class. If we were "computing" an arithmetic problem on paper, we would keep track of different "states of mind" (for example, which "digit" we are looking at in a sum), we would follow specific rules based on what "inputs" we see, and we could use some amount of "scratch work". These correspond to the three ideas mentioned a few times at this point: state, transitions, and memory.

Informally, a Turing Machine is a DFA with an infinite read/write tape. We make a small modification so that it has a single **accept** state and a single **reject** state. If computation ever reaches an accept or reject state, it *immediately* stops. Of course, we might never reach an accept / reject state -- it is possible that computation proceeds forever (just like in regular programming: you might hit an infinite loop!).

We will see that this is a much more powerful notion of computation. For example, the following languages (none of which are regular, one of which is also not context-free), are all "computable":

* $\mathcal{L}_{+} = \\{ a^n + a^m = a^{n+m} : n, m \in \mathbb{N} \\}$ (over $\Sigma = \\{ a, + \\}$).
* $\mathcal{L}_{\times} = \\{ a^n \times a^m = a^{nm} : n, m \in \mathbb{N} \\}$ (over $\Sigma = \\{ a, \times \\}$).
* $\mathcal{L}_{<} = \\{ a^n < a^m : n, m \in \mathbb{N}, n < m \\}$ (over $\Sigma = \\{ a, < \\}$).

(Question: can you figure out which of these are context-free? Hint: try to compute these using a stack.)

Computation on a TM starts with the input $w$ written on the tape $w = w_1 w_2 \ldots w_n$. We start at $q_0$, the start state, and the "read head" of the tape is pointing to $w_1$. We envision the tape as being infinite in "one way", so that you can't go left from the beginning (so $w_1$ is at the beginning, and you cannot move left from there). $\delta$ will tell us what to do if we read the symbol $a$ from the tape at state $q$:

* write $b$?
* move R or L on the tape?
* transition to state $q^\prime$?

Again, this is determnistic, so if we are at state $q$ and we see the symbol $a$ on the tape, we need to decide exactly what those three things will be. We would write $\delta(q, a) = (q^\prime, b, R)$ to mean "At state $q$, if we see $a$, transition to state $q^\prime$, write a $b$ on the tape, and then move the read head of the tape one step right."

## Warm-up

Consider the language $\mathcal{L} = \\{ 0^{2^n} : n \in \mathbb{N} \\}$. We saw that this is not regular. In fact it is also not context free (not going to prove this).

We want a TM which recognizes $\mathcal{L}$. We start our computation with a string of 0s on the tape:

(image of the tape)

We want to check if it has $2^n$ 0s on it, for some $n$. How would we do that?

**Aside**: How would you check this in a programming language? Something along the lines of:

```java
public boolean powerOfTwo(int n) {
  if (n <= 0) {
    return false;
  }
  while (n > 1) {
    if (n % 2 == 1) {
      return false;
    }
    n = n / 2;
  }
  return true;
}
```

In other words: if $n$ is 0, reject. If $n$ is 1, accept. Otherwise, check if we can divide it by 2. If we get an odd remainder, reject. If not, divide it by 2 and repeat. If we ever get to exactly one zero on the tape, accept.

How would we implement this with a TM? (DFA + tape?)

1. If there are no zeros, reject. (This can be done: if we see a blank at the beginning, reject.)
2. Check if there is exactly one zero. (This can be done: if we see a zero, that's one. If we see a blank after that, we accept.)
3. "Cross off" every other zero, by replacing the 0 with some other symbol on the tape (maybe an "x").
   * If there are any zeros left over at the end, reject.
   * If not, go back to the beginning of the tape and repeat. (enter a state which just moves left until the beginning of the tape.)

To do this, we will need to keep track of both "ends" of the tape. One way to do so is to overwrite the first 0 with a "blank" symbol, and then using the "blank" symbols, we can see if we are at the end of the tape.

(Image of what happens to the tape on different computations)

So what would the state diagram of this TM look like? We could start with, at the start state, checking to see if there's a blank or a 0. Keep in mind, that firs t0 will need to be replaced with a blank so that we can keep track of the beginning:

(image of the start state, blank -> reject, 0 -> q1)

At $q_1$, we've seen exactly one zero. If we don't see any more, accept! If we see another one, we can "cross that off", and move to another state.

(image of start -> q_1 -> q_2)

Now at $q_2$, we have seen two zeros by this point (so we are at an even number), and we've crossed off one. Let's set up a loop which will check for even/odd number of zeros, and cross off half of them:

(image of start -> q_1 -> q_2 -> q_3)

At $q_3$, we would see an "odd" number of zeros. If we see a blank at the end, that means that there was an odd number, and so we reject.

(image of start -> q_1 -> q_2 -> q_3 -> reject)

Now we're almost done. We just need to fill in a few more details:

* What happens if we see a blank at $q_2$? Then we have reached the end of the tape with an even number of zeros, having crossed out half of them. We try to go back to the beginning, and repeat.
* What if we see $x$'s on the tape at *any* of the states we have seen? In most cases, we should just skip them, as they represent "crossed out zeros".

So finally we get this machine:

(final image)

So the upshot is: using the tape, we **are** able to count!

## Example

Consider the language $\mathcal{L}_< = \\{ a^n < a^m : n < m \\}$. How might we use the tape to determine if a string is of this form?

The idea would be to "zig-zag" around the inequality symbol:

* Keep track of the "left" side with a blank.
* Go past the "<" symbol, and write an "x" over the first "a".
* Go back, write an "x" over the first "a" on the left, and go forward and write an "x" over the first "a" after "<".
* Keep doing this. If we ever run out of "a"s on the right, reject!

(image of the tape at stage 1)

Then:

(image of the tape after stage 2...)

So again, step one might look like this:

(image of q_0 -> reject with a blank, or -> q_1 with a)

At $q_1$, skip over everything until we see the "<":

(image of q_0 -> q_1, loop, -> q_2 with a <)

At $q_2$, skip over all the "x"s, until you get to an "a", then replace that with an "x". Move left, so that we can go back past the "<", and zig zag:

(image of q_0 -> q_1 -> q_2 -> q_3)

Now skip over all the x's, searching back until you see the "<".

(image of q_3 -> q_4).

At this point, I'll skip to the end, but we have a few more things to do:

* We are currently at a state which needs to "scroll back" to the beginning. Do that.
* We will enter a new state ($q_5$). At $q_5$, we search for an "a" to cross off.
  * If we never see an "a", then that means we've crossed off everything on the left. Enter a new state ($q_6$) which looks for an "a" on the right, and then accepts if it finds one (rejects if it doesn't!)
  * If we do see an "a", cross it off, and return to $q_1$, which was our original "crossed off one a on the left" state.

(finale image)

**Question**: At a "high level", how might we be able to use the tape to decide if a string is of the form $a^n + a^m = a^{n + m}$? Or of the form $a^{n} \times a^{m} = a^{nm}$?

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
