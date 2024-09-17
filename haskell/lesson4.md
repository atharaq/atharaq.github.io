# Topics in Advanced Computing Lesson 4: Tail Recursion
{:.no_toc}

1. Table of Contents
{:toc}

# Factorial

Classic recursive example: how do we implement the factorial function?

```haskell
fact 0 = 1
fact n = n * fact(n-1)
```

This works, but for larger n this triggers an exception:

> ghci> fact 1000  
> *** Exception: stack overflow

Why does this happen? When `fact 1000` is invoked, it keeps track of the number 1000, and then invokes `fact 999`, waiting for that to return so that it can multiply the result by 1000. This creates a new stack frame for the function call. That continues 999 more times!

How do we do better? What would we have done in Java? Use a loop instead:

```java
public int factorial(int n) {
  int f = 1;
  for (int i = 0; i < n; i++) {
    f *= (i + 1);
  }
  return f;
}
```

Unfortunately we don't have loops. But instead we can similarly build from the bottom-up.

```haskell
factorial n = tailFactorial 0 1 where
  tailFactorial i x
    | i == n = x
    | otherwise = tailFactorial (i + 1) (i+1)*x
```

What happens if we invoke `factorial 1000`? It immediately returns with an answer!

Wait...why does this work? Why doesn't this trigger a stack overflow? Doesn't `factorial 1000` call `tailFactorial 0 1` which calls `tailFactorial 1 1` which calls ...? Shouldn't there still be an overflow?

The answer is **tail call optimization**. GHC notices that the `tailFactorial` function is **tail recursive**. A function is **tail recursive** if it returns immediately after the recursive call returns. That is: `fact n = n * fact(n-1)` is not tail recursive, because after `fact(n-1)` returns, we still need to multiply by $n$. But `tailFactorial i x = tailFactorial (i+1) (i+1)*x` is tailRecursive, because after `tailFactorial (i+1) (i+1)*x` is done, the calling function can immediately return.

The upshot is that the compiler can perform an optimization: it doesn't need to create a *new* stack frame for every recursive call. Instead, it re-uses the same stack frame, just with updated parameters. This, essentially, makes the tail recursion like a loop.

## Exercises

Try to re-implement the following functions to be tail-recursive:

`sumUpTo n` should return the sum of the numbers from 0 to n. You can implement this recursively as:

```haskell
sumUpTo 0 = 0
sumUpTo n = n + sumUpTo (n-1)
```

**Exercise**: Re-do this using tail recursion.

`fibonacci n` should return the $n$-th Fibonacci number. You can implement this recursively as:

```haskell
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci (n-1) + fibonacci (n-2)
```

**Exercise**: Implement fibonacci using tail recursion.

`exp x n` takes a number $x$ and a non-negative integer $n$ and returns $x^n$. We can implement this recursively as:

```haskell
exp x 0 = 1
exp x n = x * exp x (n-1)
```

**Exercise**: Implement exp using tail recursion.

## Reading

Tail recursion is unfortunately not covered in our textbook. But [these notes](https://web.cs.dal.ca/~nzeh/Teaching/3137/haskell/recursion/tail_recursion/) cover the topic well.

