# Topics in Advanced Computing Lesson 14: Randomness
{:.no_toc}

1. Table of Contents
{:toc}

# Administrative

* PS3 Questions?
* Presentation 3 schedule: 11/25, 12/2, 12/5

# Random

Might need to run `stack ghci --package random`. Then `import System.Random` will work.

# Coin type

Suppose we wanted to create a `Coin` type. We might do something like:

```haskell
data Coin = HEADS | TAILS deriving (Eq, Show)

intToCoin :: Int -> Coin
intToCoin 0 = HEADS
intToCoin _ = TAILS -- not very fair
```

**Goal:** use randomness to generate a random sequence of HEADS/TAILS. (We might play around with bias / non-bias.)

## Attempt 1

To get a random number generator, we need to `import System.Random`, and we need to use the `mkStdGen` function, which creates a random number generator (an object of type `StdGen`). 

Given such an RNG, we can use the `randomR` function:

```haskell
randomR :: (Random a, RandomGen g) => (a, a) -> g -> (a, g)
```

That is, you provide a "range" of values as a tuple and an RNG, and this outputs a tuple `(a, g)`, where `a` is the randomly generated element nad `g` is the *next* RNG!

```haskell
flipTwice :: (Coin, Coin)
flipTwice =
  let g1 = mkStdGen 1000
      (c1, g2) = randomR (0, 1) g1
      (c2, _) = randomR (0, 1) g2
  in (intToCoin c1, intToCoin c2)
```

Ideally we'd like to be able to pass a parameter `n` and flip the coin `n` times. But this does the trick for now. Notice of course, though, that the `randomR` function fits exactly the kind of pattern we talked about last time: if we want some kind of "mutability", instead of mutating an object in-place, we provide a *function* `s -> (a, s)`, where `a` is the value and `s` is the state. This is precisely what the State type is: a `State s a` is just a function of this type `s -> (a, s)`.

## Attempt 2

Now let's try to just flip a coin once, using an RNG:

```haskell
flipCoin :: State StdGen Coin
flipCoin = state $ do
  (n, s) <- randomR (0, 1)
  return (intToCoin n, s) 
```

The `state` function here is the function takes a function that behaves like a state and wraps it in the State monad. It turns out there's a cleaner way to do this:

```haskell
flipCoin :: State StdGen Coin
flipCoin = intToCoin <$> state (randomR (0, 1))
```

What does `<$>` mean here? Remember `<$>` is `fmap`, so this is `fmap intToCoin (state (randomR (0, 1)))`.

* `randomR (0, 1)` is a function `g -> (a, g)`, where `a` is a number, and `g` is an RNG
* `state (randomR (0, 1))` is the functiont that takes such a function and wraps it in a `State`
* What should `fmap f (State g)` do?

```haskell
instance Functor (State s) where
  fmap f (State g) = State $ \s0 -> 
    let (a, s1) = g s0
    in (f a, s1)
```

ie, take the function `g -> (a, g)` and an RNG `g`, get the number and the next RNG as `(a, s1)`, pass `a` to the function `f`, and take that answer, along with the new state `s1`, and wrap that as the state.

How do we check the value of this? Use `evalState flipCoin (mkStdGen 0)` (or some other number besides 0).

## n times

First let's try three times:

```haskell
import Control.Applicative (liftA3)

flipThrice = liftA3 (,,) flipCoin flipCoin flipCoin
```

Now try `evalState flipThrice (mkStdGen 10)`

That easy! What about n times? Or infinitely many times? Can we try the `repeat` function? `repeat <$> flipCoin`? Will this work? Try:

> ghci> r = repeat <$> flipCoin  
> ghci> take 10 $ evalState r (mkStdGen 10)

What happens? Explanation?

## replicateM

We need kind of a feedback mechanism:

* Get the current state.
* Use it to produce a coin and a new state
* Update the current state to the new state.
* Repeat this.

This is exactly what the `replicateM` does.

```haskell
flipN :: Int -> State StdGen [Coin]
flipN n = replicateM n flipCoin
```

And to check:

> ghci> evalState (flipN 10) (mkStdGen 10)  


# Some stateful functions

* evalState
* execState
* runState
* get
* put