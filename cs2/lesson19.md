# CS2 Lesson 19: Recursion (Again)
{:.no_toc}

1. Table of Contents
{:toc}

# Recursive Prints

```java
public static void printBeforeRecursion(ArrayList<String> list, int i) {
    if (i == list.size()) {
        return;
    }
    System.out.println(list.get(i));
    printBeforeRecursion(list, i+1);
}

public static void printAfterRecursion(ArrayList<String> list, int i) {
    if (i == list.size()) {
        return;
    }
    printAfterRecursion(list, i+1);
    System.out.println(list.get(i));
}
```

**Exercise**: What do you think that each of these methods prints out if you call them with the list ["a", "b", "c", "d", "e"], and $i = 0$? Predict what you think each method will do. Then run the RecursivePrints code (on Moodle) and see what each one actually does, and see if your prediction was right. Can you explain what's going on?

**Record your response on Moodle.**

# Towers of Hanoi

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/nDApcFBgSgQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

**Towers of Hanoi** is a game played with 3 pegs and $n$ disks (for some integer $n > 0$). The rules are:

* The goal is to move all the disks from one peg to another.
* No bigger disk can be placed on top of a smaller disk.

<img src="https://upload.wikimedia.org/wikipedia/commons/0/07/Tower_of_Hanoi.jpeg" alt="Towers of Hanoi game (Wikimedia Commons)" width="50%" />

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

Notice: if $S(0) = 0$, what is $S(1)$? $S(2)$? $S(3)$? $S(4)$? Do you see the pattern? (Think in terms of powers of 2!)

## Exercise

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/880GnhkYQ-o" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

I implemented a "solver" for this game in the TowersOfHanoi class on Moodle / CodingRooms. If you prefer, you can play around with it in IntelliJ for a bit, but please do submit something on CodingRooms (even if it's not working correctly). Fill in the gaps in the `solve` method. You can use the `moveDisk` method which I implemented for you, but remember that there are *recursive* steps here. That means: you will need to call `solve` from within itself.

If you make a mistake, and move a "large" disk onto a smaller one, the code will crash with an exception. So be careful!

# Next time

Next week we will be discussing algorithms and pseudocode. As we've seen before, an **algorithm** is a precise list of instructions for solving a general problem. Algorithms can be described in many ways. For example, the algorithm which finds the maximum number in a list of numbers:

* English: "Set the max equal to the first number. For each of the rest of the numbers in the list, compare it to the previous max. If the number is greater than the max, update the max to that number.""
* Java/Python/C++ code that implements that algorithm.
* "Pseudocode": somewhere in-between natural language and a high level programming language.

Describing an algorithm using pseudocode allows us to ignore language-specific features (ie, the syntax and particular methods of the `ArrayList` type). We instead focus on the steps of the algorithm. This will allow us to *analyze* the algorithm in terms of the number of steps it takes to complete the problem (similar to our analysis of the Towers of Hanoi puzzle).

## Sequential Search Algorithm

**Problem**: Given a list $l$ and an object we are looking for $o$, find it in the list. Return $i$ if $l_i == o$, and return $-1$ if $o$ is not in the list.

Try to do the following:

1. On paper, describe an algorithm in English to solve this problem.
2. On paper, describe this same algorithm in pseudocode.

<details>
<summary>Pseudocode of a possible solution</summary>
<div class="language-java highlighter-rouge"><div class="highlight"><pre class="highlight"><code>
procedure find(list l, object o):
	for i = 0 to l.size()
		if l[i] == o
			return i
	return -1
</code></pre></div></div>
</details>

There is no generally accepted syntax for pseudocode. It's not a real language and doesn't have a compiler, so the point is to describe the algorithm precisely. You can use some general constructs that are available in most languages:

1. Variables and assignments
2. Comparisons and if-else statements
3. For and while loops
4. Functions / subroutines
5. Arrays and other data structures (like lists)

Don't worry so much about syntax rules like semicolons, brackets \{ and \}. These are specific to the Java language.

We will work on analysis of algorithms next week. When we **analyze** algorithms, we do so without worrying about hardware or language specific details. We worry about two things: **running time** and **storage space**. For now we will just focus on running time: the number of steps it takes for an algorithm to run on any input of a specified size. Ideally, we try to describe this using a mathematical function:

**Definition**: The running time of an algorithm is the function $t(n)$ which, for each $n$, gives the maximum number of steps required for the algorithm to run on any input of size $n$.

**Exercise**: Come up with a formula for $t(n)$ for the `find` algorithm mentioned earlier. What's the worst case scenario for finding an object? How many steps would that take if our list has $10$ elements? How many steps if the list has $100$? Can you find a general formula in terms of $n$?
