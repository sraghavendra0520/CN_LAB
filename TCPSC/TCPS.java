import java.net.*;
import java.io.*;

public class TCPS {
    public static void main(String args[]) throws Exception{
        ServerSocket sersock=new ServerSocket(3300);
        System.out.println("Server is Ready....");
        Socket sock=sersock.accept();
        System.out.println("Client connected.");
        BufferedReader in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter out=new PrintWriter(sock.getOutputStream(),true);
        String filename=in.readLine();
        BufferedReader file=new BufferedReader(new FileReader(filename));
        String line;
        while((line=file.readLine())!=null){
            out.println(line);
        }
        sersock.close();
        sock.close();
        file.close();
    }
}
