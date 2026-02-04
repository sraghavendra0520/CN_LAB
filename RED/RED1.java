import java.util.*;
public class RED1 {
    public static class RED{
        private double mint;
        private double maxt;
        private double maxDropProb;
        private int queueSize;
        private int currqueue;
        public RED(double min,double max,double prob,int size){
            mint=min;
            maxt=max;
            maxDropProb=prob;
            queueSize=size;
            currqueue=0;
        }
        public boolean enq(){
            if(currqueue>=queueSize){
                System.out.println("pkt droped [QUEUE FULL]");
                return false;
            }
            double dropProb=calDropProb();
            if (dropProb>0 && shouldDrop(dropProb)){
                System.out.println("pkt dropped [RED]");
                return false;
            }
            currqueue++;
            System.out.println("enqued the current size is: "+currqueue);
            return true;
        }
        public double calDropProb(){
            if(currqueue<mint)
                return 0.0;
            else if (currqueue>=maxt)
                return 1.0;
            else{
                return maxDropProb*((currqueue-mint)/(maxt-mint));
            }
        }
        public boolean shouldDrop(double prob){
            Random random=new Random();
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
        RED red = new RED(min, max, prob, size);
        for (int i = 0; i < n; i++) {
            red.enq();
        }
        sc.close();
    }
    
}
