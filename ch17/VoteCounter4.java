package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VoteCounter4 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread ID: " + Thread.currentThread().threadId());
        });

        thread.start();
    }
}
