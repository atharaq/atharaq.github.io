# Topics in Advanced Computing Lesson 2: Types / Classes / Functions
{:.no_toc}

1. Table of Contents
{:toc}

# Questions

## Reminder

* Choose a topic by the end of the day **tomorrow**!
  * Send me 2-3 possible choices over email.
* Current topics chosen: listed on BrightSpace.

# Reading

* Chapter 3: Types/Typeclasses
* Chapter 4: Syntax in Functions

# Types

* Recall: Haskell is **statically typed**. Meaning?
* Recall: **type inference**. Meaning?
* "::" means?
* How to check the type of an expression / function?

## Common Types

* Bool: True or False
* Char: a single Unicode character 
  * `String` is `[Char]` (list of characters)
* Int: word-sized integer (64 bits on a 64-bit machine, 32 bits on a 32-bit machine, etc)
* Integer: unbounded integer (less efficient)
* Float 
* Double

## Types of functions

`->` indicates a function.

```haskell
welcome x = "Hello " ++ x
```

* `welcome "Athar"`?
* `:t welcome`?
  * `welcome :: [Char] -> [Char]`
  * "welcome is a function that takes a list of characters and returns a list of characters"

## Curried

Every function in Haskell has exactly one argument. So how do we define multi-arg functions?

> ghci> hello first last = "Hello " ++ first ++ " " ++ last  
> ghci> :t hello  
> hello :: [Char] -> [Char] -> [Char]

What does this mean? `hello` is a function that takes in a string as a parameter, and returns another function! This is called **currying**.

What happens if we do `:t hello "Athar"`?

## Style note

Good style to include type declarations for your functions in .hs files. The following might go in a file called "linear.hs":

```haskell
linear :: Int -> Int -> Int
linear x y = 2*x + y
```

Then in ghci:

> ghci> :set -Wall
> ghci> :l linear
> ...

Compiler verifies that your type declaration is correct. 

# Polymorphism

* Parametric polymorphism: variables can be of any type! (Java generics / C++ templates)
* Ad-hoc polymorphism: variables can be from a set of typeclasses that support certain functions. (Kind of like interfaces)

## Common classes

## Ord / Enum / Bounded

## Num

## Integral / Fractional

## Show

# Functions

Can define functions using cases:

```haskell
count :: Integral a => a -> String
count 0 = "None"
count 1 = "One"
count 2 = "Two"
count _ = "Many"
```

* **Pattern matching**.
* Underscore is a wildcard: matches everything.
  * Used if we don't need a variable name
  * Works the same with `count x = "Many"` in the last line.
* What if we don't define the "wildcard" case? Error.
  * Can turn it into a compiler error with :set -Wincomplete-patterns.

## More Pattern Matching

Works on lists and tuples. Examples:

...

Recursion? Examples:

...

## Guards

## Where

## Let

# Problem Set 1

Due **next Friday** on BrightSpace / GH classroom?

(.hs on github classroom?)
