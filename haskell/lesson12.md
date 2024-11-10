# Topics in Advanced Computing Lesson 12: Monads
{:.no_toc}

1. Table of Contents
{:toc}

# PS 2 Solutions

point-full:

```haskell
prependAll x list = map (x:) list
```

Not quite point-free:

```haskell
prependAll x = map (x:)
```

Point-free:

```haskell
prependAll = map . (:)
```


```haskell
p :: Num a => [[a]]
p = [1] : [1 : zipWith (+) l (tail l) ++ [1] | l <- p ]
```

zipWith, tail, and list comprehensions...

```haskell
n = foldr (\x acc -> x : filter (/= x) acc) []
```

* Right-fold vs left-fold here.
* Keeping it in the correct order.
* `:` vs `++` vs reverse.

# Finishing up

[lookup3 exercise](lesson11.html#monads)

# do keyword

`do` syntax works with Monads (just as it did with IO). Same idea: glue monadic values in a sequence.

```haskell
f x = Just (show x ++ "!")
Just 3 >>= f
```

What if we had another function?

```haskell
f :: Maybe String
f = Just 3 >>= (\x ->
    Just "!" >>= (\y ->
    Just (show x ++ y)))
```

Instead, with do syntax:

```haskell
f :: Maybe String
f = do
  x <- Just 3
  y <- Just "!"
  Just (show x ++ y)
```

**Exercise**: This is kind of what we did in `lookup3`. Rewrite lookup3 using do syntax.

What happens in the following:

```haskell
:{
do
  x <- Just 3
  y <- Just 8
  Nothing
  return (x + y)
:}
```

# Monad laws

* Left identity: `return x >>= f` is the same as `f x`
  * Ex: `f x = Just (2 * x)`, try this with `return 3 >>= f` vs `f 3`.
* Right identity: `m >>= return` is just `m`.
  * Ex: try with `Just 3 >>= return`
* Associative: `(m >>= f) >>= g` is the same as `m >>= (\x -> f x >>= g)`
  * applying g after f is like composing.

# List Monad

# Take stock

What actually is a monad? What does the term mean?

* Category theory: some kind of special functor.
* Haskell: ???

Really: accessing a value of a certain type, where "unrestricted" access might not make sense. Adds some *context* to a type:

* Maybe: failure status
* Lists: non-determinism
* IO: need to wait for the IO action to complete.

Let's see a couple more examples.

# Writer

# Functions

# State Monad



