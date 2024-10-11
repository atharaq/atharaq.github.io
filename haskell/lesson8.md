# Topics in Advanced Computing Lesson 8: Input
{:.no_toc}

1. Table of Contents
{:toc}

# Questions?

# Catch-up

* [Trees](lesson7.html#trees)
* [Instances](lesson7.html#instances)
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

...

## Returns

* Do blocks return a value.
* return is an IO action that puts a value into an IO t
* return **does not return control**!
* `<-` is the inverse of return.

## When

## mapM and forM