# Discrete Mathematics Lesson 2
{: .no_toc}

1. Table of Contents
{:toc}

# Proof writing

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/UnCo5NFh8i8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</div>

How do we prove a conditional ("if-then") statement? I will cover two ways in this lesson. The first is "direct proof" and the second is "proof by contradiction".

## Direct Proofs

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

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/eJn0zP8LexY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</div>

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

### Contrapositive
{: .no_toc}

Recall, from the previous "check-in", that the contrapositive of $p \rightarrow q$ is $\lnot q \rightarrow \lnot p$. You can verify (and, on your problem set, you **will** verify this) that every conditional statement is logically equivalent to its contrapositive. This means that if you can prove $\lnot q \rightarrow \lnot p$, you have proved $p \rightarrow q$.

Proof by contradiction can often be thought of as looking at the *contrapositive* of the original statement. In other words, in the previous proof, we tried to show that "If two lines are parallel, then they have the same slope." What we provided, instead, was a direct proof that "If two lines have different slopes, then they are not parallel!"

# Satisfiability

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/3_Pt3sNlrsw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</div>

One more topic in propositional logic: **satisfiability**. Let's say we have a formula in propositional logic: something like $[p \wedge (q \rightarrow r)] \wedge [(p \vee \lnot q) \rightarrow \lnot r]$. We say that this formula is **satisfiable** if we can assign truth values to all the variables (in this case, p, q, and r) such that the resulting formula is evaluated to true.

If p is T, q is F, and r is F, then the formula is evaluated as $[\text{T} \wedge (\text{F} \rightarrow \text{F})] \wedge [(\text{T} \vee \lnot \text{F}) \rightarrow \lnot \text{F}]$. This evaluates to $[\text{T} \wedge \text{T}] \wedge [\text{T} \rightarrow \text{T}]$, which is T. That means this formula is satisfiable.

Checking whether a formula is satisfiable, in our class, amounts to making a truth table for that formula, and seeing if any row in that truth table results in a "T" in the column for this formula. For example, the following is a truth table for $p \rightarrow \lnot p$:

$$
\begin{array}{c | c | c | c | c }
p & \lnot p & p \rightarrow \lnot p \\
\hline
\text{T} & \text{F} & \text{F} \\
\text{F} & \text{T} & \text{T}
\end{array}
$$

This formula is satisfiable: it's true if $p$ is false.

## Knights and Knaves

Logic puzzles are a fun application of satisfiability. "Knights and Knaves" puzzles were popularized by the late Raymond Smullyan. Here is an example:

> You are on an island in which all residents are either knights or knaves. Knights always tell the truth, and knaves always lie, but they are indistinguishable otherwise. You meet two residents: A and B. A says, "B is a knave." B says, "Neither one of us is a knave." Can you determine A and B's types?

Before reading the solution, try this out on your own. See if you can come up with a strategy!

<details>
<summary>Click for a solution.</summary>
<p>Let p be the statement "A is a knight", and q the statement "B is a knight". Based on A's statement, if A is telling the truth, then q is false. In other words: $p \rightarrow \lnot q$. Moreover, if B is a knave, then A is telling the truth, so this is actually and if and only if: $p \leftrightarrow \lnot q$. Similarly, if $q$ is true, then $p \wedge q$ must be true, and vice versa: if both are knights, then B is telling the truth. Therefore $q$ is true.</p>
<p>In other words, we <b>know</b> the following statements: $p \leftrightarrow \lnot q$ and $q \leftrightarrow (p \wedge q)$. Let's make a truth table for this:</p>

$$
\begin{array}{c | c | c | c | c }
p & q & \lnot q & p \leftrightarrow \lnot q & q \leftrightarrow (p \wedge q) \\
\hline
\text{T} & \text{T} & \text{F} & \text{F} & \text{T} \\
\text{T} & \text{F} & \text{T} & \text{T} & \text{T} \\
\text{F} & \text{T} & \text{F} & \text{T} & \text{F} \\
\text{F} & \text{F} & \text{T} & \text{F} & \text{T} \\
\end{array}
$$

<p>We see that the only row with a satisfying assignment for both of these statements is when p is T and q is F. That is, if A is a knight and B is a knave.</p>
</details>

## Algorithms and P vs NP

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/GeVJqHGylMw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</div>

Computer science is the study of algorithms. If you have taken CS1 (and definitely if you took CS2), you likely know, at least informally, what the term *algorithm* means (informally, a general "recipe" or list of instructions for solving a problem). Our discussion of satisfiability hinted at the fact that there is a general algorithm to solve any satisfiability question: make a truth table, and then check whether there is any row in which the formula evaluates to "T".

In computer science, when we study a problem, there are two questions we can ask about that problem:

1. Is this problem solvable with an algorithm?
2. Just how *efficient* an algorithm can we find?

The first question is the domain of *computability theory*, while the second is the domain of *complexity theory*. Both are active areas of research in theoretical computer science. For the satisfiability question, we have already answered the first problem: there is an algorithm, and while the code to write the algorithm might be somewhat tricky, the general steps are not too hard to understand.

To determine the efficiency of an algorithm, we first need to define the notion of the **running time**. The running time of an algorithm is a function $T(n)$ such that, for any input of size at most $n$, the algorithm takes at most $T(n)$ steps. We then can compare two different algorithms for solving the same problem by seeing which running time is smaller in the long run (ie, for large values of $n$).

Let's think about the "truth table" algorithm. When we study counting principles, we will be able to determine exactly the number of rows in a truth table with $n$ variables. For now, I will just hint that the number of rows in a truth table with $n$ variables is **not** a polynomial function of $n$. That is, for large values of $n$, it's bigger than $n^2$, bigger than $n^3$, etc. Of course, it's possible to make truth tables for small values of $n$, like with 2 variables or 3 variables. But a formula with just 20 variables would take over a million rows, and with 100 variables it would be an astronomical amount of rows.

On the other hand, if you are given a formula, and a *particular* assignment for the variables, you can probably write a simple program that would determine if that assignment satisfies the formula. For example, if you are given the formula $p_1 \wedge p_2 \wedge p_3 \wedge p_4$ and the assignment: $p_1 = \text{T}$, $p_2 = \text{F}$, $p_3 = \text{T}$, $p_4 = \text{T}$, it is not hard to see that this is not a satisfying assignment. Moreover, the algorithm for checking this amounts to simply plugging in the variables and computing a small number of these logical operations.

In other words: the satisfiability problem might not be easy to solve, but if you are given an assignment, you can easily verify if that really does satisfy the formula. By "easy", here, I mean that the number of steps it takes to answer the question is small (technically, a polynomial function).

### Easy to verify, hard to solve?
{: .no_toc}

This duality between problems being "easy to verify" but possibly "hard to solve" is a common theme in computer science. Complexity theorists classify problems in computer science into different "classes" based on their running times; two such classes are the classes P and NP. Roughly speaking: **P** contains the collection of problems for which there is an algorithm which **solves** the problem whose running time is a polynomial function, while **NP** contains those problems which can be **verified** with an algorithm whose running time is a polynomial function. We gave an argument above that the "satisfiability problem" is in the class NP. It's also not hard to show that any problem in the class P is also in the class NP (exercise: try to give an argument for this on your own).

The million-dollar question: is the satisfiability problem in the class P? This problem is still not solved. There is currently no known algorithm that solves the satisfiability problem in polynomial time; moreover, there is no known *proof* that it *cannot* be solved in polynomial time!

When I say this is the "million-dollar question", I mean this quite literally. This is the "P vs NP" question: is every problem that is easy to "verify", also easy to "solve"? Intuition tells us "No", but we do not have a real proof of that fact yet. In the 1970s, Stephen Cook and Leonid Levin independently showed that if the satisfiability problem has a polynomial time algorithm (ie, if it's in the class P), then **every** problem in the class NP is also in the class P. That is: if we can solve the satisfiability problem efficiently, then the classes P and NP are the same class.

In 2000, the Clay Mathematics Institute named this "P vs NP" problem as one of its [Millenium Prize Problems](https://en.wikipedia.org/wiki/Millennium_Prize_Problems), announcing that anyone who discovers a solution to this problem will be awarded 1 million USD!

# Intro to Counting / Arrangement Problems

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/LP5T9aeh4Bg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
</div>

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

Suppose team $i$ is playing in a game. They have $4$ possible opponents. And there are $5$ different values for $i$. So why isn't the answer simply $5 \times 4 = 20$? For a smaller example: if we had $3$ teams, each team would play in $2$ different games. So are there $6$ games?

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

# Exit Ticket 2

Due Monday, 1/30 (see .tex file on Moodle)

1. In this problem, rather than ask you to prove a statement, I just want you to think about how you would go about writing a proof. State clearly what definitions you would use, what hypotheses/assumptions you would make, and whether you would use a direct proof or a proof by contradiction.

   **Theorem**: Let $n$ be an integer. If $n^2$ is an even number, then $n$ is even.
2. You are on an island where everyone is either a knight (who always tells the truth) or a knave (who always lies). You meet two people, A and B. A says “We are both knaves.” Determine the identities of A and B. (For this problem, you can either use a truth table, or reason intuitively.)
3. Work through problem 2 of \textit{Combinatorics Through Guided Discovery} section 1.2: Some number $n$ of schools are going to send their baseball teams to a tournament. Each team must play each other team exactly once. Think of the teams as being numbered $1$ through $n$:
   * How many games does team 1 have to play in?
	 * How many games, other than the one with team 1, does team two have to play in?
	 * How many games, other than those with the first $i - 1$ teams, does team $i$ have to play in?
	 * In terms of your answers to the previous parts of the problem, what is the total number of games played?
   Can you find a formula for the total number, using the``adding numbers in two ways" trick we used in the video?
