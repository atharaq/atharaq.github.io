# CS2 Lesson 14: Exceptions
{:.no_toc}

1. Table of Contents
{:toc}

# Exceptions

<div class="youtube-container">
video-1
</div>

An **exception** is short for "an exceptional event": anything which disrupts the normal flow of the program's instructions. When such an event occurs in a method, the following steps are taken:

1. The method creates an `Exception` object (perhaps a subclass of `Exception`) and `throws` it to the JVM. This object usually includes some information including the kind of exception thrown, and where exactly it happened in the program.
2. The JVM looks for something which handles it (a `try-catch` block). It traces back through the method invocations that occurred up until that point looking for a handler.
3. If the JVM never finds a method that handles that particular exception, the JVM will crash.

## The Stack Trace

Test out this code and look at its error message:

```java
public static void main(String[] args) {
	ArrayList<Integer> list = null;
	printSorted(list);
}

private static void printSorted(List<Integer> list) {
	Collections.sort(list);
	for (int num : list) {
		System.out.println(num);
	}
}
```

You get some useful information in this error message: exactly the lines of code where the Exception was thrown, and then all the methods that had to be invoked in order for that line of code to end up being executed.

# Handling Exceptions: try-catch

<div class="youtube-container">
video 2
</div>

As mentioned earlier: the JVM will search for an exception handler in the form of a `try-catch` block. So what exactly does that look like?

```java
try {
	someMethod();
} catch (SpecificException e) {
	doSomethingWithTheException(e);
}
```

You can catch multiple exceptions:

```java
try {
	someMethod();
	anotherMethod();
} catch (SpecificException | AnotherException e) {
	doSomethingWithTheException(e);
}
```

Or, if you want to do different things with different exception types:

```java
try {
	... 	
} catch (FirstException e) {
	handleFirstException(e);
} catch (SecondException e) {
	handleSecondException(e);
}
```

Be careful here: the JVM looks for the **first** catch clause that matches the Exception thrown. For example:

```java
try {
	...
} catch (Exception e) {
	...
} catch (SpecificException e) {
	System.out.println("You will never see this!");
}
```

Since the more specific exception would have been caught by the "general" exception class.

## Exercise

Every Exception class has a `printStackTrace` method. Surround the following code with a `try-catch` block and, in the catch clause, call the `printStackTrace` method. Run the code and put in some text (not an integer) so that an exception is thrown.

```java
Scanner sc = new Scanner(System.in);
int input = sc.nextInt();
```

# finally clause

<div class="youtube-container">
video 3
</div>

Often times, there is some code you wish to always run, regardless of whether an exception was thrown. Usually, this involves closing resources of some kind. For example, the following code (from "CopyFile.java" on Moodle) is part of a program which makes a copy of a file. The code opens a file to read from it, creates a second file to write to, and copies things from the first one to the second.

```java
try {
	stream = CopyFile.class.getResourceAsStream(FILENAME);
	out = new FileOutputStream(OUTPUT_FILE);
	...
} catch (IOException e) {
	e.printStackTrace();
} finally {
	if (stream != null) {
		try {
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  if (out != null) {
    try {
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```

In this case, we attempt to close both the stream and out variables. If we don't close these variables, the operating system / filesystem will still see that those files are being used (if you've ever seen an error message saying something like "Cannot open file; file is in use in another process", then you've encountered what happens if a file is opened but never closed).

## try-with-resources

The code above is actually terrible! While trying to make sure we close an InputStream, it might throw an Exception too, so we needed to handle that. That is: we can't just close the stream variable, and then close the out variable. If we do that, the first one might throw another exception, and we won't ever see the `out.close()` statement.

Thankfully, there is a better way: try-with-resources:

```java
try (InputStream stream = CopyFile.class.getResourceAsStream(FILENAME);
	 FileOutputStream out = new FileOutputStream(OUTPUT_FILE)) {
	...	 
} catch (IOException e) {
	e.printStackTrace();
} // no finally clause needed here
```

It might appear like there is some magic here. But under the hood, this is using *polymorphism*, which we will study next week. The data type (class) of any "resource" which we declare in the parentheses next to "try" statement must implement the `AutoCloseable` interface (an interface which just has a `close` method which may throw an Exception). We will learn more about interfaces next week, but basically this just means that the InputStream and FileOutputStream classes both have `close()` methods, and the Java compiler knows that. After this `try-catch` block runs, the two close methods will be invoked, making sure to close each of these "resources" properly.

You can still use `finally` if needed for other purposes.

## Exercise (Don't submit)

Download the CopyFile class and the java.jpeg file off of Moodle. Create a new project in IntelliJ, and put the CopyFile class in there, and the java.jpeg file in the src folder as well. Modify the CopyFile class to use the try-with-resources paradigm. When you run the program, you should see a new file in the src folder: output.jpeg, which should look exactly the same as the original java.jpeg file.

Note: running the file multiple times will just overwrite that output.jpeg file, so you might not see anything happen more than once. In that case, to make sure it's still working, delete the old "output.jpeg" file, and then run it again.

# Throwing (and re-throwing) Exceptions

<div class="youtube-container">
video 4?
</div>

As an alternative to a try-catch block: you can simply declare that your method throws the appropriate exception.

```java
public static void main(String[] args) throws IOException {
...
}
```

Often, you don't want to do this for your main method. But for other methods: it may be the right option! You can also throw (or re-throw) exceptions that you have caught on your own:


```java
} catch (IOException e) {
	// try to handle e
	...
	// if we can't...
	throw e;
}
```

We have seen something like this before. Remember the [error checking we did in the Time class](https://atharaq.github.io/cs2/lesson10.html#error-checking):

```java
public Time(int h, int m, String amOrPm) {
  if (h < 1 || h > 12) {}
    throw new IllegalArgumentException("Illegal hour: " + h + ". Hour must be between 1 and 12.");
  }
}
```

You can `throw` any object whose type is "Exception".

# Properly using Exceptions

video 5?

Some Exceptions, like the InputMismatchException thrown by the Scanner class, don't need to be surrounded by a try-catch block. These are called **unchecked** exceptions. Others, like the `IOException` in the `CopyFile` example, need to be caught or handled. These are **checked** exceptions.

In general, we should respect the following paradigms:

1. Checked exceptions are for conditions that you expect clients to try to recover from. For example: FileNotFoundException!
2. Unchecked exceptions are for "logic errors": `ArrayIndexOutOfBoundsException`, `NullPointerException`, etc. These really shouldn't happen.
3. **Rule of thumb**: Use Exceptions for exceptional situations: not as fancy if-thens! That means, don't use try-catch to check for NumberFormatException. Don't use try-catch to check for NullPointerExceptions. Instead, check hasNextInt, or check if the object is null.

# Some Common Exceptions

Your code, outside of a `catch` block, might need to throw its own Exceptions. You could create your own Exception types (create a new class which `extends` Exception -- more on "extending" classes later), but there are often built-in Exception classes that you can use for most situations:

* IllegalArgumentException: for instance, if you expect only positive integer values, but a negative value is passed in
* IllegalStateException: perhaps the object needs to be initialized or is in the middle of updating and is not in an appropriate state
* NullPointerException: this is often thrown automatically
* IndexOutOfBoundsException
* UnsupportedOperationException: for instance, if you implement an interface but you don't expect certain methods to be invoked on that implementation.
