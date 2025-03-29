# Coin Game

Create a new java project (VSCode or IntelliJ), create a new Java class in the src folder called `CoinGame.java`:

CoinGame.java:

```java
import java.util.Random;
import java.util.Scanner;

public class CoinGame {

    // simple coin flip guessing game.
    // two players. flip a coin 9 times.
    // each player guesses the number of heads
    // player who is closest wins

    // 0. allow the user the input the number of coin flips.
    // 1. add a choice for human to go first or computer
    // 2. add a second strategy for a computer player, and
    //    an option to use that strategy.
    // 3. add an option for human vs human or computer vs computer

    public static void main(String[] args) {
        Random coin = new Random();
        int numHeads = 0;

        // flip it 9 times
        for (int i = 0; i < 9; i++) {
            // nextBoolean returns true or false with equal probability
            // we say the coin is HEADS if nextBoolean is true
            if (coin.nextBoolean()) {
                numHeads++;
            }

        }

        int guessOne;

        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1: enter in your guess");
        guessOne = sc.nextInt();
        sc.nextLine(); // advance to the next line

        Random playerTwo = new Random();

        // player two: a computer which guesses a random number from 0 to 9.
        int guessTwo = playerTwo.nextInt(10);

        System.out.println("Player 2's guess: " + guessTwo);

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