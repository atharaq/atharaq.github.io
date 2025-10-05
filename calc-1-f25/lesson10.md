# Calculus I Lesson 10: Chain Rule
{:.no_toc}

1. Table of Contents
{:toc}

# Warm Up

Use the quotient rule to find the derivatives of the following functions:

1. $f(x) = \frac{1}{x}$.
2. $g(x) = \frac{1}{x^2}$.
3. $\sec(x)$. Recall that $\sec(x) = \frac{1}{\cos(x)}$.

# Final Paper

* 5 - 10 page paper
* Two prompts, but you can write about other things
* Roughly: "Calculus in the news / sciences" / "History of calculus"

## Prompt 1: Calculus in the news

> “In the fall of 1972 President Nixon announced that the rate of increase of inflation was decreasing. This was the first time a sitting president used the third derivative to advance his case for reelection.”

Hugo Rossi, *Notices of the American Mathematical Society (October 1996)*

> “The rate of increase is slowing. But the number of cases are still going up.”

[(then)-Governor Cuomo (March 27, 2020)](https://www.cnbc.com/2020/03/27/new-york-gov-andrew-cuomo-extends-school-closures-as-coronavirus-cases-rise.html)

Both of these quotes are discussing how a quantity is changing over time: that is, they are all echoing the concept of the derivative. In fact: both refer to *higher order* derivatives.

**Prompt 1**: Find an article / news clip / podcast / etc in which two quantitative variables are related.

* Describe this relationship mathematically:
  * which variable is being described as “dependent” upon the other variable?
  * How does the dependent variable change with respect to the independent one?
  * Formalize this relationship in the form of derivatives (possibly including higher-order derivatives)
* Look for data that supports or refutes the claim.

## History

* Calculus was "invented" by Newton and Leibniz?
* Many other contributors: before and after!

**Prompt 2**: Find out as much as you can about any mathematician who contributed to the development of calculus and describe their contributions as deeply as you can. This paper can be either more *historical*, or *mathematical*.

If you're interested in mathematical topics?

* Functions that are differentiable, but don't have a second derivative
* Functions that are continuous, but not differentiable
* Functions which are continuous, but nowhere differentiable
* Treatment / rejection / acceptance of "infinitesimals"

If you're interested in historical topics?

* Historical context: (mathematical training, mathematics known at the time, etc)
* Background: why were these mathematicians interested in these problems?

Either way:

* Touch on both mathematics and history. Emphasize either.

Some mathematicians of interest:

* Hasan ibn al-Haytham ("Alhazen"), 900s-1000s
* Sofya Kovalevskaya, 1800s
* Augustin-Louis Cauchy, Bernard Bolzano, and/or Karl Weierstrass 1700s-1800s
* Abraham Robinson, 1960s

Many others. Do some initial research on history of calculus and see what piques your interest!

## Topic Statement

**Due October 20**. Pick a **specific** topic you'd like to study. Narrow it down as much as you can, and give a short summary of what you'll study.

* Not just "Calculus in the news", but "I'll be studying trends in inflation in different sectors of the economy over the last 30 years."
* Not just "History", but: "I will be studying the contributions of Maria Gaetana Agnessi to the development of calculus."

## Other deadlines

* **10/20**: Topic Statement + Sources
* **11/3**: Initial notes + outline
* **11/24**: Rough draft
* **12/8**: Final draft

# Problem Presentations

You will have two **problem presentations** this semester. The idea:

* Describe a **challenging** problem:
  * From Homework?
  * From the textbook, not assigned?
  * From the Exam?
  * Anywhere else?

Keep the presentation short: about **5 minutes** or so in total.

You will be evaluated (out of 5 points) on the following criteria:

* State the problem clearly.
* Describe what was challenging about this problem (why you picked this problem).
* Explain the method of the solution (and how you knew to use that method).
* Show the steps for your solution.
* Answer any questions from your classmates about the problem.

You can choose to present the problem on the chalkboard / whiteboard or you can create slides (PPT, Keynote, Google Slides, whatever) and upload them to the assignment space on BrightSpace.

We will be presenting on the following dates:

* Monday, 10/13 (4 students)
* Thursday, 10/16 (4)
* Monday, 10/20 (4)
* Thursday, 10/23 (5)

I can take volunteers for specific dates or I can randomly assign students to present.

# Recap:

Recall: the **quotient rule**

$$ (\frac{f(x)}{g(x)})^\prime = \frac{f^\prime(x)g(x) - g^\prime(x)f(x)}{(g(x))^2}$$

and the trig derivatives:

* $(\sin(x))^\prime = \cos(x)$
* $(\cos(x))^\prime = -\sin(x)$

Last time, we looked at $f(x) = \cos(x)$. In particular, $f^\prime(0) = 0$. Why is this? Look at the unit circle. Remember that $\cos(\theta)$ is the $x$-value of the point on the unit circle at angle $\theta$.

![Unit Circle](https://www.mathsisfun.com/geometry/images/unit-circle.svg "Unit Circle")\

Near $\theta = 0$, how quickly does that $x$-value change? What about near $\theta = \frac{\pi}{2}$?

## Derivative of $\sec(x)$

$\sec(x) = \dfrac{1}{\cos(x)}$. So again use the quotient rule:

$$
\dfrac{0 - (-\sin(x))}{(\cos(x))^2}
$$

We can write this as $\dfrac{1}{\cos(x)} \dfrac{\sin(x)}{\cos(x)} = \sec(x)\tan(x)$.

# Chain Rule

Recall **function composition**:

* $(f \circ g)(x)$ means $f(g(x))$

**Theorem: The Chain Rule**. Suppose $f$ and $g$ are differentiable. Then $(f \circ g)^\prime(x) = f^\prime(g(x)) g^\prime(x)$.

* "Derivative of the outside function, plugging in the inside, times the derivative of what's inside"

Why? How does this end up happening? Let's do an example, without using the chain rule, and see if we can "spot" it showing up.

Let $f(x) = (\sin(x))^2$. Let's try to compute the derivative at $x = \pi$. First we will need to look at the following rate of change, and then consider the limit at $x \rightarrow \pi$:

$$\frac{f(x) - f(\pi)}{x - \pi} = \frac{(\sin(x))^2 - (\sin(\pi))^2}{x - \pi}$$

Instead of computing this directly right now, notice that as $x \rightarrow \pi$, there is some change in $\sin(x)$, which corresponds to some change in $(\sin(x))^2$. How do we get the derivative of $\sin(x)$ to show up in the above fraction? Multiply by $\frac{\sin(x) - \sin(\pi)}{\sin(x) - \sin(\pi)}$!

$$\frac{(\sin(x))^2 - (\sin(\pi))^2}{x - \pi} \cdot \frac{\sin(x) - \sin(\pi)}{\sin(x) - \sin(\pi)} = \frac{(\sin(x))^2 - (\sin(\pi))^2}{\sin(x) - \sin(\pi)} \cdot \frac{\sin(x) - \sin(\pi)}{x - \pi}$$

Let's look at each of these fractions individually. One of them, as $x \rightarrow \pi$, should be obvious: $\frac{\sin(x) - \sin(\pi)}{x - \pi} \rightarrow \cos(\pi)$, since this is just the derivative of $\sin(x)$ (evaluated at $x = \pi)$.

The other one: $\frac{(\sin(x))^2 - (\sin(\pi))^2}{\sin(x) - \sin(\pi)}$ is interesting. Let's make a change of variables. Let $u = \sin(x)$. Then as $x \rightarrow \pi$, $u \rightarrow \sin(\pi)$. Now this looks like: $$\frac{u^2 - (\sin(\pi))^2}{u - \sin(\pi)},$$ which, as $u \rightarrow \sin(\pi)$, is just the derivative of $u^2$ evaluated at $\sin(\pi)$. In other words, it's $2\sin(\pi)$.

So the whole thing is $2 \sin(\pi) \cos(\pi)$! Since $\sin(\pi)$ is zero, this is actually just 0.

## Example

Let $f(x) = \sin(x^2)$. Then $f^\prime(x)$? How do we figure this out?

* First, remember that the derivative of $\sin(x)$ is $\cos(x)$.
* Then plug in $x^2$: $\cos(x^2)$
* Lastly, multiply by the derivative of $x^2$: $2x$

So our final answer: $(\sin(x^2))^\prime = 2x \cos(x^2)$

## Exercises

Find the derivatives of the following:

1. $f(x) = \sin(2x)$
3. $h(x) = (\cos(x))^2$

## Solutions

<details>
<summary>Check your answers:</summary>
<ol>
<li>$(\sin(2x))^\prime = 2\cos(2x)$</li>
<li>$(\cos(x))^2 = -2\sin(x)\cos(x)$</li>
</ol>
</details>

# Reminders

* DeltaMath due next Monday.
* Topic Statement due the following Monday.
* Thursday: asynchronous lesson + small groups. **Go through the material carefully!**