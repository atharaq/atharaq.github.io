# CS2 Lesson 21: Searching
{:.no_toc}

1. Table of Contents
{:toc}

# Guessing Game

For this lesson, you will be working on this Guessing Game / Finder activity. You'll be going through the following steps for today:

0. Download the GuessingGameAndSearch.zip project off of Moodle. Unzip it and try to run it in IntelliJ.
1. Run "GuessingGame". This is a guessing game where you guess a number between 0 and 1022 (inclusive). You should be able to guess the number **within at most 10 guesses**. Find a good strategy for this!
2. Determine the algorithm used for (1). Then see if you can use that same idea to find an algorithm to find a number in a **sorted list**.
3. Determine the running time of this "find" method.
4. Use the algorithm devised in (2) to implement a faster "find" algorithm in the Finder class (included in this same project). You do not need to submit this.

The lesson is mostly self directed, and so I am not including notes here, but please use the videos for help if you get stuck on any of these parts.

## Setup

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/f9DrgSBSwD8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

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

## Finder / Code

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/r8cMvABL9G4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Please work on this, but you do not need to submit it.

# Moodle Response

On Moodle, record your response to the following questions:

1. If we have an **unsorted** list of 1 million integers, about how many comparisons would need need to determine if a number $x$ is in the list? 10, 20, 100, 1000, or 1,000,000?
2. If we have a **sorted** list of 1 million integers, about how many comparisons would need need to determine if a number $x$ is in the list? 10, 20, 100, 1000, or 1,000,000?
