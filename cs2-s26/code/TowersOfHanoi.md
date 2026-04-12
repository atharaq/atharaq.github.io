# Lesson 18 Code

TowersOfHanoi.java:

```java
import java.util.ArrayList;
import java.util.HashMap;

public class TowersOfHanoi {
  private ArrayList<Integer> peg1;
  private ArrayList<Integer> peg2;
  private ArrayList<Integer> peg3;

  private HashMap<Integer, ArrayList<Integer>> pegMap;

  // Initialize Towers of Hanoi with n disks
  // DO NOT TOUCH THIS
  public TowersOfHanoi(int n) {
    peg1 = new ArrayList<>();
    peg2 = new ArrayList<>();
    peg3 = new ArrayList<>();

    for (int i = n; i > 0; i--) {
      peg1.add(i);
    }

    pegMap = new HashMap<>();
    pegMap.put(1, peg1);
    pegMap.put(2, peg2);
    pegMap.put(3, peg3);
  }

  public void printPegs() {
    System.out.println("Peg 1: " + peg1);
    System.out.println("Peg 2: " + peg2);
    System.out.println("Peg 3: " + peg3);
  }

  // moves a disk from the "from" peg to the "to" peg
  // DO NOT TOUCH THIS!
  private void moveDisk(int from, int to) {
    ArrayList<Integer> fromPeg = pegMap.get(from);
    int diskToMove = fromPeg.get(fromPeg.size() - 1);
    fromPeg.remove(fromPeg.size() - 1);

    ArrayList<Integer> toPeg = pegMap.get(to);
    if (toPeg.size() > 0) {
      int topDisk = toPeg.get(toPeg.size() - 1);
      if (diskToMove > topDisk) {
        throw new IllegalStateException("Cannot put a larger disk (" + diskToMove + ") on a smaller one ("
            + topDisk + ")");
      }
    }
    toPeg.add(diskToMove);

    System.out.println("Moved disk " + diskToMove + " from peg " + from + " to peg " + to);
  }

  // solver for TowersOfHanoi puzzle
  // IMPLEMENT THIS!
  // I did the base case for you, you do the rest.
  public void solve(int numDisks, int from, int to, int spare) {
    if (numDisks == 0) {
      // base case: what do you do?
      // just return: there's nothing to do (it's already solved for 0 disks!)
      return;
    }

    // recursive step 1: move n - 1 disks from the "from" peg to the "spare" peg:

    // then move the last disk from the "from" peg to the "to" peg
    // use moveDisk method

    // print the pegs after you move the disk to see what it looks like now
    // call printPegs()

    // now move the n - 1 disks from the "spare" peg to the "to" peg

  }

  public static void main(String[] args) {
    int numDisks = 5;
    TowersOfHanoi tower = new TowersOfHanoi(numDisks);
    tower.printPegs();
    tower.solve(numDisks, 1, 2, 3);
  }
}
```