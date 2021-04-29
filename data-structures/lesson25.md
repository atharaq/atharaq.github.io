# Data Structures Lesson 25: Dynamic Programming
{:.no_toc}

1. Table of Contents
{:toc}

# Lambda expressions

To wrap up some discussion from last time, what happens when we pass a "lambda" expression as a parameter to a method? For example, recall our `Operator` enum had a constructor that looked like:

```java
Operator(String o, IntBinaryOperator oper) {
  op = o;
  operator = oper;
}
```

We "initialized" several enum constants using lambda expressions. For example: `TIMES("x", (x, y) -> x*y)`. How do we pass code as an object?

The key is that the `IntBinaryOperator` interface declares a single method. This is what's called a [functional interface](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description). A lambda expression can be used whenever we need an object whose type is a *functional interface* (an interface which just declares one method). Then the lambda expression is matched to the method declared in that interface.

Prior to Java 8, the only way to do something like this was to use "anonymous" classes:

```java
IntBinaryOperator op = new IntBinaryOperator() {
  @Override
  public int applyAsInt(int left, int right) {
    return left * right;
  }
};
```

(It turns out that these are [not exactly equivalent](https://www.logicbig.com/tutorials/core-java-tutorial/java-8-enhancements/java-lambda-functional-aspect.html) in terms of what's actually happening, but it's close enough.)

# Dynamic Programming

Today we will be exploring dynamic programming. This is a technique used to reduce the number of recursive calls needed in certain algorithms.

To start, download the DynamicProgramming.zip project from Moodle and open it in IntelliJ.

# Fibonacci

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/ZfeO7jiVjbM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Go through the Fibonacci code. I have two implementations: a regular recursive solution and a dynamic programming solution (using what is called "memoization"). Run the main method and see the timestamps for both. Notice how much faster the dynamic fib method is.

## Analysis

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/UmsJHU_tkSY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Let's try to analyze the recursive Fibonacci method.

```java
int fib(int n) {
    if (n <= 1) return n;
    return fib(n - 1) + fib(n - 2);
}
```

How many steps does this take? Let $T(n)$ be the running time of this method on input $n$. Notice, of course, that $T(n) = T(n - 1) + T(n - 2) + O(1)$: in order to find the running time on input $n$, you need to know how long `fib(n-1)` and `fib(n-2)` would take.

This recurrence is, of course, the same as the recurrence for the Fibonacci sequence itself. So this grows as fast as the Fibonacci sequence. If you didn't know, the Fibonacci sequence grows exponentially!

What happens with the dynamic method?

```java
int dynamicFib(int n, int[] cache) {
    if (n <= 1) return n;
    if (cache[n - 1] == -1) {
        cache[n - 1] = dynamicFib(n - 1, cache);
    }
    if (cache[n - 2] == -1) {
        cache[n - 2] = dynamicFib(n - 2, cache);
    }
    return cache[n - 1] + cache[n - 2];
}
```

In this case, `fib(n)` will call `fib(n-1)`, which will call `fib(n-2)`, and that recursion will continue until it calls `fib(1)` and `fib(0)`. Then:

* `fib(0)` will be stored in `cache[0]`
* `fib(1)` will be stored in `cache[1]`
* `fib(2)` will be stored in `cache[2]`
* `fib(3)` will be stored in `cache[3]`
* etc.

We won't need to keep making these recursive calls. In other words, we'd only make about $n$ recursive calls, and so our running time would be $O(n)$.

## Bottom-up

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/bDqzrTq_7D0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

The implementation I gave is a "top-down" dynamic programming algorithm: we start with the big problem we want to solve, work our way down, checking a "cache" if we've already asked that question before.

We could, instead, start from the bottom-up: we know fib(0) and fib(1), and so working our way up we can compute fib(2), fib(3), etc until we get to fib(n). Implement and benchmark this version. This is iterative now, not recursive.

This version should also run in $O(n)$ time. But, if you write it properly, it might be a little bit faster than the dynamic fibonacci method. Any idea why?

(Hint: there is overhead involved in calling methods.)

# Edit Distance (Optional)

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/VFVuurksI70" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Lastly, take a look at the Edit Distance code. The "edit distance" between two words is the number of character insertions or removals needed to go from one word to the next. Notice that this is slightly different, and easier, than the "edit distance" problem talked about previously in the semester. That problem involved needing the intermediate words to actually be in the dictionary..

I implemented a recursive solution to this problem. It works as follows:

* For the base cases, if one string is "empty", then we need to insert all the characters of the other string.
* If two strings have the same last character, then the edit distance between the two strings is the same as the edit distance between the two shorter strings where we ignore that last character.
* Otherwise, we look at all possible one-character edits and take the minimum of them all.

See if you can figure out how to get either a top-down or bottom-up dynamic programming solution working.

# Reminder

Please get started researching for your presentations / papers! Let me know ASAP what your group will be working on.
