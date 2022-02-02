# Computability Lesson 1: Finite State Machines
{:.no_toc}

1. Table of Contents
{:toc}

# Questions

Last time / reading:

* Some history of computability.
* Mathematical writing / LaTeX.
* Abstraction:
  * Computations need **memory**, **state**, and **transitions**.
  * Memory is unbounded.
  * Finitely many states.
  * Transitions depend only on the state and memory location we are currently "observing".

## Example

Consider a light switch. We can think of a light switch as a simple machine, which keeps track of two "states" (on and off). It has exactly one operation: flip. An "input" to this machine would be a sequence of flips. What would the output of the machine be?

Initially, the switch is off. Let's say a *word* is a string of F's, representing the input to the machine. For example, a word could be F, FF, FFF, FFFFFFFF, etc. The string FFF would represent the input that tells the machine to flip the switch three times. Given a word, a *computation* on that word would be the sequence of states we enter, starting with the "off" state, after seeing each individual "flip" input. We say the machine *accepts* a word if its computation, on the word, results in ending in the **on** state. Lastly, we can define the **language** of the machine as the set of all those input words which the machine accepts.

Abstractly, we can represent this with a simple diagram:

(diagram)

**Exercise**: Define, precisely, the set of words accepted by the machine.

<details>
<summary>Check your answer</summary>
<p>The language of this machine is the set of those strings of F's that have <strong>odd</strong> length.</p>
<p>To see this, notice that every two flips "cancel out". So if we start at the off state, we need an odd number of F's in order to end up in the on state.</p>
<p>In set-theoretic notation, we say that the language of the machine is $\{ w : w$ is a string consisting entirely of an odd number of $F$'s $\}$.</p>
</details>

# Alphabets, Words, Strings, and Languages

While it might not seem like much, we did just describe one type of a somewhat useful computing machine. As we said before, the notion of computation requires memory, states, and transitions. The "light switch" machine seems to work with just states (on and off) and transitions. We do need memory to store the input, but we can think of it as "external" memory to the machine; that is, the machine, itself, does not need to store any more information than just the information stored in those two states.

Technically, we also need to describe, precisely, what *kind* of input we allow to our machines as well. The light switch doesn't know how to handle any input besides a sequence of "flips". So we make the following definitions:

**Definition**: 

1. An **alphabet** is a nonempty, finite set of symbols.
2. If $\Sigma$ is an alphabet, a **string** or **word** is a finite sequence of symbols from $\Sigma$.

**Example 1**: If $\Sigma = \{ 0 \}$, then the following are strings over $\Sigma$:

*   (the empty string, usually represented by $\epsilon$)
* 0
* 00000

**Example 2**: If $\Sigma = \{ 0, 1 \}$, then the the following are valid strings:

* $\epsilon$
* 0
* 1
* 10
* 01

Note that 10 and 01 are **different** strings!

The set of all strings over a given alphabet $\Sigma$ is referred to as $\Sigma^*$.

**Definition**: Given an alphabet $\Sigma$, a **language** over $\Sigma$ is any set of strings over $\Sigma$.

Set theoretically, we say $\mathcal{L}$ is a language over $\Sigma$ is $\mathcal{L} \subseteq \mathcal{P}(\Sigma^*)$.

**Examples**: Here we use the alphabet $\Sigma = \{ 0, 1 \}$.

1. $\mathcal{L}_1 = \emptyset$. The set of no words.
2. $\mathcal{L}_2 = \Sigma^*$. The set of **all** possible words.
3. $\mathcal{L}_3 = \{ 0, 1, 00, 01 \}$. This is a finite language. ($\mathcal{L}_2$ is not!)
4. $\mathcal{L}_4 = \{ w \in \Sigma^* : w$ has more 0s than 1s $\}$.

**Exercise**: Give 3 examples of strings in $\mathcal{L}_4$, and one example of a string not in $\mathcal{L}_4$.

Important note: strings are **finite**, but languages do not have to be.

# Aside: Set Theory

Chapter 0 of the text goes through some of the preliminaries needed for this course. One of the most important is some basic set theory. Set theory is really important in mathematics because it gives us a language with which we can talk about anything in mathematics. We can describe everything in mathematics using set-theoretic terminology.

If you are interested, you can look at my [slides from Discrete Mathematics, Fall 2020](link here) on set theory. This covers most of the basics that we need to know, at least for now. I am reproducing some of that here, in these notes.

A **set** is an unordered collection of distinct objects. By now, we have seen **alphabets**, which are finite sets of symbols, and **languages**, which are sets of strings over some alphabet.

**Notation**: We use curly braces, $\{$ and $\}$, to denote sets. The set $\{1, 2, 3 \}$ is the set of those three elements. The set $\{ 1, 1, 1 \}$ is a set of just one element. Sets are determined by their elements (there is no notion of multiplicity).

We also use "set-builder notation": for example, $P = \{ x : x$ is a prime number$ \}$. We read this as "the set of all $x$ such that $x$ is a prime number."

**More notation**: if $X$ is a set, then $a \in X$ means "$a$ is an element of the set $X$," and $a \not \in X$ means "$a$ is not an element of $X$." For example, let $X = \{$ "red", "blue", $13 \}$. Then $1 \not \in X$, but the word "red" $\in X$.

## Operations on sets

We should know the following examples of operations on sets. Given sets $A$ and $B$, we should know:

1. $A \cup B$: the **union** of $A$ and $B$. This is the set of elements in either $A$ or $B$, or both.
2. $A \cap B$: the **intersection** of $A$ and $B$. This is the set of elements in both $A$ and $B$.
3. $A \setminus B$: $A$ "minus" $B$. This is the set of all those elements in $A$ but not in $B$.
4. $A \times B$: the Cartesian product of $A$ and $B$. This is the set of all *ordered pairs* $(a, b)$, where $a \in A$ and $b \in B$.

We will talk more about these as they come up in the course.

# Deterministic Finite State Automata

As mentioned before, our first class of machines generalize the light switch machine. The idea is that we keep track of a finite set of states and the "transitions" between them, based on the input. We consider the input to be given to us externally to the machine (so the machine does not have to have any memory). Eventually we will define these machines very formally, but for now, we will keep things somewhat informal. Here is an example, where the alphabet is $\Sigma = \{ 0, 1 \}$.

(diagram)

This kind of machine is called a **deterministic finite-state automaton**, or DFA. The "arrow" at the beginning means it is the "starting" state, and the double circle indicates that it is an "accept" state. We "feed" the machine a string. As an example, what does the machine "do" (how does it compute) on the string $010$:

* Start at state $q_0$.
* See a $0$: move to state $q_1$.
* See a $1$: move back to $q_0$.
* See $0$: move back to $q_1$.
* No more input: we are done.

Since we end in an **accept** state, we say the machine **accepts** the string $010$.

**Question**: What are all the strings accepted by this machine?

**Definition**: Given a machine $M$, the set of all strings accepted by $M$ is denoted $\mathcal{L}(M)$. We also say any of the following:

* $M$ **recognizes** $\mathcal{L}(M)$.
* $M$ **accepts** $\mathcal{L}(M)$.
* $\mathcal{L}(M)$ is the **language** of $M$.

**Example**: Determine the following:

(diagram)

1. Is $1 \in \mathcal{L}(M)$?
2. Is $00 \in \mathcal{L}(M)$?
3. $0101 \in \mathcal{L}(M)$?
4. $1001 \in \mathcal{L}(M)$?
5. Describe $\mathcal{L}(M)$ as precisely as possible.

## Other way around

Given a machine, it may take some work, but we will kind of get the hang of determining the language that the machine recognizes. The other way around can be more challenging: given a language, *design* a machine which recognizes this language. Let's try this out.

Suppose we want to design a DFA over the alphabet $\Sigma = \{ 0, 1 \}$ which accepts exactly those strings of even length. How would we do this?

* Can we count all the symbols in the string, and try to divide by two?
* If not, why not? What else can we try?

**Hint**: think back to the light switch example.

# Lesson 2 "Pre-work"

* Determine the language recognized by the following machines:

(image)

* Read Sipser section 1.1, up until Example 1.21 (page 44), or [Maheshwari-Smid](link) sections 2.1-2.2.
* Think about what we would need to describe in order to define, formally, a DFA and its computation. Can you come up with a complete list?
