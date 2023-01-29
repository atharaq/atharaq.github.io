# Discrete Mathematics Lesson 3

We will continue to work through some of the problems in [Combinatorics Through Guided Discovery, 1.2](http://bogart.openmathbooks.org/ctgd/s1-2-basics.html).

## Problems 3 - 5

Work through these on your own. Check your answers below.

<details>
<summary>Click to check your answers:
</summary>

<ol start="3">
<li> $3 \times 5 = 15$</li>
<li>There are $m \times n$ ordered pairs. This is exactly problem 3, where $M$ is the set of types of bread, and $N$ is the set of types of filling.</li>
<li>5 choices for drinks, 15 choices for sandwiches, and 4 choices for fruits makes $5 \times 15 \times 4 = 300$ choices.</li>
</ol>
</details>

## Problem 6

There are two questions here: first, how many possible ice cream cones are there? This part allows for the choice of chocolate / chocolate / chocolate.

<details>
<summary>Check your answer:</summary>
Since there are 12 choices for the top scoop, 12 for the second, and then 12 for the third, there are $12^3 = 1728$ possible ice cream cones.
</details>

The second question asks: how many cones with three **different** flavors can be made? Once you've chosen one of the 12 flavors for the bottom scoop, how many choices do you have for the middle scoop? Then how many choices do you have for the top scoop?

<details>
<summary>Check your answer:</summary>
There are $12 \times 11 \times 10 = 1320$ available cones with three different flavors of ice cream.
</details>

## Problem 7: Functions

<ol style="list-style-type: lower-latin;" type="a">
<li>There are two functions which map $1$ to $a$: $f(1) = a, f(2) = b$ and $g(1) = a, g(2) = a$. Then there are two more which map $1$ to $b$. Write those down. So there are $4$ functions total.</li>
<li>Let's think about this like in Problem 6. Pretend the set $\{ a, b \}$ refers to two different choices of ice cream flavors, and $f(1), f(2)$, and $f(3)$ refer to the flavor choice picked for each scoop (top, middle, and bottom respectively). There are two choices for each scoop, so we have $2 \times 2 \times 2 = 8$ functions total. See if you can write these down! (<strong>Note</strong>: Does this remind you of anything? How many rows in a truth table are there for $n$ variables, if each variable can only be assigned T or F?)</li>
<li>There are three choices for $f(a)$ and three for $f(b)$, so there are $9$ different functions total.</li>
<li>We've done this.</li>
<li>We've done this also! The "one to one" part is akin to saying, in problem 6, that we are not counting cones with two or more scoops of chocolate. Only cones with three different flavors are counted.</li>
<li>Try to summarize how the "function" and set-theoretic vocabulary generalizes the two questions in Problem 6.</li>
</ol>

## Problem 8(a)

(Ignore part (b) for now.) This is similar to the second part of question 6, but not quite the same: in that question, ordering an ice cream with chocolate-vanilla-strawberry scoops was different from an ice cream with strawberry-vanilla-chocolate. In this problem, buying a pint of chocolate, a pint of vanilla, and a pint of strawberry is the same as buying those three flavors in any order.

Let's think about this for a smaller number of flavors first, and then you can try out the larger case on your own. Let's say we have 5 flavors to choose from, and we want to buy 3 different pints of ice cream. The first thing we can do is ask, similar to question 6, if we did care about the order in which we bought the flavors, how many ways can we list out those three flavors? There are 5 choices for the first flavor, 4 choices for the second, and 3 for the third, so there are 60 ways to list out 3 flavors.

Now recognize that many of those choices are redundant: how many of those 60 listings of 3 flavors contain chocolate, vanilla, and strawberry? Another way of asking this question is: in how many ways can I list out chocolate, vanilla, and strawberry in some order? Out of these 3 flavors, I have 3 choices for the first, 2 for the second, and 1 for the third, and so there are 6 ways to list out 3 flavors.

For any group of 3 flavors, there are 6 arrangements of those 3 flavors. So that means, out of those 60 ways of listing out 3 flavors, each group of 3 ends up getting repeated 6 times. That tells us that there are 10 (or $\dfrac{60}{6}$) unique groups of 3 that we can make out of 5 flavors.

Now do the same logic for this problem with 12 flavors and see if you can determine the correct number of groups of 3 flavors out of a possible 12.

<details>
<summary>Check your answer:</summary>

There are $\dfrac{12 \times 11 \times 10}{3 \times 2 \times 1} = 144$ ways we can choose 3 pints of different flavors out of the 12 flavors.
</details>

# Big Ideas

The problems we worked through help motivate a number of the counting concepts / rules we will deal with. The first is the **multiplicative property**: if we make two choices, with $m$ possible first choices, and, for each way of making that first choice, there are $n$ possible second choices, then there are $mn$ ways in which we can make the two choices.

Examples:

* Problem 3: There are 3 choices for the kind of bread, and 5 choices for the kind of filling.
* Problem 5: This is a generalization of the multiplicative property, where we make three choices instead of two. But the principle is the same.

**Exercise**: How many arrangements of the letters "ABCD" are there?
<details>
    <summary>Hint: (click)</summary>
    An arrangement consists of choosing a first letter, then choosing a second one (that is different from the first), a third letter (different from the first two), and finally a fourth letter (different from the first three).
</details>

## Permutations

**Definition**: Given a collection of $n$ distinct objects $a_1, \ldots, a_n$, a *permutation* of those objects is an arrangement of the objects in some order. A $k$-*permutation* is an arrangement of $k$ of those objects in some order.

For example, BACD is a permutation of the letters 'A', 'B', 'C' and 'D', while BAD is a 3-permutation of those letters. Notice that a 4-permutation of those letters is just a permutation. In general, an $n$-permutation of a set of $n$ distinct objects is just a permutation.

## Factorials

If you have heard of factorials before, you likely have guessed that this concept would show up at some point in this lesson. The example last time: "How many arrangements of the letters C A T are there?" highlighted this concept. There are three letters and $3! = 6$ arrangements of the letters.

Usually, $n!$, read "n factorial" is defined recursively as follows:

$$
n! = \begin{cases}
1 & \mbox{if } n = 0 \\
n \times (n-1)! & \mbox{if } n > 0
\end{cases}
$$

For example, $5! = 5 \times 4 \times 3 \times 2 \times 1 = 120$.

Let's flip the script, however. Instead of defining factorials this way as some arbitrary numerical operation, we define factorials combinatorially:

**Definition**: For a natural number $n \geq 0$, the *factorial* of $n$, written $n!$, is equal to the number of arrangements of a collection of $n$ distinct objects.

Later on we will prove the *equivalence* of these definitions: that is, for any $n \geq 0$, the number of arrangements of a collection of $n$ distinct objects is equal to the previously given recursive formula. (This is strange in the case of $n = 0$, as it's not clear what an arrangement of 0 objects is, but we will have to define things precisely first to make sense of it.)

### Generalization: Functions

Much of the discussion about permutations and $k$-permutations can be discussed in the language of functions. I will assume that we know what a function is for now (later on, we will consider a more rigorous, set-theoretic definition of the term).

**Notation**: If $A$ and $B$ are sets, then the notation "$f : A \to B$" means "f is a function with domain $A$ and codomain $B$". Recall: the *domain* of a function is the set of possible inputs to that function, and the *codomain* of a function is the set of possible outputs for that function.

**Definition**: A function $f : A \to B$ is *one to one*, or *injective*, if whenever $x \neq y$ are different objects in the domain ($A$), then $f(x) \neq f(y)$ are different objects in the codomain.

This definition was given in [Problem 7](#problem-7-functions). In that problem, one was supposed to see that there is a correspondence between one to one functions and arrangements (or "$k$-permutations", as I defined them).

<p><strong>Question</strong>: Suppose $f : \{ 1, 2, \ldots, k \} \to \{ `A', `B', `C', `D' \}$ is a one to one function. In what sense does $f$ correspond to a $k$-permutation of the letters 'A', 'B', 'C', and 'D'?</p>

There are several good arguments one could give for this question. My hint would be to think about how we write down an actual $k$-permutation. For example, if $k = 2$, we need to write down 2 different letters. We pick a letter from 'A', 'B', 'C', or 'D', and then we pick a different one. I think of it as literally writing down two blanks, and numbering the blanks as $1$ and $2$. Now think about what $f(1)$ and $f(2)$ are.

**Question**: How many 3-permutations are there of a collection of 10 distinct objects?

In a similar vein to the above: write down three blanks, and now think about the number of choices for the first, second, and third blank.

**Question**: How many 4-permutations are there of a collection of 10 distinct objects?

**Theorem**: Let $n > 0$ and $k$ be a positive integer less than $n$. Then the number of $k$-permutations of a collection of $n$ distinct objects is equal to
$$
\dfrac{n!}{(n-k)!}
$$

**Exercise**: Show that your answers to the previous questions match up with this theorem.

This theorem is a generalization of the results we had been talking about in this section. But this is not necessarily the right way to think about counting $k$-permutations: the simplest way is to just write down $k$ blanks and count the number of choices for each blank.

### Justification

I stated the theorem without proving it. It's worth thinking through the proof in terms of what these symbols mean.

As we know: $n!$ counts the number of permutations of $n$ objects. Let's give an example: suppose our objects are the letters A, B, C, D, E. Then there are 120 (or $5!$) permutations of those letters. If I wanted to list all of the 2-permutations of those letters, I could start by listing out all 120 permutations. For example:

* ABCDE
* ABCED
* ABDCE
* ABDEC
* ABECD
* ABEDC
* $\ldots$

After I have listed out all the permutations, I could delete the last three letters of each to get a 2-permutation. But of course, we end up with many repetitions: ABCDE, ABCED, ABDCE, ABDEC, ABECD, and ABEDC all give us the same 2-permutation: AB.

In fact, every 2-permutation will be repeated exactly 6 times! Why is that? Because *re-arranging the last three letters does not change the 2-permutation*! Why 6, though? Because there are exactly 6, or $3!$, permutations of the last three objects.

So, out of those 120 permutations, we actually get 20 distinct 2-permutations, each of which repeats 6 times.

This argument is quite subtle and so it is worth thinking about more carefully. But the argument given does generalize. If we list out all the permutations of the $n$ objects, and delete the last $(n - k)$ letters, each $k$-permutation will repeat exactly $(n - k)!$ times, because rearranging those last $n - k$ letters does not change the resulting $k$-permutation.

## Combinations

In [Problem 8(a)](#problem-8a), we counted the number of groups of 3 different flavors we can make out of 12 flavors in total. Let's rephrase how we studied this problem. We first found the number of $3$-permutations we could make from a collection of 12 distinct objects, and then we saw that each group of 3 flavors that we listed out was repeated several times: in fact, it was repeated $3!$ times, since there are $3!$ arrangements of three flavors.

So we can generalize this. If we have a set of $n$ objects and we want to count the ways we can make a group of $k$ of them, we first can count the number of $k$-permutations of those $n$ objects using the formula we found before. Then we divide that by the number of arrangements of $k$ objects; that is, we divide it by $k!$. We will refer to the number of groups of $k$ that we can make out of $n$ objects as $\binom{n}{k}$, which we read as "$n$ choose $k$". The argument we have just given gives us a formula for this:

$$
\binom{n}{k} = \dfrac{n!}{k!(n-k)!}
$$

$\binom{n}{k}$ is sometimes referred to as the "binomial coefficient" because these show up as coefficients when you look at $(x + y)^n$. Recall that $x + y$ is a **binomial**, a sum of two terms in an algebraic expression.

# Formalizing Everything: Set Theory

Next time we will start studying set theory. Set theory is a relatively recent branch of mathematics which came about as a result of a program to try to formalize all of mathematics. Many of the notions we have already seen can be formalized in the language of set theory.

A set is just a collection of objects. These objects can be *anything*, including other sets. We will go over notation and basic set operations later, but for now I thought it'd be interesting to talk about how some of the questions we studied here can be thought of in terms of sets:

* Given two sets $A$ and $B$, we can look at the set of ordered pairs of elements $(x, y)$, where $x$ is an object from the set $A$ and $y$ is from the set $B$. Problem 3 asks: if $A$ has 3 objects and $B$ has 5, what is the size of the set of ordered pairs of objects from these sets? Problem 4 asks a similar question.
* A *function* $f: X \to Y$ can be thought of as a set of ordered pairs with a particular property: for each $x$ in the domain of the function ($X$), there is exactly one $y$ in the codomain ($Y$) such that the ordered pair $(x, y)$ is in (the graph of) the function. Problem 6 asked two types of questions about functions:
  * How many functions are there whose domain is the set containing the numbers 1, 2 and 3, and whose outputs are in the set of 12 different flavors?
  * How many of the above functions are *one-to-one* functions? (Definition was in 7(e)).

If we think of a function as a special kind of set, this previous question is actually asking about sets of sets: how large is the set of functions which have a certain property?

Next time we will start studying questions about sets:

* How do we describe sets (notation)?
* What operations can we do on sets? (We will learn about unions, intersections, cartesian products, power sets)
* What are some sets that are commonly used? ($\mathbb{N}$, $\mathbb{Z}$, $\mathbb{Q}$, $\mathbb{R}$, $\mathbb{C}$, ...)
* How do we compare the sizes of infinite sets? (Wait, what does this even mean?)

There are lots of questions that we likely will not touch on that would make great opportunities for students who are interested in learning more about set theory to study on their own. For example, we will not talk about the difference between "naive" and "axiomatic" set theory, nor will we study how to formalize everything, including the notion of numbers themselves, in the language of set theory.
