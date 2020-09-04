# Discrete Mathematics Lesson 2
{: .no_toc}

1. Table of Contents
{:toc}

# Proof writing

How do we prove a conditional ("if-then") statement? I will cover two ways in this lesson. The first is "direct proof" and the second is "proof by contradiction".

## Direct Proofs
(10 mins?)

An "if-then" statement is true if, whenever the hypothesis ("if" part, also referred to as the *antecedent*) is true, then the conclusion ("then" part, also referred to as the *consequent*) must also be true. Let's go back to an example from [Lesson 0](lesson0.html#mathematical-writing): prove that if a number $n$ is a multiple of 6, then it must be even.

Before attempting a proof, make sure you can write down definitions of "multiple of 6" and "even number"! We of course, intuitively, know what these terms mean, but we need to have good definitions so we can actually use them in our arguments. The definitions we will use are:

Multiple
:  An integer $n$ is a **multiple** of an integer $x$ if there is an integer $k$ such that $n = kx$

Even
:  An integer $n$ is **even** if it is a multiple of 2. That is, if there is $k$ such that $n = 2k$.

Now we are ready to write a proof for that exercise:

**Theorem**: Let $n$ be an integer. If $n$ is a multiple of 6, then $n$ is even.

We will prove this "directly"; that means, we will only look at those cases where the "if" part is true, and then we will try to come up with an argument for why the "then" part must be true.

**Proof**:

Let $n$ be a multiple of 6. By definition, this means there is an integer $k$ such that $n = 6k$. We can re-write this as $n = (2 \times 3)k$. The associative property of multiplication allows us to conclude that $n = 2 \times (3k)$. Let $m = 3k$, so we have that $n = 2m$. Since $k$ is an integer, so is $m$, and so we have shown that $n$ is a multiple of 2. By definition, that means $n$ is even.

## Proof by contradiction / contrapositive

Now let us examine "proof by contradiction". First of all, what does this mean? Before we examine a specific proof by contradiction, let us first recall the truth table for a conditional statement $p \rightarrow q$:

$$
\begin{array}{c | c | c}
p & q & p \rightarrow q \\
\hline
\text{T} & \text{T} & \text{T} \\
\text{T} & \text{F} & \text{F} \\
\text{F} & \text{T} & \text{T} \\
\text{F} & \text{F} & \text{T}
\end{array}
$$

Looking carefully at this truth table, the only way for an implication to be **false** is if the antecedent is true and the consequent is false. Proof by contradiction, then, is to assume that this happens, arrive at a contradiction, conclude that the statement cannot be false, and then, using classical logic, that the statement must therefore by true.

Let us use proof by contradiction, then, to show that parallel lines must have the same slope.

**Theorem**: Two non-vertical, parallel lines have the same slope.

To prove this, it will be easier to re-state it as an "if-then" statement. So I will re-state it as:

**Theorem**: If two non-vertical lines are parallel, then they have the same slope.

**Proof**:

We assume that this statement is false. In particular, we suppose lines $\ell_1$ and $\ell_2$ are parallel, meaning that they never intersect. Let $y_1 = m_1 x + b_1$ be the equation of the first line, and $y_2 = m_2 x + b_2$ be the equation of the second line. Now assume that the two lines do not have the same slope: that is, that $m_1 \neq m_2$. (*Notice: we have now assumed that the "if" part is true, and the "then" part is false; that is, we assumed that the conditional is false.*)

Consider the x-value $x = \dfrac{b_2 - b_1}{m_1 - m_2}$. Plugging this value in to both equations, and simplifying, results in the same y-value: $y = \dfrac{m_1 b_2 - m_2 b_1}{m_1 - m_2}$. This means that the two lines intersect at this point $(\dfrac{b_2-b_1}{m_1-m_2}, \dfrac{m_1 b_2 - m_2 b_1}{m_1-m_2})$. This is a contradiction, since we assumed our lines do not intersect. Therefore, our assumption (that the conditional statement is false) is not true: in other words, the "if-then" statement is not false, so it must be true.

# Satisfiability

One more topic in propositional logic: **satisfiability**. Let's say we have a formula in propositional logic: something like $[p \wedge (q \rightarrow r)] \wedge [(p \vee \lnot q) \rightarrow \lnot r]$. We say that this formula is **satisfiable** if we can assign truth values to all the variables (in this case, p, q, and r) such that the resulting formula is evaluated to true.

If p is T, q is F, and r is F, then the formula is evaluated as $[\text{T} \wedge (\text{F} \rightarrow \text{F})] \wedge [(\text{T} \vee \lnot \text{F}) \rightarrow \lnot \text{F}]$. This evaluates to $[\text{T} \wedge \text{T}] \wedge [\text{T} \rightarrow \text{T}]$, which is T. That means this formula is satisfiable.

Checking whether a formula is satisfiable, in our class, amounts to making a truth table for that formula, and seeing if any row in that truth table results in a "T" in the column for this formula. For example, the following is a truth table for $(\lnot p \rightarrow q) \wedge (\lnot p \wedge \lnot q)$:

$$
\begin{array}{c | c | c | c | c | c | c }
p & q & \lnot p & \lnot q & \lnot p \rightarrow q & \lnot p \wedge \lnot q & \lnot (\lnot p \rightarrow q) \wedge (\lnot p \wedge \lnot q) \\
\hline
\text{T} & \text{T} & \text{F} & \text{F} & \text{T} & \text{F} & \text{F}\\
\text{T} & \text{F} & \text{F} & \text{T} & \text{T} & \text{F} & \text{F} \\
\text{F} & \text{T} & \text{T} & \text{F} & \text{T} & \text{F} & \text{F}\\
\text{F} & \text{F} & \text{T} & \text{T} & \text{F} & \text{T} & \text{F}\\
\end{array}
$$

This formula is not satisfiable!

## Knights and Knaves

## P vs NP

# Intro to Counting / Arrangement Problems
(10 mins)

We will revisit logic as we go through the semester. But discrete mathematics, itself, really is about *counting*. In other words: "discrete" objects are those which can be enumerated (one after the other), while "continuous" objects are things like the real numbers $\mathbb{R}$.


**Question:** In how many ways can we arrange the letters C A T?

* CAT
* CTA
* ACT
* ATC
* TAC
* TCA

I count 6 ways.

**Question:** What is meant by an "arrangement" of the letters?

We will come back to this. For the rest of this lesson, we will work through some of the problems in [Chapter 1, *Combinatorics Through Guided Discovery*](http://bogart.openmathbooks.org/ctgd/what-is.html).

## Interlude: Read Chapter 1 and Section 1.1

Before proceeding, please make sure to read those parts. Now move on to [Section 1.2, "Basic Counting Principles"](http://bogart.openmathbooks.org/ctgd/s1-2-basics.html).

## Problems 1 - 2

Problem 2 is a generalization of Problem 1. Let's work through Problem 1, you should work through Problem 2 on your own.

>  Five schools are going to send their baseball teams to a tournament, in which each team must play each other team exactly once. How many games are required?

* (a) How many games does team 1 have to play in? Team 1 plays teams 2 - 5, so that is 4 games.
* (b) How many games, other than with team 1, does team 2 have to play in? Team 2 plays teams 3 - 5, so that's 3 games.
* (c) Let's make a table to see how many games team $i$ plays, besides the ones they played against teams $1$ through $i - 1$:

$$
\begin{array}{c | c}
i & \text{Games} \\
\hline
1 & 4 \\
2 & 3 \\
3 & 2 \\
4 & 1 \\
5 & 0
\end{array}
$$

So the answer to problem 1 is:

$$ \sum_{i = 1}^4 (5 -i) = 4 + 3 + 2 + 1 = 10$$

There is a trick to adding consecutive numbers in a row. ie, there is a trick for adding $1 + 2 + 3 + \ldots + (n - 1)$. Play around with this problem in the case that $n = 4, 5, 6, \ldots$ and see if you can find the pattern.

### Alternate Solution
{: .no_toc}
Suppose team $i$ is playing in a game. They have $4$ possible opponents. And there are $5$ different values for $i$. So why isn't the answer simply $5 \times 4 = 20$? For a smaller example: if we had $3$ teams, each team would play in $2$ different gaems. So are there $6$ games?

Let's list out each of the two games that each team plays in:

Team 1's games:

* Team 1 vs Team 2
* Team 1 vs Team 3

Team 2's games

* **Team 2 vs Team 1**
* Team 2 vs Team 3

Team 3's games

* **Team 3 vs Team 1**
* **Team 3 vs Team 2**

What do we notice here? I bolded games that were already accounted for. In particular, every game shows up *twice*! That makes sense: there are two teams playing in each game.

In general, if there are $n$ teams, each playing $n - 1$ other teams, then there are **not** $n \times (n - 1)$ games, because again, each game would appear twice if we listed out all $n - 1$ games for each team. So what is the correct formula?
