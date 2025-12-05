package MultithreadingAndConcurrency.Utils;

public class Factorial {
    public static int factorial(int n) {
        try {

            Thread.sleep(100);
            if (n == 1) {
                return 1;
            }
            return n * factorial(n - 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
