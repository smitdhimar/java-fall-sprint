package MultithreadingAndConcurrency.FutureImplementation;

import MultithreadingAndConcurrency.Utils.Factorial;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        try {

//            implement executor and autocloseable
            ExecutorService executor = Executors.newFixedThreadPool(2);

            long startTime = System.currentTimeMillis();
            ArrayList<Future<Integer>> futures = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                int taskNumber = i;

                Future<Integer> f = executor.submit(() -> {
                    int fact = Factorial.factorial(taskNumber);
                    System.out.println("factorial of " + taskNumber + " is " + fact);
                    return fact;
                });

                futures.add(f);
            }

            for (Future<Integer> f : futures) {
                try {
                    Integer result = f.get();
                    System.out.println("The result is : " + result);

                } catch (Exception e) {
                    System.out.println("FAILURE: error in futures " + e);
                    e.printStackTrace();
                }
            }
            executor.shutdown();
//            boolean isComplete = executor.awaitTermination(100, TimeUnit.MILLISECONDS);
//
//            while(!isComplete){
//                isComplete = executor.awaitTermination(100, TimeUnit.MILLISECONDS);
//            }
            long endTime = System.currentTimeMillis();

            System.out.println("Time taken to complete is : " + (endTime - startTime));

        } catch (Exception e) {
            System.out.print("FAILURE: Error in ExecutorServiceImplementation " + e);
            e.printStackTrace();
        }

    }


}
