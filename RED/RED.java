import java.util.*;

public class RED {

    public static class RandomEarlyDetection {
        private double minThreshold;
        private double maxThreshold;
        private double maxDropProb;
        private int queueSize;
        private int currentQueue;

        public RandomEarlyDetection(double min, double max, double prob, int size) {
            minThreshold = min;
            maxThreshold = max;
            maxDropProb = prob;
            queueSize = size;
            currentQueue = 0;
        }

        public boolean enqueue() {

            // If queue is full, drop packet
            if (currentQueue >= queueSize) {
                System.out.println("Packet Dropped (Queue Full)");
                return false;
            }

            double dropProb = calcDropProb();

            // RED probabilistic drop
            if (dropProb > 0 && shouldDrop(dropProb)) {
                System.out.println("Packet Dropped (RED)");
                return false;
            }

            currentQueue++;
            System.out.println("Packet Enqueued. Current Queue Size: " + currentQueue);
            return true;
        }

        // Calculate drop probability based on RED
        private double calcDropProb() {
            if (currentQueue < minThreshold)
                return 0.0;
            else if (currentQueue >= maxThreshold)
                return 1.0;
            else
                return maxDropProb *
                        ((currentQueue - minThreshold) / (maxThreshold - minThreshold));
        }

        // Correct probabilistic drop condition
        private boolean shouldDrop(double prob) {
            Random random = new Random();
            return random.nextDouble() < prob;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the minimum threshold: ");
        double min = sc.nextDouble();

        System.out.print("Enter the maximum threshold: ");
        double max = sc.nextDouble();

        System.out.print("Enter the maximum drop probability (0-1): ");
        double prob = sc.nextDouble();

        System.out.print("Enter the queue size: ");
        int size = sc.nextInt();

        System.out.print("Enter the number of packets: ");
        int n = sc.nextInt();

        RandomEarlyDetection red = new RandomEarlyDetection(min, max, prob, size);

        for (int i = 0; i < n; i++) {
            red.enqueue();
        }

        sc.close();
    }
}
