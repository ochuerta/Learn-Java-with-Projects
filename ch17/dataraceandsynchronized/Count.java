package ch17.dataraceandsynchronized;

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


