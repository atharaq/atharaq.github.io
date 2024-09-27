# Topics in Advanced Computing Lesson 5: Modules
{:.no_toc}

1. Table of Contents
{:toc}

# Reading

Chapter 7

# Warm-Up

Implement a function `maxrun` which takes in a list and returns the length of the longest continuous sublist containing all equal values.

> ghci> maxrun []  
> 0  
> ghci> maxrun [1, 2, 2, 2, 1, 0, 1, 1]  
> 3

```haskell
maxrun :: Eq a => [a] -> Int
```

Ideas?

Maybe first: write a function which takes in a list, and splits it into sublists, each of which has identical values. ie:

> ghci> split [1, 2, 2, 2, 1, 0, 1, 1]  
> [[1], [2, 2, 2], [1], [0], [1, 1]]

Then? (Two more steps?)

But first: how do we write `split`?

```haskell
split [] = []
```

What's next? (This takes some work!) Some hints:

1. Can you implement a function which takes in an `x` and a list and returns all the elements at the beginning of the list which are equal to x? (Equivalent to `takeWhile ==x`)?
2. Implement a function which takes in an `x` and a list and returns all the elements *after* the ones returned above?
3. Can you implement a function which takes in an `x` and a list and returns both of the above as a tuple?
4. Then we can implement split using the above.

(Turns out there are built in functions that do almost all of these in the `Data.List` module.)

# Data.List

Importing a module in an .hs file:

```haskell
import Data.List

numUniques :: (Eq a) => [a] -> Int
numUniques = length . nub
```

`nub` is a function in the `Data.List` module which removes duplicates from a list. The **import** statement needs to go at the top of the file.

In ghci, you would do this as:

> ghci> :m + Data.List  
> ghci> 

## Importing some

```haskell
import Data.List (nub, sort)
```

Just imports nub and sort

```haskell
import Data.List hiding (sort)
```

Imports *everything* from Data.List **except** the sort function.

```haskell
import qualified Data.List
```

Imports the functions in the Data.List module but you need to give the full name: `Data.List.nub`, `Data.List.sort`, etc. You would do this to avoid name clashes (if you imported something else that defined a sort function, for example). But if `Dat.List.nub` is too long, you can use "as":

```haskell
import qualified Data.List as L
```

## Some functions

* `intersperse '*' "MASH"`
* `intersperse 0 [1, 2, 3]`
* `intercalate " " ["hi", "everyone"]`
* `intercalate [1, 2] [[3..10], [11.20], [21..30]]`
* `transpose`
* `concat`
* `concatMap`
* `and`
* `or`
* `any (==5) [1..10]` (check if anything in the list satisfies the predicate)
* `all`
* `iterate`
* `splitAt`

Interlude: these are in the standard prelude / don't need to import Data.List:

* `takeWhile`
* `dropWhile`
* `span`


Back to Data.List:

* `sort`
* `group`
* `inits`
* `tails`

## Searching

* `isPrefixOf` / `isInfixOf` / `isSuffixOf`
* How do we implement `isPrefixOf` recursively?
* **Exercise**: implement `search`, which is essentially `isInfixOf`. `search sublist list`
  * Hint: check if any of the `tails` lists `sublist` as a prefix.

## Text

* `words`
* `unwords`
* `lines`
* `unlines`

## Set Operations

* `nub` (remove duplicates)
* `delete` (removes the first matching element)
* `([10,9..1] \\ [2, 5, 6])` (implemented as `foldl (flip delete)`. How?)
* `union`
* `intersect`

# Data.Char

([See the reading, chapter 7](https://learnyouahaskell.com/modules#data-char), for more)

Character type functions:

* isAscii, isAsciiUpper, isAsciiLower
* isLatin1
* isControl, isPrint, isSpace, etc
* generalCategory?

Conversion functions:

* toUpper, toLower
* digitToInt, intToDigit (hex digits allowed)
* ord / chr (ASCII / Unicode values)

Exercise: Caesar cipher encode / decode functions (as in the book)?

# Data.Map

What is a Map?

* Set of key-value pairs?
* An *efficient* data structure for looking up values based on keys?

One implementation: lists of tuples.

```haskell
phoneNumbers = [("Athar", "123-4567"), ("Bob", "000-1111"), ("Jenny", "867-5309")]
```

Then how do we look stuff up? Need a `find` function. Let's check the [book's implementation](https://learnyouahaskell.com/modules#data-map). Running time? Better? (In Java: `HashMap` has $O(1)$ lookups / insertions.) Haskell's `Data.Map` module uses **trees** instead.

```haskell
import qualified Data.Map as Map -- name clashes with Data.List / Prelude
```

* Map.fromList
* Map.empty
* Map.insert
  * Immutability?
* Map.null
* Map.size
* Map.singleton
* Map.lookup
* Map.member
* Map.map
* Map.filter
* Map.keys
* Map.elems
* Map.toList
* Map.fromListWith

# Data.Set

```haskell
import qualified Data.Set as Set
```

* Set.fromList
* Set.union
* Set.intersection
* Set.difference
* Set.empty
* Set.null
* Set.size
* Set.insert
* Set.member
* Set.isSubsetOf
* Set.isProperSubsetOf


# Defining Modules

* Modules **export** functions.
* If you import a module, you can use the functions it exported.
* How do we define our own modules?

In "Geometry.hs"

```haskell
module Geometry
(
  sphereVolume,
  cubeVolume -- exported names
) where

sphereVolume :: Float-> Float 
sphereVolume radius = (4.0 / 3.0) * pi * (radius^3) 
cubeVolume :: Float-> Float 
cubeVolume side= cuboidVolume side side side

cuboidVolume ::Float-> Float-> Float->Float 
cuboidVolume a b c = rectangleArea a b * c 

rectangleArea :: Float-> Float-> Float −− Internal only 
rectangleArea a b = a * b
```

How do we use this? In ghci, simply `:l Geometry`. In another hs file in the same folder, `import Geometry`. Let's play around with this.

## Breaking up

(Maybe next time: break up Geometry into separate files. Submodules)