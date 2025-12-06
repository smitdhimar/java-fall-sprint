package MultithreadingAndConcurrency.ExecutorServiceImplementation;

import MultithreadingAndConcurrency.Utils.Factorial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        try {

//            implement executor and autocloseable
            ExecutorService executor = Executors.newFixedThreadPool(2);
            List<Callable<Integer>> tasks = new ArrayList<>();
            long startTime = System.currentTimeMillis();
            for (int i = 1; i < 10; i++) {
                int taskNumber = i;

                Callable<Integer> task = () -> {
                    int fact = Factorial.factorial(taskNumber);
                    System.out.println("factorial of " + taskNumber + " is " + fact);
                    return fact;
                };
                tasks.add(task);
            }
            System.out.println("Unblocked");
            executor.invokeAll(tasks);
            System.out.println("blocked");
            executor.shutdown();
//            boolean isComplete = executor.awaitTermination(100, TimeUnit.MILLISECONDS);
//
//            while (!isComplete) {
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
