# Data Structures Lesson 11: Hashtables Wrap-up
{:.no_toc}

1. Table of Contents
{:toc}

# Breadth First Search

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/Q5f9rBsemVE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

In the above video, I talk through a "depth-first search" alternative to BFS, and why it might not give the "shortest" path in our applications problems. In particular, if we did a depth first search in the "shortest path in the city" problem, we might end up traversing the entirety of the city in a kind of spiral before finding the actual endpoint. We'd get a valid path, but certainly not the shortest one.

## Exercise: Implement BFS

As an exercise, try to implement the breadth first search algorithm for the "Shortest Path in the City" application on CodingRooms. I put some starter code in there so you don't have to worry about finding the "next" locations that one can travel to (the "child" nodes, so to speak), and I declared the queue / map / set variables that we will need for this.

# Perfect Hashing

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/SEybYflC8W8" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Revisiting the mathematics of hashtables, in this video I prove that if we insert $N$ objects into a table of size $N^2$, the probability of a collision is less than $\frac{1}{2}$. We can use this to create a **perfect hashing** scheme (a hashing scheme with worst case $O(1)$ access):

* Create a table of size $N$.
* Whenever there are collisions, instead of using a linked list to "chain", we use a secondary hashtable.
* If there are $m$ objects that hash to the same entry in the primary hashtable, we make our secondary hashtable have size $m^2$.
* Then using the theorem, we are likely to find a hash function for which there are no collisions in this secondary table! If the first hash function we try still has collisions in this table, we try another random hash function.

Then to find any object in the hashtable, it would take at most two steps.

# Coding Question

Suppose we have a list of synonymous words (each just a pair of Strings), and a list of pairs of search queries. Describe an algorithm which determines, for each pair of queries, if the queries are "synonymous". For example, if our synonyms list contains:

* hello, hi
* world, earth

Then the queries "hello world" and "hi earth" are synonymous. The queries "world hello" and "hi earth" are **not** synonymous (order matters).

Your algorithm should return a list of booleans (true / false), which correspond to whether the given pair of queries is "synonymous".

Think about the running time of your algorithm. For the sake of simplicity, assume you have 1 pair of queries, with $N$ words in each query, but your synonym list has $M$ pairs of words.

Come up with pseudocode for this problem. Be prepared to discuss this pseudocode in small groups on Monday.

# Operating System Job Queue

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/VfiHD_Qwi9A" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Operating systems need to solve a **scheduling problem**:

* Some number of processes come in at various times.
* Each process runs for a certain length.
* Only one process can run at a time.

Suppose we are running one process and it ends. We have some list of processes that have been waiting. How do we decide which process to run next?

In this video, I argue that we should choose the *shortest* job on that list, not necessarily the one which has been waiting the longest (so not FIFO)! How do we do this? We need a different data structure: not a stack / queue, but a structure which, when we call `remove()`, would give us the *smallest* object in the queue. (Hopefully in a quick amount of time.)

We will examine one such data structure next week.
