# Topics in Advanced Computing Lesson 1: Lists
{:.no_toc}

1. Table of Contents
{:toc}

# Questions

* Setting up
* Topics?
* Choose a topic by the beginning of next week!

# Lists

* One of the most fundamental data structures in Haskell.
* `names = ["Athar", "Bob", "Carl", "Athar"]`
* Access element $n$: `names!!n`
* Length of the list: `length names`
* First element: `head names` (one element)
* Rest of the list: `tail names` (returns a list)
* Concatenate two lists: `list1 ++ list2`
  * Example: `[1, 2, 3] ++ [5, 6]`
  * Doesn't work: `[1, 2, 3] ++ ["Hi"]`
  * Lists must be **homogeneous**. Lists of a single type.
* First $n$ elements: `take n names`
* Check if $x$ is in the list: `elem x names`
  * Preferred: ``x `elem` names``

## Ranges

* First ten positive integers: `ft = [1..10]`
* Backwards: `backwards = [10,9..1]`
  * Need to provide at least two elements in this case.
  * Haskell figures out the "step"
  * What if you do `[10,8,..1]`?
* First ten positive odds: `odds = [1,3..11]`
* Characters: `lowers = ['a'..'z']`

Infinite lists:

* All natural numbers: `n = [0..]`
* All even naturals: `evens = [0,2..]`
* `cycle` takes a list and repeats it infinitely.
  * `binary = cycle [0, 1]`
* `repeat` repeats one value forever
  * `twos = repeat 2`
  * If you want a list of $n$ 2's, use `replicate`
  * `replicate 5 2` makes the list `[2, 2, 2, 2, 2]`  

## Implementation questions

* Think of these as **linked lists**.
* Except: each node has a pointer to a *computation* (called a **thunk**).
* This allows **lazy evaluation**.
* That's how infinite lists work!

## Comprehensions

## Exercises
