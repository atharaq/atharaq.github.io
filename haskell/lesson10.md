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

Ex:`(+) <$> [1] <*> [2]`

## Lists

...

## IO

## ZipLists

## Laws

* `pure f <*> x` = `fmap f x`
* 