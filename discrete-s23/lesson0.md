# Discrete Mathematics Lesson 0: Intro to Course, Mathematical Writing, LaTeX
{: .no_toc}

1. Table of Contents
{:toc}

# Warm-Up

We start with a game for two players. The game works as follows:

* Players take turns choosing integers from 1 - 9 (inclusive).
* Once a number is chosen, the other player cannot choose it.
* A player wins if they choose three numbers that add up to 15.

For example:

* P1: 8
* P2: 5
* P1: 2
* P2: 6
* P1: 4 (does not win yet, since $8 + 2 + 4 = 14$)
* P2: 9 (does not win, because $9 + 6 + 5 = 20$)
* P1: 3 (**wins**: $8 + 4 + 3 = 15$)

Notice that player 1 does not use all four numbers that they pick: they can only use three numbers out of the ones they pick. It's possible for the game to end in a tie.

Pair up!

* Introduce yourself: name, pronouns, year, major, interests, etc.
* Play the game. Try playing it a few times, with each person playing as player 1 sometimes and player 2 at other times.
* After playing the game for a few minutes, see if you can come up with a strategy.
* Does this game and/or its strategy remind you of any other games you have played in your life?
* Then try to play against another group.

# Introduction

> To miss out on mathematics is to live without an opportunity to play with beautiful ideas and see the world in a new light. To grasp mathematical beauty is a unique and sublime experience that everyone should demand. All of us—no matter who you are or where you’re from—can cultivate mathematical affection.

&mdash; Francis Su, *Mathematics For Human Flourishing*

## What is "Discrete Mathematics"?
{: .no_toc}

The name "discrete mathematics" does not really seem to give a lot of information about the course. From the course description:

> Covers a variety of topics that provide a foundation for both higher mathematics and computer science. These topics may include logic and formal proofs, set theory, number theory, probability, mathematical induction, algorithms, recurrence relations, equivalence relations and partial orderings, and topics in graph theory (including isomorphism, traversability, planarity, and colorings).

How do we get all of that from the word "discrete"? Essentially, the word "discrete" is meant in opposition to the word "continuous": the set of real numbers forms a "continuum", an infinite straight line with no holes. The study of "continuous" mathematics is more commonly referred to as calculus, where we study limits, continuity, derivatives, and integrals. These are fundamentally "continuous" notions: one needs the fundamental properties of the real number line to study calculus.

In discrete mathematics, on the other hand, we mostly concern ourselves with those mathematical structures which do not rely on notions of limits / continuity. Many of the questions we ask are, therefore, questions that can be asked about any mathematical structure (not just questions that can be asked about functions of real numbers). The simplest examples are "counting" type questions: "how many objects of type A are there that also satisfy property X?"

### Who is this course for?
{: .no_toc}

This course is often required in most computer science departments. It is usually considered a prerequisite for higher level computer science courses, as it provides the mathematical background needed for courses like Data Structures, Computability, and Algorithms.

That said: this is a **mathematics** course. In some mathematics departments, there is a "bridge" course which bridges the gap between calculus based courses and upper level, abstract mathematics courses. This course does not serve that explicit purpose, but much of the material found in those "bridge" courses will be covered here (material on logic, set theory, cardinality, induction).

## Course Format and Expectations
{: .no_toc}

This course will be taught in a somewhat **flipped** model. That means that most of the lectures will be self-paced: you will do the assigned reading (usually my lecture notes, but sometimes from the textbook), solve some problems, complete an exit ticket, and then start working on homework problems.

"Self-paced" lessons might sometimes include "guided problem sets". The purpose is of course for you to learn the material by figuring out certain things for yourselves. It may feel a bit uncomfortable: how will you know that you actually learned anything? If you need reassurance, I will of course be available via office hours and we will always discuss challenging problems and concepts in class.

**Important**: self-paced does not mean "due whenever you want". You should keep up with the material on a regular basis. Make sure to ask me questions if you get stuck on an important concept during a lesson.

In class, we will go over these problems, work on the problem sets together, and, at times, students will present solutions. Every so often, we will also explore new material. This will be a good opportunity for me to go over the concepts and problems that were most confusing from the previous set of self-paced lessons and/or problem sets, and get you started on the new topics.

You are strongly encouraged to form study groups. This course will be challenging at times, and it will be useful for you to check-in with each other and see if others are struggling on the same things.

## Workload
{: .no_toc}

* 5-7 Problem Sets (roughly 2-3 weeks) (30%)
* Exit Tickets (10%): short assignments to make sure you are following along with the lessons.
* 2 mid-semester exams (10% each, take home?)
* 1 final exam (20%, take home?)
* 10% Problem Presentations: two short (~5 minutes) explanations of a challenging problem. Done **in-class**, around the time of exam 1 and exam 2.
* 10% Final Project: group project. research a topic not covered in our coursework, present it in our final meeting of the course, and write a paper about it.

# Mathematical writing

Before we even cover any actual topics in discrete mathematics, we need to cover a more fundamental topic: writing. We communicate mathematics by writing, and so it is important that we understand how to write well.

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

**Exercise**: Re-write the following proof that if 6 is a factor of a number $n$, then $n$ is even.

$$ n = 6k = (2 \times 3)k = 2 \times (3k) = 2x, x = 3k $$

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
{: .no_toc}

These first two are essential: you **must** check these out.

* [NYU: Guide to LaTeX](https://guides.nyu.edu/c.php?g=601858&p=4168084). This link is quite thorough and has many other links to other resources to help you get set up. The [resources](https://guides.nyu.edu/c.php?g=601858&p=4168135) section on the site has lots of good links to finding LaTeX commands and symbols.
* [David Xiao, "A Beginner's Guide to LaTeX" (Princeton)](https://www.cs.princeton.edu/courses/archive/spr10/cos433/Latex/latex-guide.pdf) This is a short (6 page) description of the basics of LaTeX.
* [The Not So Short Introduction to LaTeX 2e](https://tobi.oetiker.ch/lshort/lshort.pdf) This 150+ page reference manual describes many of the core functionalities of LaTeX.

# Exit Ticket 0: Due Monday, January 23

1. Get set up using LaTeX (either method).
2. Download the exit0.tex file on Moodle. Edit it, replace the sections for your name, year and major.
3. In the rest of the document, re-write the following argument that if $a$ is even and $b$ is a multiple of $a$, then $b$ is also even:

   $$
   \begin{align}
   a = 2k \\
   b = na = n(2k) = 2(nk) \\
   b = 2x, x = nk \\
   b \text{ is even!}
   \end{align}
   $$
   
4. Compile the document to a PDF and upload the PDF to Moodle.
