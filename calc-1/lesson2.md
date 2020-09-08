# Calculus I Lesson 2

Last time, we discussed the notion of limits informally. In this lesson, you will first go through a Desmos activity on your own, and then come back here and go through some exercises.

# Desmos Activity

Before reading the rest of these notes, please go through this [interactive activity on Desmos](https://student.desmos.com/join/kfm243). Please use your **real name** for **attendance purposes**, though I can/will make all responses anonymous.

# Wrap up

Let $f(x)$ be a function. Then $\lim_{x \rightarrow a} f(x)$ is read "the limit as x approaches a of $f(x)$". We've seen a few things already:

First of all: limits do not always exist! Some functions do not "approach" anything near a given point. This was fascinating to me as a student: I never knew that it was possible for something in mathematics to just "not exist".

Secondly, a function can approach different values if we approach $a$ from the left and from the right. This is why we define the "left" and "right" side limits:

* $\lim_{x \rightarrow a^-} f(x)$ means "The limit as $x$ approaches $a$, from the left, of $f(x)$". I will often, informally, refer to this as the "left hand limit".
* $\lim_{x \rightarrow a^+} f(x)$ means "The limit as $x$ approaches $a$, from the right, of $f(x)$". I will often, informally, refer to this as the "right hand limit".

If both of these **one-sided** limits exist and are equal to each other, then $\lim_{x \rightarrow a} f(x)$ exists, and is the same as both of those one-sided limits. I will often, informally, refer to $\lim_{x \rightarrow a} f(x)$ as the "two-sided" limit.

Thirdly, a function can approach a limit that is different from the actual value of the function. That is, it's possible for $\lim_{x \rightarrow a} f(x)$ to exist, but to be different from $f(a)$. This often happens when we have a "hole" in the graph of the function.

Lastly, the best possible behavior regarding limits of a function is if the function simply approaches the actual value of the function there. That is, if $\lim_{x \rightarrow a} f(x) = f(a)$. Obviously this option is quite nice, and so we will often want functions that have this behavior. We will call this property *continuity*, and this will be an important subject during this semester.

Before we close, let's go through some exercises involving *piecewise functions*, functions whose values are determined differently on different parts of their domains.

## Exercise

For the following functions, find the left-hand, right-hand, and two-sided limits, if they exist:

1. Find $\lim_{x \rightarrow 0^+} f(x)$, $\lim_{x \rightarrow 0^-} f(x)$, and $\lim_{x \rightarrow 0} f(x)$ for $$f(x) = \begin{cases} -x &\mbox{if } x < 0 \\ 2x &\mbox{if } x \geq 0 \end{cases}$$.
2. Find $\lim_{x \rightarrow 1^-} g(x)$, $\lim_{x \rightarrow 1^+} g(x)$, and $\lim_{x \rightarrow 1} g(x)$ for $$g(x) = \begin{cases} 0 &\mbox{if } x = 1 \\ 1 &\mbox{if } x \neq 1 \end{cases}$$.
