# Topics in Advanced Computing Lesson 10: Applicatives and Monads
{:.no_toc}

1. Table of Contents
{:toc}

# Applicative Functors

```haskell
infixl 4 <*> 
class Functor f => Applicative f where 
  pure :: a -> f a -- put something into a box
  (<*>) ::f (a -> b) -> f a -> f b -- take a function in a box, apply to a box.
```

Reminder: currying / partial functions.

* `(*) :: Num a => a -> a -> a`
* `(*)` applied to a number `x` returns a function `a -> a`
* `fmap (*) (Just 3)` is `Just (* 3)`, ie a function in a box.

## Maybe

```haskell
instance Applicative Maybe where  
  pure = Just  
  Nothing <*> _ = Nothing  
  (Just f) <*> something = fmap f something  
```

* `pure = Just`?
* `<*>` definitions, for Nothing and Just f?

Examples:

* `pure (-) <*> Just 10 <*> Just 4`
* `Just (+3) <*> Just 9`
* `pure (+3) <*> Just 10`

## <$>

Basically: infix version of `fmap`. So `f <$> x <*> y <*> z` is like `f x y z`, on applicative functors.

Ex:`(+) <$> Just 1 <*> Just 2`

How do we understand this? `fmap (+) Just 1` would become `Just (+1)`, and then `Just (+1) <*> Just 2` is `Just 3`.

## Lists

```haskell
instance Applicative [] where  
  pure x = [x]  
  fs <*> xs = [f x | f <- fs, x <- xs]  
```

* `pure` makes a singleton list. Try `pure 7 :: [Int]` or `pure 7 :: Maybe Int`.
* `<*>` takes all combinations of functions and elements.

All products of numbers from `[-2..2]` with `[1..3]`?

## IO

```haskell
instance Applicative IO where  
  pure = return   
  a <*> b = do  
    f <- a  
    x <- b  
    return (f x)  
```

* `pure`? Take an `x`, wrap it in an `IO` box. [That's actually what `return` does!](lesson8.html#returns)
* `<*>`?
  * `<*> :: IO (a -> b) -> IO a -> IO b`.
  * Parameter 1: IO action that yields a function.
  * Parameter 2: IO action that yield an *input* to that function.
  * Return: take the function and the input, and then wrap it in an IO box.
  * [`do` syntax](lesson8.html#io-actions)?

## Laws

* `pure f <*> x` = `fmap f x`: apply a boxed function?
* `pure id <*> x` = `x`: since `fmap id` = `id`
* `pure (.) <*> u <*> v <*> w = u <*> (v <*> w)`: right-associativity
* `pure f <*> pure x` = `pure (f x)`: put f and x into boxes and apply?
* `x <*> pure y` = `pure ($ y) <*> x`: `($ y)` is the "apply function with argument y" operator.