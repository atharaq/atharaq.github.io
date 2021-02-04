# CS2 Lesson 1: Variables / Operators, Input / Output
{:.no_toc}

1. Table of Contents
{:toc}

# Overview Videos
{:.no_toc}

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/g3Jx1kIo-H0" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/wCugzvxeDK4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>


For the rest of this week, you will *review* chapter 1 from the textbook, work through chapter 2, and *preview* chapter 3. For the most part, early in the semester we will stick closely to the textbook. There are exercises on CodingRooms to work through as we go through the book, I am describing them here.

Next Monday, we will look at these exercises as well as some supplementary material about variables, data types, and input / output.

# Chapter 1

Please read [ThinkJava Chapter 1](https://books.trinket.io/thinkjava2/chapter1.html). This section shows the basic structure of a Java program. I encourage you to work through **all** of the exercises in this chapter. You can use your CodingRooms account to try some of these out if you haven't downloaded IntelliJ yet!

## CodingRooms Exercise

At this point, you should be able to run a simple program. I'd like to you submit a program on CodingRooms just to make sure you can. The program should output your name.

In addition, make sure you are doing all of the exercises at the end of chapter 1. In particular, **Exercise 3** is a good way to see what symbols / words / etc are important and what is not, at least to the Java compiler. Spend some time on that: you can play around with it during the coding exercise on CodingRooms, but please make sure you submit **working** code that just outputs your name after you are done with all of that.

# Chapter 2: Variables and Operators

Please read [Chapter 2: Variables and Operators](https://books.trinket.io/thinkjava2/chapter2.html). Some highlights:

* Make sure you know what a memory diagram is. Often times, I will ask you what some code does. The best way to do this is to make a memory diagram, keeping track of what the values of each variable is after you have executed each line of code.
* Pay attention to the different *arithmetic operators*, in particular that "/" defaults to "integer division", unless at least one of the *operands* is a floating-point type (**double**). Constant numbers are stored in memory as **int**s if they don't have a decimal point, and **double**s if they do. That is: "3" in Java is an int, but "3.0" is a double.
* Be ware of floating point errors! Numbers in computers are stored in binary, not decimal, and a decimal number like 0.8 might have an infinite, repeating binary expansion. This leads to strange errors like one I mention below.

## Exercise

What does the following code do? Make a memory diagram.

```java
int a, b;
a = 1234;
b = 99;
int t = a;
a = b;
b = t;
```

<details>
  <summary>Explanation:</summary>
  <p>This code <strong>swaps</strong> the values of the variables a and b.</p>
  <p>The first line declares the two variables. The next two lines are used to initialize the values of a and b to 1234 and 99, respectively.</p>
  <p>The last three lines swap a and b. This is done by creating a third variable named t, setting it to a. That means t is 1234. Then the value of a is changed to 99. Then the value of b is changed to 1234.</p>
</details>

---

What does the following output?

```java
double x = 0.7;
double y = 0.9;
double a = x + 0.1;
double b = y - 0.1;
System.out.println(a);
System.out.println(b);
```

<details>
<summary>Check your answer</summary>
<p>I suggest you try this out on your own machine / on CodingRooms.</p>
<p>When I try this out on CodingRooms, I get the following:
<pre>
0.7999999999999999
0.8
</pre>
</p>
<p>This is because the decimal number 0.1 takes infinitely many bits to represent it in binary. So in the computer, we just get a "really good estimate" of the number.</p>
</details>

## CodingRooms Exercise

Work on exercises 2 and 3 from [Chapter 2](https://books.trinket.io/thinkjava2/chapter2.html#sec32). Please submit exercise 2 in the appropriate CodingRooms assignment space. Try to finish this before our next class on Monday!

Exercise 3 does not need to be submitted, but please work on that as well. You can do this in IntelliJ on your computer or in a CodingRooms workspace.

## Exercise (discuss next time)

This exercise starts off similarly to exercise 3:

1. Write a program that creates variables named hour and minute. Assign them values that roughly correspond to the current time. Use a 24-hour clock so that 2:00 PM should be "14:00".
2. Output the current time in one line,  including a message. For example:
<pre>
The current time is 15:10.
</pre>
3. Modify the program so that it also displays the time 55 minutes from now. (Hint: you may need to use the **remainder** operator %.)  For example:
<pre>
The current time is 15:10.
In 55 minutes, it will be 16:05.
</pre>

# Preview: Chapter 3: Input / Output

We've see how to "output" numbers and strings to the console. This is done using the System.out.println method. It's worth spending some time figuring out what "System", "out", and "println" even mean, and I think the book does a decent job explaining these things. In short:

* System is the name of a **class**. All of Java code is organized into classes, and this tells your program which class to look for.
* out is the name of a **variable** inside the System class. So "System.out" tells Java to go to the System class and look at the out variable.
* println is the name of a **method** that the out variable can access. Depending on the data type of the variable, there are different methods that may be available to different variables.

Moreover, once we know how to output information to the screen, we may wish to ask the user to **input** data to the program. That way, we can respond to the user's choices intelligently. Take a look at [Chapter 3](https://books.trinket.io/thinkjava2/chapter3.html) to see how to use the **Scanner** class to get input from the user. There are some strange issues that come up with the Scanner class, and we will be sure to look at this on Monday!
