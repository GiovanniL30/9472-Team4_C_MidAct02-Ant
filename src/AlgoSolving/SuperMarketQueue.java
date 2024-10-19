package AlgoSolving;

public class SuperMarketQueue {

    public static void main(String[] args) {
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{5, 2, 3, 3, 4, 4}, 2));
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 5, 3, 3, 4, 4}, 3));
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 2, 5, 3, 4, 5}, 3));
        System.out.println(SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 2, 3, 3, 5, 4}, 30));
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>();

        // initialize all counters
        for (int i = 0; i < n; i++) {
            queue.add(0); // set all counter's time to 0
        }

        // loop until all customer's time is processed
        for (int time : customers) {
            int minimumTime = queue.poll();
            queue.add(minimumTime + time);
        }

        int max = 0;
        while (!queue.isEmpty()) {
            max = Math.max(max, queue.poll());
        }

        return max;
    }

}
