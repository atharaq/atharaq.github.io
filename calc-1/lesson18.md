# Calculus I Lesson 18: Riemann Sums and Definite Integrals
{:.no_toc}

1. Table of Contents
{:toc}

# Areas under curves

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/rW1nFs0wA7c" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

We are now ready to start discussing areas under curves. Let's warm up with a couple of simple examples.

**Example**: Suppose we are driving on the highway on cruise control at a constant speed of 55mph. If we drive for 2 hours, we have traveled a 110 miles: $55$ miles / hour $\times$ 2 hours = 110 miles.

In other words, we have this graph:

<div class="desmos-container">
    <iframe src="https://www.desmos.com/calculator/jzrphpas1v?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

So it's easy to find the distance traveled from our speed if the speed is constant: it's just the area of a rectangle. But what if our speed is not constant?

**Example**: A particle is initially stopped. At some time $t = 0$, the particle beings to move at a rate of $2t$ meters per second (that is, the particle speeds up over time). How far has it moved after 3 seconds?

So this is no longer a simple "distance = speed $\times$ time" question. But in this case, to find the distance, we still look at an area:

<div class="desmos-container">
    <iframe src="https://www.desmos.com/calculator/4s1tgcl6f4?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

This would be asking for the area of a triangle. The base of the triangle is 3, and the height is 6, and so the area is $\frac{1}{2} \cdot 3 \cdot 6 = 9$ meters. In general, after $t$ seconds, note that the distance traveled by the particle would be $\frac{1}{2} \cdot t \cdot 2t = t^2$.

So we see that questions about distance traveled over time can be turned into questions about areas under curve. And questions about areas under curves, sometimes, can be answered using geometric formulas. But what if we don't have a nice geometric formula for this?

**Example**: Determine the area under the curve $y = x^2$ from $x = 0$ to $x = 1$.

<div class="desmos-container">
    <iframe src="https://www.desmos.com/calculator/kjsebgnex2?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

How might we find the area of this region? Since the "top" side is no longer a straight line, this is not a question of geometry anymore. We need *calculus* tools to answer this. Our strategy will be to get better and better approximations, and come up with a limit of these approximations. That limit should be the **actual** area under the curve.

So how might we approximate the area? Our method is going to be to use rectangles. First, split up the interval that we want to look at into equally spaced points and draw rectangles, as below:

<div class="desmos-container">
<iframe src="https://www.desmos.com/calculator/qfhjhfjcko?embed" style="border: 1px solid #ccc" frameborder=0></iframe>
</div>

This is called the **left-endpoint approximation**. We split the interval from 0 to 1 into the four intervals: $[0, 0.25]$, $[0.25, 0.5]$, $[0.5, 0.75]$ and $[0.75, 1]$. For each one of these intervals, we looked at the rectangle we get whose height was based on the left endpoint of that interval: that is, we looked at the y-values $f(0)$, $f(0.25)$, $f(0.5)$ and $f(0.75)$. We end up with the following areas:

* From 0 to 0.25: $0 \times .25 = 0$
* From 0.25 to 0.5: $1/16 \times 1/4 = 1/64$.
* From 0.5 to 0.75: $1/4 \times 1/4 = 1/16$.
* From 0.75 to 1: $9/16 \times 1/4 = 9/64$.

Adding these up, we end up with an area of about .219.

## Sigma Notation

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/hWOZKaBxCOw" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Before we continue with the strategy of getting better and better approximations, we should review "$\Sigma$ notation".

$$ \sum_{i=0}^5 (i)$$

means the sum of the terms $0 + 1 + 2 + 3 + 4 + 5$. The $i$ is called the index variable, 0 is the lower bound, and $5$ is the upper bound. We will be using this to express long sums (or sums in terms of a variable $n$ that is not known).

## Left and Right endpoint approximations

Before we found an approximation of the area under $y = x^2$ using 4 rectangles. As we use more and more rectangles, our approximation will get better and better. To approximate this area using $n$ rectangles, we divide the interval $[0, 1]$ into points $x_0 = 0, x_1, x_2, \ldots, x_n = 1$, equally spaced apart. Since the length of the interval is 1, and we want $n$ rectangles, we need the distance between two points to be $\frac{1}{n}$ in this case. Let's call that $\Delta x$.

So our approximation here would be $f(x_0)\Delta x + f(x_1)\Delta x + \ldots + f(x_{n-1})\Delta x$. Notice in our approximation for $n = 4$ above, we didn't look at the $f(1)$ to compute the area.

This can be written more succinctly as $\sum\limits_{i=0}^{n-1} f(x_i) \Delta x$.

## Riemann Sums

# Desmos Activity

For the rest of this lesson, please take a look at [this Desmos activity](https://student.desmos.com/join/t7jpxw). **You may need a calculator for this.** As usual, this will be used as your "check-in" grade for participation purposes. Please complete it by Monday's class!
