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


# Function Monad

# State Monad

# lifts and others

# Tree?