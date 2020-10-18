# Discrete Mathematics Lesson 11: Modular Arithmetic
{:.no_toc}

1. Table of Contents
{:toc}

# Calendars

If you are reading these notes as soon as they are posted on Moodle, then today is Monday, October 19. October has 31 days. What day of the week will November 19 be? This might seem a bit tricky, but of course you know there is a cycle to the days of the week: every 7 days, we'll get to another Monday. So the next few Mondays will be:

* October 26
* November 2 (26 + 7 = 33, and since October has 31 days, we will be in day 2 of November)
* November 9
* November 16

Then we can count, one by one, to figure out that November 19th will be a Thursday. Is there a way we can exploit properties of numbers to figure this out without needing to keep counting by 7s?

Knowing that October has 31 days, November has 30, and December has 31, what day of the week will January 1 be?

* October 31 is in 12 days (31 - 19), so November 1 is in 13 days. Since 14 days takes us to a Monday, 13 must take us to 1 day before a Monday: a Sunday.
* November 8, 15, 22, and 29 will all be Sundays then.
* November 30 is a Monday, and then December 1 is a Tuesday.
* December 8, 15, 22, and 29 are all Tuesdays then.
* December 30 is a Wednesday, December 31 is a Thursday, and so January 1 is a Friday.

Again, it seems like there should be a faster way to figure this out. Any ideas? Think about it for a bit before you check the spoilers below.

<details>
<summary>Spoilers</summary>

<p>There are 13 + 30 + 31 = 74 days until January 1. We know that we just need to keep counting by 7s and see how many days are left over. That is: if we count by 7s, we get that in 70 days, it's a Monday again. Then we'd need to count 4 more!</p>

<p>In other words: we know that $74 \div 7 = 10$, remainder $4$. 4 days after a Monday is a Friday.</p>
</details>

## Clocks

We are doing a certain kind of arithmetic when we think about adding days on a calendar. This is really a *cyclical* addition: you add enough numbers and things cycle back around. If we're talking about days of the week, things cycle around every 7 days. That means that adding 7 days, to a day of the week, does not change that day of the week. 7 days from a Monday is still a Monday, 7 days from a Wednesday is still a Wednesday, etc.

A very similar phenomenon happens when we add hours on a clock. If we look at the clock at 8:00, and then look again 12 hours later, the hour hand will be in the exact same spot. That is, the hour hand on the clock cycles around every 12 hours. (Ignore AM/PM, as we are just looking at the position of the hands on a clock.) Let's do some quick examples.

* Start at 6:00. What time is it in 8 hours?
* Going back to our starting point of 6:00, what time is it in 20 hours?
* Starting at 2:00, what time *was* it 8 hours ago? (In the past)

Playing around with these you should figure out how to use the fact that the clocks cycle around every 12 hours:

* 6 + 8 = 14. But the hours cycle around after 12, and so this would be 2:00.
  * You can think of this as: 6 + 8 is 6 + 6 + 2, and 6 + 6 gets us to 12:00. Then 2 more hours gets us to 2:00.
* 6 + 20 = 26. Again: hours cycle around after 12: so 2, 14, and 26 all mean the same thing on the clock: 2:00.
  * You could think of this as 6 + 8 + 12, and knowing that 6 + 8 ends up at 2:00, and adding 12 hours does nothing, would give you the same answer.
* 2 - 8 = -6. What does -6 mean on the clock? 6 hours *before* 12, which is just 6:00.

Notice that adding and subtracting are still inverse operations: adding 8 hours to 6:00 gets you to 2:00, and subtracting 8 hours from 2:00 gets you back to 6:00!

## Exercises

1. Starting at 3:00, what time will it be in 150 hours? Hint: $12 \times 12 = 144$.
2. There are exactly 365 days from now until October 19, 2021. What day of the week will October 19, 2021 be? (Hint: $7 \times 52 = 364$.)

<details>
<summary>Check your answers</summary>
<ol>
<li>Since the clock will be at 3:00 every 12 hours, then in 144 hours it will be 3:00. So 6 more hours later it will be <strong>9:00</strong>.</li>
<li>October 19, 2020 is a Monday. Adding 364 days stays on a Monday, since that's a multiple of 7. So adding 365 will make that a <strong>Tuesday</strong>.</li>
</ol>
</details>

# Divides and mod

# Division and Remainder

# Modular Addition and Subtraction

# Multiplication

# Reciprocals

# Exponentiation
