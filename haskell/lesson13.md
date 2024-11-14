# Topics in Advanced Computing Lesson 13: More Monads
{:.no_toc}

1. Table of Contents
{:toc}

# List example

```haskell
xs = [1..5]
ys = [10..19]
do
  a <- xs
  b <- ys
  return (a*b)
```

What is returned?

# gcd example

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

# lifts and others

```haskell
fmap :: Functor f => (a -> b) -> f a -> f b
<*> :: Applicative f => f (a -> b) -> f a -> f b
```

Monad versions:

```haskell
liftM :: Monad m => (a -> b) -> m a -> m b
ap :: Monad m => m (a -> b) -> m a -> m b
```

[Why so many flavors?](https://stackoverflow.com/questions/7463500/why-do-we-have-map-fmap-and-liftm)

Implementations? (Easy with `do` syntax. Can also use `>>=`.)

```haskell
liftA2 :: (Applicative f) => (a -> b -> c) f a -> f b -> f c
liftA2 f x y = f <$> x <*> y
```

(For convenience. Hint for PS3.)

`liftM2` is the same as `liftA2`. There's also `liftM3`, `liftM4`; same idea: take a function and $n$ many monads and apply.

---

```haskell
join :: (Monad m) => m (m a) -> m a
```

Take a monad of monads and flatten it. Example: `join ["hello ", "there ", "guys!"]` or `join [[1..3], [4..6]]`.

Try on Writers?

---

`sequence`: "execute" a list of actions.

```haskell
sequence :: (Traversable t, Monad m) => t (m a) -> m (t a)
sequence_ :: (Foldable t, Monad m) => t (m a) => m ()
```

---

Others:

* `mapM`
* `mapM_`
* (Control.Monad) `foldM`
* (Control.Monad) `filterM`

Exercise: use `filterM` to compute the powerset of a list.

# Function Monad

```haskell
instance Monad ((->) r) where
    return x = \_ -> x
    h >>= f = \w -> f (h w) w
```

Example:

```haskell
f :: Int -> Int
f = do
    a <- (*2)
    b <- (+10)
    return (a+b)
```

(`a` and `b` are functions here. `f x` is going to apply `a x` and `b x` and then add them.)

"glue functions together" into one function, give that parameter to all the glued functions.

# State Monad

Represents "stateful computations". First let's describe an example without monads.

Suppose you represent "states" in your program by integeres. (So you have a "State 0", "State 1", etc.) Maybe you represent this by:

```haskell
data MyState = MyState Int
```

Now let's say we have a series of functions which take in the state, either examining or modifying it:

```haskell
f1 :: MyState -> (Int, MyState)
f2 :: Int -> MyState -> (Char, MyState)
f3 :: Char -> MyState -> (String, MyState)
```

Then to use them in order:

```haskell
f = 
  let state0 = MyState 0
      (a, state1) = f1 state0
      (b, state2) = f2 a state1
      (c, state3) = f3 b state2
  in c
```

Notice two things:

1. The pattern is that each function has something like `MyState -> (a, MyState)`. (Maybe this can just be built in to the type?)
2. At each intermediate step, we need to name the states. (Could we abstract this pattern?)

Fixes?

```haskell
data MyStateWrapper s a = MyStateWrapper { runMyState :: s -> (a, s) }

f1 :: MyStateWrapper MyState Int
f2 :: Int -> MyStateWrapper MyState Char
f3 :: Char -> MyStateWrapper MyState String

andThen :: MyStateWrapper s a -> (a -> MyStateWrapper s b) -> s b
andThen f g =
    MyStateWrapper (\state0 -> 
      let (a, state1) = runMyState f state0
      in runMyState (g a) state1)
```

Then we can rewrite our `let` statement above as:

```haskell
f =
    runMyState (f1 `andThen` \a ->
                g a `andThen` \b ->
                h b) (MyStateWrapper 0)
```

That's basically it! With the State Monad, you can simplify this to:

```haskell
f = do
    a <- f1
    b <- g a
    h b
```

## Definition

In Control.Monad.State:

```haskell
newtype State s a = State { runState :: s -> (a, s) }

instance Monad (State s) where
    return x = State $ \s -> (x, s)
    (State h) >>= f = State $ \s -> let (a, nextState) = h s
                                        (State g) = f a
                                    in g nextState
```