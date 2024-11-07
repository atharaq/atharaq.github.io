# Topics in Advanced Computing Lesson 11: Monoids, Foldables, Monads
{:.no_toc}

1. Table of Contents
{:toc}

# Last time

* Applicative Functors.
* Might be helpful to go back and see how things like IO are Functors first, and then Applicative.

## Functions

Functions are functors! What would `fmap` mean here?

First some notation:

* `(->) r t` is the same as `r -> t`.
* `(->) r` then is the type of functions that take in some parameter `a` and produce functions that map `r -> a`.
* If `f` is `(-> r)`? 
  * `fmap :: (a -> b) -> f a -> f b`
  * `fmap :: (a -> b) -> (r -> a) -> (r -> b)`
  * Take in a function `f` mapping `a -> b`, and a function `g :: r -> a`, then compose them to get `r -> b`.

```haskell
instance Functor ((->) r) where
  fmap f g = \x -> f (g x)
```

Or, more simply:

```haskell
instance Functor ((->) r) where
  fmap f g = (.)
```

(Mathematically, functions are generalizations of sequences. A sequence of `a`'s is a function from `[0..n]` to a. If a sequence of a's can be thought of as a functor, so should a list of a's)

## Functions are applicative

* Need to define `pure`. What should that be?
  * `pure x` should be a function that takes in an object of type `r` and simply returns `x`.
* Need to define `<*>`:
  * `<*> :: (r -> (a -> b)) -> (r -> a) -> (r -> b)`
  * What should `f <*> g` be?
  * `f` is going to be a function that takes in an input of type `r` and returns a function `a -> b`.
  * `g` is a function that takes in an input of type `r` and returns something of type `a`.
  * We want to produce a function that takes in `r` and returns `b`.

```haskell
instance Applicative ((->) r) where
  pure x = (\_ -> x)
  f <*> g = \x -> f x (g x)
```

Example: What should the following output? `(+) <$> (+5) <*> (*10) $ 2`

Try to chase down what happens. `(+) <$> (+5) <*> (*10)` is the same as `fmap (+) (+5) <*> (*10)`. 

* `fmap` is `(.)`. So: `(+) . (+5)`?
  * Type?
  * Function which takes in a number, and returns a function.
* Then `((+) . (+5)) <*> (*10)`?
  * `f x (g x)`: `f` is `(+) . (+5)`, `g` is `(*10)`, and `x` is 2
  * `[((+) . (+5)) 2] (2 * 10)`.
  * `[((+) . (+5)) 2] 20`
  * `(+ 7) 20`
  * 27

# Finishing up

* [Monoids](lesson10.html#monoids)
* [Foldables](lesson10.html#foldables)

Can we implement the Tree foldable?

# Monads

Functors: if we have a box of `a`s, and a map from `a -> b`, can we get a box of `b`s?

Applicative functors: what if the map `a -> b` is also in the box?

Monads: if we have a box of `a`s, and a function from `a` to a box of `b`s, then return a box of `b`s?

Example: looking up something in a table could return a `Maybe`. 

```haskell
class Applicative m => Monad m where
  (>>=) :: m a -> (a -> m b) -> m b
  (>>) :: m a -> m b -> m b
  return :: a -> m a
  {-# MINIMAL (>>=) #-}
```

`>>=` is the "bind" operator. `>>` is defined in terms of `>>=`, and `return` is, essentially, `pure`.

How would we implement this for a Maybe?

* `return`: put an `x` into a `Maybe`: this is the same as `pure`, or `Just`.
* `>>=`: Given a `Maybe` and a function `f`?
  * `Nothing >>= _`?
  * `Just x >>= f`?

```haskell
instance Monad Maybe where
  return = Just
  Nothing >>= _ = Nothing
  Just x >>= f = f x
```

**Exercise**: Consider the `lookup` function in the `Data.Map` module: `lookup :: Ord k => k -> Map.Map k a -> Maybe a`.

Suppose we want to do a kind of "triple lookup": we call lookup on some key `k`, and if it's Nothing, return `Nothing`, but if it's `Just x`, then lookup `x`, and again, if it's Nothing, return `Nothing`, otherwise if it's `Just y`, return `lookup y`. How would we implement this? Is it possible that the `Monad` instance could help?

```haskell
lookup3 :: Ord k => k -> Map.Map k k -> Maybe k
lookup3 k1 m = _ -- what goes here?
```

Reminder: what's the syntax for `>>=`? It's something like `Maybe x >>= f`, where `f` is a function that produces a `Maybe`.

Coming up:

* `do` syntax with Monads
* Monad laws
* List Monad
* Monad laws.