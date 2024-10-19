package AlgoSolving;

/**
 * The {@code SuperMarketQueue} class simulates a supermarket checkout system and computes the total time
 * required to serve all customers given multiple checkout counters and a list of customer queue times.
 * The solution uses a priority queue to always assign the next customer to the checkout counter
 * with the least processing time, thereby efficiently distributing the load.
 */
public class SuperMarketQueue {

    /**
     * Main method to test the {@code solveSuperMarketQueue} function with different customer queues and counter numbers.
     *
     * @param args The input arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{5, 2, 3, 3, 4, 4}, 2));
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 5, 3, 3, 4, 4}, 3));
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 2, 5, 3, 4, 5}, 3));
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 2, 3, 3, 5, 4}, 30));
    }

    /**
     * Solves the supermarket queue problem by calculating the total time taken to serve all customers
     * given the number of checkout counters available and the time each customer spends at the checkout.
     * This method uses a priority queue (min-heap) to track the checkout counters' time,
     * always serving the next customer at the counter with the smallest total processing time.
     *
     * @param customers An array representing the time each customer spends at the checkout.
     * @param n         The number of checkout counters available.
     * @return The total time taken to serve all customers.
     */
    public static int solveSuperMarketQueue(int[] customers, int n) {
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>();

        // Initialize all counters with zero processing time
        for (int i = 0; i < n; i++) {
            queue.add(0); // set all counter's time to 0
        }

        // Process each customer's time
        for (int time : customers) {
            int minimumTime = queue.poll(); // get the counter with the least time
            queue.add(minimumTime + time);  // add the current customer's time to the counter
        }

        // Find the maximum time from all counters
        int max = 0;
        while (!queue.isEmpty()) {
            max = Math.max(max, queue.poll());
        }

        return max;
    }

}
