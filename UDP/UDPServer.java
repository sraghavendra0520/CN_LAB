import java.net.*;

class UDPServer {
    public static void main(String args[]) throws Exception {

        DatagramSocket serverSocket = new DatagramSocket(9876);
        System.out.println("Server is ready...");
        byte[] receiveData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String msg = new String(receivePacket.getData()).trim();
            System.out.println("Received from client: " + msg);
            String reply = msg.toUpperCase();
            byte[] sendData = reply.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                            receivePacket.getAddress(),
                            receivePacket.getPort());
            serverSocket.send(sendPacket);
        }
    }
}
