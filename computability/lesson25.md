# Lesson 25: Turing Jumps, Arithmetical Hierarchy, Incompleteness and Truth
{:.no_toc}

1. Table of Contents
{:toc}

# Upcoming

* Problem Set 5 will be posted tomorrow and will be due Monday, May 16 (during finals week)
* Final Projects:
  * Presentation: Thursday, 5/12. (about 15 minutes)
  * Paper: Thursday, 5/19. (about 5-10 pages)

# P vs NP, Philosophically

> If P=NP, then the world would be a profoundly different place than we usually assume it to be. There would be no special value in “creative leaps,” no fundamental gap between solving a problem and recognizing the solution once it’s found. Everyone who could appreciate a symphony would be Mozart; everyone who could follow a step-by-step argument would be Gauss; everyone who could recognize a good investment strategy would be Warren Buffett.

[Scott Aaronson, "Reasons to Believe"](https://scottaaronson.blog/?p=122)

Aaronson also wrote an interesting article about philosophy and complexity theory: [Why Philosophers Should Care About Computational Complexity](https://www.scottaaronson.com/papers/philos.pdf).

Readings: skim 6.1 and read 6.2 (Sipser)

# Oracles

Recall that an "oracle-TM" is a TM which has access to querying an oracle. One can think of it as a program which takes in two inputs: a number ($n$), and a set $X$. The program, then, can do the normal operations on $n$, but it can also ask (finitely many) questions of the form "Is $x \in X$?"

This is a very general set-up. That is, given the "source code" for an oracle TM, we could "plug in" different sets as oracles, and end up solving different problems. For example, consider the following code for an oracle TM:

"On input $\langle e, n \rangle$, with oracle $X$:

1. Find the code $e^\prime$ of a function $f_{e^\prime}$, which, on any input, ignores it and compute $f_e(n)$.
2. Check if $e^\prime \in X$.
   * If not, output 0 (reject).
   * If so, compute $f_e(n)$ and output whatever it outputs."

* If we plug in to this oracle with $X$ being the empty set, this will reject every input.
* If we plug in to this oracle with $X$ being the halting set $H = \\{ e : f_e(e) = 1 \\}$, then this computes an analogue of the "acceptance problem", translated to this number-theoretic setup.

That is, this computes a total oracle-computable function $\Phi^X$ such that if $X = H$, $\Phi^X(e, n) = f_e(n)$ if $f_e(n)$ halts, and $\Phi^X(e, n) = 0$ otherwise. This function is *not* a total computable function, but it *is* a total $H$-computable function.

## Enumeration of Partial Oracle-Computable Functions

Recall that there is a computable enumeration $f_0, f_1, f_2, \ldots$ of all partial computable functions. What does this mean?

* For each $e$, one can determine what the $e$-th partial computable function is. (The idea: if $e = 0$, figure out what the smallest valid IO TM over the alphabet $\\{0, 1 \\}$ is. Then if $e = 1$, figure out the second smallest, etc.)
* For each IO TM $F$, one can find an $e$ (maybe many $e$'s, but you can find at least one) such that $f_e$ and $F$ compute the same function (halt on the same inputs, and for those inputs that they both halt on, output the same number). The idea is to think of $e$ as the "source code" for $F$.

How did we obtain such a computable enumeration? By, more or less, describing a universal TM. That is, describing a TM $M$ such that, on input $\langle M^\prime, w \rangle$, $M$ simulates $M^\prime$ on $w$. Translating this to the language of functions on natural numbers, this describes a function $f$ which, on input $(e, n)$, "decodes" $e$ (figures out what the $e$-th TM is), and runs that on input $n$.

Similarly, we can describe a universal oracle TM $M$ in the exact same way: on input $\langle M^\prime, w \rangle$, just "decode $M^\prime$" and run it on input $w$. But of course, if $M^\prime$s code queries an oracle, then the only way $M$ can simulate that is by asking the same oracle.

In other words, there is a partial oracle computable function $F$, which, for any oracle set $X$ and any input $(e, n)$, runs the $e$-th partial $X$-computable function ("decodes" this) on input $n$. So again, we obtain an $X$-computable enumeration of all partial $X$-computable functions $\Phi^X_0, \Phi^X_1, \ldots$.

(Moreover, there is a strong universality to this algorithm: the same "oracle" algorithm works for any oracle, just depending on what set you plug in as the oracle.)

This allows us to define, for any set $X$, the **halting problem relativized to $X$**:

**Definition**: Let $X \subseteq \mathbb{N}$ be any set. Then $X^\prime$, the **Turing jump of $X$**, is the set $\\{ e : \Phi^X_e(e)$ halts $\\}$.

**Theorem**: For any set $X$, $X <_T X^\prime$.

**Proof**: There are two things to show here. First, that $X \leq_T X^\prime$. Then, that $X^\prime$ is not $X$-computable. We will skip the first (it actually takes a bit more work than you might expect.)

The second part, though, is essentially the same proof that the halting problem is not computable. The exact same proof relativizes. That is, assume that $X^\prime$ is $X$-computable. Then we would also be able to $X$-compute the set $\\{ e : \Phi^X_e(e)$ halts and equals $0 \\}$. But if this is $X$-computable, then its characteristic function $\chi$ is equal to $\Phi^X_e$ for some $e$. Then one checks that $\chi(e) = 1$ iff $\Phi^X_e(e) = 0$, and vice versa.

## Turing Jumps

A Turing jump, then, is a "strictly harder" problem than the original problem.

* The sets that can be decided from no oracle, ie the $\emptyset$-computable sets, are just the computable sets.
* The halting problem, then, is the jump of the empty set$: $\emptyset^\prime$ (usually referred to as "0-jump")
* The sets that can be computed from $\emptyset^\prime$ are the c.e. and co-c.e. sets.
* Then there is $\emptyset^{\prime\prime}$, $\emptyset^{\prime\prime\prime}$, etc.

The theorem above says that each of these is strictly harder than the one that came before it! That means, there is no set $X \subseteq \mathbb{N}$ that computes everything! That is, there is no $X$ such that for every $A \subseteq \mathbb{N}$, $A \leq_T X$.

This is actually a profound statement because this is saying that there is no "universal set". I aim to show that there is a natural example of what one might hope would be a universal set: the set of all codes of true statements about numbers!

# Logic

Recall that a **term** in arithmetic is:

* 0,
* 1,
* $x_i$, for some $i \in \mathbb{N}$ (a variable)
* $t_1 + t_2$, if $t_1$ and $t_2$ are arithmetic terms, or
* $t_1 \cdot t_2$, if $t_1$ and $t_2$ are arithmetic terms.

Previously you showed that $L_{terms} = \\{ t : t$ is a term $\\}$ is context-free. Therefore, it's computable.

A **formula** is:

* $t_1(x_1, \ldots, x_n) = t_2(x_1, \ldots, x_n)$, where $t_1$ and $t_2$ are terms,
* $t_1(x_1, \ldots, x_n) < t_2(x_1, \ldots, x_n)$, where $t_1$ and $t_2$ are terms,
* $(\phi(x_1, \ldots, x_n) \wedge \psi(x_1, \ldots, x_n))$, where $\phi$ and $\psi$ are formulas,
* $\lnot (\phi(x_1, \ldots, x_n))$, where $\phi$ is a formula,
* $\exists x_i (\phi(x_1, \ldots, x_n))$, where $\phi$ is a formula and $x_i$ is a variable ($i \in \mathbb{N})$

Similarly we showed that $L_{formulas} = \\{ \phi : \phi$ is a formula $\\}$ is computable.

**Examples**:

1. $\exists \exists x_1$ is not a formula.
2. $\exists x_1$ is not a formula.
3. $\lnot (\exists x_1 (\lnot (x_1 + x_1 = x_1)))$ is a formula.

A **statement** is a formula with no free variables.

For example, $\phi(x_0, x_1, x_2) = \exists x_3 (x_3 + x_3 = (x_0 + x_1) \cdot (x_0 + x_1 + 1) \wedge x_2 = (x_3 + x_1))$ is a formula. If we plug in, $\phi(0, 1, 2)$ is a statement. (Technically, "2" isn't in our language, but $1 + 1$ is, and so there is a "closed term" that represents 2).

## Truth and Definability

**Statements** are either true or false. **Formulas** *define* a set of numbers (or of tuples of numbers).

For example, the statement $t_1(a_1, \ldots, a_n) = t_2(b_1, \ldots, b_n)$ if those terms arithmetic terms really are equal. So for example, the expression $(1 + 1) \cdot (1 + 1) = (1 + (1 + (1 + 1)))$ is true, since both sides of the equation really are equal to 4. We write $\mathbb{N} \models (1 + 1) \cdot (1 + 1) = (1 + (1 + (1 + 1)))$.

(Notice that it's possible to write a program that would verify if terms are equal to one another. It might require some amount of recursion and/or data structures, but in principle it's just figuring out what the "expression trees" are for both terms and plugging in the numbers.)

Similarly, $\mathbb{N} \models 1 + 1 < 1 + (1 + 1)$, since $2$ really is less than 3. It is similarly possible to write a program that determines if one term is less than another term, given inputs to those terms.

Inductively, if $\phi$ and $\psi$ are both true, then $\mathbb{N} \models \phi \wedge \psi$. And if $\phi$ is true, then $\mathbb{N} \not \models \lnot \phi$, that is, $\lnot \phi$ is false. And vice versa: if $\phi$ is false, then $\mathbb{N} \models \lnot \phi$.

Lastly, $\mathbb{N} \models \exists x_0 \phi(x_0, a_1, \ldots, a_n)$ if there is some number $b \in \mathbb{N}$ such that $\mathbb{N} \models \phi(b, a_1, \ldots, a_n)$. That is, if you can plug in something for $x_0$ in the formula that makes the resulting statement true.

A formula $\phi(x_1, x_2, \ldots, x_n)$ defines the set of $n$-tuples $\\{ (x_1, \ldots, x_n) : \mathbb{N} \models \phi(x_1, \ldots, x_n) \\}$. So for example, the formula $\phi(x) = \exists y (x = y \cdot y)$ defines the set of all perfect squares $\\{ 0, 1, 4, 9, \ldots \\}$.

Much of the study of logic boils down to the question: which sets are definable? This is an interesting question to logicians because definability is some way of saying that we "understand" an object. We can define the set of even numbers, the set of prime numbers, the set of perfect squares, etc. Most (all?) sets we can describe in number theory we can define using first order logic.

## Expressibility

Arithmetic is *deceptively expressive*.

We can "code" some set theory using numbers. We say $x \in a$ if the $x$-th bit of $a$, written in binary, is a 1. That is, there is a formula $\phi(x, a)$ that expresses exactly that the $x$-th bit of $a$ is equal to 1. (Exactly how to write this formula is not so important; what's more important is that this relation is actually *computable*: on input $x$ and $a$, how would you check if the $x$-th bit of $a$ is equal to $1$?)

We can "define" finite sequences: that is, the sequence $(a_1, a_2, \ldots, a_n)$ can be represented by the single number $2^{a_1} \cdot 3^{a_2} \cdots p_n^{a_n}$, where $p_n$ is the $n$-th prime number. (This is not quite accurate, as one would first need to code the length of the sequence $n$, but this is a technicality that I'll ignore. If you care about gory details, take a look at *Models of Peano Arithmetic*, by Richard Kaye).

Putting these two together: we can express that the number $x$ represents the finite sequence $(Q, \Sigma, \Gamma, \delta, q_0, q_{halt})$ that represnts an IO TM! That is:

* Each of $Q$, $\Sigma$, and $\Gamma$ are finite sets
* $\delta$ is a finite function, which can be represented as a finite set
* $q_0$ and $q_{halt}$ are elements of $Q$

And so each of these can be represented by numbers. There is a formula $\phi(x)$ that expresses: "$x$ represents a finite sequence $(x_1, x_2, x_3, x_4, x_5, x_6)$, where $x_1$, $x_2$ and $x_3$ are sets, $x_5 \in x_1$ and $x_6 \in x_1$, and $x_4$ is a function with domain $x_1 \times x_3$ and codomain $x_1 \times x_3 \times \\{ L , R \\}$".

(That's a mouthful, and the formula would be very long, but it's possible). In fact, this shouldn't be too surprising since there is a TM which recognizes whether a sequence is a valid description of a TM. Since the description of a TM can be thought of as a string, and that string can then be thought of as its ASCII code (or Unicode encoding), we can think of this description of a TM as a number!

So the conclusion is: there is a formula $\phi(x)$ which defines the set of codes of TMs.

**Question**: What's the relationship between definability and computability? Are all computable sets definable? Vice versa? 
