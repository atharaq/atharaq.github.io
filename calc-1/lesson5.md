<!-- 9/21 -->

# Calculus I Lesson 5: Intro to Derivatives

# Quiz

# IVT Exercise

Last time we learned the Intermediate Value Theorem. Let's use this theorem to estimate $\log_2(10)$. Remember: $\log_2(10) = x$ means $2^x = 10$. So we are looking for an $x$-value such that $2^x = 10$. Let's compute some powers of 2:

* If $x = 3$, $2^3 = 2 \times 2 \times 2 = 8$.
* If $x = 4$, $2^4 = 16$.

By the Intermediate Value Theorem, there is some $c$ between 3 and 4 such that $2^c = 10$. So it's not exactly clear yet, but maybe we can do a little better?

What is $2^{3.5}?$ How do we evaluate decimals in exponents? We write it as a fraction: $3.5 = \frac{7}{2}$, and use the rules for fractions in exponents: $2^{\frac{7}{2}} = \sqrt{2^7}$. $2^7$ is 128, so this is $\sqrt{128}$, which is bigger than 10. So now we know that, by the Intermediate Value Theorem, again, the $c$ that we're looking for is between 3 and 3.5. We could keep going, and check $2^{3.25}$ and figure out if either $3 < c < 3.25$ or $3.25 < c < 3.5$, and continue to look for a better and better approximation of $\log_2(10)$.

# Derivatives Intro

Recall that one of the primary themes of calculus is the notion of change. In particular: the question of "How fast is a graph of a function changing at a particular point?" This is the meaning of the work **derivative**.

The derivative of a function $f(x)$ at a point $x = a$ is the slope of the line tangent to the graph of $f(x)$ at $x = a$. It represents the answer to the question above: how fast is this function changing at $x = a$? We can also rephrase this: how *sensitive* are the $y$-values to small changes in $x$-values near $x = a$?

## Physics Example

The classic example of derivatives showing up in physical applications involves graphing the position an object travels over time. Let's say we get in our car and turn on the car. At first, when we start the car, we have not moved yet. We press down on the pedal, start picking up speed, and, as we near our destination, we start to slow down and come to a stop. This could be modeled by the following graph:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/ntd7qavq4g?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

The tangent lines at any given point on this graph would refer to the velocity of the car.

## Economics Example

It's important to understand that the concept of a derivative occurs in many contexts, not just physical ones. The notion of a derivative will show up any time we can model a relationship between two quantities as a function: we might want to know how sensitive the dependent variable is to small changes in the independent variable. The following video from Khan Academy discusses this phenomenon in the context of economics.

Suppose we are manufacturing some product, and we model the cost $c$ as a function of the quantity $x$ of the product that we produce. That is, there is some function $c(x)$ that represents the total cost it takes to produce $x$ amount of our product. The derivative here represents the *marginal cost*: the amount of money it would cost to produce just a little bit more. The video does a good job explaining why we might care about the marginal cost, or marginal profit, or marginal revenue.

<div class="desmos-container">
<iframe src="https://www.youtube.com/embed/Wkjz1LlX1CQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## Secant Lines $\rightarrow$ Tanagent Lines

So how do we actually compute the slope of a tangent line at a point $x = a$ on the graph of a function $y = f(x)$? We approximate it using secant lines, and take the limit!

Recall that the secant line on a graph is a line between two points on a graph. Let's say that the points are at $x = a$ and $x = b$. As ordered pairs, the point at $x = a$ is plotted at $(a, f(a))$ and the point at $x = b$ is plotted at $(b, f(b))$. The slope of the line between these points is given by the average rate of change formula:

$$\frac{\Delta y}{\Delta x} = \frac{f(b)-f(a)}{b-a}$$

As $b \rightarrow a$, the secant line approaches the line tangent to graph at $x = a$. That's what happens in this graph:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/pvbubabvbu?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

With our knowledge of limits, we can define the derivative as a limit. The derivative of $f(x)$ at $x = a$ is denoted $f^\prime(a)$. The definition is given by this limit:

$$f^\prime(x) = \lim_{x\rightarrow a} \frac{f(x)-f(a)}{x-a}$$

## Exercise

Find the derivative of $f(x) = x^2$ at the point $x = 3$. That is, find $f^\prime(3)$. The definition above means we need to compute

$$\lim_{x\rightarrow 3} \frac{x^2 - 9}{x-3}$$

As a hint, you need to use algebraic manipulation for this limit.

<details>
<summary>Check your answer</summary>

<p>First let us use algebra to find a function that is equivalent to $\frac{x^2-9}{x-3}$, except at $x = 3$, and is continuous at $x = 3$.</p>

$$\frac{x^2-9}{x-3} = \frac{(x+3)(x-3)}{x-3} = x+3$$

<p>So, as $x \rightarrow 3$, this limit exists and is equal to $3$</p>
</details>

## Another derivative formula

Another way to think about secant lines is, instead of thinking about two points, think about one point and a distance.

That is, let's say we want to find a good approximation of the tangent line at a point $x = a$. We look at the point at $(a, f(a))$. Then, instead of picking another $x$-value $b$, we pick a small *increment*, let's call it $h$. Now let's look at the point where $x = a + h$. That is, we draw the secant line from $(a, f(a))$, to $(a+h, f(a+h))$. This is what is happening in the graph below:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/m6omcjykuo?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

The slope of the secant line is $\frac{f(a+h)-f(a)}{(a+h)-a} = \frac{f(a+h)-f(a)}{h}$. As $h \rightarrow 0$, the secant line again approaches a tangent line. So again, we can come up with the formula for the derivative:

$$f^\prime(x) = \lim_{h \rightarrow 0} \frac{f(x+h)-f(x)}{h}$$

Let's use this to determine the value of the derivative of the function $f(x) = x^2$, at *any* given point $x$. First let's compute $\frac{f(x+h)-f(x)}{h}$. Since $(x+h)^2$ is $(x+h)(x+h) = x^2 + 2xh + h^2$, we get:

$$\begin{align*}
\frac{f(x+h)-f(x)}{h} &= \frac{x^2 + 2xh + h^2 - x^2}{h} 
\\ &= \frac{2xh+h^2}{h}
\end{align*}$$

For all $h \neq 0$, we can use some algebra to simplify this fraction. We get $\dfrac{2xh+h^2}{h} = \dfrac{h(2x+h)}{h}$, which is $2x + h$. So, as $h \rightarrow 0$, the limit is $2x$.

That is, the derivative of $f(x) = x^2$ is $f^\prime(x) = 2x$.

Take a look at this example, from the YouTube Channel PatrickJMT. This shows a more complicated example of using algebra to compute a complicated limit.

<div class="desmos-container">
<iframe src="https://www.youtube.com/embed/vzDYOHETFlo" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Derivative of a Line

Recall that the graph of a function of the form $f(x) = mx + b$, where $m$ and $b$ are some fixed constants, is a straight line. THe line has slope $m$ and $y$-intercept $b$. What would the derivative of a line be?

Note that between any two points on a line, the "average rate of change" between them is just the slope. That is, rates of change on a line are always equal to $m$! So intuitively, as the two points get closer together, the average rate of change is still $m$, so the derivative should be $m$ as well. This is true! Let's prove it.

Suppose $f(x) = mx + b$. We can use either definition of the derivative to show that, at any point $x = a$, the derivative $f^\prime(a) = m$. Let's use the first definition. We need to compute ${\displaystyle\lim_{x\rightarrow a}}\frac{f(x)-f(a)}{x - a}$. Notice that $f(x) - f(a)$ is $(mx + b) - (ma + b)$. This is just $mx - ma$, or $m(x - a)$. So:

$$\lim_{x\rightarrow a} \frac{f(x)-f(a)}{x-a} = \lim_{x\rightarrow a} \frac{m(x-a)}{x - a} = m$$

So $f^\prime(a) = m$, at every point on the graph. **The derivative of a line is the slope of that line!**

## Derivative of a Constant Function

Similarly, we can use the definition of the derivative to find the derivative of a constant function. If $f(x) = k$ is a constant, then $f(x+h) = k$ also. So $\dfrac{f(x+h)-f(x)}{h} = \dfrac{k - k}{h} = \dfrac{0}{h}$. That means that $f^\prime(x) = 0$. This argument is covered in the following KhanAcademy video:

<div class="desmos-container">
<iframe src="https://www.youtube.com/embed/OsPNBYmqxLo" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Exercise

Find the derivative of $f(x) = \|x\|$ at $x = 0$. Hint: the absolute value function can be defined as a piecewise function:

$$f(x)=\begin{cases}-x &\mbox{if } x < 0
\\ x &\mbox{if } x \geq 0 \end{cases}$$

Since this is a piecewise function, you will need to look at the right hand and left hand limits of $\frac{f(x)-f(0)}{x-0}$.

<details>
  <summary>Solution:</summary>
  
<p>$f^\prime(0)$ <strong>does not exist</strong>! Remember that limits do not always exist. Let's compute the following limits: ${\displaystyle\lim_{x\rightarrow 0^-} \frac{f(x) - f(0)}{x - 0}$ and ${\displaystyle\lim_{x\rightarrow 0^+} \frac{f(x) - f(0)}{x - 0}$.</p>
  
<p>As $x \rightarrow 0^-$, $f(x) = -x$. So we are looking at the limit of $\frac{-x}{x}$, which is $-1$.</p>
<p>As $x \rightarrow 0^+$, $f(x) = x$. So we are looking at the limit of $\frac{x}{x}$, which is 1.</p>
<p>Since the two one-sided limits are different, the (two-sided) limit does not exist (DNE)!</p>
</details>

## Differentiability

We've seen that not every function has a derivative at every point. Given a function $f(x)$, we say $f(x)$ is **differentiable** at $x = a$ if the derivative $f^\prime(a)$ exists. That is, if ${\displaystyle\lim_{x\rightarrow a}}\frac{f(x)-f(a)}{x-a}$ exists. Alternatively, we could have used the other definition of a derivative &mdash; they are equivalent definitions.

$f(x)$ is called a **differentiable function** if it is differentiable at every point at which it is defined. That is, if it is differentiable at each point in its domain.

# Constant Multiple and Sum Rules

As we've seen, the definition of the derivative is somewhat cumbersome to use. Instead of using this definition forever, we will first try to prove some rules about the derivative. We would then be able to use what we've already computed, plus these rules, to figure out other examples.

You can watch the following Khan Academy video, where he goes through the two rules we will study today: the constant multiple rule and the sum rule.

<div class="desmos-container">
<iframe src="https://www.youtube.com/embed/uCLZyTliZj0" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Let's work a bit *abstractly*. That is, we will use properties of functions, rather than concrete examples of functions.

Our first rule will be the **constant multiple rule**. Let's say that we have a function $f(x)$ that we know has a derivative at $x = a$. Let's say that $f^\prime(a) = c$. If $g(x)$ is equal to some constant multiple of $f(x)$, say $g(x) = k f(x)$, then we want a rule that will tell us $g^\prime(a)$ in terms of $f^\prime(a)$. Let's compute $g^\prime(a)$:

$$\begin{align}
\lim_{x\rightarrow a} \frac{g(x)-g(a)}{x-a} &= \lim_{x\rightarrow a} \frac{kf(x) - kf(a)}{x - a} \\
&= \lim_{x\rightarrow a} k \frac{f(x) - f(a)}{x - a} \\
&= k \lim_{x \rightarrow a} \frac{f(x) - f(a)}{x - a} \\
&= k f^\prime(a)
\end{align}$$

This means that $g^\prime(a)$ exists, and is equal to $k$ times $f^\prime(a)$. This is the **constant multiple rule**: if $f(x)$ is differentiable, then for any constant $k$, $kf(x)$ is differentiable, and $(kf(x))^\prime = kf^\prime(x)$.

For example, we have seen that if $f(x) = x^2$, then for each $x$ value, the derivative exists, and $f^\prime(x) = 2x$. What should that mean for a function like $g(x) = 3x^2$? In this case, $g(x) = 3f(x)$, so by the constant multiple rule, $g^\prime(x) = 3f^\prime(x)$. So that means $g^\prime(x) = 3 \times 2x = 6x$.

## Exercise

Determine the derivative of $f(x) = 5x^2$.

<details>
  <summary>Check your answer</summary>
  <p>Since the derivative of $x^2$ is $2x$, the derivative of $5x^2$ is $5 \times 2x$, which is $10x$.</p>
</details>

## Sum Rule

Now let's suppose that $f(x)$ and $g(x)$ are two functions that are both differentiable at $x = a$. What would the derivative of the function $h(x) = f(x) + g(x)$ be at $x = a$?

## Exercises

# Homework Due Friday, 9/25
