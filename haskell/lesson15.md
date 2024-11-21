# Topics in Advanced Computing Lesson 15: Zippers
{:.no_toc}

1. Table of Contents
{:toc}

# Questions?

* PS3?
* Presentations?

# Breadcrumbs

Idea: given a data structure (tree, list, etc), walk up/down that structure while keeping track of enough information to recreate the entire structure.

Ex: list. If we have a list `[0, 1, 2, 3, 4, 5]`, at position 3, we might need to keep track of the part of the list that came before it and what comes after it, so that you can go back and forth.

## Attempt 1

What about for a tree?

```haskell
data Dir = L | R deriving Show
type Breadcrumbs = [Dir]

goLeft :: (Tree a, Breadcrumbs) -> (Tree a, Breadcrumbs)
goLeft (Node _ l _, bs) = (l, L:bs)
```

Similar for `goRight`

# Going up?

What about going up? Don't have enough information to go back up! A true zipper needs to keep enough information to recreate the entire structure.

```haskell
data Crumb a = LeftCrumb a (Tree a) | RightCrumb a (Tree a) deriving (Show)
type Breadcrumbs a = [Crumb a]
```

A `Crumb` keeps track of whether or not it's a left or right move, the data in the node you're at, and the subtree that you didn't visit. Then as you move down a branch, you keep track of the data you visited along that branch, and the subtrees you haven't visited, so that you can "pop back up" if you need to.

**Exercise**: Implement `goLeft` and `goRight`.

```haskell
goUp :: (Tree a, Breadcrumbs a) -> (Tree a, Breadcrumbs a)
goUp (t, LeftCrumb x r:bs) = (Node x t r, bs) -- root of this is x, left is t, right is r
goUp (t, RightCrumb x l:bs) = (Node x l t, bs)
```

## Manipulating

* Zipper type
* modify
* attach
* topMost

# Lists

What about for a list? `[1, 2, 3]`?

* Move forward or back (not up/down).
* But only one way to traverse a list (unlike a tree).

```haskell
type ListZipper a = ([a], [a])

goForward :: ListZipper a -> ListZipper a
goForward (x:xs, ys) = (xs, x:ys)

goBack (xs, y:ys) = (y:xs, ys)
```

Play around with this. What is the zipper for `[1, 2, 3, 4,5]` when we goForward twice?
