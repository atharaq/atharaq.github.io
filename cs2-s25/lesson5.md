# CS2 Lesson 5: Methods and Strings
{:.no_toc}

1. Table of Contents
{:toc}

# Warm-up

As a warm-up for this lesson, try out the following exercise. Try this on your own, and then watch the video where I go through this exercise.

Write a program which asks the user to input the size of a list. Then ask the user to input an integer for each element of the list and store all of that in an array. Then output the minimum element of the list.

Input and output should look like the following:

> How large a list do you want?  
>   4  
> Enter in element 0:  
>   15  
> Enter in element 1:  
>   -2  
> Enter in element 2:  
>   2  
> Enter in element 3:  
>   1  
> The minimum element in this list is -2.

Try this out and then watch the video where I go through my solution:

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/JHNCW0VmAqc" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

## Find Minimum, Generalized

Now add to your program another prompt for the user to input the size of a list, and then create a new list where you fill in with random integers:

```java
Scanner sc = new Scanner(System.in);
System.out.println("How large of a list do you want?");
int size = sc.nextInt();
int[] randomList = new int[size];
Random r = new Random();
for (int i = 0; i < randomList.length; i++) {
  randomList[i] = r.nextInt();
  // Maybe you need to print out this element now to check its value?
}
```

Then output the minimum element of that list. Of course, you must notice that we are doing the same thing twice. The code would look almost identical; is there a way to just write the code that solves this general problem (of finding the smallest element of a list) **once**, and then re-using that?

In this next video I go through this solution and talk about this a little bit:

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/wVOU4zDHzag" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

# Methods (Chapter 4)

So now it's a good time to read about **methods**, which is what I described at the very end of the last video. This is introduced in [Chapter 4](https://books.trinket.io/thinkjava2/chapter4.html) of the textbook. You may have skimmed it earlier, but now is a good time to go back and read through that properly. As always, make sure to do all the exercises you can.

After reading the chapter, come back and go through the rest of my videos:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/xNQ846M0Dqk" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

## Static keyword

What does the "static" keyword mean when we declare a method? The idea is that this differentiates between methods that are invoked using the name of the class, and methods that are invoked using a particular variable. That is:

```java
Scanner sc = new Scanner(System.in);
int x = sc.nextInt(); // nextInt is not static
double root2 = Math.sqrt(2); // sqrt is static
```

I talk a bit about this difference in this video:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/gjmfN-FwzHE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

## Flow Of Execution

The textbook talks a bit about "flow of execution" in this chapter. In addition to the textbook's notes on this, I try to walk through a particular example of how we read code line by line, when the code uses methods, loops, and conditionals.

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/HIlFUsPFuBQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

## Exercise

Write a method which takes in an array of integers as a parameter, and outputs each integer as a comma separated list on a single line. Test your method out by invoking it with a couple of different arrays as arguments.

```java
int[] x = new int[2];
x[0] = 1;
x[1] = 5;
printList(x);
int[] y = new int[3];
y[0] = 13;
y[1] = 10;
y[2] = 15;
printList(y);
```

This should print out:

1, 5  
13, 10, 15  

It's very easy to mess up and put an extra comma, or forget a newline in between. Try this out, see if you can get it to work perfectly, and then watch me go through it if you get stuck:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/2O6F78nH3wE" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

## Return types and parameters

The textbook goes through a bit about parameters, arguments, and return types. When you define a method, you have to provide its return type and any parameters it requires. The parameters are kind of like "inputs" to the method, while the return type is the "output" type of the method. For example, our "minElement" method required an array of integers, and returned an integer (the minimum of that array).

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/Xi4YcjXRJco" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

## Exercise

<div class="youtube-container">
  <iframe src="https://www.youtube.com/embed/Rf-puP2TFws" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

Write a method which takes in an integer array as a parameter, and returns the second smallest element of that array. Test this out by invoking the method with a few different arrays as in:

```java
int[] x = new int[5];
x[0] = 1;
x[1] = 5;
x[2] = 1;
x[3] = 0;
x[4] = -1;
System.out.println(secondSmallest(x));
int[] y = new int[3];
y[0] = 13;
y[1] = 10;
y[2] = 15;
System.out.println(secondSmallest(y));
```

This should output 0 and 10. Hint: it's not hard to figure out how to do this by going through the list twice. But this is somewhat inefficient: you should be able to do this by going through the list a single time. Can you figure that out?

## Parameter Semantics

Take a look at some of these code snippets. For each one:

1. Look at the code. Write down a guess of what you think happens.
2. Run the code (copy/paste into IntelliJ or VSCode). What actually happens?
3. Try to explain to yourself why that is happening.

Part 1:

```java
public static void changeNumber(int x) {
    x++;
}
public static void main(String[] args) {
    int x = 0;
    changeNumber(x);
    System.out.println(x);
}
```

Part 2:

```java
public static void changeNumber(int[] x) {
    x[0]++;
}
public static void main(String[] args) {
    int[] x = new int[1];
    x[0] = 0;
    changeNumber(x);
    System.out.println(x[0]);
}
```

Part 3:

```java
public static void changeNumber(int[] x) {
    x = new int[1];
    x[0] = 1;
}
public static void main(String[] args) {
    int[] x = new int[1];
    x[0] = 0;
    changeNumber(x);
    System.out.println(x[0]);
}
```

We will go over these on Monday, so if you are unsure about why some of these things are happening, be ready to ask questions in class on Monday.

# Strings (Chapter 6)

By this point, you should have already have read [Chapter 6](https://books.trinket.io/thinkjava2/chapter6.html) on loops and strings. I wanted to point out a couple of short points about Strings in Java. Please use that chapter as a reference while you go through these videos / notes, as I want to point out a couple of subtleties about Strings in Java:

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/15B-U3l0gY4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

## References

Similar to arrays, Strings are **references**. This means that when we declare a String, as in:

```java
String s = "hello there";
```

Java does not create a space in memory for "s" and fill that in with the characters in "hello there". Instead, since a String can have any length possible, you want to think of this as:

* First, the JVM determines the amount of space required by this String
* Then the JVM finds some space in RAM with enough contiguous space
* The JVM fills in that space with the correct characters
* Then the JVM creates a space in memory for "s", and, for its value, gives it the *location in memory* that it found.

This has some subtle consequences, as I go through above.

## Immutability

Moreover, Strings are **immutable**. We will discuss immutability more later on, when we design our own classes, but in particular, once a String is created in memory, that String is never changed. So if you do something like:

```java
String s = "hello";
s += " world";
```

The JVM first creates the location in memory for "hello", then creates the location in memory for " world", then creates a *third* location in memory for what happens when you concatenate them ("hello world").

## API

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/tF0Wh9zByCU" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>

If you ever need to find out what methods are allowed on a particular data type, you can search for that data type and likely find the documentation from Oracle. In particular, the [Java String API](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/String.html) is located here. I discuss a little bit about how to read this, as it's a bit confusing, but there are a few methods that I think are important, and so you might want to look at those:

* length(): returns the length of the String
* substring(): "hello".substring(2) returns “llo”, "okay".substring(1, 3) returns “ka”.
* equals() and equalsIgnoreCase(): Checks if two Strings are the same (depending on whether you want case sensitivity or not).
* compareTo(): Compares Strings based on alphabetical order.
* charAt(): Determines the character at a given position in the String

Use these on this short exercise (which I go through in the video above, so please pause that video before working through the exercise):

Ask the user to input in some text (use the nextLine() method in the Scanner class). Then do the following:

1. Output the length of that text.
2. Determine if the text they entered is **exactly** the same as the String “help!”.
3. Output the last two characters of the String.

## Exercise

Take a look at [Chapter 6, Exercise 5](https://books.trinket.io/thinkjava2/chapter6.html#sec84):

A word is said to be a “doubloon” if every letter that appears in the word appears
exactly twice. Here are some example doubloons found in the dictionary:
Abba, Anna, appall, appearer, appeases, arraigning, beriberi, bilabial, boob,
Caucasus, coco, Dada, deed, Emmett, Hannah, horseshoer, intestines, Isis, mama,
Mimi, murmur, noon, Otto, papa, peep, reappear, redder, sees, Shanghaiings, Toto

Write a method isDoubloon which takes a String as a parameter and checks whether  it is a doubloon. If it is, the method should return true. If not, the method should return false.

I talk a little bit about this exercise here. (Ignore the part where I say that you will need to submit it; instead of homework for this week, I would rather you all get started on the project.)

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/ecsgo1Ke1wA" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"></iframe>
</div>
