/*
 * Author Name: Solomon
 * File-Name: Server.java
 * Copy Right: No Copy Right
 * Creation Date: 3/6/2024
 * Last Modification Date: 5/6/2024
 * Version: 1.3 -- Add in Documentary Comment
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static ServerSocket serverSocket;
    public static Scanner reader;
    public static PrintWriter writer;
    public static Socket clientSocket1;
    public static void startServer() throws IOException {
        serverSocket = new ServerSocket(ChatClient1.ownPort); // Create server socket
        System.out.println("Server is running...");

        // Accept client 1 connection
        clientSocket1 = serverSocket.accept();
        // Create input and output streams for client 1
        reader = new Scanner(new InputStreamReader(clientSocket1.getInputStream()));
        writer = new PrintWriter(clientSocket1.getOutputStream(), true);
        System.out.println("Client 1 connected.");
        writer.println("Connected");
    }
}
