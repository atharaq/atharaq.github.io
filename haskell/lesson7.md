# Topics in Advanced Computing Lesson 7: More on Defining Types
{:.no_toc}

1. Table of Contents
{:toc}

# Reading

Up through Chapter 9.

## Questions?

# Type Parameters

Last time we saw the `Maybe` type.

```haskell
data Maybe a = Nothing | Just a
```

The `Maybe` type constructor takes a parameter `a`, returns a type `Maybe a`.

Try out:

* `:k Maybe`
* `Just "hello"`
* `:t Just "Hello"`
* `:t Nothing`

The `uncons` function in the `Data.List` module returns a Maybe:

> ghci> :m + Data.List  
> ghci> uncons [1, 2, 3]
> ghci> uncons []

By the way: how do we get the "values" of a function that is returned by a `Maybe`? There is a standard prelude function called `maybe`:

```haskell
maybe :: b -> (a -> b) -> Maybe a -> b
maybe n _ Nothing = n
maybe _ f (Just x) = f x
```

Given a default value (`n`), a function (`f`), and a `Maybe` (m) this returns either `n` if `m` is nothing, or it returns `f x` if `m` is `Just x`.

## Data.Map

We saw this last time too:

> ghci> :m + Data.Map  
> ghci> :k Map  
> Map :: * -> * -> *  
> ghci> :t empty  
> empty :: Map k a  
> ghci> :t singleton "bob" (3::Int)  
> singleton "bob" (3::Int) :: Map String Int

Style note: this is allowed, but is bad form

```haskell
data Ord k => Map k v = ...
```

That is: you're allowed to add type class constraints to a type constructor, but this is considered bad form. Instead: we only add those constraints to specific functions that rely on those classes.

## Vector

[Example from the book](https://learnyouahaskell.com/making-our-own-types-and-typeclasses#type-parameters)

```haskell
data Vector a = Vector a a a deriving (Show)

vplus :: (Num t) => Vector t -> Vector t -> Vector t
(Vector i j k) `vplus` (Vector l m n) = Vector (i+l) (j+m) (k+n)

rescale :: (Num t) => Vector t -> t -> Vector t
(Vector i j k) `rescale` m = Vector (i*m) (j*m) (k*m)

dotProduct :: (Num t) => Vector t -> Vector t -> t
(Vector i j k) `dotProduct` (Vector l m n) = i*l + j*m + k*n
```

# Deriving

Can automatically derive Eq, Ord, Enum, Read, Show, etc.

# Synonyms

Can introduce type aliases or synonyms:

```haskell
type AssocList k v = [(k, v)]

lookup :: Eq k => k -> AssocList k v -> Maybe v
lookup _ [] = Nothing
lookup k ((x, v) : xs)
  | x == v = Just v
  | otherwise = lookup k xs
```

(Clearer implementation of the `find` function we did last time.)

# Recursive Structures

## Lists

## Trees

# Instances

```haskell
data AmPm = AM | PM deriving Show
data Time = Time { hour :: Int, minute :: Int, amPm :: AmPm }

instance Show Time where
    show (Time h m a)
      | m < 10 = show h ++ ":0" ++ show m ++ " " ++ show a
      | otherwise = show h ++ ":" ++ show m ++ " " ++ show a
```

# Defining Typeclasses

# Input?