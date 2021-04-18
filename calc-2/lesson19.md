# Calculus II Lesson 19: Infinite Series
{: .no_toc}

1. Table of Contents
{:toc}

# Achilles and the Tortoise

[Zeno of Elea](https://en.wikipedia.org/wiki/Zeno_of_Elea) was a Greek philosopher famous for his "Paradoxes of Motion". He posed several of these paradoxes, but I wanted to discuss the [paradox of Achilles and the Tortoise](https://plato.stanford.edu/entries/paradox-zeno/#AchTor):

> The [second] argument was called “Achilles,” accordingly, from the fact that Achilles was taken [as a character] in it, and the argument says that it is impossible for him to overtake the tortoise when pursuing it. For in fact it is necessary that what is to overtake [something], before overtaking [it], first reach the limit from which what is fleeing set forth. In [the time in] which what is pursuing arrives at this, what is fleeing will advance a certain interval, even if it is less than that which what is pursuing advanced …. And in the time again in which what is pursuing will traverse this [interval] which what is fleeing advanced, in this time again what is fleeing will traverse some amount …. And thus in every time in which what is pursuing will traverse the [interval] which what is fleeing, being slower, has already advanced, what is fleeing will also advance some amount. (Simplicius, *On Aristotle’s Physics*)

Suppose we have a $100m$ race between Achilles (a hero) who can run fast, and a Tortoise (a very slow animal). For the sake of argument, suppose Achilles can run at a speed of $5 m/s$, while the Tortoise can run at a speed of $0.5 m/s$. To make the race fair, we can have the Tortoise have a $50m$ head start. Zeno claims that Achilles will never catch up to the Tortoise!

* First, Achilles will need to run the $50m$ it was behind the Tortoise.
* In that time, the Tortoise will have moved some amount $x_1$.
* Then Achilles needs to run $x_1$ meters to catch up to where the Tortoise was.
* In that time, the Tortoise will have moved some amount $x_2$.
* Keep going: Achilles will *never* catch up to the Tortoise, because as soon as he catches up to where the Tortoise was, the Tortoise will have moved (albeit a small amount) forward.

(picture)

Where does this argument go wrong? Let's do some actual math here, knowing that Achilles runs $5 m/s$, the Tortoise runs $0.5 m/s$, and the Tortoise is initially $50m$ ahead of Achilles:

* It takes $10s$ for Achilles to catch up to the Tortoise's starting position.
* In that time, the Tortoise moves $5m$.
* It takes $1s$ for Achilles to catch up to this position.
* In that time, the Tortoise moves $0.5m$.
* It takes $0.1s$ for Achilles to catch up to this position.
* In that time, the Tortoise moves $0.05s$.
* etc.

(picture)

In other words, Achilles will catch up to the Tortoise after $10 + 1 + 0.1 + 0.01 + \ldots$ seconds! This is an infinite sum. But it is an actual number: it's just $11.111\ldots$. This number can be expressed as a mixed fraction: $11 \frac{1}{9}$. Certainly after 11.5 seconds, Achilles will have overtaken the Tortoise!

The key issue in this paradox is that the mathematical tool of being able to add up infinitely many numbers together, and still get a finite amount, was not known to the Ancient Greeks. What does $11.111\ldots$ even mean? What does it mean to add up infinitely many numbers? This is the topic we will explore in today's lesson.

# Infinite Series

How do we define the notion of adding up infinitely many numbers? The sum of infinitely many numbers is called an **infinite series**, and we can make this notion rigorous using limits:

**Definition**: Let $(a_n)$ be an infinite sequence. For each $n$, let $s_n = \sum\limits_{i=0}^{n} a_i$, the "$n$-th partial sum". That is: $s_n = a_0 + a_1 + \ldots + a_n$. Then

$$\sum_{n=0}^{\infty} = \lim_{n \rightarrow \infty} s_n$$

If the limit exists, we say $\sum\limits_{n=0}^{\infty} a_n$ **converges**. Otherwise, it **diverges**.

## Geometric Series

## Examples

## Geometric Argument

# Geometric Series Test / Formula

## $0.999\ldots$

# Divergence Test

## Converse?

# Integral Test

# Homework
