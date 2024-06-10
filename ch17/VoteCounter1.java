package ch17;

import java.util.concurrent.*;

public class VoteCounter1 {
    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        try {
            Future<Integer> vote1 = getRandomVote(1);
            Future<Integer> vote2 = getRandomVote(2);
            Future<Integer> vote3 = getRandomVote(3);
            Future<Integer> vote4 = getRandomVote(4);

            // Wait for all tasks to complete
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

            int totalVotes = vote1.get() + vote2.get() + vote3.get() + vote4.get();
            System.out.println("Total votes: " + totalVotes);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (!executorService.isTerminated()) {
                executorService.shutdownNow();
            }
        }
    }

    public static Future<Integer> getRandomVote(int i) {
        return executorService.submit(() -> {
            Thread.sleep(1000); // simulate delay
            System.out.println("Vote " + i + " counted by " + Thread.currentThread().threadId());
            return 1; // each vote counts as 1
        });
    }

}