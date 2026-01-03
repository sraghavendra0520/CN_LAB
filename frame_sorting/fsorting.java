package frame_sorting;
import java.util.*;
class fsorting{
    static class Frame{
        int fnum;
        String content;
        Frame(int n,String c){
            fnum=n;
            content=c;
        }
    }
    public static void sorting(int n,Frame[] F){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(F[j].fnum>F[j+1].fnum){
                    int ntemp=F[j].fnum;
                    F[j].fnum=F[j+1].fnum;
                    F[j+1].fnum=ntemp;
                    String stemp=F[j].content;
                    F[j].content=F[j+1].content;
                    F[j+1].content=stemp;
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of packets: ");
        int n=sc.nextInt();
        Frame[] F=new Frame[n];
        for(int i=0;i<n;i++){
            System.out.print("--Enter the packet "+(i+1)+" details--\n");
            System.out.print("Enter the frame number: ");
            int num=sc.nextInt();
            System.out.print("Enter the content: ");
            String cont=sc.next();
            F[i]=new Frame(num,cont);
        }
        List<Frame> list=new ArrayList<>(Arrays.asList(F));
        Collections.shuffle(list);
        F=list.toArray(new Frame[0]);
        System.out.print("\nBEFPRE:");
        for(int i=0;i<n;i++){
            System.out.print(F[i].content+" ");
        }
        sorting(n, F);
        System.out.print("\nAFTER:");
        for(int i=0;i<n;i++){
            System.out.print(F[i].content+" ");
        }
    }
}