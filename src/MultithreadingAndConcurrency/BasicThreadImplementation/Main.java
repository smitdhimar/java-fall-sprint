package MultithreadingAndConcurrency.BasicThreadImplementation;

import MultithreadingAndConcurrency.BasicThreadImplementation.MyThread.MyThread;

public class Main {
    public static void main(String[] args)
    {
        Runnable oddTask = () -> {
            for(int i=0;i<10;i++)
            {
                if(i%2==1){
                    System.out.println("Thread printing number: "+ i);
                }
            }
        };
        Runnable evenTask = () -> {
            for(int i=0;i<10;i++)
            {
                if(i%2==0){
                    System.out.println("Thread printing number: "+ i);
                }
            }
        };
        MyThread odd = new MyThread(oddTask,"odd");
        MyThread even = new MyThread(evenTask,"Even");


        odd.start();
        even.start();

        try{
            odd.join();
            even.join();
        }
        catch (Exception e){
            System.out.println("Thread waiting error: ");
            e.printStackTrace();
        }
//        MyThread even = new MyThread("even");
    }


}
