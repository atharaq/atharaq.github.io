# CS2 Lesson 20: Searching
{:.no_toc}

1. Table of Contents
{:toc}

# Lesson 19 Questions?

# Project 3 Hints

* Implement the smaller pieces first: Player interface, HumanPlayer, RandomPlayer
* Maybe a class for a "Bid" (number of coins and whether we're bidding on heads / tails)?
* Make sure they all work on their own.
* Then try to put things together.
  * Ask each player to flip their coins.
  * Player 1 bids.
  * Keep track of which player's turn it is (now it's player 2's turn).
  * As long as no one has challenged yet (boolean variable?):
    * Ask the player if they want to raise or challenge.
    * If they raise, get a new bid from them (give them the previous bid).
      * Change to the other player's turn.
    * If they challenge, end the loop.
  * After someone has challenged:
    * Reveal each player's coins.
    * Count how many of the relevant side there are.
    * If more than the bidder said, the bidder wins.
    * Otherwise, the challenger wins.

# Guessing Game

For this lesson, you will be working on this Guessing Game / Finder activity. You'll be going through the following steps for today:

0. Open [Lesson 20 on Replit](https://replit.com/team/cs2-spring-23/Lesson-20). 
1. Run Main. This is a guessing game where you guess a number between 0 and 1022 (inclusive). You should be able to guess the number **within at most 10 guesses**. Find a good strategy for this!
2. Determine the algorithm used for (1). Then see if you can use that same idea to find an algorithm to find a number in a **sorted list**.
3. Determine the running time of this "find" method.
4. Use the algorithm devised in (2) to implement a faster "find" algorithm in the Finder class (included in this same project). You do not need to submit this. Uncomment the relevant line in the main metho to test this out.

The lesson is mostly self directed, and so I am not including notes here. The following videos may help; they were from a previous version of the course when I used different sofftware instead of Replit (IntelliJ and/or CodingRooms). Please use the videos for help if you get stuck on any of these parts.

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

Please work on this, but you do not need to submit it. (I mentioned CodingRooms a couple of times here, but you can **safely ignore that** as I don't want to overload you at this point.)

# Moodle Response

On Moodle, record your response to the following questions:

1. If we have an **unsorted** list of 1 million integers, about how many comparisons would need need to determine if a number $x$ is in the list? 10, 20, 100, 1000, or 1,000,000?
2. If we have a **sorted** list of 1 million integers, about how many comparisons would need need to determine if a number $x$ is in the list? 10, 20, 100, 1000, or 1,000,000?
