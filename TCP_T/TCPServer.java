import java.net.*;
import java.io.*;

class TCPServer {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(3300);
        System.out.println("Server is waiting...");
        Socket socket = server.accept();
        System.out.println("Client connected");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String fileName = in.readLine();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = file.readLine()) != null) {
            out.println(line);
        }

        file.close();
        socket.close();
        server.close();
    }
}
