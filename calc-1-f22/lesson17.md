# Calculus I Lesson 17: Applied Optimization
{:.no_toc}

1. Table of Contents
{:toc}

# Upcoming

* Rough Draft (Monday, **November 21**) (two weeks)
* Problem Presentation 2: **Friday, December 2**
* Exam 3: given 11/28, due **12/5** (four weeks)
* Final Paper: **Monday, December 12**
* Final Exam: take home, due **Thursday, December 15**.
* As always: if you need help, flexibility with deadlines, heads up about what's upcoming, etc, just ask!

## Advising / Registration Spring 2023

* Calculus II
* Computer Science I
* Computer Science II
* Discrete Mathematics
* Origins of Mathematics
* Creating User Interfaces

# Exam Recap

* Cannot do specific problems right now.
* But happy to go over concepts / processes.
* So... questions?

# Applied Optimization

## Running and Swimming

An island is 2mi due north of its closest point along a straight shoreline. A visitor is staying at a cabin on the shore that is 6mi west of that point. The visitor is planning to go from the cabin to the island. Suppose the visitor runs at a rate of 8mph and swims at a rate of 3mph. How far should the visitor run before swimming to minimize the time it takes to reach the island?

![Running and Swimming Picture](https://openstax.org/resources/d894012fd6e414e50b061ed4910e7470b7ce8065)\

**Attempt 1**: Swim straight there?

* Triangle: $a^2 + b^2 = c^2$
* $2^2 + 6^2 = c^2$
* $c = \sqrt{40}$
* Time: $\dfrac{\sqrt{40}}{3}$ hours, or about 2 hours and 6 minutes.

**Attempt 2**: run 6 miles east, swim 2 miles north.

* Running: $6 \mbox{ miles} \times \dfrac{1 \mbox{ hour}}{8 \mbox{ miles}} = \frac{3}{4}$ hours, or 45 minutes.
* Swimming: $2 \mbox{ miles} \times \dfrac{1 \mbox{ hour}}{3 \mbox{ miles}} = \frac{2}{3}$ hours, or 40 minutes
* Total: 1 hour 25 minutes

Better than swimming straight there. But is that the **best** option?

**Solution**: Absolute minimum!

* Run $x$ miles, swim $y$ miles.
* Time: $\frac{x}{8} + \frac{y}{3}$.
* What is $y$ in terms of $x$?

![Running and Swimming Picture](https://openstax.org/resources/d894012fd6e414e50b061ed4910e7470b7ce8065)\

* Swap $x$ and $(6-x)$, makes the calculation easier.
* Run $6 - x$ miles, swim $y$ miles.
* $\frac{6-x}{8} + \frac{y}{3}$

Then use the fact that $y^2 = 2^2 + x^2$, so $y = \sqrt{x^2 + 4}$. We can come up with a function for the time it takes to get there if we run $x$ miles:

$$T(x) = \frac{6-x}{8} + \frac{\sqrt{x^2+4}}{3}.$$

We look for the absolute minimum of $T(x)$ over the interval $[0, 6]$. Set $T^\prime(x) = 0$: $T^\prime(x) = -\dfrac{1}{8} + \dfrac{x}{3\sqrt{x^2+4}}$.

Set that equal to 0 and solve:

* $\dfrac{x}{3\sqrt{x^2+4}} = \dfrac{1}{8}$
* $\dfrac{x^2}{9(x^2+4)} = \dfrac{1}{64}$
* $64x^2 = 9x^2 + 36$, or $55x^2 = 36$
* $x = \pm \sqrt{\frac{36}{55}}$

Since negatives don't make sense, we get: T(\sqrt{\frac{36}{55}}) \approx 1.368$ hours. About 1 hour and 22 minutes.

This is shorter than the endpoints! (We already checked those). So this is the absolute minimum of $T(x)$ on this interval!

# General Strategy

Problems like these are called **optimization** problems.

* Optimize: maximize or minimize some function
* Draw a picture
* Set up a function
* Maximize / minimize (set derivative equal to 0)
* If needed, check endpoints

## Rectangular Fencing

You have 900 ft of fencing with which you wish to make a rectangular pen for your 30-50 (feral?) hogs. Find the dimensions of the pen which maximizes the area.

1. Draw a Picture (on the board / together in class).
2. Set up a function:
  * Since the perimeter is 900, we have $2(w + l) = 900$, or $w + l = 450$.
  * $A = w \times l = w(450 - w)$.
  * Plug in, and we can get a function for $A$ in terms of just $w$: $A(w) = w(450-w)$, or $A(w) = 450w - w^2$.
  * Maximize: $A^\prime(w) = 450 - 2w$.
  * Solve: $w = 225$.
3. Check endpoints:
  * Endpoints? $0 \leq w \leq 450$: $A(0) = 0$, $A(450) = 0$,
  * $A(225) = 225 \times 225 = 50625$ square ft.

The largest rectangle, given a fixed perimeter, is a square: 225 x 225.

Can you make a general conjecture and prove it?

# "Honeycomb Problem"

Why do bees make honeycombs using hexagons?

![Hexagon Tiling](https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Hexagons.svg/200px-Hexagons.svg.png)\

## Optimization Problem

* Find the smallest amount beeswax needed to create the largest honeycomb cells.
* **Honeycomb Conjecture**: a hexagonal grid is the most efficient way to divide a plane into equal areas, with minimal perimeter
* First Conjectured in antiquity (36 BC?)
* Proven in 1999! Thomas Hales (University of Pittsburgh)

Circles?

![Circle Tiling](https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Circles_packed_in_square_15.svg/200px-Circles_packed_in_square_15.svg.png)\

Lots of wasted space.

There are two other ways to **tile the plane** using regular polygons: squares and triangles.

![Square Tiling](https://i.stack.imgur.com/p3wFT.png)\

But the hexagonal one uses less perimeter for the same areas.

## Other ways?

General result: even if you consider irregular shapes (with curves, irregular polygons), the most efficient way to divide the plane into equal areas, using the least perimeter, involves using hexagons.

Watch this video on the honeycomb problem:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/kxDEcODUEP0" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
