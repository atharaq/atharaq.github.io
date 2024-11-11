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

---

```haskell
p :: Num a => [[a]]
p = [1] : [1 : zipWith (+) l (tail l) ++ [1] | l <- p ]
```

zipWith, tail, and list comprehensions...

---

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

```haskell
instance Monad [] where
  return x = [x]
  xs >>= f = concat (map f xs)
  fail _ = []
```

Remember: the type of `>>=` is `m a -> (a -> m b) -> m b`. If `m` is `[]`, then this is `[a] -> (a -> [b]) -> [b]`.

So `f` has to be a function which takes an element and produces a list. So `map f xs` produces a list of lists, and then `concat` concatenates them all. Example: `f x = [x + 1, x - 1]`. What happens when we execute `[1..5] >>= f`?

**Idea**: The list monad represents *nondeterministic computations*: apply all functions to all inputs.

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

Use it for computations that return a value and accumulate a result; ex: logging. Defined in the `Control.Monad.Writer` module. Definition:

```haskell
newtype Writer w a = Writer { runWriter :: (a, w) }

instance (Monoid w) => Monad (Writer w) where
  return x = Writer (x, mempty) -- append nothing
  (Writer (x, v)) >>= f = let (Writer (y, v')) = f x in Writer (y, v `mappend` v') -- append to log
```

**Note: this definition is not quite correct anymore**. Upshot: when we instantiate a Writer, you can use the `writer` function (lowercase w) instead of the `Writer` constructor. 

`w` is the type of what we are logging (ex: lists of strings). `a` is the type of the computation.

Example:

```haskell
import Control.Monad.Writer  
  
logNumber :: Int -> Writer [String] Int  
logNumber x = writer(x, ["logging: " ++ show x]) -- note lowercase w!
  
multWithLog :: Writer [String] Int  
multWithLog = do  
    a <- logNumber 3  
    b <- logNumber 5  
    return (a*b)  
```

Then in ghci: `runWriter multWithLog`

## tell

The `tell` function is useful: it essentially will append to a Writer.

Example:

```haskell
gcd' :: Int -> Int -> Writer [String] Int
gcd' a b = do
  tell ["logging " ++ show a ++ ", " ++ show b]
  if a == b then writer (a, ["done"])
  else if a < b then do
    tell ["a < b"]
    gcd' a (b - a)
  else do
    tell ["a > b"]
    gcd' b (a - b)
```

Run it with `mapM_ putStrLn $ snd $ runWriter $ gcd'` (and then give the inputs).

(Recall: `mapM_`?)


