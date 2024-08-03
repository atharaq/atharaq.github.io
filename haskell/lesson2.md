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
  * Can turn it into a compiler error with :set -Wincomplete-patterns (or :set -Wall)

## More Pattern Matching

Works on lists and tuples. Examples:

> ghci> fst' (x,_) = x  
> ghci> :t fst'
> ghci> fst' :: (a, b) -> a
> ghci> fst' (30, 10)
> 30

**Exercises**: 

1. Define a function `addVector` which takes in two tuples `(x1, y1)` and `(x2, y2)` and returns their *vector sum* (add the x's, add the y's).
2. Define a function `dotProd` which takes in two tuples `(x1, y1)` and `(x2, y2)` and returns their *dot product* (multiply the x's, multiply the y's, add them together).

What if we wanted to define these on two vectors of arbitrary length? We can use pattern matching on lists with recursion.

```haskell
:{
dotProd [] [] = 0
dotProd _ [] = error "list sizes do not match"
dotProd [] _ = error "list sizes do not match"
dotProd (x:xs) (y:ys) = x*y + dotProd xs ys
:}
```

**Exercise**: Implement `addVector` on two lists recursively (as efficiently as you can). If one list is empty and the other is not, throw an exception (as we did above).

(There will turn out to be a simpler solution later on: `zipWith (+)`)

List comprehensions: we've seen this already. Recall: Pythagorean triples:

```haskell
pythTrips = [(x,y,z) | z <- [1..], y <- [1..z], x <- [1..y], x^2 + y^2 == z^2]
```

We can do other things like: `perims = [ a + b + c | (a, b, c) <- pythTrips ]`

(Try `take 10 perims`).

## As patterns

**As patterns**: pattern match + bind a name. Syntax: `name@pattern`

```haskell
capital :: String -> String
capital "" = "Empty"
capital all@(x:xs) = "The first letter of " ++ all ++ " is " ++ [x]
```

## Guards

Boolean expression after a pipe symbol (`|`). Like an "if" or "switch":

```haskell
bmiClassifier bmi 
  | bmi <= 18.5 = "underweight"
  | bmi <= 25.0 = "normal"
  | bmi <= 30.0 = "overweight"
  | otherwise = "obese"
```

This can be all on one line, but more readable if you put each guard on its own line, indented.

## Where



## Let

# Problem Set 1

Due **next Friday** on BrightSpace / GH classroom?

(.hs on github classroom?)
