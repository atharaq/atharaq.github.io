# Topics in Advanced Computing Lesson 3: Recursion / Higher order functions
{:.no_toc}

1. Table of Contents
{:toc}

# Questions

## Reminders

* Presentation 1 starts **next week**.
  * Overview of your topic. 15ish minutes?
  * Motivate it: why is this is an interesting area of research?
  * See rubric on BrightSpace
* Problem Set 1 due **this Friday**.

## Reading

* Chapter 5: Recursion
* Chapter 6: Higher-order functions

# Recursion

## Examples

* maxList, replicate', take'

## Quicksort

## Recursive Thinking

## zip / zipWith

zip: take two lists and return a list of pairs.

```haskell
zip [0, 1, 2] [1..]
```

Returns [(0,1), (1,2), (2,3)] (cuts off the infinite list!). How would we define this using recursion / pattern matching?

zipWith: combination of zip and map. Take a function, two lists, and returns a list where we apply the function to both list elements.

```haskell
zipWith (+) [0..10] [1..]
```

Returns `[1,3,5,7,9,11,13,15,17,19,21]`.

## Exercises

...

# Higher-order Functions

* Pass functions as arguments (fundamental to functional programming).
* Technically: multi-arg functions do this!

```haskell
addNums :: Num a => a -> a -> a
addNums x y = x + y
```

This is called **currying** (named after Haskell Curry): translating a function of multiple arguments to a *sequence* of one-argument functions.

addNums is a function which takes in a parameter of typeclass Num, and returns another function. That returned function is one which takes in a parameter of typeclass Num and returns a value of typeclass Num.

Upshot: **partial application**:

```haskell
addFour = addNums 4
```

* What? Try `:t addFour`, what do you get?
* Try `addFour 7`, what do you get?
* addNums 4: takes in parameter 4, returns a function which takes in parameter y, and returns `4 + y`.

## Currying

* Function application
* Multiple args = currying

## Partial Application

* Examples: divByTen, etc
* zipWith'

## Maps / filters

Map: 

* take a function and a list and apply that function to each element of the list.
* Fundamental construct in functional programming.
* Most loops can be changed to use map instead.
* How to define it?
* Examples?


Filter: Take a predicate (a function which returns a Bool) and a list, and return the sublist of those items which the predicate evaluates to try

Example: `filter (>0) [3, -1, 4, 7, -2, 0, 8]` returns `[3, 4, 7, 8]`.

Definition?

Other examples?

* Quicksort again
* Primes / twin primes
* Collatz sequences

## Lambdas

* Anonymous function (if we only need to use a function once, don't need to give it a name)
* Derived "lambda calculus"
* Use backslash `\`.
* Often useful with constructs like map / filter / fold

## folds

Repeatedly apply a function to more and more of a list. Takes in a function, a starting value, and a list, and returns a single value.

Definition:

```haskell
foldl :: (a -> b -> a)  -> a -> [b] -> a
foldl f z [] = z
foldl f z (x:xs) = foldl f (f z x) xs
```

Ex: `foldl (\acc x -> acc + x) 0 [1..5]` is the sum function! (adds up the numbers in the list `[1..5]`). How?

* First: `foldl f (f 0 1) [2..5]`, where `f` is the lambda.
* The lambda adds 0 and 1, so it's now `foldl f 1 [2..5]`
* Next: `foldl f (f 1 2) [3..5]`
* `foldl f 3 [3..5]`
* `foldl f (f 3 3) [4..5]`
* `foldl f 6 [4..5]`
* `foldl f (f 6 4) [5]`
* `foldl f 10 [5]`
* `foldl f (f 10 5) []`
* `foldl f 15 []` (finally we're at the base case!)
* `15` 

In the prelude, in fact, `sum` is defined as `sum = foldl (+) 0`.

## foldr

foldl is technically a "left-fold". There is also a "right-fold", `foldr`.

```haskell
map' :: (a -> b) -> [a] -> [b]
map' f xs = foldr (\x acc -> f x : acc) [] xs
```

This is an implementation of the `map` function. This one takes the function `f` and the list, and, starting on the right, applies `f` to each element on the list and prepends it to the rest of the list. You could do this with `foldl` and ++, but : is much more efficient than ++ (why?).

(This is not how map is actually implemented! Can you think of a recursive, pattern-matching way to implement it instead?)

Lazy-evaluation:

```haskell
quitZero x acc = if x == 0 then 0 else x+acc
foldr quitZero 0 [3,2,1,0,100,undefined]
```

What happens here? What about for `foldr quitZero 0 [3,2,1,100,undefined]`? **Lazy evaluation**!

## foldl1 / foldr1

## scanl/scanr

foldl / foldr but returns a list of all partially accumulated values.

## Application

The '$' operator is the "function application" operator. Why would we use it? It changes precedence. 

`f a b c` binds as `(((f a) b) c)`, ie apply f to a, then take that result and apply it to b, then apply that result to c.

`f $ a b c` means apply a to b, apply that result to c, and then use that result as the argument to `f`.

Example:

```haskell
length (takeWhile (<1000) (scanl1 (+) (map sqrt[1..])))
length $ takeWhile (<1000) $ scanl1 (+) $ map sqrt[1..]
```

Those do the same thing, second is a bit more readable.

## Composition

Using the standard prelude functions `negate` and `abs`, let's take a list of numbers and make all of the values negative.

```haskell
map \x -> negate(abs x) [5, -3, 7, -2]
```

Cleaner if we use the . operator for **composition**:

```haskell
map (negate . abs) [5, -3, 7, -2]
```

"Compose the `negate` and `abs` functions, pass that to `map`".

## Exercises

...
  