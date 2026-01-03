import java.util.*;

public class RED {

    // Inner class for RED Queue
    static class RandomEarlyDetection {

        private double minThreshold;
        private double maxThreshold;
        private double maxDropProb;
        private int queueSize;
        private int currentQueue;

        // Constructor
        public RandomEarlyDetection(double min, double max, double prob, int size) {
            minThreshold = min;
            maxThreshold = max;
            maxDropProb = prob;
            queueSize = size;
            currentQueue = 0;
        }

        // Enqueue packet using RED
        public boolean enqueue() {

            // Queue full → Tail Drop
            if (currentQueue >= queueSize) {
                System.out.println("Packet dropped (Queue Full)");
                return false;
            }

            double dropProb = calculateDropProbability();

            // RED probabilistic drop
            if (dropProb > 0 && shouldDrop(dropProb)) {
                System.out.println("Packet Dropped (RED)");
                return false;
            }

            // Accept packet
            currentQueue++;
            System.out.println("Packet enqueued. Current queue size: " + currentQueue);
            return true;
        }

        // Calculate RED drop probability
        private double calculateDropProbability() {

            if (currentQueue < minThreshold) {
                return 0.0;
            }
            else if (currentQueue >= maxThreshold) {
                return 1.0;
            }
            else {
                return maxDropProb *
                       ((currentQueue - minThreshold) /
                       (maxThreshold - minThreshold));
            }
        }

        // Random drop decision
        private boolean shouldDrop(double prob) {
            Random random = new Random();
            return random.nextDouble() < prob; // ✔ Correct condition
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the minimum threshold: ");
        double min = sc.nextDouble();

        System.out.print("Enter the maximum threshold: ");
        double max = sc.nextDouble();

        System.out.print("Enter the maximum drop probability(0-1): ");
        double prob = sc.nextDouble();

        System.out.print("Enter the queue size: ");
        int size = sc.nextInt();

        System.out.print("Enter the number of packets: ");
        int n = sc.nextInt();

        RandomEarlyDetection red =
                new RandomEarlyDetection(min, max, prob, size);

        for (int i = 0; i < n; i++) {
            red.enqueue();
        }

        sc.close();
    }
}
