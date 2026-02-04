import java.net.*;
import java.io.*;

public class UDPC {
    public static  void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientsock=new DatagramSocket();
        InetAddress servIP=InetAddress.getByName("localhost");
        System.out.println("Enter the msg: ");
        String msg=br.readLine();
        byte[] senddata=msg.getBytes();
        DatagramPacket sendpkt=new DatagramPacket(senddata,senddata.length,servIP,9876);
        clientsock.send(sendpkt);
        
        byte[] recvdata=new byte[1024];
        DatagramPacket recvpkt=new DatagramPacket(recvdata,recvdata.length);
        clientsock.receive(recvpkt);
        String servmsg=new String(recvpkt.getData()).trim();
        System.out.println("from server: "+servmsg);
        clientsock.close();
    }
}
