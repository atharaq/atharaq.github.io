# Topics in Advanced Computing Lesson 8: Input
{:.no_toc}

1. Table of Contents
{:toc}

# Questions?

# Catch-up

* [Trees](lesson7.html#trees)
* [Instances](lesson7.html#instances)
* [Synonyms](lesson7.html#synonyms)
* [Defining typeclasses](lesson7.html#defining-typeclasses)
* [Functors](lesson7.html#functors)

# Input

We haven't done an actual "Hello World" program yet. We haven't done the usual steps of creating a source file, compiling it, and running it. Let's try that now. Create a new file called "hello.hs":

```haskell
main = putStrLn "Hello world!"
```

Two options:

1. `stack runhaskell hello.hs`: runs it directly.
2. `stack ghc -- --make hello`: compiles and links.

After option (2): we get an executable file just named "hello", which we can then run using the command line `./hello`. (On Windows, this might be "hello.exe").

## IO Actions

* `:t putStrLn`? (returns an IO action)
* `:k IO`? (parameterized type, may convey a result)
* `:t ()`? (a literal of a specific type)
* `:k ()`? (a concrete type with a single literal)

An *IO action* is something that will carry out an action with a side effect (in this case, an input/output side effect like reading data from the console or printing to the screen).

* Output-only actions (printing) return `IO ()`
* Input actions (reading a line) return something like `IO String`
  * `:t getLine`
  * `name <- getLine`
* IO actions are performed when `main` is invoked (program execution).
* Multiple actions? `do` syntax:

```haskell
main = do
  putStrLn "Type in your name"
  name <- getLine
  putStrLn $ "Hi there " ++ name
```

* Indentation rules are the same as for where, let.
* `<-` syntax?
* `name = getLine` doesn't work. Why not?

The `<-` syntax is the instruction to perform the requested IO action and bind its value to the variable. 

```haskell
main = do
  result <- putStrLn "Hello" -- this works, but why?
  print result
```

Compile / run. What gets printed? Why? (What did putStrLn return again? `IO ()`)

## Lets

In a `do` block, we can have `let` bindings, with no `in`.

```haskell
import Data.Char

main = do
    putStrLn "What's your first name?"
    firstName <- getLine
    putStrLn "What's your last name?"
    lastName <- getLine
    let bigFirstName = map toUpper firstName
        bigLastName = map toUpper lastName
    putStrLn $ "hey " ++ bigFirstName ++ " " ++ bigLastName ++ ", how are you?"
```

Q: `<-` vs `let`?

* `<-` for performing IO actions and binding their result.
  * "Impure"
* `let` for binding pure Haskell expressions to names. 

```haskell
printTwo = putStrLn "Two" 

main = do 
  putStrLn "One" 
  let printFour= putStrLn "Four" 
      getMyLine = getLine 
      printThree = putStrLn "Three" 
  printTwo 
  printThree 
  putStr "Type something " 
  myLine <-getMyLine 
  printFour 
  putStrLn $ "You typed \"" ++ myLine ++ "\""
```

Word Reverser program:

```haskell
reverseWords :: String -> String 
reverseWords = unwords . map reverse . words 

main = do 
  line <- getLine 
  if null line then 
    return () 
  else do
    putStrLn $ reverseWords line 
    main -- glue together two IO actions as one using do block.
```

`if-then-else` is an expression. Both branches must return the same type. What does `return` do?

## Returns

* Do blocks return a value: the value of the last expression.
* return is an IO action that puts a value into an IO t
  * ie, it wraps a value into a "box" for an 
* return **does not return control**!
  * Why did we need to do this?
  * Above: needed the `then` clause to return an IO action since 
* `<-` is the inverse of return.

```haskell
main = do
  return "tree falls in a forest" -- no one is listening
  return () -- no control transfer
  a <- return "something " -- basically: let a = "something"
  b <- do
    return "silence"
    putStrLn "did we return?"
    return "else " -- binds else to b
  let c = "was returned"
  putStrLn $ a ++ b ++ c
```

## IO Functions

* putChar
* putStr
* putStrLn
* print: essentially putStrLn . show
* getChar
* getLine
* getContents
* `interact :: (String -> String) -> IO ()`
  * read, apply f, print
* readIO 
* readLn

## When

```haskell
when :: Bool -> IO () -> IO ()
when p s = if p then s else return ()
```

Basically an if without an else. So the earlier code could have been:

```haskell
import Control.Monad (when)
reverseWords :: String -> String 
reverseWords = unwords . map reverse . words 

main = do 
  line <- getLine 
  when (not (null line)) $ do 
    putStrLn $ reverseWords line 
    main
```

`unless` is better than `when (not...))`

## Others

* sequence: apply a list of IO actions, capture the result
* mapM: take a function and a list, maps the function over the list, sequences it.
* mapM_: same thing, but throw away the result.
* forM (in Control.Monad): same as mapM but with the parameters switched around.
  * for/foreach loop syntax

Examples:

```haskell
main= do 
  inputLines <- sequence $ replicate 10 getLine 
  mapM_ putStrLn inputLines
```

```haskell
import Control.Monad

main = do
  colors <- forM [1..4] (\a -> do
    putStrLn $ "Pick a color for the number " ++ show ++ a
    getLine)
  forM_ colors putStrLn -- for each color in colors, putStrLn color
```

## Conclusion

* IO actions are values like anything else.
* Can be passed as parameters, returned
* If they are in the main function: they are *performed*.