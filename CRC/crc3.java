import java.util.Scanner;
public class crc3{
    static char xor(char a,char b){
        return (a==b)?'1':'0';
    }
    static String devide(String data,String key){
        char[] dividend=data.toCharArray();
        char[] divisor=key.toCharArray();
        for(int i=0;i<dividend.length - divisor.length;i++){
            if(dividend[i] == '1'){
                for(int j=0;j<divisor.length;j++){
                    dividend[i+j]=xor(dividend[i+j],divisor[j]);
                }
            }
        }
        return new String(dividend)
            .substring(dividend.length - divisor.length+1);
    }
    static String encode(String data,String key){
        String appendData=data+"0".repeat(key.length());
        String rem=devide(appendData, key);
        return data+rem;
    }
    static boolean hasError(String recv,String key){
        String rem=devide(recv, key);
        return rem.contains("1");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter key: ");
        String key=sc.next();
        System.out.print("Enter the data: ");
        String data=sc.next();
        String encoded=encode(data,key);
        System.out.print("Received data is: "+encoded);
        System.out.print("\nEnter the received data: ");
        String recv=sc.next();
        if(hasError(recv, key)){
            System.out.print("Error detected");
        }else{
            System.out.print("Error free");
        }
    }
}