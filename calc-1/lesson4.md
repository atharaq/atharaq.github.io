# Calculus I Lesson 4: Squeeze Theorem and Continuity

Last time we discussed two ways of computing limits: direct substitution and algebraic manipulation. We ended by discussing an example which could not be studied using these methods: $\sin(\frac{1}{x})$. Let's continue this example.

# Limit of $\sin(\frac{1}{x})$

This section is meant to be read alongside [Example 2.7](https://openstax.org/books/calculus-volume-1/pages/2-2-the-limit-of-a-function#fs-id1170572342287) from the textbook. The problem is to compute ${\displaystyle \lim_{x\rightarrow 0}} \sin(\frac{1}{x})$. To see what happens as $x \rightarrow 0$, the textbook computes values of $x$ that are getting smaller and smaller (closer to 0). The table shows that the $y$-values do not seem to converge to one, single real number as we make $x$ smaller and smaller.

The textbook then goes through another line of reasoning to show that we can pick specific points where we can calculate the $y$-values directly. Let's look at the unit circle:

![Unit circle, labeled in degrees, radians, and the (x,y) coordinates](https://upload.wikimedia.org/wikipedia/commons/4/4c/Unit_circle_angles_color.svg "Unit circle, labeled in degrees, radians, and the (x,y) coordinates")

There are many points labeled here, but let's only focus on the top and bottom points, located at $(0, 1)$ and $(0, -1)$. The top point can be reached by an angle of $\frac{\pi}{2}$ radians and the bottom by an angle of $\frac{3\pi}{2}$ radians. Recall that the points on the unit circle refer to values of $\cos$ and $\sin$. That is: the point at $(0, 1)$, reached by an angle of $\frac{\pi}{2}$, tells us that $\cos(\frac{\pi}{2}) = 0$, and $\sin(\frac{\pi}{2}) = 1$. In other words: the $x$-coordinate of a point on the unit circle is a value of $\cos$, and the $y$-coordinate of a point on the unit circle is a value of $\sin$.

Remember that $\sin$ is a **periodic** function: that means there are many angles we can use to reach the same point. The angle $\frac{5\pi}{2}$ will also reach $(0, 1)$, because it's $\frac{\pi}{2} + 2\pi$, that is, it's the angle we get to by going around the circle first by 90 degrees and then by 360 more degrees.

Similarly, $\frac{7\pi}{2}$ will also reach the bottom point at $(0, -1)$, while $\frac{9\pi}{2}$ will reach the top point at $(0, 1)$ again. This pattern continues: the values of $\sin(\frac{\pi}{2}), \sin(\frac{3\pi}{2}), \sin(\frac{5\pi}{2}), \sin(\frac{7\pi}{2})$, etc are just the pattern $1, -1, 1, -1, \ldots$

But wait: why does the textbook tell us to plug in $\frac{2}{\pi}$, $\frac{2}{3\pi}$, $\frac{2}{5\pi}$? Because we're not looking at the function $y = \sin(x)$! We're looking at the function $y = \sin(\frac{1}{x})$! That is, we need to find which values of $x$ give us $\frac{1}{x} = \frac{\pi}{2}$, or $\frac{1}{x} = \frac{7\pi}{2}$, etc. A little bit of algebra shows that we just need the reciprocals of all of these numbers.

Moreover, if we look at the pattern of numbers $\frac{2}{\pi}, \frac{2}{3\pi}, \frac{2}{5\pi}$, we see that those numbers get smaller and smaller. That is, those $x$-values approach $0$. But then, plugging in to $\sin(\frac{1}{x})$ gives us $y$-values which repeat the pattern $1, -1, 1, -1$. In other words, the graph of $y = \sin(\frac{1}{x})$ spikes up to positive 1, and down to negative 1, repeatedly, as $x \rightarrow 0$. In fact, it spikes up and down **infinitely often** as $x \rightarrow 0$!

# Limits of $e^{\frac{1}{x}}$

Let's go through a similar example from a different perspective. I want to study the graph of $e^\frac{1}{x}$ as $x \rightarrow 0$. Before we do so, we should really know how both the functions $f(x) = e^x$ and $g(x) = \frac{1}{x}$ behave.

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/snw7fiuq7h?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

Notice that as $x \rightarrow 0^-$, $g(x) \rightarrow -\infty$, and as $x \rightarrow 0^+$, $g(x) \rightarrow +\infty$. Now this tells us that ${\displaystyle \lim_{x \rightarrow 0}} g(x)$ does not exist, but it does not necessarily tell us what happens to $e^{\frac{1}{x}}$ as $x \rightarrow 0$. To understand what happens here:

* since, as $x \rightarrow 0^-$, $\frac{1}{x} \rightarrow -\infty$, we should check what happens to $e^x$ as $x \rightarrow -\infty$.
* since, as $x \rightarrow 0^+$, $\frac{1}{x} \rightarrow +\infty$, we should check what happens to $e^x$ as $x \rightarrow +\infty$.

So let's examine the graph of $f(x) = e^x$:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/7m3e7yk6cg?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

Now we see that as $x \rightarrow -\infty$, $e^x \rightarrow 0$. This tells us that ${\displaystyle \lim_{x\rightarrow 0^-}} e^{\frac{1}{x}} = 0$, since that exponent will approach $-\infty$, and as that happens, the function will approach $0$.

Similarly, we see that as $x \rightarrow +\infty$, $e^x \rightarrow +\infty$. This tells us that ${\displaystyle \lim_{x\rightarrow 0^+}} e^{\frac{1}{x}} = +\infty$, since that exponent approaches $+\infty$, and as that happens, the function approaches $+\infty$.

Putting these two results together, we get that ${\displaystyle \lim_{x\rightarrow 0}} e^{\frac{1}{x}}$ DNE, since approaching $0$ in different ways gives us different limits. Here is the graph of $e^{\frac{1}{x}}$:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/ftcoefe6kb?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

As you can see, as we approach 0 from the left, the graph approaches 0, while as we approach 0 from the right, the graph goes off to $\infty$.

**Exercise**: What do you think happens to $y = e^{\frac{1}{x^2}}$ as $x \rightarrow 0$?

# Squeeze Theorem

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/zbyqngowxg?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

This graph shows three functions: one plotted in as a solid curve, and two plotted as dotted lines. Notice that the solid curve is always in between the other two functions. Algebraically, this can be expressed by a compound inequality: if $f(x)$ is the solid curve and $g(x)$ and $h(x)$ are the dotted lines, then we write $g(x) \leq f(x) \leq h(x)$ for every $x$ (at least, near $x = 0$).

Moreover, notice that as $x \rightarrow 0$, the two dotted lines converge. That is: ${\displaystyle \lim_{x\rightarrow 0}} g(x) = {\displaystyle \lim_{x\rightarrow 0}} h(x)$. In this case, both dotted lines approach 0. That does not leave much room for $f(x)$! So what happens? This is the Squeeze Theorem, listed as Theorem 2.7 in [section 2.3 of the textbook](https://openstax.org/books/calculus-volume-1/pages/2-3-the-limit-laws): the graph of $f(x)$ gets "squeezed" toward $g(x)$ and $h(x)$, and so, as $x \rightarrow 0$ here, all three functions approach the same limit.

Let's go through an example of using the squeeze theorem. We saw, earlier, that as $x \rightarrow 0$, the function $f(x) = \sin(\frac{1}{x})$ does not approach any particular limit. What happens to the function $g(x) = x\sin(\frac{1}{x})$ as $x \rightarrow 0$? It would seem to be hopeless to find a limit, right?

In fact, we can use the Squeeze Theorem here. It turns out that the only thing that matters about $\sin(\frac{1}{x})$ in this function is that it never gets better than $+1$ or smaller than $-1$. That means that $x\sin(\frac{1}{x})$ is never larger than $\|x\|$, and is never smaller than $-\|x\|$ (the absolute values come into play if $x$ is negative, and $\sin(\frac{1}{x}) = -1$).

That is, we have the inequality: $-\|x\| \leq x\sin(\frac{1}{x}) \leq \|x\|$ for all $x$. Further, we know that the graphs of $y = -\|x\|$ and $y = \|x\|$ converge as $x \rightarrow 0$: that is, ${\displaystyle\lim_{x\rightarrow 0}} -\|x\| = {\displaystyle\lim_{x\rightarrow 0}} \|x\| = 0$. So by the Squeeze Theorem, ${\displaystyle\lim_{x\rightarrow 0}} \; x\sin(\frac{1}{x}) = 0$ also!

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/gqgxslsvlu?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

The Squeeze Theorem can be hard to apply, but it's worth knowing as it provides another tool to use to find limits if nothing else works. In the homework, you will be asked to find the limit of the following function as $x \rightarrow 0$:

$$f(x) = \begin{cases} 0 & \mbox{if } x \mbox{ is rational} \\
x^2 & \mbox{if } x \mbox{ is irrational}\end{cases}$$

As a hint: use the Squeeze Theorem. See if you can find two functions $g(x)$ and $h(x)$ with the property that $f(x)$ is never larger than $g(x)$, and $f(x)$ is never smaller than $h(x)$, and $g(x)$ and $h(x)$ approach the same value as $x \rightarrow 0$.

## Example

In this example, we will follow along [Figure 2.30 in the textbook](https://openstax.org/books/calculus-volume-1/pages/2-3-the-limit-laws#CNX_Calc_Figure_02_03_008) as we try to compute ${\displaystyle \lim_{\theta \rightarrow 0}} \frac{\sin{\theta}}{\theta}$. This limit will be important when we try to compute derivatives of trigonometric functions in the next couple of weeks.

First, let's try to understand what [Figure 2.30](https://openstax.org/books/calculus-volume-1/pages/2-3-the-limit-laws#CNX_Calc_Figure_02_03_008) shows. How did they recognize that the height of the smaller triangle is $\sin(\theta)$, the arc has length $\theta$, and the height of the larger triangle is $\tan(\theta)$?

Let's start with the second question: on the unit circle, the length of an arc is the same as the radian measure of the angle itself. This is actually why radian measure is useful! For example, if you have a circular track whose radius is one mile, and if you run exactly halfway around that track, you've run **exactly** $\pi$ miles!

Now, once we know that, we again appeal to what we know about the unit circle: when we go around the unit circle by an angle $\theta$, the $y$-value of the point we land on is equal to $\sin(\theta)$. This is the unit circle definition of the $\sin$ function. But what about that larger triangle? Where did $\tan(\theta)$ come from? This comes from using **similar triangles**: the larger triangle is similar to the smaller triangle, which means that its lengths are proportional. The base of the larger triangle has length $1$, since it's the unit circle. The base of the smaller triangle has length $\cos(\theta)$, for the same reason that the height was $\sin(\theta)$: that's the unit circle definition of $\cos$. Let $y$ be the height of the larger triangle, and we get a proportion: $\frac{y}{1} = \frac{\sin(\theta)}{\cos(\theta)}$, which just means $y = \tan(\theta)$.

Now let's think about what the figure tells us. We see that $\sin(\theta) \leq \tan(\theta)$: this is fairly clear from the picture. Moreover, the arc, $\theta$ is in between: that is, $\sin(\theta) \leq \theta \leq \tan(\theta)$. Dividing by $\theta$ on the left, we can see that $\frac{\sin(\theta)}{\theta} \leq 1$.

Now let's look at the inequality $\theta \leq \tan(\theta)$. We re-write $\tan(\theta)$ as $\frac{\sin(\theta)}{\cos(\theta)}$. We, again, are looking to get $\frac{\sin(\theta)}{\theta}$ on its own, so let's divide both sides by $\theta$ and multiply both sides by $\cos(\theta)$. Here we get: $\cos(\theta) \leq \frac{\sin(\theta)}{\theta}$. Combining these:

$$\cos(\theta) \leq \frac{\sin(\theta)}{\theta} \leq 1$$

This is all we need to use the Squeeze Theorem, since, as $\theta \rightarrow 0$, $\cos(\theta) \rightarrow 1$! That tells us that ${\displaystyle \lim_{\theta \rightarrow 0}} \frac{\sin(\theta)}{\theta} = 1$!

# Continuity

What does it mean for a function to be continuous at a point $x = a$? You may have heard the intuitive notion that "we can draw the graph of the function without picking up our pen." This brings up the idea that there are no sudden "jumps" at that point. In mathematics, though, we do not rely just on intuition: we use that intuition as motivation for definitions. So how can we make the definition of continuitiy more precise? If we want to be able to draw the graph without picking up our pen, that means that as we get close to the $x$-value $x = a$, the graph gets closer to the $y$-value $y = f(a)$. That is:

**Definition**: $f$ is **continuous** at $x = a$ if the following condditions hold:

1. $a$ is in the domain of $f$,
2. ${\displaystyle \lim_{x \rightarrow a}} f(x)$ exists, and
3. ${\displaystyle \lim_{x \rightarrow a}} f(x) = f(a)$

A function $f(x)$ is called **continuous** if, for each point $a$ in the domain of $f$, $f$ is continuous at $x = a$. Continuous functions behave better than just arbitrary functions: if we know a function is continuous, we know that, at every point in its domain, limits always exist, and they are always equal to the value of the function itself. That is: we can use "direct substitution" to compute limits!

All the usual examples of functions that we've worked with are continuous at each point in their domains: polynomials, rational functions (when their denominators are not 0), algebraic functions (when they are defined) trig functions, exponential functions, and logarithms are all continuous.

## Example

**Problem**: Determine if the following function is continuous at the points $x = -1, 0, 1$:

$$f(x) = \begin{cases}2-x & \mbox{if } x \leq 0 \\
x^2 & \mbox{if } x > 0 \end{cases}$$

Try to solve this on your own before reading on. First let's look at $x = -1$. First, $-1$ is in the domain of $f$: $f(-1) = 3$, since $-1 < 0$. Next, let's check if the one-sided limits exist. As $x \rightarrow -1^-$, $f(x) = 2 - x$, and so $f(x) \rightarrow 3$. SImilarly, as $x \rightarrow -1^+$, we still only need to look at the part of $f(x)$ where $f(x) = 2 - x$. Why is this? Think about what the values of $x$ are as we let $x$ approach $-1$ from the right: eventually, we must start looking at numbers less than $0$. So in this case, $f(x) \rightarrow 3$ also. Since the two one-sided limits exist and are both equal to $f(-1)$, we see that $f(x)$ **is continuous** at $x = -1$.

Now let's look at $x = 0$. $0$ is in the domain of $f$ again, as $f(0) = 2$. As $x \rightarrow 0^-1$, we check the part of $f(x)$ defined on $x \leq 0$: so $f(x) = 2 - x \rightarrow 2$. As $x \rightarrow 0^+$, we use $f(x) = x^2$, so $f(x) \rightarrow 0$. Since the one-sided limits are not equal, the limit does not exist, and so $f(x)$ is **not continuous** at $x = 0$.

Lastly, let's look at $x = 1$. Again $1$ is in the domain of $f(x)$, and $f(1) = 1^2$, which is $1$. As $x \rightarrow 1^-$, which function should we use? We use $f(x) = x^2$ in this case, since, as we let $x$ get close to $1$ from the left, eventually $x$ will be larger than 0. So $f(x) \rightarrow 1$ as $x \rightarrow 1^-$. Similarly, as $x \rightarrow 1^+$, we will get $f(x) \rightarrow 1$. So both One-sided limits exist and are equal to $f(1)$, and so $f(x)$ **is continuous** at $x = 1$.

**Exercise**: Determine if the following functions are continuous at the given points:

1. $$f(x) = \begin{cases} x^2 & \mbox{if } -1 \leq x < 1 \\
1 & \mbox{if } x \geq 1 \end{cases}$$ at $x = 0, 1$
2. $$g(x) = \begin{cases} |x| & \mbox{if } -1 \leq x < 0
\\ \cos(x) & \mbox{if} x \geq 0\end{cases}$$ at $x = 0, 1$

<details>
<summary>Check your answers</summary>
<ol>
<li>Continuous at $x = 0$ and at $x = 1$.</li>
<li>Not continuous at $x = 0$: ${\displaystyle\lim_{x\rightarrow 0^-}}g(x) = 0$, but ${\displaystyle\lim_{x\rightarrow 0^+}}g(x) = 1$. Continuous at $x = 1$ since $\cos(x)$ is continuous.</li>
</ol>
</details>

## Definition Quirk

Is the function $f(x) = \frac{1}{x}$ continuous? Let's look at its graph again:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/snw7fiuq7h?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

Clearly, it looks like there is a jump at $x = 0$. So it's not continuous, right?

Let's stop for a second and remember what our definition was. $f(x)$ is continous at $x = a$ if $a$ is in the domain of $f$, and the limit as we approach $a$ exists and is equal to $f(a)$. This is the definition of "continuity at a point". What was the definition of "continuous function"? A function is called a continuous function if it is continuous *at every point in its domain*.

$0$ is not in the domain of $f(x)$. So it's certainly not continuous at that point: but $f(x)$ *is* continuous at every point that is in its domain! In other words: at all the points that we can actually talk about, $f(x)$ is continuous. So $f(x)$ is called a continuous function.

Now this is of course strange: shouldn't we "fix" this definition? We can try to, but there are issues with any other definition we could come up with. This is quite a subtle issue. For example: perhaps we want to say, then, that a function is continuous if it is continuous at every real number. But then what do we make of the function $g(x) = \sqrt{1 - x^2}$?

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/62ibcc1faz?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

This function is continuous at every point from $x = -1$ to $x = 1$, and is not defined anywhere else. Should we exclude that from being continuous?

Over the years, mathematicians have settled on this definition as a result of studying, carefully, what makes functions like $\frac{1}{x}$ different from functions like $\sqrt{1 - x^2}$. It turns out that both have the same "continuity" properties everywhere they are defined: if you want to zoom in on one, individual point, you could that *part* of the graph without picking up your pen. The issue is with the **domains**: we rarely think about the domains of the function, but it turns out that to say "you can draw the graph of $f(x)$ without picking up your pen", you are **not** just talking about continuity. You are also saying that your domain is connected (it doesn't have a hole in it): a property that has nothing to do with functions.

This is a subtle point, and I don't necessarily expect you to think deeply about all of this, but just note that continuity of a function does **not** actually mean that you can draw the graph of the function without picking up your pen. It just means the definition we gave: that at each point in the domain, limits exist and are equal to the value of the function.

# Intermediate Value Theorem

Before we state the most important result about continuous functions, let's first mention a couple pieces of notation. Recall **interval notation**: the open interval $(a, b)$ refers to the set of all $x$ values such that $a < x < b$. The closed interval $[a, b]$ refers to all $x$ such that $a \leq x \leq b$. For a function $f(x)$, if we say $f$ is continuous on $(a, b)$, it means that $f$ is defined on the interval $(a, b)$, not necessarily at the endpoints, and that $f$ is continuous at each point inside. If we say $f$ is continuous on a closed interval $[a, b]$, that means the following:

* $f$ is continuous on $(a, b)$
* $a$ and $b$ are in the domain of $f$
* ${\displaystyle \lim_{x \rightarrow a^+}}f(x) = f(a)$, and
* ${\displaystyle \lim_{x \rightarrow b^-}}f(x) = f(b)$

For example, the function $f(x) = \frac{1}{x}$ is continuous on $(0, 1)$, but not on $[0, 1]$ since $f(0)$ does not exist. On the other hand, the function $g(x) = \sqrt{1 - x^2}$ is continuous on $[-1, 1]$.

Now let's get to the **Intermediate Value Theorem**. This theorem says that if $f(x)$ is continuous on a closed interval $[a, b]$, and $y$ is **any** $y$-value between $f(a)$ and $f(b)$, then there is some $x$-value, let's call it $c$, in between $a$ and $b$ such that $f(c) = y$. The graph below shows an animation of this phenomenon:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/smkkcei4ac?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

Most often, we use the Intermediate Value Theorem to show that a function must have a root, even if we don't know how to calculate it explicitly. For example: does the equation $\cos(x) = x$ have a solution?

Let's look at the function $g(x) = \cos(x) - x$. Does this function ever equal 0? We can plug in a couple of values of $x$ and see what happens. $g(0) = 1 - 0 = 1$, which is positive. $g(\pi) = -1 - \pi$, which is negative. So, by the IVT, there **must** be some $x$ between $0$ and $\pi$ such that $g(x) = 0$!
