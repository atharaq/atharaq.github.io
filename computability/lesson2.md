# Computability Lesson 2: Deterministic Finite State Automata
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

1. Determine the language of the following machine:
2. Design a DFA that recognizes the language $\\{ w : w $ has an even number of 0s and an odd number of 1s $\\}$.
3. Design DFAs that recognize the following languages over $\Sigma = \\{ a, b \\}$:
  * $\mathcal{L}_1 = \\{ w : $ the number of $a$s in $w$ is a multiple of 3 $\\}$.
  * $\mathcal{L}_2 = \\{ w : $ the number of $b$s in $w$ is odd $\\}$.
  * $\mathcal{L}_3 = \mathcal{L}_1 \cup \mathcal{L}_2 = \\{ w : w \in \mathcal{L}_1$ or $w \in \mathcal{L}_2 \\}$.

Hint on the last one: try to "simulate" going through "both" machines at the same time.

# Homework

# DFAs, Formally

To describe a Deterministic Finite Automaton, we need the following:

1. states (finitely many)
2. an alphabet (finite set of symbols)
3. transitions between the states
4. a start state
5. accepting state(s)

So, formally, a **deterministic finite automaton** (DFA) is a 5-tuple $(Q, \Sigma, \delta, q_0, F)$ (note: tuples are *ordered*, so we can refer to the first element of the tuple, second element, etc), where:

1. $Q$ is a finite set (called the **states**),
2. $\Sigma$ is a finite, non-empty set (the **alphabet**),
3. $\delta : Q \times \Sigma \to Q$ is a function (the **transition function**),
4. $q_0 \in Q$ (the **start state**), and
5. $F \subseteq Q$ (the set of **accept states**, or the **final states**).

Aside: what does $\delta : Q \times \Sigma \to Q$ mean?

* $\delta$ is a function
* $Q \times \Sigma$ is the set of all ordered pairs of the form $(q, a)$, where $q \in Q$ and $a \in \Sigma$,
* the **domain** of $\delta$ is $Q \times \Sigma$,
* the **codomian** of $\delta$ is $Q$.

That is: $\delta$ takes in, as input, a state and a symbol, and outputs a state. The meaning of $\delta(q, a) = q^\prime$ is that "if we are at state $q$ and see the symbol $a$ from the input, then we move to state $q^\prime$."

## Example

## Computation

# Closure Properties

## Union

# Problem Set 1
