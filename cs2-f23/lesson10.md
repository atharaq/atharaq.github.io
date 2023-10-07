# CS2 Lesson 10: Designing Classes
{:.no_toc}

1. Table of Contents
{:toc}

**Note on the lesson**: in some of today's videos, I start creating a "Time" class that I want you to follow along. Please do follow along: that means, create an IntelliJ project, and, while you're watching the videos, work on the code in IntelliJ alongside watching the video. Pause the video when I ask you to, work on the code for a bit, and then come back to watch me work on that same code.

# Creating a class

<div class="youtube-container">
    <iframe src="https://www.youtube.com/embed/uLqbNaFNWys" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

Some basic vocabulary terms we should know for now:

* **class**: a template for a new data type. Examples: ArrayList, Scanner
* **object**: a particular *instance* of a class.
* **constructor**: a method that is invoked when the **new** keyword is used. This method is used for setting up anything we need to create an object of that type.
* **instance method**: a method which is invoked on an object. Example: `list.add(5);`
* **static method**: a method invoked using the name of a class. Example: `Math.sqrt(25);`

Follow along the above video where I walk you through the process of creating a class in IntelliJ, declaring variables and constructors, and using the class in another main method.

This is the process we should always keep in mind when we design classes: first you think about the instance variables that the class should have, make a constructor (or multiple constructors) for that class, and implement the `toString()` method so that you can output objects of that type.

## Error checking

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/4Qyvqq7JA44" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

In this video above, I walk through the process of error checking in our class. We want to define the parameters of how to use the class properly. For example, the following should not make sense:

```java
Time time = new Time(13, 75, "Go away!");
System.out.println(time);
```

Even though we provided the Time constructor with two integers and a String, this should just not be allowed, since it does not correspond to an actual time. So we add in some error checking in our Time constructor:

```java
public Time(int h, int m, String amOrPm) {
    if (h < 1 || h > 12) {
        throw new IllegalArgumentException("Illegal hour: " + h + ". Hour must be between 1 and 12.");
    }
}
```

This is a common paradigm in Java: when we define a class, we should define the way in which it should be allowed to be used. If the class requires an integer between 1 and 12 for the hour, we should throw an exception if any code tries to use it with other parameters. We will discuss exceptions in more depth later on in the semester.

## Magic Numbers

The textbook talks about [magic numbers](https://books.trinket.io/thinkjava2/chapter3.html#sec37) earlier in the book. I hope you had read this already, but the book raises some good points about how we should use variables with meaningful names to drive logic in our code, rather than just numbers like "1" or "12" in the above code. When we revisit code later on, we might forget what we meant by those numbers, while if we have good variable names, we will be reminded of why we put those in.

To do this, we declare **constant class variables**. These are **static** variables that are marked **final**:

```java
public class Time {

    public static final int MIN_HOUR = 1;
    public static final int MAX_HOUR = 12;

    // ...

    public Time(int h, int m, String amOrPm) {
       if (h < MIN_HOUR || h > MAX_HOUR) {
            throw new IllegalArgumentException("Illegal hour: " + h + ". Hour must be between 1 and 12.");
        }
    }
}
```

This was, we know that the 1 and 12 represent "minimum" and "maximum" hours that are allowed to be used in this class.

## Public vs private

If you paid close attention, you will have seen that I declared the hour, minute, and amPm variables using the keyword **private**, while I declare the `MIN_HOUR` variable using the keyword **public**. Why? What do public and private mean?

Public and private are **visibility modifiers**. These are what tell you what classes have access to these items (variables, methods, classes, constructors, etc). There are four levels of visibility modifiers:

* **public**: every class can access this
* **protected**: we will not discuss this one in this class
* default visibility (if we leave out "public", "private", or "protected"): we will not be discussing this one either
* **private**: this item can be used only in code inside the same class

As a rule of thumb, we should often make everything as private as possible. We want to restrict how others use our class; that way, we can control how they will use it and predict and plan for possible bad behavior. I go through an example in the video above of what could go wrong if we just make everything public.

## Instance Methods

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/fLfyPfY8Ogs" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

If, as we said before, we made all our instance variables private, how would other classes use the data stored in our class? How would other classes see the current hour for a particular Time object?

The answer: create an **instance method** that allows other classes to access this value.

```java
public int getHour() {
    return hour;
}
```

Then other classes can "see" the value of the hour, but they still can't change it. If we want to allow them to change it, we can create a `setHour` method, similarly, and put in our "error-checking" code in there as well, possibly throwing an exception if we are provided an illegal hour.

# Exercise

Create a class that represents a `Student` object. A `Student` is described by a name, a student ID (integer), and a grade.

Define the class, declare its instance variables, and create a toString method for it. The toString method should return a String in the form: Name (ID): grade.

For example, a student named "Alice" with student ID 1 and a grade of 95 would be outputted at `Alice (1): 95`.

Important: we will be using this class in our second project, so please work on this now. **Submit this on replit** and make sure to run the tests for it.

# Object Oriented Design

<div class="youtube-container">
<iframe src="https://www.youtube.com/embed/vAm6FQYi_jY" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>

We now revisit one of the paradigms I mentioned earlier in the semester: modular design.

1. Break large problems up into smaller components.
2. Solve each component on its own, test it out on its own.
3. Integrate the components together.

Now, though, our components should be the "objects" in our program. To use an analogy from grammar, we should think about the "nouns" of the problem we're solving. What are the "things" in the problem, and what are those "things" doing? Those "nouns" should be represented by objects, which then need a class to define them. The instance variables are the data that is needed to represent that data type, and the instance methods would be the way that objects of that data type can behave and/or interact with other objects.

Next time we will revisit the `Gaussian Integer` program from the first exam. In that problem, you were asked to write a program which asked the user for input for two Gaussian Integers, output them each, multiply them, and then output the product. Think about how you might design a Gaussian Integer class to help solve this problem:

* What would be the instance variables for a Gaussian Integer?
* How would you implement a toString method for this class?
* What would be the instance methods for a Gaussian Integer?

# Reading and exercises

This is a good time to catch yourself up on old readings. We should have read chapter 1 - 7 already, so please catch up on those if you feel lost on anything. Do all the exercises.

For the material on classes, specifically, take a look at chapters 9 - 11. Again, do as many exercises as you can. In particular, [Exercises 2 and 3](https://books.trinket.io/thinkjava2/chapter11.html#sec144) from Chapter 11 are really good practice for creating basic classes.
