# Topics in Advanced Computing Lesson 5: Modules
{:.no_toc}

1. Table of Contents
{:toc}

# Reading

Chapter 7

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
* `any`
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



# Data.Char

# Data.Map

# Data.Set