package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.atomic.AtomicInteger;

public class VoteCounter5 implements Runnable {
    private AtomicInteger count = new AtomicInteger(0);

    public void run() {
        int iterations = 1_000_000;
        for (int i = 0; i < iterations; i++) {
            voteForCandidate();
        }
        long threadId = Thread.currentThread().threadId(); // Use threadId() instead of getId()
        System.out.println("Thread " + threadId + " voted " + count + " times");
    }

    private void voteForCandidate() {
        int currentValue;
        int newValue;
        do {
            currentValue = count.get();
            newValue = currentValue + 1;
        } while (!count.compareAndSet(currentValue, newValue));
    }
}
