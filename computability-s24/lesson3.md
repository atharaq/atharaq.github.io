# Computability Lesson 3: Non-Deterministic Finite State Automata
{:.no_toc}

1. Table of Contents
{:toc}

# Readings

After today: please make sure you have read through Section 1.2 of the Sipser book, or 2.5 of the Maheshwari-Smid book.

# Computation

We previously defined "computation" for the "light switch machine" last week. We can define computation in pretty much the same way, using the formal definition of a DFA above. Suppose $M = (Q, \Sigma, \delta, q_0, F)$. We define what it means for $M$ to **accept** a string $w$:

Let $w = w_1 w_2 \ldots w_n$, where $w_i \in \Sigma$ for each $1 \leq i \leq n$. That is, $w$ is word of length $n$ over $\Sigma$. Then $M$ **accepts** $w$ if there is a sequence of states $r_0, r_1, \ldots, r_n$ such that:

1. $r_0 = q_0$ (the computation begins with the start state),
2. $\delta(r_i, w_{i+1}) = r_{i+1}$ for each $0 \leq i < n$, (each successive state in the computation is given by the transition function), and
3. $r_n \in F$ (we end in an accept state).

That is, the sequence $r_0, r_1, \ldots, r_n$ is the sequence of states $M$ enters as it reads $w$.

Recall that we say that $M$ **recognizes** $\mathcal{L}$ if $\mathcal{L} = \\{ w : M$ accepts $w \\}$.

**Definition**: $\mathcal{L}$ is a **regular language** if there is a DFA $M$ such that $M$ recognizes $\mathcal{L}$.

# Closure Properties

Previously we saw regular languages $\mathcal{L}_1$ and $\mathcal{L}_2$ such that their union $\mathcal{L}_1 \cup \mathcal{L}_2$ is also regular. How did this work?

<img class="noreverse" src="images/union-example-warmup.jpeg" />

It almost looks like we took 2 copies of $M_1$ and put them on top of each other; alternatively, you could think of it as putting three copies of $M_2$ next to each other.

We will show today that if $\mathcal{L}_1$ and $\mathcal{L}_2$ are both regular languages, then so is $\mathcal{L}_1 \cup \mathcal{L}_2$. That is, if we have two DFAs $M_1$ and $M_2$, we can construct a third DFA $M$ which accepts a word $w$ if and only if $M_1$ accepts $w$ or $M_2$ accepts $w$.

## Example

Let's do another warmup example.

1. Design a DFA which accepts $\mathcal{L}_1 = \\{ w : w$ starts with $a \\}$.
2. Design a DFA which accepts $\mathcal{L}_2 = \\{ w : w$ ends with $b \\}$.
3. Design a DFA which accepts $\mathcal{L}_1 \cup \mathcal{L}_2$. (What words do we need to accept here? What words do we reject here?)

<img class="noreverse" src="images/two-machines.jpeg" />

So how do we design the third one? Again, try to design a machine which "runs" both machines at once. That is, if we see any symbol while we're in the start state, we move to a state that keeps track of where machine $M_1$ is in (after reading that symbol) and where machine $M_2$ is in.

<img class="noreverse" src="images/start-union.jpeg" />

Then keep going!

<img class="noreverse" src="images/final-union-ex.jpeg" />

## Union

So the idea, again: keep track of **both** states at the same time. How do we do this? If $q$ is a state in $M_1$, and $q^\prime$ is a state in $M_2$, then make $(q, q^\prime)$ a corresponding state in our new machine $M$! Then we can use the transition functions from $M_1$ and $M_2$ to figure out the transition function for $M$.

**Theorem**: The class of regular languages is closed under unions.

What does this mean? If $\mathcal{L}_1$ and $\mathcal{L}_2$ are regular languages, so is $\mathcal{L}_1 \cup \mathcal{L}_2$.

This does *not* mean that if $\mathcal{L}_1$ is *not* regular and $\mathcal{L}_2$ is *not* regular, then $\mathcal{L}_1 \cup \mathcal{L}_2$ is not regular. That statement is false!

**Proof**: Suppose $M_1 = (Q_1, \Sigma, \delta_1, q_1, F_1)$ and $M_2 = (Q_2, \Sigma, \delta_2, q_2, F_2)$ recognize $\mathcal{L}_1$ and $\mathcal{L}_2$, respectively. We construct $M = (Q, \Sigma, \delta, q_0, F)$ as follows:

* Let $Q = Q_1 \times Q_2$. (One state for each pair $(q, q^\prime)$, where $q \in Q_1$ and $q^\prime \in Q_2$)
* $\Sigma$ is the same alphabet for all three machines.
* The start state $q_0 = (q_1,q_2)$: the start state of $Q_1$ along with the start state of $Q_2$.
* The accept states $F$ are all states of the form $(q, q^\prime)$ where either $q \in F_1$ or $q^\prime \in F_2$.

How do we define $\delta$? If $(q, q^\prime) \in Q_1 \times Q_2$ and $s \in \Sigma$, what is $\delta((q, q^\prime), s)$?

* Since $q \in Q_1$, we can check $\delta_1(q, s)$.
* Since $q^\prime \in Q_2$, we can check $\delta_2(q^\prime, s)$.

So we define $\delta((q, q^\prime), s)$ as $(\delta_1(q, s), \delta_2(q^\prime, s))$.

Now we have described our machine. We must show that this machine recognizes $\mathcal{L}_1 \cup \mathcal{L}_2$. That is, we have to show:

* If $w \in \mathcal{L}(M)$, then either $w \in \mathcal{L}_1$ or $w \in \mathcal{L}_2$, and,
* If $w \in \mathcal{L}_1$ or $w \in \mathcal{L}_2$, then $w \in \mathcal{L}(M)$.

Let $w = w_1 \ldots w_n$. Suppose $r_0, \ldots, r_n$ is the sequence of states that $M_1$ enters during its computation on $w$, and $s_0, \ldots, s_n$ is the sequence of states that $M_2$ enters during its computation on $w$.

That is, $\delta_1(r_i, w_{i+1}) = r_{i+1}$ and $\delta_2(s_i, w_{i+1}) = s_{i+1}$ (by definition of computation, given earlier today). This means that $\delta( (r_i, s_i), w_{i+1}) = (r_{i+1}, s_{i+1})$, as that is how we defined $\delta$ for $M$.

Suppose $M$ accepts $w$. That means $(r_n, s_n) \in F$. By definition of $F$, then, that means either $r_n \in F_1$ or $s_n \in F_2$. That is, either $M_1$ accepts $w$ or $M_2$ accepts $w$.

Now suppose $M_1$ accepts $w$. Then $r_n \in F_1$, so $(r_n, s_n) \in F$, and so $M$ accepts $w$. Similarly, if $M_2$ accepts $w$, then $s_n \in F_2$, so $(r_n, s_n) \in F$.

**Exercise**: Show that the class of regular languages is closed under intersection. (This exercise is included on your next problem set.)

# Non-Determinism

After studying DFAs for a bit, we loosen the rules a little for our next class of machines. Before we do that: what does the word "deterministic" in DFA mean?

**Determinism**: at each state, when we see a symbol, we know *exactly* which state to transition to.

So what does **non-determinism** mean?

**Non-determinism**: at a given state, we may have more than one option when we see a symbol. Or there may be no option at all (in which case the program "crashes"). Or we may even transition without seeing a symbol at all!

In other words: the current state and the symbol we read do not *uniquely* determine the next, successive state.

**Important**: The distinction between determinism and non-determinism will play a key role throughout this course. We will prove several "equivalences" throughout this course. Importantly, this will come up later, when we describe Turing Machines, a class of machines so general that one can describe any algorithm with a TM. This notion of non-determinism is one of the major definitions we will need to study the question of P vs NP in complexity theory. If you've never heard of the P vs NP problem, that's okay; we will discuss it later. But for now, I just wanted to bring up that non-determinism is crucial to understanding what the "N" in "NP" means.

## Example

<img class="noreverse" src="images/nfa-ex1.jpeg" />

We say that $N$ accepts a word $w$ if there is *some* way to parse the input $w$ and end up in an accept state. For example: does $N$ accept the string 110? Try parsing it:

* $q_0 \xrightarrow{1} q_1 \xrightarrow{1} $ ? (crashes)
* $q_0 \xrightarrow{1} q_0 \xrightarrow{1} q_0 \xrightarrow{0} q_0$? (rejects)
* $q_0 \xrightarrow{1} q_0 \xrightarrow{1} q_1 \xrightarrow{0} q_2$ accepts!

There is an accepting computation, so $N$ **accepts** $w$!.

**Exercise**:

1. Find two strings *not* accepted by $N$.
2. Describe $\mathcal{L}(N)$ as precisely as possible. (Hint: how do you get to $q_2$?)

[Check your answers here after class](solutions/lesson3.html#nfa-1)

In general, when we try to compute with a non-deterministic machine, we can think of the machine as "making a guess" at the correct computation, or that the machine goes through all possible computations in parallel.

**Exercise**: Design an NFA which accepts the language $\mathcal{L} = \\{ w : w $ starts with $(01)^n$ for some $n \geq 1 \\}$.

[A possible solution will be here](solutions/lesson3.html#designing)

## Epsilon Transitions

<img class="noreverse" src="images/nfa-ex-epsilons.jpeg" />

NFAs are allowed to have "$\varepsilon$-transitions". In the above, if you are at state $q_1$, you can immediately jump to state $q_2$ without reading any symbol. This gives us many more ways to parse the input. (It can complicate things a lot, but also, when we design NFAs, it can make that process easier!)

Let's see how we can parse a few words. Again, we will *try* to get to an accept state ($q_2)$ if we can:

* $w = 011$. We can parse this as $q_0 \xrightarrow{0} q_1 \xrightarrow{\varepsilon} q_2 \xrightarrow{1} q_3 \xrightarrow{1} q_2$.
* $w = 1110$. These first three 1s have to be processed deterministically (why?): $q_1 \xrightarrow{1} q_0 \xrightarrow{1} q_0 \xrightarrow{1} q_0 \xrightarrow{0} q_1 \xrightarrow{\varepsilon} q_2$.

What about $w = 1001$? There are two ways to parse this:

* $q_0 \xrightarrow{1} q_0 \xrightarrow{0} q_1 \xrightarrow{\varepsilon} q_2 \xrightarrow{0} q_2 \xrightarrow{1} q_3$ (rejects)
* $q_0 \xrightarrow{1} q_0 \xrightarrow{0} q_1 \xrightarrow{0} q_0 \xrightarrow{1} q_0$ (rejects).

There is no way to parse this while ending up in $q_2$. Why not?

* In order to get to $q_2$, we first have to get to $q_1$.
* To get to $q_1$, we need an *odd number of 0s*!
* If we then get to $q_2$, we need an *even number of 1s* to stay at $q_2$!

So: $\mathcal{L}(N) = \\{ w : w = xy$, where $x$ has an odd number of 0s and $y$ has an even number of 1s $\\}$!

So $1001 \not \in \mathcal{L}(N)$, because there is no way to break up $1001$ into two strings where the first has an odd number of 0s and the second has an even number of 1s.

# Formal Definition

Notice that there are two main differences between DFAs and NFAs:

1. We are allowed to read $\varepsilon$ as a symbol (so this should change the inputs to $\delta$), and
2. The transition function does not need to pick out exactly one state (this should change the *outputs* of $\delta$).

The first change is easy to make. Instead of making the domain of $\delta$ be $Q \times \Sigma$, we let $\Sigma_{\varepsilon} = \Sigma \cup \\{ \varepsilon \\}$ and make the domain of $\delta$ $Q \times \Sigma_{\varepsilon}$.

The second change may be a little harder to reason about. What does the transition function actually output now? Now, instead of saying $\delta(q, a) = q^\prime$, we have to be able to answer: "What are all the possible states that we can transition to from $q$ when we read the symbol $a$?" In other words, the outputs of $\delta$ need to be *subsets* of $Q$, not just elements of $Q$!

**Definition**: Let $X$ be any set. We say $A \subseteq X$ if every element of $A$ is an element of $X$. The collection of all possible subsets of $X$ is called the **power set** of $X$, denoted $\mathcal{P}(X)$.

So in other words: the main change is that we modify the definition of $\delta$. Now the transition function is $\delta : Q \times \Sigma_{\varepsilon} \to \mathcal{P}(Q)$. Note that $\emptyset \in \mathcal{P}(Q)$, which means it's possible that $\delta(q, a)$ is the empty set. What would that mean?

**Definition**: A **non-deterministic finite automaton** (NFA) is a 5-tuple $(Q, \Sigma, \delta, q_0, F)$, where:

1. $Q$ is a finite set (of state),
2. $\Sigma$ is a finite, non-empty set (symbols), and $\varepsilon \not \in \Sigma$,
3. $\delta : Q \times \Sigma_{\varepsilon} \to \mathcal{P}(Q)$ is a function (transition function),
4. $q_0 \in Q$ (start state), and
5. $F \subseteq Q$ (accepting states)

Notice that every DFA is automatically an NFA. Why is that? Suppose we have a DFA, with transition function $\delta_1$. We can define an NFA with the same states, alphabet, start state and accepting state by defining a new transition function $\delta_2$ by $\delta_2(q, \varepsilon) = \\{ q \\}$ (add $\varepsilon$-transitions from each state to itself) and $\delta_2(q, a) = \\{ \delta_1(q, a) \\}$ (make the outputs of $\delta$ "singleton" sets).

## Computation

We can define computation similarly to how we define it for DFAs. The issue, of course, is that there may be many ways to parse the input.

**Definition**: Let $N = (Q, \Sigma, \delta, q_0, F)$ be an NFA and $w$ a word over $\Sigma$. Then $N$ **accepts** $w$ if there are $w_1, \ldots, w_n \in \Sigma_{\varepsilon}$ and states $r_0, \ldots, r_n \in Q$ such that:

1. $w = w_1 \ldots w_n$,
2. $r_0 = q_0$,
3. $r_{i+1} \in \delta(r_i, w_{i+1})$ for each $0 \leq i < n$, and
4. $r_n \in F$

Then $\mathcal{L}(N) = \\{ w : N$ accepts $w \\}$ is the **language** of $N$. We say that $N$ **recognizes** (or **accepts**) $\mathcal{L}(N)$.

# Problem Set 1

**Due Thursday, February 8** on BrightSpace (see tex file):

For all of these problems, the alphabet $\Sigma = \\{ 0, 1 \\}$.

1. Let $\mathcal{L}_1 = \\{ w : w$ starts with a 0 and has odd length $\\}$.
  * Give a state diagram of a DFA that accepts $\mathcal{L}_1$.
  * Give the formal description of the DFA as well.
2. Consider the language $\mathcal{L}_2 = \\{ (01)^n : n \in \mathbb{N} \\}$.
  * Give two examples of words in $\mathcal{L}_2$ and two examples of words not in $\mathcal{L}_2$.
  * Give a state diagram of a DFA which accepts $\mathcal{L}_2$.
3. Show that if $\mathcal{L}_1$ and $\mathcal{L}_2$ are regular languages, then so is $\mathcal{L}_1 \cap \mathcal{L}_2$. That is: prove that the class of regular languages is closed under intersection.
4. (We haven't learned this yet) Let $\mathcal{L}_3 = \\{ xy : x$ and $y$ are words over $\Sigma$, $x$ starts with a $0$, and $y$ starts with a $1 \\}.$ Show that $\mathcal{L}_3$ is regular by giving a state diagram of an NFA which recognizes it.
5. Convert your NFA in question (4) to a DFA using the algorithm described in class.

## Quiz

Currently planning on having a quiz next Thursday. This may change to the following Monday.
