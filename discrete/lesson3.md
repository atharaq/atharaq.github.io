# Discrete Mathematics Lesson 3

We will continue to work through some of the problems in [Combinatorics Through Guided Discovery, 1.2](http://bogart.openmathbooks.org/ctgd/s1-2-basics.html).

## Problems 3 - 5

Work through these on your own. Check your answers below.

<details>
<summary>Click to check your answers:
</summary>

<ol starty="3">
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

The second question asks: how many cones with three different flavors can be made? Once you've chosen one of the 12 flavors for the bottom scoop, how many choices do you have for the middle scoop? Then how many choices do you have for the top scoop?

<details>
<summary>Check your answer:</summary>
There are $12 \times 11 \times 10 = 1320$ available cones with three different flavors of ice cream.
</details>

## Problem 7: Functions

* a) There are two functions which map $1$ to $a$: $f(1) = a, f(2) = b$ and $g(1) = a, g(2) = a$. Then there are two more which map $1$ to $b$. Write those down. So there are $4$ functions total.
* b) Let's think about this like in Problem 6. Pretend the set $\{ a, b \}$ refers to two different choices of ice cream flavors, and $f(1), f(2)$, and $f(3)$ refer to the flavor choice picked for each scoop (top, middle, and bottom respectively). There are two choices for each scoop, so we have $2 \times 2 \times 2 = 8$ functions total. See if you can write these down! (**Note**: Does this remind you of anything? How many rows in a truth table are there for $n$ variables, if each variable can only be assigned T or F?)
* c) There are three choices for $f(a)$ and three for $f(b)$, so there are $9$ different functions total.
* d) We've done this.
* e) We've done this also! The "one to one" part is akin to saying, in problem 6, that we are not counting cones with two or more scoops of chocolate. Only cones with three different flavors are counted.
* f) Try to summarize how the "function" and set-theoretic vocabulary generalizes the two questions in Problem 6.

# Big Ideas

The problems we worked through help motivate a number of the counting concepts / rules we will deal with. The first is the **multiplicative property**: if we make two choices, with $m$ possible first choices, and, for each way of making that first choice, there are $n$ possible second choices, then there are $mn$ way in which we can make the two choices.

Examples:

* Problem 3: There are 3 choices for the kind of bread, and 5 choices for the kind of filling.
* Problem 5: This is a generalization of the multiplicative property, where we make three choices instead of two. But the principle is the same.

**Exercise**: How many arrangments of the letters "ABCD" are there?
<details>
    <summary>Hint: (click)</summary>
    An arrangement consists of choosing a first letter, then choosing a second one (that is different from the first), a third letter (different from the first two), and finally a fourth letter (different from the first three).
</details>

## Permutations

**Definition**: Given a collection of $n$ distinct objects $a_1, \ldots, a_n$, a *permutation* of those objects is an arrangement of the objects in some order. A $k$-*permutation* is an arrangement of $k$ of those objects in some order.

For example, BACD is a permutation of the letters 'A', 'B', 'C' and 'D', while BAD is a 3-permutation of those letters. Notice that a 4-permutation of those letters is just a permutation. In general, an $n$-permutation of a set of $n$ distinct objects is just a permutation.

## Factorials

If you have heard of factorials before, you likely have guessed that this concept would show up at some point in this lesson. The example at the beginning: "How many arrangements of the letters C A T are there?" highlighted this concept. There are three letters and $3! = 6$ arrangements of the letters.

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

Later on we will prove that $n!$ is equal to the previously given recursive formula. (This is strange in the case of $n = 0$, as it's not clear what an arrangement of $0$ objects is, but we will have to define things precisely first to make sense of it.)

### Generalization: Functions

Much of the discussion about permutations and $k$-permutations can be discussed in the language of functions. I will assume that we know what a function is for now (later on, we will consider a more rigorous, set-theoretic definition of the term).

**Notation**: If $A$ and $B$ are sets, then the notation "$f : A \to B$" means "f is a function with domain $A$ and codomain $B$". Recall: the *domain* of a function is the set of possible inputs to that function, and the *codomain* of a function is the set of possible outputs for that function.

**Definition**: A function $f : A \to B$ is *one to one*, or *injective*, if whenever $x \neq y$ are different objects in the domain ($A$), then $f(x) \neq f(y)$ are different objects in the codomain.

This definition was given in [Problem 7](#problem-7-functions). In that problem, one was supposed to see that there is a correspondence between one to one functions and arrangements (or "$k$-permutations", as I defined them).

**Question**: Suppose $f : \{ 1, 2, \ldots, k \} \to \{ 'A', 'B', 'C', 'D' \}$ is a one to one function. In what sense does $f$ correspond to a $k$-permutation of the letters 'A', 'B', 'C', and 'D'?

There are several good arguments one could give for this question. My hint would be to think about how we write down an actual $k$-permutation. For example, if $k = 2$, we need to write down 2 different letters. We pick a letter from 'A', 'B', 'C', or 'D', and then we pick a different one. I think of it as literally writing down two blanks, and numbering the blanks as $1$ and $2$. Now think about what $f(1)$ and $f(2)$ are.

**Question**: How many 3-permutations are there of a collection of 10 distinct objects?

In a similar vein to the above: write down three blanks, and now think about the number of choices for the first, second, and third blank.

**Question**: How many 4-permutations are there of a collection of 10 distinct objects?

**Theorem**: Let $n > 0$ and $k$ be a positive integer less than $n$. Then the number of $k$-permutations of a collection of $n$ distinct objects is equal to
$$
\frac{n!}{(n-k)!}
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
