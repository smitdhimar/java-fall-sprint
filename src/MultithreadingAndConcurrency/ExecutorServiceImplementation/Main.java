package MultithreadingAndConcurrency.ExecutorServiceImplementation;

import MultithreadingAndConcurrency.Utils.Factorial;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        try {

//            implement executor and autocloseable
            ExecutorService executor = Executors.newCachedThreadPool();

            long startTime = System.currentTimeMillis();

            for (int i = 1; i < 10; i++) {
                int taskNumber = i;

                executor.submit(() -> {
                    int fact = Factorial.factorial(taskNumber)
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

            System.out.println("Time taken to complete is : "+ (endTime-startTime));

        } catch (Exception e) {
            System.out.print("FAILURE: Error in ExecutorServiceImplementation " + e);
            e.printStackTrace();
        }

    }


}
