# Coin Game Solution

This program requires four souce files:

1. CoinGame.java
2. Player.java
3. HumanPlayer.java
4. RandomPlayer.java

Those should all be located in the same src folder:


## CoinGame.java

```java
import java.util.Random;
import java.util.Scanner;

public class CoinGame {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Player one = choosePlayer(sc, "one");
    Player two = choosePlayer(sc, "two");
    play(one, two);
  }

  private static Player choosePlayer(Scanner sc, String player) {
    System.out.println("Choose player " + player);
    System.out.println("1: Human");
    System.out.println("2: Random");
    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        return new HumanPlayer(sc);
      case 2:
        return new RandomPlayer();
      default:
        return new RandomPlayer();
    }
  }

  private static void play(Player one, Player two) {
    System.out.println("Player 1: how many times will we flip the coin?");
    int numFlips = one.declareNumFlips();
    System.out.println("Player 1 says we will flip " + numFlips + " times!");
    int numHeads = flip(numFlips);

    System.out.println("Player 1: enter in your guess");
    int guessOne = one.guessFirst(numFlips);
    System.out.println("Player 1's guess: " + guessOne);
    System.out.println("Player 2: enter in your guess");
    int guessTwo = two.guessSecond(numFlips, guessOne);
    System.out.println("Player 2's guess: " + guessTwo);

    declareWinner(numHeads, guessOne, guessTwo);
  }

  private static int flip(int numFlips) {
    Random coin = new Random();
    int numHeads = 0;

    for (int i = 0; i < numFlips; i++) {
      if (coin.nextBoolean()) {
        numHeads++;
      }
    }

    return numHeads;
  }

  private static void declareWinner(int numHeads, int guessOne, int guessTwo) {
    System.out.println("Actual number of heads: " + numHeads);

    int playerOneDiff = Math.abs(guessOne - numHeads);
    int playerTwoDiff = Math.abs(guessTwo - numHeads);

    if (playerOneDiff < playerTwoDiff) {
      System.out.println("Player 1 wins!");
    } else if (playerTwoDiff < playerOneDiff) {
      System.out.println("Player 2 wins!");
    } else {
      System.out.println("Tie game!");
    }

  }
}
```

## Player.java

```java
public interface Player {
  int declareNumFlips();
  int guessFirst(int numFlips);
  int guessSecond(int numFlips, int otherGuess);
}
```

## HumanPlayer.java

```java
import java.util.Scanner;

public class HumanPlayer implements Player {

  private Scanner sc;

  public HumanPlayer(Scanner s) {
    sc = s;
  }
  
  @Override
  public int declareNumFlips() {
    return sc.nextInt();
  }

  @Override
  public int guessFirst(int numFlips) {
    return sc.nextInt();
  }

  @Override
  public int guessSecond(int numFlips, int otherGuess) {
    return sc.nextInt();
  }
  
}
```

## RandomPlayer.java

```java
import java.util.Random;

public class RandomPlayer implements Player {

  private Random r = new Random();

  @Override
  public int declareNumFlips() {
    return r.nextInt(100) + 1;
  }

  @Override
  public int guessFirst(int numFlips) {
    return r.nextInt(numFlips + 1);
  }

  @Override
  public int guessSecond(int numFlips, int otherGuess) {
    return r.nextInt(numFlips + 1);
  }
  
}
```