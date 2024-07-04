# Topics in Advanced Computing Lesson 0: Welcome!
{:.no_toc}

1. Table of Contents
{:toc}

# Incomplete map of CS

After the "fundamentals", computer science research can be in any of a number of topics. The below are very incomplete, but give an idea of how things might break down. These categories are not rigid: research in one of these areas may affect all the other categories, for example.

## Foundations

* Computability
* Complexity
* Analysis of algorithms
* Graph theory
* Learning theory
* Logic
* ...

## Software systems

* Programming Languages
* Compilers
* Operating Systems
* Networks
* Databases
* ...

## Intelligent Systems

* Artificial Intelligence
* Machine Learning
* Natural Language Processing
* Computer Vision

## Application Development

* Graphics
* UI Design
* Software architecture
* ...

## Computer Engineering

* Computer architecture
* Digital Logic
* ...

All of these assume the basic fundamentals: programming, algorithms, the basics of running time and Big Oh analysis, data structures, etc. As mentioned before, these are all interconnected. This is incomplete, but it's a decent approximation. You can, for example, see some of the "tracks" available in the [Columbia University CS curriculum](https://mice.cs.columbia.edu/c/d.php?d=271) or the [Cornell University CS curriculum](https://www.cs.cornell.edu/undergrad/csmajor/electivesCS).

# This course

* Interleaved lectures (by me) and student presentations
* 3 presentations per student (roughly 15-20 minutes per student)
* 2 short papers (2-5 pages and 5-8 pages)

## Lecture portion

* **Functional Programming**.
* Haskell programming language
* Won't cover everything, but get a broad introduction to the topic and major research trends.

## Student presentations and papers

Pick **any** CS topic. We've seen the possible list above and [on the syllabus](syllabus.html), but there are many other things that one can talk about.

* Talks and papers should be **pedagogical**. We should learn from them. Give us a glimpse of what that field or topic is about, why it's important, etc.
* Let me know what topic you are interested in via email by **Friday, September 9**. If you have no idea, come to office hours this week or schedule a Zoom call with me next week.
* Come to office hours **at least one week** before your talks! That will give me time to evaluate whether you have the appropriate resources for the talk, and to suggest other resources if you need them.

**Note for the seniors**: your research topic here may overlap with your senior project, but the focus is different. Here, we are not focusing on producing original work, but on learning and teaching something deeply. For example, if you are working on an idea about quantum computing, your senior project might be a new quantum algorithm, while your papers / talks here might focus on "What is quantum computing?" from a big picture perspective.

## Tentative schedule for workload:

* Pick a topic: weeks 1-2
* Problem set 1: week 2-3
* Presentation 1: weeks 4-5
* Problem set 2: weeks 6-7
* Presentation 2: weeks 8-9
* Midterm paper: week 10
* Problem set 3: weeks 11-12
* Presentation 3: last week of the semester
* Problem set 4: last week of the semester
* Final paper: due during finals week

# Functional Programming

* Alternative to *imperative*-style programming.
* Imperative programming: do this, then do this, then do this.
  * Object-oriented programming (Java) is often imperative
  * Java has added *functional* features more recently.
  * Many languages (Python, C++) can be used with multiple paradigms.
* Functional programming:
  * Functions are first-class objects
  * Complex operations: apply/compose functions
  * View your program as a series of *operations* from the input to the output.
  * Functions are *pure*: no side effects!
  * Examples: Haskell, OCaml (Jane Street), Scala (on the JVM, Morgan Stanley), F# (.NET platform), ...

**Pure** functions?

* Think mathematically
* Result of a function is the same every time it is called on the same input
* No side effects
* Don’t change any state (memory)
  * Objects are immutable (variables are constant?)
* Loops? (Recursion!)

Why would anyone use this paradigm?

## Shared Mutable State

In software, I often heard the proverb "Shared mutable state is the root of all evil."

* **State**? Think data.
* **Mutable**? Data that can be changed.
* **Shared**? Data that can be accessed **in parallel**, by multiple threads / processes!

**Example**: Imagine that you have 100 in the bank. Payday comes and you will receive a 100 deposit. You also wish to withdraw 100. What happens if you do these things at the same time?

In reality: one of those *transactions* will be forced to finish before the other. But in a program?

```java
Bank b = new Bank(); // initializes with $100
ExecutorService pool = Executors.newCachedThreadPool();
for (int i = 0; i < 10000; i++) {
  if (i % 2 == 0) {
    // withdraw $100 in one thread
    pool.execute(b::withdraw); 
  } else {
    // deposit $100 in another
      pool.execute(b::payday); 
  }
}
```

This program simulates doing 5000 withdrawals and 5000 deposits in parallel (across different threads). Running this a few times, I get 100 (correct answer), -400, -1600, 400, ...

Why does this give different answers when I run it different times? What is actually happening? Imagine that two threads are trying to access the bank at the same time. If they are literally executing at the same time, you could encounter a scenario where **both** see \$100 in the bank, and then it just depends on the randomness of which thread finishes last. Example:

**Thread 1**: Sees \$100 in the bank.  
**Thread 2**: Sees \$100 in the bank.  
**Thread 1**: Add 100, now there is \$200 in the bank.  
**Thread 2**: Subtract 100, now there is \$0 in the bank.  

Now after both threads finish, there is nothing left in the bank. (How would we fix this? We would make sure that no two threads could access the bank at the same time. Or...?)

Note: this is a very **simplified** example of an issue with shared mutable state. These issues can be very unpredictable. Many have taken to functional programming as a way of avoiding these issues: after all, you cannot have shared mutable state if you do not have *any* mutable state!

# Haskell

We will be using the Haskell language in this course. We will need GHCup and Visual Studio Code.

(We may need to get set up on GitHub Classroom as well.)

## Set-up

1. [GHCup installer](https://www.haskell.org/ghcup/) Follow the instructions. Make sure to install HLS.
2. [VSCode](https://code.visualstudio.com/download)
3. After installing both: [Haskell extension for VSCode](https://marketplace.visualstudio.com/items?itemName=haskell.haskell) Or: open VSCode, go to Extensions (View -> Extensions), and search for Haskell.

(May also need to update directions here for GitHub Classroom.)

## Starting out

We will mostly use the "interactive" Haskell compiler. This allows us to input in Haskell expressions and the console immediately outputs the result. To do this, we can open a terminal (or use a terminal in VSCode) and type in the command "ghci". (Eventually we might start using "stack ghci").

GHC stands for "Glasgow Haskell Compiler"; ghci is the **interactive shell** mode for this compiler. This is a common environment called a REPL: **read-evaluate-print-loop**.

Now let's follow along some of the examples from [Chapter 2](https://learnyouahaskell.com/starting-out#ready-set-go).

### Arithmetic
{:.no_toc}

> ghci> 2 + 15  
> 1 

> ghci> 8 + 3*(-2)  
> 2

(What happens if you forget the parentheses around -2?)

### Boolean algebra
{:.no_toc}

> ghci> True && False  
> False

> ghci> True || not True  
> True

> ghci> not (True || not True)  
> False

> ghci> 5 == 2  
> False

> ghci> 5 /= 2  
> True

### Function application
{:.no_toc}

Invoke functions by writing the function name, and then the list of parameters, separated by spaces (no commas). (`succ` function is the successor function, which just adds one).

> ghci> succ 2  
> 3

Precedence?

> ghci> succ 3 * 5  
> 20

(It's $4 \times 5$, not $15 + 1$.)

More than one parameter: again, just use spaces to separate

> ghci> max 5 2  
> 5

(What happens if you use parentheses and commas? It thinks the parameter is a **tuple**!)

## Defining functions

Follow along the examples from [Chapter 2](https://learnyouahaskell.com/starting-out#babys-first-functions).

We should be able to:

* Define functions in a haskell file (.hs extension) and load them into ghci
* Define functions which use other functions we have defined
* Use the `if-else` expression

## Type checking

* Haskell is **statically typed**. This means that the type of every expression is known at compile-time.
* Haskell has **type inference**. This means that the compiler can *infer* the type of an expression, so we do not *always* need to declare these.
  * Good practice to do so though!
* To check the type of an expression, use `:t`.

> ghci> :t True  
> True :: Bool

This says that the type of the expression `True` is `Bool`.

More complicated example: consider the "anonymous function" `\x -> x + 3`. This is the function which takes in a parameter x, and returns x + 3.

> ghci> :t \x -> x + 3  
> \x -> x + 3 :: Num a => a -> a  

This is harder to parse. First, it introduces a **type variable** $a$ and states that $a$ has the Num **typeclass**. That is, "Num a" puts a **class constraint** on the type variable $a$. We read the above line as: "The function takes in a parameter of one type and returns a value of the same type. That type must be a member of the Num class."

We will say more about type variables and classes later. Two quick notes:

1. Type classes are kind of like *interfaces* in Java. 
2. Type variables are kind of like *generics* in Java (if you don't know what generics are, think about the type in angled brackets in `ArrayList<Integer>`). 

# Readings

Read Chapters 1 and 2 of the textbook. Get set up with Haskell / VSCode / (GitHub Classroom?).