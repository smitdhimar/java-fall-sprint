package MultithreadingAndConcurrency.ExecutorServiceImplementation;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        try {

//            implement executor and autocloseable
            ExecutorService executor = Executors.newFixedThreadPool(10);

            long startTime = System.currentTimeMillis();

            for (int i = 1; i < 10; i++) {
                int taskNumber = i;

                executor.submit(() -> {
                    int fact = factorial(taskNumber);
                    System.out.println("factorial of "+ taskNumber + " is "+ fact);
                    return fact;
                });
            }

            executor.shutdown();
            boolean isComplete = executor.awaitTermination(100, TimeUnit.MILLISECONDS);

            while(!isComplete){
                isComplete = executor.awaitTermination(100, TimeUnit.MILLISECONDS);
            }
            long endTime = System.currentTimeMillis();

            System.out.println("Time taken to complete is : "+ (endTime-startTime)/1000);

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
