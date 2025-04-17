# CS2 Lesson 19: Searching
{:.no_toc}

1. Table of Contents
{:toc}

# Guessing Game

For this lesson, you will be working on this Guessing Game / Finder activity. You'll be going through the following steps for today:

0. Copy/paste [the starter code](code/lesson19.html) for GuessingGame.java. 
1. Run main. This is a guessing game where you guess a number between 0 and 1022 (inclusive). You should be able to guess the number **within at most 10 guesses**. Find a good strategy for this!
2. Determine the algorithm used for (1). Then see if you can use that same idea to find an algorithm to find a number in a **sorted list**.
3. Determine the running time of this "find" method. **Use Big Oh notation**.
4. Use the algorithm devised in (2) to implement a faster "find" algorithm in the Finder class (included in this same starter code page). You do not need to submit this.

The lesson is mostly self directed, and so I am not including notes here, but we will be discussing these in class. For reference, when you wish to review the lesson, you can take a look at the following videos. They were from a previous version of the course when I used different software instead of VSCode (IntelliJ and/or CodingRooms). Please use the videos for help if you get stuck on any of these parts.

## Strategy

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/TbLVgtfrXMY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## Binary Search

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/HxT2UPc5Bt4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

## Running Time

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/frPIY5BgSUc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

For this, you will need to have gone through the sections on [Analysis of Algorithms](lesson16.html#analysis-of-algorithms) and [Big Oh](lesson16.html#big-oh-notation). Please review those notes.

## Finder / Code

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/r8cMvABL9G4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

# Exercise

1. If we have an **unsorted** list of 1 million integers, about how many comparisons would need need to determine if a number $x$ is in the list? 10, 20, 100, 1000, or 1,000,000? What algorithm would we use?
2. If we have a **sorted** list of 1 million integers, about how many comparisons would need need to determine if a number $x$ is in the list? 10, 20, 100, 1000, or 1,000,000? What algorithm would we use?

# Upcoming

* We will have a quiz, either online or in class next week.
* Work on Project 3: first get the HumanPlayer and SimplePlayer working, and see if you can design the Game class.
  * You might decide to have a class for the Board as well.
* Project 3 demos: sign-up will be on BrightSpace this weekend.
