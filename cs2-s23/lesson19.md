# CS2 Lesson 19: Recursion (Again)
{:.no_toc}

1. Table of Contents
{:toc}

# Towers of Hanoi

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/nDApcFBgSgQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**Towers of Hanoi** is a game played with 3 pegs and $n$ disks (for some integer $n > 0$). The rules are:

* The goal is to move all the disks from one peg to another.
* No bigger disk can be placed on top of a smaller disk.

<img src="https://upload.wikimedia.org/wikipedia/commons/0/07/Tower_of_Hanoi.jpeg" alt="Towers of Hanoi game (Wikimedia Commons)" />

[Click this link to play the game](https://www.mathsisfun.com/games/towerofhanoi.html). Play the game with 3 disks. See if you can win in the minimum number of moves. Then play again with 4 disks. See if you can figure out the pattern and find a solution for the puzzle.

1. Come up with a recursive algorithm to solve this game.
2. How did they figure out the minimum number of moves needed? Does your algorithm end up giving that minimum?

## Algorithm

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/X3bM-0Le2jE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Hopefully you got a chance to play around with that and you were able to figure out the algorithm. The real issue is that we need to move all the top $n - 1$ disks before we can move that last one. So how do we figure out how to do that? Recursion!

1. **Base case:** if $n = 0$, there is nothing to do!
2. *Recursively* move the first $n - 1$ disks from peg $1$ to peg $3$.
3. Move the bottom disk from peg $1$ to peg $2$.
4. *Recursively* (again) move the $n - 1$ disks from peg $3$ to peg $2$.

That means that to solve the problem for $n$ disks, you have to solve the problem for $n - 1$ disks **twice**, and add one extra step (to move that bottom disk). So if $S(n)$ is a function representing the number of steps in the solution for $n$ disks, then $S(n) = 2S(n - 1) + 1$.

Notice: if $S(0) = 0$, what is $S(1)$? $S(2)$? $S(3)$? $S(4)$? Do you see the pattern? (Think in terms of powers of 2!) **Record your answer on Moodle!**

## Exercise

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/880GnhkYQ-o" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

I implemented a "solver" for this game in the TowersOfHanoi class on [Replit](https://replit.com/team/cs2-spring-23/Lesson-19). Fill in the gaps in the `solve` method. You can use the `moveDisk` method which I implemented for you, but remember that there are *recursive* steps here. That means: you will need to call `solve` from within itself (**recursively**)!

If you make a mistake, and move a "large" disk onto a smaller one, the code will crash with an exception. So be careful!

# Homework

On Moodle, you will need to answer the question asked earlier in the lesson: come up with a formula (in terms of $n$) for the number of steps it takes to solve the Towers of Hanoi problem for $n$ disks. Notice that:

* $S(0) = 0$
* $S(1) = 1$
* $S(2) = 2 \times 1 + 1 = 3$
* $S(3) = 2 \times 3 + 1 = 7$
* Do you see a pattern?