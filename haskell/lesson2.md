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

...

## Common Types

## Types of functions

## Curried

# Polymorphism

(type variables)

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