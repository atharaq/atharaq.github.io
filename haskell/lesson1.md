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
  * Efficiency: ++ is $O(n)$, where $n$ is the length of `list1`
* Efficiency: adding a *single* element to the beginning of the list can be done in $O(1)$ using `:`
  * `0:[1..100]`
* First $n$ elements: `take n names`
* Check if $x$ is in the list: `elem x names`
  * Preferred: ``x `elem` names``
* Strings are lists!
  * `"Athar"!!0`
  * `'h':"ello"`
  * `length "Athar"`

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
  * Singly linked list, with a head, no tail.
  * That's why prepending can be done in $O(1)$, but concatenation is $O(n)$.
* Except: each node has a pointer to a *computation* (called a **thunk**) which would give the next node / value.
* This allows **lazy evaluation**.
* That's how infinite lists work!

## Comprehensions

> ghci> [x+1 | x <- [0,2..10]]  
> [1,3,5,7,9,11]

The vertical bar is like the set-theoretic "such that". "List of all the numbers x + 1, such that x is in the set [0, 2..10]"

Even squares:

> ghci> evenSquares = [ x*x | x <- [0,2..]]  
> take 10 evenSquares  
> [0,4,16,36,64,100,144,196,256,324]

More than one condition? Even squares that are multiples of 3?

> ghci> evenMult3Squares = [x | y <- [0,2..], let x = y * y, x `mod` 3 == 0]  
> ghci> take 10 evenMult3Squares  
> [0,36,144,324,576,900,1296,1764,2304,2916]

`let` keyword?

**Exercise**: Can we make an infinite list of **all** Pythagorean triples? A Pythagorean triple is a tuple $(x, y, z)$ such that $x^2 + y^2 = z^2$. We can restrict these to just be of the form $x < y < z$, so that $(3, 4, 5)$ shows up but $(4, 3, 5)$ does not.

<details>
<summary>Solution</summary>
<p>pythTrips = [(x,y,z) | z <- [1..], y <- [1..z], x <- [1..y], x^2 + y^2 == z^2]</p>
</details>

## Exercise

**The handshake problem**: given $n$ people in a room, if everyone shakes hands with everyone else, how many handshakes are there?

Define a function `handshakes n` which returns a list of unique ordered pairs $(x, y)$ such that $x \neq y$, and $x < y$. 

Use it so that:

> ghci> handshakes 4  
> [(1, 2),(1,3),(1,4),(2,3),(2,4),(3,4)]  

To start you out:

```haskell
handshakes n = 
```

Fill in the rest!