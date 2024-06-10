package ch17.dataraceandlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Count {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("Thread ID: " + Thread.currentThread().threadId() + " - Count: " + count);
    }

    public int getCount() {
        return count;
    }
}

// with trylock

class Count2 {
    static int counter = 0;
    static Lock lock = new ReentrantLock();

    static void incrementCounter() {
        if (lock.tryLock()) {
            try {
                int current = counter;
                System.out.println("Before: " + counter + ", Current thread: " + Thread.currentThread().threadId());
                counter = current + 1;
                System.out.println("After: " + counter);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Thread didn't get the lock and is looking for a new task.");
        }
    }
}

