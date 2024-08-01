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

* **Parametric** polymorphism: variables can be of any type! (Java generics / C++ templates)
* **Ad-hoc** polymorphism: variables can be from a set of typeclasses that support certain functions. (Kind of like interfaces)

Example of parametric polymorphism: the `fst` function takes in a tuple `(x, y)` and returns the first element of the tuple `x`.

> ghci> fst (3, "Athar")  
> ghci> 3  
> ghci> :t fst  
> fst :: (a, b) -> a

Here `a` and `b` are two **type variables**. They can range over any possible types (they may be the same or different types). This is saying that `fst` is a function whose argument is a tuple, and returns a value whose type matches the type of the first element of the tuple.

Ad-hoc polymorphism is accomplished using **type classes**.

> ghci> :t (+)  
> (+) :: Num a => a -> a -> a

This says that + is a function which takes in two parameters of some type `a`, and returns another one of type `a`. Moreover, it says that this type `a` must be of the `Num` class (whatever that is).

## Common classes

* Eq: == and /=
* Ord (ordered): Eq, >, >=, <, <=, max, min, compare
* Enum (enumerable): succ, pred, fromEnum, toEnum
* Bounded: minBound, maxBound
* Num (numeric): (+), (-), (*), negate, abs, signum, fromInteger
* Real: Num, Ord, and toRational
* Integral: Real, Enum, quot, rem, div, mod, toInteger, quotRem, divMod
* Show (can be turned into a string): show, showList, showsPrec
* Read (opposite of show: parse from a string): read

## Ord / Enum / Bounded

Try out the following:

1. `:t (>)`
2. `:t compare`
   * `:t compare 0`
   * `:t compare "Athar"`
   * `compare "Athar" "Ali"`
3. `:t succ`
   * `succ 3.5`
4. `maxBound :: Int`
5. `maxBound :: Char`

## Num

1. `:t 0`
2. `:t (-)`
3. `:t 1 + 2`
4. `:t (1 + 2) :: Int`
5. `:t (1 :: Int) + 2`
6. `:t (1 :: Int) + (2 :: Double)`

## Integral / Fractional

1. `:t (4 + 2.3)`
2. `:t (5 :: Int) + 3.5`
3. `:t (/)`
4. `:t div`
5. `:t toInteger`
   * Why?
6. `:t fromIntegral`
   * Why?
7. `fromIntegral (1 :: Integer) + 2.3`

## Show

1. `:t show`
2. `show 3`
3. `show pi`
4. `show True`
5. `show ("Hi", "there")`
6. `show (3, 5)`
7. `show ["hi", "there"]`
8. `show [3, 5]`

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
  * Works the same with `count x = "Many"` in the last line. (But we don't use the `x`, so not needed.)
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
