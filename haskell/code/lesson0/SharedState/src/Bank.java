public class Bank {
  private int balance = 100;

  public void payday() {
      balance += 100;
  }

  public void withdraw() {
      balance -= 100;
  }

  public void display() {
      System.out.println("Your current balance is $" + balance);
  }
}
