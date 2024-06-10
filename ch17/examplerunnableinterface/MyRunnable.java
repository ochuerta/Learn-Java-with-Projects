package ch17.examplerunnableinterface;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread ID: " + Thread.currentThread().threadId());
    }
}

