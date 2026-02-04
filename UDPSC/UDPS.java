import java.net.*;
import java.io.*;

public class UDPS {
    public static void main(String args[]) throws Exception{
        DatagramSocket servsock=new DatagramSocket(9876);
        System.out.println("Server is ready...");
        byte[] recvdata=new byte[1024];
        while(true){
            DatagramPacket recvpkt=new DatagramPacket(recvdata,recvdata.length);
            servsock.receive(recvpkt);
            String msg=new String(recvpkt.getData()).trim();
            System.out.println("receive from client: "+msg);
            String reply=msg.toUpperCase();
            byte[] senddata=reply.getBytes();
            DatagramPacket sendpkt=new DatagramPacket(senddata,senddata.length,recvpkt.getAddress(),recvpkt.getPort());
            servsock.send(sendpkt);
        }
    }
}
