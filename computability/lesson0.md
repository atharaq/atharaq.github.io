# Computability Lesson 0: Introductions
{:.no_toc}

1. Table of Contents
{:toc}

# Computability

In this course, we will formalize the notion of **algorithms** and **computation**. In previous CS courses, you must have seen a definition of algorithm along the lines of: "A precise list of instructions for solving a general problem." This is a great working definition, but it is not a *formal* definition. That means it can be challenging to use this definition in order to discover the *limits* of algorithms. Moreover, we somewhat intuitively know what it means for an algorithm to compute a solution given some input, but coming up with a formal definition can be challenging.

## Algorithm Example

```python
def fn(list):
	m = list[0]
	for n in list:
		if n > m:
			m = n
	return m
```

1. What does the function $fn$ do?
2. What are the abstract capabilities a machine needs in order to *run* this kind of algorithm?

* **Memory**: The machine needs to be able to store an effectively unbounded set of data (the list).
* **State**: The machine needs to be able to keep track of several things:
	* Where in the list it is currently looking at  
	* What line of code it is on  
	* What all the variables are currently set to.  

For any given state / memory snapshot, the machine needs to be able to compute the next state (the next line of code to look at, the next location in the list) and update the memory accordingly.

We will see that this abstraction *is precisely the definition of a Turing Machine*, the most important of the models of computation we will be studying this year!

## Aside: History

In 1900, David Hilbert (famous German mathematician) presented a list of 23 problems in mathematics that he believed to be important in some way to the future of mathematics. These really shaped twentieth century mathematics in an incredible way; for an interesting read on the history of these problems, take a look at [The Honor's Class: Hilbert's Problems and Their Solvers](insert link) by Ben Yandell.

The tenth problem read:

> ... insert text

A *Diophantine equation* is a polynomial (in several variables) with integer coefficients. A *solution* to a Diophantine equation is an assignment of integer values to all the variables that satisfies the equation. For example, the equation $x^2 + y^2 = z^2$ is a Diophantine equation, with many solutions ($x = 3, y = 4, z = 5$ is a solution).

Some Diophatine equations have no solutions. For example, $x^2 + y^2 = -1$ has no solutions in the integers. Hilbert's Tenth Problem basically asked mathematicians if one can devise an algorithm which, given an equation as input, determines if there is some solution to this equation. The problem is that at the time he posed the question, *there was no real definition of an algorithm*! In particular: there were no computers, at least not in the modern sense. But eventually, over the span of 21 years, Martin Davis, Hilary Putnam, Julia Robinson, and finally Yuri Matiyasevich proved that there is no algorithm that can solve this problem in full generality. This really shows the power of computability theory: they didn't just show that *they* failed to produce an algorithm. They showed that *every* algorithm that can possibly be made will *not* solve this problem!

Proving that no algorithm exists to solve a problem sounds like an incredibly daunting challenge. But this wasn't actually the first "unsolvability" proof in history, not even in the history of computability theory.

## Turing

The original paper in which computability theory was born was authored by Alan Turing in 1936 ("On Computable Numbers, With an Application to the Entscheidungsproblem.") This paper is one of the single-most influential papers in mathematics in the twentieth century. There is a particular section of [the paper](insert link) that really helps motivate the constructions of computability theory.

> ... insert text.



# Mathematical writing

What is the problem with the following "proof"?

$$
\begin{align}
x^2 + (x - 1)^2 = 25 \\
x^2 + x^2 - 2x + 1 = 25 \\
2x^2 - 2x - 24 = 0 \\
x^2 - x - 12 = 0 \\
(x - 4)(x + 3) = 0 \\
x = 4, -3 \\
x > 0 \implies x = 4
\end{align}
$$

There are several issues:

1. What are we trying to prove?
2. More importantly, how is one supposed to read this? Are these conditional ("if-then") statements? Are they "and" statements? It's not clear how each statement connects to the next.

Now consider the following:

**Problem**: Find a point on the line $y = x$, in the first quadrant, that lies exactly 5 units from the point $(0, 1)$.

**Solution**: The point $(4, 4)$ lies 5 units from $(0, 1)$. To see this, note that the set of points that lie exactly $5$ units from $(0, 1)$ are those that are on the circle $x^2 + (y - 1)^2 = 25$. If $y = x$, we get the equation $x^2 + (x - 1)^2 = 25$. Some algebraic simplifications give

$$
x^2 - x - 12 = 0.
$$

Factoring, we get,

$$
(x - 4)(x + 3) = 0,
$$

and obtain two solutions: $x = 4$ and $x = -3$. Since the problem asks for a point in the first quadrant, we have $(4, 4)$ as the desired point on the line $y = x$.

The moral of the story is that mathematics is written in natural language. Get in the habit of writing your mathematical arguments *primarily* in English in this course. This example is loosely taken from [Francis Su, "Guidelines for Good Mathematical Writing"](https://math.hmc.edu/su/wp-content/uploads/sites/10/2019/11/good-math-writing.pdf).


# LaTeX Markup

Have you ever wondered how mathematical articles are typed? We do not have symbols on the keyboard for things like exponents, so $x^2$ might not be so easy to write. $\pi$ will certainly not appear on your keyboard, either, and good luck finding the symbol for $\int$.

The answer is called **LaTeX**. LaTeX is a markup language used to typeset academic articles. Academic articles are **not** written in Microsoft Word or Google Docs: while you *can* get them to understand mathematical equations, it is not standard and somewhat clunky. LaTeX is **the** standard. These course notes are a minor exception: in addition to LaTeX for the mathematical symbols, I am also using Markdown (converted to HTML) and MathJax (a Javascript library that renders LaTeX on the web).

## Setting up
{: .no_toc}

There are several ways to set up and install LaTeX. If you prefer not to install anything on your local computer, you can create a **free** account on [Overleaf.com](https://www.overleaf.com). This is the simplest way to get up and running.

If you prefer to use LaTeX on your own computer, you will need two things:

1. A LaTeX *distribution*: either [MacTex](https://www.tug.org/mactex/), on Mac OS X, or [MikTex](https://miktex.org/about) for Windows.
2. A LaTeX *editor*: my preference is [texstudio](https://www.texstudio.org). MikTex and MacTex both come with LaTeX editors, and so you can use those if you like (MikTex comes with TeXworks, MacTex comes with TeXShop), though I prefer TeXstudio.

Once you have written your document in LaTeX, saved as a .tex file, you will be able to compile it to a PDF.

## Basic Formatting
{: .no_toc}

A simple LaTeX file may look something like:

~~~latex
\documentclass{article}

% This is a comment
% This part of the file is called the preamble.
% Title / author / date can go here
% Can also include packages that we need to use to render the math correctly
\title{This is my title}
\author{My Name}

\begin{document}

% This is the main body of the document.
\maketitle

Paragraph 1.

Paragraph 2.

\end{document}
~~~

It can be overwhelming to start a LaTeX document from scratch, so feel free to use the homework files I post to start. I include several packages, macros and definitions in my preamble.

## Formatting Math
{: .no_toc}

To format math in a LaTeX file, you use dollar signs to start and end your mathematical notations. Technically this is referred to as "in-line" math mode: for example, to write the sentence "If $a \neq 0$, then $ax^2 + bx + c$ is a quadratic polynomial", you use the following LaTeX syntax:

~~~latex
If $a \neq 0$, then $ax^2 + bx + c$ is a quadratic polynomial.
~~~

This is "in-line", since the math is formatted in the middle of the sentence. There is also "displayed" math mode: you can use two dollar signs (\$\$) to start and end, and that will display the mathematical content on its own line.

As you can see, there are certain commands we use to put in mathematical notation. For exponents / superscripts we use the carat (^), for "not equals" ($\neq) we use "\\neq". There are many good guides to finding basic LaTeX commands for mathematical notation, you can find them in the [further reading](#further-reading) section.

## Further reading

These first two are essential: you **must** check these out.

* [NYU: Guide to LaTeX](https://guides.nyu.edu/c.php?g=601858&p=4168084). This link is quite thorough and has many other links to other resources to help you get set up. The [resources](https://guides.nyu.edu/c.php?g=601858&p=4168135) section on the site has lots of good links to finding LaTeX commands and symbols.
* [David Xiao, "A Beginner's Guide to LaTeX" (Princeton)](https://www.cs.princeton.edu/courses/archive/spr10/cos433/Latex/latex-guide.pdf) This is a short (6 page) description of the basics of LaTeX.
* [The Not So Short Introduction to LaTeX 2e](https://tobi.oetiker.ch/lshort/lshort.pdf) This 150+ page reference manual describes many of the core functionalities of LaTeX.

# Lesson 1 "Pre-work"

0. Read Chapter 0 of Sipser. This is posted on Moodle.
1. Use the .tex file posted on Moodle. Fill in your name / year / major, put in any questions you have about the reading, and then re-write the following argument that if $f(x)$ and $g(x)$ are differentiable at $x = a$, then $(f + g)(x)$ is differentiable at $x = a$:

$$
\begin{align}
(f + g)^\prime(a) &= \lim_{x \rightarrow a} \frac{(f + g)(x) - (f + g)(a)}{x - a} \\
&= \lim_{x \rightarrow a} \frac{(f(x) + g(x)) - (f(a) + g(a))}{x - a} \\
&= \lim_{x \rightarrow a}(\frac{f(x) - f(a)}{x - a} + \frac{g(x) - g(a)}{x - a}) \\
&= f^\prime(a) + g^\prime(a)
\end{align}
$$

