# Calculus I Lesson 1

Before starting this lesson, make sure to complete the homework assignments on DeltaMath and on Moodle. This includes watching the "Essence of Calculus" video!

# Warm-up Exercise

Give examples of the following:

1. A function which is bounded above (does not go off to positive $\infty$).
2. A function which has a horizontal asymptote.
3. A function which is bounded below, but does not reach its smallest value
4. A function which is bounded above and below

<details>
<summary>Possible answers: you may have found many other examples!</summary>
<ol>
<li>$f(x) = 1 - x^2$</li>
<li>$g(x) = \dfrac{x+1}{x-1}$ has a horizontal asymptote: $y = 1$</li>
<li>$h(x) = e^x$</li>
<li>$k(x) = \sin(x)$</li>
</ol>
</details>

# More types of Functions

We have seen several kinds of functions in the last lesson and in this one:

* Rational Functions: polynomial functions are an example of these types of functions. Notice that $p(x) = x^2 + x - 3$ can be written as a fraction $p(x) = \dfrac{x^2+x-3}{1}$. Rational functions are any functions that can be written as a fraction of polynomials. Notice that the graph of $g(x) = \dfrac{x+1}{x-1}$ is unbounded, but has a finite limit!
<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/xepitqavld?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>
* Exponential Functions: and their inverses, logarithmic functions! We will have a quick refresher on inverse functions later on, but some important examples of exponential functions and logarithmic functions we will study will be $e^x$, $2^x$, $\ln(x)$ and $\log_2(x)$. You should know your rules for exponents, and you should be familiar with the rules for logarithms (enough that you can look them up if you need them).
* Trigonometric functions: give examples of *periodic* functions. $\sin$, $\cos$, and $\tan$ are the most important ones, but you should be familiar with all six basic trig functions, their graphs, trig identities, the unit circle, and inverse trig functions $\arcsin$, $\arccos$, and $\arctan$ (and the domains of these functions).

In calculus, we study how functions behave. We ask questions like: is this function continuous? Is it "smooth" (or does it have jagged edges / corners)? Does it go off to infinity / negative infinity? Does it change between increasing and decreasing often? Does it have an absolute maximum / minimum, local maxima / minima, and how many of each?

It's important to have a rich vocabulary of functions that have different kinds of behaviors, so we do not overgeneralize from some simple examples. For example: if all we know are polynomial functions, we might forget that functions can have horizontal asymptotes, which makes them approach some finite number as $x$ goes off to infinity. We may forget that the *domain* of a function is not always all real numbers.

I know that many of us do *not* remember trig, inverse trig functions, or logarithms well. But these provide good examples of functions that behave very differently from polynomials. For example, here is the graph of $y = \arctan(x)$:
<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/7cyqqppc24?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

If we had never seen the graph of $\arctan(x)$, we might not expect that a function can approach a number above and below, but never actually reach either one of them. Look at how close the graph gets to the asymptotes.

## Algebraic and Transcendental Functions

Where does $f(x) = \sqrt{x}$ show up in the above? (Answer: nowhere). The square root function is classified as an *algebraic* function. Algebraic functions are like rational functions, except that they allow powers of $x$ to be any rational number. For example:
$$f(x) = \dfrac{1+x^4}{\sqrt{x}-x^\frac{2}{5}}$$

In other words, algebraic functions are all of those functions which can be formed by starting with all rational number powers of $x$, any constant multiples of these terms, and adding, subtracting, multiplying and dividing these expressions. Recall that $\sqrt{x}$ can be expressed as $x^{\frac{1}{2}}$. Can every function be expressed like this? How about $g(x) = \sin(x)$ or $h(x) = \ln(x)$? Is there a way to express these using powers of $x$?

No! These functions are *transcendental*. Transcendental functions cannot be expressed using addition, subtraction, multiplication and division (the "algebraic" operations) along with rational exponents.

Side note: There is a related concept for numbers: [algebraic](https://en.wikipedia.org/wiki/Algebraic_number) and [transcendental](https://en.wikipedia.org/wiki/Transcendental_number) numbers.

# Inverses

You should be familliar with the concept of inverse functions. The basic notion is that if $y = f(x)$, then the inverse function (if it exists) is the function which swaps $x$ and $y$. We write that as $f^{-1}$: so if $y = f(x)$, then $x = f^{-1}(y)$.

Simple examples:

1. If $f(x) = 2x$, then the inverse function is $f^{-1}(x) = \dfrac{x}{2}$.
2. If $f(x) = x + 3$, then the inverse function is $f^{-1}(x) = x - 3$.

Not all functions have inverses. A function has an inverse if it passes the **horizontal line test**: that is, if every horizontal line you draw on the graph of the function hits the function in at most one point. For some functions, this does not happen. For example, look at the graph of $f(x) = x^2$: the line $y = 1$ hits the graph in two places.

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/2rpj5ivdo2?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

In this case, we *restrict the domain*:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/7cqprb3juc?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

Now notice that for $x \geq 0$, if $y = x^2$, then $x = \sqrt{y}$. Of course we know this intuitively: the square root function is the inverse of the squaring function, but only for positive numbers.

## Logarithms are Inverses

Students often have trouble computing logarithms. This is because logarithms are inverse functions. We determine the value of $\log_b(x)$ by asking the question: "What power do I need to raise $b$ to, in order to get $x$?" Some examples:

1. $\log_2(8) = 3$ because $2^3 = 8$.
2. $\log_2(2) = 1$, because $2^1 = 2$.
3. $\ln(1) = 0$, because $e^0 = 1$. (Note: remember that $\ln$ means $\log_e$!) More generally, $\log_b(1) = 0$.
4. $\ln(e^x) = x$, or more generally, $\log_b(b^x) = x$.
5. $e^{\ln(x)} = x$, or more generally, $b^{\log_b(x)} = x$.

We use this same intuition to figure out inverse trig functions. For example, $\arcsin(1) = \pi/2$, because $\sin(\pi/2) = 1$. Similar to the parabola above, trig functions do not have inverses unless we restrict the domain of the functions. [Review the restricted domains of inverse trigonometric functions in the textbook](https://openstax.org/books/calculus-volume-1/pages/1-4-inverse-functions#fs-id1170572141300).

---

Before moving on, if you know you have a lot to review regarding kinds of functions and their behaviors, you should take a look at [Chapter 1](https://openstax.org/books/calculus-volume-1/pages/1-introduction) of the textbook. There are also many other resources available to review material from precalculus:

* [Paul's Online Notes: Review](https://tutorial.math.lamar.edu/classes/calci/ReviewIntro.aspx) This is a great website with lecture notes from several math courses. I am linking the "review" section of the Calculus I notes.
* [Khan Academy](https://www.khanacademy.org/): Khan Academy has many lecture videos and practice problems available for topics from all levels of mathematics. You may need to search for a particular topic to find it.
* [Professor Leonard](https://www.youtube.com/watch?v=1EGFSefe5II&list=PLF797E961509B4EB5&index=2) This is a YouTube channel of an entire Calculus I course. There are several videos here reviewing functions.

---

# Main ideas of calculus

As per the [Essence of Calculus](https://www.youtube.com/watch?v=WUvTyaaNkzM) video you watched for the homework assignment, the two main themes of this course are *change* (derivatives) and *accumulation* (integrals), and, more precisely, how these two themes relate.

We asked several interesting questions on day one: how do quantities change over time? How *fast* do they change? Is the climate getting warmer? Is climate change *accelerating*? How can we *slow down* climate change?

We have seen discussion about change and accumulation in the news quite often. On March 27, [Governor Cuomo said](https://www.cnbc.com/2020/03/27/new-york-gov-andrew-cuomo-extends-school-closures-as-coronavirus-cases-rise.html):

> “The rate of increase is slowing. But the number of cases are still going up.”

What is he actually saying here? Calculus helps us develop the tools to parse out, precisely, the difference between the "rate of increase" and the change in the actual number of cases.

We also know, intuitively, that there is a relationship between the number of new cases per day and the total number of cases. This relationship captures the essence of the two themes. "Change" shows up as the number of new cases per day: it is the change in the total number of cases from one day to the next. "Accumulation" is the total: add up all the new cases per day, and you'll get the total.

There is a similar relationship between the velocity of a particle at any given moment in time, and the distance it travels. If a car is driving, on average, 50 miles per hour, for three hours, then it must have driven 150 miles. Do you see the concepts of "change" and "accumulation" here?

In calculus, we are more precise about these notions of change and accumulation. The precise term for the "instantaneous rate of change" is the **derivative**, while the precise notion for the accumulation of a quantity between two points is the **integral**. For now we will just think about drivatives.

## Derivatives: Rates of Change

To discuss the notion of "rate of change" more precisely, let's talk about a specific example. Let's say we drop a ball from a height of 45 meters. Its height (in meters), $t$ seconds later, is (roughly) given by the equation

$$h(t) = 45 - 5t^2$$
<div class="desmos-container"><iframe title="Dropping a ball graph" src="https://www.desmos.com/calculator/ubtswqoxv5?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

There are several questions about the velocity of the ball we can ask:

1. What is the *average* velocity of the ball in the first second after it is dropped? (From $t = 0$ to $t = 1$)?
2. What is the *average* velocity of the ball from $t = 1$ to $t = 3$?
3. What is the *average* velocity of the ball from $t = 1$ to $t = 2$?

Try to work these out on your own. Velocity is a rate of change. The *average rate of change* for a function $f(x)$ from $x = a$ to $x = b$ is given by the formula
$$\dfrac{\Delta y}{\Delta x} = \dfrac{f(b) - f(a)}{b - a}$$

<details>
<summary>Check your answers here:</summary>
<ol>
<li>$\dfrac{f(1)-f(0)}{1-0} = -5$ m / s.</li>
<li>$\dfrac{f(3)-f(1)}{3-1} = -20$ m / s.</li>
<li>$\dfrac{f(2)-f(1)}{2-1} = -15$ m / s.</li>
</ol>
</details>

Note: why are these answers all negative?

How do these quantities show up on the graph above? These all show up as slopes of secant lines: lines between two points on the graph.
<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/g1oa7aedyd?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

All of these refer to the velocity of the ball between two points in time: the change in the distance divided by the change in time. But what *is* the velocity of the ball at **exactly** 1 second after it is dropped? We see that average speed is something we can compute by seeing how far the ball moved in a certain amount of time. But instantaneous speed does not really make sense intuitively. So what does it actually mean?

Well, what could it mean? Write down some of your thoughts. As part of the lesson check in (later), you will be asked to discuss these thoughts a bit.  Let's zoom in on the graph near $t = 1$, and play around with different secant lines. This dynamic graph below shows what happens when we graph the secant lines between $t = 1$ and points close to that, allowing the value of $a$ to change from 0.5 to 1.5.

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/9gpc6fmosr?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

[View this graph on Desmos](https://www.desmos.com/calculator/9gpc6fmosr){:target="_blank"}.
Zoom in and out, and pause the "$a$" slider on the left at various points to see how the graph changes. Remember: the slopes of these lines tell you the average speed of the ball between those two points in time ($t = 1$ and $t = a$). What happens as $a$ gets really, really close to $t = 1$?

## Unifying theme: Limits

The key point above is that there really isn't an *algebraic* way to define the speed of an object at an **exact** instant in time. We can look at the rate of change between two, different points in time, but not for just a single, individual point.

This is where the concept of calculus really kicks in. The difference between calculus and algebra is the notion of a **limit**. Instead of thinking about the "instantaneous speed" of the ball exactly 1 second after it is dropped, we first think about average speeds between two points, and then think about what happens as those two points get closer and closer together.

In other words, the **instantaneous** speed at $t = 1$ is defined to be the limit of the *average* speeds between $t = 1$ and $t = a$, as the number $a$ gets closer and closer to 1. In the next few lessons, we will explore this concept of a limit more closely, but this is the intuition. In terms of the graph we saw above, we think about how the secant lines get closer and closer to something else: a *tangent* line!

A *secant* line on a graph is a line that connects two points on the graph. The graph below depicts a tangent line:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/zbbni7eoid?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

What do you think a good definition of a tangent line is? What do you think is the relationship between average rates of change and secant lines on the one hand, and instantaneous rates of change and tangent lines on the other?

# Lesson check-in

Answer the following questions in complete sentences on Moodle.

1. Give your best explanation of what "instantaneous velocity" means. Think about when you are driving in a car. How do you understand the speed of a car at an **exact** moment / snapshot in time?
2. Give your best explanations of what secant and tangent lines represent on a graph. Use different examples than the "ball dropping" example we covered in this lesson. (You can use the graphs from the first lesson warm up if you'd like).
3. Give your best explanation of what the slopes of secant and tangent lines represent. You may expand on your examples in the previous question.
