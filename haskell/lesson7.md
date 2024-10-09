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

What is a list? Recursively: it's an element followed by another list (base case: empty list).

```haskell
data List a = Empty | Cons a (List a) deriving (Show, Read, Eq, Ord)
```

Or, as a record:

```haskell
data List a = Empty | Cons { lHead :: a, lTail :: List a } deriving (Show, Read, Eq, Ord)
```

Play around:

> ghci> 4 `Cons` (5 `Cons` Empty)  

`cons` is the name of `:` operator ("construct" a new list). We can do something similar: to make a function automatically "infix", we can define it with special characters:

```haskell
infixr 5 :.
data List a = a :. List a | Empty deriving (Eq, Ord, Show, Read)
```

> ghci> (3 :. 4 :. 5 :. Empty) :: List Int  
> 3 :. (4 :. (5 :. Empty))

## Fixity?

* Defining an operator, you can give it a [fixity](https://www.haskell.org/onlinereport/decls.html)
* infixr: this is a **right-associative** infix operator.
* The number tells you the **precedence**. Can be from 1-9
  * Ex: '*' is `infixl 7` but '+' is `infixl 6`.
  * Higher precedence binds more tightly.
  * Both of those are left-associative (why?)
  * Why should ours be right-associative?
* If you wanted a *non-associative* operator, you can use `infix`.

## Trees

Let's make a **binary tree**. Imperatively, we thiunk of a binary tree as containing a root node, which contains a data element, and (at most) two children: a left node and a right node. Declaratively: a tree is either an empty tree, or it has a root node which contains left and right subtrees.


```haskell
data Tree a = Nil | Nod a (Tree a) (Tree a) deriving (Eq, Show, Read)

singleton :: a -> Tree a
singleton x = Node x Nil Nil
```

Let's make it a **binary search tree** in fact. A BST is a tree that has the property: if $x < y$, then x appears on the **left** of y on the tree. How do we ensure this? When we insert, we check if the node we are inserting is less than the root. If it is, then put it on the left. If not, put it on the rigth:

```haskell
insert :: Ord a => a -> Tree a -> Tree a
insert x Nil = singleton x -- base case
insert x n@(Node a left right)
  | x < a == Node a (insert x left) right
  | x > a == Node a left (insert x right)
  | otherwise = n
```

* Let's play around with this.
* Exercise: implement a function that takes in an (unsorted) list and returns a BST. (Use a fold!)
* Exercise: implement a function that takes an element `x` and a Tree and returns True or False depending on whether `x` is an element of the tree.

```haskell
member :: Ord a => a -> Tree a -> Bool
member _ _ = False -- change this
```

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