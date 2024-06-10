package ch17.dataraceandsynchronized;

public class Main {
    public static void main(String[] args) {
        Count count = new Count();

        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                count.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + count.getCount());
    }
}


