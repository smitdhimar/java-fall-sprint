package MultithreadingAndConcurrency.CompletableFutureImplementation;

import MultithreadingAndConcurrency.Utils.Factorial;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        try {

            List<CompletableFuture<Integer>> cfs = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                int taskNumber = i;
                cfs.add(CompletableFuture.supplyAsync(() -> {
                    return Factorial.factorial(taskNumber);
                }));
            }
            CompletableFuture<Void> finalCF = CompletableFuture.allOf(cfs.toArray(new CompletableFuture[0]));
            for(CompletableFuture<Integer> cf: cfs){
                Integer n = cf.get();
                System.out.println("Factorial --> "+ n);
            }
            finalCF.get();
            finalCF.join();
//            System.out.println("Factorial of 10 is : " + cf.get());
            System.out.println("Main over");
        } catch (Exception e) {
            System.out.println("FAILURE: some error " + e);
        }
    }
}
