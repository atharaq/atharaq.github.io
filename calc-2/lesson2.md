# Calculus II Lesson 2: Exponential and Logarithmic Functions
{: .no_toc}

1. Table of Contents
{:toc}

# Review

## Meaning of the definite integral

Take a look at the following chart that depicts the number of positive cases of COVID-19 per day (source: [Covid Tracking Project](https://covidtracking.com/)).

![Coronavirus cases per day](cases.png)

This "7-day average" curve is used to adjust for trends in testing frequency, but for our purposes we might as well treat the curve as representing the actual number of cases on that particular day. What does the area under this curve represent? In other words: what do you get if you add up all the number of cases on any given day?

In general, there is a relationship between a function and the area under the graph of that function. This relationship is given by the Fundamental Theorem of Calculus: if $f(x)$ is a function, then $F(x) = \int_a^x f(t) dt$ is an *antiderivative* of $f(x)$. In other words, $F^\prime(x) = f(x)$. Since $F(x)$ represents the area under the curve of $f(x)$, this says that the area under $f(x)$ changes at a rate equal to $f(x)$ itself. What does this mean in terms of the graph above?
