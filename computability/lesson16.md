# Computability Lesson 16: Set Theory / Cardinality
{:.no_toc}

1. Table of Contents
{:toc}

# Warm up

Recall that a set $X$ is countably infinite if there is a bijection $f : \mathbb{N} \to X$. We would write $\|X\| = \aleph_0$. Show that the following sets a countably infinite by finding bijections from $\mathbb{N}$ to the following sets:

1. $\mathbb{N} \setminus \\{ 0 \\}$.
2. $E = \\{ 0, 2, 4, 6, \ldots \\}$.
3. $O = \\{ 1, 3, 5, 7, \ldots \\}$.

## Unions of countable sets

**Theorem**: The union of two countably infinite sets is countably infinite.

**Proof**: Suppose $A$ and $B$ are countably infinite. Assume that $A \cap B = \emptyset$ (the more general case is also true) Let $f : \mathbb{N} \to A$ and $g : \mathbb{N} \to B$ be bijections. Then we define $h : \mathbb{N} \to A \cup B$ separately on the even and odd numbers, by letting $h(2n) = f(n)$ and $h(2n + 1) = g(n)$. (Does this actually define $h$ on all natural numbers $n$?)

I claim that $h$ is a bijection. First: $h$ is one to one. Suppose $h(n) = h(m)$. First note that for all $n$, if $n$ is even, then $h(n) \in A$ and if $n$ is odd, $h(n) \in B$. Since $A \cap B = \emptyset$, then if $n$ is even and $m$ is odd, then $h(n) \neq h(m)$ since there is nothing in both sets.

Suppose $n$ is even. Then $h(n) = f(\frac{n}{2})$. By the above argument, $m$ must also be even, and so $h(m) = f(\frac{m}{2})$. Since $h(n) = h(m)$, this means $f(\frac{n}{2}) = f(\frac{m}{2})$. But since $f$ is a bijection, then $\frac{n}{2} = \frac{m}{2}$. But then $n = m$.

Similarly, we can show that if $n$ is odd, them $m$ is odd and $n = m$.

Now we show that $h$ is onto. Suppose $y \in A \cup B$. Then either $y \in A$ or $y \ in B$. Suppose $y \in A$. Since $f$ is onto, there is $n \in \mathbb{N}$ such that $f(n) = y$. Then $h(2n) = y$. If $y \not \in A$, then $y \in B$, and since $g$ is onto, there is $n \in \mathbb{N}$ such that $g(n) = y$. But then $h(2n + 1) = y$. So whether $y \in A$ or $y \in B$, there is some $x \in \mathbb{N}$ such that $h(x) = y$.

## $\mathbb{Z}$

Let's use this previous theorem to show that $\mathbb{Z}$ is countably infinite.

First, note that $\mathbb{Z}$ is the union of the natural numbers $\mathbb{N}$ and the set of all negative integers $\\{ -1, -2, -3, \ldots \\}$. But since $\mathbb{N}$ is countable, we just need to show that the set of all negative integers $\\{ -1, -2, -3, \ldots \\}$ is countable, and then by the theorem above, their union would also be countably infinite!

Define $f : \mathbb{N} \to \\{ -1, -2, -3, \ldots \\}$ by $f(n) = -1 - n$. Then $f(0) = -1, $f(1) = -2$, $f(2) = -3$, etc.

**Claim**: $f$ is a bijection.

First: $f$ is one to one, since if $f(n) = f(m)$, then $-1 - n = -1 - m$. Do a little algebra and you can convince yourself then that $n = m$.

Next: we show that $f$ is onto. That is, we show that if $y$ is a negative integer, we can find some $n \in \mathbb{N}$ such that $-1 - n = y$. Solve for $n$ here and get that $n = -1 - y$. If $y$ is negative, that is, $y < 0$, then $-y > 0$, and so $-1 - y > -1$. But since $y$ is an integer, then $-1 - y$ would then be an integer that is greater than -1; that is, it could be $0, 1, 2, \ldots$

So for any negative integer $y$, $f(-1 - y) = y$, and, moreover, $-1 - y \in \mathbb{N}$, so $f$ is onto!

## Alternate Proof

Alternatively, since cardinality is transitive, we could show that $\mathbb{Z}$ is countably infinite by showing that the set of negative integers can be put into bijection with $\mathbb{N} \setminus \\{ 0 \\}$. Since we know that $\mathbb{N} \setminus \\{ 0 \\}$ is countably infinite, then the set of negative integers would also be countably infinite. And then the union of the negative integers and the set of natural numbers is the integers, thereby showing that the integers are also countably infinite.

So to see this, we can define $f : \mathbb{N} \setminus \\{ 0 \\} \to \\{ -1, -2, -3, \ldots \\}$ by $f(n) = -n$. Can you prove that this is one to one and onto?

## $\mathbb{Q}$

The fact that the integers are countably infinite boils down to this fact: we can list all integers in an *infinite sequence*, such that each integer shows up at some *finite* position (and shows up exactly once). We list the integers as $0, -1, 1, -2, 2, -3, 3, -4, 4, \ldots$ We could turn this "infinite sequence" into an explicit function $h : \mathbb{N} \to \mathbb{Z}$, but the actual rule is not so important as the fact that there is a way to list these numbers out.

The caveat here that each integers shows up at a finite position is important. The listing $0, 1, 2, 3, \ldots, -1, -2, -3, -4, \ldots$ is not a valid "infinite sequence" in this sense. At which position does $-2$ show up?

Now let's consider the rational numbers $\mathbb{Q} = \\{ \frac{m}{n} : m, n \in \mathbb{Z}, n \neq 0 \\}$. Are the rational numbers also countably infinite? Is there a way to list out all rational numbers in an infinite sequence? It's not entirely obvious: if we start by listing out all the integers, we will miss out on numbers likes $\frac{1}{2}, \frac{3}{2}$, etc. If we start by listing out all the numbers whose denominator is $2$, we will miss out on $\frac{1}{3}$.

It's not clear at all how we might do this! One would be forgiven for believing there is no way to list out all rational numbers in an infinite sequence. But there is a way!

For now, we will only list out the positive rational numbers. The first step is to write out all possible rational numbers in an infinite 2-dimensional array. The number on the $m$-th row and $n$-th column will be $\frac{m}{n}$:

$$
\begin{array}{ccccc}
\frac{1}{1} & \frac{1}{2} & \frac{1}{3} & \frac{1}{4} & \frac{1}{5} \ldots \\
\frac{2}{1} & \frac{2}{2} & \frac{2}{3} & \frac{2}{4} & \frac{2}{5} \ldots \\
\frac{3}{1} & \frac{3}{2} & \frac{3}{3} & \frac{3}{4} & \frac{3}{5} \ldots \\
\frac{4}{1} & \frac{4}{2} & \frac{4}{3} & \frac{4}{4} & \frac{4}{5} \ldots \\
\frac{5}{1} & \frac{5}{2} & \frac{5}{3} & \frac{5}{4} & \frac{5}{5} \ldots \\
\vdots
\end{array}
$$

Then start at the top left and "spiral around", ignoring fractions which can be reduced. So we end up with the listing: $1, 2, \dfrac{1}{2}, \dfrac{1}{3}, 3, 4, \dfrac{3}{2}, \dfrac{2}{3}, \dfrac{1}{4}, \ldots$

This spiraling is visualized in the following image: start at 1/1 on the top left, and then follow along the arrows, ignoring numbers that can be reduced (these are pointed out in red). Every rational number, expressed as $\dfrac{p}{q}$ in simplest form, will show up in this array on the $p$-th row and $q$-th column, and that position will be seen in finitely many steps. So that means this infinite listing we have will list out all positive rational numbers.

![Rationals are countable](https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Diagonal_argument.svg/485px-Diagonal_argument.svg.png "Rationals are countable")

## Number of TMs

How many Turing Machines are there? Recall: a TM is a 7-tuple $(Q, \Sigma, \Gamma, \delta, q_0, q_a, q_r)$. $Q$, $\Sigma$, and $\Gamma$ are all finite sets. For now, let's fix $\Sigma = \\{ a \\}$ and $\Gamma = \\{ a, \sqcup, \dot a \\}$ (maybe we need to add in a few more symbols to $\Gamma$, but probably not too many).

There are actually many, many finite sets $Q$. But we can really just restrict to thinking about $Q$ be sets of numbers of the form $\\{ 0, 1 , \ldots, n - 1 \\}$. Then the question would be: how many functions $\delta$ are there? Of course, there are only finitely many functions between finite sets. So that means there are only finitely many TMs with 2 states, finitely many TMs with 3 states, finitely many with 4 states, etc.

So we can list them all out, and in that way get a bijection from $\mathbb{N}$ to the set of all TMs! That is:

* $f(0) =$ the first TM in our list
* $f(1) =$ the second TM in our list
* $f(2) =$ the third TM in our list

etc.

This set is countably infinite!

## Number of Languages

Let's fix $\Sigma = \\{ a \\}$. Each language $\mathcal{L} \subseteq \Sigma^\*$ canonically corresponds to some set $A \subseteq \mathbb{N}$. Just let $A$ be the set of all *lengths* of words in $\mathcal{L}$ (or vice versa: given a set of numbers $A$, let $\mathcal{L} = \\{ a^n : n \in A \\}$).

That means that the **cardinality** of the set of all languages over $\Sigma^\*$ is the same as the cardinaliyt of the set of all *subsets* of $\mathbb{N}$. In other words, it's the same as the cardinality of $\mathcal{P}(\mathbb{N})$.

We've seen many infinite sets today: all of them can be put in bijection with $\mathbb{N}$. But it turns out that not *every* infinite set is countably infinite! There are **uncountable** infinite sets as well! $\mathcal{P}(\mathbb{N})$ is one example of such an uncountable set. That means: there is no bijection between $\mathbb{N}$ and $\mathcal{P}(\mathbb{N})$!

# Cantor's Diagonal Argument

So after studying all of these sets, we may be forgiven for thinking that all infinite sets can be put in one to one correspondence with each other. Throughout history, most mathematicians believed this! If a set is infinite, it never ends, so of course you can match it up with another set that doesn't end, right?

But this informal reasoning does not pan out. We have a rigorous definition of a one to one correspondence: a bijection. Is there a set which is "too large" to be put in bijection with the natural numbers $\mathbb{N}$? It turns out that the real numbers $\mathbb{R}$ is!


How might we prove that this set is not countable? Before we try to write a real proof, we can check that we don't know of any bijection between $\mathbb{N}$ and $\mathbb{R}$. For example, the function $f : \mathbb{N} \to \mathbb{R}$ given by $f(n) = \sqrt{n}$ is not a bijection: $\pi$ is not in the image of $f$.

But we need something stronger than just "Every function I've looked at is not a bijection." We need to show that there is **no** bijection $f : \mathbb{N} \to \mathbb{R}$. This is saying: "I can prove that, for every single function $f : \mathbb{N} \to \mathbb{R}$, something goes wrong."

That is, if I looked at a few functions, and showed that they weren't bijections, that's not enough. Maybe the square root example we thought of just wasn't clever enough. Perhaps we just weren't clever enough in coming up with the rule, like what happened with $\mathbb{Q}$? If we really want to prove that there is no bijection, we have to give an argument that works for every function $f : \mathbb{N} \to \mathbb{R}$.

That is, given a function $f : \mathbb{N} \to \mathbb{R}$, we have to show that $f$ is not a bijection. In fact, what we will show is that $f$ is not a surjection: it's not onto. We will argue in a very general way, so that this argument can be applied to every function from $\mathbb{N}$ to $\mathbb{R}$, thereby showing there is no surjection from $\mathbb{N}$ to $\mathbb{R}$.

The idea will be to find a real number $r$ which is different from $f(0)$, different from $f(1)$, different from $f(2)$, etc. This was **Cantor's Diagonal Argument**: if you list out the numbers $f(0), f(1)$ etc in a vertical table, you can find a real number that's not on that list by picking a number whose $n$-th digit after the decimal place is different from that of $f(n)$. To make this rule concrete, let's say that our number $r$ is defined by the following rule: if the $n$-th digit of $f(n)$ is equal to $1$, then the $n$-th digit of $r$ will be 2. Otherwise, the $n$-th digit of $r$ will be 1.

What does that mean? Let's look at an example. Suppose $f$ is given by the following table:

$$
\begin{align}
f(0) &= 0.131569108 \ldots \\
f(1) &= 2.718281828 \ldots \\
f(2) &= 3.141592653 \ldots \\
f(3) &= 1.741213562 \ldots \\
f(4) &= 2.618128176 \ldots \\
\vdots
\end{align}
$$

Let's look at the diagonal digits here:

$$
\begin{align}
f(0) &= \mathbf{0}.131569108 \ldots \\
f(1) &= 2.\mathbf{7}18281828 \ldots \\
f(2) &= 3.1\mathbf{4}1592653 \ldots \\
f(3) &= 1.74\mathbf{1}213562 \ldots \\
f(4) &= 2.618\mathbf{1}28176 \ldots \\
\vdots
\end{align}
$$

If we apply the diagonal argument, we end up with a number $r$ that starts off as $1.1122\ldots$. We know that this number we end up with cannot be on this list! That's because the number won't be equal to $f(n)$ for any $n$: at the $n$-th place after the decimal, $f(n)$ and $r$ are different!

This is a subtle argument: for each $f$, there is a *different* $r$ that we can find that is not in the image of $f$. So there is no way for a function $f : \mathbb{N} \to \mathbb{R}$ to be a surjection. In terms of cardinality, this means $\|\mathbb{R}\| \neq \aleph_0$.

