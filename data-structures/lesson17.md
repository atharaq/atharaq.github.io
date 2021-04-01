# Data Structures Lesson 17: NP Completeness
{:.no_toc}

1. Table of Contents
{:toc}

# DFS

Last time, we looked at the depth-first search (DFS) algorithm. [Take another look](https://atharaq.github.io/data-structures/lesson16.html#/dfs) and follow along as we run the DFS algorithm on the directed graph of course prerequisites saw earlier.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/RidlkGzIF7I" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Graph Theory Problems

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/WZfQuOe-CTY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Continuing along the slides from last time, look at [these slides on graph theory problems](https://atharaq.github.io/data-structures/lesson16.html#/scheduling-problem). In these slides, I introduce the following problems:

* Scheduling Problem (project 3): Given a list of courses, each of which contains a list of students, assign time slots to each course in such a way that courses which share students do not get scheduled at the same time.
* Coloring Problem: Given a graph, assign colors to the vertices in such a way that vertices which share edges are not assigned the same color.
* Eulerian Path / Circuit Problem: Given a graph, walk around the graph making sure to visit each edge exactly once. (If you end up exactly where you started, it's a "circuit", otherwise, it's a "path")
* Hamiltonian Path / Circuit: Given a graph, walk around the graph making sure to visit each *vertex* exactly once.
* Traveling Salesman Problem: Given a weighted *complete* graph (so there are edges between each pair of vertices), find a Hamiltonian cycle with the lowest total cost (sum of the weights of all the edges visited along the path).

# P and NP

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/BxuRRtCs5Bo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

The last section of the slides from last time talked about the [P and NP](https://atharaq.github.io/data-structures/lesson16.html#/p-vs-np) problem. This is one of the most famous unsolved problem in mathematics and computer science.

# Sorting Algorithms

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/ttgiIhn3BSc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Next week, we will start exploring sorting algorithms. The **sorting problem** asks, given an array of integers, to re-arrange the elements of the array so that they are in increasing order.

In the video, I described three sorting algorithms:

* Bubble sort: repeatedly compare consecutive elements, moving bigger elements to the right as we go along. As we continue to do this, the larger elements "bubble" up to the end of the list.
* Selection sort: for each $i$, repeatedly search for the smallest element in the list in between positions $i$ and $n - 1$, and swap it with the element at position $i$.
* Insertion sort: keep the beginning of the list (first $i$ elements) sorted, and then figure out where the element $a_{i+1}$ goes.
