package MultithreadingAndConcurrency.BasicThreadImplementation.MyThread;

public class MyThread extends Thread{

    public MyThread(Runnable task, String name)
    {
        super(task, name);
    }

//    public void run(){
//        System.out.println("Running: "+ Thread.currentThread().getName());
//    }
}