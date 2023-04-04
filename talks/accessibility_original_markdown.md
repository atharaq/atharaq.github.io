---
title: Accessible Mathematics
author: Athar Abdul-Quader and Knarik Tunyan
date: August 2020
lang: en-US
---

# Sources?

* Accessibility training: "Keep original sources" (Word, PPT, etc).
* Problem: original sources usually in LaTeX
* LaTeX does not compile to accessible PDFs: it doesn't tag the PDFs, and there are not "text to speech" rules for the mathematics expressions.
* Word equations / PPT equations?

# MathML?

* Never used MathML
* Never met a mathematician who ever used MathML
* Who has time?

# This talk

* I will **not** be telling you what works for everyone.
* I **will** tell you what worked for me.
* If you use Word, PPT, etc, feel free to continue using them!
  * Today: converting Word/PPT equations to accessible HTML

# PDF bad, HTML Good

* HTML content is structured.
* Gives hints to screen readers, Braille devices, etc.
* ChromeVox extension: test it out.
* For Math: use MathJax!
  * Type in LaTeX, converts automatically to multiple accessible formats.

# MathJax Examples

Basic examples:

* $x^2$
* $\sqrt{x}$
* Mathematics can be in-line: if $x < -3$, then $x^2 > 9$.
* Mathematics can be displayed on its own: $$\sum_{n=0}^{\infty} \frac{2^n}{n!}$$.

## Continuity

"We say a function $f : \mathbb{R} \to \mathbb{R}$ is continuous at $x = a$ if, for all $\epsilon > 0$, there is $\delta > 0$ such that for any $x$,
$$|x - a| < \delta \implies |f(x) - f(a)| < \epsilon$$."

# Writing HTML?

* Secret: I didn't write *any* HTML for this talk (or any of my notes / slides)
* Workflow:
  1. Write Markdown ([Atom](https://atom.io/) text editor)
  2. Include LaTeX in the document wherever I need mathematical symbols.
  3. Convert to HTML using [pandoc](https://pandoc.org/index.html).

# Pandoc?

Pandoc converts between many different formats!

* HTML
* LaTeX
* Markdown
* docx
* pptx
* etc etc etc

[Full list on pandoc's website.](https://pandoc.org/index.html)

# Using pandoc

* Run on the **command line** (Mac Terminal / Windows Powershell)
* For "lecture notes":
```
pandoc --mathjax -s -o accessibility.html accessibility.md
```

Example: [Discrete Math Lecture Notes](lecture_notes_set0.html).

* For fancy slides:
```
pandoc --mathjax -t revealjs -s -o accessibility.html accessibility.md
```

# LaTeX -> HTML

If you have lecture notes in LaTeX:

```
pandoc -s --mathjax -o output.html notes.tex
```
Be warned:

* Some environments not supported (theorem, proof environments)
* Custom packages might not be supported.
* Best for bare-bones notes, with just text / math.

# AMS Webinar

[Webinar Video](https://ams.zoom.us/rec/play/uZQkdOqu_Do3HNLAuQSDBvZ7W9S_J6-shCYe-fBbnhu1BSFSYwKkZrJBN-CSBM9mU8hJDm0nSiy8K25a?startTime=1594663084000&_x_zm_rtaid=Fdls5bYfRSGCKoDfwXuHig.1595533121371.3565c1a8f399de0e8a0ced83892aa541&_x_zm_rhtaid=516)

Highlights:

* More in-depth accessibility features of MathJax
* Mentioned EquatIO, Word / Google Docs equation editors
* "MathType is geared ... toward visual representation ... not towards accessibility."
* Discussion of captioning (no good solutions :( )

# Graphs / Images?

* No clear standard solution.
* Seems like SVG + alt-text is the best we can do?
