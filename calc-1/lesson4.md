# Calculus I Lesson 4

Last time we discussed two ways of computing limits: direct substitution and algebraic manipulation. We ended by discussing an example which could not be studied using these methods: $\sin(\frac{1}{x})$. Let's continue this example.

# Limit of $\sin(\frac{1}{x})$ (15)

This section is meant to be read alongside [Example 2.7](https://openstax.org/books/calculus-volume-1/pages/2-2-the-limit-of-a-function#fs-id1170572342287) from the textbook. The problem is to compute ${\displaystyle \lim_{x\rightarrow 0}} \sin(\frac{1}{x})$. To see what happens as $x \rightarrow 0$, the textbook computes values of $x$ that are getting smaller and smaller (closer to 0). The table shows that the $y$-values do not seem to converge to one, single real number as we make $x$ smaller and smaller.

The textbook then goes through another line of reasoning to show that we can pick specific points where we can calculate the $y$-values directly. Let's look at the unit circle:

![Unit circle, labeled in degrees, radians, and the (x,y) coordinates](https://upload.wikimedia.org/wikipedia/commons/4/4c/Unit_circle_angles_color.svg "Unit circle, labeled in degrees, radians, and the (x,y) coordinates")

There are many points labeled here, but let's only focus on the top and bottom points, located at $(0, 1)$ and $(0, -1)$. The top point can be reached by an angle of $\frac{\pi}{2}$ radians and the bottom by an angle of $\frac{3\pi}{2}$ radians. Recall that the points on the unit circle refer to values of $\cos$ and $\sin$. That is: the point at $(0, 1)$, reached by an angle of $\frac{\pi}{2}$, tells us that $\cos(\frac{\pi}{2}) = 0$, and $\sin(\frac{\pi}{2}) = 1$. In other words: the $x$-coordinate of a point on the unit circle is a value of $\cos$, and the $y$-coordinate of a point on the unit circle is a value of $\sin$.

Remember that $\sin$ is a **periodic** function: that means there are many angles we can use to reach the same point. The angle $\frac{5\pi}{2}$ will also reach $(0, 1)$, because it's $\frac{\pi}{2} + 2\pi$, that is, it's the angle we get to by going around the circle first by 90 degrees and then by 360 more degrees.

Similarly, $\frac{7\pi}{2}$ will also reach the bottom point at $(0, -1)$, while $\frac{9\pi}{2}$ will reach the top point at $(0, 1)$ again. This pattern continues: the values of $\sin(\frac{\pi}{2}), \sin(\frac{3\pi}{2}), \sin(\frac{5\pi}{2}), \sin(\frac{7\pi}{2})$, etc are just the pattern $1, -1, 1, -1, \ldots$

But wait: why does the textbook tell us to plug in $\frac{2}{\pi}$, $\frac{2}{3\pi}$, $\frac{2}{5\pi}$? Because we're not looking at the function $y = \sin(x)$! We're looking at the function $y = \sin(\frac{1}{x})$! That is, we need to find which values of $x$ give us $\frac{1}{x} = \frac{\pi}{2}$, or $\frac{1}{x} = \frac{7\pi}{2}$, etc. A little bit of algebra shows that we just need the reciprocals of all of these numbers.

Moreover, if we look at the pattern of numbers $\frac{2}{\pi}, \frac{2}{3\pi}, \frac{2}{5\pi}$, we see that those numbers get smaller and smaller. That is, those $x$-values approach $0$. But then, plugging in to $\sin(\frac{1}{x})$ gives us $y$-values which repeat the pattern $1, -1, 1, -1$. In other words, the graph of $y = \sin(\frac{1}{x})$ spikes up to positive 1, and down to negative 1, repeatedly, as $x \rightarrow 0$. In fact, it spikes up and down **infinitely often** as $x \rightarrow 0$!

# Limits of $e^{\frac{1}{x}}$ (10)

Let's go through a similar example from a different perspective. I want to study the graph of $e^\frac{1}{x}$ as $x \rightarrow 0$. Before we do so, we should really know how both the functions $f(x) = e^x$ and $g(x) = \frac{1}{x}$ behave.

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/snw7fiuq7h?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

Notice that as $x \rightarrow 0^-$, $g(x) \rightarrow -\infty$, and as $x \rightarrow 0^+$, $g(x) \rightarrow +\infty$. Now this tells us that ${\displaystyle \lim_{x \rightarrow 0}} g(x)$ does not exist, but it does not necessarily tell us what happens to $e^{\frac{1}{x}}$ as $x \rightarrow 0$. To understand what happens here:

* since, as $x \rightarrow 0^-$, $\frac{1}{x} \rightarrow -\infty$, we should check what happens to $e^x$ as $x \rightarrow -\infty$.
* since, as $x \rightarrow 0^+$, $\frac{1}{x} \rightarrow +\infty$< we should check what happens to $e^x$ as $x \rightarrow +\infty$.

So let's examine the graph of $f(x) = e^x$:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/7m3e7yk6cg?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

Now we see that as $x \rightarrow -\infty$, $e^x \rightarrow 0$. This tells us that ${\displaystyle \lim_{x\rightarrow 0^-}} e^{\frac{1}{x}} = 0$, since that exponent will approach $-\infty$, and as that happens, the function will approach $0$.

Similarly, we see that as $x \rightarrow +\infty$, $e^x \rightarrow +\infty$. This tells us that ${\displaystyle \lim_{x\rightarrow 0^+}} e^{\frac{1}{x}} = +\infty$, since that exponent approaches $+\infty$, and as that happens, the function approaches $+\infty$.

Putting these two results together, we get that ${\displaystyle \lim_{x\rightarrow 0}} e^{\frac{1}{x}}$ DNE, since approaching $0$ in different ways gives us different limits. Here is the graph of $e^{\frac{1}{x}}$:

<div class="desmos-container"><iframe src="https://www.desmos.com/calculator/ftcoefe6kb?embed" style="border: 1px solid #ccc" frameborder=0></iframe></div>

As you can see, as we approach 0 from the left, the graph approaches 0, while as we approach 0 from the right, the graph goes off to $\infty$.

**Exercise**: What do you think happens to $y = e^{\frac{1}{x^2}}$ as $x \rightarrow 0$?

# Squeeze Theorem (25)

# Continuity (15)

# Intermediate Value Theorem (10)
