package MultithreadingAndConcurrency.ExecutorServiceImplementation;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);

            for(int i = 1 ; i<10; i++){
                executor.submit(()->{

                });
            }

        } catch (Exception e) {
            System.out.print("FAILURE: Error in ExecutorServiceImplementation " + e);
            e.printStackTrace();
        }

    }

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
