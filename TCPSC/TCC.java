import java.io.*;
import java.net.*;

public class TCC {
    public static void main(String args[]) throws Exception{
        Socket sock=new Socket("127.0.0.1",3300);
        BufferedReader keyread=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(sock.getOutputStream(),true);
        BufferedReader in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
        System.out.print("Enter the filename: ");
        String filename=keyread.readLine();
        out.println(filename);
        String line;
        while((line=in.readLine())!=null){
            System.out.println(line);
        }
        sock.close();
    }
}
