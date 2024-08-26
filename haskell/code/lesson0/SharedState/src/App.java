import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Bank b = new Bank();

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            if (i % 2 == 0) {
                pool.execute(b::withdraw);
            } else {
                pool.execute(b::payday);
            }
        }
        pool.shutdown();
        pool.awaitTermination(1000, TimeUnit.MILLISECONDS);
        b.display();
    }
}
