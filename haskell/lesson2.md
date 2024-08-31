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

What if we wanted to define `bmiClassifier` in terms of height and weight? Your BMI is defined as your mass in kilograms divided by your height in meters squared.

```haskell
bmiClassifier weight height
  | weight / height^2 < 18.5 = "underweight"
  | weight / height^2 < 25.0 = "normal"
  | weight / height^2 < 30.0 = "overweight"
  | otherwise = "obese"
```

It would be easier if we could define a temporary variable which computed `weight / height^2` once. This is the point of the **where** clause. The above can be written more simply as:

```haskell
bmiClassifier weight height
  | bmi <= 18.5 = "underweight"
  | bmi <= 25.0 = "normal"
  | bmi <= 30.0 = "overweight"
  | otherwise = "obese"
  where bmi = weight / height^2
```

## Let

**where** bindings define variable names across the whole funciton. **let** bindings are local. `let ... in ...` is an *expression*. The idea is you use `let ...` to define some set of variables, and then the value of the expression is returned by the `in` clause.

```haskell
cylinder :: (RealFloat a) => a -> a -> a
cylinder r h =
    let sideArea = 2 * pi * r * h
        topArea = pi * r^2
    in sideArea + 2*topArea
```

In this function, the surface area of the cylinder is defined as `sideArea + 2*topArea`; those variables are bound by the `let` clause. `let` bindings can be used in list comprehensions and in GHCi as well.

# Problem Set 1

Due **next Friday** on BrightSpace / GH classroom?

(.hs on github classroom?)

1. Explain the differences between functional and imperative programming. In your answer, provide an example of an algorithm (described in Java / Python / pseudocode / etc) that is *not* written in a functional style, and explain what is not "functional" about it. You can write your answer using comments `{-` and `-}` in the hs file.
2. Write a function `elemSorted x xs` that returns true if `x` is an element of the **sorted** list `xs`. In this case, we assume `xs` is sorted; it may be infinite. Do **not** use `elem`: it fails for infinite lists. The type signature should be `elemSorted :: Ord a => a -> [a] -> Bool`. In the comments, in English, explain what this type signature means.
3. Write a function `isPerfectSquare :: Int -> Bool` which returns true if `x` is a perfect square. **Hint**: use `elemSorted` to check if `x` is an element of an infinite list of all perfect squares. (Can you figure out how to define a list of all perfect squares?)
4. Consider the expression ``p = sieve [2..] where sieve (x:xs) = x : sieve [ y | y <- xs, y `mod` x /= 0]``. In the comments of the .hs file, answer the following:
   * What is the type of p?
   * What is the value of `take 10 p`?
   * Describe `p`. What is it, mathematically? Explain how the recursive definition of `sieve` works. Explain how this defines an infinite list, without 
5. Two numbers `x` and `y` are called **twin primes** if they are both prime and they differ by 2. For example, 3 and 5 are twin primes, as are 5 and 7. Define a list `twins` of all tuples `(x, y)` where `x < y` and `x` and `y` are twin primes.
   * Hint 1: use a **let** binding to ensure `y` is equal to `x + 2`, and a `where` binding to define a local function `isPrime`.
   * Hint 2: define the function `isPrime` using `elemSorted` similarly to how you defined `isPerfectSquare`. 
   * If it works, `take 10 twins` should return the following: `[(3,5),(5,7),(11,13),(17,19),(29,31),(41,43),(59,61),(71,73),(101,103),(107,109)]`
