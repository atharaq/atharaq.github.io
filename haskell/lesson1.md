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
* First $n$ elements: `take n names`
* Check if $x$ is in the list: `elem x names`
  * Preferred: ``x `elem` names``

## Ranges

## Implementation questions

## Comprehensions

## Exercises
