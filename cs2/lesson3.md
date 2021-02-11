# CS2 Lesson 3: Conditionals and Loops
{:.no_toc}

1. Table of Contents
{:toc}

# Overview Videos
{:.no_toc}

# Conditionals and Logic (Chapter 5)

Please read through [Chapter 5](https://books.trinket.io/thinkjava2/chapter5.html) on conditionals and logic. I hope you have seen "if" statements before, as well as the comparison operators and the logical operators.

Consider the following two code snippets:

```java
System.out.println("Enter a number from 1 to 10: ");
x = sc.nextInt();
if (x < 1 || x > 10) {
  System.out.println("I said 1 to 10!");
}
```

```java
System.out.println("Enter a number from 1 to 10: ");
x = sc.nextInt();
if (x < 1 && x > 10) {
  System.out.println("I said 1 to 10!");
}
```

Which one of these correctly determines if the input is between 1 and 10 (inclusive)? What happens in the other case?

## String equals

I do wish to point out, here, that we do not use the double equals sign to compare Strings. Try this out:

```java
System.out.println("Type in yes or no");
Scanner sc = new Scanner(System.in);
String word = sc.nextLine();
if (word == "yes") {
  System.out.println("Cool!");
} else {
  System.out.println("Boo!");
}
```

What does this output if you type in "yes"? What if you type in "no"?

To get this to work properly, we would use the **equals** method:

```java
System.out.println("Type in yes or no");
Scanner sc = new Scanner(System.in);
String word = sc.nextLine();
if (word.equals("yes")) {
  System.out.println("Cool!");
} else {
  System.out.println("Boo!");
}
```

Try this out and see what happens when you input yes. Why does == not work for Strings? We'll see this a bit more in the next couple of chapters.

## Exercise (Submit on CodingRooms)

Write a program which asks the user to input an integer from 1 to 10 (inclusive). If they input something that is not an integer, you should output an angry message and end the program (hint: look at this [Example Program](https://books.trinket.io/thinkjava2/chapter5.html#sec68) from the text). If they input an integer that is not in that range, you should remind them that you asked for the number to be between 1 and 10. If they do input a number in that range, you should congratulate them on following directions.

# Loops (Chapter 6)

Now read through [Chapter 6](https://books.trinket.io/thinkjava2/chapter6.html) on for and while loops.

Consider the following code snippet:

```java
Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
int i = 0;
while (x / 2 > 0) {
  i++;
  x /= 2;
}
System.out.println(i);
```

What does this program output if we input 10? What if we input 20? What if we input 100? 200? 1000?

Another code snippet to look at:

```java
Scanner sc = new Scanner(System.in);
int input = sc.nextInt();
if (input >= 0 && input <= 10) {
  for (int i = 0; i < input; i++) {
    System.out.println(i * i);
  }
}
```

What does this output if our input is 1000? What if our input is 10?

## Exercise (Don't submit)

Write a program which asks the user to input a positive integer $N$. For the purposes of this, don't worry so much about checking the input, just assume the user puts in a positive integer. Then ask the user to input in $N$ more integers, and then output the sum of all of those numbers. For example, if the user first types in 3, then ask the user to type in 3 more numbers. If they then input 1, 5, and -23, then output -17.

This exercise is not on CodingRooms, but please work on this so we can discuss it together on Monday.

## Exercise (Submit on CodingRooms)

Write a program which asks the user to input a positive integer. Check that the input is valid (using **hasNextInt**) and that it is positive. If the number is positive, determine if it is a perfect square.
Do this **without** using the built-in Math libraries. Think for a bit first about how you might try to figure this one out. Describe your method on paper, in words or in pseudocode first, before you write the code.

Some problem solving tips:

1. **Examples**: Start with some simple examples. Think of different kinds of example inputs for each possible output: one where the output should be "not a number / not valid", another where the output should be "No, it's not a perfect square", and another where the output should be "Yes, it is a perfect square."
2. **Steps**: For each of those examples, think about the steps you need to take to determine that the given number is or is not a perfect square. For example, what steps do you need to do to figure out that 16 is a perfect square? What about 326? How would you figure out that 326 is a perfect square, without resorting to a calculator?
3. **Algorithm**: Turn your steps into an algorithm. Write down those steps and try to be as explicit as possible. Use common programming constructs in your algorithm: loops, variables, if/else statements, etc.
4. **Code**: Once you have an algorithm written down (on paper), start writing code. The algorithm should not be too hard to translate to code. Notice that I don't necessarily recommend going straight to code: some people can think like that, but often you are stuck staring at a blank screen if you don't have a plan ahead of time.
5. **Testing**: Try out your code using several different inputs. See if it works if the input is valid, not valid, if the input is a perfect square, not a perfect square, etc. More generally: try to test at least two inputs for each possible output that you expect.

# Preview: Arrays / References (Chapter 7)

Skim through [Chapter 7 on arrays](https://books.trinket.io/thinkjava2/chapter7.html) This section can be tricky, so please take some time to look at it first, so that we can discuss it more on Monday.

Arrays are **references** to data. What happens when you do the following:

```java
int[] x = new int[10];
System.out.println(x);
```

What about this:

```java
int[] x = new int[1];
x[0] = 10;
int[] y = new int[1];
y[0] = x[0];
if (x == y) {
  System.out.println("Equal.");
} else {
  System.out.println("What?");
}
```

See if you can figure out why these are not outputting what you might expect. This has something to do with the fact that arrays are **references** to data, and not data themselves. Read up a bit about this in the text, and we will talk more on Monday.
