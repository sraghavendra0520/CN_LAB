import java.net.*;
import java.io.*;

class TCPClient {
    public static void main(String args[]) throws Exception {
        Socket socket = new Socket("127.0.0.1", 3300);
        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        System.out.print("Enter file name: ");
        String fileName = keyboard.readLine();
        out.println(fileName);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        socket.close();
    }
}
