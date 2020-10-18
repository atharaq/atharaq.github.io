# Discrete Mathematics Lesson 11: Some Number Theory
{:.no_toc}

1. Table of Contents
{:toc}

# Calendars

If you are reading these notes as soon as they are posted on Moodle, then today is Monday, October 19. October has 31 days. What day of the week will November 19 be? This might seem a bit tricky, but of course you know there is a cycle to the days of the week: every 7 days, we'll get to another Monday. So the next few Mondays will be:

* October 26
* November 2 (26 + 7 = 33, and since October has 31 days, we will be in day 2 of November)
* November 9
* November 16

Then we can count, one by one, to figure out that November 19th will be a Thursday. Is there a way we can exploit properties of numbers to figure this out without needing to keep counting by 7s?

Knowing that October has 31 days, November has 30, and December has 31, what day of the week will January 1 be?

* October 31 is in 12 days (31 - 19), so November 1 is in 13 days. Since 14 days takes us to a Monday, 13 must take us to 1 day before a Monday: a Sunday.
* November 8, 15, 22, and 29 will all be Sundays then.
* November 30 is a Monday, and then December 1 is a Tuesday.
* December 8, 15, 22, and 29 are all Tuesdays then.
* December 30 is a Wednesday, December 31 is a Thursday, and so January 1 is a Friday.

Again, it seems like there should be a faster way to figure this out. Any ideas? Think about it for a bit before you check the spoilers below.

<details>
<summary>Spoilers</summary>

<p>There are 13 + 30 + 31 = 74 days until January 1. We know that we just need to keep counting by 7s and see how many days are left over. That is: if we count by 7s, we get that in 70 days, it's a Monday again. Then we'd need to count 4 more!</p>

<p>In other words: we know that $74 \div 7 = 10$, remainder $4$. 4 days after a Monday is a Friday.</p>
</details>

## Clocks

We are doing a certain kind of arithmetic when we think about adding days on a calendar. This is really a *cyclical* addition: you add enough numbers and things cycle back around. If we're talking about days of the week, things cycle around every 7 days. That means that adding 7 days, to a day of the week, does not change that day of the week. 7 days from a Monday is still a Monday, 7 days from a Wednesday is still a Wednesday, etc.

A very similar phenomenon happens when we add hours on a clock. If we look at the clock at 8:00, and then look again 12 hours later, the hour hand will be in the exact same spot. That is, the hour hand on the clock cycles around every 12 hours. (Ignore AM/PM, as we are just looking at the position of the hands on a clock.) Let's do some quick examples.

* Start at 6:00. What time is it in 8 hours?
* Going back to our starting point of 6:00, what time is it in 20 hours?
* Starting at 2:00, what time *was* it 8 hours ago? (In the past)

Playing around with these you should figure out how to use the fact that the clocks cycle around every 12 hours:

* 6 + 8 = 14. But the hours cycle around after 12, and so this would be 2:00.
  * You can think of this as: 6 + 8 is 6 + 6 + 2, and 6 + 6 gets us to 12:00. Then 2 more hours gets us to 2:00.
* 6 + 20 = 26. Again: hours cycle around after 12: so 2, 14, and 26 all mean the same thing on the clock: 2:00.
  * You could think of this as 6 + 8 + 12, and knowing that 6 + 8 ends up at 2:00, and adding 12 hours does nothing, would give you the same answer.
* 2 - 8 = -6. What does -6 mean on the clock? 6 hours *before* 12, which is just 6:00.

Notice that adding and subtracting are still inverse operations: adding 8 hours to 6:00 gets you to 2:00, and subtracting 8 hours from 2:00 gets you back to 6:00!

## Exercises

1. Starting at 3:00, what time will it be in 150 hours? Hint: $12 \times 12 = 144$.
2. There are exactly 365 days from now until October 19, 2021. What day of the week will October 19, 2021 be? (Hint: $7 \times 52 = 364$.)

<details>
<summary>Check your answers</summary>
<ol>
<li>Since the clock will be at 3:00 every 12 hours, then in 144 hours it will be 3:00. So 6 more hours later it will be <strong>9:00</strong>.</li>
<li>October 19, 2020 is a Monday. Adding 364 days stays on a Monday, since that's a multiple of 7. So adding 365 will make that a <strong>Tuesday</strong>.</li>
</ol>
</details>

## Light switches

Let me introduce one more quick example before I talk about the proper generalization. Let's say you are a parent to a toddler, who recently discovered he loves to flick light switches. Let's say the child has access to a light switch, which is initially off when the little monster decides to go to work. Demonstrating incredible speed, the boy has managed to flick the switch a total of 37 times before losing interest. Will the light be on or off at the end of that?

This pattern is even simpler than the previous "cyclical" patterns we've seen, but it is a cyclical pattern: the switch is initially off, then on, then off, then on, repeated 37 times. Every time the child flicks the switch twice, it returns to its initial state. So again: the *number* of times the child flicks the switch does not matter, but something else does (what, exactly?).

In this example: the light will be **on**, since 37 is an odd number! It's on after he flicks it once, off after he does it twice, on again after 3 times, off again after 4, etc. At even numbers, the light is off, and at odd numbers, the light is on.

# Modular Arithmetic

All of these examples illustrate the same concept of a cyclical version of addition. This concept is formalized as the study of **modular arithmetic**. Let's make some definitions

**Definition**: Let $n, m \in \mathbb{Z}$. We say $m$ **divides** $n$ if there is an integer $k$ such that $n = mk$. We write this as $m \divides n$.

**Definition**: Let $n \in \mathbb{N}$, $n > 0$, and $x, y \in \mathbb{Z}$. Then $x \equiv y$ (mod $n$) if $n$ divides $x - y$. We say "$x$ is congruent to $y$ modulo $n$".

Some examples: 

* $365 \equiv 1$ (mod 7), because $365 - 1 = 7 \times 52$.
* $37 \equiv 1$ (mod 2), because $37 - 1 = 2 \times 18$.
* $20 \equiv 8$ (mod 12), because $20 - 8 = 12 \times 1$.

**Exercises**:

1. Write down 4 numbers which are congruent to 2 modulo 3.
2. Is $18 \equiv 9$ (mod 2)? What about modulo 3? Modulo 4?

## Congruence Modulo 2

Before we study the general theory, let's look at the example of $n = 2$ which should be familiar.

**Claim**: For any two integers $x$ and $y$, then $x \equiv y$ (mod 2) if and only if both are even or both are odd.

Recall that by "even" we mean "is a multiple of 2", and by "odd" we mean "is 1 more than a multiple of 2".

**Proof**: Suppose $x \equiv y$ (mod 2). Then $x - y$ is a multiple of 2, and is therefore even. If $x$ is even and $x - y$ is even, then $x = 2k$ and $x - y = 2m$ for some integers $k$ and $m$. Then, solving for $y$, we get that $y = 2(k - m)$, which is an even number.

Similarly, if $x$ is odd, then $x = 2k + 1$ for some integer $k$. Since $x - y$ is a multiple of 2, then there is $m$ such that $x - y = 2m$. Again, solve for $y$ and we get $y = 2k + 1 - 2m = 2(k - m) + 1$, which is an odd number.

Vice versa, if $x$ and $y$ are both even, then there are integers $k$ and $m$ such that $x = 2k$ and $y = 2m$. Therefore $x - y = 2(k - m)$, which is even. If $x$ and $y$ are both odd, then there are $k$ and $m$ such that $x = 2k + 1$ and $y = 2m + 1$. So $x - y = 2(k - m)$, which is even.

## Addition Modulo 2

What does this mean for congruences modulo 2? Since 0 is even and 1 is odd, this means that for any number $x$, either $x \equiv 0$ (mod 2)$ or $x \equiv 1$ (mod 2).

Moreover, from elementary school, we might remember some rules for adding even and odd numbers:

* Even + Even = Even
* Even + Odd = Odd
* Odd + Odd = Even

This are reflected in these statements:

* $0 + 0 \equiv 0$ (mod 2)
* $0 + 1 \equiv 1$ (mod 2)
* $1 + 1 \equiv 0$ (mod 2). 

This last one is because $2 \equiv 0$ (mod 2). So, for example, if my son (I mean, the hypothetical toddler in an earlier section) were to flick a light switch 25 times, forget about it for a little while, and then flick it again 59 times, the switch would return to its initial state.

But this pattern is an interesting example of a more general result: if $a \equiv x$ (mod $n$) and $b \equiv y$ (mod $n$), then $a + b \equiv x + y$ (mod $n$). That is, in this example, when we add two odd numbers, we ended up with an even number (congruent to 0). We could have used the fact that all odd numbers are congruent to $1$ modulo 2, and then just add 1 + 1.

## Modular Addition

Let's prove the theorem we mentioned in the previous section here.

**Theorem**: Let $a, b, x, y \in \mathbb{Z}$ and $n \in \mathbb{N}$, $n > 1$. If $a \equiv x$ (mod $n$) and $b \equiv y$ (mod $n$), then $a + b \equiv x + y$ (mod $n$).

**Proof**:

Suppose $a \equiv x$ (mod $n$) and $b \equiv y$ (mod $n$). Then there are integers $k$ and $m$ such that $a - x = kn$ and $b - y = mn$. We want to show that $a + b \equiv x + y$ (mod $n$). So let's look at $(a + b) - (x + y)$.

Notice that $(a + b) - (x + y)$ could be re-written as $(a - x) + (b - y)$. Using our assumptions, this is equal to $kn + mn = (k + m)n$. That is, $n$ divides $(a - x) + (b - y)$. Since this is the same value as $(a + b) - (x + y)$, then $a + b \equiv x + y$ (mod $n$).

**Example**: Let's look at addition modulo 3 now. 

Without proving it, I will just state that modulo 3, all numbers are congruent to exactly one of 0, 1, or 2. That is: if $x$ is a multiple of $3$, then $x \equiv 0$ (mod 3). So for example, $0, 3, 6, 9, \ldots$ are all congruent to 0 modulo 3.

If $x$ is 1 more than a multiple of $3$, then $x \equiv 1$ (mod 3). These include 1, 4, 7, 10, etc. And if $x$ is 2 more than a multiple of $3$, then $x \equiv 2$ (mod 3). These inclue 2, 5, 8, 11, etc.

Modulo 3, the rules for addition are given by the facts that $0 + x = x$ for any number $x$, and the following:

* $1 + 1 \equiv 2$ (mod 3)
* $1 + 2 \equiv 0$ (mod 3)
* $2 + 2 \equiv 1$ (mod 3)

Let's look at a couple of examples:

* 7 and 10 are both congruent to 1 modulo 3. Adding them, we get 17, which is 2 more than 15 (a multiple of 3), and so $7 + 10 \equiv 2$ (mod 3)
* 25 is congruent to 1 modulo 3, and -1 is congruent to 2 modulo 3. Adding them, we get 24, which is congruent to 0 modulo 3.
* 8 and 32 are both congruent to 2 modulo 3. Adding them we get 40, which is 1 more than 39. So $8 + 32 \equiv 1$ (mod 3).

## div and mod operators

Before we do any exercises, we will state a theorem (without proof, perhaps this could be presented by a student) that will allow us to define the two important "integer division" operators: "div" and "mod"

**Theorem**: Let $n \in \mathbb{Z}$ and $d \in \mathbb{N} \setminus \{ 0 \}$. Then there are unique integers $q$ and $r$ such that $n = qd + r$ and $0 \leq r < d$.

**Definition**: Let $n \in \mathbb{Z}$ and $d \in \mathbb{N} \setminus \{ 0 \}$. Then $n$ **div** $d = q$ and $n$ **mod** $d = r$ if $q$ and $r$ satisfy the conclusion to the theorem above. That is, if $q$ and $r$ are the unique integers satisfying both $n = qd + r$ and $0 \leq r < d$.

That is: **div** gives you the quotient, when you divide, and **mod** gives you the remainder.

In the Java, C, and C++ programming languages, for example, these correspond to the / and % operators for the **int** data type.

**Examples**: 

1. For $n = 20$ and $d = 7$: 20 **div** 7 = 2, and 20 **mod** 7 = 6, because $20 = 7 \times 2 + 6$.
2. For $n = -1$ and $d = 3$: -1 **div** 3 = -1 and -1 **mod** 3 = 2, because $-1 = 3 \times -1 + 2$.

**Exercises**: Compute $n$ **div** $d$ and $n$ **mod** $d$ for the following:

1. $n = 28$ and $d = 6$.
2. $n = -7$ and $d = 4$.
3. $n = -1$ and $d = 5$.

<details>
    <summary>Check your answers</summary>
    <ol>
        <li>Since $28 = 6 \times 4 + 4$, 28 <strong>div</strong> 6 = 4 and 28 <strong>mod</strong> 6 = 4.</li>
        <li>Since $-7 = 4 \times (-2) + 1$, -7 <strong>div</strong> 4 = -2 and -7 <strong>mod</strong> 4 = 1.</li>
        <li>Since $-1 = 5 \times (-1) + 4$, -1 <strong>div</strong> 5 = -1 and -1 <strong>mod</strong> 5 = 4.</li> 
    </ol>
</details>

## Adding Remainders

Let's go back to one of the types of questions we started with: if it's currently 9:00, what time will the clock show in 50 hours?

There are two ways to try to answer this question: first, we can add 9 + 50, and then reduce modulo 12 (since the hour hand cycles around every 12 hours). But there is another way: reduce 50 modulo 12 first, and then add. That is, since 50 **mod** 12 = 2 ($50 = 12 \times 4 + 2$), then we just need to add 9 + 2 to see that it will be 11:00.

In general, to add numbers $x + y$ (mod $n$), we can first look at $x$ **mod** $n$ and $y$ **mod** $n$ and then add those remainders.

**Exercises**: Reduce each number to determine if the following congruences are true or false:

1. $37 + 25 \equiv 3$ (mod 4)
2. $21 + 18 \equiv 4$ (mod 5)
3. $7 + 16 \equiv 2$ (mod 3)

<details>
    <summary>Check your answers:</summary>
    <ol>
        <li>37 mod 4 = 1, and 25 mod 4 = 1, so $37 + 25 \equiv 2$ (mod 4). This is <strong>false</strong>.</li>
        <li>21 mod 5 = 1, and 18 mod 5 = 3, so $21 + 18 \equiv 4$ (mod 5). This is <strong>true</strong>.</li>
        <li>7 mod 3 = 1 and 16 mod 3 = 1, so $7 + 16 \equiv 2$ (mod 3). This is <strong>true</strong>.</li>
    </ol>
</details>

# Congruence Classes

Notice for modulo 2, every integer is either congruent to 0 or 1, and no integer is congruent to both of those. In other words, the set of all integers congruent to 0, and the set of all integers congruent to 1, are **disjoint**: that is, they do not intersect. Also, all integers are in one or the other of those sets.

Similarly: every integer is congruent to 0, 1, or 2 modulo 3. No integer is congruent to more than one of these.

In general, for a number $n$, there are exactly $n$ **congruence classes** modulo $n$. A congruence class modulo $n$ is a set $X$ such that all numbers in $X$ are congruent to each other (modulo $n$), **and** every number that is congruent to any element of $X$ is in $X$. That is:

* $E = \\{ x : x$ is an even integer $ \\}$ is the congruence class of those integers congruent to 0 modulo 2.
* $X = \\{ 1, 4, 7 \\}$ is not a congruence class modulo 3, since $10 \equiv 1$ (mod 3), but $10 \not \in X$.

Congruence classes are a generalization of the ideas of "even" and "odd" numbers. Even and odd numbers are the congruence classes of 0 and 1 modulo 2, respectively. You can think of congruence classes by looking at the remainders you get when you divide the numbers in that class by $n$. For each possible remainder $r$ from $0$ to $n - 1$, there is a distinct congruence class corresponding to that remainder.

For example, if $n = 4$, there are 4 classes: those numbers which are divisible by 4, those which are congruent to 1 modulo 4, those which are congruent to 2 modulo 4, and those which are congruent to 3 modulo 4. We refer to 0, 1, 2, and 3 as **representatives** of their congruence classes. That is, 3 is the representative of the class containing 3, 7, 11, 15, etc (as well as -1, -5, -9, etc). Each congruence class is infinite.

Notice that congruences are symmetric and transitive. That is: $7 \equiv 3$ (mod 4), since $4$ divides $7 - 3$, but also $3 \equiv 7$ (mod 4), becuase $4$ also divides $3 - 7$. Moreover, congruences **must** be symmetric and transitive if they are to have the properties I mentioned earlier: any two numbers in a congruence class are congruent to each other, and every number congruent to any of those is in that same class. 

That is, if $x \equiv y$ (mod $n$) and $y \equiv z$ (mod $n$), then $x$, $y$, and $z$ should be in the same class. But then that would mean that they should all be congruent to each other (no matter which one you look at first)!

**Exercises**:

1. Find 3 positive and 3 negative numbers that lie in the same congruence class as 7 modulo 4.
2. Find 3 positive and 3 negative numbers that lie in the same congruence class as 10 modulo 5.

## Adding Congruence Classes

Remember the rules for adding even and odd integers:

* Even + Even = Even
* Even + Odd = Odd
* Odd + Odd = Even

In the language of congruence classes, this really refers to the fact that addition of integers modulo 2 **only** depends on the congruence classes of the two numbers we are adding. This is a more general fact, which we've already proved: addition of numbers modulo $n$ really just boils down to knowing how to add the numbers $0$ through $n - 1$ modulo $n$. That is, it boils down to knowing the addition table.

Here is an example of an addition table modulo $4$:

$$
\begin{array}{c|c|c|c|c}
+ & 0 & 1 & 2 & 3 \\
\hline
0 & 0 & 1 & 2 & 3 \\
1 & 1 & 2 & 3 & 0 \\
2 & 2 & 3 & 0 & 1 \\
3 & 3 & 0 & 1 & 2
\end{array}
$$

Do you see the cyclic nature of this table?

**Exercise**: Fill in the following table for addition modulo 5:

$$
\begin{array}{c|c|c|c|c|c}
+ & 0 & 1 & 2 & 3 & 4\\
\hline
0 & 0 & - & - & - & - \\
1 & 1 & - & - & - & - \\
2 & 2 & - & - & - & - \\
3 & 3 & - & - & - & - \\
4 & 4 & - & - & - & -
\end{array}
$$