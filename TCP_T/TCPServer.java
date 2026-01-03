// package TCP_T;
import java.net.*;
import java.io.*;
public class TCPServer {
    public static void main(String args[]) throws Exception{
        ServerSocket servsock=new ServerSocket(3300);
        System.out.println("Ready for connection...");
        Socket sock=servsock.accept();
        System.out.println("Connection successfull");
        InputStream istream=sock.getInputStream();
        BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
        String fname=fileRead.readLine();
        BufferedReader contentRead=new BufferedReader(new FileReader(fname));
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        String str;
        while((str=contentRead.readLine())!=null){
            pwrite.println(str);
        }
        sock.close();
        servsock.close();
        pwrite.close();
        contentRead.close();
    }
}
