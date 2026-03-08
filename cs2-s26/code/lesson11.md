# Lesson 12: GaussianInteger starter code

```java
public class GaussianInteger {
  private int real;
  private int imag;

  public GaussianInteger(int a, int b) {
    real = a;
    imag = b;
  }

  public void add(GaussianInteger other) {
    real += other.real;
    imag += other.imag;
  }

  public String toString() {
    return real + " + " + imag + "i";
  }
}
```

Test this out with a `main` method:

```java
public static void main(String[] args) throws Exception {
    GaussianInteger g1 = new GaussianInteger(1, 2);
    GaussianInteger g2 = new GaussianInteger(-2, 3);

    System.out.println("g1 = " + g1);
    System.out.println("g2 = " + g2);

    g1.add(g2);

    System.out.println("g1 + g2 = " + g1);
}
```